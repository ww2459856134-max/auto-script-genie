package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;

/* loaded from: classes2.dex */
public class AnnotationDocumentImpl extends XmlComplexContentImpl implements AnnotationDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "annotation")};
    private static final long serialVersionUID = 1;

    public static class AnnotationImpl extends OpenAttrsImpl implements AnnotationDocument.Annotation {
        private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "appinfo"), new QName("http://www.w3.org/2001/XMLSchema", "documentation"), new QName("", "id")};
        private static final long serialVersionUID = 1;

        public AnnotationImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public AppinfoDocument.Appinfo addNewAppinfo() {
            AppinfoDocument.Appinfo appinfo;
            synchronized (monitor()) {
                check_orphaned();
                appinfo = (AppinfoDocument.Appinfo) get_store().add_element_user(PROPERTY_QNAME[0]);
            }
            return appinfo;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public DocumentationDocument.Documentation addNewDocumentation() {
            DocumentationDocument.Documentation documentation;
            synchronized (monitor()) {
                check_orphaned();
                documentation = (DocumentationDocument.Documentation) get_store().add_element_user(PROPERTY_QNAME[1]);
            }
            return documentation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public AppinfoDocument.Appinfo[] getAppinfoArray() {
            return (AppinfoDocument.Appinfo[]) getXmlObjectArray(PROPERTY_QNAME[0], new AppinfoDocument.Appinfo[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public List<AppinfoDocument.Appinfo> getAppinfoList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.n2
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getAppinfoArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.q
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setAppinfoArray(((Integer) obj).intValue(), (AppinfoDocument.Appinfo) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.f9
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewAppinfo(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.bb
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeAppinfo(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.v3
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfAppinfoArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public DocumentationDocument.Documentation[] getDocumentationArray() {
            return (DocumentationDocument.Documentation[]) getXmlObjectArray(PROPERTY_QNAME[1], new DocumentationDocument.Documentation[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public List<DocumentationDocument.Documentation> getDocumentationList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.m2
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getDocumentationArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.f
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setDocumentationArray(((Integer) obj).intValue(), (DocumentationDocument.Documentation) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.g
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewDocumentation(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.n
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeDocumentation(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.pa
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfDocumentationArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public String getId() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public AppinfoDocument.Appinfo insertNewAppinfo(int i2) {
            AppinfoDocument.Appinfo appinfo;
            synchronized (monitor()) {
                check_orphaned();
                appinfo = (AppinfoDocument.Appinfo) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
            }
            return appinfo;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public DocumentationDocument.Documentation insertNewDocumentation(int i2) {
            DocumentationDocument.Documentation documentation;
            synchronized (monitor()) {
                check_orphaned();
                documentation = (DocumentationDocument.Documentation) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
            }
            return documentation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public boolean isSetId() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void removeAppinfo(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[0], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void removeDocumentation(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[1], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setAppinfoArray(AppinfoDocument.Appinfo[] appinfoArr) {
            check_orphaned();
            arraySetterHelper(appinfoArr, PROPERTY_QNAME[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setDocumentationArray(DocumentationDocument.Documentation[] documentationArr) {
            check_orphaned();
            arraySetterHelper(documentationArr, PROPERTY_QNAME[1]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setId(String str) {
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

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public int sizeOfAppinfoArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public int sizeOfDocumentationArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void unsetId() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[2]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public XmlID xgetId() {
            XmlID xmlID;
            synchronized (monitor()) {
                check_orphaned();
                xmlID = (XmlID) get_store().find_attribute_user(PROPERTY_QNAME[2]);
            }
            return xmlID;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void xsetId(XmlID xmlID) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlID xmlID2 = (XmlID) typeStore.find_attribute_user(qNameArr[2]);
                if (xmlID2 == null) {
                    xmlID2 = (XmlID) get_store().add_attribute_user(qNameArr[2]);
                }
                xmlID2.set(xmlID);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public AppinfoDocument.Appinfo getAppinfoArray(int i2) {
            AppinfoDocument.Appinfo appinfo;
            synchronized (monitor()) {
                check_orphaned();
                appinfo = (AppinfoDocument.Appinfo) get_store().find_element_user(PROPERTY_QNAME[0], i2);
                if (appinfo == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return appinfo;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public DocumentationDocument.Documentation getDocumentationArray(int i2) {
            DocumentationDocument.Documentation documentation;
            synchronized (monitor()) {
                check_orphaned();
                documentation = (DocumentationDocument.Documentation) get_store().find_element_user(PROPERTY_QNAME[1], i2);
                if (documentation == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return documentation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setAppinfoArray(int i2, AppinfoDocument.Appinfo appinfo) throws Throwable {
            generatedSetterHelperImpl(appinfo, PROPERTY_QNAME[0], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setDocumentationArray(int i2, DocumentationDocument.Documentation documentation) throws Throwable {
            generatedSetterHelperImpl(documentation, PROPERTY_QNAME[1], i2, (short) 2);
        }
    }

    public AnnotationDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument
    public AnnotationDocument.Annotation addNewAnnotation() {
        AnnotationDocument.Annotation annotation;
        synchronized (monitor()) {
            check_orphaned();
            annotation = (AnnotationDocument.Annotation) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return annotation;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument
    public AnnotationDocument.Annotation getAnnotation() {
        AnnotationDocument.Annotation annotation;
        synchronized (monitor()) {
            check_orphaned();
            annotation = (AnnotationDocument.Annotation) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (annotation == null) {
                annotation = null;
            }
        }
        return annotation;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument
    public void setAnnotation(AnnotationDocument.Annotation annotation) throws Throwable {
        generatedSetterHelperImpl(annotation, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
