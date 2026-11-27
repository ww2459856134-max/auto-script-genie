package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.STTileFlipMode;

/* loaded from: classes2.dex */
public class CTGradientFillPropertiesImpl extends XmlComplexContentImpl implements CTGradientFillProperties {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gsLst"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lin"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "path"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tileRect"), new QName("", "flip"), new QName("", "rotWithShape")};
    private static final long serialVersionUID = 1;

    public CTGradientFillPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTGradientStopList addNewGsLst() {
        CTGradientStopList cTGradientStopList;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientStopList = (CTGradientStopList) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTGradientStopList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTLinearShadeProperties addNewLin() {
        CTLinearShadeProperties cTLinearShadeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLinearShadeProperties = (CTLinearShadeProperties) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTLinearShadeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTPathShadeProperties addNewPath() {
        CTPathShadeProperties cTPathShadeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPathShadeProperties = (CTPathShadeProperties) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTPathShadeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTRelativeRect addNewTileRect() {
        CTRelativeRect cTRelativeRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeRect = (CTRelativeRect) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTRelativeRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public STTileFlipMode.Enum getFlip() {
        STTileFlipMode.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[4]);
            }
            r1 = simpleValue == null ? null : (STTileFlipMode.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTGradientStopList getGsLst() {
        CTGradientStopList cTGradientStopList;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientStopList = (CTGradientStopList) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTGradientStopList == null) {
                cTGradientStopList = null;
            }
        }
        return cTGradientStopList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTLinearShadeProperties getLin() {
        CTLinearShadeProperties cTLinearShadeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLinearShadeProperties = (CTLinearShadeProperties) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTLinearShadeProperties == null) {
                cTLinearShadeProperties = null;
            }
        }
        return cTLinearShadeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTPathShadeProperties getPath() {
        CTPathShadeProperties cTPathShadeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPathShadeProperties = (CTPathShadeProperties) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTPathShadeProperties == null) {
                cTPathShadeProperties = null;
            }
        }
        return cTPathShadeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean getRotWithShape() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[5]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTRelativeRect getTileRect() {
        CTRelativeRect cTRelativeRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeRect = (CTRelativeRect) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTRelativeRect == null) {
                cTRelativeRect = null;
            }
        }
        return cTRelativeRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean isSetFlip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean isSetGsLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean isSetLin() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean isSetPath() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean isSetRotWithShape() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[5]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean isSetTileRect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void setFlip(STTileFlipMode.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void setGsLst(CTGradientStopList cTGradientStopList) throws Throwable {
        generatedSetterHelperImpl(cTGradientStopList, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void setLin(CTLinearShadeProperties cTLinearShadeProperties) throws Throwable {
        generatedSetterHelperImpl(cTLinearShadeProperties, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void setPath(CTPathShadeProperties cTPathShadeProperties) throws Throwable {
        generatedSetterHelperImpl(cTPathShadeProperties, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void setRotWithShape(boolean z) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void setTileRect(CTRelativeRect cTRelativeRect) throws Throwable {
        generatedSetterHelperImpl(cTRelativeRect, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void unsetFlip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void unsetGsLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void unsetLin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void unsetPath() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void unsetRotWithShape() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[5]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void unsetTileRect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public STTileFlipMode xgetFlip() {
        STTileFlipMode sTTileFlipMode;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTTileFlipMode = (STTileFlipMode) typeStore.find_attribute_user(qNameArr[4]);
            if (sTTileFlipMode == null) {
                sTTileFlipMode = (STTileFlipMode) get_default_attribute_value(qNameArr[4]);
            }
        }
        return sTTileFlipMode;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public XmlBoolean xgetRotWithShape() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[5]);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void xsetFlip(STTileFlipMode sTTileFlipMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STTileFlipMode sTTileFlipMode2 = (STTileFlipMode) typeStore.find_attribute_user(qNameArr[4]);
            if (sTTileFlipMode2 == null) {
                sTTileFlipMode2 = (STTileFlipMode) get_store().add_attribute_user(qNameArr[4]);
            }
            sTTileFlipMode2.set(sTTileFlipMode);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void xsetRotWithShape(XmlBoolean xmlBoolean) {
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
