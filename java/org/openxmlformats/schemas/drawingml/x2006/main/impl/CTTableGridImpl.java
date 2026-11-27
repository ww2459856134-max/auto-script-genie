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
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCol;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid;

/* loaded from: classes2.dex */
public class CTTableGridImpl extends XmlComplexContentImpl implements CTTableGrid {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gridCol")};
    private static final long serialVersionUID = 1;

    public CTTableGridImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public CTTableCol addNewGridCol() {
        CTTableCol cTTableCol;
        synchronized (monitor()) {
            check_orphaned();
            cTTableCol = (CTTableCol) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTableCol;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public CTTableCol[] getGridColArray() {
        return (CTTableCol[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTTableCol[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public List<CTTableCol> getGridColList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.v3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGridColArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.w00
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGridColArray(((Integer) obj).intValue(), (CTTableCol) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.r9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGridCol(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.kl
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGridCol(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.de
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGridColArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public CTTableCol insertNewGridCol(int i2) {
        CTTableCol cTTableCol;
        synchronized (monitor()) {
            check_orphaned();
            cTTableCol = (CTTableCol) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTTableCol;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public void removeGridCol(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public void setGridColArray(CTTableCol[] cTTableColArr) {
        check_orphaned();
        arraySetterHelper(cTTableColArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public int sizeOfGridColArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public CTTableCol getGridColArray(int i2) {
        CTTableCol cTTableCol;
        synchronized (monitor()) {
            check_orphaned();
            cTTableCol = (CTTableCol) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTTableCol == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTableCol;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public void setGridColArray(int i2, CTTableCol cTTableCol) throws Throwable {
        generatedSetterHelperImpl(cTTableCol, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
