package com.auto.exceldeps.log4j.spi;

import com.auto.exceldeps.log4j.Level;
import com.auto.exceldeps.log4j.Marker;
import com.auto.exceldeps.log4j.message.Message;

/* loaded from: classes.dex */
public interface LocationAwareLogger {
    void logMessage(Level level, Marker marker, String str, StackTraceElement stackTraceElement, Message message, Throwable th);
}
