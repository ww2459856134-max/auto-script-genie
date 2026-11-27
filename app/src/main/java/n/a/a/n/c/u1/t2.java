package n.a.a.n.c.u1;

import com.auto.exceldeps.log4j.util.Chars;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class t2 extends s2 {
    private final boolean d;
    private final String e;

    public t2(String str) {
        if (str.length() > 255) {
            throw new IllegalArgumentException("String literals in formulas can't be bigger than 255 characters ASCII");
        }
        this.d = n.a.a.o.j1.e(str);
        this.e = str;
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return n.a.a.o.v0.c("value", new Supplier() { // from class: n.a.a.n.c.u1.g0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.p();
            }
        });
    }

    @Override // n.a.a.n.c.u1.k2
    public int l() {
        return (this.e.length() * (this.d ? 2 : 1)) + 3;
    }

    @Override // n.a.a.n.c.u1.k2
    public String o() {
        String str = this.e;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 4);
        sb.append(Chars.DQUOTE);
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\"') {
                sb.append(Chars.DQUOTE);
            }
            sb.append(cCharAt);
        }
        sb.append(Chars.DQUOTE);
        return sb.toString();
    }

    public String p() {
        return this.e;
    }
}
