package n.a.a.r.a;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet;

/* loaded from: classes.dex */
public class l1 extends n.a.a.j.c {
    private CTOfficeStyleSheet a;

    public l1(n.a.a.k.b.m mVar) {
        super(mVar);
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        if (this.a == null) {
            throw new IOException("Unable to write out theme that was never read in!");
        }
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveSyntheticDocumentElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "theme"));
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

    public l1() {
        this.a = CTOfficeStyleSheet.Factory.newInstance();
    }
}
