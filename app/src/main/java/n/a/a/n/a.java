package n.a.a.n;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import n.a.a.n.e.s;

/* loaded from: classes.dex */
public enum a {
    EXCEL97(WXMediaMessage.THUMB_LENGTH_LIMIT, 256, 30, 3, 4000, 32767),
    EXCEL2007(1048576, 16384, 255, Integer.MAX_VALUE, 64000, 32767);

    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    a(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i6;
        this.g = i7;
    }

    public int a() {
        return this.d - 1;
    }

    public String b() {
        return s.f(a());
    }

    public int c() {
        return this.c - 1;
    }

    public int d() {
        return this.f;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.c;
    }

    public int g() {
        return this.g;
    }
}
