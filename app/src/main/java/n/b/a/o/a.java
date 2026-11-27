package n.b.a.o;

import n.b.a.i;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.poi.javax.xml.stream.util.StreamReaderDelegate;

/* loaded from: classes2.dex */
public abstract class a extends StreamReaderDelegate implements i {
    protected i c;

    public a(i iVar) {
        super(iVar);
        this.c = iVar;
    }

    @Override // n.b.a.i
    public n.b.a.b getDTDInfo() throws XMLStreamException {
        return this.c.getDTDInfo();
    }

    @Override // n.b.a.i
    public NamespaceContext getNonTransientNamespaceContext() {
        return this.c.getNonTransientNamespaceContext();
    }

    @Override // org.apache.poi.javax.xml.stream.util.StreamReaderDelegate
    public void setParent(XMLStreamReader xMLStreamReader) {
        super.setParent(xMLStreamReader);
        this.c = (i) xMLStreamReader;
    }
}
