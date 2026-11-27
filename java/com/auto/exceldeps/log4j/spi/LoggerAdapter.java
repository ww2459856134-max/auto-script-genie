package com.auto.exceldeps.log4j.spi;

import java.io.Closeable;

/* loaded from: classes.dex */
public interface LoggerAdapter<L> extends Closeable {
    L getLogger(String str);
}
