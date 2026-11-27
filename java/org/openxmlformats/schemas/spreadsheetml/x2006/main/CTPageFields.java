package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTPageFields extends XmlObject {
    public static final DocumentFactory<CTPageFields> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPageFields> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpagefields1db1type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPageField addNewPageField();

    long getCount();

    CTPageField getPageFieldArray(int i2);

    CTPageField[] getPageFieldArray();

    List<CTPageField> getPageFieldList();

    CTPageField insertNewPageField(int i2);

    boolean isSetCount();

    void removePageField(int i2);

    void setCount(long j2);

    void setPageFieldArray(int i2, CTPageField cTPageField);

    void setPageFieldArray(CTPageField[] cTPageFieldArr);

    int sizeOfPageFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
