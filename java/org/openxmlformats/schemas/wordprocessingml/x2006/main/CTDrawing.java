package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;

/* loaded from: classes3.dex */
public interface CTDrawing extends XmlObject {
    public static final DocumentFactory<CTDrawing> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDrawing> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdrawing8d34type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAnchor addNewAnchor();

    CTInline addNewInline();

    CTAnchor getAnchorArray(int i2);

    CTAnchor[] getAnchorArray();

    List<CTAnchor> getAnchorList();

    CTInline getInlineArray(int i2);

    CTInline[] getInlineArray();

    List<CTInline> getInlineList();

    CTAnchor insertNewAnchor(int i2);

    CTInline insertNewInline(int i2);

    void removeAnchor(int i2);

    void removeInline(int i2);

    void setAnchorArray(int i2, CTAnchor cTAnchor);

    void setAnchorArray(CTAnchor[] cTAnchorArr);

    void setInlineArray(int i2, CTInline cTInline);

    void setInlineArray(CTInline[] cTInlineArr);

    int sizeOfAnchorArray();

    int sizeOfInlineArray();
}
