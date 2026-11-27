package i.e.a.l;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import i.e.a.j.z;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: m, reason: collision with root package name */
    static final char[] f1642m = new char[0];

    /* renamed from: n, reason: collision with root package name */
    private static final char[] f1643n;

    /* renamed from: o, reason: collision with root package name */
    private static final String[] f1644o;
    private static final char[] p;
    private static final String[] q;
    private final z a;
    private ArrayList<char[]> b;
    private int c;
    private char[] d;
    private int e;
    private String f;
    private char[] g;

    /* renamed from: h, reason: collision with root package name */
    private int f1645h;

    /* renamed from: i, reason: collision with root package name */
    private char[] f1646i;

    /* renamed from: j, reason: collision with root package name */
    private int f1647j;

    /* renamed from: k, reason: collision with root package name */
    private int f1648k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1649l = false;

    static {
        char[] charArray = "\n                                 ".toCharArray();
        f1643n = charArray;
        f1644o = new String[charArray.length];
        char[] charArray2 = "\n\t\t\t\t\t\t\t\t\t".toCharArray();
        p = charArray2;
        q = new String[charArray2.length];
    }

    private i(z zVar) {
        this.a = zVar;
    }

    private final char[] a(int i2) {
        char[] cArrJ;
        int iMax = Math.max(500, i2);
        z zVar = this.a;
        return (zVar == null || (cArrJ = zVar.j(iMax)) == null) ? new char[iMax] : cArrJ;
    }

    private char[] e() {
        int i2;
        String str = this.f;
        if (str != null) {
            return str.toCharArray();
        }
        int iB = B();
        if (iB < 1) {
            return f1642m;
        }
        char[] cArr = new char[iB];
        ArrayList<char[]> arrayList = this.b;
        if (arrayList != null) {
            int size = arrayList.size();
            i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                char[] cArr2 = this.b.get(i3);
                int length = cArr2.length;
                System.arraycopy(cArr2, 0, cArr, i2, length);
                i2 += length;
            }
        } else {
            i2 = 0;
        }
        System.arraycopy(this.d, 0, cArr, i2, this.e);
        return cArr;
    }

    private int f(int i2) {
        return Math.min(i2 + (i2 < 8000 ? i2 : i2 >> 1), WXMediaMessage.NATIVE_GAME__THUMB_LIMIT);
    }

    public static i j(z zVar) {
        return new i(zVar);
    }

    private void m(int i2) {
        if (this.b == null) {
            this.b = new ArrayList<>();
        }
        char[] cArr = this.d;
        this.b.add(cArr);
        int length = cArr.length;
        this.c += length;
        char[] cArr2 = new char[Math.max(i2, f(length))];
        this.e = 0;
        this.d = cArr2;
    }

    private final void v() {
        this.f1647j = 0;
        ArrayList<char[]> arrayList = this.b;
        if (arrayList != null && arrayList.size() != 0) {
            char[] cArrG = g();
            this.f1646i = cArrG;
            this.f1648k = cArrG.length;
        } else if (!this.f1649l) {
            this.f1646i = this.d;
            this.f1648k = this.e;
        } else {
            char[] cArr = this.g;
            this.f1646i = cArr;
            this.f1648k = cArr.length;
        }
    }

    public void A(int i2) {
        this.e = i2;
    }

    public int B() {
        int i2 = this.e;
        return i2 < 0 ? this.f1645h : i2 + this.c;
    }

    public void b(char c) {
        this.f = null;
        this.g = null;
        char[] cArr = this.d;
        if (this.e >= cArr.length) {
            m(1);
        }
        int i2 = this.e;
        this.e = i2 + 1;
        cArr[i2] = c;
    }

    public void c(String str) {
        this.f = null;
        this.g = null;
        int length = str.length();
        char[] cArr = this.d;
        int length2 = cArr.length;
        int i2 = this.e;
        int i3 = length2 - i2;
        if (i3 >= length) {
            str.getChars(0, length, cArr, i2);
            this.e += length;
            return;
        }
        if (i3 > 0) {
            str.getChars(0, i3, cArr, i2);
            length -= i3;
        }
        m(length);
        str.getChars(i3, i3 + length, this.d, 0);
        this.e = length;
    }

    public void d(int i2) {
        b((char) ((i2 >> 10) | 55296));
        b((char) ((i2 & 1023) | 56320));
    }

    public char[] g() {
        char[] cArr = this.g;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrE = e();
        this.g = cArrE;
        return cArrE;
    }

    public String h() {
        if (this.f == null) {
            if (this.g != null) {
                this.f = new String(this.g);
            } else {
                int i2 = this.c;
                int i3 = this.e;
                if (i2 == 0) {
                    String str = i3 == 0 ? "" : new String(this.d, 0, i3);
                    this.f = str;
                    return str;
                }
                StringBuilder sb = new StringBuilder(i2 + i3);
                ArrayList<char[]> arrayList = this.b;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        char[] cArr = this.b.get(i4);
                        sb.append(cArr, 0, cArr.length);
                    }
                }
                sb.append(this.d, 0, i3);
                this.f = sb.toString();
            }
        }
        return this.f;
    }

    public int i(int i2, char[] cArr, int i3, int i4) {
        ArrayList<char[]> arrayList = this.b;
        int i5 = 0;
        if (arrayList != null) {
            int size = arrayList.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                char[] cArr2 = this.b.get(i7);
                int length = cArr2.length;
                int i8 = length - i2;
                if (i8 < 1) {
                    i2 -= length;
                } else {
                    if (i8 >= i4) {
                        System.arraycopy(cArr2, i2, cArr, i3, i4);
                        return i6 + i4;
                    }
                    System.arraycopy(cArr2, i2, cArr, i3, i8);
                    i6 += i8;
                    i3 += i8;
                    i4 -= i8;
                    i2 = 0;
                }
            }
            i5 = i6;
        }
        if (i4 <= 0) {
            return i5;
        }
        int i9 = this.e - i2;
        if (i4 > i9) {
            i4 = i9;
        }
        if (i4 <= 0) {
            return i5;
        }
        System.arraycopy(this.d, i2, cArr, i3, i4);
        return i5 + i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:
    
        r1 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
    
        if (r1 >= r2) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0021, code lost:
    
        if (r0[r1] <= ' ') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0023, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0026, code lost:
    
        r7 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0027, code lost:
    
        r4 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
    
        r3 = r3 + 1;
        r4 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
    
        if (r7.a(r0, r8, r1) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r1 = r8;
        r8 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0036, code lost:
    
        r6.f1647j = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
    
        r7 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0057, code lost:
    
        throw new n.b.a.n.e(new java.lang.String(r0, r8, (r4 - r8) - 1), r7.getMessage(), r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int k(n.b.a.n.c cVar, boolean z) throws n.b.a.n.e {
        int i2;
        if (z) {
            v();
        }
        int i3 = this.f1647j;
        char[] cArr = this.f1646i;
        try {
            int i4 = this.f1648k;
            int i5 = 0;
            int i6 = i3;
            loop0: while (true) {
                if (i3 >= i4) {
                    break;
                }
                while (true) {
                    try {
                        if (cArr[i3] > ' ') {
                            break;
                        }
                        i3++;
                        if (i3 >= i4) {
                            break loop0;
                        }
                    } catch (IllegalArgumentException e) {
                        e = e;
                        i2 = i3;
                        i3 = i6;
                    }
                }
                i6 = i3;
                i3 = i2;
            }
            this.f1647j = i3;
            return i5;
        } catch (IllegalArgumentException e2) {
            e = e2;
            i2 = i3;
        }
    }

    public boolean l(String str) {
        int length = str.length();
        if (length != B()) {
            return false;
        }
        ArrayList<char[]> arrayList = this.b;
        char[] cArrG = (arrayList == null || arrayList.size() == 0) ? this.d : g();
        for (int i2 = 0; i2 < length; i2++) {
            if (cArrG[i2] != str.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public char[] n() {
        if (this.b == null) {
            this.b = new ArrayList<>();
        }
        this.b.add(this.d);
        int length = this.d.length;
        this.c += length;
        char[] cArr = new char[f(length)];
        this.e = 0;
        this.d = cArr;
        return cArr;
    }

    public char[] o() {
        return this.d;
    }

    public int p() {
        return this.e;
    }

    public char[] q() {
        ArrayList<char[]> arrayList = this.b;
        if (arrayList != null && arrayList.size() != 0) {
            return g();
        }
        char[] cArr = this.g;
        return cArr != null ? cArr : this.d;
    }

    public boolean r() {
        if (this.f1649l) {
            return true;
        }
        ArrayList<char[]> arrayList = this.b;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                for (char c : this.b.get(i2)) {
                    if (c > ' ') {
                        return false;
                    }
                }
            }
        }
        char[] cArr = this.d;
        int i3 = this.e;
        for (int i4 = 0; i4 < i3; i4++) {
            if (cArr[i4] > ' ') {
                return false;
            }
        }
        return true;
    }

    public int s(Writer writer) throws IOException {
        int length;
        char[] cArr = this.g;
        if (cArr != null) {
            writer.write(cArr);
            return this.g.length;
        }
        String str = this.f;
        if (str != null) {
            writer.write(str);
            return this.f.length();
        }
        ArrayList<char[]> arrayList = this.b;
        if (arrayList != null) {
            int size = arrayList.size();
            length = 0;
            for (int i2 = 0; i2 < size; i2++) {
                char[] cArr2 = this.b.get(i2);
                writer.write(cArr2);
                length += cArr2.length;
            }
        } else {
            length = 0;
        }
        int i3 = this.e;
        if (i3 <= 0) {
            return length;
        }
        writer.write(this.d, 0, i3);
        return length + this.e;
    }

    public void t(boolean z) {
        if (this.a == null || this.d == null) {
            return;
        }
        if (z) {
            this.f = null;
            this.g = null;
        } else if (this.c + this.e > 0) {
            return;
        }
        ArrayList<char[]> arrayList = this.b;
        if (arrayList != null && arrayList.size() > 0) {
            this.b.clear();
            this.c = 0;
        }
        char[] cArr = this.d;
        this.d = null;
        this.a.z(cArr);
    }

    public String toString() {
        this.f = null;
        this.g = null;
        return h();
    }

    public void u(n.b.a.n.a aVar, n.b.a.m.o.b bVar, boolean z) {
        ArrayList<char[]> arrayList = this.b;
        if ((arrayList != null && arrayList.size() != 0) || !this.f1649l) {
            bVar.h(aVar, z, this.d, 0, this.e, this.b);
        } else {
            char[] cArr = this.g;
            bVar.h(aVar, z, cArr, 0, cArr.length, null);
        }
    }

    public void w(char c) {
        this.f = null;
        this.g = null;
        this.f1649l = false;
        ArrayList<char[]> arrayList = this.b;
        if (arrayList != null && arrayList.size() > 0) {
            this.b.clear();
            this.c = 0;
        }
        this.e = 1;
        if (this.d == null) {
            this.d = a(1);
        }
        this.d[0] = c;
    }

    public char[] x() {
        this.f = null;
        this.g = null;
        this.f1649l = false;
        ArrayList<char[]> arrayList = this.b;
        if (arrayList != null && arrayList.size() > 0) {
            this.b.clear();
            this.c = 0;
        }
        this.e = 0;
        if (this.d == null) {
            this.d = a(0);
        }
        return this.d;
    }

    public void y(int i2, char c) {
        String strSubstring;
        ArrayList<char[]> arrayList = this.b;
        if (arrayList != null && arrayList.size() > 0) {
            this.b.clear();
            this.c = 0;
        }
        this.e = -1;
        this.f1649l = true;
        int i3 = i2 + 1;
        this.f1645h = i3;
        if (c == '\t') {
            this.g = p;
            String[] strArr = q;
            strSubstring = strArr[i2];
            if (strSubstring == null) {
                strSubstring = "\n\t\t\t\t\t\t\t\t\t".substring(0, i3);
                strArr[i2] = strSubstring;
            }
        } else {
            this.g = f1643n;
            String[] strArr2 = f1644o;
            strSubstring = strArr2[i2];
            if (strSubstring == null) {
                strSubstring = "\n                                 ".substring(0, i3);
                strArr2[i2] = strSubstring;
            }
        }
        this.f = strSubstring;
    }

    public void z(int i2) {
        this.f = null;
        this.g = null;
        this.f1649l = false;
        ArrayList<char[]> arrayList = this.b;
        if (arrayList != null && arrayList.size() > 0) {
            this.b.clear();
            this.c = 0;
        }
        this.e = 2;
        if (this.d == null) {
            this.d = a(2);
        }
        char[] cArr = this.d;
        cArr[0] = (char) (55296 | (i2 >> 10));
        cArr[1] = (char) ((i2 & 1023) | 56320);
    }
}
