package i.e.a.i;

import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public class e extends XMLStreamException {
    final String c;

    public e(String str) {
        super(str);
        this.c = str;
    }

    protected String a() {
        Location location = getLocation();
        if (location == null) {
            return null;
        }
        return location.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String strA = a();
        if (strA == null) {
            return super.getMessage();
        }
        StringBuilder sb = new StringBuilder(this.c.length() + strA.length() + 20);
        sb.append(this.c);
        sb.append('\n');
        sb.append(" at ");
        sb.append(strA);
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    public e(Throwable th) {
        super(th.getMessage(), th);
        this.c = th.getMessage();
        if (getCause() == null) {
            initCause(th);
        }
    }

    public e(String str, Location location) {
        super(str, location);
        this.c = str;
    }
}
