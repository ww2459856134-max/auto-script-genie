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
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;

/* loaded from: classes2.dex */
public class AttributeGroupImpl extends AnnotatedImpl implements AttributeGroup {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "attribute"), new QName("http://www.w3.org/2001/XMLSchema", "attributeGroup"), new QName("http://www.w3.org/2001/XMLSchema", "anyAttribute"), new QName("", "name"), new QName("", "ref")};
    private static final long serialVersionUID = 1;

    public AttributeGroupImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public Wildcard addNewAnyAttribute() {
        Wildcard wildcard;
        synchronized (monitor()) {
            check_orphaned();
            wildcard = (Wildcard) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return wildcard;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public Attribute addNewAttribute() {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public AttributeGroupRef addNewAttributeGroup() {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public Wildcard getAnyAttribute() {
        Wildcard wildcard;
        synchronized (monitor()) {
            check_orphaned();
            wildcard = (Wildcard) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (wildcard == null) {
                wildcard = null;
            }
        }
        return wildcard;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public Attribute[] getAttributeArray() {
        return (Attribute[]) getXmlObjectArray(PROPERTY_QNAME[0], new Attribute[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public AttributeGroupRef[] getAttributeGroupArray() {
        return (AttributeGroupRef[]) getXmlObjectArray(PROPERTY_QNAME[1], new AttributeGroupRef[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public List<AttributeGroupRef> getAttributeGroupList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.g9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAttributeGroupArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.v1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAttributeGroupArray(((Integer) obj).intValue(), (AttributeGroupRef) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.e7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAttributeGroup(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.f5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAttributeGroup(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.i
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAttributeGroupArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public List<Attribute> getAttributeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.s0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAttributeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ua
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAttributeArray(((Integer) obj).intValue(), (Attribute) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.s9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAttribute(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.j0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAttribute(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.g0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAttributeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public String getName() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public QName getRef() {
        QName qNameValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[4]);
            qNameValue = simpleValue == null ? null : simpleValue.getQNameValue();
        }
        return qNameValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public Attribute insertNewAttribute(int i2) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public AttributeGroupRef insertNewAttributeGroup(int i2) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public boolean isSetAnyAttribute() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[3]) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public boolean isSetRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void removeAttribute(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void removeAttributeGroup(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setAnyAttribute(Wildcard wildcard) throws Throwable {
        generatedSetterHelperImpl(wildcard, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setAttributeArray(Attribute[] attributeArr) {
        check_orphaned();
        arraySetterHelper(attributeArr, PROPERTY_QNAME[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr) {
        check_orphaned();
        arraySetterHelper(attributeGroupRefArr, PROPERTY_QNAME[1]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setRef(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public int sizeOfAttributeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public int sizeOfAttributeGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void unsetAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[3]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void unsetRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public XmlNCName xgetName() {
        XmlNCName xmlNCName;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCName = (XmlNCName) get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return xmlNCName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public XmlQName xgetRef() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(PROPERTY_QNAME[4]);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlNCName xmlNCName2 = (XmlNCName) typeStore.find_attribute_user(qNameArr[3]);
            if (xmlNCName2 == null) {
                xmlNCName2 = (XmlNCName) get_store().add_attribute_user(qNameArr[3]);
            }
            xmlNCName2.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void xsetRef(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qNameArr[4]);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qNameArr[4]);
            }
            xmlQName2.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public Attribute getAttributeArray(int i2) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (attribute == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public AttributeGroupRef getAttributeGroupArray(int i2) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (attributeGroupRef == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setAttributeArray(int i2, Attribute attribute) throws Throwable {
        generatedSetterHelperImpl(attribute, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    public void setAttributeGroupArray(int i2, AttributeGroupRef attributeGroupRef) throws Throwable {
        generatedSetterHelperImpl(attributeGroupRef, PROPERTY_QNAME[1], i2, (short) 2);
    }
}
