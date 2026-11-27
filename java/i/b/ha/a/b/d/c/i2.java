package i.b.ha.a.b.d.c;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public abstract class i2 implements Closeable {
    private static final String P = StandardCharsets.UTF_8.name();
    private static final EnumSet<StandardOpenOption> Q = EnumSet.of(StandardOpenOption.READ);
    private static final byte[] U = new byte[1];
    private static final long V = j2.e(w1.f0);
    private final byte[] A;
    private final ByteBuffer C;
    private final ByteBuffer D;
    private final ByteBuffer G;
    private final ByteBuffer H;
    private final i.b.ha.a.c.i.n<InputStream, InputStream> I;
    private long J;
    private long K;
    private long M;
    private long O;
    private final List<o1> c;
    private final Map<String, LinkedList<o1>> d;
    private final y1 e;
    private final SeekableByteChannel f;
    private final boolean g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f1415h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f1416i;

    /* renamed from: j, reason: collision with root package name */
    private final byte[] f1417j;

    /* renamed from: k, reason: collision with root package name */
    private final byte[] f1418k;
    private final byte[] t;

    static {
        Comparator.comparingLong(new ToLongFunction() { // from class: i.b.ha.a.b.d.c.i
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((o1) obj).s();
            }
        }).thenComparingLong(new ToLongFunction() { // from class: i.b.ha.a.b.d.c.f
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((o1) obj).B();
            }
        });
    }

    @Deprecated
    public i2(File file) throws IOException {
        this(file, P);
    }

    private int[] B(o1 o1Var) throws IOException {
        long jB = o1Var.B();
        if (this.f1416i) {
            ((n2) this.f).a(o1Var.s(), jB + 26);
            throw null;
        }
        this.f.position(jB + 26);
        this.D.rewind();
        i.b.ha.a.b.f.g.b(this.f, this.D);
        this.D.flip();
        this.D.get(this.A);
        int iD = l2.d(this.A);
        this.D.get(this.A);
        int iD2 = l2.d(this.A);
        o1Var.R(jB + 26 + 2 + 2 + iD + iD2);
        if (o1Var.q() + o1Var.getCompressedSize() <= this.M) {
            return new int[]{iD, iD2};
        }
        throw new IOException("data for " + o1Var.getName() + " overlaps with central directory.");
    }

    private void D(o1 o1Var) throws IOException {
        a2 a2VarW = o1Var.w(f1.f1410h);
        if (a2VarW != null && !(a2VarW instanceof f1)) {
            throw new ZipException("archive contains unparseable zip64 extra field");
        }
        f1 f1Var = (f1) a2VarW;
        if (f1Var != null) {
            boolean z = o1Var.getSize() == 4294967295L;
            boolean z2 = o1Var.getCompressedSize() == 4294967295L;
            boolean z3 = o1Var.B() == 4294967295L;
            boolean z4 = o1Var.s() == 65535;
            f1Var.m(z, z2, z3, z4);
            if (z) {
                long jC = f1Var.l().c();
                if (jC < 0) {
                    throw new IOException("broken archive, entry with negative size");
                }
                o1Var.setSize(jC);
            } else if (z2) {
                f1Var.q(new x1(o1Var.getSize()));
            }
            if (z2) {
                long jC2 = f1Var.i().c();
                if (jC2 < 0) {
                    throw new IOException("broken archive, entry with negative compressed size");
                }
                o1Var.setCompressedSize(jC2);
            } else if (z) {
                f1Var.n(new x1(o1Var.getCompressedSize()));
            }
            if (z3) {
                o1Var.Z(f1Var.k().c());
            }
            if (z4) {
                o1Var.S(f1Var.j().d());
            }
        }
    }

    private void F(int i2) throws IOException {
        long jPosition = this.f.position() + i2;
        if (jPosition > this.f.size()) {
            throw new EOFException();
        }
        this.f.position(jPosition);
    }

    private boolean G() throws IOException {
        this.f.position(this.O);
        this.D.rewind();
        i.b.ha.a.b.f.g.b(this.f, this.D);
        return Arrays.equals(this.f1418k, w1.d0);
    }

    static int H(int i2) {
        return (i2 >> 8) & 15;
    }

    private static boolean I(SeekableByteChannel seekableByteChannel, long j2, long j3, byte[] bArr) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        long size = seekableByteChannel.size() - j2;
        long jMax = Math.max(0L, seekableByteChannel.size() - j3);
        boolean z = true;
        if (size >= 0) {
            while (size >= jMax) {
                seekableByteChannel.position(size);
                try {
                    byteBufferAllocate.rewind();
                    i.b.ha.a.b.f.g.b(seekableByteChannel, byteBufferAllocate);
                    byteBufferAllocate.flip();
                    if (byteBufferAllocate.get() == bArr[0] && byteBufferAllocate.get() == bArr[1] && byteBufferAllocate.get() == bArr[2] && byteBufferAllocate.get() == bArr[3]) {
                        break;
                    }
                    size--;
                } catch (EOFException unused) {
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (z) {
            seekableByteChannel.position(size);
        }
        return z;
    }

    private i.b.ha.a.b.f.c a(long j2, long j3) {
        if (j2 < 0 || j3 < 0 || j2 + j3 < j2) {
            throw new IllegalArgumentException("Corrupted archive, stream boundaries are out of range");
        }
        return this.f instanceof FileChannel ? new d2(j2, j3, (FileChannel) this.f) : new i.b.ha.a.b.f.d(j2, j3, this.f);
    }

    private void d() {
        this.c.forEach(new Consumer() { // from class: i.b.ha.a.b.d.c.n
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.n((o1) obj);
            }
        });
    }

    private long f(o1 o1Var) throws IOException {
        long jQ = o1Var.q();
        if (jQ != -1) {
            return jQ;
        }
        B(o1Var);
        return o1Var.q();
    }

    static /* synthetic */ LinkedList j(String str) {
        return new LinkedList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(o1 o1Var) {
        this.d.computeIfAbsent(o1Var.getName(), new Function() { // from class: i.b.ha.a.b.d.c.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return i2.j((String) obj);
            }
        }).addLast(o1Var);
    }

    private static SeekableByteChannel o(Path path) throws IOException {
        return Files.newByteChannel(path, Q, new FileAttribute[0]);
    }

    private Map<o1, g2> p() throws IOException {
        HashMap map = new HashMap();
        q();
        this.M = this.f.position();
        this.D.rewind();
        i.b.ha.a.b.f.g.b(this.f, this.D);
        long jE = j2.e(this.f1418k);
        if (jE != V && G()) {
            throw new IOException("Central directory is empty, can't expand corrupt archive.");
        }
        while (jE == V) {
            x(map);
            this.D.rewind();
            i.b.ha.a.b.f.g.b(this.f, this.D);
            jE = j2.e(this.f1418k);
        }
        return map;
    }

    private void q() throws IOException {
        if (w(this.f)) {
            u();
        } else {
            s();
        }
    }

    private void s() throws IOException {
        long jPosition = this.f.position();
        if (this.f1416i) {
            F(6);
            this.H.rewind();
            i.b.ha.a.b.f.g.b(this.f, this.H);
            this.J = l2.d(this.A);
            F(8);
            this.D.rewind();
            i.b.ha.a.b.f.g.b(this.f, this.D);
            long jE = j2.e(this.f1418k);
            this.K = jE;
            ((n2) this.f).a(this.J, jE);
            throw null;
        }
        F(12);
        this.D.rewind();
        i.b.ha.a.b.f.g.b(this.f, this.D);
        long jE2 = j2.e(this.f1418k);
        this.D.rewind();
        i.b.ha.a.b.f.g.b(this.f, this.D);
        this.J = 0L;
        long jE3 = j2.e(this.f1418k);
        this.K = jE3;
        long jMax = Long.max((jPosition - jE2) - jE3, 0L);
        this.O = jMax;
        this.f.position(this.K + jMax);
    }

    private void u() throws IOException {
        F(4);
        if (this.f1416i) {
            this.D.rewind();
            i.b.ha.a.b.f.g.b(this.f, this.D);
            long jE = j2.e(this.f1418k);
            this.C.rewind();
            i.b.ha.a.b.f.g.b(this.f, this.C);
            ((n2) this.f).a(jE, x1.d(this.f1417j));
            throw null;
        }
        F(4);
        this.C.rewind();
        i.b.ha.a.b.f.g.b(this.f, this.C);
        this.f.position(x1.d(this.f1417j));
        this.D.rewind();
        i.b.ha.a.b.f.g.b(this.f, this.D);
        if (!Arrays.equals(this.f1418k, w1.h0)) {
            throw new ZipException("Archive's ZIP64 end of central directory locator is corrupt.");
        }
        if (!this.f1416i) {
            F(44);
            this.C.rewind();
            i.b.ha.a.b.f.g.b(this.f, this.C);
            this.J = 0L;
            long jD = x1.d(this.f1417j);
            this.K = jD;
            this.f.position(jD);
            return;
        }
        F(16);
        this.D.rewind();
        i.b.ha.a.b.f.g.b(this.f, this.D);
        this.J = j2.e(this.f1418k);
        F(24);
        this.C.rewind();
        i.b.ha.a.b.f.g.b(this.f, this.C);
        long jD2 = x1.d(this.f1417j);
        this.K = jD2;
        ((n2) this.f).a(this.J, jD2);
        throw null;
    }

    private static boolean w(SeekableByteChannel seekableByteChannel) throws IOException {
        if (!I(seekableByteChannel, 22L, 65557L, w1.g0)) {
            throw new ZipException("Archive is not a ZIP archive");
        }
        boolean zEquals = false;
        long jPosition = seekableByteChannel.position();
        if (jPosition > 20) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            seekableByteChannel.position(seekableByteChannel.position() - 20);
            byteBufferAllocate.rewind();
            i.b.ha.a.b.f.g.b(seekableByteChannel, byteBufferAllocate);
            byteBufferAllocate.flip();
            zEquals = byteBufferAllocate.equals(ByteBuffer.wrap(w1.i0));
            if (zEquals) {
                seekableByteChannel.position(seekableByteChannel.position() - 4);
            } else {
                seekableByteChannel.position(jPosition);
            }
        }
        return zEquals;
    }

    private void x(Map<o1, g2> map) throws IOException {
        this.G.rewind();
        i.b.ha.a.b.f.g.b(this.f, this.G);
        b2 b2Var = null;
        f2 f2Var = new f2(b2Var);
        int iE = l2.e(this.t, 0);
        f2Var.g0(iE);
        f2Var.d0(H(iE));
        f2Var.h0(l2.e(this.t, 2));
        e0 e0VarD = e0.d(this.t, 4);
        boolean zK = e0VarD.k();
        y1 y1Var = zK ? z1.a : this.e;
        if (zK) {
            f2Var.c0(n1.NAME_WITH_EFS_FLAG);
        }
        f2Var.X(e0VarD);
        f2Var.e0(l2.e(this.t, 4));
        f2Var.setMethod(l2.e(this.t, 6));
        f2Var.setTime(o2.e(j2.f(this.t, 8)));
        f2Var.setCrc(j2.f(this.t, 12));
        long jF = j2.f(this.t, 16);
        if (jF < 0) {
            throw new IOException("broken archive, entry with negative compressed size");
        }
        f2Var.setCompressedSize(jF);
        long jF2 = j2.f(this.t, 20);
        if (jF2 < 0) {
            throw new IOException("broken archive, entry with negative size");
        }
        f2Var.setSize(jF2);
        int iE2 = l2.e(this.t, 24);
        if (iE2 < 0) {
            throw new IOException("broken archive, entry with negative fileNameLen");
        }
        int iE3 = l2.e(this.t, 26);
        if (iE3 < 0) {
            throw new IOException("broken archive, entry with negative extraLen");
        }
        int iE4 = l2.e(this.t, 28);
        if (iE4 < 0) {
            throw new IOException("broken archive, entry with negative commentLen");
        }
        f2Var.S(l2.e(this.t, 30));
        f2Var.Y(l2.e(this.t, 32));
        f2Var.T(j2.f(this.t, 34));
        byte[] bArrD = i.b.ha.a.b.f.g.d(this.f, iE2);
        if (bArrD.length < iE2) {
            throw new EOFException();
        }
        f2Var.b0(y1Var.b(bArrD), bArrD);
        f2Var.Z(j2.f(this.t, 38) + this.O);
        this.c.add(f2Var);
        byte[] bArrD2 = i.b.ha.a.b.f.g.d(this.f, iE3);
        if (bArrD2.length < iE3) {
            throw new EOFException();
        }
        try {
            f2Var.P(bArrD2);
            D(f2Var);
            z(f2Var);
            byte[] bArrD3 = i.b.ha.a.b.f.g.d(this.f, iE4);
            if (bArrD3.length < iE4) {
                throw new EOFException();
            }
            f2Var.setComment(y1Var.b(bArrD3));
            if (!zK && this.g) {
                map.put(f2Var, new g2(bArrD, bArrD3, b2Var));
            }
            f2Var.f0(true);
        } catch (RuntimeException e) {
            throw o2.j("Invalid extra data in entry " + f2Var.getName(), e);
        }
    }

    private void y(Map<o1, g2> map) throws IOException {
        Iterator<o1> it = this.c.iterator();
        while (it.hasNext()) {
            f2 f2Var = (f2) it.next();
            int[] iArrB = B(f2Var);
            int i2 = iArrB[0];
            int i3 = iArrB[1];
            F(i2);
            byte[] bArrD = i.b.ha.a.b.f.g.d(this.f, i3);
            if (bArrD.length < i3) {
                throw new EOFException();
            }
            try {
                f2Var.setExtra(bArrD);
                if (map.containsKey(f2Var)) {
                    g2 g2Var = map.get(f2Var);
                    o2.l(f2Var, g2Var.a, g2Var.b);
                }
            } catch (RuntimeException e) {
                throw o2.j("Invalid extra data in entry " + f2Var.getName(), e);
            }
        }
    }

    private void z(o1 o1Var) throws IOException {
        if (o1Var.s() < 0) {
            throw new IOException("broken archive, entry with negative disk number");
        }
        if (o1Var.B() < 0) {
            throw new IOException("broken archive, entry with negative local file header offset");
        }
        if (!this.f1416i) {
            if (o1Var.B() <= this.M) {
                return;
            }
            throw new IOException("local file header for " + o1Var.getName() + " starts after central directory");
        }
        if (o1Var.s() > this.J) {
            throw new IOException("local file header for " + o1Var.getName() + " starts on a later disk than central directory");
        }
        if (o1Var.s() != this.J || o1Var.B() <= this.K) {
            return;
        }
        throw new IOException("local file header for " + o1Var.getName() + " starts after central directory");
    }

    public Enumeration<o1> A() {
        return Collections.enumeration(this.c);
    }

    InputStream c(InputStream inputStream) throws IOException {
        i.b.ha.a.c.i.n<InputStream, InputStream> nVar = this.I;
        if (nVar == null) {
            return new i.b.ha.a.b.e.f.a(inputStream);
        }
        nVar.apply(inputStream);
        return inputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1415h = true;
        this.f.close();
    }

    protected void finalize() throws Throwable {
        try {
            if (!this.f1415h) {
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public InputStream i(o1 o1Var) throws IOException {
        if (!(o1Var instanceof f2)) {
            return null;
        }
        long jF = f(o1Var);
        if (jF == -1) {
            return null;
        }
        return a(jF, o1Var.getCompressedSize());
    }

    public o1 k(String str) {
        LinkedList<o1> linkedList = this.d.get(str);
        if (linkedList != null) {
            return linkedList.getFirst();
        }
        return null;
    }

    public InputStream v(o1 o1Var) throws IOException {
        if (!(o1Var instanceof f2)) {
            return null;
        }
        o2.b(o1Var);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(i(o1Var));
        switch (c2.a[k2.c(o1Var.getMethod()).ordinal()]) {
            case 1:
                return new h2(bufferedInputStream);
            case 2:
                return new u0(bufferedInputStream);
            case 3:
                try {
                    return new a0(o1Var.x().c(), o1Var.x().b(), bufferedInputStream);
                } catch (IllegalArgumentException e) {
                    throw new IOException("bad IMPLODE data", e);
                }
            case 4:
                Inflater inflater = new Inflater(true);
                return new b2(this, new SequenceInputStream(bufferedInputStream, new ByteArrayInputStream(U)), inflater, inflater);
            case 5:
                return new i.b.ha.a.b.e.b.b(bufferedInputStream);
            case 6:
                return new i.b.ha.a.b.e.c.a(bufferedInputStream);
            case 7:
            case 8:
                return c(bufferedInputStream);
            case 9:
                return new i.b.ha.a.b.e.e.c(bufferedInputStream);
            default:
                throw new w0(k2.c(o1Var.getMethod()), o1Var);
        }
    }

    @Deprecated
    public i2(File file, String str) throws IOException {
        this(file.toPath(), str, true);
    }

    @Deprecated
    public i2(Path path, String str, boolean z) throws IOException {
        this(path, str, z, false);
    }

    @Deprecated
    public i2(Path path, String str, boolean z, boolean z2) throws IOException {
        this(o(path), path.toAbsolutePath().toString(), str, z, true, z2);
    }

    /* JADX WARN: Finally extract failed */
    private i2(SeekableByteChannel seekableByteChannel, String str, Charset charset, boolean z, boolean z2, boolean z3, i.b.ha.a.c.i.n<InputStream, InputStream> nVar) throws IOException {
        this.c = new LinkedList();
        this.d = new HashMap(509);
        this.f1415h = true;
        byte[] bArr = new byte[8];
        this.f1417j = bArr;
        byte[] bArr2 = new byte[4];
        this.f1418k = bArr2;
        byte[] bArr3 = new byte[42];
        this.t = bArr3;
        byte[] bArr4 = new byte[2];
        this.A = bArr4;
        this.C = ByteBuffer.wrap(bArr);
        this.D = ByteBuffer.wrap(bArr2);
        this.G = ByteBuffer.wrap(bArr3);
        this.H = ByteBuffer.wrap(bArr4);
        this.f1416i = false;
        i.b.ha.a.c.c.d(charset, e2.f1409i);
        this.e = z1.b(charset);
        this.g = z;
        this.f = seekableByteChannel;
        this.I = nVar;
        try {
            try {
                Map<o1, g2> mapP = p();
                if (!z3) {
                    y(mapP);
                }
                d();
                this.f1415h = false;
            } catch (IOException e) {
                throw new IOException("Error reading Zip content from " + str, e);
            }
        } catch (Throwable th) {
            this.f1415h = true;
            if (z2) {
                i.b.ha.a.c.e.h(this.f);
            }
            throw th;
        }
    }

    private i2(SeekableByteChannel seekableByteChannel, String str, String str2, boolean z, boolean z2, boolean z3) throws IOException {
        this(seekableByteChannel, str, i.b.ha.a.c.c.a(str2), z, z2, z3, null);
    }
}
