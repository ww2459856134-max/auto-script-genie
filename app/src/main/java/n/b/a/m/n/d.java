package n.b.a.m.n;

import java.io.IOException;
import java.io.Writer;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.Comment;

/* loaded from: classes2.dex */
public class d extends b implements Comment {
    final String d;

    public d(Location location, String str) {
        super(location);
        this.d = str;
    }

    @Override // n.b.a.k.b
    public void c(n.b.a.j jVar) throws XMLStreamException {
        jVar.writeComment(this.d);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof Comment)) {
            return this.d.equals(((Comment) obj).getText());
        }
        return false;
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 5;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Comment
    public String getText() {
        return this.d;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws IOException, XMLStreamException {
        try {
            writer.write("<!--");
            writer.write(this.d);
            writer.write("-->");
        } catch (IOException e) {
            e(e);
            throw null;
        }
    }
}
