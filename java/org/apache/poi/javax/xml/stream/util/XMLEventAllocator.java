package org.apache.poi.javax.xml.stream.util;

import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.poi.javax.xml.stream.events.XMLEvent;

/* loaded from: classes.dex */
public interface XMLEventAllocator {
    XMLEvent allocate(XMLStreamReader xMLStreamReader) throws XMLStreamException;

    void allocate(XMLStreamReader xMLStreamReader, XMLEventConsumer xMLEventConsumer) throws XMLStreamException;

    XMLEventAllocator newInstance();
}
