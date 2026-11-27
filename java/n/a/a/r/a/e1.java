package n.a.a.r.a;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings;

/* loaded from: classes.dex */
public class e1 extends n.a.a.j.c {
    private CTSettings a;

    public e1(n.a.a.k.b.m mVar) throws IOException {
        super(mVar);
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        if (this.a == null) {
            throw new IllegalStateException("Unable to write out settings that were never read in!");
        }
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTSettings.type.getName().getNamespaceURI(), "settings"));
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

    public e1() {
        this.a = CTSettings.Factory.newInstance();
    }
}
