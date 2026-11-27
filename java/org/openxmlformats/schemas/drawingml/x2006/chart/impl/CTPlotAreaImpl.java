package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTArea3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAreaChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBar3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDTable;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLine3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPie3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStockChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurface3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurfaceChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* loaded from: classes2.dex */
public class CTPlotAreaImpl extends XmlComplexContentImpl implements CTPlotArea {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "layout"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "areaChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "area3DChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "lineChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "line3DChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "stockChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "radarChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "scatterChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "pieChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "pie3DChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "doughnutChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "barChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "bar3DChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ofPieChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "surfaceChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "surface3DChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "bubbleChart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "valAx"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "catAx"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dateAx"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "serAx"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dTable"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTPlotAreaImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTArea3DChart addNewArea3DChart() {
        CTArea3DChart cTArea3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTArea3DChart = (CTArea3DChart) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTArea3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTAreaChart addNewAreaChart() {
        CTAreaChart cTAreaChart;
        synchronized (monitor()) {
            check_orphaned();
            cTAreaChart = (CTAreaChart) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTAreaChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBar3DChart addNewBar3DChart() {
        CTBar3DChart cTBar3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBar3DChart = (CTBar3DChart) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTBar3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBarChart addNewBarChart() {
        CTBarChart cTBarChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBarChart = (CTBarChart) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTBarChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBubbleChart addNewBubbleChart() {
        CTBubbleChart cTBubbleChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleChart = (CTBubbleChart) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTBubbleChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTCatAx addNewCatAx() {
        CTCatAx cTCatAx;
        synchronized (monitor()) {
            check_orphaned();
            cTCatAx = (CTCatAx) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTCatAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDTable addNewDTable() {
        CTDTable cTDTableAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDTableAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTDTableAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDateAx addNewDateAx() {
        CTDateAx cTDateAx;
        synchronized (monitor()) {
            check_orphaned();
            cTDateAx = (CTDateAx) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTDateAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDoughnutChart addNewDoughnutChart() {
        CTDoughnutChart cTDoughnutChart;
        synchronized (monitor()) {
            check_orphaned();
            cTDoughnutChart = (CTDoughnutChart) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTDoughnutChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLayout addNewLayout() {
        CTLayout cTLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTLayout = (CTLayout) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTLayout;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLine3DChart addNewLine3DChart() {
        CTLine3DChart cTLine3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLine3DChart = (CTLine3DChart) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTLine3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLineChart addNewLineChart() {
        CTLineChart cTLineChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLineChart = (CTLineChart) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTLineChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTOfPieChart addNewOfPieChart() {
        CTOfPieChart cTOfPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTOfPieChart = (CTOfPieChart) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTOfPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPie3DChart addNewPie3DChart() {
        CTPie3DChart cTPie3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPie3DChart = (CTPie3DChart) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTPie3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPieChart addNewPieChart() {
        CTPieChart cTPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPieChart = (CTPieChart) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTRadarChart addNewRadarChart() {
        CTRadarChart cTRadarChart;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarChart = (CTRadarChart) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTRadarChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTScatterChart addNewScatterChart() {
        CTScatterChart cTScatterChart;
        synchronized (monitor()) {
            check_orphaned();
            cTScatterChart = (CTScatterChart) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTScatterChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSerAx addNewSerAx() {
        CTSerAx cTSerAx;
        synchronized (monitor()) {
            check_orphaned();
            cTSerAx = (CTSerAx) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTSerAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTStockChart addNewStockChart() {
        CTStockChart cTStockChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStockChartAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTStockChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurface3DChart addNewSurface3DChart() {
        CTSurface3DChart cTSurface3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface3DChart = (CTSurface3DChart) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTSurface3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurfaceChart addNewSurfaceChart() {
        CTSurfaceChart cTSurfaceChart;
        synchronized (monitor()) {
            check_orphaned();
            cTSurfaceChart = (CTSurfaceChart) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTSurfaceChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTValAx addNewValAx() {
        CTValAx cTValAx;
        synchronized (monitor()) {
            check_orphaned();
            cTValAx = (CTValAx) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTValAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTArea3DChart[] getArea3DChartArray() {
        return (CTArea3DChart[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTArea3DChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTArea3DChart> getArea3DChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.c0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getArea3DChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.s3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setArea3DChartArray(((Integer) obj).intValue(), (CTArea3DChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.u7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewArea3DChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.pb
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeArea3DChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.y6
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfArea3DChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTAreaChart[] getAreaChartArray() {
        return (CTAreaChart[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTAreaChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTAreaChart> getAreaChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.n
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAreaChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.d0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAreaChartArray(((Integer) obj).intValue(), (CTAreaChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.u3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAreaChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.l2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAreaChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.a
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAreaChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBar3DChart[] getBar3DChartArray() {
        return (CTBar3DChart[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTBar3DChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTBar3DChart> getBar3DChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.j3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBar3DChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.p9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBar3DChartArray(((Integer) obj).intValue(), (CTBar3DChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.g0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBar3DChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.q6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBar3DChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.z1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBar3DChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBarChart[] getBarChartArray() {
        return (CTBarChart[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTBarChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTBarChart> getBarChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.i0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBarChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.f1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBarChartArray(((Integer) obj).intValue(), (CTBarChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.e9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBarChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.za
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBarChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.g6
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBarChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBubbleChart[] getBubbleChartArray() {
        return (CTBubbleChart[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTBubbleChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTBubbleChart> getBubbleChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.xa
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBubbleChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.q7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBubbleChartArray(((Integer) obj).intValue(), (CTBubbleChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.ta
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBubbleChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.x7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBubbleChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.r5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBubbleChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTCatAx[] getCatAxArray() {
        return (CTCatAx[]) getXmlObjectArray(PROPERTY_QNAME[18], new CTCatAx[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTCatAx> getCatAxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.n2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCatAxArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.d2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCatAxArray(((Integer) obj).intValue(), (CTCatAx) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.u6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCatAx(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.x4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCatAx(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.p4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCatAxArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDTable getDTable() {
        CTDTable cTDTableFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDTableFind_element_user = get_store().find_element_user(PROPERTY_QNAME[21], 0);
            if (cTDTableFind_element_user == null) {
                cTDTableFind_element_user = null;
            }
        }
        return cTDTableFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDateAx[] getDateAxArray() {
        return (CTDateAx[]) getXmlObjectArray(PROPERTY_QNAME[19], new CTDateAx[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTDateAx> getDateAxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.y4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDateAxArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.n5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDateAxArray(((Integer) obj).intValue(), (CTDateAx) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.w5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDateAx(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.ub
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDateAx(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.w1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDateAxArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDoughnutChart[] getDoughnutChartArray() {
        return (CTDoughnutChart[]) getXmlObjectArray(PROPERTY_QNAME[10], new CTDoughnutChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTDoughnutChart> getDoughnutChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.z7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDoughnutChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.l5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDoughnutChartArray(((Integer) obj).intValue(), (CTDoughnutChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.u9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDoughnutChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.y1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDoughnutChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.fa
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDoughnutChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[23], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLayout getLayout() {
        CTLayout cTLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTLayout = (CTLayout) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTLayout == null) {
                cTLayout = null;
            }
        }
        return cTLayout;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLine3DChart[] getLine3DChartArray() {
        return (CTLine3DChart[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTLine3DChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTLine3DChart> getLine3DChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.n7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLine3DChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.r1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLine3DChartArray(((Integer) obj).intValue(), (CTLine3DChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLine3DChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.h3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLine3DChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.ma
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLine3DChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLineChart[] getLineChartArray() {
        return (CTLineChart[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTLineChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTLineChart> getLineChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.sa
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLineChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.e5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLineChartArray(((Integer) obj).intValue(), (CTLineChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.u
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLineChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.r8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLineChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.rb
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLineChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTOfPieChart[] getOfPieChartArray() {
        return (CTOfPieChart[]) getXmlObjectArray(PROPERTY_QNAME[13], new CTOfPieChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTOfPieChart> getOfPieChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.u1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOfPieChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.d9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOfPieChartArray(((Integer) obj).intValue(), (CTOfPieChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.t6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOfPieChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.h4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOfPieChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.m9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOfPieChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPie3DChart[] getPie3DChartArray() {
        return (CTPie3DChart[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTPie3DChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTPie3DChart> getPie3DChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.ra
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPie3DChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.h1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPie3DChartArray(((Integer) obj).intValue(), (CTPie3DChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.gc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPie3DChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.c1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePie3DChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.y
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPie3DChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPieChart[] getPieChartArray() {
        return (CTPieChart[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTPieChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTPieChart> getPieChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.c2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPieChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.e1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPieChartArray(((Integer) obj).intValue(), (CTPieChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.p
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPieChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.y2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePieChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.e0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPieChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTRadarChart[] getRadarChartArray() {
        return (CTRadarChart[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTRadarChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTRadarChart> getRadarChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.q0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRadarChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.r6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRadarChartArray(((Integer) obj).intValue(), (CTRadarChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.s6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRadarChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.a3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRadarChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.l6
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRadarChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTScatterChart[] getScatterChartArray() {
        return (CTScatterChart[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTScatterChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTScatterChart> getScatterChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.m2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getScatterChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.y7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setScatterChartArray(((Integer) obj).intValue(), (CTScatterChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.g7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewScatterChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.fb
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeScatterChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.x3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfScatterChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSerAx[] getSerAxArray() {
        return (CTSerAx[]) getXmlObjectArray(PROPERTY_QNAME[20], new CTSerAx[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTSerAx> getSerAxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.zb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSerAxArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.d3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSerAxArray(((Integer) obj).intValue(), (CTSerAx) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.j1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSerAx(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.d6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSerAx(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.la
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSerAxArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTShapeProperties getSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().find_element_user(PROPERTY_QNAME[22], 0);
            if (cTShapeProperties == null) {
                cTShapeProperties = null;
            }
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTStockChart[] getStockChartArray() {
        return getXmlObjectArray(PROPERTY_QNAME[5], (XmlObject[]) new CTStockChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTStockChart> getStockChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.c6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getStockChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.aa
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setStockChartArray(((Integer) obj).intValue(), (CTStockChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.ca
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewStockChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.n1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeStockChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.b4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfStockChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurface3DChart[] getSurface3DChartArray() {
        return (CTSurface3DChart[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTSurface3DChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTSurface3DChart> getSurface3DChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.o
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSurface3DChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.h0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSurface3DChartArray(((Integer) obj).intValue(), (CTSurface3DChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.d
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSurface3DChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.j5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSurface3DChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.n8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSurface3DChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurfaceChart[] getSurfaceChartArray() {
        return (CTSurfaceChart[]) getXmlObjectArray(PROPERTY_QNAME[14], new CTSurfaceChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTSurfaceChart> getSurfaceChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.z3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSurfaceChartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.a4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSurfaceChartArray(((Integer) obj).intValue(), (CTSurfaceChart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.r0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSurfaceChart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.i2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSurfaceChart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.a9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSurfaceChartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTValAx[] getValAxArray() {
        return (CTValAx[]) getXmlObjectArray(PROPERTY_QNAME[17], new CTValAx[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTValAx> getValAxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.z6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getValAxArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.w8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setValAxArray(((Integer) obj).intValue(), (CTValAx) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.k8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewValAx(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeValAx(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.c8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfValAxArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTArea3DChart insertNewArea3DChart(int i2) {
        CTArea3DChart cTArea3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTArea3DChart = (CTArea3DChart) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTArea3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTAreaChart insertNewAreaChart(int i2) {
        CTAreaChart cTAreaChart;
        synchronized (monitor()) {
            check_orphaned();
            cTAreaChart = (CTAreaChart) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTAreaChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBar3DChart insertNewBar3DChart(int i2) {
        CTBar3DChart cTBar3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBar3DChart = (CTBar3DChart) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return cTBar3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBarChart insertNewBarChart(int i2) {
        CTBarChart cTBarChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBarChart = (CTBarChart) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTBarChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBubbleChart insertNewBubbleChart(int i2) {
        CTBubbleChart cTBubbleChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleChart = (CTBubbleChart) get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return cTBubbleChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTCatAx insertNewCatAx(int i2) {
        CTCatAx cTCatAx;
        synchronized (monitor()) {
            check_orphaned();
            cTCatAx = (CTCatAx) get_store().insert_element_user(PROPERTY_QNAME[18], i2);
        }
        return cTCatAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDateAx insertNewDateAx(int i2) {
        CTDateAx cTDateAx;
        synchronized (monitor()) {
            check_orphaned();
            cTDateAx = (CTDateAx) get_store().insert_element_user(PROPERTY_QNAME[19], i2);
        }
        return cTDateAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDoughnutChart insertNewDoughnutChart(int i2) {
        CTDoughnutChart cTDoughnutChart;
        synchronized (monitor()) {
            check_orphaned();
            cTDoughnutChart = (CTDoughnutChart) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTDoughnutChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLine3DChart insertNewLine3DChart(int i2) {
        CTLine3DChart cTLine3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLine3DChart = (CTLine3DChart) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTLine3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLineChart insertNewLineChart(int i2) {
        CTLineChart cTLineChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLineChart = (CTLineChart) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTLineChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTOfPieChart insertNewOfPieChart(int i2) {
        CTOfPieChart cTOfPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTOfPieChart = (CTOfPieChart) get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return cTOfPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPie3DChart insertNewPie3DChart(int i2) {
        CTPie3DChart cTPie3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPie3DChart = (CTPie3DChart) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTPie3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPieChart insertNewPieChart(int i2) {
        CTPieChart cTPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPieChart = (CTPieChart) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTRadarChart insertNewRadarChart(int i2) {
        CTRadarChart cTRadarChart;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarChart = (CTRadarChart) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTRadarChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTScatterChart insertNewScatterChart(int i2) {
        CTScatterChart cTScatterChart;
        synchronized (monitor()) {
            check_orphaned();
            cTScatterChart = (CTScatterChart) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTScatterChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSerAx insertNewSerAx(int i2) {
        CTSerAx cTSerAx;
        synchronized (monitor()) {
            check_orphaned();
            cTSerAx = (CTSerAx) get_store().insert_element_user(PROPERTY_QNAME[20], i2);
        }
        return cTSerAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTStockChart insertNewStockChart(int i2) {
        CTStockChart cTStockChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStockChartInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTStockChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurface3DChart insertNewSurface3DChart(int i2) {
        CTSurface3DChart cTSurface3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface3DChart = (CTSurface3DChart) get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return cTSurface3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurfaceChart insertNewSurfaceChart(int i2) {
        CTSurfaceChart cTSurfaceChart;
        synchronized (monitor()) {
            check_orphaned();
            cTSurfaceChart = (CTSurfaceChart) get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return cTSurfaceChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTValAx insertNewValAx(int i2) {
        CTValAx cTValAx;
        synchronized (monitor()) {
            check_orphaned();
            cTValAx = (CTValAx) get_store().insert_element_user(PROPERTY_QNAME[17], i2);
        }
        return cTValAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public boolean isSetDTable() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[21]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[23]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public boolean isSetLayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[22]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeArea3DChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeAreaChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeBar3DChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeBarChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeBubbleChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeCatAx(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeDateAx(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeDoughnutChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeLine3DChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeLineChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeOfPieChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removePie3DChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removePieChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeRadarChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeScatterChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeSerAx(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeStockChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeSurface3DChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeSurfaceChart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeValAx(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setArea3DChartArray(CTArea3DChart[] cTArea3DChartArr) {
        check_orphaned();
        arraySetterHelper(cTArea3DChartArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setAreaChartArray(CTAreaChart[] cTAreaChartArr) {
        check_orphaned();
        arraySetterHelper(cTAreaChartArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBar3DChartArray(CTBar3DChart[] cTBar3DChartArr) {
        check_orphaned();
        arraySetterHelper(cTBar3DChartArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBarChartArray(CTBarChart[] cTBarChartArr) {
        check_orphaned();
        arraySetterHelper(cTBarChartArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBubbleChartArray(CTBubbleChart[] cTBubbleChartArr) {
        check_orphaned();
        arraySetterHelper(cTBubbleChartArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setCatAxArray(CTCatAx[] cTCatAxArr) {
        check_orphaned();
        arraySetterHelper(cTCatAxArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDTable(CTDTable cTDTable) throws Throwable {
        generatedSetterHelperImpl(cTDTable, PROPERTY_QNAME[21], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDateAxArray(CTDateAx[] cTDateAxArr) {
        check_orphaned();
        arraySetterHelper(cTDateAxArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDoughnutChartArray(CTDoughnutChart[] cTDoughnutChartArr) {
        check_orphaned();
        arraySetterHelper(cTDoughnutChartArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[23], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLayout(CTLayout cTLayout) throws Throwable {
        generatedSetterHelperImpl(cTLayout, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLine3DChartArray(CTLine3DChart[] cTLine3DChartArr) {
        check_orphaned();
        arraySetterHelper(cTLine3DChartArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLineChartArray(CTLineChart[] cTLineChartArr) {
        check_orphaned();
        arraySetterHelper(cTLineChartArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setOfPieChartArray(CTOfPieChart[] cTOfPieChartArr) {
        check_orphaned();
        arraySetterHelper(cTOfPieChartArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setPie3DChartArray(CTPie3DChart[] cTPie3DChartArr) {
        check_orphaned();
        arraySetterHelper(cTPie3DChartArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setPieChartArray(CTPieChart[] cTPieChartArr) {
        check_orphaned();
        arraySetterHelper(cTPieChartArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setRadarChartArray(CTRadarChart[] cTRadarChartArr) {
        check_orphaned();
        arraySetterHelper(cTRadarChartArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setScatterChartArray(CTScatterChart[] cTScatterChartArr) {
        check_orphaned();
        arraySetterHelper(cTScatterChartArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSerAxArray(CTSerAx[] cTSerAxArr) {
        check_orphaned();
        arraySetterHelper(cTSerAxArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSpPr(CTShapeProperties cTShapeProperties) throws Throwable {
        generatedSetterHelperImpl(cTShapeProperties, PROPERTY_QNAME[22], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setStockChartArray(CTStockChart[] cTStockChartArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTStockChartArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSurface3DChartArray(CTSurface3DChart[] cTSurface3DChartArr) {
        check_orphaned();
        arraySetterHelper(cTSurface3DChartArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSurfaceChartArray(CTSurfaceChart[] cTSurfaceChartArr) {
        check_orphaned();
        arraySetterHelper(cTSurfaceChartArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setValAxArray(CTValAx[] cTValAxArr) {
        check_orphaned();
        arraySetterHelper(cTValAxArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfArea3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfAreaChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfBar3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfBarChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfBubbleChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfCatAxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfDateAxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfDoughnutChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfLine3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfLineChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfOfPieChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfPie3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfPieChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfRadarChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfScatterChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfSerAxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfStockChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfSurface3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfSurfaceChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfValAxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void unsetDTable() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void unsetLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTArea3DChart getArea3DChartArray(int i2) {
        CTArea3DChart cTArea3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTArea3DChart = (CTArea3DChart) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTArea3DChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTArea3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTAreaChart getAreaChartArray(int i2) {
        CTAreaChart cTAreaChart;
        synchronized (monitor()) {
            check_orphaned();
            cTAreaChart = (CTAreaChart) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTAreaChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAreaChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBar3DChart getBar3DChartArray(int i2) {
        CTBar3DChart cTBar3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBar3DChart = (CTBar3DChart) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (cTBar3DChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBar3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBarChart getBarChartArray(int i2) {
        CTBarChart cTBarChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBarChart = (CTBarChart) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (cTBarChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBarChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBubbleChart getBubbleChartArray(int i2) {
        CTBubbleChart cTBubbleChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleChart = (CTBubbleChart) get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (cTBubbleChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBubbleChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTCatAx getCatAxArray(int i2) {
        CTCatAx cTCatAx;
        synchronized (monitor()) {
            check_orphaned();
            cTCatAx = (CTCatAx) get_store().find_element_user(PROPERTY_QNAME[18], i2);
            if (cTCatAx == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCatAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDateAx getDateAxArray(int i2) {
        CTDateAx cTDateAx;
        synchronized (monitor()) {
            check_orphaned();
            cTDateAx = (CTDateAx) get_store().find_element_user(PROPERTY_QNAME[19], i2);
            if (cTDateAx == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDateAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDoughnutChart getDoughnutChartArray(int i2) {
        CTDoughnutChart cTDoughnutChart;
        synchronized (monitor()) {
            check_orphaned();
            cTDoughnutChart = (CTDoughnutChart) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTDoughnutChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDoughnutChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLine3DChart getLine3DChartArray(int i2) {
        CTLine3DChart cTLine3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLine3DChart = (CTLine3DChart) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTLine3DChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLine3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLineChart getLineChartArray(int i2) {
        CTLineChart cTLineChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLineChart = (CTLineChart) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTLineChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLineChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTOfPieChart getOfPieChartArray(int i2) {
        CTOfPieChart cTOfPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTOfPieChart = (CTOfPieChart) get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (cTOfPieChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOfPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPie3DChart getPie3DChartArray(int i2) {
        CTPie3DChart cTPie3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPie3DChart = (CTPie3DChart) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTPie3DChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPie3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPieChart getPieChartArray(int i2) {
        CTPieChart cTPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPieChart = (CTPieChart) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTPieChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTRadarChart getRadarChartArray(int i2) {
        CTRadarChart cTRadarChart;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarChart = (CTRadarChart) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTRadarChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRadarChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTScatterChart getScatterChartArray(int i2) {
        CTScatterChart cTScatterChart;
        synchronized (monitor()) {
            check_orphaned();
            cTScatterChart = (CTScatterChart) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTScatterChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTScatterChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSerAx getSerAxArray(int i2) {
        CTSerAx cTSerAx;
        synchronized (monitor()) {
            check_orphaned();
            cTSerAx = (CTSerAx) get_store().find_element_user(PROPERTY_QNAME[20], i2);
            if (cTSerAx == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSerAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTStockChart getStockChartArray(int i2) {
        CTStockChart cTStockChartFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStockChartFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTStockChartFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStockChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurface3DChart getSurface3DChartArray(int i2) {
        CTSurface3DChart cTSurface3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface3DChart = (CTSurface3DChart) get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (cTSurface3DChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSurface3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurfaceChart getSurfaceChartArray(int i2) {
        CTSurfaceChart cTSurfaceChart;
        synchronized (monitor()) {
            check_orphaned();
            cTSurfaceChart = (CTSurfaceChart) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (cTSurfaceChart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSurfaceChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTValAx getValAxArray(int i2) {
        CTValAx cTValAx;
        synchronized (monitor()) {
            check_orphaned();
            cTValAx = (CTValAx) get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (cTValAx == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTValAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setArea3DChartArray(int i2, CTArea3DChart cTArea3DChart) throws Throwable {
        generatedSetterHelperImpl(cTArea3DChart, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setAreaChartArray(int i2, CTAreaChart cTAreaChart) throws Throwable {
        generatedSetterHelperImpl(cTAreaChart, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBar3DChartArray(int i2, CTBar3DChart cTBar3DChart) throws Throwable {
        generatedSetterHelperImpl(cTBar3DChart, PROPERTY_QNAME[12], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBarChartArray(int i2, CTBarChart cTBarChart) throws Throwable {
        generatedSetterHelperImpl(cTBarChart, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBubbleChartArray(int i2, CTBubbleChart cTBubbleChart) throws Throwable {
        generatedSetterHelperImpl(cTBubbleChart, PROPERTY_QNAME[16], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setCatAxArray(int i2, CTCatAx cTCatAx) throws Throwable {
        generatedSetterHelperImpl(cTCatAx, PROPERTY_QNAME[18], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDateAxArray(int i2, CTDateAx cTDateAx) throws Throwable {
        generatedSetterHelperImpl(cTDateAx, PROPERTY_QNAME[19], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDoughnutChartArray(int i2, CTDoughnutChart cTDoughnutChart) throws Throwable {
        generatedSetterHelperImpl(cTDoughnutChart, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLine3DChartArray(int i2, CTLine3DChart cTLine3DChart) throws Throwable {
        generatedSetterHelperImpl(cTLine3DChart, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLineChartArray(int i2, CTLineChart cTLineChart) throws Throwable {
        generatedSetterHelperImpl(cTLineChart, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setOfPieChartArray(int i2, CTOfPieChart cTOfPieChart) throws Throwable {
        generatedSetterHelperImpl(cTOfPieChart, PROPERTY_QNAME[13], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setPie3DChartArray(int i2, CTPie3DChart cTPie3DChart) throws Throwable {
        generatedSetterHelperImpl(cTPie3DChart, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setPieChartArray(int i2, CTPieChart cTPieChart) throws Throwable {
        generatedSetterHelperImpl(cTPieChart, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setRadarChartArray(int i2, CTRadarChart cTRadarChart) throws Throwable {
        generatedSetterHelperImpl(cTRadarChart, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setScatterChartArray(int i2, CTScatterChart cTScatterChart) throws Throwable {
        generatedSetterHelperImpl(cTScatterChart, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSerAxArray(int i2, CTSerAx cTSerAx) throws Throwable {
        generatedSetterHelperImpl(cTSerAx, PROPERTY_QNAME[20], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setStockChartArray(int i2, CTStockChart cTStockChart) throws Throwable {
        generatedSetterHelperImpl(cTStockChart, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSurface3DChartArray(int i2, CTSurface3DChart cTSurface3DChart) throws Throwable {
        generatedSetterHelperImpl(cTSurface3DChart, PROPERTY_QNAME[15], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSurfaceChartArray(int i2, CTSurfaceChart cTSurfaceChart) throws Throwable {
        generatedSetterHelperImpl(cTSurfaceChart, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setValAxArray(int i2, CTValAx cTValAx) throws Throwable {
        generatedSetterHelperImpl(cTValAx, PROPERTY_QNAME[17], i2, (short) 2);
    }
}
