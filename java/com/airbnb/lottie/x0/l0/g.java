package com.airbnb.lottie.x0.l0;

import com.auto.exceldeps.log4j.util.Chars;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
final class g extends e {
    private static final m.d G = m.d.c("'\\");
    private static final m.d H = m.d.c("\"\\");
    private static final m.d I = m.d.c("{}[]:, \n\t\r\f/\\;#=");
    private static final m.d J = m.d.c("\n\r");
    private static final m.d K = m.d.c("*/");
    private long A;
    private int C;
    private String D;

    /* renamed from: j, reason: collision with root package name */
    private final m.c f559j;

    /* renamed from: k, reason: collision with root package name */
    private final m.a f560k;
    private int t = 0;

    g(m.c cVar) {
        Objects.requireNonNull(cVar, "source == null");
        this.f559j = cVar;
        this.f560k = cVar.r();
        x(6);
    }

    private void G() throws IOException {
        if (this.g) {
            return;
        }
        F("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    private int H() throws IOException {
        int[] iArr = this.d;
        int i2 = this.c;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int iK = K(true);
            this.f560k.n();
            if (iK != 44) {
                if (iK != 59) {
                    if (iK == 93) {
                        this.t = 4;
                        return 4;
                    }
                    F("Unterminated array");
                    throw null;
                }
                G();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5) {
                    int iK2 = K(true);
                    this.f560k.n();
                    if (iK2 != 44) {
                        if (iK2 != 59) {
                            if (iK2 == 125) {
                                this.t = 2;
                                return 2;
                            }
                            F("Unterminated object");
                            throw null;
                        }
                        G();
                    }
                }
                int iK3 = K(true);
                if (iK3 == 34) {
                    this.f560k.n();
                    this.t = 13;
                    return 13;
                }
                if (iK3 == 39) {
                    this.f560k.n();
                    G();
                    this.t = 12;
                    return 12;
                }
                if (iK3 != 125) {
                    G();
                    if (J((char) iK3)) {
                        this.t = 14;
                        return 14;
                    }
                    F("Expected name");
                    throw null;
                }
                if (i3 == 5) {
                    F("Expected name");
                    throw null;
                }
                this.f560k.n();
                this.t = 2;
                return 2;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int iK4 = K(true);
                this.f560k.n();
                if (iK4 != 58) {
                    if (iK4 != 61) {
                        F("Expected ':'");
                        throw null;
                    }
                    G();
                    if (this.f559j.h(1L) && this.f560k.f(0L) == 62) {
                        this.f560k.n();
                    }
                }
            } else if (i3 == 6) {
                iArr[i2 - 1] = 7;
            } else if (i3 == 7) {
                if (K(false) == -1) {
                    this.t = 18;
                    return 18;
                }
                G();
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iK5 = K(true);
        if (iK5 == 34) {
            this.f560k.n();
            this.t = 9;
            return 9;
        }
        if (iK5 == 39) {
            G();
            this.f560k.n();
            this.t = 8;
            return 8;
        }
        if (iK5 != 44 && iK5 != 59) {
            if (iK5 == 91) {
                this.f560k.n();
                this.t = 3;
                return 3;
            }
            if (iK5 != 93) {
                if (iK5 == 123) {
                    this.f560k.n();
                    this.t = 1;
                    return 1;
                }
                int iN = N();
                if (iN != 0) {
                    return iN;
                }
                int iO = O();
                if (iO != 0) {
                    return iO;
                }
                if (!J(this.f560k.f(0L))) {
                    F("Expected value");
                    throw null;
                }
                G();
                this.t = 10;
                return 10;
            }
            if (i3 == 1) {
                this.f560k.n();
                this.t = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            F("Unexpected value");
            throw null;
        }
        G();
        this.t = 7;
        return 7;
    }

    private int I(String str, c cVar) {
        int length = cVar.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(cVar.a[i2])) {
                this.t = 0;
                this.e[this.c - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    private boolean J(int i2) throws IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (i2 != 47 && i2 != 61) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        G();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r6.f560k.B(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if (r1 != 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r6.f559j.h(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        G();
        r3 = r6.f560k.f(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r3 == 42) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        r6.f560k.n();
        r6.f560k.n();
        S();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        r6.f560k.n();
        r6.f560k.n();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        if (R() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        F("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if (r1 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
    
        G();
        S();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int K(boolean z) throws IOException {
        while (true) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (!this.f559j.h(i3)) {
                    if (z) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                byte bF = this.f560k.f(i2);
                if (bF != 10 && bF != 32 && bF != 13 && bF != 9) {
                    break;
                }
                i2 = i3;
            }
        }
    }

    private String L(m.d dVar) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jE = this.f559j.e(dVar);
            if (jE == -1) {
                F("Unterminated string");
                throw null;
            }
            if (this.f560k.f(jE) != 92) {
                if (sb == null) {
                    String strY = this.f560k.y(jE);
                    this.f560k.n();
                    return strY;
                }
                sb.append(this.f560k.y(jE));
                this.f560k.n();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.f560k.y(jE));
            this.f560k.n();
            sb.append(P());
        }
    }

    private String M() throws IOException {
        long jE = this.f559j.e(I);
        return jE != -1 ? this.f560k.y(jE) : this.f560k.x();
    }

    private int N() throws IOException {
        int i2;
        String str;
        String str2;
        byte bF = this.f560k.f(0L);
        if (bF == 116 || bF == 84) {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (bF == 102 || bF == 70) {
            i2 = 6;
            str = "false";
            str2 = "FALSE";
        } else {
            if (bF != 110 && bF != 78) {
                return 0;
            }
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.f559j.h(i4)) {
                return 0;
            }
            byte bF2 = this.f560k.f(i3);
            if (bF2 != str.charAt(i3) && bF2 != str2.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.f559j.h(length + 1) && J(this.f560k.f(length))) {
            return 0;
        }
        this.f560k.B(length);
        this.t = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0082, code lost:
    
        if (J(r11) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0084, code lost:
    
        if (r6 != 2) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0086, code lost:
    
        if (r7 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008c, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
    
        if (r10 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0092, code lost:
    
        if (r8 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0094, code lost:
    
        if (r10 != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0096, code lost:
    
        if (r10 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0099, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009a, code lost:
    
        r16.A = r8;
        r16.f560k.B(r5);
        r16.t = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a6, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a7, code lost:
    
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00aa, code lost:
    
        if (r6 == 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ad, code lost:
    
        if (r6 != 7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b2, code lost:
    
        r16.C = r5;
        r16.t = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b8, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b9, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int O() throws IOException {
        char c;
        boolean z = true;
        int i2 = 0;
        long j2 = 0;
        boolean z2 = true;
        int i3 = 0;
        char c2 = 0;
        boolean z3 = false;
        while (true) {
            int i4 = i3 + 1;
            if (!this.f559j.h(i4)) {
                break;
            }
            byte bF = this.f560k.f(i3);
            if (bF != 43) {
                if (bF == 69 || bF == 101) {
                    if (c2 != 2 && c2 != 4) {
                        return i2;
                    }
                    c2 = 5;
                } else if (bF == 45) {
                    c = 6;
                    if (c2 == 0) {
                        c2 = 1;
                        z3 = true;
                    } else if (c2 != 5) {
                        return i2;
                    }
                } else if (bF == 46) {
                    c = 3;
                    if (c2 != 2) {
                        return i2;
                    }
                } else {
                    if (bF < 48 || bF > 57) {
                        break;
                    }
                    if (c2 == z || c2 == 0) {
                        j2 = -(bF - 48);
                        c2 = 2;
                    } else if (c2 == 2) {
                        if (j2 == 0) {
                            return i2;
                        }
                        long j3 = (10 * j2) - (bF - 48);
                        z2 &= j2 > -922337203685477580L || (j2 == -922337203685477580L && j3 < j2);
                        j2 = j3;
                    } else if (c2 == 3) {
                        i2 = 0;
                        c2 = 4;
                    } else if (c2 == 5 || c2 == 6) {
                        i2 = 0;
                        c2 = 7;
                    }
                    i2 = 0;
                }
                i3 = i4;
                z = true;
            } else {
                c = 6;
                if (c2 != 5) {
                    return i2;
                }
            }
            c2 = c;
            i3 = i4;
            z = true;
        }
    }

    private char P() throws IOException {
        int i2;
        int i3;
        if (!this.f559j.h(1L)) {
            F("Unterminated escape sequence");
            throw null;
        }
        byte bN = this.f560k.n();
        if (bN == 10 || bN == 34 || bN == 39 || bN == 47 || bN == 92) {
            return (char) bN;
        }
        if (bN == 98) {
            return '\b';
        }
        if (bN == 102) {
            return '\f';
        }
        if (bN == 110) {
            return '\n';
        }
        if (bN == 114) {
            return Chars.CR;
        }
        if (bN == 116) {
            return '\t';
        }
        if (bN != 117) {
            if (this.g) {
                return (char) bN;
            }
            F("Invalid escape sequence: \\" + ((char) bN));
            throw null;
        }
        if (!this.f559j.h(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + j());
        }
        char c = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            byte bF = this.f560k.f(i4);
            char c2 = (char) (c << 4);
            if (bF < 48 || bF > 57) {
                if (bF >= 97 && bF <= 102) {
                    i2 = bF - 97;
                } else {
                    if (bF < 65 || bF > 70) {
                        F("\\u" + this.f560k.y(4L));
                        throw null;
                    }
                    i2 = bF - 65;
                }
                i3 = i2 + 10;
            } else {
                i3 = bF - 48;
            }
            c = (char) (c2 + i3);
        }
        this.f560k.B(4L);
        return c;
    }

    private void Q(m.d dVar) throws IOException {
        while (true) {
            long jE = this.f559j.e(dVar);
            if (jE == -1) {
                F("Unterminated string");
                throw null;
            }
            if (this.f560k.f(jE) != 92) {
                this.f560k.B(jE + 1);
                return;
            } else {
                this.f560k.B(jE + 1);
                P();
            }
        }
    }

    private boolean R() throws IOException {
        long jB = this.f559j.b(K);
        boolean z = jB != -1;
        m.a aVar = this.f560k;
        aVar.B(z ? jB + r1.size() : aVar.size());
        return z;
    }

    private void S() throws IOException {
        long jE = this.f559j.e(J);
        m.a aVar = this.f560k;
        aVar.B(jE != -1 ? jE + 1 : aVar.size());
    }

    private void T() throws IOException {
        long jE = this.f559j.e(I);
        m.a aVar = this.f560k;
        if (jE == -1) {
            jE = aVar.size();
        }
        aVar.B(jE);
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public void B() throws IOException {
        if (this.f558h) {
            throw new a("Cannot skip unexpected " + w() + " at " + j());
        }
        int i2 = 0;
        do {
            int iH = this.t;
            if (iH == 0) {
                iH = H();
            }
            if (iH == 3) {
                x(1);
            } else if (iH == 1) {
                x(3);
            } else {
                if (iH == 4) {
                    i2--;
                    if (i2 < 0) {
                        throw new a("Expected a value but was " + w() + " at path " + j());
                    }
                    this.c--;
                } else if (iH == 2) {
                    i2--;
                    if (i2 < 0) {
                        throw new a("Expected a value but was " + w() + " at path " + j());
                    }
                    this.c--;
                } else if (iH == 14 || iH == 10) {
                    T();
                } else if (iH == 9 || iH == 13) {
                    Q(H);
                } else if (iH == 8 || iH == 12) {
                    Q(G);
                } else if (iH == 17) {
                    this.f560k.B(this.C);
                } else if (iH == 18) {
                    throw new a("Expected a value but was " + w() + " at path " + j());
                }
                this.t = 0;
            }
            i2++;
            this.t = 0;
        } while (i2 != 0);
        int[] iArr = this.f;
        int i3 = this.c;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.e[i3 - 1] = "null";
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public void c() throws IOException {
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        if (iH == 3) {
            x(1);
            this.f[this.c - 1] = 0;
            this.t = 0;
        } else {
            throw new a("Expected BEGIN_ARRAY but was " + w() + " at path " + j());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.t = 0;
        this.d[0] = 8;
        this.c = 1;
        this.f560k.a();
        this.f559j.close();
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public void d() throws IOException {
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        if (iH == 1) {
            x(3);
            this.t = 0;
            return;
        }
        throw new a("Expected BEGIN_OBJECT but was " + w() + " at path " + j());
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public void f() throws IOException {
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        if (iH != 4) {
            throw new a("Expected END_ARRAY but was " + w() + " at path " + j());
        }
        int i2 = this.c - 1;
        this.c = i2;
        int[] iArr = this.f;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.t = 0;
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public void i() throws IOException {
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        if (iH != 2) {
            throw new a("Expected END_OBJECT but was " + w() + " at path " + j());
        }
        int i2 = this.c - 1;
        this.c = i2;
        this.e[i2] = null;
        int[] iArr = this.f;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.t = 0;
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public boolean m() throws IOException {
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        return (iH == 2 || iH == 4 || iH == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public boolean n() throws IOException {
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        if (iH == 5) {
            this.t = 0;
            int[] iArr = this.f;
            int i2 = this.c - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iH == 6) {
            this.t = 0;
            int[] iArr2 = this.f;
            int i3 = this.c - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new a("Expected a boolean but was " + w() + " at path " + j());
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public double o() throws IOException, NumberFormatException {
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        if (iH == 16) {
            this.t = 0;
            int[] iArr = this.f;
            int i2 = this.c - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.A;
        }
        if (iH == 17) {
            this.D = this.f560k.y(this.C);
        } else if (iH == 9) {
            this.D = L(H);
        } else if (iH == 8) {
            this.D = L(G);
        } else if (iH == 10) {
            this.D = M();
        } else if (iH != 11) {
            throw new a("Expected a double but was " + w() + " at path " + j());
        }
        this.t = 11;
        try {
            double d = Double.parseDouble(this.D);
            if (this.g || !(Double.isNaN(d) || Double.isInfinite(d))) {
                this.D = null;
                this.t = 0;
                int[] iArr2 = this.f;
                int i3 = this.c - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return d;
            }
            throw new b("JSON forbids NaN and infinities: " + d + " at path " + j());
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.D + " at path " + j());
        }
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public int p() throws IOException, NumberFormatException {
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        if (iH == 16) {
            long j2 = this.A;
            int i2 = (int) j2;
            if (j2 == i2) {
                this.t = 0;
                int[] iArr = this.f;
                int i3 = this.c - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new a("Expected an int but was " + this.A + " at path " + j());
        }
        if (iH == 17) {
            this.D = this.f560k.y(this.C);
        } else if (iH == 9 || iH == 8) {
            String strL = iH == 9 ? L(H) : L(G);
            this.D = strL;
            try {
                int i4 = Integer.parseInt(strL);
                this.t = 0;
                int[] iArr2 = this.f;
                int i5 = this.c - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        } else if (iH != 11) {
            throw new a("Expected an int but was " + w() + " at path " + j());
        }
        this.t = 11;
        try {
            double d = Double.parseDouble(this.D);
            int i6 = (int) d;
            if (i6 == d) {
                this.D = null;
                this.t = 0;
                int[] iArr3 = this.f;
                int i7 = this.c - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new a("Expected an int but was " + this.D + " at path " + j());
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.D + " at path " + j());
        }
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public String q() throws IOException {
        String strL;
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        if (iH == 14) {
            strL = M();
        } else if (iH == 13) {
            strL = L(H);
        } else if (iH == 12) {
            strL = L(G);
        } else {
            if (iH != 15) {
                throw new a("Expected a name but was " + w() + " at path " + j());
            }
            strL = this.D;
        }
        this.t = 0;
        this.e[this.c - 1] = strL;
        return strL;
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public String s() throws IOException {
        String strY;
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        if (iH == 10) {
            strY = M();
        } else if (iH == 9) {
            strY = L(H);
        } else if (iH == 8) {
            strY = L(G);
        } else if (iH == 11) {
            strY = this.D;
            this.D = null;
        } else if (iH == 16) {
            strY = Long.toString(this.A);
        } else {
            if (iH != 17) {
                throw new a("Expected a string but was " + w() + " at path " + j());
            }
            strY = this.f560k.y(this.C);
        }
        this.t = 0;
        int[] iArr = this.f;
        int i2 = this.c - 1;
        iArr[i2] = iArr[i2] + 1;
        return strY;
    }

    public String toString() {
        return "JsonReader(" + this.f559j + ")";
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public d w() throws IOException {
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        switch (iH) {
            case 1:
                return d.BEGIN_OBJECT;
            case 2:
                return d.END_OBJECT;
            case 3:
                return d.BEGIN_ARRAY;
            case 4:
                return d.END_ARRAY;
            case 5:
            case 6:
                return d.BOOLEAN;
            case 7:
                return d.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return d.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return d.NAME;
            case 16:
            case 17:
                return d.NUMBER;
            case 18:
                return d.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public int y(c cVar) throws IOException {
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        if (iH < 12 || iH > 15) {
            return -1;
        }
        if (iH == 15) {
            return I(this.D, cVar);
        }
        int iE = this.f559j.E(cVar.b);
        if (iE != -1) {
            this.t = 0;
            this.e[this.c - 1] = cVar.a[iE];
            return iE;
        }
        String str = this.e[this.c - 1];
        String strQ = q();
        int I2 = I(strQ, cVar);
        if (I2 == -1) {
            this.t = 15;
            this.D = strQ;
            this.e[this.c - 1] = str;
        }
        return I2;
    }

    @Override // com.airbnb.lottie.x0.l0.e
    public void z() throws IOException {
        if (this.f558h) {
            throw new a("Cannot skip unexpected " + w() + " at " + j());
        }
        int iH = this.t;
        if (iH == 0) {
            iH = H();
        }
        if (iH == 14) {
            T();
        } else if (iH == 13) {
            Q(H);
        } else if (iH == 12) {
            Q(G);
        } else if (iH != 15) {
            throw new a("Expected a name but was " + w() + " at path " + j());
        }
        this.t = 0;
        this.e[this.c - 1] = "null";
    }
}
