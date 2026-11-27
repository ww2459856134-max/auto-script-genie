package n.b.a.m.n;

import org.apache.poi.javax.xml.stream.XMLEventReader;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.XMLEvent;

/* loaded from: classes2.dex */
public class p implements n.b.a.d {
    protected final XMLEventReader c;

    protected p(XMLEventReader xMLEventReader) {
        this.c = xMLEventReader;
    }

    public static n.b.a.d a(XMLEventReader xMLEventReader) {
        return xMLEventReader instanceof n.b.a.d ? (n.b.a.d) xMLEventReader : new p(xMLEventReader);
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
        return this.c.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.c.next();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent nextEvent() throws XMLStreamException {
        return this.c.nextEvent();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent nextTag() throws XMLStreamException {
        return this.c.nextTag();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent peek() throws XMLStreamException {
        return this.c.peek();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.c.remove();
    }
}
