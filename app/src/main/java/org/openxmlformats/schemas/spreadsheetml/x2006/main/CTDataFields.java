package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTDataFields extends XmlObject {
    public static final DocumentFactory<CTDataFields> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDataFields> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdatafields52cctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDataField addNewDataField();

    long getCount();

    CTDataField getDataFieldArray(int i2);

    CTDataField[] getDataFieldArray();

    List<CTDataField> getDataFieldList();

    CTDataField insertNewDataField(int i2);

    boolean isSetCount();

    void removeDataField(int i2);

    void setCount(long j2);

    void setDataFieldArray(int i2, CTDataField cTDataField);

    void setDataFieldArray(CTDataField[] cTDataFieldArr);

    int sizeOfDataFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
