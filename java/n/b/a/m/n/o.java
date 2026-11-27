package n.b.a.m.n;

import java.util.ArrayList;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamConstants;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.poi.javax.xml.stream.events.DTD;
import org.apache.poi.javax.xml.stream.events.EntityReference;
import org.apache.poi.javax.xml.stream.events.StartElement;
import org.apache.poi.javax.xml.stream.events.XMLEvent;
import org.apache.poi.javax.xml.stream.util.XMLEventAllocator;
import org.apache.poi.javax.xml.stream.util.XMLEventConsumer;

/* loaded from: classes2.dex */
public abstract class o implements XMLEventAllocator, XMLStreamConstants {
    protected DTD a(XMLStreamReader xMLStreamReader, Location location) throws XMLStreamException {
        if (!(xMLStreamReader instanceof n.b.a.i)) {
            return new e(location, null, xMLStreamReader.getText());
        }
        n.b.a.b dTDInfo = ((n.b.a.i) xMLStreamReader).getDTDInfo();
        return new e(location, dTDInfo.getDTDRootName(), dTDInfo.getDTDSystemId(), dTDInfo.getDTDPublicId(), dTDInfo.getDTDInternalSubset(), dTDInfo.getProcessedDTD());
    }

    @Override // org.apache.poi.javax.xml.stream.util.XMLEventAllocator
    public XMLEvent allocate(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        Location locationE = e(xMLStreamReader);
        switch (xMLStreamReader.getEventType()) {
            case 1:
                return d(xMLStreamReader, locationE);
            case 2:
                return new g(locationE, xMLStreamReader);
            case 3:
                return new l(locationE, xMLStreamReader.getPITarget(), xMLStreamReader.getPIData());
            case 4:
                return new c(locationE, xMLStreamReader.getText(), false);
            case 5:
                return new d(locationE, xMLStreamReader.getText());
            case 6:
                c cVar = new c(locationE, xMLStreamReader.getText(), false);
                cVar.h(true);
                return cVar;
            case 7:
                return new m(locationE, xMLStreamReader);
            case 8:
                return new f(locationE);
            case 9:
                return b(xMLStreamReader, locationE);
            case 10:
            default:
                throw new XMLStreamException("Unrecognized event type " + xMLStreamReader.getEventType() + ".");
            case 11:
                return a(xMLStreamReader, locationE);
            case 12:
                return new c(locationE, xMLStreamReader.getText(), true);
        }
    }

    protected EntityReference b(XMLStreamReader xMLStreamReader, Location location) throws XMLStreamException {
        return new i(location, xMLStreamReader.getLocalName());
    }

    protected StartElement d(XMLStreamReader xMLStreamReader, Location location) throws XMLStreamException {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        NamespaceContext nonTransientNamespaceContext = xMLStreamReader instanceof n.b.a.i ? ((n.b.a.i) xMLStreamReader).getNonTransientNamespaceContext() : null;
        int attributeCount = xMLStreamReader.getAttributeCount();
        if (attributeCount < 1) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(attributeCount);
            for (int i2 = 0; i2 < attributeCount; i2++) {
                arrayList.add(new a(location, xMLStreamReader.getAttributeName(i2), xMLStreamReader.getAttributeValue(i2), xMLStreamReader.isAttributeSpecified(i2)));
            }
        }
        int namespaceCount = xMLStreamReader.getNamespaceCount();
        if (namespaceCount >= 1) {
            arrayList2 = new ArrayList(namespaceCount);
            for (int i3 = 0; i3 < namespaceCount; i3++) {
                arrayList2.add(k.h(location, xMLStreamReader.getNamespacePrefix(i3), xMLStreamReader.getNamespaceURI(i3)));
            }
        }
        return n.f(location, xMLStreamReader.getName(), arrayList == null ? n.b.a.m.a.a() : arrayList.iterator(), arrayList2 == null ? n.b.a.m.a.a() : arrayList2.iterator(), nonTransientNamespaceContext);
    }

    protected abstract Location e(XMLStreamReader xMLStreamReader);

    @Override // org.apache.poi.javax.xml.stream.util.XMLEventAllocator
    public void allocate(XMLStreamReader xMLStreamReader, XMLEventConsumer xMLEventConsumer) throws XMLStreamException {
        xMLEventConsumer.add(allocate(xMLStreamReader));
    }
}
