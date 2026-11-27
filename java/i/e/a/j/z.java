package i.e.a.j;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.apache.poi.javax.xml.stream.XMLInputFactory;
import org.apache.poi.javax.xml.stream.XMLReporter;
import org.apache.poi.javax.xml.stream.XMLResolver;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public final class z extends i.e.a.i.a {
    private static final HashMap<String, Object> q;
    static final ThreadLocal<SoftReference<i.e.a.l.a>> r;
    private final y d;
    private final i.e.a.l.n e;
    private final String f;
    private final String g;

    /* renamed from: h, reason: collision with root package name */
    private final String f1604h;

    /* renamed from: i, reason: collision with root package name */
    private String f1605i;

    /* renamed from: j, reason: collision with root package name */
    private String f1606j;

    /* renamed from: k, reason: collision with root package name */
    private String f1607k;

    /* renamed from: l, reason: collision with root package name */
    private int f1608l;

    /* renamed from: m, reason: collision with root package name */
    private XMLReporter f1609m;

    /* renamed from: n, reason: collision with root package name */
    private XMLResolver f1610n;

    /* renamed from: o, reason: collision with root package name */
    private i.e.a.l.e f1611o;
    protected i.e.a.l.a p;

    static {
        HashMap<String, Object> map = new HashMap<>();
        q = map;
        Boolean bool = Boolean.TRUE;
        map.put(XMLInputFactory.IS_NAMESPACE_AWARE, bool);
        map.put(XMLInputFactory.IS_VALIDATING, 8);
        map.put(XMLInputFactory.IS_COALESCING, 2);
        map.put(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, 16);
        Boolean bool2 = Boolean.FALSE;
        map.put(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, bool2);
        map.put(XMLInputFactory.SUPPORT_DTD, 4);
        map.put(XMLInputFactory.REPORTER, null);
        map.put(XMLInputFactory.RESOLVER, null);
        map.put(XMLInputFactory.ALLOCATOR, null);
        map.put(n.b.a.e.P_LAZY_PARSING, 256);
        map.put(n.b.a.e.P_INTERN_NAMES, 512);
        map.put(n.b.a.e.P_INTERN_NS_URIS, 1024);
        map.put(n.b.a.e.P_AUTO_CLOSE_INPUT, Integer.valueOf(XMLEvent.ENTITY_REFERENCE));
        map.put(n.b.a.e.P_PRESERVE_LOCATION, Integer.valueOf(XMLEvent.CHANGE_PREFIX_MAPPING));
        map.put(n.b.a.e.P_REPORT_PROLOG_WHITESPACE, bool2);
        map.put(n.b.a.e.P_REPORT_CDATA, 2048);
        map.put(n.b.a.e.P_PRESERVE_LOCATION, bool);
        map.put(n.b.a.e.P_DTD_OVERRIDE, null);
        map.put("com.fasterxml.aalto.retainAttributeGeneralEntities", 16384);
        r = new ThreadLocal<>();
    }

    private z(String str, String str2, String str3, y yVar, int i2, int i3, XMLReporter xMLReporter, XMLResolver xMLResolver, i.e.a.l.n nVar) {
        super(i2, i3);
        this.f1605i = null;
        this.f1606j = null;
        this.f1607k = null;
        this.f1608l = 0;
        this.p = null;
        this.f = str;
        this.g = str2;
        this.f1604h = str3;
        SoftReference<i.e.a.l.a> softReference = r.get();
        if (softReference != null) {
            this.p = softReference.get();
        }
        this.d = yVar;
        this.a = i2;
        this.b = i3;
        this.f1609m = xMLReporter;
        this.f1610n = xMLResolver;
        this.e = nVar;
    }

    private i.e.a.l.a s() {
        i.e.a.l.a aVar = new i.e.a.l.a();
        r.set(new SoftReference<>(aVar));
        return aVar;
    }

    public void A(char[] cArr) {
        if (this.p == null) {
            this.p = s();
        }
        this.p.h(cArr);
    }

    public String B() {
        return this.f1605i;
    }

    public e C() {
        String str = this.f1605i;
        if (str == "UTF-8") {
            return this.d.d();
        }
        if (str == "ISO-8859-1") {
            return this.d.b();
        }
        if (str == "US-ASCII") {
            return this.d.a();
        }
        throw new Error("Internal error, unknown encoding '" + this.f1605i + "'");
    }

    public i D() {
        return this.d.c();
    }

    public i.e.a.l.o E() {
        String str = this.f1605i;
        if (str == "UTF-8") {
            return o.m();
        }
        if (str == "ISO-8859-1") {
            return o.l();
        }
        if (str == "US-ASCII") {
            return o.k();
        }
        throw new Error("Internal error, unknown encoding '" + this.f1605i + "'");
    }

    public String F() {
        return this.f1604h;
    }

    public i.e.a.l.e G() {
        return this.f1611o;
    }

    public String H() {
        return this.f;
    }

    public String I() {
        return this.g;
    }

    public XMLReporter J() {
        return this.f1609m;
    }

    public XMLResolver K() {
        return this.f1610n;
    }

    public String L() {
        return this.f1607k;
    }

    public int M() {
        return this.f1608l;
    }

    public String N() {
        return this.f1606j;
    }

    public boolean O() {
        return b(512);
    }

    public boolean P() {
        return b(1024);
    }

    public boolean Q() {
        return false;
    }

    public void R(String str) {
        this.f1605i = str;
    }

    public void S(XMLReporter xMLReporter) {
        this.f1609m = xMLReporter;
    }

    public void T(XMLResolver xMLResolver) {
        this.f1610n = xMLResolver;
    }

    public void U(int i2, String str, String str2) {
        if (i2 == 256) {
            this.f1606j = "1.0";
        } else if (i2 == 272) {
            this.f1606j = "1.1";
        } else {
            this.f1606j = null;
        }
        this.f1607k = str;
        if (str2 == "yes") {
            this.f1608l = 1;
        } else if (str2 == "no") {
            this.f1608l = 2;
        } else {
            this.f1608l = 0;
        }
    }

    public final void V(String str) {
        this.f1607k = str;
    }

    public final void W(Boolean bool) {
        if (bool == null) {
            this.f1608l = 0;
        } else {
            this.f1608l = bool.booleanValue() ? 1 : 2;
        }
    }

    public final void X(String str) {
        this.f1606j = str;
    }

    public void Y(e eVar) {
        String str = this.f1605i;
        if (str == "UTF-8") {
            this.d.h(eVar);
            return;
        }
        if (str == "ISO-8859-1") {
            this.d.f(eVar);
            return;
        }
        if (str == "US-ASCII") {
            this.d.e(eVar);
            return;
        }
        throw new Error("Internal error, unknown encoding '" + this.f1605i + "'");
    }

    public void Z(i iVar) {
        this.d.g(iVar);
    }

    @Override // i.e.a.i.a
    public final Object a(String str, boolean z) {
        HashMap<String, Object> map = q;
        Object obj = map.get(str);
        if (obj == null) {
            if (map.containsKey(str)) {
                return null;
            }
            return super.a(str, z);
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Integer) {
            return Boolean.valueOf(c(((Integer) obj).intValue()));
        }
        throw new RuntimeException("Internal error: unrecognized property value type: " + obj.getClass().getName());
    }

    public boolean a0() {
        return c(XMLEvent.ENTITY_REFERENCE);
    }

    public boolean b0() {
        return c(2);
    }

    public boolean c0() {
        return c(16);
    }

    public boolean d0() {
        return c(512);
    }

    @Override // i.e.a.i.a
    public boolean e(String str) {
        return q.containsKey(str) || super.e(str);
    }

    public boolean e0() {
        return c(1024);
    }

    public boolean f0() {
        return c(256);
    }

    @Override // i.e.a.i.a
    public boolean g(String str, Object obj) {
        HashMap<String, Object> map = q;
        Object obj2 = map.get(str);
        if (obj2 == null) {
            if (map.containsKey(str)) {
                return false;
            }
            return super.g(str, obj);
        }
        if (obj2 instanceof Boolean) {
            return false;
        }
        if (!(obj2 instanceof Integer)) {
            throw new RuntimeException("Internal error");
        }
        f(((Integer) obj2).intValue(), ((Boolean) obj).booleanValue());
        return true;
    }

    public boolean g0() {
        return c(XMLEvent.CHANGE_PREFIX_MAPPING);
    }

    public byte[] h(int i2) {
        byte[] bArrA;
        i.e.a.l.a aVar = this.p;
        return (aVar == null || (bArrA = aVar.a(i2)) == null) ? new byte[i2] : bArrA;
    }

    public boolean h0() {
        return c(2048);
    }

    public char[] i(int i2) {
        char[] cArrB;
        i.e.a.l.a aVar = this.p;
        return (aVar == null || (cArrB = aVar.b(i2)) == null) ? new char[i2] : cArrB;
    }

    public boolean i0() {
        return c(16384);
    }

    public char[] j(int i2) {
        char[] cArrC;
        i.e.a.l.a aVar = this.p;
        return (aVar == null || (cArrC = aVar.c(i2)) == null) ? new char[i2] : cArrC;
    }

    public boolean j0() {
        return true;
    }

    public char[] k(int i2) {
        char[] cArrD;
        i.e.a.l.a aVar = this.p;
        return (aVar == null || (cArrD = aVar.d(i2)) == null) ? new char[i2] : cArrD;
    }

    public String l(char[] cArr, int i2) {
        return this.e.a(cArr, i2);
    }

    public void m() {
        u(true);
        w(true);
    }

    public void n() {
        u(false);
        w(false);
    }

    public void o() {
        u(false);
    }

    public void p() {
        u(false);
        w(false);
    }

    public void q() {
    }

    public z r(String str, String str2, String str3) {
        return new z(str, str2, str3, this.d, this.a, this.b, this.f1609m, this.f1610n, this.e);
    }

    public void t(boolean z) {
        f(XMLEvent.ENTITY_REFERENCE, z);
    }

    public void u(boolean z) {
        f(2, z);
    }

    public void v(boolean z) {
        f(256, z);
    }

    public void w(boolean z) {
        f(XMLEvent.CHANGE_PREFIX_MAPPING, z);
    }

    public void x(byte[] bArr) {
        if (this.p == null) {
            this.p = s();
        }
        this.p.e(bArr);
    }

    public void y(char[] cArr) {
        if (this.p == null) {
            this.p = s();
        }
        this.p.f(cArr);
    }

    public void z(char[] cArr) {
        if (this.p == null) {
            this.p = s();
        }
        this.p.g(cArr);
    }

    public z() {
        this(null, null, null, new y(), 7957, 0, null, null, new i.e.a.l.n());
    }
}
