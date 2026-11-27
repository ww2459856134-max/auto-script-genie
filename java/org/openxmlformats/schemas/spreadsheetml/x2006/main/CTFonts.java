package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTFonts extends XmlObject {
    public static final DocumentFactory<CTFonts> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFonts> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfonts6623type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTFont addNewFont();

    long getCount();

    CTFont getFontArray(int i2);

    CTFont[] getFontArray();

    List<CTFont> getFontList();

    CTFont insertNewFont(int i2);

    boolean isSetCount();

    void removeFont(int i2);

    void setCount(long j2);

    void setFontArray(int i2, CTFont cTFont);

    void setFontArray(CTFont[] cTFontArr);

    int sizeOfFontArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
