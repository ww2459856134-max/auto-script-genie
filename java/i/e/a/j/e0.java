package i.e.a.j;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamConstants;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public abstract class e0 implements XMLStreamConstants, NamespaceContext {
    protected k D;
    protected String G;
    protected String H;
    protected q[] M;
    protected final a V;
    protected long Z;
    protected int b0;
    protected final z c;
    protected long c0;
    protected final boolean d;
    protected final boolean e;
    protected boolean f;

    /* renamed from: j, reason: collision with root package name */
    protected final i.e.a.l.i f1584j;
    protected char[] t;
    protected int g = 7;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f1582h = false;

    /* renamed from: i, reason: collision with root package name */
    protected int f1583i = 0;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f1585k = false;
    protected v A = null;
    protected boolean C = false;
    protected r I = null;
    protected int J = 0;
    protected q K = q.a();
    protected int O = 0;
    protected v[] P = null;
    protected int Q = 0;
    protected m U = m.f;
    protected int W = 0;
    protected long d0 = -1;
    protected long e0 = -1;
    protected int a0 = 0;

    protected e0(z zVar) {
        this.t = null;
        this.c = zVar;
        this.e = zVar.b0();
        this.f = zVar.f0();
        this.d = zVar.Q();
        this.f1584j = i.e.a.l.i.j(zVar);
        this.V = new a(zVar);
        this.t = zVar.k(60);
    }

    private r m(int i2) {
        int i3;
        int i4 = this.f1583i;
        if (this.g == 1) {
            i3 = (this.J - 1) - i2;
            i4--;
        } else {
            i3 = i2;
        }
        for (r rVarG = this.I; rVarG != null && rVarG.e() == i4; rVarG = rVarG.g()) {
            if (i3 == 0) {
                return rVarG;
            }
            i3--;
        }
        k0(i2);
        throw null;
    }

    public final String A(int i2) {
        return this.V.n(i2);
    }

    protected abstract void A0() throws XMLStreamException;

    public final String B(String str, String str2) {
        if (this.W < 1) {
            return null;
        }
        return this.V.o(str, str2);
    }

    protected abstract void B0() throws XMLStreamException;

    public z C() {
        return this.c;
    }

    protected final boolean C0() throws XMLStreamException {
        this.f1582h = false;
        int i2 = this.g;
        if (i2 == 3) {
            A0();
        } else if (i2 != 4) {
            if (i2 == 5) {
                z0();
            } else if (i2 == 6) {
                B0();
            } else if (i2 == 11) {
                r(false);
            } else {
                if (i2 != 12) {
                    throw new Error("Internal error, unexpected incomplete token type " + i.e.a.i.b.c(this.g));
                }
                w0();
                if (this.e) {
                    y0();
                    if (this.f1585k) {
                        this.g = 9;
                        return true;
                    }
                }
            }
        } else {
            if (x0()) {
                this.g = 9;
                return true;
            }
            if (this.e && y0()) {
                this.g = 9;
                return true;
            }
        }
        return false;
    }

    public abstract n.b.a.h D();

    protected void D0(int i2) throws XMLStreamException {
        char c = (char) i2;
        if (c == 0) {
            E0();
            throw null;
        }
        String str = "Illegal character (" + i.e.a.l.p.c(c) + ")";
        if (this.d && i2 < 32) {
            str = str + " [note: in XML 1.1, it could be included via entity expansion]";
        }
        i0(str);
        throw null;
    }

    public final String E() {
        return this.G;
    }

    protected void E0() throws XMLStreamException {
        i0("Illegal character (NULL, unicode 0) encountered: not valid in any content");
        throw null;
    }

    public final String F() {
        return this.H;
    }

    protected void F0(int i2, String str) throws XMLStreamException {
        if (i2 < 32 && i2 != 13 && i2 != 10 && i2 != 9) {
            D0(i2);
            throw null;
        }
        i0("Unexpected character " + i.e.a.l.p.c((char) i2) + str);
        throw null;
    }

    public final int G() {
        return this.f1583i;
    }

    protected final void G0(int i2) throws XMLStreamException {
        if (i2 >= 55296) {
            if (i2 < 57344) {
                l0(i2);
                throw null;
            }
            if (i2 == 65534 || i2 == 65535) {
                l0(i2);
                throw null;
            }
            return;
        }
        if (i2 >= 32 || i2 == 10 || i2 == 13 || i2 == 9) {
            return;
        }
        if (!this.d || i2 == 0) {
            l0(i2);
            throw null;
        }
    }

    public n.b.a.h H() throws XMLStreamException {
        if (this.f1582h) {
            t();
        }
        return D();
    }

    public abstract long I() throws XMLStreamException;

    public abstract long J() throws XMLStreamException;

    public final v K() {
        return this.A;
    }

    public final int L() {
        if (this.g == 1) {
            return this.J;
        }
        r rVar = this.I;
        if (rVar == null) {
            return 0;
        }
        return rVar.b(this.f1583i);
    }

    public final QName M() {
        return this.A.f(this.K);
    }

    public final n.b.a.h N() {
        return i.e.a.i.d.b(this.c.H(), this.c.I(), this.c0, (int) this.d0, (int) this.e0);
    }

    public abstract long O();

    public abstract long P();

    public final int Q(Writer writer, boolean z) throws XMLStreamException {
        if (this.f1582h) {
            t();
        }
        try {
            return this.f1584j.s(writer);
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    protected char R(int i2) throws XMLStreamException {
        i.e.a.l.e eVarG = this.c.G();
        if (eVarG != null) {
            return eVarG.a(i2);
        }
        char c = (char) i2;
        if (c == 0) {
            E0();
            throw null;
        }
        String str = "Illegal XML character (" + i.e.a.l.p.c(c) + ")";
        if (this.d && i2 < 32) {
            str = str + " [note: in XML 1.1, it could be included via entity expansion]";
        }
        i0(str);
        throw null;
    }

    public final boolean S() {
        return this.f1583i == 0;
    }

    public final boolean T(int i2) {
        return true;
    }

    public final boolean U() {
        return this.C;
    }

    public final boolean V() throws XMLStreamException {
        if (this.f1582h) {
            t();
        }
        return this.f1584j.r();
    }

    protected abstract boolean W() throws XMLStreamException;

    protected final void X() throws XMLStreamException {
        if (W()) {
            return;
        }
        i0("Unexpected end-of-input when trying to parse " + i.e.a.i.b.c(this.g));
        throw null;
    }

    protected final void Y(int i2) throws XMLStreamException {
        if (W()) {
            return;
        }
        i0("Unexpected end-of-input when trying to parse " + i.e.a.i.b.c(i2));
        throw null;
    }

    public abstract int Z(boolean z) throws XMLStreamException;

    protected abstract void a() throws IOException;

    public abstract int a0() throws XMLStreamException;

    protected void b() {
        this.f1584j.t(true);
        char[] cArr = this.t;
        if (cArr != null) {
            this.t = null;
            this.c.A(cArr);
        }
    }

    protected void b0() throws XMLStreamException {
        i0("String '--' not allowed in comment (missing '>'?)");
        throw null;
    }

    protected void c0(String str) throws XMLStreamException {
        if (str == null) {
            i0("Duplicate namespace declaration for the default namespace");
            throw null;
        }
        i0("Duplicate namespace declaration for prefix '" + str + "'");
        throw null;
    }

    protected final v d(v vVar, String str) {
        v vVar2;
        v[] vVarArr = this.P;
        if (vVarArr != null && (vVar2 = vVarArr[vVar.s() & 63]) != null && vVar2.r(vVar)) {
            return vVar2;
        }
        int i2 = this.O;
        for (int i3 = 0; i3 < i2; i3++) {
            q[] qVarArr = this.M;
            q qVar = qVarArr[i3];
            if (qVar.a == str) {
                if (i3 > 0) {
                    int i4 = i3 - 1;
                    qVarArr[i3] = qVarArr[i4];
                    qVarArr[i4] = qVar;
                }
                v vVarG = vVar.g(qVar);
                if (this.P == null) {
                    int i5 = this.Q + 1;
                    this.Q = i5;
                    if (i5 < 10) {
                        return vVarG;
                    }
                    this.P = new v[64];
                }
                this.P[vVarG.s() & 63] = vVarG;
                return vVarG;
            }
        }
        if (str == "xml") {
            return vVar.g(q.c);
        }
        this.Q++;
        q qVar2 = new q(str);
        int i6 = this.O;
        if (i6 == 0) {
            this.M = new q[16];
        } else {
            q[] qVarArr2 = this.M;
            if (i6 >= qVarArr2.length) {
                this.M = (q[]) i.e.a.l.c.a(qVarArr2, qVarArr2.length);
            }
        }
        q[] qVarArr3 = this.M;
        int i7 = this.O;
        qVarArr3[i7] = qVar2;
        this.O = i7 + 1;
        return vVar.g(qVar2);
    }

    protected void d0() throws XMLStreamException {
        i0("Illegal character entity: value higher than max allowed (0x" + Integer.toHexString(1114111) + ")");
        throw null;
    }

    protected final void e(v vVar, String str) throws XMLStreamException {
        q qVarN;
        String strK = vVar.k();
        if (strK == null) {
            qVarN = this.K;
        } else {
            strK = vVar.i();
            qVarN = n(strK);
            if (qVarN.b()) {
                f(strK, str);
            }
        }
        if (!qVarN.b()) {
            if (str == XMLConstants.XML_NS_URI) {
                h0("xml", XMLConstants.XML_NS_URI);
                throw null;
            }
            if (str == "http://www.w3.org/2000/xmlns/") {
                h0("xmlns", "http://www.w3.org/2000/xmlns/");
                throw null;
            }
        }
        r rVar = this.I;
        if (rVar == null || !rVar.a(strK, this.f1583i)) {
            this.I = new r(qVarN, str, this.I, this.f1583i);
        } else {
            c0(strK);
            throw null;
        }
    }

    protected void e0(char[] cArr, int i2) throws XMLStreamException {
        i0("Unexpected end-of-input in name (parsing " + i.e.a.i.b.c(this.g) + ")");
        throw null;
    }

    protected final void f(String str, String str2) throws XMLStreamException {
        if (str == "xml" && str2.equals(XMLConstants.XML_NS_URI)) {
            return;
        }
        g0(str);
        throw null;
    }

    protected void f0() throws XMLStreamException {
        i0("String ']]>' not allowed in textual content, except as the end marker of CDATA section");
        throw null;
    }

    public final void g(boolean z) throws XMLStreamException {
        b();
        if (z || this.c.a0()) {
            try {
                a();
            } catch (IOException e) {
                throw new i.e.a.i.c(e);
            }
        }
    }

    protected void g0(String str) throws XMLStreamException {
        i0("Illegal namespace declaration: can not re-bind prefix '" + str + "'");
        throw null;
    }

    public final String getNamespacePrefix(int i2) {
        return m(i2).c().a;
    }

    public final String getNamespaceURI(int i2) {
        return m(i2).c().b;
    }

    public final NamespaceContext getNonTransientNamespaceContext() {
        m mVarA = this.U.a(this.I);
        this.U = mVarA;
        return mVarA;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public String getPrefix(String str) {
        String strF;
        if (str == null) {
            throw new IllegalArgumentException(i.e.a.i.b.a);
        }
        if (str.equals(XMLConstants.XML_NS_URI)) {
            return "xml";
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            return "xmlns";
        }
        if (str.equals(this.K.b)) {
            return "";
        }
        for (r rVarG = this.I; rVarG != null; rVarG = rVarG.g()) {
            if (rVarG.h(str) && (strF = rVarG.f()) != null) {
                for (r rVarG2 = this.I; rVarG2 != rVarG; rVarG2 = rVarG2.g()) {
                    if (rVarG2.i(strF)) {
                        break;
                    }
                }
                return strF;
            }
        }
        return null;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public Iterator<String> getPrefixes(String str) {
        String strF;
        if (str == null) {
            throw new IllegalArgumentException(i.e.a.i.b.a);
        }
        if (str.equals(XMLConstants.XML_NS_URI)) {
            return new i.e.a.l.g("xml");
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            return new i.e.a.l.g("xmlns");
        }
        ArrayList arrayList = null;
        if (str.equals(this.K.b)) {
            arrayList = new ArrayList();
            arrayList.add("");
        }
        for (r rVarG = this.I; rVarG != null; rVarG = rVarG.g()) {
            if (rVarG.h(str) && (strF = rVarG.f()) != null) {
                r rVarG2 = this.I;
                while (true) {
                    if (rVarG2 == rVarG) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(strF);
                    } else {
                        if (rVarG2.i(strF)) {
                            break;
                        }
                        rVarG2 = rVarG2.g();
                    }
                }
            }
        }
        return arrayList == null ? i.e.a.l.d.a() : arrayList.size() == 1 ? new i.e.a.l.g((String) arrayList.get(0)) : arrayList.iterator();
    }

    public final String getText() throws XMLStreamException {
        if (this.f1582h) {
            t();
        }
        return this.f1584j.h();
    }

    public final char[] getTextCharacters() throws XMLStreamException {
        if (this.f1582h) {
            t();
        }
        return this.f1584j.q();
    }

    public final int getTextLength() throws XMLStreamException {
        if (this.f1582h) {
            t();
        }
        return this.f1584j.B();
    }

    public final byte[] h(int i2, n.b.a.n.a aVar, n.b.a.m.o.b bVar) throws XMLStreamException {
        return this.V.c(i2, aVar, bVar, this);
    }

    protected void h0(String str, String str2) throws XMLStreamException {
        i0("Illegal namespace declaration: can not bind URI '" + str2 + "' to prefix other than '" + str + "'");
        throw null;
    }

    public final void i(int i2, n.b.a.n.d dVar) throws IllegalArgumentException, XMLStreamException {
        this.V.d(i2, dVar);
    }

    protected void i0(String str) throws XMLStreamException {
        throw new i.e.a.e(str, D());
    }

    public final int j(int i2, n.b.a.n.c cVar) throws XMLStreamException {
        return this.V.e(i2, cVar, this);
    }

    protected void j0(int i2, int i3) throws XMLStreamException {
        if (i2 == 58) {
            i0("Invalid colon in name: at most one colon allowed in element/attribute names, and none in PI target or entity names");
            throw null;
        }
        if (i3 == 0) {
            i0("Invalid name start character (0x" + Integer.toHexString(i2) + ")");
            throw null;
        }
        i0("Invalid name character (0x" + Integer.toHexString(i2) + ")");
        throw null;
    }

    public final int k(n.b.a.n.c cVar, boolean z) throws XMLStreamException {
        if (this.f1582h) {
            t();
        }
        try {
            return this.f1584j.k(cVar, z);
        } catch (n.b.a.n.e e) {
            n.b.a.h hVarD = D();
            throw new n.b.a.n.e(e.a(), e.getMessage(), hVarD, (IllegalArgumentException) e.getCause());
        }
    }

    protected void k0(int i2) {
        throw new IndexOutOfBoundsException("Illegal namespace declaration index, " + i2 + ", current START_ELEMENT/END_ELEMENT has " + L() + " declarations");
    }

    public final int l(String str, String str2) {
        if (this.W < 1) {
            return -1;
        }
        return this.V.g(str, str2);
    }

    protected void l0(int i2) throws XMLStreamException {
        if (i2 == 0) {
            i0("Invalid null character");
            throw null;
        }
        if (i2 < 32) {
            i0("Invalid white space character (0x" + Integer.toHexString(i2) + ")");
            throw null;
        }
        i0("Invalid xml content character (0x" + Integer.toHexString(i2) + ")");
        throw null;
    }

    protected void m0(int i2) throws XMLStreamException {
        F0(i2, ": expected either white space, or closing '?>'");
        throw null;
    }

    protected final q n(String str) throws XMLStreamException {
        int i2 = this.O;
        for (int i3 = 0; i3 < i2; i3++) {
            q[] qVarArr = this.M;
            q qVar = qVarArr[i3];
            if (qVar.a == str) {
                if (i3 > 0) {
                    int i4 = i3 - 1;
                    qVarArr[i3] = qVarArr[i4];
                    qVarArr[i4] = qVar;
                }
                return qVar;
            }
        }
        if (str == "xml") {
            return q.c;
        }
        if (str == "xmlns") {
            return q.d;
        }
        q qVar2 = new q(str);
        int i5 = this.O;
        if (i5 == 0) {
            this.M = new q[16];
        } else {
            q[] qVarArr2 = this.M;
            if (i5 >= qVarArr2.length) {
                this.M = (q[]) i.e.a.l.c.a(qVarArr2, qVarArr2.length);
            }
        }
        q[] qVarArr3 = this.M;
        int i6 = this.O;
        qVarArr3[i6] = qVar2;
        this.O = i6 + 1;
        return qVar2;
    }

    protected void n0() throws XMLStreamException {
        i0("Multiple colons not allowed in names");
        throw null;
    }

    protected abstract void o() throws XMLStreamException;

    protected void o0(boolean z, String str) throws XMLStreamException {
        i0((z ? i.e.a.i.b.f1562i : i.e.a.i.b.f1563j) + ": " + str);
        throw null;
    }

    protected abstract void p() throws XMLStreamException;

    protected void p0(boolean z, int i2, String str) throws XMLStreamException {
        String str2 = z ? i.e.a.i.b.f1562i : i.e.a.i.b.f1563j;
        if (str != null) {
            str2 = str2 + str;
        } else if (i2 == 38) {
            F0(i2, str2 + "; no entities allowed");
            throw null;
        }
        F0(i2, str2);
        throw null;
    }

    protected abstract void q() throws XMLStreamException;

    protected void q0(boolean z, int i2) throws XMLStreamException {
        if (i2 < 0) {
            i2 &= 524287;
        }
        if (i2 == 47) {
            if (z) {
                i0("Unexpected end element in prolog: malformed XML document, expected root element");
                throw null;
            }
            i0("Unexpected end element in epilog: malformed XML document (unbalanced start/end tags?)");
            throw null;
        }
        if (i2 >= 32) {
            i0("Second root element in content: malformed XML document, only one allowed");
            throw null;
        }
        F0(i2, "Unrecognized directive " + (z ? i.e.a.i.b.f1562i : i.e.a.i.b.f1563j));
        throw null;
    }

    protected abstract void r(boolean z) throws XMLStreamException;

    protected void r0(int i2, String str) throws XMLStreamException {
        String str2 = i.e.a.i.b.f1564k;
        if (str != null) {
            str2 = str2 + str;
        }
        F0(i2, str2);
        throw null;
    }

    protected abstract void s() throws XMLStreamException;

    protected void s0(v vVar, boolean z) throws XMLStreamException {
        StringBuilder sb = new StringBuilder();
        sb.append("Unbound namespace prefix '");
        sb.append(vVar.k());
        sb.append("' (for ");
        sb.append(z ? "attribute" : "element");
        sb.append(" name '");
        sb.append(vVar.l());
        sb.append("')");
        i0(sb.toString());
        throw null;
    }

    protected abstract void t() throws XMLStreamException;

    protected void t0(v vVar, boolean z) throws XMLStreamException {
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpanded ENTITY_REFERENCE (");
        sb.append(this.A);
        sb.append(") in ");
        sb.append(z ? "namespace declaration" : "attribute value");
        i0(sb.toString());
        throw null;
    }

    public final int u() {
        return this.W;
    }

    protected void u0(String str) throws XMLStreamException {
        i0("Unexpected end tag: expected </" + str + ">");
        throw null;
    }

    public final String v(int i2) {
        return this.V.l(i2).i();
    }

    public final void v0(n.b.a.n.a aVar, n.b.a.m.o.b bVar, boolean z) throws XMLStreamException {
        if (this.f1582h) {
            t();
        }
        this.f1584j.u(aVar, bVar, z);
    }

    public final String w(int i2) {
        return this.V.l(i2).j();
    }

    protected abstract void w0() throws XMLStreamException;

    public final String x(int i2) {
        return this.V.l(i2).k();
    }

    protected abstract boolean x0() throws XMLStreamException;

    public final QName y(int i2) {
        return this.V.m(i2);
    }

    protected abstract boolean y0() throws XMLStreamException;

    public final String z(int i2) {
        return "CDATA";
    }

    protected abstract void z0() throws XMLStreamException;

    public final String getNamespaceURI() {
        String strJ = this.A.j();
        return strJ == null ? this.K.b : strJ;
    }

    @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
    public String getNamespaceURI(String str) {
        if (str != null) {
            if (str.length() == 0) {
                String str2 = this.K.b;
                return str2 == null ? "" : str2;
            }
            if (str.equals("xml")) {
                return XMLConstants.XML_NS_URI;
            }
            if (str.equals("xmlns")) {
                return "http://www.w3.org/2000/xmlns/";
            }
            for (r rVarG = this.I; rVarG != null; rVarG = rVarG.g()) {
                if (rVarG.i(str)) {
                    return rVarG.d();
                }
            }
            return null;
        }
        throw new IllegalArgumentException(i.e.a.i.b.a);
    }

    public final int getTextCharacters(int i2, char[] cArr, int i3, int i4) throws XMLStreamException {
        if (this.f1582h) {
            t();
        }
        return this.f1584j.i(i2, cArr, i3, i4);
    }
}
