package com.bumptech.glide.load.x.h1;

import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes.dex */
class f {
    private final Queue<e> a = new ArrayDeque();

    f() {
    }

    e a() {
        e eVarPoll;
        synchronized (this.a) {
            eVarPoll = this.a.poll();
        }
        return eVarPoll == null ? new e() : eVarPoll;
    }

    void b(e eVar) {
        synchronized (this.a) {
            if (this.a.size() < 10) {
                this.a.offer(eVar);
            }
        }
    }
}
