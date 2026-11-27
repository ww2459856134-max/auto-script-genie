package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;

/* loaded from: classes3.dex */
public class CTSdtCellImpl extends XmlComplexContentImpl implements CTSdtCell {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdtPr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdtEndPr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdtContent")};
    private static final long serialVersionUID = 1;

    public CTSdtCellImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public CTSdtContentCell addNewSdtContent() {
        CTSdtContentCell cTSdtContentCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtContentCell = (CTSdtContentCell) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTSdtContentCell;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public CTSdtEndPr addNewSdtEndPr() {
        CTSdtEndPr cTSdtEndPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtEndPr = (CTSdtEndPr) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTSdtEndPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public CTSdtPr addNewSdtPr() {
        CTSdtPr cTSdtPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtPr = (CTSdtPr) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSdtPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public CTSdtContentCell getSdtContent() {
        CTSdtContentCell cTSdtContentCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtContentCell = (CTSdtContentCell) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTSdtContentCell == null) {
                cTSdtContentCell = null;
            }
        }
        return cTSdtContentCell;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public CTSdtEndPr getSdtEndPr() {
        CTSdtEndPr cTSdtEndPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtEndPr = (CTSdtEndPr) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTSdtEndPr == null) {
                cTSdtEndPr = null;
            }
        }
        return cTSdtEndPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public CTSdtPr getSdtPr() {
        CTSdtPr cTSdtPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtPr = (CTSdtPr) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTSdtPr == null) {
                cTSdtPr = null;
            }
        }
        return cTSdtPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public boolean isSetSdtContent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public boolean isSetSdtEndPr() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public boolean isSetSdtPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public void setSdtContent(CTSdtContentCell cTSdtContentCell) throws Throwable {
        generatedSetterHelperImpl(cTSdtContentCell, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public void setSdtEndPr(CTSdtEndPr cTSdtEndPr) throws Throwable {
        generatedSetterHelperImpl(cTSdtEndPr, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public void setSdtPr(CTSdtPr cTSdtPr) throws Throwable {
        generatedSetterHelperImpl(cTSdtPr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public void unsetSdtContent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public void unsetSdtEndPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell
    public void unsetSdtPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
