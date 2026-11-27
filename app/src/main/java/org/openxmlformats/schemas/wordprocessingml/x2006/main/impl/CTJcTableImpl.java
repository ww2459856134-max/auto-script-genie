package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJcTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJcTable;

/* loaded from: classes3.dex */
public class CTJcTableImpl extends XmlComplexContentImpl implements CTJcTable {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val")};
    private static final long serialVersionUID = 1;

    public CTJcTableImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJcTable
    public STJcTable.Enum getVal() {
        STJcTable.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r1 = simpleValue == null ? null : (STJcTable.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJcTable
    public void setVal(STJcTable.Enum r6) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJcTable
    public STJcTable xgetVal() {
        STJcTable sTJcTable;
        synchronized (monitor()) {
            check_orphaned();
            sTJcTable = (STJcTable) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTJcTable;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJcTable
    public void xsetVal(STJcTable sTJcTable) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STJcTable sTJcTable2 = (STJcTable) typeStore.find_attribute_user(qNameArr[0]);
            if (sTJcTable2 == null) {
                sTJcTable2 = (STJcTable) get_store().add_attribute_user(qNameArr[0]);
            }
            sTJcTable2.set(sTJcTable);
        }
    }
}
