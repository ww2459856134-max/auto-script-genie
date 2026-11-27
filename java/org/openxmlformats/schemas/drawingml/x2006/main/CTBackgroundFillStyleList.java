package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTBackgroundFillStyleList extends XmlObject {
    public static final DocumentFactory<CTBackgroundFillStyleList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBackgroundFillStyleList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctbackgroundfillstylelist13cftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTBlipFillProperties addNewBlipFill();

    CTGradientFillProperties addNewGradFill();

    CTGroupFillProperties addNewGrpFill();

    CTNoFillProperties addNewNoFill();

    CTPatternFillProperties addNewPattFill();

    CTSolidColorFillProperties addNewSolidFill();

    CTBlipFillProperties getBlipFillArray(int i2);

    CTBlipFillProperties[] getBlipFillArray();

    List<CTBlipFillProperties> getBlipFillList();

    CTGradientFillProperties getGradFillArray(int i2);

    CTGradientFillProperties[] getGradFillArray();

    List<CTGradientFillProperties> getGradFillList();

    CTGroupFillProperties getGrpFillArray(int i2);

    CTGroupFillProperties[] getGrpFillArray();

    List<CTGroupFillProperties> getGrpFillList();

    CTNoFillProperties getNoFillArray(int i2);

    CTNoFillProperties[] getNoFillArray();

    List<CTNoFillProperties> getNoFillList();

    CTPatternFillProperties getPattFillArray(int i2);

    CTPatternFillProperties[] getPattFillArray();

    List<CTPatternFillProperties> getPattFillList();

    CTSolidColorFillProperties getSolidFillArray(int i2);

    CTSolidColorFillProperties[] getSolidFillArray();

    List<CTSolidColorFillProperties> getSolidFillList();

    CTBlipFillProperties insertNewBlipFill(int i2);

    CTGradientFillProperties insertNewGradFill(int i2);

    CTGroupFillProperties insertNewGrpFill(int i2);

    CTNoFillProperties insertNewNoFill(int i2);

    CTPatternFillProperties insertNewPattFill(int i2);

    CTSolidColorFillProperties insertNewSolidFill(int i2);

    void removeBlipFill(int i2);

    void removeGradFill(int i2);

    void removeGrpFill(int i2);

    void removeNoFill(int i2);

    void removePattFill(int i2);

    void removeSolidFill(int i2);

    void setBlipFillArray(int i2, CTBlipFillProperties cTBlipFillProperties);

    void setBlipFillArray(CTBlipFillProperties[] cTBlipFillPropertiesArr);

    void setGradFillArray(int i2, CTGradientFillProperties cTGradientFillProperties);

    void setGradFillArray(CTGradientFillProperties[] cTGradientFillPropertiesArr);

    void setGrpFillArray(int i2, CTGroupFillProperties cTGroupFillProperties);

    void setGrpFillArray(CTGroupFillProperties[] cTGroupFillPropertiesArr);

    void setNoFillArray(int i2, CTNoFillProperties cTNoFillProperties);

    void setNoFillArray(CTNoFillProperties[] cTNoFillPropertiesArr);

    void setPattFillArray(int i2, CTPatternFillProperties cTPatternFillProperties);

    void setPattFillArray(CTPatternFillProperties[] cTPatternFillPropertiesArr);

    void setSolidFillArray(int i2, CTSolidColorFillProperties cTSolidColorFillProperties);

    void setSolidFillArray(CTSolidColorFillProperties[] cTSolidColorFillPropertiesArr);

    int sizeOfBlipFillArray();

    int sizeOfGradFillArray();

    int sizeOfGrpFillArray();

    int sizeOfNoFillArray();

    int sizeOfPattFillArray();

    int sizeOfSolidFillArray();
}
