package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyles;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFills;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles;

/* loaded from: classes2.dex */
public class CTStylesheetImpl extends XmlComplexContentImpl implements CTStylesheet {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "numFmts"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fonts"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fills"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "borders"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cellStyleXfs"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cellXfs"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cellStyles"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dxfs"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tableStyles"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "colors"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTStylesheetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTBorders addNewBorders() {
        CTBorders cTBorders;
        synchronized (monitor()) {
            check_orphaned();
            cTBorders = (CTBorders) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTBorders;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTCellStyleXfs addNewCellStyleXfs() {
        CTCellStyleXfs cTCellStyleXfs;
        synchronized (monitor()) {
            check_orphaned();
            cTCellStyleXfs = (CTCellStyleXfs) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTCellStyleXfs;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTCellStyles addNewCellStyles() {
        CTCellStyles cTCellStylesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCellStylesAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTCellStylesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTCellXfs addNewCellXfs() {
        CTCellXfs cTCellXfs;
        synchronized (monitor()) {
            check_orphaned();
            cTCellXfs = (CTCellXfs) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTCellXfs;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTColors addNewColors() {
        CTColors cTColors;
        synchronized (monitor()) {
            check_orphaned();
            cTColors = (CTColors) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTColors;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTDxfs addNewDxfs() {
        CTDxfs cTDxfs;
        synchronized (monitor()) {
            check_orphaned();
            cTDxfs = (CTDxfs) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTDxfs;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTFills addNewFills() {
        CTFills cTFills;
        synchronized (monitor()) {
            check_orphaned();
            cTFills = (CTFills) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTFills;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTFonts addNewFonts() {
        CTFonts cTFonts;
        synchronized (monitor()) {
            check_orphaned();
            cTFonts = (CTFonts) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTFonts;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTNumFmts addNewNumFmts() {
        CTNumFmts cTNumFmts;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmts = (CTNumFmts) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTNumFmts;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTTableStyles addNewTableStyles() {
        CTTableStyles cTTableStyles;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyles = (CTTableStyles) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTTableStyles;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTBorders getBorders() {
        CTBorders cTBorders;
        synchronized (monitor()) {
            check_orphaned();
            cTBorders = (CTBorders) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTBorders == null) {
                cTBorders = null;
            }
        }
        return cTBorders;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTCellStyleXfs getCellStyleXfs() {
        CTCellStyleXfs cTCellStyleXfs;
        synchronized (monitor()) {
            check_orphaned();
            cTCellStyleXfs = (CTCellStyleXfs) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTCellStyleXfs == null) {
                cTCellStyleXfs = null;
            }
        }
        return cTCellStyleXfs;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTCellStyles getCellStyles() {
        CTCellStyles cTCellStylesFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCellStylesFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTCellStylesFind_element_user == null) {
                cTCellStylesFind_element_user = null;
            }
        }
        return cTCellStylesFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTCellXfs getCellXfs() {
        CTCellXfs cTCellXfs;
        synchronized (monitor()) {
            check_orphaned();
            cTCellXfs = (CTCellXfs) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTCellXfs == null) {
                cTCellXfs = null;
            }
        }
        return cTCellXfs;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTColors getColors() {
        CTColors cTColors;
        synchronized (monitor()) {
            check_orphaned();
            cTColors = (CTColors) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTColors == null) {
                cTColors = null;
            }
        }
        return cTColors;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTDxfs getDxfs() {
        CTDxfs cTDxfs;
        synchronized (monitor()) {
            check_orphaned();
            cTDxfs = (CTDxfs) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTDxfs == null) {
                cTDxfs = null;
            }
        }
        return cTDxfs;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTFills getFills() {
        CTFills cTFills;
        synchronized (monitor()) {
            check_orphaned();
            cTFills = (CTFills) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTFills == null) {
                cTFills = null;
            }
        }
        return cTFills;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTFonts getFonts() {
        CTFonts cTFonts;
        synchronized (monitor()) {
            check_orphaned();
            cTFonts = (CTFonts) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTFonts == null) {
                cTFonts = null;
            }
        }
        return cTFonts;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTNumFmts getNumFmts() {
        CTNumFmts cTNumFmts;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmts = (CTNumFmts) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTNumFmts == null) {
                cTNumFmts = null;
            }
        }
        return cTNumFmts;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTTableStyles getTableStyles() {
        CTTableStyles cTTableStyles;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyles = (CTTableStyles) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTTableStyles == null) {
                cTTableStyles = null;
            }
        }
        return cTTableStyles;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetBorders() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetCellStyleXfs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetCellStyles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetCellXfs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetDxfs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetFills() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetFonts() {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetNumFmts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetTableStyles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setBorders(CTBorders cTBorders) throws Throwable {
        generatedSetterHelperImpl(cTBorders, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setCellStyleXfs(CTCellStyleXfs cTCellStyleXfs) throws Throwable {
        generatedSetterHelperImpl(cTCellStyleXfs, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setCellStyles(CTCellStyles cTCellStyles) throws Throwable {
        generatedSetterHelperImpl(cTCellStyles, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setCellXfs(CTCellXfs cTCellXfs) throws Throwable {
        generatedSetterHelperImpl(cTCellXfs, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setColors(CTColors cTColors) throws Throwable {
        generatedSetterHelperImpl(cTColors, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setDxfs(CTDxfs cTDxfs) throws Throwable {
        generatedSetterHelperImpl(cTDxfs, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setFills(CTFills cTFills) throws Throwable {
        generatedSetterHelperImpl(cTFills, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setFonts(CTFonts cTFonts) throws Throwable {
        generatedSetterHelperImpl(cTFonts, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setNumFmts(CTNumFmts cTNumFmts) throws Throwable {
        generatedSetterHelperImpl(cTNumFmts, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setTableStyles(CTTableStyles cTTableStyles) throws Throwable {
        generatedSetterHelperImpl(cTTableStyles, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetBorders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetCellStyleXfs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetCellStyles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetCellXfs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetDxfs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetFills() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetNumFmts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetTableStyles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }
}
