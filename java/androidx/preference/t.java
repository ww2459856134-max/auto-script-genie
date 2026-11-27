package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class t {
    private Context a;
    private SharedPreferences c;
    private k d;
    private SharedPreferences.Editor e;
    private boolean f;
    private String g;

    /* renamed from: h, reason: collision with root package name */
    private int f303h;

    /* renamed from: j, reason: collision with root package name */
    private PreferenceScreen f305j;

    /* renamed from: k, reason: collision with root package name */
    private u f306k;

    /* renamed from: l, reason: collision with root package name */
    private c f307l;

    /* renamed from: m, reason: collision with root package name */
    private a f308m;

    /* renamed from: n, reason: collision with root package name */
    private b f309n;
    private long b = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f304i = 0;

    public interface a {
        void c(Preference preference);
    }

    public interface b {
        void e(PreferenceScreen preferenceScreen);
    }

    public interface c {
        boolean d(Preference preference);
    }

    public t(Context context) {
        this.a = context;
        s(d(context));
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences(d(context), c());
    }

    private static int c() {
        return 0;
    }

    private static String d(Context context) {
        return context.getPackageName() + "_preferences";
    }

    private void n(boolean z) {
        SharedPreferences.Editor editor;
        if (!z && (editor = this.e) != null) {
            editor.apply();
        }
        this.f = z;
    }

    public Preference a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.f305j;
        if (preferenceScreen == null) {
            return null;
        }
        return preferenceScreen.A0(charSequence);
    }

    SharedPreferences.Editor e() {
        if (this.d != null) {
            return null;
        }
        if (!this.f) {
            return l().edit();
        }
        if (this.e == null) {
            this.e = l().edit();
        }
        return this.e;
    }

    long f() {
        long j2;
        synchronized (this) {
            j2 = this.b;
            this.b = 1 + j2;
        }
        return j2;
    }

    public b g() {
        return this.f309n;
    }

    public c h() {
        return this.f307l;
    }

    public u i() {
        return this.f306k;
    }

    public k j() {
        return this.d;
    }

    public PreferenceScreen k() {
        return this.f305j;
    }

    public SharedPreferences l() {
        if (j() != null) {
            return null;
        }
        if (this.c == null) {
            this.c = (this.f304i != 1 ? this.a : androidx.core.content.a.b(this.a)).getSharedPreferences(this.g, this.f303h);
        }
        return this.c;
    }

    public PreferenceScreen m(Context context, int i2, PreferenceScreen preferenceScreen) {
        n(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new s(context, this).d(i2, preferenceScreen);
        preferenceScreen2.L(this);
        n(false);
        return preferenceScreen2;
    }

    public void o(a aVar) {
        this.f308m = aVar;
    }

    public void p(b bVar) {
        this.f309n = bVar;
    }

    public void q(c cVar) {
        this.f307l = cVar;
    }

    public boolean r(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.f305j;
        if (preferenceScreen == preferenceScreen2) {
            return false;
        }
        if (preferenceScreen2 != null) {
            preferenceScreen2.Q();
        }
        this.f305j = preferenceScreen;
        return true;
    }

    public void s(String str) {
        this.g = str;
        this.c = null;
    }

    boolean t() {
        return !this.f;
    }

    public void u(Preference preference) {
        a aVar = this.f308m;
        if (aVar != null) {
            aVar.c(preference);
        }
    }
}
