package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTransition;

/* loaded from: classes2.dex */
public class CTSlideImpl extends XmlComplexContentImpl implements CTSlide {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cSld"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "clrMapOvr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "transition"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "timing"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst"), new QName("", "showMasterSp"), new QName("", "showMasterPhAnim"), new QName("", "show")};
    private static final long serialVersionUID = 1;

    public CTSlideImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public CTCommonSlideData addNewCSld() {
        CTCommonSlideData cTCommonSlideData;
        synchronized (monitor()) {
            check_orphaned();
            cTCommonSlideData = (CTCommonSlideData) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCommonSlideData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public CTColorMappingOverride addNewClrMapOvr() {
        CTColorMappingOverride cTColorMappingOverride;
        synchronized (monitor()) {
            check_orphaned();
            cTColorMappingOverride = (CTColorMappingOverride) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTColorMappingOverride;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModifyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTExtensionListModifyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public CTSlideTiming addNewTiming() {
        CTSlideTiming cTSlideTiming;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideTiming = (CTSlideTiming) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTSlideTiming;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public CTSlideTransition addNewTransition() {
        CTSlideTransition cTSlideTransitionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideTransitionAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTSlideTransitionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public CTCommonSlideData getCSld() {
        CTCommonSlideData cTCommonSlideData;
        synchronized (monitor()) {
            check_orphaned();
            cTCommonSlideData = (CTCommonSlideData) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTCommonSlideData == null) {
                cTCommonSlideData = null;
            }
        }
        return cTCommonSlideData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public CTColorMappingOverride getClrMapOvr() {
        CTColorMappingOverride cTColorMappingOverride;
        synchronized (monitor()) {
            check_orphaned();
            cTColorMappingOverride = (CTColorMappingOverride) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTColorMappingOverride == null) {
                cTColorMappingOverride = null;
            }
        }
        return cTColorMappingOverride;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public CTExtensionListModify getExtLst() {
        CTExtensionListModify cTExtensionListModifyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTExtensionListModifyFind_element_user == null) {
                cTExtensionListModifyFind_element_user = null;
            }
        }
        return cTExtensionListModifyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public boolean getShow() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[7]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public boolean getShowMasterPhAnim() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[6]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public boolean getShowMasterSp() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[5]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public CTSlideTiming getTiming() {
        CTSlideTiming cTSlideTiming;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideTiming = (CTSlideTiming) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTSlideTiming == null) {
                cTSlideTiming = null;
            }
        }
        return cTSlideTiming;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public CTSlideTransition getTransition() {
        CTSlideTransition cTSlideTransitionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideTransitionFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTSlideTransitionFind_element_user == null) {
                cTSlideTransitionFind_element_user = null;
            }
        }
        return cTSlideTransitionFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public boolean isSetClrMapOvr() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public boolean isSetShow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[7]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public boolean isSetShowMasterPhAnim() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[6]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public boolean isSetShowMasterSp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[5]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public boolean isSetTiming() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public boolean isSetTransition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void setCSld(CTCommonSlideData cTCommonSlideData) throws Throwable {
        generatedSetterHelperImpl(cTCommonSlideData, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void setClrMapOvr(CTColorMappingOverride cTColorMappingOverride) throws Throwable {
        generatedSetterHelperImpl(cTColorMappingOverride, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void setExtLst(CTExtensionListModify cTExtensionListModify) throws Throwable {
        generatedSetterHelperImpl(cTExtensionListModify, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void setShow(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[7]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void setShowMasterPhAnim(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[6]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void setShowMasterSp(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[5]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void setTiming(CTSlideTiming cTSlideTiming) throws Throwable {
        generatedSetterHelperImpl(cTSlideTiming, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void setTransition(CTSlideTransition cTSlideTransition) throws Throwable {
        generatedSetterHelperImpl(cTSlideTransition, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void unsetClrMapOvr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void unsetShow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[7]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void unsetShowMasterPhAnim() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[6]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void unsetShowMasterSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[5]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void unsetTiming() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void unsetTransition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public XmlBoolean xgetShow() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[7]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[7]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public XmlBoolean xgetShowMasterPhAnim() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[6]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[6]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public XmlBoolean xgetShowMasterSp() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[5]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[5]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void xsetShow(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[7]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[7]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void xsetShowMasterPhAnim(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[6]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[6]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlide
    public void xsetShowMasterSp(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[5]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[5]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }
}
