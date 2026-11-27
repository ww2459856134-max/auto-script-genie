package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRecord;

/* loaded from: classes2.dex */
public class CTPivotCacheRecordsImpl extends XmlComplexContentImpl implements CTPivotCacheRecords {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "r"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst"), new QName("", "count")};
    private static final long serialVersionUID = 1;

    public CTPivotCacheRecordsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public CTRecord addNewR() {
        CTRecord cTRecordAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRecordAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTRecordAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public long getCount() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public CTRecord[] getRArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CTRecord[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public List<CTRecord> getRList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.dd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.w5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRArray(((Integer) obj).intValue(), (CTRecord) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.zg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewR(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.j7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeR(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.z8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public CTRecord insertNewR(int i2) {
        CTRecord cTRecordInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRecordInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTRecordInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public boolean isSetExtLst() {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void removeR(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void setCount(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
            }
            simpleValue.setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void setRArray(CTRecord[] cTRecordArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTRecordArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[2]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[2]);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void xsetCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[2]);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[2]);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public CTRecord getRArray(int i2) {
        CTRecord cTRecordFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRecordFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTRecordFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRecordFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void setRArray(int i2, CTRecord cTRecord) throws Throwable {
        generatedSetterHelperImpl(cTRecord, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
