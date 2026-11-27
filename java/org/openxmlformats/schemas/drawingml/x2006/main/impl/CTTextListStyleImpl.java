package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* loaded from: classes2.dex */
public class CTTextListStyleImpl extends XmlComplexContentImpl implements CTTextListStyle {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "defPPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl1pPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl2pPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl3pPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl4pPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl5pPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl6pPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl7pPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl8pPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl9pPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTTextListStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewDefPPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl1PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl2PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl3PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl4PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl5PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl6PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl7PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl8PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties addNewLvl9PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getDefPPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTextParagraphProperties == null) {
                cTTextParagraphProperties = null;
            }
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl1PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTextParagraphProperties == null) {
                cTTextParagraphProperties = null;
            }
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl2PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTextParagraphProperties == null) {
                cTTextParagraphProperties = null;
            }
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl3PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTTextParagraphProperties == null) {
                cTTextParagraphProperties = null;
            }
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl4PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTTextParagraphProperties == null) {
                cTTextParagraphProperties = null;
            }
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl5PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTTextParagraphProperties == null) {
                cTTextParagraphProperties = null;
            }
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl6PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTTextParagraphProperties == null) {
                cTTextParagraphProperties = null;
            }
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl7PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTTextParagraphProperties == null) {
                cTTextParagraphProperties = null;
            }
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl8PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTTextParagraphProperties == null) {
                cTTextParagraphProperties = null;
            }
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public CTTextParagraphProperties getLvl9PPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTTextParagraphProperties == null) {
                cTTextParagraphProperties = null;
            }
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetDefPPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl1PPr() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl2PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl3PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl4PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl5PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl6PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl7PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl8PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public boolean isSetLvl9PPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setDefPPr(CTTextParagraphProperties cTTextParagraphProperties) throws Throwable {
        generatedSetterHelperImpl(cTTextParagraphProperties, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl1PPr(CTTextParagraphProperties cTTextParagraphProperties) throws Throwable {
        generatedSetterHelperImpl(cTTextParagraphProperties, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl2PPr(CTTextParagraphProperties cTTextParagraphProperties) throws Throwable {
        generatedSetterHelperImpl(cTTextParagraphProperties, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl3PPr(CTTextParagraphProperties cTTextParagraphProperties) throws Throwable {
        generatedSetterHelperImpl(cTTextParagraphProperties, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl4PPr(CTTextParagraphProperties cTTextParagraphProperties) throws Throwable {
        generatedSetterHelperImpl(cTTextParagraphProperties, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl5PPr(CTTextParagraphProperties cTTextParagraphProperties) throws Throwable {
        generatedSetterHelperImpl(cTTextParagraphProperties, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl6PPr(CTTextParagraphProperties cTTextParagraphProperties) throws Throwable {
        generatedSetterHelperImpl(cTTextParagraphProperties, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl7PPr(CTTextParagraphProperties cTTextParagraphProperties) throws Throwable {
        generatedSetterHelperImpl(cTTextParagraphProperties, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl8PPr(CTTextParagraphProperties cTTextParagraphProperties) throws Throwable {
        generatedSetterHelperImpl(cTTextParagraphProperties, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void setLvl9PPr(CTTextParagraphProperties cTTextParagraphProperties) throws Throwable {
        generatedSetterHelperImpl(cTTextParagraphProperties, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetDefPPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl1PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl2PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl3PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl4PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl5PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl6PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl7PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl8PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle
    public void unsetLvl9PPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }
}
