package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes3.dex */
public interface CTSdtEndPr extends XmlObject {
    public static final DocumentFactory<CTSdtEndPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSdtEndPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsdtendprbc6etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTRPr addNewRPr();

    CTRPr getRPrArray(int i2);

    CTRPr[] getRPrArray();

    List<CTRPr> getRPrList();

    CTRPr insertNewRPr(int i2);

    void removeRPr(int i2);

    void setRPrArray(int i2, CTRPr cTRPr);

    void setRPrArray(CTRPr[] cTRPrArr);

    int sizeOfRPrArray();
}
