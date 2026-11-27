package n.a.a.l.c;

import com.auto.exceldeps.log4j.Logger;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n.a.a.o.w0;

/* loaded from: classes.dex */
public class q extends e implements Closeable {

    /* renamed from: k, reason: collision with root package name */
    private static int f2316k = 100000;
    private static final Logger t = n.a.a.i.b.a(q.class);
    private r c;
    private n.a.a.l.e.f d;
    private final List<n.a.a.l.f.c> e;
    private final List<n.a.a.l.f.c> f;
    private n.a.a.l.f.d g;

    /* renamed from: h, reason: collision with root package name */
    private f f2317h;

    /* renamed from: i, reason: collision with root package name */
    protected n.a.a.l.d.b f2318i;

    /* renamed from: j, reason: collision with root package name */
    private n.a.a.l.a.a f2319j;

    private q(boolean z) {
        n.a.a.l.a.a aVar = n.a.a.l.a.b.a;
        this.f2319j = aVar;
        this.g = new n.a.a.l.f.d(aVar);
        this.d = new n.a.a.l.e.f(this.g);
        this.c = new r(this, this.d.c(), new ArrayList(), this.g);
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.f2317h = null;
        if (z) {
            s();
        }
    }

    private void D() throws IOException {
        this.c.q();
        s sVar = new s(this, this.g.d());
        this.d.e();
        this.d.g(sVar);
        i.b.ha.a.c.k.j jVar = i.b.ha.a.c.k.j.p().p(this.g.c().b()).get();
        this.g.o(jVar);
        c(-1).put(jVar.d());
        for (n.a.a.l.f.c cVar : this.f) {
            cVar.l(c(cVar.d()));
        }
        for (n.a.a.l.f.c cVar2 : this.e) {
            cVar2.l(c(cVar2.d()));
        }
    }

    private n.a.a.l.f.c q(int i2, boolean z) throws IOException {
        n.a.a.l.f.c cVarA = n.a.a.l.f.c.a(this.f2319j, !z);
        cVarA.j(i2);
        this.f2318i.e(ByteBuffer.allocate(this.f2319j.b()), Math.multiplyExact(i2 + 1, this.f2319j.b()));
        return cVarA;
    }

    public static int y() {
        return f2316k;
    }

    public f B() {
        if (this.f2317h == null) {
            this.f2317h = new f(this.d.c(), this, null);
        }
        return this.f2317h;
    }

    public void F(OutputStream outputStream) throws IOException {
        D();
        this.f2318i.b(outputStream);
    }

    @Override // n.a.a.l.c.e
    protected ByteBuffer a(int i2) throws IOException {
        try {
            return c(i2);
        } catch (IndexOutOfBoundsException unused) {
            this.f2318i.e(ByteBuffer.allocate(w()), (i2 + 1) * this.f2319j.b());
            return c(i2);
        }
    }

    @Override // n.a.a.l.c.e
    protected ByteBuffer c(int i2) throws IOException {
        try {
            return this.f2318i.c(this.f2319j.b(), (i2 + 1) * this.f2319j.b());
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Block " + i2 + " not found");
            indexOutOfBoundsException.initCause(e);
            throw indexOutOfBoundsException;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2318i.a();
    }

    @Override // n.a.a.l.c.e
    protected int d() {
        return w();
    }

    @Override // n.a.a.l.c.e
    protected d f() throws IOException {
        return new d(this, this.f2318i.d());
    }

    @Override // n.a.a.l.c.e
    protected int i() throws IOException {
        int iA = this.f2319j.a();
        int i2 = 0;
        int i3 = 0;
        for (n.a.a.l.f.c cVar : this.f) {
            if (cVar.g()) {
                for (int i4 = 0; i4 < iA; i4++) {
                    if (cVar.f(i4) == -1) {
                        return i3 + i4;
                    }
                }
            }
            i3 += iA;
        }
        n.a.a.l.f.c cVarQ = q(i3, true);
        cVarQ.k(0, -3);
        this.f.add(cVarQ);
        if (this.g.b() >= 109) {
            n.a.a.l.f.c cVar2 = null;
            Iterator<n.a.a.l.f.c> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n.a.a.l.f.c next = it.next();
                if (next.g()) {
                    cVar2 = next;
                    break;
                }
            }
            if (cVar2 == null) {
                int i5 = i3 + 1;
                n.a.a.l.f.c cVarQ2 = q(i5, false);
                cVarQ2.k(0, i3);
                cVarQ.k(1, -4);
                if (this.e.isEmpty()) {
                    this.g.n(i5);
                } else {
                    List<n.a.a.l.f.c> list = this.e;
                    list.get(list.size() - 1).k(this.f2319j.d(), i5);
                }
                this.e.add(cVarQ2);
                this.g.m(this.e.size());
                i3 = i5;
            } else {
                while (true) {
                    if (i2 >= this.f2319j.d()) {
                        break;
                    }
                    if (cVar2.f(i2) == -1) {
                        cVar2.k(i2, i3);
                        break;
                    }
                    i2++;
                }
            }
        } else {
            int iB = this.g.b() + 1;
            int[] iArr = new int[iB];
            int i6 = iB - 1;
            System.arraycopy(this.g.a(), 0, iArr, 0, i6);
            iArr[i6] = i3;
            this.g.g(iArr);
        }
        this.g.h(this.f.size());
        return i3 + 1;
    }

    @Override // n.a.a.l.c.e
    protected int j(int i2) {
        n.a.a.l.f.b bVarU = u(i2);
        return bVarU.a().f(bVarU.b());
    }

    @Override // n.a.a.l.c.e
    protected void m(ByteBuffer byteBuffer) {
    }

    @Override // n.a.a.l.c.e
    protected void n(int i2, int i3) {
        n.a.a.l.f.b bVarU = u(i2);
        bVarU.a().k(bVarU.b(), i3);
    }

    n.a.a.l.e.f o() {
        return this.d;
    }

    void p(o oVar) {
        this.d.a(oVar.b());
    }

    protected void s() {
        this.f2318i = new n.a.a.l.d.a(w0.l(Math.multiplyExact(this.f2319j.b(), 3L), f2316k));
    }

    protected n.a.a.l.f.b u(int i2) {
        return n.a.a.l.f.c.b(i2, this.g, this.f);
    }

    public int w() {
        return this.f2319j.b();
    }

    public n.a.a.l.a.a x() {
        return this.f2319j;
    }

    r z() {
        return this.c;
    }

    public q() {
        this(true);
        this.g.h(1);
        this.g.g(new int[]{1});
        n.a.a.l.f.c cVarA = n.a.a.l.f.c.a(this.f2319j, false);
        cVarA.j(1);
        this.f.add(cVarA);
        n(0, -2);
        n(1, -3);
        this.d.f(0);
    }
}
