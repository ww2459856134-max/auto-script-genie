package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmptyElement;

/* loaded from: classes2.dex */
public class CTColorMappingOverrideImpl extends XmlComplexContentImpl implements CTColorMappingOverride {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "masterClrMapping"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "overrideClrMapping")};
    private static final long serialVersionUID = 1;

    public CTColorMappingOverrideImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public CTEmptyElement addNewMasterClrMapping() {
        CTEmptyElement cTEmptyElement;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyElement = (CTEmptyElement) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTEmptyElement;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public CTColorMapping addNewOverrideClrMapping() {
        CTColorMapping cTColorMapping;
        synchronized (monitor()) {
            check_orphaned();
            cTColorMapping = (CTColorMapping) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTColorMapping;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public CTEmptyElement getMasterClrMapping() {
        CTEmptyElement cTEmptyElement;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyElement = (CTEmptyElement) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTEmptyElement == null) {
                cTEmptyElement = null;
            }
        }
        return cTEmptyElement;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public CTColorMapping getOverrideClrMapping() {
        CTColorMapping cTColorMapping;
        synchronized (monitor()) {
            check_orphaned();
            cTColorMapping = (CTColorMapping) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTColorMapping == null) {
                cTColorMapping = null;
            }
        }
        return cTColorMapping;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public boolean isSetMasterClrMapping() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public boolean isSetOverrideClrMapping() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public void setMasterClrMapping(CTEmptyElement cTEmptyElement) throws Throwable {
        generatedSetterHelperImpl(cTEmptyElement, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public void setOverrideClrMapping(CTColorMapping cTColorMapping) throws Throwable {
        generatedSetterHelperImpl(cTColorMapping, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public void unsetMasterClrMapping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride
    public void unsetOverrideClrMapping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }
}
