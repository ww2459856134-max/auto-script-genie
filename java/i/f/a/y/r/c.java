package i.f.a.y.r;

import i.f.a.r;

/* loaded from: classes.dex */
public final class c {
    private final int a;
    private final int[] b;
    private final r[] c;

    public c(int i2, int[] iArr, int i3, int i4, int i5) {
        this.a = i2;
        this.b = iArr;
        float f = i5;
        this.c = new r[]{new r(i3, f), new r(i4, f)};
    }

    public r[] a() {
        return this.c;
    }

    public int[] b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.a == ((c) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
