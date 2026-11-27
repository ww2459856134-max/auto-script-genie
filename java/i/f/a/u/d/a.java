package i.f.a.u.d;

import com.auto.exceldeps.log4j.util.Chars;
import i.f.a.r;

/* loaded from: classes.dex */
final class a {
    private final int a;
    private final int b;

    a(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    int a() {
        return this.a;
    }

    int b() {
        return this.b;
    }

    r c() {
        return new r(this.a, this.b);
    }

    public String toString() {
        return "<" + this.a + Chars.SPACE + this.b + '>';
    }
}
