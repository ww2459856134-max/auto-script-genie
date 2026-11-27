package com.auto.exceldeps.log4j.message;

/* loaded from: classes.dex */
public interface MessageFactory {
    Message newMessage(Object obj);

    Message newMessage(String str);

    Message newMessage(String str, Object... objArr);
}
