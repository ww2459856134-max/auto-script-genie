package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTNumFmts extends XmlObject {
    public static final DocumentFactory<CTNumFmts> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNumFmts> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnumfmtsb58btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTNumFmt addNewNumFmt();

    long getCount();

    CTNumFmt getNumFmtArray(int i2);

    CTNumFmt[] getNumFmtArray();

    List<CTNumFmt> getNumFmtList();

    CTNumFmt insertNewNumFmt(int i2);

    boolean isSetCount();

    void removeNumFmt(int i2);

    void setCount(long j2);

    void setNumFmtArray(int i2, CTNumFmt cTNumFmt);

    void setNumFmtArray(CTNumFmt[] cTNumFmtArr);

    int sizeOfNumFmtArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
