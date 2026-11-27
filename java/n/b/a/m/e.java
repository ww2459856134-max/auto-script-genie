package n.b.a.m;

import java.util.NoSuchElementException;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamConstants;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.Characters;
import org.apache.poi.javax.xml.stream.events.XMLEvent;
import org.apache.poi.javax.xml.stream.util.XMLEventAllocator;

/* loaded from: classes2.dex */
public abstract class e implements n.b.a.d, XMLStreamConstants {
    protected final XMLEventAllocator c;
    protected final n.b.a.i d;
    protected XMLEvent e = null;
    protected int f = 1;
    protected int g = 7;

    protected e(XMLEventAllocator xMLEventAllocator, n.b.a.i iVar) {
        this.c = xMLEventAllocator;
        this.d = iVar;
    }

    protected XMLStreamException a(RuntimeException runtimeException) {
        for (Throwable cause = runtimeException.getCause(); cause != null; cause = cause.getCause()) {
            if (cause instanceof XMLStreamException) {
                return (XMLStreamException) cause;
            }
        }
        throw runtimeException;
    }

    protected XMLEvent b(boolean z, int i2) throws XMLStreamException {
        try {
            XMLEvent xMLEventAllocate = this.c.allocate(this.d);
            if (z && i2 == 8) {
                k();
            }
            return xMLEventAllocate;
        } catch (RuntimeException e) {
            throw a(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public void close() throws XMLStreamException {
        this.d.close();
    }

    protected XMLEvent d() throws XMLStreamException {
        return this.c.allocate(this.d);
    }

    protected final String e(int i2, int i3) {
        String strF = f(i2, i3);
        if (strF != null) {
            return strF;
        }
        if (i2 == 1) {
            return "Current state not START_ELEMENT when calling getElementText()";
        }
        if (i2 == 2) {
            return "Expected a text token";
        }
        if (i2 == 3) {
            return "Only all-whitespace CHARACTERS/CDATA (or SPACE) allowed for nextTag()";
        }
        if (i2 == 4) {
            return "Should only encounter START_ELEMENT/END_ELEMENT, SPACE, or all-white-space CHARACTERS";
        }
        return "Internal error (unrecognized error type: " + i2 + ")";
    }

    protected abstract String f(int i2, int i3);

    protected void g(String str) throws XMLStreamException {
        h(str, this.d.getLocation());
        throw null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public String getElementText() throws XMLStreamException {
        XMLEvent xMLEventNextEvent = this.e;
        if (xMLEventNextEvent == null) {
            return this.d.getElementText();
        }
        this.e = null;
        int i2 = this.g;
        if (i2 != 1) {
            g(e(1, i2));
            throw null;
        }
        StringBuffer stringBuffer = null;
        String str = null;
        while (!xMLEventNextEvent.isEndElement()) {
            int eventType = xMLEventNextEvent.getEventType();
            if (eventType != 5 && eventType != 3) {
                if (!xMLEventNextEvent.isCharacters()) {
                    g(e(2, eventType));
                    throw null;
                }
                String data = xMLEventNextEvent.asCharacters().getData();
                if (str == null) {
                    str = data;
                } else {
                    if (stringBuffer == null) {
                        stringBuffer = new StringBuffer(str.length() + data.length());
                        stringBuffer.append(str);
                    }
                    stringBuffer.append(data);
                }
            }
            xMLEventNextEvent = nextEvent();
        }
        return stringBuffer != null ? stringBuffer.toString() : str == null ? "" : str;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public Object getProperty(String str) {
        return this.d.getProperty(str);
    }

    protected abstract void h(String str, Location location) throws XMLStreamException;

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader, java.util.Iterator
    public boolean hasNext() {
        return this.f != 2;
    }

    protected void i() {
        throw new NoSuchElementException();
    }

    protected void j(XMLStreamException xMLStreamException) {
        Throwable nestedException = xMLStreamException.getNestedException();
        Throwable nestedException2 = xMLStreamException;
        if (nestedException != null) {
            nestedException2 = xMLStreamException.getNestedException();
        }
        if (nestedException2 instanceof RuntimeException) {
            throw ((RuntimeException) nestedException2);
        }
        if (nestedException2 instanceof Error) {
            throw ((Error) nestedException2);
        }
        throw new RuntimeException("[was " + nestedException2.getClass() + "] " + nestedException2.getMessage(), nestedException2);
    }

    protected void k() throws XMLStreamException {
        this.f = 2;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            return nextEvent();
        } catch (XMLStreamException e) {
            j(e);
            throw null;
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent nextEvent() throws XMLStreamException {
        int i2 = this.f;
        if (i2 == 2) {
            i();
            throw null;
        }
        if (i2 == 1) {
            this.f = 3;
            return d();
        }
        XMLEvent xMLEvent = this.e;
        if (xMLEvent == null) {
            return b(true, this.d.next());
        }
        this.e = null;
        if (xMLEvent.isEndDocument()) {
            k();
        }
        return xMLEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public XMLEvent nextTag() throws XMLStreamException {
        XMLEvent xMLEvent = this.e;
        if (xMLEvent != null) {
            this.e = null;
            int eventType = xMLEvent.getEventType();
            if (eventType != 12) {
                switch (eventType) {
                    case 1:
                    case 2:
                        return xMLEvent;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                        break;
                    case 4:
                        if (!((Characters) xMLEvent).isWhiteSpace()) {
                            g(e(3, eventType));
                            throw null;
                        }
                        break;
                    case 8:
                        return null;
                    default:
                        g(e(4, eventType));
                        throw null;
                }
            }
        } else if (this.f == 1) {
            this.f = 3;
        }
        while (true) {
            int next = this.d.next();
            if (next == 8) {
                return null;
            }
            if (next != 12) {
                switch (next) {
                    case 1:
                    case 2:
                        return b(false, next);
                    case 3:
                    case 5:
                    case 6:
                    case 4:
                        break;
                    default:
                        g(e(4, next));
                        throw null;
                }
            }
            if (!this.d.isWhiteSpace()) {
                g(e(3, next));
                throw null;
            }
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent peek() throws XMLStreamException {
        if (this.e == null) {
            int i2 = this.f;
            if (i2 == 2) {
                return null;
            }
            if (i2 == 1) {
                this.g = 7;
                this.e = d();
                this.f = 3;
            } else {
                this.g = this.d.getEventType();
                this.e = b(false, this.d.next());
            }
        }
        return this.e;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Can not remove events from XMLEventReader.");
    }
}
