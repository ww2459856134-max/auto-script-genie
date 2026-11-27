package com.auto.exceldeps.log4j.simple;

import com.auto.exceldeps.log4j.Level;
import com.auto.exceldeps.log4j.message.MessageFactory;
import com.auto.exceldeps.log4j.message.ParameterizedMessageFactory;
import com.auto.exceldeps.log4j.simple.internal.SimpleProvider;
import com.auto.exceldeps.log4j.spi.ExtendedLogger;
import com.auto.exceldeps.log4j.spi.LoggerContext;
import com.auto.exceldeps.log4j.spi.LoggerRegistry;
import com.auto.exceldeps.log4j.util.PropertiesUtil;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class SimpleLoggerContext implements LoggerContext {
    protected static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS zzz";
    protected static final String SYSTEM_PREFIX = "com.auto.exceldeps.log4j.simplelog.";
    private final String dateTimeFormat;
    private final Level defaultLevel;
    private final LoggerRegistry<ExtendedLogger> loggerRegistry = new LoggerRegistry<>();
    private final PropertiesUtil props;
    private final boolean showContextMap;
    private final boolean showDateTime;
    private final boolean showLogName;
    private final boolean showShortName;
    private final PrintStream stream;
    static final SimpleLoggerContext INSTANCE = new SimpleLoggerContext();
    private static final MessageFactory DEFAULT_MESSAGE_FACTORY = ParameterizedMessageFactory.INSTANCE;

    @SuppressFBWarnings(justification = "Opens a file retrieved from configuration (Log4j properties)", value = {"PATH_TRAVERSAL_OUT"})
    public SimpleLoggerContext() {
        SimpleProvider.Config config = SimpleProvider.Config.INSTANCE;
        this.props = config.props;
        this.showContextMap = config.showContextMap;
        this.showLogName = config.showLogName;
        this.showShortName = config.showShortName;
        this.showDateTime = config.showDateTime;
        this.defaultLevel = config.defaultLevel;
        this.dateTimeFormat = config.dateTimeFormat;
        this.stream = config.stream;
    }

    private ExtendedLogger createLogger(String str, MessageFactory messageFactory) {
        return new SimpleLogger(str, this.defaultLevel, this.showLogName, this.showShortName, this.showDateTime, this.showContextMap, this.dateTimeFormat, messageFactory, this.props, this.stream);
    }

    @Override // com.auto.exceldeps.log4j.spi.LoggerContext
    public Object getExternalContext() {
        return null;
    }

    @Override // com.auto.exceldeps.log4j.spi.LoggerContext
    public ExtendedLogger getLogger(String str) {
        return getLogger(str, DEFAULT_MESSAGE_FACTORY);
    }

    @Override // com.auto.exceldeps.log4j.spi.LoggerContext
    public LoggerRegistry<ExtendedLogger> getLoggerRegistry() {
        return this.loggerRegistry;
    }

    @Override // com.auto.exceldeps.log4j.spi.LoggerContext
    public boolean hasLogger(String str) {
        return this.loggerRegistry.hasLogger(str, DEFAULT_MESSAGE_FACTORY);
    }

    @Override // com.auto.exceldeps.log4j.spi.LoggerContext
    public ExtendedLogger getLogger(String str, MessageFactory messageFactory) {
        if (messageFactory == null) {
            messageFactory = DEFAULT_MESSAGE_FACTORY;
        }
        ExtendedLogger logger = this.loggerRegistry.getLogger(str, messageFactory);
        if (logger != null) {
            return logger;
        }
        this.loggerRegistry.putIfAbsent(str, messageFactory, createLogger(str, messageFactory));
        return this.loggerRegistry.getLogger(str, messageFactory);
    }

    @Override // com.auto.exceldeps.log4j.spi.LoggerContext
    public boolean hasLogger(String str, Class<? extends MessageFactory> cls) {
        return this.loggerRegistry.hasLogger(str, cls);
    }

    @Override // com.auto.exceldeps.log4j.spi.LoggerContext
    public boolean hasLogger(String str, MessageFactory messageFactory) {
        if (messageFactory == null) {
            messageFactory = DEFAULT_MESSAGE_FACTORY;
        }
        return this.loggerRegistry.hasLogger(str, messageFactory);
    }
}
