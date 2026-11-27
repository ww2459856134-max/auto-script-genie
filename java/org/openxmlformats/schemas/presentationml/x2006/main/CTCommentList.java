package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTCommentList extends XmlObject {
    public static final DocumentFactory<CTCommentList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCommentList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcommentlistf692type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTComment addNewCm();

    CTComment getCmArray(int i2);

    CTComment[] getCmArray();

    List<CTComment> getCmList();

    CTComment insertNewCm(int i2);

    void removeCm(int i2);

    void setCmArray(int i2, CTComment cTComment);

    void setCmArray(CTComment[] cTCommentArr);

    int sizeOfCmArray();
}
