package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STGuid;

/* loaded from: classes2.dex */
public class CTTableStyleListImpl extends XmlComplexContentImpl implements CTTableStyleList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tblStyle"), new QName("", "def")};
    private static final long serialVersionUID = 1;

    public CTTableStyleListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public CTTableStyle addNewTblStyle() {
        CTTableStyle cTTableStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyle = (CTTableStyle) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTableStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public String getDef() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public CTTableStyle[] getTblStyleArray() {
        return (CTTableStyle[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTTableStyle[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public List<CTTableStyle> getTblStyleList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.fn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTblStyleArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.i4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTblStyleArray(((Integer) obj).intValue(), (CTTableStyle) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTblStyle(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.bc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTblStyle(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ay
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTblStyleArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public CTTableStyle insertNewTblStyle(int i2) {
        CTTableStyle cTTableStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyle = (CTTableStyle) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTTableStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public void removeTblStyle(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public void setDef(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public void setTblStyleArray(CTTableStyle[] cTTableStyleArr) {
        check_orphaned();
        arraySetterHelper(cTTableStyleArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public int sizeOfTblStyleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public STGuid xgetDef() {
        STGuid sTGuid;
        synchronized (monitor()) {
            check_orphaned();
            sTGuid = (STGuid) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return sTGuid;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public void xsetDef(STGuid sTGuid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STGuid sTGuid2 = (STGuid) typeStore.find_attribute_user(qNameArr[1]);
            if (sTGuid2 == null) {
                sTGuid2 = (STGuid) get_store().add_attribute_user(qNameArr[1]);
            }
            sTGuid2.set(sTGuid);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public CTTableStyle getTblStyleArray(int i2) {
        CTTableStyle cTTableStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyle = (CTTableStyle) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTTableStyle == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTableStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public void setTblStyleArray(int i2, CTTableStyle cTTableStyle) throws Throwable {
        generatedSetterHelperImpl(cTTableStyle, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
