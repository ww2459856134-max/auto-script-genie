package i.e.a;

import org.apache.poi.javax.xml.stream.Location;

/* loaded from: classes.dex */
public class d extends n.b.a.p.c {
    protected d(n.b.a.p.d dVar, String str) {
        super(dVar, str);
    }

    public static d c(n.b.a.p.d dVar) {
        Location locationA = dVar.a();
        return locationA == null ? new d(dVar, dVar.b()) : new d(dVar, dVar.b(), locationA);
    }

    protected String d() {
        Location location = getLocation();
        if (location == null) {
            return null;
        }
        return location.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String strD = d();
        if (strD == null) {
            return super.getMessage();
        }
        String strB = a().b();
        StringBuilder sb = new StringBuilder(strB.length() + strD.length() + 20);
        sb.append(strB);
        sb.append('\n');
        sb.append(" at ");
        sb.append(strD);
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return d.class.getName() + ": " + getMessage();
    }

    protected d(n.b.a.p.d dVar, String str, Location location) {
        super(dVar, str, location);
    }
}
