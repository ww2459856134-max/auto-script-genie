package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster;

/* loaded from: classes2.dex */
public class CTNotesMasterImpl extends XmlComplexContentImpl implements CTNotesMaster {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cSld"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "clrMap"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "hf"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "notesStyle"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTNotesMasterImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTCommonSlideData addNewCSld() {
        CTCommonSlideData cTCommonSlideData;
        synchronized (monitor()) {
            check_orphaned();
            cTCommonSlideData = (CTCommonSlideData) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCommonSlideData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTColorMapping addNewClrMap() {
        CTColorMapping cTColorMapping;
        synchronized (monitor()) {
            check_orphaned();
            cTColorMapping = (CTColorMapping) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTColorMapping;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModifyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTExtensionListModifyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTHeaderFooter addNewHf() {
        CTHeaderFooter cTHeaderFooter;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooter = (CTHeaderFooter) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTHeaderFooter;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTTextListStyle addNewNotesStyle() {
        CTTextListStyle cTTextListStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTextListStyle = (CTTextListStyle) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTextListStyle;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTColorMapping getClrMap() {
        CTColorMapping cTColorMapping;
        synchronized (monitor()) {
            check_orphaned();
            cTColorMapping = (CTColorMapping) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTColorMapping == null) {
                cTColorMapping = null;
            }
        }
        return cTColorMapping;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTHeaderFooter getHf() {
        CTHeaderFooter cTHeaderFooter;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooter = (CTHeaderFooter) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTHeaderFooter == null) {
                cTHeaderFooter = null;
            }
        }
        return cTHeaderFooter;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public CTTextListStyle getNotesStyle() {
        CTTextListStyle cTTextListStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTextListStyle = (CTTextListStyle) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTTextListStyle == null) {
                cTTextListStyle = null;
            }
        }
        return cTTextListStyle;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public boolean isSetHf() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public boolean isSetNotesStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void setCSld(CTCommonSlideData cTCommonSlideData) throws Throwable {
        generatedSetterHelperImpl(cTCommonSlideData, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void setClrMap(CTColorMapping cTColorMapping) throws Throwable {
        generatedSetterHelperImpl(cTColorMapping, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void setExtLst(CTExtensionListModify cTExtensionListModify) throws Throwable {
        generatedSetterHelperImpl(cTExtensionListModify, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void setHf(CTHeaderFooter cTHeaderFooter) throws Throwable {
        generatedSetterHelperImpl(cTHeaderFooter, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void setNotesStyle(CTTextListStyle cTTextListStyle) throws Throwable {
        generatedSetterHelperImpl(cTTextListStyle, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void unsetHf() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster
    public void unsetNotesStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }
}
