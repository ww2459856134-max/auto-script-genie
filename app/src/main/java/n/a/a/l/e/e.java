package n.a.a.l.e;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import n.a.a.o.i1;
import n.a.a.o.m0;
import n.a.a.o.x0;

/* loaded from: classes.dex */
public abstract class e implements a {
    private int A;
    private String c;
    private i1 d;
    private m0 e;
    private m0 f;
    private x0 g;

    /* renamed from: h, reason: collision with root package name */
    private x0 f2321h;

    /* renamed from: i, reason: collision with root package name */
    private x0 f2322i;

    /* renamed from: j, reason: collision with root package name */
    private x0 f2323j;

    /* renamed from: k, reason: collision with root package name */
    private x0 f2324k;
    private byte[] t;

    protected e() throws ArrayIndexOutOfBoundsException {
        byte[] bArr = new byte[128];
        this.t = bArr;
        Arrays.fill(bArr, (byte) 0);
        this.d = new i1(64);
        this.e = new m0(66);
        this.f = new m0(67);
        this.g = new x0(68, -1, this.t);
        this.f2321h = new x0(72, -1, this.t);
        this.f2322i = new x0(76, -1, this.t);
        new n.a.a.f.b(this.t, 80);
        new x0(96, 0, this.t);
        new x0(100, 0, this.t);
        new x0(104, 0, this.t);
        new x0(108, 0, this.t);
        new x0(112, 0, this.t);
        this.f2323j = new x0(116);
        this.f2324k = new x0(120, 0, this.t);
        this.A = -1;
        p("");
        r(null);
        u(null);
    }

    public void A(n.a.a.f.b bVar) throws ArrayStoreException {
        if (bVar == null) {
            Arrays.fill(this.t, 80, 96, (byte) 0);
        } else {
            bVar.d(this.t, 80);
        }
    }

    public void C(OutputStream outputStream) throws IOException {
        outputStream.write(this.t);
    }

    protected int a() {
        return this.A;
    }

    public String b() {
        return this.c;
    }

    public int e() {
        return this.f2324k.a();
    }

    public int g() {
        return this.f2323j.a();
    }

    public abstract boolean h();

    protected abstract void j();

    protected void k(int i2) throws ArrayIndexOutOfBoundsException {
        this.f2322i.b(i2, this.t);
    }

    protected void l(int i2) {
        this.A = i2;
    }

    protected void p(String str) throws ArrayIndexOutOfBoundsException {
        char[] charArray = str.toCharArray();
        int iMin = Math.min(charArray.length, 31);
        this.c = new String(charArray, 0, iMin);
        int i2 = 0;
        short s = 0;
        while (i2 < iMin) {
            new i1(s, (short) charArray[i2], this.t);
            s = (short) (s + 2);
            i2++;
        }
        while (i2 < 32) {
            new i1(s, (short) 0, this.t);
            s = (short) (s + 2);
            i2++;
        }
        this.d.a((short) ((iMin + 1) * 2), this.t);
    }

    public void r(a aVar) throws ArrayIndexOutOfBoundsException {
        this.f2321h.b(aVar == null ? -1 : ((e) aVar).a(), this.t);
    }

    protected void t(byte b) throws ArrayIndexOutOfBoundsException {
        this.f.b(b, this.t);
    }

    public void u(a aVar) throws ArrayIndexOutOfBoundsException {
        this.g.b(aVar == null ? -1 : ((e) aVar).a(), this.t);
    }

    protected void v(byte b) throws ArrayIndexOutOfBoundsException {
        this.e.b(b, this.t);
    }

    protected void w(int i2) throws ArrayIndexOutOfBoundsException {
        this.f2324k.b(i2, this.t);
    }

    public void z(int i2) throws ArrayIndexOutOfBoundsException {
        this.f2323j.b(i2, this.t);
    }
}
