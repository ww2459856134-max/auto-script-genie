package n.a.a.n.e;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.util.Chars;
import java.util.ArrayList;
import java.util.StringTokenizer;
import n.a.a.o.j1;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class k {
    private static final n.a.a.n.a e = n.a.a.n.a.EXCEL97;
    private final s a;
    private final s b;
    private final boolean c;
    private final n.a.a.n.a d;

    public k(String str, n.a.a.n.a aVar) {
        this.d = aVar == null ? e : aVar;
        if (!f(str)) {
            throw new IllegalArgumentException("References passed to the AreaReference must be contiguous, use generateContiguous(ref) if you have non-contiguous references");
        }
        String[] strArrJ = j(str);
        String str2 = strArrJ[0];
        if (strArrJ.length == 1) {
            s sVar = new s(str2);
            this.a = sVar;
            this.b = sVar;
            this.c = true;
            return;
        }
        if (strArrJ.length != 2) {
            throw new IllegalArgumentException("Bad area ref '" + str + "'");
        }
        String str3 = strArrJ[1];
        if (!g(str2)) {
            this.a = new s(str2);
            this.b = new s(str3);
            this.c = str2.equals(str3);
        } else {
            if (!g(str3)) {
                throw new IllegalStateException("Bad area ref '" + str + "'");
            }
            boolean zQ = s.q(str2);
            boolean zQ2 = s.q(str3);
            int iD = s.d(str2);
            int iD2 = s.d(str3);
            this.a = new s(0, iD, true, zQ);
            this.b = new s(65535, iD2, true, zQ2);
            this.c = false;
        }
    }

    public static k d(n.a.a.n.a aVar, String str, String str2) {
        if (aVar == null) {
            aVar = e;
        }
        return new k(str + "$1:" + str2 + "$" + aVar.f(), aVar);
    }

    public static k e(n.a.a.n.a aVar, String str, String str2) {
        if (aVar == null) {
            aVar = e;
        }
        return new k("$A" + str + ":$" + aVar.b() + str2, aVar);
    }

    public static boolean f(String str) {
        return k(str).length == 1;
    }

    private static boolean g(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char cCharAt = str.charAt(length);
            if (!(cCharAt == '$' && length == 0) && (cCharAt < 'A' || cCharAt > 'Z')) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(n.a.a.n.a aVar, s sVar, s sVar2) {
        if (aVar == null) {
            aVar = e;
        }
        return sVar.m() == 0 && sVar.r() && sVar2.m() == aVar.c() && sVar2.r();
    }

    private static String[] j(String str) {
        int length = str.length();
        int i2 = -1;
        int i3 = 0;
        boolean z = false;
        while (i3 < length) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\'') {
                if (cCharAt == ':' && !z) {
                    if (i2 >= 0) {
                        throw new IllegalArgumentException("More than one cell delimiter ':' appears in area reference '" + str + "'");
                    }
                    i2 = i3;
                }
            } else if (!z) {
                z = true;
            } else {
                if (i3 >= length - 1) {
                    throw new IllegalArgumentException("Area reference '" + str + "' ends with special name delimiter '" + Chars.QUOTE + "'");
                }
                int i4 = i3 + 1;
                if (str.charAt(i4) == '\'') {
                    i3 = i4;
                } else {
                    z = false;
                }
            }
            i3++;
        }
        if (i2 < 0) {
            return new String[]{str};
        }
        String strSubstring = str.substring(0, i2);
        String strSubstring2 = str.substring(i2 + 1);
        if (strSubstring2.indexOf(33) >= 0) {
            throw new IllegalStateException("Unexpected ! in second cell reference of '" + str + "'");
        }
        int iLastIndexOf = strSubstring.lastIndexOf(33);
        if (iLastIndexOf < 0) {
            return new String[]{strSubstring, strSubstring2};
        }
        return new String[]{strSubstring, strSubstring.substring(0, iLastIndexOf + 1) + strSubstring2};
    }

    private static String[] k(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        loop0: while (true) {
            str2 = "";
            while (stringTokenizer.hasMoreTokens()) {
                if (!str2.isEmpty()) {
                    str2 = str2 + ",";
                }
                str2 = str2 + stringTokenizer.nextToken();
                int iA = j1.a(str2, Chars.QUOTE);
                if (iA == 0 || iA == 2) {
                    break;
                }
            }
            arrayList.add(str2);
        }
        if (!str2.isEmpty()) {
            arrayList.add(str2);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String a() {
        if (h()) {
            return s.f(this.a.l()) + ParameterizedMessage.ERROR_MSG_SEPARATOR + s.f(this.b.l());
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a.g());
        if (!this.c) {
            sb.append(NameUtil.COLON);
            if (this.b.n() == null) {
                sb.append(this.b.g());
            } else {
                this.b.a(sb);
            }
        }
        return sb.toString();
    }

    public s b() {
        return this.a;
    }

    public s c() {
        return this.b;
    }

    public boolean h() {
        return i(this.d, this.a, this.b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(k.class.getName());
        sb.append(" [");
        try {
            sb.append(a());
        } catch (Exception e2) {
            sb.append(e2);
        }
        sb.append(']');
        return sb.toString();
    }

    public k(s sVar, s sVar2, n.a.a.n.a aVar) {
        int iM;
        boolean zR;
        int iM2;
        boolean zR2;
        short sL;
        String strN;
        short sL2;
        boolean z;
        String str;
        boolean zO;
        this.d = aVar != null ? aVar : e;
        boolean z2 = sVar.m() > sVar2.m();
        boolean z3 = sVar.l() > sVar2.l();
        if (!z2 && !z3) {
            this.a = sVar;
            this.b = sVar2;
        } else {
            if (z2) {
                iM = sVar2.m();
                zR = sVar2.r();
                iM2 = sVar.m();
                zR2 = sVar.r();
            } else {
                iM = sVar.m();
                zR = sVar.r();
                iM2 = sVar2.m();
                zR2 = sVar2.r();
            }
            int i2 = iM;
            boolean z4 = zR;
            boolean z5 = zR2;
            if (z3) {
                String strN2 = sVar2.n();
                sL = sVar2.l();
                boolean zO2 = sVar2.o();
                strN = sVar.n();
                sL2 = sVar.l();
                zO = sVar.o();
                str = strN2;
                z = zO2;
            } else {
                String strN3 = sVar.n();
                sL = sVar.l();
                boolean zO3 = sVar.o();
                strN = sVar2.n();
                sL2 = sVar2.l();
                z = zO3;
                str = strN3;
                zO = sVar2.o();
            }
            this.a = new s(str, i2, sL, z4, z);
            this.b = new s(strN, iM2, sL2, z5, zO);
        }
        this.c = false;
    }
}
