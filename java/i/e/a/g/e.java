package i.e.a.g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public abstract class e implements NamespaceContext {
    protected NamespaceContext c;
    protected String d;
    protected a e;
    protected boolean f;

    protected e() {
        this.e = null;
        this.f = false;
        this.d = "";
        this.c = null;
    }

    public final void a(String str, String str2) {
        a aVar = this.e;
        if (aVar == null) {
            this.e = a.d();
        } else if (this.f) {
            this.e = aVar.c();
            this.f = false;
        }
        this.e.b(str, str2);
    }

    public final String b(String str, String str2, int[] iArr) {
        a aVar = this.e;
        if (aVar == null) {
            this.e = a.d();
        } else if (this.f) {
            this.e = aVar.c();
            this.f = false;
        }
        return this.e.a(str, this.c, str2, iArr);
    }

    public final String c() {
        return this.d;
    }

    public final String d(String str) {
        String prefix;
        String strE;
        a aVar = this.e;
        if (aVar != null && (strE = aVar.e(str)) != null) {
            return strE;
        }
        NamespaceContext namespaceContext = this.c;
        if (namespaceContext == null || (prefix = namespaceContext.getPrefix(str)) == null || prefix.length() <= 0) {
            return null;
        }
        return prefix;
    }

    public final int e(String str, String str2, boolean z) throws XMLStreamException {
        NamespaceContext namespaceContext;
        if (str2 == null) {
            str2 = "";
        }
        if (str == null || str.length() == 0) {
            if (z) {
                String str3 = this.d;
                if (str2 == str3 || str2.equals(str3)) {
                    return 1;
                }
            } else if (str2.length() == 0) {
                return 1;
            }
            return 2;
        }
        if (!"xml".equals(str)) {
            a aVar = this.e;
            String strF = aVar != null ? aVar.f(str) : null;
            if (strF == null && (namespaceContext = this.c) != null) {
                strF = namespaceContext.getNamespaceURI(str);
            }
            if (strF == null) {
                return 0;
            }
            return (strF == str2 || strF.equals(str2)) ? 1 : 2;
        }
        if (str2.equals(XMLConstants.XML_NS_URI)) {
            return 1;
        }
        f("Namespace prefix 'xml' can not be bound to non-default namespace ('" + str2 + "'); has to be the default '" + XMLConstants.XML_NS_URI + "'");
        throw null;
    }

    protected final void f(String str) throws XMLStreamException {
        throw new XMLStreamException(str);
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public final String getNamespaceURI(String str) {
        String strF;
        if (str.length() == 0) {
            return this.d;
        }
        a aVar = this.e;
        if (aVar != null && (strF = aVar.f(str)) != null) {
            return strF;
        }
        NamespaceContext namespaceContext = this.c;
        if (namespaceContext != null) {
            return namespaceContext.getNamespaceURI(str);
        }
        return null;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public final String getPrefix(String str) {
        String strE;
        if (this.d.equals(str)) {
            return "";
        }
        a aVar = this.e;
        if (aVar != null && (strE = aVar.e(str)) != null) {
            return strE;
        }
        NamespaceContext namespaceContext = this.c;
        if (namespaceContext != null) {
            return namespaceContext.getPrefix(str);
        }
        return null;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public final Iterator<String> getPrefixes(String str) {
        List<String> arrayList;
        if (this.d.equals(str)) {
            arrayList = new ArrayList<>();
            arrayList.add("");
        } else {
            arrayList = null;
        }
        a aVar = this.e;
        if (aVar != null) {
            arrayList = aVar.g(str, arrayList);
        }
        NamespaceContext namespaceContext = this.c;
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
        return arrayList == null ? n.b.a.m.a.a() : arrayList.iterator();
    }

    protected e(e eVar, a aVar) {
        this.e = aVar;
        this.f = aVar != null;
        this.d = eVar.d;
        this.c = eVar.c;
    }
}
