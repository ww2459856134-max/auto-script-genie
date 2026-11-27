package com.google.gson.l0;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class d implements Closeable, Flushable {
    private static final String[] C;
    private final Writer c;
    private int[] d = new int[32];
    private int e = 0;
    private String f;
    private String g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f767h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f768i;

    /* renamed from: j, reason: collision with root package name */
    private String f769j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f770k;
    private static final Pattern t = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] A = new String[128];

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            A[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = A;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        C = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public d(Writer writer) {
        z(6);
        this.g = ParameterizedMessage.ERROR_MSG_SEPARATOR;
        this.f770k = true;
        Objects.requireNonNull(writer, "out == null");
        this.c = writer;
    }

    private void B(int i2) {
        this.d[this.e - 1] = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void I(String str) throws IOException {
        String str2;
        String[] strArr = this.f768i ? C : A;
        this.c.write(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i2 < i3) {
                        this.c.write(str, i2, i3 - i2);
                    }
                    this.c.write(str2);
                    i2 = i3 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i3) {
                }
                this.c.write(str2);
                i2 = i3 + 1;
            }
        }
        if (i2 < length) {
            this.c.write(str, i2, length - i2);
        }
        this.c.write(34);
    }

    private void P() throws IOException {
        if (this.f769j != null) {
            a();
            I(this.f769j);
            this.f769j = null;
        }
    }

    private void a() throws IOException {
        int iY = y();
        if (iY == 5) {
            this.c.write(44);
        } else if (iY != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        u();
        B(4);
    }

    private void c() throws IOException {
        int iY = y();
        if (iY == 1) {
            B(2);
            u();
            return;
        }
        if (iY == 2) {
            this.c.append(',');
            u();
        } else {
            if (iY == 4) {
                this.c.append((CharSequence) this.g);
                B(5);
                return;
            }
            if (iY != 6) {
                if (iY != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f767h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            B(7);
        }
    }

    private d i(int i2, int i3, char c) throws IOException {
        int iY = y();
        if (iY != i3 && iY != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f769j != null) {
            throw new IllegalStateException("Dangling name: " + this.f769j);
        }
        this.e--;
        if (iY == i3) {
            u();
        }
        this.c.write(c);
        return this;
    }

    private static boolean q(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    private void u() throws IOException {
        if (this.f == null) {
            return;
        }
        this.c.write(10);
        int i2 = this.e;
        for (int i3 = 1; i3 < i2; i3++) {
            this.c.write(this.f);
        }
    }

    private d x(int i2, char c) throws IOException {
        c();
        z(i2);
        this.c.write(c);
        return this;
    }

    private int y() {
        int i2 = this.e;
        if (i2 != 0) {
            return this.d[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void z(int i2) {
        int i3 = this.e;
        int[] iArr = this.d;
        if (i3 == iArr.length) {
            this.d = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.d;
        int i4 = this.e;
        this.e = i4 + 1;
        iArr2[i4] = i2;
    }

    public final void D(boolean z) {
        this.f768i = z;
    }

    public final void F(String str) {
        if (str.length() == 0) {
            this.f = null;
            this.g = ParameterizedMessage.ERROR_MSG_SEPARATOR;
        } else {
            this.f = str;
            this.g = ": ";
        }
    }

    public final void G(boolean z) {
        this.f767h = z;
    }

    public final void H(boolean z) {
        this.f770k = z;
    }

    public d J(double d) throws IOException {
        P();
        if (this.f767h || !(Double.isNaN(d) || Double.isInfinite(d))) {
            c();
            this.c.append((CharSequence) Double.toString(d));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
    }

    public d K(long j2) throws IOException {
        P();
        c();
        this.c.write(Long.toString(j2));
        return this;
    }

    public d L(Boolean bool) throws IOException {
        if (bool == null) {
            return w();
        }
        P();
        c();
        this.c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public d M(Number number) throws IOException {
        if (number == null) {
            return w();
        }
        P();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!q(cls) && !t.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f767h) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
        }
        c();
        this.c.append((CharSequence) string);
        return this;
    }

    public d N(String str) throws IOException {
        if (str == null) {
            return w();
        }
        P();
        c();
        I(str);
        return this;
    }

    public d O(boolean z) throws IOException {
        P();
        c();
        this.c.write(z ? "true" : "false");
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
        int i2 = this.e;
        if (i2 > 1 || (i2 == 1 && this.d[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.e = 0;
    }

    public d d() throws IOException {
        P();
        x(1, '[');
        return this;
    }

    public d f() throws IOException {
        P();
        x(3, '{');
        return this;
    }

    public void flush() throws IOException {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.c.flush();
    }

    public d j() throws IOException {
        i(1, 2, ']');
        return this;
    }

    public d m() throws IOException {
        i(3, 5, '}');
        return this;
    }

    public final boolean n() {
        return this.f770k;
    }

    public final boolean o() {
        return this.f768i;
    }

    public boolean p() {
        return this.f767h;
    }

    public d s(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f769j != null) {
            throw new IllegalStateException();
        }
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f769j = str;
        return this;
    }

    public d w() throws IOException {
        if (this.f769j != null) {
            if (!this.f770k) {
                this.f769j = null;
                return this;
            }
            P();
        }
        c();
        this.c.write("null");
        return this;
    }
}
