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
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtension;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;

/* loaded from: classes2.dex */
public class CTExtensionListImpl extends XmlComplexContentImpl implements CTExtensionList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ext")};
    private static final long serialVersionUID = 1;

    public CTExtensionListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public CTExtension addNewExt() {
        CTExtension cTExtensionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExtensionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public CTExtension[] getExtArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CTExtension[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public List<CTExtension> getExtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.m0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getExtArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.h7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setExtArray(((Integer) obj).intValue(), (CTExtension) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.ha
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewExt(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.e3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeExt(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.p3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfExtArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public CTExtension insertNewExt(int i2) {
        CTExtension cTExtensionInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTExtensionInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public void removeExt(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public void setExtArray(CTExtension[] cTExtensionArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTExtensionArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public int sizeOfExtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public CTExtension getExtArray(int i2) {
        CTExtension cTExtensionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTExtensionFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTExtensionFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public void setExtArray(int i2, CTExtension cTExtension) throws Throwable {
        generatedSetterHelperImpl(cTExtension, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
