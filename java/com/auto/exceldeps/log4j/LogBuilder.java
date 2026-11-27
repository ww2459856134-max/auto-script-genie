package com.auto.exceldeps.log4j;

import com.auto.exceldeps.log4j.message.Message;
import com.auto.exceldeps.log4j.util.Supplier;

/* loaded from: classes.dex */
public interface LogBuilder {
    public static final LogBuilder NOOP = new LogBuilder() { // from class: com.auto.exceldeps.log4j.LogBuilder.1
    };

    default void log() {
    }

    default void log(Message message) {
    }

    default void log(Supplier<Message> supplier) {
    }

    default void log(CharSequence charSequence) {
    }

    default void log(Object obj) {
    }

    default void log(String str) {
    }

    default void log(String str, Object obj) {
    }

    default void log(String str, Object obj, Object obj2) {
    }

    default void log(String str, Object obj, Object obj2, Object obj3) {
    }

    default void log(String str, Object obj, Object obj2, Object obj3, Object obj4) {
    }

    default void log(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
    }

    default void log(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
    }

    default void log(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
    }

    default void log(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
    }

    default void log(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
    }

    default void log(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
    }

    default void log(String str, Supplier<?>... supplierArr) {
    }

    default void log(String str, Object... objArr) {
    }

    default Message logAndGet(Supplier<Message> supplier) {
        return null;
    }

    default LogBuilder withLocation() {
        return this;
    }

    default LogBuilder withLocation(StackTraceElement stackTraceElement) {
        return this;
    }

    default LogBuilder withMarker(Marker marker) {
        return this;
    }

    default LogBuilder withThrowable(Throwable th) {
        return this;
    }
}
