package n.a.a.n.c;

import com.auto.exceldeps.log4j.util.Chars;

/* loaded from: classes.dex */
public class b1 {
    private final String a;
    private final p0 b;

    public b1(String str, p0 p0Var) {
        this.a = str;
        this.b = p0Var;
    }

    public String a() {
        StringBuilder sb = new StringBuilder(32);
        b(sb);
        return sb.toString();
    }

    protected void b(StringBuilder sb) {
        if (this.a != null) {
            sb.append(" [");
            sb.append(this.b.a());
            sb.append("]");
        }
        if (!this.b.b()) {
            sb.append(this.b.a());
            return;
        }
        sb.append(Chars.QUOTE);
        sb.append(this.b.a());
        sb.append("'");
    }

    public String c() {
        return this.a;
    }

    public p0 d() {
        return this.b;
    }

    public String toString() {
        return getClass().getName() + " [" + a() + "]";
    }
}
