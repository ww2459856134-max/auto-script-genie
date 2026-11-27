package i.f.a.y;

/* loaded from: classes.dex */
public final class f extends p {

    /* renamed from: h, reason: collision with root package name */
    private final int[] f1701h = new int[4];

    @Override // i.f.a.y.p
    protected int l(i.f.a.v.a aVar, int[] iArr, StringBuilder sb) throws i.f.a.k {
        int[] iArr2 = this.f1701h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iK = aVar.k();
        int i2 = iArr[1];
        for (int i3 = 0; i3 < 4 && i2 < iK; i3++) {
            sb.append((char) (p.j(aVar, iArr2, i2, p.f) + 48));
            for (int i4 : iArr2) {
                i2 += i4;
            }
        }
        int i5 = p.n(aVar, i2, true, p.e)[1];
        for (int i6 = 0; i6 < 4 && i5 < iK; i6++) {
            sb.append((char) (p.j(aVar, iArr2, i5, p.f) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // i.f.a.y.p
    i.f.a.a q() {
        return i.f.a.a.EAN_8;
    }
}
