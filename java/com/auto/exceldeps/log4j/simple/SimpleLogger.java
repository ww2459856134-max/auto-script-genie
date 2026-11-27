package com.auto.exceldeps.log4j.simple;

import com.auto.exceldeps.log4j.Level;
import com.auto.exceldeps.log4j.Marker;
import com.auto.exceldeps.log4j.ThreadContext;
import com.auto.exceldeps.log4j.message.Message;
import com.auto.exceldeps.log4j.message.MessageFactory;
import com.auto.exceldeps.log4j.spi.AbstractLogger;
import com.auto.exceldeps.log4j.util.PropertiesUtil;
import com.auto.exceldeps.log4j.util.Strings;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* loaded from: classes.dex */
public class SimpleLogger extends AbstractLogger {
    private static final char SPACE = ' ';
    private static final long serialVersionUID = 1;
    private final DateFormat dateFormatter;
    private Level level;
    private final String logName;
    private final boolean showContextMap;
    private final boolean showDateTime;
    private PrintStream stream;

    public SimpleLogger(String str, Level level, boolean z, boolean z2, boolean z3, boolean z4, String str2, MessageFactory messageFactory, PropertiesUtil propertiesUtil, PrintStream printStream) {
        SimpleDateFormat simpleDateFormat;
        super(str, messageFactory);
        this.level = Level.toLevel(propertiesUtil.getStringProperty("com.auto.exceldeps.log4j.simplelog." + str + ".level"), level);
        if (z2) {
            int iLastIndexOf = str.lastIndexOf(".");
            if (iLastIndexOf <= 0 || iLastIndexOf >= str.length()) {
                this.logName = str;
            } else {
                this.logName = str.substring(iLastIndexOf + 1);
            }
        } else if (z) {
            this.logName = str;
        } else {
            this.logName = null;
        }
        this.showDateTime = z3;
        this.showContextMap = z4;
        this.stream = printStream;
        if (!z3) {
            this.dateFormatter = null;
            return;
        }
        try {
            simpleDateFormat = new SimpleDateFormat(str2);
        } catch (IllegalArgumentException unused) {
            simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS zzz");
        }
        this.dateFormatter = simpleDateFormat;
    }

    @Override // com.auto.exceldeps.log4j.Logger
    public Level getLevel() {
        return this.level;
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, Message message, Throwable th) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    @SuppressFBWarnings(justification = "Log4j prints stacktraces only to logs, which should be private.", value = {"INFORMATION_EXPOSURE_THROUGH_AN_ERROR_MESSAGE"})
    public void logMessage(String str, Level level, Marker marker, Message message, Throwable th) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (this.showDateTime) {
            Date date = new Date();
            synchronized (this.dateFormatter) {
                str2 = this.dateFormatter.format(date);
            }
            sb.append(str2);
            sb.append(' ');
        }
        sb.append(level.toString());
        sb.append(' ');
        if (Strings.isNotEmpty(this.logName)) {
            sb.append(this.logName);
            sb.append(' ');
        }
        sb.append(message.getFormattedMessage());
        if (this.showContextMap) {
            Map<String, String> immutableContext = ThreadContext.getImmutableContext();
            if (immutableContext.size() > 0) {
                sb.append(' ');
                sb.append(immutableContext.toString());
                sb.append(' ');
            }
        }
        Object[] parameters = message.getParameters();
        if (th == null && parameters != null && parameters.length > 0 && (parameters[parameters.length - 1] instanceof Throwable)) {
            th = (Throwable) parameters[parameters.length - 1];
        }
        this.stream.println(sb.toString());
        if (th != null) {
            this.stream.print(' ');
            th.printStackTrace(this.stream);
        }
    }

    public void setLevel(Level level) {
        if (level != null) {
            this.level = level;
        }
    }

    public void setStream(PrintStream printStream) {
        this.stream = printStream;
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, CharSequence charSequence, Throwable th) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, Object obj, Throwable th) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object... objArr) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return this.level.intLevel() >= level.intLevel();
    }

    @Override // com.auto.exceldeps.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Throwable th) {
        return this.level.intLevel() >= level.intLevel();
    }
}
