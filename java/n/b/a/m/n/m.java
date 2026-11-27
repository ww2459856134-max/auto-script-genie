package n.b.a.m.n;

import java.io.IOException;
import java.io.Writer;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.poi.javax.xml.stream.events.StartDocument;

/* loaded from: classes2.dex */
public class m extends b implements StartDocument {
    private final boolean d;
    private final boolean e;
    private final String f;
    private final boolean g;

    /* renamed from: h, reason: collision with root package name */
    private final String f2542h;

    /* renamed from: i, reason: collision with root package name */
    private final String f2543i;

    public m(Location location, XMLStreamReader xMLStreamReader) {
        super(location);
        this.d = xMLStreamReader.standaloneSet();
        this.e = xMLStreamReader.isStandalone();
        String version = xMLStreamReader.getVersion();
        this.f = (version == null || version.length() == 0) ? "1.0" : version;
        String characterEncodingScheme = xMLStreamReader.getCharacterEncodingScheme();
        this.f2542h = characterEncodingScheme;
        this.g = characterEncodingScheme != null && characterEncodingScheme.length() > 0;
        this.f2543i = location != null ? location.getSystemId() : "";
    }

    @Override // n.b.a.k.b
    public void c(n.b.a.j jVar) throws XMLStreamException {
        jVar.writeStartDocument();
    }

    @Override // org.apache.poi.javax.xml.stream.events.StartDocument
    public boolean encodingSet() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof StartDocument)) {
            return false;
        }
        StartDocument startDocument = (StartDocument) obj;
        return encodingSet() == startDocument.encodingSet() && isStandalone() == startDocument.isStandalone() && standaloneSet() == startDocument.standaloneSet() && b.d(getCharacterEncodingScheme(), startDocument.getCharacterEncodingScheme()) && b.d(getSystemId(), startDocument.getSystemId()) && b.d(getVersion(), startDocument.getVersion());
    }

    @Override // org.apache.poi.javax.xml.stream.events.StartDocument
    public String getCharacterEncodingScheme() {
        return this.f2542h;
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 7;
    }

    @Override // org.apache.poi.javax.xml.stream.events.StartDocument
    public String getSystemId() {
        return this.f2543i;
    }

    @Override // org.apache.poi.javax.xml.stream.events.StartDocument
    public String getVersion() {
        return this.f;
    }

    public int hashCode() {
        int iHashCode = encodingSet() ? 1 : 0;
        if (isStandalone()) {
            iHashCode--;
        }
        if (standaloneSet()) {
            iHashCode ^= 1;
        }
        String str = this.f;
        if (str != null) {
            iHashCode ^= str.hashCode();
        }
        String str2 = this.f2542h;
        if (str2 != null) {
            iHashCode ^= str2.hashCode();
        }
        String str3 = this.f2543i;
        return str3 != null ? iHashCode ^ str3.hashCode() : iHashCode;
    }

    @Override // org.apache.poi.javax.xml.stream.events.StartDocument
    public boolean isStandalone() {
        return this.e;
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isStartDocument() {
        return true;
    }

    @Override // org.apache.poi.javax.xml.stream.events.StartDocument
    public boolean standaloneSet() {
        return this.d;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws IOException, XMLStreamException {
        try {
            writer.write("<?xml version=\"");
            String str = this.f;
            if (str == null || str.length() == 0) {
                writer.write("1.0");
            } else {
                writer.write(this.f);
            }
            writer.write(34);
            if (this.g) {
                writer.write(" encoding=\"");
                writer.write(this.f2542h);
                writer.write(34);
            }
            if (this.d) {
                if (this.e) {
                    writer.write(" standalone=\"yes\"");
                } else {
                    writer.write(" standalone=\"no\"");
                }
            }
            writer.write(" ?>");
        } catch (IOException e) {
            e(e);
            throw null;
        }
    }

    public m(Location location) {
        this(location, (String) null);
    }

    public m(Location location, String str) {
        this(location, str, null);
    }

    public m(Location location, String str, String str2) {
        this(location, str, str2, false, false);
    }

    public m(Location location, String str, String str2, boolean z, boolean z2) {
        super(location);
        this.f2542h = str;
        this.g = str != null && str.length() > 0;
        this.f = str2;
        this.d = z;
        this.e = z2;
        this.f2543i = "";
    }
}
