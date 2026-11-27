package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTFunctionGroups extends XmlObject {
    public static final DocumentFactory<CTFunctionGroups> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFunctionGroups> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfunctiongroupsbfd5type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTFunctionGroup addNewFunctionGroup();

    long getBuiltInGroupCount();

    CTFunctionGroup getFunctionGroupArray(int i2);

    CTFunctionGroup[] getFunctionGroupArray();

    List<CTFunctionGroup> getFunctionGroupList();

    CTFunctionGroup insertNewFunctionGroup(int i2);

    boolean isSetBuiltInGroupCount();

    void removeFunctionGroup(int i2);

    void setBuiltInGroupCount(long j2);

    void setFunctionGroupArray(int i2, CTFunctionGroup cTFunctionGroup);

    void setFunctionGroupArray(CTFunctionGroup[] cTFunctionGroupArr);

    int sizeOfFunctionGroupArray();

    void unsetBuiltInGroupCount();

    XmlUnsignedInt xgetBuiltInGroupCount();

    void xsetBuiltInGroupCount(XmlUnsignedInt xmlUnsignedInt);
}
