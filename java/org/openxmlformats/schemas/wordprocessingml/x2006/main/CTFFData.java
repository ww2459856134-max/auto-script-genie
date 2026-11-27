package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes3.dex */
public interface CTFFData extends XmlObject {
    public static final DocumentFactory<CTFFData> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFFData> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctffdataaa7etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOnOff addNewCalcOnExit();

    CTFFCheckBox addNewCheckBox();

    CTFFDDList addNewDdList();

    CTOnOff addNewEnabled();

    CTMacroName addNewEntryMacro();

    CTMacroName addNewExitMacro();

    CTFFHelpText addNewHelpText();

    CTDecimalNumber addNewLabel();

    CTFFName addNewName();

    CTFFStatusText addNewStatusText();

    CTUnsignedDecimalNumber addNewTabIndex();

    CTFFTextInput addNewTextInput();

    CTOnOff getCalcOnExitArray(int i2);

    CTOnOff[] getCalcOnExitArray();

    List<CTOnOff> getCalcOnExitList();

    CTFFCheckBox getCheckBoxArray(int i2);

    CTFFCheckBox[] getCheckBoxArray();

    List<CTFFCheckBox> getCheckBoxList();

    CTFFDDList getDdListArray(int i2);

    CTFFDDList[] getDdListArray();

    List<CTFFDDList> getDdListList();

    CTOnOff getEnabledArray(int i2);

    CTOnOff[] getEnabledArray();

    List<CTOnOff> getEnabledList();

    CTMacroName getEntryMacroArray(int i2);

    CTMacroName[] getEntryMacroArray();

    List<CTMacroName> getEntryMacroList();

    CTMacroName getExitMacroArray(int i2);

    CTMacroName[] getExitMacroArray();

    List<CTMacroName> getExitMacroList();

    CTFFHelpText getHelpTextArray(int i2);

    CTFFHelpText[] getHelpTextArray();

    List<CTFFHelpText> getHelpTextList();

    CTDecimalNumber getLabelArray(int i2);

    CTDecimalNumber[] getLabelArray();

    List<CTDecimalNumber> getLabelList();

    CTFFName getNameArray(int i2);

    CTFFName[] getNameArray();

    List<CTFFName> getNameList();

    CTFFStatusText getStatusTextArray(int i2);

    CTFFStatusText[] getStatusTextArray();

    List<CTFFStatusText> getStatusTextList();

    CTUnsignedDecimalNumber getTabIndexArray(int i2);

    CTUnsignedDecimalNumber[] getTabIndexArray();

    List<CTUnsignedDecimalNumber> getTabIndexList();

    CTFFTextInput getTextInputArray(int i2);

    CTFFTextInput[] getTextInputArray();

    List<CTFFTextInput> getTextInputList();

    CTOnOff insertNewCalcOnExit(int i2);

    CTFFCheckBox insertNewCheckBox(int i2);

    CTFFDDList insertNewDdList(int i2);

    CTOnOff insertNewEnabled(int i2);

    CTMacroName insertNewEntryMacro(int i2);

    CTMacroName insertNewExitMacro(int i2);

    CTFFHelpText insertNewHelpText(int i2);

    CTDecimalNumber insertNewLabel(int i2);

    CTFFName insertNewName(int i2);

    CTFFStatusText insertNewStatusText(int i2);

    CTUnsignedDecimalNumber insertNewTabIndex(int i2);

    CTFFTextInput insertNewTextInput(int i2);

    void removeCalcOnExit(int i2);

    void removeCheckBox(int i2);

    void removeDdList(int i2);

    void removeEnabled(int i2);

    void removeEntryMacro(int i2);

    void removeExitMacro(int i2);

    void removeHelpText(int i2);

    void removeLabel(int i2);

    void removeName(int i2);

    void removeStatusText(int i2);

    void removeTabIndex(int i2);

    void removeTextInput(int i2);

    void setCalcOnExitArray(int i2, CTOnOff cTOnOff);

    void setCalcOnExitArray(CTOnOff[] cTOnOffArr);

    void setCheckBoxArray(int i2, CTFFCheckBox cTFFCheckBox);

    void setCheckBoxArray(CTFFCheckBox[] cTFFCheckBoxArr);

    void setDdListArray(int i2, CTFFDDList cTFFDDList);

    void setDdListArray(CTFFDDList[] cTFFDDListArr);

    void setEnabledArray(int i2, CTOnOff cTOnOff);

    void setEnabledArray(CTOnOff[] cTOnOffArr);

    void setEntryMacroArray(int i2, CTMacroName cTMacroName);

    void setEntryMacroArray(CTMacroName[] cTMacroNameArr);

    void setExitMacroArray(int i2, CTMacroName cTMacroName);

    void setExitMacroArray(CTMacroName[] cTMacroNameArr);

    void setHelpTextArray(int i2, CTFFHelpText cTFFHelpText);

    void setHelpTextArray(CTFFHelpText[] cTFFHelpTextArr);

    void setLabelArray(int i2, CTDecimalNumber cTDecimalNumber);

    void setLabelArray(CTDecimalNumber[] cTDecimalNumberArr);

    void setNameArray(int i2, CTFFName cTFFName);

    void setNameArray(CTFFName[] cTFFNameArr);

    void setStatusTextArray(int i2, CTFFStatusText cTFFStatusText);

    void setStatusTextArray(CTFFStatusText[] cTFFStatusTextArr);

    void setTabIndexArray(int i2, CTUnsignedDecimalNumber cTUnsignedDecimalNumber);

    void setTabIndexArray(CTUnsignedDecimalNumber[] cTUnsignedDecimalNumberArr);

    void setTextInputArray(int i2, CTFFTextInput cTFFTextInput);

    void setTextInputArray(CTFFTextInput[] cTFFTextInputArr);

    int sizeOfCalcOnExitArray();

    int sizeOfCheckBoxArray();

    int sizeOfDdListArray();

    int sizeOfEnabledArray();

    int sizeOfEntryMacroArray();

    int sizeOfExitMacroArray();

    int sizeOfHelpTextArray();

    int sizeOfLabelArray();

    int sizeOfNameArray();

    int sizeOfStatusTextArray();

    int sizeOfTabIndexArray();

    int sizeOfTextInputArray();
}
