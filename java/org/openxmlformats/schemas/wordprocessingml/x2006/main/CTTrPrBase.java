package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes3.dex */
public interface CTTrPrBase extends XmlObject {
    public static final DocumentFactory<CTTrPrBase> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTrPrBase> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttrprbase5d77type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOnOff addNewCantSplit();

    CTCnf addNewCnfStyle();

    CTDecimalNumber addNewDivId();

    CTDecimalNumber addNewGridAfter();

    CTDecimalNumber addNewGridBefore();

    CTOnOff addNewHidden();

    CTJcTable addNewJc();

    CTTblWidth addNewTblCellSpacing();

    CTOnOff addNewTblHeader();

    CTHeight addNewTrHeight();

    CTTblWidth addNewWAfter();

    CTTblWidth addNewWBefore();

    CTOnOff getCantSplitArray(int i2);

    CTOnOff[] getCantSplitArray();

    List<CTOnOff> getCantSplitList();

    CTCnf getCnfStyleArray(int i2);

    CTCnf[] getCnfStyleArray();

    List<CTCnf> getCnfStyleList();

    CTDecimalNumber getDivIdArray(int i2);

    CTDecimalNumber[] getDivIdArray();

    List<CTDecimalNumber> getDivIdList();

    CTDecimalNumber getGridAfterArray(int i2);

    CTDecimalNumber[] getGridAfterArray();

    List<CTDecimalNumber> getGridAfterList();

    CTDecimalNumber getGridBeforeArray(int i2);

    CTDecimalNumber[] getGridBeforeArray();

    List<CTDecimalNumber> getGridBeforeList();

    CTOnOff getHiddenArray(int i2);

    CTOnOff[] getHiddenArray();

    List<CTOnOff> getHiddenList();

    CTJcTable getJcArray(int i2);

    CTJcTable[] getJcArray();

    List<CTJcTable> getJcList();

    CTTblWidth getTblCellSpacingArray(int i2);

    CTTblWidth[] getTblCellSpacingArray();

    List<CTTblWidth> getTblCellSpacingList();

    CTOnOff getTblHeaderArray(int i2);

    CTOnOff[] getTblHeaderArray();

    List<CTOnOff> getTblHeaderList();

    CTHeight getTrHeightArray(int i2);

    CTHeight[] getTrHeightArray();

    List<CTHeight> getTrHeightList();

    CTTblWidth getWAfterArray(int i2);

    CTTblWidth[] getWAfterArray();

    List<CTTblWidth> getWAfterList();

    CTTblWidth getWBeforeArray(int i2);

    CTTblWidth[] getWBeforeArray();

    List<CTTblWidth> getWBeforeList();

    CTOnOff insertNewCantSplit(int i2);

    CTCnf insertNewCnfStyle(int i2);

    CTDecimalNumber insertNewDivId(int i2);

    CTDecimalNumber insertNewGridAfter(int i2);

    CTDecimalNumber insertNewGridBefore(int i2);

    CTOnOff insertNewHidden(int i2);

    CTJcTable insertNewJc(int i2);

    CTTblWidth insertNewTblCellSpacing(int i2);

    CTOnOff insertNewTblHeader(int i2);

    CTHeight insertNewTrHeight(int i2);

    CTTblWidth insertNewWAfter(int i2);

    CTTblWidth insertNewWBefore(int i2);

    void removeCantSplit(int i2);

    void removeCnfStyle(int i2);

    void removeDivId(int i2);

    void removeGridAfter(int i2);

    void removeGridBefore(int i2);

    void removeHidden(int i2);

    void removeJc(int i2);

    void removeTblCellSpacing(int i2);

    void removeTblHeader(int i2);

    void removeTrHeight(int i2);

    void removeWAfter(int i2);

    void removeWBefore(int i2);

    void setCantSplitArray(int i2, CTOnOff cTOnOff);

    void setCantSplitArray(CTOnOff[] cTOnOffArr);

    void setCnfStyleArray(int i2, CTCnf cTCnf);

    void setCnfStyleArray(CTCnf[] cTCnfArr);

    void setDivIdArray(int i2, CTDecimalNumber cTDecimalNumber);

    void setDivIdArray(CTDecimalNumber[] cTDecimalNumberArr);

    void setGridAfterArray(int i2, CTDecimalNumber cTDecimalNumber);

    void setGridAfterArray(CTDecimalNumber[] cTDecimalNumberArr);

    void setGridBeforeArray(int i2, CTDecimalNumber cTDecimalNumber);

    void setGridBeforeArray(CTDecimalNumber[] cTDecimalNumberArr);

    void setHiddenArray(int i2, CTOnOff cTOnOff);

    void setHiddenArray(CTOnOff[] cTOnOffArr);

    void setJcArray(int i2, CTJcTable cTJcTable);

    void setJcArray(CTJcTable[] cTJcTableArr);

    void setTblCellSpacingArray(int i2, CTTblWidth cTTblWidth);

    void setTblCellSpacingArray(CTTblWidth[] cTTblWidthArr);

    void setTblHeaderArray(int i2, CTOnOff cTOnOff);

    void setTblHeaderArray(CTOnOff[] cTOnOffArr);

    void setTrHeightArray(int i2, CTHeight cTHeight);

    void setTrHeightArray(CTHeight[] cTHeightArr);

    void setWAfterArray(int i2, CTTblWidth cTTblWidth);

    void setWAfterArray(CTTblWidth[] cTTblWidthArr);

    void setWBeforeArray(int i2, CTTblWidth cTTblWidth);

    void setWBeforeArray(CTTblWidth[] cTTblWidthArr);

    int sizeOfCantSplitArray();

    int sizeOfCnfStyleArray();

    int sizeOfDivIdArray();

    int sizeOfGridAfterArray();

    int sizeOfGridBeforeArray();

    int sizeOfHiddenArray();

    int sizeOfJcArray();

    int sizeOfTblCellSpacingArray();

    int sizeOfTblHeaderArray();

    int sizeOfTrHeightArray();

    int sizeOfWAfterArray();

    int sizeOfWBeforeArray();
}
