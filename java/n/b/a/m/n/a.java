package n.b.a.m.n;

import java.io.IOException;
import java.io.Writer;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.Attribute;

/* loaded from: classes2.dex */
public class a extends b implements Attribute {
    final QName d;
    final String e;
    final boolean f;

    public a(Location location, String str, String str2, String str3, String str4, boolean z) {
        super(location);
        this.e = str4;
        if (str3 != null) {
            this.d = new QName(str2 == null ? "" : str2, str, str3);
        } else if (str2 == null) {
            this.d = new QName(str);
        } else {
            this.d = new QName(str2, str);
        }
        this.f = z;
    }

    protected static void f(Writer writer, String str) throws IOException {
        int length = str.length();
        int i2 = 0;
        do {
            char cCharAt = 0;
            int i3 = i2;
            while (i3 < length && (cCharAt = str.charAt(i3)) != '<' && cCharAt != '&' && cCharAt != '\"') {
                i3++;
            }
            int i4 = i3 - i2;
            if (i4 > 0) {
                writer.write(str, i2, i4);
            }
            if (i3 < length) {
                if (cCharAt == '<') {
                    writer.write("&lt;");
                } else if (cCharAt == '&') {
                    writer.write("&amp;");
                } else if (cCharAt == '\"') {
                    writer.write("&quot;");
                }
            }
            i2 = i3 + 1;
        } while (i2 < length);
    }

    @Override // n.b.a.k.b
    public void c(n.b.a.j jVar) throws XMLStreamException {
        QName qName = this.d;
        jVar.writeAttribute(qName.getPrefix(), qName.getLocalPart(), qName.getNamespaceURI(), this.e);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        if (this.d.equals(attribute.getName()) && this.e.equals(attribute.getValue()) && isSpecified() == attribute.isSpecified()) {
            return b.d(getDTDType(), attribute.getDTDType());
        }
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Attribute
    public String getDTDType() {
        return "CDATA";
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 10;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Attribute
    public QName getName() {
        return this.d;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Attribute
    public String getValue() {
        return this.e;
    }

    public int hashCode() {
        return this.d.hashCode() ^ this.e.hashCode();
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isAttribute() {
        return true;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Attribute
    public boolean isSpecified() {
        return this.f;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws IOException, XMLStreamException {
        String prefix = this.d.getPrefix();
        if (prefix != null) {
            try {
                if (prefix.length() > 0) {
                    writer.write(prefix);
                    writer.write(58);
                }
            } catch (IOException e) {
                e(e);
                throw null;
            }
        }
        writer.write(this.d.getLocalPart());
        writer.write(61);
        writer.write(34);
        f(writer, this.e);
        writer.write(34);
    }

    public a(Location location, QName qName, String str, boolean z) {
        super(location);
        this.d = qName;
        this.e = str;
        this.f = z;
    }
}
