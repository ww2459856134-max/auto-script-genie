package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.tencent.open.SocialConstants;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaBiLevelEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaCeilingEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaFloorEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaInverseEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaOutsetEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaReplaceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBiLevelEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlendEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlurEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorChangeEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorReplaceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDuotoneEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillOverlayEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGlowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGrayscaleEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHSLEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInnerShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLuminanceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTReflectionEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeOffsetEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSoftEdgesEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTintEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransformEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.STEffectContainerType;
import org.openxmlformats.schemas.drawingml.x2006.main.STEffectContainerType$Enum;

/* loaded from: classes2.dex */
public class CTEffectContainerImpl extends XmlComplexContentImpl implements CTEffectContainer {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "cont"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "effect"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaBiLevel"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaCeiling"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaFloor"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaInv"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaMod"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaModFix"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaOutset"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaRepl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "biLevel"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blend"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blur"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "clrChange"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "clrRepl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "duotone"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fill"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fillOverlay"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "glow"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "grayscl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hsl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "innerShdw"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lum"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "outerShdw"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "prstShdw"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "reflection"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "relOff"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "softEdge"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tint"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "xfrm"), new QName("", SocialConstants.PARAM_TYPE), new QName("", "name")};
    private static final long serialVersionUID = 1;

    public CTEffectContainerImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaBiLevelEffect addNewAlphaBiLevel() {
        CTAlphaBiLevelEffect cTAlphaBiLevelEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaBiLevelEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTAlphaBiLevelEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaCeilingEffect addNewAlphaCeiling() {
        CTAlphaCeilingEffect cTAlphaCeilingEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaCeilingEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTAlphaCeilingEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaFloorEffect addNewAlphaFloor() {
        CTAlphaFloorEffect cTAlphaFloorEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaFloorEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTAlphaFloorEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaInverseEffect addNewAlphaInv() {
        CTAlphaInverseEffect cTAlphaInverseEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaInverseEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTAlphaInverseEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateEffect addNewAlphaMod() {
        CTAlphaModulateEffect cTAlphaModulateEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTAlphaModulateEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateFixedEffect addNewAlphaModFix() {
        CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTAlphaModulateFixedEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaOutsetEffect addNewAlphaOutset() {
        CTAlphaOutsetEffect cTAlphaOutsetEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaOutsetEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTAlphaOutsetEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaReplaceEffect addNewAlphaRepl() {
        CTAlphaReplaceEffect cTAlphaReplaceEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaReplaceEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTAlphaReplaceEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBiLevelEffect addNewBiLevel() {
        CTBiLevelEffect cTBiLevelEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBiLevelEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTBiLevelEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlendEffect addNewBlend() {
        CTBlendEffect cTBlendEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlendEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTBlendEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlurEffect addNewBlur() {
        CTBlurEffect cTBlurEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlurEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTBlurEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorChangeEffect addNewClrChange() {
        CTColorChangeEffect cTColorChangeEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorChangeEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTColorChangeEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorReplaceEffect addNewClrRepl() {
        CTColorReplaceEffect cTColorReplaceEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorReplaceEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTColorReplaceEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectContainer addNewCont() {
        CTEffectContainer cTEffectContainer;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectContainer = (CTEffectContainer) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTEffectContainer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTDuotoneEffect addNewDuotone() {
        CTDuotoneEffect cTDuotoneEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTDuotoneEffect = (CTDuotoneEffect) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTDuotoneEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectReference addNewEffect() {
        CTEffectReference cTEffectReferenceAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectReferenceAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTEffectReferenceAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillEffect addNewFill() {
        CTFillEffect cTFillEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTFillEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillOverlayEffect addNewFillOverlay() {
        CTFillOverlayEffect cTFillOverlayEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillOverlayEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTFillOverlayEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGlowEffect addNewGlow() {
        CTGlowEffect cTGlowEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGlowEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTGlowEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGrayscaleEffect addNewGrayscl() {
        CTGrayscaleEffect cTGrayscaleEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTGrayscaleEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTHSLEffect addNewHsl() {
        CTHSLEffect cTHSLEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHSLEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTHSLEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTInnerShadowEffect addNewInnerShdw() {
        CTInnerShadowEffect cTInnerShadowEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInnerShadowEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTInnerShadowEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTLuminanceEffect addNewLum() {
        CTLuminanceEffect cTLuminanceEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLuminanceEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTLuminanceEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTOuterShadowEffect addNewOuterShdw() {
        CTOuterShadowEffect cTOuterShadowEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTOuterShadowEffect = (CTOuterShadowEffect) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTOuterShadowEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTPresetShadowEffect addNewPrstShdw() {
        CTPresetShadowEffect cTPresetShadowEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetShadowEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTPresetShadowEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTReflectionEffect addNewReflection() {
        CTReflectionEffect cTReflectionEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTReflectionEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTReflectionEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTRelativeOffsetEffect addNewRelOff() {
        CTRelativeOffsetEffect cTRelativeOffsetEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeOffsetEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTRelativeOffsetEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTSoftEdgesEffect addNewSoftEdge() {
        CTSoftEdgesEffect cTSoftEdgesEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSoftEdgesEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTSoftEdgesEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTintEffect addNewTint() {
        CTTintEffect cTTintEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTintEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[28]);
        }
        return cTTintEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTransformEffect addNewXfrm() {
        CTTransformEffect cTTransformEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTransformEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[29]);
        }
        return cTTransformEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaBiLevelEffect[] getAlphaBiLevelArray() {
        return getXmlObjectArray(PROPERTY_QNAME[2], (XmlObject[]) new CTAlphaBiLevelEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaBiLevelEffect> getAlphaBiLevelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.zs
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaBiLevelArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.z5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaBiLevelArray(((Integer) obj).intValue(), (CTAlphaBiLevelEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xe
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaBiLevel(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qd
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaBiLevel(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.s1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaBiLevelArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaCeilingEffect[] getAlphaCeilingArray() {
        return getXmlObjectArray(PROPERTY_QNAME[3], (XmlObject[]) new CTAlphaCeilingEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaCeilingEffect> getAlphaCeilingList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.s8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaCeilingArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.mm
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaCeilingArray(((Integer) obj).intValue(), (CTAlphaCeilingEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jc0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaCeiling(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.if
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaCeiling(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y40
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaCeilingArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaFloorEffect[] getAlphaFloorArray() {
        return getXmlObjectArray(PROPERTY_QNAME[4], (XmlObject[]) new CTAlphaFloorEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaFloorEffect> getAlphaFloorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.e40
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaFloorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.zp
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaFloorArray(((Integer) obj).intValue(), (CTAlphaFloorEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.oi
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaFloor(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rl
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaFloor(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gg
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaFloorArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaInverseEffect[] getAlphaInvArray() {
        return getXmlObjectArray(PROPERTY_QNAME[5], (XmlObject[]) new CTAlphaInverseEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaInverseEffect> getAlphaInvList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaInvArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.cb
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaInvArray(((Integer) obj).intValue(), (CTAlphaInverseEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ea0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaInv(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.d80
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaInv(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.e5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaInvArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateEffect[] getAlphaModArray() {
        return getXmlObjectArray(PROPERTY_QNAME[6], (XmlObject[]) new CTAlphaModulateEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateFixedEffect[] getAlphaModFixArray() {
        return (CTAlphaModulateFixedEffect[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTAlphaModulateFixedEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaModulateFixedEffect> getAlphaModFixList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.my
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaModFixArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.cd
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaModFixArray(((Integer) obj).intValue(), (CTAlphaModulateFixedEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xw
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaModFix(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.a90
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaModFix(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.bd
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaModFixArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaModulateEffect> getAlphaModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ip
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaModArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.al
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaModArray(((Integer) obj).intValue(), (CTAlphaModulateEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ma
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaMod(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.mo
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaMod(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jd
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaModArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaOutsetEffect[] getAlphaOutsetArray() {
        return getXmlObjectArray(PROPERTY_QNAME[8], (XmlObject[]) new CTAlphaOutsetEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaOutsetEffect> getAlphaOutsetList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.j90
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaOutsetArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.t70
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaOutsetArray(((Integer) obj).intValue(), (CTAlphaOutsetEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.bv
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaOutset(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.po
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaOutset(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.x70
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaOutsetArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaReplaceEffect[] getAlphaReplArray() {
        return getXmlObjectArray(PROPERTY_QNAME[9], (XmlObject[]) new CTAlphaReplaceEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaReplaceEffect> getAlphaReplList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.vx
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAlphaReplArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.nc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAlphaReplArray(((Integer) obj).intValue(), (CTAlphaReplaceEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.w90
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAlphaRepl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.u20
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAlphaRepl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.fp
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAlphaReplArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBiLevelEffect[] getBiLevelArray() {
        return getXmlObjectArray(PROPERTY_QNAME[10], (XmlObject[]) new CTBiLevelEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTBiLevelEffect> getBiLevelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ha0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBiLevelArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.za0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBiLevelArray(((Integer) obj).intValue(), (CTBiLevelEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.k3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBiLevel(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jz
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBiLevel(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jv
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBiLevelArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlendEffect[] getBlendArray() {
        return getXmlObjectArray(PROPERTY_QNAME[11], (XmlObject[]) new CTBlendEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTBlendEffect> getBlendList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.r70
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBlendArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.dl
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBlendArray(((Integer) obj).intValue(), (CTBlendEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m80
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBlend(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.u10
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBlend(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.u2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBlendArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlurEffect[] getBlurArray() {
        return getXmlObjectArray(PROPERTY_QNAME[12], (XmlObject[]) new CTBlurEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTBlurEffect> getBlurList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.kw
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBlurArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.me
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBlurArray(((Integer) obj).intValue(), (CTBlurEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.c2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBlur(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ht
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBlur(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBlurArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorChangeEffect[] getClrChangeArray() {
        return getXmlObjectArray(PROPERTY_QNAME[13], (XmlObject[]) new CTColorChangeEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTColorChangeEffect> getClrChangeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ab0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getClrChangeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sv
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setClrChangeArray(((Integer) obj).intValue(), (CTColorChangeEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.i5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewClrChange(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.n0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeClrChange(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ko
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfClrChangeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorReplaceEffect[] getClrReplArray() {
        return getXmlObjectArray(PROPERTY_QNAME[14], (XmlObject[]) new CTColorReplaceEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTColorReplaceEffect> getClrReplList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.j9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getClrReplArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.v60
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setClrReplArray(((Integer) obj).intValue(), (CTColorReplaceEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.p60
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewClrRepl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ml
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeClrRepl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.at
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfClrReplArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectContainer[] getContArray() {
        return (CTEffectContainer[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTEffectContainer[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTEffectContainer> getContList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getContArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.tu
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setContArray(((Integer) obj).intValue(), (CTEffectContainer) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCont(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.p7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCont(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qq
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfContArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTDuotoneEffect[] getDuotoneArray() {
        return (CTDuotoneEffect[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTDuotoneEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTDuotoneEffect> getDuotoneList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rc0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDuotoneArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ih
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDuotoneArray(((Integer) obj).intValue(), (CTDuotoneEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.dy
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDuotone(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.mp
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDuotone(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.a00
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDuotoneArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectReference[] getEffectArray() {
        return getXmlObjectArray(PROPERTY_QNAME[1], (XmlObject[]) new CTEffectReference[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTEffectReference> getEffectList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y20
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEffectArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xr
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEffectArray(((Integer) obj).intValue(), (CTEffectReference) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEffect(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.py
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEffect(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.w70
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEffectArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillEffect[] getFillArray() {
        return getXmlObjectArray(PROPERTY_QNAME[16], (XmlObject[]) new CTFillEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTFillEffect> getFillList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.u3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFillArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.h7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFillArray(((Integer) obj).intValue(), (CTFillEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.e9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFill(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.q60
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFill(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.nh
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFillArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillOverlayEffect[] getFillOverlayArray() {
        return getXmlObjectArray(PROPERTY_QNAME[17], (XmlObject[]) new CTFillOverlayEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTFillOverlayEffect> getFillOverlayList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hi
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFillOverlayArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.i
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFillOverlayArray(((Integer) obj).intValue(), (CTFillOverlayEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.j7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFillOverlay(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.l20
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFillOverlay(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jk
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFillOverlayArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGlowEffect[] getGlowArray() {
        return getXmlObjectArray(PROPERTY_QNAME[18], (XmlObject[]) new CTGlowEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTGlowEffect> getGlowList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ij
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGlowArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jj
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGlowArray(((Integer) obj).intValue(), (CTGlowEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qz
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGlow(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.f60
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGlow(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.fb0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGlowArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGrayscaleEffect[] getGraysclArray() {
        return getXmlObjectArray(PROPERTY_QNAME[19], (XmlObject[]) new CTGrayscaleEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTGrayscaleEffect> getGraysclList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.cz
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGraysclArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.t0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGraysclArray(((Integer) obj).intValue(), (CTGrayscaleEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.i1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGrayscl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.w40
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGrayscl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.yt
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGraysclArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTHSLEffect[] getHslArray() {
        return getXmlObjectArray(PROPERTY_QNAME[20], (XmlObject[]) new CTHSLEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTHSLEffect> getHslList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ct
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHslArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.bl
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHslArray(((Integer) obj).intValue(), (CTHSLEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rm
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHsl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.d50
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHsl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.oh
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHslArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTInnerShadowEffect[] getInnerShdwArray() {
        return getXmlObjectArray(PROPERTY_QNAME[21], (XmlObject[]) new CTInnerShadowEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTInnerShadowEffect> getInnerShdwList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.d70
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getInnerShdwArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.rq
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setInnerShdwArray(((Integer) obj).intValue(), (CTInnerShadowEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ch
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewInnerShdw(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.d4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeInnerShdw(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gv
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfInnerShdwArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTLuminanceEffect[] getLumArray() {
        return getXmlObjectArray(PROPERTY_QNAME[22], (XmlObject[]) new CTLuminanceEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTLuminanceEffect> getLumList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.y0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLumArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.t20
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLumArray(((Integer) obj).intValue(), (CTLuminanceEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.h1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLum(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.d1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLum(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.eh
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLumArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public String getName() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[31]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTOuterShadowEffect[] getOuterShdwArray() {
        return (CTOuterShadowEffect[]) getXmlObjectArray(PROPERTY_QNAME[23], new CTOuterShadowEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTOuterShadowEffect> getOuterShdwList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.e0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOuterShdwArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.s80
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOuterShdwArray(((Integer) obj).intValue(), (CTOuterShadowEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.m2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOuterShdw(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.x00
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOuterShdw(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.tm
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOuterShdwArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTPresetShadowEffect[] getPrstShdwArray() {
        return getXmlObjectArray(PROPERTY_QNAME[24], (XmlObject[]) new CTPresetShadowEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTPresetShadowEffect> getPrstShdwList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.kd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPrstShdwArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.zh
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPrstShdwArray(((Integer) obj).intValue(), (CTPresetShadowEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.r00
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPrstShdw(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xu
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePrstShdw(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.yk
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPrstShdwArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTReflectionEffect[] getReflectionArray() {
        return getXmlObjectArray(PROPERTY_QNAME[25], (XmlObject[]) new CTReflectionEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTReflectionEffect> getReflectionList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.f50
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getReflectionArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ez
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setReflectionArray(((Integer) obj).intValue(), (CTReflectionEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.s30
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewReflection(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.s0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeReflection(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ci
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfReflectionArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTRelativeOffsetEffect[] getRelOffArray() {
        return getXmlObjectArray(PROPERTY_QNAME[26], (XmlObject[]) new CTRelativeOffsetEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTRelativeOffsetEffect> getRelOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.x80
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRelOffArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.cy
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRelOffArray(((Integer) obj).intValue(), (CTRelativeOffsetEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ec0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRelOff(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.cv
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRelOff(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.r0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRelOffArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTSoftEdgesEffect[] getSoftEdgeArray() {
        return getXmlObjectArray(PROPERTY_QNAME[27], (XmlObject[]) new CTSoftEdgesEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTSoftEdgesEffect> getSoftEdgeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.yo
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSoftEdgeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.c8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSoftEdgeArray(((Integer) obj).intValue(), (CTSoftEdgesEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.u1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSoftEdge(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ze
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSoftEdge(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.c
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSoftEdgeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTintEffect[] getTintArray() {
        return getXmlObjectArray(PROPERTY_QNAME[28], (XmlObject[]) new CTTintEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTTintEffect> getTintList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.l0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTintArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.o6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTintArray(((Integer) obj).intValue(), (CTTintEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ce
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTint(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.r5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTint(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.df
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTintArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public STEffectContainerType$Enum getType() {
        STEffectContainerType$Enum sTEffectContainerType$Enum;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[30]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[30]);
            }
            sTEffectContainerType$Enum = simpleValue == null ? null : (STEffectContainerType$Enum) simpleValue.getEnumValue();
        }
        return sTEffectContainerType$Enum;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTransformEffect[] getXfrmArray() {
        return getXmlObjectArray(PROPERTY_QNAME[29], (XmlObject[]) new CTTransformEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTTransformEffect> getXfrmList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.h80
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getXfrmArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.x1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setXfrmArray(((Integer) obj).intValue(), (CTTransformEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.od
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewXfrm(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xa
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeXfrm(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.db
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfXfrmArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaBiLevelEffect insertNewAlphaBiLevel(int i2) {
        CTAlphaBiLevelEffect cTAlphaBiLevelEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaBiLevelEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTAlphaBiLevelEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaCeilingEffect insertNewAlphaCeiling(int i2) {
        CTAlphaCeilingEffect cTAlphaCeilingEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaCeilingEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTAlphaCeilingEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaFloorEffect insertNewAlphaFloor(int i2) {
        CTAlphaFloorEffect cTAlphaFloorEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaFloorEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTAlphaFloorEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaInverseEffect insertNewAlphaInv(int i2) {
        CTAlphaInverseEffect cTAlphaInverseEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaInverseEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTAlphaInverseEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateEffect insertNewAlphaMod(int i2) {
        CTAlphaModulateEffect cTAlphaModulateEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTAlphaModulateEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateFixedEffect insertNewAlphaModFix(int i2) {
        CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTAlphaModulateFixedEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaOutsetEffect insertNewAlphaOutset(int i2) {
        CTAlphaOutsetEffect cTAlphaOutsetEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaOutsetEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTAlphaOutsetEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaReplaceEffect insertNewAlphaRepl(int i2) {
        CTAlphaReplaceEffect cTAlphaReplaceEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaReplaceEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTAlphaReplaceEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBiLevelEffect insertNewBiLevel(int i2) {
        CTBiLevelEffect cTBiLevelEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBiLevelEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTBiLevelEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlendEffect insertNewBlend(int i2) {
        CTBlendEffect cTBlendEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlendEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTBlendEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlurEffect insertNewBlur(int i2) {
        CTBlurEffect cTBlurEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlurEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return cTBlurEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorChangeEffect insertNewClrChange(int i2) {
        CTColorChangeEffect cTColorChangeEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorChangeEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return cTColorChangeEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorReplaceEffect insertNewClrRepl(int i2) {
        CTColorReplaceEffect cTColorReplaceEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorReplaceEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return cTColorReplaceEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectContainer insertNewCont(int i2) {
        CTEffectContainer cTEffectContainer;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectContainer = (CTEffectContainer) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTEffectContainer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTDuotoneEffect insertNewDuotone(int i2) {
        CTDuotoneEffect cTDuotoneEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTDuotoneEffect = (CTDuotoneEffect) get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return cTDuotoneEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectReference insertNewEffect(int i2) {
        CTEffectReference cTEffectReferenceInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectReferenceInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTEffectReferenceInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillEffect insertNewFill(int i2) {
        CTFillEffect cTFillEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return cTFillEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillOverlayEffect insertNewFillOverlay(int i2) {
        CTFillOverlayEffect cTFillOverlayEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillOverlayEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[17], i2);
        }
        return cTFillOverlayEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGlowEffect insertNewGlow(int i2) {
        CTGlowEffect cTGlowEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGlowEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[18], i2);
        }
        return cTGlowEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGrayscaleEffect insertNewGrayscl(int i2) {
        CTGrayscaleEffect cTGrayscaleEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[19], i2);
        }
        return cTGrayscaleEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTHSLEffect insertNewHsl(int i2) {
        CTHSLEffect cTHSLEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHSLEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[20], i2);
        }
        return cTHSLEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTInnerShadowEffect insertNewInnerShdw(int i2) {
        CTInnerShadowEffect cTInnerShadowEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInnerShadowEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[21], i2);
        }
        return cTInnerShadowEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTLuminanceEffect insertNewLum(int i2) {
        CTLuminanceEffect cTLuminanceEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLuminanceEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[22], i2);
        }
        return cTLuminanceEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTOuterShadowEffect insertNewOuterShdw(int i2) {
        CTOuterShadowEffect cTOuterShadowEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTOuterShadowEffect = (CTOuterShadowEffect) get_store().insert_element_user(PROPERTY_QNAME[23], i2);
        }
        return cTOuterShadowEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTPresetShadowEffect insertNewPrstShdw(int i2) {
        CTPresetShadowEffect cTPresetShadowEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetShadowEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[24], i2);
        }
        return cTPresetShadowEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTReflectionEffect insertNewReflection(int i2) {
        CTReflectionEffect cTReflectionEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTReflectionEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[25], i2);
        }
        return cTReflectionEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTRelativeOffsetEffect insertNewRelOff(int i2) {
        CTRelativeOffsetEffect cTRelativeOffsetEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeOffsetEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[26], i2);
        }
        return cTRelativeOffsetEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTSoftEdgesEffect insertNewSoftEdge(int i2) {
        CTSoftEdgesEffect cTSoftEdgesEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSoftEdgesEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[27], i2);
        }
        return cTSoftEdgesEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTintEffect insertNewTint(int i2) {
        CTTintEffect cTTintEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTintEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[28], i2);
        }
        return cTTintEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTransformEffect insertNewXfrm(int i2) {
        CTTransformEffect cTTransformEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTransformEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[29], i2);
        }
        return cTTransformEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[31]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[30]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaBiLevel(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaCeiling(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaFloor(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaInv(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaMod(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaModFix(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaOutset(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaRepl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeBiLevel(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeBlend(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeBlur(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeClrChange(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeClrRepl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeCont(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeDuotone(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeEffect(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeFill(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeFillOverlay(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeGlow(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeGrayscl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeHsl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeInnerShdw(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeLum(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeOuterShdw(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removePrstShdw(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeReflection(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeRelOff(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeSoftEdge(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeTint(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[28], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeXfrm(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[29], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaBiLevelArray(CTAlphaBiLevelEffect[] cTAlphaBiLevelEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaBiLevelEffectArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaCeilingArray(CTAlphaCeilingEffect[] cTAlphaCeilingEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaCeilingEffectArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaFloorArray(CTAlphaFloorEffect[] cTAlphaFloorEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaFloorEffectArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaInvArray(CTAlphaInverseEffect[] cTAlphaInverseEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaInverseEffectArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaModArray(CTAlphaModulateEffect[] cTAlphaModulateEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaModulateEffectArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaModFixArray(CTAlphaModulateFixedEffect[] cTAlphaModulateFixedEffectArr) {
        check_orphaned();
        arraySetterHelper(cTAlphaModulateFixedEffectArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaOutsetArray(CTAlphaOutsetEffect[] cTAlphaOutsetEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaOutsetEffectArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaReplArray(CTAlphaReplaceEffect[] cTAlphaReplaceEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaReplaceEffectArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setBiLevelArray(CTBiLevelEffect[] cTBiLevelEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBiLevelEffectArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setBlendArray(CTBlendEffect[] cTBlendEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBlendEffectArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setBlurArray(CTBlurEffect[] cTBlurEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBlurEffectArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setClrChangeArray(CTColorChangeEffect[] cTColorChangeEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTColorChangeEffectArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setClrReplArray(CTColorReplaceEffect[] cTColorReplaceEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTColorReplaceEffectArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setContArray(CTEffectContainer[] cTEffectContainerArr) {
        check_orphaned();
        arraySetterHelper(cTEffectContainerArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setDuotoneArray(CTDuotoneEffect[] cTDuotoneEffectArr) {
        check_orphaned();
        arraySetterHelper(cTDuotoneEffectArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setEffectArray(CTEffectReference[] cTEffectReferenceArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTEffectReferenceArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setFillArray(CTFillEffect[] cTFillEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFillEffectArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setFillOverlayArray(CTFillOverlayEffect[] cTFillOverlayEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFillOverlayEffectArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setGlowArray(CTGlowEffect[] cTGlowEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTGlowEffectArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setGraysclArray(CTGrayscaleEffect[] cTGrayscaleEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTGrayscaleEffectArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setHslArray(CTHSLEffect[] cTHSLEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTHSLEffectArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setInnerShdwArray(CTInnerShadowEffect[] cTInnerShadowEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTInnerShadowEffectArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setLumArray(CTLuminanceEffect[] cTLuminanceEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTLuminanceEffectArr, PROPERTY_QNAME[22]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[31]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[31]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setOuterShdwArray(CTOuterShadowEffect[] cTOuterShadowEffectArr) {
        check_orphaned();
        arraySetterHelper(cTOuterShadowEffectArr, PROPERTY_QNAME[23]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setPrstShdwArray(CTPresetShadowEffect[] cTPresetShadowEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTPresetShadowEffectArr, PROPERTY_QNAME[24]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setReflectionArray(CTReflectionEffect[] cTReflectionEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTReflectionEffectArr, PROPERTY_QNAME[25]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setRelOffArray(CTRelativeOffsetEffect[] cTRelativeOffsetEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTRelativeOffsetEffectArr, PROPERTY_QNAME[26]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setSoftEdgeArray(CTSoftEdgesEffect[] cTSoftEdgesEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTSoftEdgesEffectArr, PROPERTY_QNAME[27]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setTintArray(CTTintEffect[] cTTintEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTintEffectArr, PROPERTY_QNAME[28]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setType(STEffectContainerType$Enum sTEffectContainerType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[30]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[30]);
            }
            simpleValue.setEnumValue(sTEffectContainerType$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setXfrmArray(CTTransformEffect[] cTTransformEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTransformEffectArr, PROPERTY_QNAME[29]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaBiLevelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaCeilingArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaFloorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaInvArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaModFixArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaOutsetArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaReplArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfBiLevelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfBlendArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfBlurArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfClrChangeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfClrReplArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfContArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfDuotoneArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfEffectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfFillOverlayArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfGlowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfGraysclArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfHslArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfInnerShdwArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfLumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfOuterShdwArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfPrstShdwArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfReflectionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfRelOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfSoftEdgeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfTintArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[28]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfXfrmArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[29]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[31]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[30]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public XmlToken xgetName() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(PROPERTY_QNAME[31]);
        }
        return xmlToken;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public STEffectContainerType xgetType() {
        STEffectContainerType sTEffectContainerTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTEffectContainerTypeFind_attribute_user = typeStore.find_attribute_user(qNameArr[30]);
            if (sTEffectContainerTypeFind_attribute_user == null) {
                sTEffectContainerTypeFind_attribute_user = (STEffectContainerType) get_default_attribute_value(qNameArr[30]);
            }
        }
        return sTEffectContainerTypeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void xsetName(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qNameArr[31]);
            if (xmlToken2 == null) {
                xmlToken2 = (XmlToken) get_store().add_attribute_user(qNameArr[31]);
            }
            xmlToken2.set(xmlToken);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void xsetType(STEffectContainerType sTEffectContainerType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STEffectContainerType sTEffectContainerTypeFind_attribute_user = typeStore.find_attribute_user(qNameArr[30]);
            if (sTEffectContainerTypeFind_attribute_user == null) {
                sTEffectContainerTypeFind_attribute_user = (STEffectContainerType) get_store().add_attribute_user(qNameArr[30]);
            }
            sTEffectContainerTypeFind_attribute_user.set(sTEffectContainerType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaBiLevelEffect getAlphaBiLevelArray(int i2) {
        CTAlphaBiLevelEffect cTAlphaBiLevelEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaBiLevelEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTAlphaBiLevelEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaBiLevelEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaCeilingEffect getAlphaCeilingArray(int i2) {
        CTAlphaCeilingEffect cTAlphaCeilingEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaCeilingEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTAlphaCeilingEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaCeilingEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaFloorEffect getAlphaFloorArray(int i2) {
        CTAlphaFloorEffect cTAlphaFloorEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaFloorEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTAlphaFloorEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaFloorEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaInverseEffect getAlphaInvArray(int i2) {
        CTAlphaInverseEffect cTAlphaInverseEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaInverseEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTAlphaInverseEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaInverseEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateEffect getAlphaModArray(int i2) {
        CTAlphaModulateEffect cTAlphaModulateEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTAlphaModulateEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaModulateEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateFixedEffect getAlphaModFixArray(int i2) {
        CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTAlphaModulateFixedEffect == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaModulateFixedEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaOutsetEffect getAlphaOutsetArray(int i2) {
        CTAlphaOutsetEffect cTAlphaOutsetEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaOutsetEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTAlphaOutsetEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaOutsetEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaReplaceEffect getAlphaReplArray(int i2) {
        CTAlphaReplaceEffect cTAlphaReplaceEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaReplaceEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTAlphaReplaceEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaReplaceEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBiLevelEffect getBiLevelArray(int i2) {
        CTBiLevelEffect cTBiLevelEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBiLevelEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTBiLevelEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBiLevelEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlendEffect getBlendArray(int i2) {
        CTBlendEffect cTBlendEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlendEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (cTBlendEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBlendEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlurEffect getBlurArray(int i2) {
        CTBlurEffect cTBlurEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlurEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (cTBlurEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBlurEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorChangeEffect getClrChangeArray(int i2) {
        CTColorChangeEffect cTColorChangeEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorChangeEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (cTColorChangeEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTColorChangeEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorReplaceEffect getClrReplArray(int i2) {
        CTColorReplaceEffect cTColorReplaceEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorReplaceEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (cTColorReplaceEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTColorReplaceEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectContainer getContArray(int i2) {
        CTEffectContainer cTEffectContainer;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectContainer = (CTEffectContainer) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTEffectContainer == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEffectContainer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTDuotoneEffect getDuotoneArray(int i2) {
        CTDuotoneEffect cTDuotoneEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTDuotoneEffect = (CTDuotoneEffect) get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (cTDuotoneEffect == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDuotoneEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectReference getEffectArray(int i2) {
        CTEffectReference cTEffectReferenceFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectReferenceFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTEffectReferenceFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEffectReferenceFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillEffect getFillArray(int i2) {
        CTFillEffect cTFillEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (cTFillEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFillEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillOverlayEffect getFillOverlayArray(int i2) {
        CTFillOverlayEffect cTFillOverlayEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillOverlayEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (cTFillOverlayEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFillOverlayEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGlowEffect getGlowArray(int i2) {
        CTGlowEffect cTGlowEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGlowEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[18], i2);
            if (cTGlowEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGlowEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGrayscaleEffect getGraysclArray(int i2) {
        CTGrayscaleEffect cTGrayscaleEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[19], i2);
            if (cTGrayscaleEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGrayscaleEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTHSLEffect getHslArray(int i2) {
        CTHSLEffect cTHSLEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHSLEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[20], i2);
            if (cTHSLEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHSLEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTInnerShadowEffect getInnerShdwArray(int i2) {
        CTInnerShadowEffect cTInnerShadowEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInnerShadowEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[21], i2);
            if (cTInnerShadowEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTInnerShadowEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTLuminanceEffect getLumArray(int i2) {
        CTLuminanceEffect cTLuminanceEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLuminanceEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[22], i2);
            if (cTLuminanceEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLuminanceEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTOuterShadowEffect getOuterShdwArray(int i2) {
        CTOuterShadowEffect cTOuterShadowEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTOuterShadowEffect = (CTOuterShadowEffect) get_store().find_element_user(PROPERTY_QNAME[23], i2);
            if (cTOuterShadowEffect == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOuterShadowEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTPresetShadowEffect getPrstShdwArray(int i2) {
        CTPresetShadowEffect cTPresetShadowEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetShadowEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[24], i2);
            if (cTPresetShadowEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPresetShadowEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTReflectionEffect getReflectionArray(int i2) {
        CTReflectionEffect cTReflectionEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTReflectionEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[25], i2);
            if (cTReflectionEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTReflectionEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTRelativeOffsetEffect getRelOffArray(int i2) {
        CTRelativeOffsetEffect cTRelativeOffsetEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeOffsetEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[26], i2);
            if (cTRelativeOffsetEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRelativeOffsetEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTSoftEdgesEffect getSoftEdgeArray(int i2) {
        CTSoftEdgesEffect cTSoftEdgesEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSoftEdgesEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[27], i2);
            if (cTSoftEdgesEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSoftEdgesEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTintEffect getTintArray(int i2) {
        CTTintEffect cTTintEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTintEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[28], i2);
            if (cTTintEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTintEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTransformEffect getXfrmArray(int i2) {
        CTTransformEffect cTTransformEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTransformEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[29], i2);
            if (cTTransformEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTransformEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaBiLevelArray(int i2, CTAlphaBiLevelEffect cTAlphaBiLevelEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaBiLevelEffect, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaCeilingArray(int i2, CTAlphaCeilingEffect cTAlphaCeilingEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaCeilingEffect, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaFloorArray(int i2, CTAlphaFloorEffect cTAlphaFloorEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaFloorEffect, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaInvArray(int i2, CTAlphaInverseEffect cTAlphaInverseEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaInverseEffect, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaModArray(int i2, CTAlphaModulateEffect cTAlphaModulateEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaModulateEffect, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaModFixArray(int i2, CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaModulateFixedEffect, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaOutsetArray(int i2, CTAlphaOutsetEffect cTAlphaOutsetEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaOutsetEffect, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaReplArray(int i2, CTAlphaReplaceEffect cTAlphaReplaceEffect) throws Throwable {
        generatedSetterHelperImpl(cTAlphaReplaceEffect, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setBiLevelArray(int i2, CTBiLevelEffect cTBiLevelEffect) throws Throwable {
        generatedSetterHelperImpl(cTBiLevelEffect, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setBlendArray(int i2, CTBlendEffect cTBlendEffect) throws Throwable {
        generatedSetterHelperImpl(cTBlendEffect, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setBlurArray(int i2, CTBlurEffect cTBlurEffect) throws Throwable {
        generatedSetterHelperImpl(cTBlurEffect, PROPERTY_QNAME[12], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setClrChangeArray(int i2, CTColorChangeEffect cTColorChangeEffect) throws Throwable {
        generatedSetterHelperImpl(cTColorChangeEffect, PROPERTY_QNAME[13], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setClrReplArray(int i2, CTColorReplaceEffect cTColorReplaceEffect) throws Throwable {
        generatedSetterHelperImpl(cTColorReplaceEffect, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setContArray(int i2, CTEffectContainer cTEffectContainer) throws Throwable {
        generatedSetterHelperImpl(cTEffectContainer, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setDuotoneArray(int i2, CTDuotoneEffect cTDuotoneEffect) throws Throwable {
        generatedSetterHelperImpl(cTDuotoneEffect, PROPERTY_QNAME[15], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setEffectArray(int i2, CTEffectReference cTEffectReference) throws Throwable {
        generatedSetterHelperImpl(cTEffectReference, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setFillArray(int i2, CTFillEffect cTFillEffect) throws Throwable {
        generatedSetterHelperImpl(cTFillEffect, PROPERTY_QNAME[16], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setFillOverlayArray(int i2, CTFillOverlayEffect cTFillOverlayEffect) throws Throwable {
        generatedSetterHelperImpl(cTFillOverlayEffect, PROPERTY_QNAME[17], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setGlowArray(int i2, CTGlowEffect cTGlowEffect) throws Throwable {
        generatedSetterHelperImpl(cTGlowEffect, PROPERTY_QNAME[18], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setGraysclArray(int i2, CTGrayscaleEffect cTGrayscaleEffect) throws Throwable {
        generatedSetterHelperImpl(cTGrayscaleEffect, PROPERTY_QNAME[19], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setHslArray(int i2, CTHSLEffect cTHSLEffect) throws Throwable {
        generatedSetterHelperImpl(cTHSLEffect, PROPERTY_QNAME[20], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setInnerShdwArray(int i2, CTInnerShadowEffect cTInnerShadowEffect) throws Throwable {
        generatedSetterHelperImpl(cTInnerShadowEffect, PROPERTY_QNAME[21], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setLumArray(int i2, CTLuminanceEffect cTLuminanceEffect) throws Throwable {
        generatedSetterHelperImpl(cTLuminanceEffect, PROPERTY_QNAME[22], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setOuterShdwArray(int i2, CTOuterShadowEffect cTOuterShadowEffect) throws Throwable {
        generatedSetterHelperImpl(cTOuterShadowEffect, PROPERTY_QNAME[23], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setPrstShdwArray(int i2, CTPresetShadowEffect cTPresetShadowEffect) throws Throwable {
        generatedSetterHelperImpl(cTPresetShadowEffect, PROPERTY_QNAME[24], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setReflectionArray(int i2, CTReflectionEffect cTReflectionEffect) throws Throwable {
        generatedSetterHelperImpl(cTReflectionEffect, PROPERTY_QNAME[25], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setRelOffArray(int i2, CTRelativeOffsetEffect cTRelativeOffsetEffect) throws Throwable {
        generatedSetterHelperImpl(cTRelativeOffsetEffect, PROPERTY_QNAME[26], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setSoftEdgeArray(int i2, CTSoftEdgesEffect cTSoftEdgesEffect) throws Throwable {
        generatedSetterHelperImpl(cTSoftEdgesEffect, PROPERTY_QNAME[27], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setTintArray(int i2, CTTintEffect cTTintEffect) throws Throwable {
        generatedSetterHelperImpl(cTTintEffect, PROPERTY_QNAME[28], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setXfrmArray(int i2, CTTransformEffect cTTransformEffect) throws Throwable {
        generatedSetterHelperImpl(cTTransformEffect, PROPERTY_QNAME[29], i2, (short) 2);
    }
}
