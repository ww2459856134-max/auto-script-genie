package n.b.a.m.n;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.DTD;
import org.apache.poi.javax.xml.stream.events.EntityDeclaration;
import org.apache.poi.javax.xml.stream.events.NotationDeclaration;

/* loaded from: classes2.dex */
public class e extends b implements n.b.a.k.a {
    protected final String d;
    protected final String e;
    protected final String f;
    protected final String g;

    /* renamed from: h, reason: collision with root package name */
    protected final Object f2539h;

    /* renamed from: i, reason: collision with root package name */
    protected String f2540i;

    public e(Location location, String str, String str2, String str3, String str4, Object obj) {
        super(location);
        this.f2540i = null;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.f2540i = null;
        this.f2539h = obj;
    }

    @Override // n.b.a.k.b
    public void c(n.b.a.j jVar) throws XMLStreamException {
        String str = this.d;
        if (str != null) {
            jVar.b(str, this.e, this.f, this.g);
        } else {
            jVar.writeDTD(f());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof DTD)) {
            return b.d(getDocumentTypeDeclaration(), ((DTD) obj).getDocumentTypeDeclaration());
        }
        return false;
    }

    protected String f() throws IOException, XMLStreamException {
        if (this.f2540i == null) {
            String str = this.g;
            StringWriter stringWriter = new StringWriter(str != null ? 60 + str.length() + 4 : 60);
            writeAsEncodedUnicode(stringWriter);
            this.f2540i = stringWriter.toString();
        }
        return this.f2540i;
    }

    @Override // org.apache.poi.javax.xml.stream.events.DTD
    public String getDocumentTypeDeclaration() {
        try {
            return f();
        } catch (XMLStreamException e) {
            throw new RuntimeException("Internal error: " + e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.events.DTD
    public List<EntityDeclaration> getEntities() {
        return null;
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 11;
    }

    @Override // org.apache.poi.javax.xml.stream.events.DTD
    public List<NotationDeclaration> getNotations() {
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.events.DTD
    public Object getProcessedDTD() {
        return this.f2539h;
    }

    public int hashCode() {
        String str;
        String str2 = this.d;
        int iHashCode = str2 != null ? 0 ^ str2.hashCode() : 0;
        String str3 = this.e;
        if (str3 != null) {
            iHashCode ^= str3.hashCode();
        }
        String str4 = this.f;
        if (str4 != null) {
            iHashCode ^= str4.hashCode();
        }
        String str5 = this.g;
        if (str5 != null) {
            iHashCode ^= str5.hashCode();
        }
        Object obj = this.f2539h;
        if (obj != null) {
            iHashCode ^= obj.hashCode();
        }
        return (iHashCode != 0 || (str = this.f2540i) == null) ? iHashCode : iHashCode ^ str.hashCode();
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws IOException, XMLStreamException {
        try {
            String str = this.f2540i;
            if (str != null) {
                writer.write(str);
                return;
            }
            writer.write("<!DOCTYPE");
            if (this.d != null) {
                writer.write(32);
                writer.write(this.d);
            }
            if (this.e != null) {
                if (this.f != null) {
                    writer.write(" PUBLIC \"");
                    writer.write(this.f);
                    writer.write(34);
                } else {
                    writer.write(" SYSTEM");
                }
                writer.write(" \"");
                writer.write(this.e);
                writer.write(34);
            }
            if (this.g != null) {
                writer.write(" [");
                writer.write(this.g);
                writer.write(93);
            }
            writer.write(">");
        } catch (IOException e) {
            e(e);
            throw null;
        }
    }

    public e(Location location, String str, String str2) {
        this(location, str, null, null, str2, null);
    }

    public e(Location location, String str) {
        this(location, null, null, null, null, null);
        this.f2540i = str;
    }
}
