package com.auto.exceldeps.log4j.simple;

import com.auto.exceldeps.log4j.spi.LoggerContext;
import com.auto.exceldeps.log4j.spi.LoggerContextFactory;
import java.net.URI;

/* loaded from: classes.dex */
public class SimpleLoggerContextFactory implements LoggerContextFactory {
    public static final SimpleLoggerContextFactory INSTANCE = new SimpleLoggerContextFactory();

    @Override // com.auto.exceldeps.log4j.spi.LoggerContextFactory
    public LoggerContext getContext(String str, ClassLoader classLoader, Object obj, boolean z) {
        return SimpleLoggerContext.INSTANCE;
    }

    @Override // com.auto.exceldeps.log4j.spi.LoggerContextFactory
    public boolean isClassLoaderDependent() {
        return false;
    }

    @Override // com.auto.exceldeps.log4j.spi.LoggerContextFactory
    public void removeContext(LoggerContext loggerContext) {
    }

    @Override // com.auto.exceldeps.log4j.spi.LoggerContextFactory
    public LoggerContext getContext(String str, ClassLoader classLoader, Object obj, boolean z, URI uri, String str2) {
        return SimpleLoggerContext.INSTANCE;
    }
}
