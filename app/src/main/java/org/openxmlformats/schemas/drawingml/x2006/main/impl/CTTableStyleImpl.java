package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableBackgroundStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STGuid;

/* loaded from: classes2.dex */
public class CTTableStyleImpl extends XmlComplexContentImpl implements CTTableStyle {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tblBg"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "wholeTbl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "band1H"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "band2H"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "band1V"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "band2V"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lastCol"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "firstCol"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lastRow"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "seCell"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "swCell"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "firstRow"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "neCell"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "nwCell"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst"), new QName("", "styleId"), new QName("", "styleName")};
    private static final long serialVersionUID = 1;

    public CTTableStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand1H() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand1V() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand2H() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand2V() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewFirstCol() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewFirstRow() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewLastCol() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewLastRow() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewNeCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewNwCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewSeCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewSwCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTableBackgroundStyle addNewTblBg() {
        CTTableBackgroundStyle cTTableBackgroundStyleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTableBackgroundStyleAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTableBackgroundStyleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewWholeTbl() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand1H() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand1V() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand2H() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand2V() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[14], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getFirstCol() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getFirstRow() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getLastCol() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getLastRow() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getNeCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getNwCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getSeCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public String getStyleId() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[15]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public String getStyleName() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[16]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getSwCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTableBackgroundStyle getTblBg() {
        CTTableBackgroundStyle cTTableBackgroundStyleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTableBackgroundStyleFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTableBackgroundStyleFind_element_user == null) {
                cTTableBackgroundStyleFind_element_user = null;
            }
        }
        return cTTableBackgroundStyleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getWholeTbl() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTablePartStyle == null) {
                cTTablePartStyle = null;
            }
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand1H() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand1V() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand2H() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand2V() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[14]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetFirstCol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetFirstRow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetLastCol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetLastRow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetNeCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetNwCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetSeCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetSwCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetTblBg() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetWholeTbl() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand1H(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand1V(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand2H(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand2V(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[14], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setFirstCol(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setFirstRow(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setLastCol(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setLastRow(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setNeCell(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setNwCell(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setSeCell(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setStyleId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[15]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[15]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setStyleName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[16]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[16]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setSwCell(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setTblBg(CTTableBackgroundStyle cTTableBackgroundStyle) throws Throwable {
        generatedSetterHelperImpl(cTTableBackgroundStyle, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setWholeTbl(CTTablePartStyle cTTablePartStyle) throws Throwable {
        generatedSetterHelperImpl(cTTablePartStyle, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand1H() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand1V() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand2H() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand2V() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetFirstCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetFirstRow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetLastCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetLastRow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetNeCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetNwCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetSeCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetSwCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetTblBg() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetWholeTbl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public STGuid xgetStyleId() {
        STGuid sTGuid;
        synchronized (monitor()) {
            check_orphaned();
            sTGuid = (STGuid) get_store().find_attribute_user(PROPERTY_QNAME[15]);
        }
        return sTGuid;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public XmlString xgetStyleName() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[16]);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void xsetStyleId(STGuid sTGuid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STGuid sTGuid2 = (STGuid) typeStore.find_attribute_user(qNameArr[15]);
            if (sTGuid2 == null) {
                sTGuid2 = (STGuid) get_store().add_attribute_user(qNameArr[15]);
            }
            sTGuid2.set(sTGuid);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void xsetStyleName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[16]);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[16]);
            }
            xmlString2.set(xmlString);
        }
    }
}
