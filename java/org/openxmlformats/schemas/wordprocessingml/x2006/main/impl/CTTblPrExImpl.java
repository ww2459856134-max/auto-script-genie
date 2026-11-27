package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExChange;

/* loaded from: classes3.dex */
public class CTTblPrExImpl extends CTTblPrExBaseImpl implements CTTblPrEx {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPrExChange")};
    private static final long serialVersionUID = 1;

    public CTTblPrExImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public CTTblPrExChange addNewTblPrExChange() {
        CTTblPrExChange cTTblPrExChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPrExChangeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTblPrExChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public CTTblPrExChange getTblPrExChange() {
        CTTblPrExChange cTTblPrExChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPrExChangeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTblPrExChangeFind_element_user == null) {
                cTTblPrExChangeFind_element_user = null;
            }
        }
        return cTTblPrExChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public boolean isSetTblPrExChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public void setTblPrExChange(CTTblPrExChange cTTblPrExChange) throws Throwable {
        generatedSetterHelperImpl(cTTblPrExChange, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public void unsetTblPrExChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
