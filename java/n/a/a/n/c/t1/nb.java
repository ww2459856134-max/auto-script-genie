package n.a.a.n.c.t1;

import java.util.Locale;

/* loaded from: classes.dex */
final class nb extends ub {
    nb() {
    }

    @Override // n.a.a.n.c.t1.ub
    protected n.a.a.n.c.r1.w0 l(String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c : str.toCharArray()) {
            if (z) {
                sb.append(String.valueOf(c).toUpperCase(Locale.ROOT));
            } else {
                sb.append(String.valueOf(c).toLowerCase(Locale.ROOT));
            }
            z = !Character.isLetter(c);
        }
        return new n.a.a.n.c.r1.m0(sb.toString());
    }
}
