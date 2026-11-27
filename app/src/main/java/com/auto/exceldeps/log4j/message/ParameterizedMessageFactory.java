package com.auto.exceldeps.log4j.message;

/* loaded from: classes.dex */
public final class ParameterizedMessageFactory extends AbstractMessageFactory {
    public static final ParameterizedMessageFactory INSTANCE = new ParameterizedMessageFactory();
    private static final long serialVersionUID = -8970940216592525651L;

    @Override // com.auto.exceldeps.log4j.message.MessageFactory
    public Message newMessage(String str, Object... objArr) {
        return new ParameterizedMessage(str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.message.AbstractMessageFactory, com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj) {
        return new ParameterizedMessage(str, obj);
    }

    @Override // com.auto.exceldeps.log4j.message.AbstractMessageFactory, com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2) {
        return new ParameterizedMessage(str, obj, obj2);
    }

    @Override // com.auto.exceldeps.log4j.message.AbstractMessageFactory, com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3) {
        return new ParameterizedMessage(str, obj, obj2, obj3);
    }

    @Override // com.auto.exceldeps.log4j.message.AbstractMessageFactory, com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return new ParameterizedMessage(str, obj, obj2, obj3, obj4);
    }

    @Override // com.auto.exceldeps.log4j.message.AbstractMessageFactory, com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return new ParameterizedMessage(str, obj, obj2, obj3, obj4, obj5);
    }

    @Override // com.auto.exceldeps.log4j.message.AbstractMessageFactory, com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return new ParameterizedMessage(str, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // com.auto.exceldeps.log4j.message.AbstractMessageFactory, com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return new ParameterizedMessage(str, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // com.auto.exceldeps.log4j.message.AbstractMessageFactory, com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return new ParameterizedMessage(str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // com.auto.exceldeps.log4j.message.AbstractMessageFactory, com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return new ParameterizedMessage(str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // com.auto.exceldeps.log4j.message.AbstractMessageFactory, com.auto.exceldeps.log4j.message.MessageFactory2
    public Message newMessage(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return new ParameterizedMessage(str, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }
}
