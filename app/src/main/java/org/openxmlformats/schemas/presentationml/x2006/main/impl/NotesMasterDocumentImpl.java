package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument;

/* loaded from: classes2.dex */
public class NotesMasterDocumentImpl extends XmlComplexContentImpl implements NotesMasterDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "notesMaster")};
    private static final long serialVersionUID = 1;

    public NotesMasterDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument
    public CTNotesMaster addNewNotesMaster() {
        CTNotesMaster cTNotesMaster;
        synchronized (monitor()) {
            check_orphaned();
            cTNotesMaster = (CTNotesMaster) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTNotesMaster;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument
    public CTNotesMaster getNotesMaster() {
        CTNotesMaster cTNotesMaster;
        synchronized (monitor()) {
            check_orphaned();
            cTNotesMaster = (CTNotesMaster) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTNotesMaster == null) {
                cTNotesMaster = null;
            }
        }
        return cTNotesMaster;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument
    public void setNotesMaster(CTNotesMaster cTNotesMaster) throws Throwable {
        generatedSetterHelperImpl(cTNotesMaster, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
