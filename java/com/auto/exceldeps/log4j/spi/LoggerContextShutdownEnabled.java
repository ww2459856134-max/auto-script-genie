package com.auto.exceldeps.log4j.spi;

import java.util.List;

/* loaded from: classes.dex */
public interface LoggerContextShutdownEnabled {
    void addShutdownListener(LoggerContextShutdownAware loggerContextShutdownAware);

    List<LoggerContextShutdownAware> getListeners();
}
