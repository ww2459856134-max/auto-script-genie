package n.a.a.n.c;

import com.auto.exceldeps.log4j.util.Chars;

/* loaded from: classes.dex */
public class p0 {
    private final String a;
    private final boolean b;

    public p0(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public String a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(p0.class.getName());
        sb.append(" [");
        if (this.b) {
            sb.append(Chars.QUOTE);
            sb.append(this.a);
            sb.append("'");
        } else {
            sb.append(this.a);
        }
        sb.append(']');
        return sb.toString();
    }
}
