package i.e.a.g;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class b extends e {
    private b g;

    /* renamed from: h, reason: collision with root package name */
    private Element f1556h;

    private b() {
        this.g = null;
        this.f1556h = null;
        this.e = null;
        this.f = false;
        this.d = "";
        this.c = null;
    }

    public static b l() {
        return new b();
    }

    protected void g(String str, String str2) throws DOMException {
        this.f1556h.setAttribute(str, str2);
    }

    protected void h(String str, String str2, String str3) throws DOMException {
        this.f1556h.setAttributeNS(str, str2, str3);
    }

    protected void i(Node node) {
        if (n()) {
            this.f1556h.getOwnerDocument().appendChild(node);
        } else {
            this.f1556h.appendChild(node);
        }
    }

    protected b j(Element element) {
        if (n()) {
            element.getOwnerDocument().appendChild(element);
        } else {
            this.f1556h.appendChild(element);
        }
        return k(element);
    }

    protected b k(Element element) {
        return new b(this, element, this.e);
    }

    public b m() {
        return this.g;
    }

    public boolean n() {
        return this.g == null;
    }

    public void o(String str) {
        this.d = str;
    }

    private b(b bVar, Element element, a aVar) {
        super(bVar, aVar);
        this.g = bVar;
        this.f1556h = element;
        this.e = aVar;
        this.f = aVar != null;
        this.d = bVar.d;
        this.c = bVar.c;
    }
}
