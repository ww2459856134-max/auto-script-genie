package androidx.lifecycle;

import androidx.lifecycle.f;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: j, reason: collision with root package name */
    static final Object f285j = new Object();
    final Object a = new Object();
    private h.b.a.b.e<o<? super T>, LiveData<T>.b> b = new h.b.a.b.e<>();
    int c = 0;
    private boolean d;
    private volatile Object e;
    volatile Object f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f286h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f287i;

    class LifecycleBoundObserver extends LiveData<T>.b implements g {
        final i e;
        final /* synthetic */ LiveData f;

        @Override // androidx.lifecycle.g
        public void a(i iVar, f.a aVar) {
            f.b bVarB = this.e.o().b();
            if (bVarB == f.b.DESTROYED) {
                this.f.h(this.a);
                return;
            }
            f.b bVar = null;
            while (bVar != bVarB) {
                h(j());
                bVar = bVarB;
                bVarB = this.e.o().b();
            }
        }

        @Override // androidx.lifecycle.LiveData.b
        void i() {
            this.e.o().c(this);
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean j() {
            return this.e.o().b().a(f.b.STARTED);
        }
    }

    private class a extends LiveData<T>.b {
        a(LiveData liveData, o<? super T> oVar) {
            super(oVar);
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean j() {
            return true;
        }
    }

    private abstract class b {
        final o<? super T> a;
        boolean b;
        int c = -1;

        b(o<? super T> oVar) {
            this.a = oVar;
        }

        void h(boolean z) {
            if (z == this.b) {
                return;
            }
            this.b = z;
            LiveData.this.b(z ? 1 : -1);
            if (this.b) {
                LiveData.this.d(this);
            }
        }

        void i() {
        }

        abstract boolean j();
    }

    public LiveData() {
        Object obj = f285j;
        this.f = obj;
        this.e = obj;
        this.g = -1;
    }

    static void a(String str) {
        if (h.b.a.a.a.b().a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void c(LiveData<T>.b bVar) {
        if (bVar.b) {
            if (!bVar.j()) {
                bVar.h(false);
                return;
            }
            int i2 = bVar.c;
            int i3 = this.g;
            if (i2 >= i3) {
                return;
            }
            bVar.c = i3;
            bVar.a.a((Object) this.e);
        }
    }

    void b(int i2) {
        int i3 = this.c;
        this.c = i2 + i3;
        if (this.d) {
            return;
        }
        this.d = true;
        while (true) {
            try {
                int i4 = this.c;
                if (i3 == i4) {
                    return;
                }
                boolean z = i3 == 0 && i4 > 0;
                boolean z2 = i3 > 0 && i4 == 0;
                if (z) {
                    f();
                } else if (z2) {
                    g();
                }
                i3 = i4;
            } finally {
                this.d = false;
            }
        }
    }

    void d(LiveData<T>.b bVar) {
        if (this.f286h) {
            this.f287i = true;
            return;
        }
        this.f286h = true;
        do {
            this.f287i = false;
            if (bVar != null) {
                c(bVar);
                bVar = null;
            } else {
                h.b.a.b.e<o<? super T>, LiveData<T>.b>.a aVarG = this.b.g();
                while (aVarG.hasNext()) {
                    c((b) aVarG.next().getValue());
                    if (this.f287i) {
                        break;
                    }
                }
            }
        } while (this.f287i);
        this.f286h = false;
    }

    public void e(o<? super T> oVar) {
        a("observeForever");
        a aVar = new a(this, oVar);
        LiveData<T>.b bVarK = this.b.k(oVar, aVar);
        if (bVarK instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (bVarK != null) {
            return;
        }
        aVar.h(true);
    }

    protected void f() {
    }

    protected void g() {
    }

    public void h(o<? super T> oVar) {
        a("removeObserver");
        LiveData<T>.b bVarL = this.b.l(oVar);
        if (bVarL == null) {
            return;
        }
        bVarL.i();
        bVarL.h(false);
    }

    protected void i(T t) {
        a("setValue");
        this.g++;
        this.e = t;
        d(null);
    }
}
