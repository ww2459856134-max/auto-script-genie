package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTCustSplit extends XmlObject {
    public static final DocumentFactory<CTCustSplit> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCustSplit> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcustsplit93bftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTUnsignedInt addNewSecondPiePt();

    CTUnsignedInt getSecondPiePtArray(int i2);

    CTUnsignedInt[] getSecondPiePtArray();

    List<CTUnsignedInt> getSecondPiePtList();

    CTUnsignedInt insertNewSecondPiePt(int i2);

    void removeSecondPiePt(int i2);

    void setSecondPiePtArray(int i2, CTUnsignedInt cTUnsignedInt);

    void setSecondPiePtArray(CTUnsignedInt[] cTUnsignedIntArr);

    int sizeOfSecondPiePtArray();
}
