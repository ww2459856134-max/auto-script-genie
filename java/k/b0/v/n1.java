package k.b0.v;

/* loaded from: classes.dex */
class n1 extends k.x.c1 {
    private byte[] c;
    private String d;
    private k.x.i e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1911h;

    /* renamed from: i, reason: collision with root package name */
    private m1[] f1912i;

    static {
        k.y.c.b(n1.class);
    }

    public n1(k.a0.a.o1 o1Var, int i2) {
        super(k.x.z0.A);
        int i3 = 0;
        this.g = 0;
        this.c = o1Var.z();
        this.d = o1Var.getName();
        this.g = o1Var.C();
        this.f = i2;
        this.f1911h = false;
        k.a0.a.n1[] n1VarArrB = o1Var.B();
        this.f1912i = new m1[n1VarArrB.length];
        while (true) {
            m1[] m1VarArr = this.f1912i;
            if (i3 >= m1VarArr.length) {
                return;
            }
            m1VarArr[i3] = new m1(n1VarArrB[i3]);
            i3++;
        }
    }

    public int A() {
        return this.f;
    }

    public String getName() {
        return this.d;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = this.c;
        if (bArr != null && !this.f1911h) {
            return bArr;
        }
        m1[] m1VarArr = this.f1912i;
        int length = m1VarArr.length > 1 ? (m1VarArr.length * 11) + 4 : 11;
        byte[] bArr2 = new byte[length + 15 + (this.e != null ? 1 : this.d.length())];
        this.c = bArr2;
        k.x.s0.f(this.e != null ? 32 : 0, bArr2, 0);
        byte[] bArr3 = this.c;
        bArr3[2] = 0;
        if (this.e != null) {
            bArr3[3] = 1;
        } else {
            bArr3[3] = (byte) this.d.length();
        }
        k.x.s0.f(length, this.c, 4);
        k.x.s0.f(this.g, this.c, 6);
        k.x.s0.f(this.g, this.c, 8);
        k.x.i iVar = this.e;
        if (iVar != null) {
            this.c[15] = (byte) iVar.c();
        } else {
            k.x.y0.a(this.d, this.c, 15);
        }
        int length2 = this.e != null ? 16 : this.d.length() + 15;
        m1[] m1VarArr2 = this.f1912i;
        if (m1VarArr2.length > 1) {
            byte[] bArr4 = this.c;
            int i2 = length2 + 1;
            bArr4[length2] = 41;
            k.x.s0.f(length - 3, bArr4, i2);
            int length3 = i2 + 2;
            int i3 = 0;
            while (true) {
                m1[] m1VarArr3 = this.f1912i;
                if (i3 >= m1VarArr3.length) {
                    break;
                }
                int i4 = length3 + 1;
                this.c[length3] = 59;
                byte[] bArrA = m1VarArr3[i3].a();
                System.arraycopy(bArrA, 0, this.c, i4, bArrA.length);
                length3 = i4 + bArrA.length;
                i3++;
            }
            this.c[length3] = 16;
        } else {
            this.c[length2] = 59;
            byte[] bArrA2 = m1VarArr2[0].a();
            System.arraycopy(bArrA2, 0, this.c, length2 + 1, bArrA2.length);
        }
        return this.c;
    }

    n1(k.x.i iVar, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(k.x.z0.A);
        this.g = 0;
        this.e = iVar;
        this.f = i2;
        this.g = z ? 0 : i2 + 1;
        this.f1912i = new m1[]{new m1(i3, i4, i5, i6, i7)};
    }

    n1(k.x.i iVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z) {
        super(k.x.z0.A);
        this.g = 0;
        this.e = iVar;
        this.f = i2;
        this.g = z ? 0 : i2 + 1;
        this.f1912i = new m1[]{new m1(i3, i4, i5, i6, i7), new m1(i3, i8, i9, i10, i11)};
    }
}
