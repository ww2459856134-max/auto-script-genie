package l.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import l.a.a.c.b;
import l.a.a.d.e;
import l.a.a.f.l;
import l.a.a.f.q;
import l.a.a.f.s;
import l.a.a.f.t.f;
import l.a.a.g.d;
import l.a.a.h.g;
import l.a.a.h.h;
import l.a.a.h.i;
import l.a.a.h.k;
import l.a.a.h.m;
import l.a.a.h.n;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class a implements Closeable {
    private int A;
    private List<InputStream> C;
    private boolean D;
    private File c;
    private q d;
    private boolean e;
    private d f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private char[] f2185h;

    /* renamed from: i, reason: collision with root package name */
    private e f2186i;

    /* renamed from: j, reason: collision with root package name */
    private Charset f2187j;

    /* renamed from: k, reason: collision with root package name */
    private ThreadFactory f2188k;
    private ExecutorService t;

    public a(String str) {
        this(new File(str), (char[]) null);
    }

    private void f(File file, s sVar, boolean z) throws IOException {
        u();
        q qVar = this.d;
        if (qVar == null) {
            throw new b("internal error: zip model is null");
        }
        if (z && qVar.h()) {
            throw new b("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
        new i(this.d, this.f2185h, this.f2186i, i()).e(new h(file, sVar, j()));
    }

    private k i() {
        if (this.g) {
            if (this.f2188k == null) {
                this.f2188k = Executors.defaultThreadFactory();
            }
            this.t = Executors.newSingleThreadExecutor(this.f2188k);
        }
        return new k(this.t, this.g, this.f);
    }

    private l j() {
        return new l(this.f2187j, this.A, this.D);
    }

    private void m() {
        q qVar = new q();
        this.d = qVar;
        qVar.q(this.c);
    }

    private RandomAccessFile q() throws IOException {
        if (!l.a.a.i.d.t(this.c)) {
            return new RandomAccessFile(this.c, f.READ.a());
        }
        l.a.a.e.a.h hVar = new l.a.a.e.a.h(this.c, f.READ.a(), l.a.a.i.d.h(this.c));
        hVar.c();
        return hVar;
    }

    private void u() throws IOException {
        if (this.d != null) {
            return;
        }
        if (!this.c.exists()) {
            m();
            return;
        }
        if (!this.c.canRead()) {
            throw new b("no read access for the input zip file");
        }
        try {
            RandomAccessFile randomAccessFileQ = q();
            try {
                q qVarH = new l.a.a.d.b().h(randomAccessFileQ, j());
                this.d = qVarH;
                qVarH.q(this.c);
                if (randomAccessFileQ != null) {
                    randomAccessFileQ.close();
                }
            } catch (Throwable th) {
                if (randomAccessFileQ != null) {
                    try {
                        randomAccessFileQ.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (b e) {
            throw e;
        } catch (IOException e2) {
            throw new b(e2);
        }
    }

    public void a(File file, s sVar) throws b {
        c(Collections.singletonList(file), sVar);
    }

    public void c(List<File> list, s sVar) throws IOException {
        if (list == null || list.size() == 0) {
            throw new b("input file List is null or empty");
        }
        if (sVar == null) {
            throw new b("input parameters are null");
        }
        u();
        if (this.d == null) {
            throw new b("internal error: zip model is null");
        }
        if (this.c.exists() && this.d.h()) {
            throw new b("Zip file already exists. Zip file format does not allow updating split/spanned files");
        }
        new g(this.d, this.f2185h, this.f2186i, i()).e(new l.a.a.h.f(list, sVar, j()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<InputStream> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
        this.C.clear();
    }

    public void d(File file, s sVar) throws b {
        if (file == null) {
            throw new b("input path is null, cannot add folder to zip file");
        }
        if (!file.exists()) {
            throw new b("folder does not exist");
        }
        if (!file.isDirectory()) {
            throw new b("input folder is not a directory");
        }
        if (!file.canRead()) {
            throw new b("cannot read input folder");
        }
        if (sVar == null) {
            throw new b("input parameters are null, cannot add folder to zip file");
        }
        f(file, sVar, true);
    }

    public void n(String str) throws b {
        o(str, new l.a.a.f.k());
    }

    public void o(String str, l.a.a.f.k kVar) throws IOException {
        if (!l.a.a.i.i.j(str)) {
            throw new b("output path is null or invalid");
        }
        if (!l.a.a.i.i.d(new File(str))) {
            throw new b("invalid output path");
        }
        if (this.d == null) {
            u();
        }
        q qVar = this.d;
        if (qVar == null) {
            throw new b("Internal error occurred when extracting zip file");
        }
        new n(qVar, this.f2185h, kVar, i()).e(new m(str, j()));
    }

    public List<l.a.a.f.i> p() throws IOException {
        u();
        q qVar = this.d;
        return (qVar == null || qVar.a() == null) ? Collections.emptyList() : this.d.a().a();
    }

    public boolean s() throws IOException {
        if (this.d == null) {
            u();
            if (this.d == null) {
                throw new b("Zip Model is null");
            }
        }
        if (this.d.a() == null || this.d.a().a() == null) {
            throw new b("invalid zip file");
        }
        Iterator<l.a.a.f.i> it = this.d.a().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            l.a.a.f.i next = it.next();
            if (next != null && next.s()) {
                this.e = true;
                break;
            }
        }
        return this.e;
    }

    public String toString() {
        return this.c.toString();
    }

    public void w(Charset charset) throws IllegalArgumentException {
        if (charset == null) {
            throw new IllegalArgumentException("charset cannot be null");
        }
        this.f2187j = charset;
    }

    public void x(char[] cArr) {
        this.f2185h = cArr;
    }

    public a(String str, char[] cArr) {
        this(new File(str), cArr);
    }

    public a(File file, char[] cArr) {
        this.f2186i = new e();
        this.f2187j = null;
        this.A = XMLEvent.CHANGE_PREFIX_MAPPING;
        this.C = new ArrayList();
        this.D = true;
        if (file != null) {
            this.c = file;
            this.f2185h = cArr;
            this.g = false;
            this.f = new d();
            return;
        }
        throw new IllegalArgumentException("input zip file parameter is null");
    }
}
