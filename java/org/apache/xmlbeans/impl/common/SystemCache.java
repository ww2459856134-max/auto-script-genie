package org.apache.xmlbeans.impl.common;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationTargetException;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SystemProperties;

/* loaded from: classes.dex */
public class SystemCache {
    private static SystemCache INSTANCE = initCache();
    private ThreadLocal<SoftReference> tl_saxLoaders = new ThreadLocal<>();

    public static synchronized SystemCache get() {
        return INSTANCE;
    }

    private static SystemCache initCache() {
        String property = SystemProperties.getProperty("xmlbean.systemcacheimpl");
        if (property == null) {
            return new SystemCache();
        }
        String str = "Could not instantiate class " + property + " as specified by \"xmlbean.systemcacheimpl\". ";
        try {
            return (SystemCache) Class.forName(property).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassCastException unused) {
            throw new ClassCastException(str + "Class does not derive from SystemCache.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(str + "Class was not found.", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(str + "A public empty constructor may be missing.", e2);
        } catch (InstantiationException e3) {
            e = e3;
            throw new RuntimeException(str + "An empty constructor may be missing.", e);
        } catch (NoSuchMethodException e4) {
            e = e4;
            throw new RuntimeException(str + "An empty constructor may be missing.", e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(str + "An empty constructor may be missing.", e);
        }
    }

    public static synchronized void set(SystemCache systemCache) {
        INSTANCE = systemCache;
    }

    public void addToTypeLoaderCache(SchemaTypeLoader schemaTypeLoader, ClassLoader classLoader) {
    }

    public void clearThreadLocals() {
        this.tl_saxLoaders.remove();
    }

    public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader classLoader) {
        return null;
    }

    public Object getSaxLoader() {
        SoftReference softReference = this.tl_saxLoaders.get();
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void setSaxLoader(Object obj) {
        this.tl_saxLoaders.set(new SoftReference(obj));
    }
}
