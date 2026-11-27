package org.apache.xmlbeans.impl.xb.substwsdl.impl;

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
import org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument;
import org.apache.xmlbeans.impl.xb.substwsdl.TImport;

/* loaded from: classes2.dex */
public class DefinitionsDocumentImpl extends XmlComplexContentImpl implements DefinitionsDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "definitions")};
    private static final long serialVersionUID = 1;

    public static class DefinitionsImpl extends XmlComplexContentImpl implements DefinitionsDocument.Definitions {
        private static final QName[] PROPERTY_QNAME = {new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "import"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "types"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "message"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "binding"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "portType"), new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "service")};
        private static final long serialVersionUID = 1;

        public DefinitionsImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewBinding() {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().add_element_user(PROPERTY_QNAME[3]);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public TImport addNewImport() {
            TImport tImport;
            synchronized (monitor()) {
                check_orphaned();
                tImport = (TImport) get_store().add_element_user(PROPERTY_QNAME[0]);
            }
            return tImport;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewMessage() {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().add_element_user(PROPERTY_QNAME[2]);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewPortType() {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().add_element_user(PROPERTY_QNAME[4]);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewService() {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().add_element_user(PROPERTY_QNAME[5]);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewTypes() {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().add_element_user(PROPERTY_QNAME[1]);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getBindingArray() {
            return getXmlObjectArray(PROPERTY_QNAME[3], new XmlObject[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public List<XmlObject> getBindingList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.h
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getBindingArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.m
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setBindingArray(((Integer) obj).intValue(), (XmlObject) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.r
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewBinding(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.d
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeBinding(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.x
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfBindingArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public TImport[] getImportArray() {
            return (TImport[]) getXmlObjectArray(PROPERTY_QNAME[0], new TImport[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public List<TImport> getImportList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.j
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getImportArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.f
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setImportArray(((Integer) obj).intValue(), (TImport) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.u
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewImport(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.q
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeImport(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.a0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfImportArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getMessageArray() {
            return getXmlObjectArray(PROPERTY_QNAME[2], new XmlObject[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public List<XmlObject> getMessageList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.t
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getMessageArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.b
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setMessageArray(((Integer) obj).intValue(), (XmlObject) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.w
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewMessage(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.a
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeMessage(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.d0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfMessageArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getPortTypeArray() {
            return getXmlObjectArray(PROPERTY_QNAME[4], new XmlObject[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public List<XmlObject> getPortTypeList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.e
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getPortTypeArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.v
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setPortTypeArray(((Integer) obj).intValue(), (XmlObject) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.c0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewPortType(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.y
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removePortType(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.i
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfPortTypeArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getServiceArray() {
            return getXmlObjectArray(PROPERTY_QNAME[5], new XmlObject[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public List<XmlObject> getServiceList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.g
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getServiceArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.s
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setServiceArray(((Integer) obj).intValue(), (XmlObject) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.k
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewService(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.c
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeService(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.z
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfServiceArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getTypesArray() {
            return getXmlObjectArray(PROPERTY_QNAME[1], new XmlObject[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public List<XmlObject> getTypesList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.l
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getTypesArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.n
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setTypesArray(((Integer) obj).intValue(), (XmlObject) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.o
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewTypes(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.p
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeTypes(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.substwsdl.impl.b0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfTypesArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewBinding(int i2) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public TImport insertNewImport(int i2) {
            TImport tImport;
            synchronized (monitor()) {
                check_orphaned();
                tImport = (TImport) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
            }
            return tImport;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewMessage(int i2) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewPortType(int i2) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewService(int i2) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewTypes(int i2) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeBinding(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[3], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeImport(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[0], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeMessage(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[2], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removePortType(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[4], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeService(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[5], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeTypes(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[1], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setBindingArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, PROPERTY_QNAME[3]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setImportArray(TImport[] tImportArr) {
            check_orphaned();
            arraySetterHelper(tImportArr, PROPERTY_QNAME[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setMessageArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, PROPERTY_QNAME[2]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setPortTypeArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, PROPERTY_QNAME[4]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setServiceArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, PROPERTY_QNAME[5]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setTypesArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, PROPERTY_QNAME[1]);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfBindingArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfImportArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfMessageArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfPortTypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfServiceArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfTypesArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getBindingArray(int i2) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().find_element_user(PROPERTY_QNAME[3], i2);
                if (xmlObject == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public TImport getImportArray(int i2) {
            TImport tImport;
            synchronized (monitor()) {
                check_orphaned();
                tImport = (TImport) get_store().find_element_user(PROPERTY_QNAME[0], i2);
                if (tImport == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return tImport;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getMessageArray(int i2) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().find_element_user(PROPERTY_QNAME[2], i2);
                if (xmlObject == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getPortTypeArray(int i2) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().find_element_user(PROPERTY_QNAME[4], i2);
                if (xmlObject == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getServiceArray(int i2) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().find_element_user(PROPERTY_QNAME[5], i2);
                if (xmlObject == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getTypesArray(int i2) {
            XmlObject xmlObject;
            synchronized (monitor()) {
                check_orphaned();
                xmlObject = (XmlObject) get_store().find_element_user(PROPERTY_QNAME[1], i2);
                if (xmlObject == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setBindingArray(int i2, XmlObject xmlObject) throws Throwable {
            generatedSetterHelperImpl(xmlObject, PROPERTY_QNAME[3], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setImportArray(int i2, TImport tImport) throws Throwable {
            generatedSetterHelperImpl(tImport, PROPERTY_QNAME[0], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setMessageArray(int i2, XmlObject xmlObject) throws Throwable {
            generatedSetterHelperImpl(xmlObject, PROPERTY_QNAME[2], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setPortTypeArray(int i2, XmlObject xmlObject) throws Throwable {
            generatedSetterHelperImpl(xmlObject, PROPERTY_QNAME[4], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setServiceArray(int i2, XmlObject xmlObject) throws Throwable {
            generatedSetterHelperImpl(xmlObject, PROPERTY_QNAME[5], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setTypesArray(int i2, XmlObject xmlObject) throws Throwable {
            generatedSetterHelperImpl(xmlObject, PROPERTY_QNAME[1], i2, (short) 2);
        }
    }

    public DefinitionsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument
    public DefinitionsDocument.Definitions addNewDefinitions() {
        DefinitionsDocument.Definitions definitions;
        synchronized (monitor()) {
            check_orphaned();
            definitions = (DefinitionsDocument.Definitions) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return definitions;
    }

    @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument
    public DefinitionsDocument.Definitions getDefinitions() {
        DefinitionsDocument.Definitions definitions;
        synchronized (monitor()) {
            check_orphaned();
            definitions = (DefinitionsDocument.Definitions) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (definitions == null) {
                definitions = null;
            }
        }
        return definitions;
    }

    @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument
    public void setDefinitions(DefinitionsDocument.Definitions definitions) throws Throwable {
        generatedSetterHelperImpl(definitions, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
