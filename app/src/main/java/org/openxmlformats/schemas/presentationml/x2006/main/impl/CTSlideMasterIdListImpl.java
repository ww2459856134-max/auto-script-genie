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
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;

/* loaded from: classes2.dex */
public class CTSlideMasterIdListImpl extends XmlComplexContentImpl implements CTSlideMasterIdList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sldMasterId")};
    private static final long serialVersionUID = 1;

    public CTSlideMasterIdListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public CTSlideMasterIdListEntry addNewSldMasterId() {
        CTSlideMasterIdListEntry cTSlideMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSlideMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public CTSlideMasterIdListEntry[] getSldMasterIdArray() {
        return (CTSlideMasterIdListEntry[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTSlideMasterIdListEntry[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public List<CTSlideMasterIdListEntry> getSldMasterIdList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.t0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSldMasterIdArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.s2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSldMasterIdArray(((Integer) obj).intValue(), (CTSlideMasterIdListEntry) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.p3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSldMasterId(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.w
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSldMasterId(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.b4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSldMasterIdArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public CTSlideMasterIdListEntry insertNewSldMasterId(int i2) {
        CTSlideMasterIdListEntry cTSlideMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTSlideMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public void removeSldMasterId(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public void setSldMasterIdArray(CTSlideMasterIdListEntry[] cTSlideMasterIdListEntryArr) {
        check_orphaned();
        arraySetterHelper(cTSlideMasterIdListEntryArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public int sizeOfSldMasterIdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public CTSlideMasterIdListEntry getSldMasterIdArray(int i2) {
        CTSlideMasterIdListEntry cTSlideMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTSlideMasterIdListEntry == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSlideMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public void setSldMasterIdArray(int i2, CTSlideMasterIdListEntry cTSlideMasterIdListEntry) throws Throwable {
        generatedSetterHelperImpl(cTSlideMasterIdListEntry, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
