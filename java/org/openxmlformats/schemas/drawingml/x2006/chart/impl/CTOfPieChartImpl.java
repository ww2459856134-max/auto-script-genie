package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDouble;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTGapAmount;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieType;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSecondPieSize;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSplitType;

/* loaded from: classes2.dex */
public class CTOfPieChartImpl extends XmlComplexContentImpl implements CTOfPieChart {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ofPieType"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "varyColors"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ser"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "gapWidth"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "splitType"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "splitPos"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "custSplit"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "secondPieSize"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "serLines"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTOfPieChartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTCustSplit addNewCustSplit() {
        CTCustSplit cTCustSplit;
        synchronized (monitor()) {
            check_orphaned();
            cTCustSplit = (CTCustSplit) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTCustSplit;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTDLbls addNewDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTGapAmount addNewGapWidth() {
        CTGapAmount cTGapAmount;
        synchronized (monitor()) {
            check_orphaned();
            cTGapAmount = (CTGapAmount) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTGapAmount;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTOfPieType addNewOfPieType() {
        CTOfPieType cTOfPieType;
        synchronized (monitor()) {
            check_orphaned();
            cTOfPieType = (CTOfPieType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTOfPieType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTSecondPieSize addNewSecondPieSize() {
        CTSecondPieSize cTSecondPieSize;
        synchronized (monitor()) {
            check_orphaned();
            cTSecondPieSize = (CTSecondPieSize) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTSecondPieSize;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTPieSer addNewSer() {
        CTPieSer cTPieSer;
        synchronized (monitor()) {
            check_orphaned();
            cTPieSer = (CTPieSer) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTPieSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTChartLines addNewSerLines() {
        CTChartLines cTChartLines;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLines = (CTChartLines) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTChartLines;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTDouble addNewSplitPos() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTSplitType addNewSplitType() {
        CTSplitType cTSplitType;
        synchronized (monitor()) {
            check_orphaned();
            cTSplitType = (CTSplitType) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTSplitType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTBoolean addNewVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTCustSplit getCustSplit() {
        CTCustSplit cTCustSplit;
        synchronized (monitor()) {
            check_orphaned();
            cTCustSplit = (CTCustSplit) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTCustSplit == null) {
                cTCustSplit = null;
            }
        }
        return cTCustSplit;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTDLbls getDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTDLbls == null) {
                cTDLbls = null;
            }
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTGapAmount getGapWidth() {
        CTGapAmount cTGapAmount;
        synchronized (monitor()) {
            check_orphaned();
            cTGapAmount = (CTGapAmount) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTGapAmount == null) {
                cTGapAmount = null;
            }
        }
        return cTGapAmount;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTOfPieType getOfPieType() {
        CTOfPieType cTOfPieType;
        synchronized (monitor()) {
            check_orphaned();
            cTOfPieType = (CTOfPieType) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTOfPieType == null) {
                cTOfPieType = null;
            }
        }
        return cTOfPieType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTSecondPieSize getSecondPieSize() {
        CTSecondPieSize cTSecondPieSize;
        synchronized (monitor()) {
            check_orphaned();
            cTSecondPieSize = (CTSecondPieSize) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTSecondPieSize == null) {
                cTSecondPieSize = null;
            }
        }
        return cTSecondPieSize;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTPieSer[] getSerArray() {
        return (CTPieSer[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTPieSer[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTChartLines[] getSerLinesArray() {
        return (CTChartLines[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTChartLines[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public List<CTChartLines> getSerLinesList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.a7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSerLinesArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.ga
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSerLinesArray(((Integer) obj).intValue(), (CTChartLines) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.a5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSerLines(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.r2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSerLines(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.l8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSerLinesArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public List<CTPieSer> getSerList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.j
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSerArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.f6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSerArray(((Integer) obj).intValue(), (CTPieSer) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.da
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSer(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.f
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSer(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.o5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSerArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTDouble getSplitPos() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTDouble == null) {
                cTDouble = null;
            }
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTSplitType getSplitType() {
        CTSplitType cTSplitType;
        synchronized (monitor()) {
            check_orphaned();
            cTSplitType = (CTSplitType) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTSplitType == null) {
                cTSplitType = null;
            }
        }
        return cTSplitType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTBoolean getVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTPieSer insertNewSer(int i2) {
        CTPieSer cTPieSer;
        synchronized (monitor()) {
            check_orphaned();
            cTPieSer = (CTPieSer) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTPieSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTChartLines insertNewSerLines(int i2) {
        CTChartLines cTChartLines;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLines = (CTChartLines) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTChartLines;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public boolean isSetCustSplit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public boolean isSetDLbls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public boolean isSetGapWidth() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public boolean isSetSecondPieSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public boolean isSetSplitPos() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public boolean isSetSplitType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public boolean isSetVaryColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void removeSer(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void removeSerLines(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setCustSplit(CTCustSplit cTCustSplit) throws Throwable {
        generatedSetterHelperImpl(cTCustSplit, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setDLbls(CTDLbls cTDLbls) throws Throwable {
        generatedSetterHelperImpl(cTDLbls, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setGapWidth(CTGapAmount cTGapAmount) throws Throwable {
        generatedSetterHelperImpl(cTGapAmount, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setOfPieType(CTOfPieType cTOfPieType) throws Throwable {
        generatedSetterHelperImpl(cTOfPieType, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setSecondPieSize(CTSecondPieSize cTSecondPieSize) throws Throwable {
        generatedSetterHelperImpl(cTSecondPieSize, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setSerArray(CTPieSer[] cTPieSerArr) {
        check_orphaned();
        arraySetterHelper(cTPieSerArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setSerLinesArray(CTChartLines[] cTChartLinesArr) {
        check_orphaned();
        arraySetterHelper(cTChartLinesArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setSplitPos(CTDouble cTDouble) throws Throwable {
        generatedSetterHelperImpl(cTDouble, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setSplitType(CTSplitType cTSplitType) throws Throwable {
        generatedSetterHelperImpl(cTSplitType, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setVaryColors(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public int sizeOfSerArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public int sizeOfSerLinesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void unsetCustSplit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void unsetDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void unsetGapWidth() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void unsetSecondPieSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void unsetSplitPos() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void unsetSplitType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void unsetVaryColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTPieSer getSerArray(int i2) {
        CTPieSer cTPieSer;
        synchronized (monitor()) {
            check_orphaned();
            cTPieSer = (CTPieSer) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTPieSer == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPieSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public CTChartLines getSerLinesArray(int i2) {
        CTChartLines cTChartLines;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLines = (CTChartLines) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTChartLines == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTChartLines;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setSerArray(int i2, CTPieSer cTPieSer) throws Throwable {
        generatedSetterHelperImpl(cTPieSer, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart
    public void setSerLinesArray(int i2, CTChartLines cTChartLines) throws Throwable {
        generatedSetterHelperImpl(cTChartLines, PROPERTY_QNAME[9], i2, (short) 2);
    }
}
