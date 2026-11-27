package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.status.StatusLogger;
import java.lang.invoke.MethodHandles;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.wiring.BundleRevision;

/* loaded from: classes.dex */
public class OsgiServiceLocator {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final boolean OSGI_AVAILABLE = checkOsgiAvailable();

    static /* synthetic */ Object a(Bundle bundle) {
        int state = bundle.getState();
        return state != 1 ? state != 2 ? state != 4 ? state != 8 ? state != 16 ? state != 32 ? "UNKNOWN" : "ACTIVE" : "STOPPING" : "STARTING" : "RESOLVED" : "INSTALLED" : "UNINSTALLED";
    }

    private static boolean checkOsgiAvailable() {
        try {
            return Class.forName("org.osgi.framework.FrameworkUtil").getMethod("getBundle", Class.class).invoke(null, OsgiServiceLocator.class) != null;
        } catch (ClassNotFoundException | LinkageError | NoSuchMethodException unused) {
            return false;
        } catch (Throwable th) {
            LOGGER.error("Unknown error checking OSGI environment.", th);
            return false;
        }
    }

    public static boolean isAvailable() {
        return OSGI_AVAILABLE;
    }

    private static boolean isFragment(Bundle bundle) {
        try {
            return (((BundleRevision) bundle.adapt(BundleRevision.class)).getTypes() & 1) != 0;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static <T> Stream<T> loadServices(Class<T> cls, MethodHandles.Lookup lookup) {
        return loadServices((Class) cls, lookup, true);
    }

    public static <T> Stream<T> loadServices(Class<T> cls, MethodHandles.Lookup lookup, boolean z) {
        Objects.requireNonNull(lookup, "lookup");
        return loadServices(cls, lookup.lookupClass(), StatusLogger.getLogger());
    }

    static <T> Stream<T> loadServices(final Class<T> cls, Class<?> cls2, Logger logger) {
        final Bundle bundle = FrameworkUtil.getBundle(cls2);
        if (bundle != null && !isFragment(bundle)) {
            final BundleContext bundleContext = bundle.getBundleContext();
            if (bundleContext == null) {
                Objects.requireNonNull(cls);
                Objects.requireNonNull(bundle);
                logger.warn("Unable to load OSGi services for service {}: bundle {} (state {}) does not have a valid BundleContext", new Supplier() { // from class: com.auto.exceldeps.log4j.util.b
                    @Override // com.auto.exceldeps.log4j.util.Supplier, java.util.function.Supplier
                    public final Object get() {
                        return cls.getName();
                    }
                }, new Supplier() { // from class: com.auto.exceldeps.log4j.util.t
                    @Override // com.auto.exceldeps.log4j.util.Supplier, java.util.function.Supplier
                    public final Object get() {
                        return bundle.getSymbolicName();
                    }
                }, new Supplier() { // from class: com.auto.exceldeps.log4j.util.j
                    @Override // com.auto.exceldeps.log4j.util.Supplier, java.util.function.Supplier
                    public final Object get() {
                        return OsgiServiceLocator.a(bundle);
                    }
                });
            } else {
                try {
                    Stream stream = bundleContext.getServiceReferences(cls, (String) null).stream();
                    Objects.requireNonNull(bundleContext);
                    return stream.map(new Function() { // from class: com.auto.exceldeps.log4j.util.i
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return bundleContext.getService((ServiceReference) obj);
                        }
                    });
                } catch (Exception e) {
                    logger.error("Unable to load OSGI services for service {}", cls, e);
                }
            }
        }
        return Stream.empty();
    }
}
