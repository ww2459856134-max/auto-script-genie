package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMRUColors;

/* loaded from: classes2.dex */
public class CTColorsImpl extends XmlComplexContentImpl implements CTColors {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "indexedColors"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "mruColors")};
    private static final long serialVersionUID = 1;

    public CTColorsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors
    public CTIndexedColors addNewIndexedColors() {
        CTIndexedColors cTIndexedColors;
        synchronized (monitor()) {
            check_orphaned();
            cTIndexedColors = (CTIndexedColors) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTIndexedColors;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors
    public CTMRUColors addNewMruColors() {
        CTMRUColors cTMRUColorsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMRUColorsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTMRUColorsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors
    public CTIndexedColors getIndexedColors() {
        CTIndexedColors cTIndexedColors;
        synchronized (monitor()) {
            check_orphaned();
            cTIndexedColors = (CTIndexedColors) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTIndexedColors == null) {
                cTIndexedColors = null;
            }
        }
        return cTIndexedColors;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors
    public CTMRUColors getMruColors() {
        CTMRUColors cTMRUColorsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMRUColorsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTMRUColorsFind_element_user == null) {
                cTMRUColorsFind_element_user = null;
            }
        }
        return cTMRUColorsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors
    public boolean isSetIndexedColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors
    public boolean isSetMruColors() {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors
    public void setIndexedColors(CTIndexedColors cTIndexedColors) throws Throwable {
        generatedSetterHelperImpl(cTIndexedColors, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors
    public void setMruColors(CTMRUColors cTMRUColors) throws Throwable {
        generatedSetterHelperImpl(cTMRUColors, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors
    public void unsetIndexedColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors
    public void unsetMruColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }
}
