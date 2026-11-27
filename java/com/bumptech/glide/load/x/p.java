package com.bumptech.glide.load.x;

import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class p<R> implements k, Runnable, Comparable<p<?>>, com.bumptech.glide.b0.q.f {
    private o0 A;
    private int C;
    private int D;
    private b0 G;
    private com.bumptech.glide.load.r H;
    private o<R> I;
    private int J;
    private u K;
    private t M;
    private long O;
    private boolean P;
    private Object Q;
    private Thread U;
    private com.bumptech.glide.load.n V;
    private com.bumptech.glide.load.n W;
    private Object Z;
    private com.bumptech.glide.load.a a0;
    private com.bumptech.glide.load.w.e<?> b0;
    private volatile l c0;
    private volatile boolean d0;
    private volatile boolean e0;
    private final r f;
    private final h.e.i.e<p<?>> g;

    /* renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.f f634j;

    /* renamed from: k, reason: collision with root package name */
    private com.bumptech.glide.load.n f635k;
    private com.bumptech.glide.h t;
    private final m<R> c = new m<>();
    private final List<Throwable> d = new ArrayList();
    private final com.bumptech.glide.b0.q.l e = com.bumptech.glide.b0.q.l.a();

    /* renamed from: h, reason: collision with root package name */
    private final q<?> f632h = new q<>();

    /* renamed from: i, reason: collision with root package name */
    private final s f633i = new s();

    private final class a<Z> implements v<Z> {
        private final com.bumptech.glide.load.a a;

        a(com.bumptech.glide.load.a aVar) {
            this.a = aVar;
        }

        @Override // com.bumptech.glide.load.x.v
        public z0<Z> a(z0<Z> z0Var) {
            return p.this.v(this.a, z0Var);
        }
    }

    p(r rVar, h.e.i.e<p<?>> eVar) {
        this.f = rVar;
        this.g = eVar;
    }

    private void A() {
        int i2 = n.a[this.M.ordinal()];
        if (i2 == 1) {
            this.K = k(u.INITIALIZE);
            this.c0 = j();
            y();
        } else if (i2 == 2) {
            y();
        } else {
            if (i2 == 3) {
                i();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.M);
        }
    }

    private void B() {
        Throwable th;
        this.e.c();
        if (!this.d0) {
            this.d0 = true;
            return;
        }
        if (this.d.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.d;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    private <Data> z0<R> g(com.bumptech.glide.load.w.e<?> eVar, Data data, com.bumptech.glide.load.a aVar) throws t0 {
        if (data == null) {
            return null;
        }
        try {
            long jB = com.bumptech.glide.b0.j.b();
            z0<R> z0VarH = h(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                o("Decoded result " + z0VarH, jB);
            }
            return z0VarH;
        } finally {
            eVar.b();
        }
    }

    private <Data> z0<R> h(Data data, com.bumptech.glide.load.a aVar) throws t0 {
        return z(data, aVar, this.c.h(data.getClass()));
    }

    private void i() {
        if (Log.isLoggable("DecodeJob", 2)) {
            p("Retrieved data", this.O, "data: " + this.Z + ", cache key: " + this.V + ", fetcher: " + this.b0);
        }
        z0<R> z0VarG = null;
        try {
            z0VarG = g(this.b0, this.Z, this.a0);
        } catch (t0 e) {
            e.i(this.W, this.a0);
            this.d.add(e);
        }
        if (z0VarG != null) {
            r(z0VarG, this.a0);
        } else {
            y();
        }
    }

    private l j() {
        int i2 = n.b[this.K.ordinal()];
        if (i2 == 1) {
            return new a1(this.c, this);
        }
        if (i2 == 2) {
            return new h(this.c, this);
        }
        if (i2 == 3) {
            return new f1(this.c, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.K);
    }

    private u k(u uVar) {
        int i2 = n.b[uVar.ordinal()];
        if (i2 == 1) {
            return this.G.a() ? u.DATA_CACHE : k(u.DATA_CACHE);
        }
        if (i2 == 2) {
            return this.P ? u.FINISHED : u.SOURCE;
        }
        if (i2 == 3 || i2 == 4) {
            return u.FINISHED;
        }
        if (i2 == 5) {
            return this.G.b() ? u.RESOURCE_CACHE : k(u.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + uVar);
    }

    private com.bumptech.glide.load.r l(com.bumptech.glide.load.a aVar) {
        com.bumptech.glide.load.r rVar = this.H;
        if (Build.VERSION.SDK_INT < 26) {
            return rVar;
        }
        boolean z = aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || this.c.w();
        com.bumptech.glide.load.q<Boolean> qVar = com.bumptech.glide.load.z.f.y.f650i;
        Boolean bool = (Boolean) rVar.c(qVar);
        if (bool != null && (!bool.booleanValue() || z)) {
            return rVar;
        }
        com.bumptech.glide.load.r rVar2 = new com.bumptech.glide.load.r();
        rVar2.d(this.H);
        rVar2.e(qVar, Boolean.valueOf(z));
        return rVar2;
    }

    private int m() {
        return this.t.ordinal();
    }

    private void o(String str, long j2) {
        p(str, j2, null);
    }

    private void p(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.b0.j.a(j2));
        sb.append(", load key: ");
        sb.append(this.A);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void q(z0<R> z0Var, com.bumptech.glide.load.a aVar) {
        B();
        this.I.c(z0Var, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r(z0<R> z0Var, com.bumptech.glide.load.a aVar) {
        if (z0Var instanceof u0) {
            ((u0) z0Var).c();
        }
        y0 y0Var = 0;
        if (this.f632h.c()) {
            z0Var = y0.d(z0Var);
            y0Var = z0Var;
        }
        q(z0Var, aVar);
        this.K = u.ENCODE;
        try {
            if (this.f632h.c()) {
                this.f632h.b(this.f, this.H);
            }
            t();
        } finally {
            if (y0Var != 0) {
                y0Var.g();
            }
        }
    }

    private void s() {
        B();
        this.I.b(new t0("Failed to load resource", new ArrayList(this.d)));
        u();
    }

    private void t() {
        if (this.f633i.b()) {
            x();
        }
    }

    private void u() {
        if (this.f633i.c()) {
            x();
        }
    }

    private void x() {
        this.f633i.e();
        this.f632h.a();
        this.c.a();
        this.d0 = false;
        this.f634j = null;
        this.f635k = null;
        this.H = null;
        this.t = null;
        this.A = null;
        this.I = null;
        this.K = null;
        this.c0 = null;
        this.U = null;
        this.V = null;
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.O = 0L;
        this.e0 = false;
        this.Q = null;
        this.d.clear();
        this.g.b(this);
    }

    private void y() {
        this.U = Thread.currentThread();
        this.O = com.bumptech.glide.b0.j.b();
        boolean zA = false;
        while (!this.e0 && this.c0 != null && !(zA = this.c0.a())) {
            this.K = k(this.K);
            this.c0 = j();
            if (this.K == u.SOURCE) {
                c();
                return;
            }
        }
        if ((this.K == u.FINISHED || this.e0) && !zA) {
            s();
        }
    }

    private <Data, ResourceType> z0<R> z(Data data, com.bumptech.glide.load.a aVar, w0<Data, ResourceType, R> w0Var) throws t0 {
        com.bumptech.glide.load.r rVarL = l(aVar);
        com.bumptech.glide.load.w.g<Data> gVarL = this.f634j.h().l(data);
        try {
            return w0Var.a(gVarL, rVarL, this.C, this.D, new a(aVar));
        } finally {
            gVarL.b();
        }
    }

    boolean C() {
        u uVarK = k(u.INITIALIZE);
        return uVarK == u.RESOURCE_CACHE || uVarK == u.DATA_CACHE;
    }

    public void a() {
        this.e0 = true;
        l lVar = this.c0;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.x.k
    public void b(com.bumptech.glide.load.n nVar, Exception exc, com.bumptech.glide.load.w.e<?> eVar, com.bumptech.glide.load.a aVar) {
        eVar.b();
        t0 t0Var = new t0("Fetching data failed", exc);
        t0Var.k(nVar, aVar, eVar.a());
        this.d.add(t0Var);
        if (Thread.currentThread() == this.U) {
            y();
        } else {
            this.M = t.SWITCH_TO_SOURCE_SERVICE;
            this.I.d(this);
        }
    }

    @Override // com.bumptech.glide.load.x.k
    public void c() {
        this.M = t.SWITCH_TO_SOURCE_SERVICE;
        this.I.d(this);
    }

    @Override // com.bumptech.glide.load.x.k
    public void d(com.bumptech.glide.load.n nVar, Object obj, com.bumptech.glide.load.w.e<?> eVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.n nVar2) {
        this.V = nVar;
        this.Z = obj;
        this.b0 = eVar;
        this.a0 = aVar;
        this.W = nVar2;
        if (Thread.currentThread() != this.U) {
            this.M = t.DECODE_DATA;
            this.I.d(this);
        } else {
            com.bumptech.glide.b0.q.i.a("DecodeJob.decodeFromRetrievedData");
            try {
                i();
            } finally {
                com.bumptech.glide.b0.q.i.d();
            }
        }
    }

    @Override // com.bumptech.glide.b0.q.f
    public com.bumptech.glide.b0.q.l e() {
        return this.e;
    }

    @Override // java.lang.Comparable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(p<?> pVar) {
        int iM = m() - pVar.m();
        return iM == 0 ? this.J - pVar.J : iM;
    }

    p<R> n(com.bumptech.glide.f fVar, Object obj, o0 o0Var, com.bumptech.glide.load.n nVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, b0 b0Var, Map<Class<?>, com.bumptech.glide.load.v<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.r rVar, o<R> oVar, int i4) {
        this.c.u(fVar, obj, nVar, i2, i3, b0Var, cls, cls2, hVar, rVar, map, z, z2, this.f);
        this.f634j = fVar;
        this.f635k = nVar;
        this.t = hVar;
        this.A = o0Var;
        this.C = i2;
        this.D = i3;
        this.G = b0Var;
        this.P = z3;
        this.H = rVar;
        this.I = oVar;
        this.J = i4;
        this.M = t.INITIALIZE;
        this.Q = obj;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.b0.q.i.b("DecodeJob#run(model=%s)", this.Q);
        com.bumptech.glide.load.w.e<?> eVar = this.b0;
        try {
            try {
                try {
                    if (this.e0) {
                        s();
                        if (eVar != null) {
                            eVar.b();
                        }
                        com.bumptech.glide.b0.q.i.d();
                        return;
                    }
                    A();
                    if (eVar != null) {
                        eVar.b();
                    }
                    com.bumptech.glide.b0.q.i.d();
                } catch (g e) {
                    throw e;
                }
            } catch (Throwable th) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.e0 + ", stage: " + this.K, th);
                }
                if (this.K != u.ENCODE) {
                    this.d.add(th);
                    s();
                }
                if (!this.e0) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (eVar != null) {
                eVar.b();
            }
            com.bumptech.glide.b0.q.i.d();
            throw th2;
        }
    }

    <Z> z0<Z> v(com.bumptech.glide.load.a aVar, z0<Z> z0Var) {
        z0<Z> z0VarA;
        com.bumptech.glide.load.v<Z> vVar;
        com.bumptech.glide.load.c cVarB;
        com.bumptech.glide.load.n iVar;
        Class<?> cls = z0Var.get().getClass();
        com.bumptech.glide.load.u<Z> uVarN = null;
        if (aVar != com.bumptech.glide.load.a.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.v<Z> vVarR = this.c.r(cls);
            vVar = vVarR;
            z0VarA = vVarR.a(this.f634j, z0Var, this.C, this.D);
        } else {
            z0VarA = z0Var;
            vVar = null;
        }
        if (!z0Var.equals(z0VarA)) {
            z0Var.a();
        }
        if (this.c.v(z0VarA)) {
            uVarN = this.c.n(z0VarA);
            cVarB = uVarN.b(this.H);
        } else {
            cVarB = com.bumptech.glide.load.c.NONE;
        }
        com.bumptech.glide.load.u uVar = uVarN;
        if (!this.G.d(!this.c.x(this.V), aVar, cVarB)) {
            return z0VarA;
        }
        if (uVar == null) {
            throw new com.bumptech.glide.m(z0VarA.get().getClass());
        }
        int i2 = n.c[cVarB.ordinal()];
        if (i2 == 1) {
            iVar = new i(this.V, this.f635k);
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + cVarB);
            }
            iVar = new b1(this.c.b(), this.V, this.f635k, this.C, this.D, vVar, cls, this.H);
        }
        y0 y0VarD = y0.d(z0VarA);
        this.f632h.d(iVar, uVar, y0VarD);
        return y0VarD;
    }

    void w(boolean z) {
        if (this.f633i.d(z)) {
            x();
        }
    }
}
