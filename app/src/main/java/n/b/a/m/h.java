package n.b.a.m;

import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.poi.javax.xml.stream.util.StreamReaderDelegate;

/* loaded from: classes2.dex */
public class h extends StreamReaderDelegate implements n.b.a.i, n.b.a.a, n.b.a.b, n.b.a.c {
    protected int c;
    protected String d;

    protected h(XMLStreamReader xMLStreamReader) {
        super(xMLStreamReader);
        this.c = 0;
    }

    public static n.b.a.i a(XMLStreamReader xMLStreamReader) {
        return xMLStreamReader instanceof n.b.a.i ? (n.b.a.i) xMLStreamReader : new h(xMLStreamReader);
    }

    @Override // n.b.a.i
    public n.b.a.b getDTDInfo() throws XMLStreamException {
        if (getEventType() != 11) {
            return null;
        }
        return this;
    }

    @Override // n.b.a.b
    public String getDTDInternalSubset() {
        if (getEventType() == 11) {
            return getText();
        }
        return null;
    }

    @Override // n.b.a.b
    public String getDTDPublicId() {
        return null;
    }

    @Override // n.b.a.b
    public String getDTDRootName() {
        return null;
    }

    @Override // n.b.a.b
    public String getDTDSystemId() {
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.util.StreamReaderDelegate, org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getElementText() throws XMLStreamException {
        boolean z = getEventType() == 1;
        String elementText = super.getElementText();
        if (z) {
            this.c--;
        }
        return elementText;
    }

    @Override // n.b.a.i
    public NamespaceContext getNonTransientNamespaceContext() {
        return null;
    }

    @Override // n.b.a.b
    public Object getProcessedDTD() {
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.util.StreamReaderDelegate, org.apache.poi.javax.xml.stream.XMLStreamReader
    public int next() throws XMLStreamException {
        if (this.d != null) {
            this.d = null;
            return 2;
        }
        int next = super.next();
        if (next == 1) {
            this.c++;
        } else if (next == 2) {
            this.c--;
        }
        return next;
    }
}
