package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmbeddedWAVAudioFile;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLSubShapeId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement;

/* loaded from: classes2.dex */
public class CTTLTimeTargetElementImpl extends XmlComplexContentImpl implements CTTLTimeTargetElement {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sldTgt"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sndTgt"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "spTgt"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "inkTgt")};
    private static final long serialVersionUID = 1;

    public CTTLTimeTargetElementImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTTLSubShapeId addNewInkTgt() {
        CTTLSubShapeId cTTLSubShapeIdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSubShapeIdAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTLSubShapeIdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTEmpty addNewSldTgt() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTEmbeddedWAVAudioFile addNewSndTgt() {
        CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFileAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedWAVAudioFileAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTEmbeddedWAVAudioFileAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTTLShapeTargetElement addNewSpTgt() {
        CTTLShapeTargetElement cTTLShapeTargetElement;
        synchronized (monitor()) {
            check_orphaned();
            cTTLShapeTargetElement = (CTTLShapeTargetElement) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTLShapeTargetElement;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTTLSubShapeId getInkTgt() {
        CTTLSubShapeId cTTLSubShapeIdFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSubShapeIdFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTTLSubShapeIdFind_element_user == null) {
                cTTLSubShapeIdFind_element_user = null;
            }
        }
        return cTTLSubShapeIdFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTEmpty getSldTgt() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTEmbeddedWAVAudioFile getSndTgt() {
        CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFileFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedWAVAudioFileFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTEmbeddedWAVAudioFileFind_element_user == null) {
                cTEmbeddedWAVAudioFileFind_element_user = null;
            }
        }
        return cTEmbeddedWAVAudioFileFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTTLShapeTargetElement getSpTgt() {
        CTTLShapeTargetElement cTTLShapeTargetElement;
        synchronized (monitor()) {
            check_orphaned();
            cTTLShapeTargetElement = (CTTLShapeTargetElement) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTLShapeTargetElement == null) {
                cTTLShapeTargetElement = null;
            }
        }
        return cTTLShapeTargetElement;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public boolean isSetInkTgt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public boolean isSetSldTgt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public boolean isSetSndTgt() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public boolean isSetSpTgt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void setInkTgt(CTTLSubShapeId cTTLSubShapeId) throws Throwable {
        generatedSetterHelperImpl(cTTLSubShapeId, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void setSldTgt(CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void setSndTgt(CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile) throws Throwable {
        generatedSetterHelperImpl(cTEmbeddedWAVAudioFile, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void setSpTgt(CTTLShapeTargetElement cTTLShapeTargetElement) throws Throwable {
        generatedSetterHelperImpl(cTTLShapeTargetElement, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void unsetInkTgt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void unsetSldTgt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void unsetSndTgt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void unsetSpTgt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }
}
