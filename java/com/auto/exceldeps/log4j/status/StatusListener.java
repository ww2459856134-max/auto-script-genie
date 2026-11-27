package com.auto.exceldeps.log4j.status;

import com.auto.exceldeps.log4j.Level;
import java.io.Closeable;
import java.util.EventListener;

/* loaded from: classes.dex */
public interface StatusListener extends Closeable, EventListener {
    Level getStatusLevel();

    void log(StatusData statusData);
}
