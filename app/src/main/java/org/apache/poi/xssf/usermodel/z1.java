package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition;

/* loaded from: classes.dex */
public class z1 extends n.a.a.j.c {
    private CTPivotCacheDefinition a;

    public z1() {
        this.a = CTPivotCacheDefinition.Factory.newInstance();
        I();
    }

    private void I() {
        this.a.setCreatedVersion((short) 3);
        this.a.setMinRefreshableVersion((short) 3);
        this.a.setRefreshedVersion((short) 3);
        this.a.setRefreshedBy(n.a.a.j.b.DOCUMENT_CREATOR);
        this.a.setRefreshedDate(new Date().getTime());
        this.a.setRefreshOnLoad(true);
    }

    public void J(InputStream inputStream) throws IOException {
        try {
            XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
            xmlOptions.setLoadReplaceDocumentElement(null);
            this.a = CTPivotCacheDefinition.Factory.parse(inputStream, xmlOptions);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        OutputStream outputStreamO = getPackagePart().o();
        try {
            XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
            xmlOptions.setSaveSyntheticDocumentElement(new QName(CTPivotCacheDefinition.type.getName().getNamespaceURI(), "pivotCacheDefinition"));
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

    protected z1(n.a.a.k.b.m mVar) throws IOException {
        super(mVar);
        InputStream inputStreamM = mVar.m();
        try {
            J(inputStreamM);
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
