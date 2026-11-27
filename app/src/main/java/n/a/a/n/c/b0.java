package n.a.a.n.c;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.util.Chars;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
import n.a.a.n.c.u1.a2;
import n.a.a.n.c.u1.b2;
import n.a.a.n.c.u1.c2;
import n.a.a.n.c.u1.d2;
import n.a.a.n.c.u1.e2;
import n.a.a.n.c.u1.f2;
import n.a.a.n.c.u1.g2;
import n.a.a.n.c.u1.h2;
import n.a.a.n.c.u1.i2;
import n.a.a.n.c.u1.j2;
import n.a.a.n.c.u1.k2;
import n.a.a.n.c.u1.n2;
import n.a.a.n.c.u1.p1;
import n.a.a.n.c.u1.q1;
import n.a.a.n.c.u1.q2;
import n.a.a.n.c.u1.r1;
import n.a.a.n.c.u1.s1;
import n.a.a.n.c.u1.t1;
import n.a.a.n.c.u1.t2;
import n.a.a.n.c.u1.u1;
import n.a.a.n.c.u1.u2;
import n.a.a.n.c.u1.v1;
import n.a.a.n.c.u1.v2;
import n.a.a.n.c.u1.w1;
import n.a.a.n.c.u1.w2;
import n.a.a.n.c.u1.x1;
import n.a.a.n.c.u1.x2;
import n.a.a.n.c.u1.y1;
import n.a.a.n.c.u1.y2;
import n.a.a.n.c.u1.z1;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: k, reason: collision with root package name */
    private static final Logger f2358k = n.a.a.i.b.a(b0.class);

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f2359l = Pattern.compile("(\\$?[A-Za-z]+)?(\\$?[0-9]+)?");
    private final String a;
    private final int b;
    private int c = 0;
    private w0 d;
    private int e;
    private boolean f;
    private final c0 g;

    /* renamed from: h, reason: collision with root package name */
    private final n.a.a.n.a f2360h;

    /* renamed from: i, reason: collision with root package name */
    private final int f2361i;

    /* renamed from: j, reason: collision with root package name */
    private final int f2362j;

    private b0(String str, c0 c0Var, int i2, int i3) {
        this.a = str;
        this.g = c0Var;
        this.f2360h = c0Var == null ? n.a.a.n.a.EXCEL97 : c0Var.b();
        this.b = str.length();
        this.f2361i = i2;
        this.f2362j = i3;
    }

    private static boolean A(w0 w0Var) {
        k2 k2VarE = w0Var.e();
        if (k2VarE instanceof f2) {
            return true;
        }
        if (k2VarE instanceof n.a.a.n.c.u1.y0) {
            byte bS = ((n.a.a.n.c.u1.y0) k2VarE).s();
            return bS == 0 || 32 == bS;
        }
        if (k2VarE instanceof y2) {
            return false;
        }
        if (k2VarE instanceof g2) {
            return true;
        }
        return k2VarE instanceof h2 ? A(w0Var.c()[0]) : k2VarE == n.a.a.n.c.u1.o1.f2439h;
    }

    private static boolean B(int i2) {
        return i2 == 32 || i2 == 9 || i2 == 13 || i2 == 10;
    }

    private void C(int i2) {
        if (this.e == i2) {
            E();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("'");
        StringBuilder sbAppendCodePoint = sb.appendCodePoint(i2);
        sbAppendCodePoint.append("'");
        throw m(sbAppendCodePoint.toString());
    }

    private static boolean D(w0 w0Var) {
        k2 k2VarE = w0Var.e();
        if ((k2VarE instanceof n.a.a.n.c.u1.y0) || (k2VarE instanceof b2)) {
            return true;
        }
        if (!(k2VarE instanceof g2) && !(k2VarE instanceof h2)) {
            return false;
        }
        for (w0 w0Var2 : w0Var.c()) {
            if (D(w0Var2)) {
                return true;
            }
        }
        return false;
    }

    private void E() {
        if (!B(this.e)) {
            this.f = false;
        } else if (this.e == 32) {
            this.f = true;
        }
        int i2 = this.c;
        int i3 = this.b;
        if (i2 <= i3) {
            if (i2 < i3) {
                this.e = this.a.codePointAt(i2);
            } else {
                this.e = 0;
                this.f = false;
            }
            this.c += Character.charCount(this.e);
            return;
        }
        throw new IllegalStateException("Parsed past the end of the formula, pos: " + this.c + ", length: " + this.b + ", formula: " + this.a);
    }

    private String F() {
        StringBuilder sb = new StringBuilder();
        while (w(this.e)) {
            sb.appendCodePoint(this.e);
            E();
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    private void G() {
        this.c = 0;
        E();
        this.d = i0();
        if (this.c > this.b) {
            return;
        }
        throw new x("Unused input [" + this.a.substring(this.c - 1) + "] after attempting to parse the formula [" + this.a + "]");
    }

    public static k2[] H(String str, c0 c0Var, f0 f0Var, int i2) {
        return I(str, c0Var, f0Var, i2, -1);
    }

    public static k2[] I(String str, c0 c0Var, f0 f0Var, int i2, int i3) {
        b0 b0Var = new b0(str, c0Var, i2, i3);
        b0Var.G();
        return b0Var.s(f0Var);
    }

    private w0 J() {
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(L());
            int i2 = this.e;
            if (i2 == 125) {
                Object[][] objArr = new Object[arrayList.size()][];
                arrayList.toArray(objArr);
                f(objArr, objArr[0].length);
                return new w0(new n.a.a.n.c.u1.g1(objArr));
            }
            if (i2 != 59) {
                throw m("'}' or ';'");
            }
            C(59);
        }
    }

    private Object K() {
        h0();
        int i2 = this.e;
        if (i2 == 34) {
            return Z();
        }
        if (i2 == 35) {
            return n.a.a.n.c.q1.c.c(Q());
        }
        if (i2 != 45) {
            return (i2 == 70 || i2 == 84 || i2 == 102 || i2 == 116) ? P() : j(S(), true);
        }
        C(45);
        h0();
        return j(S(), false);
    }

    private Object[] L() {
        int i2;
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(K());
            h0();
            i2 = this.e;
            if (i2 != 44) {
                break;
            }
            C(44);
        }
        if (i2 != 59 && i2 != 125) {
            throw m("'}' or ','");
        }
        Object[] objArr = new Object[arrayList.size()];
        arrayList.toArray(objArr);
        return objArr;
    }

    private String M() {
        if (this.e != 91) {
            return null;
        }
        E();
        int i2 = this.e;
        if (i2 == 35) {
            return null;
        }
        if (i2 == 64) {
            E();
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i3 = this.e;
            if (i3 == 93) {
                C(93);
                return sb.toString();
            }
            sb.appendCodePoint(i3);
            E();
        }
    }

    private String N() {
        int i2;
        StringBuilder sb = new StringBuilder();
        if (!Character.isLetter(this.e) && (i2 = this.e) != 95 && i2 != 92) {
            throw m("number, string, defined name, or data table");
        }
        while (z(this.e)) {
            sb.appendCodePoint(this.e);
            E();
        }
        h0();
        return sb.toString();
    }

    private String O() {
        if (this.e != 91) {
            return null;
        }
        E();
        if (this.e != 35) {
            return null;
        }
        E();
        String strN = N();
        if (strN.equals("This")) {
            strN = strN + Chars.SPACE + N();
        }
        C(93);
        return strN;
    }

    private Boolean P() {
        String strD0 = d0();
        if ("TRUE".equalsIgnoreCase(strD0)) {
            return Boolean.TRUE;
        }
        if ("FALSE".equalsIgnoreCase(strD0)) {
            return Boolean.FALSE;
        }
        throw m("'TRUE' or 'FALSE'");
    }

    private int Q() {
        C(35);
        String strD0 = d0();
        if (strD0 == null) {
            throw m("remainder of error constant literal");
        }
        String upperCase = strD0.toUpperCase(Locale.ROOT);
        char cCharAt = upperCase.charAt(0);
        if (cCharAt == 'D') {
            n.a.a.n.d.i0 i0Var = n.a.a.n.d.i0.DIV0;
            if (!upperCase.equals("DIV")) {
                throw m(i0Var.f());
            }
            C(47);
            C(48);
            C(33);
            return i0Var.d();
        }
        if (cCharAt != 'N') {
            if (cCharAt == 'R') {
                n.a.a.n.d.i0 i0Var2 = n.a.a.n.d.i0.REF;
                if (!upperCase.equals(i0Var2.name())) {
                    throw m(i0Var2.f());
                }
                C(33);
                return i0Var2.d();
            }
            if (cCharAt != 'V') {
                throw m("#VALUE!, #REF!, #DIV/0!, #NAME?, #NUM!, #NULL! or #N/A");
            }
            n.a.a.n.d.i0 i0Var3 = n.a.a.n.d.i0.VALUE;
            if (!upperCase.equals(i0Var3.name())) {
                throw m(i0Var3.f());
            }
            C(33);
            return i0Var3.d();
        }
        n.a.a.n.d.i0 i0Var4 = n.a.a.n.d.i0.NAME;
        if (upperCase.equals(i0Var4.name())) {
            C(63);
            return i0Var4.d();
        }
        n.a.a.n.d.i0 i0Var5 = n.a.a.n.d.i0.NUM;
        if (upperCase.equals(i0Var5.name())) {
            C(33);
            return i0Var5.d();
        }
        n.a.a.n.d.i0 i0Var6 = n.a.a.n.d.i0.NULL;
        if (upperCase.equals(i0Var6.name())) {
            C(33);
            return i0Var6.d();
        }
        n.a.a.n.d.i0 i0Var7 = n.a.a.n.d.i0.NA;
        if (!upperCase.equals("N")) {
            throw m("#NAME?, #NUM!, #NULL! or #N/A");
        }
        C(47);
        int i2 = this.e;
        if (i2 != 65 && i2 != 97) {
            throw m(i0Var7.f());
        }
        C(i2);
        return i0Var7.d();
    }

    private w0 R(int i2) {
        g0(i2);
        if (Character.isDigit(this.e)) {
            return new w0(S());
        }
        if (this.e == 34) {
            return new w0(new t2(Z()));
        }
        String strN = N();
        int i3 = this.e;
        if (i3 == 40) {
            return n(strN);
        }
        if (i3 == 91) {
            return a0(strN);
        }
        if (strN.equalsIgnoreCase("TRUE") || strN.equalsIgnoreCase("FALSE")) {
            return new w0(n.a.a.n.c.u1.i1.q(strN.equalsIgnoreCase("TRUE")));
        }
        c0 c0Var = this.g;
        if (c0Var == null) {
            throw new IllegalStateException("Need book to evaluate name '" + strN + "'");
        }
        n nVarA = c0Var.a(strN, this.f2361i);
        if (nVarA == null) {
            throw new x("Specified named range '" + strN + "' does not exist in the current workbook.");
        }
        if (nVarA.a()) {
            return new w0(nVarA.c());
        }
        throw new x("Specified name '" + strN + "' is not a range as expected.");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private k2 S() {
        String strF;
        String str;
        String strF2;
        String strF3 = F();
        String str2 = null;
        if (this.e == 46) {
            E();
            strF = F();
        } else {
            strF = null;
        }
        if (this.e == 69) {
            E();
            int i2 = this.e;
            if (i2 == 43) {
                E();
            } else {
                if (i2 == 45) {
                    E();
                    str = ProcessIdUtil.DEFAULT_PROCESSID;
                }
                strF2 = F();
                if (strF2 != null) {
                    throw m("Integer");
                }
                str2 = str + strF2;
            }
            str = "";
            strF2 = F();
            if (strF2 != null) {
            }
        }
        if (strF3 == null && strF == null) {
            throw m("Integer");
        }
        return r(strF3, strF, str2);
    }

    private w0 T() throws NumberFormatException {
        w0 w0VarU = U();
        boolean z = false;
        while (this.e == 58) {
            int i2 = this.c;
            E();
            w0 w0VarU2 = U();
            g("LHS", i2, w0VarU);
            g("RHS", i2, w0VarU2);
            w0VarU = new w0(n2.d, new w0[]{w0VarU, w0VarU2});
            z = true;
        }
        return z ? e(w0VarU) : w0VarU;
    }

    private w0 U() throws NumberFormatException {
        int i2;
        String str;
        h0();
        int i3 = this.c;
        b1 b1VarV = V(false);
        if (b1VarV == null) {
            g0(i3);
        } else {
            h0();
            i3 = this.c;
        }
        a0 a0VarY = Y();
        if (a0VarY == null) {
            if (b1VarV == null) {
                return R(i3);
            }
            if (this.e == 35) {
                return new w0(n.a.a.n.c.u1.o1.q(Q()));
            }
            String strN = N();
            if (strN.isEmpty()) {
                throw new x("Cell reference or Named Range expected after sheet name at index " + this.c + ".");
            }
            k2 k2VarH = this.g.h(strN, b1VarV);
            if (k2VarH != null) {
                return new w0(k2VarH);
            }
            throw new x("Specified name '" + strN + "' for sheet " + b1VarV.a() + " not found");
        }
        boolean zB = B(this.e);
        if (zB) {
            h0();
        }
        int i4 = this.e;
        if (i4 == 58) {
            int i5 = this.c;
            E();
            h0();
            a0 a0VarY2 = Y();
            a0 a0Var = (a0VarY2 == null || a0VarY.e(a0VarY2)) ? a0VarY2 : null;
            if (a0Var == null) {
                g0(i5);
                if (!a0VarY.c()) {
                    if (b1VarV != null) {
                        str = "'" + b1VarV.d().a() + '!';
                    } else {
                        str = "";
                    }
                    throw new x(str + a0VarY.b() + "' is not a proper reference.");
                }
            }
            return l(b1VarV, a0VarY, a0Var);
        }
        if (i4 != 46) {
            if (a0VarY.c() && y(a0VarY.b())) {
                return l(b1VarV, a0VarY, null);
            }
            if (b1VarV == null) {
                return R(i3);
            }
            throw new x("Second part of cell reference expected after sheet name at index " + this.c + ".");
        }
        E();
        int i6 = 1;
        while (true) {
            i2 = this.e;
            if (i2 != 46) {
                break;
            }
            i6++;
            E();
        }
        boolean zB2 = B(i2);
        h0();
        a0 a0VarY3 = Y();
        String strSubstring = this.a.substring(i3 - 1, this.c - 1);
        if (a0VarY3 == null) {
            if (b1VarV == null) {
                return R(i3);
            }
            throw new x("Complete area reference expected after sheet name at index " + this.c + ".");
        }
        if (zB || zB2) {
            if (!a0VarY.g() && !a0VarY3.g()) {
                return l(b1VarV, a0VarY, a0VarY3);
            }
            throw new x("Dotted range (full row or column) expression '" + strSubstring + "' must not contain whitespace.");
        }
        if (i6 == 1 && a0VarY.f() && a0VarY3.f()) {
            return R(i3);
        }
        if ((!a0VarY.g() && !a0VarY3.g()) || i6 == 2) {
            return l(b1VarV, a0VarY, a0VarY3);
        }
        throw new x("Dotted range (full row or column) expression '" + strSubstring + "' must have exactly 2 dots.");
    }

    private b1 V(boolean z) {
        String strO = this.e == 91 ? o() : null;
        int i2 = this.e;
        if (i2 != 39 && !z) {
            if (i2 != 95 && !Character.isLetter(i2)) {
                if (this.e != 33 || strO == null) {
                    return null;
                }
                E();
                return new b1(strO, null);
            }
            StringBuilder sb = new StringBuilder();
            while (x(this.e)) {
                sb.appendCodePoint(this.e);
                E();
            }
            if (this.e == 39) {
                E();
            }
            p0 p0Var = new p0(sb.toString(), false);
            h0();
            int i3 = this.e;
            if (i3 == 33) {
                E();
                return new b1(strO, p0Var);
            }
            if (i3 == 58) {
                return W(strO, p0Var, false);
            }
            return null;
        }
        if (!z) {
            C(39);
        }
        if (this.e == 91) {
            strO = o();
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = this.e == 39;
        while (!z2) {
            sb2.appendCodePoint(this.e);
            E();
            int i4 = this.e;
            if (i4 == 39) {
                E();
                if (this.e != 39) {
                    z2 = true;
                }
            } else if (i4 == 58) {
                z2 = true;
            }
        }
        p0 p0Var2 = new p0(sb2.toString(), true);
        h0();
        int i5 = this.e;
        if (i5 == 33) {
            E();
            return new b1(strO, p0Var2);
        }
        if (i5 == 58) {
            return W(strO, p0Var2, true);
        }
        return null;
    }

    private b1 W(String str, p0 p0Var, boolean z) {
        E();
        b1 b1VarV = V(z);
        if (b1VarV != null) {
            return new g1(str, p0Var, b1VarV.d());
        }
        return null;
    }

    private w0 X() {
        int i2;
        h0();
        int i3 = this.e;
        if (i3 == 34) {
            return new w0(new t2(Z()));
        }
        if (i3 == 35) {
            return new w0(n.a.a.n.c.u1.o1.q(Q()));
        }
        if (i3 == 40) {
            C(40);
            w0 w0VarI0 = i0();
            C(41);
            return new w0(h2.d, w0VarI0);
        }
        if (i3 == 43) {
            C(43);
            return c0(true);
        }
        if (i3 == 45) {
            C(45);
            return c0(false);
        }
        if (i3 == 123) {
            C(123);
            w0 w0VarJ = J();
            C(125);
            return w0VarJ;
        }
        if (u(i3) || Character.isDigit(this.e) || (i2 = this.e) == 39 || i2 == 91 || i2 == 95 || i2 == 92) {
            return T();
        }
        if (i2 == 46) {
            return new w0(S());
        }
        throw m("cell ref or constant literal");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0077, code lost:
    
        if (r5 <= r8.f2360h.f()) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a0 Y() throws NumberFormatException {
        int i2 = this.c - 1;
        boolean z = false;
        boolean z2 = false;
        while (i2 < this.b) {
            char cCharAt = this.a.charAt(i2);
            if (!Character.isDigit(cCharAt)) {
                if (!Character.isLetter(cCharAt)) {
                    if (cCharAt != '$' && cCharAt != '_') {
                        break;
                    }
                } else {
                    z2 = true;
                }
            } else {
                z = true;
            }
            i2++;
        }
        int i3 = this.c;
        if (i2 <= i3 - 1) {
            return null;
        }
        String strSubstring = this.a.substring(i3 - 1, i2);
        if (!f2359l.matcher(strSubstring).matches()) {
            return null;
        }
        if (z2 && z) {
            if (!y(strSubstring)) {
                return null;
            }
        } else {
            if (!z2) {
                if (z) {
                    try {
                        int i4 = Integer.parseInt(strSubstring.replace("$", ""));
                        if (i4 >= 1) {
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!n.a.a.n.e.s.p(strSubstring.replace("$", ""), this.f2360h)) {
                return null;
            }
        }
        g0(i2 + 1);
        return new a0(strSubstring, z2, z);
    }

    private String Z() {
        C(34);
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (this.e == 34) {
                E();
                if (this.e != 34) {
                    return sb.toString();
                }
            }
            sb.appendCodePoint(this.e);
            E();
        }
    }

    private w0[] a() {
        ArrayList arrayList = new ArrayList(2);
        h0();
        if (this.e == 41) {
            return w0.e;
        }
        while (true) {
            boolean z = true;
            do {
                h0();
                if (v(this.e)) {
                    if (z) {
                        arrayList.add(new w0(z1.d));
                    }
                    if (this.e == 41) {
                        w0[] w0VarArr = new w0[arrayList.size()];
                        arrayList.toArray(w0VarArr);
                        return w0VarArr;
                    }
                    C(44);
                } else {
                    arrayList.add(t());
                    z = false;
                    h0();
                }
            } while (v(this.e));
            throw m("',' or ')'");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private w0 a0(String str) {
        char c;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        String str2;
        boolean z4;
        int i3;
        int i4;
        String str3;
        int i5;
        int i6;
        int i7;
        int i8;
        if (!this.f2360h.equals(n.a.a.n.a.EXCEL2007)) {
            throw new x("Structured references work only on XSSF (Excel 2007+)!");
        }
        n.a.a.n.d.r0 r0VarF = this.g.f(str);
        if (r0VarF == null) {
            throw new x("Illegal table name: '" + str + "'");
        }
        String strC = r0VarF.c();
        int iD = r0VarF.D();
        int iJ = r0VarF.j();
        int iW = r0VarF.w();
        int iZ = r0VarF.z();
        int i9 = this.c;
        E();
        if (this.e == 93) {
            E();
            if (r0VarF.getHeaderRowCount() > 0) {
                iW++;
            }
            if (r0VarF.getTotalsRowCount() > 0) {
                iZ--;
            }
            return new w0(this.g.n(new n.a.a.n.e.k(new n.a.a.n.e.s(iW, iD), new n.a.a.n.e.s(iZ, iJ), this.f2360h), new b1(null, new p0(strC, true))));
        }
        int i10 = 0;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (true) {
            int i11 = this.c;
            String strO = O();
            c = 4;
            i2 = iJ;
            z = z5;
            z2 = z6;
            z3 = z7;
            str2 = strC;
            if (strO == null) {
                g0(i11);
            } else {
                strO.hashCode();
                switch (strO) {
                    case "Headers":
                        z8 = true;
                        break;
                    case "Totals":
                        z = true;
                        break;
                    case "All":
                        z9 = true;
                        break;
                    case "Data":
                        z3 = true;
                        break;
                    case "This Row":
                        z2 = true;
                        break;
                    default:
                        throw new x("Unknown special quantifier " + strO);
                }
                i10++;
                if (this.e == 44) {
                    E();
                    iJ = i2;
                    z5 = z;
                    z6 = z2;
                    z7 = z3;
                    strC = str2;
                }
            }
        }
        h0();
        if (this.e == 64) {
            E();
            z4 = true;
        } else {
            z4 = false;
        }
        int i12 = this.c;
        String strM = M();
        if (strM == null) {
            g0(i12);
            i3 = iD;
            i4 = 0;
        } else {
            int i13 = this.e;
            i3 = iD;
            if (i13 == 44) {
                throw new x("The formula " + this.a + " is illegal: you should not use ',' with column quantifiers");
            }
            if (i13 == 58) {
                E();
                String strM2 = M();
                if (strM2 == null) {
                    throw new x("The formula " + this.a + " is illegal: the string after ':' must be column quantifier");
                }
                str3 = strM2;
                i4 = 2;
                if (i4 == 0 || i10 != 0) {
                    C(93);
                } else {
                    g0(i9);
                    int i14 = this.c;
                    strM = M();
                    if (strM != null) {
                        i4++;
                    } else {
                        g0(i14);
                        String strO2 = O();
                        if (strO2 == null) {
                            throw new x("The formula " + this.a + " is illegal");
                        }
                        strO2.hashCode();
                        switch (strO2.hashCode()) {
                            case -1835006106:
                                if (!strO2.equals("Headers")) {
                                    c = 65535;
                                    break;
                                } else {
                                    c = 0;
                                    break;
                                }
                            case -1784055345:
                                if (strO2.equals("Totals")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 65921:
                                if (strO2.equals("All")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 2122698:
                                if (strO2.equals("Data")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 1291583832:
                                if (!strO2.equals("This Row")) {
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                z8 = true;
                                break;
                            case 1:
                                z = true;
                                break;
                            case 2:
                                z9 = true;
                                break;
                            case 3:
                                z3 = true;
                                break;
                            case 4:
                                z2 = true;
                                break;
                            default:
                                throw new x("Unknown special quantifier " + strO2);
                        }
                        i10++;
                    }
                }
                String str4 = strM;
                if (!z && r0VarF.getTotalsRowCount() == 0) {
                    return new w0(n.a.a.n.c.u1.o1.f2439h);
                }
                if ((!z4 || z2) && ((i5 = this.f2362j) < iW || iZ < i5)) {
                    if (i5 >= 0) {
                        return new w0(n.a.a.n.c.u1.o1.g);
                    }
                    throw new x("Formula contained [#This Row] or [@] structured reference but this row < 0. Row index must be specified for row-referencing structured references.");
                }
                if (i10 <= 0) {
                    if (i10 != 1 || !z9) {
                        if (z3 && z8) {
                            if (r0VarF.getTotalsRowCount() > 0) {
                                iZ--;
                            }
                        } else if (z3 && z) {
                            iW++;
                        } else {
                            int i15 = 1;
                            if (i10 != 1) {
                                if (i10 != i15 && z8) {
                                    iZ = iW;
                                } else if (i10 != i15 && z) {
                                    iW = iZ;
                                } else {
                                    if ((i10 == i15 || !z2) && !z4) {
                                        throw new x("The formula " + this.a + " is illegal");
                                    }
                                    iW = this.f2362j;
                                    iZ = iW;
                                }
                            } else if (z3) {
                                iW++;
                                if (r0VarF.getTotalsRowCount() > 0) {
                                    i6 = iZ - 1;
                                    iZ = i6;
                                }
                            } else {
                                i15 = 1;
                                if (i10 != i15) {
                                    if (i10 != i15) {
                                    }
                                    if (i10 == i15) {
                                        throw new x("The formula " + this.a + " is illegal");
                                    }
                                    throw new x("The formula " + this.a + " is illegal");
                                }
                            }
                        }
                    }
                } else if (z4) {
                    iW = this.f2362j;
                    iZ = iW;
                } else {
                    iW++;
                    if (r0VarF.getTotalsRowCount() > 0) {
                        i6 = iZ - 1;
                        iZ = i6;
                    }
                }
                if (i4 != 2) {
                    if (str4 == null || str3 == null) {
                        throw new IllegalStateException("Cannot parse column: " + str4 + " and " + str3 + " with formula " + this.a);
                    }
                    int iA = r0VarF.a(str4);
                    String str5 = str3;
                    int iA2 = r0VarF.a(str5);
                    if (iA == -1 || iA2 == -1) {
                        throw new x("One of the columns " + str4 + ", " + str5 + " doesn't exist in table " + r0VarF.getName());
                    }
                    i8 = i3 + iA;
                    i7 = i3 + iA2;
                } else if (i4 != 1 || z4) {
                    i7 = i2;
                    i8 = i3;
                } else {
                    if (str4 == null) {
                        throw new IllegalStateException("Cannot parse column: " + str4 + " with formula " + this.a);
                    }
                    int iA3 = r0VarF.a(str4);
                    if (iA3 == -1) {
                        throw new x("The column " + str4 + " doesn't exist in table " + r0VarF.getName());
                    }
                    i8 = i3 + iA3;
                    i7 = i8;
                }
                return new w0(this.g.n(new n.a.a.n.e.k(new n.a.a.n.e.s(iW, i8), new n.a.a.n.e.s(iZ, i7), this.f2360h), new b1(null, new p0(str2, true))));
            }
            i4 = 1;
        }
        str3 = null;
        if (i4 == 0) {
            C(93);
        }
        String str42 = strM;
        if (!z) {
        }
        if (z4) {
            if (i5 >= 0) {
            }
        } else if (i5 >= 0) {
        }
        if (i10 <= 0) {
        }
        if (i4 != 2) {
        }
        return new w0(this.g.n(new n.a.a.n.e.k(new n.a.a.n.e.s(iW, i8), new n.a.a.n.e.s(iZ, i7), this.f2360h), new b1(null, new p0(str2, true))));
    }

    private w0 b() {
        k2 k2Var;
        w0 w0VarF0 = f0();
        while (true) {
            h0();
            int i2 = this.e;
            if (i2 == 42) {
                C(42);
                k2Var = a2.d;
            } else {
                if (i2 != 47) {
                    return w0VarF0;
                }
                C(47);
                k2Var = n.a.a.n.c.u1.l1.d;
            }
            w0VarF0 = new w0(k2Var, w0VarF0, f0());
        }
    }

    public static n.a.a.n.c.u1.b1 b0(String str, c0 c0Var, int i2) {
        k2[] k2VarArrI = I(str, c0Var, f0.CELL, -1, i2);
        if (k2VarArrI.length == 1 && (k2VarArrI[0] instanceof n.a.a.n.c.u1.b1)) {
            return (n.a.a.n.c.u1.b1) k2VarArrI[0];
        }
        throw new IllegalStateException("Illegal structured reference, had length: " + k2VarArrI.length);
    }

    private void c(String str) {
        n.a.a.n.d.m0 m0VarI = this.g.i();
        m0VarI.setFunction(true);
        m0VarI.b(str);
        m0VarI.c(this.f2361i);
    }

    private w0 c0(boolean z) {
        boolean z2 = w(this.e) || this.e == 46;
        w0 w0VarF0 = f0();
        if (z2) {
            k2 k2VarE = w0VarF0.e();
            if (k2VarE instanceof e2) {
                return z ? w0VarF0 : new w0(new e2(-((e2) k2VarE).p()));
            }
            if (k2VarE instanceof t1) {
                return z ? w0VarF0 : new w0(new e2(-((t1) k2VarE).p()));
            }
        }
        return new w0(z ? w2.d : v2.d, w0VarF0);
    }

    private w0 d() {
        k2 k2Var;
        w0 w0VarB = b();
        while (true) {
            h0();
            int i2 = this.e;
            if (i2 == 43) {
                C(43);
                k2Var = n.a.a.n.c.u1.z0.d;
            } else {
                if (i2 != 45) {
                    return w0VarB;
                }
                C(45);
                k2Var = u2.d;
            }
            w0VarB = new w0(k2Var, w0VarB, b());
        }
    }

    private String d0() {
        if (this.e == 39) {
            throw m("unquoted identifier");
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!Character.isLetterOrDigit(this.e) && this.e != 46) {
                break;
            }
            sb.appendCodePoint(this.e);
            E();
        }
        if (sb.length() < 1) {
            return null;
        }
        return sb.toString();
    }

    private static w0 e(w0 w0Var) {
        return new w0(D(w0Var) ? new y1(w0Var.d()) : new x1(w0Var.d()), w0Var);
    }

    private w0 e0() {
        w0 w0VarX = X();
        while (true) {
            h0();
            if (this.e != 37) {
                return w0VarX;
            }
            C(37);
            w0VarX = new w0(i2.d, w0VarX);
        }
    }

    private void f(Object[][] objArr, int i2) {
        for (int i3 = 0; i3 < objArr.length; i3++) {
            int length = objArr[i3].length;
            if (length != i2) {
                throw new x("Array row " + i3 + " has length " + length + " but row 0 has length " + i2);
            }
        }
    }

    private w0 f0() {
        w0 w0VarE0 = e0();
        while (true) {
            h0();
            if (this.e != 94) {
                return w0VarE0;
            }
            C(94);
            w0VarE0 = new w0(j2.d, w0VarE0, e0());
        }
    }

    private static void g(String str, int i2, w0 w0Var) {
        if (A(w0Var)) {
            return;
        }
        throw new x("The " + str + " of the range operator ':' at position " + i2 + " is not a proper reference.");
    }

    private void g0(int i2) {
        this.c = i2;
        if (i2 <= this.b) {
            this.e = this.a.codePointAt(i2 - Character.charCount(this.e));
        } else {
            this.e = 0;
        }
    }

    private w0 h() {
        w0 w0VarI = i();
        while (true) {
            h0();
            switch (this.e) {
                case 60:
                case 61:
                case 62:
                    w0VarI = new w0(p(), w0VarI, i());
                default:
                    return w0VarI;
            }
        }
    }

    private void h0() {
        while (B(this.e)) {
            E();
        }
    }

    private w0 i() {
        w0 w0VarD = d();
        while (true) {
            h0();
            if (this.e != 38) {
                return w0VarD;
            }
            C(38);
            w0VarD = new w0(n.a.a.n.c.u1.j1.d, w0VarD, d());
        }
    }

    private w0 i0() {
        w0 w0VarT = t();
        boolean z = false;
        while (true) {
            h0();
            if (this.e != 44) {
                break;
            }
            E();
            z = true;
            w0VarT = new w0(x2.d, w0VarT, t());
        }
        return z ? e(w0VarT) : w0VarT;
    }

    private static Double j(k2 k2Var, boolean z) {
        double dP;
        if (k2Var instanceof t1) {
            dP = ((t1) k2Var).p();
        } else {
            if (!(k2Var instanceof e2)) {
                throw new IllegalStateException("Unexpected ptg (" + k2Var.getClass().getName() + ")");
            }
            dP = ((e2) k2Var).p();
        }
        if (!z) {
            dP = -dP;
        }
        return Double.valueOf(dP);
    }

    private void j0(int i2, n.a.a.n.c.s1.b bVar) {
        String str;
        c0 c0Var;
        String str2;
        if (i2 < bVar.c()) {
            String str3 = "Too few arguments to function '" + bVar.d() + "'. ";
            if (bVar.g()) {
                str2 = str3 + "Expected " + bVar.c();
            } else {
                str2 = str3 + "At least " + bVar.c() + " were expected";
            }
            throw new x(str2 + " but got " + i2 + ".");
        }
        int iB = (!bVar.h() || (c0Var = this.g) == null) ? bVar.b() : c0Var.b().e();
        if (i2 > iB) {
            String str4 = "Too many arguments to function '" + bVar.d() + "'. ";
            if (bVar.g()) {
                str = str4 + "Expected " + iB;
            } else {
                str = str4 + "At most " + iB + " were expected";
            }
            throw new x(str + " but got " + i2 + ".");
        }
    }

    private n.a.a.n.e.k k(a0 a0Var, a0 a0Var2) {
        if (a0Var.e(a0Var2)) {
            return a0Var.f() ? n.a.a.n.e.k.e(this.f2360h, a0Var.b(), a0Var2.b()) : a0Var.d() ? n.a.a.n.e.k.d(this.f2360h, a0Var.b(), a0Var2.b()) : new n.a.a.n.e.k(a0Var.a(), a0Var2.a(), this.f2360h);
        }
        throw new x("has incompatible parts: '" + a0Var.b() + "' and '" + a0Var2.b() + "'.");
    }

    private w0 l(b1 b1Var, a0 a0Var, a0 a0Var2) throws x {
        k2 e1Var;
        if (a0Var2 == null) {
            n.a.a.n.e.s sVarA = a0Var.a();
            e1Var = b1Var == null ? new q2(sVarA) : this.g.m(sVarA, b1Var);
        } else {
            n.a.a.n.e.k kVarK = k(a0Var, a0Var2);
            e1Var = b1Var == null ? new n.a.a.n.c.u1.e1(kVarK) : this.g.n(kVarK, b1Var);
        }
        return new w0(e1Var);
    }

    private RuntimeException m(String str) {
        String string;
        if (this.e == 61 && n.a.a.o.j1.f(this.a.substring(0, this.c - 1))) {
            string = "The specified formula '" + this.a + "' starts with an equals sign which is not allowed.";
        } else {
            StringBuilder sb = new StringBuilder("Parse error near char ");
            sb.append(this.c - 1);
            sb.append(" '");
            StringBuilder sbAppendCodePoint = sb.appendCodePoint(this.e);
            sbAppendCodePoint.append("'");
            sbAppendCodePoint.append(" in specified formula '");
            sbAppendCodePoint.append(this.a);
            sbAppendCodePoint.append("'. Expected ");
            sbAppendCodePoint.append(str);
            string = sbAppendCodePoint.toString();
        }
        return new x(string);
    }

    private w0 n(String str) {
        k2 k2VarH = null;
        if (!n.a.a.n.c.u1.y0.w(str)) {
            c0 c0Var = this.g;
            if (c0Var == null) {
                throw new IllegalStateException("Need book to evaluate name '" + str + "'");
            }
            n nVarA = c0Var.a(str, this.f2361i);
            if (nVarA == null) {
                k2VarH = this.g.h(str, null);
                if (k2VarH == null) {
                    f2358k.atWarn().log("FormulaParser.function: Name '{}' is completely unknown in the current workbook.", str);
                    int i2 = y.a[this.g.b().ordinal()];
                    if (i2 == 1) {
                        c(str);
                        k2VarH = this.g.a(str, this.f2361i).c();
                    } else {
                        if (i2 != 2) {
                            throw new IllegalStateException("Unexpected spreadsheet version: " + this.g.b().name());
                        }
                        k2VarH = new c2(str);
                    }
                }
            } else {
                if (!nVarA.d()) {
                    throw new x("Attempt to use name '" + str + "' as a function, but defined name in workbook does not refer to a function");
                }
                k2VarH = nVarA.c();
            }
        }
        C(40);
        w0[] w0VarArrA = a();
        C(41);
        return q(str, k2VarH, w0VarArrA);
    }

    private String o() {
        StringBuilder sb = new StringBuilder();
        E();
        while (true) {
            int i2 = this.e;
            if (i2 == 93) {
                E();
                return sb.toString();
            }
            sb.appendCodePoint(i2);
            E();
        }
    }

    private k2 p() {
        int i2 = this.e;
        if (i2 == 61) {
            C(i2);
            return n.a.a.n.c.u1.m1.d;
        }
        boolean z = i2 == 62;
        C(i2);
        if (z) {
            if (this.e != 61) {
                return s1.d;
            }
            C(61);
            return r1.d;
        }
        int i3 = this.e;
        if (i3 == 61) {
            C(61);
            return v1.d;
        }
        if (i3 != 62) {
            return w1.d;
        }
        C(62);
        return d2.d;
    }

    private w0 q(String str, k2 k2Var, w0[] w0VarArr) {
        n.a.a.n.c.s1.b bVarD = n.a.a.n.c.s1.d.d(str.toUpperCase(Locale.ROOT));
        int length = w0VarArr.length;
        if (bVarD == null) {
            if (k2Var == null) {
                throw new IllegalStateException("NamePtg must be supplied for external functions");
            }
            int i2 = length + 1;
            w0[] w0VarArr2 = new w0[i2];
            w0VarArr2[0] = new w0(k2Var);
            System.arraycopy(w0VarArr, 0, w0VarArr2, 1, length);
            return new w0(q1.C(str, i2), w0VarArr2);
        }
        if (k2Var != null) {
            throw new IllegalStateException("NamePtg no applicable to internal functions");
        }
        boolean z = !bVarD.g();
        int iA = bVarD.a();
        if (iA == 4 && w0VarArr.length == 1) {
            return new w0(n.a.a.n.c.u1.h1.v(), w0VarArr);
        }
        j0(w0VarArr.length, bVarD);
        return new w0(z ? q1.C(str, length) : p1.B(iA), w0VarArr);
    }

    private static k2 r(String str, String str2, String str3) throws NumberFormatException {
        StringBuilder sb = new StringBuilder();
        if (str2 == null) {
            sb.append(str);
            if (str3 != null) {
                sb.append('E');
                sb.append(str3);
            }
            String string = sb.toString();
            try {
                int i2 = Integer.parseInt(string);
                return t1.q(i2) ? new t1(i2) : new e2(string);
            } catch (NumberFormatException unused) {
                return new e2(string);
            }
        }
        if (str != null) {
            sb.append(str);
        }
        sb.append(NameUtil.PERIOD);
        sb.append(str2);
        if (str3 != null) {
            sb.append('E');
            sb.append(str3);
        }
        return new e2(sb.toString());
    }

    private k2[] s(f0 f0Var) {
        new r0(f0Var).e(this.d);
        return w0.h(this.d);
    }

    private w0 t() {
        w0 w0VarH = h();
        boolean z = false;
        while (true) {
            h0();
            if (!this.f) {
                break;
            }
            try {
                z = true;
                w0VarH = new w0(u1.d, w0VarH, h());
            } catch (x unused) {
                g0(this.c);
            }
        }
        return z ? e(w0VarH) : w0VarH;
    }

    private static boolean u(int i2) {
        return Character.isLetter(i2) || i2 == 36 || i2 == 95;
    }

    private static boolean v(int i2) {
        return i2 == 44 || i2 == 41;
    }

    private static boolean w(int i2) {
        return Character.isDigit(i2);
    }

    private static boolean x(int i2) {
        return Character.isLetterOrDigit(i2) || i2 > 128 || i2 == 32 || i2 == 46 || i2 == 95;
    }

    private boolean y(String str) {
        boolean z = n.a.a.n.e.s.c(str, this.f2360h) == n.a.a.n.e.r.CELL;
        if (!z) {
            return z;
        }
        if (!(n.a.a.n.c.s1.d.d(str.toUpperCase(Locale.ROOT)) != null)) {
            return z;
        }
        int i2 = this.c;
        g0(str.length() + i2);
        h0();
        boolean z2 = this.e != 40;
        g0(i2);
        return z2;
    }

    private static boolean z(int i2) {
        return Character.isLetterOrDigit(i2) || i2 > 128 || i2 == 46 || i2 == 63 || i2 == 92 || i2 == 95;
    }
}
