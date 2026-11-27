package k.x.j1;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import java.io.Reader;

/* loaded from: classes.dex */
class o1 {
    private static final char[] p = m("\b\u0000\u0003\u0015\u0015\u0000\u0001\u0015\u0001\u0014\u0001\u0011\u0001\u0016\u0001\b\u0002\u0000\u0001\u0012\u0001\u0005\u0001\u0006\u0001!\u0001\u001f\u0001\u0004\u0001 \u0001\u0007\u0001\u001b\u0001\u001c\t\u0002\u0001\u0003\u0001\u0000\u0001$\u0001#\u0001\"\u0001\u001e\u0001\u0000\u0001\u000e\u0002\u0001\u0001\u0018\u0001\f\u0001\r\u0002\u0001\u0001\u0019\u0002\u0001\u0001\u000f\u0001\u001d\u0001\u0017\u0003\u0001\u0001\n\u0001\u0010\u0001\t\u0001\u000b\u0001\u001a\u0004\u0001\u0004\u0000\u0001\u0013\u0001\u0000\u001a\u0001ﾅ\u0000");
    private static final int[] q = j();
    private static final int[] r = o();
    private static final int[] s = q();
    private static final String[] t = {"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
    private static final int[] u = l();
    private Reader a;
    private int b;
    private int c = 0;
    private char[] d = new char[16384];
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2139h;

    /* renamed from: i, reason: collision with root package name */
    private int f2140i;

    /* renamed from: j, reason: collision with root package name */
    private int f2141j;

    /* renamed from: k, reason: collision with root package name */
    private int f2142k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2143l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f2144m;

    /* renamed from: n, reason: collision with root package name */
    private t f2145n;

    /* renamed from: o, reason: collision with root package name */
    private k.x.a1 f2146o;

    o1(Reader reader) {
        this.a = reader;
    }

    private boolean g() throws IOException {
        int i2 = this.f2139h;
        if (i2 > 0) {
            char[] cArr = this.d;
            System.arraycopy(cArr, i2, cArr, 0, this.f2140i - i2);
            int i3 = this.f2140i;
            int i4 = this.f2139h;
            this.f2140i = i3 - i4;
            this.g -= i4;
            this.e -= i4;
            this.f -= i4;
            this.f2139h = 0;
        }
        int i5 = this.g;
        char[] cArr2 = this.d;
        if (i5 >= cArr2.length) {
            char[] cArr3 = new char[i5 * 2];
            System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
            this.d = cArr3;
        }
        Reader reader = this.a;
        char[] cArr4 = this.d;
        int i6 = this.f2140i;
        int i7 = reader.read(cArr4, i6, cArr4.length - i6);
        if (i7 < 0) {
            return true;
        }
        this.f2140i += i7;
        return false;
    }

    private void h(int i2) {
        String str;
        try {
            str = t[i2];
        } catch (ArrayIndexOutOfBoundsException unused) {
            str = t[0];
        }
        throw new Error(str);
    }

    private static int i(String str, int i2, int[] iArr) {
        int i3;
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            int iCharAt = str.charAt(i4);
            int i6 = i5 + 1;
            char cCharAt = str.charAt(i5);
            while (true) {
                i3 = i2 + 1;
                iArr[i2] = cCharAt;
                iCharAt--;
                if (iCharAt <= 0) {
                    break;
                }
                i2 = i3;
            }
            i4 = i6;
            i2 = i3;
        }
        return i2;
    }

    private static int[] j() {
        int[] iArr = new int[94];
        i("\u0001\u0000\u0001\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\u0000\u0002\u0002\u0001\b\u0001\u0000\u0001\t\u0001\u0000\u0001\n\u0001\u000b\u0001\f\u0001\r\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0001\u0001\u0011\u0001\u0002\u0001\u0012\u0001\u0000\u0001\u0013\u0001\u0000\u0001\u0002\u0003\u0000\u0002\u0002\u0005\u0000\u0001\u0014\u0001\u0015\u0001\u0016\u0001\u0002\u0001\u0000\u0001\u0017\u0001\u0000\u0001\u0012\u0002\u0000\u0001\u0018\u0001\u0000\u0002\u0002\b\u0000\u0001\u0017\u0001\u0000\u0001\u0019\u0001\u0000\u0001\u001a\b\u0000\u0001\u001b\u0002\u0000\u0001\u0019\u0002\u0000\u0001\u001c\u0004\u0000\u0001\u001d\u0003\u0000\u0001\u001d\u0001\u0000\u0001\u001e\u0001\u0000", 0, iArr);
        return iArr;
    }

    private static int k(String str, int i2, int[] iArr) {
        int i3;
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            int iCharAt = str.charAt(i4);
            int i6 = i5 + 1;
            char cCharAt = str.charAt(i5);
            while (true) {
                i3 = i2 + 1;
                iArr[i2] = cCharAt;
                iCharAt--;
                if (iCharAt <= 0) {
                    break;
                }
                i2 = i3;
            }
            i4 = i6;
            i2 = i3;
        }
        return i2;
    }

    private static int[] l() {
        int[] iArr = new int[94];
        k("\u0001\u0000\u0003\u0001\u0004\t\u0001\u0000\u0002\u0001\u0001\t\u0001\u0000\u0001\t\u0001\u0000\u0004\t\u0001\u0001\u0001\t\u0002\u0001\u0001\t\u0002\u0001\u0001\u0000\u0001\t\u0001\u0000\u0001\u0001\u0003\u0000\u0002\u0001\u0005\u0000\u0003\t\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0002\u0000\u0001\u0001\u0001\u0000\u0002\u0001\b\u0000\u0001\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\b\u0000\u0001\u0001\u0002\u0000\u0001\u0001\u0002\u0000\u0001\t\u0004\u0000\u0001\u0001\u0003\u0000\u0001\t\u0001\u0000\u0001\u0001\u0001\u0000", 0, iArr);
        return iArr;
    }

    private static char[] m(String str) {
        int i2;
        char[] cArr = new char[WXMediaMessage.THUMB_LENGTH_LIMIT];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 100) {
            int i5 = i3 + 1;
            int iCharAt = str.charAt(i3);
            int i6 = i5 + 1;
            char cCharAt = str.charAt(i5);
            while (true) {
                i2 = i4 + 1;
                cArr[i4] = cCharAt;
                iCharAt--;
                if (iCharAt <= 0) {
                    break;
                }
                i4 = i2;
            }
            i3 = i6;
            i4 = i2;
        }
        return cArr;
    }

    private static int n(String str, int i2, int[] iArr) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            iArr[i2] = (str.charAt(i3) << 16) | str.charAt(i4);
            i2++;
            i3 = i4 + 1;
        }
        return i2;
    }

    private static int[] o() {
        int[] iArr = new int[94];
        n("\u0000\u0000\u0000%\u0000J\u0000o\u0000\u0094\u0000\u0094\u0000\u0094\u0000\u0094\u0000¹\u0000Þ\u0000ă\u0000\u0094\u0000Ĩ\u0000\u0094\u0000ō\u0000\u0094\u0000\u0094\u0000\u0094\u0000\u0094\u0000Ų\u0000\u0094\u0000Ɨ\u0000Ƽ\u0000\u0094\u0000ǡ\u0000Ȇ\u0000ȫ\u0000\u0094\u0000ɐ\u0000ɵ\u0000ʚ\u0000ʿ\u0000ˤ\u0000̉\u0000̮\u0000͓\u0000\u0378\u0000Ν\u0000ς\u0000ϧ\u0000\u0094\u0000\u0094\u0000\u0094\u0000Ќ\u0000б\u0000і\u0000ѻ\u0000Ҡ\u0000Ӆ\u0000Ӫ\u0000ʿ\u0000ԏ\u0000Դ\u0000ՙ\u0000վ\u0000֣\u0000\u05c8\u0000\u05ed\u0000ؒ\u0000ط\u0000ٜ\u0000ځ\u0000\u0094\u0000ڦ\u0000ۋ\u0000ۋ\u0000Ќ\u0000۰\u0000ܕ\u0000ܺ\u0000ݟ\u0000ބ\u0000ީ\u0000ߎ\u0000߳\u0000࠘\u0000࠘\u0000࠽\u0000ࡢ\u0000ࢇ\u0000ࢬ\u0000\u0094\u0000࣑\u0000ࣶ\u0000छ\u0000ी\u0000॥\u0000ঊ\u0000য\u0000\u09d4\u0000\u0094\u0000৹\u0000ਞ\u0000ਞ", 0, iArr);
        return iArr;
    }

    private static int p(String str, int i2, int[] iArr) {
        int i3;
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            int iCharAt = str.charAt(i4);
            int i6 = i5 + 1;
            int iCharAt2 = str.charAt(i5) - 1;
            while (true) {
                i3 = i2 + 1;
                iArr[i2] = iCharAt2;
                iCharAt--;
                if (iCharAt <= 0) {
                    break;
                }
                i2 = i3;
            }
            i4 = i6;
            i2 = i3;
        }
        return i2;
    }

    private static int[] q() {
        int[] iArr = new int[2627];
        p("\u0001\u0000\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\u0000\u0001\t\u0001\n\u0003\u0003\u0001\u000b\u0003\u0003\u0001\f\u0001\r\u0002\u0000\u0001\u000e\u0001\u000f\u0004\u0003\u0001\u0010\u0001\u0004\u0001\u0003\u0001\u0000\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0015\u0001\u0016\u0011\u0017\u0001\u0018\u0013\u0017\u0001\u0000\u0001\u0019\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c\u0002\u0000\u0001\u001d\b\u0019\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004\u0019\u0001\u0000\u0001\u001a\u0001\u0019\t\u0000\u0001\u0004\u0004\u0000\u0001 \u0014\u0000\u0001\u0004.\u0000\u0001!\u0007\u0000\b!\u0006\u0000\u0004!\u0002\u0000\u0001!\b\u0000\u0001\u0019\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c\u0002\u0000\u0001\u001d\u0001\u0019\u0001\"\u0006\u0019\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004\u0019\u0001\u0000\u0001\u001a\u0001\u0019\b\u0000\u0001\u0019\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c\u0002\u0000\u0001\u001d\u0005\u0019\u0001#\u0002\u0019\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004\u0019\u0001\u0000\u0001\u001a\u0001\u0019\u0007\u0000\u0012\r\u0001$\u0012\r\n\u0000\u0001%\f\u0000\u0001&\u0001'\u0001\u0000\u0001(-\u0000\u0001)#\u0000\u0001*\u0001+\u0001\u0000\u0011\u0017\u0001\u0000\u0013\u0017\u0001\u0000\u0001,\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c\u0002\u0000\u0001\u001d\b,\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004,\u0001\u0000\u0001\u001a\u0001,\b\u0000\u0001\u001e\u0001\u001a\u0001-\u0005\u0000\b\u001e\u0002\u0000\u0001\u001e\u0003\u0000\u0004\u001e\u0001\u0000\u0001\u001a\u0001\u001e\b\u0000\u0001.\u0006\u0000\u0001/\b.\u0006\u0000\u0004.\u0002\u0000\u0001.\t\u0000\u00010\u0019\u0000\u00010\t\u0000\u0002\u001e\u0006\u0000\b\u001e\u0002\u0000\u0001\u001e\u0003\u0000\u0004\u001e\u0001\u0000\u0002\u001e\b\u0000\u00011\u0006\u0000\u00012\b1\u0006\u0000\u00041\u0002\u0000\u00011\t\u0000\u00013\u0019\u0000\u00013\t\u0000\u00014\u00010\u0001\u001b\u0004\u0000\u0001\u001d\b4\u0006\u0000\u00044\u0001\u0000\u00010\u00014\b\u0000\u0001,\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c\u0002\u0000\u0001\u001d\u0002,\u00015\u0005,\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004,\u0001\u0000\u0001\u001a\u0001,\b\u0000\u0001,\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c\u0002\u0000\u0001\u001d\u0006,\u00016\u0001,\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004,\u0001\u0000\u0001\u001a\u0001,\u001b\u0000\u00017\u001c\u0000\u00018#\u0000\u00019\u0002\u0000\u0001:/\u0000\u0001;\u0019\u0000\u0001<\u0017\u0000\u0001,\u0001\u001e\u0002\u0000\u0001\u001c\u0003\u0000\b,\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004,\u0001\u0000\u0001\u001e\u0001,\b\u0000\u0001=\u0006\u0000\u0001>\b=\u0006\u0000\u0004=\u0002\u0000\u0001=\b\u0000\u0001?\u0007\u0000\b?\u0006\u0000\u0004?\u0002\u0000\u0001?\b\u0000\u0001.\u0007\u0000\b.\u0006\u0000\u0004.\u0002\u0000\u0001.\t\u0000\u00010\u0001-\u0018\u0000\u00010\t\u0000\u0001@\u0001A\u0005\u0000\u0001B\b@\u0006\u0000\u0004@\u0001\u0000\u0001A\u0001@\b\u0000\u00011\u0007\u0000\b1\u0006\u0000\u00041\u0002\u0000\u00011\t\u0000\u00010\u0001\u001b\u0004\u0000\u0001\u001d\u0013\u0000\u00010\t\u0000\u0001,\u0001\u001e\u0002\u0000\u0001\u001c\u0003\u0000\u0003,\u0001C\u0004,\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004,\u0001\u0000\u0001\u001e\u0001,\b\u0000\u0001,\u0001\u001e\u0002\u0000\u0001\u001c\u0003\u0000\u0007,\u00015\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004,\u0001\u0000\u0001\u001e\u0001,\b\u0000\u0001D\u0006\u0000\u0001E\bD\u0006\u0000\u0004D\u0002\u0000\u0001D\u0014\u0000\u0001F&\u0000\u0001G\r\u0000\u0001F$\u0000\u0001H!\u0000\u0001I\u0019\u0000\u0001J\u0016\u0000\u0001K\u0001L\u0005\u0000\u0001M\bK\u0006\u0000\u0004K\u0001\u0000\u0001L\u0001K\b\u0000\u0001=\u0007\u0000\b=\u0006\u0000\u0004=\u0002\u0000\u0001=\t\u0000\u0001A\u0005\u0000\u0001B\u0013\u0000\u0001A\n\u0000\u0001A\u0019\u0000\u0001A\t\u0000\u0001N\u0001O\u0001P\u0004\u0000\u0001Q\bN\u0006\u0000\u0004N\u0001\u0000\u0001O\u0001N\b\u0000\u0001D\u0007\u0000\bD\u0006\u0000\u0004D\u0002\u0000\u0001D\u001b\u0000\u0001R\u001f\u0000\u0001F!\u0000\u0001S3\u0000\u0001T\u0014\u0000\u0001U\u001b\u0000\u0001L\u0005\u0000\u0001M\u0013\u0000\u0001L\n\u0000\u0001L\u0019\u0000\u0001L\n\u0000\u0001O\u0001P\u0004\u0000\u0001Q\u0013\u0000\u0001O\n\u0000\u0001O\u0001V\u0018\u0000\u0001O\t\u0000\u0001W\u0006\u0000\u0001X\bW\u0006\u0000\u0004W\u0002\u0000\u0001W\t\u0000\u0001O\u0019\u0000\u0001O&\u0000\u0001R\"\u0000\u0001F\u0014\u0000\u0001F\u0019\u0000\u0001Y\u0006\u0000\u0001Z\bY\u0006\u0000\u0004Y\u0002\u0000\u0001Y\b\u0000\u0001[\u0007\u0000\b[\u0006\u0000\u0004[\u0002\u0000\u0001[\b\u0000\u0001W\u0007\u0000\bW\u0006\u0000\u0004W\u0002\u0000\u0001W\b\u0000\u0001\\\u0001]\u0005\u0000\u0001^\b\\\u0006\u0000\u0004\\\u0001\u0000\u0001]\u0001\\\b\u0000\u0001Y\u0007\u0000\bY\u0006\u0000\u0004Y\u0002\u0000\u0001Y\t\u0000\u0001]\u0005\u0000\u0001^\u0013\u0000\u0001]\n\u0000\u0001]\u0019\u0000\u0001]\b\u0000", 0, iArr);
        return iArr;
    }

    int a() {
        return this.f2142k;
    }

    void b(t tVar) {
        this.f2145n = tVar;
    }

    void c(k.x.a1 a1Var) {
        this.f2146o = a1Var;
    }

    public final void d(int i2) {
        this.c = i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public t0 e() throws w, IOException {
        char c;
        int i2;
        boolean z;
        int i3 = this.f2140i;
        char[] cArr = this.d;
        char[] cArr2 = p;
        int[] iArr = s;
        int[] iArr2 = r;
        int[] iArr3 = u;
        while (true) {
            int i4 = this.e;
            int i5 = this.f2142k;
            int i6 = this.f2139h;
            this.f2142k = i5 + (i4 - i6);
            boolean z2 = false;
            while (i6 < i4) {
                char c2 = cArr[i6];
                if (c2 != 133 && c2 != 8232 && c2 != 8233) {
                    switch (c2) {
                        case '\n':
                            if (!z2) {
                                this.f2141j++;
                                break;
                            } else {
                                z2 = false;
                                break;
                            }
                        case '\r':
                            this.f2141j++;
                            z2 = true;
                            break;
                    }
                } else {
                    this.f2141j++;
                    z2 = false;
                }
                i6++;
            }
            if (z2) {
                if (i4 < i3) {
                    z = cArr[i4] == '\n';
                    if (z) {
                        this.f2141j--;
                    }
                } else {
                    if (!this.f2143l) {
                        boolean zG = g();
                        int i7 = this.f2140i;
                        i4 = this.e;
                        char[] cArr3 = this.d;
                        if (zG) {
                            i3 = i7;
                            z = false;
                        } else {
                            z = cArr3[i4] == '\n';
                            i3 = i7;
                        }
                        cArr = cArr3;
                    }
                    if (z) {
                    }
                }
            }
            this.f2139h = i4;
            this.g = i4;
            this.b = this.c;
            char c3 = 65535;
            int i8 = i4;
            int i9 = -1;
            while (true) {
                if (i4 < i3) {
                    i2 = i4 + 1;
                    c = cArr[i4];
                } else if (this.f2143l) {
                    c = c3;
                } else {
                    this.g = i4;
                    this.e = i8;
                    boolean zG2 = g();
                    int i10 = this.g;
                    i8 = this.e;
                    char[] cArr4 = this.d;
                    int i11 = this.f2140i;
                    if (zG2) {
                        cArr = cArr4;
                        c = c3;
                        i3 = i11;
                    } else {
                        i2 = i10 + 1;
                        i3 = i11;
                        c = cArr4[i10];
                        cArr = cArr4;
                    }
                }
                int i12 = iArr[iArr2[this.b] + cArr2[c]];
                if (i12 != c3) {
                    this.b = i12;
                    int i13 = iArr3[i12];
                    if ((i13 & 1) != 1) {
                        c3 = 65535;
                    } else if ((i13 & 8) == 8) {
                        i8 = i2;
                        i9 = i12;
                    } else {
                        c3 = 65535;
                        i8 = i2;
                        i9 = i12;
                    }
                    i4 = i2;
                }
            }
            this.e = i8;
            if (i9 >= 0) {
                i9 = q[i9];
            }
            switch (i9) {
                case 1:
                    this.f2144m = false;
                    return new f1(f());
                case 2:
                    return new l0(f(), this.f2146o);
                case 3:
                    return new c0(f());
                case 4:
                    return new y0();
                case 5:
                    return new d();
                case 6:
                    return new o0();
                case 7:
                    return new l();
                case 8:
                    this.f2144m = true;
                    d(1);
                    break;
                case 9:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                    break;
                case 10:
                    return new p();
                case 11:
                    return new w0();
                case 12:
                    return new h0();
                case 13:
                    return new j0();
                case 14:
                    return new b0();
                case 15:
                    return new r();
                case 16:
                    return new e0();
                case 17:
                    d(0);
                    if (!this.f2144m) {
                        break;
                    } else {
                        return new f1("");
                    }
                case 18:
                    return new j(f());
                case 19:
                    return new c1(f());
                case 20:
                    return new a0();
                case 21:
                    return new m0();
                case 22:
                    return new d0();
                case 23:
                    return new n(f());
                case 24:
                    return new q(f());
                case 25:
                    return new i(f(), this.f2145n);
                case 26:
                    return new g(f());
                case 27:
                    return new c(f());
                case 28:
                    return new s(f());
                case 29:
                    return new m(f(), this.f2145n);
                case 30:
                    return new b(f(), this.f2145n);
                default:
                    if (c == 65535 && this.f2139h == this.g) {
                        this.f2143l = true;
                        return null;
                    }
                    h(1);
                    throw null;
            }
        }
    }

    public final String f() {
        char[] cArr = this.d;
        int i2 = this.f2139h;
        return new String(cArr, i2, this.e - i2);
    }
}
