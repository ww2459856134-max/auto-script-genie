package n.a.a.n.e;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n.a.a.n.c.c1;
import n.a.a.o.j1;
import n.a.a.o.v0;

/* loaded from: classes.dex */
public class s implements n.a.a.e.a.a {

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f2491h = Pattern.compile("(\\$?[A-Z]+)?(\\$?[0-9]+)?", 2);

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f2492i = Pattern.compile("\\$?([A-Z]+)\\$?([0-9]+)", 2);

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f2493j = Pattern.compile("\\$?([A-Z]+)", 2);

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f2494k = Pattern.compile("\\$?([0-9]+)");
    private static final Pattern t = Pattern.compile("[_A-Z][_.A-Z0-9]*", 2);
    private final String c;
    private final int d;
    private final int e;
    private final boolean f;
    private final boolean g;

    public s(String str) {
        if (j1.b(str, "#REF!")) {
            throw new IllegalArgumentException("Cell reference invalid: " + str);
        }
        q qVarV = v(str);
        this.c = qVarV.a;
        String strSubstring = qVarV.c;
        boolean z = false;
        boolean z2 = !strSubstring.isEmpty() && strSubstring.charAt(0) == '$';
        this.g = z2;
        strSubstring = z2 ? strSubstring.substring(1) : strSubstring;
        if (strSubstring.isEmpty()) {
            this.e = -1;
        } else {
            this.e = d(strSubstring);
        }
        String strSubstring2 = qVarV.b;
        if (!strSubstring2.isEmpty() && strSubstring2.charAt(0) == '$') {
            z = true;
        }
        this.f = z;
        strSubstring2 = z ? strSubstring2.substring(1) : strSubstring2;
        if (strSubstring2.isEmpty()) {
            this.d = -1;
        } else {
            this.d = Integer.parseInt(strSubstring2) - 1;
        }
    }

    public static boolean b(String str, String str2, n.a.a.n.a aVar) {
        if (p(str, aVar)) {
            return t(str2, aVar);
        }
        return false;
    }

    public static r c(String str, n.a.a.n.a aVar) {
        int length = str.length();
        if (length < 1) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == '$' || cCharAt == '.' || cCharAt == '_' || Character.isLetter(cCharAt) || Character.isDigit(cCharAt)) {
            if (!Character.isDigit(str.charAt(length - 1))) {
                return w(str, aVar);
            }
            Matcher matcher = f2492i.matcher(str);
            return !matcher.matches() ? w(str, aVar) : b(matcher.group(1), matcher.group(2), aVar) ? r.CELL : str.indexOf(36) >= 0 ? r.BAD_CELL_OR_NAMED_RANGE : r.NAMED_RANGE;
        }
        throw new IllegalArgumentException("Invalid first char (" + cCharAt + ") of cell reference or named range.  Letter expected");
    }

    public static int d(String str) {
        char[] charArray = str.toUpperCase(Locale.ROOT).toCharArray();
        int i2 = 0;
        for (int i3 = 0; i3 < charArray.length; i3++) {
            char c = charArray[i3];
            if (c != '$') {
                i2 = (i2 * 26) + (c - 'A') + 1;
            } else if (i3 != 0) {
                throw new IllegalArgumentException("Bad col ref format '" + str + "'");
            }
        }
        return i2 - 1;
    }

    public static String f(int i2) {
        int i3 = i2 + 1;
        StringBuilder sb = new StringBuilder(2);
        while (i3 > 0) {
            int i4 = i3 % 26;
            if (i4 == 0) {
                i4 = 26;
            }
            i3 = (i3 - i4) / 26;
            sb.insert(0, (char) (i4 + 64));
        }
        return sb.toString();
    }

    public static boolean p(String str, n.a.a.n.a aVar) {
        String strB = aVar.b();
        int length = strB.length();
        int length2 = str.length();
        if (length2 > length) {
            return false;
        }
        return length2 != length || str.toUpperCase(Locale.ROOT).compareTo(strB) <= 0;
    }

    public static boolean q(String str) {
        return str.charAt(0) == '$';
    }

    public static boolean s(int i2, n.a.a.n.a aVar) {
        return i2 >= 0 && i2 <= aVar.c();
    }

    public static boolean t(String str, n.a.a.n.a aVar) {
        long j2 = Long.parseLong(str) - 1;
        if (j2 > 2147483647L) {
            return false;
        }
        return s(Math.toIntExact(j2), aVar);
    }

    private static String u(String str, int i2) {
        if (i2 < 0) {
            return null;
        }
        if (!(str.charAt(0) == '\'')) {
            if (!str.contains(" ")) {
                return str.substring(0, i2);
            }
            throw new IllegalArgumentException("Sheet names containing spaces must be quoted: (" + str + ")");
        }
        int i3 = i2 - 1;
        if (str.charAt(i3) != '\'') {
            throw new IllegalArgumentException("Mismatched quotes: (" + str + ")");
        }
        StringBuilder sb = new StringBuilder(i2);
        int i4 = 1;
        while (i4 < i3) {
            char cCharAt = str.charAt(i4);
            if (cCharAt != '\'') {
                sb.append(cCharAt);
            } else {
                i4++;
                if (i4 >= i3 || str.charAt(i4) != '\'') {
                    throw new IllegalArgumentException("Bad sheet name quote escaping: (" + str + ")");
                }
                sb.append(cCharAt);
            }
            i4++;
        }
        return sb.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: n.a.a.n.e.q.<init>(java.lang.String, java.lang.String, java.lang.String, n.a.a.n.e.p):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:291)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:194)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    private static n.a.a.n.e.q v(java.lang.String r4) {
        /*
            r0 = 33
            int r0 = r4.lastIndexOf(r0)
            java.lang.String r1 = u(r4, r0)
            r2 = 1
            int r0 = r0 + r2
            java.lang.String r0 = r4.substring(r0)
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toUpperCase(r3)
            java.util.regex.Pattern r3 = n.a.a.n.e.s.f2491h
            java.util.regex.Matcher r0 = r3.matcher(r0)
            boolean r3 = r0.matches()
            if (r3 == 0) goto L32
            java.lang.String r4 = r0.group(r2)
            r2 = 2
            java.lang.String r0 = r0.group(r2)
            n.a.a.n.e.q r2 = new n.a.a.n.e.q
            r3 = 0
            r2.<init>(r1, r0, r4)
            return r2
        L32:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid CellReference: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n.a.a.n.e.s.v(java.lang.String):n.a.a.n.e.q");
    }

    private static r w(String str, n.a.a.n.a aVar) {
        Matcher matcher = f2493j.matcher(str);
        if (matcher.matches() && p(matcher.group(1), aVar)) {
            return r.COLUMN;
        }
        Matcher matcher2 = f2494k.matcher(str);
        return (matcher2.matches() && t(matcher2.group(1), aVar)) ? r.ROW : !t.matcher(str).matches() ? r.BAD_CELL_OR_NAMED_RANGE : r.NAMED_RANGE;
    }

    void a(StringBuilder sb) {
        if (this.e != -1) {
            if (this.g) {
                sb.append('$');
            }
            sb.append(f(this.e));
        }
        if (this.d != -1) {
            if (this.f) {
                sb.append('$');
            }
            sb.append(this.d + 1);
        }
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return v0.h("sheetName", new Supplier() { // from class: n.a.a.n.e.h
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.n();
            }
        }, "rowIndex", new Supplier() { // from class: n.a.a.n.e.i
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a.m());
            }
        }, "colIndex", new Supplier() { // from class: n.a.a.n.e.e
            @Override // java.util.function.Supplier
            public final Object get() {
                return Short.valueOf(this.a.l());
            }
        }, "rowAbs", new Supplier() { // from class: n.a.a.n.e.f
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a.r());
            }
        }, "colAbs", new Supplier() { // from class: n.a.a.n.e.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a.o());
            }
        }, "formatAsString", new Supplier() { // from class: n.a.a.n.e.c
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.g();
            }
        });
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.d == sVar.d && this.e == sVar.e && this.f == sVar.f && this.g == sVar.g && Objects.equals(this.c, sVar.c);
    }

    public String g() {
        return i(true);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.d), Integer.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.g), this.c);
    }

    public String i(boolean z) {
        String str;
        StringBuilder sb = new StringBuilder(32);
        if (z && (str = this.c) != null) {
            c1.b(sb, str);
            sb.append('!');
        }
        a(sb);
        return sb.toString();
    }

    public String[] k() {
        return new String[]{this.c, Integer.toString(this.d + 1), f(this.e)};
    }

    public short l() {
        return (short) this.e;
    }

    public int m() {
        return this.d;
    }

    public String n() {
        return this.c;
    }

    public boolean o() {
        return this.g;
    }

    public boolean r() {
        return this.f;
    }

    public String toString() {
        return s.class.getName() + " [" + g() + "]";
    }

    public s(int i2, int i3) {
        this(i2, i3, false, false);
    }

    public s(int i2, short s) {
        this(i2, s & 65535, false, false);
    }

    public s(n.a.a.n.d.e eVar) {
        this(eVar.getSheet().c(), eVar.g(), eVar.i(), false, false);
    }

    public s(int i2, int i3, boolean z, boolean z2) {
        this(null, i2, i3, z, z2);
    }

    public s(String str, int i2, int i3, boolean z, boolean z2) {
        if (i2 < -1) {
            throw new IllegalArgumentException("row index may not be negative, but had " + i2);
        }
        if (i3 >= -1) {
            this.c = str;
            this.d = i2;
            this.e = i3;
            this.f = z;
            this.g = z2;
            return;
        }
        throw new IllegalArgumentException("column index may not be negative, but had " + i3);
    }
}
