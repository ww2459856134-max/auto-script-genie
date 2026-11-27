package i.e.a.k;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Objects;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public abstract class p extends n.b.a.m.l implements NamespaceContext {
    protected final w c;
    protected NamespaceContext d;
    protected boolean e;
    protected boolean f;
    protected boolean g;

    /* renamed from: i, reason: collision with root package name */
    protected u f1631i;

    /* renamed from: j, reason: collision with root package name */
    protected final x f1632j;

    /* renamed from: k, reason: collision with root package name */
    protected n.b.a.p.f f1633k;
    protected int t = 4;
    protected n.b.a.p.b A = null;
    protected o C = o.PROLOG;
    protected k D = k.f();
    protected boolean G = false;
    protected boolean H = false;
    protected boolean I = false;
    protected String J = null;
    protected k K = null;
    protected int M = 0;

    /* renamed from: h, reason: collision with root package name */
    protected final boolean f1630h = false;

    protected p(w wVar, x xVar, u uVar) {
        this.c = wVar;
        this.f1632j = xVar;
        this.f1631i = uVar;
        this.e = wVar.I();
        this.f = wVar.G();
        this.g = wVar.F();
    }

    protected static void C(String str) throws XMLStreamException {
        throw new i.e.a.i.e(str);
    }

    protected static void D(String str, Object obj) throws XMLStreamException {
        C(MessageFormat.format(str, obj));
        throw null;
    }

    private final void f(boolean z) throws XMLStreamException {
        o oVar = this.C;
        if (oVar != o.EPILOG) {
            if (this.e && oVar == o.PROLOG) {
                j(i.e.a.i.b.v);
                throw null;
            }
            if (this.H) {
                e(this.I);
            }
            while (this.C != o.EPILOG) {
                writeEndElement();
            }
        }
        if (this.f1631i.h()) {
            this.f1631i.j();
        }
        try {
            this.f1632j.e(z);
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    protected static void h(String str) throws XMLStreamException {
        C(str);
        throw null;
    }

    protected static void i(String str, Object obj) throws XMLStreamException {
        D(str, obj);
        throw null;
    }

    protected static void j(String str) throws XMLStreamException {
        C(str);
        throw null;
    }

    protected static void k(String str, Object obj) throws XMLStreamException {
        D(str, obj);
        throw null;
    }

    protected final boolean A() {
        return this.C != o.TREE;
    }

    public void B(n.b.a.p.d dVar) throws XMLStreamException {
        n.b.a.p.b bVar = this.A;
        if (bVar != null) {
            bVar.a(dVar);
        } else if (dVar.c() >= 2) {
            throw i.e.a.d.c(dVar);
        }
    }

    public void E(String str) throws XMLStreamException {
        try {
            this.f1632j.E(str);
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    public void F(char[] cArr, int i2, int i3) throws XMLStreamException {
        try {
            this.f1632j.F(cArr, i2, i3);
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // n.b.a.j
    public void a(String str, String str2, boolean z) throws XMLStreamException {
        v(str, str2, z ? "yes" : "no");
    }

    @Override // n.b.a.j
    public void b(String str, String str2, String str3, String str4) throws XMLStreamException {
        r();
        this.J = str;
        try {
            this.f1632j.y(this.f1631i.e(str), str2, str3, str4);
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void close() throws XMLStreamException {
        f(false);
    }

    @Override // n.b.a.j
    public void d(String str) throws XMLStreamException {
        this.G = true;
        if (this.H) {
            e(this.I);
        }
        try {
            this.f1632j.D(str, 0, str.length());
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    protected void e(boolean z) throws XMLStreamException {
        this.H = false;
        try {
            if (z) {
                this.f1632j.G();
            } else {
                this.f1632j.H();
            }
            if (z) {
                k kVar = this.D;
                k kVarO = kVar.o();
                this.D = kVarO;
                if (kVarO.v()) {
                    this.C = o.EPILOG;
                }
                if (this.M < 8) {
                    kVar.b(this.K);
                    this.K = kVar;
                    this.M++;
                }
            }
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void flush() throws XMLStreamException {
        try {
            this.f1632j.g();
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    protected void g(int i2) throws XMLStreamException {
        int i3 = this.t;
        if (i3 == 0) {
            l(MessageFormat.format(i.e.a.i.b.b, this.D.k(), i.e.a.i.b.c(i2)));
            return;
        }
        if (i3 == 1) {
            l(MessageFormat.format(i.e.a.i.b.c, this.D.k()));
            return;
        }
        if (i3 == 3 || i3 == 4) {
            l(MessageFormat.format(i.e.a.i.b.d, this.D.k(), i.e.a.i.b.c(i2)));
            return;
        }
        l("Internal error: trying to report invalid content for " + i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public final NamespaceContext getNamespaceContext() {
        return this;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String str) {
        NamespaceContext namespaceContext;
        String strL = this.D.l(str);
        return (strL != null || (namespaceContext = this.d) == null) ? strL : namespaceContext.getNamespaceURI(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public String getPrefix(String str) {
        NamespaceContext namespaceContext;
        String strP = this.D.p(str);
        return (strP != null || (namespaceContext = this.d) == null) ? strP : namespaceContext.getPrefix(str);
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String str) {
        return this.D.q(str, this.d);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public Object getProperty(String str) {
        return this.c.a(str, true);
    }

    public void l(String str) throws XMLStreamException {
        B(new n.b.a.p.d(z(), str, 2));
    }

    protected abstract void m(String str, String str2);

    protected void n(String str, String str2) throws n.b.a.p.c {
        this.C = o.TREE;
    }

    protected void o(String str, String str2) throws XMLStreamException {
        if (this.H) {
            e(this.I);
            return;
        }
        o oVar = this.C;
        if (oVar == o.PROLOG) {
            n(str, str2);
            return;
        }
        if (oVar == o.EPILOG) {
            if (!this.e) {
                this.C = o.TREE;
                return;
            }
            if (str != null) {
                str2 = str + ParameterizedMessage.ERROR_MSG_SEPARATOR + str2;
            }
            k(i.e.a.i.b.u, str2);
            throw null;
        }
    }

    protected final void p(r rVar) {
    }

    protected final void q() throws XMLStreamException {
        this.G = true;
        if (this.H) {
            e(this.I);
        }
        if (this.e && A()) {
            j(i.e.a.i.b.s);
            throw null;
        }
    }

    protected final void r() throws XMLStreamException {
        if (this.e) {
            if (this.C == o.PROLOG) {
                if (this.J != null) {
                    throw new XMLStreamException("Trying to write multiple DOCTYPE declarations");
                }
            } else {
                throw new XMLStreamException("Can not write DOCTYPE declaration (DTD) when not in prolog any more (state " + this.C + "; start element(s) written)");
            }
        }
    }

    protected final void s(r rVar, String str) throws XMLStreamException {
        if (this.g) {
            p(rVar);
        }
        try {
            this.f1632j.t(rVar, str);
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public abstract void setDefaultNamespace(String str) throws XMLStreamException;

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException {
        if (this.C == o.PROLOG) {
            this.d = namespaceContext;
        } else {
            C("Called setNamespaceContext() after having already output root element.");
            throw null;
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public final void setPrefix(String str, String str2) throws XMLStreamException {
        Objects.requireNonNull(str);
        if (str.length() == 0) {
            setDefaultNamespace(str2);
            return;
        }
        Objects.requireNonNull(str2);
        if (str.equals("xml")) {
            if (!str2.equals(XMLConstants.XML_NS_URI)) {
                D(i.e.a.i.b.f1567n, str2);
                throw null;
            }
        } else if (str.equals("xmlns")) {
            if (!str2.equals("http://www.w3.org/2000/xmlns/")) {
                D(i.e.a.i.b.f1568o, str2);
                throw null;
            }
        } else {
            if (str2.equals(XMLConstants.XML_NS_URI)) {
                D(i.e.a.i.b.p, str);
                throw null;
            }
            if (str2.equals("http://www.w3.org/2000/xmlns/")) {
                D(i.e.a.i.b.q, str);
                throw null;
            }
        }
        if (str2.length() != 0 || this.c.C()) {
            m(str, str2);
        } else {
            C(i.e.a.i.b.r);
            throw null;
        }
    }

    protected final void t(String str) throws XMLStreamException {
        try {
            this.f1632j.t(this.f1631i.e("xmlns"), str);
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[StreamWriter: ");
        sb.append(getClass());
        sb.append(", underlying outputter: ");
        x xVar = this.f1632j;
        sb.append(xVar == null ? "NULL" : xVar.toString());
        return sb.toString();
    }

    protected final void u(String str, String str2) throws XMLStreamException {
        try {
            this.f1632j.t(this.f1631i.f("xmlns", str), str2);
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    protected void v(String str, String str2, String str3) throws XMLStreamException {
        if (this.e && this.G) {
            j(i.e.a.i.b.w);
            throw null;
        }
        this.G = true;
        if (this.f && str != null && str.length() > 0 && !str.equals("1.0") && !str.equals("1.1")) {
            h("Illegal version argument ('" + str + "'); should only use '1.0' or '1.1'");
            throw null;
        }
        if (str == null || str.length() == 0) {
            str = "1.0";
        }
        if ("1.1".equals(str)) {
            this.c.q();
            this.f1632j.f();
        }
        if (str2 != null && str2.length() > 0) {
            this.c.D(str2);
        }
        try {
            this.f1632j.J(str, str2, str3);
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    protected void w(r rVar, boolean z) throws XMLStreamException {
        this.G = true;
        this.H = true;
        k kVar = this.K;
        if (kVar != null) {
            this.K = kVar.x(this.D, rVar);
            this.M--;
            this.D = kVar;
        } else {
            this.D = this.D.d(rVar);
        }
        try {
            this.f1632j.I(rVar);
            this.I = z;
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public final void writeAttribute(String str, String str2) throws XMLStreamException {
        if (this.H) {
            s(this.f1631i.e(str), str2);
        } else {
            C(i.e.a.i.b.C);
            throw null;
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeCData(String str) throws XMLStreamException {
        n.b.a.p.f fVar;
        if (this.f1630h) {
            writeCharacters(str);
            return;
        }
        q();
        if (this.t == 3 && (fVar = this.f1633k) != null) {
            fVar.c(str, false);
        }
        try {
            int iU = this.f1632j.u(str);
            if (iU < 0) {
                return;
            }
            i(i.e.a.i.b.x, Integer.valueOf(iU));
            throw null;
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeCharacters(char[] cArr, int i2, int i3) throws XMLStreamException {
        n.b.a.p.f fVar;
        this.G = true;
        if (this.H) {
            e(this.I);
        }
        if (A()) {
            F(cArr, i2, i3);
            return;
        }
        int i4 = this.t;
        if (i4 <= 1) {
            if (i4 == 0 || !i.e.a.l.j.b(cArr, i2, i3, this.c.C())) {
                g(4);
            }
        } else if (i4 == 3 && (fVar = this.f1633k) != null) {
            fVar.d(cArr, i2, i3, false);
        }
        if (i3 > 0) {
            try {
                this.f1632j.w(cArr, i2, i3);
            } catch (IOException e) {
                throw new i.e.a.i.c(e);
            }
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeComment(String str) throws XMLStreamException {
        this.G = true;
        if (this.H) {
            e(this.I);
        }
        if (this.t == 0) {
            g(5);
        }
        try {
            int iX = this.f1632j.x(str);
            if (iX < 0) {
                return;
            }
            i(i.e.a.i.b.y, Integer.valueOf(iX));
            throw null;
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public final void writeDTD(String str) throws XMLStreamException {
        r();
        this.J = "";
        try {
            this.f1632j.z(str);
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str) throws XMLStreamException {
        o(null, str);
        r rVarE = this.f1631i.e(str);
        n.b.a.p.f fVar = this.f1633k;
        if (fVar != null) {
            fVar.b(str, "", "");
        }
        w(rVarE, true);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEndDocument() throws XMLStreamException {
        f(false);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEndElement() throws XMLStreamException {
        if (this.H && this.I) {
            this.I = false;
            e(true);
        }
        if (this.C != o.TREE) {
            j("No open start element, when trying to write end element");
            throw null;
        }
        k kVar = this.D;
        this.D = kVar.o();
        if (this.M < 8) {
            kVar.b(this.K);
            this.K = kVar;
            this.M++;
        }
        try {
            if (this.H) {
                this.H = false;
                this.f1632j.G();
            } else {
                this.f1632j.A(kVar.j());
            }
            if (this.D.v()) {
                this.C = o.EPILOG;
            }
            n.b.a.p.f fVar = this.f1633k;
            if (fVar != null) {
                this.t = fVar.a(kVar.i(), kVar.n(), kVar.m());
            }
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeEntityRef(String str) throws XMLStreamException {
        this.G = true;
        if (this.H) {
            e(this.I);
        }
        if (this.e && A()) {
            j(i.e.a.i.b.t);
            throw null;
        }
        if (this.t == 0) {
            g(9);
        }
        try {
            this.f1632j.B(this.f1631i.e(str));
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeProcessingInstruction(String str) throws XMLStreamException {
        writeProcessingInstruction(str, null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartDocument() throws XMLStreamException {
        String strU = this.c.u();
        if (strU == null) {
            strU = "UTF-8";
            this.c.D("UTF-8");
        }
        v("1.0", strU, null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str) throws XMLStreamException {
        o(null, str);
        r rVarE = this.f1631i.e(str);
        n.b.a.p.f fVar = this.f1633k;
        if (fVar != null) {
            fVar.b(str, "", "");
        }
        w(rVarE, false);
    }

    protected void x(r rVar, boolean z, String str) throws XMLStreamException {
        this.G = true;
        this.H = true;
        if (str == null) {
            str = "";
        }
        k kVar = this.K;
        if (kVar != null) {
            this.K = kVar.y(this.D, rVar, str);
            this.M--;
            this.D = kVar;
        } else {
            this.D = this.D.e(rVar, str);
        }
        try {
            this.f1632j.I(rVar);
            this.I = z;
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    public n.b.a.h y() {
        return new i.e.a.i.d(null, null, this.f1632j.h(), this.f1632j.l(), this.f1632j.i());
    }

    public Location z() {
        return y();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeProcessingInstruction(String str, String str2) throws XMLStreamException {
        this.G = true;
        if (this.H) {
            e(this.I);
        }
        if (this.t == 0) {
            g(3);
        }
        try {
            int iC = this.f1632j.C(this.f1631i.e(str), str2);
            if (iC < 0) {
                return;
            }
            i(i.e.a.i.b.z, Integer.valueOf(iC));
            throw null;
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartDocument(String str) throws XMLStreamException {
        v(str, this.c.u(), null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeStartDocument(String str, String str2) throws XMLStreamException {
        v(str2, str, null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamWriter
    public void writeCharacters(String str) throws XMLStreamException {
        n.b.a.p.f fVar;
        this.G = true;
        if (this.H) {
            e(this.I);
        }
        if (A()) {
            E(str);
            return;
        }
        int i2 = this.t;
        if (i2 <= 1) {
            if (i2 == 0 || !i.e.a.l.j.a(str, this.c.C())) {
                g(4);
            }
        } else if (i2 == 3 && (fVar = this.f1633k) != null) {
            fVar.c(str, false);
        }
        try {
            this.f1632j.v(str);
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }
}
