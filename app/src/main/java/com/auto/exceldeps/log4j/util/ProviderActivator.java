package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.spi.Provider;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/* loaded from: classes.dex */
public abstract class ProviderActivator implements BundleActivator {
    public static final String API_VERSION = "APIVersion";
    private final Provider provider;
    private ServiceRegistration<Provider> providerRegistration = null;

    protected ProviderActivator(Provider provider) {
        this.provider = provider;
    }

    public void start(BundleContext bundleContext) throws Exception {
        Hashtable hashtable = new Hashtable();
        hashtable.put(API_VERSION, this.provider.getVersions());
        this.providerRegistration = bundleContext.registerService(Provider.class, this.provider, hashtable);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        ServiceRegistration<Provider> serviceRegistration = this.providerRegistration;
        if (serviceRegistration != null) {
            serviceRegistration.unregister();
        }
    }
}
