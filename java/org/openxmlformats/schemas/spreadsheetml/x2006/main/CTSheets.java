package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTSheets extends XmlObject {
    public static final DocumentFactory<CTSheets> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSheets> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsheets49fdtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTSheet addNewSheet();

    CTSheet getSheetArray(int i2);

    CTSheet[] getSheetArray();

    List<CTSheet> getSheetList();

    CTSheet insertNewSheet(int i2);

    void removeSheet(int i2);

    void setSheetArray(int i2, CTSheet cTSheet);

    void setSheetArray(CTSheet[] cTSheetArr);

    int sizeOfSheetArray();
}
