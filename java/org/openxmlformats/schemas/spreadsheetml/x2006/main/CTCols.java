package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTCols extends XmlObject {
    public static final DocumentFactory<CTCols> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCols> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcols627ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCol addNewCol();

    CTCol getColArray(int i2);

    CTCol[] getColArray();

    List<CTCol> getColList();

    CTCol insertNewCol(int i2);

    void removeCol(int i2);

    void setColArray(int i2, CTCol cTCol);

    void setColArray(CTCol[] cTColArr);

    int sizeOfColArray();
}
