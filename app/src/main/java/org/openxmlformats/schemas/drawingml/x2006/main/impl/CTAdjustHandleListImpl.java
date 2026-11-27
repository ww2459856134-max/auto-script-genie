package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPolarAdjustHandle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTXYAdjustHandle;

/* loaded from: classes2.dex */
public class CTAdjustHandleListImpl extends XmlComplexContentImpl implements CTAdjustHandleList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ahXY"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ahPolar")};
    private static final long serialVersionUID = 1;

    public CTAdjustHandleListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTPolarAdjustHandle addNewAhPolar() {
        CTPolarAdjustHandle cTPolarAdjustHandle;
        synchronized (monitor()) {
            check_orphaned();
            cTPolarAdjustHandle = (CTPolarAdjustHandle) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTPolarAdjustHandle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTXYAdjustHandle addNewAhXY() {
        CTXYAdjustHandle cTXYAdjustHandle;
        synchronized (monitor()) {
            check_orphaned();
            cTXYAdjustHandle = (CTXYAdjustHandle) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTXYAdjustHandle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTPolarAdjustHandle[] getAhPolarArray() {
        return (CTPolarAdjustHandle[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTPolarAdjustHandle[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public List<CTPolarAdjustHandle> getAhPolarList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.x50
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAhPolarArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m10
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAhPolarArray(((Integer) obj).intValue(), (CTPolarAdjustHandle) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.j10
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAhPolar(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jl
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAhPolar(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.z50
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAhPolarArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTXYAdjustHandle[] getAhXYArray() {
        return (CTXYAdjustHandle[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTXYAdjustHandle[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public List<CTXYAdjustHandle> getAhXYList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.v50
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAhXYArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.wl
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAhXYArray(((Integer) obj).intValue(), (CTXYAdjustHandle) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xo
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAhXY(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.wq
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAhXY(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.dr
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAhXYArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTPolarAdjustHandle insertNewAhPolar(int i2) {
        CTPolarAdjustHandle cTPolarAdjustHandle;
        synchronized (monitor()) {
            check_orphaned();
            cTPolarAdjustHandle = (CTPolarAdjustHandle) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTPolarAdjustHandle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTXYAdjustHandle insertNewAhXY(int i2) {
        CTXYAdjustHandle cTXYAdjustHandle;
        synchronized (monitor()) {
            check_orphaned();
            cTXYAdjustHandle = (CTXYAdjustHandle) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTXYAdjustHandle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void removeAhPolar(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void removeAhXY(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void setAhPolarArray(CTPolarAdjustHandle[] cTPolarAdjustHandleArr) {
        check_orphaned();
        arraySetterHelper(cTPolarAdjustHandleArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void setAhXYArray(CTXYAdjustHandle[] cTXYAdjustHandleArr) {
        check_orphaned();
        arraySetterHelper(cTXYAdjustHandleArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public int sizeOfAhPolarArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public int sizeOfAhXYArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTPolarAdjustHandle getAhPolarArray(int i2) {
        CTPolarAdjustHandle cTPolarAdjustHandle;
        synchronized (monitor()) {
            check_orphaned();
            cTPolarAdjustHandle = (CTPolarAdjustHandle) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTPolarAdjustHandle == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPolarAdjustHandle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTXYAdjustHandle getAhXYArray(int i2) {
        CTXYAdjustHandle cTXYAdjustHandle;
        synchronized (monitor()) {
            check_orphaned();
            cTXYAdjustHandle = (CTXYAdjustHandle) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTXYAdjustHandle == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTXYAdjustHandle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void setAhPolarArray(int i2, CTPolarAdjustHandle cTPolarAdjustHandle) throws Throwable {
        generatedSetterHelperImpl(cTPolarAdjustHandle, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void setAhXYArray(int i2, CTXYAdjustHandle cTXYAdjustHandle) throws Throwable {
        generatedSetterHelperImpl(cTXYAdjustHandle, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
