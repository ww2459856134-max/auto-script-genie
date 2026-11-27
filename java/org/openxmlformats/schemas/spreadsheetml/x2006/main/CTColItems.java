package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTColItems extends XmlObject {
    public static final DocumentFactory<CTColItems> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTColItems> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcolitemsa0c9type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTI addNewI();

    long getCount();

    CTI getIArray(int i2);

    CTI[] getIArray();

    List<CTI> getIList();

    CTI insertNewI(int i2);

    boolean isSetCount();

    void removeI(int i2);

    void setCount(long j2);

    void setIArray(int i2, CTI cti);

    void setIArray(CTI[] ctiArr);

    int sizeOfIArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
