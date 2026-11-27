package n.a.a.k.b;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.message.Message;
import com.auto.exceldeps.log4j.message.SimpleMessage;
import com.auto.exceldeps.log4j.util.Supplier;
import i.b.ha.a.b.d.c.o1;
import i.b.ha.a.b.d.c.w1;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import n.a.a.o.k1;
import n.a.a.o.w0;

/* loaded from: classes.dex */
public final class x extends k {
    private static boolean H;
    private static boolean I;
    private static final Logger J = n.a.a.i.b.a(x.class);
    private final n.a.a.k.c.c G;

    public x() {
        this(j.a());
    }

    private synchronized String l0(File file) {
        File file2;
        do {
            file2 = new File(file.getAbsoluteFile() + File.separator + "OpenXML4J" + System.nanoTime());
        } while (file2.exists());
        return n.a.a.k.b.z.f.c(file2.getAbsoluteFile());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n0(o1 o1Var) {
        String name = o1Var.getName();
        return name.startsWith("[trash]") || name.endsWith("/");
    }

    static /* synthetic */ boolean o0(o1 o1Var) {
        return !n0(o1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ w q0(o1 o1Var) {
        return new w(this, o1Var, this.f2281j);
    }

    static /* synthetic */ boolean r0(w wVar) {
        return wVar.d != null;
    }

    static /* synthetic */ Message s0(o oVar) {
        return new SimpleMessage("Save part '" + n.a.a.k.b.z.q.d(oVar.f()) + "'");
    }

    private static n.a.a.k.c.c t0(File file) throws Throwable {
        try {
            InputStream inputStreamNewInputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);
            n.a.a.k.c.b bVarG = null;
            try {
                bVarG = n.a.a.k.b.z.q.g(inputStreamNewInputStream);
                return new n.a.a.k.c.e(bVarG);
            } catch (n.a.a.d e) {
                e = e;
                w0.f(inputStreamNewInputStream);
                w0.f(bVarG);
                throw e;
            } catch (n.a.a.k.a.b e2) {
                e = e2;
                w0.f(inputStreamNewInputStream);
                w0.f(bVarG);
                throw e;
            } catch (Exception e3) {
                w0.f(inputStreamNewInputStream);
                w0.f(bVarG);
                throw new n.a.a.k.a.b("Failed to read the file input stream from file: '" + file + "'", e3);
            }
        } catch (IOException e4) {
            throw new n.a.a.k.a.b("Can't open the specified file input stream from file: '" + file + "'", e4);
        }
    }

    @Override // n.a.a.k.b.k
    protected n J() throws n.a.a.k.a.a {
        n nVar = new n();
        n.a.a.k.c.c cVar = this.G;
        if (cVar == null) {
            return nVar;
        }
        o1 o1VarK = cVar.k("[Content_Types].xml");
        if (o1VarK == null) {
            boolean z = this.G.k("mimetype") != null;
            boolean z2 = this.G.k("settings.xml") != null;
            if (z && z2) {
                throw new n.a.a.k.a.d("The supplied data appears to be in ODF (Open Document) Format. Formats like these (eg ODS, ODP) are not supported, try Apache ODFToolkit");
            }
            if (this.G.A().hasMoreElements()) {
                throw new n.a.a.k.a.a("Package should contain a content type part [M1.13]");
            }
            throw new n.a.a.k.a.c("No valid entries or contents found, this is not a valid OOXML (Office Open XML) file");
        }
        if (this.f2281j != null) {
            throw new n.a.a.k.a.a("ContentTypeManager can only be created once. This must be a cyclic relation?");
        }
        try {
            this.f2281j = new n.a.a.k.b.z.o(this.G.v(o1VarK), this);
            ArrayList list = Collections.list(this.G.A());
            if (list.size() > n.a.a.k.c.f.L()) {
                throw new n.a.a.k.a.a(String.format(Locale.ROOT, "The file appears to be potentially malicious. This file embeds more internal file entries than expected.\nThis may indicates that the file could pose a security risk.\nYou can adjust this limit via ZipSecureFile.setMaxFileCount() if you need to work with files which are very large.\nLimits: MAX_FILE_COUNT: %d", Long.valueOf(n.a.a.k.c.f.L())));
            }
            Iterator it = ((List) list.stream().filter(new Predicate() { // from class: n.a.a.k.b.f
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return x.o0((o1) obj);
                }
            }).map(new Function() { // from class: n.a.a.k.b.g
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.q0((o1) obj);
                }
            }).filter(new Predicate() { // from class: n.a.a.k.b.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return x.r0((w) obj);
                }
            }).sorted().collect(Collectors.toList())).iterator();
            while (it.hasNext()) {
                ((w) it.next()).b(nVar);
            }
            return nVar;
        } catch (IOException e) {
            throw new n.a.a.k.a.a(e.getMessage(), e);
        }
    }

    @Override // n.a.a.k.b.k
    protected void c0() {
        try {
            n.a.a.k.c.c cVar = this.G;
            if (cVar != null) {
                cVar.close();
            }
        } catch (IOException unused) {
        }
    }

    @Override // n.a.a.k.b.k
    public void f0(OutputStream outputStream) throws n.a.a.k.a.b, n.a.a.k.a.f {
        g0();
        w1 w1Var = outputStream instanceof w1 ? (w1) outputStream : new w1(outputStream);
        try {
            if (I("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties").isEmpty() && I("http://schemas.openxmlformats.org/officedocument/2006/relationships/metadata/core-properties").isEmpty()) {
                J.atDebug().log("Save core properties part");
                z();
                if (!O(this.f2280i)) {
                    a(this.f2280i);
                }
                this.e.a(this.f2280i.r().g(), v.INTERNAL, "http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties", null);
                if (!this.f2281j.h("application/vnd.openxmlformats-package.core-properties+xml")) {
                    this.f2281j.a(this.f2280i.r(), "application/vnd.openxmlformats-package.core-properties+xml");
                }
            }
            Logger logger = J;
            logger.atDebug().log("Save content types part");
            if (!this.f2281j.k(w1Var)) {
                throw new n.a.a.k.a.g("Failed to save: content types part");
            }
            logger.atDebug().log("Save package relationships");
            if (!n.a.a.k.b.z.r.e.b(K(), s.c, w1Var)) {
                throw new n.a.a.k.a.g("Failed to save: package relationships part");
            }
            Iterator<m> it = F().iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (!next.B()) {
                    final o oVarR = next.r();
                    J.atDebug().log(new Supplier() { // from class: n.a.a.k.b.e
                        @Override // com.auto.exceldeps.log4j.util.Supplier, java.util.function.Supplier
                        public final Object get() {
                            return x.s0(oVarR);
                        }
                    });
                    n.a.a.k.b.z.l lVar = this.f.get(next.e);
                    if (lVar == null) {
                        lVar = this.g;
                    }
                    if (!lVar.a(next, w1Var)) {
                        throw new n.a.a.k.a.f("The part " + oVarR.g() + " failed to be saved in the stream with marshaller " + lVar + ". Enable logging via Log4j 2 for more details.");
                    }
                }
            }
            w1Var.p();
        } catch (n.a.a.k.a.g e) {
            throw e;
        } catch (Exception e2) {
            throw new n.a.a.k.a.g("Fail to save: an error occurs while saving the package : " + e2.getMessage(), e2);
        }
    }

    @Override // n.a.a.k.b.k
    protected void i() throws IOException {
        try {
            w();
            String str = this.t;
            if (str == null || str.isEmpty()) {
                w0.f(this.G);
                return;
            }
            File file = new File(this.t);
            if (!file.exists()) {
                w0.f(this.G);
                throw new n.a.a.k.a.b("Can't close a package not previously open with the open() method !");
            }
            try {
                File fileA = k1.a(l0(n.a.a.k.b.z.f.b(file)), ".tmp");
                try {
                    d0(fileA);
                    w0.f(this.G);
                    try {
                        n.a.a.k.b.z.f.a(fileA, file);
                        j();
                    } finally {
                        if (!fileA.delete()) {
                            J.atWarn().log("The temporary file: '{}' cannot be deleted ! Make sure that no other application use it.", file.getAbsolutePath());
                        }
                    }
                } catch (Throwable th) {
                    w0.f(this.G);
                    if (!fileA.delete()) {
                        J.atWarn().log("The temporary file: '{}' cannot be deleted ! Make sure that no other application use it.", file.getAbsolutePath());
                    }
                    throw th;
                }
            } catch (IOException | Error | RuntimeException e) {
                w0.f(this.G);
                throw e;
            }
        } catch (Error | RuntimeException e2) {
            w0.f(this.G);
            throw e2;
        }
    }

    @Override // n.a.a.k.b.k
    public boolean l() {
        n.a.a.k.c.c cVar = this.G;
        return cVar != null && cVar.l();
    }

    public n.a.a.k.c.c m0() {
        return this.G;
    }

    @Override // n.a.a.k.b.k
    protected m s(o oVar, String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("contentType cannot be null");
        }
        if (oVar == null) {
            throw new IllegalArgumentException("partName cannot be null");
        }
        try {
            return H ? I ? new n.a.a.k.b.z.e(this, oVar, str, z) : new n.a.a.k.b.z.n(this, oVar, str, z) : new n.a.a.k.b.z.h(this, oVar, str, z);
        } catch (Exception e) {
            J.atWarn().withThrowable(e).log("Failed to create part {}", oVar);
            return null;
        }
    }

    @Override // n.a.a.k.b.k
    protected void x() {
    }

    public x(j jVar) {
        super(k.D, jVar);
        this.G = null;
        try {
            this.f2281j = new n.a.a.k.b.z.o(null, this);
        } catch (n.a.a.k.a.a e) {
            J.atWarn().withThrowable(e).log("Could not parse ZipPackage");
        }
    }

    x(InputStream inputStream, l lVar, boolean z, j jVar) throws IOException {
        super(lVar, jVar);
        n.a.a.k.c.b bVarH = n.a.a.k.b.z.q.h(inputStream, z);
        try {
            this.G = new n.a.a.k.c.e(bVarH);
            if (bVarH != null) {
                bVarH.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (bVarH != null) {
                    try {
                        bVarH.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    x(String str, l lVar, j jVar) throws n.a.a.k.a.b {
        this(new File(str), lVar, jVar);
    }

    x(File file, l lVar, j jVar) throws Throwable {
        n.a.a.k.c.c cVarT0;
        super(lVar, jVar);
        try {
            cVarT0 = new n.a.a.k.c.d(n.a.a.k.b.z.q.f(file));
        } catch (n.a.a.k.b.z.g e) {
            throw new n.a.a.k.a.b("Can't open the specified file: '" + file + "'", e);
        } catch (IOException e2) {
            if (lVar != l.WRITE) {
                J.atWarn().log("Error in zip file {} - falling back to stream processing (i.e. ignoring zip central directory)", file);
                cVarT0 = t0(file);
            } else {
                throw new n.a.a.k.a.b("Can't open the specified file: '" + file + "'", e2);
            }
        }
        this.G = cVarT0;
    }
}
