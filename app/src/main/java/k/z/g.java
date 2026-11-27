package k.z;

/* loaded from: classes.dex */
public final class g {
    private static g[] b = new g[0];
    public static g c = new g(0, "horizontal");
    private int a;

    static {
        new g(255, "vertical");
        new g(90, "up 90");
        new g(180, "down 90");
        new g(45, "up 45");
        new g(135, "down 45");
        new g(255, "stacked");
    }

    protected g(int i2, String str) {
        this.a = i2;
        g[] gVarArr = b;
        g[] gVarArr2 = new g[gVarArr.length + 1];
        b = gVarArr2;
        System.arraycopy(gVarArr, 0, gVarArr2, 0, gVarArr.length);
        b[gVarArr.length] = this;
    }

    public static g a(int i2) {
        int i3 = 0;
        while (true) {
            g[] gVarArr = b;
            if (i3 >= gVarArr.length) {
                return c;
            }
            if (gVarArr[i3].b() == i2) {
                return b[i3];
            }
            i3++;
        }
    }

    public int b() {
        return this.a;
    }
}
