package n.a.a.k.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Comparable<n.a.a.k.b.m>] */
/* loaded from: classes.dex */
public abstract class m implements Object {
    protected k c;
    protected o d;
    protected n.a.a.k.b.z.c e;
    private final boolean f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private r f2283h;

    protected m(k kVar, o oVar, n.a.a.k.b.z.c cVar) throws n.a.a.k.a.a {
        this(kVar, oVar, cVar, true);
    }

    private void H() throws n.a.a.k.a.b {
        if (this.f) {
            throw new n.a.a.k.a.b("Can do this operation on a relationship part !");
        }
    }

    private r w(String str) throws n.a.a.k.a.a, n.a.a.k.a.b {
        this.c.h0();
        if (this.f2283h == null) {
            H();
            this.f2283h = new r(this);
        }
        return new r(this.f2283h, str);
    }

    public boolean A(q qVar) {
        return (qVar == null || this.f2283h.h(qVar.a()) == null) ? false : true;
    }

    public boolean B() {
        return this.f;
    }

    void C() throws n.a.a.k.a.a {
        if (this.f2283h != null || this.f) {
            return;
        }
        H();
        this.f2283h = new r(this);
    }

    public void D(String str) throws n.a.a.k.a.b {
        this.c.g0();
        r rVar = this.f2283h;
        if (rVar != null) {
            rVar.p(str);
        }
    }

    public abstract boolean E(OutputStream outputStream) throws n.a.a.k.a.f;

    public void F(String str) throws n.a.a.k.a.a, n.a.a.k.a.b {
        k kVar = this.c;
        if (kVar == null) {
            this.e = new n.a.a.k.b.z.c(str);
            return;
        }
        kVar.i0(this.d);
        this.e = new n.a.a.k.b.z.c(str);
        this.c.X(this);
    }

    public void G(boolean z) {
        this.g = z;
    }

    public q b(String str, String str2) {
        return c(str, str2, null);
    }

    public q c(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException("target is null for type " + str2);
        }
        if (str2 == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        if (this.f2283h == null) {
            this.f2283h = new r();
        }
        try {
            return this.f2283h.a(new URI(str), v.EXTERNAL, str2, str3);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid target - " + e);
        }
    }

    public q d(URI uri, v vVar, String str, String str2) throws n.a.a.k.a.b {
        this.c.g0();
        if (uri == null) {
            throw new IllegalArgumentException("targetPartName");
        }
        if (vVar == null) {
            throw new IllegalArgumentException("targetMode");
        }
        if (str == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        if (this.f || s.j(uri)) {
            throw new n.a.a.k.a.b("Rule M1.25: The Relationships part shall not have relationships to any other part.");
        }
        if (this.f2283h == null) {
            this.f2283h = new r();
        }
        return this.f2283h.a(uri, vVar, str, str2);
    }

    public q e(o oVar, v vVar, String str) {
        return f(oVar, vVar, str, null);
    }

    public q f(o oVar, v vVar, String str, String str2) throws n.a.a.k.a.b {
        this.c.g0();
        if (oVar == null) {
            throw new IllegalArgumentException("targetPartName");
        }
        if (vVar == null) {
            throw new IllegalArgumentException("targetMode");
        }
        if (str == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        if (this.f || oVar.j()) {
            throw new n.a.a.k.a.b("Rule M1.25: The Relationships part shall not have relationships to any other part.");
        }
        if (this.f2283h == null) {
            this.f2283h = new r();
        }
        return this.f2283h.a(oVar.g(), vVar, str, str2);
    }

    public void g() {
    }

    public void h() {
        r rVar = this.f2283h;
        if (rVar != null) {
            rVar.clear();
        }
    }

    public abstract void i();

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(m mVar) {
        if (mVar == null) {
            return -1;
        }
        return o.c(this.d, mVar.d);
    }

    public q k(m mVar) {
        return this.f2283h.e(mVar);
    }

    public String l() {
        return this.e.toString();
    }

    public InputStream m() throws IOException {
        InputStream inputStreamN = n();
        if (inputStreamN != null) {
            return inputStreamN;
        }
        throw new IOException("Can't obtain the input stream from " + this.d.f());
    }

    protected abstract InputStream n() throws IOException;

    public OutputStream o() throws IOException {
        if (!(this instanceof y)) {
            return p();
        }
        this.c.Z(this.d);
        m mVarQ = this.c.q(this.d, this.e.toString(), false);
        if (mVarQ == null) {
            throw new n.a.a.k.a.b("Can't create a temporary part !");
        }
        mVarQ.f2283h = this.f2283h;
        return mVarQ.p();
    }

    protected abstract OutputStream p() throws IOException;

    public k q() {
        return this.c;
    }

    public o r() {
        return this.d;
    }

    public m s(q qVar) throws n.a.a.k.a.a, n.a.a.k.a.b, IOException {
        if (!A(qVar)) {
            throw new IllegalArgumentException("Relationship " + qVar + " doesn't start with this part " + this.d);
        }
        URI uriE = qVar.e();
        if (uriE.getFragment() != null) {
            String string = uriE.toString();
            try {
                uriE = new URI(string.substring(0, string.indexOf(35)));
            } catch (URISyntaxException unused) {
                throw new n.a.a.k.a.a("Invalid target URI: " + uriE);
            }
        }
        m mVarB = this.c.B(s.c(uriE));
        if (mVarB != null) {
            return mVarB;
        }
        throw new IllegalArgumentException("No part found for relationship " + qVar);
    }

    public q t(String str) {
        return this.f2283h.h(str);
    }

    public String toString() {
        return "Name: " + this.d + " - Content Type: " + this.e;
    }

    public r u() throws n.a.a.k.a.a {
        return w(null);
    }

    public r v(String str) throws n.a.a.k.a.a {
        this.c.h0();
        return w(str);
    }

    public long x() {
        return -1L;
    }

    public boolean y() {
        r rVar;
        return (this.f || (rVar = this.f2283h) == null || rVar.isEmpty()) ? false : true;
    }

    public boolean z() {
        return this.g;
    }

    protected m(k kVar, o oVar, n.a.a.k.b.z.c cVar, boolean z) throws n.a.a.k.a.a {
        this.d = oVar;
        this.e = cVar;
        this.c = kVar;
        this.f = oVar.j();
        if (z) {
            C();
        }
    }

    public m(k kVar, o oVar, String str) throws n.a.a.k.a.a {
        this(kVar, oVar, new n.a.a.k.b.z.c(str));
    }
}
