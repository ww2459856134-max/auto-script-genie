package n.a.a.q.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import n.a.a.j.m;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument;

/* loaded from: classes.dex */
public class h extends n.a.a.j.c {
    private CTSingleXmlCells a;

    public h() {
        this.a = CTSingleXmlCells.Factory.newInstance();
    }

    public void I(InputStream inputStream) throws IOException {
        try {
            this.a = SingleXmlCellsDocument.Factory.parse(inputStream, m.a).getSingleXmlCells();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    protected void J(OutputStream outputStream) throws IOException {
        SingleXmlCellsDocument singleXmlCellsDocumentNewInstance = SingleXmlCellsDocument.Factory.newInstance();
        singleXmlCellsDocumentNewInstance.setSingleXmlCells(this.a);
        singleXmlCellsDocumentNewInstance.save(outputStream, m.a);
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        OutputStream outputStreamO = getPackagePart().o();
        try {
            J(outputStreamO);
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

    public h(n.a.a.k.b.m mVar) throws IOException {
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
