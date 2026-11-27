package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DClose;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathFillMode;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate;

/* loaded from: classes2.dex */
public class CTPath2DImpl extends XmlComplexContentImpl implements CTPath2D {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "close"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "moveTo"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lnTo"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "arcTo"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "quadBezTo"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "cubicBezTo"), new QName("", "w"), new QName("", "h"), new QName("", "fill"), new QName("", "stroke"), new QName("", "extrusionOk")};
    private static final long serialVersionUID = 1;

    public CTPath2DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DArcTo addNewArcTo() {
        CTPath2DArcTo cTPath2DArcTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DArcTo = (CTPath2DArcTo) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTPath2DArcTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DClose addNewClose() {
        CTPath2DClose cTPath2DClose;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DClose = (CTPath2DClose) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTPath2DClose;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DCubicBezierTo addNewCubicBezTo() {
        CTPath2DCubicBezierTo cTPath2DCubicBezierTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTPath2DCubicBezierTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DLineTo addNewLnTo() {
        CTPath2DLineTo cTPath2DLineTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DLineTo = (CTPath2DLineTo) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTPath2DLineTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DMoveTo addNewMoveTo() {
        CTPath2DMoveTo cTPath2DMoveTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DMoveTo = (CTPath2DMoveTo) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTPath2DMoveTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DQuadBezierTo addNewQuadBezTo() {
        CTPath2DQuadBezierTo cTPath2DQuadBezierTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTPath2DQuadBezierTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DArcTo[] getArcToArray() {
        return (CTPath2DArcTo[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTPath2DArcTo[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public List<CTPath2DArcTo> getArcToList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.e30
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getArcToArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.z4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setArcToArray(((Integer) obj).intValue(), (CTPath2DArcTo) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.w8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewArcTo(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.iz
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeArcTo(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y10
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfArcToArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DClose[] getCloseArray() {
        return (CTPath2DClose[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTPath2DClose[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public List<CTPath2DClose> getCloseList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.pj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCloseArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.s6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCloseArray(((Integer) obj).intValue(), (CTPath2DClose) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xx
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewClose(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sb0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeClose(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCloseArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DCubicBezierTo[] getCubicBezToArray() {
        return (CTPath2DCubicBezierTo[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTPath2DCubicBezierTo[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public List<CTPath2DCubicBezierTo> getCubicBezToList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.do
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCubicBezToArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.j50
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCubicBezToArray(((Integer) obj).intValue(), (CTPath2DCubicBezierTo) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ys
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCubicBezTo(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.n7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCubicBezTo(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.i00
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCubicBezToArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean getExtrusionOk() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[10]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[10]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public STPathFillMode.Enum getFill() {
        STPathFillMode.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[8]);
            }
            r1 = simpleValue == null ? null : (STPathFillMode.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public long getH() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[7]);
            }
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DLineTo[] getLnToArray() {
        return (CTPath2DLineTo[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTPath2DLineTo[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public List<CTPath2DLineTo> getLnToList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.l30
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLnToArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sj
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLnToArray(((Integer) obj).intValue(), (CTPath2DLineTo) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.nv
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLnTo(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.p40
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLnTo(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.f2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLnToArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DMoveTo[] getMoveToArray() {
        return (CTPath2DMoveTo[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTPath2DMoveTo[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public List<CTPath2DMoveTo> getMoveToList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.z7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qs
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToArray(((Integer) obj).intValue(), (CTPath2DMoveTo) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.c1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveTo(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.cm
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveTo(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.fg
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DQuadBezierTo[] getQuadBezToArray() {
        return (CTPath2DQuadBezierTo[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTPath2DQuadBezierTo[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public List<CTPath2DQuadBezierTo> getQuadBezToList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.h6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getQuadBezToArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.k00
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setQuadBezToArray(((Integer) obj).intValue(), (CTPath2DQuadBezierTo) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hy
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewQuadBezTo(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.w0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeQuadBezTo(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfQuadBezToArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean getStroke() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[9]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public long getW() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[6]);
            }
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DArcTo insertNewArcTo(int i2) {
        CTPath2DArcTo cTPath2DArcTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DArcTo = (CTPath2DArcTo) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTPath2DArcTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DClose insertNewClose(int i2) {
        CTPath2DClose cTPath2DClose;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DClose = (CTPath2DClose) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTPath2DClose;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DCubicBezierTo insertNewCubicBezTo(int i2) {
        CTPath2DCubicBezierTo cTPath2DCubicBezierTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTPath2DCubicBezierTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DLineTo insertNewLnTo(int i2) {
        CTPath2DLineTo cTPath2DLineTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DLineTo = (CTPath2DLineTo) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTPath2DLineTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DMoveTo insertNewMoveTo(int i2) {
        CTPath2DMoveTo cTPath2DMoveTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DMoveTo = (CTPath2DMoveTo) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTPath2DMoveTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DQuadBezierTo insertNewQuadBezTo(int i2) {
        CTPath2DQuadBezierTo cTPath2DQuadBezierTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTPath2DQuadBezierTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean isSetExtrusionOk() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[10]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean isSetFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[8]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean isSetH() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[7]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean isSetStroke() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[9]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean isSetW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[6]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void removeArcTo(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void removeClose(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void removeCubicBezTo(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void removeLnTo(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void removeMoveTo(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void removeQuadBezTo(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setArcToArray(CTPath2DArcTo[] cTPath2DArcToArr) {
        check_orphaned();
        arraySetterHelper(cTPath2DArcToArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setCloseArray(CTPath2DClose[] cTPath2DCloseArr) {
        check_orphaned();
        arraySetterHelper(cTPath2DCloseArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setCubicBezToArray(CTPath2DCubicBezierTo[] cTPath2DCubicBezierToArr) {
        check_orphaned();
        arraySetterHelper(cTPath2DCubicBezierToArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setExtrusionOk(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[10]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[10]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setFill(STPathFillMode.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[8]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setH(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[7]);
            }
            simpleValue.setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setLnToArray(CTPath2DLineTo[] cTPath2DLineToArr) {
        check_orphaned();
        arraySetterHelper(cTPath2DLineToArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setMoveToArray(CTPath2DMoveTo[] cTPath2DMoveToArr) {
        check_orphaned();
        arraySetterHelper(cTPath2DMoveToArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setQuadBezToArray(CTPath2DQuadBezierTo[] cTPath2DQuadBezierToArr) {
        check_orphaned();
        arraySetterHelper(cTPath2DQuadBezierToArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setStroke(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[9]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setW(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[6]);
            }
            simpleValue.setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public int sizeOfArcToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public int sizeOfCloseArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public int sizeOfCubicBezToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public int sizeOfLnToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public int sizeOfQuadBezToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void unsetExtrusionOk() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[10]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void unsetFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[8]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void unsetH() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[7]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void unsetStroke() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[9]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void unsetW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[6]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public XmlBoolean xgetExtrusionOk() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[10]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[10]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public STPathFillMode xgetFill() {
        STPathFillMode sTPathFillMode;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTPathFillMode = (STPathFillMode) typeStore.find_attribute_user(qNameArr[8]);
            if (sTPathFillMode == null) {
                sTPathFillMode = (STPathFillMode) get_default_attribute_value(qNameArr[8]);
            }
        }
        return sTPathFillMode;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public STPositiveCoordinate xgetH() {
        STPositiveCoordinate sTPositiveCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTPositiveCoordinate = (STPositiveCoordinate) typeStore.find_attribute_user(qNameArr[7]);
            if (sTPositiveCoordinate == null) {
                sTPositiveCoordinate = (STPositiveCoordinate) get_default_attribute_value(qNameArr[7]);
            }
        }
        return sTPositiveCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public XmlBoolean xgetStroke() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[9]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[9]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public STPositiveCoordinate xgetW() {
        STPositiveCoordinate sTPositiveCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTPositiveCoordinate = (STPositiveCoordinate) typeStore.find_attribute_user(qNameArr[6]);
            if (sTPositiveCoordinate == null) {
                sTPositiveCoordinate = (STPositiveCoordinate) get_default_attribute_value(qNameArr[6]);
            }
        }
        return sTPositiveCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void xsetExtrusionOk(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[10]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[10]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void xsetFill(STPathFillMode sTPathFillMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STPathFillMode sTPathFillMode2 = (STPathFillMode) typeStore.find_attribute_user(qNameArr[8]);
            if (sTPathFillMode2 == null) {
                sTPathFillMode2 = (STPathFillMode) get_store().add_attribute_user(qNameArr[8]);
            }
            sTPathFillMode2.set(sTPathFillMode);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void xsetH(STPositiveCoordinate sTPositiveCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STPositiveCoordinate sTPositiveCoordinate2 = (STPositiveCoordinate) typeStore.find_attribute_user(qNameArr[7]);
            if (sTPositiveCoordinate2 == null) {
                sTPositiveCoordinate2 = (STPositiveCoordinate) get_store().add_attribute_user(qNameArr[7]);
            }
            sTPositiveCoordinate2.set(sTPositiveCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void xsetStroke(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[9]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[9]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void xsetW(STPositiveCoordinate sTPositiveCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STPositiveCoordinate sTPositiveCoordinate2 = (STPositiveCoordinate) typeStore.find_attribute_user(qNameArr[6]);
            if (sTPositiveCoordinate2 == null) {
                sTPositiveCoordinate2 = (STPositiveCoordinate) get_store().add_attribute_user(qNameArr[6]);
            }
            sTPositiveCoordinate2.set(sTPositiveCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DArcTo getArcToArray(int i2) {
        CTPath2DArcTo cTPath2DArcTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DArcTo = (CTPath2DArcTo) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTPath2DArcTo == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2DArcTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DClose getCloseArray(int i2) {
        CTPath2DClose cTPath2DClose;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DClose = (CTPath2DClose) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTPath2DClose == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2DClose;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DCubicBezierTo getCubicBezToArray(int i2) {
        CTPath2DCubicBezierTo cTPath2DCubicBezierTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTPath2DCubicBezierTo == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2DCubicBezierTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DLineTo getLnToArray(int i2) {
        CTPath2DLineTo cTPath2DLineTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DLineTo = (CTPath2DLineTo) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTPath2DLineTo == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2DLineTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DMoveTo getMoveToArray(int i2) {
        CTPath2DMoveTo cTPath2DMoveTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DMoveTo = (CTPath2DMoveTo) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTPath2DMoveTo == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2DMoveTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DQuadBezierTo getQuadBezToArray(int i2) {
        CTPath2DQuadBezierTo cTPath2DQuadBezierTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTPath2DQuadBezierTo == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2DQuadBezierTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setArcToArray(int i2, CTPath2DArcTo cTPath2DArcTo) throws Throwable {
        generatedSetterHelperImpl(cTPath2DArcTo, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setCloseArray(int i2, CTPath2DClose cTPath2DClose) throws Throwable {
        generatedSetterHelperImpl(cTPath2DClose, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setCubicBezToArray(int i2, CTPath2DCubicBezierTo cTPath2DCubicBezierTo) throws Throwable {
        generatedSetterHelperImpl(cTPath2DCubicBezierTo, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setLnToArray(int i2, CTPath2DLineTo cTPath2DLineTo) throws Throwable {
        generatedSetterHelperImpl(cTPath2DLineTo, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setMoveToArray(int i2, CTPath2DMoveTo cTPath2DMoveTo) throws Throwable {
        generatedSetterHelperImpl(cTPath2DMoveTo, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setQuadBezToArray(int i2, CTPath2DQuadBezierTo cTPath2DQuadBezierTo) throws Throwable {
        generatedSetterHelperImpl(cTPath2DQuadBezierTo, PROPERTY_QNAME[4], i2, (short) 2);
    }
}
