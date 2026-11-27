package i.e.a.k;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.NamespaceContext;

/* loaded from: classes.dex */
final class k {
    private k a;
    private r b;
    private String c;
    private String d;
    private h e;

    private k() {
        this.d = "";
        this.e = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = null;
        this.d = "";
    }

    protected static k f() {
        return new k();
    }

    private void w(k kVar, r rVar, String str) {
        this.a = kVar;
        this.b = rVar;
        this.c = str;
        this.e = kVar.e;
        this.d = kVar.d;
    }

    public void a(String str, String str2) {
        h hVar = this.e;
        if (hVar == null) {
            this.e = h.c();
        } else {
            k kVar = this.a;
            if (kVar != null && kVar.e == hVar) {
                this.e = hVar.b();
            }
        }
        this.e.a(str, str2);
    }

    protected void b(k kVar) {
        this.a = kVar;
    }

    public j c(String str, String str2, NamespaceContext namespaceContext) {
        if (str.equals("xml")) {
            return str2.equals(XMLConstants.XML_NS_URI) ? j.OK : j.MISBOUND;
        }
        h hVar = this.e;
        String strE = hVar == null ? null : hVar.e(str);
        if (strE == null && namespaceContext != null) {
            strE = namespaceContext.getNamespaceURI(str);
        }
        return strE == null ? j.UNBOUND : (strE == str2 || strE.equals(str2)) ? j.OK : j.MISBOUND;
    }

    protected k d(r rVar) {
        return new k(this, rVar, this.d, this.e);
    }

    protected k e(r rVar, String str) {
        return new k(this, rVar, str, this.e);
    }

    public String g(NamespaceContext namespaceContext, String str, int[] iArr) {
        if (this.e == null) {
            this.e = h.c();
        }
        return this.e.f(str, namespaceContext, iArr);
    }

    public String h(String str, NamespaceContext namespaceContext) {
        String prefix;
        String strD;
        h hVar = this.e;
        if (hVar != null && (strD = hVar.d(str)) != null) {
            return strD;
        }
        if (namespaceContext == null || (prefix = namespaceContext.getPrefix(str)) == null || prefix.length() <= 0) {
            return null;
        }
        return prefix;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String i() {
        return this.b.c();
    }

    public r j() {
        return this.b;
    }

    public String k() {
        return this.b.toString();
    }

    public String l(String str) {
        String strE;
        if (str.length() == 0) {
            return this.d;
        }
        h hVar = this.e;
        if (hVar == null || (strE = hVar.e(str)) == null) {
            return null;
        }
        return strE;
    }

    public String m() {
        String str = this.c;
        return str == null ? "" : str;
    }

    public String n() {
        if (this.b.d() == null) {
            return "";
        }
        return null;
    }

    public k o() {
        return this.a;
    }

    public String p(String str) {
        String strD;
        if (this.d.equals(str)) {
            return "";
        }
        h hVar = this.e;
        if (hVar == null || (strD = hVar.d(str)) == null) {
            return null;
        }
        return strD;
    }

    public Iterator<String> q(String str, NamespaceContext namespaceContext) {
        List<String> arrayList;
        if (this.d.equals(str)) {
            arrayList = new ArrayList<>();
            arrayList.add("");
        } else {
            arrayList = null;
        }
        h hVar = this.e;
        if (hVar != null) {
            arrayList = hVar.g(str, arrayList);
        }
        if (namespaceContext != null) {
            Iterator prefixes = namespaceContext.getPrefixes(str);
            while (prefixes.hasNext()) {
                String str2 = (String) prefixes.next();
                if (str2.length() != 0) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    } else if (arrayList.contains(str2)) {
                    }
                    arrayList.add(str2);
                }
            }
        }
        return arrayList == null ? i.e.a.l.d.a() : arrayList.iterator();
    }

    public boolean r() {
        String str = this.d;
        return str == null || str.length() == 0;
    }

    public boolean s() {
        return this.b.g();
    }

    public boolean t(String str, String str2, NamespaceContext namespaceContext) {
        if (str == null || str.length() == 0) {
            return this.d.equals(str2);
        }
        if ("xml".equals(str)) {
            return str2.equals(XMLConstants.XML_NS_URI);
        }
        h hVar = this.e;
        String strE = hVar == null ? null : hVar.e(str);
        if (strE == null && namespaceContext != null) {
            strE = namespaceContext.getNamespaceURI(str);
        }
        return strE != null && (strE == str2 || strE.equals(str2));
    }

    public boolean u(String str, NamespaceContext namespaceContext) {
        String namespaceURI;
        h hVar = this.e;
        String strE = hVar == null ? null : hVar.e(str);
        if ((strE == null || strE.length() == 0) && !str.equals("xml")) {
            return namespaceContext == null || (namespaceURI = namespaceContext.getNamespaceURI(str)) == null || namespaceURI.length() == 0;
        }
        return false;
    }

    public boolean v() {
        return this.a == null;
    }

    protected k x(k kVar, r rVar) {
        k kVar2 = this.a;
        w(kVar, rVar, this.d);
        return kVar2;
    }

    protected k y(k kVar, r rVar, String str) {
        k kVar2 = this.a;
        w(kVar, rVar, str);
        return kVar2;
    }

    public void z(String str) {
        this.d = str;
    }

    private k(k kVar, r rVar, String str, h hVar) {
        this.d = "";
        this.e = null;
        this.a = kVar;
        this.b = rVar;
        this.c = str;
        this.e = hVar;
        this.d = kVar.d;
    }
}
