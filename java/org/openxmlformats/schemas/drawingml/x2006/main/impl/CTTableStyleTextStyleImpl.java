package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.STOnOffStyleType;

/* loaded from: classes2.dex */
public class CTTableStyleTextStyleImpl extends XmlComplexContentImpl implements CTTableStyleTextStyle {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "font"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fontRef"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "scrgbClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "srgbClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hslClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "sysClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "schemeClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "prstClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst"), new QName("", "b"), new QName("", "i")};
    private static final long serialVersionUID = 1;

    public CTTableStyleTextStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTFontCollection addNewFont() {
        CTFontCollection cTFontCollection;
        synchronized (monitor()) {
            check_orphaned();
            cTFontCollection = (CTFontCollection) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTFontCollection;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTFontReference addNewFontRef() {
        CTFontReference cTFontReference;
        synchronized (monitor()) {
            check_orphaned();
            cTFontReference = (CTFontReference) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTFontReference;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTHslColor addNewHslClr() {
        CTHslColor cTHslColor;
        synchronized (monitor()) {
            check_orphaned();
            cTHslColor = (CTHslColor) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTHslColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTPresetColor addNewPrstClr() {
        CTPresetColor cTPresetColor;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetColor = (CTPresetColor) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTPresetColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTSchemeColor addNewSchemeClr() {
        CTSchemeColor cTSchemeColor;
        synchronized (monitor()) {
            check_orphaned();
            cTSchemeColor = (CTSchemeColor) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTSchemeColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTScRgbColor addNewScrgbClr() {
        CTScRgbColor cTScRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTScRgbColor = (CTScRgbColor) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTScRgbColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTSRgbColor addNewSrgbClr() {
        CTSRgbColor cTSRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTSRgbColor = (CTSRgbColor) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTSRgbColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTSystemColor addNewSysClr() {
        CTSystemColor cTSystemColor;
        synchronized (monitor()) {
            check_orphaned();
            cTSystemColor = (CTSystemColor) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTSystemColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public STOnOffStyleType.Enum getB() {
        STOnOffStyleType.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[9]);
            }
            r1 = simpleValue == null ? null : (STOnOffStyleType.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTFontCollection getFont() {
        CTFontCollection cTFontCollection;
        synchronized (monitor()) {
            check_orphaned();
            cTFontCollection = (CTFontCollection) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTFontCollection == null) {
                cTFontCollection = null;
            }
        }
        return cTFontCollection;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTFontReference getFontRef() {
        CTFontReference cTFontReference;
        synchronized (monitor()) {
            check_orphaned();
            cTFontReference = (CTFontReference) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTFontReference == null) {
                cTFontReference = null;
            }
        }
        return cTFontReference;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTHslColor getHslClr() {
        CTHslColor cTHslColor;
        synchronized (monitor()) {
            check_orphaned();
            cTHslColor = (CTHslColor) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTHslColor == null) {
                cTHslColor = null;
            }
        }
        return cTHslColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public STOnOffStyleType.Enum getI() {
        STOnOffStyleType.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[10]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[10]);
            }
            r1 = simpleValue == null ? null : (STOnOffStyleType.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTPresetColor getPrstClr() {
        CTPresetColor cTPresetColor;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetColor = (CTPresetColor) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTPresetColor == null) {
                cTPresetColor = null;
            }
        }
        return cTPresetColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTSchemeColor getSchemeClr() {
        CTSchemeColor cTSchemeColor;
        synchronized (monitor()) {
            check_orphaned();
            cTSchemeColor = (CTSchemeColor) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTSchemeColor == null) {
                cTSchemeColor = null;
            }
        }
        return cTSchemeColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTScRgbColor getScrgbClr() {
        CTScRgbColor cTScRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTScRgbColor = (CTScRgbColor) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTScRgbColor == null) {
                cTScRgbColor = null;
            }
        }
        return cTScRgbColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTSRgbColor getSrgbClr() {
        CTSRgbColor cTSRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTSRgbColor = (CTSRgbColor) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTSRgbColor == null) {
                cTSRgbColor = null;
            }
        }
        return cTSRgbColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public CTSystemColor getSysClr() {
        CTSystemColor cTSystemColor;
        synchronized (monitor()) {
            check_orphaned();
            cTSystemColor = (CTSystemColor) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTSystemColor == null) {
                cTSystemColor = null;
            }
        }
        return cTSystemColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public boolean isSetB() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[9]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public boolean isSetFont() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public boolean isSetFontRef() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public boolean isSetHslClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public boolean isSetI() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[10]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public boolean isSetPrstClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public boolean isSetSchemeClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public boolean isSetScrgbClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public boolean isSetSrgbClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public boolean isSetSysClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void setB(STOnOffStyleType.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[9]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void setFont(CTFontCollection cTFontCollection) throws Throwable {
        generatedSetterHelperImpl(cTFontCollection, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void setFontRef(CTFontReference cTFontReference) throws Throwable {
        generatedSetterHelperImpl(cTFontReference, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void setHslClr(CTHslColor cTHslColor) throws Throwable {
        generatedSetterHelperImpl(cTHslColor, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void setI(STOnOffStyleType.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[10]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[10]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void setPrstClr(CTPresetColor cTPresetColor) throws Throwable {
        generatedSetterHelperImpl(cTPresetColor, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void setSchemeClr(CTSchemeColor cTSchemeColor) throws Throwable {
        generatedSetterHelperImpl(cTSchemeColor, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void setScrgbClr(CTScRgbColor cTScRgbColor) throws Throwable {
        generatedSetterHelperImpl(cTScRgbColor, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void setSrgbClr(CTSRgbColor cTSRgbColor) throws Throwable {
        generatedSetterHelperImpl(cTSRgbColor, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void setSysClr(CTSystemColor cTSystemColor) throws Throwable {
        generatedSetterHelperImpl(cTSystemColor, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void unsetB() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[9]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void unsetFont() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void unsetFontRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void unsetHslClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void unsetI() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[10]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void unsetPrstClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void unsetSchemeClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void unsetScrgbClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void unsetSrgbClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void unsetSysClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public STOnOffStyleType xgetB() {
        STOnOffStyleType sTOnOffStyleType;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTOnOffStyleType = (STOnOffStyleType) typeStore.find_attribute_user(qNameArr[9]);
            if (sTOnOffStyleType == null) {
                sTOnOffStyleType = (STOnOffStyleType) get_default_attribute_value(qNameArr[9]);
            }
        }
        return sTOnOffStyleType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public STOnOffStyleType xgetI() {
        STOnOffStyleType sTOnOffStyleType;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTOnOffStyleType = (STOnOffStyleType) typeStore.find_attribute_user(qNameArr[10]);
            if (sTOnOffStyleType == null) {
                sTOnOffStyleType = (STOnOffStyleType) get_default_attribute_value(qNameArr[10]);
            }
        }
        return sTOnOffStyleType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void xsetB(STOnOffStyleType sTOnOffStyleType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STOnOffStyleType sTOnOffStyleType2 = (STOnOffStyleType) typeStore.find_attribute_user(qNameArr[9]);
            if (sTOnOffStyleType2 == null) {
                sTOnOffStyleType2 = (STOnOffStyleType) get_store().add_attribute_user(qNameArr[9]);
            }
            sTOnOffStyleType2.set(sTOnOffStyleType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle
    public void xsetI(STOnOffStyleType sTOnOffStyleType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STOnOffStyleType sTOnOffStyleType2 = (STOnOffStyleType) typeStore.find_attribute_user(qNameArr[10]);
            if (sTOnOffStyleType2 == null) {
                sTOnOffStyleType2 = (STOnOffStyleType) get_store().add_attribute_user(qNameArr[10]);
            }
            sTOnOffStyleType2.set(sTOnOffStyleType);
        }
    }
}
