package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAttr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr;

/* loaded from: classes3.dex */
public class CTSmartTagPrImpl extends XmlComplexContentImpl implements CTSmartTagPr {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "attr")};
    private static final long serialVersionUID = 1;

    public CTSmartTagPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public CTAttr addNewAttr() {
        CTAttr cTAttr;
        synchronized (monitor()) {
            check_orphaned();
            cTAttr = (CTAttr) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTAttr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public CTAttr[] getAttrArray() {
        return (CTAttr[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTAttr[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public List<CTAttr> getAttrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ri1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAttrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h62
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAttrArray(((Integer) obj).intValue(), (CTAttr) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qk0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAttr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ct2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAttr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jm
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAttrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public CTAttr insertNewAttr(int i2) {
        CTAttr cTAttr;
        synchronized (monitor()) {
            check_orphaned();
            cTAttr = (CTAttr) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTAttr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public void removeAttr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public void setAttrArray(CTAttr[] cTAttrArr) {
        check_orphaned();
        arraySetterHelper(cTAttrArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public int sizeOfAttrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public CTAttr getAttrArray(int i2) {
        CTAttr cTAttr;
        synchronized (monitor()) {
            check_orphaned();
            cTAttr = (CTAttr) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTAttr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAttr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public void setAttrArray(int i2, CTAttr cTAttr) throws Throwable {
        generatedSetterHelperImpl(cTAttr, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
