package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.message.ParameterFormatter;
import com.auto.exceldeps.log4j.util.Constants;
import com.auto.exceldeps.log4j.util.StringBuilderFormattable;
import com.auto.exceldeps.log4j.util.StringBuilders;
import com.auto.exceldeps.log4j.util.internal.SerializationUtil;
import com.google.errorprone.annotations.InlineMe;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public class ParameterizedMessage implements Message, StringBuilderFormattable {
    public static final String ERROR_MSG_SEPARATOR = ":";
    public static final String ERROR_PREFIX = "[!!!";
    public static final String ERROR_SEPARATOR = "=>";
    public static final String ERROR_SUFFIX = "!!!]";
    private static final ThreadLocal<FormatBufferHolder> FORMAT_BUFFER_HOLDER_REF;
    public static final String RECURSION_PREFIX = "[...";
    public static final String RECURSION_SUFFIX = "...]";
    private static final long serialVersionUID = -665975803997290697L;
    private transient Object[] args;
    private String formattedMessage;
    private final String pattern;
    private final ParameterFormatter.MessagePatternAnalysis patternAnalysis;
    private final transient Throwable throwable;

    /* JADX INFO: Access modifiers changed from: private */
    static final class FormatBufferHolder {
        private final StringBuilder buffer;
        private boolean used;

        private FormatBufferHolder() {
            this.buffer = new StringBuilder(Constants.MAX_REUSABLE_MESSAGE_SIZE);
            this.used = false;
        }
    }

    static {
        FORMAT_BUFFER_HOLDER_REF = Constants.ENABLE_THREADLOCALS ? ThreadLocal.withInitial(new Supplier() { // from class: com.auto.exceldeps.log4j.message.c
            @Override // java.util.function.Supplier
            public final Object get() {
                return ParameterizedMessage.b();
            }
        }) : null;
    }

    @InlineMe(imports = {"java.util.Arrays"}, replacement = "this(pattern, Arrays.stream(args).toArray(Object[]::new), throwable)")
    @Deprecated
    public ParameterizedMessage(String str, String[] strArr, Throwable th) {
        this(str, Arrays.stream(strArr).toArray(new IntFunction() { // from class: com.auto.exceldeps.log4j.message.d
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return ParameterizedMessage.a(i2);
            }
        }), th);
    }

    static /* synthetic */ Object[] a(int i2) {
        return new Object[i2];
    }

    static /* synthetic */ FormatBufferHolder b() {
        return new FormatBufferHolder();
    }

    public static int countArgumentPlaceholders(String str) {
        if (str == null) {
            return 0;
        }
        return ParameterFormatter.analyzePattern(str, -1).placeholderCount;
    }

    public static String deepToString(Object obj) {
        return ParameterFormatter.deepToString(obj);
    }

    private static Throwable determineThrowable(Throwable th, Object[] objArr, ParameterFormatter.MessagePatternAnalysis messagePatternAnalysis) {
        if (th != null) {
            return th;
        }
        if (objArr == null || objArr.length <= messagePatternAnalysis.placeholderCount) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    public static String format(String str, Object[] objArr) {
        return ParameterFormatter.format(str, objArr, objArr != null ? objArr.length : 0);
    }

    public static String identityToString(Object obj) {
        return ParameterFormatter.identityToString(obj);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        SerializationUtil.assertFiltered(objectInputStream);
        objectInputStream.defaultReadObject();
        this.args = new Object[objectInputStream.readInt()];
        int i2 = 0;
        while (true) {
            Object[] objArr = this.args;
            if (i2 >= objArr.length) {
                return;
            }
            objArr[i2] = SerializationUtil.readWrappedObject(objectInputStream);
            i2++;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.args.length);
        for (Object obj : this.args) {
            SerializationUtil.writeWrappedObject(obj instanceof Serializable ? (Serializable) obj : String.valueOf(obj), objectOutputStream);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParameterizedMessage)) {
            return false;
        }
        ParameterizedMessage parameterizedMessage = (ParameterizedMessage) obj;
        return Objects.equals(this.pattern, parameterizedMessage.pattern) && Arrays.equals(this.args, parameterizedMessage.args);
    }

    @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        String str = this.formattedMessage;
        if (str != null) {
            sb.append(str);
        } else {
            Object[] objArr = this.args;
            ParameterFormatter.formatMessage(sb, this.pattern, objArr, objArr != null ? objArr.length : 0, this.patternAnalysis);
        }
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormat() {
        return this.pattern;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    @Override // com.auto.exceldeps.log4j.message.Message
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getFormattedMessage() {
        if (this.formattedMessage == null) {
            ThreadLocal<FormatBufferHolder> threadLocal = FORMAT_BUFFER_HOLDER_REF;
            if (threadLocal != null) {
                FormatBufferHolder formatBufferHolder = threadLocal.get();
                if (formatBufferHolder.used) {
                    StringBuilder sb = new StringBuilder(Constants.MAX_REUSABLE_MESSAGE_SIZE);
                    formatTo(sb);
                    this.formattedMessage = sb.toString();
                } else {
                    formatBufferHolder.used = true;
                    StringBuilder sb2 = formatBufferHolder.buffer;
                    try {
                        formatTo(sb2);
                        this.formattedMessage = sb2.toString();
                    } finally {
                        StringBuilders.trimToMaxSize(sb2, Constants.MAX_REUSABLE_MESSAGE_SIZE);
                        sb2.setLength(0);
                        formatBufferHolder.used = false;
                    }
                }
            }
        }
        return this.formattedMessage;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Object[] getParameters() {
        return this.args;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        String str = this.pattern;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Object[] objArr = this.args;
        return iHashCode + (objArr != null ? Arrays.hashCode(objArr) : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParameterizedMessage[messagePattern=");
        sb.append(this.pattern);
        sb.append(", argCount=");
        sb.append(this.args.length);
        sb.append(", throwableProvided=");
        sb.append(this.throwable != null);
        sb.append(']');
        return sb.toString();
    }

    public ParameterizedMessage(String str, Object[] objArr, Throwable th) {
        this.args = objArr;
        this.pattern = str;
        ParameterFormatter.MessagePatternAnalysis messagePatternAnalysisAnalyzePattern = ParameterFormatter.analyzePattern(str, objArr != null ? objArr.length : 0);
        this.patternAnalysis = messagePatternAnalysisAnalyzePattern;
        this.throwable = determineThrowable(th, this.args, messagePatternAnalysisAnalyzePattern);
    }

    public ParameterizedMessage(String str, Object... objArr) {
        this(str, objArr, (Throwable) null);
    }

    public ParameterizedMessage(String str, Object obj) {
        this(str, obj);
    }

    public ParameterizedMessage(String str, Object obj, Object obj2) {
        this(str, obj, obj2);
    }
}
