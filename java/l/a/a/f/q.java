package l.a.a.f;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class q implements Cloneable {
    private List<j> c = new ArrayList();
    private c d;
    private f e;
    private m f;
    private n g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2230h;

    /* renamed from: i, reason: collision with root package name */
    private long f2231i;

    /* renamed from: j, reason: collision with root package name */
    private File f2232j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2233k;

    public q() {
        new ArrayList();
        this.d = new c();
        this.e = new f();
        this.f = new m();
        this.g = new n();
        this.f2233k = false;
        this.f2231i = -1L;
    }

    public c a() {
        return this.d;
    }

    public f b() {
        return this.e;
    }

    public List<j> c() {
        return this.c;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public long d() {
        return this.f2231i;
    }

    public m e() {
        return this.f;
    }

    public n f() {
        return this.g;
    }

    public File g() {
        return this.f2232j;
    }

    public boolean h() {
        return this.f2230h;
    }

    public boolean i() {
        return this.f2233k;
    }

    public void j(c cVar) {
        this.d = cVar;
    }

    public void k(f fVar) {
        this.e = fVar;
    }

    public void l(boolean z) {
        this.f2230h = z;
    }

    public void m(long j2) {
        this.f2231i = j2;
    }

    public void n(m mVar) {
        this.f = mVar;
    }

    public void o(n nVar) {
        this.g = nVar;
    }

    public void p(boolean z) {
        this.f2233k = z;
    }

    public void q(File file) {
        this.f2232j = file;
    }
}
