package com.auto.exceldeps.log4j.status;

import com.auto.exceldeps.log4j.Level;
import com.auto.exceldeps.log4j.message.Message;
import com.auto.exceldeps.log4j.util.Chars;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/* loaded from: classes.dex */
public class StatusData implements Serializable {
    private static final long serialVersionUID = -4341916115118014017L;

    @Nullable
    private final StackTraceElement caller;
    private final Instant instant;
    private final DateTimeFormatter instantFormatter;
    private final Level level;
    private final Message message;
    private final String threadName;

    @Nullable
    private final Throwable throwable;

    public StatusData(@Nullable StackTraceElement stackTraceElement, Level level, Message message, @Nullable Throwable th, @Nullable String str) {
        this(stackTraceElement, level, message, th, str, null, Instant.now());
    }

    @SuppressFBWarnings(justification = "Log4j prints stacktraces only to logs, which should be private.", value = {"INFORMATION_EXPOSURE_THROUGH_AN_ERROR_MESSAGE"})
    public String getFormattedStatus() {
        StringBuilder sb = new StringBuilder();
        this.instantFormatter.formatTo(this.instant, sb);
        sb.append(Chars.SPACE);
        sb.append(getThreadName());
        sb.append(Chars.SPACE);
        sb.append(this.level.toString());
        sb.append(Chars.SPACE);
        sb.append(this.message.getFormattedMessage());
        Object[] parameters = this.message.getParameters();
        Throwable th = this.throwable;
        if (th == null && parameters != null && (parameters[parameters.length - 1] instanceof Throwable)) {
            th = (Throwable) parameters[parameters.length - 1];
        }
        if (th != null) {
            sb.append(Chars.SPACE);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            sb.append(byteArrayOutputStream);
        }
        return sb.toString();
    }

    public Instant getInstant() {
        return this.instant;
    }

    public Level getLevel() {
        return this.level;
    }

    public Message getMessage() {
        return this.message;
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return this.caller;
    }

    public String getThreadName() {
        return this.threadName;
    }

    @Nullable
    public Throwable getThrowable() {
        return this.throwable;
    }

    @Deprecated
    public long getTimestamp() {
        return this.instant.toEpochMilli();
    }

    public String toString() {
        return getMessage().getFormattedMessage();
    }

    StatusData(@Nullable StackTraceElement stackTraceElement, Level level, Message message, @Nullable Throwable th, @Nullable String str, @Nullable DateTimeFormatter dateTimeFormatter, Instant instant) {
        this.instantFormatter = dateTimeFormatter == null ? DateTimeFormatter.ISO_INSTANT : dateTimeFormatter;
        this.instant = instant;
        this.caller = stackTraceElement;
        Objects.requireNonNull(level, "level");
        this.level = level;
        Objects.requireNonNull(message, "message");
        this.message = message;
        this.throwable = th;
        this.threadName = str == null ? Thread.currentThread().getName() : str;
    }
}
