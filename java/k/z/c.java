package k.z;

import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes.dex */
public class c {
    private static c[] c = new c[0];
    public static final c d = new c(0, "none");
    private int a;
    private String b;

    static {
        new c(1, "thin");
        new c(2, "medium");
        new c(3, "dashed");
        new c(4, "dotted");
        new c(5, "thick");
        new c(6, XmlErrorCodes.DOUBLE);
        new c(7, "hair");
        new c(8, "medium dashed");
        new c(9, "dash dot");
        new c(10, "medium dash dot");
        new c(11, "Dash dot dot");
        new c(12, "Medium dash dot dot");
        new c(13, "Slanted dash dot");
    }

    protected c(int i2, String str) {
        this.a = i2;
        this.b = str;
        c[] cVarArr = c;
        c[] cVarArr2 = new c[cVarArr.length + 1];
        c = cVarArr2;
        System.arraycopy(cVarArr, 0, cVarArr2, 0, cVarArr.length);
        c[cVarArr.length] = this;
    }

    public static c b(int i2) {
        int i3 = 0;
        while (true) {
            c[] cVarArr = c;
            if (i3 >= cVarArr.length) {
                return d;
            }
            if (cVarArr[i3].c() == i2) {
                return c[i3];
            }
            i3++;
        }
    }

    public String a() {
        return this.b;
    }

    public int c() {
        return this.a;
    }
}
