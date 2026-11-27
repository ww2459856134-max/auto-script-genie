package org.apache.xmlbeans.impl.xb.xsdownload.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.JavaListObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry;

/* loaded from: classes2.dex */
public class DownloadedSchemaEntryImpl extends XmlComplexContentImpl implements DownloadedSchemaEntry {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "filename"), new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "sha1"), new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "schemaLocation"), new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "namespace")};
    private static final long serialVersionUID = 1;

    public DownloadedSchemaEntryImpl(SchemaType schemaType) {
        super(schemaType);
    }

    static /* synthetic */ String[] C(int i2) {
        return new String[i2];
    }

    static /* synthetic */ XmlAnyURI[] D(int i2) {
        return new XmlAnyURI[i2];
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI addNewSchemaLocation() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return xmlAnyURI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void addSchemaLocation(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[2])).setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String getFilename() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String getNamespace() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String[] getSchemaLocationArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[2], new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdownload.impl.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((SimpleValue) obj).getStringValue();
            }
        }, new IntFunction() { // from class: org.apache.xmlbeans.impl.xb.xsdownload.impl.d
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return DownloadedSchemaEntryImpl.C(i2);
            }
        });
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public List<String> getSchemaLocationList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdownload.impl.e
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSchemaLocationArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdownload.impl.p
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setSchemaLocationArray(((Integer) obj).intValue(), (String) obj2);
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdownload.impl.j
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertSchemaLocation(((Integer) obj).intValue(), (String) obj2);
                }
            }, new h(this), new a(this));
        }
        return javaListObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String getSha1() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI insertNewSchemaLocation(int i2) {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return xmlAnyURI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void insertSchemaLocation(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[2], i2)).setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public boolean isSetNamespace() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void removeSchemaLocation(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setFilename(String str) {
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

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setNamespace(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[3], 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[3]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setSchemaLocationArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[2]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setSha1(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[1], 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[1]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public int sizeOfSchemaLocationArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void unsetNamespace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlToken xgetFilename() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_element_user(PROPERTY_QNAME[0], 0);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI xgetNamespace() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_element_user(PROPERTY_QNAME[3], 0);
        }
        return xmlAnyURI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI[] xgetSchemaLocationArray() {
        return (XmlAnyURI[]) xgetArray(PROPERTY_QNAME[2], new IntFunction() { // from class: org.apache.xmlbeans.impl.xb.xsdownload.impl.c
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return DownloadedSchemaEntryImpl.D(i2);
            }
        });
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public List<XmlAnyURI> xgetSchemaLocationList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdownload.impl.i
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetSchemaLocationArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdownload.impl.f
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetSchemaLocationArray(((Integer) obj).intValue(), (XmlAnyURI) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdownload.impl.m
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSchemaLocation(((Integer) obj).intValue());
                }
            }, new h(this), new a(this));
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlToken xgetSha1() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_element_user(PROPERTY_QNAME[1], 0);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetFilename(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlToken xmlToken2 = (XmlToken) typeStore.find_element_user(qNameArr[0], 0);
            if (xmlToken2 == null) {
                xmlToken2 = (XmlToken) get_store().add_element_user(qNameArr[0]);
            }
            xmlToken2.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetNamespace(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_element_user(qNameArr[3], 0);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_element_user(qNameArr[3]);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetSchemaLocationArray(XmlAnyURI[] xmlAnyURIArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlAnyURIArr, PROPERTY_QNAME[2]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetSha1(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlToken xmlToken2 = (XmlToken) typeStore.find_element_user(qNameArr[1], 0);
            if (xmlToken2 == null) {
                xmlToken2 = (XmlToken) get_store().add_element_user(qNameArr[1]);
            }
            xmlToken2.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String getSchemaLocationArray(int i2) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI xgetSchemaLocationArray(int i2) {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (xmlAnyURI == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlAnyURI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setSchemaLocationArray(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (simpleValue != null) {
                simpleValue.setStringValue(str);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetSchemaLocationArray(int i2, XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (xmlAnyURI2 != null) {
                xmlAnyURI2.set(xmlAnyURI);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }
}
