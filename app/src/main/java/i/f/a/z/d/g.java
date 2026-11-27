package i.f.a.z.d;

import com.auto.exceldeps.log4j.util.Chars;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes.dex */
abstract class g {
    private static final char[] a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final BigInteger[] c;

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i2 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = c;
            if (i2 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i2] = bigIntegerArr2[i2 - 1].multiply(bigIntegerValueOf);
            i2++;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:30:0x0066
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x0077. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:35:0x007a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0045 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0021 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(int r16, int[] r17, java.nio.charset.Charset r18, int r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i.f.a.z.d.g.a(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static i.f.a.v.e b(int[] iArr, String str) throws i.f.a.g {
        int iG;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charsetForName = StandardCharsets.ISO_8859_1;
        int i2 = iArr[1];
        i.f.a.z.c cVar = new i.f.a.z.c();
        int i3 = 2;
        while (i3 < iArr[0]) {
            if (i2 != 913) {
                switch (i2) {
                    case 900:
                        iG = g(iArr, i3, sb);
                        break;
                    case 901:
                        iG = a(i2, iArr, charsetForName, i3, sb);
                        break;
                    case 902:
                        iG = f(iArr, i3, sb);
                        break;
                    default:
                        switch (i2) {
                            case 922:
                            case 923:
                                throw i.f.a.g.a();
                            case 924:
                                break;
                            case 925:
                                iG = i3 + 1;
                                break;
                            case 926:
                                iG = i3 + 2;
                                break;
                            case 927:
                                iG = i3 + 1;
                                charsetForName = Charset.forName(i.f.a.v.d.b(iArr[i3]).name());
                                break;
                            case 928:
                                iG = d(iArr, i3, cVar);
                                break;
                            default:
                                iG = g(iArr, i3 - 1, sb);
                                break;
                        }
                }
            } else {
                iG = i3 + 1;
                sb.append((char) iArr[i3]);
            }
            if (iG >= iArr.length) {
                throw i.f.a.g.a();
            }
            i3 = iG + 1;
            i2 = iArr[iG];
        }
        if (sb.length() == 0) {
            throw i.f.a.g.a();
        }
        i.f.a.v.e eVar = new i.f.a.v.e(null, sb.toString(), null, str);
        eVar.m(cVar);
        return eVar;
    }

    private static String c(int[] iArr, int i2) throws i.f.a.g {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigIntegerAdd = bigIntegerAdd.add(c[(i2 - i3) - 1].multiply(BigInteger.valueOf(iArr[i3])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw i.f.a.g.a();
    }

    static int d(int[] iArr, int i2, i.f.a.z.c cVar) throws i.f.a.g {
        if (i2 + 2 > iArr[0]) {
            throw i.f.a.g.a();
        }
        int[] iArr2 = new int[2];
        int i3 = 0;
        while (i3 < 2) {
            iArr2[i3] = iArr[i2];
            i3++;
            i2++;
        }
        cVar.j(Integer.parseInt(c(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int iG = g(iArr, i2, sb);
        cVar.d(sb.toString());
        int i4 = iArr[iG] == 923 ? iG + 1 : -1;
        while (iG < iArr[0]) {
            int i5 = iArr[iG];
            if (i5 == 922) {
                iG++;
                cVar.g(true);
            } else {
                if (i5 != 923) {
                    throw i.f.a.g.a();
                }
                int i6 = iG + 1;
                switch (iArr[i6]) {
                    case 0:
                        StringBuilder sb2 = new StringBuilder();
                        iG = g(iArr, i6 + 1, sb2);
                        cVar.e(sb2.toString());
                        break;
                    case 1:
                        StringBuilder sb3 = new StringBuilder();
                        iG = f(iArr, i6 + 1, sb3);
                        cVar.i(Integer.parseInt(sb3.toString()));
                        break;
                    case 2:
                        StringBuilder sb4 = new StringBuilder();
                        iG = f(iArr, i6 + 1, sb4);
                        cVar.l(Long.parseLong(sb4.toString()));
                        break;
                    case 3:
                        StringBuilder sb5 = new StringBuilder();
                        iG = g(iArr, i6 + 1, sb5);
                        cVar.k(sb5.toString());
                        break;
                    case 4:
                        StringBuilder sb6 = new StringBuilder();
                        iG = g(iArr, i6 + 1, sb6);
                        cVar.b(sb6.toString());
                        break;
                    case 5:
                        StringBuilder sb7 = new StringBuilder();
                        iG = f(iArr, i6 + 1, sb7);
                        cVar.f(Long.parseLong(sb7.toString()));
                        break;
                    case 6:
                        StringBuilder sb8 = new StringBuilder();
                        iG = f(iArr, i6 + 1, sb8);
                        cVar.c(Integer.parseInt(sb8.toString()));
                        break;
                    default:
                        throw i.f.a.g.a();
                }
            }
        }
        if (i4 != -1) {
            int i7 = iG - i4;
            if (cVar.a()) {
                i7--;
            }
            cVar.h(Arrays.copyOfRange(iArr, i4, i7 + i4));
        }
        return iG;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void e(int[] iArr, int[] iArr2, int i2, StringBuilder sb) {
        f fVar;
        int i3;
        f fVar2 = f.ALPHA;
        f fVar3 = fVar2;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = iArr[i4];
            int i6 = e.a[fVar2.ordinal()];
            char c2 = Chars.SPACE;
            switch (i6) {
                case 1:
                    if (i5 < 26) {
                        i3 = i5 + 65;
                        c2 = (char) i3;
                        break;
                    } else {
                        if (i5 == 900) {
                            fVar2 = f.ALPHA;
                        } else if (i5 != 913) {
                            switch (i5) {
                                case 27:
                                    fVar2 = f.LOWER;
                                    break;
                                case 28:
                                    fVar2 = f.MIXED;
                                    break;
                                case 29:
                                    fVar = f.PUNCT_SHIFT;
                                    c2 = 0;
                                    f fVar4 = fVar;
                                    fVar3 = fVar2;
                                    fVar2 = fVar4;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                case 2:
                    if (i5 < 26) {
                        i3 = i5 + 97;
                        c2 = (char) i3;
                        break;
                    } else {
                        if (i5 == 900) {
                            fVar2 = f.ALPHA;
                        } else if (i5 != 913) {
                            switch (i5) {
                                case 27:
                                    fVar = f.ALPHA_SHIFT;
                                    c2 = 0;
                                    f fVar42 = fVar;
                                    fVar3 = fVar2;
                                    fVar2 = fVar42;
                                    break;
                                case 28:
                                    fVar2 = f.MIXED;
                                    break;
                                case 29:
                                    fVar = f.PUNCT_SHIFT;
                                    c2 = 0;
                                    f fVar422 = fVar;
                                    fVar3 = fVar2;
                                    fVar2 = fVar422;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                    break;
                case 3:
                    if (i5 < 25) {
                        c2 = b[i5];
                        break;
                    } else if (i5 == 900) {
                        fVar2 = f.ALPHA;
                        c2 = 0;
                        break;
                    } else {
                        if (i5 != 913) {
                            switch (i5) {
                                case 25:
                                    fVar2 = f.PUNCT;
                                    break;
                                case 27:
                                    fVar2 = f.LOWER;
                                    break;
                                case 29:
                                    fVar = f.PUNCT_SHIFT;
                                    c2 = 0;
                                    f fVar4222 = fVar;
                                    fVar3 = fVar2;
                                    fVar2 = fVar4222;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                    }
                    break;
                case 4:
                    if (i5 < 29) {
                        c2 = a[i5];
                        break;
                    } else {
                        if (i5 == 29 || i5 == 900) {
                            fVar2 = f.ALPHA;
                        } else if (i5 == 913) {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                case 5:
                    if (i5 < 26) {
                        c2 = (char) (i5 + 65);
                    } else if (i5 != 26) {
                        fVar2 = i5 != 900 ? fVar3 : f.ALPHA;
                        c2 = 0;
                        break;
                    }
                    fVar2 = fVar3;
                    break;
                case 6:
                    if (i5 < 29) {
                        c2 = a[i5];
                    } else if (i5 == 29 || i5 == 900) {
                        fVar2 = f.ALPHA;
                        c2 = 0;
                        break;
                    } else {
                        if (i5 == 913) {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                    }
                    fVar2 = fVar3;
                    break;
                default:
                    c2 = 0;
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int f(int[] iArr, int i2, StringBuilder sb) throws i.f.a.g {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i4 == iArr[0]) {
                z = true;
            }
            if (i5 < 900) {
                iArr2[i3] = i5;
                i3++;
            } else if (i5 == 900 || i5 == 901 || i5 == 928) {
                i4--;
                z = true;
            } else {
                switch (i5) {
                }
            }
            if ((i3 % 15 == 0 || i5 == 902 || z) && i3 > 0) {
                sb.append(c(iArr2, i3));
                i3 = 0;
            }
            i2 = i4;
        }
        return i2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0034. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0037. Please report as an issue. */
    private static int g(int[] iArr, int i2, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i2) << 1];
        int[] iArr3 = new int[(iArr[0] - i2) << 1];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != 913) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                            }
                    }
                }
                i2 = i4 - 1;
                z = true;
            } else {
                iArr2[i3] = 913;
                i2 = i4 + 1;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i2 = i4;
        }
        e(iArr2, iArr3, i3, sb);
        return i2;
    }
}
