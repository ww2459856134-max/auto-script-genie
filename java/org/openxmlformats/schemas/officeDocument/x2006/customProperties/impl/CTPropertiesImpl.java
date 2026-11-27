package org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;

/* loaded from: classes2.dex */
public class CTPropertiesImpl extends XmlComplexContentImpl implements CTProperties {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/custom-properties", "property")};
    private static final long serialVersionUID = 1;

    public CTPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public CTProperty addNewProperty() {
        CTProperty cTProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTProperty = (CTProperty) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTProperty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public CTProperty[] getPropertyArray() {
        return (CTProperty[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTProperty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public List<CTProperty> getPropertyList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl.c
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPropertyArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl.d
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPropertyArray(((Integer) obj).intValue(), (CTProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewProperty(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeProperty(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl.e
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPropertyArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public CTProperty insertNewProperty(int i2) {
        CTProperty cTProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTProperty = (CTProperty) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTProperty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public void removeProperty(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public void setPropertyArray(CTProperty[] cTPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTPropertyArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public int sizeOfPropertyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public CTProperty getPropertyArray(int i2) {
        CTProperty cTProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTProperty = (CTProperty) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProperty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public void setPropertyArray(int i2, CTProperty cTProperty) throws Throwable {
        generatedSetterHelperImpl(cTProperty, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
