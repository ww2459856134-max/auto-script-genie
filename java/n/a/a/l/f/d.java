package n.a.a.l.f;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import n.a.a.o.b1;
import n.a.a.o.i1;
import n.a.a.o.x0;
import n.a.a.o.y0;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public final class d {
    private final n.a.a.l.a.a a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2325h;

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f2326i;

    public d(n.a.a.l.a.a aVar) {
        this.a = aVar;
        byte[] bArr = new byte[512];
        this.f2326i = bArr;
        Arrays.fill(bArr, (byte) -1);
        new b1(0, -2226271756974174256L, bArr);
        new x0(8, 0, bArr);
        new x0(12, 0, bArr);
        new x0(16, 0, bArr);
        new x0(20, 0, bArr);
        new i1(24, (short) 59, bArr);
        new i1(26, (short) 3, bArr);
        new i1(28, (short) -2, bArr);
        new i1(30, aVar.c(), bArr);
        new x0(32, 6, bArr);
        new x0(36, 0, bArr);
        new x0(40, 0, bArr);
        new x0(52, 0, bArr);
        new x0(56, XMLEvent.CHANGE_PREFIX_MAPPING, bArr);
        this.b = 0;
        this.f = 0;
        this.f2325h = 0;
        this.d = -2;
        this.e = -2;
        this.g = -2;
    }

    public int[] a() {
        int iMin = Math.min(this.b, 109);
        int[] iArr = new int[iMin];
        int i2 = 76;
        for (int i3 = 0; i3 < iMin; i3++) {
            iArr[i3] = y0.a(this.f2326i, i2);
            i2 += 4;
        }
        return iArr;
    }

    public int b() {
        return this.b;
    }

    public n.a.a.l.a.a c() {
        return this.a;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.e;
    }

    public void g(int[] iArr) {
        int iMin = Math.min(iArr.length, 109);
        int i2 = 109 - iMin;
        int i3 = 76;
        for (int i4 = 0; i4 < iMin; i4++) {
            y0.b(this.f2326i, i3, iArr[i4]);
            i3 += 4;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            y0.b(this.f2326i, i3, -1);
            i3 += 4;
        }
    }

    public void h(int i2) {
        this.b = i2;
    }

    public void i(int i2) {
        this.c = i2;
    }

    public void j(int i2) {
        this.d = i2;
    }

    public void k(int i2) {
        this.f = i2;
    }

    public void l(int i2) {
        this.e = i2;
    }

    public void m(int i2) {
        this.f2325h = i2;
    }

    public void n(int i2) {
        this.g = i2;
    }

    public void o(OutputStream outputStream) throws IOException {
        new x0(44, this.b, this.f2326i);
        new x0(40, this.a.b() == 512 ? 0 : this.c, this.f2326i);
        new x0(48, this.d, this.f2326i);
        new x0(60, this.e, this.f2326i);
        new x0(64, this.f, this.f2326i);
        new x0(68, this.g, this.f2326i);
        new x0(72, this.f2325h, this.f2326i);
        outputStream.write(this.f2326i, 0, 512);
        for (int i2 = 512; i2 < this.a.b(); i2++) {
            outputStream.write(0);
        }
    }
}
