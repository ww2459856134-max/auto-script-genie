package n.a.a.n.b;

import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class a0 {
    public static final a0 c;
    public static final a0 d;
    public static final a0 e;
    public static final a0 f;
    public static final a0 g;

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ a0[] f2334h;

    static {
        v vVar = new v("GENERAL", 0);
        c = vVar;
        final String str = "NUMBER";
        final int i2 = 1;
        a0 a0Var = new a0(str, i2) { // from class: n.a.a.n.b.w
            {
                v vVar2 = null;
            }

            @Override // n.a.a.n.b.a0
            b0 a(Locale locale, String str2) {
                return new g0(locale, str2);
            }

            @Override // n.a.a.n.b.a0
            boolean b(char c2) {
                return false;
            }
        };
        d = a0Var;
        final String str2 = "DATE";
        final int i3 = 2;
        a0 a0Var2 = new a0(str2, i3) { // from class: n.a.a.n.b.x
            {
                v vVar2 = null;
            }

            @Override // n.a.a.n.b.a0
            b0 a(Locale locale, String str3) {
                return new e(locale, str3);
            }

            @Override // n.a.a.n.b.a0
            boolean b(char c2) {
                return c2 == '\'' || (c2 <= 127 && Character.isLetter(c2));
            }
        };
        e = a0Var2;
        final String str3 = "ELAPSED";
        final int i4 = 3;
        a0 a0Var3 = new a0(str3, i4) { // from class: n.a.a.n.b.y
            {
                v vVar2 = null;
            }

            @Override // n.a.a.n.b.a0
            b0 a(Locale locale, String str4) {
                return new i(str4);
            }

            @Override // n.a.a.n.b.a0
            boolean b(char c2) {
                return false;
            }
        };
        f = a0Var3;
        final String str4 = "TEXT";
        final int i5 = 4;
        a0 a0Var4 = new a0(str4, i5) { // from class: n.a.a.n.b.z
            {
                v vVar2 = null;
            }

            @Override // n.a.a.n.b.a0
            b0 a(Locale locale, String str5) {
                return new j0(str5);
            }

            @Override // n.a.a.n.b.a0
            boolean b(char c2) {
                return false;
            }
        };
        g = a0Var4;
        f2334h = new a0[]{vVar, a0Var, a0Var2, a0Var3, a0Var4};
    }

    private a0(String str, int i2) {
    }

    public static a0 valueOf(String str) {
        return (a0) Enum.valueOf(a0.class, str);
    }

    public static a0[] values() {
        return (a0[]) f2334h.clone();
    }

    abstract b0 a(Locale locale, String str);

    abstract boolean b(char c2);

    /* synthetic */ a0(String str, int i2, v vVar) {
        this(str, i2);
    }
}
