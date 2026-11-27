package n.a.a.k.b.z;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import n.a.a.k.b.s;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public abstract class d {
    protected n.a.a.k.b.k a;
    private TreeMap<String, String> b = new TreeMap<>();
    private TreeMap<n.a.a.k.b.o, String> c;

    public d(InputStream inputStream, n.a.a.k.b.k kVar) throws DOMException, n.a.a.k.a.a {
        this.a = kVar;
        if (inputStream != null) {
            try {
                i(inputStream);
            } catch (n.a.a.k.a.a e) {
                n.a.a.k.a.a aVar = new n.a.a.k.a.a("Can't read content types part !");
                aVar.initCause(e);
                throw aVar;
            }
        }
    }

    private void b(String str, String str2) {
        this.b.put(str.toLowerCase(Locale.ROOT), str2);
    }

    private void c(n.a.a.k.b.o oVar, String str) {
        if (this.c == null) {
            this.c = new TreeMap<>();
        }
        this.c.put(oVar, str);
    }

    private void d(Element element, Map.Entry<String, String> entry) throws DOMException {
        Element elementCreateElementNS = element.getOwnerDocument().createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", "Default");
        elementCreateElementNS.setAttribute("Extension", entry.getKey());
        elementCreateElementNS.setAttribute("ContentType", entry.getValue());
        element.appendChild(elementCreateElementNS);
    }

    private void e(Element element, Map.Entry<n.a.a.k.b.o, String> entry) throws DOMException {
        Element elementCreateElementNS = element.getOwnerDocument().createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", "Override");
        elementCreateElementNS.setAttribute("PartName", entry.getKey().f());
        elementCreateElementNS.setAttribute("ContentType", entry.getValue());
        element.appendChild(elementCreateElementNS);
    }

    private void i(InputStream inputStream) throws DOMException, n.a.a.k.a.a {
        try {
            Document documentD = n.a.a.j.o.a.d(inputStream);
            NodeList elementsByTagNameNS = documentD.getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/content-types", "Default");
            int length = elementsByTagNameNS.getLength();
            for (int i2 = 0; i2 < length; i2++) {
                Element element = (Element) elementsByTagNameNS.item(i2);
                b(element.getAttribute("Extension"), element.getAttribute("ContentType"));
            }
            NodeList elementsByTagNameNS2 = documentD.getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/content-types", "Override");
            int length2 = elementsByTagNameNS2.getLength();
            for (int i3 = 0; i3 < length2; i3++) {
                Element element2 = (Element) elementsByTagNameNS2.item(i3);
                c(s.c(new URI(element2.getAttribute("PartName"))), element2.getAttribute("ContentType"));
            }
        } catch (IOException | URISyntaxException | SAXException e) {
            throw new n.a.a.k.a.a(e.getMessage());
        }
    }

    public void a(n.a.a.k.b.o oVar, String str) {
        boolean zContainsValue = this.b.containsValue(str);
        String lowerCase = oVar.e().toLowerCase(Locale.ROOT);
        if (lowerCase.isEmpty() || ((this.b.containsKey(lowerCase) && !zContainsValue) || (!this.b.containsKey(lowerCase) && zContainsValue))) {
            c(oVar, str);
        } else {
            if (zContainsValue) {
                return;
            }
            b(lowerCase, str);
        }
    }

    public void f() {
        this.b.clear();
        TreeMap<n.a.a.k.b.o, String> treeMap = this.c;
        if (treeMap != null) {
            treeMap.clear();
        }
    }

    public String g(n.a.a.k.b.o oVar) {
        if (oVar == null) {
            throw new IllegalArgumentException("partName");
        }
        TreeMap<n.a.a.k.b.o, String> treeMap = this.c;
        if (treeMap != null && treeMap.containsKey(oVar)) {
            return this.c.get(oVar);
        }
        String lowerCase = oVar.e().toLowerCase(Locale.ROOT);
        if (this.b.containsKey(lowerCase)) {
            return this.b.get(lowerCase);
        }
        n.a.a.k.b.k kVar = this.a;
        if (kVar == null || kVar.B(oVar) == null) {
            return null;
        }
        throw new n.a.a.k.a.g("Rule M2.4 exception : Part '" + oVar + "' not found - this error should NEVER happen!\nCheck that your code is closing the open resources in the correct order prior to filing a bug report.\nIf you can provide the triggering file, then please raise a bug at https://bz.apache.org/bugzilla/enter_bug.cgi?product=POI and attach the file that triggers it, thanks!");
    }

    public boolean h(String str) {
        TreeMap<n.a.a.k.b.o, String> treeMap;
        if (str != null) {
            return this.b.containsValue(str) || ((treeMap = this.c) != null && treeMap.containsValue(str));
        }
        throw new IllegalArgumentException("contentType");
    }

    public void j(n.a.a.k.b.o oVar) throws n.a.a.k.a.b {
        if (oVar == null) {
            throw new IllegalArgumentException("partName");
        }
        TreeMap<n.a.a.k.b.o, String> treeMap = this.c;
        if (treeMap != null && treeMap.get(oVar) != null) {
            this.c.remove(oVar);
            return;
        }
        String strE = oVar.e();
        boolean z = true;
        n.a.a.k.b.k kVar = this.a;
        if (kVar != null) {
            try {
                Iterator<n.a.a.k.b.m> it = kVar.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n.a.a.k.b.m next = it.next();
                    if (!next.r().equals(oVar) && next.r().e().equalsIgnoreCase(strE)) {
                        z = false;
                        break;
                    }
                }
            } catch (n.a.a.k.a.a e) {
                throw new n.a.a.k.a.b(e.getMessage());
            }
        }
        if (z) {
            this.b.remove(strE);
        }
        n.a.a.k.b.k kVar2 = this.a;
        if (kVar2 != null) {
            try {
                Iterator<n.a.a.k.b.m> it2 = kVar2.F().iterator();
                while (it2.hasNext()) {
                    n.a.a.k.b.m next2 = it2.next();
                    if (!next2.r().equals(oVar) && g(next2.r()) == null) {
                        throw new n.a.a.k.a.b("Rule M2.4 is not respected: Nor a default element or override element is associated with the part: " + next2.r().f());
                    }
                }
            } catch (n.a.a.k.a.a e2) {
                throw new n.a.a.k.a.b(e2.getMessage());
            }
        }
    }

    public boolean k(OutputStream outputStream) throws DOMException {
        Document documentB = n.a.a.j.o.a.b();
        Element elementCreateElementNS = documentB.createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", "Types");
        documentB.appendChild(elementCreateElementNS);
        Iterator<Map.Entry<String, String>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            d(elementCreateElementNS, it.next());
        }
        TreeMap<n.a.a.k.b.o, String> treeMap = this.c;
        if (treeMap != null) {
            Iterator<Map.Entry<n.a.a.k.b.o, String>> it2 = treeMap.entrySet().iterator();
            while (it2.hasNext()) {
                e(elementCreateElementNS, it2.next());
            }
        }
        documentB.normalize();
        return l(documentB, outputStream);
    }

    public abstract boolean l(Document document, OutputStream outputStream);
}
