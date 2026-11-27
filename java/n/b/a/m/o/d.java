package n.b.a.m.o;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes2.dex */
public final class d {
    protected a a = null;
    protected h b = null;
    protected k c = null;
    protected f d = null;
    protected C0018d e = null;

    public static final class a extends n.b.a.m.o.e {
        protected boolean d;

        @Override // n.b.a.n.d
        public void a(String str) throws IllegalArgumentException {
            int length = str.length();
            char cCharAt = str.charAt(0);
            if (cCharAt == 't') {
                if (length == 4 && str.charAt(1) == 'r' && str.charAt(2) == 'u' && str.charAt(3) == 'e') {
                    this.d = true;
                    return;
                }
            } else if (cCharAt == 'f') {
                if (length == 5 && str.charAt(1) == 'a' && str.charAt(2) == 'l' && str.charAt(3) == 's' && str.charAt(4) == 'e') {
                    this.d = false;
                    return;
                }
            } else if (cCharAt == '0') {
                if (length == 1) {
                    this.d = false;
                    return;
                }
            } else if (cCharAt == '1' && length == 1) {
                this.d = true;
                return;
            }
            throw e(str);
        }

        @Override // n.b.a.n.d
        public void b(char[] cArr, int i2, int i3) throws IllegalArgumentException {
            int i4 = i3 - i2;
            char c = cArr[i2];
            if (c == 't') {
                if (i4 == 4 && cArr[i2 + 1] == 'r' && cArr[i2 + 2] == 'u' && cArr[i2 + 3] == 'e') {
                    this.d = true;
                    return;
                }
            } else if (c == 'f') {
                if (i4 == 5 && cArr[i2 + 1] == 'a' && cArr[i2 + 2] == 'l' && cArr[i2 + 3] == 's' && cArr[i2 + 4] == 'e') {
                    this.d = false;
                    return;
                }
            } else if (c == '0') {
                if (i4 == 1) {
                    this.d = false;
                    return;
                }
            } else if (c == '1' && i4 == 1) {
                this.d = true;
                return;
            }
            throw f(cArr, i2, i3);
        }

        @Override // n.b.a.m.o.e
        public String g() {
            return XmlErrorCodes.BOOLEAN;
        }

        public boolean t() {
            return this.d;
        }
    }

    public static final class b extends n.b.a.m.o.e {
        protected BigDecimal d;

        @Override // n.b.a.n.d
        public void a(String str) throws IllegalArgumentException {
            try {
                this.d = new BigDecimal(str);
            } catch (NumberFormatException unused) {
                throw e(str);
            }
        }

        @Override // n.b.a.n.d
        public void b(char[] cArr, int i2, int i3) throws IllegalArgumentException {
            int i4 = i3 - i2;
            try {
                this.d = new BigDecimal(new String(cArr, i2, i4));
            } catch (NumberFormatException unused) {
                throw e(new String(cArr, i2, i4));
            }
        }

        @Override // n.b.a.m.o.e
        public String g() {
            return XmlErrorCodes.DECIMAL;
        }

        public BigDecimal t() {
            return this.d;
        }
    }

    /* renamed from: n.b.a.m.o.d$d, reason: collision with other inner class name */
    public static final class C0018d extends n.b.a.m.o.e {
        protected double d;

        @Override // n.b.a.n.d
        public void a(String str) throws IllegalArgumentException {
            int length = str.length();
            if (length == 3) {
                char cCharAt = str.charAt(0);
                if (cCharAt == 'I') {
                    if (str.charAt(1) == 'N' && str.charAt(2) == 'F') {
                        this.d = Double.POSITIVE_INFINITY;
                        return;
                    }
                } else if (cCharAt == 'N' && str.charAt(1) == 'a' && str.charAt(2) == 'N') {
                    this.d = Double.NaN;
                    return;
                }
            } else if (length == 4 && str.charAt(0) == '-' && str.charAt(1) == 'I' && str.charAt(2) == 'N' && str.charAt(3) == 'F') {
                this.d = Double.NEGATIVE_INFINITY;
                return;
            }
            try {
                this.d = Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                throw e(str);
            }
        }

        @Override // n.b.a.n.d
        public void b(char[] cArr, int i2, int i3) throws IllegalArgumentException {
            int i4 = i3 - i2;
            if (i4 == 3) {
                char c = cArr[i2];
                if (c == 'I') {
                    if (cArr[i2 + 1] == 'N' && cArr[i2 + 2] == 'F') {
                        this.d = Double.POSITIVE_INFINITY;
                        return;
                    }
                } else if (c == 'N' && cArr[i2 + 1] == 'a' && cArr[i2 + 2] == 'N') {
                    this.d = Double.NaN;
                    return;
                }
            } else if (i4 == 4 && cArr[i2] == '-' && cArr[i2 + 1] == 'I' && cArr[i2 + 2] == 'N' && cArr[i2 + 3] == 'F') {
                this.d = Double.NEGATIVE_INFINITY;
                return;
            }
            String str = new String(cArr, i2, i4);
            try {
                this.d = Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                throw e(str);
            }
        }

        @Override // n.b.a.m.o.e
        public String g() {
            return XmlErrorCodes.DOUBLE;
        }

        public double t() {
            return this.d;
        }
    }

    public static final class f extends n.b.a.m.o.e {
        protected float d;

        @Override // n.b.a.n.d
        public void a(String str) throws IllegalArgumentException {
            int length = str.length();
            if (length == 3) {
                char cCharAt = str.charAt(0);
                if (cCharAt == 'I') {
                    if (str.charAt(1) == 'N' && str.charAt(2) == 'F') {
                        this.d = Float.POSITIVE_INFINITY;
                        return;
                    }
                } else if (cCharAt == 'N' && str.charAt(1) == 'a' && str.charAt(2) == 'N') {
                    this.d = Float.NaN;
                    return;
                }
            } else if (length == 4 && str.charAt(0) == '-' && str.charAt(1) == 'I' && str.charAt(2) == 'N' && str.charAt(3) == 'F') {
                this.d = Float.NEGATIVE_INFINITY;
                return;
            }
            try {
                this.d = Float.parseFloat(str);
            } catch (NumberFormatException unused) {
                throw e(str);
            }
        }

        @Override // n.b.a.n.d
        public void b(char[] cArr, int i2, int i3) throws IllegalArgumentException {
            int i4 = i3 - i2;
            if (i4 == 3) {
                char c = cArr[i2];
                if (c == 'I') {
                    if (cArr[i2 + 1] == 'N' && cArr[i2 + 2] == 'F') {
                        this.d = Float.POSITIVE_INFINITY;
                        return;
                    }
                } else if (c == 'N' && cArr[i2 + 1] == 'a' && cArr[i2 + 2] == 'N') {
                    this.d = Float.NaN;
                    return;
                }
            } else if (i4 == 4 && cArr[i2] == '-' && cArr[i2 + 1] == 'I' && cArr[i2 + 2] == 'N' && cArr[i2 + 3] == 'F') {
                this.d = Float.NEGATIVE_INFINITY;
                return;
            }
            String str = new String(cArr, i2, i4);
            try {
                this.d = Float.parseFloat(str);
            } catch (NumberFormatException unused) {
                throw e(str);
            }
        }

        @Override // n.b.a.m.o.e
        public String g() {
            return XmlErrorCodes.FLOAT;
        }

        public float t() {
            return this.d;
        }
    }

    public static final class h extends n.b.a.m.o.e {
        protected int d;

        @Override // n.b.a.n.d
        public void a(String str) throws IllegalArgumentException {
            int length = str.length();
            char cCharAt = str.charAt(0);
            boolean z = cCharAt == '-';
            int iP = (z || cCharAt == '+') ? p(str, cCharAt, true, length) : p(str, cCharAt, false, length);
            int i2 = this.a;
            int i3 = length - i2;
            if (i3 == 0) {
                if (z) {
                    iP = -iP;
                }
                this.d = iP;
                return;
            }
            r(str, i2, length);
            if (i3 <= 8) {
                int iJ = n.b.a.m.o.e.j(iP, str, i2, i3 + i2);
                if (z) {
                    iJ = -iJ;
                }
                this.d = iJ;
                return;
            }
            if (i3 == 9 && iP < 3) {
                long jL = (iP == 2 ? 2000000000L : 1000000000L) + n.b.a.m.o.e.l(str, i2, i3 + i2);
                if (z) {
                    long j2 = -jL;
                    if (j2 >= -2147483648L) {
                        this.d = (int) j2;
                        return;
                    }
                } else if (jL <= 2147483647L) {
                    this.d = (int) jL;
                    return;
                }
            }
            throw new IllegalArgumentException("value \"" + h(str) + "\" not a valid 32-bit integer: overflow.");
        }

        @Override // n.b.a.n.d
        public void b(char[] cArr, int i2, int i3) throws IllegalArgumentException {
            char c = cArr[i2];
            boolean z = c == '-';
            int iQ = (z || c == '+') ? q(cArr, c, true, i2, i3) : q(cArr, c, false, i2, i3);
            int i4 = this.a;
            int i5 = i3 - i4;
            if (i5 == 0) {
                if (z) {
                    iQ = -iQ;
                }
                this.d = iQ;
                return;
            }
            s(cArr, i2, i3, i4);
            if (i5 <= 8) {
                int iK = n.b.a.m.o.e.k(iQ, cArr, i4, i5 + i4);
                if (z) {
                    iK = -iK;
                }
                this.d = iK;
                return;
            }
            if (i5 == 9 && iQ < 3) {
                long jM = (iQ == 2 ? 2000000000L : 1000000000L) + n.b.a.m.o.e.m(cArr, i4, i5 + i4);
                if (z) {
                    long j2 = -jM;
                    if (j2 >= -2147483648L) {
                        this.d = (int) j2;
                        return;
                    }
                } else if (jM <= 2147483647L) {
                    this.d = (int) jM;
                    return;
                }
            }
            throw new IllegalArgumentException("value \"" + i(cArr, i2, i3) + "\" not a valid 32-bit integer: overflow.");
        }

        @Override // n.b.a.m.o.e
        public String g() {
            return XmlErrorCodes.INT;
        }

        public int t() {
            return this.d;
        }
    }

    public static final class i extends n.b.a.m.o.e {
        protected BigInteger d;

        @Override // n.b.a.n.d
        public void a(String str) throws IllegalArgumentException {
            try {
                this.d = new BigInteger(str);
            } catch (NumberFormatException unused) {
                throw e(str);
            }
        }

        @Override // n.b.a.n.d
        public void b(char[] cArr, int i2, int i3) throws IllegalArgumentException {
            String str = new String(cArr, i2, i3 - i2);
            try {
                this.d = new BigInteger(str);
            } catch (NumberFormatException unused) {
                throw e(str);
            }
        }

        @Override // n.b.a.m.o.e
        public String g() {
            return XmlErrorCodes.INTEGER;
        }

        public BigInteger t() {
            return this.d;
        }
    }

    public static final class k extends n.b.a.m.o.e {
        protected long d;

        private long u(String str, boolean z) {
            BigInteger bigInteger = new BigInteger(str);
            if (z) {
                BigInteger bigIntegerNegate = bigInteger.negate();
                if (bigIntegerNegate.compareTo(n.b.a.m.o.e.b) >= 0) {
                    return bigIntegerNegate.longValue();
                }
            } else if (bigInteger.compareTo(n.b.a.m.o.e.c) <= 0) {
                return bigInteger.longValue();
            }
            throw new IllegalArgumentException("value \"" + h(str) + "\" not a valid long: overflow.");
        }

        @Override // n.b.a.n.d
        public void a(String str) throws IllegalArgumentException {
            int length = str.length();
            char cCharAt = str.charAt(0);
            boolean z = cCharAt == '-';
            int iP = (z || cCharAt == '+') ? p(str, cCharAt, true, length) : p(str, cCharAt, false, length);
            int i2 = this.a;
            int i3 = length - i2;
            if (i3 == 0) {
                if (z) {
                    iP = -iP;
                }
                this.d = iP;
                return;
            }
            r(str, i2, length);
            if (i3 <= 8) {
                int iJ = n.b.a.m.o.e.j(iP, str, i2, i3 + i2);
                if (z) {
                    iJ = -iJ;
                }
                this.d = iJ;
                return;
            }
            int i4 = i2 - 1;
            int i5 = i3 + 1;
            if (i5 > 18) {
                this.d = u(str.substring(i4, i5 + i4), z);
                return;
            }
            long jN = n.b.a.m.o.e.n(str, i4, i5 + i4);
            if (z) {
                jN = -jN;
            }
            this.d = jN;
        }

        @Override // n.b.a.n.d
        public void b(char[] cArr, int i2, int i3) throws IllegalArgumentException {
            char c = cArr[i2];
            boolean z = c == '-';
            int iQ = (z || c == '+') ? q(cArr, c, true, i2, i3) : q(cArr, c, false, i2, i3);
            int i4 = this.a;
            int i5 = i3 - i4;
            if (i5 == 0) {
                if (z) {
                    iQ = -iQ;
                }
                this.d = iQ;
                return;
            }
            s(cArr, i2, i3, i4);
            if (i5 <= 8) {
                int iK = n.b.a.m.o.e.k(iQ, cArr, i4, i5 + i4);
                if (z) {
                    iK = -iK;
                }
                this.d = iK;
                return;
            }
            int i6 = i4 - 1;
            int i7 = i5 + 1;
            if (i7 > 18) {
                this.d = u(new String(cArr, i6, i7), z);
                return;
            }
            long jO = n.b.a.m.o.e.o(cArr, i6, i7 + i6);
            if (z) {
                jO = -jO;
            }
            this.d = jO;
        }

        @Override // n.b.a.m.o.e
        public String g() {
            return XmlErrorCodes.LONG;
        }

        public long t() {
            return this.d;
        }
    }

    public static final class l extends n.b.a.m.o.e {
        final NamespaceContext d;
        protected QName e;

        public l(NamespaceContext namespaceContext) {
            this.d = namespaceContext;
        }

        @Override // n.b.a.n.d
        public void a(String str) throws IllegalArgumentException {
            int iIndexOf = str.indexOf(58);
            if (iIndexOf >= 0) {
                this.e = v(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            } else {
                this.e = u(str);
            }
        }

        @Override // n.b.a.n.d
        public void b(char[] cArr, int i2, int i3) throws IllegalArgumentException {
            for (int i4 = i2; i4 < i3; i4++) {
                if (cArr[i4] == ':') {
                    this.e = v(new String(cArr, i2, i4 - i2), new String(cArr, i4 + 1, (i3 - i4) - 1));
                    return;
                }
            }
            this.e = u(new String(cArr, i2, i3 - i2));
        }

        @Override // n.b.a.m.o.e
        public String g() {
            return XmlErrorCodes.QNAME;
        }

        public QName t() {
            return this.e;
        }

        protected QName u(String str) throws IllegalArgumentException {
            String namespaceURI = this.d.getNamespaceURI("");
            return new QName(namespaceURI != null ? namespaceURI : "", str);
        }

        protected QName v(String str, String str2) throws IllegalArgumentException {
            if (str.length() == 0 || str2.length() == 0) {
                throw e(str + ParameterizedMessage.ERROR_MSG_SEPARATOR + str2);
            }
            String namespaceURI = this.d.getNamespaceURI(str);
            if (namespaceURI != null && namespaceURI.length() != 0) {
                return new QName(namespaceURI, str2, str);
            }
            throw new IllegalArgumentException("Value \"" + h(str + ParameterizedMessage.ERROR_MSG_SEPARATOR + str2) + "\" not a valid QName: prefix '" + str + "' not bound to a namespace");
        }
    }

    public a a() {
        if (this.a == null) {
            this.a = new a();
        }
        return this.a;
    }

    public b b() {
        return new b();
    }

    public c c() {
        return new c(e());
    }

    public c d(double[] dArr, int i2, int i3) {
        return new c(dArr, i2, i3, e());
    }

    public C0018d e() {
        if (this.e == null) {
            this.e = new C0018d();
        }
        return this.e;
    }

    public e f() {
        return new e(h());
    }

    public e g(float[] fArr, int i2, int i3) {
        return new e(fArr, i2, i3, h());
    }

    public f h() {
        if (this.d == null) {
            this.d = new f();
        }
        return this.d;
    }

    public g i() {
        return new g(k());
    }

    public g j(int[] iArr, int i2, int i3) {
        return new g(iArr, i2, i3, k());
    }

    public h k() {
        if (this.b == null) {
            this.b = new h();
        }
        return this.b;
    }

    public i l() {
        return new i();
    }

    public j m() {
        return new j(o());
    }

    public j n(long[] jArr, int i2, int i3) {
        return new j(jArr, i2, i3, o());
    }

    public k o() {
        if (this.c == null) {
            this.c = new k();
        }
        return this.c;
    }

    public l p(NamespaceContext namespaceContext) {
        return new l(namespaceContext);
    }

    public static final class c extends n.b.a.m.o.c {
        double[] d;
        final C0018d e;

        public c(double[] dArr, int i2, int i3, C0018d c0018d) {
            super(i2, i3);
            this.d = dArr;
            this.e = c0018d;
        }

        @Override // n.b.a.n.c
        public boolean a(char[] cArr, int i2, int i3) throws IllegalArgumentException {
            this.e.b(cArr, i2, i3);
            this.d[this.a + this.c] = this.e.t();
            int i4 = this.c + 1;
            this.c = i4;
            return i4 >= this.b;
        }

        @Override // n.b.a.m.o.c
        public void d() {
            double[] dArr = this.d;
            int length = dArr.length;
            int iC = c(length);
            double[] dArr2 = new double[iC];
            this.d = dArr2;
            System.arraycopy(dArr, this.a, dArr2, 0, length);
            this.a = 0;
            this.b = iC;
        }

        public double[] e() {
            int i2 = this.c;
            double[] dArr = new double[i2];
            System.arraycopy(this.d, this.a, dArr, 0, i2);
            return dArr;
        }

        public c(C0018d c0018d) {
            super(0, 40);
            this.d = new double[40];
            this.e = c0018d;
        }
    }

    public static final class e extends n.b.a.m.o.c {
        float[] d;
        final f e;

        public e(float[] fArr, int i2, int i3, f fVar) {
            super(i2, i3);
            this.d = fArr;
            this.e = fVar;
        }

        @Override // n.b.a.n.c
        public boolean a(char[] cArr, int i2, int i3) throws IllegalArgumentException {
            this.e.b(cArr, i2, i3);
            this.d[this.a + this.c] = this.e.t();
            int i4 = this.c + 1;
            this.c = i4;
            return i4 >= this.b;
        }

        @Override // n.b.a.m.o.c
        public void d() {
            float[] fArr = this.d;
            int length = fArr.length;
            int iC = c(length);
            float[] fArr2 = new float[iC];
            this.d = fArr2;
            System.arraycopy(fArr, this.a, fArr2, 0, length);
            this.a = 0;
            this.b = iC;
        }

        public float[] e() {
            int i2 = this.c;
            float[] fArr = new float[i2];
            System.arraycopy(this.d, this.a, fArr, 0, i2);
            return fArr;
        }

        public e(f fVar) {
            super(0, 40);
            this.d = new float[40];
            this.e = fVar;
        }
    }

    public static final class g extends n.b.a.m.o.c {
        int[] d;
        final h e;

        public g(int[] iArr, int i2, int i3, h hVar) {
            super(i2, i3);
            this.d = iArr;
            this.e = hVar;
        }

        @Override // n.b.a.n.c
        public boolean a(char[] cArr, int i2, int i3) throws IllegalArgumentException {
            this.e.b(cArr, i2, i3);
            this.d[this.a + this.c] = this.e.t();
            int i4 = this.c + 1;
            this.c = i4;
            return i4 >= this.b;
        }

        @Override // n.b.a.m.o.c
        public void d() {
            int[] iArr = this.d;
            int length = iArr.length;
            int iC = c(length);
            int[] iArr2 = new int[iC];
            this.d = iArr2;
            System.arraycopy(iArr, this.a, iArr2, 0, length);
            this.a = 0;
            this.b = iC;
        }

        public int[] e() {
            int i2 = this.c;
            int[] iArr = new int[i2];
            System.arraycopy(this.d, this.a, iArr, 0, i2);
            return iArr;
        }

        public g(h hVar) {
            super(0, 40);
            this.d = new int[40];
            this.e = hVar;
        }
    }

    public static final class j extends n.b.a.m.o.c {
        long[] d;
        final k e;

        public j(long[] jArr, int i2, int i3, k kVar) {
            super(i2, i3);
            this.d = jArr;
            this.e = kVar;
        }

        @Override // n.b.a.n.c
        public boolean a(char[] cArr, int i2, int i3) throws IllegalArgumentException {
            this.e.b(cArr, i2, i3);
            this.d[this.a + this.c] = this.e.t();
            int i4 = this.c + 1;
            this.c = i4;
            return i4 >= this.b;
        }

        @Override // n.b.a.m.o.c
        public void d() {
            long[] jArr = this.d;
            int length = jArr.length;
            int iC = c(length);
            long[] jArr2 = new long[iC];
            this.d = jArr2;
            System.arraycopy(jArr, this.a, jArr2, 0, length);
            this.a = 0;
            this.b = iC;
        }

        public long[] e() {
            int i2 = this.c;
            long[] jArr = new long[i2];
            System.arraycopy(this.d, this.a, jArr, 0, i2);
            return jArr;
        }

        public j(k kVar) {
            super(0, 40);
            this.d = new long[40];
            this.e = kVar;
        }
    }
}
