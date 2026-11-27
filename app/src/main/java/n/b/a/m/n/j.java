package n.b.a.m.n;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.stream.events.Namespace;

/* loaded from: classes2.dex */
public class j implements NamespaceContext {
    final NamespaceContext c;
    final List<Namespace> d;

    protected j(NamespaceContext namespaceContext, List<Namespace> list) {
        this.c = namespaceContext;
        this.d = list == null ? Collections.emptyList() : list;
    }

    public static j b(NamespaceContext namespaceContext, List<Namespace> list) {
        return new j(namespaceContext, list);
    }

    protected <T> ArrayList<T> a(ArrayList<T> arrayList, T t) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(t);
        return arrayList;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String str) {
        String namespaceURI;
        if (str == null) {
            throw new IllegalArgumentException("Illegal to pass null prefix");
        }
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            Namespace namespace = this.d.get(i2);
            if (str.equals(namespace.getPrefix())) {
                return namespace.getNamespaceURI();
            }
        }
        NamespaceContext namespaceContext = this.c;
        if (namespaceContext != null && (namespaceURI = namespaceContext.getNamespaceURI(str)) != null) {
            return namespaceURI;
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
            throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
        }
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            Namespace namespace = this.d.get(i2);
            if (str.equals(namespace.getNamespaceURI())) {
                return namespace.getPrefix();
            }
        }
        NamespaceContext namespaceContext = this.c;
        if (namespaceContext != null) {
            String prefix = namespaceContext.getPrefix(str);
            if (prefix != null && getNamespaceURI(prefix).equals(str)) {
                return prefix;
            }
            Iterator prefixes = this.c.getPrefixes(str);
            while (prefixes.hasNext()) {
                String str2 = (String) prefixes.next();
                if (!str2.equals(prefix) && getNamespaceURI(str2).equals(str)) {
                    return str2;
                }
            }
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
        int size = this.d.size();
        ArrayList arrayListA = null;
        for (int i2 = 0; i2 < size; i2++) {
            Namespace namespace = this.d.get(i2);
            if (str.equals(namespace.getNamespaceURI())) {
                arrayListA = a(arrayListA, namespace.getPrefix());
            }
        }
        NamespaceContext namespaceContext = this.c;
        if (namespaceContext != null) {
            Iterator prefixes = namespaceContext.getPrefixes(str);
            while (prefixes.hasNext()) {
                String str2 = (String) prefixes.next();
                if (getNamespaceURI(str2).equals(str)) {
                    arrayListA = a(arrayListA, str2);
                }
            }
        }
        if (str.equals(XMLConstants.XML_NS_URI)) {
            arrayListA = a(arrayListA, "xml");
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            a(arrayListA, "xmlns");
        }
        return null;
    }
}
