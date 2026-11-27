package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTExternalSheetData extends XmlObject {
    public static final DocumentFactory<CTExternalSheetData> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTExternalSheetData> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctexternalsheetdatafd3dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExternalRow addNewRow();

    boolean getRefreshError();

    CTExternalRow getRowArray(int i2);

    CTExternalRow[] getRowArray();

    List<CTExternalRow> getRowList();

    long getSheetId();

    CTExternalRow insertNewRow(int i2);

    boolean isSetRefreshError();

    void removeRow(int i2);

    void setRefreshError(boolean z);

    void setRowArray(int i2, CTExternalRow cTExternalRow);

    void setRowArray(CTExternalRow[] cTExternalRowArr);

    void setSheetId(long j2);

    int sizeOfRowArray();

    void unsetRefreshError();

    XmlBoolean xgetRefreshError();

    XmlUnsignedInt xgetSheetId();

    void xsetRefreshError(XmlBoolean xmlBoolean);

    void xsetSheetId(XmlUnsignedInt xmlUnsignedInt);
}
