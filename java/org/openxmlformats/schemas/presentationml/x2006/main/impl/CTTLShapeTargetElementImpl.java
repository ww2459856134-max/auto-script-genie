package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAnimationElementChoice;
import org.openxmlformats.schemas.drawingml.x2006.main.STDrawingElementId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLOleChartTargetElement;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLSubShapeId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTextTargetElement;

/* loaded from: classes2.dex */
public class CTTLShapeTargetElementImpl extends XmlComplexContentImpl implements CTTLShapeTargetElement {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "bg"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "subSp"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "oleChartEl"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "txEl"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "graphicEl"), new QName("", "spid")};
    private static final long serialVersionUID = 1;

    public CTTLShapeTargetElementImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTEmpty addNewBg() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTAnimationElementChoice addNewGraphicEl() {
        CTAnimationElementChoice cTAnimationElementChoiceAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnimationElementChoiceAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTAnimationElementChoiceAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLOleChartTargetElement addNewOleChartEl() {
        CTTLOleChartTargetElement cTTLOleChartTargetElementAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLOleChartTargetElementAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTLOleChartTargetElementAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLSubShapeId addNewSubSp() {
        CTTLSubShapeId cTTLSubShapeIdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSubShapeIdAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTLSubShapeIdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLTextTargetElement addNewTxEl() {
        CTTLTextTargetElement cTTLTextTargetElementAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTextTargetElementAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTLTextTargetElementAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTEmpty getBg() {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTEmptyFind_element_user == null) {
                cTEmptyFind_element_user = null;
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTAnimationElementChoice getGraphicEl() {
        CTAnimationElementChoice cTAnimationElementChoiceFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnimationElementChoiceFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTAnimationElementChoiceFind_element_user == null) {
                cTAnimationElementChoiceFind_element_user = null;
            }
        }
        return cTAnimationElementChoiceFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLOleChartTargetElement getOleChartEl() {
        CTTLOleChartTargetElement cTTLOleChartTargetElementFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLOleChartTargetElementFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTLOleChartTargetElementFind_element_user == null) {
                cTTLOleChartTargetElementFind_element_user = null;
            }
        }
        return cTTLOleChartTargetElementFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public long getSpid() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[5]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLSubShapeId getSubSp() {
        CTTLSubShapeId cTTLSubShapeIdFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSubShapeIdFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTLSubShapeIdFind_element_user == null) {
                cTTLSubShapeIdFind_element_user = null;
            }
        }
        return cTTLSubShapeIdFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLTextTargetElement getTxEl() {
        CTTLTextTargetElement cTTLTextTargetElementFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTextTargetElementFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTTLTextTargetElementFind_element_user == null) {
                cTTLTextTargetElementFind_element_user = null;
            }
        }
        return cTTLTextTargetElementFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetBg() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetGraphicEl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetOleChartEl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetSubSp() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetTxEl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setBg(CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setGraphicEl(CTAnimationElementChoice cTAnimationElementChoice) throws Throwable {
        generatedSetterHelperImpl(cTAnimationElementChoice, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setOleChartEl(CTTLOleChartTargetElement cTTLOleChartTargetElement) throws Throwable {
        generatedSetterHelperImpl(cTTLOleChartTargetElement, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setSpid(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[5]);
            }
            simpleValue.setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setSubSp(CTTLSubShapeId cTTLSubShapeId) throws Throwable {
        generatedSetterHelperImpl(cTTLSubShapeId, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setTxEl(CTTLTextTargetElement cTTLTextTargetElement) throws Throwable {
        generatedSetterHelperImpl(cTTLTextTargetElement, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetBg() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetGraphicEl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetOleChartEl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetSubSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetTxEl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public STDrawingElementId xgetSpid() {
        STDrawingElementId sTDrawingElementId;
        synchronized (monitor()) {
            check_orphaned();
            sTDrawingElementId = (STDrawingElementId) get_store().find_attribute_user(PROPERTY_QNAME[5]);
        }
        return sTDrawingElementId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void xsetSpid(STDrawingElementId sTDrawingElementId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STDrawingElementId sTDrawingElementId2 = (STDrawingElementId) typeStore.find_attribute_user(qNameArr[5]);
            if (sTDrawingElementId2 == null) {
                sTDrawingElementId2 = (STDrawingElementId) get_store().add_attribute_user(qNameArr[5]);
            }
            sTDrawingElementId2.set(sTDrawingElementId);
        }
    }
}
