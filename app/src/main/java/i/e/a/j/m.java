package i.e.a.j;

import com.auto.exceldeps.log4j.util.Chars;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.NamespaceContext;

/* loaded from: classes.dex */
public final class m implements NamespaceContext {
    public static final m f = new m(null, new String[0]);
    protected final r c;
    protected final String[] d;
    protected ArrayList<String> e = null;

    private m(r rVar, String[] strArr) {
        this.c = rVar;
        this.d = strArr;
    }

    public m a(r rVar) {
        if (rVar == this.c) {
            return this;
        }
        if (this == f) {
            ArrayList arrayList = new ArrayList();
            for (r rVarG = rVar; rVarG != null; rVarG = rVarG.g()) {
                arrayList.add(rVarG.f());
                arrayList.add(rVarG.d());
            }
            return new m(rVar, (String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        ArrayList<String> arrayList2 = this.e;
        if (arrayList2 == null) {
            this.e = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        for (r rVarG2 = rVar; rVarG2 != null; rVarG2 = rVarG2.g()) {
            this.e.add(rVarG2.f());
            this.e.add(rVarG2.d());
        }
        ArrayList<String> arrayList3 = this.e;
        return new m(rVar, (String[]) arrayList3.toArray(new String[arrayList3.size()]));
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public final String getNamespaceURI(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Null prefix not allowed");
        }
        if (str.length() > 0) {
            if (str.equals("xml")) {
                return XMLConstants.XML_NS_URI;
            }
            if (str.equals("xmlns")) {
                return "http://www.w3.org/2000/xmlns/";
            }
        }
        String[] strArr = this.d;
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2 += 2) {
            if (str.equals(strArr[i2])) {
                return strArr[i2 + 1];
            }
        }
        return null;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public final String getPrefix(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
        }
        if (str.equals(XMLConstants.XML_NS_URI)) {
            return "xml";
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            return "xmlns";
        }
        String[] strArr = this.d;
        int length = strArr.length;
        for (int i2 = 1; i2 < length; i2 += 2) {
            if (str.equals(strArr[i2])) {
                int i3 = i2 - 1;
                String str2 = strArr[i3];
                for (int i4 = i2 + 1; i4 < length; i4 += 2) {
                    if (strArr[i4] == str2) {
                        break;
                    }
                }
                return strArr[i3];
            }
        }
        return null;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public final Iterator<String> getPrefixes(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Illegal to pass null/empty prefix as argument.");
        }
        if (str.equals(XMLConstants.XML_NS_URI)) {
            return n.b.a.m.c.a("xml");
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            return n.b.a.m.c.a("xmlns");
        }
        String[] strArr = this.d;
        int length = strArr.length;
        ArrayList arrayList = null;
        String str2 = null;
        for (int i2 = 1; i2 < length; i2 += 2) {
            String str3 = strArr[i2];
            if (str3 == str || str3.equals(str)) {
                String str4 = strArr[i2 - 1];
                int i3 = i2 + 1;
                while (true) {
                    if (i3 < length) {
                        if (strArr[i3] == str4) {
                            break;
                        }
                        i3 += 2;
                    } else if (str2 == null) {
                        str2 = str4;
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayList.add(str2);
                        }
                        arrayList.add(str4);
                    }
                }
            }
        }
        return arrayList != null ? arrayList.iterator() : str2 != null ? n.b.a.m.c.a(str2) : n.b.a.m.a.a();
    }

    public String toString() {
        if (this == f) {
            return "[EMPTY non-transient NsContext]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int length = this.d.length;
        for (int i2 = 0; i2 < length; i2 += 2) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(Chars.DQUOTE);
            sb.append(this.d[i2]);
            sb.append("\"->\"");
            sb.append(this.d[i2 + 1]);
            sb.append(Chars.DQUOTE);
        }
        sb.append(']');
        return sb.toString();
    }
}
