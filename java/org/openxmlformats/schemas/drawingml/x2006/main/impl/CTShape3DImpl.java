package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBevel;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetMaterialType;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetMaterialType$Enum;

/* loaded from: classes2.dex */
public class CTShape3DImpl extends XmlComplexContentImpl implements CTShape3D {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "bevelT"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "bevelB"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extrusionClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "contourClr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst"), new QName("", "z"), new QName("", "extrusionH"), new QName("", "contourW"), new QName("", "prstMaterial")};
    private static final long serialVersionUID = 1;

    public CTShape3DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public CTBevel addNewBevelB() {
        CTBevel cTBevelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBevelAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTBevelAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public CTBevel addNewBevelT() {
        CTBevel cTBevelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBevelAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTBevelAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public CTColor addNewContourClr() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public CTColor addNewExtrusionClr() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public CTBevel getBevelB() {
        CTBevel cTBevelFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBevelFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTBevelFind_element_user == null) {
                cTBevelFind_element_user = null;
            }
        }
        return cTBevelFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public CTBevel getBevelT() {
        CTBevel cTBevelFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBevelFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTBevelFind_element_user == null) {
                cTBevelFind_element_user = null;
            }
        }
        return cTBevelFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public CTColor getContourClr() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTColor == null) {
                cTColor = null;
            }
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public long getContourW() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public CTColor getExtrusionClr() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTColor == null) {
                cTColor = null;
            }
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public long getExtrusionH() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public STPresetMaterialType$Enum getPrstMaterial() {
        STPresetMaterialType$Enum sTPresetMaterialType$Enum;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[8]);
            }
            sTPresetMaterialType$Enum = simpleValue == null ? null : (STPresetMaterialType$Enum) simpleValue.getEnumValue();
        }
        return sTPresetMaterialType$Enum;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public Object getZ() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[5]);
            }
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public boolean isSetBevelB() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public boolean isSetBevelT() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public boolean isSetContourClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public boolean isSetContourW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[7]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public boolean isSetExtrusionClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public boolean isSetExtrusionH() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[6]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public boolean isSetPrstMaterial() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[8]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public boolean isSetZ() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[5]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void setBevelB(CTBevel cTBevel) throws Throwable {
        generatedSetterHelperImpl(cTBevel, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void setBevelT(CTBevel cTBevel) throws Throwable {
        generatedSetterHelperImpl(cTBevel, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void setContourClr(CTColor cTColor) throws Throwable {
        generatedSetterHelperImpl(cTColor, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void setContourW(long j2) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void setExtrusionClr(CTColor cTColor) throws Throwable {
        generatedSetterHelperImpl(cTColor, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void setExtrusionH(long j2) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void setPrstMaterial(STPresetMaterialType$Enum sTPresetMaterialType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[8]);
            }
            simpleValue.setEnumValue(sTPresetMaterialType$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void setZ(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[5]);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void unsetBevelB() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void unsetBevelT() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void unsetContourClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void unsetContourW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[7]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void unsetExtrusionClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void unsetExtrusionH() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[6]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void unsetPrstMaterial() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[8]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void unsetZ() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[5]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public STPositiveCoordinate xgetContourW() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public STPositiveCoordinate xgetExtrusionH() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public STPresetMaterialType xgetPrstMaterial() {
        STPresetMaterialType sTPresetMaterialTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTPresetMaterialTypeFind_attribute_user = typeStore.find_attribute_user(qNameArr[8]);
            if (sTPresetMaterialTypeFind_attribute_user == null) {
                sTPresetMaterialTypeFind_attribute_user = (STPresetMaterialType) get_default_attribute_value(qNameArr[8]);
            }
        }
        return sTPresetMaterialTypeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public STCoordinate xgetZ() {
        STCoordinate sTCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTCoordinate = (STCoordinate) typeStore.find_attribute_user(qNameArr[5]);
            if (sTCoordinate == null) {
                sTCoordinate = (STCoordinate) get_default_attribute_value(qNameArr[5]);
            }
        }
        return sTCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void xsetContourW(STPositiveCoordinate sTPositiveCoordinate) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void xsetExtrusionH(STPositiveCoordinate sTPositiveCoordinate) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void xsetPrstMaterial(STPresetMaterialType sTPresetMaterialType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STPresetMaterialType sTPresetMaterialTypeFind_attribute_user = typeStore.find_attribute_user(qNameArr[8]);
            if (sTPresetMaterialTypeFind_attribute_user == null) {
                sTPresetMaterialTypeFind_attribute_user = (STPresetMaterialType) get_store().add_attribute_user(qNameArr[8]);
            }
            sTPresetMaterialTypeFind_attribute_user.set(sTPresetMaterialType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D
    public void xsetZ(STCoordinate sTCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STCoordinate sTCoordinate2 = (STCoordinate) typeStore.find_attribute_user(qNameArr[5]);
            if (sTCoordinate2 == null) {
                sTCoordinate2 = (STCoordinate) get_store().add_attribute_user(qNameArr[5]);
            }
            sTCoordinate2.set(sTCoordinate);
        }
    }
}
