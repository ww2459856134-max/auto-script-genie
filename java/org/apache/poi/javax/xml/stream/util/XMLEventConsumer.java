package org.apache.poi.javax.xml.stream.util;

import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.XMLEvent;

/* loaded from: classes.dex */
public interface XMLEventConsumer {
    void add(XMLEvent xMLEvent) throws XMLStreamException;
}
