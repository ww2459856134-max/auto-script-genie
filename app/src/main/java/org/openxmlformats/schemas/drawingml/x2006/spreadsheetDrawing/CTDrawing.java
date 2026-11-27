package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTDrawing extends XmlObject {
    public static final DocumentFactory<CTDrawing> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDrawing> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdrawing2748type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAbsoluteAnchor addNewAbsoluteAnchor();

    CTOneCellAnchor addNewOneCellAnchor();

    CTTwoCellAnchor addNewTwoCellAnchor();

    CTAbsoluteAnchor getAbsoluteAnchorArray(int i2);

    CTAbsoluteAnchor[] getAbsoluteAnchorArray();

    List<CTAbsoluteAnchor> getAbsoluteAnchorList();

    CTOneCellAnchor getOneCellAnchorArray(int i2);

    CTOneCellAnchor[] getOneCellAnchorArray();

    List<CTOneCellAnchor> getOneCellAnchorList();

    CTTwoCellAnchor getTwoCellAnchorArray(int i2);

    CTTwoCellAnchor[] getTwoCellAnchorArray();

    List<CTTwoCellAnchor> getTwoCellAnchorList();

    CTAbsoluteAnchor insertNewAbsoluteAnchor(int i2);

    CTOneCellAnchor insertNewOneCellAnchor(int i2);

    CTTwoCellAnchor insertNewTwoCellAnchor(int i2);

    void removeAbsoluteAnchor(int i2);

    void removeOneCellAnchor(int i2);

    void removeTwoCellAnchor(int i2);

    void setAbsoluteAnchorArray(int i2, CTAbsoluteAnchor cTAbsoluteAnchor);

    void setAbsoluteAnchorArray(CTAbsoluteAnchor[] cTAbsoluteAnchorArr);

    void setOneCellAnchorArray(int i2, CTOneCellAnchor cTOneCellAnchor);

    void setOneCellAnchorArray(CTOneCellAnchor[] cTOneCellAnchorArr);

    void setTwoCellAnchorArray(int i2, CTTwoCellAnchor cTTwoCellAnchor);

    void setTwoCellAnchorArray(CTTwoCellAnchor[] cTTwoCellAnchorArr);

    int sizeOfAbsoluteAnchorArray();

    int sizeOfOneCellAnchorArray();

    int sizeOfTwoCellAnchorArray();
}
