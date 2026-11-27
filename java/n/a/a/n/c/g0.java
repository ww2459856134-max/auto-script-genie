package n.a.a.n.c;

import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
final class g0 {
    private final int a;
    private final int b;
    private final int c;
    private int d;

    public g0(int i2, int i3, int i4) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i2;
    }

    public boolean a(int i2, int i3, int i4) {
        if (i3 != this.b || i4 != this.c || i2 != this.d + 1) {
            return false;
        }
        this.d = i2;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        n.a.a.n.e.s sVar = new n.a.a.n.e.s(this.a, this.b, false, false);
        n.a.a.n.e.s sVar2 = new n.a.a.n.e.s(this.d, this.c, false, false);
        sb.append(g0.class.getName());
        sb.append(" [");
        sb.append(sVar.g());
        sb.append(NameUtil.COLON);
        sb.append(sVar2.g());
        sb.append("]");
        return sb.toString();
    }
}
