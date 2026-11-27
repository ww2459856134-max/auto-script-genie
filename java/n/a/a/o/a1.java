package n.a.a.o;

import java.nio.charset.Charset;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public abstract class a1 {
    public static final TimeZone a = TimeZone.getTimeZone(ZoneOffset.UTC);
    public static final Charset b = Charset.forName("CP1252");
    private static final ThreadLocal<TimeZone> c = new ThreadLocal<>();
    private static final ThreadLocal<Locale> d = new ThreadLocal<>();

    static {
        m1.a(new Runnable() { // from class: n.a.a.o.r
            @Override // java.lang.Runnable
            public final void run() {
                a1.g();
            }
        });
    }

    public static Calendar a() {
        return d(f());
    }

    public static Calendar b(int i2, int i3, int i4) {
        return c(i2, i3, i4, 0, 0, 0);
    }

    public static Calendar c(int i2, int i3, int i4, int i5, int i6, int i7) {
        Calendar calendarA = a();
        calendarA.set(i2, i3, i4, i5, i6, i7);
        calendarA.clear(14);
        return calendarA;
    }

    public static Calendar d(TimeZone timeZone) {
        return Calendar.getInstance(timeZone, e());
    }

    public static Locale e() {
        Locale locale = d.get();
        return locale != null ? locale : Locale.getDefault();
    }

    public static TimeZone f() {
        TimeZone timeZone = c.get();
        return timeZone != null ? timeZone : TimeZone.getDefault();
    }

    static /* synthetic */ void g() {
        c.remove();
        d.remove();
    }
}
