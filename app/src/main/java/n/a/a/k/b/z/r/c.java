package n.a.a.k.b.z.r;

import com.tencent.open.SocialConstants;
import java.io.OutputStream;
import java.util.Optional;
import n.a.a.k.a.f;
import n.a.a.k.b.m;
import n.a.a.k.b.z.k;
import n.a.a.k.b.z.l;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes.dex */
public abstract class c implements l {
    private static final b c = new b("dc", "http://purl.org/dc/elements/1.1/");
    private static final b d = new b("cp", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    private static final b e = new b("dcterms", "http://purl.org/dc/terms/");
    private static final b f = new b("xsi", "http://www.w3.org/2001/XMLSchema-instance");
    k a;
    Document b;

    private void b() {
        s("category", d, this.a.J());
    }

    private void c() {
        s("contentStatus", d, this.a.K());
    }

    private void d() {
        s("contentType", d, this.a.L());
    }

    private void e() throws DOMException {
        u("created", e, this.a.M(), this.a.N(), "dcterms:W3CDTF");
    }

    private void f() {
        s("creator", c, this.a.O());
    }

    private void g() {
        s(SocialConstants.PARAM_COMMENT, c, this.a.R());
    }

    private void h() {
        s("identifier", c, this.a.S());
    }

    private void i() {
        s("keywords", d, this.a.T());
    }

    private void j() {
        s("language", c, this.a.U());
    }

    private void k() {
        s("lastModifiedBy", d, this.a.V());
    }

    private void l() throws DOMException {
        t("lastPrinted", d, this.a.W(), this.a.X());
    }

    private void m() throws DOMException {
        u("modified", e, this.a.Y(), this.a.Z(), "dcterms:W3CDTF");
    }

    private void n() {
        s("revision", d, this.a.a0());
    }

    private void o() {
        s("subject", c, this.a.b0());
    }

    private void p() {
        s("title", c, this.a.c0());
    }

    private void q() {
        s("version", d, this.a.d0());
    }

    private String r(String str, b bVar) {
        if (bVar.b().isEmpty()) {
            return str;
        }
        return bVar.b() + NameUtil.COLON + str;
    }

    private Element s(String str, b bVar, Optional<String> optional) {
        return t(str, bVar, optional, optional.orElse(null));
    }

    private Element t(String str, b bVar, Optional<?> optional, String str2) throws DOMException {
        if (!optional.isPresent()) {
            return null;
        }
        Element documentElement = this.b.getDocumentElement();
        Element elementCreateElementNS = (Element) documentElement.getElementsByTagNameNS(bVar.a(), str).item(0);
        if (elementCreateElementNS == null) {
            elementCreateElementNS = this.b.createElementNS(bVar.a(), r(str, bVar));
            documentElement.appendChild(elementCreateElementNS);
        }
        elementCreateElementNS.setTextContent(str2);
        return elementCreateElementNS;
    }

    private Element u(String str, b bVar, Optional<?> optional, String str2, String str3) throws DOMException {
        Element elementT = t(str, bVar, optional, str2);
        if (elementT != null) {
            b bVar2 = f;
            elementT.setAttributeNS(bVar2.a(), r(SocialConstants.PARAM_TYPE, bVar2), str3);
        }
        return elementT;
    }

    @Override // n.a.a.k.b.z.l
    public boolean a(m mVar, OutputStream outputStream) throws DOMException, f {
        if (!(mVar instanceof k)) {
            throw new IllegalArgumentException("'part' must be a PackagePropertiesPart instance, but had: " + mVar.getClass() + ", check logs while reading.");
        }
        this.a = (k) mVar;
        Document documentB = n.a.a.j.o.a.b();
        this.b = documentB;
        b bVar = d;
        Element elementCreateElementNS = documentB.createElementNS(bVar.a(), r("coreProperties", bVar));
        n.a.a.j.o.a.a(elementCreateElementNS, bVar.b(), bVar.a());
        b bVar2 = c;
        n.a.a.j.o.a.a(elementCreateElementNS, bVar2.b(), bVar2.a());
        b bVar3 = e;
        n.a.a.j.o.a.a(elementCreateElementNS, bVar3.b(), bVar3.a());
        b bVar4 = f;
        n.a.a.j.o.a.a(elementCreateElementNS, bVar4.b(), bVar4.a());
        this.b.appendChild(elementCreateElementNS);
        b();
        c();
        d();
        e();
        f();
        g();
        h();
        i();
        j();
        k();
        l();
        m();
        n();
        o();
        p();
        q();
        return true;
    }
}
