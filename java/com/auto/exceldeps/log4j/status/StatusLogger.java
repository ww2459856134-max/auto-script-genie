package com.auto.exceldeps.log4j.status;

import com.auto.exceldeps.log4j.Level;
import com.auto.exceldeps.log4j.Marker;
import com.auto.exceldeps.log4j.message.Message;
import com.auto.exceldeps.log4j.message.MessageFactory;
import com.auto.exceldeps.log4j.message.ParameterizedNoReferenceMessageFactory;
import com.auto.exceldeps.log4j.spi.AbstractLogger;
import com.auto.exceldeps.log4j.status.StatusLogger;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public class StatusLogger extends AbstractLogger {
    private static final String DEBUG_PROPERTY_NAME = "log4j2.debug";
    static final int DEFAULT_FALLBACK_LISTENER_BUFFER_CAPACITY = 0;
    static final Level DEFAULT_FALLBACK_LISTENER_LEVEL = Level.ERROR;
    public static final String DEFAULT_STATUS_LISTENER_LEVEL = "log4j2.StatusLogger.level";
    public static final String MAX_STATUS_ENTRIES = "log4j2.status.entries";
    public static final String PROPERTIES_FILE_NAME = "log4j2.StatusLogger.properties";
    public static final String STATUS_DATE_FORMAT = "log4j2.StatusLogger.dateFormat";
    static final String STATUS_DATE_FORMAT_ZONE = "log4j2.StatusLogger.dateFormatZone";
    private static final long serialVersionUID = 2;
    private final Queue<StatusData> buffer;
    private final Config config;
    private final StatusConsoleListener fallbackListener;
    private final transient ReadWriteLock listenerLock;
    private final transient Lock listenerReadLock;
    private final transient Lock listenerWriteLock;
    private final List<StatusListener> listeners;

    private static final class InstanceHolder {
        private static volatile StatusLogger INSTANCE = new StatusLogger();

        private InstanceHolder() {
        }
    }

    static final class PropertiesUtilsDouble {
        PropertiesUtilsDouble() {
        }

        static /* synthetic */ void a(Map map, Object obj, Object obj2) {
            if (isRelevantPropertyName(obj)) {
                map.put(normalizePropertyName((String) obj), obj2);
            }
        }

        private static boolean isRelevantPropertyName(@Nullable Object obj) {
            return (obj instanceof String) && ((String) obj).matches("^(?i)log4j.*");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Map<String, Object> normalizeProperties(Properties... propertiesArr) {
            final HashMap map = new HashMap();
            for (Properties properties : propertiesArr) {
                properties.forEach(new BiConsumer() { // from class: com.auto.exceldeps.log4j.status.b
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        StatusLogger.PropertiesUtilsDouble.a(map, obj, obj2);
                    }
                });
            }
            return map;
        }

        private static String normalizePropertyName(String str) {
            return str.replaceAll("[._-]", "").replaceAll("\\P{InBasic_Latin}", ".").toLowerCase(Locale.US).replaceAll("^log4j2", "log4j");
        }

        static Map<String, Object> readAllAvailableProperties() {
            return normalizeProperties(System.getProperties(), readEnvironmentProperties(), readPropertiesFile(StatusLogger.PROPERTIES_FILE_NAME));
        }

        private static Properties readEnvironmentProperties() {
            Properties properties = new Properties();
            properties.putAll(System.getenv());
            return properties;
        }

        static Properties readPropertiesFile(String str) throws IOException {
            Properties properties = new Properties();
            URL resource = StatusLogger.class.getResource('/' + str);
            if (resource == null) {
                return properties;
            }
            try {
                InputStream inputStreamOpenStream = resource.openStream();
                try {
                    properties.load(inputStreamOpenStream);
                    if (inputStreamOpenStream != null) {
                        inputStreamOpenStream.close();
                    }
                } finally {
                }
            } catch (IOException e) {
                new RuntimeException(String.format("failed reading properties from `%s`", str), e).printStackTrace(System.err);
            }
            return properties;
        }

        @Nullable
        static String readProperty(Map<String, Object> map, String str) {
            Object obj = map.get(normalizePropertyName(str));
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    StatusLogger() {
        String simpleName = StatusLogger.class.getSimpleName();
        ParameterizedNoReferenceMessageFactory parameterizedNoReferenceMessageFactory = ParameterizedNoReferenceMessageFactory.INSTANCE;
        Config config = Config.getInstance();
        Level level = Config.getInstance().fallbackListenerLevel;
        Objects.requireNonNull(level);
        this(simpleName, parameterizedNoReferenceMessageFactory, config, new StatusConsoleListener(level));
    }

    private void buffer(StatusData statusData) {
        if (this.config.bufferCapacity == 0) {
            return;
        }
        this.buffer.add(statusData);
        while (this.buffer.size() >= this.config.bufferCapacity) {
            this.buffer.remove();
        }
    }

    private static void closeListenerSafely(StatusListener statusListener) throws IOException {
        try {
            statusListener.close();
        } catch (IOException e) {
            new RuntimeException(String.format("failed closing listener: %s", statusListener), e).printStackTrace(System.err);
        }
    }

    private StatusData createStatusData(@Nullable String str, Level level, Message message, @Nullable Throwable th) {
        return new StatusData(getStackTraceElement(str), level, message, th, null, this.config.instantFormatter, Instant.now());
    }

    public static StatusLogger getLogger() {
        return InstanceHolder.INSTANCE;
    }

    @Nullable
    private static StackTraceElement getStackTraceElement(@Nullable String str) {
        if (str == null) {
            return null;
        }
        boolean z = false;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            if (z && !str.equals(className)) {
                return stackTraceElement;
            }
            if (!str.equals(className)) {
                if ("?".equals(className)) {
                    break;
                }
            } else {
                z = true;
            }
        }
        return null;
    }

    private boolean isLevelEnabled(Level level, Level level2) {
        return this.config.debugEnabled || level.isLessSpecificThan(level2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: notifyListener, reason: merged with bridge method [inline-methods] */
    public void b(StatusListener statusListener, StatusData statusData) {
        if (isLevelEnabled(statusListener.getStatusLevel(), statusData.getLevel())) {
            statusListener.log(statusData);
        }
    }

    private void notifyListeners(final StatusData statusData) {
        this.listenerReadLock.lock();
        try {
            boolean z = !this.listeners.isEmpty();
            this.listeners.forEach(new Consumer() { // from class: com.auto.exceldeps.log4j.status.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.b(statusData, (StatusListener) obj);
                }
            });
            if (z) {
                return;
            }
            a(this.fallbackListener, statusData);
        } finally {
            this.listenerReadLock.unlock();
        }
    }

    public static void setLogger(StatusLogger statusLogger) {
        Objects.requireNonNull(statusLogger, "logger");
        StatusLogger unused = InstanceHolder.INSTANCE = statusLogger;
    }

    @Deprecated
    public void clear() {
        this.buffer.clear();
    }

    public StatusConsoleListener getFallbackListener() {
        return this.fallbackListener;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public Level getLevel() {
        Level statusLevel = this.fallbackListener.getStatusLevel();
        for (int i2 = 0; i2 < this.listeners.size(); i2++) {
            Level statusLevel2 = this.listeners.get(i2).getStatusLevel();
            if (statusLevel2.isLessSpecificThan(statusLevel)) {
                statusLevel = statusLevel2;
            }
        }
        return statusLevel;
    }

    public Iterable<StatusListener> getListeners() {
        this.listenerReadLock.lock();
        try {
            return Collections.unmodifiableCollection(this.listeners);
        } finally {
            this.listenerReadLock.unlock();
        }
    }

    @Deprecated
    public List<StatusData> getStatusData() {
        return Collections.unmodifiableList(new ArrayList(this.buffer));
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Throwable th) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    @SuppressFBWarnings({"INFORMATION_EXPOSURE_THROUGH_AN_ERROR_MESSAGE"})
    public void logMessage(String str, Level level, Marker marker, Message message, Throwable th) {
        try {
            StatusData statusDataCreateStatusData = createStatusData(str, level, message, th);
            buffer(statusDataCreateStatusData);
            notifyListeners(statusDataCreateStatusData);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public void registerListener(StatusListener statusListener) {
        Objects.requireNonNull(statusListener, "listener");
        this.listenerWriteLock.lock();
        try {
            this.listeners.add(statusListener);
        } finally {
            this.listenerWriteLock.unlock();
        }
    }

    public void removeListener(StatusListener statusListener) {
        Objects.requireNonNull(statusListener, "listener");
        this.listenerWriteLock.lock();
        try {
            this.listeners.remove(statusListener);
            closeListenerSafely(statusListener);
        } finally {
            this.listenerWriteLock.unlock();
        }
    }

    public void reset() {
        this.listenerWriteLock.lock();
        try {
            Iterator<StatusListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                closeListenerSafely(it.next());
                it.remove();
            }
            this.listenerWriteLock.unlock();
            this.fallbackListener.close();
            this.buffer.clear();
        } catch (Throwable th) {
            this.listenerWriteLock.unlock();
            throw th;
        }
    }

    @Deprecated
    public void setLevel(Level level) {
        Objects.requireNonNull(level, "level");
        this.fallbackListener.setLevel(level);
    }

    @Deprecated
    public void updateListenerLevel(Level level) {
        Objects.requireNonNull(level, "level");
        this.fallbackListener.setLevel(level);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object... objArr) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2) {
        return isEnabled(level, marker);
    }

    public static final class Config {
        private static final Config INSTANCE = new Config();
        final int bufferCapacity;
        final boolean debugEnabled;

        @Nullable
        final Level fallbackListenerLevel;

        @Nullable
        final DateTimeFormatter instantFormatter;

        public Config(boolean z, int i2, @Nullable DateTimeFormatter dateTimeFormatter) {
            this.debugEnabled = z;
            if (i2 >= 0) {
                this.bufferCapacity = i2;
                this.fallbackListenerLevel = null;
                this.instantFormatter = dateTimeFormatter;
            } else {
                throw new IllegalArgumentException("was expecting a positive `bufferCapacity`, found: " + i2);
            }
        }

        public static Config getInstance() {
            return INSTANCE;
        }

        private static int readBufferCapacity(Map<String, Object> map) throws NumberFormatException {
            String property = PropertiesUtilsDouble.readProperty(map, StatusLogger.MAX_STATUS_ENTRIES);
            if (property == null) {
                return 0;
            }
            try {
                int i2 = Integer.parseInt(property);
                if (i2 >= 0) {
                    return i2;
                }
                throw new IllegalArgumentException(String.format("was expecting a positive buffer capacity, found: %d", Integer.valueOf(i2)));
            } catch (Exception e) {
                new IllegalArgumentException(String.format("Failed reading the buffer capacity from the `%s` property: `%s`. Falling back to the default: %d.", StatusLogger.MAX_STATUS_ENTRIES, property, 0), e).printStackTrace(System.err);
                return 0;
            }
        }

        private static boolean readDebugEnabled(Map<String, Object> map) {
            String property = PropertiesUtilsDouble.readProperty(map, "log4j2.debug");
            return (property == null || "false".equalsIgnoreCase(property)) ? false : true;
        }

        private static Level readFallbackListenerLevel(Map<String, Object> map) {
            String property = PropertiesUtilsDouble.readProperty(map, StatusLogger.DEFAULT_STATUS_LISTENER_LEVEL);
            Level level = StatusLogger.DEFAULT_FALLBACK_LISTENER_LEVEL;
            if (property == null) {
                return level;
            }
            try {
                return Level.valueOf(property);
            } catch (Exception e) {
                new IllegalArgumentException(String.format("Failed reading the level from the `%s` property: `%s`. Falling back to the default: `%s`.", StatusLogger.DEFAULT_STATUS_LISTENER_LEVEL, property, level), e).printStackTrace(System.err);
                return level;
            }
        }

        @Nullable
        private static DateTimeFormatter readInstantFormatter(Map<String, Object> map) {
            String property = PropertiesUtilsDouble.readProperty(map, StatusLogger.STATUS_DATE_FORMAT);
            if (property == null) {
                return null;
            }
            try {
                DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern(property);
                String property2 = PropertiesUtilsDouble.readProperty(map, StatusLogger.STATUS_DATE_FORMAT_ZONE);
                ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
                if (property2 != null) {
                    try {
                        zoneIdSystemDefault = ZoneId.of(property2);
                    } catch (Exception e) {
                        new IllegalArgumentException(String.format("Failed reading the instant formatting zone ID from the `%s` property: `%s`. Falling back to the default: `%s`.", StatusLogger.STATUS_DATE_FORMAT_ZONE, property2, zoneIdSystemDefault), e).printStackTrace(System.err);
                    }
                }
                return dateTimeFormatterOfPattern.withZone(zoneIdSystemDefault);
            } catch (Exception e2) {
                new IllegalArgumentException(String.format("failed reading the instant format from the `%s` property: `%s`", StatusLogger.STATUS_DATE_FORMAT, property), e2).printStackTrace(System.err);
                return null;
            }
        }

        private Config() {
            this(PropertiesUtilsDouble.readAllAvailableProperties());
        }

        Config(Properties... propertiesArr) {
            this((Map<String, Object>) PropertiesUtilsDouble.normalizeProperties(propertiesArr));
        }

        private Config(Map<String, Object> map) {
            this.debugEnabled = readDebugEnabled(map);
            this.bufferCapacity = readBufferCapacity(map);
            this.fallbackListenerLevel = readFallbackListenerLevel(map);
            this.instantFormatter = readInstantFormatter(map);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusLogger(String str, MessageFactory messageFactory, Config config, StatusConsoleListener statusConsoleListener) {
        super(str, messageFactory);
        Objects.requireNonNull(str, "name");
        Objects.requireNonNull(messageFactory, "messageFactory");
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.listenerLock = reentrantReadWriteLock;
        this.listenerReadLock = reentrantReadWriteLock.readLock();
        this.listenerWriteLock = reentrantReadWriteLock.writeLock();
        this.buffer = new ConcurrentLinkedQueue();
        Objects.requireNonNull(config, "config");
        this.config = config;
        Objects.requireNonNull(statusConsoleListener, "fallbackListener");
        this.fallbackListener = statusConsoleListener;
        this.listeners = new ArrayList();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, CharSequence charSequence, Throwable th) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, Object obj, Throwable th) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, Message message, Throwable th) {
        return isEnabled(level, marker);
    }

    @Override // com.auto.exceldeps.log4j.spi.AbstractLogger, com.auto.exceldeps.log4j.Logger
    public boolean isEnabled(Level level, Marker marker) {
        Objects.requireNonNull(level, "messageLevel");
        return isLevelEnabled(getLevel(), level);
    }
}
