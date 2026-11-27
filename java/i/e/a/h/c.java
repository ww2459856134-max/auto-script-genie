package i.e.a.h;

import i.e.a.i.d;
import java.io.Writer;
import n.b.a.j;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public class c extends n.b.a.m.n.b {
    private static final c d = new c();

    protected c() {
        super(d.c());
    }

    public static c f() {
        return d;
    }

    @Override // n.b.a.k.b
    public void c(j jVar) throws XMLStreamException {
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 257;
    }

    public int hashCode() {
        return 42;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
    }
}
