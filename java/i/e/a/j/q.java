package i.e.a.j;

import org.apache.poi.javax.xml.XMLConstants;

/* loaded from: classes.dex */
final class q {
    public static final q c = new q("xml", XMLConstants.XML_NS_URI, null);
    public static final q d = new q("xmlns", "http://www.w3.org/2000/xmlns/", null);
    public final String a;
    public String b;

    public q(String str) {
        if (str != "xml" && str != "xmlns") {
            this.a = str;
            this.b = null;
        } else {
            throw new RuntimeException("Trying to create non-singleton binding for ns prefix '" + str + "'");
        }
    }

    public static final q a() {
        return new q(null);
    }

    public boolean b() {
        return this == c || this == d;
    }

    private q(String str, String str2, Object obj) {
        this.a = str;
        this.b = str2;
    }
}
