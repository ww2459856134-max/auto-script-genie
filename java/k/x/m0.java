package k.x;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import k.a0.a.f2;

/* loaded from: classes.dex */
public class m0 extends c1 implements b0 {

    /* renamed from: j, reason: collision with root package name */
    private static String[] f2157j;

    /* renamed from: k, reason: collision with root package name */
    public static final l0 f2158k;

    /* renamed from: l, reason: collision with root package name */
    public static final l0 f2159l;
    private boolean c;
    private byte[] d;
    private int e;
    private String f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2160h;

    /* renamed from: i, reason: collision with root package name */
    private Format f2161i;

    static {
        k.y.c.b(m0.class);
        f2157j = new String[]{"dd", "mm", "yy", "hh", "ss", "m/", "/d"};
        f2158k = new l0();
        f2159l = new l0();
    }

    protected m0() {
        super(z0.H);
        this.c = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DateFormat A() {
        int i2;
        int iMin;
        int iMin2;
        char c;
        int iIndexOf;
        Format format = this.f2161i;
        if (format != null && (format instanceof DateFormat)) {
            return (DateFormat) format;
        }
        String string = this.f;
        int iIndexOf2 = string.indexOf("AM/PM");
        while (true) {
            if (iIndexOf2 == -1) {
                break;
            }
            StringBuffer stringBuffer = new StringBuffer(string.substring(0, iIndexOf2));
            stringBuffer.append('a');
            stringBuffer.append(string.substring(iIndexOf2 + 5));
            string = stringBuffer.toString();
            iIndexOf2 = string.indexOf("AM/PM");
        }
        int iIndexOf3 = string.indexOf("ss.0");
        while (iIndexOf3 != -1) {
            StringBuffer stringBuffer2 = new StringBuffer(string.substring(0, iIndexOf3));
            stringBuffer2.append("ss.SSS");
            int i3 = iIndexOf3 + 4;
            while (i3 < string.length() && string.charAt(i3) == '0') {
                i3++;
            }
            stringBuffer2.append(string.substring(i3));
            string = stringBuffer2.toString();
            iIndexOf3 = string.indexOf("ss.0");
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i4 = 0; i4 < string.length(); i4++) {
            if (string.charAt(i4) != '\\') {
                stringBuffer3.append(string.charAt(i4));
            }
        }
        String string2 = stringBuffer3.toString();
        if (string2.charAt(0) == '[' && (iIndexOf = string2.indexOf(93)) != -1) {
            string2 = string2.substring(iIndexOf + 1);
        }
        char[] charArray = E(string2, ";@", "").toCharArray();
        for (i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] == 'm') {
                if (i2 > 0) {
                    int i5 = i2 - 1;
                    if (charArray[i5] == 'm' || charArray[i5] == 'M') {
                        charArray[i2] = charArray[i5];
                    } else {
                        int i6 = i2 - 1;
                        int i7 = i6;
                        while (true) {
                            if (i7 <= 0) {
                                iMin = Integer.MAX_VALUE;
                                break;
                            }
                            if (charArray[i7] == 'h') {
                                iMin = i2 - i7;
                                break;
                            }
                            i7--;
                        }
                        int i8 = i2 + 1;
                        int i9 = i8;
                        while (true) {
                            if (i9 >= charArray.length) {
                                break;
                            }
                            if (charArray[i9] == 'h') {
                                iMin = Math.min(iMin, i9 - i2);
                                break;
                            }
                            i9++;
                        }
                        int i10 = i6;
                        while (true) {
                            if (i10 <= 0) {
                                break;
                            }
                            if (charArray[i10] == 'H') {
                                iMin = i2 - i10;
                                break;
                            }
                            i10--;
                        }
                        int i11 = i8;
                        while (true) {
                            if (i11 >= charArray.length) {
                                break;
                            }
                            if (charArray[i11] == 'H') {
                                iMin = Math.min(iMin, i11 - i2);
                                break;
                            }
                            i11++;
                        }
                        int i12 = i6;
                        while (true) {
                            if (i12 <= 0) {
                                break;
                            }
                            if (charArray[i12] == 's') {
                                iMin = Math.min(iMin, i2 - i12);
                                break;
                            }
                            i12--;
                        }
                        int i13 = i8;
                        while (true) {
                            if (i13 >= charArray.length) {
                                break;
                            }
                            if (charArray[i13] == 's') {
                                iMin = Math.min(iMin, i13 - i2);
                                break;
                            }
                            i13++;
                        }
                        int i14 = i6;
                        while (true) {
                            if (i14 <= 0) {
                                iMin2 = Integer.MAX_VALUE;
                                break;
                            }
                            if (charArray[i14] == 'd') {
                                iMin2 = i2 - i14;
                                break;
                            }
                            i14--;
                        }
                        int i15 = i8;
                        while (true) {
                            if (i15 >= charArray.length) {
                                break;
                            }
                            if (charArray[i15] == 'd') {
                                iMin2 = Math.min(iMin2, i15 - i2);
                                break;
                            }
                            i15++;
                        }
                        while (true) {
                            if (i6 <= 0) {
                                break;
                            }
                            if (charArray[i6] == 'y') {
                                iMin2 = Math.min(iMin2, i2 - i6);
                                break;
                            }
                            i6--;
                        }
                        while (true) {
                            if (i8 >= charArray.length) {
                                break;
                            }
                            if (charArray[i8] == 'y') {
                                iMin2 = Math.min(iMin2, i8 - i2);
                                break;
                            }
                            i8++;
                        }
                        if (iMin2 < iMin) {
                            charArray[i2] = Character.toUpperCase(charArray[i2]);
                        } else if (iMin2 == iMin && iMin2 != Integer.MAX_VALUE && ((c = charArray[i2 - iMin2]) == 'y' || c == 'd')) {
                            charArray[i2] = Character.toUpperCase(charArray[i2]);
                        }
                    }
                }
            }
        }
        try {
            this.f2161i = new SimpleDateFormat(new String(charArray));
        } catch (IllegalArgumentException unused) {
            this.f2161i = new SimpleDateFormat("dd MM yyyy hh:mm:ss");
        }
        return (DateFormat) this.f2161i;
    }

    public final NumberFormat B() {
        Format format = this.f2161i;
        if (format != null && (format instanceof NumberFormat)) {
            return (NumberFormat) format;
        }
        try {
            this.f2161i = new DecimalFormat(E(E(E(E(E(this.f, "E+", "E"), "_)", ""), "_", ""), "[Red]", ""), "\\", ""));
        } catch (IllegalArgumentException unused) {
            this.f2161i = new DecimalFormat("#.###");
        }
        return (NumberFormat) this.f2161i;
    }

    public final boolean C() {
        return this.g;
    }

    public final boolean D() {
        return this.f2160h;
    }

    protected final String E(String str, String str2, String str3) {
        int iIndexOf = str.indexOf(str2);
        while (iIndexOf != -1) {
            StringBuffer stringBuffer = new StringBuffer(str.substring(0, iIndexOf));
            stringBuffer.append(str3);
            stringBuffer.append(str.substring(iIndexOf + str2.length()));
            str = stringBuffer.toString();
            iIndexOf = str.indexOf(str2);
        }
        return str;
    }

    protected final void F(String str) {
        this.f = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        if (!this.c || !m0Var.c) {
            return this.f.equals(m0Var.f);
        }
        if (this.g == m0Var.g && this.f2160h == m0Var.f2160h) {
            return this.f.equals(m0Var.f);
        }
        return false;
    }

    @Override // k.x.b0
    public void f(int i2) {
        this.e = i2;
        this.c = true;
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    @Override // k.x.b0
    public boolean isInitialized() {
        return this.c;
    }

    @Override // k.x.b0
    public int m() {
        return this.e;
    }

    @Override // k.x.b0
    public boolean r() {
        return false;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[(this.f.length() * 2) + 3 + 2];
        this.d = bArr;
        s0.f(this.e, bArr, 0);
        s0.f(this.f.length(), this.d, 2);
        byte[] bArr2 = this.d;
        bArr2[4] = 1;
        y0.e(this.f, bArr2, 5);
        return this.d;
    }

    public m0(f2 f2Var, k.w wVar, l0 l0Var) {
        super(f2Var);
        byte[] bArrC = x().c();
        int i2 = 0;
        this.e = s0.c(bArrC[0], bArrC[1]);
        this.c = true;
        if (l0Var == f2158k) {
            int iC = s0.c(bArrC[2], bArrC[3]);
            if (bArrC[4] == 0) {
                this.f = y0.d(bArrC, iC, 5, wVar);
            } else {
                this.f = y0.g(bArrC, iC, 5);
            }
        } else {
            int i3 = bArrC[2];
            byte[] bArr = new byte[i3];
            System.arraycopy(bArrC, 3, bArr, 0, i3);
            this.f = new String(bArr);
        }
        this.g = false;
        this.f2160h = false;
        while (true) {
            String[] strArr = f2157j;
            if (i2 >= strArr.length) {
                break;
            }
            String str = strArr[i2];
            if (this.f.indexOf(str) != -1 || this.f.indexOf(str.toUpperCase()) != -1) {
                break;
            } else {
                i2++;
            }
        }
        this.g = true;
        if (this.g) {
            return;
        }
        if (this.f.indexOf(35) == -1 && this.f.indexOf(48) == -1) {
            return;
        }
        this.f2160h = true;
    }
}
