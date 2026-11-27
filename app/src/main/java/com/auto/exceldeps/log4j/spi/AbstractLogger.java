package com.auto.exceldeps.log4j.spi;

import com.auto.exceldeps.log4j.Level;
import com.auto.exceldeps.log4j.LogBuilder;
import com.auto.exceldeps.log4j.LoggingException;
import com.auto.exceldeps.log4j.Marker;
import com.auto.exceldeps.log4j.MarkerManager;
import com.auto.exceldeps.log4j.internal.DefaultLogBuilder;
import com.auto.exceldeps.log4j.message.DefaultFlowMessageFactory;
import com.auto.exceldeps.log4j.message.EntryMessage;
import com.auto.exceldeps.log4j.message.FlowMessageFactory;
import com.auto.exceldeps.log4j.message.Message;
import com.auto.exceldeps.log4j.message.MessageFactory;
import com.auto.exceldeps.log4j.message.MessageFactory2;
import com.auto.exceldeps.log4j.message.ParameterizedMessageFactory;
import com.auto.exceldeps.log4j.message.ReusableMessageFactory;
import com.auto.exceldeps.log4j.message.StringFormattedMessage;
import com.auto.exceldeps.log4j.status.StatusLogger;
import com.auto.exceldeps.log4j.util.Constants;
import com.auto.exceldeps.log4j.util.LambdaUtil;
import com.auto.exceldeps.log4j.util.MessageSupplier;
import com.auto.exceldeps.log4j.util.PerformanceSensitive;
import com.auto.exceldeps.log4j.util.StackLocatorUtil;
import java.io.Serializable;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public abstract class AbstractLogger implements ExtendedLogger, LocationAwareLogger, Serializable {
    private static final String CATCHING = "Catching";
    public static final Marker CATCHING_MARKER;
    public static final Class<? extends FlowMessageFactory> DEFAULT_FLOW_MESSAGE_FACTORY_CLASS;
    public static final Class<? extends MessageFactory> DEFAULT_MESSAGE_FACTORY_CLASS;
    public static final Marker ENTRY_MARKER;
    public static final Marker EXCEPTION_MARKER;
    public static final Marker EXIT_MARKER;
    public static final Marker FLOW_MARKER;
    private static final String FQCN;
    private static final String THROWING = "Throwing";
    public static final Marker THROWING_MARKER;
    private static final ThreadLocal<DefaultLogBuilder> logBuilder;
    private static final ThreadLocal<int[]> recursionDepthHolder;
    private static final long serialVersionUID = 2;
    private final FlowMessageFactory flowMessageFactory;
    private final MessageFactory2 messageFactory;
    protected final String name;

    static {
        Marker marker = MarkerManager.getMarker("FLOW");
        FLOW_MARKER = marker;
        ENTRY_MARKER = MarkerManager.getMarker("ENTER").setParents(marker);
        EXIT_MARKER = MarkerManager.getMarker("EXIT").setParents(marker);
        Marker marker2 = MarkerManager.getMarker("EXCEPTION");
        EXCEPTION_MARKER = marker2;
        THROWING_MARKER = MarkerManager.getMarker("THROWING").setParents(marker2);
        CATCHING_MARKER = MarkerManager.getMarker("CATCHING").setParents(marker2);
        DEFAULT_MESSAGE_FACTORY_CLASS = ParameterizedMessageFactory.class;
        DEFAULT_FLOW_MESSAGE_FACTORY_CLASS = DefaultFlowMessageFactory.class;
        FQCN = AbstractLogger.class.getName();
        recursionDepthHolder = new ThreadLocal<>();
        logBuilder = ThreadLocal.withInitial(new Supplier() { // from class: com.auto.exceldeps.log4j.spi.d
            @Override // java.util.function.Supplier
            public final Object get() {
                return new DefaultLogBuilder();
            }
        });
    }

    public AbstractLogger() {
        this(null, null, null);
    }

    private static MessageFactory2 adaptMessageFactory(MessageFactory messageFactory) {
        return messageFactory instanceof MessageFactory2 ? (MessageFactory2) messageFactory : new MessageFactory2Adapter(messageFactory);
    }

    public static void checkMessageFactory(ExtendedLogger extendedLogger, MessageFactory messageFactory) {
        String name = extendedLogger.getName();
        MessageFactory messageFactory2 = extendedLogger.getMessageFactory();
        if (messageFactory != null && !messageFactory2.equals(messageFactory)) {
            StatusLogger.getLogger().warn("The Logger {} was created with the message factory {} and is now requested with the message factory {}, which may create log events with unexpected formatting.", name, messageFactory2, messageFactory);
            return;
        }
        if (messageFactory == null) {
            Class<?> cls = messageFactory2.getClass();
            Class<? extends MessageFactory> cls2 = DEFAULT_MESSAGE_FACTORY_CLASS;
            if (cls.equals(cls2)) {
                return;
            }
            StatusLogger.getLogger().warn("The Logger {} was created with the message factory {} and is now requested with a null message factory (defaults to {}), which may create log events with unexpected formatting.", name, messageFactory2, cls2.getName());
        }
    }

    private static void decrementRecursionDepth() {
        int[] recursionDepthHolder2 = getRecursionDepthHolder();
        int i2 = recursionDepthHolder2[0] - 1;
        recursionDepthHolder2[0] = i2;
        if (i2 >= 0) {
            return;
        }
        throw new IllegalStateException("Recursion depth became negative: " + i2);
    }

    @PerformanceSensitive
    private StackTraceElement getLocation(String str) {
        if (requiresLocation()) {
            return StackLocatorUtil.calcLocation(str);
        }
        return null;
    }

    public static int getRecursionDepth() {
        return getRecursionDepthHolder()[0];
    }

    private static int[] getRecursionDepthHolder() {
        ThreadLocal<int[]> threadLocal = recursionDepthHolder;
        int[] iArr = threadLocal.get();
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[1];
        threadLocal.set(iArr2);
        return iArr2;
    }

    private void handleLogMessageException(Throwable th, String str, Message message) {
        if (th instanceof LoggingException) {
            throw ((LoggingException) th);
        }
        StatusLogger.getLogger().warn("{} caught {} logging {}: {}", str, th.getClass().getName(), message.getClass().getSimpleName(), message.getFormat(), th);
    }

    private static void incrementRecursionDepth() {
        int[] recursionDepthHolder2 = getRecursionDepthHolder();
        recursionDepthHolder2[0] = recursionDepthHolder2[0] + 1;
    }

    @PerformanceSensitive
    private void logMessageSafely(String str, Level level, Marker marker, Message message, Throwable th) {
        try {
            logMessageTrackRecursion(str, level, marker, message, th);
        } finally {
            ReusableMessageFactory.release(message);
        }
    }

    @PerformanceSensitive
    private void logMessageTrackRecursion(String str, Level level, Marker marker, Message message, Throwable th) {
        try {
            incrementRecursionDepth();
            tryLogMessage(str, getLocation(str), level, marker, message, th);
        } finally {
            decrementRecursionDepth();
        }
    }

    @PerformanceSensitive
    private void tryLogMessage(String str, StackTraceElement stackTraceElement, Level level, Marker marker, Message message, Throwable th) {
        try {
            log(level, marker, str, stackTraceElement, message, th);
        } catch (Throwable th2) {
            handleLogMessageException(th2, str, message);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public LogBuilder always() {
        return getLogBuilder(Level.OFF);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public LogBuilder atDebug() {
        return atLevel(Level.DEBUG);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public LogBuilder atError() {
        return atLevel(Level.ERROR);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public LogBuilder atFatal() {
        return atLevel(Level.FATAL);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public LogBuilder atInfo() {
        return atLevel(Level.INFO);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public LogBuilder atLevel(Level level) {
        return isEnabled(level) ? getLogBuilder(level) : LogBuilder.NOOP;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public LogBuilder atTrace() {
        return atLevel(Level.TRACE);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public LogBuilder atWarn() {
        return atLevel(Level.WARN);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void catching(Level level, Throwable th) {
        catching(FQCN, level, th);
    }

    protected Message catchingMsg(Throwable th) {
        return this.messageFactory.newMessage(CATCHING);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, CharSequence charSequence) {
        logIfEnabled(FQCN, Level.DEBUG, marker, charSequence, (Throwable) null);
    }

    protected EntryMessage enter(String str, String str2, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        Level level = Level.TRACE;
        Marker marker = ENTRY_MARKER;
        if (!isEnabled(level, marker, (Object) null, (Throwable) null)) {
            return null;
        }
        EntryMessage entryMessageNewEntryMessage = this.flowMessageFactory.newEntryMessage(str2, LambdaUtil.getAll(supplierArr));
        logMessageSafely(str, level, marker, entryMessageNewEntryMessage, null);
        return entryMessageNewEntryMessage;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    @Deprecated
    public void entry() {
        entry(FQCN, null);
    }

    protected EntryMessage entryMsg(String str, Object... objArr) {
        return this.flowMessageFactory.newEntryMessage(str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, Message message) {
        logIfEnabled(FQCN, Level.ERROR, marker, message, message != null ? message.getThrowable() : null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    @Deprecated
    public void exit() {
        exit(FQCN, null);
    }

    protected Message exitMsg(String str, Object obj) {
        return this.flowMessageFactory.newExitMessage(str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, Message message) {
        logIfEnabled(FQCN, Level.FATAL, marker, message, message != null ? message.getThrowable() : null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public FlowMessageFactory getFlowMessageFactory() {
        return this.flowMessageFactory;
    }

    protected LogBuilder getLogBuilder(Level level) {
        if (Constants.ENABLE_THREADLOCALS) {
            DefaultLogBuilder defaultLogBuilder = logBuilder.get();
            if (!defaultLogBuilder.isInUse()) {
                return defaultLogBuilder.reset(this, level);
            }
        }
        return new DefaultLogBuilder(this, level);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public <MF extends MessageFactory> MF getMessageFactory() {
        return this.messageFactory;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public String getName() {
        return this.name;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, Message message) {
        logIfEnabled(FQCN, Level.INFO, marker, message, message != null ? message.getThrowable() : null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isDebugEnabled() {
        return isEnabled(Level.DEBUG, null, null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isEnabled(Level level) {
        return isEnabled(level, (Marker) null, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isErrorEnabled() {
        return isEnabled(Level.ERROR, (Marker) null, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isFatalEnabled() {
        return isEnabled(Level.FATAL, (Marker) null, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isInfoEnabled() {
        return isEnabled(Level.INFO, (Marker) null, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isTraceEnabled() {
        return isEnabled(Level.TRACE, (Marker) null, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isWarnEnabled() {
        return isEnabled(Level.WARN, (Marker) null, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, Message message) {
        logIfEnabled(FQCN, level, marker, message, message != null ? message.getThrowable() : null);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, Message message, Throwable th) {
        if (isEnabled(level, marker, message, th)) {
            logMessageSafely(str, level, marker, message, th);
        }
    }

    protected void logMessage(String str, Level level, Marker marker, CharSequence charSequence, Throwable th) {
        logMessageSafely(str, level, marker, this.messageFactory.newMessage(charSequence), th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void printf(Level level, Marker marker, String str, Object... objArr) {
        if (isEnabled(level, marker, str, objArr)) {
            StringFormattedMessage stringFormattedMessage = new StringFormattedMessage(str, objArr);
            logMessageSafely(FQCN, level, marker, stringFormattedMessage, stringFormattedMessage.getThrowable());
        }
    }

    protected boolean requiresLocation() {
        return false;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public <T extends Throwable> T throwing(T t) {
        return (T) throwing(FQCN, Level.ERROR, t);
    }

    protected Message throwingMsg(Throwable th) {
        return this.messageFactory.newMessage(THROWING);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, Message message) {
        logIfEnabled(FQCN, Level.TRACE, marker, message, message != null ? message.getThrowable() : null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public EntryMessage traceEntry() {
        return enter(FQCN, (String) null, (Object[]) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void traceExit() {
        exit(FQCN, null, null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, Message message) {
        logIfEnabled(FQCN, Level.WARN, marker, message, message != null ? message.getThrowable() : null);
    }

    public AbstractLogger(String str) {
        this(str, null, null);
    }

    protected void catching(String str, Level level, Throwable th) {
        Marker marker = CATCHING_MARKER;
        if (isEnabled(level, marker, (Object) null, (Throwable) null)) {
            logMessageSafely(str, level, marker, catchingMsg(th), th);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, Level.DEBUG, marker, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    @Deprecated
    public void entry(Object... objArr) {
        entry(FQCN, objArr);
    }

    protected EntryMessage entryMsg(String str, MessageSupplier... messageSupplierArr) {
        int length = messageSupplierArr == null ? 0 : messageSupplierArr.length;
        Object[] objArr = new Object[length];
        for (int i2 = 0; i2 < length; i2++) {
            objArr[i2] = messageSupplierArr[i2].get();
        }
        return entryMsg(str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, Message message, Throwable th) {
        logIfEnabled(FQCN, Level.ERROR, marker, message, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    @Deprecated
    public <R> R exit(R r) {
        return (R) exit(FQCN, r);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, Message message, Throwable th) {
        logIfEnabled(FQCN, Level.FATAL, marker, message, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, Message message, Throwable th) {
        logIfEnabled(FQCN, Level.INFO, marker, message, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isDebugEnabled(Marker marker) {
        return isEnabled(Level.DEBUG, marker, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isEnabled(Level level, Marker marker) {
        return isEnabled(level, marker, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isErrorEnabled(Marker marker) {
        return isEnabled(Level.ERROR, marker, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isFatalEnabled(Marker marker) {
        return isEnabled(Level.FATAL, marker, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isInfoEnabled(Marker marker) {
        return isEnabled(Level.INFO, marker, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isTraceEnabled(Marker marker) {
        return isEnabled(Level.TRACE, marker, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public boolean isWarnEnabled(Marker marker) {
        return isEnabled(Level.WARN, marker, (Object) null, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, Message message, Throwable th) {
        logIfEnabled(FQCN, level, marker, message, th);
    }

    protected void logMessage(String str, Level level, Marker marker, Object obj, Throwable th) {
        logMessageSafely(str, level, marker, this.messageFactory.newMessage(obj), th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public <T extends Throwable> T throwing(Level level, T t) {
        return (T) throwing(FQCN, level, t);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, Message message, Throwable th) {
        logIfEnabled(FQCN, Level.TRACE, marker, message, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public EntryMessage traceEntry(String str, Object... objArr) {
        return enter(FQCN, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public <R> R traceExit(R r) {
        return (R) exit(FQCN, null, r);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, Message message, Throwable th) {
        logIfEnabled(FQCN, Level.WARN, marker, message, th);
    }

    public AbstractLogger(String str, MessageFactory messageFactory) {
        this(str, messageFactory, null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, Message message) {
        logIfEnabled(FQCN, Level.DEBUG, marker, message, message != null ? message.getThrowable() : null);
    }

    protected void entry(String str, Object... objArr) {
        Level level = Level.TRACE;
        Marker marker = ENTRY_MARKER;
        if (isEnabled(level, marker, (Object) null, (Throwable) null)) {
            if (objArr == null) {
                logMessageSafely(str, level, marker, entryMsg((String) null, (com.auto.exceldeps.log4j.util.Supplier<?>[]) null), null);
            } else {
                logMessageSafely(str, level, marker, entryMsg((String) null, objArr), null);
            }
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, CharSequence charSequence) {
        logIfEnabled(FQCN, Level.ERROR, marker, charSequence, (Throwable) null);
    }

    protected <R> R exit(String str, R r) {
        Level level = Level.TRACE;
        Marker marker = EXIT_MARKER;
        if (isEnabled(level, marker, (CharSequence) null, (Throwable) null)) {
            logMessageSafely(str, level, marker, this.flowMessageFactory.newExitMessage((String) null, r), null);
        }
        return r;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, CharSequence charSequence) {
        logIfEnabled(FQCN, Level.FATAL, marker, charSequence, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, CharSequence charSequence) {
        logIfEnabled(FQCN, Level.INFO, marker, charSequence, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, CharSequence charSequence) {
        logIfEnabled(FQCN, level, marker, charSequence, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, MessageSupplier messageSupplier, Throwable th) {
        if (isEnabled(level, marker, messageSupplier, th)) {
            logMessage(str, level, marker, messageSupplier, th);
        }
    }

    protected void logMessage(String str, Level level, Marker marker, MessageSupplier messageSupplier, Throwable th) {
        Message message = LambdaUtil.get(messageSupplier);
        if (th == null && message != null) {
            th = message.getThrowable();
        }
        logMessageSafely(str, level, marker, message, th);
    }

    protected <T extends Throwable> T throwing(String str, Level level, T t) {
        Marker marker = THROWING_MARKER;
        if (isEnabled(level, marker, (Object) null, (Throwable) null)) {
            logMessageSafely(str, level, marker, throwingMsg(t), t);
        }
        return t;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, CharSequence charSequence) {
        logIfEnabled(FQCN, Level.TRACE, marker, charSequence, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public EntryMessage traceEntry(com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        return enter(FQCN, (String) null, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public <R> R traceExit(String str, R r) {
        return (R) exit(FQCN, str, r);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, CharSequence charSequence) {
        logIfEnabled(FQCN, Level.WARN, marker, charSequence, (Throwable) null);
    }

    protected AbstractLogger(String str, MessageFactory messageFactory, FlowMessageFactory flowMessageFactory) {
        if (str != null) {
            this.name = str;
        } else {
            Class<?> cls = getClass();
            String canonicalName = cls.getCanonicalName();
            this.name = canonicalName == null ? cls.getName() : canonicalName;
        }
        this.messageFactory = messageFactory != null ? adaptMessageFactory(messageFactory) : ParameterizedMessageFactory.INSTANCE;
        this.flowMessageFactory = flowMessageFactory == null ? DefaultFlowMessageFactory.INSTANCE : flowMessageFactory;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void catching(Throwable th) {
        Level level = Level.ERROR;
        Marker marker = CATCHING_MARKER;
        if (isEnabled(level, marker, (Object) null, (Throwable) null)) {
            logMessageSafely(FQCN, level, marker, catchingMsg(th), th);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, Message message, Throwable th) {
        logIfEnabled(FQCN, Level.DEBUG, marker, message, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, Level.ERROR, marker, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, Level.FATAL, marker, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, Level.INFO, marker, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, CharSequence charSequence, Throwable th) {
        if (isEnabled(level, marker, charSequence, th)) {
            logMessage(FQCN, level, marker, charSequence, th);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void printf(Level level, String str, Object... objArr) {
        if (isEnabled(level, (Marker) null, str, objArr)) {
            StringFormattedMessage stringFormattedMessage = new StringFormattedMessage(str, objArr);
            logMessageSafely(FQCN, level, null, stringFormattedMessage, stringFormattedMessage.getThrowable());
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, Level.TRACE, marker, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public EntryMessage traceEntry(String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        return enter(FQCN, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void traceExit(EntryMessage entryMessage) {
        if (entryMessage != null) {
            Level level = Level.TRACE;
            Marker marker = EXIT_MARKER;
            if (isEnabled(level, marker, (Message) entryMessage, (Throwable) null)) {
                logMessageSafely(FQCN, level, marker, this.flowMessageFactory.newExitMessage(entryMessage), null);
            }
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, Level.WARN, marker, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, Object obj) {
        logIfEnabled(FQCN, Level.DEBUG, marker, obj, (Throwable) null);
    }

    @Deprecated
    protected EntryMessage enter(String str, String str2, MessageSupplier... messageSupplierArr) {
        Level level = Level.TRACE;
        Marker marker = ENTRY_MARKER;
        if (!isEnabled(level, marker, (Object) null, (Throwable) null)) {
            return null;
        }
        EntryMessage entryMessageEntryMsg = entryMsg(str2, messageSupplierArr);
        logMessageSafely(str, level, marker, entryMessageEntryMsg, null);
        return entryMessageEntryMsg;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, Object obj) {
        logIfEnabled(FQCN, Level.ERROR, marker, obj, (Throwable) null);
    }

    protected <R> R exit(String str, String str2, R r) {
        Level level = Level.TRACE;
        Marker marker = EXIT_MARKER;
        if (isEnabled(level, marker, (CharSequence) null, (Throwable) null)) {
            logMessageSafely(str, level, marker, this.flowMessageFactory.newExitMessage(str2, r), null);
        }
        return r;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, Object obj) {
        logIfEnabled(FQCN, Level.FATAL, marker, obj, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, Object obj) {
        logIfEnabled(FQCN, Level.INFO, marker, obj, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, Object obj, Throwable th) {
        if (isEnabled(level, marker, obj, th)) {
            logMessage(str, level, marker, obj, th);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, Object obj) {
        logIfEnabled(FQCN, Level.TRACE, marker, obj, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public EntryMessage traceEntry(Message message) {
        return enter(FQCN, message);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, Object obj) {
        logIfEnabled(FQCN, Level.WARN, marker, obj, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, Object obj, Throwable th) {
        logIfEnabled(FQCN, Level.DEBUG, marker, obj, th);
    }

    protected EntryMessage entryMsg(String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        return entryMsg(str, LambdaUtil.getAll(supplierArr));
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, Object obj, Throwable th) {
        logIfEnabled(FQCN, Level.ERROR, marker, obj, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, Object obj, Throwable th) {
        logIfEnabled(FQCN, Level.FATAL, marker, obj, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, Object obj, Throwable th) {
        logIfEnabled(FQCN, Level.INFO, marker, obj, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, Object obj) {
        logIfEnabled(FQCN, level, marker, obj, (Throwable) null);
    }

    protected void logMessage(String str, Level level, Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        Message message = LambdaUtil.getMessage(supplier, this.messageFactory);
        if (th == null && message != null) {
            th = message.getThrowable();
        }
        logMessageSafely(str, level, marker, message, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, Object obj, Throwable th) {
        logIfEnabled(FQCN, Level.TRACE, marker, obj, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public <R> R traceExit(EntryMessage entryMessage, R r) {
        if (entryMessage != null) {
            Level level = Level.TRACE;
            Marker marker = EXIT_MARKER;
            if (isEnabled(level, marker, (Message) entryMessage, (Throwable) null)) {
                logMessageSafely(FQCN, level, marker, this.flowMessageFactory.newExitMessage((Object) r, entryMessage), null);
            }
        }
        return r;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, Object obj, Throwable th) {
        logIfEnabled(FQCN, Level.WARN, marker, obj, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, (Throwable) null);
    }

    protected EntryMessage enter(String str, String str2, Object... objArr) {
        Level level = Level.TRACE;
        Marker marker = ENTRY_MARKER;
        if (!isEnabled(level, marker, (Object) null, (Throwable) null)) {
            return null;
        }
        EntryMessage entryMessageNewEntryMessage = this.flowMessageFactory.newEntryMessage(str2, objArr);
        logMessageSafely(str, level, marker, entryMessageNewEntryMessage, null);
        return entryMessageNewEntryMessage;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str) {
        logIfEnabled(FQCN, Level.INFO, marker, str, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, Object obj, Throwable th) {
        if (isEnabled(level, marker, obj, th)) {
            logMessage(FQCN, level, marker, obj, th);
        }
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, CharSequence charSequence, Throwable th) {
        if (isEnabled(level, marker, charSequence, th)) {
            logMessage(str, level, marker, charSequence, th);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str) {
        logIfEnabled(FQCN, Level.WARN, marker, str, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, Object... objArr) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, Object... objArr) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, Object... objArr) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, Object... objArr) {
        logIfEnabled(FQCN, Level.INFO, marker, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, Object... objArr) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public <R> R traceExit(Message message, R r) {
        if (message != null) {
            Level level = Level.TRACE;
            Marker marker = EXIT_MARKER;
            if (isEnabled(level, marker, message, (Throwable) null)) {
                logMessageSafely(FQCN, level, marker, this.flowMessageFactory.newExitMessage(r, message), null);
            }
        }
        return r;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, Object... objArr) {
        logIfEnabled(FQCN, Level.WARN, marker, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, Throwable th) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, Throwable th) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, Throwable th) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, Throwable th) {
        logIfEnabled(FQCN, Level.INFO, marker, str, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str) {
        logIfEnabled(FQCN, level, marker, str, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        if (isEnabled(level, marker, supplier, th)) {
            logMessage(str, level, marker, supplier, th);
        }
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, Throwable th) {
        logMessageSafely(str, level, marker, this.messageFactory.newMessage(str2), th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, Throwable th) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, Throwable th) {
        logIfEnabled(FQCN, Level.WARN, marker, str, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Message message) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, message, message != null ? message.getThrowable() : null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Message message) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, message, message != null ? message.getThrowable() : null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Message message) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, message, message != null ? message.getThrowable() : null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Message message) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, message, message != null ? message.getThrowable() : null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, Object... objArr) {
        logIfEnabled(FQCN, level, marker, str, objArr);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2) {
        Message messageNewMessage = this.messageFactory.newMessage(str2);
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Message message) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, message, message != null ? message.getThrowable() : null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Message message) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, message, message != null ? message.getThrowable() : null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Message message, Throwable th) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, message, th);
    }

    @Deprecated
    protected EntryMessage enter(String str, MessageSupplier messageSupplier) {
        Level level = Level.TRACE;
        Marker marker = ENTRY_MARKER;
        if (!isEnabled(level, marker, (Object) null, (Throwable) null)) {
            return null;
        }
        EntryMessage entryMessageNewEntryMessage = this.flowMessageFactory.newEntryMessage(messageSupplier.get());
        logMessageSafely(str, level, marker, entryMessageNewEntryMessage, null);
        return entryMessageNewEntryMessage;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Message message, Throwable th) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, message, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Message message, Throwable th) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, message, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Message message, Throwable th) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, message, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, Throwable th) {
        logIfEnabled(FQCN, level, marker, str, th);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2) {
        if (isEnabled(level, marker, str2)) {
            logMessage(str, level, marker, str2);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Message message, Throwable th) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, message, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Message message, Throwable th) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, message, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(CharSequence charSequence) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, charSequence, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(CharSequence charSequence) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, charSequence, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(CharSequence charSequence) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, charSequence, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(CharSequence charSequence) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, charSequence, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Message message) {
        logIfEnabled(FQCN, level, (Marker) null, message, message != null ? message.getThrowable() : null);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, Object... objArr) {
        Message messageNewMessage = this.messageFactory.newMessage(str2, objArr);
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(CharSequence charSequence) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, charSequence, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(CharSequence charSequence) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, charSequence, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Message message, Throwable th) {
        logIfEnabled(FQCN, level, (Marker) null, message, th);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        if (isEnabled(level, marker, str2)) {
            logMessage(str, level, marker, str2, supplierArr);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Object obj) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, obj, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Object obj) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, obj, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Object obj) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, obj, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Object obj) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, obj, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, CharSequence charSequence) {
        logIfEnabled(FQCN, level, (Marker) null, charSequence, (Throwable) null);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, Object obj) {
        Message messageNewMessage = this.messageFactory.newMessage(str2, obj);
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Object obj) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, obj, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Object obj) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, obj, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Object obj, Throwable th) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, obj, th);
    }

    protected EntryMessage enter(String str, Message message) {
        Level level = Level.TRACE;
        Marker marker = ENTRY_MARKER;
        if (!isEnabled(level, marker, (Object) null, (Throwable) null)) {
            return null;
        }
        EntryMessage entryMessageNewEntryMessage = this.flowMessageFactory.newEntryMessage(message);
        logMessageSafely(str, level, marker, entryMessageNewEntryMessage, null);
        return entryMessageNewEntryMessage;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Object obj, Throwable th) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, obj, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Object obj, Throwable th) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, obj, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Object obj, Throwable th) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, obj, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, CharSequence charSequence, Throwable th) {
        logIfEnabled(FQCN, level, (Marker) null, charSequence, th);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, Object... objArr) {
        if (isEnabled(level, marker, str2, objArr)) {
            logMessage(str, level, marker, str2, objArr);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Object obj, Throwable th) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, obj, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Object obj, Throwable th) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, obj, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, str, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, str, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, str, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, str, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Object obj) {
        logIfEnabled(FQCN, level, (Marker) null, obj, (Throwable) null);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, Object obj, Object obj2) {
        Message messageNewMessage = this.messageFactory.newMessage(str2, obj, obj2);
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, str, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, str, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, Object... objArr) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, Object... objArr) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, Object... objArr) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, Object... objArr) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Object obj, Throwable th) {
        logIfEnabled(FQCN, level, (Marker) null, obj, th);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, Object obj) {
        if (isEnabled(level, marker, str2, obj)) {
            logMessage(str, level, marker, str2, obj);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, Object... objArr) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, Object... objArr) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, Throwable th) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, str, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, Throwable th) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, str, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, Throwable th) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, str, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, Throwable th) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, str, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str) {
        logIfEnabled(FQCN, level, (Marker) null, str, (Throwable) null);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3) {
        Message messageNewMessage = this.messageFactory.newMessage(str2, obj, obj2, obj3);
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, Throwable th) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, str, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, Throwable th) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, str, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, Object... objArr) {
        logIfEnabled(FQCN, level, (Marker) null, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, Object obj, Object obj2) {
        if (isEnabled(level, marker, str2, obj, obj2)) {
            logMessage(str, level, marker, str2, obj, obj2);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, Throwable th) {
        logIfEnabled(FQCN, level, (Marker) null, str, th);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        Message messageNewMessage = this.messageFactory.newMessage(str2, obj, obj2, obj3, obj4);
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, Level.DEBUG, marker, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, Level.ERROR, marker, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, Level.FATAL, marker, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, Level.INFO, marker, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, level, (Marker) null, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3) {
        if (isEnabled(level, marker, str2, obj, obj2, obj3)) {
            logMessage(str, level, marker, str2, obj, obj2, obj3);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, Level.TRACE, marker, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, Level.WARN, marker, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, Level.INFO, marker, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, level, (Marker) null, supplier, th);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Message messageNewMessage = this.messageFactory.newMessage(str2, obj, obj2, obj3, obj4, obj5);
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, Level.WARN, marker, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, Level.DEBUG, marker, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, Level.ERROR, marker, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, Level.FATAL, marker, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, Level.INFO, marker, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier) {
        logIfEnabled(FQCN, level, marker, supplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (isEnabled(level, marker, str2, obj, obj2, obj3, obj4)) {
            logMessage(str, level, marker, str2, obj, obj2, obj3, obj4);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, Level.TRACE, marker, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, Level.WARN, marker, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, level, marker, str, supplierArr);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Message messageNewMessage = this.messageFactory.newMessage(str2, obj, obj2, obj3, obj4, obj5, obj6);
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, str, supplierArr);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, Level.DEBUG, marker, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, Level.ERROR, marker, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, Level.FATAL, marker, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, Level.INFO, marker, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, com.auto.exceldeps.log4j.util.Supplier<?> supplier, Throwable th) {
        logIfEnabled(FQCN, level, marker, supplier, th);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        if (isEnabled(level, marker, str2, obj, obj2, obj3, obj4, obj5)) {
            logMessage(str, level, marker, str2, obj, obj2, obj3, obj4, obj5);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, Level.TRACE, marker, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, Level.WARN, marker, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, Level.DEBUG, marker, messageSupplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, Level.ERROR, marker, messageSupplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, Level.FATAL, marker, messageSupplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, Level.INFO, marker, messageSupplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        logIfEnabled(FQCN, level, (Marker) null, str, supplierArr);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        Message messageNewMessage = this.messageFactory.newMessage(str2, obj, obj2, obj3, obj4, obj5, obj6, obj7);
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, Level.TRACE, marker, messageSupplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, Level.WARN, marker, messageSupplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, level, marker, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        if (isEnabled(level, marker, str2, obj, obj2, obj3, obj4, obj5, obj6)) {
            logMessage(str, level, marker, str2, obj, obj2, obj3, obj4, obj5, obj6);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, messageSupplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, messageSupplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, messageSupplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, messageSupplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, level, marker, messageSupplier, th);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        Message messageNewMessage = this.messageFactory.newMessage(str2, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, messageSupplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, messageSupplier, th);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, Object obj) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, Object obj) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, Object obj) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, Object obj) {
        logIfEnabled(FQCN, Level.INFO, marker, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, MessageSupplier messageSupplier) {
        logIfEnabled(FQCN, level, (Marker) null, messageSupplier, (Throwable) null);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        if (isEnabled(level, marker, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7)) {
            logMessage(str, level, marker, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, Object obj) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, Object obj) {
        logIfEnabled(FQCN, Level.WARN, marker, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, Level.INFO, marker, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, MessageSupplier messageSupplier, Throwable th) {
        logIfEnabled(FQCN, level, (Marker) null, messageSupplier, th);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        Message messageNewMessage = this.messageFactory.newMessage(str2, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, Level.WARN, marker, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, Level.INFO, marker, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, Object obj) {
        logIfEnabled(FQCN, level, marker, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        if (isEnabled(level, marker, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8)) {
            logMessage(str, level, marker, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, Level.WARN, marker, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, Level.INFO, marker, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, level, marker, str, obj, obj2);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        Message messageNewMessage = this.messageFactory.newMessage(str2, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, Level.WARN, marker, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, Level.INFO, marker, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, level, marker, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        if (isEnabled(level, marker, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9)) {
            logMessage(str, level, marker, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, Level.WARN, marker, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, Level.INFO, marker, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, level, marker, str, obj, obj2, obj3, obj4);
    }

    protected void logMessage(String str, Level level, Marker marker, String str2, com.auto.exceldeps.log4j.util.Supplier<?>... supplierArr) {
        Message messageNewMessage = this.messageFactory.newMessage(str2, LambdaUtil.getAll(supplierArr));
        logMessageSafely(str, level, marker, messageNewMessage, messageNewMessage.getThrowable());
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, Level.WARN, marker, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, Level.INFO, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, level, marker, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        if (isEnabled(level, marker, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10)) {
            logMessage(str, level, marker, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, Level.WARN, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, Level.INFO, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, level, marker, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger, com.auto.exceldeps.log4j.spi.LocationAwareLogger
    public void logMessage(Level level, Marker marker, String str, StackTraceElement stackTraceElement, Message message, Throwable th) {
        try {
            incrementRecursionDepth();
            log(level, marker, str, stackTraceElement, message, th);
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, Level.WARN, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, Level.INFO, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, level, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public void logIfEnabled(String str, Level level, Marker marker, String str2, Throwable th) {
        if (isEnabled(level, marker, str2, th)) {
            logMessage(str, level, marker, str2, th);
        }
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, Level.WARN, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, Level.DEBUG, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, Level.ERROR, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, Level.FATAL, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, Level.INFO, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, level, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, Level.TRACE, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, Level.WARN, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, Object obj) {
        logIfEnabled(FQCN, Level.DEBUG, (Marker) null, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, Object obj) {
        logIfEnabled(FQCN, Level.ERROR, (Marker) null, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, Object obj) {
        logIfEnabled(FQCN, Level.FATAL, (Marker) null, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, Object obj) {
        logIfEnabled(FQCN, Level.INFO, (Marker) null, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, level, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, Object obj) {
        logIfEnabled(FQCN, Level.TRACE, (Marker) null, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, Object obj) {
        logIfEnabled(FQCN, Level.WARN, (Marker) null, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, Level.DEBUG, null, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, Level.ERROR, null, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, Level.FATAL, null, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, Level.INFO, null, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, level, marker, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, Level.TRACE, null, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, Level.WARN, null, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, Level.DEBUG, null, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, Level.ERROR, null, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, Level.FATAL, null, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, Level.INFO, null, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, Object obj) {
        logIfEnabled(FQCN, level, (Marker) null, str, obj);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, Level.TRACE, null, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, Level.WARN, null, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, Level.DEBUG, null, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, Level.ERROR, null, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, Level.FATAL, null, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, Level.INFO, null, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, Object obj, Object obj2) {
        logIfEnabled(FQCN, level, null, str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, Level.TRACE, null, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, Level.WARN, null, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, Level.DEBUG, null, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, Level.ERROR, null, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, Level.FATAL, null, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, Level.INFO, null, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(FQCN, level, null, str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, Level.TRACE, null, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, Level.WARN, null, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, Level.DEBUG, null, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, Level.ERROR, null, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, Level.FATAL, null, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, Level.INFO, null, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        logIfEnabled(FQCN, level, null, str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, Level.TRACE, null, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, Level.WARN, null, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, Level.DEBUG, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, Level.ERROR, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, Level.FATAL, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, Level.INFO, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        logIfEnabled(FQCN, level, null, str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, Level.TRACE, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, Level.WARN, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, Level.DEBUG, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, Level.ERROR, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, Level.FATAL, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, Level.INFO, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        logIfEnabled(FQCN, level, null, str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, Level.TRACE, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, Level.WARN, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, Level.DEBUG, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, Level.ERROR, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, Level.FATAL, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, Level.INFO, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        logIfEnabled(FQCN, level, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, Level.TRACE, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, Level.WARN, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void debug(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, Level.DEBUG, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void error(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, Level.ERROR, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void fatal(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, Level.FATAL, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void info(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, Level.INFO, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        logIfEnabled(FQCN, level, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void trace(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, Level.TRACE, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void warn(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, Level.WARN, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        logIfEnabled(FQCN, level, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public void log(Level level, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        logIfEnabled(FQCN, level, null, str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    protected void log(Level level, Marker marker, String str, StackTraceElement stackTraceElement, Message message, Throwable th) {
        logMessage(str, level, marker, message, th);
    }
}
