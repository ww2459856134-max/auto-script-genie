package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* loaded from: classes2.dex */
public interface CTAuthors extends XmlObject {
    public static final DocumentFactory<CTAuthors> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTAuthors> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctauthorsb8a7type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    void addAuthor(String str);

    STXstring addNewAuthor();

    String getAuthorArray(int i2);

    String[] getAuthorArray();

    List<String> getAuthorList();

    void insertAuthor(int i2, String str);

    STXstring insertNewAuthor(int i2);

    void removeAuthor(int i2);

    void setAuthorArray(int i2, String str);

    void setAuthorArray(String[] strArr);

    int sizeOfAuthorArray();

    STXstring xgetAuthorArray(int i2);

    STXstring[] xgetAuthorArray();

    List<STXstring> xgetAuthorList();

    void xsetAuthorArray(int i2, STXstring sTXstring);

    void xsetAuthorArray(STXstring[] sTXstringArr);
}
