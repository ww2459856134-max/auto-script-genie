package i.b.ha.a.b.d.c;

import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class o1 extends ZipEntry {
    private long A;
    private long C;
    private final Function<l2, a2> D;
    private long G;
    private boolean H;
    private long I;
    private int c;
    private long d;
    private int e;
    private int f;
    private long g;

    /* renamed from: h, reason: collision with root package name */
    private int f1433h;

    /* renamed from: i, reason: collision with root package name */
    private a2[] f1434i;

    /* renamed from: j, reason: collision with root package name */
    private s0 f1435j;

    /* renamed from: k, reason: collision with root package name */
    private String f1436k;
    private e0 t;

    static {
        new LinkedList();
    }

    protected o1() {
        this("");
    }

    private a2[] D() {
        a2[] a2VarArr = this.f1434i;
        a2[] a2VarArrM = m(a2VarArr, a2VarArr.length + 1);
        a2VarArrM[this.f1434i.length] = this.f1435j;
        return a2VarArrM;
    }

    private a2[] G() {
        s0 s0Var = this.f1435j;
        return s0Var == null ? d0.b : new a2[]{s0Var};
    }

    private void H(a2 a2Var) {
        if (a2Var instanceof s0) {
            this.f1435j = (s0) a2Var;
            return;
        }
        if (this.f1434i == null) {
            this.f1434i = new a2[]{a2Var};
            return;
        }
        if (w(a2Var.d()) != null) {
            I(a2Var.d());
        }
        a2[] a2VarArr = this.f1434i;
        a2[] a2VarArrM = m(a2VarArr, a2VarArr.length + 1);
        a2VarArrM[a2VarArrM.length - 1] = a2Var;
        this.f1434i = a2VarArrM;
    }

    private void I(l2 l2Var) {
        if (this.f1434i == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (a2 a2Var : this.f1434i) {
            if (!l2Var.equals(a2Var.d())) {
                arrayList.add(a2Var);
            }
        }
        if (this.f1434i.length == arrayList.size()) {
            return;
        }
        this.f1434i = (a2[]) arrayList.toArray(d0.b);
    }

    private void J(FileTime fileTime) {
        super.setLastModifiedTime(fileTime);
        this.I = fileTime.toMillis();
        this.H = true;
    }

    private static boolean K(String str) {
        return str.endsWith("/");
    }

    private void L(a2[] a2VarArr, boolean z) {
        if (this.f1434i == null) {
            V(a2VarArr);
            return;
        }
        for (a2 a2Var : a2VarArr) {
            a2 a2VarW = a2Var instanceof s0 ? this.f1435j : w(a2Var.d());
            if (a2VarW == null) {
                H(a2Var);
            } else {
                byte[] bArrE = z ? a2Var.e() : a2Var.a();
                if (z) {
                    try {
                        a2VarW.g(bArrE, 0, bArrE.length);
                    } catch (ZipException unused) {
                        t0 t0Var = new t0();
                        t0Var.i(a2VarW.d());
                        if (z) {
                            t0Var.j(bArrE);
                            t0Var.h(a2VarW.a());
                        } else {
                            t0Var.j(a2VarW.e());
                            t0Var.h(bArrE);
                        }
                        I(a2VarW.d());
                        H(t0Var);
                    }
                } else {
                    a2VarW.b(bArrE, 0, bArrE.length);
                }
            }
        }
        U();
    }

    private a2[] M(byte[] bArr, boolean z, b0 b0Var) throws ZipException {
        return this.D != null ? d0.f(bArr, z, new i1(this, b0Var)) : d0.f(bArr, z, b0Var);
    }

    private boolean O() {
        if (getLastAccessTime() == null && getCreationTime() == null) {
            return this.H;
        }
        return true;
    }

    private void W() {
        l2 l2Var = d1.f1404j;
        if (w(l2Var) != null) {
            I(l2Var);
        }
        l2 l2Var2 = x0.f;
        if (w(l2Var2) != null) {
            I(l2Var2);
        }
        if (O()) {
            FileTime lastModifiedTime = getLastModifiedTime();
            FileTime lastAccessTime = getLastAccessTime();
            FileTime creationTime = getCreationTime();
            if (j(lastModifiedTime, lastAccessTime, creationTime)) {
                f(lastModifiedTime, lastAccessTime, creationTime);
            }
            i(lastModifiedTime, lastAccessTime, creationTime);
        }
        U();
    }

    private void f(FileTime fileTime, FileTime fileTime2, FileTime fileTime3) {
        d1 d1Var = new d1();
        if (fileTime != null) {
            d1Var.y(fileTime);
        }
        if (fileTime2 != null) {
            d1Var.t(fileTime2);
        }
        if (fileTime3 != null) {
            d1Var.v(fileTime3);
        }
        H(d1Var);
    }

    private void i(FileTime fileTime, FileTime fileTime2, FileTime fileTime3) {
        x0 x0Var = new x0();
        if (fileTime != null) {
            x0Var.r(fileTime);
        }
        if (fileTime2 != null) {
            x0Var.n(fileTime2);
        }
        if (fileTime3 != null) {
            x0Var.p(fileTime3);
        }
        H(x0Var);
    }

    private void i0() {
        j0();
        k0();
    }

    private static boolean j(FileTime fileTime, FileTime fileTime2, FileTime fileTime3) {
        return i.b.ha.a.c.h.b.a.c(fileTime) && i.b.ha.a.c.h.b.a.c(fileTime2) && i.b.ha.a.c.h.b.a.c(fileTime3);
    }

    private void j0() {
        FileTime fileTimeL;
        FileTime fileTimeI;
        FileTime fileTimeN;
        a2 a2VarW = w(d1.f1404j);
        if (a2VarW instanceof d1) {
            d1 d1Var = (d1) a2VarW;
            if (d1Var.p() && (fileTimeN = d1Var.n()) != null) {
                J(fileTimeN);
            }
            if (d1Var.q() && (fileTimeI = d1Var.i()) != null) {
                super.setLastAccessTime(fileTimeI);
            }
            if (!d1Var.r() || (fileTimeL = d1Var.l()) == null) {
                return;
            }
            super.setCreationTime(fileTimeL);
        }
    }

    private void k0() {
        a2 a2VarW = w(x0.f);
        if (a2VarW instanceof x0) {
            x0 x0Var = (x0) a2VarW;
            FileTime fileTimeK = x0Var.k();
            if (fileTimeK != null) {
                J(fileTimeK);
            }
            FileTime fileTimeI = x0Var.i();
            if (fileTimeI != null) {
                super.setLastAccessTime(fileTimeI);
            }
            FileTime fileTimeJ = x0Var.j();
            if (fileTimeJ != null) {
                super.setCreationTime(fileTimeJ);
            }
        }
    }

    private a2[] m(a2[] a2VarArr, int i2) {
        return (a2[]) Arrays.copyOf(a2VarArr, i2);
    }

    private a2[] o() {
        a2[] a2VarArr = this.f1434i;
        return a2VarArr == null ? G() : this.f1435j != null ? D() : a2VarArr;
    }

    public long B() {
        return this.A;
    }

    public int F() {
        return this.f;
    }

    public void N(l2 l2Var) {
        if (w(l2Var) == null) {
            throw new NoSuchElementException();
        }
        I(l2Var);
        U();
    }

    public void P(byte[] bArr) {
        try {
            L(M(bArr, false, m1.d), false);
        } catch (ZipException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public void Q(j1 j1Var) {
    }

    protected void R(long j2) {
        this.C = j2;
    }

    public void S(long j2) {
        this.G = j2;
    }

    public void T(long j2) {
        this.g = j2;
    }

    protected void U() {
        super.setExtra(d0.e(o()));
        i0();
    }

    public void V(a2[] a2VarArr) {
        this.f1435j = null;
        ArrayList arrayList = new ArrayList();
        if (a2VarArr != null) {
            for (a2 a2Var : a2VarArr) {
                if (a2Var instanceof s0) {
                    this.f1435j = (s0) a2Var;
                } else {
                    arrayList.add(a2Var);
                }
            }
        }
        this.f1434i = (a2[]) arrayList.toArray(d0.b);
        U();
    }

    public void X(e0 e0Var) {
        this.t = e0Var;
    }

    public void Y(int i2) {
        this.e = i2;
    }

    protected void Z(long j2) {
        this.A = j2;
    }

    protected void a0(String str) {
        if (str != null && F() == 0 && !str.contains("/")) {
            str = str.replace('\\', '/');
        }
        this.f1436k = str;
    }

    protected void b0(String str, byte[] bArr) {
        a0(str);
    }

    public void c(a2 a2Var) {
        if (a2Var instanceof s0) {
            this.f1435j = (s0) a2Var;
        } else {
            if (w(a2Var.d()) != null) {
                I(a2Var.d());
            }
            a2[] a2VarArr = this.f1434i;
            a2[] a2VarArr2 = new a2[i.b.ha.a.d.b.a(a2VarArr) + 1];
            this.f1434i = a2VarArr2;
            a2VarArr2[0] = a2Var;
            if (a2VarArr != null) {
                System.arraycopy(a2VarArr, 0, a2VarArr2, 1, a2VarArr2.length - 1);
            }
        }
        U();
    }

    public void c0(n1 n1Var) {
    }

    @Override // java.util.zip.ZipEntry
    public Object clone() {
        o1 o1Var = (o1) super.clone();
        o1Var.Y(y());
        o1Var.T(u());
        o1Var.V(o());
        return o1Var;
    }

    public void d(a2 a2Var) {
        H(a2Var);
        U();
    }

    protected void d0(int i2) {
        this.f = i2;
    }

    public void e0(int i2) {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        o1 o1Var = (o1) obj;
        if (!Objects.equals(getName(), o1Var.getName())) {
            return false;
        }
        String comment = getComment();
        String comment2 = o1Var.getComment();
        if (comment == null) {
            comment = "";
        }
        if (comment2 == null) {
            comment2 = "";
        }
        return Objects.equals(getLastModifiedTime(), o1Var.getLastModifiedTime()) && Objects.equals(getLastAccessTime(), o1Var.getLastAccessTime()) && Objects.equals(getCreationTime(), o1Var.getCreationTime()) && comment.equals(comment2) && y() == o1Var.y() && F() == o1Var.F() && u() == o1Var.u() && getMethod() == o1Var.getMethod() && getSize() == o1Var.getSize() && getCrc() == o1Var.getCrc() && getCompressedSize() == o1Var.getCompressedSize() && Arrays.equals(p(), o1Var.p()) && Arrays.equals(z(), o1Var.z()) && this.A == o1Var.A && this.C == o1Var.C && this.t.equals(o1Var.t);
    }

    protected void f0(boolean z) {
    }

    public void g0(int i2) {
    }

    @Override // java.util.zip.ZipEntry
    public int getMethod() {
        return this.c;
    }

    @Override // java.util.zip.ZipEntry
    public String getName() {
        String str = this.f1436k;
        return str == null ? super.getName() : str;
    }

    @Override // java.util.zip.ZipEntry
    public long getSize() {
        return this.d;
    }

    @Override // java.util.zip.ZipEntry
    public long getTime() {
        if (this.H) {
            return getLastModifiedTime().toMillis();
        }
        long j2 = this.I;
        return j2 != -1 ? j2 : super.getTime();
    }

    public void h0(int i2) {
    }

    @Override // java.util.zip.ZipEntry
    public int hashCode() {
        return getName().hashCode();
    }

    @Override // java.util.zip.ZipEntry
    public boolean isDirectory() {
        return K(getName());
    }

    protected int n() {
        return this.f1433h;
    }

    public byte[] p() {
        return d0.d(o());
    }

    public long q() {
        return this.C;
    }

    public long s() {
        return this.G;
    }

    @Override // java.util.zip.ZipEntry
    public ZipEntry setCreationTime(FileTime fileTime) {
        super.setCreationTime(fileTime);
        W();
        return this;
    }

    @Override // java.util.zip.ZipEntry
    public void setExtra(byte[] bArr) throws RuntimeException {
        try {
            L(M(bArr, true, m1.d), true);
        } catch (ZipException e) {
            throw new IllegalArgumentException("Error parsing extra fields for entry: " + getName() + " - " + e.getMessage(), e);
        }
    }

    @Override // java.util.zip.ZipEntry
    public ZipEntry setLastAccessTime(FileTime fileTime) {
        super.setLastAccessTime(fileTime);
        W();
        return this;
    }

    @Override // java.util.zip.ZipEntry
    public ZipEntry setLastModifiedTime(FileTime fileTime) {
        J(fileTime);
        W();
        return this;
    }

    @Override // java.util.zip.ZipEntry
    public void setMethod(int i2) {
        if (i2 >= 0) {
            this.c = i2;
            return;
        }
        throw new IllegalArgumentException("ZIP compression method cannot be negative: " + i2);
    }

    @Override // java.util.zip.ZipEntry
    public void setSize(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("Invalid entry size");
        }
        this.d = j2;
    }

    @Override // java.util.zip.ZipEntry
    public void setTime(long j2) {
        if (!o2.g(j2)) {
            setLastModifiedTime(FileTime.fromMillis(j2));
            return;
        }
        super.setTime(j2);
        this.I = j2;
        this.H = false;
        W();
    }

    public long u() {
        return this.g;
    }

    public a2 w(l2 l2Var) {
        a2[] a2VarArr = this.f1434i;
        if (a2VarArr == null) {
            return null;
        }
        for (a2 a2Var : a2VarArr) {
            if (l2Var.equals(a2Var.d())) {
                return a2Var;
            }
        }
        return null;
    }

    public e0 x() {
        return this.t;
    }

    public int y() {
        return this.e;
    }

    public byte[] z() {
        byte[] extra = getExtra();
        return extra != null ? extra : i.b.ha.a.b.f.e.a;
    }

    private o1(Function<l2, a2> function, String str) {
        super(str);
        this.c = -1;
        this.d = -1L;
        this.f = 0;
        this.t = new e0();
        this.A = -1L;
        this.C = -1L;
        n1 n1Var = n1.NAME;
        j1 j1Var = j1.COMMENT;
        this.I = -1L;
        this.D = function;
        a0(str);
    }

    public o1(String str) {
        this(null, str);
    }
}
