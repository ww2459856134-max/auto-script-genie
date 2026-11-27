package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTSingleXmlCells extends XmlObject {
    public static final DocumentFactory<CTSingleXmlCells> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSingleXmlCells> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsinglexmlcells5a6btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTSingleXmlCell addNewSingleXmlCell();

    CTSingleXmlCell getSingleXmlCellArray(int i2);

    CTSingleXmlCell[] getSingleXmlCellArray();

    List<CTSingleXmlCell> getSingleXmlCellList();

    CTSingleXmlCell insertNewSingleXmlCell(int i2);

    void removeSingleXmlCell(int i2);

    void setSingleXmlCellArray(int i2, CTSingleXmlCell cTSingleXmlCell);

    void setSingleXmlCellArray(CTSingleXmlCell[] cTSingleXmlCellArr);

    int sizeOfSingleXmlCellArray();
}
