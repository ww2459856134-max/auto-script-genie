package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.spi.LoggerContextFactory;
import com.auto.exceldeps.log4j.spi.Provider;
import com.auto.exceldeps.log4j.status.StatusLogger;
import java.net.URL;
import java.security.Permission;
import java.util.Iterator;
import org.osgi.annotation.bundle.Header;
import org.osgi.annotation.bundle.Headers;
import org.osgi.framework.AdaptPermission;
import org.osgi.framework.AdminPermission;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.SynchronousBundleListener;
import org.osgi.framework.wiring.BundleWire;
import org.osgi.framework.wiring.BundleWiring;

@InternalApi
@Headers({@Header(name = "Bundle-Activator", value = "${@class}"), @Header(name = "Bundle-ActivationPolicy", value = "lazy")})
/* loaded from: classes.dex */
public class Activator implements BundleActivator, SynchronousBundleListener {
    private boolean lockingProviderUtil;
    private static final SecurityManager SECURITY_MANAGER = System.getSecurityManager();
    private static final Logger LOGGER = StatusLogger.getLogger();

    private static void checkPermission(Permission permission) {
        SecurityManager securityManager = SECURITY_MANAGER;
        if (securityManager != null) {
            securityManager.checkPermission(permission);
        }
    }

    private void loadProvider(Bundle bundle) {
        if (bundle.getState() == 1) {
            return;
        }
        try {
            checkPermission(new AdminPermission(bundle, "resource"));
            checkPermission(new AdaptPermission(BundleWiring.class.getName(), bundle, "adapt"));
            BundleContext bundleContext = bundle.getBundleContext();
            if (bundleContext == null) {
                LOGGER.debug("Bundle {} has no context (state={}), skipping loading provider", bundle.getSymbolicName(), toStateString(bundle.getState()));
            } else {
                loadProvider(bundleContext, (BundleWiring) bundle.adapt(BundleWiring.class));
            }
        } catch (SecurityException e) {
            LOGGER.debug("Cannot access bundle [{}] contents. Ignoring.", bundle.getSymbolicName(), e);
        } catch (Exception e2) {
            LOGGER.warn("Problem checking bundle {} for Log4j 2 provider.", bundle.getSymbolicName(), e2);
        }
    }

    private String toStateString(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? i2 != 16 ? i2 != 32 ? Integer.toString(i2) : "ACTIVE" : "STOPPING" : "STARTING" : "RESOLVED" : "INSTALLED" : "UNINSTALLED";
    }

    private void unlockIfReady() {
        if (!this.lockingProviderUtil || ProviderUtil.PROVIDERS.isEmpty()) {
            return;
        }
        ProviderUtil.STARTUP_LOCK.unlock();
        this.lockingProviderUtil = false;
    }

    public void bundleChanged(BundleEvent bundleEvent) {
        if (bundleEvent.getType() != 2) {
            return;
        }
        loadProvider(bundleEvent.getBundle());
        unlockIfReady();
    }

    public void start(BundleContext bundleContext) throws Exception {
        ProviderUtil.STARTUP_LOCK.lock();
        this.lockingProviderUtil = true;
        Iterator it = ((BundleWiring) bundleContext.getBundle().adapt(BundleWiring.class)).getRequiredWires(LoggerContextFactory.class.getName()).iterator();
        while (it.hasNext()) {
            loadProvider(bundleContext, ((BundleWire) it.next()).getProviderWiring());
        }
        bundleContext.addBundleListener(this);
        for (Bundle bundle : bundleContext.getBundles()) {
            loadProvider(bundle);
        }
        unlockIfReady();
    }

    public void stop(BundleContext bundleContext) throws Exception {
        bundleContext.removeBundleListener(this);
        unlockIfReady();
    }

    private void loadProvider(BundleContext bundleContext, BundleWiring bundleWiring) {
        try {
            Provider provider = null;
            Iterator it = bundleContext.getServiceReferences(Provider.class, "(APIVersion>=2.6.0)").iterator();
            while (it.hasNext()) {
                Provider provider2 = (Provider) bundleContext.getService((ServiceReference) it.next());
                if (provider == null || provider2.getPriority().intValue() > provider.getPriority().intValue()) {
                    provider = provider2;
                }
            }
            if (provider != null) {
                ProviderUtil.addProvider(provider);
            }
        } catch (InvalidSyntaxException e) {
            LOGGER.error("Invalid service filter: (APIVersion>=2.6.0)", e);
        }
        Iterator it2 = bundleWiring.findEntries("META-INF", "log4j-provider.properties", 0).iterator();
        while (it2.hasNext()) {
            ProviderUtil.loadProvider((URL) it2.next(), bundleWiring.getClassLoader());
        }
    }
}
