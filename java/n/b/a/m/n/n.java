package n.b.a.m.n;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.Attribute;
import org.apache.poi.javax.xml.stream.events.Namespace;
import org.apache.poi.javax.xml.stream.events.StartElement;

/* loaded from: classes2.dex */
public class n extends b implements StartElement {
    protected final QName d;
    protected final ArrayList<Attribute> e;
    protected final ArrayList<Namespace> f;
    protected NamespaceContext g;

    /* renamed from: h, reason: collision with root package name */
    NamespaceContext f2544h;

    protected n(Location location, QName qName, ArrayList<Attribute> arrayList, ArrayList<Namespace> arrayList2, NamespaceContext namespaceContext) {
        super(location);
        this.f2544h = null;
        this.d = qName;
        this.e = arrayList;
        this.f = arrayList2;
        this.g = namespaceContext == null ? n.b.a.m.b.a() : namespaceContext;
    }

    public static n f(Location location, QName qName, Iterator<?> it, Iterator<?> it2, NamespaceContext namespaceContext) {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (it == null || !it.hasNext()) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            do {
                arrayList3.add((Attribute) it.next());
            } while (it.hasNext());
            arrayList = arrayList3;
        }
        if (it2 == null || !it2.hasNext()) {
            arrayList2 = null;
        } else {
            ArrayList arrayList4 = new ArrayList();
            do {
                arrayList4.add((Namespace) it2.next());
            } while (it2.hasNext());
            arrayList2 = arrayList4;
        }
        return new n(location, qName, arrayList, arrayList2, namespaceContext);
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public StartElement asStartElement() {
        return this;
    }

    @Override // n.b.a.k.b
    public void c(n.b.a.j jVar) throws XMLStreamException {
        QName qName = this.d;
        jVar.writeStartElement(qName.getPrefix(), qName.getLocalPart(), qName.getNamespaceURI());
        ArrayList<Namespace> arrayList = this.f;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Namespace namespace = this.f.get(i2);
                String prefix = namespace.getPrefix();
                String namespaceURI = namespace.getNamespaceURI();
                if (prefix == null || prefix.length() == 0) {
                    jVar.writeDefaultNamespace(namespaceURI);
                } else {
                    jVar.writeNamespace(prefix, namespaceURI);
                }
            }
        }
        ArrayList<Attribute> arrayList2 = this.e;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                Attribute attribute = this.e.get(i3);
                if (attribute.isSpecified()) {
                    QName name = attribute.getName();
                    jVar.writeAttribute(name.getPrefix(), name.getNamespaceURI(), name.getLocalPart(), attribute.getValue());
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof StartElement)) {
            return false;
        }
        StartElement startElement = (StartElement) obj;
        if (this.d.equals(startElement.getName()) && b.b(getNamespaces(), startElement.getNamespaces())) {
            return b.b(getAttributes(), startElement.getAttributes());
        }
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.StartElement
    public Attribute getAttributeByName(QName qName) {
        if (this.e == null) {
            return null;
        }
        String localPart = qName.getLocalPart();
        String namespaceURI = qName.getNamespaceURI();
        int size = this.e.size();
        boolean z = namespaceURI == null || namespaceURI.length() == 0;
        for (int i2 = 0; i2 < size; i2++) {
            Attribute attribute = this.e.get(i2);
            QName name = attribute.getName();
            if (name.getLocalPart().equals(localPart)) {
                String namespaceURI2 = name.getNamespaceURI();
                if (z) {
                    if (namespaceURI2 == null || namespaceURI2.length() == 0) {
                        return attribute;
                    }
                } else if (namespaceURI.equals(namespaceURI2)) {
                    return attribute;
                }
            }
        }
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.events.StartElement
    public Iterator<Attribute> getAttributes() {
        ArrayList<Attribute> arrayList = this.e;
        return arrayList == null ? n.b.a.m.a.a() : arrayList.iterator();
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 1;
    }

    @Override // org.apache.poi.javax.xml.stream.events.StartElement
    public final QName getName() {
        return this.d;
    }

    @Override // org.apache.poi.javax.xml.stream.events.StartElement
    public NamespaceContext getNamespaceContext() {
        if (this.f2544h == null) {
            ArrayList<Namespace> arrayList = this.f;
            if (arrayList == null) {
                this.f2544h = this.g;
            } else {
                this.f2544h = j.b(this.g, arrayList);
            }
        }
        return this.f2544h;
    }

    @Override // org.apache.poi.javax.xml.stream.events.StartElement
    public String getNamespaceURI(String str) {
        ArrayList<Namespace> arrayList = this.f;
        if (arrayList == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Namespace namespace = this.f.get(i2);
            String prefix = namespace.getPrefix();
            if (prefix == null) {
                prefix = "";
            }
            if (str.equals(prefix)) {
                return namespace.getNamespaceURI();
            }
        }
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.events.StartElement
    public Iterator<Namespace> getNamespaces() {
        ArrayList<Namespace> arrayList = this.f;
        return arrayList == null ? n.b.a.m.a.a() : arrayList.iterator();
    }

    public int hashCode() {
        return b.a(getAttributes(), b.a(getNamespaces(), this.d.hashCode()));
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isStartElement() {
        return true;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws IOException, XMLStreamException {
        try {
            writer.write(60);
            String prefix = this.d.getPrefix();
            if (prefix != null && prefix.length() > 0) {
                writer.write(prefix);
                writer.write(58);
            }
            writer.write(this.d.getLocalPart());
            ArrayList<Namespace> arrayList = this.f;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    writer.write(32);
                    this.f.get(i2).writeAsEncodedUnicode(writer);
                }
            }
            ArrayList<Attribute> arrayList2 = this.e;
            if (arrayList2 != null) {
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Attribute attribute = this.e.get(i3);
                    if (attribute.isSpecified()) {
                        writer.write(32);
                        attribute.writeAsEncodedUnicode(writer);
                    }
                }
            }
            writer.write(62);
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }
}
