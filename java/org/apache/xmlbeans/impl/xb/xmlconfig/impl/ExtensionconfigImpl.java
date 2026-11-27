package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.JavaNameList;

/* loaded from: classes2.dex */
public class ExtensionconfigImpl extends XmlComplexContentImpl implements Extensionconfig {
    private static final QName[] PROPERTY_QNAME = {new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "interface"), new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "prePostSet"), new QName("", "for")};
    private static final long serialVersionUID = 1;

    public static class InterfaceImpl extends XmlComplexContentImpl implements Extensionconfig.Interface {
        private static final QName[] PROPERTY_QNAME = {new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "staticHandler"), new QName("", "name")};
        private static final long serialVersionUID = 1;

        public InterfaceImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public String getName() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public String getStaticHandler() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], 0);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public boolean isSetName() {
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

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public void setName(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public void setStaticHandler(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[0], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[0]);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public void unsetName() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[1]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public XmlString xgetName() {
            XmlString xmlString;
            synchronized (monitor()) {
                check_orphaned();
                xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            }
            return xmlString;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public XmlString xgetStaticHandler() {
            XmlString xmlString;
            synchronized (monitor()) {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            }
            return xmlString;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public void xsetName(XmlString xmlString) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[1]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[1]);
                }
                xmlString2.set(xmlString);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.Interface
        public void xsetStaticHandler(XmlString xmlString) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_element_user(qNameArr[0], 0);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_element_user(qNameArr[0]);
                }
                xmlString2.set(xmlString);
            }
        }
    }

    public static class PrePostSetImpl extends XmlComplexContentImpl implements Extensionconfig.PrePostSet {
        private static final QName[] PROPERTY_QNAME = {new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "staticHandler")};
        private static final long serialVersionUID = 1;

        public PrePostSetImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.PrePostSet
        public String getStaticHandler() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], 0);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.PrePostSet
        public void setStaticHandler(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[0], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[0]);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.PrePostSet
        public XmlString xgetStaticHandler() {
            XmlString xmlString;
            synchronized (monitor()) {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            }
            return xmlString;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig.PrePostSet
        public void xsetStaticHandler(XmlString xmlString) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_element_user(qNameArr[0], 0);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_element_user(qNameArr[0]);
                }
                xmlString2.set(xmlString);
            }
        }
    }

    public ExtensionconfigImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Extensionconfig.Interface addNewInterface() {
        Extensionconfig.Interface r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = (Extensionconfig.Interface) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return r1;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Extensionconfig.PrePostSet addNewPrePostSet() {
        Extensionconfig.PrePostSet prePostSet;
        synchronized (monitor()) {
            check_orphaned();
            prePostSet = (Extensionconfig.PrePostSet) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return prePostSet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Object getFor() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Extensionconfig.Interface[] getInterfaceArray() {
        return (Extensionconfig.Interface[]) getXmlObjectArray(PROPERTY_QNAME[0], new Extensionconfig.Interface[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public List<Extensionconfig.Interface> getInterfaceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xmlconfig.impl.t
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getInterfaceArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xmlconfig.impl.w
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setInterfaceArray(((Integer) obj).intValue(), (Extensionconfig.Interface) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xmlconfig.impl.n
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewInterface(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xmlconfig.impl.c
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeInterface(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xmlconfig.impl.g
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfInterfaceArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Extensionconfig.PrePostSet getPrePostSet() {
        Extensionconfig.PrePostSet prePostSet;
        synchronized (monitor()) {
            check_orphaned();
            prePostSet = (Extensionconfig.PrePostSet) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (prePostSet == null) {
                prePostSet = null;
            }
        }
        return prePostSet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Extensionconfig.Interface insertNewInterface(int i2) {
        Extensionconfig.Interface r5;
        synchronized (monitor()) {
            check_orphaned();
            r5 = (Extensionconfig.Interface) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return r5;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public boolean isSetFor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public boolean isSetPrePostSet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void removeInterface(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void setFor(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void setInterfaceArray(Extensionconfig.Interface[] interfaceArr) {
        check_orphaned();
        arraySetterHelper(interfaceArr, PROPERTY_QNAME[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void setPrePostSet(Extensionconfig.PrePostSet prePostSet) throws Throwable {
        generatedSetterHelperImpl(prePostSet, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public int sizeOfInterfaceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void unsetFor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[2]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void unsetPrePostSet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public JavaNameList xgetFor() {
        JavaNameList javaNameList;
        synchronized (monitor()) {
            check_orphaned();
            javaNameList = (JavaNameList) get_store().find_attribute_user(PROPERTY_QNAME[2]);
        }
        return javaNameList;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void xsetFor(JavaNameList javaNameList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            JavaNameList javaNameList2 = (JavaNameList) typeStore.find_attribute_user(qNameArr[2]);
            if (javaNameList2 == null) {
                javaNameList2 = (JavaNameList) get_store().add_attribute_user(qNameArr[2]);
            }
            javaNameList2.set(javaNameList);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public Extensionconfig.Interface getInterfaceArray(int i2) {
        Extensionconfig.Interface r5;
        synchronized (monitor()) {
            check_orphaned();
            r5 = (Extensionconfig.Interface) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (r5 == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return r5;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig
    public void setInterfaceArray(int i2, Extensionconfig.Interface r4) throws Throwable {
        generatedSetterHelperImpl(r4, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
