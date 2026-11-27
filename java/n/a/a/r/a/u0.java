package n.a.a.r.a;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;

/* loaded from: classes.dex */
public class u0 extends n.a.a.j.c {
    private CTNumbering a;

    public u0(n.a.a.k.b.m mVar) {
        super(mVar);
        new ArrayList();
        new ArrayList();
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTNumbering.type.getName().getNamespaceURI(), "numbering"));
        n.a.a.k.b.m packagePart = getPackagePart();
        if (this.a != null) {
            OutputStream outputStreamO = packagePart.o();
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
    }

    public u0() {
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new ArrayList();
    }
}
