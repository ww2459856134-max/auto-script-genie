package n.a.a.n.b;

import com.auto.exceldeps.log4j.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class k {

    /* renamed from: h, reason: collision with root package name */
    private static final Logger f2348h = n.a.a.i.b.a(k.class);

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f2349i = Pattern.compile(t.f2353j.pattern() + "(;|$)", 6);

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Locale, Map<String, k>> f2350j = new WeakHashMap();
    private final Locale a;
    private final String b;
    private final t c;
    private final t d;
    private final t e;
    private final t f;
    private final int g;

    /* synthetic */ k(Locale locale, String str, j jVar) {
        this(locale, str);
    }

    private static k b(Locale locale) {
        return new j(locale, "General", locale);
    }

    private t c(Object obj) {
        if (!(obj instanceof Number)) {
            throw new IllegalArgumentException("value must be a Number");
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        int i2 = this.g;
        return i2 == 1 ? (!this.c.l() || (this.c.l() && this.c.a(Double.valueOf(dDoubleValue)))) ? this.c : new t(this.a, "General") : i2 == 2 ? ((this.c.l() || dDoubleValue < 0.0d) && !(this.c.l() && this.c.a(Double.valueOf(dDoubleValue)))) ? (!this.e.l() || (this.e.l() && this.e.a(Double.valueOf(dDoubleValue)))) ? this.e : new t("\"###############################################################################################################################################################################################################################################################\"") : this.c : ((this.c.l() || dDoubleValue <= 0.0d) && !(this.c.l() && this.c.a(Double.valueOf(dDoubleValue)))) ? ((this.e.l() || dDoubleValue >= 0.0d) && !(this.e.l() && this.e.a(Double.valueOf(dDoubleValue)))) ? this.d : this.e : this.c;
    }

    public static synchronized k d(Locale locale, String str) {
        k kVarB;
        Map<String, k> mapComputeIfAbsent = f2350j.computeIfAbsent(locale, new Function() { // from class: n.a.a.n.b.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return k.e((Locale) obj);
            }
        });
        kVarB = mapComputeIfAbsent.get(str);
        if (kVarB == null) {
            kVarB = (str.equals("General") || str.equals("@")) ? b(locale) : new k(locale, str);
            mapComputeIfAbsent.put(str, kVarB);
        }
        return kVarB;
    }

    static /* synthetic */ Map e(Locale locale) {
        return new WeakHashMap();
    }

    public u a(Object obj) {
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            return (dDoubleValue >= 0.0d || ((this.g != 2 || this.c.l() || this.e.l()) && ((this.g != 3 || this.e.l()) && (this.g != 4 || this.e.l())))) ? c(Double.valueOf(dDoubleValue)).b(Double.valueOf(dDoubleValue)) : this.e.b(Double.valueOf(-dDoubleValue));
        }
        if (!(obj instanceof Date)) {
            return this.f.b(obj);
        }
        double dF = n.a.a.n.d.y.f((Date) obj);
        if (n.a.a.n.d.y.v(dF)) {
            return c(Double.valueOf(dF)).b(obj);
        }
        throw new IllegalArgumentException("value " + dF + " of date " + obj + " is not a valid Excel date");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            return this.b.equals(((k) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    private k(Locale locale, String str) {
        this.a = locale;
        this.b = str;
        t tVar = new t(locale, "@");
        Matcher matcher = f2349i.matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            try {
                try {
                    String strGroup = matcher.group();
                    arrayList.add(new t(locale, strGroup.endsWith(";") ? strGroup.substring(0, strGroup.length() - 1) : strGroup));
                } catch (RuntimeException e) {
                    f2348h.warn("Invalid format: {}", b0.c(matcher.group()), e);
                    arrayList.add(null);
                }
            } catch (StackOverflowError unused) {
                throw new IllegalStateException("The provided format is too complex: " + str + ", you can try to increase Java Stack size via commandline argument '-Xss' to allow handling this format");
            }
        }
        int size = arrayList.size();
        this.g = size;
        if (size == 1) {
            this.c = (t) arrayList.get(0);
            this.e = null;
            this.d = null;
            this.f = tVar;
            return;
        }
        if (size == 2) {
            this.c = (t) arrayList.get(0);
            this.e = (t) arrayList.get(1);
            this.d = null;
            this.f = tVar;
            return;
        }
        if (size != 3) {
            this.c = (t) arrayList.get(0);
            this.e = (t) arrayList.get(1);
            this.d = (t) arrayList.get(2);
            this.f = (t) arrayList.get(3);
            return;
        }
        this.c = (t) arrayList.get(0);
        this.e = (t) arrayList.get(1);
        this.d = (t) arrayList.get(2);
        this.f = tVar;
    }
}
