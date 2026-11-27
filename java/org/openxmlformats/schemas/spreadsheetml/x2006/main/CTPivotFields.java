package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTPivotFields extends XmlObject {
    public static final DocumentFactory<CTPivotFields> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPivotFields> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpivotfields12batype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPivotField addNewPivotField();

    long getCount();

    CTPivotField getPivotFieldArray(int i2);

    CTPivotField[] getPivotFieldArray();

    List<CTPivotField> getPivotFieldList();

    CTPivotField insertNewPivotField(int i2);

    boolean isSetCount();

    void removePivotField(int i2);

    void setCount(long j2);

    void setPivotFieldArray(int i2, CTPivotField cTPivotField);

    void setPivotFieldArray(CTPivotField[] cTPivotFieldArr);

    int sizeOfPivotFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
