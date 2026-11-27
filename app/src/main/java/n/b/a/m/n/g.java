package n.b.a.m.n;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.poi.javax.xml.stream.events.EndElement;
import org.apache.poi.javax.xml.stream.events.Namespace;

/* loaded from: classes2.dex */
public class g extends b implements EndElement {
    protected final QName d;
    protected final ArrayList<Namespace> e;

    public g(Location location, XMLStreamReader xMLStreamReader) {
        super(location);
        this.d = xMLStreamReader.getName();
        int namespaceCount = xMLStreamReader.getNamespaceCount();
        if (namespaceCount == 0) {
            this.e = null;
            return;
        }
        ArrayList<Namespace> arrayList = new ArrayList<>(namespaceCount);
        for (int i2 = 0; i2 < namespaceCount; i2++) {
            arrayList.add(k.h(location, xMLStreamReader.getNamespacePrefix(i2), xMLStreamReader.getNamespaceURI(i2)));
        }
        this.e = arrayList;
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public EndElement asEndElement() {
        return this;
    }

    @Override // n.b.a.k.b
    public void c(n.b.a.j jVar) throws XMLStreamException {
        jVar.writeEndElement();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof EndElement) && getName().equals(((EndElement) obj).getName());
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 2;
    }

    @Override // org.apache.poi.javax.xml.stream.events.EndElement
    public QName getName() {
        return this.d;
    }

    @Override // org.apache.poi.javax.xml.stream.events.EndElement
    public Iterator<Namespace> getNamespaces() {
        ArrayList<Namespace> arrayList = this.e;
        return arrayList == null ? n.b.a.m.a.a() : arrayList.iterator();
    }

    public int hashCode() {
        return getName().hashCode();
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isEndElement() {
        return true;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws IOException, XMLStreamException {
        try {
            writer.write("</");
            String prefix = this.d.getPrefix();
            if (prefix != null && prefix.length() > 0) {
                writer.write(prefix);
                writer.write(58);
            }
            writer.write(this.d.getLocalPart());
            writer.write(62);
        } catch (IOException e) {
            e(e);
            throw null;
        }
    }

    public g(Location location, QName qName, Iterator<Namespace> it) {
        super(location);
        this.d = qName;
        if (it != null && it.hasNext()) {
            ArrayList<Namespace> arrayList = new ArrayList<>();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            this.e = arrayList;
            return;
        }
        this.e = null;
    }
}
