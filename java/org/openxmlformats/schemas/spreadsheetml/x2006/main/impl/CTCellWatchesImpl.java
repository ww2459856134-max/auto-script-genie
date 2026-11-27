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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatch;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches;

/* loaded from: classes2.dex */
public class CTCellWatchesImpl extends XmlComplexContentImpl implements CTCellWatches {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cellWatch")};
    private static final long serialVersionUID = 1;

    public CTCellWatchesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public CTCellWatch addNewCellWatch() {
        CTCellWatch cTCellWatch;
        synchronized (monitor()) {
            check_orphaned();
            cTCellWatch = (CTCellWatch) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCellWatch;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public CTCellWatch[] getCellWatchArray() {
        return (CTCellWatch[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTCellWatch[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public List<CTCellWatch> getCellWatchList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.zi
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCellWatchArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.uf
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCellWatchArray(((Integer) obj).intValue(), (CTCellWatch) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.q3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCellWatch(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.k5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCellWatch(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.b6
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCellWatchArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public CTCellWatch insertNewCellWatch(int i2) {
        CTCellWatch cTCellWatch;
        synchronized (monitor()) {
            check_orphaned();
            cTCellWatch = (CTCellWatch) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTCellWatch;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public void removeCellWatch(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public void setCellWatchArray(CTCellWatch[] cTCellWatchArr) {
        check_orphaned();
        arraySetterHelper(cTCellWatchArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public int sizeOfCellWatchArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public CTCellWatch getCellWatchArray(int i2) {
        CTCellWatch cTCellWatch;
        synchronized (monitor()) {
            check_orphaned();
            cTCellWatch = (CTCellWatch) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTCellWatch == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCellWatch;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public void setCellWatchArray(int i2, CTCellWatch cTCellWatch) throws Throwable {
        generatedSetterHelperImpl(cTCellWatch, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
