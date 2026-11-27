package k.x.j1;

import java.util.Stack;

/* loaded from: classes.dex */
class j1 implements u0 {
    private byte[] a;
    private k.c b;
    private t0 d;
    private t f;
    private k.x.a1 g;

    /* renamed from: h, reason: collision with root package name */
    private k.w f2134h;

    /* renamed from: i, reason: collision with root package name */
    private s0 f2135i;
    private int c = 0;
    private Stack e = new Stack();

    static {
        k.y.c.b(j1.class);
    }

    public j1(byte[] bArr, k.c cVar, t tVar, k.x.a1 a1Var, k.w wVar, s0 s0Var) {
        this.a = bArr;
        this.b = cVar;
        this.f = tVar;
        this.g = a1Var;
        this.f2134h = wVar;
        this.f2135i = s0Var;
        k.y.a.a(this.g != null);
    }

    private void c(q0 q0Var) {
        q0Var.k(this.e);
        this.e.push(q0Var);
    }

    private void d(g1 g1Var) throws w {
        int i2 = this.c;
        this.c = i2 + g1Var.l(this.a, i2);
        Stack stack = this.e;
        this.e = new Stack();
        e(g1Var.j());
        t0[] t0VarArr = new t0[this.e.size()];
        int i3 = 0;
        while (!this.e.isEmpty()) {
            t0VarArr[i3] = (t0) this.e.pop();
            i3++;
        }
        g1Var.n(t0VarArr);
        this.e = stack;
        stack.push(g1Var);
    }

    private void e(int i2) throws w {
        Stack stack = new Stack();
        int i3 = this.c + i2;
        while (true) {
            int i4 = this.c;
            if (i4 >= i3) {
                return;
            }
            byte b = this.a[i4];
            this.c = i4 + 1;
            i1 i1VarD = i1.d(b);
            i1 i1Var = i1.N;
            if (i1VarD == i1Var) {
                throw new w(w.c, b);
            }
            k.y.a.a(i1VarD != i1Var);
            if (i1VarD == i1.c) {
                j jVar = new j(this.b);
                int i5 = this.c;
                this.c = i5 + jVar.j(this.a, i5);
                this.e.push(jVar);
            } else if (i1VarD == i1.f2128k) {
                k kVar = new k();
                int i6 = this.c;
                this.c = i6 + kVar.j(this.a, i6);
                this.e.push(kVar);
            } else if (i1VarD == i1.g) {
                s sVar = new s();
                int i7 = this.c;
                this.c = i7 + sVar.j(this.a, i7);
                this.e.push(sVar);
            } else if (i1VarD == i1.f2129l) {
                a1 a1Var = new a1(this.b);
                int i8 = this.c;
                this.c = i8 + a1Var.j(this.a, i8);
                this.e.push(a1Var);
            } else if (i1VarD == i1.d) {
                i iVar = new i(this.b, this.f);
                int i9 = this.c;
                this.c = i9 + iVar.j(this.a, i9);
                this.e.push(iVar);
            } else if (i1VarD == i1.f2132o) {
                c cVar = new c();
                int i10 = this.c;
                this.c = i10 + cVar.l(this.a, i10);
                this.e.push(cVar);
            } else if (i1VarD == i1.f2130m) {
                z0 z0Var = new z0(this.b);
                int i11 = this.c;
                this.c = i11 + z0Var.j(this.a, i11);
                this.e.push(z0Var);
            } else if (i1VarD == i1.r) {
                b bVar = new b(this.f);
                int i12 = this.c;
                this.c = i12 + bVar.l(this.a, i12);
                this.e.push(bVar);
            } else if (i1VarD == i1.q) {
                k0 k0Var = new k0();
                int i13 = this.c;
                this.c = i13 + k0Var.j(this.a, i13);
                k0Var.g(this.f2135i);
                this.e.push(k0Var);
            } else if (i1VarD == i1.p) {
                l0 l0Var = new l0(this.g);
                int i14 = this.c;
                this.c = i14 + l0Var.j(this.a, i14);
                l0Var.g(this.f2135i);
                this.e.push(l0Var);
            } else if (i1VarD == i1.f2126i) {
                c0 c0Var = new c0();
                int i15 = this.c;
                this.c = i15 + c0Var.l(this.a, i15);
                this.e.push(c0Var);
            } else if (i1VarD == i1.f2127j) {
                q qVar = new q();
                int i16 = this.c;
                this.c = i16 + qVar.k(this.a, i16);
                this.e.push(qVar);
            } else if (i1VarD == i1.f2125h) {
                g gVar = new g();
                int i17 = this.c;
                this.c = i17 + gVar.j(this.a, i17);
                this.e.push(gVar);
            } else if (i1VarD == i1.f) {
                f1 f1Var = new f1(this.f2134h);
                int i18 = this.c;
                this.c = i18 + f1Var.j(this.a, i18);
                this.e.push(f1Var);
            } else if (i1VarD == i1.e) {
                i0 i0Var = new i0();
                int i19 = this.c;
                this.c = i19 + i0Var.j(this.a, i19);
                this.e.push(i0Var);
            } else if (i1VarD == i1.s) {
                m1 m1Var = new m1();
                int i20 = this.c;
                this.c = i20 + m1Var.q(this.a, i20);
                c(m1Var);
            } else if (i1VarD == i1.t) {
                k1 k1Var = new k1();
                int i21 = this.c;
                this.c = i21 + k1Var.q(this.a, i21);
                c(k1Var);
            } else if (i1VarD == i1.u) {
                v0 v0Var = new v0();
                int i22 = this.c;
                this.c = i22 + v0Var.q(this.a, i22);
                c(v0Var);
            } else if (i1VarD == i1.x) {
                h1 h1Var = new h1();
                int i23 = this.c;
                this.c = i23 + h1Var.q(this.a, i23);
                c(h1Var);
            } else if (i1VarD == i1.w) {
                a aVar = new a();
                int i24 = this.c;
                this.c = i24 + aVar.q(this.a, i24);
                c(aVar);
            } else if (i1VarD == i1.y) {
                j0 j0Var = new j0();
                int i25 = this.c;
                this.c = i25 + j0Var.q(this.a, i25);
                c(j0Var);
            } else if (i1VarD == i1.z) {
                p pVar = new p();
                int i26 = this.c;
                this.c = i26 + pVar.q(this.a, i26);
                c(pVar);
            } else if (i1VarD == i1.B) {
                o oVar = new o();
                int i27 = this.c;
                this.c = i27 + oVar.q(this.a, i27);
                c(oVar);
            } else if (i1VarD == i1.A) {
                x0 x0Var = new x0();
                int i28 = this.c;
                this.c = i28 + x0Var.q(this.a, i28);
                c(x0Var);
            } else if (i1VarD == i1.C) {
                e0 e0Var = new e0();
                int i29 = this.c;
                this.c = i29 + e0Var.q(this.a, i29);
                c(e0Var);
            } else if (i1VarD == i1.D) {
                d0 d0Var = new d0();
                int i30 = this.c;
                this.c = i30 + d0Var.q(this.a, i30);
                c(d0Var);
            } else if (i1VarD == i1.G) {
                b0 b0Var = new b0();
                int i31 = this.c;
                this.c = i31 + b0Var.q(this.a, i31);
                c(b0Var);
            } else if (i1VarD == i1.F) {
                a0 a0Var = new a0();
                int i32 = this.c;
                this.c = i32 + a0Var.q(this.a, i32);
                c(a0Var);
            } else if (i1VarD == i1.H) {
                m0 m0Var = new m0();
                int i33 = this.c;
                this.c = i33 + m0Var.q(this.a, i33);
                c(m0Var);
            } else if (i1VarD == i1.E) {
                r rVar = new r();
                int i34 = this.c;
                this.c = i34 + rVar.q(this.a, i34);
                c(rVar);
            } else if (i1VarD == i1.v) {
                r0 r0Var = new r0();
                int i35 = this.c;
                this.c = i35 + r0Var.p(this.a, i35);
                c(r0Var);
            } else if (i1VarD == i1.L) {
                e eVar = new e(this.f2134h);
                int i36 = this.c;
                this.c = i36 + eVar.s(this.a, i36);
                if (eVar.r()) {
                    c(eVar);
                } else if (eVar.q()) {
                    stack.push(eVar);
                }
            } else if (i1VarD == i1.J) {
                h hVar = new h(this.f2134h);
                int i37 = this.c;
                this.c = i37 + hVar.o(this.a, i37);
                c(hVar);
            } else if (i1VarD == i1.K) {
                n1 n1Var = new n1(this.f2134h);
                int i38 = this.c;
                this.c = i38 + n1Var.q(this.a, i38);
                if (n1Var.o() != y.e) {
                    c(n1Var);
                } else {
                    n1Var.k(this.e);
                    e eVar2 = stack.empty() ? new e(this.f2134h) : (e) stack.pop();
                    eVar2.t(n1Var);
                    this.e.push(eVar2);
                }
            } else if (i1VarD == i1.M) {
                d(new g0());
            } else if (i1VarD == i1.f2131n) {
                d(new f0());
            }
        }
    }

    @Override // k.x.j1.u0
    public byte[] a() {
        return this.d.a();
    }

    @Override // k.x.j1.u0
    public void b() throws w {
        e(this.a.length);
        this.d = (t0) this.e.pop();
        k.y.a.a(this.e.empty());
    }

    @Override // k.x.j1.u0
    public String getFormula() {
        StringBuffer stringBuffer = new StringBuffer();
        this.d.c(stringBuffer);
        return stringBuffer.toString();
    }
}
