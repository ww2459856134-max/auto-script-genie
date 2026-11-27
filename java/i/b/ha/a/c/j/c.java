package i.b.ha.a.c.j;

import i.b.ha.a.c.j.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c<T extends c<T>> extends h<e, T> {

    /* renamed from: j, reason: collision with root package name */
    private long f1474j;

    /* renamed from: k, reason: collision with root package name */
    private long f1475k = -1;

    /* renamed from: l, reason: collision with root package name */
    private i.b.ha.a.c.i.l<Long, Long> f1476l = i.b.ha.a.c.i.l.a();

    /* renamed from: m, reason: collision with root package name */
    private boolean f1477m = true;

    c() {
    }

    long s() {
        return this.f1474j;
    }

    long t() {
        return this.f1475k;
    }

    i.b.ha.a.c.i.l<Long, Long> u() {
        return this.f1476l;
    }

    boolean v() {
        return this.f1477m;
    }

    public T w(long j2) {
        this.f1475k = Math.max(-1L, j2);
        c();
        return this;
    }

    public T x(boolean z) {
        this.f1477m = z;
        c();
        return this;
    }
}
