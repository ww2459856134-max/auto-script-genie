package k.z;

import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes.dex */
public final class n {
    private static n[] b = new n[0];
    public static final n c = new n(0, "none");
    public static final n d = new n(1, "single");
    private int a;

    static {
        new n(2, XmlErrorCodes.DOUBLE);
        new n(33, "single accounting");
        new n(34, "double accounting");
    }

    protected n(int i2, String str) {
        this.a = i2;
        n[] nVarArr = b;
        n[] nVarArr2 = new n[nVarArr.length + 1];
        b = nVarArr2;
        System.arraycopy(nVarArr, 0, nVarArr2, 0, nVarArr.length);
        b[nVarArr.length] = this;
    }

    public static n a(int i2) {
        int i3 = 0;
        while (true) {
            n[] nVarArr = b;
            if (i3 >= nVarArr.length) {
                return c;
            }
            if (nVarArr[i3].b() == i2) {
                return b[i3];
            }
            i3++;
        }
    }

    public int b() {
        return this.a;
    }
}
