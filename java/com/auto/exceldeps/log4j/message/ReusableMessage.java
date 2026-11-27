package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.util.PerformanceSensitive;
import com.auto.exceldeps.log4j.util.StringBuilderFormattable;

@PerformanceSensitive({"allocation"})
/* loaded from: classes.dex */
public interface ReusableMessage extends Message, StringBuilderFormattable {
    short getParameterCount();

    Message memento();

    Object[] swapParameters(Object[] objArr);
}
