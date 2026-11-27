package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;

/* loaded from: classes2.dex */
public interface CTGroupShape extends XmlObject {
    public static final DocumentFactory<CTGroupShape> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTGroupShape> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctgroupshape6c36type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTConnector addNewCxnSp();

    CTGraphicalObjectFrame addNewGraphicFrame();

    CTGroupShape addNewGrpSp();

    CTGroupShapeProperties addNewGrpSpPr();

    CTGroupShapeNonVisual addNewNvGrpSpPr();

    CTPicture addNewPic();

    CTShape addNewSp();

    CTConnector getCxnSpArray(int i2);

    CTConnector[] getCxnSpArray();

    List<CTConnector> getCxnSpList();

    CTGraphicalObjectFrame getGraphicFrameArray(int i2);

    CTGraphicalObjectFrame[] getGraphicFrameArray();

    List<CTGraphicalObjectFrame> getGraphicFrameList();

    CTGroupShape getGrpSpArray(int i2);

    CTGroupShape[] getGrpSpArray();

    List<CTGroupShape> getGrpSpList();

    CTGroupShapeProperties getGrpSpPr();

    CTGroupShapeNonVisual getNvGrpSpPr();

    CTPicture getPicArray(int i2);

    CTPicture[] getPicArray();

    List<CTPicture> getPicList();

    CTShape getSpArray(int i2);

    CTShape[] getSpArray();

    List<CTShape> getSpList();

    CTConnector insertNewCxnSp(int i2);

    CTGraphicalObjectFrame insertNewGraphicFrame(int i2);

    CTGroupShape insertNewGrpSp(int i2);

    CTPicture insertNewPic(int i2);

    CTShape insertNewSp(int i2);

    void removeCxnSp(int i2);

    void removeGraphicFrame(int i2);

    void removeGrpSp(int i2);

    void removePic(int i2);

    void removeSp(int i2);

    void setCxnSpArray(int i2, CTConnector cTConnector);

    void setCxnSpArray(CTConnector[] cTConnectorArr);

    void setGraphicFrameArray(int i2, CTGraphicalObjectFrame cTGraphicalObjectFrame);

    void setGraphicFrameArray(CTGraphicalObjectFrame[] cTGraphicalObjectFrameArr);

    void setGrpSpArray(int i2, CTGroupShape cTGroupShape);

    void setGrpSpArray(CTGroupShape[] cTGroupShapeArr);

    void setGrpSpPr(CTGroupShapeProperties cTGroupShapeProperties);

    void setNvGrpSpPr(CTGroupShapeNonVisual cTGroupShapeNonVisual);

    void setPicArray(int i2, CTPicture cTPicture);

    void setPicArray(CTPicture[] cTPictureArr);

    void setSpArray(int i2, CTShape cTShape);

    void setSpArray(CTShape[] cTShapeArr);

    int sizeOfCxnSpArray();

    int sizeOfGraphicFrameArray();

    int sizeOfGrpSpArray();

    int sizeOfPicArray();

    int sizeOfSpArray();
}
