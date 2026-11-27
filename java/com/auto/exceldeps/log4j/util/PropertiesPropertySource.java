package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.util.PropertySource;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes.dex */
public class PropertiesPropertySource implements PropertySource {
    private static final int DEFAULT_PRIORITY = 200;
    private static final String PREFIX = "log4j2.";
    private final int priority;
    private final Properties properties;

    public PropertiesPropertySource(Properties properties) {
        this(properties, 200);
    }

    @Override // com.auto.exceldeps.log4j.util.PropertySource
    public boolean containsProperty(String str) {
        return getProperty(str) != null;
    }

    @Override // com.auto.exceldeps.log4j.util.PropertySource
    public void forEach(BiConsumer<String, String> biConsumer) {
        for (Map.Entry entry : this.properties.entrySet()) {
            biConsumer.accept((String) entry.getKey(), (String) entry.getValue());
        }
    }

    @Override // com.auto.exceldeps.log4j.util.PropertySource
    public CharSequence getNormalForm(Iterable<? extends CharSequence> iterable) {
        CharSequence charSequenceJoinAsCamelCase = PropertySource.Util.joinAsCamelCase(iterable);
        if (charSequenceJoinAsCamelCase.length() <= 0) {
            return null;
        }
        return PREFIX + ((Object) charSequenceJoinAsCamelCase);
    }

    @Override // com.auto.exceldeps.log4j.util.PropertySource
    public int getPriority() {
        return this.priority;
    }

    @Override // com.auto.exceldeps.log4j.util.PropertySource
    public String getProperty(String str) {
        return this.properties.getProperty(str);
    }

    @Override // com.auto.exceldeps.log4j.util.PropertySource
    public Collection<String> getPropertyNames() {
        return this.properties.stringPropertyNames();
    }

    public PropertiesPropertySource(Properties properties, int i2) {
        this.properties = properties;
        this.priority = i2;
    }
}
