package n.a.a.j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import n.a.a.k.b.o;
import n.a.a.k.b.r;
import n.a.a.k.b.s;
import n.a.a.k.b.v;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument;

/* loaded from: classes.dex */
public class h {
    private static final PropertiesDocument f;
    private static final org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument g;
    private final n.a.a.k.b.k a;
    private final a b;
    private final g c;
    private n.a.a.k.b.m d;
    private n.a.a.k.b.m e;

    public static class a {
        private final PropertiesDocument a;

        public CTProperties b() {
            return this.a.getProperties();
        }

        private a(PropertiesDocument propertiesDocument) {
            this.a = propertiesDocument;
        }
    }

    static {
        PropertiesDocument propertiesDocumentNewInstance = PropertiesDocument.Factory.newInstance();
        f = propertiesDocumentNewInstance;
        propertiesDocumentNewInstance.addNewProperties();
        org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument propertiesDocumentNewInstance2 = org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument.Factory.newInstance();
        g = propertiesDocumentNewInstance2;
        propertiesDocumentNewInstance2.addNewProperties();
    }

    public h(n.a.a.k.b.k kVar) throws XmlException, n.a.a.k.a.b, IOException, n.a.a.k.a.f {
        InputStream inputStreamM;
        this.a = kVar;
        r rVarL = kVar.L("http://schemas.openxmlformats.org/officeDocument/2006/relationships/extended-properties");
        if (rVarL.size() == 1) {
            n.a.a.k.b.m mVarD = kVar.D(rVarL.g(0));
            this.d = mVarD;
            if (mVarD == null) {
                this.b = new a((PropertiesDocument) f.copy());
            } else {
                inputStreamM = mVarD.m();
                try {
                    this.b = new a(PropertiesDocument.Factory.parse(inputStreamM, m.a));
                    if (inputStreamM != null) {
                        inputStreamM.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
        } else {
            this.d = null;
            this.b = new a((PropertiesDocument) f.copy());
        }
        r rVarL2 = kVar.L("http://schemas.openxmlformats.org/officeDocument/2006/relationships/custom-properties");
        if (rVarL2.size() != 1) {
            this.e = null;
            this.c = new g((org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument) g.copy());
            return;
        }
        n.a.a.k.b.m mVarD2 = kVar.D(rVarL2.g(0));
        this.e = mVarD2;
        if (mVarD2 == null) {
            this.c = new g((org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument) g.copy());
            return;
        }
        inputStreamM = mVarD2.m();
        try {
            this.c = new g(org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument.Factory.parse(inputStreamM, m.a));
            if (inputStreamM != null) {
                inputStreamM.close();
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } finally {
            }
        }
    }

    public void a() throws IOException {
        g gVar;
        OutputStream outputStreamO;
        a aVar;
        g gVar2;
        a aVar2;
        if (this.d == null && (aVar2 = this.b) != null && aVar2.a != null && !f.toString().equals(this.b.a.toString())) {
            try {
                o oVarB = s.b("/docProps/app.xml");
                this.a.c(oVarB, v.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/extended-properties");
                this.d = this.a.p(oVarB, "application/vnd.openxmlformats-officedocument.extended-properties+xml");
            } catch (n.a.a.k.a.a e) {
                throw new d(e);
            }
        }
        if (this.e == null && (gVar2 = this.c) != null && gVar2.a != null && !g.toString().equals(this.c.a.toString())) {
            try {
                o oVarB2 = s.b("/docProps/custom.xml");
                this.a.c(oVarB2, v.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/custom-properties");
                this.e = this.a.p(oVarB2, "application/vnd.openxmlformats-officedocument.custom-properties+xml");
            } catch (n.a.a.k.a.a e2) {
                throw new d(e2);
            }
        }
        if (this.d != null && (aVar = this.b) != null && aVar.a != null) {
            outputStreamO = this.d.o();
            try {
                if (this.d.x() > 0) {
                    this.d.g();
                }
                this.b.a.save(outputStreamO, m.a);
                if (outputStreamO != null) {
                    outputStreamO.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        }
        if (this.e == null || (gVar = this.c) == null || gVar.a == null) {
            return;
        }
        this.e.g();
        outputStreamO = this.e.o();
        try {
            this.c.a.save(outputStreamO, m.a);
            if (outputStreamO != null) {
                outputStreamO.close();
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } finally {
            }
        }
    }

    public a b() {
        return this.b;
    }
}
