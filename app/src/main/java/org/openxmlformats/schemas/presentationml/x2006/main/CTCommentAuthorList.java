package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTCommentAuthorList extends XmlObject {
    public static final DocumentFactory<CTCommentAuthorList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCommentAuthorList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcommentauthorlisteb07type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCommentAuthor addNewCmAuthor();

    CTCommentAuthor getCmAuthorArray(int i2);

    CTCommentAuthor[] getCmAuthorArray();

    List<CTCommentAuthor> getCmAuthorList();

    CTCommentAuthor insertNewCmAuthor(int i2);

    void removeCmAuthor(int i2);

    void setCmAuthorArray(int i2, CTCommentAuthor cTCommentAuthor);

    void setCmAuthorArray(CTCommentAuthor[] cTCommentAuthorArr);

    int sizeOfCmAuthorArray();
}
