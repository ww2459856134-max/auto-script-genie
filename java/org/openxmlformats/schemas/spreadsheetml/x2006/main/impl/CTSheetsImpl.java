package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets;

/* loaded from: classes2.dex */
public class CTSheetsImpl extends XmlComplexContentImpl implements CTSheets {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheet")};
    private static final long serialVersionUID = 1;

    public CTSheetsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public CTSheet addNewSheet() {
        CTSheet cTSheet;
        synchronized (monitor()) {
            check_orphaned();
            cTSheet = (CTSheet) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public CTSheet[] getSheetArray() {
        return (CTSheet[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTSheet[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public List<CTSheet> getSheetList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.mf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSheetArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.i6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSheetArray(((Integer) obj).intValue(), (CTSheet) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.lh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSheet(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.v3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSheet(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.y8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSheetArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public CTSheet insertNewSheet(int i2) {
        CTSheet cTSheet;
        synchronized (monitor()) {
            check_orphaned();
            cTSheet = (CTSheet) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTSheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public void removeSheet(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public void setSheetArray(CTSheet[] cTSheetArr) {
        check_orphaned();
        arraySetterHelper(cTSheetArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public int sizeOfSheetArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public CTSheet getSheetArray(int i2) {
        CTSheet cTSheet;
        synchronized (monitor()) {
            check_orphaned();
            cTSheet = (CTSheet) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTSheet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public void setSheetArray(int i2, CTSheet cTSheet) throws Throwable {
        generatedSetterHelperImpl(cTSheet, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
