package k.z;

/* loaded from: classes.dex */
public class a {
    private static a[] b = new a[0];
    public static a c = new a(0, "general");
    private int a;

    static {
        new a(1, "left");
        new a(2, "centre");
        new a(3, "right");
        new a(4, "fill");
        new a(5, "justify");
    }

    protected a(int i2, String str) {
        this.a = i2;
        a[] aVarArr = b;
        a[] aVarArr2 = new a[aVarArr.length + 1];
        b = aVarArr2;
        System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
        b[aVarArr.length] = this;
    }

    public static a a(int i2) {
        int i3 = 0;
        while (true) {
            a[] aVarArr = b;
            if (i3 >= aVarArr.length) {
                return c;
            }
            if (aVarArr[i3].b() == i2) {
                return b[i3];
            }
            i3++;
        }
    }

    public int b() {
        return this.a;
    }
}
