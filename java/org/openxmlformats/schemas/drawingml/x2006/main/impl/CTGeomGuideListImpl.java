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
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;

/* loaded from: classes2.dex */
public class CTGeomGuideListImpl extends XmlComplexContentImpl implements CTGeomGuideList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gd")};
    private static final long serialVersionUID = 1;

    public CTGeomGuideListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList
    public CTGeomGuide addNewGd() {
        CTGeomGuide cTGeomGuide;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuide = (CTGeomGuide) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTGeomGuide;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList
    public CTGeomGuide[] getGdArray() {
        return (CTGeomGuide[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTGeomGuide[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList
    public List<CTGeomGuide> getGdList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.w4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGdArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.cw
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGdArray(((Integer) obj).intValue(), (CTGeomGuide) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.k1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ae
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.yv
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGdArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList
    public CTGeomGuide insertNewGd(int i2) {
        CTGeomGuide cTGeomGuide;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuide = (CTGeomGuide) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTGeomGuide;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList
    public void removeGd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList
    public void setGdArray(CTGeomGuide[] cTGeomGuideArr) {
        check_orphaned();
        arraySetterHelper(cTGeomGuideArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList
    public int sizeOfGdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList
    public CTGeomGuide getGdArray(int i2) {
        CTGeomGuide cTGeomGuide;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuide = (CTGeomGuide) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTGeomGuide == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGeomGuide;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList
    public void setGdArray(int i2, CTGeomGuide cTGeomGuide) throws Throwable {
        generatedSetterHelperImpl(cTGeomGuide, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
