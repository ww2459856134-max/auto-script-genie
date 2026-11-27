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
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList;

/* loaded from: classes2.dex */
public class CTLineStyleListImpl extends XmlComplexContentImpl implements CTLineStyleList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ln")};
    private static final long serialVersionUID = 1;

    public CTLineStyleListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public CTLineProperties addNewLn() {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public CTLineProperties[] getLnArray() {
        return (CTLineProperties[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTLineProperties[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public List<CTLineProperties> getLnList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m30
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLnArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLnArray(((Integer) obj).intValue(), (CTLineProperties) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.t8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLn(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.w5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLn(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.af
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLnArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public CTLineProperties insertNewLn(int i2) {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public void removeLn(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public void setLnArray(CTLineProperties[] cTLinePropertiesArr) {
        check_orphaned();
        arraySetterHelper(cTLinePropertiesArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public int sizeOfLnArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public CTLineProperties getLnArray(int i2) {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTLineProperties == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public void setLnArray(int i2, CTLineProperties cTLineProperties) throws Throwable {
        generatedSetterHelperImpl(cTLineProperties, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
