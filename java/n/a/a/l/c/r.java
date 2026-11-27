package n.a.a.l.c;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import n.a.a.o.d1;

/* loaded from: classes.dex */
public class r extends e {
    private final q a;
    private s b;
    private final List<n.a.a.l.f.c> c;
    private final n.a.a.l.f.d d;
    private final n.a.a.l.e.g e;

    r(q qVar, n.a.a.l.e.g gVar, List<n.a.a.l.f.c> list, n.a.a.l.f.d dVar) {
        if (gVar == null) {
            throw new d1("Invalid argument to POIFSMiniStore: root is null");
        }
        this.a = qVar;
        this.c = list;
        this.d = dVar;
        this.e = gVar;
        this.b = new s(qVar, gVar.g());
    }

    private int o() {
        int iA = this.a.x().a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            int iC = this.c.get(size).c();
            if (iC > 0) {
                return (size * iA) + iC;
            }
        }
        return 0;
    }

    @Override // n.a.a.l.c.e
    protected ByteBuffer a(int i2) throws IOException, ArrayIndexOutOfBoundsException {
        boolean z = this.b.p() == -2;
        if (!z) {
            try {
                return c(i2);
            } catch (NoSuchElementException unused) {
            }
        }
        int i3 = this.a.i();
        this.a.a(i3);
        if (z) {
            this.a.o().c().z(i3);
            this.b = new s(this.a, i3);
        } else {
            d dVarF = this.a.f();
            int iP = this.b.p();
            while (true) {
                dVarF.a(iP);
                int iJ = this.a.j(iP);
                if (iJ == -2) {
                    break;
                }
                iP = iJ;
            }
            this.a.n(iP, i3);
        }
        this.a.n(i3, -2);
        return a(i2);
    }

    @Override // n.a.a.l.c.e
    protected ByteBuffer c(int i2) throws IOException {
        int i3 = i2 * 64;
        int iW = i3 / this.a.w();
        int iW2 = i3 % this.a.w();
        Iterator<Integer> itK = this.b.k();
        for (int i4 = 0; i4 < iW; i4++) {
            itK.next();
        }
        ByteBuffer byteBufferC = this.a.c(itK.next().intValue());
        byteBufferC.position(byteBufferC.position() + iW2);
        ByteBuffer byteBufferSlice = byteBufferC.slice();
        byteBufferSlice.limit(64);
        return byteBufferSlice;
    }

    @Override // n.a.a.l.c.e
    protected int d() {
        return 64;
    }

    @Override // n.a.a.l.c.e
    protected d f() {
        return new d(this, this.e.e());
    }

    @Override // n.a.a.l.c.e
    protected int i() throws IOException {
        int iA = this.a.x().a();
        int i2 = 0;
        for (n.a.a.l.f.c cVar : this.c) {
            if (cVar.g()) {
                for (int i3 = 0; i3 < iA; i3++) {
                    if (cVar.f(i3) == -1) {
                        return i2 + i3;
                    }
                }
            }
            i2 += iA;
        }
        n.a.a.l.f.c cVarA = n.a.a.l.f.c.a(this.a.x(), false);
        int i4 = this.a.i();
        cVarA.j(i4);
        if (this.d.e() == 0) {
            this.d.l(i4);
            this.d.k(1);
        } else {
            d dVarF = this.a.f();
            int iF = this.d.f();
            while (true) {
                dVarF.a(iF);
                int iJ = this.a.j(iF);
                if (iJ == -2) {
                    break;
                }
                iF = iJ;
            }
            this.a.n(iF, i4);
            n.a.a.l.f.d dVar = this.d;
            dVar.k(dVar.e() + 1);
        }
        this.a.n(i4, -2);
        this.c.add(cVarA);
        return i2;
    }

    @Override // n.a.a.l.c.e
    protected int j(int i2) {
        n.a.a.l.f.b bVarP = p(i2);
        return bVarP.a().f(bVarP.b());
    }

    @Override // n.a.a.l.c.e
    protected void m(ByteBuffer byteBuffer) {
        this.a.m(byteBuffer);
    }

    @Override // n.a.a.l.c.e
    protected void n(int i2, int i3) {
        n.a.a.l.f.b bVarP = p(i2);
        bVarP.a().k(bVarP.b(), i3);
    }

    protected n.a.a.l.f.b p(int i2) {
        return n.a.a.l.f.c.e(i2, this.d, this.c);
    }

    void q() throws IOException {
        for (n.a.a.l.f.c cVar : this.c) {
            cVar.l(this.a.c(cVar.d()));
        }
        this.a.o().c().w(o());
    }
}
