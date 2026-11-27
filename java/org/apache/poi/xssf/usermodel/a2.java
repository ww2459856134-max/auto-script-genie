package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords;

/* loaded from: classes.dex */
public class a2 extends n.a.a.j.c {
    private CTPivotCacheRecords a;

    public a2() {
        this.a = CTPivotCacheRecords.Factory.newInstance();
    }

    protected void I(InputStream inputStream) throws IOException {
        try {
            XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
            xmlOptions.setLoadReplaceDocumentElement(null);
            this.a = CTPivotCacheRecords.Factory.parse(inputStream, xmlOptions);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        OutputStream outputStreamO = getPackagePart().o();
        try {
            XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
            xmlOptions.setSaveSyntheticDocumentElement(new QName(CTPivotCacheRecords.type.getName().getNamespaceURI(), "pivotCacheRecords"));
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

    protected a2(n.a.a.k.b.m mVar) throws IOException {
        super(mVar);
        InputStream inputStreamM = mVar.m();
        try {
            I(inputStreamM);
            if (inputStreamM != null) {
                inputStreamM.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamM != null) {
                    try {
                        inputStreamM.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
