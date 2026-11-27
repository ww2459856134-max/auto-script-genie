package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes3.dex */
public interface CTEndnotes extends XmlObject {
    public static final DocumentFactory<CTEndnotes> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTEndnotes> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctendnotescee2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTFtnEdn addNewEndnote();

    CTFtnEdn getEndnoteArray(int i2);

    CTFtnEdn[] getEndnoteArray();

    List<CTFtnEdn> getEndnoteList();

    CTFtnEdn insertNewEndnote(int i2);

    void removeEndnote(int i2);

    void setEndnoteArray(int i2, CTFtnEdn cTFtnEdn);

    void setEndnoteArray(CTFtnEdn[] cTFtnEdnArr);

    int sizeOfEndnoteArray();
}
