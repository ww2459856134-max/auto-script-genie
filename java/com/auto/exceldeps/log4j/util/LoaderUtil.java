package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.status.StatusLogger;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.function.BooleanSupplier;

@InternalApi
/* loaded from: classes.dex */
public final class LoaderUtil {
    public static final String IGNORE_TCCL_PROPERTY = "log4j.ignoreTCL";
    private static Boolean ignoreTCCL;
    private static final Logger LOGGER = StatusLogger.getLogger();
    static final RuntimePermission GET_CLASS_LOADER = new RuntimePermission("getClassLoader");
    static final LazyBoolean GET_CLASS_LOADER_DISABLED = new LazyBoolean(new BooleanSupplier() { // from class: com.auto.exceldeps.log4j.util.e
        @Override // java.util.function.BooleanSupplier
        public final boolean getAsBoolean() {
            return LoaderUtil.d();
        }
    });
    private static final PrivilegedAction<ClassLoader> TCCL_GETTER = new ThreadContextClassLoaderGetter();

    private static class ThreadContextClassLoaderGetter implements PrivilegedAction<ClassLoader> {
        private ThreadContextClassLoaderGetter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.security.PrivilegedAction
        public ClassLoader run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader;
            }
            ClassLoader thisClassLoader = LoaderUtil.getThisClassLoader();
            return (thisClassLoader != null || LoaderUtil.GET_CLASS_LOADER_DISABLED.getAsBoolean()) ? thisClassLoader : ClassLoader.getSystemClassLoader();
        }
    }

    static class UrlResource {
        private final ClassLoader classLoader;
        private final URL url;

        UrlResource(ClassLoader classLoader, URL url) {
            this.classLoader = classLoader;
            this.url = url;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UrlResource)) {
                return false;
            }
            UrlResource urlResource = (UrlResource) obj;
            return Objects.equals(this.classLoader, urlResource.classLoader) && Objects.equals(this.url, urlResource.url);
        }

        public ClassLoader getClassLoader() {
            return this.classLoader;
        }

        public URL getUrl() {
            return this.url;
        }

        public int hashCode() {
            return Objects.hashCode(this.classLoader) + Objects.hashCode(this.url);
        }
    }

    private LoaderUtil() {
    }

    static /* synthetic */ ClassLoader a(Class cls, Class cls2) {
        ClassLoader classLoader = cls == null ? null : cls.getClassLoader();
        ClassLoader classLoader2 = cls2 != null ? cls2.getClassLoader() : null;
        ClassLoader thisClassLoader = GET_CLASS_LOADER_DISABLED.getAsBoolean() ? getThisClassLoader() : Thread.currentThread().getContextClassLoader();
        return isChild(thisClassLoader, classLoader) ? isChild(thisClassLoader, classLoader2) ? thisClassLoader : classLoader2 : isChild(classLoader, classLoader2) ? classLoader : classLoader2;
    }

    static /* synthetic */ Object b() {
        return null;
    }

    static /* synthetic */ Void c() throws AccessControlException {
        AccessController.checkPermission(GET_CLASS_LOADER);
        return null;
    }

    static /* synthetic */ boolean d() throws AccessControlException {
        if (System.getSecurityManager() == null) {
            return false;
        }
        try {
            try {
                AccessController.checkPermission(GET_CLASS_LOADER);
                return false;
            } catch (SecurityException unused) {
                return true;
            }
        } catch (SecurityException unused2) {
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.auto.exceldeps.log4j.util.g
                @Override // java.security.PrivilegedAction
                public final Object run() {
                    return LoaderUtil.c();
                }
            });
            return false;
        }
    }

    public static Collection<URL> findResources(String str) {
        return findResources(str, true);
    }

    static Collection<UrlResource> findUrlResources(String str, boolean z) throws IOException {
        ClassLoader[] classLoaderArr = new ClassLoader[3];
        classLoaderArr[0] = z ? getThreadContextClassLoader() : null;
        classLoaderArr[1] = LoaderUtil.class.getClassLoader();
        classLoaderArr[2] = GET_CLASS_LOADER_DISABLED.getAsBoolean() ? null : ClassLoader.getSystemClassLoader();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i2 = 0; i2 < 3; i2++) {
            ClassLoader classLoader = classLoaderArr[i2];
            if (classLoader != null) {
                try {
                    Enumeration<URL> resources = classLoader.getResources(str);
                    while (resources.hasMoreElements()) {
                        linkedHashSet.add(new UrlResource(classLoader, resources.nextElement()));
                    }
                } catch (IOException e) {
                    LOGGER.error("failed to collect resources of name `{}`", str, e);
                }
            }
        }
        return linkedHashSet;
    }

    public static ClassLoader getClassLoader() {
        return getClassLoader(LoaderUtil.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ClassLoader getThisClassLoader() {
        return LoaderUtil.class.getClassLoader();
    }

    public static ClassLoader getThreadContextClassLoader() {
        try {
            return GET_CLASS_LOADER_DISABLED.getAsBoolean() ? getThisClassLoader() : (ClassLoader) runPrivileged(TCCL_GETTER);
        } catch (SecurityException unused) {
            return null;
        }
    }

    private static boolean isChild(ClassLoader classLoader, ClassLoader classLoader2) {
        if (classLoader == null || classLoader2 == null) {
            return classLoader != null;
        }
        ClassLoader parent = classLoader.getParent();
        while (parent != null && parent != classLoader2) {
            parent = parent.getParent();
        }
        return parent != null;
    }

    public static boolean isClassAvailable(String str) {
        try {
            loadClass(str);
            return true;
        } catch (ClassNotFoundException | LinkageError unused) {
            return false;
        } catch (Throwable th) {
            LOGGER.error("Unknown error while checking existence of class `{}`", str, th);
            return false;
        }
    }

    private static boolean isIgnoreTccl() {
        if (ignoreTCCL == null) {
            String stringProperty = PropertiesUtil.getProperties().getStringProperty(IGNORE_TCCL_PROPERTY, null);
            ignoreTCCL = Boolean.valueOf((stringProperty == null || "false".equalsIgnoreCase(stringProperty.trim())) ? false : true);
        }
        return ignoreTCCL.booleanValue();
    }

    public static Class<?> loadClass(String str) throws ClassNotFoundException {
        ClassLoader thisClassLoader = isIgnoreTccl() ? getThisClassLoader() : getThreadContextClassLoader();
        if (thisClassLoader == null) {
            thisClassLoader = getThisClassLoader();
        }
        return Class.forName(str, true, thisClassLoader);
    }

    public static Class<?> loadClassUnchecked(String str) {
        try {
            return loadClass(str);
        } catch (ClassNotFoundException e) {
            NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError(e.getMessage());
            noClassDefFoundError.initCause(e);
            throw noClassDefFoundError;
        }
    }

    public static <T> T newCheckedInstanceOf(String str, Class<T> cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        return (T) newInstanceOf(loadClass(str).asSubclass(cls));
    }

    public static <T> T newCheckedInstanceOfProperty(String str, Class<T> cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        return (T) newCheckedInstanceOfProperty(str, cls, new java.util.function.Supplier() { // from class: com.auto.exceldeps.log4j.util.h
            @Override // java.util.function.Supplier
            public final Object get() {
                return LoaderUtil.b();
            }
        });
    }

    public static <T> T newInstanceOf(Class<T> cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    }

    public static <T> T newInstanceOfUnchecked(Class<T> cls) {
        try {
            return (T) newInstanceOf(cls);
        } catch (IllegalAccessException e) {
            IllegalAccessError illegalAccessError = new IllegalAccessError(e.getMessage());
            illegalAccessError.initCause(e);
            throw illegalAccessError;
        } catch (InstantiationException e2) {
            InstantiationError instantiationError = new InstantiationError(e2.getMessage());
            instantiationError.initCause(e2);
            throw instantiationError;
        } catch (NoSuchMethodException e3) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError(e3.getMessage());
            noSuchMethodError.initCause(e3);
            throw noSuchMethodError;
        } catch (InvocationTargetException e4) {
            throw new InternalException(e4.getCause());
        }
    }

    private static <T> T runPrivileged(PrivilegedAction<T> privilegedAction) {
        return System.getSecurityManager() != null ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    static Collection<URL> findResources(String str, boolean z) throws IOException {
        Collection<UrlResource> collectionFindUrlResources = findUrlResources(str, z);
        LinkedHashSet linkedHashSet = new LinkedHashSet(collectionFindUrlResources.size());
        Iterator<UrlResource> it = collectionFindUrlResources.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next().getUrl());
        }
        return linkedHashSet;
    }

    public static ClassLoader getClassLoader(final Class<?> cls, final Class<?> cls2) {
        return (ClassLoader) runPrivileged(new PrivilegedAction() { // from class: com.auto.exceldeps.log4j.util.f
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return LoaderUtil.a(cls, cls2);
            }
        });
    }

    public static <T> T newCheckedInstanceOfProperty(String str, Class<T> cls, java.util.function.Supplier<T> supplier) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        String stringProperty = PropertiesUtil.getProperties().getStringProperty(str);
        return stringProperty == null ? supplier.get() : (T) newCheckedInstanceOf(stringProperty, cls);
    }

    public static <T> T newInstanceOf(String str) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        return (T) newInstanceOf((Class) Cast.cast(loadClass(str)));
    }

    public static <T> T newInstanceOfUnchecked(String str) {
        return (T) newInstanceOfUnchecked((Class) Cast.cast(loadClassUnchecked(str)));
    }

    public static <T> T newInstanceOfUnchecked(String str, Class<T> cls) {
        return (T) newInstanceOfUnchecked(loadClassUnchecked(str).asSubclass(cls));
    }
}
