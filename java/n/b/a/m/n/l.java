package n.b.a.m.n;

import java.io.IOException;
import java.io.Writer;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.ProcessingInstruction;

/* loaded from: classes2.dex */
public class l extends b implements ProcessingInstruction {
    final String d;
    final String e;

    public l(Location location, String str, String str2) {
        super(location);
        this.d = str;
        this.e = str2;
    }

    @Override // n.b.a.k.b
    public void c(n.b.a.j jVar) throws XMLStreamException {
        String str = this.e;
        if (str == null || str.length() <= 0) {
            jVar.writeProcessingInstruction(this.d);
        } else {
            jVar.writeProcessingInstruction(this.d, this.e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ProcessingInstruction)) {
            return false;
        }
        ProcessingInstruction processingInstruction = (ProcessingInstruction) obj;
        return this.d.equals(processingInstruction.getTarget()) && b.d(this.e, processingInstruction.getData());
    }

    @Override // org.apache.poi.javax.xml.stream.events.ProcessingInstruction
    public String getData() {
        return this.e;
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 3;
    }

    @Override // org.apache.poi.javax.xml.stream.events.ProcessingInstruction
    public String getTarget() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = this.d.hashCode();
        String str = this.e;
        return str != null ? iHashCode ^ str.hashCode() : iHashCode;
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isProcessingInstruction() {
        return true;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws IOException, XMLStreamException {
        try {
            writer.write("<?");
            writer.write(this.d);
            String str = this.e;
            if (str != null && str.length() > 0) {
                writer.write(this.e);
            }
            writer.write("?>");
        } catch (IOException e) {
            e(e);
            throw null;
        }
    }
}
