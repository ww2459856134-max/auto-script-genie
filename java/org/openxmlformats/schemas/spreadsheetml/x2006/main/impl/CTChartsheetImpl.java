package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCsPageSetup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomChartsheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawingHF;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetBackgroundPicture;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWebPublishItems;

/* loaded from: classes2.dex */
public class CTChartsheetImpl extends XmlComplexContentImpl implements CTChartsheet {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetPr"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetViews"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetProtection"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customSheetViews"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageMargins"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageSetup"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "headerFooter"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "drawing"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawing"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawingHF"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "drawingHF"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "picture"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "webPublishItems"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTChartsheetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTCustomChartsheetViews addNewCustomSheetViews() {
        CTCustomChartsheetViews cTCustomChartsheetViewsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomChartsheetViewsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTCustomChartsheetViewsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTDrawing addNewDrawing() {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawing = (CTDrawing) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTDrawingHF addNewDrawingHF() {
        CTDrawingHF cTDrawingHFAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawingHFAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTDrawingHFAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTHeaderFooter addNewHeaderFooter() {
        CTHeaderFooter cTHeaderFooter;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooter = (CTHeaderFooter) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTHeaderFooter;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTLegacyDrawing addNewLegacyDrawing() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTLegacyDrawing addNewLegacyDrawingHF() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTPageMargins addNewPageMargins() {
        CTPageMargins cTPageMargins;
        synchronized (monitor()) {
            check_orphaned();
            cTPageMargins = (CTPageMargins) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTPageMargins;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTCsPageSetup addNewPageSetup() {
        CTCsPageSetup cTCsPageSetupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCsPageSetupAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTCsPageSetupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTSheetBackgroundPicture addNewPicture() {
        CTSheetBackgroundPicture cTSheetBackgroundPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetBackgroundPicture = (CTSheetBackgroundPicture) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTSheetBackgroundPicture;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTChartsheetPr addNewSheetPr() {
        CTChartsheetPr cTChartsheetPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartsheetPrAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTChartsheetPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTChartsheetProtection addNewSheetProtection() {
        CTChartsheetProtection cTChartsheetProtectionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartsheetProtectionAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTChartsheetProtectionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTChartsheetViews addNewSheetViews() {
        CTChartsheetViews cTChartsheetViewsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartsheetViewsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTChartsheetViewsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTWebPublishItems addNewWebPublishItems() {
        CTWebPublishItems cTWebPublishItemsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWebPublishItemsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTWebPublishItemsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTCustomChartsheetViews getCustomSheetViews() {
        CTCustomChartsheetViews cTCustomChartsheetViewsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomChartsheetViewsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTCustomChartsheetViewsFind_element_user == null) {
                cTCustomChartsheetViewsFind_element_user = null;
            }
        }
        return cTCustomChartsheetViewsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTDrawing getDrawing() {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawing = (CTDrawing) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTDrawing == null) {
                cTDrawing = null;
            }
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTDrawingHF getDrawingHF() {
        CTDrawingHF cTDrawingHFFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawingHFFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTDrawingHFFind_element_user == null) {
                cTDrawingHFFind_element_user = null;
            }
        }
        return cTDrawingHFFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTHeaderFooter getHeaderFooter() {
        CTHeaderFooter cTHeaderFooter;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooter = (CTHeaderFooter) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTHeaderFooter == null) {
                cTHeaderFooter = null;
            }
        }
        return cTHeaderFooter;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTLegacyDrawing getLegacyDrawing() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTLegacyDrawing == null) {
                cTLegacyDrawing = null;
            }
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTLegacyDrawing getLegacyDrawingHF() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTLegacyDrawing == null) {
                cTLegacyDrawing = null;
            }
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTPageMargins getPageMargins() {
        CTPageMargins cTPageMargins;
        synchronized (monitor()) {
            check_orphaned();
            cTPageMargins = (CTPageMargins) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTPageMargins == null) {
                cTPageMargins = null;
            }
        }
        return cTPageMargins;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTCsPageSetup getPageSetup() {
        CTCsPageSetup cTCsPageSetupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCsPageSetupFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTCsPageSetupFind_element_user == null) {
                cTCsPageSetupFind_element_user = null;
            }
        }
        return cTCsPageSetupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTSheetBackgroundPicture getPicture() {
        CTSheetBackgroundPicture cTSheetBackgroundPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetBackgroundPicture = (CTSheetBackgroundPicture) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTSheetBackgroundPicture == null) {
                cTSheetBackgroundPicture = null;
            }
        }
        return cTSheetBackgroundPicture;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTChartsheetPr getSheetPr() {
        CTChartsheetPr cTChartsheetPrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartsheetPrFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTChartsheetPrFind_element_user == null) {
                cTChartsheetPrFind_element_user = null;
            }
        }
        return cTChartsheetPrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTChartsheetProtection getSheetProtection() {
        CTChartsheetProtection cTChartsheetProtectionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartsheetProtectionFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTChartsheetProtectionFind_element_user == null) {
                cTChartsheetProtectionFind_element_user = null;
            }
        }
        return cTChartsheetProtectionFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTChartsheetViews getSheetViews() {
        CTChartsheetViews cTChartsheetViewsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTChartsheetViewsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTChartsheetViewsFind_element_user == null) {
                cTChartsheetViewsFind_element_user = null;
            }
        }
        return cTChartsheetViewsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public CTWebPublishItems getWebPublishItems() {
        CTWebPublishItems cTWebPublishItemsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWebPublishItemsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTWebPublishItemsFind_element_user == null) {
                cTWebPublishItemsFind_element_user = null;
            }
        }
        return cTWebPublishItemsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetCustomSheetViews() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetDrawingHF() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetHeaderFooter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetLegacyDrawing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetLegacyDrawingHF() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetPageMargins() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetPageSetup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetPicture() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetSheetPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetSheetProtection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public boolean isSetWebPublishItems() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setCustomSheetViews(CTCustomChartsheetViews cTCustomChartsheetViews) throws Throwable {
        generatedSetterHelperImpl(cTCustomChartsheetViews, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setDrawing(CTDrawing cTDrawing) throws Throwable {
        generatedSetterHelperImpl(cTDrawing, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setDrawingHF(CTDrawingHF cTDrawingHF) throws Throwable {
        generatedSetterHelperImpl(cTDrawingHF, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setHeaderFooter(CTHeaderFooter cTHeaderFooter) throws Throwable {
        generatedSetterHelperImpl(cTHeaderFooter, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setLegacyDrawing(CTLegacyDrawing cTLegacyDrawing) throws Throwable {
        generatedSetterHelperImpl(cTLegacyDrawing, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setLegacyDrawingHF(CTLegacyDrawing cTLegacyDrawing) throws Throwable {
        generatedSetterHelperImpl(cTLegacyDrawing, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setPageMargins(CTPageMargins cTPageMargins) throws Throwable {
        generatedSetterHelperImpl(cTPageMargins, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setPageSetup(CTCsPageSetup cTCsPageSetup) throws Throwable {
        generatedSetterHelperImpl(cTCsPageSetup, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setPicture(CTSheetBackgroundPicture cTSheetBackgroundPicture) throws Throwable {
        generatedSetterHelperImpl(cTSheetBackgroundPicture, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setSheetPr(CTChartsheetPr cTChartsheetPr) throws Throwable {
        generatedSetterHelperImpl(cTChartsheetPr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setSheetProtection(CTChartsheetProtection cTChartsheetProtection) throws Throwable {
        generatedSetterHelperImpl(cTChartsheetProtection, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setSheetViews(CTChartsheetViews cTChartsheetViews) throws Throwable {
        generatedSetterHelperImpl(cTChartsheetViews, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void setWebPublishItems(CTWebPublishItems cTWebPublishItems) throws Throwable {
        generatedSetterHelperImpl(cTWebPublishItems, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetCustomSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetDrawingHF() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetLegacyDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetLegacyDrawingHF() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetPageMargins() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetPageSetup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetPicture() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetSheetPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetSheetProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet
    public void unsetWebPublishItems() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }
}
