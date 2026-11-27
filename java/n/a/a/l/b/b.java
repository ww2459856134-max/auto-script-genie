package n.a.a.l.b;

import org.apache.xmlbeans.xml.stream.XMLEvent;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'f' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class b {
    public static final b A;
    private static final /* synthetic */ b[] C;
    public static final b e;
    public static final b f;
    public static final b g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f2298h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f2299i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f2300j;

    /* renamed from: k, reason: collision with root package name */
    public static final b f2301k;
    public static final b t;
    public final String c;
    public final boolean d;

    static {
        b bVar = new b("rc4", 0, c.rc4, "RC4", 26625, 64, new int[]{40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128}, -1, 20, "RC4", false);
        e = bVar;
        c cVar = c.aes;
        b bVar2 = new b("aes128", 1, cVar, "AES", 26126, 128, new int[]{128}, 16, 32, "AES", false);
        f = bVar2;
        b bVar3 = new b("aes192", 2, cVar, "AES", 26127, 192, new int[]{192}, 16, 32, "AES", false);
        g = bVar3;
        b bVar4 = new b("aes256", 3, cVar, "AES", 26128, 256, new int[]{256}, 16, 32, "AES", false);
        f2298h = bVar4;
        b bVar5 = new b("rc2", 4, null, "RC2", -1, 128, new int[]{40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128}, 8, 20, "RC2", false);
        f2299i = bVar5;
        b bVar6 = new b("des", 5, null, "DES", -1, 64, new int[]{64}, 8, 32, "DES", false);
        f2300j = bVar6;
        b bVar7 = new b("des3", 6, null, "DESede", -1, 192, new int[]{192}, 8, 32, "3DES", false);
        f2301k = bVar7;
        b bVar8 = new b("des3_112", 7, null, "DESede", -1, 128, new int[]{128}, 8, 32, "3DES_112", true);
        t = bVar8;
        b bVar9 = new b("rsa", 8, null, "RSA", -1, 1024, new int[]{1024, 2048, 3072, XMLEvent.CHANGE_PREFIX_MAPPING}, -1, -1, "", false);
        A = bVar9;
        C = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9};
    }

    private b(String str, int i2, c cVar, String str2, int i3, int i4, int[] iArr, int i5, int i6, String str3, boolean z) {
        this.c = str2;
        this.d = z;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) C.clone();
    }
}
