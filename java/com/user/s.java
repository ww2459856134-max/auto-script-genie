package com.user;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class s {
    private long a;
    private long b;
    private r c;

    s() {
    }

    private void a(r rVar, Runnable runnable, Runnable runnable2) {
        if (runnable != null) {
            rVar.b.add(runnable);
        }
        if (runnable2 != null) {
            rVar.c.add(runnable2);
        }
    }

    synchronized r b(long j2, boolean z, Runnable runnable, Runnable runnable2) {
        r rVar = this.c;
        if (rVar != null) {
            a(rVar, runnable, runnable2);
            return null;
        }
        if (f(j2) <= 0 && !z) {
            r rVar2 = new r(this.a);
            this.c = rVar2;
            a(rVar2, runnable, runnable2);
            return this.c;
        }
        return null;
    }

    synchronized void c(r rVar, Runnable runnable) {
        if (this.a == rVar.a) {
            runnable.run();
        }
    }

    synchronized List<Runnable> d(r rVar, boolean z, long j2) {
        if (!e(rVar)) {
            return new ArrayList();
        }
        this.c = null;
        this.b = z ? 0L : j2 + 30000;
        return new ArrayList(z ? rVar.b : rVar.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    synchronized boolean e(r rVar) {
        boolean z;
        if (this.c == rVar) {
            z = this.a == rVar.a;
        }
        return z;
    }

    synchronized long f(long j2) {
        return Math.max(0L, this.b - j2);
    }

    synchronized void g() {
        this.a++;
        this.c = null;
        this.b = 0L;
    }
}
