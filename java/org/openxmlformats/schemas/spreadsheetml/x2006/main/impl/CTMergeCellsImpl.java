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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells;

/* loaded from: classes2.dex */
public class CTMergeCellsImpl extends XmlComplexContentImpl implements CTMergeCells {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "mergeCell"), new QName("", "count")};
    private static final long serialVersionUID = 1;

    public CTMergeCellsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
    public CTMergeCell addNewMergeCell() {
        CTMergeCell cTMergeCell;
        synchronized (monitor()) {
            check_orphaned();
            cTMergeCell = (CTMergeCell) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTMergeCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
    public long getCount() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
    public CTMergeCell[] getMergeCellArray() {
        return (CTMergeCell[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTMergeCell[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
    public List<CTMergeCell> getMergeCellList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.uj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMergeCellArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.s7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMergeCellArray(((Integer) obj).intValue(), (CTMergeCell) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.w9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMergeCell(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.j3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMergeCell(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.xi
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMergeCellArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
    public CTMergeCell insertNewMergeCell(int i2) {
        CTMergeCell cTMergeCell;
        synchronized (monitor()) {
            check_orphaned();
            cTMergeCell = (CTMergeCell) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTMergeCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
    public void removeMergeCell(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
    public void setMergeCellArray(CTMergeCell[] cTMergeCellArr) {
        check_orphaned();
        arraySetterHelper(cTMergeCellArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
    public int sizeOfMergeCellArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[1]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
    public CTMergeCell getMergeCellArray(int i2) {
        CTMergeCell cTMergeCell;
        synchronized (monitor()) {
            check_orphaned();
            cTMergeCell = (CTMergeCell) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTMergeCell == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMergeCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells
    public void setMergeCellArray(int i2, CTMergeCell cTMergeCell) throws Throwable {
        generatedSetterHelperImpl(cTMergeCell, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
