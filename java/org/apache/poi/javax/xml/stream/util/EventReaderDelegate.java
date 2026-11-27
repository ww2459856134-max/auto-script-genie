package org.apache.poi.javax.xml.stream.util;

import org.apache.poi.javax.xml.stream.XMLEventReader;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.XMLEvent;

/* loaded from: classes.dex */
public class EventReaderDelegate implements XMLEventReader {
    private XMLEventReader reader;

    public EventReaderDelegate() {
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public void close() throws XMLStreamException {
        this.reader.close();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public String getElementText() throws XMLStreamException {
        return this.reader.getElementText();
    }

    public XMLEventReader getParent() {
        return this.reader;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public Object getProperty(String str) throws IllegalArgumentException {
        return this.reader.getProperty(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader, java.util.Iterator
    public boolean hasNext() {
        return this.reader.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.reader.next();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent nextEvent() throws XMLStreamException {
        return this.reader.nextEvent();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent nextTag() throws XMLStreamException {
        return this.reader.nextTag();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent peek() throws XMLStreamException {
        return this.reader.peek();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.reader.remove();
    }

    public void setParent(XMLEventReader xMLEventReader) {
        this.reader = xMLEventReader;
    }

    public EventReaderDelegate(XMLEventReader xMLEventReader) {
        this.reader = xMLEventReader;
    }
}
