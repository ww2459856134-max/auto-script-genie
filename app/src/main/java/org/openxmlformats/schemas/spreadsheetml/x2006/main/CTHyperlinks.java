package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTHyperlinks extends XmlObject {
    public static final DocumentFactory<CTHyperlinks> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTHyperlinks> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cthyperlinks6416type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTHyperlink addNewHyperlink();

    CTHyperlink getHyperlinkArray(int i2);

    CTHyperlink[] getHyperlinkArray();

    List<CTHyperlink> getHyperlinkList();

    CTHyperlink insertNewHyperlink(int i2);

    void removeHyperlink(int i2);

    void setHyperlinkArray(int i2, CTHyperlink cTHyperlink);

    void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr);

    int sizeOfHyperlinkArray();
}
