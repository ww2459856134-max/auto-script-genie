package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.tencent.open.SocialConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STProofErr;

/* loaded from: classes3.dex */
public class CTProofErrImpl extends XmlComplexContentImpl implements CTProofErr {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", SocialConstants.PARAM_TYPE)};
    private static final long serialVersionUID = 1;

    public CTProofErrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr
    public STProofErr.Enum getType() {
        STProofErr.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r1 = simpleValue == null ? null : (STProofErr.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr
    public void setType(STProofErr.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr
    public STProofErr xgetType() {
        STProofErr sTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            sTProofErr = (STProofErr) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr
    public void xsetType(STProofErr sTProofErr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STProofErr sTProofErr2 = (STProofErr) typeStore.find_attribute_user(qNameArr[0]);
            if (sTProofErr2 == null) {
                sTProofErr2 = (STProofErr) get_store().add_attribute_user(qNameArr[0]);
            }
            sTProofErr2.set(sTProofErr);
        }
    }
}
