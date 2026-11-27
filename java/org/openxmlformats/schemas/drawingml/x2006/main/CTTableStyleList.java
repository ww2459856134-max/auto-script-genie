package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STGuid;

/* loaded from: classes2.dex */
public interface CTTableStyleList extends XmlObject {
    public static final DocumentFactory<CTTableStyleList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTableStyleList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttablestylelist4bdctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTableStyle addNewTblStyle();

    String getDef();

    CTTableStyle getTblStyleArray(int i2);

    CTTableStyle[] getTblStyleArray();

    List<CTTableStyle> getTblStyleList();

    CTTableStyle insertNewTblStyle(int i2);

    void removeTblStyle(int i2);

    void setDef(String str);

    void setTblStyleArray(int i2, CTTableStyle cTTableStyle);

    void setTblStyleArray(CTTableStyle[] cTTableStyleArr);

    int sizeOfTblStyleArray();

    STGuid xgetDef();

    void xsetDef(STGuid sTGuid);
}
