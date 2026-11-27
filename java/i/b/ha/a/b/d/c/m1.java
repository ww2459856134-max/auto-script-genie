package i.b.ha.a.b.d.c;

import java.util.Arrays;
import java.util.zip.ZipException;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'd' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public class m1 implements b0 {
    public static final m1 d;
    public static final m1 e;
    public static final m1 f;
    public static final m1 g;

    /* renamed from: h, reason: collision with root package name */
    public static final m1 f1429h;

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ m1[] f1430i;
    private final c0 c;

    static {
        final c0 c0Var = c0.f;
        final String str = "BEST_EFFORT";
        final int i2 = 0;
        d = new m1(str, i2, c0Var) { // from class: i.b.ha.a.b.d.c.k1
            {
                i1 i1Var = null;
            }

            @Override // i.b.ha.a.b.d.c.m1, i.b.ha.a.b.d.c.b0
            public a2 b(a2 a2Var, byte[] bArr, int i3, int i4, boolean z) {
                return m1.f(a2Var, bArr, i3, i4, z);
            }
        };
        e = new m1("STRICT_FOR_KNOW_EXTRA_FIELDS", 1, c0Var);
        final c0 c0Var2 = c0.e;
        final String str2 = "ONLY_PARSEABLE_LENIENT";
        final int i3 = 2;
        f = new m1(str2, i3, c0Var2) { // from class: i.b.ha.a.b.d.c.l1
            {
                i1 i1Var = null;
            }

            @Override // i.b.ha.a.b.d.c.m1, i.b.ha.a.b.d.c.b0
            public a2 b(a2 a2Var, byte[] bArr, int i4, int i5, boolean z) {
                return m1.f(a2Var, bArr, i4, i5, z);
            }
        };
        g = new m1("ONLY_PARSEABLE_STRICT", 3, c0Var2);
        f1429h = new m1("DRACONIC", 4, c0.d);
        f1430i = d();
    }

    /* synthetic */ m1(String str, int i2, c0 c0Var, i1 i1Var) {
        this(str, i2, c0Var);
    }

    private static /* synthetic */ m1[] d() {
        return new m1[]{d, e, f, g, f1429h};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static a2 f(a2 a2Var, byte[] bArr, int i2, int i3, boolean z) {
        try {
            d0.c(a2Var, bArr, i2, i3, z);
            return a2Var;
        } catch (ZipException unused) {
            t0 t0Var = new t0();
            t0Var.i(a2Var.d());
            if (z) {
                t0Var.j(Arrays.copyOfRange(bArr, i2, i3 + i2));
            } else {
                t0Var.h(Arrays.copyOfRange(bArr, i2, i3 + i2));
            }
            return t0Var;
        }
    }

    public static m1 valueOf(String str) {
        return (m1) Enum.valueOf(m1.class, str);
    }

    public static m1[] values() {
        return (m1[]) f1430i.clone();
    }

    @Override // i.b.ha.a.b.d.c.r0
    public a2 a(byte[] bArr, int i2, int i3, boolean z, int i4) throws ZipException {
        return this.c.a(bArr, i2, i3, z, i4);
    }

    public a2 b(a2 a2Var, byte[] bArr, int i2, int i3, boolean z) throws ZipException {
        d0.c(a2Var, bArr, i2, i3, z);
        return a2Var;
    }

    @Override // i.b.ha.a.b.d.c.b0
    public a2 c(l2 l2Var) {
        return d0.a(l2Var);
    }

    private m1(String str, int i2, c0 c0Var) {
        this.c = c0Var;
    }
}
