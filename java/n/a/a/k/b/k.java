package n.a.a.k.b;

import com.auto.exceldeps.log4j.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n.a.a.o.j1;
import n.a.a.o.w0;

/* loaded from: classes.dex */
public abstract class k implements Closeable {
    private static final Logger C = n.a.a.i.b.a(k.class);
    protected static final l D = l.READ_WRITE;
    protected OutputStream A;
    private final l c;
    private n d;
    protected r e;
    protected final Map<n.a.a.k.b.z.c, n.a.a.k.b.z.l> f;
    protected final n.a.a.k.b.z.l g;

    /* renamed from: h, reason: collision with root package name */
    protected final Map<n.a.a.k.b.z.c, n.a.a.k.b.z.m> f2279h;

    /* renamed from: i, reason: collision with root package name */
    protected n.a.a.k.b.z.k f2280i;

    /* renamed from: j, reason: collision with root package name */
    protected n.a.a.k.b.z.d f2281j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f2282k;
    protected String t;

    k(l lVar, j jVar) {
        HashMap map = new HashMap(5);
        this.f = map;
        this.g = new n.a.a.k.b.z.r.a();
        HashMap map2 = new HashMap(2);
        this.f2279h = map2;
        if (getClass() != x.class) {
            throw new IllegalArgumentException("PackageBase may not be subclassed");
        }
        this.c = lVar;
        n.a.a.k.b.z.c cVarP = P();
        map2.put(cVarP, new n.a.a.k.b.z.s.a(jVar));
        map.put(cVarP, new n.a.a.k.b.z.r.d());
    }

    private r M(String str) throws n.a.a.k.a.b {
        h0();
        u();
        return this.e.k(str);
    }

    private static n.a.a.k.b.z.c P() {
        try {
            return new n.a.a.k.b.z.c("application/vnd.openxmlformats-package.core-properties+xml");
        } catch (n.a.a.k.a.a e) {
            throw new n.a.a.k.a.g("Package.init() : this exception should never happen, if you read this message please send a mail to the developers team. : " + e.getMessage(), e);
        }
    }

    public static k Q(File file) throws n.a.a.k.a.a {
        return R(file, D);
    }

    public static k R(File file, l lVar) throws n.a.a.k.a.a {
        return S(file, lVar, j.a());
    }

    public static k S(File file, l lVar, j jVar) throws n.a.a.k.a.a, IOException {
        if (file == null) {
            throw new IllegalArgumentException("'file' must be given");
        }
        if (file.exists() && file.isDirectory()) {
            throw new IllegalArgumentException("file must not be a directory");
        }
        try {
            x xVar = new x(file, lVar, jVar);
            try {
                if (((k) xVar).d == null && lVar != l.WRITE) {
                    xVar.F();
                }
                xVar.t = file.getAbsolutePath();
                return xVar;
            } catch (RuntimeException | n.a.a.k.a.a e) {
                if (lVar == l.READ) {
                    xVar.b0();
                } else {
                    w0.f(xVar);
                }
                throw e;
            }
        } catch (n.a.a.k.a.b e2) {
            throw new n.a.a.k.a.a(e2.getMessage(), e2);
        }
    }

    public static k T(InputStream inputStream, boolean z) throws n.a.a.k.a.a, IOException {
        return U(inputStream, z, j.a());
    }

    public static k U(InputStream inputStream, boolean z, j jVar) throws n.a.a.k.a.a, IOException {
        try {
            x xVar = new x(inputStream, l.READ_WRITE, z, jVar);
            try {
                if (((k) xVar).d == null) {
                    xVar.F();
                }
                return xVar;
            } catch (RuntimeException | n.a.a.k.a.a e) {
                w0.f(xVar);
                throw e;
            }
        } catch (n.a.a.k.b.z.g e2) {
            throw new n.a.a.k.a.a(e2.getMessage(), e2);
        }
    }

    public static k V(String str) throws n.a.a.k.a.a {
        return W(str, D, j.a());
    }

    public static k W(String str, l lVar, j jVar) throws n.a.a.k.a.a, n.a.a.k.a.b, IOException {
        if (j1.f(str)) {
            throw new IllegalArgumentException("'path' must be given");
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            throw new IllegalArgumentException("path must not be a directory");
        }
        x xVar = new x(str, lVar, jVar);
        if (((k) xVar).d == null && lVar != l.WRITE) {
            try {
                xVar.F();
            } catch (Throwable th) {
                w0.f(xVar);
                throw th;
            }
        }
        xVar.t = new File(str).getAbsolutePath();
        return xVar;
    }

    private static void m(k kVar) {
        try {
            n.a.a.k.b.z.o oVar = new n.a.a.k.b.z.o(null, kVar);
            kVar.f2281j = oVar;
            oVar.a(s.c(s.b), "application/vnd.openxmlformats-package.relationships+xml");
            kVar.f2281j.a(s.b("/default.xml"), "application/xml");
            n.a.a.k.b.z.k kVar2 = new n.a.a.k.b.z.k(kVar, s.e);
            kVar.f2280i = kVar2;
            kVar2.a("Generated by Apache POI OpenXML4J");
            kVar.f2280i.m0(Optional.of(new Date()));
        } catch (n.a.a.k.a.a e) {
            throw new IllegalStateException(e);
        }
    }

    public static k o(OutputStream outputStream) {
        x xVar = new x();
        xVar.t = null;
        xVar.A = outputStream;
        m(xVar);
        return xVar;
    }

    public m B(o oVar) throws n.a.a.k.a.b, IOException {
        h0();
        if (oVar == null) {
            throw new IllegalArgumentException("partName");
        }
        if (this.d == null) {
            try {
                F();
            } catch (n.a.a.k.a.a unused) {
                return null;
            }
        }
        return this.d.c(oVar);
    }

    public m D(q qVar) {
        u();
        Iterator<q> it = this.e.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next.b().equals(qVar.b())) {
                try {
                    return B(s.c(next.e()));
                } catch (n.a.a.k.a.a unused) {
                    continue;
                }
            }
        }
        return null;
    }

    public ArrayList<m> F() throws n.a.a.k.a.a, n.a.a.k.a.b, IOException {
        h0();
        if (this.d == null) {
            this.d = J();
            Iterator it = new ArrayList(this.d.i()).iterator();
            boolean z = true;
            boolean z2 = false;
            while (it.hasNext()) {
                m mVar = (m) it.next();
                mVar.C();
                if ("application/vnd.openxmlformats-package.core-properties+xml".equals(mVar.l())) {
                    if (z2) {
                        C.atWarn().log("OPC Compliance error [M4.1]: there is more than one core properties relationship in the package! POI will use only the first, but other software may reject this file.");
                    } else {
                        z2 = true;
                    }
                }
                n.a.a.k.b.z.m mVar2 = this.f2279h.get(mVar.e);
                if (mVar2 != null) {
                    n.a.a.k.b.z.s.b bVar = new n.a.a.k.b.z.s.b(this, mVar.d);
                    try {
                        InputStream inputStreamM = mVar.m();
                        try {
                            m mVarA = mVar2.a(bVar, inputStreamM);
                            this.d.h(mVar.r());
                            this.d.g(mVarA.d, mVarA);
                            if ((mVarA instanceof n.a.a.k.b.z.k) && z2 && z) {
                                this.f2280i = (n.a.a.k.b.z.k) mVarA;
                                z = false;
                            }
                            if (inputStreamM != null) {
                                inputStreamM.close();
                            }
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                if (inputStreamM != null) {
                                    try {
                                        inputStreamM.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                }
                                throw th2;
                            }
                        }
                    } catch (IOException unused) {
                        C.atWarn().log("Unmarshall operation : IOException for {}", mVar.d);
                    } catch (n.a.a.k.a.b e) {
                        throw new n.a.a.k.a.a(e.getMessage(), e);
                    }
                }
            }
        }
        return new ArrayList<>(this.d.i());
    }

    public ArrayList<m> G(String str) {
        ArrayList<m> arrayList = new ArrayList<>();
        for (m mVar : this.d.i()) {
            if (mVar.l().equals(str)) {
                arrayList.add(mVar);
            }
        }
        return arrayList;
    }

    public List<m> H(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("name pattern must not be null");
        }
        Matcher matcher = pattern.matcher("");
        ArrayList arrayList = new ArrayList();
        for (m mVar : this.d.i()) {
            if (matcher.reset(mVar.r().f()).matches()) {
                arrayList.add(mVar);
            }
        }
        return arrayList;
    }

    public ArrayList<m> I(String str) {
        if (str == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        ArrayList<m> arrayList = new ArrayList<>();
        Iterator<q> it = L(str).iterator();
        while (it.hasNext()) {
            m mVarD = D(it.next());
            if (mVarD != null) {
                arrayList.add(mVarD);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    protected abstract n J() throws n.a.a.k.a.a;

    public r K() {
        return M(null);
    }

    public r L(String str) throws n.a.a.k.a.b {
        h0();
        if (str != null) {
            return M(str);
        }
        throw new IllegalArgumentException("relationshipType");
    }

    public int N(String str) throws n.a.a.k.a.a {
        return this.d.d(str);
    }

    protected boolean O(m mVar) {
        return this.d.b(mVar.d);
    }

    public void X(m mVar) throws n.a.a.k.a.b {
        a(mVar);
        this.f2281j.a(mVar.r(), mVar.l());
        this.f2282k = true;
    }

    public void Y(m mVar) throws n.a.a.k.a.b {
        if (mVar != null) {
            Z(mVar.r());
        }
    }

    public void Z(o oVar) throws n.a.a.k.a.b {
        m mVarB;
        g0();
        if (oVar == null || !n(oVar)) {
            throw new IllegalArgumentException("partName");
        }
        if (this.d.b(oVar)) {
            this.d.c(oVar).G(true);
            a0(oVar);
        } else {
            a0(oVar);
        }
        this.f2281j.j(oVar);
        if (oVar.j()) {
            URI uriH = s.h(oVar.g());
            try {
                o oVarC = s.c(uriH);
                if (oVarC.g().equals(s.f)) {
                    f();
                } else if (n(oVarC) && (mVarB = B(oVarC)) != null) {
                    mVarB.h();
                }
            } catch (n.a.a.k.a.a unused) {
                C.atError().log("Part name URI '{}' is not valid! This message is not intended to be displayed!", uriH);
                return;
            }
        }
        this.f2282k = true;
    }

    protected m a(m mVar) throws n.a.a.k.a.b {
        g0();
        if (mVar == null) {
            throw new IllegalArgumentException("part");
        }
        if (O(mVar)) {
            if (!this.d.c(mVar.d).z()) {
                throw new n.a.a.k.a.b("A part with the name '" + mVar.d.f() + "' already exists : Packages shall not contain equivalent part names and package implementers shall neither create nor recognize packages with equivalent part names. [M1.12]");
            }
            mVar.G(false);
            this.d.h(mVar.d);
        }
        this.d.g(mVar.d, mVar);
        this.f2282k = true;
        return mVar;
    }

    protected void a0(o oVar) throws n.a.a.k.a.b {
        if (oVar == null) {
            throw new IllegalArgumentException("partName cannot be null");
        }
        g0();
        this.d.h(oVar);
    }

    public void b0() {
        c0();
    }

    public q c(o oVar, v vVar, String str) {
        return d(oVar, vVar, str, null);
    }

    protected abstract void c0();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (l()) {
            return;
        }
        if (this.c == l.READ) {
            C.atDebug().log("The close() method is intended to SAVE a package. This package is open in READ ONLY mode, use the revert() method instead!");
            b0();
            return;
        }
        if (this.f2281j == null) {
            C.atWarn().log("Unable to call close() on a package that hasn't been fully opened yet");
            b0();
            return;
        }
        if (j1.g(this.t)) {
            File file = new File(this.t);
            if (file.exists() && this.t.equalsIgnoreCase(file.getAbsolutePath())) {
                i();
            } else {
                d0(file);
            }
        } else {
            OutputStream outputStream = this.A;
            if (outputStream != null) {
                try {
                    e0(outputStream);
                } finally {
                    this.A.close();
                }
            }
        }
        b0();
        j();
        this.f2281j.f();
    }

    public q d(o oVar, v vVar, String str, String str2) {
        if (str.equals("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties") && this.f2280i != null) {
            throw new n.a.a.k.a.b("OPC Compliance error [M4.1]: can't add another core properties part ! Use the built-in package method instead.");
        }
        if (oVar.j()) {
            throw new n.a.a.k.a.b("Rule M1.25: The Relationships part shall not have relationships to any other part.");
        }
        u();
        q qVarA = this.e.a(oVar.g(), vVar, str, str2);
        this.f2282k = true;
        return qVarA;
    }

    public void d0(File file) throws n.a.a.k.a.b, IOException {
        if (file == null) {
            throw new IllegalArgumentException("targetFile");
        }
        g0();
        if (file.exists() && file.getAbsolutePath().equals(this.t)) {
            throw new n.a.a.k.a.b("You can't call save(File) to save to the currently open file. To save to the current file, please just call close()");
        }
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(file.toPath(), new OpenOption[0]);
        try {
            e0(outputStreamNewOutputStream);
            if (outputStreamNewOutputStream != null) {
                outputStreamNewOutputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamNewOutputStream != null) {
                    try {
                        outputStreamNewOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public void e0(OutputStream outputStream) throws IOException {
        g0();
        f0(outputStream);
    }

    public void f() {
        r rVar = this.e;
        if (rVar != null) {
            rVar.clear();
            this.f2282k = true;
        }
    }

    protected abstract void f0(OutputStream outputStream) throws IOException;

    void g0() throws n.a.a.k.a.b {
        if (this.c == l.READ) {
            throw new n.a.a.k.a.b("Operation not allowed, document open in read only mode!");
        }
    }

    void h0() throws n.a.a.k.a.b {
        if (this.c == l.WRITE) {
            throw new n.a.a.k.a.b("Operation not allowed, document open in write only mode!");
        }
    }

    protected abstract void i() throws IOException;

    public void i0(o oVar) throws n.a.a.k.a.b {
        Z(oVar);
        this.f2281j.j(oVar);
        this.f2282k = true;
    }

    protected void j() {
        this.d.a();
    }

    public abstract boolean l();

    public boolean n(o oVar) {
        return B(oVar) != null;
    }

    public m p(o oVar, String str) {
        return q(oVar, str, true);
    }

    m q(o oVar, String str, boolean z) throws n.a.a.k.a.b {
        g0();
        if (oVar == null) {
            throw new IllegalArgumentException("partName");
        }
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("contentType");
        }
        if (this.d.b(oVar) && !this.d.c(oVar).z()) {
            throw new n.a.a.k.a.h("A part with the name '" + oVar.f() + "' already exists : Packages shall not contain equivalent part names and package implementers shall neither create nor recognize packages with equivalent part names. [M1.12]");
        }
        if (str.equals("application/vnd.openxmlformats-package.core-properties+xml") && this.f2280i != null) {
            throw new n.a.a.k.a.b("OPC Compliance error [M4.1]: you try to add more than one core properties relationship in the package !");
        }
        m mVarS = s(oVar, str, z);
        try {
            this.f2281j.a(s.b("/.xml"), "application/xml");
            this.f2281j.a(s.b("/.rels"), "application/vnd.openxmlformats-package.relationships+xml");
            this.f2281j.a(oVar, str);
            this.d.g(oVar, mVarS);
            this.f2282k = true;
            return mVarS;
        } catch (n.a.a.k.a.a e) {
            throw new n.a.a.k.a.b("unable to create default content-type entries.", e);
        }
    }

    protected abstract m s(o oVar, String str, boolean z);

    public String toString() {
        return "OPCPackage{packageAccess=" + this.c + ", relationships=" + this.e + ", packageProperties=" + this.f2280i + ", isDirty=" + this.f2282k + '}';
    }

    public void u() {
        if (this.e == null) {
            try {
                this.e = new r(this);
            } catch (n.a.a.k.a.a unused) {
                this.e = new r();
            }
        }
    }

    public void w() throws n.a.a.k.a.b {
        g0();
        n.a.a.k.b.z.k kVar = this.f2280i;
        if (kVar != null) {
            kVar.I();
        }
        x();
    }

    protected abstract void x();

    public l y() {
        return this.c;
    }

    public p z() throws n.a.a.k.a.a, n.a.a.k.a.b {
        h0();
        if (this.f2280i == null) {
            this.f2280i = new n.a.a.k.b.z.k(this, s.e);
        }
        return this.f2280i;
    }
}
