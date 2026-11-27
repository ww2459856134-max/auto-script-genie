package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlurEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillOverlayEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGlowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInnerShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTReflectionEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSoftEdgesEffect;

/* loaded from: classes2.dex */
public class CTEffectListImpl extends XmlComplexContentImpl implements CTEffectList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blur"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fillOverlay"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "glow"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "innerShdw"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "outerShdw"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "prstShdw"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "reflection"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "softEdge")};
    private static final long serialVersionUID = 1;

    public CTEffectListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTBlurEffect addNewBlur() {
        CTBlurEffect cTBlurEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlurEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTBlurEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTFillOverlayEffect addNewFillOverlay() {
        CTFillOverlayEffect cTFillOverlayEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillOverlayEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTFillOverlayEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTGlowEffect addNewGlow() {
        CTGlowEffect cTGlowEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGlowEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTGlowEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTInnerShadowEffect addNewInnerShdw() {
        CTInnerShadowEffect cTInnerShadowEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInnerShadowEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTInnerShadowEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTOuterShadowEffect addNewOuterShdw() {
        CTOuterShadowEffect cTOuterShadowEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTOuterShadowEffect = (CTOuterShadowEffect) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTOuterShadowEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTPresetShadowEffect addNewPrstShdw() {
        CTPresetShadowEffect cTPresetShadowEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetShadowEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTPresetShadowEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTReflectionEffect addNewReflection() {
        CTReflectionEffect cTReflectionEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTReflectionEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTReflectionEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTSoftEdgesEffect addNewSoftEdge() {
        CTSoftEdgesEffect cTSoftEdgesEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSoftEdgesEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTSoftEdgesEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTBlurEffect getBlur() {
        CTBlurEffect cTBlurEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlurEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTBlurEffectFind_element_user == null) {
                cTBlurEffectFind_element_user = null;
            }
        }
        return cTBlurEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTFillOverlayEffect getFillOverlay() {
        CTFillOverlayEffect cTFillOverlayEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillOverlayEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTFillOverlayEffectFind_element_user == null) {
                cTFillOverlayEffectFind_element_user = null;
            }
        }
        return cTFillOverlayEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTGlowEffect getGlow() {
        CTGlowEffect cTGlowEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGlowEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTGlowEffectFind_element_user == null) {
                cTGlowEffectFind_element_user = null;
            }
        }
        return cTGlowEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTInnerShadowEffect getInnerShdw() {
        CTInnerShadowEffect cTInnerShadowEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInnerShadowEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTInnerShadowEffectFind_element_user == null) {
                cTInnerShadowEffectFind_element_user = null;
            }
        }
        return cTInnerShadowEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTOuterShadowEffect getOuterShdw() {
        CTOuterShadowEffect cTOuterShadowEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTOuterShadowEffect = (CTOuterShadowEffect) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTOuterShadowEffect == null) {
                cTOuterShadowEffect = null;
            }
        }
        return cTOuterShadowEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTPresetShadowEffect getPrstShdw() {
        CTPresetShadowEffect cTPresetShadowEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetShadowEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTPresetShadowEffectFind_element_user == null) {
                cTPresetShadowEffectFind_element_user = null;
            }
        }
        return cTPresetShadowEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTReflectionEffect getReflection() {
        CTReflectionEffect cTReflectionEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTReflectionEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTReflectionEffectFind_element_user == null) {
                cTReflectionEffectFind_element_user = null;
            }
        }
        return cTReflectionEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTSoftEdgesEffect getSoftEdge() {
        CTSoftEdgesEffect cTSoftEdgesEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSoftEdgesEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTSoftEdgesEffectFind_element_user == null) {
                cTSoftEdgesEffectFind_element_user = null;
            }
        }
        return cTSoftEdgesEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetBlur() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetFillOverlay() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetGlow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetInnerShdw() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetOuterShdw() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetPrstShdw() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetReflection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetSoftEdge() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setBlur(CTBlurEffect cTBlurEffect) throws Throwable {
        generatedSetterHelperImpl(cTBlurEffect, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setFillOverlay(CTFillOverlayEffect cTFillOverlayEffect) throws Throwable {
        generatedSetterHelperImpl(cTFillOverlayEffect, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setGlow(CTGlowEffect cTGlowEffect) throws Throwable {
        generatedSetterHelperImpl(cTGlowEffect, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setInnerShdw(CTInnerShadowEffect cTInnerShadowEffect) throws Throwable {
        generatedSetterHelperImpl(cTInnerShadowEffect, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setOuterShdw(CTOuterShadowEffect cTOuterShadowEffect) throws Throwable {
        generatedSetterHelperImpl(cTOuterShadowEffect, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setPrstShdw(CTPresetShadowEffect cTPresetShadowEffect) throws Throwable {
        generatedSetterHelperImpl(cTPresetShadowEffect, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setReflection(CTReflectionEffect cTReflectionEffect) throws Throwable {
        generatedSetterHelperImpl(cTReflectionEffect, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setSoftEdge(CTSoftEdgesEffect cTSoftEdgesEffect) throws Throwable {
        generatedSetterHelperImpl(cTSoftEdgesEffect, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetBlur() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetFillOverlay() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetGlow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetInnerShdw() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetOuterShdw() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetPrstShdw() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetReflection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetSoftEdge() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }
}
