package k.b0.v;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class k1 extends k.x.c1 {
    private ArrayList c;

    protected k1(ArrayList arrayList) {
        super(k.x.z0.G0);
        this.c = arrayList;
    }

    @Override // k.x.c1
    public byte[] y() {
        int i2 = 2;
        byte[] bArr = new byte[(this.c.size() * 8) + 2];
        k.x.s0.f(this.c.size(), bArr, 0);
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            k.r rVar = (k.r) this.c.get(i3);
            k.c topLeft = rVar.getTopLeft();
            k.c bottomRight = rVar.getBottomRight();
            k.x.s0.f(topLeft.getRow(), bArr, i2);
            k.x.s0.f(bottomRight.getRow(), bArr, i2 + 2);
            k.x.s0.f(topLeft.b(), bArr, i2 + 4);
            k.x.s0.f(bottomRight.b(), bArr, i2 + 6);
            i2 += 8;
        }
        return bArr;
    }
}
