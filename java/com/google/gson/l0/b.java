package com.google.gson.l0;

import com.auto.exceldeps.log4j.util.Chars;
import com.google.gson.internal.b0;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class b implements Closeable {
    private String A;
    private int[] C;
    private int D;
    private String[] G;
    private int[] H;
    private final Reader c;
    private boolean d = false;
    private final char[] e = new char[1024];
    private int f = 0;
    private int g = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f759h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f760i = 0;

    /* renamed from: j, reason: collision with root package name */
    int f761j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f762k;
    private int t;

    static {
        b0.a = new a();
    }

    public b(Reader reader) {
        int[] iArr = new int[32];
        this.C = iArr;
        this.D = 0;
        this.D = 0 + 1;
        iArr[0] = 6;
        this.G = new String[32];
        this.H = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.c = reader;
    }

    private int G(boolean z) throws IOException {
        char[] cArr = this.e;
        int i2 = this.f;
        int i3 = this.g;
        while (true) {
            if (i2 == i3) {
                this.f = i2;
                if (!n(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + x());
                }
                i2 = this.f;
                i3 = this.g;
            }
            int i4 = i2 + 1;
            char c = cArr[i2];
            if (c == '\n') {
                this.f759h++;
                this.f760i = i4;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.f = i4;
                    if (i4 == i3) {
                        this.f = i4 - 1;
                        boolean zN = n(2);
                        this.f++;
                        if (!zN) {
                            return c;
                        }
                    }
                    d();
                    int i5 = this.f;
                    char c2 = cArr[i5];
                    if (c2 == '*') {
                        this.f = i5 + 1;
                        if (!S("*/")) {
                            W("Unterminated comment");
                            throw null;
                        }
                        i2 = this.f + 2;
                        i3 = this.g;
                    } else {
                        if (c2 != '/') {
                            return c;
                        }
                        this.f = i5 + 1;
                        T();
                        i2 = this.f;
                        i3 = this.g;
                    }
                } else {
                    if (c != '#') {
                        this.f = i4;
                        return c;
                    }
                    this.f = i4;
                    d();
                    T();
                    i2 = this.f;
                    i3 = this.g;
                }
            }
            i2 = i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
    
        if (r2 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
    
        r2 = new java.lang.StringBuilder(java.lang.Math.max((r3 - r4) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        r2.append(r0, r4, r3 - r4);
        r10.f = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String I(char c) throws IOException {
        char[] cArr = this.e;
        StringBuilder sb = null;
        do {
            int i2 = this.f;
            int i3 = this.g;
            while (true) {
                int i4 = i3;
                int i5 = i2;
                while (i2 < i4) {
                    int i6 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 == c) {
                        this.f = i6;
                        int i7 = (i6 - i5) - 1;
                        if (sb == null) {
                            return new String(cArr, i5, i7);
                        }
                        sb.append(cArr, i5, i7);
                        return sb.toString();
                    }
                    if (c2 == '\\') {
                        this.f = i6;
                        int i8 = (i6 - i5) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i8 + 1) * 2, 16));
                        }
                        sb.append(cArr, i5, i8);
                        sb.append(P());
                        i2 = this.f;
                        i3 = this.g;
                    } else {
                        if (c2 == '\n') {
                            this.f759h++;
                            this.f760i = i6;
                        }
                        i2 = i6;
                    }
                }
                break;
            }
        } while (n(1));
        W("Unterminated string");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        d();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String K() throws IOException {
        String string;
        int i2 = 0;
        StringBuilder sb = null;
        do {
            int i3 = 0;
            while (true) {
                int i4 = this.f;
                if (i4 + i3 < this.g) {
                    char c = this.e[i4 + i3];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i3++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i3 >= this.e.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i3, 16));
                    }
                    sb.append(this.e, this.f, i3);
                    this.f += i3;
                } else if (n(i3 + 1)) {
                }
            }
            i2 = i3;
            if (sb != null) {
                string = new String(this.e, this.f, i2);
            } else {
                sb.append(this.e, this.f, i2);
                string = sb.toString();
            }
            this.f += i2;
            return string;
        } while (n(1));
        if (sb != null) {
        }
        this.f += i2;
        return string;
    }

    private int M() throws IOException {
        int i2;
        String str;
        String str2;
        char c = this.e[this.f];
        if (c == 't' || c == 'T') {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c == 'f' || c == 'F') {
            i2 = 6;
            str = "false";
            str2 = "FALSE";
        } else {
            if (c != 'n' && c != 'N') {
                return 0;
            }
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f + i3 >= this.g && !n(i3 + 1)) {
                return 0;
            }
            char c2 = this.e[this.f + i3];
            if (c2 != str.charAt(i3) && c2 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f + length < this.g || n(length + 1)) && w(this.e[this.f + length])) {
            return 0;
        }
        this.f += length;
        this.f761j = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0091, code lost:
    
        if (w(r14) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0093, code lost:
    
        if (r9 != 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0095, code lost:
    
        if (r10 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009d, code lost:
    
        if (r13 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a3, code lost:
    
        if (r11 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        if (r13 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a7, code lost:
    
        if (r13 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ab, code lost:
    
        r18.f762k = r11;
        r18.f += r8;
        r18.f761j = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b7, code lost:
    
        if (r9 == 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ba, code lost:
    
        if (r9 == 4) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bd, code lost:
    
        if (r9 != 7) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c2, code lost:
    
        r18.t = r8;
        r18.f761j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c8, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c9, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int N() throws IOException {
        char c;
        char[] cArr = this.e;
        int i2 = this.f;
        int i3 = this.g;
        int i4 = 0;
        boolean z = true;
        int i5 = 0;
        char c2 = 0;
        boolean z2 = false;
        long j2 = 0;
        while (true) {
            if (i2 + i5 != i3) {
                c = cArr[i2 + i5];
                char c3 = 3;
                if (c == '+') {
                    if (c == 'E' || c == 'e') {
                        i4 = 0;
                        if (c2 != 2 && c2 != 4) {
                            return 0;
                        }
                        c2 = 5;
                    } else if (c == '-') {
                        c3 = 6;
                        i4 = 0;
                        if (c2 == 0) {
                            c2 = 1;
                            z2 = true;
                        } else if (c2 != 5) {
                            return 0;
                        }
                    } else if (c == '.') {
                        i4 = 0;
                        if (c2 != 2) {
                            return 0;
                        }
                    } else {
                        if (c < '0' || c > '9') {
                            break;
                        }
                        if (c2 == 1 || c2 == 0) {
                            j2 = -(c - '0');
                            c2 = 2;
                        } else if (c2 == 2) {
                            if (j2 == 0) {
                                return 0;
                            }
                            long j3 = (10 * j2) - (c - '0');
                            z &= j2 > -922337203685477580L || (j2 == -922337203685477580L && j3 < j2);
                            j2 = j3;
                        } else if (c2 == 3) {
                            i4 = 0;
                            c2 = 4;
                        } else if (c2 == 5 || c2 == 6) {
                            i4 = 0;
                            c2 = 7;
                        }
                        i4 = 0;
                    }
                    i5++;
                } else {
                    c3 = 6;
                    i4 = 0;
                    if (c2 != 5) {
                        return 0;
                    }
                }
                c2 = c3;
                i5++;
            } else {
                if (i5 == cArr.length) {
                    return i4;
                }
                if (!n(i5 + 1)) {
                    break;
                }
                i2 = this.f;
                i3 = this.g;
                c = cArr[i2 + i5];
                char c32 = 3;
                if (c == '+') {
                }
                c2 = c32;
                i5++;
            }
        }
    }

    private void O(int i2) {
        int i3 = this.D;
        int[] iArr = this.C;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.C = Arrays.copyOf(iArr, i4);
            this.H = Arrays.copyOf(this.H, i4);
            this.G = (String[]) Arrays.copyOf(this.G, i4);
        }
        int[] iArr2 = this.C;
        int i5 = this.D;
        this.D = i5 + 1;
        iArr2[i5] = i2;
    }

    private char P() throws IOException {
        int i2;
        int i3;
        if (this.f == this.g && !n(1)) {
            W("Unterminated escape sequence");
            throw null;
        }
        char[] cArr = this.e;
        int i4 = this.f;
        int i5 = i4 + 1;
        this.f = i5;
        char c = cArr[i4];
        if (c == '\n') {
            this.f759h++;
            this.f760i = i5;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
            if (c == 'b') {
                return '\b';
            }
            if (c == 'f') {
                return '\f';
            }
            if (c == 'n') {
                return '\n';
            }
            if (c == 'r') {
                return Chars.CR;
            }
            if (c == 't') {
                return '\t';
            }
            if (c != 'u') {
                W("Invalid escape sequence");
                throw null;
            }
            if (i5 + 4 > this.g && !n(4)) {
                W("Unterminated escape sequence");
                throw null;
            }
            char c2 = 0;
            int i6 = this.f;
            int i7 = i6 + 4;
            while (i6 < i7) {
                char c3 = this.e[i6];
                char c4 = (char) (c2 << 4);
                if (c3 < '0' || c3 > '9') {
                    if (c3 >= 'a' && c3 <= 'f') {
                        i2 = c3 - 'a';
                    } else {
                        if (c3 < 'A' || c3 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.e, this.f, 4));
                        }
                        i2 = c3 - 'A';
                    }
                    i3 = i2 + 10;
                } else {
                    i3 = c3 - '0';
                }
                c2 = (char) (c4 + i3);
                i6++;
            }
            this.f += 4;
            return c2;
        }
        return c;
    }

    private void R(char c) throws IOException {
        char[] cArr = this.e;
        do {
            int i2 = this.f;
            int i3 = this.g;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c2 = cArr[i2];
                if (c2 == c) {
                    this.f = i4;
                    return;
                }
                if (c2 == '\\') {
                    this.f = i4;
                    P();
                    i2 = this.f;
                    i3 = this.g;
                } else {
                    if (c2 == '\n') {
                        this.f759h++;
                        this.f760i = i4;
                    }
                    i2 = i4;
                }
            }
            this.f = i2;
        } while (n(1));
        W("Unterminated string");
        throw null;
    }

    private boolean S(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f + length > this.g && !n(length)) {
                return false;
            }
            char[] cArr = this.e;
            int i2 = this.f;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.e[this.f + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f759h++;
            this.f760i = i2 + 1;
            this.f++;
        }
    }

    private void T() throws IOException {
        char c;
        do {
            if (this.f >= this.g && !n(1)) {
                return;
            }
            char[] cArr = this.e;
            int i2 = this.f;
            int i3 = i2 + 1;
            this.f = i3;
            c = cArr[i2];
            if (c == '\n') {
                this.f759h++;
                this.f760i = i3;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        d();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void U() throws IOException {
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.f;
                if (i3 + i2 < this.g) {
                    char c = this.e[i3 + i2];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.f = i3 + i2;
                }
            }
            this.f += i2;
            return;
        } while (n(1));
    }

    private IOException W(String str) throws IOException {
        throw new e(str + x());
    }

    private void d() throws IOException {
        if (this.d) {
            return;
        }
        W("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    private void f() throws IOException {
        G(true);
        int i2 = this.f - 1;
        this.f = i2;
        if (i2 + 5 <= this.g || n(5)) {
            int i3 = this.f;
            char[] cArr = this.e;
            if (cArr[i3] == ')' && cArr[i3 + 1] == ']' && cArr[i3 + 2] == '}' && cArr[i3 + 3] == '\'' && cArr[i3 + 4] == '\n') {
                this.f = i3 + 5;
            }
        }
    }

    private boolean n(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.e;
        int i5 = this.f760i;
        int i6 = this.f;
        this.f760i = i5 - i6;
        int i7 = this.g;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.g = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.g = 0;
        }
        this.f = 0;
        do {
            Reader reader = this.c;
            int i9 = this.g;
            int i10 = reader.read(cArr, i9, cArr.length - i9);
            if (i10 == -1) {
                return false;
            }
            i3 = this.g + i10;
            this.g = i3;
            if (this.f759h == 0 && (i4 = this.f760i) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f++;
                this.f760i = i4 + 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    private String p(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = 0;
        while (true) {
            int i3 = this.D;
            if (i2 >= i3) {
                return sb.toString();
            }
            int i4 = this.C[i2];
            if (i4 == 1 || i4 == 2) {
                int i5 = this.H[i2];
                if (z && i5 > 0 && i2 == i3 - 1) {
                    i5--;
                }
                sb.append('[');
                sb.append(i5);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append(NameUtil.PERIOD);
                String[] strArr = this.G;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
            i2++;
        }
    }

    private boolean w(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        d();
        return false;
    }

    public int B() throws IOException, NumberFormatException {
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        if (i2 == 15) {
            long j2 = this.f762k;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.f761j = 0;
                int[] iArr = this.H;
                int i4 = this.D - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.f762k + x());
        }
        if (i2 == 16) {
            this.A = new String(this.e, this.f, this.t);
            this.f += this.t;
        } else {
            if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected an int but was " + L() + x());
            }
            if (i2 == 10) {
                this.A = K();
            } else {
                this.A = I(i2 == 8 ? Chars.QUOTE : Chars.DQUOTE);
            }
            try {
                int i5 = Integer.parseInt(this.A);
                this.f761j = 0;
                int[] iArr2 = this.H;
                int i6 = this.D - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return i5;
            } catch (NumberFormatException unused) {
            }
        }
        this.f761j = 11;
        double d = Double.parseDouble(this.A);
        int i7 = (int) d;
        if (i7 != d) {
            throw new NumberFormatException("Expected an int but was " + this.A + x());
        }
        this.A = null;
        this.f761j = 0;
        int[] iArr3 = this.H;
        int i8 = this.D - 1;
        iArr3[i8] = iArr3[i8] + 1;
        return i7;
    }

    public long D() throws IOException, NumberFormatException {
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        if (i2 == 15) {
            this.f761j = 0;
            int[] iArr = this.H;
            int i3 = this.D - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f762k;
        }
        if (i2 == 16) {
            this.A = new String(this.e, this.f, this.t);
            this.f += this.t;
        } else {
            if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected a long but was " + L() + x());
            }
            if (i2 == 10) {
                this.A = K();
            } else {
                this.A = I(i2 == 8 ? Chars.QUOTE : Chars.DQUOTE);
            }
            try {
                long j2 = Long.parseLong(this.A);
                this.f761j = 0;
                int[] iArr2 = this.H;
                int i4 = this.D - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return j2;
            } catch (NumberFormatException unused) {
            }
        }
        this.f761j = 11;
        double d = Double.parseDouble(this.A);
        long j3 = (long) d;
        if (j3 != d) {
            throw new NumberFormatException("Expected a long but was " + this.A + x());
        }
        this.A = null;
        this.f761j = 0;
        int[] iArr3 = this.H;
        int i5 = this.D - 1;
        iArr3[i5] = iArr3[i5] + 1;
        return j3;
    }

    public String F() throws IOException {
        String strI;
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        if (i2 == 14) {
            strI = K();
        } else if (i2 == 12) {
            strI = I(Chars.QUOTE);
        } else {
            if (i2 != 13) {
                throw new IllegalStateException("Expected a name but was " + L() + x());
            }
            strI = I(Chars.DQUOTE);
        }
        this.f761j = 0;
        this.G[this.D - 1] = strI;
        return strI;
    }

    public void H() throws IOException {
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        if (i2 == 7) {
            this.f761j = 0;
            int[] iArr = this.H;
            int i3 = this.D - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + L() + x());
    }

    public String J() throws IOException {
        String str;
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        if (i2 == 10) {
            str = K();
        } else if (i2 == 8) {
            str = I(Chars.QUOTE);
        } else if (i2 == 9) {
            str = I(Chars.DQUOTE);
        } else if (i2 == 11) {
            str = this.A;
            this.A = null;
        } else if (i2 == 15) {
            str = Long.toString(this.f762k);
        } else {
            if (i2 != 16) {
                throw new IllegalStateException("Expected a string but was " + L() + x());
            }
            str = new String(this.e, this.f, this.t);
            this.f += this.t;
        }
        this.f761j = 0;
        int[] iArr = this.H;
        int i3 = this.D - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public c L() throws IOException {
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        switch (i2) {
            case 1:
                return c.BEGIN_OBJECT;
            case 2:
                return c.END_OBJECT;
            case 3:
                return c.BEGIN_ARRAY;
            case 4:
                return c.END_ARRAY;
            case 5:
            case 6:
                return c.BOOLEAN;
            case 7:
                return c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.STRING;
            case 12:
            case 13:
            case 14:
                return c.NAME;
            case 15:
            case 16:
                return c.NUMBER;
            case 17:
                return c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void Q(boolean z) {
        this.d = z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void V() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.f761j;
            if (i3 == 0) {
                i3 = i();
            }
            switch (i3) {
                case 1:
                    O(3);
                    i2++;
                    this.f761j = 0;
                    break;
                case 2:
                    if (i2 == 0) {
                        this.G[this.D - 1] = null;
                    }
                    this.D--;
                    i2--;
                    this.f761j = 0;
                    break;
                case 3:
                    O(1);
                    i2++;
                    this.f761j = 0;
                    break;
                case 4:
                    this.D--;
                    i2--;
                    this.f761j = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f761j = 0;
                    break;
                case 8:
                    R(Chars.QUOTE);
                    this.f761j = 0;
                    break;
                case 9:
                    R(Chars.DQUOTE);
                    this.f761j = 0;
                    break;
                case 10:
                    U();
                    this.f761j = 0;
                    break;
                case 12:
                    R(Chars.QUOTE);
                    if (i2 == 0) {
                        this.G[this.D - 1] = "<skipped>";
                    }
                    this.f761j = 0;
                    break;
                case 13:
                    R(Chars.DQUOTE);
                    if (i2 == 0) {
                        this.G[this.D - 1] = "<skipped>";
                    }
                    this.f761j = 0;
                    break;
                case 14:
                    U();
                    if (i2 == 0) {
                        this.G[this.D - 1] = "<skipped>";
                    }
                    this.f761j = 0;
                    break;
                case 16:
                    this.f += this.t;
                    this.f761j = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i2 > 0);
        int[] iArr = this.H;
        int i4 = this.D - 1;
        iArr[i4] = iArr[i4] + 1;
    }

    public void a() throws IOException {
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        if (i2 == 3) {
            O(1);
            this.H[this.D - 1] = 0;
            this.f761j = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + L() + x());
        }
    }

    public void c() throws IOException {
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        if (i2 == 1) {
            O(3);
            this.f761j = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + L() + x());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f761j = 0;
        this.C[0] = 8;
        this.D = 1;
        this.c.close();
    }

    int i() throws IOException {
        int iG;
        int[] iArr = this.C;
        int i2 = this.D;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int iG2 = G(true);
            if (iG2 != 44) {
                if (iG2 != 59) {
                    if (iG2 == 93) {
                        this.f761j = 4;
                        return 4;
                    }
                    W("Unterminated array");
                    throw null;
                }
                d();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5 && (iG = G(true)) != 44) {
                    if (iG != 59) {
                        if (iG == 125) {
                            this.f761j = 2;
                            return 2;
                        }
                        W("Unterminated object");
                        throw null;
                    }
                    d();
                }
                int iG3 = G(true);
                if (iG3 == 34) {
                    this.f761j = 13;
                    return 13;
                }
                if (iG3 == 39) {
                    d();
                    this.f761j = 12;
                    return 12;
                }
                if (iG3 == 125) {
                    if (i3 != 5) {
                        this.f761j = 2;
                        return 2;
                    }
                    W("Expected name");
                    throw null;
                }
                d();
                this.f--;
                if (w((char) iG3)) {
                    this.f761j = 14;
                    return 14;
                }
                W("Expected name");
                throw null;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int iG4 = G(true);
                if (iG4 != 58) {
                    if (iG4 != 61) {
                        W("Expected ':'");
                        throw null;
                    }
                    d();
                    if (this.f < this.g || n(1)) {
                        char[] cArr = this.e;
                        int i4 = this.f;
                        if (cArr[i4] == '>') {
                            this.f = i4 + 1;
                        }
                    }
                }
            } else if (i3 == 6) {
                if (this.d) {
                    f();
                }
                this.C[this.D - 1] = 7;
            } else if (i3 == 7) {
                if (G(false) == -1) {
                    this.f761j = 17;
                    return 17;
                }
                d();
                this.f--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iG5 = G(true);
        if (iG5 == 34) {
            this.f761j = 9;
            return 9;
        }
        if (iG5 == 39) {
            d();
            this.f761j = 8;
            return 8;
        }
        if (iG5 != 44 && iG5 != 59) {
            if (iG5 == 91) {
                this.f761j = 3;
                return 3;
            }
            if (iG5 != 93) {
                if (iG5 == 123) {
                    this.f761j = 1;
                    return 1;
                }
                this.f--;
                int iM = M();
                if (iM != 0) {
                    return iM;
                }
                int iN = N();
                if (iN != 0) {
                    return iN;
                }
                if (!w(this.e[this.f])) {
                    W("Expected value");
                    throw null;
                }
                d();
                this.f761j = 10;
                return 10;
            }
            if (i3 == 1) {
                this.f761j = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            W("Unexpected value");
            throw null;
        }
        d();
        this.f--;
        this.f761j = 7;
        return 7;
    }

    public void j() throws IOException {
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        if (i2 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + L() + x());
        }
        int i3 = this.D - 1;
        this.D = i3;
        int[] iArr = this.H;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f761j = 0;
    }

    public void m() throws IOException {
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        if (i2 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + L() + x());
        }
        int i3 = this.D - 1;
        this.D = i3;
        this.G[i3] = null;
        int[] iArr = this.H;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f761j = 0;
    }

    public String o() {
        return p(false);
    }

    public String q() {
        return p(true);
    }

    public boolean s() throws IOException {
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        return (i2 == 2 || i2 == 4 || i2 == 17) ? false : true;
    }

    public String toString() {
        return b.class.getSimpleName() + x();
    }

    public final boolean u() {
        return this.d;
    }

    String x() {
        return " at line " + (this.f759h + 1) + " column " + ((this.f - this.f760i) + 1) + " path " + o();
    }

    public boolean y() throws IOException {
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        if (i2 == 5) {
            this.f761j = 0;
            int[] iArr = this.H;
            int i3 = this.D - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (i2 == 6) {
            this.f761j = 0;
            int[] iArr2 = this.H;
            int i4 = this.D - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + L() + x());
    }

    public double z() throws IOException, NumberFormatException {
        int i2 = this.f761j;
        if (i2 == 0) {
            i2 = i();
        }
        if (i2 == 15) {
            this.f761j = 0;
            int[] iArr = this.H;
            int i3 = this.D - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f762k;
        }
        if (i2 == 16) {
            this.A = new String(this.e, this.f, this.t);
            this.f += this.t;
        } else if (i2 == 8 || i2 == 9) {
            this.A = I(i2 == 8 ? Chars.QUOTE : Chars.DQUOTE);
        } else if (i2 == 10) {
            this.A = K();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + L() + x());
        }
        this.f761j = 11;
        double d = Double.parseDouble(this.A);
        if (!this.d && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new e("JSON forbids NaN and infinities: " + d + x());
        }
        this.A = null;
        this.f761j = 0;
        int[] iArr2 = this.H;
        int i4 = this.D - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return d;
    }
}
