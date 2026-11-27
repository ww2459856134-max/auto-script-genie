package k.x.i1;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class y extends z {
    private boolean b;
    private ArrayList c;

    static {
        k.y.c.b(y.class);
    }

    public y(a0 a0Var) {
        super(a0Var);
        this.b = false;
        this.c = new ArrayList();
    }

    private void o() {
        int iF = f() + 8;
        int iMin = Math.min(f() + e(), g());
        while (iF < iMin) {
            a0 a0Var = new a0(c(), iF);
            b0 b0VarG = a0Var.g();
            z oVar = b0VarG == b0.f2040i ? new o(a0Var) : b0VarG == b0.f2042k ? new l(a0Var) : b0VarG == b0.e ? new a(a0Var) : b0VarG == b0.g ? new q0(a0Var) : b0VarG == b0.f2039h ? new o0(a0Var) : b0VarG == b0.f2043l ? new p0(a0Var) : b0VarG == b0.f2044m ? new n0(a0Var) : b0VarG == b0.f2046o ? new g(a0Var) : b0VarG == b0.p ? new h(a0Var) : b0VarG == b0.f2041j ? new b(a0Var) : b0VarG == b0.f2045n ? new j0(a0Var) : b0VarG == b0.r ? new r0(a0Var) : b0VarG == b0.q ? new i(a0Var) : new x(a0Var);
            this.c.add(oVar);
            iF += oVar.e();
        }
        this.b = true;
    }

    @Override // k.x.i1.z
    byte[] b() {
        if (!this.b) {
            o();
        }
        byte[] bArr = new byte[0];
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            byte[] bArrB = ((z) it.next()).b();
            if (bArrB != null) {
                byte[] bArr2 = new byte[bArr.length + bArrB.length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                System.arraycopy(bArrB, 0, bArr2, bArr.length, bArrB.length);
                bArr = bArr2;
            }
        }
        return j(bArr);
    }

    public void m(z zVar) {
        this.c.add(zVar);
    }

    public z[] n() {
        if (!this.b) {
            o();
        }
        ArrayList arrayList = this.c;
        return (z[]) arrayList.toArray(new z[arrayList.size()]);
    }

    protected y(b0 b0Var) {
        super(b0Var);
        i(true);
        this.c = new ArrayList();
    }
}
