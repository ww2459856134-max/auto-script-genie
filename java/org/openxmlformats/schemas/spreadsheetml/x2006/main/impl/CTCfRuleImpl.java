package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import com.tencent.open.SocialConstants;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.JavaListObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STConditionalFormattingOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDxfId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STTimePeriod;

/* loaded from: classes2.dex */
public class CTCfRuleImpl extends XmlComplexContentImpl implements CTCfRule {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "formula"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "colorScale"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dataBar"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "iconSet"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst"), new QName("", SocialConstants.PARAM_TYPE), new QName("", "dxfId"), new QName("", "priority"), new QName("", "stopIfTrue"), new QName("", "aboveAverage"), new QName("", "percent"), new QName("", "bottom"), new QName("", "operator"), new QName("", "text"), new QName("", "timePeriod"), new QName("", "rank"), new QName("", "stdDev"), new QName("", "equalAverage")};
    private static final long serialVersionUID = 1;

    public CTCfRuleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    static /* synthetic */ String[] C(int i2) {
        return new String[i2];
    }

    static /* synthetic */ STFormula[] D(int i2) {
        return new STFormula[i2];
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void addFormula(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[0])).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTColorScale addNewColorScale() {
        CTColorScale cTColorScale;
        synchronized (monitor()) {
            check_orphaned();
            cTColorScale = (CTColorScale) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTColorScale;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTDataBar addNewDataBar() {
        CTDataBar cTDataBar;
        synchronized (monitor()) {
            check_orphaned();
            cTDataBar = (CTDataBar) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTDataBar;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STFormula addNewFormula() {
        STFormula sTFormula;
        synchronized (monitor()) {
            check_orphaned();
            sTFormula = (STFormula) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return sTFormula;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTIconSet addNewIconSet() {
        CTIconSet cTIconSet;
        synchronized (monitor()) {
            check_orphaned();
            cTIconSet = (CTIconSet) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTIconSet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean getAboveAverage() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[9]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean getBottom() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[11]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[11]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTColorScale getColorScale() {
        CTColorScale cTColorScale;
        synchronized (monitor()) {
            check_orphaned();
            cTColorScale = (CTColorScale) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTColorScale == null) {
                cTColorScale = null;
            }
        }
        return cTColorScale;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTDataBar getDataBar() {
        CTDataBar cTDataBar;
        synchronized (monitor()) {
            check_orphaned();
            cTDataBar = (CTDataBar) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTDataBar == null) {
                cTDataBar = null;
            }
        }
        return cTDataBar;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public long getDxfId() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[6]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean getEqualAverage() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[17]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[17]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public String[] getFormulaArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[0], u9.a, new IntFunction() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.f3
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTCfRuleImpl.C(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public List<String> getFormulaList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.fj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFormulaArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.jd
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setFormulaArray(((Integer) obj).intValue(), (String) obj2);
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.gd
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertFormula(((Integer) obj).intValue(), (String) obj2);
                }
            }, new n3(this), new ih(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public CTIconSet getIconSet() {
        CTIconSet cTIconSet;
        synchronized (monitor()) {
            check_orphaned();
            cTIconSet = (CTIconSet) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTIconSet == null) {
                cTIconSet = null;
            }
        }
        return cTIconSet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STConditionalFormattingOperator.Enum getOperator() {
        STConditionalFormattingOperator.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[12]);
            r1 = simpleValue == null ? null : (STConditionalFormattingOperator.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean getPercent() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[10]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[10]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public int getPriority() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[7]);
            intValue = simpleValue == null ? 0 : simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public long getRank() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[15]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public int getStdDev() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[16]);
            intValue = simpleValue == null ? 0 : simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean getStopIfTrue() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[8]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public String getText() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[13]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STTimePeriod.Enum getTimePeriod() {
        STTimePeriod.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[14]);
            r1 = simpleValue == null ? null : (STTimePeriod.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STCfType.Enum getType() {
        STCfType.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[5]);
            r1 = simpleValue == null ? null : (STCfType.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void insertFormula(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[0], i2)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STFormula insertNewFormula(int i2) {
        STFormula sTFormula;
        synchronized (monitor()) {
            check_orphaned();
            sTFormula = (STFormula) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return sTFormula;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetAboveAverage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[9]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetBottom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[11]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetColorScale() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetDataBar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetDxfId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[6]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetEqualAverage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[17]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetIconSet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetOperator() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[12]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetPercent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[10]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetRank() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[15]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetStdDev() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[16]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetStopIfTrue() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[8]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[13]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetTimePeriod() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[14]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[5]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void removeFormula(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setAboveAverage(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[9]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setBottom(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[11]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[11]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setColorScale(CTColorScale cTColorScale) throws Throwable {
        generatedSetterHelperImpl(cTColorScale, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setDataBar(CTDataBar cTDataBar) throws Throwable {
        generatedSetterHelperImpl(cTDataBar, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setDxfId(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[6]);
            }
            simpleValue.setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setEqualAverage(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[17]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[17]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setFormulaArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setIconSet(CTIconSet cTIconSet) throws Throwable {
        generatedSetterHelperImpl(cTIconSet, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setOperator(STConditionalFormattingOperator.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[12]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[12]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setPercent(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[10]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[10]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setPriority(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[7]);
            }
            simpleValue.setIntValue(i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setRank(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[15]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[15]);
            }
            simpleValue.setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setStdDev(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[16]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[16]);
            }
            simpleValue.setIntValue(i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setStopIfTrue(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[8]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setText(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[13]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[13]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setTimePeriod(STTimePeriod.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[14]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[14]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setType(STCfType.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[5]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public int sizeOfFormulaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetAboveAverage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[9]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[11]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetColorScale() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetDataBar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetDxfId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[6]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetEqualAverage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[17]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetIconSet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetOperator() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[12]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetPercent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[10]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetRank() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[15]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetStdDev() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[16]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetStopIfTrue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[8]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[13]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetTimePeriod() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[14]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[5]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlBoolean xgetAboveAverage() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[9]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[9]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlBoolean xgetBottom() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[11]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[11]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STDxfId xgetDxfId() {
        STDxfId sTDxfId;
        synchronized (monitor()) {
            check_orphaned();
            sTDxfId = (STDxfId) get_store().find_attribute_user(PROPERTY_QNAME[6]);
        }
        return sTDxfId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlBoolean xgetEqualAverage() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[17]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[17]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STFormula[] xgetFormulaArray() {
        return (STFormula[]) xgetArray(PROPERTY_QNAME[0], new IntFunction() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.e3
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTCfRuleImpl.D(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public List<STFormula> xgetFormulaList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.sj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetFormulaArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.d9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetFormulaArray(((Integer) obj).intValue(), (STFormula) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.n8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFormula(((Integer) obj).intValue());
                }
            }, new n3(this), new ih(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STConditionalFormattingOperator xgetOperator() {
        STConditionalFormattingOperator sTConditionalFormattingOperator;
        synchronized (monitor()) {
            check_orphaned();
            sTConditionalFormattingOperator = (STConditionalFormattingOperator) get_store().find_attribute_user(PROPERTY_QNAME[12]);
        }
        return sTConditionalFormattingOperator;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlBoolean xgetPercent() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[10]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[10]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlInt xgetPriority() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(PROPERTY_QNAME[7]);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlUnsignedInt xgetRank() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[15]);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlInt xgetStdDev() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(PROPERTY_QNAME[16]);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlBoolean xgetStopIfTrue() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[8]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[8]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public XmlString xgetText() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[13]);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STTimePeriod xgetTimePeriod() {
        STTimePeriod sTTimePeriod;
        synchronized (monitor()) {
            check_orphaned();
            sTTimePeriod = (STTimePeriod) get_store().find_attribute_user(PROPERTY_QNAME[14]);
        }
        return sTTimePeriod;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STCfType xgetType() {
        STCfType sTCfType;
        synchronized (monitor()) {
            check_orphaned();
            sTCfType = (STCfType) get_store().find_attribute_user(PROPERTY_QNAME[5]);
        }
        return sTCfType;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetAboveAverage(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[9]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[9]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetBottom(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[11]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[11]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetDxfId(STDxfId sTDxfId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STDxfId sTDxfId2 = (STDxfId) typeStore.find_attribute_user(qNameArr[6]);
            if (sTDxfId2 == null) {
                sTDxfId2 = (STDxfId) get_store().add_attribute_user(qNameArr[6]);
            }
            sTDxfId2.set(sTDxfId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetEqualAverage(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[17]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[17]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetFormulaArray(STFormula[] sTFormulaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTFormulaArr, PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetOperator(STConditionalFormattingOperator sTConditionalFormattingOperator) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STConditionalFormattingOperator sTConditionalFormattingOperator2 = (STConditionalFormattingOperator) typeStore.find_attribute_user(qNameArr[12]);
            if (sTConditionalFormattingOperator2 == null) {
                sTConditionalFormattingOperator2 = (STConditionalFormattingOperator) get_store().add_attribute_user(qNameArr[12]);
            }
            sTConditionalFormattingOperator2.set(sTConditionalFormattingOperator);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetPercent(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[10]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[10]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetPriority(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qNameArr[7]);
            if (xmlInt2 == null) {
                xmlInt2 = (XmlInt) get_store().add_attribute_user(qNameArr[7]);
            }
            xmlInt2.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetRank(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[15]);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[15]);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetStdDev(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qNameArr[16]);
            if (xmlInt2 == null) {
                xmlInt2 = (XmlInt) get_store().add_attribute_user(qNameArr[16]);
            }
            xmlInt2.set(xmlInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetStopIfTrue(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[8]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[8]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetText(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[13]);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[13]);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetTimePeriod(STTimePeriod sTTimePeriod) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STTimePeriod sTTimePeriod2 = (STTimePeriod) typeStore.find_attribute_user(qNameArr[14]);
            if (sTTimePeriod2 == null) {
                sTTimePeriod2 = (STTimePeriod) get_store().add_attribute_user(qNameArr[14]);
            }
            sTTimePeriod2.set(sTTimePeriod);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetType(STCfType sTCfType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STCfType sTCfType2 = (STCfType) typeStore.find_attribute_user(qNameArr[5]);
            if (sTCfType2 == null) {
                sTCfType2 = (STCfType) get_store().add_attribute_user(qNameArr[5]);
            }
            sTCfType2.set(sTCfType);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public String getFormulaArray(int i2) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public STFormula xgetFormulaArray(int i2) {
        STFormula sTFormula;
        synchronized (monitor()) {
            check_orphaned();
            sTFormula = (STFormula) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (sTFormula == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTFormula;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void setFormulaArray(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (simpleValue != null) {
                simpleValue.setStringValue(str);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule
    public void xsetFormulaArray(int i2, STFormula sTFormula) {
        synchronized (monitor()) {
            check_orphaned();
            STFormula sTFormula2 = (STFormula) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (sTFormula2 != null) {
                sTFormula2.set(sTFormula);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }
}
