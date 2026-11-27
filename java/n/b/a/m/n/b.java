package n.b.a.m.n;

import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.Characters;
import org.apache.poi.javax.xml.stream.events.EndElement;
import org.apache.poi.javax.xml.stream.events.StartElement;

/* loaded from: classes2.dex */
public abstract class b implements n.b.a.k.b {

    @Deprecated
    protected final Location c;

    protected b(Location location) {
        this.c = location;
    }

    protected static int a(Iterator<?> it, int i2) {
        if (it != null) {
            while (it.hasNext()) {
                i2 ^= it.next().hashCode();
            }
        }
        return i2;
    }

    protected static boolean b(Iterator<?> it, Iterator<?> it2) {
        if (it == null || it2 == null) {
            return it == it2;
        }
        while (it.hasNext()) {
            if (!it2.hasNext() || !it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    protected static boolean d(String str, String str2) {
        return (str == null || str.length() == 0) ? str2 == null || str2.length() == 0 : str2 != null && str.equals(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public Characters asCharacters() {
        return (Characters) this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public EndElement asEndElement() {
        return (EndElement) this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public StartElement asStartElement() {
        return (StartElement) this;
    }

    protected void e(IOException iOException) throws XMLStreamException {
        throw new XMLStreamException(iOException.getMessage(), iOException);
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public abstract int getEventType();

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public Location getLocation() {
        return this.c;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public QName getSchemaType() {
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isAttribute() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isCharacters() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isEndDocument() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isEndElement() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isEntityReference() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isNamespace() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isProcessingInstruction() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isStartDocument() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isStartElement() {
        return false;
    }

    public String toString() {
        return "[Stax Event #" + getEventType() + "]";
    }
}
