package k.a0.a;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f2 {
    private int a;
    private k.x.z0 b;
    private int c;
    private int d;
    private j0 e;
    private byte[] f;
    private ArrayList g;

    static {
        k.y.c.b(f2.class);
    }

    f2(byte[] bArr, int i2, j0 j0Var) {
        this.a = k.x.s0.c(bArr[i2], bArr[i2 + 1]);
        this.c = k.x.s0.c(bArr[i2 + 2], bArr[i2 + 3]);
        this.e = j0Var;
        j0Var.j(4);
        this.d = j0Var.c();
        this.e.j(this.c);
        this.b = k.x.z0.a(this.a);
    }

    public void a(f2 f2Var) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(f2Var);
    }

    public int b() {
        return this.a;
    }

    public byte[] c() {
        if (this.f == null) {
            this.f = this.e.g(this.d, this.c);
        }
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            int size = arrayList.size();
            byte[][] bArr = new byte[size][];
            int length = 0;
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                bArr[i2] = ((f2) this.g.get(i2)).c();
                length += bArr[i2].length;
            }
            byte[] bArr2 = this.f;
            byte[] bArr3 = new byte[bArr2.length + length];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            int length2 = this.f.length;
            for (int i3 = 0; i3 < size; i3++) {
                byte[] bArr4 = bArr[i3];
                System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
                length2 += bArr4.length;
            }
            this.f = bArr3;
        }
        return this.f;
    }

    public int d() {
        return this.c;
    }

    public k.x.z0 e() {
        return this.b;
    }

    void f(k.x.z0 z0Var) {
        this.b = z0Var;
    }
}
