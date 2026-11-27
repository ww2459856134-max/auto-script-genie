package org.apache.xmlbeans.impl.xb.ltgfmt.impl;

import com.tencent.open.SocialConstants;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;

/* loaded from: classes2.dex */
public class TestCaseImpl extends XmlComplexContentImpl implements TestCase {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", SocialConstants.PARAM_COMMENT), new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "files"), new QName("", "id"), new QName("", "origin"), new QName("", "modified")};
    private static final long serialVersionUID = 1;

    public static class FilesImpl extends XmlComplexContentImpl implements TestCase.Files {
        private static final QName[] PROPERTY_QNAME = {new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "file")};
        private static final long serialVersionUID = 1;

        public FilesImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public FileDesc addNewFile() {
            FileDesc fileDesc;
            synchronized (monitor()) {
                check_orphaned();
                fileDesc = (FileDesc) get_store().add_element_user(PROPERTY_QNAME[0]);
            }
            return fileDesc;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public FileDesc[] getFileArray() {
            return (FileDesc[]) getXmlObjectArray(PROPERTY_QNAME[0], new FileDesc[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public List<FileDesc> getFileList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.ltgfmt.impl.d
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getFileArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.ltgfmt.impl.c
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setFileArray(((Integer) obj).intValue(), (FileDesc) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.ltgfmt.impl.h
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewFile(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.ltgfmt.impl.f
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeFile(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.ltgfmt.impl.b
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfFileArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public FileDesc insertNewFile(int i2) {
            FileDesc fileDesc;
            synchronized (monitor()) {
                check_orphaned();
                fileDesc = (FileDesc) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
            }
            return fileDesc;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public void removeFile(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[0], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public void setFileArray(FileDesc[] fileDescArr) {
            check_orphaned();
            arraySetterHelper(fileDescArr, PROPERTY_QNAME[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public int sizeOfFileArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public FileDesc getFileArray(int i2) {
            FileDesc fileDesc;
            synchronized (monitor()) {
                check_orphaned();
                fileDesc = (FileDesc) get_store().find_element_user(PROPERTY_QNAME[0], i2);
                if (fileDesc == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return fileDesc;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public void setFileArray(int i2, FileDesc fileDesc) throws Throwable {
            generatedSetterHelperImpl(fileDesc, PROPERTY_QNAME[0], i2, (short) 2);
        }
    }

    public TestCaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public TestCase.Files addNewFiles() {
        TestCase.Files files;
        synchronized (monitor()) {
            check_orphaned();
            files = (TestCase.Files) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return files;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public String getDescription() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public TestCase.Files getFiles() {
        TestCase.Files files;
        synchronized (monitor()) {
            check_orphaned();
            files = (TestCase.Files) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (files == null) {
                files = null;
            }
        }
        return files;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public String getId() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean getModified() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[4]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public String getOrigin() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean isSetDescription() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean isSetModified() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean isSetOrigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[3]) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setDescription(String str) {
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

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setFiles(TestCase.Files files) throws Throwable {
        generatedSetterHelperImpl(files, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
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

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setModified(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setOrigin(String str) {
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

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void unsetDescription() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[2]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void unsetModified() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void unsetOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[3]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public XmlString xgetDescription() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[0], 0);
        }
        return xmlString;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public XmlID xgetId() {
        XmlID xmlID;
        synchronized (monitor()) {
            check_orphaned();
            xmlID = (XmlID) get_store().find_attribute_user(PROPERTY_QNAME[2]);
        }
        return xmlID;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public XmlBoolean xgetModified() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[4]);
        }
        return xmlBoolean;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public XmlToken xgetOrigin() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void xsetDescription(XmlString xmlString) {
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

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
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

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void xsetModified(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[4]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[4]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void xsetOrigin(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qNameArr[3]);
            if (xmlToken2 == null) {
                xmlToken2 = (XmlToken) get_store().add_attribute_user(qNameArr[3]);
            }
            xmlToken2.set(xmlToken);
        }
    }
}
