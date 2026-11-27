package n.a.a.j.o;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import n.a.a.o.r1;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public abstract class a {
    private static final DocumentBuilder a = c();

    public static void a(Element element, String str, String str2) throws DOMException {
        element.setAttributeNS("http://www.w3.org/2000/xmlns/", Sax2Dom.XMLNS_STRING + str, str2);
    }

    public static Document b() {
        return a.newDocument();
    }

    public static DocumentBuilder c() {
        return r1.l();
    }

    public static Document d(InputStream inputStream) throws SAXException, IOException {
        return c().parse(inputStream);
    }
}
