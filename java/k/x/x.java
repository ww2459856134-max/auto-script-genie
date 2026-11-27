package k.x;

/* loaded from: classes.dex */
public class x {
    private static int f;
    private static int g;

    /* renamed from: h, reason: collision with root package name */
    private static int f2170h;
    private boolean a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;

    static {
        k.y.c.b(x.class);
        f = 1;
        g = 2;
        f2170h = 4;
    }

    public x(byte[] bArr) {
        int iC = s0.c(bArr[0], bArr[1]);
        this.a = (f & iC) != 0;
        this.b = (g & iC) != 0;
        this.c = (iC & f2170h) != 0;
        this.e = s0.d(bArr[10], bArr[11], bArr[12], bArr[13]);
        this.d = s0.d(bArr[14], bArr[15], bArr[16], bArr[17]);
    }

    public void a() {
        this.d++;
    }

    public void b() {
        this.d--;
    }

    public byte[] c() {
        byte[] bArr = new byte[18];
        int i2 = this.a ? f | 0 : 0;
        if (this.b) {
            i2 |= g;
        }
        if (this.c) {
            i2 |= f2170h;
        }
        s0.f(i2, bArr, 0);
        s0.a(this.e, bArr, 10);
        s0.a(this.d, bArr, 14);
        return bArr;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public x(int i2, int i3) {
        this.e = i2;
        this.d = i3;
        this.c = true;
    }
}
