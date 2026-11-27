package n.b.a.m;

import java.util.Iterator;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.NamespaceContext;

/* loaded from: classes2.dex */
public class b implements NamespaceContext {
    static final b c = new b();

    private b() {
    }

    public static b a() {
        return c;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public final String getNamespaceURI(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
        }
        if (str.length() <= 0) {
            return null;
        }
        if (str.equals("xml")) {
            return XMLConstants.XML_NS_URI;
        }
        if (str.equals("xmlns")) {
            return "http://www.w3.org/2000/xmlns/";
        }
        return null;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public String getPrefix(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Illegal to pass null/empty URI as argument.");
        }
        if (str.equals(XMLConstants.XML_NS_URI)) {
            return "xml";
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            return "xmlns";
        }
        return null;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
        }
        return str.equals(XMLConstants.XML_NS_URI) ? c.a("xml") : str.equals("http://www.w3.org/2000/xmlns/") ? c.a("xmlns") : a.a();
    }
}
