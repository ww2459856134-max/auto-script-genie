package k.b0.v;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class k2 extends k.x.c1 {

    /* renamed from: o, reason: collision with root package name */
    private static final k.y.c f1903o = k.y.c.b(k2.class);
    private static int p = 255;
    private static int q = 256;
    private o[] c;
    private int d;
    private boolean e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f1904h;

    /* renamed from: i, reason: collision with root package name */
    private k.x.h1 f1905i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1906j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1907k;

    /* renamed from: l, reason: collision with root package name */
    private int f1908l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1909m;

    /* renamed from: n, reason: collision with root package name */
    private k.b0.s f1910n;

    public k2(int i2, k.b0.s sVar) {
        super(k.x.z0.f2175k);
        this.f = i2;
        this.c = new o[0];
        this.g = 0;
        this.d = p;
        this.e = false;
        this.f1907k = true;
        this.f1910n = sVar;
    }

    private void H(ArrayList arrayList, l0 l0Var) throws IOException {
        if (arrayList.size() == 0) {
            return;
        }
        if (arrayList.size() >= 3) {
            l0Var.e(new l1(arrayList));
        } else {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                l0Var.e((o) it.next());
            }
        }
        arrayList.clear();
    }

    public void A(o oVar) {
        k.b0.l lVarU;
        int iB = oVar.b();
        if (iB >= q) {
            f1903o.f("Could not add cell at " + k.x.m.a(oVar.getRow(), oVar.b()) + " because it exceeds the maximum column limit");
            return;
        }
        o[] oVarArr = this.c;
        if (iB >= oVarArr.length) {
            o[] oVarArr2 = new o[Math.max(oVarArr.length + 10, iB + 1)];
            this.c = oVarArr2;
            System.arraycopy(oVarArr, 0, oVarArr2, 0, oVarArr.length);
        }
        o[] oVarArr3 = this.c;
        if (oVarArr3[iB] != null && (lVarU = oVarArr3[iB].u()) != null) {
            lVarU.h();
            if (lVarU.e() != null && !lVarU.e().b()) {
                lVarU.i();
            }
        }
        this.c[iB] = oVar;
        this.g = Math.max(iB + 1, this.g);
    }

    public o B(int i2) {
        if (i2 < 0 || i2 >= this.g) {
            return null;
        }
        return this.c[i2];
    }

    public int C() {
        return this.g;
    }

    void D(k.x.r0 r0Var) {
        if (this.f1906j) {
            this.f1904h = r0Var.a(this.f1904h);
        }
    }

    void E(int i2, boolean z, boolean z2, int i3, boolean z3, k.x.h1 h1Var) {
        this.d = i2;
        this.e = z2;
        this.f1907k = z;
        this.f1908l = i3;
        this.f1909m = z3;
        if (h1Var != null) {
            this.f1906j = true;
            this.f1905i = h1Var;
            this.f1904h = h1Var.I();
        }
    }

    public void F(l0 l0Var) throws IOException {
        l0Var.e(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void G(l0 l0Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.g; i2++) {
            o[] oVarArr = this.c;
            if (oVarArr[i2] == null) {
                H(arrayList, l0Var);
            } else if (oVarArr[i2].getType() == k.f.d) {
                k.b0.h hVar = (k.b0.h) this.c[i2];
                boolean z = hVar.getValue() == ((double) ((int) hVar.getValue())) && hVar.getValue() < 5.36870911E8d && hVar.getValue() > -5.36870912E8d && hVar.c() == null;
                if (z) {
                    arrayList.add(this.c[i2]);
                } else {
                    H(arrayList, l0Var);
                    l0Var.e(this.c[i2]);
                    if (this.c[i2].getType() == k.f.f1991i) {
                        l0Var.e(new x2(this.c[i2].p()));
                    }
                }
            }
        }
        H(arrayList, l0Var);
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[16];
        int iF = this.d;
        if (this.f1910n.getSettings().f() != 255 && iF == p) {
            iF = this.f1910n.getSettings().f();
        }
        k.x.s0.f(this.f, bArr, 0);
        k.x.s0.f(this.g, bArr, 4);
        k.x.s0.f(iF, bArr, 6);
        int i2 = this.f1908l + 256;
        if (this.f1909m) {
            i2 |= 16;
        }
        if (this.e) {
            i2 |= 32;
        }
        if (!this.f1907k) {
            i2 |= 64;
        }
        if (this.f1906j) {
            i2 = i2 | 128 | (this.f1904h << 16);
        }
        k.x.s0.a(i2, bArr, 12);
        return bArr;
    }
}
