package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTCellXfs extends XmlObject {
    public static final DocumentFactory<CTCellXfs> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCellXfs> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcellxfs1322type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTXf addNewXf();

    long getCount();

    CTXf getXfArray(int i2);

    CTXf[] getXfArray();

    List<CTXf> getXfList();

    CTXf insertNewXf(int i2);

    boolean isSetCount();

    void removeXf(int i2);

    void setCount(long j2);

    void setXfArray(int i2, CTXf cTXf);

    void setXfArray(CTXf[] cTXfArr);

    int sizeOfXfArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
