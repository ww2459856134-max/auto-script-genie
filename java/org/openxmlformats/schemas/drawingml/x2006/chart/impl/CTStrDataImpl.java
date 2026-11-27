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
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* loaded from: classes2.dex */
public class CTStrDataImpl extends XmlComplexContentImpl implements CTStrData {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ptCount"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "pt"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTStrDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTStrVal addNewPt() {
        CTStrVal cTStrVal;
        synchronized (monitor()) {
            check_orphaned();
            cTStrVal = (CTStrVal) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTStrVal;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTUnsignedInt addNewPtCount() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTStrVal[] getPtArray() {
        return (CTStrVal[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTStrVal[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTUnsignedInt getPtCount() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTUnsignedInt == null) {
                cTUnsignedInt = null;
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public List<CTStrVal> getPtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.v3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPtArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.n6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPtArray(((Integer) obj).intValue(), (CTStrVal) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.p1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPt(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.u5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePt(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.h9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPtArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTStrVal insertNewPt(int i2) {
        CTStrVal cTStrVal;
        synchronized (monitor()) {
            check_orphaned();
            cTStrVal = (CTStrVal) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTStrVal;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public boolean isSetPtCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void removePt(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void setPtArray(CTStrVal[] cTStrValArr) {
        check_orphaned();
        arraySetterHelper(cTStrValArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void setPtCount(CTUnsignedInt cTUnsignedInt) throws Throwable {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public int sizeOfPtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void unsetPtCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTStrVal getPtArray(int i2) {
        CTStrVal cTStrVal;
        synchronized (monitor()) {
            check_orphaned();
            cTStrVal = (CTStrVal) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTStrVal == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStrVal;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void setPtArray(int i2, CTStrVal cTStrVal) throws Throwable {
        generatedSetterHelperImpl(cTStrVal, PROPERTY_QNAME[1], i2, (short) 2);
    }
}
