package n.a.a.r.a;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;

/* loaded from: classes.dex */
public class f1 extends n.a.a.j.c {
    private CTStyles a;

    public f1(n.a.a.k.b.m mVar) {
        super(mVar);
        new ArrayList();
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        if (this.a == null) {
            throw new IOException("Unable to write out styles that were never read in!");
        }
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTStyles.type.getName().getNamespaceURI(), "styles"));
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

    public f1() {
        new ArrayList();
    }
}
