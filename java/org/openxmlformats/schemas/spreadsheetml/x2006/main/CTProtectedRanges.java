package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTProtectedRanges extends XmlObject {
    public static final DocumentFactory<CTProtectedRanges> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTProtectedRanges> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctprotectedranges7e83type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTProtectedRange addNewProtectedRange();

    CTProtectedRange getProtectedRangeArray(int i2);

    CTProtectedRange[] getProtectedRangeArray();

    List<CTProtectedRange> getProtectedRangeList();

    CTProtectedRange insertNewProtectedRange(int i2);

    void removeProtectedRange(int i2);

    void setProtectedRangeArray(int i2, CTProtectedRange cTProtectedRange);

    void setProtectedRangeArray(CTProtectedRange[] cTProtectedRangeArr);

    int sizeOfProtectedRangeArray();
}
