package n.a.a.n.c;

import com.auto.exceldeps.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class g1 extends b1 {
    private final p0 c;

    public g1(String str, p0 p0Var, p0 p0Var2) {
        super(str, p0Var);
        this.c = p0Var2;
    }

    @Override // n.a.a.n.c.b1
    protected void b(StringBuilder sb) {
        super.b(sb);
        sb.append(NameUtil.COLON);
        if (!this.c.b()) {
            sb.append(this.c.a());
            return;
        }
        sb.append(Chars.QUOTE);
        sb.append(this.c.a());
        sb.append("'");
    }

    public p0 e() {
        return this.c;
    }
}
