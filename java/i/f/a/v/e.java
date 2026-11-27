package i.f.a.v;

import java.util.List;

/* loaded from: classes.dex */
public final class e {
    private final byte[] a;
    private int b;
    private final String c;
    private final List<byte[]> d;
    private final String e;
    private Object f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1684h;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public int c() {
        return this.b;
    }

    public Object d() {
        return this.f;
    }

    public byte[] e() {
        return this.a;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.f1684h;
    }

    public String h() {
        return this.c;
    }

    public boolean i() {
        return this.g >= 0 && this.f1684h >= 0;
    }

    public void j(Integer num) {
    }

    public void k(Integer num) {
    }

    public void l(int i2) {
        this.b = i2;
    }

    public void m(Object obj) {
        this.f = obj;
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this.a = bArr;
        this.b = bArr == null ? 0 : bArr.length * 8;
        this.c = str;
        this.d = list;
        this.e = str2;
        this.g = i3;
        this.f1684h = i2;
    }
}
