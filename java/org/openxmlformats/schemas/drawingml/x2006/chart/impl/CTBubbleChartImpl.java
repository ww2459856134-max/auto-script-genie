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
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleScale;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSizeRepresents;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* loaded from: classes2.dex */
public class CTBubbleChartImpl extends XmlComplexContentImpl implements CTBubbleChart {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "varyColors"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ser"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "bubble3D"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "bubbleScale"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "showNegBubbles"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "sizeRepresents"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "axId"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTBubbleChartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTUnsignedInt addNewAxId() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBoolean addNewBubble3D() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBubbleScale addNewBubbleScale() {
        CTBubbleScale cTBubbleScaleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleScaleAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTBubbleScaleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTDLbls addNewDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBubbleSer addNewSer() {
        CTBubbleSer cTBubbleSer;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleSer = (CTBubbleSer) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTBubbleSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBoolean addNewShowNegBubbles() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTSizeRepresents addNewSizeRepresents() {
        CTSizeRepresents cTSizeRepresentsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSizeRepresentsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTSizeRepresentsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBoolean addNewVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTUnsignedInt[] getAxIdArray() {
        return (CTUnsignedInt[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTUnsignedInt[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public List<CTUnsignedInt> getAxIdList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.v2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAxIdArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.d7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAxIdArray(((Integer) obj).intValue(), (CTUnsignedInt) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.w7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAxId(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.na
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAxId(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.q
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAxIdArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBoolean getBubble3D() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBubbleScale getBubbleScale() {
        CTBubbleScale cTBubbleScaleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleScaleFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTBubbleScaleFind_element_user == null) {
                cTBubbleScaleFind_element_user = null;
            }
        }
        return cTBubbleScaleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBubbleSer[] getSerArray() {
        return (CTBubbleSer[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTBubbleSer[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public List<CTBubbleSer> getSerList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.w6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSerArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.g
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSerArray(((Integer) obj).intValue(), (CTBubbleSer) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.l4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSer(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.ka
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSer(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.wa
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSerArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBoolean getShowNegBubbles() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTSizeRepresents getSizeRepresents() {
        CTSizeRepresents cTSizeRepresentsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSizeRepresentsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTSizeRepresentsFind_element_user == null) {
                cTSizeRepresentsFind_element_user = null;
            }
        }
        return cTSizeRepresentsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTUnsignedInt insertNewAxId(int i2) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBubbleSer insertNewSer(int i2) {
        CTBubbleSer cTBubbleSer;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleSer = (CTBubbleSer) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTBubbleSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetBubble3D() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetBubbleScale() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetDLbls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetShowNegBubbles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetSizeRepresents() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetVaryColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void removeAxId(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void removeSer(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr) {
        check_orphaned();
        arraySetterHelper(cTUnsignedIntArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setBubble3D(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setBubbleScale(CTBubbleScale cTBubbleScale) throws Throwable {
        generatedSetterHelperImpl(cTBubbleScale, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setDLbls(CTDLbls cTDLbls) throws Throwable {
        generatedSetterHelperImpl(cTDLbls, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setSerArray(CTBubbleSer[] cTBubbleSerArr) {
        check_orphaned();
        arraySetterHelper(cTBubbleSerArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setShowNegBubbles(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setSizeRepresents(CTSizeRepresents cTSizeRepresents) throws Throwable {
        generatedSetterHelperImpl(cTSizeRepresents, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setVaryColors(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public int sizeOfAxIdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public int sizeOfSerArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetBubble3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetBubbleScale() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetShowNegBubbles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetSizeRepresents() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetVaryColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTUnsignedInt getAxIdArray(int i2) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTUnsignedInt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBubbleSer getSerArray(int i2) {
        CTBubbleSer cTBubbleSer;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleSer = (CTBubbleSer) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTBubbleSer == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBubbleSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setAxIdArray(int i2, CTUnsignedInt cTUnsignedInt) throws Throwable {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setSerArray(int i2, CTBubbleSer cTBubbleSer) throws Throwable {
        generatedSetterHelperImpl(cTBubbleSer, PROPERTY_QNAME[1], i2, (short) 2);
    }
}
