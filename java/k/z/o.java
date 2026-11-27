package k.z;

/* loaded from: classes.dex */
public class o {
    private static o[] b = new o[0];
    public static o c;
    private int a;

    static {
        new o(0, "top");
        new o(1, "centre");
        c = new o(2, "bottom");
        new o(3, "Justify");
    }

    protected o(int i2, String str) {
        this.a = i2;
        o[] oVarArr = b;
        o[] oVarArr2 = new o[oVarArr.length + 1];
        b = oVarArr2;
        System.arraycopy(oVarArr, 0, oVarArr2, 0, oVarArr.length);
        b[oVarArr.length] = this;
    }

    public static o a(int i2) {
        int i3 = 0;
        while (true) {
            o[] oVarArr = b;
            if (i3 >= oVarArr.length) {
                return c;
            }
            if (oVarArr[i3].b() == i2) {
                return b[i3];
            }
            i3++;
        }
    }

    public int b() {
        return this.a;
    }
}
