package org.openxmlformats.schemas.officeDocument.x2006.math;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTM extends XmlObject {
    public static final DocumentFactory<CTM> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTM> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctm3f8ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTMPr addNewMPr();

    CTMR addNewMr();

    CTMPr getMPr();

    CTMR getMrArray(int i2);

    CTMR[] getMrArray();

    List<CTMR> getMrList();

    CTMR insertNewMr(int i2);

    boolean isSetMPr();

    void removeMr(int i2);

    void setMPr(CTMPr cTMPr);

    void setMrArray(int i2, CTMR ctmr);

    void setMrArray(CTMR[] ctmrArr);

    int sizeOfMrArray();

    void unsetMPr();
}
