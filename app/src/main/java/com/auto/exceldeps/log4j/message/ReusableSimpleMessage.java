package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.util.Constants;
import com.auto.exceldeps.log4j.util.PerformanceSensitive;

@PerformanceSensitive({"allocation"})
/* loaded from: classes.dex */
public class ReusableSimpleMessage implements ReusableMessage, CharSequence, ParameterVisitable, Clearable {
    private static final long serialVersionUID = -9199974506498249809L;
    private CharSequence charSequence;

    private Object writeReplace() {
        return memento();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.charSequence.charAt(i2);
    }

    @Override // com.auto.exceldeps.log4j.message.Clearable
    public void clear() {
        this.charSequence = null;
    }

    @Override // com.auto.exceldeps.log4j.message.ParameterVisitable
    public <S> void forEachParameter(ParameterConsumer<S> parameterConsumer, S s) {
    }

    @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        sb.append(this.charSequence);
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormat() {
        CharSequence charSequence = this.charSequence;
        if (charSequence instanceof String) {
            return (String) charSequence;
        }
        return null;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormattedMessage() {
        return String.valueOf(this.charSequence);
    }

    @Override // com.auto.exceldeps.log4j.message.ReusableMessage
    public short getParameterCount() {
        return (short) 0;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Object[] getParameters() {
        return Constants.EMPTY_OBJECT_ARRAY;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Throwable getThrowable() {
        return null;
    }

    @Override // java.lang.CharSequence
    public int length() {
        CharSequence charSequence = this.charSequence;
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    @Override // com.auto.exceldeps.log4j.message.ReusableMessage
    public Message memento() {
        return new SimpleMessage(this.charSequence);
    }

    public void set(String str) {
        this.charSequence = str;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return this.charSequence.subSequence(i2, i3);
    }

    @Override // com.auto.exceldeps.log4j.message.ReusableMessage
    public Object[] swapParameters(Object[] objArr) {
        return objArr;
    }

    public void set(CharSequence charSequence) {
        this.charSequence = charSequence;
    }
}
