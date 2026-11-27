package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.util.internal.SerializationUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FilteredObjectInputStream extends ObjectInputStream {
    private final Collection<String> allowedExtraClasses;

    public FilteredObjectInputStream() throws IOException, SecurityException {
        this.allowedExtraClasses = Collections.emptySet();
    }

    private static boolean isAllowedByDefault(String str) {
        return isRequiredPackage(str) || SerializationUtil.REQUIRED_JAVA_CLASSES.contains(str);
    }

    private static boolean isRequiredPackage(String str) {
        Iterator<String> it = SerializationUtil.REQUIRED_JAVA_PACKAGES.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public Collection<String> getAllowedClasses() {
        return this.allowedExtraClasses;
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        String strStripArray = SerializationUtil.stripArray(objectStreamClass.getName());
        if (isAllowedByDefault(strStripArray) || this.allowedExtraClasses.contains(strStripArray)) {
            return super.resolveClass(objectStreamClass);
        }
        throw new InvalidObjectException("Class is not allowed for deserialization: " + strStripArray);
    }

    public FilteredObjectInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        this.allowedExtraClasses = Collections.emptySet();
    }

    public FilteredObjectInputStream(Collection<String> collection) throws IOException, SecurityException {
        this.allowedExtraClasses = collection;
    }

    public FilteredObjectInputStream(InputStream inputStream, Collection<String> collection) throws IOException {
        super(inputStream);
        this.allowedExtraClasses = collection;
    }
}
