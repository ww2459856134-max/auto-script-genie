package k.z;

/* loaded from: classes.dex */
public final class m {
    private static m[] b = new m[0];
    public static final m c = new m(0, "normal");
    private int a;

    static {
        new m(1, "super");
        new m(2, "sub");
    }

    protected m(int i2, String str) {
        this.a = i2;
        m[] mVarArr = b;
        m[] mVarArr2 = new m[mVarArr.length + 1];
        b = mVarArr2;
        System.arraycopy(mVarArr, 0, mVarArr2, 0, mVarArr.length);
        b[mVarArr.length] = this;
    }

    public static m a(int i2) {
        int i3 = 0;
        while (true) {
            m[] mVarArr = b;
            if (i3 >= mVarArr.length) {
                return c;
            }
            if (mVarArr[i3].b() == i2) {
                return b[i3];
            }
            i3++;
        }
    }

    public int b() {
        return this.a;
    }
}
