package n.a.a.r.a;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;

/* loaded from: classes.dex */
public class r0 extends s0 {
    public r0() {
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTNumbering.type.getName().getNamespaceURI(), "hdr"));
        OutputStream outputStreamO = getPackagePart().o();
        try {
            super.I().save(outputStreamO, xmlOptions);
            if (outputStreamO != null) {
                outputStreamO.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamO != null) {
                    try {
                        outputStreamO.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public r0(n.a.a.j.c cVar, n.a.a.k.b.m mVar) throws IOException {
        super(cVar, mVar);
        throw null;
    }
}
