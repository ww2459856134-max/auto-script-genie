package com.auto.exceldeps.log4j.util.internal;

import com.auto.exceldeps.log4j.status.StatusLogger;
import com.auto.exceldeps.log4j.util.FilteredObjectInputStream;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes.dex */
public final class SerializationUtil {
    private static final String DEFAULT_FILTER_CLASS = "com.auto.exceldeps.log4j.util.internal.DefaultObjectInputFilter";
    public static final List<String> REQUIRED_JAVA_CLASSES;
    public static final List<String> REQUIRED_JAVA_PACKAGES;
    private static final Method getObjectInputFilter;
    private static final Method newObjectInputFilter;
    private static final Method setObjectInputFilter;

    static {
        int i2 = 0;
        Method method = null;
        Method method2 = null;
        Method method3 = null;
        for (Method method4 : ObjectInputStream.class.getMethods()) {
            if (method4.getName().equals("setObjectInputFilter")) {
                method2 = method4;
            } else if (method4.getName().equals("getObjectInputFilter")) {
                method3 = method4;
            }
        }
        if (method2 != null) {
            try {
                Method[] methods = Class.forName(DEFAULT_FILTER_CLASS).getMethods();
                int length = methods.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Method method5 = methods[i2];
                    if (method5.getName().equals("newInstance") && Modifier.isStatic(method5.getModifiers())) {
                        method = method5;
                        break;
                    }
                    i2++;
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        newObjectInputFilter = method;
        setObjectInputFilter = method2;
        getObjectInputFilter = method3;
        REQUIRED_JAVA_CLASSES = Arrays.asList("java.math.BigDecimal", "java.math.BigInteger", "java.rmi.MarshalledObject", XmlErrorCodes.BOOLEAN, "byte", "char", XmlErrorCodes.DOUBLE, XmlErrorCodes.FLOAT, XmlErrorCodes.INT, XmlErrorCodes.LONG, "short");
        REQUIRED_JAVA_PACKAGES = Arrays.asList("java.lang.", "java.time.", "java.util.", "com.auto.exceldeps.log4j.");
    }

    private SerializationUtil() {
    }

    public static void assertFiltered(ObjectInputStream objectInputStream) {
        if (!(objectInputStream instanceof FilteredObjectInputStream) && setObjectInputFilter == null) {
            throw new IllegalArgumentException("readObject requires a FilteredObjectInputStream or an ObjectInputStream that accepts an ObjectInputFilter");
        }
    }

    @SuppressFBWarnings(justification = "Object deserialization uses either Java 9 native filter or our custom filter to limit the kinds of classes deserialized.", value = {"OBJECT_DESERIALIZATION"})
    public static Object readWrappedObject(ObjectInputStream objectInputStream) throws IllegalAccessException, IOException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ObjectInputStream objectInputStream2;
        assertFiltered(objectInputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) objectInputStream.readObject());
        if (objectInputStream instanceof FilteredObjectInputStream) {
            objectInputStream2 = new FilteredObjectInputStream(byteArrayInputStream, ((FilteredObjectInputStream) objectInputStream).getAllowedClasses());
        } else {
            try {
                Object objInvoke = newObjectInputFilter.invoke(null, getObjectInputFilter.invoke(objectInputStream, new Object[0]));
                objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
                setObjectInputFilter.invoke(objectInputStream2, objInvoke);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new StreamCorruptedException("Unable to set ObjectInputFilter on stream");
            }
        }
        try {
            try {
                return objectInputStream2.readObject();
            } finally {
                objectInputStream2.close();
            }
        } catch (Exception | LinkageError e) {
            StatusLogger.getLogger().warn("Ignoring {} during deserialization", e.getMessage());
            return null;
        }
    }

    public static String stripArray(Class<?> cls) {
        while (cls.isArray()) {
            cls = cls.getComponentType();
        }
        return cls.getName();
    }

    public static void writeWrappedObject(Serializable serializable, ObjectOutputStream objectOutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        try {
            objectOutputStream2.writeObject(serializable);
            objectOutputStream2.flush();
            objectOutputStream.writeObject(byteArrayOutputStream.toByteArray());
            objectOutputStream2.close();
        } catch (Throwable th) {
            try {
                objectOutputStream2.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String stripArray(String str) {
        char c = 1;
        int iLastIndexOf = str.lastIndexOf(91) + 1;
        if (iLastIndexOf == 0) {
            return str;
        }
        if (str.charAt(iLastIndexOf) == 'L') {
            return str.substring(iLastIndexOf + 1, str.length() - 1);
        }
        String strSubstring = str.substring(iLastIndexOf);
        strSubstring.hashCode();
        switch (strSubstring.hashCode()) {
            case 66:
                if (!strSubstring.equals("B")) {
                    c = 65535;
                    break;
                } else {
                    c = 0;
                    break;
                }
            case 67:
                if (!strSubstring.equals("C")) {
                }
                break;
            case 68:
                if (strSubstring.equals("D")) {
                    c = 2;
                    break;
                }
                break;
            case 70:
                if (strSubstring.equals("F")) {
                    c = 3;
                    break;
                }
                break;
            case 73:
                if (strSubstring.equals("I")) {
                    c = 4;
                    break;
                }
                break;
            case 74:
                if (strSubstring.equals("J")) {
                    c = 5;
                    break;
                }
                break;
            case 83:
                if (strSubstring.equals("S")) {
                    c = 6;
                    break;
                }
                break;
            case 90:
                if (strSubstring.equals("Z")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "byte";
            case 1:
                return "char";
            case 2:
                return XmlErrorCodes.DOUBLE;
            case 3:
                return XmlErrorCodes.FLOAT;
            case 4:
                return XmlErrorCodes.INT;
            case 5:
                return XmlErrorCodes.LONG;
            case 6:
                return "short";
            case 7:
                return XmlErrorCodes.BOOLEAN;
            default:
                throw new IllegalArgumentException("Unsupported array class signature '" + str + "'");
        }
    }
}
