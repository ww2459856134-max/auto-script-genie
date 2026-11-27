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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItem;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems;

/* loaded from: classes2.dex */
public class CTItemsImpl extends XmlComplexContentImpl implements CTItems {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "item"), new QName("", "count")};
    private static final long serialVersionUID = 1;

    public CTItemsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public CTItem addNewItem() {
        CTItem cTItem;
        synchronized (monitor()) {
            check_orphaned();
            cTItem = (CTItem) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTItem;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public long getCount() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public CTItem[] getItemArray() {
        return (CTItem[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTItem[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public List<CTItem> getItemList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.c9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getItemArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.bh
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setItemArray(((Integer) obj).intValue(), (CTItem) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.mc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewItem(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.pd
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeItem(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ni
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfItemArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public CTItem insertNewItem(int i2) {
        CTItem cTItem;
        synchronized (monitor()) {
            check_orphaned();
            cTItem = (CTItem) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTItem;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public void removeItem(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public void setItemArray(CTItem[] cTItemArr) {
        check_orphaned();
        arraySetterHelper(cTItemArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public int sizeOfItemArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[1]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public CTItem getItemArray(int i2) {
        CTItem cTItem;
        synchronized (monitor()) {
            check_orphaned();
            cTItem = (CTItem) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTItem == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTItem;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public void setItemArray(int i2, CTItem cTItem) throws Throwable {
        generatedSetterHelperImpl(cTItem, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
