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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames;

/* loaded from: classes2.dex */
public class CTExternalSheetNamesImpl extends XmlComplexContentImpl implements CTExternalSheetNames {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetName")};
    private static final long serialVersionUID = 1;

    public CTExternalSheetNamesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public CTExternalSheetName addNewSheetName() {
        CTExternalSheetName cTExternalSheetName;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetName = (CTExternalSheetName) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExternalSheetName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public CTExternalSheetName[] getSheetNameArray() {
        return (CTExternalSheetName[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTExternalSheetName[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public List<CTExternalSheetName> getSheetNameList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.i8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSheetNameArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.g9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSheetNameArray(((Integer) obj).intValue(), (CTExternalSheetName) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ed
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSheetName(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ue
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSheetName(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.qd
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSheetNameArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public CTExternalSheetName insertNewSheetName(int i2) {
        CTExternalSheetName cTExternalSheetName;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetName = (CTExternalSheetName) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTExternalSheetName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public void removeSheetName(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public void setSheetNameArray(CTExternalSheetName[] cTExternalSheetNameArr) {
        check_orphaned();
        arraySetterHelper(cTExternalSheetNameArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public int sizeOfSheetNameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public CTExternalSheetName getSheetNameArray(int i2) {
        CTExternalSheetName cTExternalSheetName;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetName = (CTExternalSheetName) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTExternalSheetName == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTExternalSheetName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public void setSheetNameArray(int i2, CTExternalSheetName cTExternalSheetName) throws Throwable {
        generatedSetterHelperImpl(cTExternalSheetName, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
