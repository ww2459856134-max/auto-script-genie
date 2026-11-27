package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix;

/* loaded from: classes2.dex */
public class CTBaseStylesImpl extends XmlComplexContentImpl implements CTBaseStyles {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "clrScheme"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fontScheme"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fmtScheme"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTBaseStylesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTColorScheme addNewClrScheme() {
        CTColorScheme cTColorScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTColorScheme = (CTColorScheme) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTColorScheme;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTStyleMatrix addNewFmtScheme() {
        CTStyleMatrix cTStyleMatrix;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleMatrix = (CTStyleMatrix) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTStyleMatrix;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTFontScheme addNewFontScheme() {
        CTFontScheme cTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTFontScheme = (CTFontScheme) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTFontScheme;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTColorScheme getClrScheme() {
        CTColorScheme cTColorScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTColorScheme = (CTColorScheme) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTColorScheme == null) {
                cTColorScheme = null;
            }
        }
        return cTColorScheme;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTStyleMatrix getFmtScheme() {
        CTStyleMatrix cTStyleMatrix;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleMatrix = (CTStyleMatrix) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTStyleMatrix == null) {
                cTStyleMatrix = null;
            }
        }
        return cTStyleMatrix;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public CTFontScheme getFontScheme() {
        CTFontScheme cTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTFontScheme = (CTFontScheme) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTFontScheme == null) {
                cTFontScheme = null;
            }
        }
        return cTFontScheme;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public void setClrScheme(CTColorScheme cTColorScheme) throws Throwable {
        generatedSetterHelperImpl(cTColorScheme, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public void setFmtScheme(CTStyleMatrix cTStyleMatrix) throws Throwable {
        generatedSetterHelperImpl(cTStyleMatrix, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public void setFontScheme(CTFontScheme cTFontScheme) throws Throwable {
        generatedSetterHelperImpl(cTFontScheme, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }
}
