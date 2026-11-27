package com.auto.exceldeps.log4j.spi;

import com.auto.exceldeps.log4j.Level;
import com.auto.exceldeps.log4j.Marker;
import com.auto.exceldeps.log4j.message.Message;
import com.auto.exceldeps.log4j.message.MessageFactory;
import com.auto.exceldeps.log4j.util.StackLocatorUtil;

/* loaded from: classes.dex */
public class ExtendedLoggerWrapper extends AbstractLogger {
    private static final long serialVersionUID = 1;
    protected final ExtendedLogger logger;

    public ExtendedLoggerWrapper(ExtendedLogger extendedLogger, String str, MessageFactory messageFactory) {
        super(str, messageFactory);
        this.logger = extendedLogger;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public Level getLevel() {
        return this.logger.getLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, Message message, Throwable th) {
        return this.logger.isEnabled(level, marker, message, th);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logMessage(String str, Level level, Marker marker, Message message, Throwable th) {
        if ((this.logger instanceof LocationAwareLogger) && requiresLocation()) {
            ((LocationAwareLogger) this.logger).logMessage(level, marker, str, StackLocatorUtil.calcLocation(str), message, th);
        } else {
            this.logger.logMessage(str, level, marker, message, th);
        }
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, CharSequence charSequence, Throwable th) {
        return this.logger.isEnabled(level, marker, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, Object obj, Throwable th) {
        return this.logger.isEnabled(level, marker, obj, th);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str) {
        return this.logger.isEnabled(level, marker, str);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object... objArr) {
        return this.logger.isEnabled(level, marker, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj) {
        return this.logger.isEnabled(level, marker, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2) {
        return this.logger.isEnabled(level, marker, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3) {
        return this.logger.isEnabled(level, marker, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return this.logger.isEnabled(level, marker, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return this.logger.isEnabled(level, marker, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return this.logger.isEnabled(level, marker, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return this.logger.isEnabled(level, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return this.logger.isEnabled(level, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return this.logger.isEnabled(level, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return this.logger.isEnabled(level, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Throwable th) {
        return this.logger.isEnabled(level, marker, str, th);
    }
}
