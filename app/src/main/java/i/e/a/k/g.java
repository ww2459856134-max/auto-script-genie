package i.e.a.k;

import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public final class g extends p {
    public g(w wVar, x xVar, u uVar) {
        super(wVar, xVar, uVar);
    }

    @Override // i.e.a.k.p
    public void m(String str, String str2) {
        this.D.a(str, str2);
    }

    @Override // i.e.a.k.p, org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void setDefaultNamespace(String str) throws XMLStreamException {
        this.D.z(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2, String str3) throws XMLStreamException {
        r rVarE;
        if (!this.H) {
            p.C(i.e.a.i.b.C);
            throw null;
        }
        if (str == null || str.length() == 0) {
            rVarE = this.f1631i.e(str2);
        } else {
            String strH = this.D.h(str, this.d);
            if (strH == null) {
                p.C("Unbound namespace URI '" + str + "'");
                throw null;
            }
            rVarE = this.f1631i.f(strH, str2);
        }
        s(rVarE, str3);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeDefaultNamespace(String str) throws XMLStreamException {
        if (!this.H) {
            p.C(i.e.a.i.b.D);
            throw null;
        }
        t(str);
        setDefaultNamespace(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str, String str2) throws XMLStreamException {
        r rVarF;
        String strP = this.D.p(str);
        if (strP == null) {
            p.C("Unbound namespace URI '" + str + "'");
            throw null;
        }
        if (strP.length() == 0) {
            rVarF = this.f1631i.e(str2);
            strP = null;
        } else {
            rVarF = this.f1631i.f(strP, str2);
        }
        o(strP, str2);
        x(rVarF, true, str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeNamespace(String str, String str2) throws XMLStreamException {
        if (str == null || str.length() == 0) {
            writeDefaultNamespace(str2);
        } else {
            if (!this.H) {
                p.C(i.e.a.i.b.D);
                throw null;
            }
            u(str, str2);
            setPrefix(str, str2);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str, String str2) throws XMLStreamException {
        r rVarF;
        String strP = this.D.p(str);
        if (strP == null) {
            p.C("Unbound namespace URI '" + str + "'");
            throw null;
        }
        if (strP.length() == 0) {
            rVarF = this.f1631i.e(str2);
            strP = null;
        } else {
            rVarF = this.f1631i.f(strP, str2);
        }
        o(strP, str2);
        w(rVarF, false);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str, String str2, String str3) throws XMLStreamException {
        r rVarE;
        o(str, str2);
        if (str != null && str.length() != 0) {
            rVarE = this.f1631i.f(str, str2);
        } else {
            rVarE = this.f1631i.e(str2);
        }
        x(rVarE, true, str3);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str, String str2, String str3) throws XMLStreamException {
        r rVarE;
        o(str, str2);
        if (str != null && str.length() != 0) {
            rVarE = this.f1631i.f(str, str2);
        } else {
            rVarE = this.f1631i.e(str2);
        }
        x(rVarE, false, str3);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2, String str3, String str4) throws XMLStreamException {
        r rVarE;
        if (this.H) {
            if (str != null && str.length() != 0) {
                rVarE = this.f1631i.f(str, str3);
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
