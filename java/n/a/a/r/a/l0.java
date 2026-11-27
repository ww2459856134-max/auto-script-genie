package n.a.a.r.a;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes;

/* loaded from: classes.dex */
public class l0 extends f0 {
    protected CTEndnotes a;

    public l0() {
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTEndnotes.type.getName().getNamespaceURI(), "endnotes"));
        OutputStream outputStreamO = getPackagePart().o();
        try {
            this.a.save(outputStreamO, xmlOptions);
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

    public l0(n.a.a.k.b.m mVar) {
        super(mVar);
    }
}
