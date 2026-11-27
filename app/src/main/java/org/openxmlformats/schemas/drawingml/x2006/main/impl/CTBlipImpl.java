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
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaBiLevelEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaCeilingEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaFloorEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaInverseEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaReplaceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBiLevelEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlurEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorChangeEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorReplaceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDuotoneEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillOverlayEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGrayscaleEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHSLEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLuminanceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTintEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlipCompression;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* loaded from: classes2.dex */
public class CTBlipImpl extends XmlComplexContentImpl implements CTBlip {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaBiLevel"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaCeiling"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaFloor"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaInv"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaModFix"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaRepl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "biLevel"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blur"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "clrChange"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "clrRepl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "duotone"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fillOverlay"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "grayscl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hsl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lum"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tint"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "embed"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "link"), new QName("", "cstate")};
    private static final long serialVersionUID = 1;

    public CTBlipImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaBiLevelEffect addNewAlphaBiLevel() {
        CTAlphaBiLevelEffect cTAlphaBiLevelEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaBiLevelEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTAlphaBiLevelEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaCeilingEffect addNewAlphaCeiling() {
        CTAlphaCeilingEffect cTAlphaCeilingEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaCeilingEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTAlphaCeilingEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaFloorEffect addNewAlphaFloor() {
        CTAlphaFloorEffect cTAlphaFloorEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaFloorEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTAlphaFloorEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaInverseEffect addNewAlphaInv() {
        CTAlphaInverseEffect cTAlphaInverseEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaInverseEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTAlphaInverseEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateEffect addNewAlphaMod() {
        CTAlphaModulateEffect cTAlphaModulateEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTAlphaModulateEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateFixedEffect addNewAlphaModFix() {
        CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTAlphaModulateFixedEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaReplaceEffect addNewAlphaRepl() {
        CTAlphaReplaceEffect cTAlphaReplaceEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaReplaceEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTAlphaReplaceEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBiLevelEffect addNewBiLevel() {
        CTBiLevelEffect cTBiLevelEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBiLevelEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTBiLevelEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBlurEffect addNewBlur() {
        CTBlurEffect cTBlurEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlurEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTBlurEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorChangeEffect addNewClrChange() {
        CTColorChangeEffect cTColorChangeEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorChangeEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTColorChangeEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorReplaceEffect addNewClrRepl() {
        CTColorReplaceEffect cTColorReplaceEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorReplaceEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTColorReplaceEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTDuotoneEffect addNewDuotone() {
        CTDuotoneEffect cTDuotoneEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTDuotoneEffect = (CTDuotoneEffect) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTDuotoneEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTFillOverlayEffect addNewFillOverlay() {
        CTFillOverlayEffect cTFillOverlayEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillOverlayEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTFillOverlayEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTGrayscaleEffect addNewGrayscl() {
        CTGrayscaleEffect cTGrayscaleEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTGrayscaleEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTHSLEffect addNewHsl() {
        CTHSLEffect cTHSLEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHSLEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTHSLEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTLuminanceEffect addNewLum() {
        CTLuminanceEffect cTLuminanceEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLuminanceEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTLuminanceEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTTintEffect addNewTint() {
        CTTintEffect cTTintEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTintEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTTintEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaBiLevelEffect[] getAlphaBiLevelArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CTAlphaBiLevelEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaBiLevelEffect> getAlphaBiLevelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.pu
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaBiLevelArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.k90
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaBiLevelArray(((Integer) obj).intValue(), (CTAlphaBiLevelEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.c00
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaBiLevel(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaBiLevel(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.j1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaBiLevelArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaCeilingEffect[] getAlphaCeilingArray() {
        return getXmlObjectArray(PROPERTY_QNAME[1], (XmlObject[]) new CTAlphaCeilingEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaCeilingEffect> getAlphaCeilingList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.b40
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaCeilingArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ya0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaCeilingArray(((Integer) obj).intValue(), (CTAlphaCeilingEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xq
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaCeiling(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hr
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaCeiling(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.n30
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaCeilingArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaFloorEffect[] getAlphaFloorArray() {
        return getXmlObjectArray(PROPERTY_QNAME[2], (XmlObject[]) new CTAlphaFloorEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaFloorEffect> getAlphaFloorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.zi
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaFloorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.fd
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaFloorArray(((Integer) obj).intValue(), (CTAlphaFloorEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lb0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaFloor(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ea
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaFloor(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.b70
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaFloorArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaInverseEffect[] getAlphaInvArray() {
        return getXmlObjectArray(PROPERTY_QNAME[3], (XmlObject[]) new CTAlphaInverseEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaInverseEffect> getAlphaInvList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xm
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaInvArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rz
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaInvArray(((Integer) obj).intValue(), (CTAlphaInverseEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jo
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaInv(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaInv(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rg
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaInvArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateEffect[] getAlphaModArray() {
        return getXmlObjectArray(PROPERTY_QNAME[4], (XmlObject[]) new CTAlphaModulateEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateFixedEffect[] getAlphaModFixArray() {
        return (CTAlphaModulateFixedEffect[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTAlphaModulateFixedEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaModulateFixedEffect> getAlphaModFixList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.yq
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaModFixArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qf
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaModFixArray(((Integer) obj).intValue(), (CTAlphaModulateFixedEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaModFix(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.a20
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaModFix(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qj
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaModFixArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaModulateEffect> getAlphaModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.h0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hw
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaModArray(((Integer) obj).intValue(), (CTAlphaModulateEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.nk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rx
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.i80
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaReplaceEffect[] getAlphaReplArray() {
        return getXmlObjectArray(PROPERTY_QNAME[6], (XmlObject[]) new CTAlphaReplaceEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaReplaceEffect> getAlphaReplList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.g80
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaReplArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.s
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaReplArray(((Integer) obj).intValue(), (CTAlphaReplaceEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.tn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaRepl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaRepl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qp
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaReplArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBiLevelEffect[] getBiLevelArray() {
        return getXmlObjectArray(PROPERTY_QNAME[7], (XmlObject[]) new CTBiLevelEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTBiLevelEffect> getBiLevelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.s00
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBiLevelArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.u80
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBiLevelArray(((Integer) obj).intValue(), (CTBiLevelEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ir
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBiLevel(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.o0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBiLevel(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.vf
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBiLevelArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBlurEffect[] getBlurArray() {
        return getXmlObjectArray(PROPERTY_QNAME[8], (XmlObject[]) new CTBlurEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTBlurEffect> getBlurList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.id
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBlurArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBlurArray(((Integer) obj).intValue(), (CTBlurEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.kv
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBlur(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.p70
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBlur(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xk
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBlurArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorChangeEffect[] getClrChangeArray() {
        return getXmlObjectArray(PROPERTY_QNAME[9], (XmlObject[]) new CTColorChangeEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTColorChangeEffect> getClrChangeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ib
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getClrChangeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.u5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setClrChangeArray(((Integer) obj).intValue(), (CTColorChangeEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.c90
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewClrChange(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ho
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeClrChange(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.l50
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfClrChangeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorReplaceEffect[] getClrReplArray() {
        return getXmlObjectArray(PROPERTY_QNAME[10], (XmlObject[]) new CTColorReplaceEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTColorReplaceEffect> getClrReplList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.v7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getClrReplArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.j20
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setClrReplArray(((Integer) obj).intValue(), (CTColorReplaceEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.k50
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewClrRepl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.cs
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeClrRepl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qc
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfClrReplArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public STBlipCompression.Enum getCstate() {
        STBlipCompression.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[20]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[20]);
            }
            r1 = simpleValue == null ? null : (STBlipCompression.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTDuotoneEffect[] getDuotoneArray() {
        return (CTDuotoneEffect[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTDuotoneEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTDuotoneEffect> getDuotoneList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.n10
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDuotoneArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ge
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDuotoneArray(((Integer) obj).intValue(), (CTDuotoneEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.dh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDuotone(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDuotone(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gn
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDuotoneArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public String getEmbed() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[18]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[18]);
            }
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[17], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTFillOverlayEffect[] getFillOverlayArray() {
        return getXmlObjectArray(PROPERTY_QNAME[12], (XmlObject[]) new CTFillOverlayEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTFillOverlayEffect> getFillOverlayList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.bn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFillOverlayArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ca0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFillOverlayArray(((Integer) obj).intValue(), (CTFillOverlayEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.oo
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFillOverlay(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.d20
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFillOverlay(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jb0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFillOverlayArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTGrayscaleEffect[] getGraysclArray() {
        return getXmlObjectArray(PROPERTY_QNAME[13], (XmlObject[]) new CTGrayscaleEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTGrayscaleEffect> getGraysclList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGraysclArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.l4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGraysclArray(((Integer) obj).intValue(), (CTGrayscaleEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGrayscl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.bh
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGrayscl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ga
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGraysclArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTHSLEffect[] getHslArray() {
        return getXmlObjectArray(PROPERTY_QNAME[14], (XmlObject[]) new CTHSLEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTHSLEffect> getHslList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHslArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.fx
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHslArray(((Integer) obj).intValue(), (CTHSLEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ic0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHsl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.p4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHsl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.g7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHslArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public String getLink() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[19]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[19]);
            }
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTLuminanceEffect[] getLumArray() {
        return getXmlObjectArray(PROPERTY_QNAME[15], (XmlObject[]) new CTLuminanceEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTLuminanceEffect> getLumList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.im
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLumArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.v00
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLumArray(((Integer) obj).intValue(), (CTLuminanceEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLum(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qh
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLum(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLumArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTTintEffect[] getTintArray() {
        return getXmlObjectArray(PROPERTY_QNAME[16], (XmlObject[]) new CTTintEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTTintEffect> getTintList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.nb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTintArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gx
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTintArray(((Integer) obj).intValue(), (CTTintEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.kb0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTint(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lc0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTint(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.av
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTintArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaBiLevelEffect insertNewAlphaBiLevel(int i2) {
        CTAlphaBiLevelEffect cTAlphaBiLevelEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaBiLevelEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTAlphaBiLevelEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaCeilingEffect insertNewAlphaCeiling(int i2) {
        CTAlphaCeilingEffect cTAlphaCeilingEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaCeilingEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTAlphaCeilingEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaFloorEffect insertNewAlphaFloor(int i2) {
        CTAlphaFloorEffect cTAlphaFloorEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaFloorEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTAlphaFloorEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaInverseEffect insertNewAlphaInv(int i2) {
        CTAlphaInverseEffect cTAlphaInverseEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaInverseEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTAlphaInverseEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateEffect insertNewAlphaMod(int i2) {
        CTAlphaModulateEffect cTAlphaModulateEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTAlphaModulateEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateFixedEffect insertNewAlphaModFix(int i2) {
        CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTAlphaModulateFixedEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaReplaceEffect insertNewAlphaRepl(int i2) {
        CTAlphaReplaceEffect cTAlphaReplaceEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaReplaceEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTAlphaReplaceEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBiLevelEffect insertNewBiLevel(int i2) {
        CTBiLevelEffect cTBiLevelEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBiLevelEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTBiLevelEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBlurEffect insertNewBlur(int i2) {
        CTBlurEffect cTBlurEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlurEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTBlurEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorChangeEffect insertNewClrChange(int i2) {
        CTColorChangeEffect cTColorChangeEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorChangeEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTColorChangeEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorReplaceEffect insertNewClrRepl(int i2) {
        CTColorReplaceEffect cTColorReplaceEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorReplaceEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTColorReplaceEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTDuotoneEffect insertNewDuotone(int i2) {
        CTDuotoneEffect cTDuotoneEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTDuotoneEffect = (CTDuotoneEffect) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTDuotoneEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTFillOverlayEffect insertNewFillOverlay(int i2) {
        CTFillOverlayEffect cTFillOverlayEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillOverlayEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return cTFillOverlayEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTGrayscaleEffect insertNewGrayscl(int i2) {
        CTGrayscaleEffect cTGrayscaleEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return cTGrayscaleEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTHSLEffect insertNewHsl(int i2) {
        CTHSLEffect cTHSLEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHSLEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return cTHSLEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTLuminanceEffect insertNewLum(int i2) {
        CTLuminanceEffect cTLuminanceEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLuminanceEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return cTLuminanceEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTTintEffect insertNewTint(int i2) {
        CTTintEffect cTTintEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTintEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return cTTintEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public boolean isSetCstate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[20]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public boolean isSetEmbed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[18]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[17]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public boolean isSetLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[19]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaBiLevel(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaCeiling(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaFloor(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaInv(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaModFix(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaRepl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeBiLevel(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeBlur(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeClrChange(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeClrRepl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeDuotone(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeFillOverlay(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeGrayscl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeHsl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeLum(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeTint(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaBiLevelArray(CTAlphaBiLevelEffect[] cTAlphaBiLevelEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaBiLevelEffectArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaCeilingArray(CTAlphaCeilingEffect[] cTAlphaCeilingEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaCeilingEffectArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaFloorArray(CTAlphaFloorEffect[] cTAlphaFloorEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaFloorEffectArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaInvArray(CTAlphaInverseEffect[] cTAlphaInverseEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaInverseEffectArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaModArray(CTAlphaModulateEffect[] cTAlphaModulateEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaModulateEffectArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaModFixArray(CTAlphaModulateFixedEffect[] cTAlphaModulateFixedEffectArr) {
        check_orphaned();
        arraySetterHelper(cTAlphaModulateFixedEffectArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaReplArray(CTAlphaReplaceEffect[] cTAlphaReplaceEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaReplaceEffectArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setBiLevelArray(CTBiLevelEffect[] cTBiLevelEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBiLevelEffectArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setBlurArray(CTBlurEffect[] cTBlurEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBlurEffectArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setClrChangeArray(CTColorChangeEffect[] cTColorChangeEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTColorChangeEffectArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setClrReplArray(CTColorReplaceEffect[] cTColorReplaceEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTColorReplaceEffectArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setCstate(STBlipCompression.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[20]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[20]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setDuotoneArray(CTDuotoneEffect[] cTDuotoneEffectArr) {
        check_orphaned();
        arraySetterHelper(cTDuotoneEffectArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setEmbed(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[18]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[18]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[17], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setFillOverlayArray(CTFillOverlayEffect[] cTFillOverlayEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFillOverlayEffectArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setGraysclArray(CTGrayscaleEffect[] cTGrayscaleEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTGrayscaleEffectArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setHslArray(CTHSLEffect[] cTHSLEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTHSLEffectArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setLink(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[19]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[19]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setLumArray(CTLuminanceEffect[] cTLuminanceEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTLuminanceEffectArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setTintArray(CTTintEffect[] cTTintEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTintEffectArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaBiLevelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaCeilingArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaFloorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaInvArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaModFixArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaReplArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfBiLevelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfBlurArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfClrChangeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfClrReplArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfDuotoneArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfFillOverlayArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfGraysclArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfHslArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfLumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfTintArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void unsetCstate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[20]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void unsetEmbed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[18]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void unsetLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[19]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public STBlipCompression xgetCstate() {
        STBlipCompression sTBlipCompression;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTBlipCompression = (STBlipCompression) typeStore.find_attribute_user(qNameArr[20]);
            if (sTBlipCompression == null) {
                sTBlipCompression = (STBlipCompression) get_default_attribute_value(qNameArr[20]);
            }
        }
        return sTBlipCompression;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public STRelationshipId xgetEmbed() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTRelationshipId = (STRelationshipId) typeStore.find_attribute_user(qNameArr[18]);
            if (sTRelationshipId == null) {
                sTRelationshipId = (STRelationshipId) get_default_attribute_value(qNameArr[18]);
            }
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public STRelationshipId xgetLink() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTRelationshipId = (STRelationshipId) typeStore.find_attribute_user(qNameArr[19]);
            if (sTRelationshipId == null) {
                sTRelationshipId = (STRelationshipId) get_default_attribute_value(qNameArr[19]);
            }
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void xsetCstate(STBlipCompression sTBlipCompression) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STBlipCompression sTBlipCompression2 = (STBlipCompression) typeStore.find_attribute_user(qNameArr[20]);
            if (sTBlipCompression2 == null) {
                sTBlipCompression2 = (STBlipCompression) get_store().add_attribute_user(qNameArr[20]);
            }
            sTBlipCompression2.set(sTBlipCompression);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void xsetEmbed(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qNameArr[18]);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qNameArr[18]);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void xsetLink(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qNameArr[19]);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qNameArr[19]);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaBiLevelEffect getAlphaBiLevelArray(int i2) {
        CTAlphaBiLevelEffect cTAlphaBiLevelEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaBiLevelEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTAlphaBiLevelEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaBiLevelEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaCeilingEffect getAlphaCeilingArray(int i2) {
        CTAlphaCeilingEffect cTAlphaCeilingEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaCeilingEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTAlphaCeilingEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaCeilingEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaFloorEffect getAlphaFloorArray(int i2) {
        CTAlphaFloorEffect cTAlphaFloorEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaFloorEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTAlphaFloorEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaFloorEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaInverseEffect getAlphaInvArray(int i2) {
        CTAlphaInverseEffect cTAlphaInverseEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaInverseEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTAlphaInverseEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaInverseEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateEffect getAlphaModArray(int i2) {
        CTAlphaModulateEffect cTAlphaModulateEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTAlphaModulateEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaModulateEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateFixedEffect getAlphaModFixArray(int i2) {
        CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTAlphaModulateFixedEffect == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaModulateFixedEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaReplaceEffect getAlphaReplArray(int i2) {
        CTAlphaReplaceEffect cTAlphaReplaceEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaReplaceEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTAlphaReplaceEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaReplaceEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBiLevelEffect getBiLevelArray(int i2) {
        CTBiLevelEffect cTBiLevelEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBiLevelEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTBiLevelEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBiLevelEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBlurEffect getBlurArray(int i2) {
        CTBlurEffect cTBlurEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlurEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTBlurEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBlurEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorChangeEffect getClrChangeArray(int i2) {
        CTColorChangeEffect cTColorChangeEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorChangeEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTColorChangeEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTColorChangeEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorReplaceEffect getClrReplArray(int i2) {
        CTColorReplaceEffect cTColorReplaceEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorReplaceEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTColorReplaceEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTColorReplaceEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTDuotoneEffect getDuotoneArray(int i2) {
        CTDuotoneEffect cTDuotoneEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTDuotoneEffect = (CTDuotoneEffect) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (cTDuotoneEffect == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDuotoneEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTFillOverlayEffect getFillOverlayArray(int i2) {
        CTFillOverlayEffect cTFillOverlayEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillOverlayEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (cTFillOverlayEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFillOverlayEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTGrayscaleEffect getGraysclArray(int i2) {
        CTGrayscaleEffect cTGrayscaleEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (cTGrayscaleEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGrayscaleEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTHSLEffect getHslArray(int i2) {
        CTHSLEffect cTHSLEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHSLEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (cTHSLEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHSLEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTLuminanceEffect getLumArray(int i2) {
        CTLuminanceEffect cTLuminanceEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLuminanceEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (cTLuminanceEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLuminanceEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTTintEffect getTintArray(int i2) {
        CTTintEffect cTTintEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTintEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (cTTintEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTintEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaBiLevelArray(int i2, CTAlphaBiLevelEffect cTAlphaBiLevelEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaBiLevelEffect, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaCeilingArray(int i2, CTAlphaCeilingEffect cTAlphaCeilingEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaCeilingEffect, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaFloorArray(int i2, CTAlphaFloorEffect cTAlphaFloorEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaFloorEffect, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaInvArray(int i2, CTAlphaInverseEffect cTAlphaInverseEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaInverseEffect, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaModArray(int i2, CTAlphaModulateEffect cTAlphaModulateEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaModulateEffect, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaModFixArray(int i2, CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaModulateFixedEffect, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaReplArray(int i2, CTAlphaReplaceEffect cTAlphaReplaceEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaReplaceEffect, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setBiLevelArray(int i2, CTBiLevelEffect cTBiLevelEffect) throws Throwable {
        generatedSetterHelperImpl(cTBiLevelEffect, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setBlurArray(int i2, CTBlurEffect cTBlurEffect) throws Throwable {
        generatedSetterHelperImpl(cTBlurEffect, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setClrChangeArray(int i2, CTColorChangeEffect cTColorChangeEffect) throws Throwable {
        generatedSetterHelperImpl(cTColorChangeEffect, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setClrReplArray(int i2, CTColorReplaceEffect cTColorReplaceEffect) throws Throwable {
        generatedSetterHelperImpl(cTColorReplaceEffect, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setDuotoneArray(int i2, CTDuotoneEffect cTDuotoneEffect) throws Throwable {
        generatedSetterHelperImpl(cTDuotoneEffect, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setFillOverlayArray(int i2, CTFillOverlayEffect cTFillOverlayEffect) throws Throwable {
        generatedSetterHelperImpl(cTFillOverlayEffect, PROPERTY_QNAME[12], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setGraysclArray(int i2, CTGrayscaleEffect cTGrayscaleEffect) throws Throwable {
        generatedSetterHelperImpl(cTGrayscaleEffect, PROPERTY_QNAME[13], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setHslArray(int i2, CTHSLEffect cTHSLEffect) throws Throwable {
        generatedSetterHelperImpl(cTHSLEffect, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setLumArray(int i2, CTLuminanceEffect cTLuminanceEffect) throws Throwable {
        generatedSetterHelperImpl(cTLuminanceEffect, PROPERTY_QNAME[15], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setTintArray(int i2, CTTintEffect cTTintEffect) throws Throwable {
        generatedSetterHelperImpl(cTTintEffect, PROPERTY_QNAME[16], i2, (short) 2);
    }
}
