package n.b.a;

import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;

/* loaded from: classes2.dex */
public interface i extends XMLStreamReader {
    b getDTDInfo() throws XMLStreamException;

    NamespaceContext getNonTransientNamespaceContext();
}
