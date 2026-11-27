package com.auto.exceldeps.log4j.simple.internal;

import com.auto.exceldeps.log4j.Level;
import com.auto.exceldeps.log4j.simple.SimpleLoggerContextFactory;
import com.auto.exceldeps.log4j.spi.LoggerContextFactory;
import com.auto.exceldeps.log4j.spi.NoOpThreadContextMap;
import com.auto.exceldeps.log4j.spi.Provider;
import com.auto.exceldeps.log4j.spi.ThreadContextMap;
import com.auto.exceldeps.log4j.util.PropertiesUtil;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.jspecify.annotations.NullMarked;

@NullMarked
/* loaded from: classes.dex */
public final class SimpleProvider extends Provider {
    private final ThreadContextMap threadContextMap;

    public static final class Config {
        private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS zzz";
        public static final Config INSTANCE = new Config();
        private static final String SYSTEM_ERR = "system.err";
        private static final String SYSTEM_OUT = "system.out";
        private static final String SYSTEM_PREFIX = "com.auto.exceldeps.log4j.simplelog.";
        public final String dateTimeFormat;
        public final Level defaultLevel;
        public final PropertiesUtil props;
        public final boolean showContextMap;
        public final boolean showDateTime;
        public final boolean showLogName;
        public final boolean showShortName;
        public final PrintStream stream;

        private Config() {
            PrintStream printStream;
            PropertiesUtil propertiesUtil = new PropertiesUtil("log4j2.simplelog.properties");
            this.props = propertiesUtil;
            this.showContextMap = propertiesUtil.getBooleanProperty("com.auto.exceldeps.log4j.simplelog.showContextMap", false);
            this.showLogName = propertiesUtil.getBooleanProperty("com.auto.exceldeps.log4j.simplelog.showlogname", false);
            this.showShortName = propertiesUtil.getBooleanProperty("com.auto.exceldeps.log4j.simplelog.showShortLogname", true);
            boolean booleanProperty = propertiesUtil.getBooleanProperty("com.auto.exceldeps.log4j.simplelog.showdatetime", false);
            this.showDateTime = booleanProperty;
            this.defaultLevel = Level.toLevel(propertiesUtil.getStringProperty("com.auto.exceldeps.log4j.simplelog.level"), Level.ERROR);
            this.dateTimeFormat = booleanProperty ? propertiesUtil.getStringProperty("com.auto.exceldeps.log4j.simplelog.dateTimeFormat", DEFAULT_DATE_TIME_FORMAT) : null;
            String stringProperty = propertiesUtil.getStringProperty("com.auto.exceldeps.log4j.simplelog.logFile", SYSTEM_ERR);
            if (SYSTEM_ERR.equalsIgnoreCase(stringProperty)) {
                printStream = System.err;
            } else if (SYSTEM_OUT.equalsIgnoreCase(stringProperty)) {
                printStream = System.out;
            } else {
                try {
                    printStream = new PrintStream(new FileOutputStream(stringProperty));
                } catch (FileNotFoundException unused) {
                    printStream = System.err;
                }
            }
            this.stream = printStream;
        }
    }

    public SimpleProvider() {
        super(null, "2.6.0");
        this.threadContextMap = Config.INSTANCE.showContextMap ? super.getThreadContextMapInstance() : NoOpThreadContextMap.INSTANCE;
    }

    @Override // com.auto.exceldeps.log4j.spi.Provider
    public LoggerContextFactory getLoggerContextFactory() {
        return SimpleLoggerContextFactory.INSTANCE;
    }

    @Override // com.auto.exceldeps.log4j.spi.Provider
    public ThreadContextMap getThreadContextMapInstance() {
        return this.threadContextMap;
    }
}
