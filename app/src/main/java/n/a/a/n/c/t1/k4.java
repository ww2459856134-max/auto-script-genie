package n.a.a.n.c.t1;

import java.util.regex.Pattern;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public final class k4 extends i4 {
    private final String b;
    private final Pattern c;

    public k4(String str, g4 g4Var) {
        super(g4Var);
        this.b = str;
        int iC = g4Var.c();
        if (iC == 0 || iC == 1 || iC == 2) {
            this.c = g(str);
        } else {
            this.c = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pattern g(String str) {
        char cCharAt;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        boolean z = false;
        while (i2 < length) {
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 == '$' || cCharAt2 == '.') {
                sb.append("\\");
                sb.append(cCharAt2);
                continue;
            } else {
                if (cCharAt2 == '?') {
                    sb.append(NameUtil.PERIOD);
                } else if (cCharAt2 != '[') {
                    if (cCharAt2 == '~') {
                        int i3 = i2 + 1;
                        if (i3 >= length || !((cCharAt = str.charAt(i3)) == '*' || cCharAt == '?')) {
                            sb.append('~');
                        } else {
                            sb.append('[');
                            sb.append(cCharAt);
                            sb.append(']');
                            i2 = i3;
                        }
                    } else if (cCharAt2 != ']' && cCharAt2 != '^') {
                        switch (cCharAt2) {
                            case '(':
                            case ')':
                                break;
                            case '*':
                                sb.append(".*");
                                break;
                            default:
                                sb.append(cCharAt2);
                                continue;
                        }
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z) {
            return Pattern.compile(sb.toString(), 2);
        }
        return null;
    }

    @Override // n.a.a.n.c.t1.z3
    public boolean a(n.a.a.n.c.r1.w0 w0Var) {
        if (w0Var instanceof n.a.a.n.c.r1.l) {
            int iE = e();
            return (iE == 0 || iE == 1) ? this.b.isEmpty() : iE == 2 && this.b.length() != 0;
        }
        if (!(w0Var instanceof n.a.a.n.c.r1.m0)) {
            return false;
        }
        String stringValue = ((n.a.a.n.c.r1.m0) w0Var).getStringValue();
        if (stringValue.length() >= 1 || this.b.length() >= 1) {
            Pattern pattern = this.c;
            return pattern != null ? d(pattern.matcher(stringValue).matches()) : c(stringValue.compareToIgnoreCase(this.b));
        }
        int iE2 = e();
        return iE2 == 0 || iE2 == 2;
    }

    @Override // n.a.a.n.c.t1.i4
    protected String f() {
        Pattern pattern = this.c;
        return pattern == null ? this.b : pattern.pattern();
    }
}
