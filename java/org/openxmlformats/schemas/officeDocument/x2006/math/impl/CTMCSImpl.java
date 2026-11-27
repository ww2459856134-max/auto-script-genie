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
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMC;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS;

/* loaded from: classes2.dex */
public class CTMCSImpl extends XmlComplexContentImpl implements CTMCS {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "mc")};
    private static final long serialVersionUID = 1;

    public CTMCSImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public CTMC addNewMc() {
        CTMC ctmc;
        synchronized (monitor()) {
            check_orphaned();
            ctmc = (CTMC) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return ctmc;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public CTMC[] getMcArray() {
        return (CTMC[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTMC[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public List<CTMC> getMcList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.jn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMcArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.qe
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMcArray(((Integer) obj).intValue(), (CTMC) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.oa
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMc(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.hg
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMc(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.lk
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMcArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public CTMC insertNewMc(int i2) {
        CTMC ctmc;
        synchronized (monitor()) {
            check_orphaned();
            ctmc = (CTMC) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return ctmc;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public void removeMc(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public void setMcArray(CTMC[] ctmcArr) {
        check_orphaned();
        arraySetterHelper(ctmcArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public int sizeOfMcArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public CTMC getMcArray(int i2) {
        CTMC ctmc;
        synchronized (monitor()) {
            check_orphaned();
            ctmc = (CTMC) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (ctmc == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctmc;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public void setMcArray(int i2, CTMC ctmc) throws Throwable {
        generatedSetterHelperImpl(ctmc, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
