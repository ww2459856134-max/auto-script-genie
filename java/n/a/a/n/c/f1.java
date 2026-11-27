package n.a.a.n.c;

import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
final class f1 implements d1 {
    private final int a;
    private final int b;
    private final h1[] c;

    public f1(int i2, int i3, h1[] h1VarArr) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Invalid firstSheetIndex: " + i2 + ".");
        }
        if (i3 >= i2) {
            this.a = i2;
            this.b = i3;
            this.c = (h1[]) h1VarArr.clone();
        } else {
            throw new IllegalArgumentException("Invalid lastSheetIndex: " + i3 + " for firstSheetIndex: " + i2 + ".");
        }
    }

    @Override // n.a.a.n.c.d1
    public int d() {
        return this.b;
    }

    public int e(int i2) {
        int iMax = 0;
        boolean z = false;
        for (int i3 = this.a; i3 <= this.b; i3++) {
            if (i2 >= this.c[i3 - this.a].c()) {
                z = true;
            }
        }
        if (!z) {
            return i2;
        }
        for (int i4 = this.a; i4 <= this.b; i4++) {
            iMax = Math.max(iMax, this.c[i4 - this.a].b());
        }
        return Math.min(i2, iMax);
    }

    public n.a.a.n.c.r1.w0 f(int i2, int i3, int i4) {
        return h(i2).a(i3, i4);
    }

    @Override // n.a.a.n.c.d1
    public int g() {
        return this.a;
    }

    public h1 h(int i2) {
        int i3 = this.a;
        if (i2 >= i3 && i2 <= this.b) {
            return this.c[i2 - i3];
        }
        throw new IllegalArgumentException("Invalid SheetIndex: " + i2 + " - Outside range " + this.a + " : " + this.b);
    }

    public String n(int i2) {
        return h(i2).e();
    }

    public String p() {
        StringBuilder sb = new StringBuilder();
        sb.append(n(this.a));
        if (this.a != this.b) {
            sb.append(NameUtil.COLON);
            sb.append(n(this.b));
        }
        return sb.toString();
    }

    public f1(int i2, h1 h1Var) {
        this(i2, i2, new h1[]{h1Var});
    }
}
