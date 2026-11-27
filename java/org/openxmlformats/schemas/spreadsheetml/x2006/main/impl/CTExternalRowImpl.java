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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow;

/* loaded from: classes2.dex */
public class CTExternalRowImpl extends XmlComplexContentImpl implements CTExternalRow {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cell"), new QName("", "r")};
    private static final long serialVersionUID = 1;

    public CTExternalRowImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public CTExternalCell addNewCell() {
        CTExternalCell cTExternalCell;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalCell = (CTExternalCell) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExternalCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public CTExternalCell[] getCellArray() {
        return (CTExternalCell[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTExternalCell[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public List<CTExternalCell> getCellList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.q2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCellArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.g0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCellArray(((Integer) obj).intValue(), (CTExternalCell) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.fb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCell(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ki
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCell(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.b2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCellArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public long getR() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public CTExternalCell insertNewCell(int i2) {
        CTExternalCell cTExternalCell;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalCell = (CTExternalCell) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTExternalCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public void removeCell(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public void setCellArray(CTExternalCell[] cTExternalCellArr) {
        check_orphaned();
        arraySetterHelper(cTExternalCellArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public void setR(long j2) {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public int sizeOfCellArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public XmlUnsignedInt xgetR() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public void xsetR(XmlUnsignedInt xmlUnsignedInt) {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public CTExternalCell getCellArray(int i2) {
        CTExternalCell cTExternalCell;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalCell = (CTExternalCell) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTExternalCell == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTExternalCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow
    public void setCellArray(int i2, CTExternalCell cTExternalCell) throws Throwable {
        generatedSetterHelperImpl(cTExternalCell, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
