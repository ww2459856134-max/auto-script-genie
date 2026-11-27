package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrOriginal;

/* loaded from: classes3.dex */
public class CTRPrChangeImpl extends CTTrackChangeImpl implements CTRPrChange {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr")};
    private static final long serialVersionUID = 1;

    public CTRPrChangeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrChange
    public CTRPrOriginal addNewRPr() {
        CTRPrOriginal cTRPrOriginal;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrOriginal = (CTRPrOriginal) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTRPrOriginal;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrChange
    public CTRPrOriginal getRPr() {
        CTRPrOriginal cTRPrOriginal;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrOriginal = (CTRPrOriginal) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTRPrOriginal == null) {
                cTRPrOriginal = null;
            }
        }
        return cTRPrOriginal;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrChange
    public void setRPr(CTRPrOriginal cTRPrOriginal) throws Throwable {
        generatedSetterHelperImpl(cTRPrOriginal, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
