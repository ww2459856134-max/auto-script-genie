package i.f.a.y;

/* loaded from: classes.dex */
public final class q extends p {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f1703i = {1, 1, 1, 1, 1, 1};

    /* renamed from: j, reason: collision with root package name */
    static final int[][] f1704j = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: h, reason: collision with root package name */
    private final int[] f1705h = new int[4];

    public static String s(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    private static void t(StringBuilder sb, int i2) throws i.f.a.k {
        for (int i3 = 0; i3 <= 1; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                if (i2 == f1704j[i3][i4]) {
                    sb.insert(0, (char) (i3 + 48));
                    sb.append((char) (i4 + 48));
                    return;
                }
            }
        }
        throw i.f.a.k.a();
    }

    @Override // i.f.a.y.p
    protected boolean h(String str) throws i.f.a.g {
        return super.h(s(str));
    }

    @Override // i.f.a.y.p
    protected int[] k(i.f.a.v.a aVar, int i2) throws i.f.a.k {
        return p.n(aVar, i2, true, f1703i);
    }

    @Override // i.f.a.y.p
    protected int l(i.f.a.v.a aVar, int[] iArr, StringBuilder sb) throws i.f.a.k {
        int[] iArr2 = this.f1705h;
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
        t(sb, i3);
        return i2;
    }

    @Override // i.f.a.y.p
    i.f.a.a q() {
        return i.f.a.a.UPC_E;
    }
}
