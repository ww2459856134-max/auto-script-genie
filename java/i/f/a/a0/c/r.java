package i.f.a.a0.c;

/* loaded from: classes.dex */
public final class r {
    private final boolean a;

    r(boolean z) {
        this.a = z;
    }

    public void a(i.f.a.r[] rVarArr) {
        if (!this.a || rVarArr == null || rVarArr.length < 3) {
            return;
        }
        i.f.a.r rVar = rVarArr[0];
        rVarArr[0] = rVarArr[2];
        rVarArr[2] = rVar;
    }
}
