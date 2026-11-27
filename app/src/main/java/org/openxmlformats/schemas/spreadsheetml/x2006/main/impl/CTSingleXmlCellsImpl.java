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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells;

/* loaded from: classes2.dex */
public class CTSingleXmlCellsImpl extends XmlComplexContentImpl implements CTSingleXmlCells {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "singleXmlCell")};
    private static final long serialVersionUID = 1;

    public CTSingleXmlCellsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public CTSingleXmlCell addNewSingleXmlCell() {
        CTSingleXmlCell cTSingleXmlCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSingleXmlCell = (CTSingleXmlCell) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSingleXmlCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public CTSingleXmlCell[] getSingleXmlCellArray() {
        return (CTSingleXmlCell[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTSingleXmlCell[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public List<CTSingleXmlCell> getSingleXmlCellList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.f
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSingleXmlCellArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.gj
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSingleXmlCellArray(((Integer) obj).intValue(), (CTSingleXmlCell) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.o4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSingleXmlCell(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ea
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSingleXmlCell(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.r3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSingleXmlCellArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public CTSingleXmlCell insertNewSingleXmlCell(int i2) {
        CTSingleXmlCell cTSingleXmlCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSingleXmlCell = (CTSingleXmlCell) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTSingleXmlCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public void removeSingleXmlCell(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public void setSingleXmlCellArray(CTSingleXmlCell[] cTSingleXmlCellArr) {
        check_orphaned();
        arraySetterHelper(cTSingleXmlCellArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public int sizeOfSingleXmlCellArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public CTSingleXmlCell getSingleXmlCellArray(int i2) {
        CTSingleXmlCell cTSingleXmlCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSingleXmlCell = (CTSingleXmlCell) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTSingleXmlCell == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSingleXmlCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public void setSingleXmlCellArray(int i2, CTSingleXmlCell cTSingleXmlCell) throws Throwable {
        generatedSetterHelperImpl(cTSingleXmlCell, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
