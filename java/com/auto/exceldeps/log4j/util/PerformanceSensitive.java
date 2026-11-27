package com.auto.exceldeps.log4j.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface PerformanceSensitive {
    String[] value() default {""};
}
