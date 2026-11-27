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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet;

/* loaded from: classes2.dex */
public class CTExternalSheetDataSetImpl extends XmlComplexContentImpl implements CTExternalSheetDataSet {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetData")};
    private static final long serialVersionUID = 1;

    public CTExternalSheetDataSetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public CTExternalSheetData addNewSheetData() {
        CTExternalSheetData cTExternalSheetData;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetData = (CTExternalSheetData) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExternalSheetData;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public CTExternalSheetData[] getSheetDataArray() {
        return (CTExternalSheetData[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTExternalSheetData[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public List<CTExternalSheetData> getSheetDataList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ja
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSheetDataArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ob
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSheetDataArray(((Integer) obj).intValue(), (CTExternalSheetData) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.vg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSheetData(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.eb
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSheetData(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.df
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSheetDataArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public CTExternalSheetData insertNewSheetData(int i2) {
        CTExternalSheetData cTExternalSheetData;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetData = (CTExternalSheetData) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTExternalSheetData;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public void removeSheetData(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public void setSheetDataArray(CTExternalSheetData[] cTExternalSheetDataArr) {
        check_orphaned();
        arraySetterHelper(cTExternalSheetDataArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public int sizeOfSheetDataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public CTExternalSheetData getSheetDataArray(int i2) {
        CTExternalSheetData cTExternalSheetData;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetData = (CTExternalSheetData) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTExternalSheetData == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTExternalSheetData;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public void setSheetDataArray(int i2, CTExternalSheetData cTExternalSheetData) throws Throwable {
        generatedSetterHelperImpl(cTExternalSheetData, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
