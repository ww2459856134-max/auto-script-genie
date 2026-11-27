package n.a.a.n.d;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.util.Chars;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n.a.a.o.j1;

/* loaded from: classes.dex */
public class w {

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f2477m = Pattern.compile("[0#]+");

    /* renamed from: n, reason: collision with root package name */
    private static final Pattern f2478n = Pattern.compile("([d]{3,})", 2);

    /* renamed from: o, reason: collision with root package name */
    private static final Pattern f2479o = Pattern.compile("(([AP])[M/P]*)", 2);
    private static final Pattern p = Pattern.compile(".*\\[\\s*(>|>=|<|<=|=)\\s*[0-9]*\\.*[0-9].*");
    private static final Pattern q = Pattern.compile("(\\[\\$[^-\\]]*-[0-9A-Z]+])");
    private static final Pattern r = Pattern.compile("(\\[BLACK])|(\\[BLUE])|(\\[CYAN])|(\\[GREEN])|(\\[MAGENTA])|(\\[RED])|(\\[WHITE])|(\\[YELLOW])|(\\[COLOR\\s*\\d])|(\\[COLOR\\s*[0-5]\\d])", 2);
    private static final Pattern s = Pattern.compile("(?:([#\\d]+)\\s+)?(#+)\\s*/\\s*([#\\d]+)");
    private static final Pattern t = Pattern.compile("(\"[^\"]*\")|([^ ?#\\d/]+)");
    private static final Pattern u = Pattern.compile("([#0]([^.#0])[#0]{3})");
    private static final Pattern v = Pattern.compile("0+#");
    private static final String w;
    private static final Logger x;
    private DecimalFormatSymbols a;
    private DateFormatSymbols b;
    private DateFormat c;
    private Format d;
    private Format e;
    private final Map<String, Format> f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2480h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2481i;

    /* renamed from: j, reason: collision with root package name */
    private Locale f2482j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2483k;

    /* renamed from: l, reason: collision with root package name */
    private final PropertyChangeSupport f2484l;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 255; i2++) {
            sb.append('#');
        }
        w = sb.toString();
        x = n.a.a.i.b.a(w.class);
    }

    public w() {
        this(false);
    }

    private void e() {
        f(n.a.a.o.a1.e());
    }

    private void f(Locale locale) {
        if (this.f2483k && !locale.equals(this.f2482j)) {
            A(locale);
            this.f2484l.firePropertyChange("locale", this.f2482j, locale);
        }
    }

    private String g(String str) {
        StringBuilder sb = new StringBuilder(str.replace("\\%", "'%'"));
        int i2 = 0;
        if (this.g) {
            int i3 = 0;
            while (i3 < sb.length()) {
                char cCharAt = sb.charAt(i3);
                if ((cCharAt == '_' || cCharAt == '*' || cCharAt == '?') && (i3 <= 0 || sb.charAt(i3 - 1) != '\\')) {
                    if (cCharAt == '?') {
                        sb.setCharAt(i3, Chars.SPACE);
                    } else if (i3 < sb.length() - 1) {
                        if (cCharAt == '_') {
                            sb.setCharAt(i3 + 1, Chars.SPACE);
                        } else {
                            sb.deleteCharAt(i3 + 1);
                        }
                        sb.deleteCharAt(i3);
                        i3--;
                    }
                }
                i3++;
            }
        } else {
            int i4 = 0;
            while (i4 < sb.length()) {
                char cCharAt2 = sb.charAt(i4);
                if ((cCharAt2 == '_' || cCharAt2 == '*') && (i4 <= 0 || sb.charAt(i4 - 1) != '\\')) {
                    if (i4 < sb.length() - 1) {
                        sb.deleteCharAt(i4 + 1);
                    }
                    sb.deleteCharAt(i4);
                    i4--;
                }
                i4++;
            }
        }
        while (i2 < sb.length()) {
            char cCharAt3 = sb.charAt(i2);
            if (cCharAt3 == '\\' || cCharAt3 == '\"') {
                sb.deleteCharAt(i2);
            } else if ((cCharAt3 == '+' || cCharAt3 == '-') && i2 > 0 && sb.charAt(i2 - 1) == 'E') {
                sb.deleteCharAt(i2);
            } else {
                i2++;
            }
            i2--;
            i2++;
        }
        return sb.toString();
    }

    private Format h(String str, double d) {
        int i2;
        char c;
        String strReplace = d(str).replace("\\-", ProcessIdUtil.DEFAULT_PROCESSID).replace("\\,", ",").replace("\\.", ".").replace("\\ ", " ").replace("\\/", "/").replace(";@", "").replace("\"/\"", "/").replace("\"\"", "'").replace("\\T", "'T'");
        Matcher matcher = f2479o.matcher(strReplace);
        boolean z = false;
        boolean z2 = false;
        while (matcher.find()) {
            strReplace = matcher.replaceAll("@");
            matcher = f2479o.matcher(strReplace);
            z2 = true;
        }
        String strReplace2 = strReplace.replace('@', 'a');
        Matcher matcher2 = f2478n.matcher(strReplace2);
        if (matcher2.find()) {
            strReplace2 = matcher2.replaceAll(matcher2.group(0).toUpperCase(Locale.ROOT).replace('D', 'E'));
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = strReplace2.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        boolean z3 = false;
        boolean z4 = true;
        while (i3 < charArray.length) {
            char c2 = charArray[i3];
            if (c2 == '\'') {
                sb.append(c2);
                do {
                    i3++;
                    if (i3 >= charArray.length) {
                        break;
                    }
                    c = charArray[i3];
                    sb.append(c);
                } while (c != '\'');
            } else {
                if (c2 == '[' && !z3) {
                    sb.append(c2);
                    z4 = z;
                    i2 = 1;
                    z3 = true;
                } else if (c2 == ']' && z3) {
                    sb.append(c2);
                    z3 = z;
                } else if (z3) {
                    if (c2 == 'h' || c2 == 'H') {
                        sb.append('H');
                    } else if (c2 == 'm' || c2 == 'M') {
                        sb.append('m');
                    } else if (c2 == 's' || c2 == 'S') {
                        sb.append('s');
                    } else {
                        sb.append(c2);
                    }
                } else if (c2 == 'h' || c2 == 'H') {
                    if (z2) {
                        sb.append('h');
                    } else {
                        sb.append('H');
                    }
                    i2 = 1;
                    z4 = false;
                } else if (c2 != 'm' && c2 != 'M') {
                    if (c2 == 's' || c2 == 'S') {
                        sb.append('s');
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            int iIntValue = ((Integer) it.next()).intValue();
                            if (sb.charAt(iIntValue) == 'M') {
                                sb.replace(iIntValue, iIntValue + 1, "m");
                            }
                        }
                        arrayList.clear();
                    } else if (Character.isLetter(c2)) {
                        arrayList.clear();
                        if (c2 == 'y' || c2 == 'Y') {
                            sb.append('y');
                        } else if (c2 == 'd' || c2 == 'D') {
                            sb.append('d');
                        } else {
                            sb.append(c2);
                        }
                    } else {
                        if (Character.isWhitespace(c2)) {
                            arrayList.clear();
                        }
                        sb.append(c2);
                    }
                    i2 = 1;
                    z4 = true;
                } else if (z4) {
                    sb.append('M');
                    arrayList.add(Integer.valueOf(sb.length() - 1));
                } else {
                    sb.append('m');
                }
                i3 += i2;
                z = false;
            }
            i2 = 1;
            i3 += i2;
            z = false;
        }
        String string = sb.toString();
        try {
            return new b0(string, this.b);
        } catch (IllegalArgumentException e) {
            x.atDebug().withThrowable(e).log("Formatting failed for format {}, falling back", string);
            return q(d);
        }
    }

    private Format i(double d, int i2, String str) {
        String strGroup;
        int iIndexOf;
        e();
        int i3 = 0;
        if (str != null) {
            Matcher matcher = r.matcher(str);
            while (matcher.find() && (iIndexOf = str.indexOf((strGroup = matcher.group()))) != -1) {
                String str2 = str.substring(0, iIndexOf) + str.substring(iIndexOf + strGroup.length());
                if (str2.equals(str)) {
                    break;
                }
                matcher = r.matcher(str2);
                str = str2;
            }
        }
        if (str != null) {
            Matcher matcher2 = q.matcher(str);
            while (matcher2.find()) {
                String strGroup2 = matcher2.group();
                String strSubstring = strGroup2.substring(strGroup2.indexOf(36) + 1, strGroup2.indexOf(45));
                if (strSubstring.indexOf(36) > -1) {
                    strSubstring = strSubstring.substring(0, strSubstring.indexOf(36)) + '\\' + strSubstring.substring(strSubstring.indexOf(36));
                }
                str = matcher2.replaceAll(strSubstring);
                matcher2 = q.matcher(str);
            }
        }
        if (j1.f(str)) {
            return q(d);
        }
        if ("General".equalsIgnoreCase(str) || "@".equals(str)) {
            return this.d;
        }
        if (str == null) {
            return null;
        }
        if (y.o(i2, str) && y.v(d)) {
            return h(str, d);
        }
        if (!str.contains("#/") && !str.contains("?/")) {
            if (f2477m.matcher(str).find()) {
                return k(str, d);
            }
            if (this.g) {
                return new r(g(str));
            }
            return null;
        }
        String[] strArrSplit = str.split(";");
        int length = strArrSplit.length;
        while (true) {
            if (i3 >= length) {
                return new k0("#", "#/##");
            }
            Matcher matcher3 = s.matcher(t.matcher(strArrSplit[i3].replace("?", "#")).replaceAll(" ").replaceAll(" +", " "));
            if (matcher3.find()) {
                return new k0(matcher3.group(1) == null ? "" : "#", matcher3.group(3));
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DecimalFormat j(String str) {
        DecimalFormat decimalFormat = new DecimalFormat(str, DecimalFormatSymbols.getInstance(Locale.ROOT));
        decimalFormat.setParseIntegerOnly(true);
        return decimalFormat;
    }

    private Format k(String str, double d) {
        char cCharAt;
        String strG = g(str);
        DecimalFormatSymbols decimalFormatSymbols = this.a;
        Matcher matcher = u.matcher(strG);
        if (matcher.find() && (cCharAt = matcher.group(2).charAt(0)) != ',') {
            decimalFormatSymbols = DecimalFormatSymbols.getInstance(this.f2482j);
            decimalFormatSymbols.setGroupingSeparator(cCharAt);
            String strGroup = matcher.group(1);
            strG = strG.replace(strGroup, strGroup.replace(cCharAt, ','));
        }
        if (v.matcher(strG).matches()) {
            strG = "#";
        }
        try {
            return new s(strG, decimalFormatSymbols);
        } catch (IllegalArgumentException e) {
            x.atDebug().withThrowable(e).log("Formatting failed for format {}, falling back", str);
            return q(d);
        }
    }

    private Format q(double d) {
        e();
        Format format = this.e;
        return format != null ? format : this.d;
    }

    private Format r(double d, int i2, String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("Missing input format for value " + d + " and index " + i2);
        }
        e();
        String strReplace = str.replace("\\%", "'%'");
        if (strReplace.contains(";") && (strReplace.indexOf(59) != strReplace.lastIndexOf(59) || p.matcher(strReplace).matches())) {
            try {
                return new q(this, n.a.a.n.b.k.d(this.f2482j, strReplace).a((d == 0.0d || !y.o(i2, strReplace)) ? Double.valueOf(d) : y.l(d, z)), null);
            } catch (Exception e) {
                x.atWarn().withThrowable(e).log("Formatting failed for format {}, falling back", strReplace);
            }
        }
        if (this.g && d == 0.0d && strReplace.contains("#") && !strReplace.contains("0")) {
            strReplace = strReplace.replace("#", "");
        }
        Format format = this.f.get(strReplace);
        if (format != null) {
            return format;
        }
        if ("General".equalsIgnoreCase(strReplace) || "@".equals(strReplace)) {
            return this.d;
        }
        Format formatI = i(d, i2, strReplace);
        this.f.put(strReplace, formatI);
        return formatI;
    }

    private Format s(e eVar, n.a.a.n.c.j jVar) {
        a0 a0VarA;
        if (eVar == null || (a0VarA = a0.a(eVar, jVar)) == null) {
            return null;
        }
        int iD = a0VarA.d();
        String strC = a0VarA.c();
        if (j1.f(strC)) {
            return null;
        }
        return r(eVar.d(), iD, strC, v(eVar));
    }

    private String t(e eVar, n.a.a.n.c.j jVar) {
        String strW;
        if (eVar == null) {
            return null;
        }
        Format formatS = s(eVar, jVar);
        if (formatS == null && (formatS = this.c) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", DateFormatSymbols.getInstance(n.a.a.o.a1.e()));
            simpleDateFormat.setTimeZone(n.a.a.o.a1.f());
            formatS = simpleDateFormat;
        }
        synchronized (formatS) {
            if (formatS instanceof b0) {
                ((b0) formatS).b(eVar.d());
            }
            strW = w(eVar.m(), formatS);
        }
        return strW;
    }

    private String u(e eVar, n.a.a.n.c.j jVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        Format formatS = s(eVar, jVar);
        double d = eVar.d();
        if (formatS == null) {
            return Double.toString(d);
        }
        if (formatS instanceof s) {
            s sVar = (s) formatS;
            if (sVar.a()) {
                str = sVar.format(Double.valueOf(d));
            }
        }
        if (str == null) {
            try {
                str = formatS.format(BigDecimal.valueOf(d));
            } catch (NumberFormatException unused) {
                str = formatS.format(Double.valueOf(d));
            }
        }
        return str.replaceFirst("E(\\d)", "E+$1");
    }

    private boolean v(e eVar) {
        if (eVar == null || !(eVar.getSheet().getWorkbook() instanceof x)) {
            return false;
        }
        return ((x) eVar.getSheet().getWorkbook()).isDate1904();
    }

    private String w(Date date, Format format) {
        String str;
        if (format == null) {
            format = this.c;
        }
        synchronized (format) {
            str = format.format(date);
        }
        return str;
    }

    public static void x(DecimalFormat decimalFormat) {
        y(decimalFormat, RoundingMode.HALF_UP);
    }

    public static void y(DecimalFormat decimalFormat, RoundingMode roundingMode) {
        decimalFormat.setRoundingMode(roundingMode);
    }

    public void A(Locale locale) {
        if (!this.f2483k || locale.equals(this.f2482j)) {
            return;
        }
        this.f2482j = locale;
        this.b = DateFormatSymbols.getInstance(locale);
        this.a = DecimalFormatSymbols.getInstance(this.f2482j);
        this.d = new z(this.f2482j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", this.b);
        this.c = simpleDateFormat;
        simpleDateFormat.setTimeZone(n.a.a.o.a1.f());
        this.f.clear();
        Format format = v.c;
        c("00000\\-0000", format);
        c("00000-0000", format);
        Format format2 = t.c;
        c("[<=9999999]###\\-####;\\(###\\)\\ ###\\-####", format2);
        c("[<=9999999]###-####;(###) ###-####", format2);
        c("###\\-####;\\(###\\)\\ ###\\-####", format2);
        c("###-####;(###) ###-####", format2);
        Format format3 = u.c;
        c("000\\-00\\-0000", format3);
        c("000-00-0000", format3);
    }

    public void c(String str, Format format) {
        this.f.put(str, format);
    }

    String d(String str) {
        int iIndexOf;
        if (!this.f2480h || (iIndexOf = str.indexOf("yy")) < 0) {
            return str;
        }
        int iIndexOf2 = str.indexOf("yyy");
        if (str.indexOf("yyyy") == iIndexOf) {
            int i2 = iIndexOf + 4;
            return str.substring(0, i2) + d(str.substring(i2));
        }
        if (iIndexOf2 == iIndexOf) {
            return str;
        }
        int i3 = iIndexOf + 2;
        return str.substring(0, i3) + "yy" + d(str.substring(i3));
    }

    public String l(e eVar) {
        return m(eVar, null);
    }

    public String m(e eVar, j0 j0Var) {
        return n(eVar, j0Var, null);
    }

    public String n(e eVar, j0 j0Var, n.a.a.n.c.j jVar) {
        e();
        if (eVar == null) {
            return "";
        }
        j jVarB = eVar.b();
        if (jVarB == j.FORMULA) {
            if (j0Var != null) {
                jVarB = j0Var.a(eVar);
            } else {
                if (!this.f2481i) {
                    return eVar.j();
                }
                try {
                    jVarB = eVar.h();
                } catch (Exception unused) {
                    return eVar.j();
                }
            }
        }
        int i2 = p.a[jVarB.ordinal()];
        if (i2 == 1) {
            return y.s(eVar, jVar) ? t(eVar, jVar) : u(eVar, jVar);
        }
        if (i2 == 2) {
            return eVar.q().getString();
        }
        if (i2 == 3) {
            return eVar.c() ? "TRUE" : "FALSE";
        }
        if (i2 == 4) {
            return "";
        }
        if (i2 == 5) {
            return i0.a(eVar.a()).f();
        }
        throw new IllegalStateException("Unexpected celltype (" + jVarB + ")");
    }

    public String o(double d, int i2, String str) {
        return p(d, i2, str, false);
    }

    public String p(double d, int i2, String str, boolean z) {
        e();
        if (y.o(i2, str)) {
            if (y.v(d)) {
                Format formatR = r(d, i2, str, z);
                if (formatR instanceof b0) {
                    ((b0) formatR).b(d);
                }
                return w(y.l(d, z), formatR);
            }
            if (this.g) {
                return w;
            }
        }
        Format formatR2 = r(d, i2, str, z);
        if (formatR2 == null) {
            return String.valueOf(d);
        }
        String strH = n.a.a.n.e.c0.h(d);
        String str2 = strH.indexOf(69) > -1 ? formatR2.format(Double.valueOf(d)) : formatR2.format(new BigDecimal(strH));
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return ((lowerCase.contains("general") || lowerCase.contains("e+0")) && str2.contains("E") && !str2.contains("E-")) ? str2.replaceFirst("E", "E+") : str2;
    }

    public void z(boolean z) {
        this.f2481i = z;
    }

    public w(boolean z) {
        this(n.a.a.o.a1.e(), true, z);
    }

    public w(Locale locale, boolean z, boolean z2) {
        this.f = new HashMap();
        this.g = false;
        this.f2480h = false;
        this.f2481i = false;
        this.f2483k = true;
        this.f2484l = new PropertyChangeSupport(this);
        f(locale);
        this.f2483k = z;
        this.g = z2;
    }
}
