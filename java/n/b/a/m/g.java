package n.b.a.m;

import org.apache.poi.javax.xml.stream.StreamFilter;
import org.apache.poi.javax.xml.stream.XMLStreamConstants;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;

/* loaded from: classes2.dex */
public class g extends n.b.a.o.a implements XMLStreamConstants {
    final StreamFilter d;

    public g(XMLStreamReader xMLStreamReader, StreamFilter streamFilter) {
        super(h.a(xMLStreamReader));
        this.d = streamFilter;
    }

    @Override // org.apache.poi.javax.xml.stream.util.StreamReaderDelegate, org.apache.poi.javax.xml.stream.XMLStreamReader
    public int next() throws XMLStreamException {
        int next;
        do {
            next = this.c.next();
            if (this.d.accept(this)) {
                break;
            }
        } while (next != 8);
        return next;
    }

    @Override // org.apache.poi.javax.xml.stream.util.StreamReaderDelegate, org.apache.poi.javax.xml.stream.XMLStreamReader
    public int nextTag() throws XMLStreamException {
        int iNextTag;
        do {
            iNextTag = this.c.nextTag();
        } while (!this.d.accept(this));
        return iNextTag;
    }
}
