package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTComplementTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGammaTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGrayscaleTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInverseGammaTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInverseTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositivePercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STHexColorRGB;

/* loaded from: classes2.dex */
public class CTSRgbColorImpl extends XmlComplexContentImpl implements CTSRgbColor {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tint"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "shade"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "comp"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "inv"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gray"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alpha"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hue"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hueOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hueMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "sat"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "satOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "satMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lum"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lumOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lumMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "red"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "redOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "redMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "green"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "greenOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "greenMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blue"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blueOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blueMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gamma"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "invGamma"), new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTSRgbColorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedPercentage addNewAlpha() {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositivePercentage addNewAlphaMod() {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTFixedPercentage addNewAlphaOff() {
        CTFixedPercentage cTFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTFixedPercentage = (CTFixedPercentage) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewBlue() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewBlueMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewBlueOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTComplementTransform addNewComp() {
        CTComplementTransform cTComplementTransform;
        synchronized (monitor()) {
            check_orphaned();
            cTComplementTransform = (CTComplementTransform) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTComplementTransform;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTGammaTransform addNewGamma() {
        CTGammaTransform cTGammaTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGammaTransformAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTGammaTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTGrayscaleTransform addNewGray() {
        CTGrayscaleTransform cTGrayscaleTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleTransformAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTGrayscaleTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewGreen() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewGreenMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewGreenOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedAngle addNewHue() {
        CTPositiveFixedAngle cTPositiveFixedAngle;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedAngle = (CTPositiveFixedAngle) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTPositiveFixedAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositivePercentage addNewHueMod() {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTAngle addNewHueOff() {
        CTAngle cTAngleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAngleAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTAngleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTInverseTransform addNewInv() {
        CTInverseTransform cTInverseTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseTransformAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTInverseTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTInverseGammaTransform addNewInvGamma() {
        CTInverseGammaTransform cTInverseGammaTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseGammaTransformAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTInverseGammaTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewLum() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewLumMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewLumOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewRed() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewRedMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewRedOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewSat() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewSatMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage addNewSatOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedPercentage addNewShade() {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedPercentage addNewTint() {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedPercentage[] getAlphaArray() {
        return (CTPositiveFixedPercentage[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTPositiveFixedPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPositiveFixedPercentage> getAlphaList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.va0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.wx
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaArray(((Integer) obj).intValue(), (CTPositiveFixedPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlpha(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.c10
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlpha(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.u7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositivePercentage[] getAlphaModArray() {
        return (CTPositivePercentage[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTPositivePercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPositivePercentage> getAlphaModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qe
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaModArray(((Integer) obj).intValue(), (CTPositivePercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.r4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.d2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.eq
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTFixedPercentage[] getAlphaOffArray() {
        return (CTFixedPercentage[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTFixedPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTFixedPercentage> getAlphaOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.g90
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m40
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaOffArray(((Integer) obj).intValue(), (CTFixedPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.k0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.f1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getBlueArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[23], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getBlueList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.u50
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBlueArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.j5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBlueArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.v2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBlue(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.x9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBlue(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ha
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBlueArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getBlueModArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[25], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getBlueModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.e8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBlueModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.x2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBlueModArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.wu
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBlueMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rd
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBlueMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qa
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBlueModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getBlueOffArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[24], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getBlueOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rw
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBlueOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.c5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBlueOffArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.z60
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBlueOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ew
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBlueOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hf
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBlueOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTComplementTransform[] getCompArray() {
        return (CTComplementTransform[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTComplementTransform[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTComplementTransform> getCompList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sm
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCompArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.g00
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCompArray(((Integer) obj).intValue(), (CTComplementTransform) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.pn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewComp(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeComp(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.fb
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCompArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTGammaTransform[] getGammaArray() {
        return getXmlObjectArray(PROPERTY_QNAME[26], (XmlObject[]) new CTGammaTransform[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTGammaTransform> getGammaList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.g3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGammaArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.db0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGammaArray(((Integer) obj).intValue(), (CTGammaTransform) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.nd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGamma(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ej
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGamma(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xi
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGammaArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTGrayscaleTransform[] getGrayArray() {
        return getXmlObjectArray(PROPERTY_QNAME[4], (XmlObject[]) new CTGrayscaleTransform[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTGrayscaleTransform> getGrayList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.er
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGrayArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.zb
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGrayArray(((Integer) obj).intValue(), (CTGrayscaleTransform) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.li
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGray(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.z80
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGray(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.i40
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGrayArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getGreenArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[20], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getGreenList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.d7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGreenArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.s40
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGreenArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.fq
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGreen(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qn
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGreen(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rb0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGreenArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getGreenModArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[22], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getGreenModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.vv
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGreenModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.iu
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGreenModArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.o1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGreenMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.az
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGreenMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ul
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGreenModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getGreenOffArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[21], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getGreenOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.v4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGreenOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.f4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGreenOffArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gc0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGreenOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.uw
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGreenOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.vi
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGreenOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedAngle[] getHueArray() {
        return (CTPositiveFixedAngle[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTPositiveFixedAngle[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPositiveFixedAngle> getHueList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHueArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.pz
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHueArray(((Integer) obj).intValue(), (CTPositiveFixedAngle) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ur
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHue(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.f70
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHue(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.tb0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHueArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositivePercentage[] getHueModArray() {
        return (CTPositivePercentage[]) getXmlObjectArray(PROPERTY_QNAME[10], new CTPositivePercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPositivePercentage> getHueModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y90
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHueModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.g6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHueModArray(((Integer) obj).intValue(), (CTPositivePercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.no
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHueMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ff
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHueMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.d90
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHueModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTAngle[] getHueOffArray() {
        return getXmlObjectArray(PROPERTY_QNAME[9], (XmlObject[]) new CTAngle[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTAngle> getHueOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ah
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHueOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.o50
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHueOffArray(((Integer) obj).intValue(), (CTAngle) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.oq
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHueOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xv
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHueOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.cc0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHueOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTInverseTransform[] getInvArray() {
        return getXmlObjectArray(PROPERTY_QNAME[3], (XmlObject[]) new CTInverseTransform[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTInverseGammaTransform[] getInvGammaArray() {
        return getXmlObjectArray(PROPERTY_QNAME[27], (XmlObject[]) new CTInverseGammaTransform[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTInverseGammaTransform> getInvGammaList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ev
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getInvGammaArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m70
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setInvGammaArray(((Integer) obj).intValue(), (CTInverseGammaTransform) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.kc0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewInvGamma(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.k
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeInvGamma(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hb
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfInvGammaArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTInverseTransform> getInvList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.es
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getInvArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ws
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setInvArray(((Integer) obj).intValue(), (CTInverseTransform) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ru
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewInv(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.co
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeInv(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.og
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfInvArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getLumArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[14], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getLumList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.yp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLumArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.i8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLumArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.wb0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLum(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLum(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.o8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLumArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getLumModArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getLumModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.kn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLumModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xa0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLumModArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ne
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLumMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.dj
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLumMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q40
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLumModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getLumOffArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getLumOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.wh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLumOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.tc0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLumOffArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hx
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLumOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLumOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xs
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLumOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getRedArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[17], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getRedList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.te
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRedArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rp
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRedArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.p5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRed(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ub0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRed(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q70
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRedArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getRedModArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[19], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getRedModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.cq
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRedModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRedModArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.h70
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRedMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.o00
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRedMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ba
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRedModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getRedOffArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[18], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getRedOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.n4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRedOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.up
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRedOffArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.nx
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRedOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.c0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRedOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.yl
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRedOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getSatArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getSatList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.g40
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSatArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.j3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSatArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qt
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSat(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.h90
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSat(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rk
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSatArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getSatModArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[13], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getSatModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSatModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.pq
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSatModArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.za
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSatMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.pm
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSatMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.v1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSatModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage[] getSatOffArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPercentage> getSatOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ks
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSatOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.uc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSatOffArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.el
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSatOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.di
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSatOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lg
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSatOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedPercentage[] getShadeArray() {
        return (CTPositiveFixedPercentage[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTPositiveFixedPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPositiveFixedPercentage> getShadeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.yx
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getShadeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.cg
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setShadeArray(((Integer) obj).intValue(), (CTPositiveFixedPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lw
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewShade(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sc0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeShade(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.mv
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfShadeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedPercentage[] getTintArray() {
        return (CTPositiveFixedPercentage[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTPositiveFixedPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public List<CTPositiveFixedPercentage> getTintList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTintArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ry
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTintArray(((Integer) obj).intValue(), (CTPositiveFixedPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sa0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTint(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.mr
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTint(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.an
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTintArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public byte[] getVal() {
        byte[] byteArrayValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[28]);
            byteArrayValue = simpleValue == null ? null : simpleValue.getByteArrayValue();
        }
        return byteArrayValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedPercentage insertNewAlpha(int i2) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositivePercentage insertNewAlphaMod(int i2) {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTFixedPercentage insertNewAlphaOff(int i2) {
        CTFixedPercentage cTFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTFixedPercentage = (CTFixedPercentage) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewBlue(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[23], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewBlueMod(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[25], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewBlueOff(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[24], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTComplementTransform insertNewComp(int i2) {
        CTComplementTransform cTComplementTransform;
        synchronized (monitor()) {
            check_orphaned();
            cTComplementTransform = (CTComplementTransform) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTComplementTransform;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTGammaTransform insertNewGamma(int i2) {
        CTGammaTransform cTGammaTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGammaTransformInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[26], i2);
        }
        return cTGammaTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTGrayscaleTransform insertNewGray(int i2) {
        CTGrayscaleTransform cTGrayscaleTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleTransformInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTGrayscaleTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewGreen(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[20], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewGreenMod(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[22], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewGreenOff(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[21], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedAngle insertNewHue(int i2) {
        CTPositiveFixedAngle cTPositiveFixedAngle;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedAngle = (CTPositiveFixedAngle) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTPositiveFixedAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositivePercentage insertNewHueMod(int i2) {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTAngle insertNewHueOff(int i2) {
        CTAngle cTAngleInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAngleInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTAngleInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTInverseTransform insertNewInv(int i2) {
        CTInverseTransform cTInverseTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseTransformInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTInverseTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTInverseGammaTransform insertNewInvGamma(int i2) {
        CTInverseGammaTransform cTInverseGammaTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseGammaTransformInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[27], i2);
        }
        return cTInverseGammaTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewLum(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewLumMod(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewLumOff(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewRed(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[17], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewRedMod(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[19], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewRedOff(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[18], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewSat(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewSatMod(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage insertNewSatOff(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedPercentage insertNewShade(int i2) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedPercentage insertNewTint(int i2) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeAlpha(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeAlphaMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeAlphaOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeBlue(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeBlueMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeBlueOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeComp(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeGamma(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeGray(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeGreen(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeGreenMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeGreenOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeHue(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeHueMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeHueOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeInv(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeInvGamma(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeLum(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeLumMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeLumOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeRed(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeRedMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeRedOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeSat(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeSatMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeSatOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeShade(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void removeTint(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setAlphaArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPositiveFixedPercentageArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setAlphaModArray(CTPositivePercentage[] cTPositivePercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPositivePercentageArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setAlphaOffArray(CTFixedPercentage[] cTFixedPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTFixedPercentageArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setBlueArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[23]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setBlueModArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[25]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setBlueOffArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[24]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setCompArray(CTComplementTransform[] cTComplementTransformArr) {
        check_orphaned();
        arraySetterHelper(cTComplementTransformArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setGammaArray(CTGammaTransform[] cTGammaTransformArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTGammaTransformArr, PROPERTY_QNAME[26]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setGrayArray(CTGrayscaleTransform[] cTGrayscaleTransformArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTGrayscaleTransformArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setGreenArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setGreenModArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[22]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setGreenOffArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setHueArray(CTPositiveFixedAngle[] cTPositiveFixedAngleArr) {
        check_orphaned();
        arraySetterHelper(cTPositiveFixedAngleArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setHueModArray(CTPositivePercentage[] cTPositivePercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPositivePercentageArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setHueOffArray(CTAngle[] cTAngleArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAngleArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setInvArray(CTInverseTransform[] cTInverseTransformArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTInverseTransformArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setInvGammaArray(CTInverseGammaTransform[] cTInverseGammaTransformArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTInverseGammaTransformArr, PROPERTY_QNAME[27]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setLumArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setLumModArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setLumOffArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setRedArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setRedModArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setRedOffArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setSatArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setSatModArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setSatOffArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setShadeArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPositiveFixedPercentageArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setTintArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPositiveFixedPercentageArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setVal(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[28]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[28]);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfAlphaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfAlphaModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfAlphaOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfBlueArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfBlueModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfBlueOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfCompArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfGammaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfGrayArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfGreenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfGreenModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfGreenOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfHueArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfHueModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfHueOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfInvArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfInvGammaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfLumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfLumModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfLumOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfRedArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfRedModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfRedOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfSatArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfSatModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfSatOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfShadeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public int sizeOfTintArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public STHexColorRGB xgetVal() {
        STHexColorRGB sTHexColorRGB;
        synchronized (monitor()) {
            check_orphaned();
            sTHexColorRGB = (STHexColorRGB) get_store().find_attribute_user(PROPERTY_QNAME[28]);
        }
        return sTHexColorRGB;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void xsetVal(STHexColorRGB sTHexColorRGB) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STHexColorRGB sTHexColorRGB2 = (STHexColorRGB) typeStore.find_attribute_user(qNameArr[28]);
            if (sTHexColorRGB2 == null) {
                sTHexColorRGB2 = (STHexColorRGB) get_store().add_attribute_user(qNameArr[28]);
            }
            sTHexColorRGB2.set(sTHexColorRGB);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedPercentage getAlphaArray(int i2) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTPositiveFixedPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositivePercentage getAlphaModArray(int i2) {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTPositivePercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTFixedPercentage getAlphaOffArray(int i2) {
        CTFixedPercentage cTFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTFixedPercentage = (CTFixedPercentage) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTFixedPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getBlueArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[23], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getBlueModArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[25], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getBlueOffArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[24], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTComplementTransform getCompArray(int i2) {
        CTComplementTransform cTComplementTransform;
        synchronized (monitor()) {
            check_orphaned();
            cTComplementTransform = (CTComplementTransform) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTComplementTransform == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTComplementTransform;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTGammaTransform getGammaArray(int i2) {
        CTGammaTransform cTGammaTransformFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGammaTransformFind_element_user = get_store().find_element_user(PROPERTY_QNAME[26], i2);
            if (cTGammaTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGammaTransformFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTGrayscaleTransform getGrayArray(int i2) {
        CTGrayscaleTransform cTGrayscaleTransformFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleTransformFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTGrayscaleTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGrayscaleTransformFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getGreenArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[20], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getGreenModArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[22], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getGreenOffArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[21], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedAngle getHueArray(int i2) {
        CTPositiveFixedAngle cTPositiveFixedAngle;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedAngle = (CTPositiveFixedAngle) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTPositiveFixedAngle == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPositiveFixedAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositivePercentage getHueModArray(int i2) {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTPositivePercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTAngle getHueOffArray(int i2) {
        CTAngle cTAngleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAngleFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTAngleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAngleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTInverseTransform getInvArray(int i2) {
        CTInverseTransform cTInverseTransformFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseTransformFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTInverseTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTInverseTransformFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTInverseGammaTransform getInvGammaArray(int i2) {
        CTInverseGammaTransform cTInverseGammaTransformFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseGammaTransformFind_element_user = get_store().find_element_user(PROPERTY_QNAME[27], i2);
            if (cTInverseGammaTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTInverseGammaTransformFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getLumArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getLumModArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getLumOffArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getRedArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getRedModArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[19], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getRedOffArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[18], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getSatArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getSatModArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPercentage getSatOffArray(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedPercentage getShadeArray(int i2) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTPositiveFixedPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public CTPositiveFixedPercentage getTintArray(int i2) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTPositiveFixedPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setAlphaArray(int i2, CTPositiveFixedPercentage cTPositiveFixedPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPositiveFixedPercentage, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setAlphaModArray(int i2, CTPositivePercentage cTPositivePercentage) throws Throwable {
        generatedSetterHelperImpl(cTPositivePercentage, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setAlphaOffArray(int i2, CTFixedPercentage cTFixedPercentage) throws Throwable {
        generatedSetterHelperImpl(cTFixedPercentage, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setBlueArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[23], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setBlueModArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[25], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setBlueOffArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[24], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setCompArray(int i2, CTComplementTransform cTComplementTransform) throws Throwable {
        generatedSetterHelperImpl(cTComplementTransform, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setGammaArray(int i2, CTGammaTransform cTGammaTransform) throws Throwable {
        generatedSetterHelperImpl(cTGammaTransform, PROPERTY_QNAME[26], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setGrayArray(int i2, CTGrayscaleTransform cTGrayscaleTransform) throws Throwable {
        generatedSetterHelperImpl(cTGrayscaleTransform, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setGreenArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[20], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setGreenModArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[22], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setGreenOffArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[21], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setHueArray(int i2, CTPositiveFixedAngle cTPositiveFixedAngle) throws Throwable {
        generatedSetterHelperImpl(cTPositiveFixedAngle, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setHueModArray(int i2, CTPositivePercentage cTPositivePercentage) throws Throwable {
        generatedSetterHelperImpl(cTPositivePercentage, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setHueOffArray(int i2, CTAngle cTAngle) throws Throwable {
        generatedSetterHelperImpl(cTAngle, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setInvArray(int i2, CTInverseTransform cTInverseTransform) throws Throwable {
        generatedSetterHelperImpl(cTInverseTransform, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setInvGammaArray(int i2, CTInverseGammaTransform cTInverseGammaTransform) throws Throwable {
        generatedSetterHelperImpl(cTInverseGammaTransform, PROPERTY_QNAME[27], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setLumArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setLumModArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[16], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setLumOffArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[15], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setRedArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[17], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setRedModArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[19], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setRedOffArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[18], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setSatArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setSatModArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[13], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setSatOffArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[12], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setShadeArray(int i2, CTPositiveFixedPercentage cTPositiveFixedPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPositiveFixedPercentage, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor
    public void setTintArray(int i2, CTPositiveFixedPercentage cTPositiveFixedPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPositiveFixedPercentage, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
