package i.e.a.k;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public final class m extends p {
    final String O;
    int[] P;
    String Q;
    HashMap<String, String> U;

    public m(w wVar, x xVar, u uVar) {
        super(wVar, xVar, uVar);
        this.P = null;
        this.Q = null;
        this.U = null;
        this.O = wVar.w();
    }

    private final boolean I(String str, String str2, String str3, boolean z) throws XMLStreamException {
        if (str == null || str.length() == 0) {
            o(null, str2);
            x(this.f1631i.e(str2), z, str3);
            return true;
        }
        o(str, str2);
        x(this.f1631i.f(str, str2), z, str3);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        if (r1 != 2) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected r G(String str, String str2, String str3) throws XMLStreamException {
        if (str != null && str.length() > 0) {
            int i2 = l.a[this.D.c(str, str3, this.d).ordinal()];
            if (i2 == 1) {
                u(str, str3);
                this.D.a(str, str3);
            }
            return this.f1631i.f(str, str2);
        }
        String strH = this.D.h(str3, this.d);
        if (strH == null) {
            if (this.P == null) {
                this.P = new int[]{1};
            }
            strH = this.D.g(this.d, this.O, this.P);
            u(strH, str3);
            this.D.a(strH, str3);
        }
        return this.f1631i.f(strH, str2);
    }

    protected final String H(String str) throws XMLStreamException {
        String str2;
        String str3 = this.Q;
        if (str3 != null && str3.equals(str)) {
            return null;
        }
        HashMap<String, String> map = this.U;
        if (map != null && (str2 = map.get(str)) != null) {
            return str2;
        }
        if (this.P == null) {
            this.P = new int[]{1};
        }
        return this.D.g(this.d, this.O, this.P);
    }

    public void J(String str, String str2, String str3, boolean z) throws XMLStreamException {
        if (str3 == null || str3.length() == 0) {
            o(null, str2);
            x(this.f1631i.e(str2), z, null);
            if (!this.D.r()) {
                t(str3);
                this.D.z("");
            }
            n.b.a.p.f fVar = this.f1633k;
            if (fVar != null) {
                fVar.b(str2, "", "");
                return;
            }
            return;
        }
        if (str == null) {
            str = this.D.p(str3);
            if (str != null) {
                I(str, str2, str3, z);
            } else {
                str = H(str3);
                if (I(str, str2, str3, z)) {
                    t(str3);
                    this.D.z(str3);
                } else {
                    u(str, str3);
                    this.D.a(str, str3);
                }
            }
        } else {
            boolean zI = I(str, str2, str3, z);
            if (!this.D.t(str, str3, this.d)) {
                if (zI) {
                    t(str3);
                    this.D.z(str3);
                } else {
                    u(str, str3);
                    this.D.a(str, str3);
                }
            }
        }
        n.b.a.p.f fVar2 = this.f1633k;
        if (fVar2 != null) {
            if (str == null) {
                str = "";
            }
            fVar2.b(str2, "", str);
        }
    }

    @Override // i.e.a.k.p
    public void m(String str, String str2) {
        if (str2 != null && str2.length() != 0) {
            if (this.U == null) {
                this.U = new HashMap<>(16);
            }
            this.U.put(str2, str);
            return;
        }
        HashMap<String, String> map = this.U;
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    @Override // i.e.a.k.p, org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void setDefaultNamespace(String str) throws XMLStreamException {
        if (str == null || str.length() == 0) {
            str = null;
        }
        this.Q = str;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2, String str3) throws XMLStreamException {
        if (this.H) {
            s((str == null || str.length() == 0) ? this.f1631i.e(str2) : G(null, str2, str), str3);
        } else {
            p.C(i.e.a.i.b.C);
            throw null;
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeDefaultNamespace(String str) throws XMLStreamException {
        if (!this.H) {
            p.C(i.e.a.i.b.D);
            throw null;
        }
        if (!this.D.s()) {
            this.D.z(str);
            t(str);
        }
        t(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str, String str2) throws XMLStreamException {
        J(null, str2, str, true);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeNamespace(String str, String str2) throws XMLStreamException {
        if (str == null || str.length() == 0) {
            writeDefaultNamespace(str2);
            return;
        }
        if (!this.H) {
            p.C(i.e.a.i.b.D);
            throw null;
        }
        if (this.D.u(str, this.d)) {
            this.D.a(str, str2);
            u(str, str2);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str, String str2) throws XMLStreamException {
        J(null, str2, str, false);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str, String str2, String str3) throws XMLStreamException {
        J(str, str2, str3, true);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str, String str2, String str3) throws XMLStreamException {
        J(str, str2, str3, false);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2, String str3, String str4) throws XMLStreamException {
        r rVarE;
        if (this.H) {
            if (str2 != null && str2.length() != 0) {
                rVarE = G(str, str3, str2);
            } else {
                rVarE = this.f1631i.e(str3);
            }
            s(rVarE, str4);
            return;
        }
        p.C(i.e.a.i.b.C);
        throw null;
    }
}
