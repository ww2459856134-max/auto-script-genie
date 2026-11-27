package k.x;

/* loaded from: classes.dex */
public class f {
    public String a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public int f2019h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f2020i;

    public f(g gVar, byte[] bArr) {
        this.f2020i = bArr;
        int i2 = 64;
        int iC = s0.c(bArr[64], bArr[65]);
        if (iC > 64) {
            g.a.f("property set name exceeds max length - truncating");
        } else {
            i2 = iC;
        }
        byte[] bArr2 = this.f2020i;
        this.b = bArr2[66];
        this.c = bArr2[67];
        this.d = s0.d(bArr2[116], bArr2[117], bArr2[118], bArr2[119]);
        byte[] bArr3 = this.f2020i;
        this.e = s0.d(bArr3[120], bArr3[121], bArr3[122], bArr3[123]);
        byte[] bArr4 = this.f2020i;
        this.f = s0.d(bArr4[68], bArr4[69], bArr4[70], bArr4[71]);
        byte[] bArr5 = this.f2020i;
        this.g = s0.d(bArr5[72], bArr5[73], bArr5[74], bArr5[75]);
        byte[] bArr6 = this.f2020i;
        this.f2019h = s0.d(bArr6[76], bArr6[77], bArr6[78], bArr6[79]);
        int i3 = i2 > 2 ? (i2 - 1) / 2 : 0;
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i4 = 0; i4 < i3; i4++) {
            stringBuffer.append((char) this.f2020i[i4 * 2]);
        }
        this.a = stringBuffer.toString();
    }

    public void a(int i2) {
        this.f2019h = i2;
        s0.a(i2, this.f2020i, 76);
    }

    public void b(int i2) {
        int i3 = i2 == 0 ? 0 : 1;
        this.c = i3;
        this.f2020i[67] = (byte) i3;
    }

    public void c(int i2) {
        this.g = i2;
        s0.a(i2, this.f2020i, 72);
    }

    public void d(int i2) {
        this.f = i2;
        s0.a(i2, this.f2020i, 68);
    }

    public void e(int i2) {
        this.e = i2;
        s0.a(i2, this.f2020i, 120);
    }

    public void f(int i2) {
        this.d = i2;
        s0.a(i2, this.f2020i, 116);
    }

    public void g(int i2) {
        this.b = i2;
        this.f2020i[66] = (byte) i2;
    }

    public f(g gVar, String str) {
        this.f2020i = new byte[128];
        k.y.a.a(str.length() < 32);
        s0.f((str.length() + 1) * 2, this.f2020i, 64);
        for (int i2 = 0; i2 < str.length(); i2++) {
            this.f2020i[i2 * 2] = (byte) str.charAt(i2);
        }
    }
}
