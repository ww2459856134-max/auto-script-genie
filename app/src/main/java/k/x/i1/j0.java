package k.x.i1;

import java.util.ArrayList;
import java.util.Iterator;
import k.x.y0;

/* loaded from: classes.dex */
class j0 extends x {
    private byte[] c;
    private int d;
    private ArrayList e;

    static {
        k.y.c.b(j0.class);
    }

    public j0(a0 a0Var) {
        super(a0Var);
        this.d = d();
        p();
    }

    private void p() {
        this.e = new ArrayList();
        byte[] bArrA = a();
        int i2 = 0;
        for (int i3 = 0; i3 < this.d; i3++) {
            int iC = k.x.s0.c(bArrA[i2], bArrA[i2 + 1]);
            int i4 = iC & 16383;
            int iD = k.x.s0.d(bArrA[i2 + 2], bArrA[i2 + 3], bArrA[i2 + 4], bArrA[i2 + 5]);
            boolean z = true;
            boolean z2 = (iC & 16384) != 0;
            if ((iC & 32768) == 0) {
                z = false;
            }
            i2 += 6;
            this.e.add(new i0(i4, z2, z, iD));
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            i0 i0Var = (i0) it.next();
            if (i0Var.c) {
                i0Var.e = y0.g(bArrA, i0Var.d / 2, i2);
                i2 += i0Var.d;
            }
        }
    }

    @Override // k.x.i1.x, k.x.i1.z
    byte[] b() {
        String str;
        int size = this.e.size();
        this.d = size;
        k(size);
        this.c = new byte[this.d * 6];
        Iterator it = this.e.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i0 i0Var = (i0) it.next();
            int i3 = i0Var.a & 16383;
            if (i0Var.b) {
                i3 |= 16384;
            }
            if (i0Var.c) {
                i3 |= 32768;
            }
            k.x.s0.f(i3, this.c, i2);
            k.x.s0.a(i0Var.d, this.c, i2 + 2);
            i2 += 6;
        }
        Iterator it2 = this.e.iterator();
        while (it2.hasNext()) {
            i0 i0Var2 = (i0) it2.next();
            if (i0Var2.c && (str = i0Var2.e) != null) {
                byte[] bArr = new byte[this.c.length + (str.length() * 2)];
                byte[] bArr2 = this.c;
                System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
                y0.e(i0Var2.e, bArr, this.c.length);
                this.c = bArr;
            }
        }
        return j(this.c);
    }

    void m(int i2, boolean z, boolean z2, int i3) {
        this.e.add(new i0(i2, z, z2, i3));
    }

    void n(int i2, boolean z, boolean z2, int i3, String str) {
        this.e.add(new i0(i2, z, z2, i3, str));
    }

    i0 o(int i2) {
        Iterator it = this.e.iterator();
        boolean z = false;
        i0 i0Var = null;
        while (it.hasNext() && !z) {
            i0Var = (i0) it.next();
            if (i0Var.a == i2) {
                z = true;
            }
        }
        if (z) {
            return i0Var;
        }
        return null;
    }

    public j0() {
        super(b0.f2045n);
        this.e = new ArrayList();
        l(3);
    }
}
