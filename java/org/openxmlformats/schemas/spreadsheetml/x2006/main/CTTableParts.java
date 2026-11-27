package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTTableParts extends XmlObject {
    public static final DocumentFactory<CTTableParts> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTableParts> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttablepartsf6bbtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTablePart addNewTablePart();

    long getCount();

    CTTablePart getTablePartArray(int i2);

    CTTablePart[] getTablePartArray();

    List<CTTablePart> getTablePartList();

    CTTablePart insertNewTablePart(int i2);

    boolean isSetCount();

    void removeTablePart(int i2);

    void setCount(long j2);

    void setTablePartArray(int i2, CTTablePart cTTablePart);

    void setTablePartArray(CTTablePart[] cTTablePartArr);

    int sizeOfTablePartArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
