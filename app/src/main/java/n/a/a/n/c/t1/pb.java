package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class pb extends ub {
    pb() {
    }

    private boolean m(char c) {
        return c >= ' ';
    }

    @Override // n.a.a.n.c.t1.ub
    protected n.a.a.n.c.r1.w0 l(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (m(c)) {
                sb.append(c);
            }
        }
        return new n.a.a.n.c.r1.m0(sb.toString());
    }
}
