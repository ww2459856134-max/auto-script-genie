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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;

/* loaded from: classes3.dex */
public class CTCustomXmlPrImpl extends XmlComplexContentImpl implements CTCustomXmlPr {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "placeholder"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "attr")};
    private static final long serialVersionUID = 1;

    public CTCustomXmlPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public CTAttr addNewAttr() {
        CTAttr cTAttr;
        synchronized (monitor()) {
            check_orphaned();
            cTAttr = (CTAttr) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTAttr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public CTString addNewPlaceholder() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public CTAttr[] getAttrArray() {
        return (CTAttr[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTAttr[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public List<CTAttr> getAttrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vk0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAttrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.c50
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAttrArray(((Integer) obj).intValue(), (CTAttr) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qm2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAttr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qs2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAttr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lh2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAttrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public CTString getPlaceholder() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public CTAttr insertNewAttr(int i2) {
        CTAttr cTAttr;
        synchronized (monitor()) {
            check_orphaned();
            cTAttr = (CTAttr) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTAttr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public boolean isSetPlaceholder() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public void removeAttr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public void setAttrArray(CTAttr[] cTAttrArr) {
        check_orphaned();
        arraySetterHelper(cTAttrArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public void setPlaceholder(CTString cTString) throws Throwable {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public int sizeOfAttrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public void unsetPlaceholder() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public CTAttr getAttrArray(int i2) {
        CTAttr cTAttr;
        synchronized (monitor()) {
            check_orphaned();
            cTAttr = (CTAttr) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTAttr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAttr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlPr
    public void setAttrArray(int i2, CTAttr cTAttr) throws Throwable {
        generatedSetterHelperImpl(cTAttr, PROPERTY_QNAME[1], i2, (short) 2);
    }
}
