package com.auto.exceldeps.log4j.message;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface Message extends Serializable {
    @Deprecated
    default String getFormat() {
        return null;
    }

    String getFormattedMessage();

    Object[] getParameters();

    Throwable getThrowable();
}
