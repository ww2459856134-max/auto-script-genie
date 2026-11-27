package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames;

/* loaded from: classes2.dex */
public class CTExternalBookImpl extends XmlComplexContentImpl implements CTExternalBook {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetNames"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "definedNames"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetDataSet"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id")};
    private static final long serialVersionUID = 1;

    public CTExternalBookImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalDefinedNames addNewDefinedNames() {
        CTExternalDefinedNames cTExternalDefinedNames;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalDefinedNames = (CTExternalDefinedNames) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTExternalDefinedNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalSheetDataSet addNewSheetDataSet() {
        CTExternalSheetDataSet cTExternalSheetDataSet;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetDataSet = (CTExternalSheetDataSet) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTExternalSheetDataSet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalSheetNames addNewSheetNames() {
        CTExternalSheetNames cTExternalSheetNames;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetNames = (CTExternalSheetNames) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExternalSheetNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalDefinedNames getDefinedNames() {
        CTExternalDefinedNames cTExternalDefinedNames;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalDefinedNames = (CTExternalDefinedNames) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTExternalDefinedNames == null) {
                cTExternalDefinedNames = null;
            }
        }
        return cTExternalDefinedNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public String getId() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalSheetDataSet getSheetDataSet() {
        CTExternalSheetDataSet cTExternalSheetDataSet;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetDataSet = (CTExternalSheetDataSet) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTExternalSheetDataSet == null) {
                cTExternalSheetDataSet = null;
            }
        }
        return cTExternalSheetDataSet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public CTExternalSheetNames getSheetNames() {
        CTExternalSheetNames cTExternalSheetNames;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetNames = (CTExternalSheetNames) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTExternalSheetNames == null) {
                cTExternalSheetNames = null;
            }
        }
        return cTExternalSheetNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public boolean isSetDefinedNames() {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public boolean isSetSheetDataSet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public boolean isSetSheetNames() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void setDefinedNames(CTExternalDefinedNames cTExternalDefinedNames) throws Throwable {
        generatedSetterHelperImpl(cTExternalDefinedNames, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void setSheetDataSet(CTExternalSheetDataSet cTExternalSheetDataSet) throws Throwable {
        generatedSetterHelperImpl(cTExternalSheetDataSet, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void setSheetNames(CTExternalSheetNames cTExternalSheetNames) throws Throwable {
        generatedSetterHelperImpl(cTExternalSheetNames, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void unsetDefinedNames() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void unsetSheetDataSet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void unsetSheetNames() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public STRelationshipId xgetId() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook
    public void xsetId(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qNameArr[3]);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qNameArr[3]);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }
}
