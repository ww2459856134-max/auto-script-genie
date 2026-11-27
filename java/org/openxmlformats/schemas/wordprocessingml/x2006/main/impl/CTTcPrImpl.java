package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrChange;

/* loaded from: classes3.dex */
public class CTTcPrImpl extends CTTcPrInnerImpl implements CTTcPr {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcPrChange")};
    private static final long serialVersionUID = 1;

    public CTTcPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public CTTcPrChange addNewTcPrChange() {
        CTTcPrChange cTTcPrChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTcPrChangeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTcPrChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public CTTcPrChange getTcPrChange() {
        CTTcPrChange cTTcPrChangeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTcPrChangeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTcPrChangeFind_element_user == null) {
                cTTcPrChangeFind_element_user = null;
            }
        }
        return cTTcPrChangeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public boolean isSetTcPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public void setTcPrChange(CTTcPrChange cTTcPrChange) throws Throwable {
        generatedSetterHelperImpl(cTTcPrChange, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public void unsetTcPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
