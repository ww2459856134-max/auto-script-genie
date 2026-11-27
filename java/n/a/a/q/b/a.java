package n.a.a.q.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import n.a.a.j.m;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument;

/* loaded from: classes.dex */
public class a extends n.a.a.j.c {
    private CTCalcChain a;

    public a() {
        this.a = CTCalcChain.Factory.newInstance();
    }

    public CTCalcChain I() {
        return this.a;
    }

    public void J(InputStream inputStream) throws IOException {
        try {
            this.a = CalcChainDocument.Factory.parse(inputStream, m.a).getCalcChain();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void K(int i2, String str) {
        CTCalcCell[] cArray = this.a.getCArray();
        int i3 = -1;
        for (int i4 = 0; i4 < cArray.length; i4++) {
            if (cArray[i4].isSetI()) {
                i3 = cArray[i4].getI();
            }
            if (i3 == i2 && cArray[i4].getR().equals(str)) {
                if (cArray[i4].isSetI() && i4 < cArray.length - 1) {
                    int i5 = i4 + 1;
                    if (!cArray[i5].isSetI()) {
                        cArray[i5].setI(i3);
                    }
                }
                this.a.removeC(i4);
                return;
            }
        }
    }

    public void L(OutputStream outputStream) throws IOException {
        CalcChainDocument calcChainDocumentNewInstance = CalcChainDocument.Factory.newInstance();
        calcChainDocumentNewInstance.setCalcChain(this.a);
        calcChainDocumentNewInstance.save(outputStream, m.a);
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        OutputStream outputStreamO = getPackagePart().o();
        try {
            L(outputStreamO);
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

    public a(n.a.a.k.b.m mVar) throws IOException {
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
