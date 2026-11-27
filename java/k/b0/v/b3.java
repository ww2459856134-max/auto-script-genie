package k.b0.v;

/* loaded from: classes.dex */
class b3 extends k.x.c1 {

    /* renamed from: i, reason: collision with root package name */
    private static k.y.c f1888i = k.y.c.b(b3.class);

    /* renamed from: j, reason: collision with root package name */
    public static final a3 f1889j = new a3();

    /* renamed from: k, reason: collision with root package name */
    public static final a3 f1890k = new a3();

    /* renamed from: l, reason: collision with root package name */
    public static final a3 f1891l = new a3();
    private a3 c;
    private byte[] d;
    private int e;
    private String f;
    private String[] g;

    /* renamed from: h, reason: collision with root package name */
    private k.w f1892h;

    public b3(int i2, k.w wVar) {
        super(k.x.z0.f);
        this.e = i2;
        this.c = f1889j;
        this.f1892h = wVar;
    }

    private void G() {
        this.d = new byte[]{1, 0, 1, 58};
    }

    private void H() {
        int i2 = 0;
        int length = 0;
        for (int i3 = 0; i3 < this.e; i3++) {
            length += this.g[i3].length();
        }
        byte[] bArrA = k.x.e0.a(this.f, this.f1892h);
        int length2 = bArrA.length + 6;
        int i4 = this.e;
        byte[] bArr = new byte[length2 + (i4 * 3) + (length * 2)];
        this.d = bArr;
        k.x.s0.f(i4, bArr, 0);
        k.x.s0.f(bArrA.length + 1, this.d, 2);
        byte[] bArr2 = this.d;
        bArr2[4] = 0;
        bArr2[5] = 1;
        System.arraycopy(bArrA, 0, bArr2, 6, bArrA.length);
        int length3 = bArrA.length + 4 + 2;
        while (true) {
            String[] strArr = this.g;
            if (i2 >= strArr.length) {
                return;
            }
            k.x.s0.f(strArr[i2].length(), this.d, length3);
            byte[] bArr3 = this.d;
            bArr3[length3 + 2] = 1;
            k.x.y0.e(this.g[i2], bArr3, length3 + 3);
            length3 += (this.g[i2].length() * 2) + 3;
            i2++;
        }
    }

    private void I() {
        byte[] bArr = new byte[4];
        this.d = bArr;
        k.x.s0.f(this.e, bArr, 0);
        byte[] bArr2 = this.d;
        bArr2[2] = 1;
        bArr2[3] = 4;
        this.c = f1889j;
    }

    void A(int i2) {
        k.y.a.a(this.c == f1889j);
        this.e = i2;
        I();
    }

    public String B() {
        return this.f;
    }

    public int C() {
        return this.e;
    }

    public int D(String str) {
        String[] strArr;
        int i2 = 0;
        boolean z = false;
        while (true) {
            strArr = this.g;
            if (i2 >= strArr.length || z) {
                break;
            }
            if (strArr[i2].equals(str)) {
                z = true;
            }
            i2++;
        }
        if (z) {
            return 0;
        }
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[this.g.length] = str;
        this.g = strArr2;
        return strArr2.length - 1;
    }

    public String E(int i2) {
        return this.g[i2];
    }

    public a3 F() {
        return this.c;
    }

    @Override // k.x.c1
    public byte[] y() {
        a3 a3Var = this.c;
        if (a3Var == f1889j) {
            I();
        } else if (a3Var == f1890k) {
            H();
        } else if (a3Var == f1891l) {
            G();
        } else {
            f1888i.f("unsupported supbook type - defaulting to internal");
            I();
        }
        return this.d;
    }

    public b3(String str, k.w wVar) {
        super(k.x.z0.f);
        this.f = str;
        this.e = 1;
        this.g = new String[0];
        this.f1892h = wVar;
        this.c = f1890k;
    }

    public b3(k.a0.a.d3 d3Var, k.w wVar) {
        super(k.x.z0.f);
        this.f1892h = wVar;
        if (d3Var.C() == k.a0.a.d3.g) {
            this.c = f1889j;
            this.e = d3Var.A();
        } else if (d3Var.C() == k.a0.a.d3.f1796h) {
            this.c = f1890k;
            this.e = d3Var.A();
            this.f = d3Var.z();
            this.g = new String[this.e];
            for (int i2 = 0; i2 < this.e; i2++) {
                this.g[i2] = d3Var.B(i2);
            }
        }
        if (d3Var.C() == k.a0.a.d3.f1797i) {
            f1888i.f("Supbook type is addin");
        }
    }
}
