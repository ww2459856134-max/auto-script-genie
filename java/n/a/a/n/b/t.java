package n.a.a.n.b;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.util.Chars;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import n.a.a.o.a1;
import n.a.a.o.o0;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class t {
    static final Map<String, n.a.a.h.a.a> f;

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f2351h;

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f2352i;

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f2353j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f2354k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f2355l;

    /* renamed from: m, reason: collision with root package name */
    public static final int f2356m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f2357n;
    private final n.a.a.h.a.a a;
    private final r b;
    private final b0 c;
    private final a0 d;
    private static final Logger e = n.a.a.i.b.a(t.class);
    static final List<n.a.a.h.a.a> g = Collections.unmodifiableList((List) Arrays.asList(0, 16777215, 16711680, 65280, 255, 16776960, 16711935, 65535, 8388608, 32768, 128, 8421376, 8388736, 32896, 12632256, 8421504, 10066431, 10040166, 16777164, 13434879, 6684774, 16744576, 26316, 13421823, 128, 16711935, 16776960, 65535, 8388736, 8388608, 32896, 255, 52479, 13434879, 13434828, 16777113, 10079487, 16751052, 13408767, 16764057, 3368703, 3394764, 10079232, 16763904, 16750848, 16737792, 6710937, 9868950, 13158, 3381606, 13056, 3355392, 10040064, 10040166, 3355545, 3355443).stream().map(new Function() { // from class: n.a.a.n.b.c
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return new n.a.a.h.a.a(((Integer) obj).intValue());
        }
    }).collect(Collectors.toList()));

    static {
        int i2 = 0;
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (n.a.a.g.a.a aVar : n.a.a.g.a.a.values()) {
            String strName = aVar.name();
            short[] sArrD = aVar.d();
            n.a.a.h.a.a aVar2 = new n.a.a.h.a.a(sArrD[0], sArrD[1], sArrD[2]);
            treeMap.put(strName, aVar2);
            if (strName.indexOf(95) > 0) {
                treeMap.put(strName.replace(NameUtil.USCORE, Chars.SPACE), aVar2);
            }
            if (strName.indexOf("_PERCENT") > 0) {
                treeMap.put(strName.replace("_PERCENT", "%").replace(NameUtil.USCORE, Chars.SPACE), aVar2);
            }
        }
        List<n.a.a.h.a.a> list = g;
        treeMap.put("black", list.get(0));
        treeMap.put("white", list.get(1));
        treeMap.put("red", list.get(2));
        treeMap.put("green", list.get(3));
        treeMap.put("blue", list.get(4));
        treeMap.put("yellow", list.get(5));
        treeMap.put("magenta", list.get(6));
        treeMap.put("cyan", list.get(7));
        Iterator it = treeMap.keySet().iterator();
        String str = "\\[(";
        while (it.hasNext()) {
            str = str + ((String) it.next()).replaceAll("([^a-zA-Z0-9])", "\\\\$1") + "|";
        }
        String str2 = str + "color\\s*[0-9]+)\\]";
        String str3 = "\\\\.                     # Quoted single character\n|\"([^\\\\\"]|\\\\.)*\"         # Quoted string of characters (handles escaped quotes like \\\") \n|(\\[\\$.{0,3}(-[0-9a-f]{3,4})?])                   # Currency symbol in a given locale\n|_.                             # Space as wide as a given character\n|\\*.                           # Repeating fill character\n|@                              # Text: cell text\n|([0?\\#][0?\\#,]*)             # Number: digit + other digits and commas\n|e[-+]                          # Number: Scientific: Exponent\n|m{1,5}                         # Date: month or minute spec\n|d{1,4}                         # Date: day/date spec\n|y{2,4}                         # Date: year spec\n|h{1,2}                         # Date: hour spec\n|s{1,2}                         # Date: second spec\n|am?/pm?                        # Date: am/pm spec\n|\\[h{1,2}]                     # Elapsed time: hour spec\n|\\[m{1,2}]                     # Elapsed time: minute spec\n|\\[s{1,2}]                     # Elapsed time: second spec\n|[^;]                           # A character\n";
        Pattern.compile(str2, 6);
        Pattern.compile("([<>=]=?|!=|<>)    # The operator\n  \\s*(-?([0-9]+(?:\\.[0-9]*)?)|(\\.[0-9]*))\\s*  # The constant to test against\n", 6);
        f2351h = Pattern.compile(str3, 6);
        f2352i = Pattern.compile("(\\[\\$.{0,3}(-[0-9a-f]{3,4})?])", 6);
        Pattern patternCompile = Pattern.compile("(?:" + str2 + ")?                 # Text color\n(?:\\[([<>=]=?|!=|<>)    # The operator\n  \\s*(-?([0-9]+(?:\\.[0-9]*)?)|(\\.[0-9]*))\\s*  # The constant to test against\n])?               # Condition\n(?:\\[\\$-[0-9a-fA-F]+])?                # Optional locale id, ignored currently\n((?:" + str3 + ")+)                        # Format spec\n", 6);
        f2353j = patternCompile;
        f2354k = d(patternCompile, "[Blue]@", "Blue");
        f2355l = d(patternCompile, "[>=1]@", ">=");
        f2356m = d(patternCompile, "[>=1]@", "1");
        f2357n = d(patternCompile, "[Blue][>1]\\a ?", "\\a ?");
        while (true) {
            List<n.a.a.h.a.a> list2 = g;
            if (i2 >= list2.size()) {
                f = Collections.unmodifiableMap(treeMap);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("color");
            int i3 = i2 + 1;
            sb.append(i3);
            treeMap.put(sb.toString(), list2.get(i2));
            treeMap.put("color " + i3, list2.get(i2));
            i2 = i3;
        }
    }

    public t(String str) {
        this(a1.e(), str);
    }

    static String c(String str) {
        PrimitiveIterator.OfInt ofIntB = o0.b(str);
        Integer next = ofIntB.hasNext() ? ofIntB.next() : null;
        Integer next2 = ofIntB.hasNext() ? ofIntB.next() : null;
        if (next == null || next2 == null) {
            throw new IllegalArgumentException("Expected part string to have at least 2 chars");
        }
        char[] chars = Character.toChars(next2.intValue());
        StringBuilder sb = new StringBuilder(chars.length * 3);
        sb.append(chars);
        sb.append(chars);
        sb.append(chars);
        return sb.toString();
    }

    private static int d(Pattern pattern, String str, String str2) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Pattern \"" + pattern.pattern() + "\" doesn't match \"" + str + "\"");
        }
        for (int i2 = 1; i2 <= matcher.groupCount(); i2++) {
            String strGroup = matcher.group(i2);
            if (strGroup != null && strGroup.equals(str2)) {
                return i2;
            }
        }
        throw new IllegalArgumentException("\"" + str2 + "\" not found in \"" + pattern.pattern() + "\"");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private a0 e(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty() || strTrim.equalsIgnoreCase("General")) {
            return a0.c;
        }
        Matcher matcher = f2351h.matcher(strTrim);
        boolean z = false;
        boolean z2 = false;
        while (matcher.find()) {
            String strGroup = matcher.group(0);
            Iterator<String> itA = o0.a(strGroup);
            if (itA.hasNext()) {
                String next = itA.next();
                next.hashCode();
                char c = 65535;
                switch (next.hashCode()) {
                    case 35:
                        if (next.equals("#")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 48:
                        if (next.equals("0")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 63:
                        if (next.equals("?")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 64:
                        if (next.equals("@")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 68:
                        if (next.equals("D")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 72:
                        if (next.equals("H")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 77:
                        if (next.equals("M")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 83:
                        if (next.equals("S")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 89:
                        if (next.equals("Y")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 91:
                        if (next.equals("[")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case 100:
                        if (next.equals("d")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 104:
                        if (next.equals("h")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 109:
                        if (next.equals("m")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case 115:
                        if (next.equals("s")) {
                            c = Chars.CR;
                            break;
                        }
                        break;
                    case 121:
                        if (next.equals("y")) {
                            c = 14;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                    case 2:
                        return a0.d;
                    case 1:
                        z2 = true;
                        break;
                    case 3:
                        return a0.g;
                    case 4:
                    case '\b':
                    case '\n':
                    case 14:
                        return a0.e;
                    case 5:
                    case 6:
                    case 7:
                    case 11:
                    case '\f':
                    case '\r':
                        z = true;
                        break;
                    case '\t':
                        String lowerCase = itA.hasNext() ? itA.next().toLowerCase(Locale.ROOT) : null;
                        if ("h".equals(lowerCase) || "m".equals(lowerCase) || "s".equals(lowerCase)) {
                            return a0.f;
                        }
                        if ("$".equals(lowerCase)) {
                            return a0.d;
                        }
                        throw new IllegalArgumentException("Unsupported [] format block '" + strGroup + "' in '" + strTrim + "' with c2: " + lowerCase);
                }
            }
        }
        return z ? a0.e : z2 ? a0.d : a0.g;
    }

    private a0 f(Matcher matcher) {
        return e(matcher.group(f2357n));
    }

    static n.a.a.h.a.a g(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        n.a.a.h.a.a aVar = f.get(str);
        if (aVar == null) {
            e.warn("Unknown color: {}", b0.c(str));
        }
        return aVar;
    }

    private static n.a.a.h.a.a h(Matcher matcher) {
        return g(matcher.group(f2354k));
    }

    private r i(Matcher matcher) {
        int i2 = f2355l;
        String strGroup = matcher.group(i2);
        if (strGroup == null || strGroup.isEmpty()) {
            return null;
        }
        return r.a(matcher.group(i2), matcher.group(f2356m));
    }

    private b0 j(Locale locale, Matcher matcher) {
        String strGroup = matcher.group(f2357n);
        Matcher matcher2 = f2352i.matcher(strGroup);
        if (matcher2.find()) {
            String strGroup2 = matcher2.group(1);
            strGroup = strGroup.replace(strGroup2, strGroup2.startsWith("[$-") ? "$" : !strGroup2.contains(ProcessIdUtil.DEFAULT_PROCESSID) ? strGroup2.substring(2, strGroup2.indexOf("]")) : strGroup2.substring(2, strGroup2.lastIndexOf(45)));
        }
        return this.d.a(locale, strGroup);
    }

    public static String k(Matcher matcher, int i2) {
        String strGroup = matcher.group(i2);
        return strGroup == null ? "" : strGroup;
    }

    public static StringBuffer m(String str, a0 a0Var, s sVar) {
        int iIndexOf;
        Matcher matcher = f2351h.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            iIndexOf = 0;
            if (!matcher.find()) {
                break;
            }
            String strK = k(matcher, 0);
            if (!strK.isEmpty()) {
                String strA = sVar.a(matcher, strK, a0Var, stringBuffer);
                if (strA == null) {
                    char cCharAt = strK.charAt(0);
                    if (cCharAt == '\"') {
                        strK = n(strK.substring(1, strK.length() - 1), a0Var);
                    } else if (cCharAt == '*') {
                        strK = c(strK);
                    } else if (cCharAt == '\\') {
                        strK = n(strK.substring(1), a0Var);
                    } else if (cCharAt == '_') {
                        strK = " ";
                    }
                } else {
                    strK = strA;
                }
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(strK));
            }
        }
        matcher.appendTail(stringBuffer);
        if (a0Var.b(Chars.QUOTE)) {
            int iIndexOf2 = 0;
            while (true) {
                iIndexOf2 = stringBuffer.indexOf("''", iIndexOf2);
                if (iIndexOf2 < 0) {
                    break;
                }
                stringBuffer.delete(iIndexOf2, iIndexOf2 + 2);
                if (sVar instanceof d) {
                    ((d) sVar).c(iIndexOf2, -2);
                }
            }
            while (true) {
                iIndexOf = stringBuffer.indexOf("\u0000", iIndexOf);
                if (iIndexOf < 0) {
                    break;
                }
                stringBuffer.replace(iIndexOf, iIndexOf + 1, "''");
                if (sVar instanceof d) {
                    ((d) sVar).c(iIndexOf, 1);
                }
            }
        }
        return stringBuffer;
    }

    static String n(String str, a0 a0Var) {
        StringBuilder sb = new StringBuilder();
        PrimitiveIterator.OfInt ofIntB = o0.b(str);
        while (ofIntB.hasNext()) {
            int iNextInt = ofIntB.nextInt();
            if (iNextInt == 39 && a0Var.b(Chars.QUOTE)) {
                sb.append((char) 0);
            } else {
                char[] chars = Character.toChars(iNextInt);
                boolean zB = a0Var.b(chars[0]);
                if (zB) {
                    sb.append(Chars.QUOTE);
                }
                sb.append(chars);
                if (zB) {
                    sb.append(Chars.QUOTE);
                }
            }
        }
        return sb.toString();
    }

    public boolean a(Object obj) {
        r rVar = this.b;
        if (rVar != null && (obj instanceof Number)) {
            return rVar.b(((Number) obj).doubleValue());
        }
        Objects.requireNonNull(obj, "valueObject");
        return true;
    }

    public u b(Object obj) {
        String strD;
        n.a.a.h.a.a aVar;
        boolean zA = a(obj);
        if (zA) {
            strD = this.c.a(obj);
            aVar = this.a;
        } else {
            strD = this.c.d(obj);
            aVar = null;
        }
        return new u(zA, strD, aVar);
    }

    boolean l() {
        return this.b != null;
    }

    public String toString() {
        return this.c.a;
    }

    public t(Locale locale, String str) {
        Matcher matcher = f2353j.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Unrecognized format: " + b0.c(str));
        }
        this.a = h(matcher);
        this.b = i(matcher);
        this.d = f(matcher);
        this.c = j(locale, matcher);
    }
}
