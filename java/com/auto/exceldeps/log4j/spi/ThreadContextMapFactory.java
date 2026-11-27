package com.auto.exceldeps.log4j.spi;

import com.auto.exceldeps.log4j.util.ProviderUtil;

/* loaded from: classes.dex */
public final class ThreadContextMapFactory {
    private ThreadContextMapFactory() {
    }

    public static ThreadContextMap createThreadContextMap() {
        return ProviderUtil.getProvider().getThreadContextMapInstance();
    }

    public static void init() {
        ProviderUtil.getProvider().getThreadContextMapInstance();
    }
}
