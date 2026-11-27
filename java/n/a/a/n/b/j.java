package n.a.a.n.b;

import java.util.Locale;

/* loaded from: classes.dex */
final class j extends k {

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ Locale f2347k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    j(Locale locale, String str, Locale locale2) {
        super(locale, str, null);
        this.f2347k = locale2;
    }

    @Override // n.a.a.n.b.k
    public u a(Object obj) {
        return new u(true, new c0(this.f2347k).a(obj), null);
    }
}
