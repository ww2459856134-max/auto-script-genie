package n.a.a.n.b;

import java.text.AttributedCharacterIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import n.a.a.o.a1;
import n.a.a.o.j1;

/* loaded from: classes.dex */
public class e extends b0 {

    /* renamed from: h, reason: collision with root package name */
    private static final Calendar f2335h = a1.b(1904, 0, 1);

    /* renamed from: i, reason: collision with root package name */
    private static e f2336i;
    private boolean c;
    private boolean d;
    private boolean e;
    private final DateFormat f;
    private String g;

    public e(String str) {
        this(a1.e(), str);
    }

    @Override // n.a.a.n.b.b0
    public synchronized void b(StringBuffer stringBuffer, Object obj) {
        Object objValueOf = obj == null ? Double.valueOf(0.0d) : obj;
        if (objValueOf instanceof Number) {
            double dRound = Math.round(((Number) objValueOf).doubleValue() * 8.64E7d);
            if (dRound == 0.0d) {
                objValueOf = f2335h.getTime();
            } else {
                Calendar calendar = (Calendar) f2335h.clone();
                calendar.add(13, (int) (this.g == null ? Math.round(dRound / 1000.0d) : dRound / 1000.0d));
                calendar.add(14, (int) (dRound % 1000.0d));
                objValueOf = calendar.getTime();
            }
        }
        AttributedCharacterIterator toCharacterIterator = this.f.formatToCharacterIterator(objValueOf);
        boolean z = false;
        boolean z2 = false;
        for (char cFirst = toCharacterIterator.first(); cFirst != 65535; cFirst = toCharacterIterator.next()) {
            if (toCharacterIterator.getAttribute(DateFormat.Field.MILLISECOND) != null) {
                if (z) {
                    continue;
                } else {
                    Date date = (Date) objValueOf;
                    int length = stringBuffer.length();
                    Formatter formatter = new Formatter(stringBuffer, Locale.ROOT);
                    try {
                        long time = date.getTime() % 1000;
                        if (time < 0) {
                            time += 1000;
                        }
                        formatter.format(this.b, this.g, Double.valueOf(time / 1000.0d));
                        formatter.close();
                        stringBuffer.delete(length, length + 2);
                        z = true;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                formatter.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                throw th2;
                            }
                        }
                    }
                }
            } else if (toCharacterIterator.getAttribute(DateFormat.Field.AM_PM) == null) {
                stringBuffer.append(cFirst);
            } else if (!z2) {
                if (this.e) {
                    if (this.c) {
                        stringBuffer.append(j1.l(cFirst));
                        if (this.d) {
                            stringBuffer.append('M');
                        }
                    } else {
                        stringBuffer.append(j1.k(cFirst));
                        if (this.d) {
                            stringBuffer.append('m');
                        }
                    }
                }
                z2 = true;
            }
        }
    }

    @Override // n.a.a.n.b.b0
    public void e(StringBuffer stringBuffer, Object obj) {
        e eVar = f2336i;
        if (eVar == null) {
            synchronized (e.class) {
                eVar = f2336i;
                if (eVar == null) {
                    eVar = new e("mm/d/y");
                    f2336i = eVar;
                }
            }
        }
        eVar.b(stringBuffer, obj);
    }

    public e(Locale locale, String str) {
        super(str);
        d dVar = new d(this);
        StringBuffer stringBufferM = t.m(str, a0.e, dVar);
        dVar.b(stringBufferM);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(stringBufferM.toString(), locale);
        this.f = simpleDateFormat;
        simpleDateFormat.setTimeZone(a1.f());
    }
}
