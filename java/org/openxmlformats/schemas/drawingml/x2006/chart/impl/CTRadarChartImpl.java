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
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarStyle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* loaded from: classes2.dex */
public class CTRadarChartImpl extends XmlComplexContentImpl implements CTRadarChart {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "radarStyle"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "varyColors"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ser"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "axId"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTRadarChartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTUnsignedInt addNewAxId() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTDLbls addNewDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTRadarStyle addNewRadarStyle() {
        CTRadarStyle cTRadarStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarStyle = (CTRadarStyle) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTRadarStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTRadarSer addNewSer() {
        CTRadarSer cTRadarSer;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarSer = (CTRadarSer) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTRadarSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTBoolean addNewVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTUnsignedInt[] getAxIdArray() {
        return (CTUnsignedInt[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTUnsignedInt[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public List<CTUnsignedInt> getAxIdList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.z0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAxIdArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.ac
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAxIdArray(((Integer) obj).intValue(), (CTUnsignedInt) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.s0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAxId(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.c7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAxId(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.xb
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAxIdArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTRadarStyle getRadarStyle() {
        CTRadarStyle cTRadarStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarStyle = (CTRadarStyle) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTRadarStyle == null) {
                cTRadarStyle = null;
            }
        }
        return cTRadarStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTRadarSer[] getSerArray() {
        return (CTRadarSer[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTRadarSer[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public List<CTRadarSer> getSerList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.j8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSerArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.k1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSerArray(((Integer) obj).intValue(), (CTRadarSer) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.u0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSer(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.b8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSer(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.a1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSerArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTUnsignedInt insertNewAxId(int i2) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTRadarSer insertNewSer(int i2) {
        CTRadarSer cTRadarSer;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarSer = (CTRadarSer) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTRadarSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public boolean isSetDLbls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void removeAxId(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void removeSer(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr) {
        check_orphaned();
        arraySetterHelper(cTUnsignedIntArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void setDLbls(CTDLbls cTDLbls) throws Throwable {
        generatedSetterHelperImpl(cTDLbls, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void setRadarStyle(CTRadarStyle cTRadarStyle) throws Throwable {
        generatedSetterHelperImpl(cTRadarStyle, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void setSerArray(CTRadarSer[] cTRadarSerArr) {
        check_orphaned();
        arraySetterHelper(cTRadarSerArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void setVaryColors(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public int sizeOfAxIdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public int sizeOfSerArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void unsetDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void unsetVaryColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTUnsignedInt getAxIdArray(int i2) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTUnsignedInt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public CTRadarSer getSerArray(int i2) {
        CTRadarSer cTRadarSer;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarSer = (CTRadarSer) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTRadarSer == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRadarSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void setAxIdArray(int i2, CTUnsignedInt cTUnsignedInt) throws Throwable {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart
    public void setSerArray(int i2, CTRadarSer cTRadarSer) throws Throwable {
        generatedSetterHelperImpl(cTRadarSer, PROPERTY_QNAME[2], i2, (short) 2);
    }
}
