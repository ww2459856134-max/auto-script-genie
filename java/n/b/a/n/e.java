package n.b.a.n;

import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes2.dex */
public class e extends XMLStreamException {
    protected String c;

    public e(String str, String str2, IllegalArgumentException illegalArgumentException) {
        super(str2, illegalArgumentException);
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public e(String str, String str2, Location location, IllegalArgumentException illegalArgumentException) {
        super(str2, location, illegalArgumentException);
        this.c = str;
    }

    public e(String str, String str2, Location location) {
        super(str2, location);
        this.c = str;
    }
}
