package com.auto.exceldeps.log4j.util;

import aQute.bnd.annotation.spi.ServiceProvider;
import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.status.StatusLogger;
import com.auto.exceldeps.log4j.util.PropertySource;
import java.util.Collection;
import java.util.Objects;
import java.util.Properties;

@ServiceProvider(resolution = "optional", value = PropertySource.class)
/* loaded from: classes.dex */
public class SystemPropertiesPropertySource implements PropertySource {
    private static final int DEFAULT_PRIORITY = 0;
    private static final String PREFIX = "log4j2.";
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final PropertySource INSTANCE = new SystemPropertiesPropertySource();

    public static String getSystemProperty(String str, String str2) {
        String property = INSTANCE.getProperty(str);
        return property != null ? property : str2;
    }

    private static void logException(SecurityException securityException) {
        LOGGER.error("The Java system properties are not available to Log4j due to security restrictions.", (Throwable) securityException);
    }

    public static PropertySource provider() {
        return INSTANCE;
    }

    @Override // com.auto.exceldeps.log4j.util.PropertySource
    public boolean containsProperty(String str) {
        return getProperty(str) != null;
    }

    @Override // com.auto.exceldeps.log4j.util.PropertySource
    public void forEach(BiConsumer<String, String> biConsumer) {
        Object[] array;
        try {
            Properties properties = System.getProperties();
            synchronized (properties) {
                array = properties.keySet().toArray();
            }
            for (Object obj : array) {
                String string = Objects.toString(obj, null);
                biConsumer.accept(string, properties.getProperty(string));
            }
        } catch (SecurityException e) {
            logException(e);
        }
    }

    @Override // com.auto.exceldeps.log4j.util.PropertySource
    public CharSequence getNormalForm(Iterable<? extends CharSequence> iterable) {
        return PREFIX + ((Object) PropertySource.Util.joinAsCamelCase(iterable));
    }

    @Override // com.auto.exceldeps.log4j.util.PropertySource
    public int getPriority() {
        return 0;
    }

    @Override // com.auto.exceldeps.log4j.util.PropertySource
    public String getProperty(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException e) {
            logException(e, str);
            return super.getProperty(str);
        }
    }

    @Override // com.auto.exceldeps.log4j.util.PropertySource
    public Collection<String> getPropertyNames() {
        try {
            return System.getProperties().stringPropertyNames();
        } catch (SecurityException e) {
            logException(e);
            return super.getPropertyNames();
        }
    }

    private static void logException(SecurityException securityException, String str) {
        LOGGER.error("The Java system property {} is not available to Log4j due to security restrictions.", str, securityException);
    }
}
