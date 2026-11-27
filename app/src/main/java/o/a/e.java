package o.a;

/* loaded from: classes3.dex */
public class e {
    private int a;
    private int b;

    public e(int i2, int i3) {
        this.a = 0;
        this.b = 0;
        this.a = i2;
        this.b = i3;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public void c(int i2) {
        this.a = i2;
    }

    public void d(int i2) {
        this.b = i2;
    }

    public String toString() {
        return "{" + this.a + "," + this.b + "}";
    }
}
