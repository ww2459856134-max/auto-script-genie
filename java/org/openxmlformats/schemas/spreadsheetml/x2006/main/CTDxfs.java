package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTDxfs extends XmlObject {
    public static final DocumentFactory<CTDxfs> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDxfs> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdxfsb26atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDxf addNewDxf();

    long getCount();

    CTDxf getDxfArray(int i2);

    CTDxf[] getDxfArray();

    List<CTDxf> getDxfList();

    CTDxf insertNewDxf(int i2);

    boolean isSetCount();

    void removeDxf(int i2);

    void setCount(long j2);

    void setDxfArray(int i2, CTDxf cTDxf);

    void setDxfArray(CTDxf[] cTDxfArr);

    int sizeOfDxfArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
