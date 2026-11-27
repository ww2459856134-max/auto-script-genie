package i.f.a.y;

/* loaded from: classes.dex */
public final class e extends p {

    /* renamed from: i, reason: collision with root package name */
    static final int[] f1699i = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: h, reason: collision with root package name */
    private final int[] f1700h = new int[4];

    private static void s(StringBuilder sb, int i2) throws i.f.a.k {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f1699i[i3]) {
                sb.insert(0, (char) (i3 + 48));
                return;
            }
        }
        throw i.f.a.k.a();
    }

    @Override // i.f.a.y.p
    protected int l(i.f.a.v.a aVar, int[] iArr, StringBuilder sb) throws i.f.a.k {
        int[] iArr2 = this.f1700h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iK = aVar.k();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < iK; i4++) {
            int iJ = p.j(aVar, iArr2, i2, p.g);
            sb.append((char) ((iJ % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (iJ >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        s(sb, i3);
        int i6 = p.n(aVar, i2, true, p.e)[1];
        for (int i7 = 0; i7 < 6 && i6 < iK; i7++) {
            sb.append((char) (p.j(aVar, iArr2, i6, p.f) + 48));
            for (int i8 : iArr2) {
                i6 += i8;
            }
        }
        return i6;
    }

    @Override // i.f.a.y.p
    i.f.a.a q() {
        return i.f.a.a.EAN_13;
    }
}
