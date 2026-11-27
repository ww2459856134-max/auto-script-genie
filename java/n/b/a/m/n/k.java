package n.b.a.m.n;

import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.events.Namespace;

/* loaded from: classes2.dex */
public class k extends a implements Namespace {
    final String g;

    /* renamed from: h, reason: collision with root package name */
    final String f2541h;

    protected k(Location location, String str) {
        super(location, "xmlns", "http://www.w3.org/2000/xmlns/", null, str, true);
        this.g = "";
        this.f2541h = str;
    }

    public static k g(Location location, String str) {
        return new k(location, str);
    }

    public static k h(Location location, String str, String str2) {
        return (str == null || str.length() == 0) ? new k(location, str2) : new k(location, str, str2);
    }

    @Override // n.b.a.m.n.a, n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 13;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Namespace
    public String getNamespaceURI() {
        return this.f2541h;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Namespace
    public String getPrefix() {
        return this.g;
    }

    @Override // org.apache.poi.javax.xml.stream.events.Namespace
    public boolean isDefaultNamespaceDeclaration() {
        return this.g.length() == 0;
    }

    @Override // n.b.a.m.n.b, org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isNamespace() {
        return true;
    }

    protected k(Location location, String str, String str2) {
        super(location, str, "http://www.w3.org/2000/xmlns/", "xmlns", str2, true);
        this.g = str;
        this.f2541h = str2;
    }
}
