package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTCalcChain extends XmlObject {
    public static final DocumentFactory<CTCalcChain> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCalcChain> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcalcchain5a0btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCalcCell addNewC();

    CTExtensionList addNewExtLst();

    CTCalcCell getCArray(int i2);

    CTCalcCell[] getCArray();

    List<CTCalcCell> getCList();

    CTExtensionList getExtLst();

    CTCalcCell insertNewC(int i2);

    boolean isSetExtLst();

    void removeC(int i2);

    void setCArray(int i2, CTCalcCell cTCalcCell);

    void setCArray(CTCalcCell[] cTCalcCellArr);

    void setExtLst(CTExtensionList cTExtensionList);

    int sizeOfCArray();

    void unsetExtLst();
}
