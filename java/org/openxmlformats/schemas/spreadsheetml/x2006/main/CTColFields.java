package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTColFields extends XmlObject {
    public static final DocumentFactory<CTColFields> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTColFields> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcolfields9ab8type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTField addNewField();

    long getCount();

    CTField getFieldArray(int i2);

    CTField[] getFieldArray();

    List<CTField> getFieldList();

    CTField insertNewField(int i2);

    boolean isSetCount();

    void removeField(int i2);

    void setCount(long j2);

    void setFieldArray(int i2, CTField cTField);

    void setFieldArray(CTField[] cTFieldArr);

    int sizeOfFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
