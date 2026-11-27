package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTExternalRow extends XmlObject {
    public static final DocumentFactory<CTExternalRow> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTExternalRow> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctexternalrowa22etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExternalCell addNewCell();

    CTExternalCell getCellArray(int i2);

    CTExternalCell[] getCellArray();

    List<CTExternalCell> getCellList();

    long getR();

    CTExternalCell insertNewCell(int i2);

    void removeCell(int i2);

    void setCellArray(int i2, CTExternalCell cTExternalCell);

    void setCellArray(CTExternalCell[] cTExternalCellArr);

    void setR(long j2);

    int sizeOfCellArray();

    XmlUnsignedInt xgetR();

    void xsetR(XmlUnsignedInt xmlUnsignedInt);
}
