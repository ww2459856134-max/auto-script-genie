package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTSheetViews extends XmlObject {
    public static final DocumentFactory<CTSheetViews> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSheetViews> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsheetviewsb918type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    CTSheetView addNewSheetView();

    CTExtensionList getExtLst();

    CTSheetView getSheetViewArray(int i2);

    CTSheetView[] getSheetViewArray();

    List<CTSheetView> getSheetViewList();

    CTSheetView insertNewSheetView(int i2);

    boolean isSetExtLst();

    void removeSheetView(int i2);

    void setExtLst(CTExtensionList cTExtensionList);

    void setSheetViewArray(int i2, CTSheetView cTSheetView);

    void setSheetViewArray(CTSheetView[] cTSheetViewArr);

    int sizeOfSheetViewArray();

    void unsetExtLst();
}
