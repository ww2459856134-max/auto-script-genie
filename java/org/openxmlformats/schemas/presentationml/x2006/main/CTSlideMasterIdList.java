package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTSlideMasterIdList extends XmlObject {
    public static final DocumentFactory<CTSlideMasterIdList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSlideMasterIdList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctslidemasteridlist0b63type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTSlideMasterIdListEntry addNewSldMasterId();

    CTSlideMasterIdListEntry getSldMasterIdArray(int i2);

    CTSlideMasterIdListEntry[] getSldMasterIdArray();

    List<CTSlideMasterIdListEntry> getSldMasterIdList();

    CTSlideMasterIdListEntry insertNewSldMasterId(int i2);

    void removeSldMasterId(int i2);

    void setSldMasterIdArray(int i2, CTSlideMasterIdListEntry cTSlideMasterIdListEntry);

    void setSldMasterIdArray(CTSlideMasterIdListEntry[] cTSlideMasterIdListEntryArr);

    int sizeOfSldMasterIdArray();
}
