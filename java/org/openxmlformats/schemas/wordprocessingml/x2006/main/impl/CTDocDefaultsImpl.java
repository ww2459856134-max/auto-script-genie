package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault;

/* loaded from: classes3.dex */
public class CTDocDefaultsImpl extends XmlComplexContentImpl implements CTDocDefaults {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPrDefault"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPrDefault")};
    private static final long serialVersionUID = 1;

    public CTDocDefaultsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public CTPPrDefault addNewPPrDefault() {
        CTPPrDefault cTPPrDefault;
        synchronized (monitor()) {
            check_orphaned();
            cTPPrDefault = (CTPPrDefault) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTPPrDefault;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public CTRPrDefault addNewRPrDefault() {
        CTRPrDefault cTRPrDefault;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrDefault = (CTRPrDefault) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTRPrDefault;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public CTPPrDefault getPPrDefault() {
        CTPPrDefault cTPPrDefault;
        synchronized (monitor()) {
            check_orphaned();
            cTPPrDefault = (CTPPrDefault) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTPPrDefault == null) {
                cTPPrDefault = null;
            }
        }
        return cTPPrDefault;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public CTRPrDefault getRPrDefault() {
        CTRPrDefault cTRPrDefault;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrDefault = (CTRPrDefault) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTRPrDefault == null) {
                cTRPrDefault = null;
            }
        }
        return cTRPrDefault;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public boolean isSetPPrDefault() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public boolean isSetRPrDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public void setPPrDefault(CTPPrDefault cTPPrDefault) throws Throwable {
        generatedSetterHelperImpl(cTPPrDefault, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public void setRPrDefault(CTRPrDefault cTRPrDefault) throws Throwable {
        generatedSetterHelperImpl(cTRPrDefault, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public void unsetPPrDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public void unsetRPrDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
