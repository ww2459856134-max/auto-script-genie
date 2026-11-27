package n.b.a.m.n;

import java.io.IOException;
import java.io.Writer;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.EntityDeclaration;
import org.apache.poi.javax.xml.stream.events.EntityReference;

/* loaded from: classes2.dex */
public class i extends b implements EntityReference {
    protected final EntityDeclaration d;

    public i(Location location, EntityDeclaration entityDeclaration) {
        super(location);
        this.d = entityDeclaration;
    }

    @Override // n.b.a.k.b
    public void c(n.b.a.j jVar) throws XMLStreamException {
        jVar.writeEntityRef(getName());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof EntityReference)) {
            return getName().equals(((EntityReference) obj).getName());
        }
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.EntityReference
    public EntityDeclaration getDeclaration() {
        return this.d;
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 9;
    }

    @Override // org.apache.poi.javax.xml.stream.events.EntityReference
    public String getName() {
        return this.d.getName();
    }

    public int hashCode() {
        return getName().hashCode();
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isEntityReference() {
        return true;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws IOException, XMLStreamException {
        try {
            writer.write(38);
            writer.write(getName());
            writer.write(59);
        } catch (IOException e) {
            e(e);
            throw null;
        }
    }

    public i(Location location, String str) {
        super(location);
        this.d = new h(location, str);
    }
}
