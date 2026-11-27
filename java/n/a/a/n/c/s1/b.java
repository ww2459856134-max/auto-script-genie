package n.a.a.n.c.s1;

/* loaded from: classes.dex */
public final class b {
    private final int a;
    private final String b;
    private final int c;
    private final int d;
    private final byte e;
    private final byte[] f;

    b(int i2, String str, int i3, int i4, byte b, byte[] bArr) {
        this.a = i2;
        this.b = str;
        this.c = i3;
        this.d = i4;
        this.e = b;
        this.f = bArr == null ? null : (byte[]) bArr.clone();
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    public byte[] e() {
        return (byte[]) this.f.clone();
    }

    public byte f() {
        return this.e;
    }

    public boolean g() {
        return this.c == this.d;
    }

    public boolean h() {
        return 30 == this.d;
    }

    public String toString() {
        return b.class.getName() + " [" + this.a + " " + this.b + "]";
    }
}
