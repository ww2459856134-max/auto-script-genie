package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.util.PerformanceSensitive;
import com.auto.exceldeps.log4j.util.StringBuilders;

@PerformanceSensitive({"allocation"})
/* loaded from: classes.dex */
public class ReusableObjectMessage implements ReusableMessage, ParameterVisitable, Clearable {
    private static final long serialVersionUID = 6922476812535519960L;
    private transient Object obj;

    private Object writeReplace() {
        return memento();
    }

    @Override // com.auto.exceldeps.log4j.message.Clearable
    public void clear() {
        this.obj = null;
    }

    @Override // com.auto.exceldeps.log4j.message.ParameterVisitable
    public <S> void forEachParameter(ParameterConsumer<S> parameterConsumer, S s) {
        parameterConsumer.accept(this.obj, 0, s);
    }

    @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        StringBuilders.appendValue(sb, this.obj);
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormat() {
        Object obj = this.obj;
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormattedMessage() {
        return String.valueOf(this.obj);
    }

    public Object getParameter() {
        return this.obj;
    }

    @Override // com.auto.exceldeps.log4j.message.ReusableMessage
    public short getParameterCount() {
        return (short) 1;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Object[] getParameters() {
        return new Object[]{this.obj};
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Throwable getThrowable() {
        Object obj = this.obj;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    @Override // com.auto.exceldeps.log4j.message.ReusableMessage
    public Message memento() {
        return new ObjectMessage(this.obj);
    }

    public void set(Object obj) {
        this.obj = obj;
    }

    @Override // com.auto.exceldeps.log4j.message.ReusableMessage
    public Object[] swapParameters(Object[] objArr) {
        if (objArr.length != 0) {
            objArr[0] = this.obj;
            return objArr;
        }
        Object[] objArr2 = new Object[10];
        objArr2[0] = this.obj;
        return objArr2;
    }

    public String toString() {
        return getFormattedMessage();
    }
}
