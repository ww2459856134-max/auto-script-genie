package i.e.a.f;

import i.e.a.j.s;
import i.e.a.j.t;
import i.e.a.j.u;
import i.e.a.j.v;

/* loaded from: classes.dex */
public abstract class e {
    private static final int a;
    private static final int b;
    private static final int c;
    private static final int d;
    private static final int e;
    private static final int f;
    private static final int g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f1551h;

    /* renamed from: i, reason: collision with root package name */
    private static final s f1552i;

    /* renamed from: j, reason: collision with root package name */
    private static final t f1553j;

    /* renamed from: k, reason: collision with root package name */
    private static final u f1554k;

    /* renamed from: l, reason: collision with root package name */
    private static final t f1555l;

    static {
        int i2 = a("xml")[0];
        a = i2;
        int[] iArrA = a("version");
        int i3 = iArrA[0];
        b = i3;
        int i4 = iArrA[1];
        c = i4;
        int[] iArrA2 = a("standalone");
        int i5 = iArrA2[0];
        d = i5;
        int i6 = iArrA2[1];
        e = i6;
        int i7 = iArrA2[2];
        f = i7;
        int[] iArrA3 = a("encoding");
        int i8 = iArrA3[0];
        g = i8;
        int i9 = iArrA3[1];
        f1551h = i9;
        f1552i = new s("xml", null, "xml", 0, i2);
        f1553j = new t("version", null, "version", 0, i3, i4);
        f1554k = new u("standalone", null, "standalone", 0, i5, i6, i7);
        f1555l = new t("encoding", null, "encoding", 0, i8, i9);
    }

    static int[] a(String str) {
        int length = str.length();
        int[] iArr = new int[(length + 3) / 4];
        int i2 = 0;
        while (i2 < length) {
            int iCharAt = str.charAt(i2);
            int i3 = i2 + 1;
            if (i3 < length) {
                iCharAt = (iCharAt << 8) | str.charAt(i3);
                i3++;
                if (i3 < length) {
                    iCharAt = (iCharAt << 8) | str.charAt(i3);
                    i3++;
                    if (i3 < length) {
                        iCharAt = (iCharAt << 8) | str.charAt(i3);
                    }
                }
            }
            iArr[i3 / 4] = iCharAt;
            i2 = i3 + 1;
        }
        return iArr;
    }

    public static v b(int i2) {
        if (i2 == a) {
            return f1552i;
        }
        return null;
    }

    public static v c(int i2, int i3) {
        if (i2 == b) {
            if (i3 == c) {
                return f1553j;
            }
            return null;
        }
        if (i2 == g && i3 == f1551h) {
            return f1555l;
        }
        return null;
    }

    public static v d(int i2, int i3, int i4) {
        if (i2 == d && i3 == e && i4 == f) {
            return f1554k;
        }
        return null;
    }
}
