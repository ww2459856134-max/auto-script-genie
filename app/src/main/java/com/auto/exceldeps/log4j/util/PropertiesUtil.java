package com.auto.exceldeps.log4j.util;

import aQute.bnd.annotation.spi.ServiceConsumer;
import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.status.StatusLogger;
import com.auto.exceldeps.log4j.util.PropertiesUtil;
import com.auto.exceldeps.log4j.util.PropertySource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.xmlbeans.impl.common.NameUtil;

@ServiceConsumer(cardinality = "multiple", resolution = "optional", value = PropertySource.class)
/* loaded from: classes.dex */
public final class PropertiesUtil {
    private static final String LOG4J_PROPERTIES_FILE_NAME = "log4j2.component.properties";
    private static final String LOG4J_SYSTEM_PROPERTIES_FILE_NAME = "log4j2.system.properties";
    private final Environment environment;
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final Lazy<PropertiesUtil> COMPONENT_PROPERTIES = Lazy.lazy(new java.util.function.Supplier() { // from class: com.auto.exceldeps.log4j.util.n
        @Override // java.util.function.Supplier
        public final Object get() {
            return PropertiesUtil.a();
        }
    });
    private static final Pattern DURATION_PATTERN = Pattern.compile("([+-]?\\d+)\\s*(\\w+)?", 2);

    /* JADX INFO: Access modifiers changed from: private */
    static final class Environment {
        private final ThreadLocal<PropertySource> CURRENT_PROPERTY_SOURCE;
        private final Set<PropertySource> sources;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean b(List list, String str, PropertySource propertySource) {
            CharSequence normalForm = list.isEmpty() ? null : propertySource.getNormalForm(list);
            return sourceContainsProperty(propertySource, str) || (normalForm != null && sourceContainsProperty(propertySource, normalForm.toString()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPropertySource(PropertySource propertySource) {
            this.sources.add(propertySource);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ String d(List list, String str, PropertySource propertySource) {
            String string;
            return (list.isEmpty() || (string = Objects.toString(propertySource.getNormalForm(list), null)) == null || !sourceContainsProperty(propertySource, string)) ? sourceGetProperty(propertySource, str) : sourceGetProperty(propertySource, string);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean containsKey(final String str) {
            final List<CharSequence> list = PropertySource.Util.tokenize(str);
            return this.sources.stream().anyMatch(new Predicate() { // from class: com.auto.exceldeps.log4j.util.m
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.a.b(list, str, (PropertySource) obj);
                }
            });
        }

        static /* synthetic */ void e(String str, String str2) {
            if (System.getProperty(str) == null) {
                System.setProperty(str, str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String get(final String str) {
            final List<CharSequence> list = PropertySource.Util.tokenize(str);
            return (String) this.sources.stream().sorted(PropertySource.Comparator.INSTANCE).map(new Function() { // from class: com.auto.exceldeps.log4j.util.l
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.d(list, str, (PropertySource) obj);
                }
            }).filter(new Predicate() { // from class: com.auto.exceldeps.log4j.util.q
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return Objects.nonNull((String) obj);
                }
            }).findFirst().orElse(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePropertySource(PropertySource propertySource) {
            this.sources.remove(propertySource);
        }

        private boolean sourceContainsProperty(PropertySource propertySource, String str) {
            PropertySource propertySource2 = this.CURRENT_PROPERTY_SOURCE.get();
            if (propertySource2 == null) {
                this.CURRENT_PROPERTY_SOURCE.set(propertySource);
                try {
                    return propertySource.containsProperty(str);
                } catch (Exception e) {
                    PropertiesUtil.LOGGER.warn("Failed to retrieve Log4j property {} from property source {}.", str, propertySource, e);
                } finally {
                    this.CURRENT_PROPERTY_SOURCE.remove();
                }
            }
            PropertiesUtil.LOGGER.warn("Recursive call to `containsProperty()` from property source {}.", propertySource2);
            return false;
        }

        private String sourceGetProperty(PropertySource propertySource, String str) {
            PropertySource propertySource2 = this.CURRENT_PROPERTY_SOURCE.get();
            if (propertySource2 == null) {
                this.CURRENT_PROPERTY_SOURCE.set(propertySource);
                try {
                    return propertySource.getProperty(str);
                } catch (Exception e) {
                    PropertiesUtil.LOGGER.warn("Failed to retrieve Log4j property {} from property source {}.", str, propertySource, e);
                } finally {
                    this.CURRENT_PROPERTY_SOURCE.remove();
                }
            }
            PropertiesUtil.LOGGER.warn("Recursive call to `getProperty()` from property source {}.", propertySource2);
            return null;
        }

        private Environment(PropertySource propertySource) {
            this.sources = ConcurrentHashMap.newKeySet();
            this.CURRENT_PROPERTY_SOURCE = new ThreadLocal<>();
            try {
                new PropertyFilePropertySource(PropertiesUtil.LOG4J_SYSTEM_PROPERTIES_FILE_NAME, false).forEach(new BiConsumer() { // from class: com.auto.exceldeps.log4j.util.k
                    @Override // com.auto.exceldeps.log4j.util.BiConsumer, java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        PropertiesUtil.Environment.e((String) obj, (String) obj2);
                    }
                });
            } catch (SecurityException e) {
                PropertiesUtil.LOGGER.warn("Unable to set Java system properties from {} file, due to security restrictions.", PropertiesUtil.LOG4J_SYSTEM_PROPERTIES_FILE_NAME, e);
            }
            this.sources.add(propertySource);
            Stream streamSafeStream = ServiceLoaderUtil.safeStream(PropertySource.class, ServiceLoader.load(PropertySource.class, PropertiesUtil.class.getClassLoader()), PropertiesUtil.LOGGER);
            final Set<PropertySource> set = this.sources;
            Objects.requireNonNull(set);
            streamSafeStream.forEach(new Consumer() { // from class: com.auto.exceldeps.log4j.util.v
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    set.add((PropertySource) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    enum TimeUnit {
        NANOS(new String[]{"ns", "nano", "nanos", "nanosecond", "nanoseconds"}, ChronoUnit.NANOS),
        MICROS(new String[]{"us", "micro", "micros", "microsecond", "microseconds"}, ChronoUnit.MICROS),
        MILLIS(new String[]{"ms", "milli", "millis", "millisecond", "milliseconds"}, ChronoUnit.MILLIS),
        SECONDS(new String[]{"s", "second", "seconds"}, ChronoUnit.SECONDS),
        MINUTES(new String[]{"m", "minute", "minutes"}, ChronoUnit.MINUTES),
        HOURS(new String[]{"h", "hour", "hours"}, ChronoUnit.HOURS),
        DAYS(new String[]{"d", "day", "days"}, ChronoUnit.DAYS);

        private final String[] descriptions;
        private final TemporalUnit timeUnit;

        TimeUnit(String[] strArr, TemporalUnit temporalUnit) {
            this.descriptions = strArr;
            this.timeUnit = temporalUnit;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Stream<String> getValidUnits() {
            return Arrays.stream(values()).flatMap(new Function() { // from class: com.auto.exceldeps.log4j.util.o
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Arrays.stream(((PropertiesUtil.TimeUnit) obj).descriptions);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static TemporalUnit parseUnit(String str) {
            if (str == null) {
                return ChronoUnit.MILLIS;
            }
            for (TimeUnit timeUnit : values()) {
                for (String str2 : timeUnit.descriptions) {
                    if (str.equals(str2)) {
                        return timeUnit.timeUnit;
                    }
                }
            }
            throw new IllegalArgumentException("Invalid duration unit '" + str + "'");
        }
    }

    public PropertiesUtil(Properties properties) {
        this(new PropertiesPropertySource(properties));
    }

    static /* synthetic */ PropertiesUtil a() {
        return new PropertiesUtil(LOG4J_PROPERTIES_FILE_NAME, false);
    }

    public static Properties extractSubset(Properties properties, String str) {
        Properties properties2 = new Properties();
        if (str != null && !str.isEmpty()) {
            if (str.charAt(str.length() - 1) != '.') {
                str = str + NameUtil.PERIOD;
            }
            ArrayList arrayList = new ArrayList();
            for (String str2 : properties.stringPropertyNames()) {
                if (str2.startsWith(str)) {
                    properties2.setProperty(str2.substring(str.length()), properties.getProperty(str2));
                    arrayList.add(str2);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                properties.remove((String) it.next());
            }
        }
        return properties2;
    }

    static ResourceBundle getCharsetsResourceBundle() {
        return ResourceBundle.getBundle("Log4j-charsets");
    }

    public static PropertiesUtil getProperties() {
        return COMPONENT_PROPERTIES.get();
    }

    public static Properties getSystemProperties() {
        try {
            return new Properties(System.getProperties());
        } catch (SecurityException e) {
            LOGGER.error("Unable to access system properties.", (Throwable) e);
            return new Properties();
        }
    }

    static Properties loadClose(InputStream inputStream, Object obj) throws IOException {
        Properties properties = new Properties();
        try {
            if (inputStream != null) {
                try {
                    try {
                        properties.load(inputStream);
                        inputStream.close();
                    } catch (IOException e) {
                        LOGGER.error("Unable to read source `{}`", obj, e);
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        LOGGER.error("Unable to close source `{}`", obj, e2);
                    }
                    throw th;
                }
            }
        } catch (IOException e3) {
            LOGGER.error("Unable to close source `{}`", obj, e3);
        }
        return properties;
    }

    static Duration parseDuration(CharSequence charSequence) {
        Matcher matcher = DURATION_PATTERN.matcher(charSequence);
        if (matcher.matches()) {
            return Duration.of(parseDurationAmount(matcher.group(1)), TimeUnit.parseUnit(matcher.group(2)));
        }
        throw new IllegalArgumentException("Invalid duration value '" + ((Object) charSequence) + "'.");
    }

    private static long parseDurationAmount(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid duration amount '" + str + "'", e);
        }
    }

    public static Map<String, Properties> partitionOnCommonPrefixes(Properties properties) {
        return partitionOnCommonPrefixes(properties, false);
    }

    public void addPropertySource(PropertySource propertySource) {
        Environment environment = this.environment;
        Objects.requireNonNull(propertySource);
        environment.addPropertySource(propertySource);
    }

    public boolean getBooleanProperty(String str) {
        return getBooleanProperty(str, false);
    }

    public Charset getCharsetProperty(String str) {
        return getCharsetProperty(str, Charset.defaultCharset());
    }

    public double getDoubleProperty(String str, double d) {
        String stringProperty = getStringProperty(str);
        if (stringProperty != null) {
            try {
                return Double.parseDouble(stringProperty);
            } catch (NumberFormatException e) {
                LOGGER.warn("Unable to read double `{}` from property `{}`. Falling back to the default: `{}`", stringProperty, str, Double.valueOf(d), e);
            }
        }
        return d;
    }

    public Duration getDurationProperty(String str, Duration duration) {
        String stringProperty = getStringProperty(str);
        try {
            return parseDuration(stringProperty);
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Unable to read duration `{}` from property `{}`.\nExpected format 'n unit', where 'n' is an integer and 'unit' is one of: {}.", stringProperty, str, TimeUnit.getValidUnits().collect(Collectors.joining(", ")), e);
            return duration;
        }
    }

    public int getIntegerProperty(String str, int i2) {
        String stringProperty = getStringProperty(str);
        if (stringProperty != null) {
            try {
                return Integer.parseInt(stringProperty.trim());
            } catch (NumberFormatException e) {
                LOGGER.warn("Unable to read int `{}` from property `{}`. Falling back to the default: `{}`", stringProperty, str, Integer.valueOf(i2), e);
            }
        }
        return i2;
    }

    public long getLongProperty(String str, long j2) {
        String stringProperty = getStringProperty(str);
        if (stringProperty != null) {
            try {
                return Long.parseLong(stringProperty);
            } catch (NumberFormatException e) {
                LOGGER.warn("Unable to read long `{}` from property `{}`. Falling back to the default: `{}`", stringProperty, str, Long.valueOf(j2), e);
            }
        }
        return j2;
    }

    public String getStringProperty(String[] strArr, String str, Supplier<String> supplier) {
        for (String str2 : strArr) {
            String stringProperty = getStringProperty(str2 + str);
            if (stringProperty != null) {
                return stringProperty;
            }
        }
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    public boolean hasProperty(String str) {
        return this.environment.containsKey(str);
    }

    public boolean isOsWindows() {
        return SystemPropertiesPropertySource.getSystemProperty("os.name", "").startsWith("Windows");
    }

    @Deprecated
    public void reload() {
    }

    public void removePropertySource(PropertySource propertySource) {
        Environment environment = this.environment;
        Objects.requireNonNull(propertySource);
        environment.removePropertySource(propertySource);
    }

    public PropertiesUtil(String str) {
        this(str, true);
    }

    public static Map<String, Properties> partitionOnCommonPrefixes(Properties properties, boolean z) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (String str : properties.stringPropertyNames()) {
            int iIndexOf = str.indexOf(46);
            if (iIndexOf >= 0) {
                String strSubstring = str.substring(0, iIndexOf);
                if (!concurrentHashMap.containsKey(strSubstring)) {
                    concurrentHashMap.put(strSubstring, new Properties());
                }
                ((Properties) concurrentHashMap.get(strSubstring)).setProperty(str.substring(iIndexOf + 1), properties.getProperty(str));
            } else if (z) {
                if (!concurrentHashMap.containsKey(str)) {
                    concurrentHashMap.put(str, new Properties());
                }
                ((Properties) concurrentHashMap.get(str)).setProperty("", properties.getProperty(str));
            }
        }
        return concurrentHashMap;
    }

    public boolean getBooleanProperty(String str, boolean z) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? z : "true".equalsIgnoreCase(stringProperty);
    }

    public Charset getCharsetProperty(String str, Charset charset) {
        String stringProperty = getStringProperty(str);
        if (stringProperty == null) {
            return charset;
        }
        if (Charset.isSupported(stringProperty)) {
            return Charset.forName(stringProperty);
        }
        ResourceBundle charsetsResourceBundle = getCharsetsResourceBundle();
        if (charsetsResourceBundle.containsKey(str)) {
            String string = charsetsResourceBundle.getString(str);
            if (Charset.isSupported(string)) {
                return Charset.forName(string);
            }
        }
        LOGGER.warn("Unable to read charset `{}` from property `{}`. Falling back to the default: `{}`", stringProperty, str, charset);
        return charset;
    }

    private PropertiesUtil(String str, boolean z) {
        this(new PropertyFilePropertySource(str, z));
    }

    PropertiesUtil(PropertySource propertySource) {
        this.environment = new Environment(propertySource);
    }

    public boolean getBooleanProperty(String str, boolean z, boolean z2) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? z : stringProperty.isEmpty() ? z2 : "true".equalsIgnoreCase(stringProperty);
    }

    public String getStringProperty(String str) {
        return this.environment.get(str);
    }

    public String getStringProperty(String str, String str2) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? str2 : stringProperty;
    }

    public Boolean getBooleanProperty(String[] strArr, String str, Supplier<Boolean> supplier) {
        for (String str2 : strArr) {
            if (hasProperty(str2 + str)) {
                return Boolean.valueOf(getBooleanProperty(str2 + str));
            }
        }
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    public Duration getDurationProperty(String[] strArr, String str, Supplier<Duration> supplier) {
        for (String str2 : strArr) {
            if (hasProperty(str2 + str)) {
                return getDurationProperty(str2 + str, null);
            }
        }
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    public Integer getIntegerProperty(String[] strArr, String str, Supplier<Integer> supplier) {
        for (String str2 : strArr) {
            if (hasProperty(str2 + str)) {
                return Integer.valueOf(getIntegerProperty(str2 + str, 0));
            }
        }
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    public Long getLongProperty(String[] strArr, String str, Supplier<Long> supplier) {
        for (String str2 : strArr) {
            if (hasProperty(str2 + str)) {
                return Long.valueOf(getLongProperty(str2 + str, 0L));
            }
        }
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }
}
