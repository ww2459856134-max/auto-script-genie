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
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetColorVal;

/* loaded from: classes2.dex */
public class CTPresetColorImpl extends XmlComplexContentImpl implements CTPresetColor {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tint"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "shade"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "comp"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "inv"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gray"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alpha"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hue"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hueOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hueMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "sat"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "satOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "satMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lum"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lumOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lumMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "red"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "redOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "redMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "green"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "greenOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "greenMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blue"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blueOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blueMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gamma"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "invGamma"), new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTPresetColorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositiveFixedPercentage addNewAlpha() {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositivePercentage addNewAlphaMod() {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTFixedPercentage addNewAlphaOff() {
        CTFixedPercentage cTFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTFixedPercentage = (CTFixedPercentage) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewBlue() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewBlueMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewBlueOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTComplementTransform addNewComp() {
        CTComplementTransform cTComplementTransform;
        synchronized (monitor()) {
            check_orphaned();
            cTComplementTransform = (CTComplementTransform) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTComplementTransform;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTGammaTransform addNewGamma() {
        CTGammaTransform cTGammaTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGammaTransformAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTGammaTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTGrayscaleTransform addNewGray() {
        CTGrayscaleTransform cTGrayscaleTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleTransformAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTGrayscaleTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewGreen() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewGreenMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewGreenOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositiveFixedAngle addNewHue() {
        CTPositiveFixedAngle cTPositiveFixedAngle;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedAngle = (CTPositiveFixedAngle) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTPositiveFixedAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositivePercentage addNewHueMod() {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTAngle addNewHueOff() {
        CTAngle cTAngleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAngleAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTAngleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTInverseTransform addNewInv() {
        CTInverseTransform cTInverseTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseTransformAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTInverseTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTInverseGammaTransform addNewInvGamma() {
        CTInverseGammaTransform cTInverseGammaTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseGammaTransformAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTInverseGammaTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewLum() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewLumMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewLumOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewRed() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewRedMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewRedOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewSat() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewSatMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage addNewSatOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositiveFixedPercentage addNewShade() {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositiveFixedPercentage addNewTint() {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositiveFixedPercentage[] getAlphaArray() {
        return (CTPositiveFixedPercentage[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTPositiveFixedPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPositiveFixedPercentage> getAlphaList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.vc0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaArray(((Integer) obj).intValue(), (CTPositiveFixedPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.k70
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlpha(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.of
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlpha(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.se
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositivePercentage[] getAlphaModArray() {
        return (CTPositivePercentage[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTPositivePercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPositivePercentage> getAlphaModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.b8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.w3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaModArray(((Integer) obj).intValue(), (CTPositivePercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.mb0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ky
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTFixedPercentage[] getAlphaOffArray() {
        return (CTFixedPercentage[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTFixedPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTFixedPercentage> getAlphaOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.yb0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ii
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaOffArray(((Integer) obj).intValue(), (CTFixedPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.v70
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.un
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.oe
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getBlueArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[23], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getBlueList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBlueArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.yg
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBlueArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.pe
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBlue(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.v5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBlue(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBlueArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getBlueModArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[25], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getBlueModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.dv
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBlueModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.x0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBlueModArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.mx
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBlueMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.z00
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBlueMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.bz
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBlueModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getBlueOffArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[24], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getBlueOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.h10
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBlueOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.vy
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBlueOffArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.bs
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBlueOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gi
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBlueOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.na
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBlueOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTComplementTransform[] getCompArray() {
        return (CTComplementTransform[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTComplementTransform[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTComplementTransform> getCompList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ob
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCompArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.by
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCompArray(((Integer) obj).intValue(), (CTComplementTransform) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewComp(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q20
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeComp(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ym
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCompArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTGammaTransform[] getGammaArray() {
        return getXmlObjectArray(PROPERTY_QNAME[26], (XmlObject[]) new CTGammaTransform[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTGammaTransform> getGammaList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.tw
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGammaArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.o9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGammaArray(((Integer) obj).intValue(), (CTGammaTransform) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.j6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGamma(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.u0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGamma(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.fc0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGammaArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTGrayscaleTransform[] getGrayArray() {
        return getXmlObjectArray(PROPERTY_QNAME[4], (XmlObject[]) new CTGrayscaleTransform[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTGrayscaleTransform> getGrayList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.w2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGrayArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hp
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGrayArray(((Integer) obj).intValue(), (CTGrayscaleTransform) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.r7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGray(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.p8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGray(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sw
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGrayArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getGreenArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[20], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getGreenList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGreenArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.tl
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGreenArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ow
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGreen(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.l7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGreen(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.fa
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGreenArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getGreenModArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[22], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getGreenModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.b5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGreenModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.i90
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGreenModArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ue
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGreenMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ft
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGreenMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.n00
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGreenModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getGreenOffArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[21], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getGreenOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.b60
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGreenOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rt
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGreenOffArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m60
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGreenOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xb
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGreenOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ja
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGreenOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositiveFixedAngle[] getHueArray() {
        return (CTPositiveFixedAngle[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTPositiveFixedAngle[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPositiveFixedAngle> getHueList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ns
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHueArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.t4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHueArray(((Integer) obj).intValue(), (CTPositiveFixedAngle) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.o7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHue(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHue(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.o3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHueArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositivePercentage[] getHueModArray() {
        return (CTPositivePercentage[]) getXmlObjectArray(PROPERTY_QNAME[10], new CTPositivePercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPositivePercentage> getHueModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sq
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHueModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.k2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHueModArray(((Integer) obj).intValue(), (CTPositivePercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHueMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.u70
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHueMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lx
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHueModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTAngle[] getHueOffArray() {
        return getXmlObjectArray(PROPERTY_QNAME[9], (XmlObject[]) new CTAngle[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTAngle> getHueOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.d8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHueOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.kf
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHueOffArray(((Integer) obj).intValue(), (CTAngle) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHueOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.eb0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHueOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.yb
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHueOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTInverseTransform[] getInvArray() {
        return getXmlObjectArray(PROPERTY_QNAME[3], (XmlObject[]) new CTInverseTransform[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTInverseGammaTransform[] getInvGammaArray() {
        return getXmlObjectArray(PROPERTY_QNAME[27], (XmlObject[]) new CTInverseGammaTransform[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTInverseGammaTransform> getInvGammaList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.k7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getInvGammaArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.v20
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setInvGammaArray(((Integer) obj).intValue(), (CTInverseGammaTransform) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.mk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewInvGamma(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y80
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeInvGamma(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ra
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfInvGammaArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTInverseTransform> getInvList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.l90
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getInvArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.nq
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setInvArray(((Integer) obj).intValue(), (CTInverseTransform) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.tf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewInv(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.um
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeInv(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.st
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfInvArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getLumArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[14], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getLumList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLumArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.su
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLumArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.v30
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLum(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.h20
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLum(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ig
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLumArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getLumModArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getLumModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.dw
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLumModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.dm
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLumModArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.b10
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLumMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.kz
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLumMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.aa
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLumModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getLumOffArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getLumOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.or
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLumOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.a60
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLumOffArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ju
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLumOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.tk
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLumOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sr
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLumOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getRedArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[17], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getRedList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.t5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRedArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q50
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRedArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.z8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRed(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.d9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRed(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jm
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRedArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getRedModArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[19], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getRedModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y70
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRedModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.e90
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRedModArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.oj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRedMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hc0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRedMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lq
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRedModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getRedOffArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[18], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getRedOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.n90
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRedOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.a5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRedOffArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.mt
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRedOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.en
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRedOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.uz
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRedOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getSatArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getSatList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ri
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSatArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.h50
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSatArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.re
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSat(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.o10
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSat(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.uy
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSatArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getSatModArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[13], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getSatModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.nu
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSatModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lu
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSatModArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gb0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSatMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.i6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSatMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.pp
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSatModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage[] getSatOffArray() {
        return (CTPercentage[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPercentage> getSatOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.th
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSatOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.k6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSatOffArray(((Integer) obj).intValue(), (CTPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lt
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSatOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.x40
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSatOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.j4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSatOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositiveFixedPercentage[] getShadeArray() {
        return (CTPositiveFixedPercentage[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTPositiveFixedPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPositiveFixedPercentage> getShadeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.zy
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getShadeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.kr
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setShadeArray(((Integer) obj).intValue(), (CTPositiveFixedPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ma0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewShade(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ad
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeShade(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ku
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfShadeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositiveFixedPercentage[] getTintArray() {
        return (CTPositiveFixedPercentage[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTPositiveFixedPercentage[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public List<CTPositiveFixedPercentage> getTintList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sl
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTintArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.f9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTintArray(((Integer) obj).intValue(), (CTPositiveFixedPercentage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ts
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTint(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.tc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTint(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hk
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTintArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public STPresetColorVal.Enum getVal() {
        STPresetColorVal.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[28]);
            r1 = simpleValue == null ? null : (STPresetColorVal.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositiveFixedPercentage insertNewAlpha(int i2) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositivePercentage insertNewAlphaMod(int i2) {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTFixedPercentage insertNewAlphaOff(int i2) {
        CTFixedPercentage cTFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTFixedPercentage = (CTFixedPercentage) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewBlue(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[23], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewBlueMod(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[25], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewBlueOff(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[24], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTComplementTransform insertNewComp(int i2) {
        CTComplementTransform cTComplementTransform;
        synchronized (monitor()) {
            check_orphaned();
            cTComplementTransform = (CTComplementTransform) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTComplementTransform;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTGammaTransform insertNewGamma(int i2) {
        CTGammaTransform cTGammaTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGammaTransformInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[26], i2);
        }
        return cTGammaTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTGrayscaleTransform insertNewGray(int i2) {
        CTGrayscaleTransform cTGrayscaleTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleTransformInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTGrayscaleTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewGreen(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[20], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewGreenMod(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[22], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewGreenOff(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[21], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositiveFixedAngle insertNewHue(int i2) {
        CTPositiveFixedAngle cTPositiveFixedAngle;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedAngle = (CTPositiveFixedAngle) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTPositiveFixedAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositivePercentage insertNewHueMod(int i2) {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTAngle insertNewHueOff(int i2) {
        CTAngle cTAngleInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAngleInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTAngleInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTInverseTransform insertNewInv(int i2) {
        CTInverseTransform cTInverseTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseTransformInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTInverseTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTInverseGammaTransform insertNewInvGamma(int i2) {
        CTInverseGammaTransform cTInverseGammaTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseGammaTransformInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[27], i2);
        }
        return cTInverseGammaTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewLum(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewLumMod(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewLumOff(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewRed(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[17], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewRedMod(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[19], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewRedOff(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[18], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewSat(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewSatMod(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPercentage insertNewSatOff(int i2) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositiveFixedPercentage insertNewShade(int i2) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public CTPositiveFixedPercentage insertNewTint(int i2) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeAlpha(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeAlphaMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeAlphaOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeBlue(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeBlueMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeBlueOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeComp(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeGamma(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeGray(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeGreen(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeGreenMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeGreenOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeHue(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeHueMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeHueOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeInv(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeInvGamma(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeLum(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeLumMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeLumOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeRed(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeRedMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeRedOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeSat(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeSatMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeSatOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeShade(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void removeTint(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setAlphaArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPositiveFixedPercentageArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setAlphaModArray(CTPositivePercentage[] cTPositivePercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPositivePercentageArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setAlphaOffArray(CTFixedPercentage[] cTFixedPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTFixedPercentageArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setBlueArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[23]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setBlueModArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[25]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setBlueOffArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[24]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setCompArray(CTComplementTransform[] cTComplementTransformArr) {
        check_orphaned();
        arraySetterHelper(cTComplementTransformArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setGammaArray(CTGammaTransform[] cTGammaTransformArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTGammaTransformArr, PROPERTY_QNAME[26]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setGrayArray(CTGrayscaleTransform[] cTGrayscaleTransformArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTGrayscaleTransformArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setGreenArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setGreenModArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[22]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setGreenOffArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setHueArray(CTPositiveFixedAngle[] cTPositiveFixedAngleArr) {
        check_orphaned();
        arraySetterHelper(cTPositiveFixedAngleArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setHueModArray(CTPositivePercentage[] cTPositivePercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPositivePercentageArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setHueOffArray(CTAngle[] cTAngleArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAngleArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setInvArray(CTInverseTransform[] cTInverseTransformArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTInverseTransformArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setInvGammaArray(CTInverseGammaTransform[] cTInverseGammaTransformArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTInverseGammaTransformArr, PROPERTY_QNAME[27]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setLumArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setLumModArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setLumOffArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setRedArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setRedModArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setRedOffArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setSatArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setSatModArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setSatOffArray(CTPercentage[] cTPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPercentageArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setShadeArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPositiveFixedPercentageArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setTintArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr) {
        check_orphaned();
        arraySetterHelper(cTPositiveFixedPercentageArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setVal(STPresetColorVal.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[28]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[28]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfAlphaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfAlphaModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfAlphaOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfBlueArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfBlueModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfBlueOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfCompArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfGammaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfGrayArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfGreenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfGreenModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfGreenOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfHueArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfHueModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfHueOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfInvArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfInvGammaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfLumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfLumModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfLumOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfRedArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfRedModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfRedOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfSatArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfSatModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfSatOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfShadeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public int sizeOfTintArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public STPresetColorVal xgetVal() {
        STPresetColorVal sTPresetColorVal;
        synchronized (monitor()) {
            check_orphaned();
            sTPresetColorVal = (STPresetColorVal) get_store().find_attribute_user(PROPERTY_QNAME[28]);
        }
        return sTPresetColorVal;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void xsetVal(STPresetColorVal sTPresetColorVal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STPresetColorVal sTPresetColorVal2 = (STPresetColorVal) typeStore.find_attribute_user(qNameArr[28]);
            if (sTPresetColorVal2 == null) {
                sTPresetColorVal2 = (STPresetColorVal) get_store().add_attribute_user(qNameArr[28]);
            }
            sTPresetColorVal2.set(sTPresetColorVal);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setAlphaArray(int i2, CTPositiveFixedPercentage cTPositiveFixedPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPositiveFixedPercentage, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setAlphaModArray(int i2, CTPositivePercentage cTPositivePercentage) throws Throwable {
        generatedSetterHelperImpl(cTPositivePercentage, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setAlphaOffArray(int i2, CTFixedPercentage cTFixedPercentage) throws Throwable {
        generatedSetterHelperImpl(cTFixedPercentage, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setBlueArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[23], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setBlueModArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[25], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setBlueOffArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[24], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setCompArray(int i2, CTComplementTransform cTComplementTransform) throws Throwable {
        generatedSetterHelperImpl(cTComplementTransform, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setGammaArray(int i2, CTGammaTransform cTGammaTransform) throws Throwable {
        generatedSetterHelperImpl(cTGammaTransform, PROPERTY_QNAME[26], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setGrayArray(int i2, CTGrayscaleTransform cTGrayscaleTransform) throws Throwable {
        generatedSetterHelperImpl(cTGrayscaleTransform, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setGreenArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[20], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setGreenModArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[22], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setGreenOffArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[21], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setHueArray(int i2, CTPositiveFixedAngle cTPositiveFixedAngle) throws Throwable {
        generatedSetterHelperImpl(cTPositiveFixedAngle, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setHueModArray(int i2, CTPositivePercentage cTPositivePercentage) throws Throwable {
        generatedSetterHelperImpl(cTPositivePercentage, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setHueOffArray(int i2, CTAngle cTAngle) throws Throwable {
        generatedSetterHelperImpl(cTAngle, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setInvArray(int i2, CTInverseTransform cTInverseTransform) throws Throwable {
        generatedSetterHelperImpl(cTInverseTransform, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setInvGammaArray(int i2, CTInverseGammaTransform cTInverseGammaTransform) throws Throwable {
        generatedSetterHelperImpl(cTInverseGammaTransform, PROPERTY_QNAME[27], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setLumArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setLumModArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[16], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setLumOffArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[15], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setRedArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[17], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setRedModArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[19], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setRedOffArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[18], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setSatArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setSatModArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[13], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setSatOffArray(int i2, CTPercentage cTPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPercentage, PROPERTY_QNAME[12], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setShadeArray(int i2, CTPositiveFixedPercentage cTPositiveFixedPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPositiveFixedPercentage, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor
    public void setTintArray(int i2, CTPositiveFixedPercentage cTPositiveFixedPercentage) throws Throwable {
        generatedSetterHelperImpl(cTPositiveFixedPercentage, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
