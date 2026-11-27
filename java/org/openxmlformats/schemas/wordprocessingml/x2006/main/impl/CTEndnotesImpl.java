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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;

/* loaded from: classes3.dex */
public class CTEndnotesImpl extends XmlComplexContentImpl implements CTEndnotes {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnote")};
    private static final long serialVersionUID = 1;

    public CTEndnotesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public CTFtnEdn addNewEndnote() {
        CTFtnEdn cTFtnEdn;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdn = (CTFtnEdn) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTFtnEdn;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public CTFtnEdn[] getEndnoteArray() {
        return (CTFtnEdn[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTFtnEdn[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public List<CTFtnEdn> getEndnoteList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xb2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEndnoteArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.us1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEndnoteArray(((Integer) obj).intValue(), (CTFtnEdn) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.cv
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEndnote(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.v01
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEndnote(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.r51
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEndnoteArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public CTFtnEdn insertNewEndnote(int i2) {
        CTFtnEdn cTFtnEdn;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdn = (CTFtnEdn) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTFtnEdn;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public void removeEndnote(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public void setEndnoteArray(CTFtnEdn[] cTFtnEdnArr) {
        check_orphaned();
        arraySetterHelper(cTFtnEdnArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public int sizeOfEndnoteArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public CTFtnEdn getEndnoteArray(int i2) {
        CTFtnEdn cTFtnEdn;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdn = (CTFtnEdn) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTFtnEdn == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFtnEdn;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public void setEndnoteArray(int i2, CTFtnEdn cTFtnEdn) throws Throwable {
        generatedSetterHelperImpl(cTFtnEdn, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
