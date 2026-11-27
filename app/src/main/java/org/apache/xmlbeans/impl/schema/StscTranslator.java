package org.apache.xmlbeans.impl.schema;

import com.auto.exceldeps.log4j.util.Chars;
import com.tencent.open.SocialConstants;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaBookmark;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlPositiveInteger;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.schema.StscImporter;
import org.apache.xmlbeans.impl.schema.StscTranslator;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.impl.values.XmlNonNegativeIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlPositiveIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.apache.xmlbeans.impl.xb.xsdschema.Annotated;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
import org.apache.xmlbeans.impl.xpath.XPath;
import org.apache.xmlbeans.soap.SOAPArrayType;

/* loaded from: classes.dex */
public class StscTranslator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String FORM_QUALIFIED = "qualified";
    private static final QName WSDL_ARRAYTYPE_NAME = QNameHelper.forLNS(SoapEncSchemaTypeSystem.ARRAY_TYPE, "http://schemas.xmlsoap.org/wsdl/");
    public static final RegularExpression XPATH_REGEXP = new RegularExpression("(\\.//)?((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)/)*((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)|((attribute::|@)((\\i\\c*:)?(\\i\\c*|\\*))))(\\|(\\.//)?((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)/)*((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)|((attribute::|@)((\\i\\c*:)?(\\i\\c*|\\*)))))*", "X");

    private static class RedefinitionHolder {
        private Map<String, NamedAttributeGroup> agRedefinitions;
        private Map<String, TopLevelComplexType> ctRedefinitions;
        private Map<String, NamedGroup> mgRedefinitions;
        private String schemaLocation;
        private final StscImporter.SchemaToProcess schemaRedefined;
        private Map<String, TopLevelSimpleType> stRedefinitions;

        RedefinitionHolder(StscImporter.SchemaToProcess schemaToProcess, RedefineDocument.Redefine redefine) {
            this.stRedefinitions = Collections.emptyMap();
            this.ctRedefinitions = Collections.emptyMap();
            this.agRedefinitions = Collections.emptyMap();
            this.mgRedefinitions = Collections.emptyMap();
            this.schemaLocation = "";
            this.schemaRedefined = schemaToProcess;
            if (redefine != null) {
                StscState stscState = StscState.get();
                this.stRedefinitions = new HashMap();
                this.ctRedefinitions = new HashMap();
                this.agRedefinitions = new HashMap();
                this.mgRedefinitions = new HashMap();
                if (redefine.getSchemaLocation() != null) {
                    this.schemaLocation = redefine.getSchemaLocation();
                }
                for (TopLevelComplexType topLevelComplexType : redefine.getComplexTypeArray()) {
                    if (topLevelComplexType.getName() != null) {
                        if (this.ctRedefinitions.containsKey(topLevelComplexType.getName())) {
                            stscState.error("Duplicate type redefinition: " + topLevelComplexType.getName(), 49, (XmlObject) null);
                        } else {
                            this.ctRedefinitions.put(topLevelComplexType.getName(), topLevelComplexType);
                        }
                    }
                }
                for (TopLevelSimpleType topLevelSimpleType : redefine.getSimpleTypeArray()) {
                    if (topLevelSimpleType.getName() != null) {
                        if (this.stRedefinitions.containsKey(topLevelSimpleType.getName())) {
                            stscState.error("Duplicate type redefinition: " + topLevelSimpleType.getName(), 49, (XmlObject) null);
                        } else {
                            this.stRedefinitions.put(topLevelSimpleType.getName(), topLevelSimpleType);
                        }
                    }
                }
                for (NamedGroup namedGroup : redefine.getGroupArray()) {
                    if (namedGroup.getName() != null) {
                        if (this.mgRedefinitions.containsKey(namedGroup.getName())) {
                            stscState.error("Duplicate type redefinition: " + namedGroup.getName(), 49, (XmlObject) null);
                        } else {
                            this.mgRedefinitions.put(namedGroup.getName(), namedGroup);
                        }
                    }
                }
                for (NamedAttributeGroup namedAttributeGroup : redefine.getAttributeGroupArray()) {
                    if (namedAttributeGroup.getName() != null) {
                        if (this.agRedefinitions.containsKey(namedAttributeGroup.getName())) {
                            stscState.error("Duplicate type redefinition: " + namedAttributeGroup.getName(), 49, (XmlObject) null);
                        } else {
                            this.agRedefinitions.put(namedAttributeGroup.getName(), namedAttributeGroup);
                        }
                    }
                }
            }
        }

        public void complainAboutMissingDefinitions() {
            if (this.stRedefinitions.isEmpty() && this.ctRedefinitions.isEmpty() && this.agRedefinitions.isEmpty() && this.mgRedefinitions.isEmpty()) {
                return;
            }
            StscState stscState = StscState.get();
            for (String str : this.stRedefinitions.keySet()) {
                stscState.error("Redefined simple type " + str + " not found in " + this.schemaLocation, 60, this.stRedefinitions.get(str));
            }
            for (String str2 : this.ctRedefinitions.keySet()) {
                stscState.error("Redefined complex type " + str2 + " not found in " + this.schemaLocation, 60, this.ctRedefinitions.get(str2));
            }
            for (String str3 : this.agRedefinitions.keySet()) {
                stscState.error("Redefined attribute group " + str3 + " not found in " + this.schemaLocation, 60, this.agRedefinitions.get(str3));
            }
            for (String str4 : this.mgRedefinitions.keySet()) {
                stscState.error("Redefined model group " + str4 + " not found in " + this.schemaLocation, 60, this.mgRedefinitions.get(str4));
            }
        }

        public NamedAttributeGroup redefineAttributeGroup(String str) {
            if (str == null || !this.agRedefinitions.containsKey(str)) {
                return null;
            }
            return this.agRedefinitions.remove(str);
        }

        public TopLevelComplexType redefineComplexType(String str) {
            if (str == null || !this.ctRedefinitions.containsKey(str)) {
                return null;
            }
            return this.ctRedefinitions.remove(str);
        }

        public NamedGroup redefineModelGroup(String str) {
            if (str == null || !this.mgRedefinitions.containsKey(str)) {
                return null;
            }
            return this.mgRedefinitions.remove(str);
        }

        public TopLevelSimpleType redefineSimpleType(String str) {
            if (str == null || !this.stRedefinitions.containsKey(str)) {
                return null;
            }
            return this.stRedefinitions.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class RedefinitionMaster {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final short ATTRIBUTE_GROUP = 4;
        private static final short COMPLEX_TYPE = 2;
        private static final RedefinitionHolder[] EMPTY_REDEFINTION_HOLDER_ARRAY = new RedefinitionHolder[0];
        private static final short MODEL_GROUP = 3;
        private static final short SIMPLE_TYPE = 1;
        private Map<String, List<RedefinitionHolder>> agRedefinitions;
        private Map<String, List<RedefinitionHolder>> ctRedefinitions;
        private Map<String, List<RedefinitionHolder>> mgRedefinitions;
        private Map<String, List<RedefinitionHolder>> stRedefinitions;

        RedefinitionMaster(RedefinitionHolder[] redefinitionHolderArr) {
            this.stRedefinitions = Collections.emptyMap();
            this.ctRedefinitions = Collections.emptyMap();
            this.agRedefinitions = Collections.emptyMap();
            this.mgRedefinitions = Collections.emptyMap();
            if (redefinitionHolderArr.length > 0) {
                this.stRedefinitions = new HashMap();
                this.ctRedefinitions = new HashMap();
                this.agRedefinitions = new HashMap();
                this.mgRedefinitions = new HashMap();
                for (RedefinitionHolder redefinitionHolder : redefinitionHolderArr) {
                    Iterator it = redefinitionHolder.stRedefinitions.keySet().iterator();
                    while (it.hasNext()) {
                        this.stRedefinitions.computeIfAbsent((String) it.next(), new Function() { // from class: org.apache.xmlbeans.impl.schema.n1
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return StscTranslator.RedefinitionMaster.a((String) obj);
                            }
                        }).add(redefinitionHolder);
                    }
                    Iterator it2 = redefinitionHolder.ctRedefinitions.keySet().iterator();
                    while (it2.hasNext()) {
                        this.ctRedefinitions.computeIfAbsent((String) it2.next(), new Function() { // from class: org.apache.xmlbeans.impl.schema.l1
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return StscTranslator.RedefinitionMaster.b((String) obj);
                            }
                        }).add(redefinitionHolder);
                    }
                    Iterator it3 = redefinitionHolder.agRedefinitions.keySet().iterator();
                    while (it3.hasNext()) {
                        this.agRedefinitions.computeIfAbsent((String) it3.next(), new Function() { // from class: org.apache.xmlbeans.impl.schema.k1
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return StscTranslator.RedefinitionMaster.c((String) obj);
                            }
                        }).add(redefinitionHolder);
                    }
                    Iterator it4 = redefinitionHolder.mgRedefinitions.keySet().iterator();
                    while (it4.hasNext()) {
                        this.mgRedefinitions.computeIfAbsent((String) it4.next(), new Function() { // from class: org.apache.xmlbeans.impl.schema.m1
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return StscTranslator.RedefinitionMaster.d((String) obj);
                            }
                        }).add(redefinitionHolder);
                    }
                }
            }
        }

        static /* synthetic */ List a(String str) {
            return new ArrayList();
        }

        static /* synthetic */ List b(String str) {
            return new ArrayList();
        }

        static /* synthetic */ List c(String str) {
            return new ArrayList();
        }

        private String componentNameFromCode(short s) {
            return s != 1 ? s != 2 ? s != 3 ? s != 4 ? "" : "attribute group" : "model group" : "complex type" : "simple type";
        }

        static /* synthetic */ List d(String str) {
            return new ArrayList();
        }

        private RedefinitionHolder[] doTopologicalSort(List<RedefinitionHolder> list, StscImporter.SchemaToProcess schemaToProcess, String str, short s) {
            RedefinitionHolder[] redefinitionHolderArr = new RedefinitionHolder[list.size()];
            int i2 = 0;
            for (RedefinitionHolder redefinitionHolder : list) {
                if (redefinitionHolder.schemaRedefined == schemaToProcess || redefinitionHolder.schemaRedefined.indirectIncludes(schemaToProcess)) {
                    redefinitionHolderArr[i2] = redefinitionHolder;
                    i2++;
                }
            }
            RedefinitionHolder[] redefinitionHolderArr2 = new RedefinitionHolder[i2];
            int[] iArr = new int[i2];
            int i3 = 0;
            while (i3 < i2 - 1) {
                RedefinitionHolder redefinitionHolder2 = redefinitionHolderArr[i3];
                int i4 = i3 + 1;
                for (int i5 = i4; i5 < i2; i5++) {
                    if (redefinitionHolder2.schemaRedefined.indirectIncludes(redefinitionHolderArr[i5].schemaRedefined)) {
                        iArr[i3] = iArr[i3] + 1;
                    }
                    if (redefinitionHolderArr[i5].schemaRedefined.indirectIncludes(redefinitionHolder2.schemaRedefined)) {
                        iArr[i5] = iArr[i5] + 1;
                    }
                }
                i3 = i4;
            }
            int i6 = 0;
            boolean z = false;
            while (true) {
                XmlObject xmlObjectLocationFromRedefinitionAndCode = null;
                if (i6 >= i2) {
                    break;
                }
                int i7 = -1;
                for (int i8 = 0; i8 < i2; i8++) {
                    if (iArr[i8] == 0 && i7 < 0) {
                        i7 = i8;
                    }
                }
                if (i7 < 0) {
                    if (!z) {
                        StringBuilder sb = new StringBuilder();
                        for (int i9 = 0; i9 < i2; i9++) {
                            if (redefinitionHolderArr[i9] != null) {
                                sb.append(redefinitionHolderArr[i9].schemaLocation);
                                sb.append(',');
                                sb.append(Chars.SPACE);
                                if (xmlObjectLocationFromRedefinitionAndCode == null) {
                                    xmlObjectLocationFromRedefinitionAndCode = locationFromRedefinitionAndCode(redefinitionHolderArr[i9], str, s);
                                }
                            }
                        }
                        StscState.get().error("Detected circular redefinition of " + componentNameFromCode(s) + " \"" + str + "\"; Files involved: " + sb.toString(), 60, xmlObjectLocationFromRedefinitionAndCode);
                        z = true;
                    }
                    int i10 = i2;
                    for (int i11 = 0; i11 < i2; i11++) {
                        if (iArr[i11] > 0 && iArr[i11] < i10) {
                            i10 = iArr[i11];
                            i7 = i11;
                        }
                    }
                    iArr[i7] = iArr[i7] - 1;
                } else {
                    int i12 = i6 + 1;
                    redefinitionHolderArr2[i6] = redefinitionHolderArr[i7];
                    for (int i13 = 0; i13 < i2; i13++) {
                        if (redefinitionHolderArr[i13] != null && redefinitionHolderArr[i13].schemaRedefined.indirectIncludes(redefinitionHolderArr[i7].schemaRedefined)) {
                            iArr[i13] = iArr[i13] - 1;
                        }
                    }
                    redefinitionHolderArr[i7] = null;
                    iArr[i7] = iArr[i7] - 1;
                    i6 = i12;
                }
            }
            for (int i14 = 1; i14 < i2; i14++) {
                int i15 = i14 - 1;
                while (i15 >= 0 && redefinitionHolderArr2[i15] == null) {
                    i15--;
                }
                if (!redefinitionHolderArr2[i14].schemaRedefined.indirectIncludes(redefinitionHolderArr2[i15].schemaRedefined)) {
                    StscState.get().error("Detected multiple redefinitions of " + componentNameFromCode(s) + " \"" + str + "\"; Files involved: " + redefinitionHolderArr2[i15].schemaRedefined.getSourceName() + ", " + redefinitionHolderArr2[i14].schemaRedefined.getSourceName(), 49, locationFromRedefinitionAndCode(redefinitionHolderArr2[i14], str, s));
                    if (s == 1) {
                        redefinitionHolderArr2[i14].redefineSimpleType(str);
                    } else if (s == 2) {
                        redefinitionHolderArr2[i14].redefineComplexType(str);
                    } else if (s == 3) {
                        redefinitionHolderArr2[i14].redefineModelGroup(str);
                    } else if (s == 4) {
                        redefinitionHolderArr2[i14].redefineAttributeGroup(str);
                    }
                    redefinitionHolderArr2[i14] = null;
                }
            }
            return redefinitionHolderArr2;
        }

        private XmlObject locationFromRedefinitionAndCode(RedefinitionHolder redefinitionHolder, String str, short s) {
            if (s == 1) {
                return (XmlObject) redefinitionHolder.stRedefinitions.get(str);
            }
            if (s == 2) {
                return (XmlObject) redefinitionHolder.ctRedefinitions.get(str);
            }
            if (s == 3) {
                return (XmlObject) redefinitionHolder.mgRedefinitions.get(str);
            }
            if (s != 4) {
                return null;
            }
            return (XmlObject) redefinitionHolder.agRedefinitions.get(str);
        }

        RedefinitionHolder[] getAttributeGroupRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List<RedefinitionHolder> list = this.agRedefinitions.get(str);
            return list == null ? EMPTY_REDEFINTION_HOLDER_ARRAY : doTopologicalSort(list, schemaToProcess, str, ATTRIBUTE_GROUP);
        }

        RedefinitionHolder[] getComplexTypeRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List<RedefinitionHolder> list = this.ctRedefinitions.get(str);
            return list == null ? EMPTY_REDEFINTION_HOLDER_ARRAY : doTopologicalSort(list, schemaToProcess, str, (short) 2);
        }

        RedefinitionHolder[] getModelGroupRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List<RedefinitionHolder> list = this.mgRedefinitions.get(str);
            return list == null ? EMPTY_REDEFINTION_HOLDER_ARRAY : doTopologicalSort(list, schemaToProcess, str, MODEL_GROUP);
        }

        RedefinitionHolder[] getSimpleTypeRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List<RedefinitionHolder> list = this.stRedefinitions.get(str);
            return list == null ? EMPTY_REDEFINTION_HOLDER_ARRAY : doTopologicalSort(list, schemaToProcess, str, (short) 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void addAllDefinitions(StscImporter.SchemaToProcess[] schemaToProcessArr) {
        boolean z;
        StscImporter.SchemaToProcess[] schemaToProcessArr2 = schemaToProcessArr;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (StscImporter.SchemaToProcess schemaToProcess : schemaToProcessArr2) {
            List<StscImporter.SchemaToProcess> redefines = schemaToProcess.getRedefines();
            if (redefines != null) {
                List<RedefineDocument.Redefine> redefineObjects = schemaToProcess.getRedefineObjects();
                Iterator<StscImporter.SchemaToProcess> it = redefines.iterator();
                Iterator<RedefineDocument.Redefine> it2 = redefineObjects.iterator();
                while (it.hasNext()) {
                    arrayList.add(new RedefinitionHolder(it.next(), it2.next()));
                }
            }
        }
        RedefinitionMaster redefinitionMaster = new RedefinitionMaster((RedefinitionHolder[]) arrayList.toArray(new RedefinitionHolder[0]));
        StscState stscState = StscState.get();
        int length = schemaToProcessArr2.length;
        int i3 = 0;
        while (i3 < length) {
            StscImporter.SchemaToProcess schemaToProcess2 = schemaToProcessArr2[i3];
            SchemaDocument.Schema schema = schemaToProcess2.getSchema();
            String chameleonNamespace = schemaToProcess2.getChameleonNamespace();
            if (schema.sizeOfNotationArray() > 0) {
                stscState.warning("Schema <notation> is not yet supported for this release.", 51, schema.getNotationArray(i2));
            }
            String targetNamespace = schema.getTargetNamespace();
            if (chameleonNamespace == null || targetNamespace != null) {
                chameleonNamespace = targetNamespace;
                z = i2;
            } else {
                z = 1;
            }
            if (chameleonNamespace == null) {
                chameleonNamespace = "";
            }
            if (chameleonNamespace.length() > 0 || !isEmptySchema(schema)) {
                stscState.registerContribution(chameleonNamespace, schema.documentProperties().getSourceName());
                stscState.addNewContainer(chameleonNamespace);
            }
            ArrayList arrayList2 = new ArrayList();
            TopLevelComplexType[] complexTypeArray = schema.getComplexTypeArray();
            int length2 = complexTypeArray.length;
            int i4 = i2;
            while (i4 < length2) {
                TopLevelComplexType topLevelComplexType = complexTypeArray[i4];
                RedefinitionHolder[] complexTypeRedefinitions = redefinitionMaster.getComplexTypeRedefinitions(topLevelComplexType.getName(), schemaToProcess2);
                int length3 = complexTypeRedefinitions.length;
                TopLevelComplexType topLevelComplexType2 = topLevelComplexType;
                int i5 = 0;
                while (i5 < length3) {
                    int i6 = length;
                    RedefinitionHolder redefinitionHolder = complexTypeRedefinitions[i5];
                    RedefinitionHolder[] redefinitionHolderArr = complexTypeRedefinitions;
                    if (redefinitionHolder != null) {
                        TopLevelComplexType topLevelComplexTypeRedefineComplexType = redefinitionHolder.redefineComplexType(topLevelComplexType2.getName());
                        arrayList2.add(topLevelComplexType2);
                        topLevelComplexType2 = topLevelComplexTypeRedefineComplexType;
                    }
                    i5++;
                    length = i6;
                    complexTypeRedefinitions = redefinitionHolderArr;
                }
                int i7 = length;
                SchemaTypeImpl schemaTypeImplTranslateGlobalComplexType = translateGlobalComplexType(topLevelComplexType2, chameleonNamespace, z, !arrayList2.isEmpty());
                stscState.addGlobalType(schemaTypeImplTranslateGlobalComplexType, null);
                int size = arrayList2.size() - 1;
                while (size >= 0) {
                    SchemaTypeImpl schemaTypeImplTranslateGlobalComplexType2 = translateGlobalComplexType((TopLevelComplexType) arrayList2.remove(size), chameleonNamespace, z, size > 0);
                    stscState.addGlobalType(schemaTypeImplTranslateGlobalComplexType2, schemaTypeImplTranslateGlobalComplexType);
                    size--;
                    schemaTypeImplTranslateGlobalComplexType = schemaTypeImplTranslateGlobalComplexType2;
                }
                i4++;
                length = i7;
            }
            int i8 = length;
            TopLevelSimpleType[] simpleTypeArray = schema.getSimpleTypeArray();
            int length4 = simpleTypeArray.length;
            int i9 = 0;
            while (i9 < length4) {
                TopLevelSimpleType topLevelSimpleType = simpleTypeArray[i9];
                RedefinitionHolder[] simpleTypeRedefinitions = redefinitionMaster.getSimpleTypeRedefinitions(topLevelSimpleType.getName(), schemaToProcess2);
                int length5 = simpleTypeRedefinitions.length;
                int i10 = 0;
                while (i10 < length5) {
                    TopLevelSimpleType[] topLevelSimpleTypeArr = simpleTypeArray;
                    RedefinitionHolder redefinitionHolder2 = simpleTypeRedefinitions[i10];
                    int i11 = length4;
                    if (redefinitionHolder2 != null) {
                        TopLevelSimpleType topLevelSimpleTypeRedefineSimpleType = redefinitionHolder2.redefineSimpleType(topLevelSimpleType.getName());
                        arrayList2.add(topLevelSimpleType);
                        topLevelSimpleType = topLevelSimpleTypeRedefineSimpleType;
                    }
                    i10++;
                    simpleTypeArray = topLevelSimpleTypeArr;
                    length4 = i11;
                }
                TopLevelSimpleType[] topLevelSimpleTypeArr2 = simpleTypeArray;
                int i12 = length4;
                SchemaTypeImpl schemaTypeImplTranslateGlobalSimpleType = translateGlobalSimpleType(topLevelSimpleType, chameleonNamespace, z, !arrayList2.isEmpty());
                stscState.addGlobalType(schemaTypeImplTranslateGlobalSimpleType, null);
                int size2 = arrayList2.size() - 1;
                while (size2 >= 0) {
                    SchemaTypeImpl schemaTypeImplTranslateGlobalSimpleType2 = translateGlobalSimpleType((TopLevelSimpleType) arrayList2.remove(size2), chameleonNamespace, z, size2 > 0);
                    stscState.addGlobalType(schemaTypeImplTranslateGlobalSimpleType2, schemaTypeImplTranslateGlobalSimpleType);
                    size2--;
                    schemaTypeImplTranslateGlobalSimpleType = schemaTypeImplTranslateGlobalSimpleType2;
                }
                i9++;
                simpleTypeArray = topLevelSimpleTypeArr2;
                length4 = i12;
            }
            for (TopLevelElement topLevelElement : schema.getElementArray()) {
                stscState.addDocumentType(translateDocumentType(topLevelElement, chameleonNamespace, z), QNameHelper.forLNS(topLevelElement.getName(), chameleonNamespace));
            }
            for (TopLevelAttribute topLevelAttribute : schema.getAttributeArray()) {
                stscState.addAttributeType(translateAttributeType(topLevelAttribute, chameleonNamespace, z), QNameHelper.forLNS(topLevelAttribute.getName(), chameleonNamespace));
            }
            NamedGroup[] groupArray = schema.getGroupArray();
            int length6 = groupArray.length;
            int i13 = 0;
            while (i13 < length6) {
                NamedGroup namedGroup = groupArray[i13];
                RedefinitionHolder[] modelGroupRedefinitions = redefinitionMaster.getModelGroupRedefinitions(namedGroup.getName(), schemaToProcess2);
                int length7 = modelGroupRedefinitions.length;
                int i14 = 0;
                while (i14 < length7) {
                    NamedGroup[] namedGroupArr = groupArray;
                    RedefinitionHolder redefinitionHolder3 = modelGroupRedefinitions[i14];
                    int i15 = length6;
                    if (redefinitionHolder3 != null) {
                        NamedGroup namedGroupRedefineModelGroup = redefinitionHolder3.redefineModelGroup(namedGroup.getName());
                        arrayList2.add(namedGroup);
                        namedGroup = namedGroupRedefineModelGroup;
                    }
                    i14++;
                    groupArray = namedGroupArr;
                    length6 = i15;
                }
                NamedGroup[] namedGroupArr2 = groupArray;
                int i16 = length6;
                SchemaModelGroupImpl schemaModelGroupImplTranslateModelGroup = translateModelGroup(namedGroup, chameleonNamespace, z, !arrayList2.isEmpty());
                stscState.addModelGroup(schemaModelGroupImplTranslateModelGroup, null);
                int size3 = arrayList2.size() - 1;
                while (size3 >= 0) {
                    SchemaModelGroupImpl schemaModelGroupImplTranslateModelGroup2 = translateModelGroup((NamedGroup) arrayList2.remove(size3), chameleonNamespace, z, size3 > 0);
                    stscState.addModelGroup(schemaModelGroupImplTranslateModelGroup2, schemaModelGroupImplTranslateModelGroup);
                    size3--;
                    schemaModelGroupImplTranslateModelGroup = schemaModelGroupImplTranslateModelGroup2;
                }
                i13++;
                groupArray = namedGroupArr2;
                length6 = i16;
            }
            NamedAttributeGroup[] attributeGroupArray = schema.getAttributeGroupArray();
            int length8 = attributeGroupArray.length;
            int i17 = 0;
            while (i17 < length8) {
                NamedAttributeGroup namedAttributeGroup = attributeGroupArray[i17];
                RedefinitionHolder[] attributeGroupRedefinitions = redefinitionMaster.getAttributeGroupRedefinitions(namedAttributeGroup.getName(), schemaToProcess2);
                int length9 = attributeGroupRedefinitions.length;
                int i18 = 0;
                while (i18 < length9) {
                    NamedAttributeGroup[] namedAttributeGroupArr = attributeGroupArray;
                    RedefinitionHolder redefinitionHolder4 = attributeGroupRedefinitions[i18];
                    RedefinitionMaster redefinitionMaster2 = redefinitionMaster;
                    if (redefinitionHolder4 != null) {
                        NamedAttributeGroup namedAttributeGroupRedefineAttributeGroup = redefinitionHolder4.redefineAttributeGroup(namedAttributeGroup.getName());
                        arrayList2.add(namedAttributeGroup);
                        namedAttributeGroup = namedAttributeGroupRedefineAttributeGroup;
                    }
                    i18++;
                    attributeGroupArray = namedAttributeGroupArr;
                    redefinitionMaster = redefinitionMaster2;
                }
                NamedAttributeGroup[] namedAttributeGroupArr2 = attributeGroupArray;
                RedefinitionMaster redefinitionMaster3 = redefinitionMaster;
                SchemaAttributeGroupImpl schemaAttributeGroupImplTranslateAttributeGroup = translateAttributeGroup(namedAttributeGroup, chameleonNamespace, z, !arrayList2.isEmpty());
                stscState.addAttributeGroup(schemaAttributeGroupImplTranslateAttributeGroup, null);
                int size4 = arrayList2.size() - 1;
                while (size4 >= 0) {
                    SchemaAttributeGroupImpl schemaAttributeGroupImplTranslateAttributeGroup2 = translateAttributeGroup((NamedAttributeGroup) arrayList2.remove(size4), chameleonNamespace, z, size4 > 0);
                    stscState.addAttributeGroup(schemaAttributeGroupImplTranslateAttributeGroup2, schemaAttributeGroupImplTranslateAttributeGroup);
                    size4--;
                    schemaAttributeGroupImplTranslateAttributeGroup = schemaAttributeGroupImplTranslateAttributeGroup2;
                }
                i17++;
                attributeGroupArray = namedAttributeGroupArr2;
                redefinitionMaster = redefinitionMaster3;
            }
            RedefinitionMaster redefinitionMaster4 = redefinitionMaster;
            for (AnnotationDocument.Annotation annotation : schema.getAnnotationArray()) {
                stscState.addAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(chameleonNamespace), schema, annotation), chameleonNamespace);
            }
            i3++;
            schemaToProcessArr2 = schemaToProcessArr;
            length = i8;
            redefinitionMaster = redefinitionMaster4;
            i2 = 0;
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((RedefinitionHolder) it3.next()).complainAboutMissingDefinitions();
        }
    }

    static BigInteger buildBigInt(XmlAnySimpleType xmlAnySimpleType) {
        if (xmlAnySimpleType == null) {
            return null;
        }
        String stringValue = xmlAnySimpleType.getStringValue();
        try {
            BigInteger bigInteger = new BigInteger(stringValue);
            if (bigInteger.signum() >= 0) {
                return bigInteger;
            }
            StscState.get().error(XmlErrorCodes.INVALID_VALUE, new Object[]{stringValue, "nonNegativeInteger"}, xmlAnySimpleType);
            return null;
        } catch (NumberFormatException e) {
            StscState.get().error(XmlErrorCodes.INVALID_VALUE_DETAIL, new Object[]{stringValue, "nonNegativeInteger", e.getMessage()}, xmlAnySimpleType);
            return null;
        }
    }

    static XmlNonNegativeInteger buildNnInteger(XmlAnySimpleType xmlAnySimpleType) {
        BigInteger bigIntegerBuildBigInt = buildBigInt(xmlAnySimpleType);
        try {
            XmlNonNegativeIntegerImpl xmlNonNegativeIntegerImpl = new XmlNonNegativeIntegerImpl();
            xmlNonNegativeIntegerImpl.setBigIntegerValue(bigIntegerBuildBigInt);
            xmlNonNegativeIntegerImpl.setImmutable();
            return xmlNonNegativeIntegerImpl;
        } catch (XmlValueOutOfRangeException unused) {
            StscState.get().error("Internal error processing number", 21, xmlAnySimpleType);
            return null;
        }
    }

    static XmlPositiveInteger buildPosInteger(XmlAnySimpleType xmlAnySimpleType) {
        BigInteger bigIntegerBuildBigInt = buildBigInt(xmlAnySimpleType);
        try {
            XmlPositiveIntegerImpl xmlPositiveIntegerImpl = new XmlPositiveIntegerImpl();
            xmlPositiveIntegerImpl.setBigIntegerValue(bigIntegerBuildBigInt);
            xmlPositiveIntegerImpl.setImmutable();
            return xmlPositiveIntegerImpl;
        } catch (XmlValueOutOfRangeException unused) {
            StscState.get().error("Internal error processing number", 21, xmlAnySimpleType);
            return null;
        }
    }

    private static SchemaType checkRecursiveGroupReference(QName[] qNameArr, QName qName, SchemaTypeImpl schemaTypeImpl) {
        QName[] groupReferenceContext;
        if (qNameArr.length < 1) {
            return null;
        }
        while (schemaTypeImpl != null && schemaTypeImpl.getName() == null && !schemaTypeImpl.isDocumentType()) {
            if (qName.equals(schemaTypeImpl.getContainerField().getName()) && (groupReferenceContext = schemaTypeImpl.getGroupReferenceContext()) != null && groupReferenceContext.length == qNameArr.length) {
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= qNameArr.length) {
                        z = true;
                        break;
                    }
                    if (!(qNameArr[i2] == null && groupReferenceContext[i2] == null) && (qNameArr[i2] == null || !qNameArr[i2].equals(groupReferenceContext[i2]))) {
                        break;
                    }
                    i2++;
                }
                if (z) {
                    return schemaTypeImpl;
                }
            }
            schemaTypeImpl = (SchemaTypeImpl) schemaTypeImpl.getOuterType();
        }
        return null;
    }

    private static boolean checkXPathSyntax(String str) {
        boolean zMatches;
        if (str == null) {
            return false;
        }
        String strRemoveWhitespace = removeWhitespace(str);
        RegularExpression regularExpression = XPATH_REGEXP;
        synchronized (regularExpression) {
            zMatches = regularExpression.matches(strRemoveWhitespace);
        }
        return zMatches;
    }

    public static void copyGlobalAttributeToLocalAttribute(SchemaGlobalAttributeImpl schemaGlobalAttributeImpl, SchemaLocalAttributeImpl schemaLocalAttributeImpl) {
        schemaLocalAttributeImpl.init(schemaGlobalAttributeImpl.getName(), schemaGlobalAttributeImpl.getTypeRef(), schemaGlobalAttributeImpl.getUse(), schemaGlobalAttributeImpl.getDefaultText(), schemaGlobalAttributeImpl.getParseObject(), schemaGlobalAttributeImpl._defaultValue, schemaGlobalAttributeImpl.isFixed(), schemaGlobalAttributeImpl.getWSDLArrayType(), schemaGlobalAttributeImpl.getAnnotation(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void copyGlobalElementToLocalElement(SchemaGlobalElement schemaGlobalElement, SchemaLocalElementImpl schemaLocalElementImpl) {
        schemaLocalElementImpl.setNameAndTypeRef(schemaGlobalElement.getName(), schemaGlobalElement.getType().getRef());
        schemaLocalElementImpl.setNillable(schemaGlobalElement.isNillable());
        schemaLocalElementImpl.setDefault(schemaGlobalElement.getDefaultText(), schemaGlobalElement.isFixed(), ((SchemaGlobalElementImpl) schemaGlobalElement).getParseObject());
        schemaLocalElementImpl.setIdentityConstraints(((SchemaLocalElementImpl) schemaGlobalElement).getIdentityConstraintRefs());
        schemaLocalElementImpl.setBlock(schemaGlobalElement.blockExtension(), schemaGlobalElement.blockRestriction(), schemaGlobalElement.blockSubstitution());
        schemaLocalElementImpl.setAbstract(schemaGlobalElement.isAbstract());
        SchemaParticle schemaParticle = (SchemaParticle) schemaGlobalElement;
        schemaLocalElementImpl.setTransitionRules(schemaParticle.acceptedStartNames(), schemaParticle.isSkippable());
        schemaLocalElementImpl.setAnnotation(schemaGlobalElement.getAnnotation());
    }

    static FormChoice findAttributeFormDefault(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        while (xmlCursorNewCursor.getObject().schemaType() != SchemaDocument.Schema.type) {
            try {
                if (!xmlCursorNewCursor.toParent()) {
                    if (xmlCursorNewCursor != null) {
                        xmlCursorNewCursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        FormChoice formChoiceXgetAttributeFormDefault = ((SchemaDocument.Schema) xmlCursorNewCursor.getObject()).xgetAttributeFormDefault();
        if (xmlCursorNewCursor != null) {
            xmlCursorNewCursor.close();
        }
        return formChoiceXgetAttributeFormDefault;
    }

    static FormChoice findElementFormDefault(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        while (xmlCursorNewCursor.getObject().schemaType() != SchemaDocument.Schema.type) {
            try {
                if (!xmlCursorNewCursor.toParent()) {
                    if (xmlCursorNewCursor != null) {
                        xmlCursorNewCursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        FormChoice formChoiceXgetElementFormDefault = ((SchemaDocument.Schema) xmlCursorNewCursor.getObject()).xgetElementFormDefault();
        if (xmlCursorNewCursor != null) {
            xmlCursorNewCursor.close();
        }
        return formChoiceXgetElementFormDefault;
    }

    private static String findFilename(XmlObject xmlObject) {
        return StscState.get().sourceNameForUri(xmlObject.documentProperties().getSourceName());
    }

    private static Object getUserData(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            XmlCursor.XmlBookmark bookmark = xmlCursorNewCursor.getBookmark(SchemaBookmark.class);
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            if (bookmark instanceof SchemaBookmark) {
                return ((SchemaBookmark) bookmark).getValue();
            }
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private static boolean isEmptySchema(SchemaDocument.Schema schema) {
        XmlCursor xmlCursorNewCursor = schema.newCursor();
        try {
            boolean z = !xmlCursorNewCursor.toFirstChild();
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return z;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private static boolean isReservedTypeName(QName qName) {
        return BuiltinSchemaTypeSystem.get().findType(qName) != null;
    }

    private static String removeWhitespace(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (!XMLChar.isSpace(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    static SchemaTypeImpl translateAnonymousSimpleType(SimpleType simpleType, String str, boolean z, String str2, String str3, List<SchemaType> list, SchemaType schemaType) {
        StscState stscState = StscState.get();
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
        schemaTypeImpl.setSimpleType(true);
        schemaTypeImpl.setParseContext(simpleType, str, z, str2, str3, false);
        schemaTypeImpl.setOuterSchemaTypeRef(schemaType.getRef());
        schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), simpleType));
        schemaTypeImpl.setUserData(getUserData(simpleType));
        list.add(schemaTypeImpl);
        return schemaTypeImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r24v0, types: [java.util.List, java.util.List<org.apache.xmlbeans.SchemaType>] */
    /* JADX WARN: Type inference failed for: r5v19, types: [org.apache.xmlbeans.impl.schema.SchemaLocalAttributeImpl] */
    static SchemaLocalAttributeImpl translateAttribute(Attribute attribute, String str, String str2, boolean z, List<SchemaType> list, SchemaType schemaType, SchemaAttributeModel schemaAttributeModel, boolean z2) {
        SchemaGlobalAttributeImpl schemaLocalAttributeImpl;
        QName qNameForLNS;
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        LocalSimpleType localSimpleType;
        QName qName;
        SchemaType type;
        int iTranslateUseCode;
        boolean zIsFixed;
        String defaultText;
        String str3;
        boolean zEquals;
        int i2;
        String str4;
        SOAPArrayType sOAPArrayType;
        boolean z3;
        SOAPArrayType sOAPArrayType2;
        StscState stscState = StscState.get();
        String name = attribute.getName();
        QName ref = attribute.getRef();
        if (ref != null && name != null) {
            if (name.equals(ref.getLocalPart()) && uriMatch(str, ref.getNamespaceURI())) {
                stscState.warning(XmlErrorCodes.SCHEMA_ATTR$REF_OR_NAME_HAS_BOTH, new Object[]{name}, attribute.xgetRef());
            } else {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_OR_NAME_HAS_BOTH, new Object[]{name}, attribute.xgetRef());
            }
            name = null;
        }
        if (ref == null && name == null) {
            stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_OR_NAME_HAS_NEITHER, (Object[]) null, attribute);
            return null;
        }
        if (name != null && !XMLChar.isValidNCName(name)) {
            stscState.error(XmlErrorCodes.INVALID_VALUE, new Object[]{name, "name"}, attribute.xgetName());
        }
        if (z2) {
            schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
        } else {
            SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = new SchemaGlobalAttributeImpl(StscState.get().getContainer(str));
            schemaGlobalAttributeImpl.setParseContext(attribute, str, z);
            schemaLocalAttributeImpl = schemaGlobalAttributeImpl;
        }
        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl2 = schemaLocalAttributeImpl;
        if (ref != null) {
            if (attribute.getType() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_FEATURES, new Object[]{SocialConstants.PARAM_TYPE}, attribute.xgetType());
            }
            if (attribute.getSimpleType() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_FEATURES, new Object[]{"<simpleType>"}, attribute.getSimpleType());
            }
            if (attribute.getForm() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_FEATURES, new Object[]{"form"}, attribute.xgetForm());
            }
            SchemaGlobalAttributeImpl schemaGlobalAttributeImplFindGlobalAttribute = stscState.findGlobalAttribute(ref, z ? str : null, str);
            if (schemaGlobalAttributeImplFindGlobalAttribute == null) {
                stscState.notFoundError(ref, 3, attribute.xgetRef(), true);
                return null;
            }
            iTranslateUseCode = schemaGlobalAttributeImplFindGlobalAttribute.getUse();
            type = schemaGlobalAttributeImplFindGlobalAttribute.getType();
            defaultText = schemaGlobalAttributeImplFindGlobalAttribute.getDefaultText();
            if (defaultText != null) {
                zIsFixed = schemaGlobalAttributeImplFindGlobalAttribute.isFixed();
                if (zIsFixed) {
                    str3 = defaultText;
                }
                qName = ref;
            } else {
                zIsFixed = false;
            }
            str3 = null;
            qName = ref;
        } else {
            if (z2) {
                FormChoice formChoiceXgetForm = attribute.xgetForm();
                if (formChoiceXgetForm != null) {
                    zEquals = formChoiceXgetForm.getStringValue().equals(FORM_QUALIFIED);
                } else if (str2 != null) {
                    zEquals = str2.equals(FORM_QUALIFIED);
                } else {
                    FormChoice formChoiceFindAttributeFormDefault = findAttributeFormDefault(attribute);
                    zEquals = formChoiceFindAttributeFormDefault != null && formChoiceFindAttributeFormDefault.getStringValue().equals(FORM_QUALIFIED);
                }
                qNameForLNS = zEquals ? QNameHelper.forLNS(name, str) : QNameHelper.forLN(name);
            } else {
                qNameForLNS = QNameHelper.forLNS(name, str);
            }
            QName qName2 = qNameForLNS;
            if (attribute.getType() != null) {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(attribute.getType(), z ? str : null, str);
                if (schemaTypeImplFindGlobalType == null) {
                    stscState.notFoundError(attribute.getType(), 0, attribute.xgetType(), true);
                }
            } else {
                schemaTypeImplFindGlobalType = null;
            }
            if (qName2.getNamespaceURI().equals("http://www.w3.org/2001/XMLSchema-instance")) {
                stscState.error(XmlErrorCodes.NO_XSI, new Object[]{"http://www.w3.org/2001/XMLSchema-instance"}, attribute.xgetName());
            }
            if (qName2.getNamespaceURI().isEmpty() && qName2.getLocalPart().equals("xmlns")) {
                stscState.error(XmlErrorCodes.NO_XMLNS, (Object[]) null, attribute.xgetName());
            }
            LocalSimpleType simpleType = attribute.getSimpleType();
            if (schemaTypeImplFindGlobalType == null || simpleType == null) {
                localSimpleType = simpleType;
            } else {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$TYPE_ATTR_OR_NESTED_TYPE, (Object[]) null, simpleType);
                localSimpleType = null;
            }
            if (localSimpleType != null) {
                SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
                schemaTypeImpl.setContainerField(schemaGlobalAttributeImpl2);
                schemaTypeImpl.setOuterSchemaTypeRef(schemaType == null ? null : schemaType.getRef());
                list.add(schemaTypeImpl);
                schemaTypeImpl.setSimpleType(true);
                LocalSimpleType localSimpleType2 = localSimpleType;
                qName = qName2;
                schemaTypeImpl.setParseContext(localSimpleType, str, z, null, null, false);
                schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), localSimpleType2));
                schemaTypeImpl.setUserData(getUserData(localSimpleType2));
                type = schemaTypeImpl;
            } else {
                qName = qName2;
                type = schemaTypeImplFindGlobalType;
            }
            if (type == null && schemaAttributeModel != null && schemaAttributeModel.getAttribute(qName) != null) {
                type = schemaAttributeModel.getAttribute(qName).getType();
            }
            iTranslateUseCode = 2;
            zIsFixed = false;
            defaultText = null;
            str3 = null;
        }
        if (type == null) {
            type = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (!type.isSimpleType()) {
            stscState.error("Attributes must have a simple type (not complex).", 46, attribute);
            type = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (!attribute.isSetUse() || (iTranslateUseCode = translateUseCode(attribute.xgetUse())) == 2 || zIsFixed) {
            String str5 = defaultText;
            i2 = iTranslateUseCode;
            str4 = str5;
        } else {
            i2 = iTranslateUseCode;
            str4 = null;
        }
        if (attribute.isSetDefault() || attribute.isSetFixed()) {
            if (zIsFixed && !attribute.isSetFixed()) {
                stscState.error("A use of a fixed attribute definition must also be fixed", 9, attribute.xgetFixed());
            }
            boolean zIsSetFixed = attribute.isSetFixed();
            if (attribute.isSetDefault() && zIsSetFixed) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$DEFAULT_OR_FIXED, (Object[]) null, attribute.xgetFixed());
                zIsSetFixed = false;
            }
            Object fixed = zIsSetFixed ? attribute.getFixed() : attribute.getDefault();
            if (str3 == null || str3.equals(fixed)) {
                sOAPArrayType = null;
                z3 = zIsSetFixed;
                str3 = fixed;
            } else {
                sOAPArrayType = null;
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$FIXED_NOT_MATCH, (Object[]) null, attribute.xgetFixed());
                z3 = zIsSetFixed;
            }
        } else {
            z3 = zIsFixed;
            str3 = str4;
            sOAPArrayType = null;
        }
        if (!z2) {
            schemaGlobalAttributeImpl2.setFilename(findFilename(attribute));
        }
        XmlCursor xmlCursorNewCursor = attribute.newCursor();
        try {
            String attributeText = xmlCursorNewCursor.getAttributeText(WSDL_ARRAYTYPE_NAME);
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            if (attributeText != null) {
                try {
                    sOAPArrayType2 = new SOAPArrayType(attributeText, new NamespaceContext(attribute));
                } catch (XmlValueOutOfRangeException unused) {
                    stscState.error(XmlErrorCodes.SOAPARRAY, new Object[]{attributeText}, attribute);
                }
            } else {
                sOAPArrayType2 = sOAPArrayType;
            }
            schemaGlobalAttributeImpl2.init(qName, type.getRef(), i2, str3, attribute, null, z3, sOAPArrayType2, SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), attribute), getUserData(attribute));
            return schemaGlobalAttributeImpl2;
        } finally {
        }
    }

    public static SchemaAttributeGroupImpl translateAttributeGroup(AttributeGroup attributeGroup, String str, boolean z, boolean z2) {
        String name = attributeGroup.getName();
        if (name == null) {
            StscState.get().error(XmlErrorCodes.MISSING_NAME, new Object[]{"attribute group"}, attributeGroup);
            return null;
        }
        SchemaContainer container = StscState.get().getContainer(str);
        SchemaAttributeGroupImpl schemaAttributeGroupImpl = new SchemaAttributeGroupImpl(container);
        SchemaAnnotationImpl annotation = SchemaAnnotationImpl.getAnnotation(container, attributeGroup);
        FormChoice formChoiceFindAttributeFormDefault = findAttributeFormDefault(attributeGroup);
        schemaAttributeGroupImpl.init(QNameHelper.forLNS(name, str), str, z, formChoiceFindAttributeFormDefault == null ? null : formChoiceFindAttributeFormDefault.getStringValue(), z2, attributeGroup, annotation, getUserData(attributeGroup));
        schemaAttributeGroupImpl.setFilename(findFilename(attributeGroup));
        return schemaAttributeGroupImpl;
    }

    private static SchemaTypeImpl translateAttributeType(TopLevelAttribute topLevelAttribute, String str, boolean z) {
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(StscState.get().getContainer(str));
        schemaTypeImpl.setAttributeType(true);
        schemaTypeImpl.setParseContext(topLevelAttribute, str, z, null, null, false);
        schemaTypeImpl.setFilename(findFilename(topLevelAttribute));
        return schemaTypeImpl;
    }

    private static SchemaTypeImpl translateDocumentType(TopLevelElement topLevelElement, String str, boolean z) {
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(StscState.get().getContainer(str));
        schemaTypeImpl.setDocumentType(true);
        schemaTypeImpl.setParseContext(topLevelElement, str, z, null, null, false);
        schemaTypeImpl.setFilename(findFilename(topLevelElement));
        return schemaTypeImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0365 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x033e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v3, types: [org.apache.xmlbeans.SchemaField, org.apache.xmlbeans.impl.schema.SchemaLocalElementImpl, org.apache.xmlbeans.impl.schema.SchemaParticleImpl] */
    /* JADX WARN: Type inference failed for: r1v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v84 */
    /* JADX WARN: Type inference failed for: r27v0, types: [java.util.List, java.util.List<org.apache.xmlbeans.SchemaType>] */
    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object, org.apache.xmlbeans.impl.schema.SchemaTypeImpl] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SchemaLocalElementImpl translateElement(Element element, String str, boolean z, String str2, String str3, List<SchemaType> list, SchemaType schemaType) {
        SchemaTypeImpl schemaTypeImpl;
        QName qNameForLNS;
        boolean z2;
        boolean zContains;
        SchemaParticle schemaParticle;
        SchemaType type;
        boolean z3;
        Annotated annotated;
        Object obj;
        Object obj2;
        Object obj3;
        QName qName;
        int i2;
        XmlCursor xmlCursorNewCursor;
        String attributeText;
        int i3;
        SOAPArrayType sOAPArrayType;
        boolean zIsSetFixed;
        Object block;
        boolean zContains2;
        boolean zContains3;
        ?? r1;
        Keybase[] keyArray;
        int i4;
        int i5;
        Keybase[] uniqueArray;
        int i6;
        KeyrefDocument.Keyref[] keyrefArray;
        int i7;
        SchemaGlobalElementImpl schemaGlobalElementImplFindGlobalElement;
        boolean zEquals;
        StscState stscState = StscState.get();
        if (element.isSetSubstitutionGroup()) {
            SchemaTypeImpl schemaTypeImplFindDocumentType = stscState.findDocumentType(element.getSubstitutionGroup(), ((SchemaTypeImpl) schemaType).getChameleonNamespace(), str);
            if (schemaTypeImplFindDocumentType != null) {
                StscResolver.resolveType(schemaTypeImplFindDocumentType);
            }
            schemaTypeImpl = schemaTypeImplFindDocumentType;
        } else {
            schemaTypeImpl = null;
        }
        String name = element.getName();
        QName ref = element.getRef();
        if (ref != null && name != null) {
            stscState.error(XmlErrorCodes.SCHEMA_ELEM$REF_OR_NAME_HAS_BOTH, new Object[]{name}, element.xgetRef());
            name = null;
        }
        if (ref == null && name == null) {
            stscState.error(XmlErrorCodes.SCHEMA_ELEM$REF_OR_NAME_HAS_NEITHER, (Object[]) null, element);
            return null;
        }
        if (name != null && !XMLChar.isValidNCName(name)) {
            stscState.error(XmlErrorCodes.INVALID_VALUE, new Object[]{name, "name"}, element.xgetName());
        }
        if (ref != null) {
            if (element.getType() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{SocialConstants.PARAM_TYPE}, element.xgetType());
            }
            if (element.getSimpleType() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"<simpleType>"}, element.getSimpleType());
            }
            if (element.getComplexType() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"<complexType>"}, element.getComplexType());
            }
            if (element.getForm() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"form"}, element.xgetForm());
            }
            if (element.sizeOfKeyArray() > 0) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"<key>"}, element);
            }
            if (element.sizeOfKeyrefArray() > 0) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"<keyref>"}, element);
            }
            if (element.sizeOfUniqueArray() > 0) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"<unique>"}, element);
            }
            if (element.isSetDefault()) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"default"}, element.xgetDefault());
            }
            if (element.isSetFixed()) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"fixed"}, element.xgetFixed());
            }
            if (element.isSetBlock()) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"block"}, element.xgetBlock());
            }
            if (element.isSetNillable()) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"nillable"}, element.xgetNillable());
            }
            SchemaGlobalElementImpl schemaGlobalElementImplFindGlobalElement2 = stscState.findGlobalElement(ref, z ? str : null, str);
            if (schemaGlobalElementImplFindGlobalElement2 == null) {
                stscState.notFoundError(ref, 1, element.xgetRef(), true);
                return null;
            }
            SchemaLocalElementImpl schemaLocalElementImpl = new SchemaLocalElementImpl();
            schemaLocalElementImpl.setParticleType(4);
            schemaLocalElementImpl.setUserData(getUserData(element));
            copyGlobalElementToLocalElement(schemaGlobalElementImplFindGlobalElement2, schemaLocalElementImpl);
            return schemaLocalElementImpl;
        }
        if (element instanceof LocalElement) {
            SchemaParticle schemaLocalElementImpl2 = new SchemaLocalElementImpl();
            FormChoice formChoiceXgetForm = element.xgetForm();
            if (formChoiceXgetForm != null) {
                zEquals = formChoiceXgetForm.getStringValue().equals(FORM_QUALIFIED);
            } else if (str2 != null) {
                zEquals = str2.equals(FORM_QUALIFIED);
            } else {
                FormChoice formChoiceFindElementFormDefault = findElementFormDefault(element);
                zEquals = formChoiceFindElementFormDefault != null && formChoiceFindElementFormDefault.getStringValue().equals(FORM_QUALIFIED);
            }
            if (zEquals) {
                qNameForLNS = QNameHelper.forLNS(name, str);
                schemaParticle = schemaLocalElementImpl2;
            } else {
                qNameForLNS = QNameHelper.forLN(name);
                schemaParticle = schemaLocalElementImpl2;
            }
        } else {
            SchemaGlobalElementImpl schemaGlobalElementImpl = new SchemaGlobalElementImpl(stscState.getContainer(str));
            if (schemaTypeImpl != null) {
                SchemaGlobalElementImpl schemaGlobalElementImplFindGlobalElement3 = stscState.findGlobalElement(element.getSubstitutionGroup(), z ? str : null, str);
                if (schemaGlobalElementImplFindGlobalElement3 != null) {
                    schemaGlobalElementImpl.setSubstitutionGroup(schemaGlobalElementImplFindGlobalElement3.getRef());
                }
            }
            qNameForLNS = QNameHelper.forLNS(name, str);
            QName[] substitutionGroupMembers = ((SchemaTypeImpl) schemaType).getSubstitutionGroupMembers();
            QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
            qNameSetBuilder.add(qNameForLNS);
            for (QName qName2 : substitutionGroupMembers) {
                schemaGlobalElementImpl.addSubstitutionGroupMember(qName2);
                qNameSetBuilder.add(qName2);
            }
            schemaGlobalElementImpl.setTransitionRules(QNameSet.forSpecification(qNameSetBuilder), false);
            schemaGlobalElementImpl.setTransitionNotes(QNameSet.EMPTY, true);
            Object obj4 = element.getFinal();
            if (obj4 == null) {
                z2 = false;
                zContains = false;
                schemaGlobalElementImpl.setFinal(zContains, z2);
                schemaGlobalElementImpl.setAbstract(element.getAbstract());
                schemaGlobalElementImpl.setFilename(findFilename(element));
                schemaGlobalElementImpl.setParseContext(element, str, z);
                schemaParticle = schemaGlobalElementImpl;
            } else {
                if ((obj4 instanceof String) && obj4.equals("#all")) {
                    z2 = true;
                    zContains = true;
                } else if (obj4 instanceof List) {
                    List list2 = (List) obj4;
                    zContains = list2.contains("extension");
                    z2 = list2.contains("restriction");
                }
                schemaGlobalElementImpl.setFinal(zContains, z2);
                schemaGlobalElementImpl.setAbstract(element.getAbstract());
                schemaGlobalElementImpl.setFilename(findFilename(element));
                schemaGlobalElementImpl.setParseContext(element, str, z);
                schemaParticle = schemaGlobalElementImpl;
            }
        }
        QName qName3 = qNameForLNS;
        ?? r13 = schemaParticle;
        r13.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), element));
        r13.setUserData(getUserData(element));
        if (element.getType() != null) {
            type = stscState.findGlobalType(element.getType(), z ? str : null, str);
            if (type == null) {
                stscState.notFoundError(element.getType(), 0, element.xgetType(), true);
            }
        } else {
            type = null;
        }
        Annotated complexType = element.getComplexType();
        if (complexType == null) {
            complexType = element.getSimpleType();
            z3 = true;
        } else {
            z3 = false;
        }
        if (type == null || complexType == null) {
            annotated = complexType;
        } else {
            stscState.error(XmlErrorCodes.SCHEMA_ELEM$TYPE_ATTR_OR_NESTED_TYPE, (Object[]) null, complexType);
            annotated = null;
        }
        try {
            if (annotated != null) {
                SchemaComponent[] currentProcessing = stscState.getCurrentProcessing();
                int length = currentProcessing.length;
                QName[] qNameArr = new QName[length];
                int i8 = 0;
                while (i8 < length) {
                    int i9 = length;
                    if (currentProcessing[i8] instanceof SchemaModelGroupImpl) {
                        qNameArr[i8] = ((SchemaModelGroupImpl) currentProcessing[i8]).getName();
                    }
                    i8++;
                    length = i9;
                }
                type = checkRecursiveGroupReference(qNameArr, qName3, (SchemaTypeImpl) schemaType);
                if (type == null) {
                    ?? schemaTypeImpl2 = new SchemaTypeImpl(stscState.getContainer(str));
                    schemaTypeImpl2.setContainerField(r13);
                    schemaTypeImpl2.setOuterSchemaTypeRef(schemaType == null ? null : schemaType.getRef());
                    schemaTypeImpl2.setGroupReferenceContext(qNameArr);
                    list.add(schemaTypeImpl2);
                    schemaTypeImpl2.setSimpleType(z3);
                    obj = "#all";
                    obj2 = "extension";
                    obj3 = "restriction";
                    qName = qName3;
                    i2 = 4;
                    schemaTypeImpl2.setParseContext(annotated, str, z, str2, str3, false);
                    schemaTypeImpl2.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), annotated));
                    schemaTypeImpl2.setUserData(getUserData(annotated));
                    type = schemaTypeImpl2;
                    if (type == null && schemaTypeImpl != null) {
                        schemaGlobalElementImplFindGlobalElement = stscState.findGlobalElement(element.getSubstitutionGroup(), !z ? str : null, str);
                        if (schemaGlobalElementImplFindGlobalElement != null) {
                            type = schemaGlobalElementImplFindGlobalElement.getType();
                        }
                    }
                    if (type == null) {
                        type = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
                    }
                    xmlCursorNewCursor = element.newCursor();
                    attributeText = xmlCursorNewCursor.getAttributeText(WSDL_ARRAYTYPE_NAME);
                    if (xmlCursorNewCursor != null) {
                        xmlCursorNewCursor.close();
                    }
                    if (attributeText == null) {
                        try {
                            sOAPArrayType = new SOAPArrayType(attributeText, new NamespaceContext(element));
                            i3 = 0;
                        } catch (XmlValueOutOfRangeException unused) {
                            i3 = 0;
                            stscState.error(XmlErrorCodes.SOAPARRAY, new Object[]{attributeText}, element);
                        }
                        r13.setWsdlArrayType(sOAPArrayType);
                        zIsSetFixed = element.isSetFixed();
                        if (element.isSetDefault() && zIsSetFixed) {
                            stscState.error(XmlErrorCodes.SCHEMA_ELEM$DEFAULT_OR_FIXED, (Object[]) null, element.xgetFixed());
                            zIsSetFixed = i3;
                        }
                        r13.setParticleType(i2);
                        r13.setNameAndTypeRef(qName, type.getRef());
                        r13.setNillable(element.getNillable());
                        r13.setDefault(zIsSetFixed ? element.getFixed() : element.getDefault(), zIsSetFixed, element);
                        block = element.getBlock();
                        if (block == null) {
                            int i10 = i3;
                            zContains2 = i10 == true ? 1 : 0;
                            zContains3 = zContains2;
                            r1 = i10;
                        } else if ((block instanceof String) && block.equals(obj)) {
                            r1 = 1;
                            zContains2 = true;
                            zContains3 = true;
                        } else if (block instanceof List) {
                            List list3 = (List) block;
                            zContains3 = list3.contains(obj2);
                            zContains2 = list3.contains(obj3);
                            r1 = list3.contains("substitution") ? 1 : i3;
                        }
                        r13.setBlock(zContains3, zContains2, r1);
                        int iSizeOfKeyArray = element.sizeOfKeyArray() + element.sizeOfKeyrefArray() + element.sizeOfUniqueArray();
                        SchemaIdentityConstraintImpl[] schemaIdentityConstraintImplArr = new SchemaIdentityConstraintImpl[iSizeOfKeyArray];
                        keyArray = element.getKeyArray();
                        int i11 = i3;
                        i4 = i11;
                        i5 = i4;
                        while (i5 < keyArray.length) {
                            schemaIdentityConstraintImplArr[i11] = translateIdentityConstraint(keyArray[i5], str, z);
                            if (schemaIdentityConstraintImplArr[i11] != null) {
                                schemaIdentityConstraintImplArr[i11].setConstraintCategory(1);
                            } else {
                                i4 = 1;
                            }
                            i5++;
                            i11++;
                        }
                        uniqueArray = element.getUniqueArray();
                        i6 = i3;
                        while (i6 < uniqueArray.length) {
                            schemaIdentityConstraintImplArr[i11] = translateIdentityConstraint(uniqueArray[i6], str, z);
                            if (schemaIdentityConstraintImplArr[i11] != null) {
                                schemaIdentityConstraintImplArr[i11].setConstraintCategory(3);
                            } else {
                                i4 = 1;
                            }
                            i6++;
                            i11++;
                        }
                        keyrefArray = element.getKeyrefArray();
                        i7 = i3;
                        while (i7 < keyrefArray.length) {
                            schemaIdentityConstraintImplArr[i11] = translateIdentityConstraint(keyrefArray[i7], str, z);
                            if (schemaIdentityConstraintImplArr[i11] != null) {
                                schemaIdentityConstraintImplArr[i11].setConstraintCategory(2);
                            } else {
                                i4 = 1;
                            }
                            i7++;
                            i11++;
                        }
                        if (i4 == 0) {
                            SchemaIdentityConstraint.Ref[] refArr = new SchemaIdentityConstraint.Ref[iSizeOfKeyArray];
                            while (i3 < iSizeOfKeyArray) {
                                refArr[i3] = schemaIdentityConstraintImplArr[i3].getRef();
                                i3++;
                            }
                            r13.setIdentityConstraints(refArr);
                        }
                        return r13;
                    }
                    i3 = 0;
                    sOAPArrayType = null;
                    r13.setWsdlArrayType(sOAPArrayType);
                    zIsSetFixed = element.isSetFixed();
                    if (element.isSetDefault()) {
                        stscState.error(XmlErrorCodes.SCHEMA_ELEM$DEFAULT_OR_FIXED, (Object[]) null, element.xgetFixed());
                        zIsSetFixed = i3;
                    }
                    r13.setParticleType(i2);
                    r13.setNameAndTypeRef(qName, type.getRef());
                    r13.setNillable(element.getNillable());
                    r13.setDefault(zIsSetFixed ? element.getFixed() : element.getDefault(), zIsSetFixed, element);
                    block = element.getBlock();
                    if (block == null) {
                    }
                    r13.setBlock(zContains3, zContains2, r1);
                    int iSizeOfKeyArray2 = element.sizeOfKeyArray() + element.sizeOfKeyrefArray() + element.sizeOfUniqueArray();
                    SchemaIdentityConstraintImpl[] schemaIdentityConstraintImplArr2 = new SchemaIdentityConstraintImpl[iSizeOfKeyArray2];
                    keyArray = element.getKeyArray();
                    int i112 = i3;
                    i4 = i112;
                    i5 = i4;
                    while (i5 < keyArray.length) {
                    }
                    uniqueArray = element.getUniqueArray();
                    i6 = i3;
                    while (i6 < uniqueArray.length) {
                    }
                    keyrefArray = element.getKeyrefArray();
                    i7 = i3;
                    while (i7 < keyrefArray.length) {
                    }
                    if (i4 == 0) {
                    }
                    return r13;
                }
                obj2 = "extension";
                obj3 = "restriction";
                obj = "#all";
            } else {
                obj = "#all";
                obj2 = "extension";
                obj3 = "restriction";
            }
            attributeText = xmlCursorNewCursor.getAttributeText(WSDL_ARRAYTYPE_NAME);
            if (xmlCursorNewCursor != null) {
            }
            if (attributeText == null) {
            }
            sOAPArrayType = null;
            r13.setWsdlArrayType(sOAPArrayType);
            zIsSetFixed = element.isSetFixed();
            if (element.isSetDefault()) {
            }
            r13.setParticleType(i2);
            r13.setNameAndTypeRef(qName, type.getRef());
            r13.setNillable(element.getNillable());
            r13.setDefault(zIsSetFixed ? element.getFixed() : element.getDefault(), zIsSetFixed, element);
            block = element.getBlock();
            if (block == null) {
            }
            r13.setBlock(zContains3, zContains2, r1);
            int iSizeOfKeyArray22 = element.sizeOfKeyArray() + element.sizeOfKeyrefArray() + element.sizeOfUniqueArray();
            SchemaIdentityConstraintImpl[] schemaIdentityConstraintImplArr22 = new SchemaIdentityConstraintImpl[iSizeOfKeyArray22];
            keyArray = element.getKeyArray();
            int i1122 = i3;
            i4 = i1122;
            i5 = i4;
            while (i5 < keyArray.length) {
            }
            uniqueArray = element.getUniqueArray();
            i6 = i3;
            while (i6 < uniqueArray.length) {
            }
            keyrefArray = element.getKeyrefArray();
            i7 = i3;
            while (i7 < keyrefArray.length) {
            }
            if (i4 == 0) {
            }
            return r13;
        } finally {
        }
        qName = qName3;
        i2 = 4;
        if (type == null) {
            schemaGlobalElementImplFindGlobalElement = stscState.findGlobalElement(element.getSubstitutionGroup(), !z ? str : null, str);
            if (schemaGlobalElementImplFindGlobalElement != null) {
            }
        }
        if (type == null) {
        }
        xmlCursorNewCursor = element.newCursor();
    }

    private static SchemaTypeImpl translateGlobalComplexType(TopLevelComplexType topLevelComplexType, String str, boolean z, boolean z2) {
        StscState stscState = StscState.get();
        String name = topLevelComplexType.getName();
        if (name == null) {
            stscState.error(XmlErrorCodes.MISSING_NAME, new Object[]{"global type"}, topLevelComplexType);
            return null;
        }
        if (!XMLChar.isValidNCName(name)) {
            stscState.error(XmlErrorCodes.INVALID_VALUE, new Object[]{name, "name"}, topLevelComplexType.xgetName());
        }
        QName qNameForLNS = QNameHelper.forLNS(name, str);
        if (isReservedTypeName(qNameForLNS)) {
            stscState.warning(XmlErrorCodes.RESERVED_TYPE_NAME, new Object[]{QNameHelper.pretty(qNameForLNS)}, topLevelComplexType);
            return null;
        }
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
        schemaTypeImpl.setParseContext(topLevelComplexType, str, z, null, null, z2);
        schemaTypeImpl.setFilename(findFilename(topLevelComplexType));
        schemaTypeImpl.setName(QNameHelper.forLNS(name, str));
        schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), topLevelComplexType));
        schemaTypeImpl.setUserData(getUserData(topLevelComplexType));
        return schemaTypeImpl;
    }

    private static SchemaTypeImpl translateGlobalSimpleType(TopLevelSimpleType topLevelSimpleType, String str, boolean z, boolean z2) {
        StscState stscState = StscState.get();
        String name = topLevelSimpleType.getName();
        if (name == null) {
            stscState.error(XmlErrorCodes.MISSING_NAME, new Object[]{"global type"}, topLevelSimpleType);
            return null;
        }
        if (!XMLChar.isValidNCName(name)) {
            stscState.error(XmlErrorCodes.INVALID_VALUE, new Object[]{name, "name"}, topLevelSimpleType.xgetName());
        }
        QName qNameForLNS = QNameHelper.forLNS(name, str);
        if (isReservedTypeName(qNameForLNS)) {
            stscState.warning(XmlErrorCodes.RESERVED_TYPE_NAME, new Object[]{QNameHelper.pretty(qNameForLNS)}, topLevelSimpleType);
            return null;
        }
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
        schemaTypeImpl.setSimpleType(true);
        schemaTypeImpl.setParseContext(topLevelSimpleType, str, z, null, null, z2);
        schemaTypeImpl.setFilename(findFilename(topLevelSimpleType));
        schemaTypeImpl.setName(qNameForLNS);
        schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), topLevelSimpleType));
        schemaTypeImpl.setUserData(getUserData(topLevelSimpleType));
        return schemaTypeImpl;
    }

    private static SchemaIdentityConstraintImpl translateIdentityConstraint(Keybase keybase, String str, boolean z) {
        StscState stscState = StscState.get();
        String xpath = keybase.getSelector() == null ? null : keybase.getSelector().getXpath();
        if (!checkXPathSyntax(xpath)) {
            stscState.error(XmlErrorCodes.SELECTOR_XPATH, new Object[]{xpath}, keybase.getSelector().xgetXpath());
            return null;
        }
        FieldDocument.Field[] fieldArray = keybase.getFieldArray();
        for (FieldDocument.Field field : fieldArray) {
            if (!checkXPathSyntax(field.getXpath())) {
                stscState.error(XmlErrorCodes.FIELDS_XPATH, new Object[]{field.getXpath()}, field.xgetXpath());
                return null;
            }
        }
        SchemaIdentityConstraintImpl schemaIdentityConstraintImpl = new SchemaIdentityConstraintImpl(stscState.getContainer(str));
        schemaIdentityConstraintImpl.setName(QNameHelper.forLNS(keybase.getName(), str));
        schemaIdentityConstraintImpl.setSelector(keybase.getSelector().getXpath());
        schemaIdentityConstraintImpl.setParseContext(keybase, str, z);
        schemaIdentityConstraintImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), keybase));
        schemaIdentityConstraintImpl.setUserData(getUserData(keybase));
        HashMap map = new HashMap();
        XmlCursor xmlCursorNewCursor = keybase.newCursor();
        try {
            xmlCursorNewCursor.getAllNamespaces(map);
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            map.remove("");
            schemaIdentityConstraintImpl.setNSMap(map);
            int length = fieldArray.length;
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = fieldArray[i2].getXpath();
            }
            schemaIdentityConstraintImpl.setFields(strArr);
            try {
                schemaIdentityConstraintImpl.buildPaths();
                stscState.addIdConstraint(schemaIdentityConstraintImpl);
                schemaIdentityConstraintImpl.setFilename(findFilename(keybase));
                return stscState.findIdConstraint(schemaIdentityConstraintImpl.getName(), str, null);
            } catch (XPath.XPathCompileException e) {
                stscState.error(XmlErrorCodes.INVALID_XPATH, new Object[]{e.getMessage()}, keybase);
                return null;
            }
        } finally {
        }
    }

    public static SchemaModelGroupImpl translateModelGroup(NamedGroup namedGroup, String str, boolean z, boolean z2) {
        String name = namedGroup.getName();
        if (name == null) {
            StscState.get().error(XmlErrorCodes.MISSING_NAME, new Object[]{"model group"}, namedGroup);
            return null;
        }
        SchemaContainer container = StscState.get().getContainer(str);
        SchemaModelGroupImpl schemaModelGroupImpl = new SchemaModelGroupImpl(container);
        SchemaAnnotationImpl annotation = SchemaAnnotationImpl.getAnnotation(container, namedGroup);
        FormChoice formChoiceFindElementFormDefault = findElementFormDefault(namedGroup);
        FormChoice formChoiceFindAttributeFormDefault = findAttributeFormDefault(namedGroup);
        schemaModelGroupImpl.init(QNameHelper.forLNS(name, str), str, z, formChoiceFindElementFormDefault == null ? null : formChoiceFindElementFormDefault.getStringValue(), formChoiceFindAttributeFormDefault == null ? null : formChoiceFindAttributeFormDefault.getStringValue(), z2, namedGroup, annotation, getUserData(namedGroup));
        schemaModelGroupImpl.setFilename(findFilename(namedGroup));
        return schemaModelGroupImpl;
    }

    static int translateUseCode(Attribute.Use use) {
        if (use == null) {
            return 2;
        }
        String stringValue = use.getStringValue();
        if (stringValue.equals("optional")) {
            return 2;
        }
        if (stringValue.equals("required")) {
            return 3;
        }
        return stringValue.equals("prohibited") ? 1 : 2;
    }

    public static boolean uriMatch(String str, String str2) {
        return str == null ? str2 == null || str2.equals("") : str2 == null ? str.equals("") : str.equals(str2);
    }
}
