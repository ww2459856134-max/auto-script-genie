package n.a.a.p.a.a;

import org.apache.poi.xssf.usermodel.f2;
import org.apache.poi.xssf.usermodel.i2;
import org.apache.poi.xssf.usermodel.q1;

/* loaded from: classes.dex */
abstract class w<T> implements p<T> {
    private final i2 a;
    private final n.a.a.n.e.m b;
    private final int c;
    private final q1 d;

    protected w(i2 i2Var, n.a.a.n.e.m mVar) {
        this.a = i2Var;
        n.a.a.n.e.m mVarC = mVar.C();
        this.b = mVarC;
        this.c = mVarC.u();
        this.d = i2Var.getWorkbook().getCreationHelper().a();
    }

    @Override // n.a.a.p.a.a.p
    public boolean a() {
        return true;
    }

    @Override // n.a.a.p.a.a.p
    public String d() {
        return this.b.E(this.a.c(), true);
    }

    @Override // n.a.a.p.a.a.p
    public int e() {
        return this.c;
    }

    protected n.a.a.n.d.l g(int i2) {
        if (i2 < 0 || i2 >= this.c) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index must be between 0 and ");
            sb.append(this.c - 1);
            sb.append(" (inclusive), given: ");
            sb.append(i2);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int iB = this.b.b();
        int iA = this.b.a();
        int iG = (this.b.g() - iA) + 1;
        int i3 = iA + (i2 % iG);
        f2 f2VarF = this.a.f(iB + (i2 / iG));
        if (f2VarF == null) {
            return null;
        }
        return this.d.d(f2VarF.x(i3));
    }
}
