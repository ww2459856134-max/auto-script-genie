package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTMergeCells extends XmlObject {
    public static final DocumentFactory<CTMergeCells> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTMergeCells> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctmergecells1242type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTMergeCell addNewMergeCell();

    long getCount();

    CTMergeCell getMergeCellArray(int i2);

    CTMergeCell[] getMergeCellArray();

    List<CTMergeCell> getMergeCellList();

    CTMergeCell insertNewMergeCell(int i2);

    boolean isSetCount();

    void removeMergeCell(int i2);

    void setCount(long j2);

    void setMergeCellArray(int i2, CTMergeCell cTMergeCell);

    void setMergeCellArray(CTMergeCell[] cTMergeCellArr);

    int sizeOfMergeCellArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
