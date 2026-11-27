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
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTHoleSize;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

/* loaded from: classes2.dex */
public class CTDoughnutChartImpl extends XmlComplexContentImpl implements CTDoughnutChart {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "varyColors"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ser"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "firstSliceAng"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "holeSize"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTDoughnutChartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTDLbls addNewDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTFirstSliceAng addNewFirstSliceAng() {
        CTFirstSliceAng cTFirstSliceAng;
        synchronized (monitor()) {
            check_orphaned();
            cTFirstSliceAng = (CTFirstSliceAng) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTFirstSliceAng;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTHoleSize addNewHoleSize() {
        CTHoleSize cTHoleSize;
        synchronized (monitor()) {
            check_orphaned();
            cTHoleSize = (CTHoleSize) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTHoleSize;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTPieSer addNewSer() {
        CTPieSer cTPieSer;
        synchronized (monitor()) {
            check_orphaned();
            cTPieSer = (CTPieSer) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTPieSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTBoolean addNewVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTDLbls getDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTDLbls == null) {
                cTDLbls = null;
            }
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTFirstSliceAng getFirstSliceAng() {
        CTFirstSliceAng cTFirstSliceAng;
        synchronized (monitor()) {
            check_orphaned();
            cTFirstSliceAng = (CTFirstSliceAng) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTFirstSliceAng == null) {
                cTFirstSliceAng = null;
            }
        }
        return cTFirstSliceAng;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTHoleSize getHoleSize() {
        CTHoleSize cTHoleSize;
        synchronized (monitor()) {
            check_orphaned();
            cTHoleSize = (CTHoleSize) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTHoleSize == null) {
                cTHoleSize = null;
            }
        }
        return cTHoleSize;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTPieSer[] getSerArray() {
        return (CTPieSer[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTPieSer[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public List<CTPieSer> getSerList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.t5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSerArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.d1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSerArray(((Integer) obj).intValue(), (CTPieSer) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.c5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSer(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.pa
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSer(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.v5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSerArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTBoolean getVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTPieSer insertNewSer(int i2) {
        CTPieSer cTPieSer;
        synchronized (monitor()) {
            check_orphaned();
            cTPieSer = (CTPieSer) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTPieSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public boolean isSetDLbls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public boolean isSetFirstSliceAng() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public boolean isSetHoleSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public boolean isSetVaryColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void removeSer(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void setDLbls(CTDLbls cTDLbls) throws Throwable {
        generatedSetterHelperImpl(cTDLbls, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void setFirstSliceAng(CTFirstSliceAng cTFirstSliceAng) throws Throwable {
        generatedSetterHelperImpl(cTFirstSliceAng, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void setHoleSize(CTHoleSize cTHoleSize) throws Throwable {
        generatedSetterHelperImpl(cTHoleSize, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void setSerArray(CTPieSer[] cTPieSerArr) {
        check_orphaned();
        arraySetterHelper(cTPieSerArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void setVaryColors(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public int sizeOfSerArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void unsetDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void unsetFirstSliceAng() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void unsetHoleSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void unsetVaryColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public CTPieSer getSerArray(int i2) {
        CTPieSer cTPieSer;
        synchronized (monitor()) {
            check_orphaned();
            cTPieSer = (CTPieSer) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTPieSer == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPieSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart
    public void setSerArray(int i2, CTPieSer cTPieSer) throws Throwable {
        generatedSetterHelperImpl(cTPieSer, PROPERTY_QNAME[1], i2, (short) 2);
    }
}
