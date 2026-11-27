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
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList;

/* loaded from: classes2.dex */
public class CTEffectStyleListImpl extends XmlComplexContentImpl implements CTEffectStyleList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "effectStyle")};
    private static final long serialVersionUID = 1;

    public CTEffectStyleListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public CTEffectStyleItem addNewEffectStyle() {
        CTEffectStyleItem cTEffectStyleItem;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectStyleItem = (CTEffectStyleItem) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTEffectStyleItem;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public CTEffectStyleItem[] getEffectStyleArray() {
        return (CTEffectStyleItem[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTEffectStyleItem[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public List<CTEffectStyleItem> getEffectStyleList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.u00
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEffectStyleArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEffectStyleArray(((Integer) obj).intValue(), (CTEffectStyleItem) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.pb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEffectStyle(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.d40
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEffectStyle(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.p00
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEffectStyleArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public CTEffectStyleItem insertNewEffectStyle(int i2) {
        CTEffectStyleItem cTEffectStyleItem;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectStyleItem = (CTEffectStyleItem) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTEffectStyleItem;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public void removeEffectStyle(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public void setEffectStyleArray(CTEffectStyleItem[] cTEffectStyleItemArr) {
        check_orphaned();
        arraySetterHelper(cTEffectStyleItemArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public int sizeOfEffectStyleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public CTEffectStyleItem getEffectStyleArray(int i2) {
        CTEffectStyleItem cTEffectStyleItem;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectStyleItem = (CTEffectStyleItem) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTEffectStyleItem == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEffectStyleItem;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList
    public void setEffectStyleArray(int i2, CTEffectStyleItem cTEffectStyleItem) throws Throwable {
        generatedSetterHelperImpl(cTEffectStyleItem, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
