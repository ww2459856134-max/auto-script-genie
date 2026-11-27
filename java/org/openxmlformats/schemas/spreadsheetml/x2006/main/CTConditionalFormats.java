package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTConditionalFormats extends XmlObject {
    public static final DocumentFactory<CTConditionalFormats> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTConditionalFormats> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctconditionalformats02fftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTConditionalFormat addNewConditionalFormat();

    CTConditionalFormat getConditionalFormatArray(int i2);

    CTConditionalFormat[] getConditionalFormatArray();

    List<CTConditionalFormat> getConditionalFormatList();

    long getCount();

    CTConditionalFormat insertNewConditionalFormat(int i2);

    boolean isSetCount();

    void removeConditionalFormat(int i2);

    void setConditionalFormatArray(int i2, CTConditionalFormat cTConditionalFormat);

    void setConditionalFormatArray(CTConditionalFormat[] cTConditionalFormatArr);

    void setCount(long j2);

    int sizeOfConditionalFormatArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
