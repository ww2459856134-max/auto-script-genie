package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrChange;

/* loaded from: classes3.dex */
public class CTTblPrImpl extends CTTblPrBaseImpl implements CTTblPr {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPrChange")};
    private static final long serialVersionUID = 1;

    public CTTblPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public CTTblPrChange addNewTblPrChange() {
        CTTblPrChange cTTblPrChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPrChangeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTblPrChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public CTTblPrChange getTblPrChange() {
        CTTblPrChange cTTblPrChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPrChangeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTblPrChangeFind_element_user == null) {
                cTTblPrChangeFind_element_user = null;
            }
        }
        return cTTblPrChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public boolean isSetTblPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public void setTblPrChange(CTTblPrChange cTTblPrChange) throws Throwable {
        generatedSetterHelperImpl(cTTblPrChange, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public void unsetTblPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
