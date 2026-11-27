package k.b0.v;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class k0 extends k.x.c1 {
    private ArrayList c;

    public k0(k.a0.a.i0 i0Var) {
        super(k.x.z0.g);
        this.c = new ArrayList(i0Var.A());
        for (int i2 = 0; i2 < i0Var.A(); i2++) {
            this.c.add(new j0(i0Var.B(i2), i0Var.y(i2), i0Var.z(i2)));
        }
    }

    public int A(int i2) {
        return ((j0) this.c.get(i2)).b;
    }

    int B(int i2, int i3) {
        Iterator it = this.c.iterator();
        boolean z = false;
        int i4 = 0;
        while (it.hasNext() && !z) {
            j0 j0Var = (j0) it.next();
            if (j0Var.a == i2 && j0Var.b == i3) {
                z = true;
            } else {
                i4++;
            }
        }
        if (z) {
            return i4;
        }
        this.c.add(new j0(i2, i3, i3));
        return this.c.size() - 1;
    }

    public int C(int i2) {
        return ((j0) this.c.get(i2)).a;
    }

    void D(int i2) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((j0) it.next()).a(i2);
        }
    }

    @Override // k.x.c1
    public byte[] y() {
        int i2 = 2;
        byte[] bArr = new byte[(this.c.size() * 6) + 2];
        k.x.s0.f(this.c.size(), bArr, 0);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            j0 j0Var = (j0) it.next();
            k.x.s0.f(j0Var.a, bArr, i2);
            k.x.s0.f(j0Var.b, bArr, i2 + 2);
            k.x.s0.f(j0Var.c, bArr, i2 + 4);
            i2 += 6;
        }
        return bArr;
    }

    public k0() {
        super(k.x.z0.g);
        this.c = new ArrayList();
    }
}
