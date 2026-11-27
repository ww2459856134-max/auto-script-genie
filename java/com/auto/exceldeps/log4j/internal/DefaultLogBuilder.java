package com.auto.exceldeps.log4j.internal;

import com.auto.exceldeps.log4j.BridgeAware;
import com.auto.exceldeps.log4j.Level;
import com.auto.exceldeps.log4j.LogBuilder;
import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.Marker;
import com.auto.exceldeps.log4j.message.Message;
import com.auto.exceldeps.log4j.message.SimpleMessage;
import com.auto.exceldeps.log4j.spi.ExtendedLogger;
import com.auto.exceldeps.log4j.status.StatusLogger;
import com.auto.exceldeps.log4j.util.LambdaUtil;
import com.auto.exceldeps.log4j.util.StackLocatorUtil;
import com.auto.exceldeps.log4j.util.Supplier;
import java.util.Arrays;

/* loaded from: classes.dex */
public class DefaultLogBuilder implements BridgeAware, LogBuilder {
    private static Message EMPTY_MESSAGE = new SimpleMessage("");
    private static final String FQCN = DefaultLogBuilder.class.getName();
    private static final Logger LOGGER = StatusLogger.getLogger();
    private String fqcn;
    private volatile boolean inUse;
    private Level level;
    private StackTraceElement location;
    private ExtendedLogger logger;
    private Marker marker;
    private long threadId;
    private Throwable throwable;

    public DefaultLogBuilder(ExtendedLogger extendedLogger, Level level) {
        this.fqcn = FQCN;
        this.logger = extendedLogger;
        this.level = level;
        this.threadId = Thread.currentThread().getId();
        this.inUse = level != null;
    }

    private boolean isValid() {
        if (!this.inUse) {
            LOGGER.warn("Attempt to reuse LogBuilder was ignored. {}", StackLocatorUtil.getCallerClass(2));
            return false;
        }
        if (this.threadId == Thread.currentThread().getId()) {
            return true;
        }
        LOGGER.warn("LogBuilder can only be used on the owning thread. {}", StackLocatorUtil.getCallerClass(2));
        return false;
    }

    private void logMessage(Message message) {
        try {
            this.logger.logMessage(this.level, this.marker, this.fqcn, this.location, message, this.throwable);
        } finally {
            this.inUse = false;
        }
    }

    protected boolean isEnabled(Message message) {
        return this.logger.isEnabled(this.level, this.marker, message, this.throwable);
    }

    public boolean isInUse() {
        return this.inUse;
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(Message message) {
        if (isValid() && isEnabled(message)) {
            logMessage(message);
        }
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public Message logAndGet(Supplier<Message> supplier) {
        if (!isValid()) {
            return null;
        }
        Message message = supplier.get();
        if (!isEnabled(message)) {
            return message;
        }
        logMessage(message);
        return message;
    }

    public LogBuilder reset(ExtendedLogger extendedLogger, Level level) {
        this.logger = extendedLogger;
        this.level = level;
        this.marker = null;
        this.throwable = null;
        this.location = null;
        this.inUse = true;
        return this;
    }

    @Override // com.auto.exceldeps.log4j.BridgeAware
    public void setEntryPoint(String str) {
        this.fqcn = str;
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public LogBuilder withLocation() {
        this.location = StackLocatorUtil.getStackTraceElement(2);
        return this;
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public LogBuilder withMarker(Marker marker) {
        this.marker = marker;
        return this;
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public LogBuilder withThrowable(Throwable th) {
        this.throwable = th;
        return this;
    }

    protected boolean isEnabled(CharSequence charSequence) {
        return this.logger.isEnabled(this.level, this.marker, charSequence, this.throwable);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public LogBuilder withLocation(StackTraceElement stackTraceElement) {
        this.location = stackTraceElement;
        return this;
    }

    protected boolean isEnabled(String str) {
        return this.logger.isEnabled(this.level, this.marker, str, this.throwable);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(CharSequence charSequence) {
        if (isValid() && isEnabled(charSequence)) {
            logMessage(this.logger.getMessageFactory().newMessage(charSequence));
        }
    }

    protected boolean isEnabled(String str, Object... objArr) {
        if (this.throwable != null) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 1);
            objArrCopyOf[objArr.length] = this.throwable;
            objArr = objArrCopyOf;
        }
        return this.logger.isEnabled(this.level, this.marker, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str) {
        if (isValid() && isEnabled(str)) {
            logMessage(this.logger.getMessageFactory().newMessage(str));
        }
    }

    public DefaultLogBuilder() {
        this(null, null);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str, Object... objArr) {
        if (isValid() && isEnabled(str, objArr)) {
            logMessage(this.logger.getMessageFactory().newMessage(str, objArr));
        }
    }

    protected boolean isEnabled(Object obj) {
        return this.logger.isEnabled(this.level, this.marker, obj, this.throwable);
    }

    protected boolean isEnabled(String str, Object obj) {
        Throwable th = this.throwable;
        if (th != null) {
            return this.logger.isEnabled(this.level, this.marker, str, obj, th);
        }
        return this.logger.isEnabled(this.level, this.marker, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str, Supplier<?>... supplierArr) {
        if (isValid()) {
            Object[] all = LambdaUtil.getAll(supplierArr);
            if (isEnabled(str, all)) {
                logMessage(this.logger.getMessageFactory().newMessage(str, all));
            }
        }
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(Supplier<Message> supplier) {
        logAndGet(supplier);
    }

    protected boolean isEnabled(String str, Object obj, Object obj2) {
        Throwable th = this.throwable;
        if (th != null) {
            return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, th);
        }
        return this.logger.isEnabled(this.level, this.marker, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(Object obj) {
        if (isValid() && isEnabled(obj)) {
            logMessage(this.logger.getMessageFactory().newMessage(obj));
        }
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str, Object obj) {
        if (isValid() && isEnabled(str, obj)) {
            logMessage(this.logger.getMessageFactory().newMessage(str, obj));
        }
    }

    protected boolean isEnabled(String str, Object obj, Object obj2, Object obj3) {
        Throwable th = this.throwable;
        if (th != null) {
            return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, th);
        }
        return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str, Object obj, Object obj2) {
        if (isValid() && isEnabled(str, obj, obj2)) {
            logMessage(this.logger.getMessageFactory().newMessage(str, obj, obj2));
        }
    }

    protected boolean isEnabled(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        Throwable th = this.throwable;
        if (th != null) {
            return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, th);
        }
        return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str, Object obj, Object obj2, Object obj3) {
        if (isValid() && isEnabled(str, obj, obj2, obj3)) {
            logMessage(this.logger.getMessageFactory().newMessage(str, obj, obj2, obj3));
        }
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (isValid() && isEnabled(str, obj, obj2, obj3, obj4)) {
            logMessage(this.logger.getMessageFactory().newMessage(str, obj, obj2, obj3, obj4));
        }
    }

    protected boolean isEnabled(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Throwable th = this.throwable;
        if (th != null) {
            return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, obj5, th);
        }
        return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        if (isValid() && isEnabled(str, obj, obj2, obj3, obj4, obj5)) {
            logMessage(this.logger.getMessageFactory().newMessage(str, obj, obj2, obj3, obj4, obj5));
        }
    }

    protected boolean isEnabled(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Throwable th = this.throwable;
        if (th != null) {
            return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, obj5, obj6, th);
        }
        return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        if (isValid() && isEnabled(str, obj, obj2, obj3, obj4, obj5, obj6)) {
            logMessage(this.logger.getMessageFactory().newMessage(str, obj, obj2, obj3, obj4, obj5, obj6));
        }
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        if (isValid() && isEnabled(str, obj, obj2, obj3, obj4, obj5, obj6, obj7)) {
            logMessage(this.logger.getMessageFactory().newMessage(str, obj, obj2, obj3, obj4, obj5, obj6, obj7));
        }
    }

    protected boolean isEnabled(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        Throwable th = this.throwable;
        if (th != null) {
            return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, th);
        }
        return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        if (isValid() && isEnabled(str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8)) {
            logMessage(this.logger.getMessageFactory().newMessage(str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8));
        }
    }

    protected boolean isEnabled(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        Throwable th = this.throwable;
        if (th != null) {
            return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, th);
        }
        return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        if (isValid() && isEnabled(str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9)) {
            logMessage(this.logger.getMessageFactory().newMessage(str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9));
        }
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        if (isValid() && isEnabled(str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10)) {
            logMessage(this.logger.getMessageFactory().newMessage(str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10));
        }
    }

    protected boolean isEnabled(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        Throwable th = this.throwable;
        if (th != null) {
            return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, th);
        }
        return this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.LogBuilder
    public void log() {
        if (isValid() && isEnabled(EMPTY_MESSAGE)) {
            logMessage(EMPTY_MESSAGE);
        }
    }

    protected boolean isEnabled(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        Throwable th = this.throwable;
        return th != null ? this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, th) : this.logger.isEnabled(this.level, this.marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }
}
