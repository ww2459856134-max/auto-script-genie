package o.a;

import android.graphics.Color;

/* loaded from: classes3.dex */
public class a {
    private int a;
    private int b;
    private int c;

    public a(int i2, int i3, int i4) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.a = i2;
        this.b = i3;
        this.c = i4;
    }

    public static boolean d(a aVar, a aVar2) {
        return e(aVar, aVar2, 10);
    }

    public static boolean e(a aVar, a aVar2, int i2) {
        return aVar.c() == aVar2.c() && aVar.a() == aVar2.a() && aVar.b() == aVar2.b();
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public String toString() {
        return "" + this.a + "," + this.b + "," + this.c;
    }

    public a(int i2) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.a = Color.red(i2);
        this.b = Color.green(i2);
        this.c = Color.blue(i2);
    }
}
