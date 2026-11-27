package org.apache.xmlbeans.impl.common;

import java.io.InputStream;
import org.apache.xmlbeans.ResourceLoader;

/* loaded from: classes.dex */
public class DefaultClassLoaderResourceLoader implements ResourceLoader {
    @Override // org.apache.xmlbeans.ResourceLoader
    public void close() {
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public InputStream getResourceAsStream(String str) {
        InputStream resourceAsStream;
        try {
            resourceAsStream = getResourceAsStream(Thread.currentThread().getContextClassLoader(), str);
        } catch (SecurityException unused) {
            resourceAsStream = null;
        }
        if (resourceAsStream == null) {
            resourceAsStream = getResourceAsStream(DefaultClassLoaderResourceLoader.class.getClassLoader(), str);
        }
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        return DefaultClassLoaderResourceLoader.class.getResourceAsStream("/" + str);
    }

    private InputStream getResourceAsStream(ClassLoader classLoader, String str) {
        if (classLoader == null) {
            return null;
        }
        return classLoader.getResourceAsStream(str);
    }
}
