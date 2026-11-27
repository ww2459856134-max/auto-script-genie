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
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMR;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg;

/* loaded from: classes2.dex */
public class CTMRImpl extends XmlComplexContentImpl implements CTMR {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "e")};
    private static final long serialVersionUID = 1;

    public CTMRImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMR
    public CTOMathArg addNewE() {
        CTOMathArg cTOMathArg;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathArg = (CTOMathArg) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTOMathArg;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMR
    public CTOMathArg[] getEArray() {
        return (CTOMathArg[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTOMathArg[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMR
    public List<CTOMathArg> getEList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.x2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ln
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEArray(((Integer) obj).intValue(), (CTOMathArg) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.zg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewE(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.x5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeE(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.y1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMR
    public CTOMathArg insertNewE(int i2) {
        CTOMathArg cTOMathArg;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathArg = (CTOMathArg) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTOMathArg;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMR
    public void removeE(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMR
    public void setEArray(CTOMathArg[] cTOMathArgArr) {
        check_orphaned();
        arraySetterHelper(cTOMathArgArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMR
    public int sizeOfEArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMR
    public CTOMathArg getEArray(int i2) {
        CTOMathArg cTOMathArg;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathArg = (CTOMathArg) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTOMathArg == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMathArg;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMR
    public void setEArray(int i2, CTOMathArg cTOMathArg) throws Throwable {
        generatedSetterHelperImpl(cTOMathArg, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
