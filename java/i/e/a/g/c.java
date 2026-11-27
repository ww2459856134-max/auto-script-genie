package i.e.a.g;

import i.e.a.j.z;
import java.util.Collections;
import javax.xml.transform.dom.DOMSource;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public class c extends n.b.a.m.m.a {
    protected final z D;

    protected c(DOMSource dOMSource, z zVar) throws XMLStreamException {
        super(dOMSource, zVar.j0(), zVar.b0());
        this.D = zVar;
        if (zVar.O()) {
            p(zVar.d0());
        }
        if (zVar.P()) {
            q(zVar.e0());
        }
    }

    public static c t(DOMSource dOMSource, z zVar) throws XMLStreamException {
        return new c(dOMSource, zVar);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public Object getProperty(String str) {
        return str.equals("org.apache.poi.javax.xml.stream.entities") ? Collections.EMPTY_LIST : str.equals("org.apache.poi.javax.xml.stream.notations") ? Collections.EMPTY_LIST : this.D.a(str, true);
    }

    @Override // n.b.a.m.m.a
    protected void s(String str, Location location) throws XMLStreamException {
        throw new i.e.a.e(str, location);
    }
}
