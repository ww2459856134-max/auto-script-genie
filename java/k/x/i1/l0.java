package k.x.i1;

/* loaded from: classes.dex */
final class l0 {
    private static l0[] b = new l0[0];
    public static final l0 c = new l0(0);
    public static final l0 d = new l0(75);
    public static final l0 e = new l0(201);
    public static final l0 f = new l0(202);
    public static final l0 g = new l0(-1);
    private int a;

    l0(int i2) {
        this.a = i2;
        l0[] l0VarArr = b;
        l0[] l0VarArr2 = new l0[l0VarArr.length + 1];
        b = l0VarArr2;
        System.arraycopy(l0VarArr, 0, l0VarArr2, 0, l0VarArr.length);
        b[l0VarArr.length] = this;
    }

    static l0 a(int i2) {
        l0 l0Var = g;
        int i3 = 0;
        boolean z = false;
        while (true) {
            l0[] l0VarArr = b;
            if (i3 >= l0VarArr.length || z) {
                break;
            }
            if (l0VarArr[i3].a == i2) {
                l0Var = l0VarArr[i3];
                z = true;
            }
            i3++;
        }
        return l0Var;
    }

    public int b() {
        return this.a;
    }
}
