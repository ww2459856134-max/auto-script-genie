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
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;

/* loaded from: classes2.dex */
public class CTSlideIdListImpl extends XmlComplexContentImpl implements CTSlideIdList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sldId")};
    private static final long serialVersionUID = 1;

    public CTSlideIdListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public CTSlideIdListEntry addNewSldId() {
        CTSlideIdListEntry cTSlideIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideIdListEntry = (CTSlideIdListEntry) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSlideIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public CTSlideIdListEntry[] getSldIdArray() {
        return (CTSlideIdListEntry[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTSlideIdListEntry[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public List<CTSlideIdListEntry> getSldIdList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.z0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSldIdArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.y0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSldIdArray(((Integer) obj).intValue(), (CTSlideIdListEntry) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.j1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSldId(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.d
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSldId(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.e4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSldIdArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public CTSlideIdListEntry insertNewSldId(int i2) {
        CTSlideIdListEntry cTSlideIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideIdListEntry = (CTSlideIdListEntry) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTSlideIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public void removeSldId(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public void setSldIdArray(CTSlideIdListEntry[] cTSlideIdListEntryArr) {
        check_orphaned();
        arraySetterHelper(cTSlideIdListEntryArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public int sizeOfSldIdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public CTSlideIdListEntry getSldIdArray(int i2) {
        CTSlideIdListEntry cTSlideIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideIdListEntry = (CTSlideIdListEntry) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTSlideIdListEntry == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSlideIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList
    public void setSldIdArray(int i2, CTSlideIdListEntry cTSlideIdListEntry) throws Throwable {
        generatedSetterHelperImpl(cTSlideIdListEntry, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
