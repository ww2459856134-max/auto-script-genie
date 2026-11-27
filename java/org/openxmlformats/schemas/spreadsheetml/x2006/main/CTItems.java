package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTItems extends XmlObject {
    public static final DocumentFactory<CTItems> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTItems> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctitemsecdftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTItem addNewItem();

    long getCount();

    CTItem getItemArray(int i2);

    CTItem[] getItemArray();

    List<CTItem> getItemList();

    CTItem insertNewItem(int i2);

    boolean isSetCount();

    void removeItem(int i2);

    void setCount(long j2);

    void setItemArray(int i2, CTItem cTItem);

    void setItemArray(CTItem[] cTItemArr);

    int sizeOfItemArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
