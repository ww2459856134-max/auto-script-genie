package k.z;

/* loaded from: classes.dex */
public class k {
    private static k[] b = new k[0];
    public static final k c = new k(0, "None");
    private int a;

    static {
        new k(1, "Solid");
        new k(2, "Gray 50%");
        new k(3, "Gray 75%");
        new k(4, "Gray 25%");
        new k(5, "Pattern 1");
        new k(6, "Pattern 2");
        new k(7, "Pattern 3");
        new k(8, "Pattern 4");
        new k(9, "Pattern 5");
        new k(10, "Pattern 6");
        new k(11, "Pattern 7");
        new k(12, "Pattern 8");
        new k(13, "Pattern 9");
        new k(14, "Pattern 10");
        new k(15, "Pattern 11");
        new k(16, "Pattern 12");
        new k(17, "Pattern 13");
        new k(18, "Pattern 14");
    }

    protected k(int i2, String str) {
        this.a = i2;
        k[] kVarArr = b;
        k[] kVarArr2 = new k[kVarArr.length + 1];
        b = kVarArr2;
        System.arraycopy(kVarArr, 0, kVarArr2, 0, kVarArr.length);
        b[kVarArr.length] = this;
    }

    public static k a(int i2) {
        int i3 = 0;
        while (true) {
            k[] kVarArr = b;
            if (i3 >= kVarArr.length) {
                return c;
            }
            if (kVarArr[i3].b() == i2) {
                return b[i3];
            }
            i3++;
        }
    }

    public int b() {
        return this.a;
    }
}
