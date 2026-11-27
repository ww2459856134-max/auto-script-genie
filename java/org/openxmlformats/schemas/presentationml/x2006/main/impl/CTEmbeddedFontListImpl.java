package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry;

/* loaded from: classes2.dex */
public class CTEmbeddedFontListImpl extends XmlComplexContentImpl implements CTEmbeddedFontList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "embeddedFont")};
    private static final long serialVersionUID = 1;

    public CTEmbeddedFontListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public CTEmbeddedFontListEntry addNewEmbeddedFont() {
        CTEmbeddedFontListEntry cTEmbeddedFontListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontListEntry = (CTEmbeddedFontListEntry) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTEmbeddedFontListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public CTEmbeddedFontListEntry[] getEmbeddedFontArray() {
        return (CTEmbeddedFontListEntry[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTEmbeddedFontListEntry[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public List<CTEmbeddedFontListEntry> getEmbeddedFontList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.w2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEmbeddedFontArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.v0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEmbeddedFontArray(((Integer) obj).intValue(), (CTEmbeddedFontListEntry) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.z3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEmbeddedFont(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.e1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEmbeddedFont(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.l0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEmbeddedFontArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public CTEmbeddedFontListEntry insertNewEmbeddedFont(int i2) {
        CTEmbeddedFontListEntry cTEmbeddedFontListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontListEntry = (CTEmbeddedFontListEntry) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTEmbeddedFontListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public void removeEmbeddedFont(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public void setEmbeddedFontArray(CTEmbeddedFontListEntry[] cTEmbeddedFontListEntryArr) {
        check_orphaned();
        arraySetterHelper(cTEmbeddedFontListEntryArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public int sizeOfEmbeddedFontArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public CTEmbeddedFontListEntry getEmbeddedFontArray(int i2) {
        CTEmbeddedFontListEntry cTEmbeddedFontListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontListEntry = (CTEmbeddedFontListEntry) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTEmbeddedFontListEntry == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmbeddedFontListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public void setEmbeddedFontArray(int i2, CTEmbeddedFontListEntry cTEmbeddedFontListEntry) throws Throwable {
        generatedSetterHelperImpl(cTEmbeddedFontListEntry, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
