package n.b.a.m.n;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.EntityDeclaration;

/* loaded from: classes2.dex */
public class h extends b implements EntityDeclaration {
    protected final String d;

    public h(Location location, String str) {
        super(location);
        this.d = str;
    }

    @Override // n.b.a.k.b
    public void c(n.b.a.j jVar) throws IOException, XMLStreamException {
        StringWriter stringWriter = new StringWriter();
        writeAsEncodedUnicode(stringWriter);
        jVar.d(stringWriter.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof EntityDeclaration)) {
            return false;
        }
        EntityDeclaration entityDeclaration = (EntityDeclaration) obj;
        return b.d(getName(), entityDeclaration.getName()) && b.d(getBaseURI(), entityDeclaration.getBaseURI()) && b.d(getNotationName(), entityDeclaration.getNotationName()) && b.d(getPublicId(), entityDeclaration.getPublicId()) && b.d(getReplacementText(), entityDeclaration.getReplacementText()) && b.d(getSystemId(), entityDeclaration.getSystemId());
    }

    @Override // org.apache.poi.javax.xml.stream.events.EntityDeclaration
    public String getBaseURI() {
        return "";
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 15;
    }

    @Override // org.apache.poi.javax.xml.stream.events.EntityDeclaration
    public String getName() {
        return this.d;
    }

    @Override // org.apache.poi.javax.xml.stream.events.EntityDeclaration
    public String getNotationName() {
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.events.EntityDeclaration
    public String getPublicId() {
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.events.EntityDeclaration
    public String getReplacementText() {
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.events.EntityDeclaration
    public String getSystemId() {
        return null;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws IOException, XMLStreamException {
        try {
            writer.write("<!ENTITY ");
            writer.write(getName());
            writer.write(" \"");
            String replacementText = getReplacementText();
            if (replacementText != null) {
                writer.write(replacementText);
            }
            writer.write("\">");
        } catch (IOException e) {
            e(e);
            throw null;
        }
    }
}
