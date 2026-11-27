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
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;

/* loaded from: classes2.dex */
public class CTPath2DCubicBezierToImpl extends XmlComplexContentImpl implements CTPath2DCubicBezierTo {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "pt")};
    private static final long serialVersionUID = 1;

    public CTPath2DCubicBezierToImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public CTAdjPoint2D addNewPt() {
        CTAdjPoint2D cTAdjPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjPoint2D = (CTAdjPoint2D) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTAdjPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public CTAdjPoint2D[] getPtArray() {
        return (CTAdjPoint2D[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTAdjPoint2D[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public List<CTAdjPoint2D> getPtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.mh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPtArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sa
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPtArray(((Integer) obj).intValue(), (CTAdjPoint2D) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ga0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPt(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q30
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePt(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.mu
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPtArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public CTAdjPoint2D insertNewPt(int i2) {
        CTAdjPoint2D cTAdjPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjPoint2D = (CTAdjPoint2D) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTAdjPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public void removePt(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public void setPtArray(CTAdjPoint2D[] cTAdjPoint2DArr) {
        check_orphaned();
        arraySetterHelper(cTAdjPoint2DArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public int sizeOfPtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public CTAdjPoint2D getPtArray(int i2) {
        CTAdjPoint2D cTAdjPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjPoint2D = (CTAdjPoint2D) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTAdjPoint2D == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAdjPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public void setPtArray(int i2, CTAdjPoint2D cTAdjPoint2D) throws Throwable {
        generatedSetterHelperImpl(cTAdjPoint2D, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
