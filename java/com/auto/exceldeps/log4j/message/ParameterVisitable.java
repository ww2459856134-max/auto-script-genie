package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.util.PerformanceSensitive;

@PerformanceSensitive({"allocation"})
/* loaded from: classes.dex */
public interface ParameterVisitable {
    <S> void forEachParameter(ParameterConsumer<S> parameterConsumer, S s);
}
