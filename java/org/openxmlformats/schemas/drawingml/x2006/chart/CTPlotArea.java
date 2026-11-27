package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* loaded from: classes2.dex */
public interface CTPlotArea extends XmlObject {
    public static final DocumentFactory<CTPlotArea> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPlotArea> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctplotarea106etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTArea3DChart addNewArea3DChart();

    CTAreaChart addNewAreaChart();

    CTBar3DChart addNewBar3DChart();

    CTBarChart addNewBarChart();

    CTBubbleChart addNewBubbleChart();

    CTCatAx addNewCatAx();

    CTDTable addNewDTable();

    CTDateAx addNewDateAx();

    CTDoughnutChart addNewDoughnutChart();

    CTExtensionList addNewExtLst();

    CTLayout addNewLayout();

    CTLine3DChart addNewLine3DChart();

    CTLineChart addNewLineChart();

    CTOfPieChart addNewOfPieChart();

    CTPie3DChart addNewPie3DChart();

    CTPieChart addNewPieChart();

    CTRadarChart addNewRadarChart();

    CTScatterChart addNewScatterChart();

    CTSerAx addNewSerAx();

    CTShapeProperties addNewSpPr();

    CTStockChart addNewStockChart();

    CTSurface3DChart addNewSurface3DChart();

    CTSurfaceChart addNewSurfaceChart();

    CTValAx addNewValAx();

    CTArea3DChart getArea3DChartArray(int i2);

    CTArea3DChart[] getArea3DChartArray();

    List<CTArea3DChart> getArea3DChartList();

    CTAreaChart getAreaChartArray(int i2);

    CTAreaChart[] getAreaChartArray();

    List<CTAreaChart> getAreaChartList();

    CTBar3DChart getBar3DChartArray(int i2);

    CTBar3DChart[] getBar3DChartArray();

    List<CTBar3DChart> getBar3DChartList();

    CTBarChart getBarChartArray(int i2);

    CTBarChart[] getBarChartArray();

    List<CTBarChart> getBarChartList();

    CTBubbleChart getBubbleChartArray(int i2);

    CTBubbleChart[] getBubbleChartArray();

    List<CTBubbleChart> getBubbleChartList();

    CTCatAx getCatAxArray(int i2);

    CTCatAx[] getCatAxArray();

    List<CTCatAx> getCatAxList();

    CTDTable getDTable();

    CTDateAx getDateAxArray(int i2);

    CTDateAx[] getDateAxArray();

    List<CTDateAx> getDateAxList();

    CTDoughnutChart getDoughnutChartArray(int i2);

    CTDoughnutChart[] getDoughnutChartArray();

    List<CTDoughnutChart> getDoughnutChartList();

    CTExtensionList getExtLst();

    CTLayout getLayout();

    CTLine3DChart getLine3DChartArray(int i2);

    CTLine3DChart[] getLine3DChartArray();

    List<CTLine3DChart> getLine3DChartList();

    CTLineChart getLineChartArray(int i2);

    CTLineChart[] getLineChartArray();

    List<CTLineChart> getLineChartList();

    CTOfPieChart getOfPieChartArray(int i2);

    CTOfPieChart[] getOfPieChartArray();

    List<CTOfPieChart> getOfPieChartList();

    CTPie3DChart getPie3DChartArray(int i2);

    CTPie3DChart[] getPie3DChartArray();

    List<CTPie3DChart> getPie3DChartList();

    CTPieChart getPieChartArray(int i2);

    CTPieChart[] getPieChartArray();

    List<CTPieChart> getPieChartList();

    CTRadarChart getRadarChartArray(int i2);

    CTRadarChart[] getRadarChartArray();

    List<CTRadarChart> getRadarChartList();

    CTScatterChart getScatterChartArray(int i2);

    CTScatterChart[] getScatterChartArray();

    List<CTScatterChart> getScatterChartList();

    CTSerAx getSerAxArray(int i2);

    CTSerAx[] getSerAxArray();

    List<CTSerAx> getSerAxList();

    CTShapeProperties getSpPr();

    CTStockChart getStockChartArray(int i2);

    CTStockChart[] getStockChartArray();

    List<CTStockChart> getStockChartList();

    CTSurface3DChart getSurface3DChartArray(int i2);

    CTSurface3DChart[] getSurface3DChartArray();

    List<CTSurface3DChart> getSurface3DChartList();

    CTSurfaceChart getSurfaceChartArray(int i2);

    CTSurfaceChart[] getSurfaceChartArray();

    List<CTSurfaceChart> getSurfaceChartList();

    CTValAx getValAxArray(int i2);

    CTValAx[] getValAxArray();

    List<CTValAx> getValAxList();

    CTArea3DChart insertNewArea3DChart(int i2);

    CTAreaChart insertNewAreaChart(int i2);

    CTBar3DChart insertNewBar3DChart(int i2);

    CTBarChart insertNewBarChart(int i2);

    CTBubbleChart insertNewBubbleChart(int i2);

    CTCatAx insertNewCatAx(int i2);

    CTDateAx insertNewDateAx(int i2);

    CTDoughnutChart insertNewDoughnutChart(int i2);

    CTLine3DChart insertNewLine3DChart(int i2);

    CTLineChart insertNewLineChart(int i2);

    CTOfPieChart insertNewOfPieChart(int i2);

    CTPie3DChart insertNewPie3DChart(int i2);

    CTPieChart insertNewPieChart(int i2);

    CTRadarChart insertNewRadarChart(int i2);

    CTScatterChart insertNewScatterChart(int i2);

    CTSerAx insertNewSerAx(int i2);

    CTStockChart insertNewStockChart(int i2);

    CTSurface3DChart insertNewSurface3DChart(int i2);

    CTSurfaceChart insertNewSurfaceChart(int i2);

    CTValAx insertNewValAx(int i2);

    boolean isSetDTable();

    boolean isSetExtLst();

    boolean isSetLayout();

    boolean isSetSpPr();

    void removeArea3DChart(int i2);

    void removeAreaChart(int i2);

    void removeBar3DChart(int i2);

    void removeBarChart(int i2);

    void removeBubbleChart(int i2);

    void removeCatAx(int i2);

    void removeDateAx(int i2);

    void removeDoughnutChart(int i2);

    void removeLine3DChart(int i2);

    void removeLineChart(int i2);

    void removeOfPieChart(int i2);

    void removePie3DChart(int i2);

    void removePieChart(int i2);

    void removeRadarChart(int i2);

    void removeScatterChart(int i2);

    void removeSerAx(int i2);

    void removeStockChart(int i2);

    void removeSurface3DChart(int i2);

    void removeSurfaceChart(int i2);

    void removeValAx(int i2);

    void setArea3DChartArray(int i2, CTArea3DChart cTArea3DChart);

    void setArea3DChartArray(CTArea3DChart[] cTArea3DChartArr);

    void setAreaChartArray(int i2, CTAreaChart cTAreaChart);

    void setAreaChartArray(CTAreaChart[] cTAreaChartArr);

    void setBar3DChartArray(int i2, CTBar3DChart cTBar3DChart);

    void setBar3DChartArray(CTBar3DChart[] cTBar3DChartArr);

    void setBarChartArray(int i2, CTBarChart cTBarChart);

    void setBarChartArray(CTBarChart[] cTBarChartArr);

    void setBubbleChartArray(int i2, CTBubbleChart cTBubbleChart);

    void setBubbleChartArray(CTBubbleChart[] cTBubbleChartArr);

    void setCatAxArray(int i2, CTCatAx cTCatAx);

    void setCatAxArray(CTCatAx[] cTCatAxArr);

    void setDTable(CTDTable cTDTable);

    void setDateAxArray(int i2, CTDateAx cTDateAx);

    void setDateAxArray(CTDateAx[] cTDateAxArr);

    void setDoughnutChartArray(int i2, CTDoughnutChart cTDoughnutChart);

    void setDoughnutChartArray(CTDoughnutChart[] cTDoughnutChartArr);

    void setExtLst(CTExtensionList cTExtensionList);

    void setLayout(CTLayout cTLayout);

    void setLine3DChartArray(int i2, CTLine3DChart cTLine3DChart);

    void setLine3DChartArray(CTLine3DChart[] cTLine3DChartArr);

    void setLineChartArray(int i2, CTLineChart cTLineChart);

    void setLineChartArray(CTLineChart[] cTLineChartArr);

    void setOfPieChartArray(int i2, CTOfPieChart cTOfPieChart);

    void setOfPieChartArray(CTOfPieChart[] cTOfPieChartArr);

    void setPie3DChartArray(int i2, CTPie3DChart cTPie3DChart);

    void setPie3DChartArray(CTPie3DChart[] cTPie3DChartArr);

    void setPieChartArray(int i2, CTPieChart cTPieChart);

    void setPieChartArray(CTPieChart[] cTPieChartArr);

    void setRadarChartArray(int i2, CTRadarChart cTRadarChart);

    void setRadarChartArray(CTRadarChart[] cTRadarChartArr);

    void setScatterChartArray(int i2, CTScatterChart cTScatterChart);

    void setScatterChartArray(CTScatterChart[] cTScatterChartArr);

    void setSerAxArray(int i2, CTSerAx cTSerAx);

    void setSerAxArray(CTSerAx[] cTSerAxArr);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setStockChartArray(int i2, CTStockChart cTStockChart);

    void setStockChartArray(CTStockChart[] cTStockChartArr);

    void setSurface3DChartArray(int i2, CTSurface3DChart cTSurface3DChart);

    void setSurface3DChartArray(CTSurface3DChart[] cTSurface3DChartArr);

    void setSurfaceChartArray(int i2, CTSurfaceChart cTSurfaceChart);

    void setSurfaceChartArray(CTSurfaceChart[] cTSurfaceChartArr);

    void setValAxArray(int i2, CTValAx cTValAx);

    void setValAxArray(CTValAx[] cTValAxArr);

    int sizeOfArea3DChartArray();

    int sizeOfAreaChartArray();

    int sizeOfBar3DChartArray();

    int sizeOfBarChartArray();

    int sizeOfBubbleChartArray();

    int sizeOfCatAxArray();

    int sizeOfDateAxArray();

    int sizeOfDoughnutChartArray();

    int sizeOfLine3DChartArray();

    int sizeOfLineChartArray();

    int sizeOfOfPieChartArray();

    int sizeOfPie3DChartArray();

    int sizeOfPieChartArray();

    int sizeOfRadarChartArray();

    int sizeOfScatterChartArray();

    int sizeOfSerAxArray();

    int sizeOfStockChartArray();

    int sizeOfSurface3DChartArray();

    int sizeOfSurfaceChartArray();

    int sizeOfValAxArray();

    void unsetDTable();

    void unsetExtLst();

    void unsetLayout();

    void unsetSpPr();
}
