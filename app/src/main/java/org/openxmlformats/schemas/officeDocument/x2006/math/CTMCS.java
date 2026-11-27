package org.openxmlformats.schemas.officeDocument.x2006.math;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTMCS extends XmlObject {
    public static final DocumentFactory<CTMCS> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTMCS> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctmcs4b1ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTMC addNewMc();

    CTMC getMcArray(int i2);

    CTMC[] getMcArray();

    List<CTMC> getMcList();

    CTMC insertNewMc(int i2);

    void removeMc(int i2);

    void setMcArray(int i2, CTMC ctmc);

    void setMcArray(CTMC[] ctmcArr);

    int sizeOfMcArray();
}
