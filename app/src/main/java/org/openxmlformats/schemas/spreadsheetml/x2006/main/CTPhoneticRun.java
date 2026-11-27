package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* loaded from: classes2.dex */
public interface CTPhoneticRun extends XmlObject {
    public static final DocumentFactory<CTPhoneticRun> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPhoneticRun> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctphoneticrun2b2atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    long getEb();

    long getSb();

    String getT();

    void setEb(long j2);

    void setSb(long j2);

    void setT(String str);

    XmlUnsignedInt xgetEb();

    XmlUnsignedInt xgetSb();

    STXstring xgetT();

    void xsetEb(XmlUnsignedInt xmlUnsignedInt);

    void xsetSb(XmlUnsignedInt xmlUnsignedInt);

    void xsetT(STXstring sTXstring);
}
