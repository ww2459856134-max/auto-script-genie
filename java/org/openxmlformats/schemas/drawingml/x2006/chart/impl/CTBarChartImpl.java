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
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarDir;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarGrouping;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTGapAmount;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOverlap;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* loaded from: classes2.dex */
public class CTBarChartImpl extends XmlComplexContentImpl implements CTBarChart {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "barDir"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "grouping"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "varyColors"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ser"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "gapWidth"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "overlap"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "serLines"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "axId"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTBarChartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTUnsignedInt addNewAxId() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTBarDir addNewBarDir() {
        CTBarDir cTBarDir;
        synchronized (monitor()) {
            check_orphaned();
            cTBarDir = (CTBarDir) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTBarDir;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTDLbls addNewDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTGapAmount addNewGapWidth() {
        CTGapAmount cTGapAmount;
        synchronized (monitor()) {
            check_orphaned();
            cTGapAmount = (CTGapAmount) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTGapAmount;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTBarGrouping addNewGrouping() {
        CTBarGrouping cTBarGrouping;
        synchronized (monitor()) {
            check_orphaned();
            cTBarGrouping = (CTBarGrouping) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTBarGrouping;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTOverlap addNewOverlap() {
        CTOverlap cTOverlap;
        synchronized (monitor()) {
            check_orphaned();
            cTOverlap = (CTOverlap) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTOverlap;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTBarSer addNewSer() {
        CTBarSer cTBarSer;
        synchronized (monitor()) {
            check_orphaned();
            cTBarSer = (CTBarSer) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTBarSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTChartLines addNewSerLines() {
        CTChartLines cTChartLines;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLines = (CTChartLines) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTChartLines;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTBoolean addNewVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTUnsignedInt[] getAxIdArray() {
        return (CTUnsignedInt[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTUnsignedInt[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public List<CTUnsignedInt> getAxIdList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.y8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAxIdArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.e6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAxIdArray(((Integer) obj).intValue(), (CTUnsignedInt) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.m5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAxId(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.w3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAxId(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.bc
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAxIdArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTBarDir getBarDir() {
        CTBarDir cTBarDir;
        synchronized (monitor()) {
            check_orphaned();
            cTBarDir = (CTBarDir) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTBarDir == null) {
                cTBarDir = null;
            }
        }
        return cTBarDir;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTDLbls getDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTDLbls == null) {
                cTDLbls = null;
            }
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTGapAmount getGapWidth() {
        CTGapAmount cTGapAmount;
        synchronized (monitor()) {
            check_orphaned();
            cTGapAmount = (CTGapAmount) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTGapAmount == null) {
                cTGapAmount = null;
            }
        }
        return cTGapAmount;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTBarGrouping getGrouping() {
        CTBarGrouping cTBarGrouping;
        synchronized (monitor()) {
            check_orphaned();
            cTBarGrouping = (CTBarGrouping) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTBarGrouping == null) {
                cTBarGrouping = null;
            }
        }
        return cTBarGrouping;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTOverlap getOverlap() {
        CTOverlap cTOverlap;
        synchronized (monitor()) {
            check_orphaned();
            cTOverlap = (CTOverlap) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTOverlap == null) {
                cTOverlap = null;
            }
        }
        return cTOverlap;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTBarSer[] getSerArray() {
        return (CTBarSer[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTBarSer[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTChartLines[] getSerLinesArray() {
        return (CTChartLines[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTChartLines[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public List<CTChartLines> getSerLinesList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.q5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSerLinesArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.f4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSerLinesArray(((Integer) obj).intValue(), (CTChartLines) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.m
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSerLines(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.k6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSerLines(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.ib
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSerLinesArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public List<CTBarSer> getSerList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.z2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSerArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.v7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSerArray(((Integer) obj).intValue(), (CTBarSer) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.q2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSer(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.m8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSer(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.x2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSerArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTBoolean getVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTUnsignedInt insertNewAxId(int i2) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTBarSer insertNewSer(int i2) {
        CTBarSer cTBarSer;
        synchronized (monitor()) {
            check_orphaned();
            cTBarSer = (CTBarSer) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTBarSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTChartLines insertNewSerLines(int i2) {
        CTChartLines cTChartLines;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLines = (CTChartLines) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTChartLines;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public boolean isSetDLbls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public boolean isSetGapWidth() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public boolean isSetGrouping() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public boolean isSetOverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public boolean isSetVaryColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void removeAxId(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void removeSer(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void removeSerLines(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr) {
        check_orphaned();
        arraySetterHelper(cTUnsignedIntArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setBarDir(CTBarDir cTBarDir) throws Throwable {
        generatedSetterHelperImpl(cTBarDir, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setDLbls(CTDLbls cTDLbls) throws Throwable {
        generatedSetterHelperImpl(cTDLbls, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setGapWidth(CTGapAmount cTGapAmount) throws Throwable {
        generatedSetterHelperImpl(cTGapAmount, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setGrouping(CTBarGrouping cTBarGrouping) throws Throwable {
        generatedSetterHelperImpl(cTBarGrouping, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setOverlap(CTOverlap cTOverlap) throws Throwable {
        generatedSetterHelperImpl(cTOverlap, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setSerArray(CTBarSer[] cTBarSerArr) {
        check_orphaned();
        arraySetterHelper(cTBarSerArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setSerLinesArray(CTChartLines[] cTChartLinesArr) {
        check_orphaned();
        arraySetterHelper(cTChartLinesArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setVaryColors(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public int sizeOfAxIdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public int sizeOfSerArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public int sizeOfSerLinesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void unsetDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void unsetGapWidth() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void unsetGrouping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void unsetOverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void unsetVaryColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTUnsignedInt getAxIdArray(int i2) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTUnsignedInt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTBarSer getSerArray(int i2) {
        CTBarSer cTBarSer;
        synchronized (monitor()) {
            check_orphaned();
            cTBarSer = (CTBarSer) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTBarSer == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBarSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public CTChartLines getSerLinesArray(int i2) {
        CTChartLines cTChartLines;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLines = (CTChartLines) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTChartLines == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTChartLines;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setAxIdArray(int i2, CTUnsignedInt cTUnsignedInt) throws Throwable {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setSerArray(int i2, CTBarSer cTBarSer) throws Throwable {
        generatedSetterHelperImpl(cTBarSer, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart
    public void setSerLinesArray(int i2, CTChartLines cTChartLines) throws Throwable {
        generatedSetterHelperImpl(cTChartLines, PROPERTY_QNAME[7], i2, (short) 2);
    }
}
