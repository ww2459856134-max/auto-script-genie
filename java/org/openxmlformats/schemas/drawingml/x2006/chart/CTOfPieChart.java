package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTOfPieChart extends XmlObject {
    public static final DocumentFactory<CTOfPieChart> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTOfPieChart> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctofpiechartbbb3type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCustSplit addNewCustSplit();

    CTDLbls addNewDLbls();

    CTExtensionList addNewExtLst();

    CTGapAmount addNewGapWidth();

    CTOfPieType addNewOfPieType();

    CTSecondPieSize addNewSecondPieSize();

    CTPieSer addNewSer();

    CTChartLines addNewSerLines();

    CTDouble addNewSplitPos();

    CTSplitType addNewSplitType();

    CTBoolean addNewVaryColors();

    CTCustSplit getCustSplit();

    CTDLbls getDLbls();

    CTExtensionList getExtLst();

    CTGapAmount getGapWidth();

    CTOfPieType getOfPieType();

    CTSecondPieSize getSecondPieSize();

    CTPieSer getSerArray(int i2);

    CTPieSer[] getSerArray();

    CTChartLines getSerLinesArray(int i2);

    CTChartLines[] getSerLinesArray();

    List<CTChartLines> getSerLinesList();

    List<CTPieSer> getSerList();

    CTDouble getSplitPos();

    CTSplitType getSplitType();

    CTBoolean getVaryColors();

    CTPieSer insertNewSer(int i2);

    CTChartLines insertNewSerLines(int i2);

    boolean isSetCustSplit();

    boolean isSetDLbls();

    boolean isSetExtLst();

    boolean isSetGapWidth();

    boolean isSetSecondPieSize();

    boolean isSetSplitPos();

    boolean isSetSplitType();

    boolean isSetVaryColors();

    void removeSer(int i2);

    void removeSerLines(int i2);

    void setCustSplit(CTCustSplit cTCustSplit);

    void setDLbls(CTDLbls cTDLbls);

    void setExtLst(CTExtensionList cTExtensionList);

    void setGapWidth(CTGapAmount cTGapAmount);

    void setOfPieType(CTOfPieType cTOfPieType);

    void setSecondPieSize(CTSecondPieSize cTSecondPieSize);

    void setSerArray(int i2, CTPieSer cTPieSer);

    void setSerArray(CTPieSer[] cTPieSerArr);

    void setSerLinesArray(int i2, CTChartLines cTChartLines);

    void setSerLinesArray(CTChartLines[] cTChartLinesArr);

    void setSplitPos(CTDouble cTDouble);

    void setSplitType(CTSplitType cTSplitType);

    void setVaryColors(CTBoolean cTBoolean);

    int sizeOfSerArray();

    int sizeOfSerLinesArray();

    void unsetCustSplit();

    void unsetDLbls();

    void unsetExtLst();

    void unsetGapWidth();

    void unsetSecondPieSize();

    void unsetSplitPos();

    void unsetSplitType();

    void unsetVaryColors();
}
