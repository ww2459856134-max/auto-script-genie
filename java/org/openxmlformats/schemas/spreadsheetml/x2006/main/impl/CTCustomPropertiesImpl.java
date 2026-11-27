package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperty;

/* loaded from: classes2.dex */
public class CTCustomPropertiesImpl extends XmlComplexContentImpl implements CTCustomProperties {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customPr")};
    private static final long serialVersionUID = 1;

    public CTCustomPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public CTCustomProperty addNewCustomPr() {
        CTCustomProperty cTCustomProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomProperty = (CTCustomProperty) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCustomProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public CTCustomProperty[] getCustomPrArray() {
        return (CTCustomProperty[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTCustomProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public List<CTCustomProperty> getCustomPrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.aa
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomPrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.wa
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomPrArray(((Integer) obj).intValue(), (CTCustomProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.z7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomPr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.zj
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomPr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.sf
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomPrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public CTCustomProperty insertNewCustomPr(int i2) {
        CTCustomProperty cTCustomProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomProperty = (CTCustomProperty) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTCustomProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public void removeCustomPr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public void setCustomPrArray(CTCustomProperty[] cTCustomPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTCustomPropertyArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public int sizeOfCustomPrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public CTCustomProperty getCustomPrArray(int i2) {
        CTCustomProperty cTCustomProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomProperty = (CTCustomProperty) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTCustomProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCustomProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public void setCustomPrArray(int i2, CTCustomProperty cTCustomProperty) throws Throwable {
        generatedSetterHelperImpl(cTCustomProperty, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
