package n.a.a.n.c.t1;

import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
public class la extends c6 {
    private static final int[] a = {XmlValidationError.INCORRECT_ATTRIBUTE, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] b = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final String[][] c = {new String[]{"XLV", "VL", "XCV", "VC", "CDL", "LD", "CML", "LM", "CMVC", "LMVL"}, new String[]{"CDXC", "LDXL", "CDVC", "LDVL", "CMXC", "LMXL", "XCIX", "VCIV", "XLIX", "VLIV"}, new String[]{"XLIX", "IL", "XCIX", "IC", "CDXC", "XD", "CDVC", "XDV", "CDIC", "XDIX", "LMVL", "XMV", "CMIC", "XMIX", "CMXC", "XM"}, new String[]{"XDV", "VD", "XDIX", "VDIV", "XMV", "VM", "XMIX", "VMIV"}, new String[]{"VDIV", "ID", "VMIV", "IM"}};

    private String l(int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < 13; i3++) {
            while (true) {
                int[] iArr = a;
                if (i2 >= iArr[i3]) {
                    i2 -= iArr[i3];
                    sb.append(b[i3]);
                }
            }
        }
        return sb.toString();
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            int iF = n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
            if (iF < 0) {
                return n.a.a.n.c.r1.o.e;
            }
            if (iF > 3999) {
                return n.a.a.n.c.r1.o.e;
            }
            if (iF == 0) {
                return new n.a.a.n.c.r1.m0("");
            }
            try {
                int iF2 = n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0Var2, i2, i3));
                if (iF2 > 4 || iF2 < 0) {
                    return n.a.a.n.c.r1.o.e;
                }
                String strL = l(iF);
                return iF2 == 0 ? new n.a.a.n.c.r1.m0(strL) : new n.a.a.n.c.r1.m0(m(strL, iF2));
            } catch (n.a.a.n.c.r1.p unused) {
                return n.a.a.n.c.r1.o.f2385h;
            }
        } catch (n.a.a.n.c.r1.p unused2) {
            return n.a.a.n.c.r1.o.e;
        }
    }

    public String m(String str, int i2) {
        for (int i3 = 0; i3 <= i2 && i3 <= 4 && i2 > 0; i3++) {
            if (i3 != 1 || i2 <= 1) {
                String[] strArr = c[i3];
                for (int i4 = 0; i4 < strArr.length - 1; i4 += 2) {
                    str = str.replace(strArr[i4], strArr[i4 + 1]);
                }
            }
        }
        return str;
    }
}
