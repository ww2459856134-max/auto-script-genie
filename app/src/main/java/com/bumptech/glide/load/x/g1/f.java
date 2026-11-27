package com.bumptech.glide.load.x.g1;

import com.bumptech.glide.load.x.g1.t;
import java.util.Queue;

/* loaded from: classes.dex */
abstract class f<T extends t> {
    private final Queue<T> a = com.bumptech.glide.b0.p.e(20);

    f() {
    }

    abstract T a();

    T b() {
        T tPoll = this.a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }

    public void c(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }
}
