package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.message.MultiformatMessage;

/* loaded from: classes.dex */
public interface MultiFormatStringBuilderFormattable extends MultiformatMessage, StringBuilderFormattable {
    void formatTo(String[] strArr, StringBuilder sb);
}
