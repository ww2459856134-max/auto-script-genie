package k.x.i1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class m0 {
    private ArrayList a;
    private boolean b;
    private e[] c = new e[0];

    static {
        k.y.c.b(m0.class);
    }

    public m0(k.w wVar) {
    }

    private void e(k.b0.v.l0 l0Var) throws IOException {
        if (this.c.length == 0 && this.a.size() == 0) {
            return;
        }
        if (this.c.length == 0 && this.a.size() != 0) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                l0Var.e(wVar.a());
                wVar.b(l0Var);
            }
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                ((w) it2.next()).h(l0Var);
            }
            return;
        }
        int i2 = 0;
        if (this.a.size() != 0 || this.c.length == 0) {
            int size = this.a.size();
            e[] eVarArr = this.c;
            int length = eVarArr.length + size;
            y[] yVarArr = new y[length];
            boolean[] zArr = new boolean[eVarArr.length + size];
            int iE = 0;
            for (int i3 = 0; i3 < size; i3++) {
                w wVar2 = (w) this.a.get(i3);
                yVarArr[i3] = wVar2.g();
                if (i3 > 0) {
                    iE += yVarArr[i3].e();
                }
                if (wVar2.d()) {
                    zArr[i3] = true;
                }
            }
            int i4 = 0;
            while (true) {
                e[] eVarArr2 = this.c;
                if (i4 >= eVarArr2.length) {
                    break;
                }
                int i5 = i4 + size;
                yVarArr[i5] = eVarArr2[i4].d();
                iE += yVarArr[i5].e();
                i4++;
            }
            m mVar = new m();
            mVar.m(new l(this.c.length + size));
            q0 q0Var = new q0();
            o0 o0Var = new o0();
            o0Var.m(new p0());
            o0Var.m(new n0(l0.c, 1024, 5));
            q0Var.m(o0Var);
            q0Var.m(yVarArr[0]);
            mVar.m(q0Var);
            byte[] bArrB = mVar.b();
            k.x.s0.a(k.x.s0.d(bArrB[4], bArrB[5], bArrB[6], bArrB[7]) + iE, bArrB, 4);
            k.x.s0.a(k.x.s0.d(bArrB[28], bArrB[29], bArrB[30], bArrB[31]) + iE, bArrB, 28);
            if (zArr[0]) {
                int length2 = bArrB.length - 8;
                byte[] bArr = new byte[length2];
                System.arraycopy(bArrB, 0, bArr, 0, length2);
                bArrB = bArr;
            }
            l0Var.e(new e0(bArrB));
            ((w) this.a.get(0)).b(l0Var);
            for (int i6 = 1; i6 < length; i6++) {
                byte[] bArrJ = yVarArr[i6].j(yVarArr[i6].a());
                if (zArr[i6]) {
                    int length3 = bArrJ.length - 8;
                    byte[] bArr2 = new byte[length3];
                    System.arraycopy(bArrJ, 0, bArr2, 0, length3);
                    bArrJ = bArr2;
                }
                l0Var.e(new e0(bArrJ));
                if (i6 < size) {
                    ((w) this.a.get(i6)).b(l0Var);
                } else {
                    e eVar = this.c[i6 - size];
                    l0Var.e(eVar.c());
                    l0Var.e(eVar);
                }
            }
            Iterator it3 = this.a.iterator();
            while (it3.hasNext()) {
                ((w) it3.next()).h(l0Var);
            }
            return;
        }
        while (true) {
            e[] eVarArr3 = this.c;
            if (i2 >= eVarArr3.length) {
                return;
            }
            e eVar2 = eVarArr3[i2];
            if (eVar2.b() != null) {
                l0Var.e(eVar2.b());
            }
            if (eVar2.c() != null) {
                l0Var.e(eVar2.c());
            }
            l0Var.e(eVar2);
            i2++;
        }
    }

    public e[] a() {
        return this.c;
    }

    public void b(e[] eVarArr) {
        this.c = eVarArr;
    }

    public void c(ArrayList arrayList, boolean z) {
        this.a = arrayList;
        this.b = z;
    }

    public void d(k.b0.v.l0 l0Var) throws IOException {
        int i2;
        if (this.a.size() == 0 && this.c.length == 0) {
            return;
        }
        boolean z = this.b;
        int size = this.a.size();
        Iterator it = this.a.iterator();
        while (true) {
            if (!it.hasNext() || z) {
                break;
            } else if (((w) it.next()).getOrigin() != k0.a) {
                z = true;
            }
        }
        if (size > 0 && !z && !((w) this.a.get(0)).f()) {
            z = true;
        }
        if (size == 0) {
            e[] eVarArr = this.c;
            if (eVarArr.length == 1 && eVarArr[0].b() == null) {
                z = false;
            }
        }
        if (!z) {
            e(l0Var);
            return;
        }
        int length = this.c.length + size;
        Object[] objArr = new Object[length];
        y yVar = null;
        int length2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            y yVarG = ((w) this.a.get(i3)).g();
            if (yVarG != null) {
                byte[] bArrB = yVarG.b();
                objArr[i3] = bArrB;
                if (i3 == 0) {
                    yVar = yVarG;
                } else {
                    length2 += bArrB.length;
                }
            }
        }
        int i4 = 0;
        while (true) {
            e[] eVarArr2 = this.c;
            if (i4 >= eVarArr2.length) {
                break;
            }
            y yVarD = eVarArr2[i4].d();
            byte[] bArrJ = yVarD.j(yVarD.a());
            objArr[i4 + size] = bArrJ;
            if (i4 == 0 && size == 0) {
                yVar = yVarD;
            } else {
                length2 += bArrJ.length;
            }
            i4++;
        }
        m mVar = new m();
        mVar.m(new l(this.c.length + size));
        q0 q0Var = new q0();
        o0 o0Var = new o0();
        o0Var.m(new p0());
        o0Var.m(new n0(l0.c, 1024, 5));
        q0Var.m(o0Var);
        q0Var.m(yVar);
        mVar.m(q0Var);
        byte[] bArrB2 = mVar.b();
        k.x.s0.a(k.x.s0.d(bArrB2[4], bArrB2[5], bArrB2[6], bArrB2[7]) + length2, bArrB2, 4);
        k.x.s0.a(k.x.s0.d(bArrB2[28], bArrB2[29], bArrB2[30], bArrB2[31]) + length2, bArrB2, 28);
        if (size > 0 && ((w) this.a.get(0)).d()) {
            int length3 = bArrB2.length - 8;
            byte[] bArr = new byte[length3];
            System.arraycopy(bArrB2, 0, bArr, 0, length3);
            bArrB2 = bArr;
        }
        l0Var.e(new e0(bArrB2));
        if (size > 0) {
            ((w) this.a.get(0)).b(l0Var);
        } else {
            e eVar = this.c[0];
            l0Var.e(eVar.c());
            l0Var.e(eVar);
        }
        for (i2 = 1; i2 < length; i2++) {
            byte[] bArr2 = (byte[]) objArr[i2];
            if (i2 < size && ((w) this.a.get(i2)).d()) {
                int length4 = bArr2.length - 8;
                byte[] bArr3 = new byte[length4];
                System.arraycopy(bArr2, 0, bArr3, 0, length4);
                bArr2 = bArr3;
            }
            l0Var.e(new e0(bArr2));
            if (i2 < size) {
                ((w) this.a.get(i2)).b(l0Var);
            } else {
                e eVar2 = this.c[i2 - size];
                l0Var.e(eVar2.c());
                l0Var.e(eVar2);
            }
        }
        Iterator it2 = this.a.iterator();
        while (it2.hasNext()) {
            ((w) it2.next()).h(l0Var);
        }
    }
}
