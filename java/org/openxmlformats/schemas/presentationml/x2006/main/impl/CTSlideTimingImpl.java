package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBuildList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList;

/* loaded from: classes2.dex */
public class CTSlideTimingImpl extends XmlComplexContentImpl implements CTSlideTiming {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "tnLst"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "bldLst"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTSlideTimingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public CTBuildList addNewBldLst() {
        CTBuildList cTBuildListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBuildListAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTBuildListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModifyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTExtensionListModifyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public CTTimeNodeList addNewTnLst() {
        CTTimeNodeList cTTimeNodeList;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeNodeList = (CTTimeNodeList) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTimeNodeList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public CTBuildList getBldLst() {
        CTBuildList cTBuildListFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBuildListFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTBuildListFind_element_user == null) {
                cTBuildListFind_element_user = null;
            }
        }
        return cTBuildListFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public CTExtensionListModify getExtLst() {
        CTExtensionListModify cTExtensionListModifyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTExtensionListModifyFind_element_user == null) {
                cTExtensionListModifyFind_element_user = null;
            }
        }
        return cTExtensionListModifyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public CTTimeNodeList getTnLst() {
        CTTimeNodeList cTTimeNodeList;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeNodeList = (CTTimeNodeList) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTimeNodeList == null) {
                cTTimeNodeList = null;
            }
        }
        return cTTimeNodeList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public boolean isSetBldLst() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public boolean isSetTnLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public void setBldLst(CTBuildList cTBuildList) throws Throwable {
        generatedSetterHelperImpl(cTBuildList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public void setExtLst(CTExtensionListModify cTExtensionListModify) throws Throwable {
        generatedSetterHelperImpl(cTExtensionListModify, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public void setTnLst(CTTimeNodeList cTTimeNodeList) throws Throwable {
        generatedSetterHelperImpl(cTTimeNodeList, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public void unsetBldLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public void unsetTnLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
