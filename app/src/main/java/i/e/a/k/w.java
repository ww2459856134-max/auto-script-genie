package i.e.a.k;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.apache.poi.javax.xml.stream.XMLInputFactory;
import org.apache.poi.javax.xml.stream.XMLOutputFactory;

/* loaded from: classes.dex */
public final class w extends i.e.a.i.a {

    /* renamed from: h, reason: collision with root package name */
    private static final HashMap<String, Integer> f1640h;

    /* renamed from: i, reason: collision with root package name */
    static final ThreadLocal<SoftReference<i.e.a.l.a>> f1641i;
    private String d;
    private final v e;
    private String f;
    i.e.a.l.a g;

    static {
        HashMap<String, Integer> map = new HashMap<>();
        f1640h = map;
        map.put(XMLOutputFactory.IS_REPAIRING_NAMESPACES, 1);
        map.put(XMLInputFactory.IS_NAMESPACE_AWARE, 32);
        map.put(XMLInputFactory.REPORTER, null);
        map.put(n.b.a.f.P_AUTO_CLOSE_OUTPUT, 16);
        map.put(n.b.a.f.P_AUTOMATIC_EMPTY_ELEMENTS, 64);
        map.put(n.b.a.f.P_AUTOMATIC_NS_PREFIX, -2);
        map.put(n.b.a.f.P_TEXT_ESCAPER, null);
        map.put(n.b.a.f.P_ATTR_VALUE_ESCAPER, null);
        f1641i = new ThreadLocal<>();
    }

    private w(String str, int i2, int i3, v vVar, String str2) {
        super(i2, i3);
        this.g = null;
        this.f = str;
        this.e = vVar;
        SoftReference<i.e.a.l.a> softReference = f1641i.get();
        if (softReference != null) {
            this.g = softReference.get();
        }
        this.a = i2;
        this.b = i3;
        this.d = str2;
    }

    private i.e.a.l.a o() {
        i.e.a.l.a aVar = new i.e.a.l.a();
        f1641i.set(new SoftReference<>(aVar));
        return aVar;
    }

    public u A(s sVar) {
        return this.e.d(sVar);
    }

    public boolean B() {
        return c(32);
    }

    public boolean C() {
        return false;
    }

    public void D(String str) {
        String str2 = this.f;
        if (str2 == null || str2.length() == 0) {
            this.f = str;
        }
    }

    public boolean E() {
        return c(16);
    }

    public boolean F() {
        return false;
    }

    public boolean G() {
        return true;
    }

    public boolean H() {
        return false;
    }

    public boolean I() {
        return true;
    }

    public boolean J() {
        return true;
    }

    public boolean K() {
        return true;
    }

    public boolean L() {
        return c(1);
    }

    @Override // i.e.a.i.a
    public Object a(String str, boolean z) {
        HashMap<String, Integer> map = f1640h;
        Integer num = map.get(str);
        if (num == null) {
            if (map.containsKey(str)) {
                return null;
            }
            return super.a(str, z);
        }
        int iIntValue = num.intValue();
        if (iIntValue >= 0) {
            return Boolean.valueOf(c(iIntValue));
        }
        if (iIntValue != -2) {
            return null;
        }
        return this.d;
    }

    @Override // i.e.a.i.a
    public boolean e(String str) {
        return f1640h.containsKey(str) || super.e(str);
    }

    @Override // i.e.a.i.a
    public boolean g(String str, Object obj) {
        HashMap<String, Integer> map = f1640h;
        Integer num = map.get(str);
        if (num == null) {
            if (map.containsKey(str)) {
                return false;
            }
            return super.g(str, obj);
        }
        int iIntValue = num.intValue();
        if (iIntValue < 0) {
            if (iIntValue != -2) {
                return false;
            }
            this.d = obj.toString();
            return true;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (iIntValue == 32 && !zBooleanValue) {
            return false;
        }
        f(iIntValue, zBooleanValue);
        return true;
    }

    public byte[] h(int i2) {
        byte[] bArrA;
        i.e.a.l.a aVar = this.g;
        return (aVar == null || (bArrA = aVar.a(i2)) == null) ? new byte[i2] : bArrA;
    }

    public char[] i(int i2) {
        char[] cArrB;
        i.e.a.l.a aVar = this.g;
        return (aVar == null || (cArrB = aVar.b(i2)) == null) ? new char[i2] : cArrB;
    }

    public char[] j(int i2) {
        char[] cArrC;
        i.e.a.l.a aVar = this.g;
        return (aVar == null || (cArrC = aVar.c(i2)) == null) ? new char[i2] : cArrC;
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public w n() {
        return new w(this.f, this.a, this.b, this.e, this.d);
    }

    public void p(boolean z) {
        f(16, z);
    }

    public void q() {
    }

    public void r(byte[] bArr) {
        if (this.g == null) {
            this.g = o();
        }
        this.g.e(bArr);
    }

    public void s(char[] cArr) {
        if (this.g == null) {
            this.g = o();
        }
        this.g.f(cArr);
    }

    public void t(char[] cArr) {
        if (this.g == null) {
            this.g = o();
        }
        this.g.g(cArr);
    }

    public String u() {
        return this.f;
    }

    public u v(s sVar) {
        return this.e.a(sVar);
    }

    public String w() {
        return this.d;
    }

    public u x(s sVar) {
        return this.e.b(sVar);
    }

    public u y(s sVar) {
        return this.e.c(sVar);
    }

    public String z() {
        return this.f;
    }

    public w() {
        this(null, 32, 0, new v(), "ans");
    }
}
