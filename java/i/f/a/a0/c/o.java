package i.f.a.a0.c;

/* loaded from: classes.dex */
public enum o {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: h, reason: collision with root package name */
    private static final o[] f1658h;
    private final int c;

    static {
        o oVar = L;
        o oVar2 = M;
        o oVar3 = Q;
        f1658h = new o[]{oVar2, oVar, H, oVar3};
    }

    o(int i2) {
        this.c = i2;
    }

    public static o a(int i2) {
        if (i2 >= 0) {
            o[] oVarArr = f1658h;
            if (i2 < oVarArr.length) {
                return oVarArr[i2];
            }
        }
        throw new IllegalArgumentException();
    }

    public int b() {
        return this.c;
    }
}
