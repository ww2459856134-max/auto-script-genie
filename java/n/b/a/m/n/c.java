package n.b.a.m.n;

import java.io.IOException;
import java.io.Writer;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.Characters;

/* loaded from: classes2.dex */
public class c extends b implements Characters {
    final String d;
    final boolean e;
    final boolean f;
    boolean g;

    /* renamed from: h, reason: collision with root package name */
    boolean f2538h;

    public c(Location location, String str, boolean z) {
        super(location);
        this.g = false;
        this.f2538h = false;
        this.d = str;
        this.e = z;
        this.f = false;
    }

    public static final c f(Location location, String str) {
        return new c(location, str, false, true, true);
    }

    public static final c g(Location location, String str) {
        return new c(location, str, false, true, false);
    }

    protected static void i(Writer writer, String str) throws IOException {
        int i2;
        int length = str.length();
        for (int i3 = 0; i3 < length; i3 = i2 + 1) {
            char cCharAt = 0;
            i2 = i3;
            while (i2 < length && (cCharAt = str.charAt(i2)) != '<' && cCharAt != '&' && (cCharAt != '>' || i2 < 2 || str.charAt(i2 - 1) != ']' || str.charAt(i2 - 2) != ']')) {
                i2++;
            }
            int i4 = i2 - i3;
            if (i4 > 0) {
                writer.write(str, i3, i4);
            }
            if (i2 < length) {
                if (cCharAt == '<') {
                    writer.write("&lt;");
                } else if (cCharAt == '&') {
                    writer.write("&amp;");
                } else if (cCharAt == '>') {
                    writer.write("&gt;");
                }
            }
        }
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public Characters asCharacters() {
        return this;
    }

    @Override // n.b.a.k.b
    public void c(n.b.a.j jVar) throws XMLStreamException {
        if (this.e) {
            jVar.writeCData(this.d);
        } else {
            jVar.writeCharacters(this.d);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Characters)) {
            return false;
        }
        Characters characters = (Characters) obj;
        return this.d.equals(characters.getData()) && isCData() == characters.isCData();
    }

    @Override // org.apache.poi.javax.xml.stream.events.Characters
    public String getData() {
        return this.d;
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return this.e ? 12 : 4;
    }

    public void h(boolean z) {
        this.g = true;
        this.f2538h = z;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    @Override // org.apache.poi.javax.xml.stream.events.Characters
    public boolean isCData() {
        return this.e;
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isCharacters() {
        return true;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Characters
    public boolean isIgnorableWhiteSpace() {
        return this.f;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Characters
    public boolean isWhiteSpace() {
        if (!this.g) {
            this.g = true;
            String str = this.d;
            int length = str.length();
            int i2 = 0;
            while (i2 < length && str.charAt(i2) <= ' ') {
                i2++;
            }
            this.f2538h = i2 == length;
        }
        return this.f2538h;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public void writeAsEncodedUnicode(Writer writer) throws IOException, XMLStreamException {
        try {
            if (!this.e) {
                i(writer, this.d);
                return;
            }
            writer.write("<![CDATA[");
            writer.write(this.d);
            writer.write("]]>");
        } catch (IOException e) {
            e(e);
            throw null;
        }
    }

    private c(Location location, String str, boolean z, boolean z2, boolean z3) {
        super(location);
        this.g = false;
        this.f2538h = false;
        this.d = str;
        this.e = z;
        this.f2538h = z2;
        if (z2) {
            this.g = true;
            this.f = z3;
        } else {
            this.g = false;
            this.f = false;
        }
    }
}
