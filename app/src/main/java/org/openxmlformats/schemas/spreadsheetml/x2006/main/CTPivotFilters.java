package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTPivotFilters extends XmlObject {
    public static final DocumentFactory<CTPivotFilters> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPivotFilters> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpivotfilters1462type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPivotFilter addNewFilter();

    long getCount();

    CTPivotFilter getFilterArray(int i2);

    CTPivotFilter[] getFilterArray();

    List<CTPivotFilter> getFilterList();

    CTPivotFilter insertNewFilter(int i2);

    boolean isSetCount();

    void removeFilter(int i2);

    void setCount(long j2);

    void setFilterArray(int i2, CTPivotFilter cTPivotFilter);

    void setFilterArray(CTPivotFilter[] cTPivotFilterArr);

    int sizeOfFilterArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
