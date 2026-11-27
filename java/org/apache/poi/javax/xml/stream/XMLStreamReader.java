package org.apache.poi.javax.xml.stream;

import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;

/* loaded from: classes.dex */
public interface XMLStreamReader extends XMLStreamConstants {
    void close() throws XMLStreamException;

    int getAttributeCount();

    String getAttributeLocalName(int i2);

    QName getAttributeName(int i2);

    String getAttributeNamespace(int i2);

    String getAttributePrefix(int i2);

    String getAttributeType(int i2);

    String getAttributeValue(int i2);

    String getAttributeValue(String str, String str2);

    String getCharacterEncodingScheme();

    String getElementText() throws XMLStreamException;

    String getEncoding();

    int getEventType();

    String getLocalName();

    Location getLocation();

    QName getName();

    NamespaceContext getNamespaceContext();

    int getNamespaceCount();

    String getNamespacePrefix(int i2);

    String getNamespaceURI();

    String getNamespaceURI(int i2);

    String getNamespaceURI(String str);

    String getPIData();

    String getPITarget();

    String getPrefix();

    Object getProperty(String str) throws IllegalArgumentException;

    String getText();

    int getTextCharacters(int i2, char[] cArr, int i3, int i4) throws XMLStreamException;

    char[] getTextCharacters();

    int getTextLength();

    int getTextStart();

    String getVersion();

    boolean hasName();

    boolean hasNext() throws XMLStreamException;

    boolean hasText();

    boolean isAttributeSpecified(int i2);

    boolean isCharacters();

    boolean isEndElement();

    boolean isStandalone();

    boolean isStartElement();

    boolean isWhiteSpace();

    int next() throws XMLStreamException;

    int nextTag() throws XMLStreamException;

    void require(int i2, String str, String str2) throws XMLStreamException;

    boolean standaloneSet();
}
