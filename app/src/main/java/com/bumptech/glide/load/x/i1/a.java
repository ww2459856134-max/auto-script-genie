package com.bumptech.glide.load.x.i1;

import android.text.TextUtils;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a {
    private final boolean a;
    private int b;
    private int c;
    private e d = e.b;
    private String e;
    private long f;

    a(boolean z) {
        this.a = z;
    }

    public f a() {
        if (TextUtils.isEmpty(this.e)) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.e);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.c, this.f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new c(this.e, this.d, this.a));
        if (this.f != 0) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return new f(threadPoolExecutor);
    }

    public a b(String str) {
        this.e = str;
        return this;
    }

    public a c(int i2) {
        this.b = i2;
        this.c = i2;
        return this;
    }
}
