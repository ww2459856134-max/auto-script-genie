package n.a.a.k.b;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class q {
    private final String a;
    private final k b;
    private final String c;
    private final m d;
    private final v e;
    private final URI f;

    static {
        try {
            new URI("/_rels/.rels");
        } catch (URISyntaxException unused) {
        }
    }

    public q(k kVar, m mVar, URI uri, v vVar, String str, String str2) {
        Objects.requireNonNull(kVar, "pkg cannot be null");
        Objects.requireNonNull(uri, "targetUri cannot be null");
        Objects.requireNonNull(str, "relationshipType cannot be null");
        Objects.requireNonNull(str2, "id cannot be null");
        this.b = kVar;
        this.d = mVar;
        this.f = uri;
        this.e = vVar;
        this.c = str;
        this.a = str2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public URI c() {
        m mVar = this.d;
        return mVar == null ? s.f : mVar.d.g();
    }

    public v d() {
        return this.e;
    }

    public URI e() {
        return this.e == v.EXTERNAL ? this.f : "http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink".equals(this.c) ? this.f : !this.f.toASCIIString().startsWith("/") ? s.m(c(), this.f) : this.f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (!this.a.equals(qVar.a) || !this.c.equals(qVar.c)) {
            return false;
        }
        m mVar = qVar.d;
        return (mVar == null || mVar.equals(this.d)) && this.e == qVar.e && this.f.equals(qVar.f);
    }

    public int hashCode() {
        return Objects.hash(this.a, this.c, this.d, this.e, this.f);
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(this.a);
        sb.append(" - container=");
        sb.append(this.b);
        sb.append(" - relationshipType=");
        sb.append(this.c);
        if (this.d == null) {
            str = " - source=null";
        } else {
            str = " - source=" + c().toASCIIString();
        }
        sb.append(str);
        sb.append(" - target=");
        sb.append(e().toASCIIString());
        if (this.e == null) {
            str2 = ",targetMode=null";
        } else {
            str2 = ",targetMode=" + this.e;
        }
        sb.append(str2);
        return sb.toString();
    }
}
