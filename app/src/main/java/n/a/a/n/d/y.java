package n.a.a.n.d;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import n.a.a.o.m1;

/* loaded from: classes.dex */
public abstract class y {
    private static final Pattern a;
    private static final Pattern b;
    private static final Pattern c;
    private static final Pattern d;
    private static final Pattern e;
    private static final Pattern f;
    private static final DateTimeFormatter g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f2485h;

    /* renamed from: i, reason: collision with root package name */
    private static final ThreadLocal<Integer> f2486i;

    /* renamed from: j, reason: collision with root package name */
    private static final ThreadLocal<String> f2487j;

    /* renamed from: k, reason: collision with root package name */
    private static final ThreadLocal<Boolean> f2488k;

    static {
        BigDecimal.valueOf(8.64E13d);
        BigDecimal.valueOf(500000.0d);
        BigDecimal.valueOf(5.0E8d);
        Pattern.compile(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        a = Pattern.compile("^\\[\\$-.*?]");
        b = Pattern.compile("^\\[[a-zA-Z]+]");
        c = Pattern.compile("[yYmMdDhHsS]");
        d = Pattern.compile("^[\\[\\]yYmMdDhHsS\\-T/年月日,. :\"\\\\]+0* ?[ampAMP/]*$");
        e = Pattern.compile("^\\[([hH]+|[mM]+|[sS]+)]");
        f = Pattern.compile("^\\[DBNum([123])]");
        g = new DateTimeFormatterBuilder().appendPattern("[d[.] [MMMM][MMM][ yyyy]][[ ]h:m[:s][.SSS] a][[ ]H:m[:s][.SSS]]").appendPattern("[[yyyy ]d-[MMMM][MMM][-yyyy]][[ ]h:m[:s][.SSS] a][[ ]H:m[:s][.SSS]]").appendPattern("[M/dd[/yyyy]][[ ]h:m[:s][.SSS] a][[ ]H:m[:s][.SSS]]").appendPattern("[[yyyy/]M/dd][[ ]h:m[:s][.SSS] a][[ ]H:m[:s][.SSS]]").parseDefaulting(ChronoField.YEAR_OF_ERA, n.a.a.o.a1.a().get(1)).toFormatter(n.a.a.o.a1.e());
        f2485h = true;
        f2486i = ThreadLocal.withInitial(new Supplier() { // from class: n.a.a.n.d.b
            @Override // java.util.function.Supplier
            public final Object get() {
                return y.w();
            }
        });
        f2487j = new ThreadLocal<>();
        f2488k = new ThreadLocal<>();
        m1.a(new Runnable() { // from class: n.a.a.n.d.a
            @Override // java.lang.Runnable
            public final void run() {
                y.x();
            }
        });
    }

    private static int a(int i2, int i3, boolean z) {
        return i3 + c(i2, i3, z);
    }

    private static void b(String str, int i2, boolean z) {
        if (f2485h) {
            if (str == null || "".equals(str)) {
                f2487j.remove();
            } else {
                f2487j.set(str);
            }
            if (i2 == -1) {
                f2486i.remove();
            } else {
                f2486i.set(Integer.valueOf(i2));
            }
            f2488k.set(Boolean.valueOf(z));
        }
    }

    private static int c(int i2, int i3, boolean z) {
        if ((!z && i2 < 1900 && !u(i2, i3)) || (z && i2 < 1904)) {
            throw new IllegalArgumentException("'year' must be 1900 or greater");
        }
        int i4 = i2 - 1;
        return ((i2 - (z ? 1904 : 1900)) * 365) + ((((i4 / 4) - (i4 / 100)) + (i4 / 400)) - 460);
    }

    public static double d(LocalDate localDate) {
        return e(localDate, false);
    }

    public static double e(LocalDate localDate, boolean z) {
        return n(localDate.getYear(), localDate.getDayOfYear(), 0, 0, 0, 0, z);
    }

    public static double f(Date date) {
        return g(date, false);
    }

    public static double g(Date date, boolean z) {
        Calendar calendarA = n.a.a.o.a1.a();
        calendarA.setTime(date);
        return n(calendarA.get(1), calendarA.get(6), calendarA.get(11), calendarA.get(12), calendarA.get(13), calendarA.get(14), z);
    }

    public static Calendar h(double d2, boolean z) {
        return i(d2, z, null, false);
    }

    public static Calendar i(double d2, boolean z, TimeZone timeZone, boolean z2) {
        if (!v(d2)) {
            return null;
        }
        int iFloor = (int) Math.floor(d2);
        int i2 = (int) (((d2 - iFloor) * 8.64E7d) + 0.5d);
        Calendar calendarD = timeZone != null ? n.a.a.o.a1.d(timeZone) : n.a.a.o.a1.a();
        z(calendarD, iFloor, i2, z, z2);
        return calendarD;
    }

    public static Calendar j(double d2, boolean z) {
        return i(d2, z, n.a.a.o.a1.a, false);
    }

    public static Date k(double d2) {
        return m(d2, false, null, false);
    }

    public static Date l(double d2, boolean z) {
        return m(d2, z, null, false);
    }

    public static Date m(double d2, boolean z, TimeZone timeZone, boolean z2) {
        Calendar calendarI = i(d2, z, timeZone, z2);
        if (calendarI == null) {
            return null;
        }
        return calendarI.getTime();
    }

    private static double n(int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        if (!z && i2 < 1900 && !u(i2, i3)) {
            return -1.0d;
        }
        if (z && i2 < 1904) {
            return -1.0d;
        }
        double dA = (((((((i4 * 60.0d) + i5) * 60.0d) + i6) * 1000.0d) + i7) / 8.64E7d) + a(i2, i3, z);
        return (z || dA < 60.0d) ? z ? dA - 1.0d : dA : dA + 1.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean o(int i2, String str) {
        if (t(i2)) {
            b(str, i2, true);
            return true;
        }
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (q(str, i2)) {
            return f2488k.get().booleanValue();
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = str.charAt(i3);
            if (i3 < length - 1) {
                int i4 = i3 + 1;
                char cCharAt2 = str.charAt(i4);
                if (cCharAt == '\\') {
                    if (cCharAt2 != ' ' && cCharAt2 != '\\') {
                        switch (cCharAt2) {
                            case ',':
                            case '-':
                            case '.':
                                break;
                            default:
                                sb.append(cCharAt);
                                break;
                        }
                    }
                } else if (cCharAt == ';' && cCharAt2 == '@') {
                    i3 = i4;
                }
            }
            i3++;
        }
        String string = sb.toString();
        if (e.matcher(string).matches()) {
            b(str, i2, true);
            return true;
        }
        String strReplaceAll = b.matcher(a.matcher(f.matcher(string).replaceAll("")).replaceAll("")).replaceAll("");
        int iIndexOf = strReplaceAll.indexOf(59);
        if (iIndexOf > 0 && iIndexOf < strReplaceAll.length() - 1) {
            strReplaceAll = strReplaceAll.substring(0, iIndexOf);
        }
        if (!c.matcher(strReplaceAll).find()) {
            return false;
        }
        boolean zMatches = d.matcher(strReplaceAll).matches();
        b(str, i2, zMatches);
        return zMatches;
    }

    public static boolean p(a0 a0Var) {
        if (a0Var == null) {
            return false;
        }
        return o(a0Var.d(), a0Var.c());
    }

    private static boolean q(String str, int i2) {
        return f2485h && i2 == f2486i.get().intValue() && str.equals(f2487j.get());
    }

    public static boolean r(e eVar) {
        return s(eVar, null);
    }

    public static boolean s(e eVar, n.a.a.n.c.j jVar) {
        a0 a0VarA;
        if (eVar == null || !v(eVar.d()) || (a0VarA = a0.a(eVar, jVar)) == null) {
            return false;
        }
        return p(a0VarA);
    }

    public static boolean t(int i2) {
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                return true;
            default:
                switch (i2) {
                    case 45:
                    case 46:
                    case 47:
                        return true;
                    default:
                        return false;
                }
        }
    }

    private static boolean u(int i2, int i3) {
        return i2 == 1899 && i3 == 365;
    }

    public static boolean v(double d2) {
        return d2 > -4.9E-324d;
    }

    static /* synthetic */ Integer w() {
        return -1;
    }

    static /* synthetic */ void x() {
        f2486i.remove();
        f2487j.remove();
        f2488k.remove();
    }

    /* JADX WARN: Type inference failed for: r7v8, types: [java.time.ZonedDateTime] */
    public static Double y(String str) {
        TemporalAccessor temporalAccessor = g.parse(str.replaceAll("\\s+", " "));
        LocalTime localTime = (LocalTime) temporalAccessor.query(TemporalQueries.localTime());
        LocalDate localDate = (LocalDate) temporalAccessor.query(TemporalQueries.localDate());
        if (localTime == null && localDate == null) {
            return null;
        }
        double dF = localDate != null ? f(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())) : 0.0d;
        if (localTime != null) {
            dF += (localTime.toSecondOfDay() * 1.0d) / 86400.0d;
        }
        return Double.valueOf(dF);
    }

    public static void z(Calendar calendar, int i2, int i3, boolean z, boolean z2) {
        int i4;
        int i5 = 1900;
        if (z) {
            i5 = 1904;
            i4 = 1;
        } else {
            i4 = i2 < 61 ? 0 : -1;
        }
        calendar.set(i5, 0, i2 + i4, 0, 0, 0);
        calendar.set(14, i3);
        if (calendar.get(14) == 0) {
            calendar.clear(14);
        }
        if (z2) {
            calendar.add(14, 500);
            calendar.clear(14);
        }
    }
}
