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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReference;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences;

/* loaded from: classes2.dex */
public class CTExternalReferencesImpl extends XmlComplexContentImpl implements CTExternalReferences {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "externalReference")};
    private static final long serialVersionUID = 1;

    public CTExternalReferencesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public CTExternalReference addNewExternalReference() {
        CTExternalReference cTExternalReference;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalReference = (CTExternalReference) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExternalReference;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public CTExternalReference[] getExternalReferenceArray() {
        return (CTExternalReference[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTExternalReference[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public List<CTExternalReference> getExternalReferenceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.j6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getExternalReferenceArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.zb
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setExternalReferenceArray(((Integer) obj).intValue(), (CTExternalReference) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ah
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewExternalReference(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ab
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeExternalReference(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.e5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfExternalReferenceArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public CTExternalReference insertNewExternalReference(int i2) {
        CTExternalReference cTExternalReference;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalReference = (CTExternalReference) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTExternalReference;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public void removeExternalReference(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public void setExternalReferenceArray(CTExternalReference[] cTExternalReferenceArr) {
        check_orphaned();
        arraySetterHelper(cTExternalReferenceArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public int sizeOfExternalReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public CTExternalReference getExternalReferenceArray(int i2) {
        CTExternalReference cTExternalReference;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalReference = (CTExternalReference) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTExternalReference == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTExternalReference;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences
    public void setExternalReferenceArray(int i2, CTExternalReference cTExternalReference) throws Throwable {
        generatedSetterHelperImpl(cTExternalReference, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
