package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTTableColumns extends XmlObject {
    public static final DocumentFactory<CTTableColumns> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTableColumns> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttablecolumnsebb8type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTableColumn addNewTableColumn();

    long getCount();

    CTTableColumn getTableColumnArray(int i2);

    CTTableColumn[] getTableColumnArray();

    List<CTTableColumn> getTableColumnList();

    CTTableColumn insertNewTableColumn(int i2);

    boolean isSetCount();

    void removeTableColumn(int i2);

    void setCount(long j2);

    void setTableColumnArray(int i2, CTTableColumn cTTableColumn);

    void setTableColumnArray(CTTableColumn[] cTTableColumnArr);

    int sizeOfTableColumnArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
