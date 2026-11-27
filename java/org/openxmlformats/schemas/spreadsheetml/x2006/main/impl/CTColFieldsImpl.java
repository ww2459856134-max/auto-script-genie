package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField;

/* loaded from: classes2.dex */
public class CTColFieldsImpl extends XmlComplexContentImpl implements CTColFields {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "field"), new QName("", "count")};
    private static final long serialVersionUID = 1;

    public CTColFieldsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public CTField addNewField() {
        CTField cTField;
        synchronized (monitor()) {
            check_orphaned();
            cTField = (CTField) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public long getCount() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[1]);
            }
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public CTField[] getFieldArray() {
        return (CTField[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTField[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public List<CTField> getFieldList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ze
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFieldArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.v0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFieldArray(((Integer) obj).intValue(), (CTField) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.g5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewField(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.a6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeField(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.z4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFieldArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public CTField insertNewField(int i2) {
        CTField cTField;
        synchronized (monitor()) {
            check_orphaned();
            cTField = (CTField) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = true;
            if (get_store().find_attribute_user(PROPERTY_QNAME[1]) == null) {
                z = false;
            }
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public void removeField(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public void setCount(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
            }
            simpleValue.setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public void setFieldArray(CTField[] cTFieldArr) {
        check_orphaned();
        arraySetterHelper(cTFieldArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public int sizeOfFieldArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[1]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlUnsignedInt = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[1]);
            if (xmlUnsignedInt == null) {
                xmlUnsignedInt = (XmlUnsignedInt) get_default_attribute_value(qNameArr[1]);
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public void xsetCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[1]);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[1]);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public CTField getFieldArray(int i2) {
        CTField cTField;
        synchronized (monitor()) {
            check_orphaned();
            cTField = (CTField) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTField == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields
    public void setFieldArray(int i2, CTField cTField) throws Throwable {
        generatedSetterHelperImpl(cTField, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
