package n.a.a.q.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import n.a.a.j.m;
import n.a.a.k.b.q;
import n.a.a.k.b.v;
import n.a.a.n.d.m0;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument;

/* loaded from: classes.dex */
public class e extends n.a.a.j.c {
    private CTExternalLink a;

    public e() {
        CTExternalLink cTExternalLinkNewInstance = CTExternalLink.Factory.newInstance();
        this.a = cTExternalLinkNewInstance;
        cTExternalLinkNewInstance.addNewExternalBook();
    }

    private CTExternalCell J(CTExternalRow cTExternalRow, String str) {
        for (CTExternalCell cTExternalCell : cTExternalRow.getCellArray()) {
            if (cTExternalCell.getR().equals(str)) {
                return cTExternalCell;
            }
        }
        CTExternalCell cTExternalCellAddNewCell = cTExternalRow.addNewCell();
        cTExternalCellAddNewCell.setR(str);
        return cTExternalCellAddNewCell;
    }

    private CTExternalRow M(CTExternalSheetData cTExternalSheetData, long j2) {
        for (CTExternalRow cTExternalRow : cTExternalSheetData.getRowArray()) {
            if (cTExternalRow.getR() == j2) {
                return cTExternalRow;
            }
        }
        CTExternalRow cTExternalRowAddNewRow = cTExternalSheetData.addNewRow();
        cTExternalRowAddNewRow.setR(j2);
        return cTExternalRowAddNewRow;
    }

    private CTExternalSheetData N(int i2) {
        CTExternalSheetDataSet sheetDataSet = this.a.getExternalBook().getSheetDataSet();
        if (sheetDataSet == null) {
            sheetDataSet = this.a.getExternalBook().addNewSheetDataSet();
        }
        CTExternalSheetData cTExternalSheetData = null;
        CTExternalSheetData[] sheetDataArray = sheetDataSet.getSheetDataArray();
        int length = sheetDataArray.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            CTExternalSheetData cTExternalSheetData2 = sheetDataArray[i3];
            if (cTExternalSheetData2.getSheetId() == i2) {
                cTExternalSheetData = cTExternalSheetData2;
                break;
            }
            i3++;
        }
        if (cTExternalSheetData != null) {
            return cTExternalSheetData;
        }
        CTExternalSheetData cTExternalSheetDataAddNewSheetData = sheetDataSet.addNewSheetData();
        cTExternalSheetDataAddNewSheetData.setSheetId(i2);
        return cTExternalSheetDataAddNewSheetData;
    }

    private int O(String str) {
        CTExternalBook externalBook = this.a.getExternalBook();
        CTExternalSheetNames sheetNames = externalBook.getSheetNames();
        if (sheetNames == null) {
            sheetNames = externalBook.addNewSheetNames();
        }
        int i2 = 0;
        while (true) {
            if (i2 >= sheetNames.sizeOfSheetNameArray()) {
                i2 = -1;
                break;
            }
            if (sheetNames.getSheetNameArray(i2).getVal().equals(str)) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            return i2;
        }
        sheetNames.addNewSheetName().setVal(str);
        return sheetNames.sizeOfSheetNameArray() - 1;
    }

    public void I(String str, long j2, String str2, String str3) {
        synchronized (this.a.getExternalBook().monitor()) {
            J(M(N(O(str)), j2), str2).setV(str3);
        }
    }

    public List<m0> K() {
        CTExternalDefinedName[] definedNameArray = this.a.getExternalBook().getDefinedNames().getDefinedNameArray();
        ArrayList arrayList = new ArrayList(definedNameArray.length);
        for (CTExternalDefinedName cTExternalDefinedName : definedNameArray) {
            arrayList.add(new d(this, cTExternalDefinedName));
        }
        return arrayList;
    }

    public String L() {
        q qVarT = getPackagePart().t(this.a.getExternalBook().getId());
        if (qVarT == null || qVarT.d() != v.EXTERNAL) {
            return null;
        }
        return qVarT.e().toString();
    }

    public void P(InputStream inputStream) throws IOException {
        try {
            this.a = ExternalLinkDocument.Factory.parse(inputStream, m.a).getExternalLink();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void Q(String str) {
        String id = this.a.getExternalBook().getId();
        if (id != null && !id.isEmpty()) {
            getPackagePart().D(id);
        }
        this.a.getExternalBook().setId(getPackagePart().b(str, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/externalLinkPath").a());
    }

    public void R(OutputStream outputStream) throws IOException {
        ExternalLinkDocument externalLinkDocumentNewInstance = ExternalLinkDocument.Factory.newInstance();
        externalLinkDocumentNewInstance.setExternalLink(this.a);
        externalLinkDocumentNewInstance.save(outputStream, m.a);
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        OutputStream outputStreamO = getPackagePart().o();
        try {
            R(outputStreamO);
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

    public e(n.a.a.k.b.m mVar) throws IOException {
        super(mVar);
        InputStream inputStreamM = mVar.m();
        try {
            P(inputStreamM);
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
