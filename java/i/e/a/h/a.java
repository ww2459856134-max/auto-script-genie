package i.e.a.h;

import n.b.a.m.n.o;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.poi.javax.xml.stream.events.XMLEvent;
import org.apache.poi.javax.xml.stream.util.XMLEventAllocator;

/* loaded from: classes.dex */
public final class a extends o {
    static final a e = new a(true);
    protected final boolean c;
    protected Location d = null;

    protected a(boolean z) {
        this.c = z;
    }

    public static a f() {
        return e;
    }

    public static a g() {
        return new a(false);
    }

    @Override // n.b.a.m.n.o, org.apache.poi.javax.xml.stream.util.XMLEventAllocator
    public XMLEvent allocate(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        return xMLStreamReader.getEventType() == 257 ? c.f() : super.allocate(xMLStreamReader);
    }

    @Override // n.b.a.m.n.o
    protected Location e(XMLStreamReader xMLStreamReader) {
        if (this.c) {
            return xMLStreamReader.getLocation();
        }
        Location location = this.d;
        if (location != null) {
            return location;
        }
        Location location2 = xMLStreamReader.getLocation();
        this.d = location2;
        return location2;
    }

    @Override // org.apache.poi.javax.xml.stream.util.XMLEventAllocator
    public XMLEventAllocator newInstance() {
        return new a(this.c);
    }
}
