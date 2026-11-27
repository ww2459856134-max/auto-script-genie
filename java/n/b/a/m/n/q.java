package n.b.a.m.n;

import org.apache.poi.javax.xml.stream.EventFilter;
import org.apache.poi.javax.xml.stream.XMLStreamConstants;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.XMLEvent;

/* loaded from: classes2.dex */
public class q implements n.b.a.d, XMLStreamConstants {
    final n.b.a.d c;
    final EventFilter d;

    public q(n.b.a.d dVar, EventFilter eventFilter) {
        this.c = dVar;
        this.d = eventFilter;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public void close() throws XMLStreamException {
        this.c.close();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public String getElementText() throws XMLStreamException {
        return this.c.getElementText();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public Object getProperty(String str) {
        return this.c.getProperty(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader, java.util.Iterator
    public boolean hasNext() {
        try {
            return peek() != null;
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            return nextEvent();
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent nextEvent() throws XMLStreamException {
        XMLEvent xMLEventNextEvent;
        do {
            xMLEventNextEvent = this.c.nextEvent();
            if (xMLEventNextEvent == null) {
                break;
            }
        } while (!this.d.accept(xMLEventNextEvent));
        return xMLEventNextEvent;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent nextTag() throws XMLStreamException {
        XMLEvent xMLEventNextTag;
        do {
            xMLEventNextTag = this.c.nextTag();
            if (xMLEventNextTag == null) {
                break;
            }
        } while (!this.d.accept(xMLEventNextTag));
        return xMLEventNextTag;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent peek() throws XMLStreamException {
        XMLEvent xMLEventPeek;
        while (true) {
            xMLEventPeek = this.c.peek();
            if (xMLEventPeek == null || this.d.accept(xMLEventPeek)) {
                break;
            }
            this.c.nextEvent();
        }
        return xMLEventPeek;
    }

    @Override // java.util.Iterator
    public void remove() {
        this.c.remove();
    }
}
