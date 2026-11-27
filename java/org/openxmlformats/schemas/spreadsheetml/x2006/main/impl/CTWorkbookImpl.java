package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STConformanceClass;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STConformanceClass$Enum;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFileRecoveryPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFileSharing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFileVersion;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleSize;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSmartTagPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSmartTagTypes;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWebPublishObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWebPublishing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection;

/* loaded from: classes2.dex */
public class CTWorkbookImpl extends XmlComplexContentImpl implements CTWorkbook {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fileVersion"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fileSharing"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "workbookPr"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "workbookProtection"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "bookViews"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheets"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "functionGroups"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "externalReferences"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "definedNames"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "calcPr"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "oleSize"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customWorkbookViews"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pivotCaches"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "smartTagPr"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "smartTagTypes"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "webPublishing"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fileRecoveryPr"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "webPublishObjects"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst"), new QName("", "conformance")};
    private static final long serialVersionUID = 1;

    public CTWorkbookImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTBookViews addNewBookViews() {
        CTBookViews cTBookViews;
        synchronized (monitor()) {
            check_orphaned();
            cTBookViews = (CTBookViews) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTBookViews;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTCalcPr addNewCalcPr() {
        CTCalcPr cTCalcPr;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcPr = (CTCalcPr) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTCalcPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTCustomWorkbookViews addNewCustomWorkbookViews() {
        CTCustomWorkbookViews cTCustomWorkbookViews;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomWorkbookViews = (CTCustomWorkbookViews) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTCustomWorkbookViews;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTDefinedNames addNewDefinedNames() {
        CTDefinedNames cTDefinedNames;
        synchronized (monitor()) {
            check_orphaned();
            cTDefinedNames = (CTDefinedNames) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTDefinedNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTExternalReferences addNewExternalReferences() {
        CTExternalReferences cTExternalReferences;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalReferences = (CTExternalReferences) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTExternalReferences;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileRecoveryPr addNewFileRecoveryPr() {
        CTFileRecoveryPr cTFileRecoveryPr;
        synchronized (monitor()) {
            check_orphaned();
            cTFileRecoveryPr = (CTFileRecoveryPr) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTFileRecoveryPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileSharing addNewFileSharing() {
        CTFileSharing cTFileSharing;
        synchronized (monitor()) {
            check_orphaned();
            cTFileSharing = (CTFileSharing) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTFileSharing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileVersion addNewFileVersion() {
        CTFileVersion cTFileVersion;
        synchronized (monitor()) {
            check_orphaned();
            cTFileVersion = (CTFileVersion) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTFileVersion;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFunctionGroups addNewFunctionGroups() {
        CTFunctionGroups cTFunctionGroups;
        synchronized (monitor()) {
            check_orphaned();
            cTFunctionGroups = (CTFunctionGroups) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTFunctionGroups;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTOleSize addNewOleSize() {
        CTOleSize cTOleSize;
        synchronized (monitor()) {
            check_orphaned();
            cTOleSize = (CTOleSize) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTOleSize;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTPivotCaches addNewPivotCaches() {
        CTPivotCaches cTPivotCaches;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotCaches = (CTPivotCaches) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTPivotCaches;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTSheets addNewSheets() {
        CTSheets cTSheets;
        synchronized (monitor()) {
            check_orphaned();
            cTSheets = (CTSheets) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTSheets;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTSmartTagPr addNewSmartTagPr() {
        CTSmartTagPr cTSmartTagPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagPrAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTSmartTagPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTSmartTagTypes addNewSmartTagTypes() {
        CTSmartTagTypes cTSmartTagTypesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagTypesAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTSmartTagTypesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWebPublishObjects addNewWebPublishObjects() {
        CTWebPublishObjects cTWebPublishObjectsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWebPublishObjectsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTWebPublishObjectsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWebPublishing addNewWebPublishing() {
        CTWebPublishing cTWebPublishing;
        synchronized (monitor()) {
            check_orphaned();
            cTWebPublishing = (CTWebPublishing) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTWebPublishing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWorkbookPr addNewWorkbookPr() {
        CTWorkbookPr cTWorkbookPr;
        synchronized (monitor()) {
            check_orphaned();
            cTWorkbookPr = (CTWorkbookPr) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTWorkbookPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWorkbookProtection addNewWorkbookProtection() {
        CTWorkbookProtection cTWorkbookProtection;
        synchronized (monitor()) {
            check_orphaned();
            cTWorkbookProtection = (CTWorkbookProtection) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTWorkbookProtection;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTBookViews getBookViews() {
        CTBookViews cTBookViews;
        synchronized (monitor()) {
            check_orphaned();
            cTBookViews = (CTBookViews) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTBookViews == null) {
                cTBookViews = null;
            }
        }
        return cTBookViews;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTCalcPr getCalcPr() {
        CTCalcPr cTCalcPr;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcPr = (CTCalcPr) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTCalcPr == null) {
                cTCalcPr = null;
            }
        }
        return cTCalcPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public STConformanceClass$Enum getConformance() {
        STConformanceClass$Enum sTConformanceClass$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[19]);
            sTConformanceClass$Enum = simpleValue == null ? null : (STConformanceClass$Enum) simpleValue.getEnumValue();
        }
        return sTConformanceClass$Enum;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTCustomWorkbookViews getCustomWorkbookViews() {
        CTCustomWorkbookViews cTCustomWorkbookViews;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomWorkbookViews = (CTCustomWorkbookViews) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTCustomWorkbookViews == null) {
                cTCustomWorkbookViews = null;
            }
        }
        return cTCustomWorkbookViews;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTDefinedNames getDefinedNames() {
        CTDefinedNames cTDefinedNames;
        synchronized (monitor()) {
            check_orphaned();
            cTDefinedNames = (CTDefinedNames) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTDefinedNames == null) {
                cTDefinedNames = null;
            }
        }
        return cTDefinedNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[18], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTExternalReferences getExternalReferences() {
        CTExternalReferences cTExternalReferences;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalReferences = (CTExternalReferences) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTExternalReferences == null) {
                cTExternalReferences = null;
            }
        }
        return cTExternalReferences;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileRecoveryPr[] getFileRecoveryPrArray() {
        return (CTFileRecoveryPr[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTFileRecoveryPr[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public List<CTFileRecoveryPr> getFileRecoveryPrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ta
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFileRecoveryPrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.mb
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFileRecoveryPrArray(((Integer) obj).intValue(), (CTFileRecoveryPr) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.x9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFileRecoveryPr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.rc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFileRecoveryPr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.yh
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFileRecoveryPrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileSharing getFileSharing() {
        CTFileSharing cTFileSharing;
        synchronized (monitor()) {
            check_orphaned();
            cTFileSharing = (CTFileSharing) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTFileSharing == null) {
                cTFileSharing = null;
            }
        }
        return cTFileSharing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileVersion getFileVersion() {
        CTFileVersion cTFileVersion;
        synchronized (monitor()) {
            check_orphaned();
            cTFileVersion = (CTFileVersion) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTFileVersion == null) {
                cTFileVersion = null;
            }
        }
        return cTFileVersion;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFunctionGroups getFunctionGroups() {
        CTFunctionGroups cTFunctionGroups;
        synchronized (monitor()) {
            check_orphaned();
            cTFunctionGroups = (CTFunctionGroups) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTFunctionGroups == null) {
                cTFunctionGroups = null;
            }
        }
        return cTFunctionGroups;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTOleSize getOleSize() {
        CTOleSize cTOleSize;
        synchronized (monitor()) {
            check_orphaned();
            cTOleSize = (CTOleSize) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTOleSize == null) {
                cTOleSize = null;
            }
        }
        return cTOleSize;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTPivotCaches getPivotCaches() {
        CTPivotCaches cTPivotCaches;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotCaches = (CTPivotCaches) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTPivotCaches == null) {
                cTPivotCaches = null;
            }
        }
        return cTPivotCaches;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTSheets getSheets() {
        CTSheets cTSheets;
        synchronized (monitor()) {
            check_orphaned();
            cTSheets = (CTSheets) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTSheets == null) {
                cTSheets = null;
            }
        }
        return cTSheets;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTSmartTagPr getSmartTagPr() {
        CTSmartTagPr cTSmartTagPrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagPrFind_element_user = get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTSmartTagPrFind_element_user == null) {
                cTSmartTagPrFind_element_user = null;
            }
        }
        return cTSmartTagPrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTSmartTagTypes getSmartTagTypes() {
        CTSmartTagTypes cTSmartTagTypesFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagTypesFind_element_user = get_store().find_element_user(PROPERTY_QNAME[14], 0);
            if (cTSmartTagTypesFind_element_user == null) {
                cTSmartTagTypesFind_element_user = null;
            }
        }
        return cTSmartTagTypesFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWebPublishObjects getWebPublishObjects() {
        CTWebPublishObjects cTWebPublishObjectsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWebPublishObjectsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[17], 0);
            if (cTWebPublishObjectsFind_element_user == null) {
                cTWebPublishObjectsFind_element_user = null;
            }
        }
        return cTWebPublishObjectsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWebPublishing getWebPublishing() {
        CTWebPublishing cTWebPublishing;
        synchronized (monitor()) {
            check_orphaned();
            cTWebPublishing = (CTWebPublishing) get_store().find_element_user(PROPERTY_QNAME[15], 0);
            if (cTWebPublishing == null) {
                cTWebPublishing = null;
            }
        }
        return cTWebPublishing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWorkbookPr getWorkbookPr() {
        CTWorkbookPr cTWorkbookPr;
        synchronized (monitor()) {
            check_orphaned();
            cTWorkbookPr = (CTWorkbookPr) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTWorkbookPr == null) {
                cTWorkbookPr = null;
            }
        }
        return cTWorkbookPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWorkbookProtection getWorkbookProtection() {
        CTWorkbookProtection cTWorkbookProtection;
        synchronized (monitor()) {
            check_orphaned();
            cTWorkbookProtection = (CTWorkbookProtection) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTWorkbookProtection == null) {
                cTWorkbookProtection = null;
            }
        }
        return cTWorkbookProtection;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileRecoveryPr insertNewFileRecoveryPr(int i2) {
        CTFileRecoveryPr cTFileRecoveryPr;
        synchronized (monitor()) {
            check_orphaned();
            cTFileRecoveryPr = (CTFileRecoveryPr) get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return cTFileRecoveryPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetBookViews() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetCalcPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetConformance() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[19]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetCustomWorkbookViews() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetDefinedNames() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[18]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetExternalReferences() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetFileSharing() {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetFileVersion() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetFunctionGroups() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetOleSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetPivotCaches() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetSmartTagPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetSmartTagTypes() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[14]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetWebPublishObjects() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[17]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetWebPublishing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[15]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetWorkbookPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetWorkbookProtection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void removeFileRecoveryPr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setBookViews(CTBookViews cTBookViews) throws Throwable {
        generatedSetterHelperImpl(cTBookViews, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setCalcPr(CTCalcPr cTCalcPr) throws Throwable {
        generatedSetterHelperImpl(cTCalcPr, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setConformance(STConformanceClass$Enum sTConformanceClass$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[19]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[19]);
            }
            simpleValue.setEnumValue(sTConformanceClass$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setCustomWorkbookViews(CTCustomWorkbookViews cTCustomWorkbookViews) throws Throwable {
        generatedSetterHelperImpl(cTCustomWorkbookViews, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setDefinedNames(CTDefinedNames cTDefinedNames) throws Throwable {
        generatedSetterHelperImpl(cTDefinedNames, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[18], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setExternalReferences(CTExternalReferences cTExternalReferences) throws Throwable {
        generatedSetterHelperImpl(cTExternalReferences, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setFileRecoveryPrArray(CTFileRecoveryPr[] cTFileRecoveryPrArr) {
        check_orphaned();
        arraySetterHelper(cTFileRecoveryPrArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setFileSharing(CTFileSharing cTFileSharing) throws Throwable {
        generatedSetterHelperImpl(cTFileSharing, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setFileVersion(CTFileVersion cTFileVersion) throws Throwable {
        generatedSetterHelperImpl(cTFileVersion, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setFunctionGroups(CTFunctionGroups cTFunctionGroups) throws Throwable {
        generatedSetterHelperImpl(cTFunctionGroups, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setOleSize(CTOleSize cTOleSize) throws Throwable {
        generatedSetterHelperImpl(cTOleSize, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setPivotCaches(CTPivotCaches cTPivotCaches) throws Throwable {
        generatedSetterHelperImpl(cTPivotCaches, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setSheets(CTSheets cTSheets) throws Throwable {
        generatedSetterHelperImpl(cTSheets, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setSmartTagPr(CTSmartTagPr cTSmartTagPr) throws Throwable {
        generatedSetterHelperImpl(cTSmartTagPr, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setSmartTagTypes(CTSmartTagTypes cTSmartTagTypes) throws Throwable {
        generatedSetterHelperImpl(cTSmartTagTypes, PROPERTY_QNAME[14], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setWebPublishObjects(CTWebPublishObjects cTWebPublishObjects) throws Throwable {
        generatedSetterHelperImpl(cTWebPublishObjects, PROPERTY_QNAME[17], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setWebPublishing(CTWebPublishing cTWebPublishing) throws Throwable {
        generatedSetterHelperImpl(cTWebPublishing, PROPERTY_QNAME[15], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setWorkbookPr(CTWorkbookPr cTWorkbookPr) throws Throwable {
        generatedSetterHelperImpl(cTWorkbookPr, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setWorkbookProtection(CTWorkbookProtection cTWorkbookProtection) throws Throwable {
        generatedSetterHelperImpl(cTWorkbookProtection, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public int sizeOfFileRecoveryPrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetBookViews() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetCalcPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetConformance() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[19]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetCustomWorkbookViews() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetDefinedNames() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetExternalReferences() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetFileSharing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetFileVersion() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetFunctionGroups() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetOleSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetPivotCaches() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetSmartTagPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetSmartTagTypes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetWebPublishObjects() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetWebPublishing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetWorkbookPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetWorkbookProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public STConformanceClass xgetConformance() {
        STConformanceClass sTConformanceClassFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTConformanceClassFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[19]);
        }
        return sTConformanceClassFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void xsetConformance(STConformanceClass sTConformanceClass) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STConformanceClass sTConformanceClassFind_attribute_user = typeStore.find_attribute_user(qNameArr[19]);
            if (sTConformanceClassFind_attribute_user == null) {
                sTConformanceClassFind_attribute_user = (STConformanceClass) get_store().add_attribute_user(qNameArr[19]);
            }
            sTConformanceClassFind_attribute_user.set(sTConformanceClass);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileRecoveryPr getFileRecoveryPrArray(int i2) {
        CTFileRecoveryPr cTFileRecoveryPr;
        synchronized (monitor()) {
            check_orphaned();
            cTFileRecoveryPr = (CTFileRecoveryPr) get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (cTFileRecoveryPr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFileRecoveryPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setFileRecoveryPrArray(int i2, CTFileRecoveryPr cTFileRecoveryPr) throws Throwable {
        generatedSetterHelperImpl(cTFileRecoveryPr, PROPERTY_QNAME[16], i2, (short) 2);
    }
}
