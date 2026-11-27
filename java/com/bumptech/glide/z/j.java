package com.bumptech.glide.z;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.b0.p;
import com.bumptech.glide.b0.q.l;
import com.bumptech.glide.load.x.h0;
import com.bumptech.glide.load.x.i0;
import com.bumptech.glide.load.x.t0;
import com.bumptech.glide.load.x.z0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class j<R> implements c, com.bumptech.glide.z.l.g, h {
    private static final boolean D = Log.isLoggable("Request", 2);
    private int A;
    private boolean B;
    private RuntimeException C;
    private final String a;
    private final l b;
    private final Object c;
    private final f<R> d;
    private final e e;
    private final Context f;
    private final com.bumptech.glide.f g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f710h;

    /* renamed from: i, reason: collision with root package name */
    private final Class<R> f711i;

    /* renamed from: j, reason: collision with root package name */
    private final a<?> f712j;

    /* renamed from: k, reason: collision with root package name */
    private final int f713k;

    /* renamed from: l, reason: collision with root package name */
    private final int f714l;

    /* renamed from: m, reason: collision with root package name */
    private final com.bumptech.glide.h f715m;

    /* renamed from: n, reason: collision with root package name */
    private final com.bumptech.glide.z.l.h<R> f716n;

    /* renamed from: o, reason: collision with root package name */
    private final List<f<R>> f717o;
    private final com.bumptech.glide.z.m.e<? super R> p;
    private final Executor q;
    private z0<R> r;
    private h0 s;
    private long t;
    private volatile i0 u;
    private i v;
    private Drawable w;
    private Drawable x;
    private Drawable y;
    private int z;

    private j(Context context, com.bumptech.glide.f fVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, com.bumptech.glide.h hVar, com.bumptech.glide.z.l.h<R> hVar2, f<R> fVar2, List<f<R>> list, e eVar, i0 i0Var, com.bumptech.glide.z.m.e<? super R> eVar2, Executor executor) {
        this.a = D ? String.valueOf(super.hashCode()) : null;
        this.b = l.a();
        this.c = obj;
        this.f = context;
        this.g = fVar;
        this.f710h = obj2;
        this.f711i = cls;
        this.f712j = aVar;
        this.f713k = i2;
        this.f714l = i3;
        this.f715m = hVar;
        this.f716n = hVar2;
        this.d = fVar2;
        this.f717o = list;
        this.e = eVar;
        this.u = i0Var;
        this.p = eVar2;
        this.q = executor;
        this.v = i.PENDING;
        if (this.C == null && fVar.i()) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    private void A() {
        if (l()) {
            Drawable drawableP = this.f710h == null ? p() : null;
            if (drawableP == null) {
                drawableP = o();
            }
            if (drawableP == null) {
                drawableP = q();
            }
            this.f716n.j(drawableP);
        }
    }

    private void i() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean j() {
        e eVar = this.e;
        return eVar == null || eVar.l(this);
    }

    private boolean l() {
        e eVar = this.e;
        return eVar == null || eVar.e(this);
    }

    private boolean m() {
        e eVar = this.e;
        return eVar == null || eVar.i(this);
    }

    private void n() {
        i();
        this.b.c();
        this.f716n.c(this);
        h0 h0Var = this.s;
        if (h0Var != null) {
            h0Var.a();
            this.s = null;
        }
    }

    private Drawable o() {
        if (this.w == null) {
            Drawable drawableK = this.f712j.k();
            this.w = drawableK;
            if (drawableK == null && this.f712j.j() > 0) {
                this.w = s(this.f712j.j());
            }
        }
        return this.w;
    }

    private Drawable p() {
        if (this.y == null) {
            Drawable drawableL = this.f712j.l();
            this.y = drawableL;
            if (drawableL == null && this.f712j.m() > 0) {
                this.y = s(this.f712j.m());
            }
        }
        return this.y;
    }

    private Drawable q() {
        if (this.x == null) {
            Drawable drawableR = this.f712j.r();
            this.x = drawableR;
            if (drawableR == null && this.f712j.s() > 0) {
                this.x = s(this.f712j.s());
            }
        }
        return this.x;
    }

    private boolean r() {
        e eVar = this.e;
        return eVar == null || !eVar.c().a();
    }

    private Drawable s(int i2) {
        return com.bumptech.glide.load.z.h.a.a(this.g, i2, this.f712j.x() != null ? this.f712j.x() : this.f.getTheme());
    }

    private void t(String str) {
        Log.v("Request", str + " this: " + this.a);
    }

    private static int u(int i2, float f) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f * i2);
    }

    private void v() {
        e eVar = this.e;
        if (eVar != null) {
            eVar.j(this);
        }
    }

    private void w() {
        e eVar = this.e;
        if (eVar != null) {
            eVar.b(this);
        }
    }

    public static <R> j<R> x(Context context, com.bumptech.glide.f fVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, com.bumptech.glide.h hVar, com.bumptech.glide.z.l.h<R> hVar2, f<R> fVar2, List<f<R>> list, e eVar, i0 i0Var, com.bumptech.glide.z.m.e<? super R> eVar2, Executor executor) {
        return new j<>(context, fVar, obj, obj2, cls, aVar, i2, i3, hVar, hVar2, fVar2, list, eVar, i0Var, eVar2, executor);
    }

    private void y(t0 t0Var, int i2) {
        boolean zA;
        this.b.c();
        synchronized (this.c) {
            t0Var.l(this.C);
            int iG = this.g.g();
            if (iG <= i2) {
                Log.w("Glide", "Load failed for " + this.f710h + " with size [" + this.z + "x" + this.A + "]", t0Var);
                if (iG <= 4) {
                    t0Var.g("Glide");
                }
            }
            this.s = null;
            this.v = i.FAILED;
            boolean z = true;
            this.B = true;
            try {
                List<f<R>> list = this.f717o;
                if (list != null) {
                    Iterator<f<R>> it = list.iterator();
                    zA = false;
                    while (it.hasNext()) {
                        zA |= it.next().a(t0Var, this.f710h, this.f716n, r());
                    }
                } else {
                    zA = false;
                }
                f<R> fVar = this.d;
                if (fVar == null || !fVar.a(t0Var, this.f710h, this.f716n, r())) {
                    z = false;
                }
                if (!(zA | z)) {
                    A();
                }
                this.B = false;
                v();
            } catch (Throwable th) {
                this.B = false;
                throw th;
            }
        }
    }

    private void z(z0<R> z0Var, R r, com.bumptech.glide.load.a aVar) {
        boolean zB;
        boolean zR = r();
        this.v = i.COMPLETE;
        this.r = z0Var;
        if (this.g.g() <= 3) {
            Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + aVar + " for " + this.f710h + " with size [" + this.z + "x" + this.A + "] in " + com.bumptech.glide.b0.j.a(this.t) + " ms");
        }
        boolean z = true;
        this.B = true;
        try {
            List<f<R>> list = this.f717o;
            if (list != null) {
                Iterator<f<R>> it = list.iterator();
                zB = false;
                while (it.hasNext()) {
                    zB |= it.next().b(r, this.f710h, this.f716n, aVar, zR);
                }
            } else {
                zB = false;
            }
            f<R> fVar = this.d;
            if (fVar == null || !fVar.b(r, this.f710h, this.f716n, aVar, zR)) {
                z = false;
            }
            if (!(z | zB)) {
                this.f716n.g(r, this.p.a(aVar, zR));
            }
            this.B = false;
            w();
        } catch (Throwable th) {
            this.B = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.z.c
    public boolean a() {
        boolean z;
        synchronized (this.c) {
            z = this.v == i.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.z.h
    public void b(t0 t0Var) {
        y(t0Var, 5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (r6 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        r5.u.k(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00aa, code lost:
    
        if (r6 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ac, code lost:
    
        r5.u.k(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.z.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(z0<?> z0Var, com.bumptech.glide.load.a aVar) {
        this.b.c();
        z0<?> z0Var2 = null;
        try {
            synchronized (this.c) {
                try {
                    this.s = null;
                    if (z0Var == null) {
                        b(new t0("Expected to receive a Resource<R> with an object of " + this.f711i + " inside, but instead got null."));
                        return;
                    }
                    Object obj = z0Var.get();
                    try {
                        if (obj != null && this.f711i.isAssignableFrom(obj.getClass())) {
                            if (m()) {
                                z(z0Var, obj, aVar);
                                return;
                            } else {
                                this.r = null;
                                this.v = i.COMPLETE;
                            }
                        }
                        this.r = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.f711i);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(z0Var);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        b(new t0(sb.toString()));
                    } catch (Throwable th) {
                        z0Var2 = z0Var;
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            throw th;
        } catch (Throwable th3) {
            if (z0Var2 != null) {
                this.u.k(z0Var2);
            }
            throw th3;
        }
    }

    @Override // com.bumptech.glide.z.c
    public void clear() {
        synchronized (this.c) {
            i();
            this.b.c();
            i iVar = this.v;
            i iVar2 = i.CLEARED;
            if (iVar == iVar2) {
                return;
            }
            n();
            z0<R> z0Var = this.r;
            if (z0Var != null) {
                this.r = null;
            } else {
                z0Var = null;
            }
            if (j()) {
                this.f716n.f(q());
            }
            this.v = iVar2;
            if (z0Var != null) {
                this.u.k(z0Var);
            }
        }
    }

    @Override // com.bumptech.glide.z.c
    public void d() {
        synchronized (this.c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @Override // com.bumptech.glide.z.l.g
    public void e(int i2, int i3) throws Throwable {
        Object obj;
        this.b.c();
        Object obj2 = this.c;
        synchronized (obj2) {
            try {
                try {
                    boolean z = D;
                    if (z) {
                        t("Got onSizeReady in " + com.bumptech.glide.b0.j.a(this.t));
                    }
                    if (this.v == i.WAITING_FOR_SIZE) {
                        i iVar = i.RUNNING;
                        this.v = iVar;
                        float fW = this.f712j.w();
                        this.z = u(i2, fW);
                        this.A = u(i3, fW);
                        if (z) {
                            t("finished setup for calling load in " + com.bumptech.glide.b0.j.a(this.t));
                        }
                        obj = obj2;
                        try {
                            this.s = this.u.f(this.g, this.f710h, this.f712j.v(), this.z, this.A, this.f712j.u(), this.f711i, this.f715m, this.f712j.i(), this.f712j.y(), this.f712j.H(), this.f712j.D(), this.f712j.o(), this.f712j.B(), this.f712j.A(), this.f712j.z(), this.f712j.n(), this, this.q);
                            if (this.v != iVar) {
                                this.s = null;
                            }
                            if (z) {
                                t("finished onSizeReady in " + com.bumptech.glide.b0.j.a(this.t));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    @Override // com.bumptech.glide.z.c
    public boolean f() {
        boolean z;
        synchronized (this.c) {
            z = this.v == i.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.z.c
    public boolean g() {
        boolean z;
        synchronized (this.c) {
            z = this.v == i.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.z.h
    public Object getLock() {
        this.b.c();
        return this.c;
    }

    @Override // com.bumptech.glide.z.c
    public boolean h(c cVar) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        a<?> aVar;
        com.bumptech.glide.h hVar;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        a<?> aVar2;
        com.bumptech.glide.h hVar2;
        int size2;
        if (!(cVar instanceof j)) {
            return false;
        }
        synchronized (this.c) {
            i2 = this.f713k;
            i3 = this.f714l;
            obj = this.f710h;
            cls = this.f711i;
            aVar = this.f712j;
            hVar = this.f715m;
            List<f<R>> list = this.f717o;
            size = list != null ? list.size() : 0;
        }
        j jVar = (j) cVar;
        synchronized (jVar.c) {
            i4 = jVar.f713k;
            i5 = jVar.f714l;
            obj2 = jVar.f710h;
            cls2 = jVar.f711i;
            aVar2 = jVar.f712j;
            hVar2 = jVar.f715m;
            List<f<R>> list2 = jVar.f717o;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i2 == i4 && i3 == i5 && p.b(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && hVar == hVar2 && size == size2;
    }

    @Override // com.bumptech.glide.z.c
    public boolean isRunning() {
        boolean z;
        synchronized (this.c) {
            i iVar = this.v;
            z = iVar == i.RUNNING || iVar == i.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // com.bumptech.glide.z.c
    public void k() {
        synchronized (this.c) {
            i();
            this.b.c();
            this.t = com.bumptech.glide.b0.j.b();
            if (this.f710h == null) {
                if (p.r(this.f713k, this.f714l)) {
                    this.z = this.f713k;
                    this.A = this.f714l;
                }
                y(new t0("Received null model"), p() == null ? 5 : 3);
                return;
            }
            i iVar = this.v;
            i iVar2 = i.RUNNING;
            if (iVar == iVar2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (iVar == i.COMPLETE) {
                c(this.r, com.bumptech.glide.load.a.MEMORY_CACHE);
                return;
            }
            i iVar3 = i.WAITING_FOR_SIZE;
            this.v = iVar3;
            if (p.r(this.f713k, this.f714l)) {
                e(this.f713k, this.f714l);
            } else {
                this.f716n.k(this);
            }
            i iVar4 = this.v;
            if ((iVar4 == iVar2 || iVar4 == iVar3) && l()) {
                this.f716n.h(q());
            }
            if (D) {
                t("finished run method in " + com.bumptech.glide.b0.j.a(this.t));
            }
        }
    }
}
