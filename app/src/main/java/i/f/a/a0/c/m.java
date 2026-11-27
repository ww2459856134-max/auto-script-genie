package i.f.a.a0.c;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
abstract class m {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d8 A[LOOP:0: B:53:0x001e->B:50:0x00d8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static i.f.a.v.e a(byte[] bArr, u uVar, o oVar, Map<i.f.a.e, ?> map) throws i.f.a.g {
        q qVar;
        int i2;
        i.f.a.v.c cVar = new i.f.a.v.c(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i3 = 1;
        ArrayList arrayList = new ArrayList(1);
        boolean z = 0;
        int i4 = -1;
        int iD = -1;
        i.f.a.v.d dVarB = null;
        while (true) {
            try {
                q qVarA = cVar.a() < 4 ? q.TERMINATOR : q.a(cVar.d(4));
                int[] iArr = l.a;
                int i5 = z;
                switch (iArr[qVarA.ordinal()]) {
                    case 5:
                        qVar = qVarA;
                        i2 = i5;
                        if (qVar != q.TERMINATOR) {
                            return new i.f.a.v.e(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, oVar == null ? null : oVar.toString(), i4, iD);
                        }
                        i3 = 1;
                        z = i2;
                    case 6:
                    case 7:
                        i5 = i3;
                        qVar = qVarA;
                        i2 = i5;
                        if (qVar != q.TERMINATOR) {
                        }
                        break;
                    case 8:
                        if (cVar.a() < 16) {
                            throw i.f.a.g.a();
                        }
                        int iD2 = cVar.d(8);
                        iD = cVar.d(8);
                        i4 = iD2;
                        i5 = z;
                        qVar = qVarA;
                        i2 = i5;
                        if (qVar != q.TERMINATOR) {
                        }
                        break;
                    case 9:
                        dVarB = i.f.a.v.d.b(g(cVar));
                        if (dVarB == null) {
                            throw i.f.a.g.a();
                        }
                        i5 = z;
                        qVar = qVarA;
                        i2 = i5;
                        if (qVar != q.TERMINATOR) {
                        }
                        break;
                    case 10:
                        int iD3 = cVar.d(4);
                        int iD4 = cVar.d(qVarA.c(uVar));
                        i5 = z;
                        if (iD3 == i3) {
                            d(cVar, sb, iD4);
                            i5 = z;
                        }
                        qVar = qVarA;
                        i2 = i5;
                        if (qVar != q.TERMINATOR) {
                        }
                        break;
                    default:
                        int iD5 = cVar.d(qVarA.c(uVar));
                        int i6 = iArr[qVarA.ordinal()];
                        if (i6 == i3) {
                            qVar = qVarA;
                            f(cVar, sb, iD5);
                            i2 = z;
                        } else if (i6 == 2) {
                            qVar = qVarA;
                            b(cVar, sb, iD5, z);
                            i2 = z;
                        } else if (i6 == 3) {
                            qVar = qVarA;
                            c(cVar, sb, iD5, dVarB, arrayList, map);
                            i2 = z;
                        } else {
                            if (i6 != 4) {
                                throw i.f.a.g.a();
                            }
                            e(cVar, sb, iD5);
                            i5 = z;
                            qVar = qVarA;
                            i2 = i5;
                        }
                        if (qVar != q.TERMINATOR) {
                        }
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw i.f.a.g.a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(i.f.a.v.c cVar, StringBuilder sb, int i2, boolean z) throws i.f.a.g {
        while (i2 > 1) {
            if (cVar.a() < 11) {
                throw i.f.a.g.a();
            }
            int iD = cVar.d(11);
            sb.append(h(iD / 45));
            sb.append(h(iD % 45));
            i2 -= 2;
        }
        if (i2 == 1) {
            if (cVar.a() < 6) {
                throw i.f.a.g.a();
            }
            sb.append(h(cVar.d(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i3 = length + 1;
                        if (sb.charAt(i3) == '%') {
                            sb.deleteCharAt(i3);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    }
                }
            }
        }
    }

    private static void c(i.f.a.v.c cVar, StringBuilder sb, int i2, i.f.a.v.d dVar, Collection<byte[]> collection, Map<i.f.a.e, ?> map) throws i.f.a.g {
        if ((i2 << 3) > cVar.a()) {
            throw i.f.a.g.a();
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) cVar.d(8);
        }
        try {
            sb.append(new String(bArr, dVar == null ? i.f.a.v.l.a(bArr, map) : dVar.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw i.f.a.g.a();
        }
    }

    private static void d(i.f.a.v.c cVar, StringBuilder sb, int i2) throws i.f.a.g {
        if (i2 * 13 > cVar.a()) {
            throw i.f.a.g.a();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int iD = cVar.d(13);
            int i4 = (iD % 96) | ((iD / 96) << 8);
            int i5 = i4 + (i4 < 2560 ? 41377 : 42657);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw i.f.a.g.a();
        }
    }

    private static void e(i.f.a.v.c cVar, StringBuilder sb, int i2) throws i.f.a.g {
        if (i2 * 13 > cVar.a()) {
            throw i.f.a.g.a();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int iD = cVar.d(13);
            int i4 = (iD % 192) | ((iD / 192) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw i.f.a.g.a();
        }
    }

    private static void f(i.f.a.v.c cVar, StringBuilder sb, int i2) throws i.f.a.g {
        while (i2 >= 3) {
            if (cVar.a() < 10) {
                throw i.f.a.g.a();
            }
            int iD = cVar.d(10);
            if (iD >= 1000) {
                throw i.f.a.g.a();
            }
            sb.append(h(iD / 100));
            sb.append(h((iD / 10) % 10));
            sb.append(h(iD % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (cVar.a() < 7) {
                throw i.f.a.g.a();
            }
            int iD2 = cVar.d(7);
            if (iD2 >= 100) {
                throw i.f.a.g.a();
            }
            sb.append(h(iD2 / 10));
            sb.append(h(iD2 % 10));
            return;
        }
        if (i2 == 1) {
            if (cVar.a() < 4) {
                throw i.f.a.g.a();
            }
            int iD3 = cVar.d(4);
            if (iD3 >= 10) {
                throw i.f.a.g.a();
            }
            sb.append(h(iD3));
        }
    }

    private static int g(i.f.a.v.c cVar) throws i.f.a.g {
        int iD = cVar.d(8);
        if ((iD & 128) == 0) {
            return iD & 127;
        }
        if ((iD & 192) == 128) {
            return cVar.d(8) | ((iD & 63) << 8);
        }
        if ((iD & 224) == 192) {
            return cVar.d(16) | ((iD & 31) << 16);
        }
        throw i.f.a.g.a();
    }

    private static char h(int i2) throws i.f.a.g {
        char[] cArr = a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw i.f.a.g.a();
    }
}
