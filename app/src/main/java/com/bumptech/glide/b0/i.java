package com.bumptech.glide.b0;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class i {
    private static final Executor a = new g();
    private static final Executor b = new h();

    public static Executor a() {
        return b;
    }

    public static Executor b() {
        return a;
    }
}
