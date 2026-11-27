package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

/* loaded from: classes2.dex */
public class CTOfficeArtExtensionListImpl extends XmlComplexContentImpl implements CTOfficeArtExtensionList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ext")};
    private static final long serialVersionUID = 1;

    public CTOfficeArtExtensionListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public CTOfficeArtExtension addNewExt() {
        CTOfficeArtExtension cTOfficeArtExtension;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtension = (CTOfficeArtExtension) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTOfficeArtExtension;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public CTOfficeArtExtension[] getExtArray() {
        return (CTOfficeArtExtension[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTOfficeArtExtension[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public List<CTOfficeArtExtension> getExtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m20
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getExtArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.bu
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setExtArray(((Integer) obj).intValue(), (CTOfficeArtExtension) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lm
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewExt(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ac
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeExt(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q80
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfExtArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public CTOfficeArtExtension insertNewExt(int i2) {
        CTOfficeArtExtension cTOfficeArtExtension;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtension = (CTOfficeArtExtension) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTOfficeArtExtension;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public void removeExt(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public void setExtArray(CTOfficeArtExtension[] cTOfficeArtExtensionArr) {
        check_orphaned();
        arraySetterHelper(cTOfficeArtExtensionArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public int sizeOfExtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public CTOfficeArtExtension getExtArray(int i2) {
        CTOfficeArtExtension cTOfficeArtExtension;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtension = (CTOfficeArtExtension) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTOfficeArtExtension == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOfficeArtExtension;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList
    public void setExtArray(int i2, CTOfficeArtExtension cTOfficeArtExtension) throws Throwable {
        generatedSetterHelperImpl(cTOfficeArtExtension, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
