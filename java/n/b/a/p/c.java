package n.b.a.p;

import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes2.dex */
public abstract class c extends XMLStreamException {
    protected d c;

    protected c(d dVar, String str) throws RuntimeException {
        super(str);
        if (dVar != null) {
            this.c = dVar;
        } else {
            b();
            throw null;
        }
    }

    protected static void b() throws RuntimeException {
        throw new IllegalArgumentException("Validation problem argument can not be null");
    }

    public d a() {
        return this.c;
    }

    protected c(d dVar, String str, Location location) throws RuntimeException {
        super(str, location);
        if (dVar != null) {
            this.c = dVar;
        } else {
            b();
            throw null;
        }
    }
}
