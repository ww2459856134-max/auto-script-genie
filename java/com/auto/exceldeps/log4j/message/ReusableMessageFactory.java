package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.util.PerformanceSensitive;
import java.io.Serializable;

@PerformanceSensitive({"allocation"})
/* loaded from: classes.dex */
public final class ReusableMessageFactory implements MessageFactory2, Serializable {
    public static final ReusableMessageFactory INSTANCE = new ReusableMessageFactory();
    private static final long serialVersionUID = 1;
    private final transient ThreadLocal<ReusableParameterizedMessage> threadLocalParameterized = new ThreadLocal<>();
    private final transient ThreadLocal<ReusableSimpleMessage> threadLocalSimpleMessage = new ThreadLocal<>();
    private final transient ThreadLocal<ReusableObjectMessage> threadLocalObjectMessage = new ThreadLocal<>();

    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 1;

        private SerializationProxy() {
        }

        private Object readResolve() {
            return ReusableMessageFactory.INSTANCE;
        }
    }

    private ReusableObjectMessage getObject() {
        ReusableObjectMessage reusableObjectMessage = this.threadLocalObjectMessage.get();
        if (reusableObjectMessage != null) {
            return reusableObjectMessage;
        }
        ReusableObjectMessage reusableObjectMessage2 = new ReusableObjectMessage();
        this.threadLocalObjectMessage.set(reusableObjectMessage2);
        return reusableObjectMessage2;
    }

    private ReusableParameterizedMessage getParameterized() {
        ReusableParameterizedMessage reusableParameterizedMessage = this.threadLocalParameterized.get();
        if (reusableParameterizedMessage == null) {
            reusableParameterizedMessage = new ReusableParameterizedMessage();
            this.threadLocalParameterized.set(reusableParameterizedMessage);
        }
        if (reusableParameterizedMessage.reserved) {
            reusableParameterizedMessage = new ReusableParameterizedMessage();
        }
        return reusableParameterizedMessage.reserve();
    }

    private ReusableSimpleMessage getSimple() {
        ReusableSimpleMessage reusableSimpleMessage = this.threadLocalSimpleMessage.get();
        if (reusableSimpleMessage != null) {
            return reusableSimpleMessage;
        }
        ReusableSimpleMessage reusableSimpleMessage2 = new ReusableSimpleMessage();
        this.threadLocalSimpleMessage.set(reusableSimpleMessage2);
        return reusableSimpleMessage2;
    }

    public static void release(Message message) {
        if (message instanceof Clearable) {
            ((Clearable) message).clear();
        }
    }

    private Object writeReplace() {
        return new SerializationProxy();
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(CharSequence charSequence) {
        ReusableSimpleMessage simple = getSimple();
        simple.set(charSequence);
        return simple;
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory
    public Message newMessage(String str, Object... objArr) {
        return getParameterized().set(str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj) {
        return getParameterized().set(str, obj);
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2) {
        return getParameterized().set(str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3) {
        return getParameterized().set(str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return getParameterized().set(str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return getParameterized().set(str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return getParameterized().set(str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return getParameterized().set(str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return getParameterized().set(str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return getParameterized().set(str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return getParameterized().set(str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory
    public Message newMessage(String str) {
        ReusableSimpleMessage simple = getSimple();
        simple.set(str);
        return simple;
    }

    @Override // com.auto.exceldeps.log4j.message.MessageFactory
    public Message newMessage(Object obj) {
        ReusableObjectMessage object = getObject();
        object.set(obj);
        return object;
    }
}
