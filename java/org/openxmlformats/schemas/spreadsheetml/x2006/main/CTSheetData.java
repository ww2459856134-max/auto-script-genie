package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTSheetData extends XmlObject {
    public static final DocumentFactory<CTSheetData> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSheetData> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsheetdata8408type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTRow addNewRow();

    CTRow getRowArray(int i2);

    CTRow[] getRowArray();

    List<CTRow> getRowList();

    CTRow insertNewRow(int i2);

    void removeRow(int i2);

    void setRowArray(int i2, CTRow cTRow);

    void setRowArray(CTRow[] cTRowArr);

    int sizeOfRowArray();
}
