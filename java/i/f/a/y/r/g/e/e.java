package i.f.a.y.r.g.e;

/* loaded from: classes.dex */
final class e extends i {
    private final String c;
    private final String d;

    e(i.f.a.v.a aVar, String str, String str2) {
        super(aVar);
        this.c = str2;
        this.d = str;
    }

    private void k(StringBuilder sb, int i2) {
        int iF = b().f(i2, 16);
        if (iF == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.c);
        sb.append(')');
        int i3 = iF % 32;
        int i4 = iF / 32;
        int i5 = (i4 % 12) + 1;
        int i6 = i4 / 12;
        if (i6 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i6);
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i3 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i3);
    }

    @Override // i.f.a.y.r.g.e.j
    public String d() throws i.f.a.k {
        if (c().k() != 84) {
            throw i.f.a.k.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        j(sb, 48, 20);
        k(sb, 68);
        return sb.toString();
    }

    @Override // i.f.a.y.r.g.e.i
    protected void h(StringBuilder sb, int i2) {
        sb.append('(');
        sb.append(this.d);
        sb.append(i2 / 100000);
        sb.append(')');
    }

    @Override // i.f.a.y.r.g.e.i
    protected int i(int i2) {
        return i2 % 100000;
    }
}
