package org.apache.poi.javax.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.transform.Source;
import org.apache.poi.javax.xml.stream.util.XMLEventAllocator;

/* loaded from: classes.dex */
public abstract class XMLInputFactory {
    public static final String ALLOCATOR = "org.apache.poi.javax.xml.stream.allocator";
    public static final String IS_COALESCING = "org.apache.poi.javax.xml.stream.isCoalescing";
    public static final String IS_NAMESPACE_AWARE = "org.apache.poi.javax.xml.stream.isNamespaceAware";
    public static final String IS_REPLACING_ENTITY_REFERENCES = "org.apache.poi.javax.xml.stream.isReplacingEntityReferences";
    public static final String IS_SUPPORTING_EXTERNAL_ENTITIES = "org.apache.poi.javax.xml.stream.isSupportingExternalEntities";
    public static final String IS_VALIDATING = "org.apache.poi.javax.xml.stream.isValidating";
    public static final String REPORTER = "org.apache.poi.javax.xml.stream.reporter";
    public static final String RESOLVER = "org.apache.poi.javax.xml.stream.resolver";
    public static final String SUPPORT_DTD = "org.apache.poi.javax.xml.stream.supportDTD";

    protected XMLInputFactory() {
    }

    public static XMLInputFactory newInstance() throws FactoryConfigurationError {
        return (XMLInputFactory) FactoryFinder.find("org.apache.poi.javax.xml.stream.XMLInputFactory", "com.bea.xml.stream.MXParserFactory");
    }

    public abstract XMLEventReader createFilteredReader(XMLEventReader xMLEventReader, EventFilter eventFilter) throws XMLStreamException;

    public abstract XMLStreamReader createFilteredReader(XMLStreamReader xMLStreamReader, StreamFilter streamFilter) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(InputStream inputStream) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(InputStream inputStream, String str) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(Reader reader) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(String str, InputStream inputStream) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(String str, Reader reader) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(Source source) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(XMLStreamReader xMLStreamReader) throws XMLStreamException;

    public abstract XMLStreamReader createXMLStreamReader(InputStream inputStream) throws XMLStreamException;

    public abstract XMLStreamReader createXMLStreamReader(InputStream inputStream, String str) throws XMLStreamException;

    public abstract XMLStreamReader createXMLStreamReader(Reader reader) throws XMLStreamException;

    public abstract XMLStreamReader createXMLStreamReader(String str, InputStream inputStream) throws XMLStreamException;

    public abstract XMLStreamReader createXMLStreamReader(String str, Reader reader) throws XMLStreamException;

    public abstract XMLStreamReader createXMLStreamReader(Source source) throws XMLStreamException;

    public abstract XMLEventAllocator getEventAllocator();

    public abstract Object getProperty(String str) throws IllegalArgumentException;

    public abstract XMLReporter getXMLReporter();

    public abstract XMLResolver getXMLResolver();

    public abstract boolean isPropertySupported(String str);

    public abstract void setEventAllocator(XMLEventAllocator xMLEventAllocator);

    public abstract void setProperty(String str, Object obj) throws IllegalArgumentException;

    public abstract void setXMLReporter(XMLReporter xMLReporter);

    public abstract void setXMLResolver(XMLResolver xMLResolver);

    public static XMLInputFactory newInstance(String str, ClassLoader classLoader) throws FactoryConfigurationError {
        return (XMLInputFactory) FactoryFinder.find(str, "com.bea.xml.stream.MXParserFactory", classLoader);
    }
}
