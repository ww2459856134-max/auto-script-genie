package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTM;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMPr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMR;

/* loaded from: classes2.dex */
public class CTMImpl extends XmlComplexContentImpl implements CTM {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "mPr"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "mr")};
    private static final long serialVersionUID = 1;

    public CTMImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public CTMPr addNewMPr() {
        CTMPr cTMPr;
        synchronized (monitor()) {
            check_orphaned();
            cTMPr = (CTMPr) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTMPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public CTMR addNewMr() {
        CTMR ctmr;
        synchronized (monitor()) {
            check_orphaned();
            ctmr = (CTMR) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return ctmr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public CTMPr getMPr() {
        CTMPr cTMPr;
        synchronized (monitor()) {
            check_orphaned();
            cTMPr = (CTMPr) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTMPr == null) {
                cTMPr = null;
            }
        }
        return cTMPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public CTMR[] getMrArray() {
        return (CTMR[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTMR[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public List<CTMR> getMrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.im
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.op
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMrArray(((Integer) obj).intValue(), (CTMR) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.zi
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.aa
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ye
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public CTMR insertNewMr(int i2) {
        CTMR ctmr;
        synchronized (monitor()) {
            check_orphaned();
            ctmr = (CTMR) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return ctmr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public boolean isSetMPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public void removeMr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public void setMPr(CTMPr cTMPr) throws Throwable {
        generatedSetterHelperImpl(cTMPr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public void setMrArray(CTMR[] ctmrArr) {
        check_orphaned();
        arraySetterHelper(ctmrArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public int sizeOfMrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public void unsetMPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public CTMR getMrArray(int i2) {
        CTMR ctmr;
        synchronized (monitor()) {
            check_orphaned();
            ctmr = (CTMR) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (ctmr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctmr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTM
    public void setMrArray(int i2, CTMR ctmr) throws Throwable {
        generatedSetterHelperImpl(ctmr, PROPERTY_QNAME[1], i2, (short) 2);
    }
}
