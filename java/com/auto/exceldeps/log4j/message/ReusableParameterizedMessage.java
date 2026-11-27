package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.message.ParameterFormatter;
import com.auto.exceldeps.log4j.util.Constants;
import com.auto.exceldeps.log4j.util.PerformanceSensitive;
import com.auto.exceldeps.log4j.util.StringBuilders;
import java.util.Arrays;

@PerformanceSensitive({"allocation"})
/* loaded from: classes.dex */
public class ReusableParameterizedMessage implements ReusableMessage, ParameterVisitable, Clearable {
    private static final int MAX_PARAMS = 10;
    private static final long serialVersionUID = 7800075879295123856L;
    private int argCount;
    private String messagePattern;
    private transient Throwable throwable;
    private transient Object[] varargs;
    private final ParameterFormatter.MessagePatternAnalysis patternAnalysis = new ParameterFormatter.MessagePatternAnalysis();
    private final StringBuilder formatBuffer = new StringBuilder(Constants.MAX_REUSABLE_MESSAGE_SIZE);
    private transient Object[] params = new Object[10];
    transient boolean reserved = false;

    private static Throwable determineThrowable(Object[] objArr, int i2, int i3) {
        if (i3 >= i2) {
            return null;
        }
        Object obj = objArr[i2 - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    private Object[] getParams() {
        Object[] objArr = this.varargs;
        return objArr == null ? this.params : objArr;
    }

    private Object[] getTrimmedParams() {
        Object[] objArr = this.varargs;
        return objArr == null ? Arrays.copyOf(this.params, this.argCount) : objArr;
    }

    private void init(String str, int i2, Object[] objArr) {
        this.varargs = null;
        this.messagePattern = str;
        this.argCount = i2;
        ParameterFormatter.analyzePattern(str, i2, this.patternAnalysis);
        this.throwable = determineThrowable(objArr, i2, this.patternAnalysis.placeholderCount);
    }

    private Object writeReplace() {
        return memento();
    }

    @Override // com.auto.exceldeps.log4j.message.Clearable
    public void clear() {
        this.reserved = false;
        this.varargs = null;
        this.messagePattern = null;
        this.throwable = null;
        ParameterFormatter.MessagePatternAnalysis messagePatternAnalysis = this.patternAnalysis;
        int[] iArr = messagePatternAnalysis.placeholderCharIndices;
        if (iArr == null || iArr.length <= 16) {
            return;
        }
        messagePatternAnalysis.placeholderCharIndices = new int[16];
    }

    @Override // com.auto.exceldeps.log4j.message.ParameterVisitable
    public <S> void forEachParameter(ParameterConsumer<S> parameterConsumer, S s) {
        Object[] params = getParams();
        for (short s2 = 0; s2 < this.argCount; s2 = (short) (s2 + 1)) {
            parameterConsumer.accept(params[s2], s2, s);
        }
    }

    @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        ParameterFormatter.formatMessage(sb, this.messagePattern, getParams(), this.argCount, this.patternAnalysis);
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormat() {
        return this.messagePattern;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormattedMessage() {
        try {
            formatTo(this.formatBuffer);
            return this.formatBuffer.toString();
        } finally {
            StringBuilders.trimToMaxSize(this.formatBuffer, Constants.MAX_REUSABLE_MESSAGE_SIZE);
            this.formatBuffer.setLength(0);
        }
    }

    @Override // com.auto.exceldeps.log4j.message.ReusableMessage
    public short getParameterCount() {
        return (short) this.argCount;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Object[] getParameters() {
        return getTrimmedParams();
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Throwable getThrowable() {
        return this.throwable;
    }

    @Override // com.auto.exceldeps.log4j.message.ReusableMessage
    public Message memento() {
        return new ParameterizedMessage(this.messagePattern, getTrimmedParams());
    }

    ReusableParameterizedMessage reserve() {
        this.reserved = true;
        return this;
    }

    public ReusableParameterizedMessage set(String str, Object... objArr) {
        init(str, objArr == null ? 0 : objArr.length, objArr);
        this.varargs = objArr;
        return this;
    }

    @Override // com.auto.exceldeps.log4j.message.ReusableMessage
    public Object[] swapParameters(Object[] objArr) {
        Object[] objArr2 = this.varargs;
        if (objArr2 != null) {
            int i2 = this.argCount;
            if (i2 > objArr.length) {
                objArr = new Object[i2];
            }
            System.arraycopy(objArr2, 0, objArr, 0, i2);
            return objArr;
        }
        Object[] objArr3 = this.params;
        if (objArr.length >= 10) {
            this.params = objArr;
        } else {
            int i3 = this.argCount;
            if (i3 <= objArr.length) {
                System.arraycopy(objArr3, 0, objArr, 0, i3);
                for (int i4 = 0; i4 < this.argCount; i4++) {
                    this.params[i4] = null;
                }
                return objArr;
            }
            this.params = new Object[10];
        }
        return objArr3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReusableParameterizedMessage[messagePattern=");
        sb.append(getFormat());
        sb.append(", argCount=");
        sb.append((int) getParameterCount());
        sb.append(", throwableProvided=");
        sb.append(getThrowable() != null);
        sb.append(']');
        return sb.toString();
    }

    public ReusableParameterizedMessage set(String str, Object obj) {
        Object[] objArr = this.params;
        objArr[0] = obj;
        init(str, 1, objArr);
        return this;
    }

    public ReusableParameterizedMessage set(String str, Object obj, Object obj2) {
        Object[] objArr = this.params;
        objArr[0] = obj;
        objArr[1] = obj2;
        init(str, 2, objArr);
        return this;
    }

    public ReusableParameterizedMessage set(String str, Object obj, Object obj2, Object obj3) {
        Object[] objArr = this.params;
        objArr[0] = obj;
        objArr[1] = obj2;
        objArr[2] = obj3;
        init(str, 3, objArr);
        return this;
    }

    public ReusableParameterizedMessage set(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        Object[] objArr = this.params;
        objArr[0] = obj;
        objArr[1] = obj2;
        objArr[2] = obj3;
        objArr[3] = obj4;
        init(str, 4, objArr);
        return this;
    }

    public ReusableParameterizedMessage set(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object[] objArr = this.params;
        objArr[0] = obj;
        objArr[1] = obj2;
        objArr[2] = obj3;
        objArr[3] = obj4;
        objArr[4] = obj5;
        init(str, 5, objArr);
        return this;
    }

    public ReusableParameterizedMessage set(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] objArr = this.params;
        objArr[0] = obj;
        objArr[1] = obj2;
        objArr[2] = obj3;
        objArr[3] = obj4;
        objArr[4] = obj5;
        objArr[5] = obj6;
        init(str, 6, objArr);
        return this;
    }

    public ReusableParameterizedMessage set(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        Object[] objArr = this.params;
        objArr[0] = obj;
        objArr[1] = obj2;
        objArr[2] = obj3;
        objArr[3] = obj4;
        objArr[4] = obj5;
        objArr[5] = obj6;
        objArr[6] = obj7;
        init(str, 7, objArr);
        return this;
    }

    public ReusableParameterizedMessage set(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        Object[] objArr = this.params;
        objArr[0] = obj;
        objArr[1] = obj2;
        objArr[2] = obj3;
        objArr[3] = obj4;
        objArr[4] = obj5;
        objArr[5] = obj6;
        objArr[6] = obj7;
        objArr[7] = obj8;
        init(str, 8, objArr);
        return this;
    }

    public ReusableParameterizedMessage set(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        Object[] objArr = this.params;
        objArr[0] = obj;
        objArr[1] = obj2;
        objArr[2] = obj3;
        objArr[3] = obj4;
        objArr[4] = obj5;
        objArr[5] = obj6;
        objArr[6] = obj7;
        objArr[7] = obj8;
        objArr[8] = obj9;
        init(str, 9, objArr);
        return this;
    }

    public ReusableParameterizedMessage set(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        Object[] objArr = this.params;
        objArr[0] = obj;
        objArr[1] = obj2;
        objArr[2] = obj3;
        objArr[3] = obj4;
        objArr[4] = obj5;
        objArr[5] = obj6;
        objArr[6] = obj7;
        objArr[7] = obj8;
        objArr[8] = obj9;
        objArr[9] = obj10;
        init(str, 10, objArr);
        return this;
    }
}
