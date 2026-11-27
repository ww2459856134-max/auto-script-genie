package n.a.a.h.a;

import androidx.recyclerview.widget.k0;
import java.beans.ConstructorProperties;

/* loaded from: classes.dex */
public class a {
    public static final a b = new a(255, 255, 255);
    public static final a c = new a(192, 192, 192);
    public static final a d = new a(128, 128, 128);
    public static final a e = new a(64, 64, 64);
    public static final a f = new a(0, 0, 0);
    public static final a g = new a(255, 0, 0);

    /* renamed from: h, reason: collision with root package name */
    public static final a f2272h = new a(255, 175, 175);

    /* renamed from: i, reason: collision with root package name */
    public static final a f2273i = new a(255, k0.a.DEFAULT_DRAG_ANIMATION_DURATION, 0);

    /* renamed from: j, reason: collision with root package name */
    public static final a f2274j = new a(255, 255, 0);

    /* renamed from: k, reason: collision with root package name */
    public static final a f2275k = new a(0, 255, 0);

    /* renamed from: l, reason: collision with root package name */
    public static final a f2276l = new a(255, 0, 255);

    /* renamed from: m, reason: collision with root package name */
    public static final a f2277m = new a(0, 255, 255);

    /* renamed from: n, reason: collision with root package name */
    public static final a f2278n = new a(0, 0, 255);
    int a;

    public a(int i2, int i3, int i4) {
        this(i2, i3, i4, 255);
    }

    private static void e(int i2, int i3, int i4, int i5) {
        boolean z;
        String str = "";
        if (i5 < 0 || i5 > 255) {
            str = " Alpha";
            z = true;
        } else {
            z = false;
        }
        if (i2 < 0 || i2 > 255) {
            str = str + " Red";
            z = true;
        }
        if (i3 < 0 || i3 > 255) {
            str = str + " Green";
            z = true;
        }
        if (i4 < 0 || i4 > 255) {
            str = str + " Blue";
            z = true;
        }
        if (!z) {
            return;
        }
        throw new IllegalArgumentException("Color parameter outside of expected range:" + str);
    }

    public int a() {
        return (c() >> 0) & 255;
    }

    public int b() {
        return (c() >> 8) & 255;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        return (c() >> 16) & 255;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).c() == c();
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return a.class.getName() + "[r=" + d() + ",g=" + b() + ",b=" + a() + "]";
    }

    @ConstructorProperties({"red", "green", "blue", "alpha"})
    public a(int i2, int i3, int i4, int i5) {
        this.a = ((i5 & 255) << 24) | ((i2 & 255) << 16) | ((i3 & 255) << 8) | ((i4 & 255) << 0);
        e(i2, i3, i4, i5);
    }

    public a(int i2) {
        this.a = i2 | (-16777216);
    }
}
