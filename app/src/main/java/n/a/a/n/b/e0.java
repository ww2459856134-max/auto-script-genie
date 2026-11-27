package n.a.a.n.b;

import java.util.Locale;

/* loaded from: classes.dex */
class e0 extends b0 {
    @Override // n.a.a.n.b.b0
    public void b(StringBuffer stringBuffer, Object obj) {
        if (obj == null) {
            return;
        }
        (obj instanceof Number ? ((Number) obj).doubleValue() % 1.0d == 0.0d ? new g0(this.b, "#") : new g0(this.b, "#.#") : j0.e).b(stringBuffer, obj);
    }

    @Override // n.a.a.n.b.b0
    public void e(StringBuffer stringBuffer, Object obj) {
        b(stringBuffer, obj);
    }

    private e0(Locale locale) {
        super(locale, "General");
    }
}
