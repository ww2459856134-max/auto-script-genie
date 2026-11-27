package n.a.a.n.b;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.util.Chars;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class g0 extends b0 {
    private static final Logger z = n.a.a.i.b.a(g0.class);
    private final String c;
    private final String d;
    private final double e;
    private final f0 f;
    private final f0 g;

    /* renamed from: h, reason: collision with root package name */
    private final f0 f2337h;

    /* renamed from: i, reason: collision with root package name */
    private final f0 f2338i;

    /* renamed from: j, reason: collision with root package name */
    private final f0 f2339j;

    /* renamed from: k, reason: collision with root package name */
    private final f0 f2340k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f2341l;

    /* renamed from: m, reason: collision with root package name */
    private final List<f0> f2342m;

    /* renamed from: n, reason: collision with root package name */
    private final List<f0> f2343n;

    /* renamed from: o, reason: collision with root package name */
    private final List<f0> f2344o;
    private final List<f0> p;
    private final List<f0> q;
    private final List<f0> r;
    private final List<f0> s;
    private final int t;
    private final String u;
    private final String v;
    private final boolean w;
    private final DecimalFormat x;
    private final b0 y;

    public g0(Locale locale, String str) {
        int i2;
        super(locale, str);
        ArrayList arrayList = new ArrayList();
        this.f2342m = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f2343n = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.f2344o = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        this.p = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        this.q = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        this.r = arrayList6;
        ArrayList arrayList7 = new ArrayList();
        this.s = arrayList7;
        this.y = new e0(this.b);
        h0 h0Var = new h0();
        StringBuffer stringBufferM = t.m(str, a0.d, h0Var);
        f0 f0VarD = h0Var.d();
        this.f2337h = f0VarD;
        arrayList.addAll(h0Var.h());
        this.w = h0Var.j();
        if ((h0Var.c() == null && h0Var.d() == null) || h0Var.g() == null) {
            this.g = h0Var.g();
            this.f2338i = h0Var.e();
        } else {
            this.g = null;
            this.f2338i = null;
        }
        int iP = p(h0Var.c(), arrayList);
        if (h0Var.c() != null) {
            int i3 = iP + 1;
            if (iP == 0) {
                arrayList.remove(h0Var.c());
                this.f = null;
            } else {
                this.f = h0Var.c();
            }
            i2 = i3;
        } else {
            this.f = null;
            i2 = 0;
        }
        f0 f0Var = this.f;
        if (f0Var != null) {
            this.f2339j = f0Var;
        } else if (f0VarD != null) {
            this.f2339j = f0VarD;
        } else {
            f0 f0Var2 = this.f2338i;
            if (f0Var2 != null) {
                this.f2339j = f0Var2;
            } else {
                this.f2339j = null;
            }
        }
        if (f0VarD != null) {
            this.f2340k = f0VarD;
        } else {
            f0 f0Var3 = this.f2338i;
            if (f0Var3 != null) {
                this.f2340k = f0Var3;
            } else {
                this.f2340k = null;
            }
        }
        double[] dArr = {h0Var.f()};
        this.f2341l = o(stringBufferM, arrayList, this.f, n(), h(), dArr);
        if (f0VarD == null) {
            this.e = dArr[0];
        } else {
            this.e = 1.0d;
        }
        if (iP != 0) {
            arrayList3.addAll(arrayList.subList(arrayList.indexOf(this.f) + 1, h()));
        }
        if (f0VarD != null) {
            int iIndexOf = arrayList.indexOf(f0VarD);
            arrayList6.addAll(z(iIndexOf, 2));
            arrayList7.addAll(y(iIndexOf + 2));
        }
        if (this.g != null) {
            f0 f0Var4 = this.f2338i;
            if (f0Var4 != null) {
                arrayList4.addAll(y(arrayList.indexOf(f0Var4)));
            }
            arrayList5.addAll(y(arrayList.indexOf(this.g) + 1));
            if (arrayList5.isEmpty()) {
                arrayList4.clear();
                this.t = 1;
                this.u = null;
                this.v = null;
            } else {
                this.t = t(arrayList5);
                this.u = x(arrayList4);
                this.v = x(arrayList5);
            }
        } else {
            this.t = 1;
            this.u = null;
            this.v = null;
        }
        arrayList2.addAll(arrayList.subList(0, n()));
        if (f0VarD == null) {
            int iF = f() + i2;
            if (iF == 0) {
                this.d = "";
            } else {
                this.d = "%0" + iF + NameUtil.PERIOD + iP + "f";
            }
            this.x = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            boolean z2 = true;
            if (arrayList2.size() == 1) {
                stringBuffer.append("0");
                z2 = false;
            } else {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    if (q((f0) it.next())) {
                        stringBuffer.append(z2 ? '#' : '0');
                        z2 = false;
                    }
                }
            }
            if (!this.f2344o.isEmpty()) {
                stringBuffer.append(NameUtil.PERIOD);
                Iterator<f0> it2 = this.f2344o.iterator();
                while (it2.hasNext()) {
                    if (q(it2.next())) {
                        if (!z2) {
                            stringBuffer.append('0');
                        }
                        z2 = false;
                    }
                }
            }
            stringBuffer.append('E');
            List<f0> list = this.r;
            u(stringBuffer, list.subList(2, list.size()));
            this.x = new DecimalFormat(stringBuffer.toString(), i());
            this.d = null;
        }
        this.c = stringBufferM.toString();
    }

    private void A(double d, StringBuffer stringBuffer, double d2, StringBuffer stringBuffer2, Set<i0> set) {
        int iE;
        int iD = 1;
        if (!this.w) {
            if (d2 == 0.0d && !j('0', this.p)) {
                C(stringBuffer, stringBuffer2, this.f2343n, set, false);
                f0 f0VarR = r(this.f2343n);
                f0 f0VarR2 = r(this.q);
                if (l('?', this.f2343n, this.p, this.q)) {
                    set.add(w(f0VarR, false, f0VarR2, true, Chars.SPACE));
                    return;
                } else {
                    set.add(g(f0VarR, false, f0VarR2, true));
                    return;
                }
            }
            boolean z2 = !j('0', this.p);
            boolean z3 = !j('0', this.f2343n);
            boolean z4 = d2 == 0.0d && ((this.f2343n.isEmpty() || (this.f2343n.size() == 1 && j('#', this.f2343n))) || z2);
            boolean z5 = d2 != 0.0d && z3;
            if (d == 0.0d && (z4 || z5)) {
                f0 f0VarR3 = r(this.f2343n);
                set.add(k('?', this.f2343n, this.p) ? w(f0VarR3, true, this.f2338i, false, Chars.SPACE) : g(f0VarR3, true, this.f2338i, false));
            } else {
                C(stringBuffer, stringBuffer2, this.f2343n, set, false);
            }
        }
        if (d2 != 0.0d) {
            try {
                if (this.w && d2 % 1.0d == 0.0d) {
                    iE = (int) Math.round(d2);
                } else {
                    k0 k0VarC = k0.c(d2, this.t);
                    iE = k0VarC.e();
                    iD = k0VarC.d();
                }
            } catch (RuntimeException e) {
                z.atError().withThrowable(e).log("error while fraction evaluation");
                return;
            }
        } else {
            iE = (int) Math.round(d2);
        }
        E(this.u, this.w ? Math.toIntExact(iE + Math.round(iD * d)) : iE, stringBuffer2, this.p, set);
        E(this.v, iD, stringBuffer2, this.q, set);
    }

    private void B(StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        char c;
        if (this.f2344o.isEmpty()) {
            return;
        }
        int iIndexOf = stringBuffer.indexOf(Character.toString(i().getDecimalSeparator())) + 1;
        int iIndexOf2 = this.f2337h != null ? stringBuffer.indexOf("e") : stringBuffer.length();
        do {
            iIndexOf2--;
            if (iIndexOf2 <= iIndexOf) {
                break;
            }
        } while (stringBuffer.charAt(iIndexOf2) == '0');
        for (f0 f0Var : this.f2344o) {
            char cCharAt = stringBuffer.charAt(iIndexOf);
            if (cCharAt != '0' || (c = f0Var.a) == '0' || iIndexOf < iIndexOf2) {
                stringBuffer2.setCharAt(f0Var.b, cCharAt);
            } else if (c == '?') {
                stringBuffer2.setCharAt(f0Var.b, Chars.SPACE);
            }
            iIndexOf++;
        }
    }

    private void C(StringBuffer stringBuffer, StringBuffer stringBuffer2, List<f0> list, Set<i0> set, boolean z2) {
        boolean z3;
        f0 f0Var;
        char c;
        char cCharAt;
        DecimalFormatSymbols decimalFormatSymbolsI = i();
        String string = Character.toString(decimalFormatSymbolsI.getDecimalSeparator());
        String string2 = Character.toString(decimalFormatSymbolsI.getGroupingSeparator());
        int iIndexOf = stringBuffer.indexOf(string) - 1;
        if (iIndexOf < 0) {
            iIndexOf = ((this.f2337h == null || list != this.f2343n) ? stringBuffer.length() : stringBuffer.indexOf("E")) - 1;
        }
        int i2 = 0;
        while (i2 < iIndexOf && ((cCharAt = stringBuffer.charAt(i2)) == '0' || cCharAt == decimalFormatSymbolsI.getGroupingSeparator())) {
            i2++;
        }
        ListIterator<f0> listIterator = list.listIterator(list.size());
        f0 f0Var2 = null;
        int i3 = 0;
        while (listIterator.hasPrevious()) {
            char cCharAt2 = iIndexOf >= 0 ? stringBuffer.charAt(iIndexOf) : '0';
            f0 f0VarPrevious = listIterator.previous();
            boolean z4 = z2 && i3 > 0 && i3 % 3 == 0;
            if (cCharAt2 != '0' || (c = f0VarPrevious.a) == '0' || c == '?' || iIndexOf >= i2) {
                z3 = f0VarPrevious.a == '?' && iIndexOf < i2;
                int i4 = f0VarPrevious.b;
                if (z3) {
                    cCharAt2 = Chars.SPACE;
                }
                stringBuffer2.setCharAt(i4, cCharAt2);
                f0Var = f0VarPrevious;
            } else {
                f0Var = f0Var2;
                z3 = false;
            }
            if (z4) {
                set.add(m(f0VarPrevious, z3 ? " " : string2, 2));
            }
            i3++;
            iIndexOf--;
            f0Var2 = f0Var;
        }
        if (iIndexOf >= 0) {
            int i5 = iIndexOf + 1;
            StringBuffer stringBuffer3 = new StringBuffer(stringBuffer.substring(0, i5));
            if (z2) {
                while (i5 > 0) {
                    if (i3 > 0 && i3 % 3 == 0) {
                        stringBuffer3.insert(i5, string2);
                    }
                    i3++;
                    i5--;
                }
            }
            set.add(m(f0Var2, stringBuffer3, 1));
        }
    }

    private void D(double d, StringBuffer stringBuffer, Set<i0> set) {
        StringBuffer stringBuffer2 = new StringBuffer();
        FieldPosition fieldPosition = new FieldPosition(1);
        this.x.format(d, stringBuffer2, fieldPosition);
        C(stringBuffer2, stringBuffer, this.f2343n, set, this.f2341l);
        B(stringBuffer2, stringBuffer);
        int endIndex = fieldPosition.getEndIndex() + 1;
        char cCharAt = stringBuffer2.charAt(endIndex);
        if (cCharAt != '-') {
            stringBuffer2.insert(endIndex, '+');
            cCharAt = '+';
        }
        f0 next = this.r.listIterator(1).next();
        char c = next.a;
        if (cCharAt == '-' || c == '+') {
            set.add(w(next, true, next, true, cCharAt));
        } else {
            set.add(g(next, true, next, true));
        }
        C(new StringBuffer(stringBuffer2.substring(endIndex + 1)), stringBuffer, this.s, set, false);
    }

    private void E(String str, int i2, StringBuffer stringBuffer, List<f0> list, Set<i0> set) {
        StringBuffer stringBuffer2 = new StringBuffer();
        Formatter formatter = new Formatter(stringBuffer2, this.b);
        try {
            formatter.format(this.b, str, Integer.valueOf(i2));
            formatter.close();
            C(stringBuffer2, stringBuffer, list, set, false);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private int f() {
        f0 next;
        Iterator<f0> it = this.f2342m.iterator();
        int i2 = 0;
        while (it.hasNext() && (next = it.next()) != this.f2339j) {
            if (q(next)) {
                i2++;
            }
        }
        return i2;
    }

    private static i0 g(f0 f0Var, boolean z2, f0 f0Var2, boolean z3) {
        return new i0(f0Var, z2, f0Var2, z3);
    }

    private int h() {
        f0 f0Var = this.f2340k;
        return f0Var == null ? this.f2342m.size() : this.f2342m.indexOf(f0Var);
    }

    private DecimalFormatSymbols i() {
        return DecimalFormatSymbols.getInstance(this.b);
    }

    private static boolean j(char c, List<f0> list) {
        Iterator<f0> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a == c) {
                return true;
            }
        }
        return false;
    }

    private static boolean k(char c, List<f0> list, List<f0> list2) {
        return j(c, list) || j(c, list2);
    }

    private static boolean l(char c, List<f0> list, List<f0> list2, List<f0> list3) {
        return j(c, list) || j(c, list2) || j(c, list3);
    }

    private static i0 m(f0 f0Var, CharSequence charSequence, int i2) {
        return new i0(f0Var, charSequence, i2);
    }

    private int n() {
        f0 f0Var = this.f2339j;
        return f0Var == null ? this.f2342m.size() : this.f2342m.indexOf(f0Var);
    }

    private static boolean o(StringBuffer stringBuffer, List<f0> list, f0 f0Var, int i2, int i3, double[] dArr) {
        ListIterator<f0> listIterator = list.listIterator(i2);
        int i4 = 0;
        boolean z2 = true;
        boolean z3 = false;
        while (listIterator.hasPrevious()) {
            if (listIterator.previous().a != ',') {
                z2 = false;
            } else if (z2) {
                dArr[0] = dArr[0] / 1000.0d;
            } else {
                z3 = true;
            }
        }
        if (f0Var != null) {
            ListIterator<f0> listIterator2 = list.listIterator(i3);
            while (listIterator2.hasPrevious() && listIterator2.previous().a == ',') {
                dArr[0] = dArr[0] / 1000.0d;
            }
        }
        ListIterator<f0> listIterator3 = list.listIterator();
        while (listIterator3.hasNext()) {
            f0 next = listIterator3.next();
            next.b -= i4;
            if (next.a == ',') {
                i4++;
                listIterator3.remove();
                stringBuffer.deleteCharAt(next.b);
            }
        }
        return z3;
    }

    private static int p(f0 f0Var, List<f0> list) {
        int iIndexOf = list.indexOf(f0Var);
        int i2 = 0;
        if (iIndexOf != -1) {
            ListIterator<f0> listIterator = list.listIterator(iIndexOf + 1);
            while (listIterator.hasNext() && q(listIterator.next())) {
                i2++;
            }
        }
        return i2;
    }

    private static boolean q(f0 f0Var) {
        char c = f0Var.a;
        return c == '0' || c == '?' || c == '#';
    }

    private static f0 r(List<f0> list) {
        return list.get(list.size() - 1);
    }

    private String s(String str) {
        DecimalFormatSymbols decimalFormatSymbolsI = i();
        return (!str.contains(",") || decimalFormatSymbolsI.getGroupingSeparator() == ',') ? (!str.contains(".") || decimalFormatSymbolsI.getDecimalSeparator() == '.') ? str : str.replace(NameUtil.PERIOD, decimalFormatSymbolsI.getDecimalSeparator()) : (!str.contains(".") || decimalFormatSymbolsI.getDecimalSeparator() == '.') ? str.replace(',', decimalFormatSymbolsI.getGroupingSeparator()) : v(str, "\\.", "[DECIMAL_SEPARATOR]").replace(',', decimalFormatSymbolsI.getGroupingSeparator()).replace("[DECIMAL_SEPARATOR]", Character.toString(decimalFormatSymbolsI.getDecimalSeparator()));
    }

    private static int t(List<f0> list) {
        return Math.toIntExact(Math.round(Math.pow(10.0d, list.size()) - 1.0d));
    }

    private static void u(StringBuffer stringBuffer, List<f0> list) {
        Iterator<f0> it = list.iterator();
        while (it.hasNext()) {
            if (q(it.next())) {
                stringBuffer.append('0');
            }
        }
    }

    private static String v(String str, String str2, String str3) {
        return str.replaceFirst("(?s)(.*)" + str2, "$1" + str3);
    }

    private static i0 w(f0 f0Var, boolean z2, f0 f0Var2, boolean z3, char c) {
        return new i0(f0Var, z2, f0Var2, z3, c);
    }

    private static String x(List<f0> list) {
        return "%0" + list.size() + "d";
    }

    private List<f0> y(int i2) {
        return z(i2, 0);
    }

    private List<f0> z(int i2, int i3) {
        if (i2 >= this.f2342m.size()) {
            return Collections.emptyList();
        }
        int i4 = i3 + i2;
        ListIterator<f0> listIterator = this.f2342m.listIterator(i4);
        f0 next = listIterator.next();
        while (listIterator.hasNext()) {
            f0 next2 = listIterator.next();
            if (!q(next2) || next2.b - next.b > 1) {
                break;
            }
            i4++;
            next = next2;
        }
        return this.f2342m.subList(i2, i4 + 1);
    }

    @Override // n.a.a.n.b.b0
    public void b(StringBuffer stringBuffer, Object obj) throws IndexOutOfBoundsException {
        double d;
        double d2;
        Iterator<f0> it;
        boolean z2;
        double dDoubleValue = BigDecimal.valueOf(((Number) obj).doubleValue()).multiply(BigDecimal.valueOf(this.e)).doubleValue();
        double d3 = 0.0d;
        boolean z3 = false;
        int i2 = 1;
        boolean z4 = dDoubleValue < 0.0d;
        if (z4) {
            dDoubleValue = -dDoubleValue;
        }
        if (this.g == null) {
            d = d3;
            d2 = dDoubleValue;
        } else if (this.w) {
            d = dDoubleValue;
            d2 = 0.0d;
        } else {
            d3 = dDoubleValue % 1.0d;
            dDoubleValue = (long) dDoubleValue;
            d = d3;
            d2 = dDoubleValue;
        }
        TreeSet treeSet = new TreeSet();
        StringBuffer stringBuffer2 = new StringBuffer(s(this.c));
        if (this.f2337h != null) {
            D(d2, stringBuffer2, treeSet);
        } else if (this.w) {
            A(d2, null, d, stringBuffer2, treeSet);
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            try {
                Formatter formatter = new Formatter(stringBuffer3, this.b);
                try {
                    formatter.format(this.b, this.d, Double.valueOf(d2));
                    formatter.close();
                    if (this.f2338i == null) {
                        B(stringBuffer3, stringBuffer2);
                        C(stringBuffer3, stringBuffer2, this.f2343n, treeSet, this.f2341l);
                    } else {
                        A(d2, stringBuffer3, d, stringBuffer2, treeSet);
                    }
                } finally {
                }
            } catch (IllegalFormatException e) {
                throw new IllegalArgumentException("Format: " + this.d, e);
            }
        }
        String string = Character.toString(i().getGroupingSeparator());
        Iterator<i0> it2 = treeSet.iterator();
        i0 next = it2.hasNext() ? it2.next() : null;
        i.i.a.h hVar = new i.i.a.h();
        Iterator<f0> it3 = this.f2342m.iterator();
        int length = 0;
        while (it3.hasNext()) {
            f0 next2 = it3.next();
            int i3 = next2.b;
            int i4 = i3 + length;
            if (!hVar.c(i3) && stringBuffer2.charAt(i4) == '#') {
                stringBuffer2.deleteCharAt(i4);
                length--;
                hVar.i(next2.b);
            }
            while (next != null && next2 == next.d()) {
                int length2 = stringBuffer2.length();
                int i5 = next2.b + length;
                int iC = next.c();
                if (iC == i2) {
                    it = it3;
                    z2 = z3;
                    stringBuffer2.insert(i5, next.e());
                } else if (iC == 2) {
                    it = it3;
                    z2 = z3;
                    if (!next.e().equals(string) || !hVar.c(next2.b)) {
                        stringBuffer2.insert(i5 + 1, next.e());
                    }
                } else {
                    if (iC != 3) {
                        throw new IllegalStateException("Unknown op: " + next.c());
                    }
                    int i6 = next2.b;
                    if (!next.g()) {
                        i6++;
                        i5++;
                    }
                    while (hVar.c(i6)) {
                        i6++;
                        i5++;
                    }
                    int i7 = next.b().b;
                    if (next.f()) {
                        i7++;
                    }
                    int i8 = i7 + length;
                    if (i5 < i8) {
                        if (next.e() == null || next.e().length() != 0) {
                            it = it3;
                            z2 = false;
                            char cCharAt = next.e().charAt(0);
                            while (i5 < i8) {
                                stringBuffer2.setCharAt(i5, cCharAt);
                                i5++;
                            }
                        } else {
                            stringBuffer2.delete(i5, i8);
                            it = it3;
                            z2 = false;
                        }
                        hVar.k(i6, i7);
                    } else {
                        it = it3;
                        z2 = false;
                    }
                }
                length += stringBuffer2.length() - length2;
                next = it2.hasNext() ? it2.next() : null;
                z3 = z2;
                it3 = it;
                i2 = 1;
            }
            z3 = z3;
            it3 = it3;
            i2 = 1;
        }
        if (z4) {
            stringBuffer.append(NameUtil.HYPHEN);
        }
        stringBuffer.append(stringBuffer2);
    }

    @Override // n.a.a.n.b.b0
    public void e(StringBuffer stringBuffer, Object obj) {
        this.y.b(stringBuffer, obj);
    }
}
