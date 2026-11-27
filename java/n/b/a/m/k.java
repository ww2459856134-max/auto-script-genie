package n.b.a.m;

import com.auto.exceldeps.log4j.util.Chars;
import org.apache.poi.javax.xml.stream.XMLOutputFactory;
import org.apache.poi.javax.xml.stream.XMLStreamConstants;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamWriter;

/* loaded from: classes2.dex */
public class k extends n.b.a.o.b implements n.b.a.j, XMLStreamConstants {
    protected k(XMLStreamWriter xMLStreamWriter) throws IllegalArgumentException {
        super(xMLStreamWriter);
        this.c = xMLStreamWriter;
        Object property = xMLStreamWriter.getProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES);
        if (property instanceof Boolean) {
            ((Boolean) property).booleanValue();
        }
    }

    public static n.b.a.j e(XMLStreamWriter xMLStreamWriter) {
        return xMLStreamWriter instanceof n.b.a.j ? (n.b.a.j) xMLStreamWriter : new k(xMLStreamWriter);
    }

    @Override // n.b.a.j
    public void a(String str, String str2, boolean z) throws XMLStreamException {
        writeStartDocument(str2, str);
    }

    @Override // n.b.a.j
    public void b(String str, String str2, String str3, String str4) throws XMLStreamException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<!DOCTYPE");
        stringBuffer.append(str);
        if (str2 != null) {
            if (str3 != null) {
                stringBuffer.append(" PUBLIC \"");
                stringBuffer.append(str3);
                stringBuffer.append("\" \"");
            } else {
                stringBuffer.append(" SYSTEM \"");
            }
            stringBuffer.append(str2);
            stringBuffer.append(Chars.DQUOTE);
        }
        if (str4 != null && str4.length() > 0) {
            stringBuffer.append(" [");
            stringBuffer.append(str4);
            stringBuffer.append(']');
        }
        stringBuffer.append('>');
        writeDTD(stringBuffer.toString());
    }

    @Override // n.b.a.j
    public void d(String str) throws XMLStreamException {
        f(str, 0, str.length());
        throw null;
    }

    public void f(String str, int i2, int i3) throws XMLStreamException {
        throw new UnsupportedOperationException("Not implemented");
    }
}
