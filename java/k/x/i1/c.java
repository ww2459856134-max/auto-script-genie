package k.x.i1;

/* loaded from: classes.dex */
final class c {
    private static c[] b = new c[0];
    public static final c c;
    public static final c d;
    private int a;

    static {
        new c(0, "Error");
        c = new c(1, "Unknown");
        new c(2, "EMF");
        new c(3, "WMF");
        new c(4, "PICT");
        new c(5, "JPEG");
        d = new c(6, "PNG");
        new c(7, "DIB");
        new c(32, "FIRST");
        new c(255, "LAST");
    }

    private c(int i2, String str) {
        this.a = i2;
        c[] cVarArr = b;
        c[] cVarArr2 = new c[cVarArr.length + 1];
        System.arraycopy(cVarArr, 0, cVarArr2, 0, cVarArr.length);
        cVarArr2[b.length] = this;
        b = cVarArr2;
    }

    public static c a(int i2) {
        c cVar = c;
        int i3 = 0;
        while (true) {
            c[] cVarArr = b;
            if (i3 >= cVarArr.length) {
                return cVar;
            }
            if (cVarArr[i3].a == i2) {
                return cVarArr[i3];
            }
            i3++;
        }
    }

    public int b() {
        return this.a;
    }
}
