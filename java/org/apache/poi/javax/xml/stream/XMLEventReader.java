package org.apache.poi.javax.xml.stream;

import java.util.Iterator;
import org.apache.poi.javax.xml.stream.events.XMLEvent;

/* loaded from: classes.dex */
public interface XMLEventReader extends Iterator {
    void close() throws XMLStreamException;

    String getElementText() throws XMLStreamException;

    Object getProperty(String str) throws IllegalArgumentException;

    @Override // java.util.Iterator
    boolean hasNext();

    XMLEvent nextEvent() throws XMLStreamException;

    XMLEvent nextTag() throws XMLStreamException;

    XMLEvent peek() throws XMLStreamException;
}
