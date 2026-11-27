package k.x;

import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class x0 implements k.r {
    private k.s a;
    private int b;
    private int c;
    private int d;
    private int e;

    public x0(k.s sVar, int i2, int i3, int i4, int i5) {
        this.a = sVar;
        this.c = i3;
        this.e = i5;
        this.b = i2;
        this.d = i4;
    }

    public boolean a(x0 x0Var) {
        if (x0Var == this) {
            return true;
        }
        return this.e >= x0Var.c && this.c <= x0Var.e && this.d >= x0Var.b && this.b <= x0Var.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return this.b == x0Var.b && this.d == x0Var.d && this.c == x0Var.c && this.e == x0Var.e;
    }

    @Override // k.r
    public k.c getBottomRight() {
        return (this.d >= this.a.d() || this.e >= this.a.b()) ? new d0(this.d, this.e) : this.a.a(this.d, this.e);
    }

    @Override // k.r
    public k.c getTopLeft() {
        return (this.b >= this.a.d() || this.c >= this.a.b()) ? new d0(this.b, this.c) : this.a.a(this.b, this.c);
    }

    public int hashCode() {
        return (((this.c ^ 65535) ^ this.e) ^ this.b) ^ this.d;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        m.c(this.b, this.c, stringBuffer);
        stringBuffer.append(NameUtil.HYPHEN);
        m.c(this.d, this.e, stringBuffer);
        return stringBuffer.toString();
    }

    public x0(x0 x0Var, k.s sVar) {
        this.a = sVar;
        this.c = x0Var.c;
        this.e = x0Var.e;
        this.b = x0Var.b;
        this.d = x0Var.d;
    }
}
