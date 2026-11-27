package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument;

/* loaded from: classes2.dex */
public class KeybaseImpl extends AnnotatedImpl implements Keybase {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "selector"), new QName("http://www.w3.org/2001/XMLSchema", "field"), new QName("", "name")};
    private static final long serialVersionUID = 1;

    public KeybaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public FieldDocument.Field addNewField() {
        FieldDocument.Field field;
        synchronized (monitor()) {
            check_orphaned();
            field = (FieldDocument.Field) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return field;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public SelectorDocument.Selector addNewSelector() {
        SelectorDocument.Selector selector;
        synchronized (monitor()) {
            check_orphaned();
            selector = (SelectorDocument.Selector) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return selector;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public FieldDocument.Field[] getFieldArray() {
        return (FieldDocument.Field[]) getXmlObjectArray(PROPERTY_QNAME[1], new FieldDocument.Field[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public List<FieldDocument.Field> getFieldList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.u7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFieldArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.da
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFieldArray(((Integer) obj).intValue(), (FieldDocument.Field) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.r9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewField(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.w6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeField(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.o4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFieldArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public String getName() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public SelectorDocument.Selector getSelector() {
        SelectorDocument.Selector selector;
        synchronized (monitor()) {
            check_orphaned();
            selector = (SelectorDocument.Selector) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (selector == null) {
                selector = null;
            }
        }
        return selector;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public FieldDocument.Field insertNewField(int i2) {
        FieldDocument.Field field;
        synchronized (monitor()) {
            check_orphaned();
            field = (FieldDocument.Field) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return field;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void removeField(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void setFieldArray(FieldDocument.Field[] fieldArr) {
        check_orphaned();
        arraySetterHelper(fieldArr, PROPERTY_QNAME[1]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void setSelector(SelectorDocument.Selector selector) throws Throwable {
        generatedSetterHelperImpl(selector, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public int sizeOfFieldArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public XmlNCName xgetName() {
        XmlNCName xmlNCName;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCName = (XmlNCName) get_store().find_attribute_user(PROPERTY_QNAME[2]);
        }
        return xmlNCName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlNCName xmlNCName2 = (XmlNCName) typeStore.find_attribute_user(qNameArr[2]);
            if (xmlNCName2 == null) {
                xmlNCName2 = (XmlNCName) get_store().add_attribute_user(qNameArr[2]);
            }
            xmlNCName2.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public FieldDocument.Field getFieldArray(int i2) {
        FieldDocument.Field field;
        synchronized (monitor()) {
            check_orphaned();
            field = (FieldDocument.Field) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (field == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return field;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void setFieldArray(int i2, FieldDocument.Field field) throws Throwable {
        generatedSetterHelperImpl(field, PROPERTY_QNAME[1], i2, (short) 2);
    }
}
