package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTTextParagraph extends XmlObject {
    public static final DocumentFactory<CTTextParagraph> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTextParagraph> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttextparagraphcaf2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTextLineBreak addNewBr();

    CTTextCharacterProperties addNewEndParaRPr();

    CTTextField addNewFld();

    CTTextParagraphProperties addNewPPr();

    CTRegularTextRun addNewR();

    CTTextLineBreak getBrArray(int i2);

    CTTextLineBreak[] getBrArray();

    List<CTTextLineBreak> getBrList();

    CTTextCharacterProperties getEndParaRPr();

    CTTextField getFldArray(int i2);

    CTTextField[] getFldArray();

    List<CTTextField> getFldList();

    CTTextParagraphProperties getPPr();

    CTRegularTextRun getRArray(int i2);

    CTRegularTextRun[] getRArray();

    List<CTRegularTextRun> getRList();

    CTTextLineBreak insertNewBr(int i2);

    CTTextField insertNewFld(int i2);

    CTRegularTextRun insertNewR(int i2);

    boolean isSetEndParaRPr();

    boolean isSetPPr();

    void removeBr(int i2);

    void removeFld(int i2);

    void removeR(int i2);

    void setBrArray(int i2, CTTextLineBreak cTTextLineBreak);

    void setBrArray(CTTextLineBreak[] cTTextLineBreakArr);

    void setEndParaRPr(CTTextCharacterProperties cTTextCharacterProperties);

    void setFldArray(int i2, CTTextField cTTextField);

    void setFldArray(CTTextField[] cTTextFieldArr);

    void setPPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setRArray(int i2, CTRegularTextRun cTRegularTextRun);

    void setRArray(CTRegularTextRun[] cTRegularTextRunArr);

    int sizeOfBrArray();

    int sizeOfFldArray();

    int sizeOfRArray();

    void unsetEndParaRPr();

    void unsetPPr();
}
