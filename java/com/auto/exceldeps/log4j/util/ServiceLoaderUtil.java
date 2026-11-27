package com.auto.exceldeps.log4j.util;

import aQute.bnd.annotation.baseline.BaselineIgnore;
import com.auto.exceldeps.log4j.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@InternalApi
@BaselineIgnore("2.24.0")
/* loaded from: classes.dex */
public final class ServiceLoaderUtil {
    private static final int MAX_BROKEN_SERVICES = 8;

    private static final class ServiceLoaderSpliterator<S> extends Spliterators.AbstractSpliterator<S> {
        private final Logger logger;
        private final Iterator<? extends S> serviceIterator;
        private final String serviceName;

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super S> consumer) throws Exception {
            int i2 = 8;
            while (true) {
                int i3 = i2 - 1;
                if (i2 <= 0) {
                    return false;
                }
                try {
                } catch (Exception e) {
                    this.logger.warn("Unexpected exception  while loading implementation for service {}", this.serviceName, e);
                    throw e;
                } catch (LinkageError e2) {
                    e = e2;
                    this.logger.warn("Unable to load implementation for service {}", this.serviceName, e);
                    i2 = i3;
                } catch (ServiceConfigurationError e3) {
                    e = e3;
                    this.logger.warn("Unable to load implementation for service {}", this.serviceName, e);
                    i2 = i3;
                }
                if (this.serviceIterator.hasNext()) {
                    consumer.accept(this.serviceIterator.next());
                    return true;
                }
                continue;
                i2 = i3;
            }
        }

        private ServiceLoaderSpliterator(Class<S> cls, Iterable<? extends S> iterable, Logger logger) {
            super(Long.MAX_VALUE, 1296);
            this.serviceName = cls.getName();
            this.serviceIterator = iterable.iterator();
            this.logger = logger;
        }
    }

    private ServiceLoaderUtil() {
    }

    public static <S> Stream<S> safeStream(Class<S> cls, ServiceLoader<? extends S> serviceLoader, Logger logger) {
        Objects.requireNonNull(serviceLoader, "serviceLoader");
        final HashSet hashSet = new HashSet();
        Stream stream = StreamSupport.stream(new ServiceLoaderSpliterator(cls, serviceLoader, logger), false);
        Class<?> callerClass = StackLocatorUtil.getCallerClass(2);
        if (OsgiServiceLocator.isAvailable() && callerClass != null) {
            stream = Stream.concat(stream, OsgiServiceLocator.loadServices(cls, callerClass, logger));
        }
        return stream.filter(new Predicate() { // from class: com.auto.exceldeps.log4j.util.r
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return hashSet.add(obj.getClass());
            }
        });
    }
}
