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
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList;

/* loaded from: classes2.dex */
public class CTPath2DListImpl extends XmlComplexContentImpl implements CTPath2DList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "path")};
    private static final long serialVersionUID = 1;

    public CTPath2DListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public CTPath2D addNewPath() {
        CTPath2D cTPath2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2D = (CTPath2D) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTPath2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public CTPath2D[] getPathArray() {
        return (CTPath2D[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTPath2D[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public List<CTPath2D> getPathList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.f6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPathArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.yj
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPathArray(((Integer) obj).intValue(), (CTPath2D) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPath(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m00
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePath(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.wn
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPathArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public CTPath2D insertNewPath(int i2) {
        CTPath2D cTPath2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2D = (CTPath2D) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTPath2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public void removePath(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public void setPathArray(CTPath2D[] cTPath2DArr) {
        check_orphaned();
        arraySetterHelper(cTPath2DArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public int sizeOfPathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public CTPath2D getPathArray(int i2) {
        CTPath2D cTPath2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2D = (CTPath2D) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTPath2D == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public void setPathArray(int i2, CTPath2D cTPath2D) throws Throwable {
        generatedSetterHelperImpl(cTPath2D, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
