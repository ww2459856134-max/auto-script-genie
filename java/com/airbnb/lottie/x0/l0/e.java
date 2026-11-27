package com.airbnb.lottie.x0.l0;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class e implements Closeable {

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f557i = new String[128];
    int c;
    int[] d = new int[32];
    String[] e = new String[32];
    int[] f = new int[32];
    boolean g;

    /* renamed from: h, reason: collision with root package name */
    boolean f558h;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f557i[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f557i;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void D(m.b bVar, String str) throws IOException {
        String str2;
        String[] strArr = f557i;
        bVar.writeByte(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i2 < i3) {
                        bVar.g(str, i2, i3);
                    }
                    bVar.t(str2);
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
                bVar.t(str2);
                i2 = i3 + 1;
            }
        }
        if (i2 < length) {
            bVar.g(str, i2, length);
        }
        bVar.writeByte(34);
    }

    public static e u(m.c cVar) {
        return new g(cVar);
    }

    public abstract void B() throws IOException;

    final b F(String str) throws b {
        throw new b(str + " at path " + j());
    }

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract void f() throws IOException;

    public abstract void i() throws IOException;

    public final String j() {
        return f.a(this.c, this.d, this.e, this.f);
    }

    public abstract boolean m() throws IOException;

    public abstract boolean n() throws IOException;

    public abstract double o() throws IOException;

    public abstract int p() throws IOException;

    public abstract String q() throws IOException;

    public abstract String s() throws IOException;

    public abstract d w() throws IOException;

    final void x(int i2) {
        int i3 = this.c;
        int[] iArr = this.d;
        if (i3 == iArr.length) {
            if (i3 == 256) {
                throw new a("Nesting too deep at " + j());
            }
            this.d = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.e;
            this.e = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f;
            this.f = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.d;
        int i4 = this.c;
        this.c = i4 + 1;
        iArr3[i4] = i2;
    }

    public abstract int y(c cVar) throws IOException;

    public abstract void z() throws IOException;
}
