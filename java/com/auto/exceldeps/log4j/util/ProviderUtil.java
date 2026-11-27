package com.auto.exceldeps.log4j.util;

import aQute.bnd.annotation.spi.ServiceConsumer;
import com.auto.exceldeps.log4j.LogManager;
import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.simple.internal.SimpleProvider;
import com.auto.exceldeps.log4j.spi.LoggerContextFactory;
import com.auto.exceldeps.log4j.spi.Provider;
import com.auto.exceldeps.log4j.status.StatusLogger;
import com.auto.exceldeps.log4j.util.LoaderUtil;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@InternalApi
@ServiceConsumer(cardinality = "multiple", resolution = "optional", value = Provider.class)
/* loaded from: classes.dex */
public final class ProviderUtil {
    private static volatile Provider PROVIDER = null;
    static final String PROVIDER_RESOURCE = "META-INF/log4j-provider.properties";
    static final Collection<Provider> PROVIDERS = new HashSet();
    static final Lock STARTUP_LOCK = new ReentrantLock();
    private static final String[] COMPATIBLE_API_VERSIONS = {"2.6.0"};
    private static final Logger LOGGER = StatusLogger.getLogger();

    private ProviderUtil() {
    }

    static void addProvider(Provider provider) {
        if (!validVersion(provider.getVersions())) {
            LOGGER.warn("Ignoring provider for incompatible version {}:\n{}", provider.getVersions(), provider);
        } else {
            PROVIDERS.add(provider);
            LOGGER.debug("Loaded provider:\n{}", provider);
        }
    }

    public static ClassLoader findClassLoader() {
        return LoaderUtil.getThreadContextClassLoader();
    }

    public static Provider getProvider() throws InterruptedException {
        lazyInit();
        return PROVIDER;
    }

    public static Iterable<Provider> getProviders() throws InterruptedException {
        lazyInit();
        return PROVIDERS;
    }

    public static boolean hasProviders() throws InterruptedException {
        lazyInit();
        return !PROVIDERS.isEmpty();
    }

    static void lazyInit() throws InterruptedException {
        if (PROVIDER == null) {
            try {
                STARTUP_LOCK.lockInterruptibly();
                try {
                    if (PROVIDER == null) {
                        ServiceLoaderUtil.safeStream(Provider.class, ServiceLoader.load(Provider.class, ProviderUtil.class.getClassLoader()), LOGGER).filter(new Predicate() { // from class: com.auto.exceldeps.log4j.util.p
                            @Override // java.util.function.Predicate
                            public final boolean test(Object obj) {
                                return ProviderUtil.validVersion(((Provider) obj).getVersions());
                            }
                        }).forEach(new Consumer() { // from class: com.auto.exceldeps.log4j.util.a
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                ProviderUtil.addProvider((Provider) obj);
                            }
                        });
                        for (LoaderUtil.UrlResource urlResource : LoaderUtil.findUrlResources(PROVIDER_RESOURCE, false)) {
                            loadProvider(urlResource.getUrl(), urlResource.getClassLoader());
                        }
                        PROVIDER = selectProvider(PropertiesUtil.getProperties(), PROVIDERS, LOGGER);
                    }
                    STARTUP_LOCK.unlock();
                } catch (Throwable th) {
                    STARTUP_LOCK.unlock();
                    throw th;
                }
            } catch (InterruptedException e) {
                LOGGER.fatal("Interrupted before Log4j Providers could be loaded.", (Throwable) e);
                Thread.currentThread().interrupt();
            }
        }
    }

    @SuppressFBWarnings(justification = "Uses a fixed URL that ends in 'META-INF/log4j-provider.properties'.", value = {"URLCONNECTION_SSRF_FD"})
    static void loadProvider(URL url, ClassLoader classLoader) {
        try {
            addProvider(new Provider(PropertiesUtil.loadClose(url.openStream(), url), url, classLoader));
        } catch (IOException e) {
            LOGGER.error("Unable to open {}", url, e);
        }
    }

    @Deprecated
    static void loadProviders(Enumeration<URL> enumeration, ClassLoader classLoader) {
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                loadProvider(enumeration.nextElement(), classLoader);
            }
        }
    }

    static Provider selectProvider(PropertiesUtil propertiesUtil, Collection<Provider> collection, Logger logger) {
        Provider providerOrElseGet;
        String stringProperty = propertiesUtil.getStringProperty(Provider.PROVIDER_PROPERTY_NAME);
        if (stringProperty == null) {
            providerOrElseGet = null;
        } else if (SimpleProvider.class.getName().equals(stringProperty)) {
            providerOrElseGet = new SimpleProvider();
        } else {
            try {
                providerOrElseGet = (Provider) LoaderUtil.newInstanceOf(stringProperty);
            } catch (Exception e) {
                logger.error("Unable to create provider {}.\nFalling back to default selection process.", PROVIDER, e);
            }
        }
        String stringProperty2 = propertiesUtil.getStringProperty(LogManager.FACTORY_PROPERTY_NAME);
        if (stringProperty2 != null) {
            if (providerOrElseGet == null) {
                logger.warn("Usage of the {} property is deprecated. Use the {} property instead.", LogManager.FACTORY_PROPERTY_NAME, Provider.PROVIDER_PROPERTY_NAME);
                Iterator<Provider> it = collection.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Provider next = it.next();
                    if (stringProperty2.equals(next.getClassName())) {
                        providerOrElseGet = next;
                        break;
                    }
                }
            } else {
                logger.warn("Ignoring {} system property, since {} was set.", LogManager.FACTORY_PROPERTY_NAME, Provider.PROVIDER_PROPERTY_NAME);
            }
            if (providerOrElseGet == null) {
                logger.warn("No provider found using {} as logger context factory. The factory will be instantiated directly.", stringProperty2);
                try {
                    Class<?> clsLoadClass = LoaderUtil.loadClass(stringProperty2);
                    if (LoggerContextFactory.class.isAssignableFrom(clsLoadClass)) {
                        providerOrElseGet = new Provider((Integer) null, "", (Class<? extends LoggerContextFactory>) clsLoadClass.asSubclass(LoggerContextFactory.class));
                    } else {
                        logger.error("Class {} specified in the {} system property does not extend {}", stringProperty2, LogManager.FACTORY_PROPERTY_NAME, LoggerContextFactory.class.getName());
                    }
                } catch (Exception e2) {
                    logger.error("Unable to create class {} specified in the {} system property", stringProperty2, LogManager.FACTORY_PROPERTY_NAME, e2);
                }
            }
        }
        if (providerOrElseGet == null) {
            Comparator<? super Provider> comparatorComparing = Comparator.comparing(new Function() { // from class: com.auto.exceldeps.log4j.util.u
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((Provider) obj).getPriority();
                }
            });
            int size = collection.size();
            if (size == 0) {
                logger.error("Log4j API could not find a logging provider.");
            } else if (size != 1) {
                logger.warn((String) collection.stream().sorted(comparatorComparing).map(new Function() { // from class: com.auto.exceldeps.log4j.util.x
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((Provider) obj).toString();
                    }
                }).collect(Collectors.joining("\n", "Log4j API found multiple logging providers:\n", "")));
            }
            providerOrElseGet = collection.stream().max(comparatorComparing).orElseGet(new java.util.function.Supplier() { // from class: com.auto.exceldeps.log4j.util.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new SimpleProvider();
                }
            });
        }
        logger.info("Using provider:\n{}", providerOrElseGet);
        return providerOrElseGet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validVersion(String str) {
        for (String str2 : COMPATIBLE_API_VERSIONS) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }
}
