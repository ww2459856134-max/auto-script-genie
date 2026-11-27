package com.auto.exceldeps.log4j.message;

/* loaded from: classes.dex */
public interface MultiformatMessage extends Message {
    String[] getFormats();

    String getFormattedMessage(String[] strArr);
}
