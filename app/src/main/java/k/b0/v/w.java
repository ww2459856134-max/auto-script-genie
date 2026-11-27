package k.b0.v;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class w extends k.x.c1 {
    private int c;
    private int d;
    private ArrayList e;
    private int f;

    public w(int i2) {
        super(k.x.z0.r);
        this.c = i2;
        this.e = new ArrayList(10);
    }

    void A(int i2) {
        this.e.add(new Integer(i2));
    }

    void B(int i2) {
        this.d = i2;
    }

    void C(int i2) {
        this.f = i2;
    }

    @Override // k.x.c1
    protected byte[] y() {
        int i2 = 4;
        byte[] bArr = new byte[(this.e.size() * 2) + 4];
        k.x.s0.a(this.f - this.c, bArr, 0);
        int i3 = this.d;
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            k.x.s0.f(iIntValue - i3, bArr, i2);
            i2 += 2;
            i3 = iIntValue;
        }
        return bArr;
    }
}
