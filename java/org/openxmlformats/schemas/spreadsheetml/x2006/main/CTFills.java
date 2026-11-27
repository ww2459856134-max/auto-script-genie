package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTFills extends XmlObject {
    public static final DocumentFactory<CTFills> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFills> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfills2c6ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTFill addNewFill();

    long getCount();

    CTFill getFillArray(int i2);

    CTFill[] getFillArray();

    List<CTFill> getFillList();

    CTFill insertNewFill(int i2);

    boolean isSetCount();

    void removeFill(int i2);

    void setCount(long j2);

    void setFillArray(int i2, CTFill cTFill);

    void setFillArray(CTFill[] cTFillArr);

    int sizeOfFillArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
