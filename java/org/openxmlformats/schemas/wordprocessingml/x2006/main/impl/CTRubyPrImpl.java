package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLang;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyAlign;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr;

/* loaded from: classes3.dex */
public class CTRubyPrImpl extends XmlComplexContentImpl implements CTRubyPr {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rubyAlign"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hps"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hpsRaise"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hpsBaseText"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lid"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dirty")};
    private static final long serialVersionUID = 1;

    public CTRubyPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTOnOff addNewDirty() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTHpsMeasure addNewHps() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTHpsMeasure addNewHpsBaseText() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTHpsMeasure addNewHpsRaise() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTLang addNewLid() {
        CTLang cTLang;
        synchronized (monitor()) {
            check_orphaned();
            cTLang = (CTLang) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTLang;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTRubyAlign addNewRubyAlign() {
        CTRubyAlign cTRubyAlign;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyAlign = (CTRubyAlign) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTRubyAlign;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTOnOff getDirty() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTHpsMeasure getHps() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTHpsMeasure == null) {
                cTHpsMeasure = null;
            }
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTHpsMeasure getHpsBaseText() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTHpsMeasure == null) {
                cTHpsMeasure = null;
            }
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTHpsMeasure getHpsRaise() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTHpsMeasure == null) {
                cTHpsMeasure = null;
            }
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTLang getLid() {
        CTLang cTLang;
        synchronized (monitor()) {
            check_orphaned();
            cTLang = (CTLang) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTLang == null) {
                cTLang = null;
            }
        }
        return cTLang;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTRubyAlign getRubyAlign() {
        CTRubyAlign cTRubyAlign;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyAlign = (CTRubyAlign) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTRubyAlign == null) {
                cTRubyAlign = null;
            }
        }
        return cTRubyAlign;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public boolean isSetDirty() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void setDirty(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void setHps(CTHpsMeasure cTHpsMeasure) throws Throwable {
        generatedSetterHelperImpl(cTHpsMeasure, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void setHpsBaseText(CTHpsMeasure cTHpsMeasure) throws Throwable {
        generatedSetterHelperImpl(cTHpsMeasure, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void setHpsRaise(CTHpsMeasure cTHpsMeasure) throws Throwable {
        generatedSetterHelperImpl(cTHpsMeasure, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void setLid(CTLang cTLang) throws Throwable {
        generatedSetterHelperImpl(cTLang, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void setRubyAlign(CTRubyAlign cTRubyAlign) throws Throwable {
        generatedSetterHelperImpl(cTRubyAlign, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void unsetDirty() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }
}
