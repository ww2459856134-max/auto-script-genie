package i.b.ha.a.b.d.c;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.zip.Deflater;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class w1 extends i.b.ha.a.b.d.b<o1> {
    static final Charset Z = StandardCharsets.UTF_8;
    private static final byte[] a0 = {0, 0};
    private static final byte[] b0 = {0, 0, 0, 0};
    private static final byte[] c0 = j2.b(1);
    static final byte[] d0 = j2.e.a();
    static final byte[] e0 = j2.f.a();
    static final byte[] f0 = j2.d.a();
    static final byte[] g0 = j2.b(101010256);
    static final byte[] h0 = j2.b(101075792);
    static final byte[] i0 = j2.b(117853008);
    private final o0 A;
    private long C;
    private long D;
    private long G;
    private long H;
    protected final Deflater K;
    private boolean O;
    private boolean Q;
    private final boolean V;

    @Deprecated
    protected boolean f;
    private t1 g;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1447j;

    /* renamed from: h, reason: collision with root package name */
    private String f1445h = "";

    /* renamed from: i, reason: collision with root package name */
    private int f1446i = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f1448k = 8;
    private final List<o1> t = new LinkedList();
    private final Map<o1, u1> I = new HashMap();
    private y1 J = z1.b(Z);
    private boolean M = true;
    private v1 P = v1.c;
    private g1 U = g1.AsNeeded;
    private final Map<Integer, Integer> W = new HashMap();

    public w1(OutputStream outputStream) {
        ((FilterOutputStream) this).out = outputStream;
        Deflater deflater = new Deflater(this.f1446i, true);
        this.K = deflater;
        this.A = o0.a(outputStream, deflater);
        this.V = false;
    }

    private void B(o1 o1Var, long j2, boolean z) {
        g1 g1Var;
        if (z) {
            f1 f1VarY = y(o1Var);
            if (o1Var.getCompressedSize() >= 4294967295L || o1Var.getSize() >= 4294967295L || (g1Var = this.U) == g1.Always || g1Var == g1.AlwaysWithCompatibility) {
                f1VarY.n(new x1(o1Var.getCompressedSize()));
                f1VarY.q(new x1(o1Var.getSize()));
            } else {
                f1VarY.n(null);
                f1VarY.q(null);
            }
            boolean z2 = j2 >= 4294967295L || this.U == g1.Always;
            boolean z3 = o1Var.s() >= 65535 || this.U == g1.Always;
            if (z2 || z3) {
                f1VarY.p(new x1(j2));
            }
            if (z3) {
                f1VarY.o(new j2(o1Var.s()));
            }
            o1Var.U();
        }
    }

    private boolean D(o1 o1Var) {
        return o1Var.w(f1.f1410h) instanceof f1;
    }

    private boolean F(o1 o1Var) {
        return o1Var.getSize() >= 4294967295L || o1Var.getCompressedSize() >= 4294967295L;
    }

    private boolean G(o1 o1Var, g1 g1Var) {
        return g1Var == g1.Always || g1Var == g1.AlwaysWithCompatibility || F(o1Var);
    }

    private void I() throws IOException {
        if (this.f) {
            throw new IOException("Stream has already been finished");
        }
        t1 t1Var = this.g;
        if (t1Var == null) {
            throw new IOException("No current entry to close");
        }
        if (t1Var.f) {
            return;
        }
        write(i.b.ha.a.b.f.e.a, 0, 0);
    }

    private void K(o1 o1Var, boolean z) throws IOException {
        x1 x1Var;
        x1 x1Var2;
        if (this.f) {
            throw new IOException("Stream has already been finished");
        }
        if (this.g != null) {
            f();
        }
        t1 t1Var = new t1(o1Var);
        this.g = t1Var;
        this.t.add(t1Var.a);
        L(this.g.a);
        g1 g1VarS = s(this.g.a);
        Q(g1VarS);
        if (M(this.g.a, g1VarS)) {
            f1 f1VarY = y(this.g.a);
            if (z) {
                x1Var = new x1(this.g.a.getSize());
                x1Var2 = new x1(this.g.a.getCompressedSize());
            } else {
                x1Var = (this.g.a.getMethod() != 0 || this.g.a.getSize() == -1) ? x1.d : new x1(this.g.a.getSize());
                x1Var2 = x1Var;
            }
            f1VarY.q(x1Var);
            f1VarY.n(x1Var2);
            this.g.a.U();
        }
        if (this.g.a.getMethod() == 8 && this.f1447j) {
            this.K.setLevel(this.f1446i);
            this.f1447j = false;
        }
        X(o1Var, z);
    }

    private void L(o1 o1Var) {
        if (o1Var.getMethod() == -1) {
            o1Var.setMethod(this.f1448k);
        }
        if (o1Var.getTime() == -1) {
            o1Var.setTime(System.currentTimeMillis());
        }
    }

    private boolean M(o1 o1Var, g1 g1Var) {
        if (g1Var == g1.Always || g1Var == g1.AlwaysWithCompatibility || o1Var.getSize() >= 4294967295L || o1Var.getCompressedSize() >= 4294967295L) {
            return true;
        }
        int i2 = (o1Var.getSize() > (-1L) ? 1 : (o1Var.getSize() == (-1L) ? 0 : -1));
        return false;
    }

    private boolean N() {
        int iC = this.V ? ((m2) ((FilterOutputStream) this).out).c() : 0;
        return iC >= 65535 || this.G >= 65535 || this.W.getOrDefault(Integer.valueOf(iC), 0).intValue() >= 65535 || this.t.size() >= 65535 || this.D >= 4294967295L || this.C >= 4294967295L;
    }

    private boolean O(int i2, boolean z) {
        return !z && i2 == 8;
    }

    private void P() throws h1 {
        if (this.U != g1.Never) {
            return;
        }
        int iC = this.V ? ((m2) ((FilterOutputStream) this).out).c() : 0;
        if (iC >= 65535) {
            throw new h1("Number of the disk of End Of Central Directory exceeds the limit of 65535.");
        }
        if (this.G >= 65535) {
            throw new h1("Number of the disk with the start of Central Directory exceeds the limit of 65535.");
        }
        if (this.W.getOrDefault(Integer.valueOf(iC), 0).intValue() >= 65535) {
            throw new h1("Number of entries on this disk exceeds the limit of 65535.");
        }
        if (this.t.size() >= 65535) {
            throw new h1("Archive contains more than 65535 entries.");
        }
        if (this.D >= 4294967295L) {
            throw new h1("The size of the entire central directory exceeds the limit of 4GByte.");
        }
        if (this.C >= 4294967295L) {
            throw new h1("Archive's size exceeds the limit of 4GByte.");
        }
    }

    private void Q(g1 g1Var) throws ZipException {
        if (this.g.a.getMethod() == 0) {
            if (this.g.a.getSize() == -1) {
                throw new ZipException("Uncompressed size is required for STORED method when not writing to a file");
            }
            if (this.g.a.getCrc() == -1) {
                throw new ZipException("CRC checksum is required for STORED method when not writing to a file");
            }
            this.g.a.setCompressedSize(this.g.a.getSize());
        }
        if ((this.g.a.getSize() >= 4294967295L || this.g.a.getCompressedSize() >= 4294967295L) && g1Var == g1.Never) {
            throw new h1(h1.a(this.g.a));
        }
    }

    private int R(int i2, boolean z, boolean z2) {
        if (z) {
            return 45;
        }
        if (z2) {
            return 20;
        }
        return S(i2);
    }

    private int S(int i2) {
        return i2 == 8 ? 20 : 10;
    }

    private void U() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(70000);
        Iterator<o1> it = this.t.iterator();
        while (true) {
            int i2 = 0;
            while (it.hasNext()) {
                byteArrayOutputStream.write(j(it.next()));
                i2++;
                if (i2 > 1000) {
                    break;
                }
            }
            V(byteArrayOutputStream.toByteArray());
            return;
            V(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.reset();
        }
    }

    private void V(byte[] bArr) throws IOException {
        this.A.p(bArr);
    }

    private void X(o1 o1Var, boolean z) throws IOException {
        boolean zC = this.J.c(o1Var.getName());
        ByteBuffer byteBufferX = x(o1Var);
        if (this.P != v1.c) {
            c(o1Var, zC, byteBufferX);
        }
        long jM = this.A.m();
        if (this.V) {
            m2 m2Var = (m2) ((FilterOutputStream) this).out;
            o1Var.S(m2Var.c());
            jM = m2Var.a();
        }
        byte[] bArrN = n(o1Var, byteBufferX, zC, z, jM);
        this.I.put(o1Var, new u1(jM, O(o1Var.getMethod(), z)));
        this.g.b = jM + 14;
        V(bArrN);
        this.g.c = this.A.m();
    }

    private void c(o1 o1Var, boolean z, ByteBuffer byteBuffer) throws IOException {
        v1 v1Var = this.P;
        v1 v1Var2 = v1.b;
        if (v1Var == v1Var2 || !z) {
            o1Var.d(new q0(o1Var.getName(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position()));
        }
        String comment = o1Var.getComment();
        if (comment == null || comment.isEmpty()) {
            return;
        }
        boolean zC = this.J.c(comment);
        if (this.P == v1Var2 || !zC) {
            ByteBuffer byteBufferA = u(o1Var).a(comment);
            o1Var.d(new p0(comment, byteBufferA.array(), byteBufferA.arrayOffset(), byteBufferA.limit() - byteBufferA.position()));
        }
    }

    private boolean d(g1 g1Var) throws ZipException {
        boolean zG = G(this.g.a, g1Var);
        if (zG && g1Var == g1.Never) {
            throw new h1(h1.a(this.g.a));
        }
        return zG;
    }

    private void i(boolean z, boolean z2) throws IOException {
        if (!z2) {
            W(this.g.a);
        }
        this.g = null;
    }

    private byte[] j(o1 o1Var) throws IOException {
        g1 g1Var;
        u1 u1Var = this.I.get(o1Var);
        boolean z = D(o1Var) || o1Var.getCompressedSize() >= 4294967295L || o1Var.getSize() >= 4294967295L || u1Var.a >= 4294967295L || o1Var.s() >= 65535 || (g1Var = this.U) == g1.Always || g1Var == g1.AlwaysWithCompatibility;
        if (z && this.U == g1.Never) {
            throw new h1("Archive's size exceeds the limit of 4GByte.");
        }
        B(o1Var, u1Var.a, z);
        return m(o1Var, x(o1Var), u1Var, z);
    }

    private byte[] m(o1 o1Var, ByteBuffer byteBuffer, u1 u1Var, boolean z) throws IOException {
        byte[] bArr;
        g1 g1Var;
        if (this.V) {
            this.W.compute(Integer.valueOf(((m2) ((FilterOutputStream) this).out).c()), new BiFunction() { // from class: i.b.ha.a.b.d.c.l
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    Integer num = (Integer) obj2;
                    return Integer.valueOf(num != null ? 1 + num.intValue() : 1);
                }
            });
        }
        byte[] bArrP = o1Var.p();
        int length = bArrP.length;
        String comment = o1Var.getComment();
        if (comment == null) {
            comment = "";
        }
        ByteBuffer byteBufferA = u(o1Var).a(comment);
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        int iLimit2 = byteBufferA.limit() - byteBufferA.position();
        int i2 = iLimit + 46;
        int i3 = i2 + length;
        byte[] bArr2 = new byte[i3 + iLimit2];
        System.arraycopy(f0, 0, bArr2, 0, 4);
        l2.g((o1Var.F() << 8) | (!this.Q ? 20 : 45), bArr2, 4);
        int method = o1Var.getMethod();
        boolean zC = this.J.c(o1Var.getName());
        l2.g(R(method, z, u1Var.b), bArr2, 6);
        w(!zC && this.O, u1Var.b).a(bArr2, 8);
        l2.g(method, bArr2, 10);
        o2.o(o1Var.getTime(), bArr2, 12);
        j2.g(o1Var.getCrc(), bArr2, 16);
        if (o1Var.getCompressedSize() >= 4294967295L || o1Var.getSize() >= 4294967295L || (g1Var = this.U) == g1.Always || g1Var == g1.AlwaysWithCompatibility) {
            j2 j2Var = j2.g;
            j2Var.h(bArr2, 20);
            j2Var.h(bArr2, 24);
        } else {
            j2.g(o1Var.getCompressedSize(), bArr2, 20);
            j2.g(o1Var.getSize(), bArr2, 24);
        }
        l2.g(iLimit, bArr2, 28);
        l2.g(length, bArr2, 30);
        l2.g(iLimit2, bArr2, 32);
        if (!this.V) {
            System.arraycopy(a0, 0, bArr2, 34, 2);
        } else if (o1Var.s() >= 65535 || this.U == g1.Always) {
            l2.g(65535, bArr2, 34);
        } else {
            l2.g((int) o1Var.s(), bArr2, 34);
        }
        l2.g(o1Var.y(), bArr2, 36);
        j2.g(o1Var.u(), bArr2, 38);
        if (u1Var.a >= 4294967295L || this.U == g1.Always) {
            bArr = bArrP;
            j2.g(4294967295L, bArr2, 42);
        } else {
            bArr = bArrP;
            j2.g(Math.min(u1Var.a, 4294967295L), bArr2, 42);
        }
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr2, 46, iLimit);
        System.arraycopy(bArr, 0, bArr2, i2, length);
        System.arraycopy(byteBufferA.array(), byteBufferA.arrayOffset(), bArr2, i3, iLimit2);
        return bArr2;
    }

    private byte[] n(o1 o1Var, ByteBuffer byteBuffer, boolean z, boolean z2, long j2) {
        l2 l2Var = m0.f;
        a2 a2VarW = o1Var.w(l2Var);
        if (a2VarW != null) {
            o1Var.N(l2Var);
        }
        m0 m0Var = a2VarW instanceof m0 ? (m0) a2VarW : null;
        int iN = o1Var.n();
        if (iN <= 0 && m0Var != null) {
            iN = m0Var.i();
        }
        if (iN > 1 || (m0Var != null && !m0Var.h())) {
            o1Var.d(new m0(iN, m0Var != null && m0Var.h(), (int) (((((-j2) - (((byteBuffer.limit() + 30) - byteBuffer.position()) + o1Var.z().length)) - 4) - 2) & (iN - 1))));
        }
        byte[] bArrZ = o1Var.z();
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        int i2 = iLimit + 30;
        byte[] bArr = new byte[bArrZ.length + i2];
        System.arraycopy(d0, 0, bArr, 0, 4);
        int method = o1Var.getMethod();
        boolean zO = O(method, z2);
        l2.g(R(method, D(o1Var), zO), bArr, 4);
        w(!z && this.O, zO).a(bArr, 6);
        l2.g(method, bArr, 8);
        o2.o(o1Var.getTime(), bArr, 10);
        if (z2 || method != 8) {
            j2.g(o1Var.getCrc(), bArr, 14);
        } else {
            System.arraycopy(b0, 0, bArr, 14, 4);
        }
        if (D(this.g.a)) {
            j2 j2Var = j2.g;
            j2Var.h(bArr, 18);
            j2Var.h(bArr, 22);
        } else if (z2) {
            j2.g(o1Var.getCompressedSize(), bArr, 18);
            j2.g(o1Var.getSize(), bArr, 22);
        } else if (method == 8) {
            byte[] bArr2 = b0;
            System.arraycopy(bArr2, 0, bArr, 18, 4);
            System.arraycopy(bArr2, 0, bArr, 22, 4);
        } else if (k2.d(method) || method == k2.XZ.b()) {
            j2.g(o1Var.getCompressedSize(), bArr, 18);
            j2.g(o1Var.getSize(), bArr, 22);
        } else {
            j2.g(o1Var.getSize(), bArr, 18);
            j2.g(o1Var.getSize(), bArr, 22);
        }
        l2.g(iLimit, bArr, 26);
        l2.g(bArrZ.length, bArr, 28);
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 30, iLimit);
        System.arraycopy(bArrZ, 0, bArr, i2, bArrZ.length);
        return bArr;
    }

    private void q() throws IOException {
        if (this.g.a.getMethod() == 8) {
            this.A.f();
        }
    }

    private g1 s(o1 o1Var) {
        return (this.U == g1.AsNeeded && o1Var.getMethod() == 8 && o1Var.getSize() == -1) ? g1.Never : this.U;
    }

    private y1 u(o1 o1Var) {
        return (this.J.c(o1Var.getName()) || !this.O) ? this.J : z1.a;
    }

    private e0 w(boolean z, boolean z2) {
        e0 e0Var = new e0();
        e0Var.h(this.M || z);
        if (z2) {
            e0Var.e(true);
        }
        return e0Var;
    }

    private ByteBuffer x(o1 o1Var) throws IOException {
        return u(o1Var).a(o1Var.getName());
    }

    private f1 y(o1 o1Var) {
        t1 t1Var = this.g;
        if (t1Var != null) {
            t1Var.e = !this.Q;
        }
        this.Q = true;
        a2 a2VarW = o1Var.w(f1.f1410h);
        f1 f1Var = a2VarW instanceof f1 ? (f1) a2VarW : null;
        if (f1Var == null) {
            f1Var = new f1();
        }
        o1Var.c(f1Var);
        return f1Var;
    }

    private boolean z(long j2, long j3, g1 g1Var) throws ZipException {
        int method = this.g.a.getMethod();
        if (method == 8) {
            this.g.a.setSize(this.g.d);
            this.g.a.setCompressedSize(j2);
            this.g.a.setCrc(j3);
        } else if (k2.d(method) || method == k2.XZ.b()) {
            this.g.a.setCompressedSize(j2);
            this.g.a.setCrc(j3);
        } else {
            if (this.g.a.getCrc() != j3) {
                throw new ZipException("Bad CRC checksum for entry " + this.g.a.getName() + ": " + Long.toHexString(this.g.a.getCrc()) + " instead of " + Long.toHexString(j3));
            }
            if (this.g.a.getSize() != j2) {
                throw new ZipException("Bad size for entry " + this.g.a.getName() + ": " + this.g.a.getSize() + " instead of " + j2);
            }
        }
        return d(g1Var);
    }

    public void J(o1 o1Var) throws IOException {
        K(o1Var, false);
    }

    protected void T() throws IOException, IllegalArgumentException {
        if (!this.Q && this.V) {
            ((m2) ((FilterOutputStream) this).out).d(this.H);
        }
        P();
        V(g0);
        int iC = this.V ? ((m2) ((FilterOutputStream) this).out).c() : 0;
        V(l2.b(iC));
        V(l2.b((int) this.G));
        int size = this.t.size();
        V(l2.b(Math.min(this.V ? this.W.getOrDefault(Integer.valueOf(iC), 0).intValue() : size, 65535)));
        V(l2.b(Math.min(size, 65535)));
        V(j2.b(Math.min(this.D, 4294967295L)));
        V(j2.b(Math.min(this.C, 4294967295L)));
        ByteBuffer byteBufferA = this.J.a(this.f1445h);
        int iLimit = byteBufferA.limit() - byteBufferA.position();
        V(l2.b(iLimit));
        this.A.q(byteBufferA.array(), byteBufferA.arrayOffset(), iLimit);
    }

    protected void W(o1 o1Var) throws IOException {
        if (O(o1Var.getMethod(), false)) {
            V(e0);
            V(j2.b(o1Var.getCrc()));
            if (D(o1Var)) {
                V(x1.b(o1Var.getCompressedSize()));
                V(x1.b(o1Var.getSize()));
            } else {
                V(j2.b(o1Var.getCompressedSize()));
                V(j2.b(o1Var.getSize()));
            }
        }
    }

    protected final void Y(byte[] bArr) throws IOException {
        this.A.u(bArr, 0, bArr.length);
    }

    protected void Z() throws IOException, IllegalArgumentException {
        if (this.U == g1.Never) {
            return;
        }
        if (!this.Q && N()) {
            this.Q = true;
        }
        if (this.Q) {
            long jM = this.A.m();
            long jC = 0;
            if (this.V) {
                m2 m2Var = (m2) ((FilterOutputStream) this).out;
                jM = m2Var.a();
                jC = m2Var.c();
            }
            Y(h0);
            Y(x1.b(44L));
            Y(l2.b(45));
            Y(l2.b(45));
            Y(j2.b(this.V ? ((m2) ((FilterOutputStream) this).out).c() : 0));
            Y(j2.b(this.G));
            Y(x1.b(this.V ? this.W.getOrDefault(Integer.valueOf(r0), 0).intValue() : this.t.size()));
            Y(x1.b(this.t.size()));
            Y(x1.b(this.D));
            Y(x1.b(this.C));
            if (this.V) {
                ((m2) ((FilterOutputStream) this).out).d(this.H + 20);
            }
            Y(i0);
            Y(j2.b(jC));
            Y(x1.b(jM));
            if (this.V) {
                Y(j2.b(((m2) ((FilterOutputStream) this).out).c() + 1));
            } else {
                Y(c0);
            }
        }
    }

    @Override // i.b.ha.a.b.b, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            if (!this.f) {
                p();
            }
        } finally {
            o();
        }
    }

    public void f() throws IOException {
        I();
        q();
        long jM = this.A.m() - this.g.c;
        long j2 = this.A.j();
        this.g.d = this.A.i();
        i(z(jM, j2, s(this.g.a)), false);
        this.A.n();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = ((FilterOutputStream) this).out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    void o() throws IOException {
        if (((FilterOutputStream) this).out != null) {
            super.close();
        }
    }

    public void p() throws IOException {
        if (this.f) {
            throw new IOException("This archive has already been finished");
        }
        if (this.g != null) {
            throw new IOException("This archive contains unclosed entries.");
        }
        long jM = this.A.m();
        this.C = jM;
        if (this.V) {
            this.C = ((m2) ((FilterOutputStream) this).out).a();
            this.G = r2.c();
        }
        U();
        this.D = this.A.m() - jM;
        ByteBuffer byteBufferA = this.J.a(this.f1445h);
        this.H = (byteBufferA.limit() - byteBufferA.position()) + 22;
        Z();
        T();
        this.I.clear();
        this.t.clear();
        this.A.close();
        if (this.V) {
            ((FilterOutputStream) this).out.close();
        }
        this.f = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        t1 t1Var = this.g;
        if (t1Var == null) {
            throw new IllegalStateException("No current entry");
        }
        o2.b(t1Var.a);
        a(this.A.o(bArr, i2, i3, this.g.a.getMethod()));
    }
}
