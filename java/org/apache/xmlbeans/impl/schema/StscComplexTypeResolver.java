package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.QNameSetSpecification;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.schema.StscComplexTypeResolver;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexRestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.Group;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
import org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;

/* loaded from: classes.dex */
public class StscComplexTypeResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ANY_ATTRIBUTE_CODE = 102;
    private static final int ATTRIBUTE_CODE = 100;
    private static final int ATTRIBUTE_GROUP_CODE = 101;
    private static final int MODEL_GROUP_CODE = 100;
    private static final Map<QName, Integer> attributeCodeMap;
    private static final CodeForNameEntry[] attributeCodes;
    private static final Map<QName, Integer> particleCodeMap;
    private static final CodeForNameEntry[] particleCodes;

    /* JADX INFO: Access modifiers changed from: private */
    static class CodeForNameEntry {
        public int code;
        public QName name;

        CodeForNameEntry(QName qName, int i2) {
            this.name = qName;
            this.code = i2;
        }
    }

    private static class RedefinitionForGroup {
        private final SchemaModelGroupImpl group;
        private boolean seenRedefinition = false;

        public RedefinitionForGroup(SchemaModelGroupImpl schemaModelGroupImpl) {
            this.group = schemaModelGroupImpl;
        }

        public SchemaModelGroupImpl getGroup() {
            return this.group;
        }

        public boolean isSeenRedefinition() {
            return this.seenRedefinition;
        }

        public void setSeenRedefinition(boolean z) {
            this.seenRedefinition = z;
        }
    }

    static class WildcardResult {
        boolean hasWildcards;
        QNameSet typedWildcards;

        WildcardResult(QNameSet qNameSet, boolean z) {
            this.typedWildcards = qNameSet;
            this.hasWildcards = z;
        }
    }

    static {
        CodeForNameEntry[] codeForNameEntryArr = {new CodeForNameEntry(QNameHelper.forLNS("all", "http://www.w3.org/2001/XMLSchema"), 1), new CodeForNameEntry(QNameHelper.forLNS("sequence", "http://www.w3.org/2001/XMLSchema"), 3), new CodeForNameEntry(QNameHelper.forLNS("choice", "http://www.w3.org/2001/XMLSchema"), 2), new CodeForNameEntry(QNameHelper.forLNS("element", "http://www.w3.org/2001/XMLSchema"), 4), new CodeForNameEntry(QNameHelper.forLNS("any", "http://www.w3.org/2001/XMLSchema"), 5), new CodeForNameEntry(QNameHelper.forLNS("group", "http://www.w3.org/2001/XMLSchema"), 100)};
        particleCodes = codeForNameEntryArr;
        particleCodeMap = Collections.unmodifiableMap((Map) Stream.of((Object[]) codeForNameEntryArr).collect(Collectors.toMap(new Function() { // from class: org.apache.xmlbeans.impl.schema.w0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((StscComplexTypeResolver.CodeForNameEntry) obj).name;
            }
        }, new Function() { // from class: org.apache.xmlbeans.impl.schema.y0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((StscComplexTypeResolver.CodeForNameEntry) obj).code);
            }
        })));
        CodeForNameEntry[] codeForNameEntryArr2 = {new CodeForNameEntry(QNameHelper.forLNS("attribute", "http://www.w3.org/2001/XMLSchema"), 100), new CodeForNameEntry(QNameHelper.forLNS("attributeGroup", "http://www.w3.org/2001/XMLSchema"), 101), new CodeForNameEntry(QNameHelper.forLNS("anyAttribute", "http://www.w3.org/2001/XMLSchema"), 102)};
        attributeCodes = codeForNameEntryArr2;
        attributeCodeMap = Collections.unmodifiableMap((Map) Stream.of((Object[]) codeForNameEntryArr2).collect(Collectors.toMap(new Function() { // from class: org.apache.xmlbeans.impl.schema.a1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((StscComplexTypeResolver.CodeForNameEntry) obj).name;
            }
        }, new Function() { // from class: org.apache.xmlbeans.impl.schema.x0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((StscComplexTypeResolver.CodeForNameEntry) obj).code);
            }
        })));
    }

    static void addMinusPointlessParticles(List<SchemaParticle> list, SchemaParticle schemaParticle, int i2) {
        if (schemaParticle == null) {
            return;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType != 2) {
            if (particleType == 3 && i2 == 3 && schemaParticle.isSingleton()) {
                list.addAll(Arrays.asList(schemaParticle.getParticleChildren()));
                return;
            }
        } else if (i2 == 2 && schemaParticle.isSingleton()) {
            list.addAll(Arrays.asList(schemaParticle.getParticleChildren()));
            return;
        }
        list.add(schemaParticle);
    }

    private static boolean afterMapSubsumedByStartMap(Map<SchemaParticle, QNameSet> map, Map<SchemaParticle, QNameSet> map2) {
        if (map2.size() > map.size()) {
            return false;
        }
        if (map2.isEmpty()) {
            return true;
        }
        for (SchemaParticle schemaParticle : map.keySet()) {
            if (schemaParticle.getParticleType() == 5 && map2.containsKey(schemaParticle) && !map.get(schemaParticle).containsAll(map2.get(schemaParticle))) {
                return false;
            }
            map2.remove(schemaParticle);
            if (map2.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean b(SchemaProperty schemaProperty) {
        return !schemaProperty.isAttribute();
    }

    static Map<QName, SchemaProperty> buildAttributePropertyModelByQName(SchemaAttributeModel schemaAttributeModel, final SchemaType schemaType) {
        return (Map) Stream.of((Object[]) schemaAttributeModel.getAttributes()).collect(Collectors.toMap(new Function() { // from class: org.apache.xmlbeans.impl.schema.v
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((SchemaLocalAttribute) obj).getName();
            }
        }, new Function() { // from class: org.apache.xmlbeans.impl.schema.u0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return StscComplexTypeResolver.buildUseProperty((SchemaLocalAttribute) obj, schemaType);
            }
        }, throwingMerger(), x.a));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static Map<QName, SchemaProperty> buildContentPropertyModelByQName(SchemaParticle schemaParticle, SchemaType schemaType) {
        Map<QName, SchemaProperty> linkedHashMap;
        if (schemaParticle == null) {
            return Collections.emptyMap();
        }
        int particleType = schemaParticle.getParticleType();
        boolean z = true;
        if (particleType == 1) {
            linkedHashMap = null;
        } else {
            if (particleType != 2) {
                if (particleType != 3) {
                    if (particleType == 4) {
                        linkedHashMap = buildElementPropertyModel((SchemaLocalElement) schemaParticle, schemaType);
                    } else {
                        if (particleType != 5) {
                            throw new IllegalStateException();
                        }
                        linkedHashMap = Collections.emptyMap();
                    }
                }
                linkedHashMap = null;
            } else {
                linkedHashMap = null;
            }
            z = false;
        }
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
                for (SchemaProperty schemaProperty : buildContentPropertyModelByQName(schemaParticle2, schemaType).values()) {
                    SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) linkedHashMap.get(schemaProperty.getName());
                    if (schemaPropertyImpl == null) {
                        if (!z) {
                            ((SchemaPropertyImpl) schemaProperty).setMinOccurs(BigInteger.ZERO);
                        }
                        linkedHashMap.put(schemaProperty.getName(), schemaProperty);
                    } else {
                        mergeProperties(schemaPropertyImpl, schemaProperty, z);
                    }
                }
            }
            BigInteger minOccurs = schemaParticle.getMinOccurs();
            BigInteger maxOccurs = schemaParticle.getMaxOccurs();
            for (SchemaProperty schemaProperty2 : linkedHashMap.values()) {
                BigInteger minOccurs2 = schemaProperty2.getMinOccurs();
                BigInteger maxOccurs2 = schemaProperty2.getMaxOccurs();
                BigInteger bigIntegerMultiply = minOccurs2.multiply(minOccurs);
                if (maxOccurs != null) {
                    BigInteger bigInteger = BigInteger.ZERO;
                    if (maxOccurs.equals(bigInteger)) {
                        maxOccurs2 = bigInteger;
                    } else if (maxOccurs2 != null && !maxOccurs2.equals(BigInteger.ZERO)) {
                        maxOccurs2 = maxOccurs == null ? null : maxOccurs2.multiply(maxOccurs);
                    }
                }
                SchemaPropertyImpl schemaPropertyImpl2 = (SchemaPropertyImpl) schemaProperty2;
                schemaPropertyImpl2.setMinOccurs(bigIntegerMultiply);
                schemaPropertyImpl2.setMaxOccurs(maxOccurs2);
            }
        }
        return linkedHashMap;
    }

    static Map<QName, SchemaProperty> buildElementPropertyModel(SchemaLocalElement schemaLocalElement, SchemaType schemaType) {
        SchemaProperty schemaPropertyBuildUseProperty = buildUseProperty(schemaLocalElement, schemaType);
        return Collections.singletonMap(schemaPropertyBuildUseProperty.getName(), schemaPropertyBuildUseProperty);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void buildStateMachine(SchemaParticle schemaParticle) {
        boolean z;
        boolean zAfterMapSubsumedByStartMap;
        boolean z2;
        boolean z3;
        if (schemaParticle == null) {
            return;
        }
        SchemaParticleImpl schemaParticleImpl = (SchemaParticleImpl) schemaParticle;
        if (schemaParticleImpl.hasTransitionNotes()) {
            return;
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder();
        boolean z4 = schemaParticleImpl.getMinOccurs().signum() == 0;
        int particleType = schemaParticleImpl.getParticleType();
        if (particleType == 1) {
            SchemaParticle[] schemaParticleArrEnsureStateMachine = ensureStateMachine(schemaParticleImpl.getParticleChildren());
            int length = schemaParticleArrEnsureStateMachine.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                } else {
                    if (!schemaParticleArrEnsureStateMachine[i2].isSkippable()) {
                        z = false;
                        break;
                    }
                    i2++;
                }
            }
            int length2 = schemaParticleArrEnsureStateMachine.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    zAfterMapSubsumedByStartMap = true;
                    break;
                } else {
                    if (!((SchemaParticleImpl) schemaParticleArrEnsureStateMachine[i3]).isDeterministic()) {
                        zAfterMapSubsumedByStartMap = false;
                        break;
                    }
                    i3++;
                }
            }
            for (SchemaParticle schemaParticle2 : schemaParticleArrEnsureStateMachine) {
                if (zAfterMapSubsumedByStartMap && !qNameSetBuilder.isDisjoint(schemaParticle2.acceptedStartNames())) {
                    zAfterMapSubsumedByStartMap = false;
                }
                qNameSetBuilder.addAll(schemaParticle2.acceptedStartNames());
                qNameSetBuilder2.addAll(((SchemaParticleImpl) schemaParticle2).getExcludeNextSet());
            }
            if (z) {
                qNameSetBuilder2.addAll(qNameSetBuilder);
            }
        } else if (particleType == 2) {
            SchemaParticle[] schemaParticleArrEnsureStateMachine2 = ensureStateMachine(schemaParticleImpl.getParticleChildren());
            int length3 = schemaParticleArrEnsureStateMachine2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length3) {
                    z = false;
                    break;
                } else {
                    if (schemaParticleArrEnsureStateMachine2[i4].isSkippable()) {
                        z = true;
                        break;
                    }
                    i4++;
                }
            }
            int length4 = schemaParticleArrEnsureStateMachine2.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length4) {
                    zAfterMapSubsumedByStartMap = true;
                    break;
                } else {
                    if (!((SchemaParticleImpl) schemaParticleArrEnsureStateMachine2[i5]).isDeterministic()) {
                        zAfterMapSubsumedByStartMap = false;
                        break;
                    }
                    i5++;
                }
            }
            for (SchemaParticle schemaParticle3 : schemaParticleArrEnsureStateMachine2) {
                if (zAfterMapSubsumedByStartMap && !qNameSetBuilder.isDisjoint(schemaParticle3.acceptedStartNames())) {
                    zAfterMapSubsumedByStartMap = false;
                }
                qNameSetBuilder.addAll(schemaParticle3.acceptedStartNames());
                qNameSetBuilder2.addAll(((SchemaParticleImpl) schemaParticle3).getExcludeNextSet());
            }
        } else {
            if (particleType != 3) {
                if (particleType != 4) {
                    if (particleType != 5) {
                        throw new IllegalStateException("Unrecognized schema particle");
                    }
                    qNameSetBuilder.addAll(schemaParticleImpl.getWildcardSet());
                } else if (schemaParticleImpl.hasTransitionRules()) {
                    qNameSetBuilder.addAll(schemaParticleImpl.acceptedStartNames());
                } else {
                    qNameSetBuilder.add(schemaParticleImpl.getName());
                }
                zAfterMapSubsumedByStartMap = true;
                BigInteger minOccurs = schemaParticleImpl.getMinOccurs();
                BigInteger maxOccurs = schemaParticleImpl.getMaxOccurs();
                z2 = maxOccurs != null || maxOccurs.compareTo(BigInteger.ONE) > 0;
                z3 = maxOccurs != null || minOccurs.compareTo(maxOccurs) < 0;
                if (z2 && zAfterMapSubsumedByStartMap && !qNameSetBuilder2.isDisjoint(qNameSetBuilder)) {
                    QNameSet qNameSetIntersect = qNameSetBuilder2.intersect(qNameSetBuilder);
                    HashMap map = new HashMap();
                    particlesMatchingStart(schemaParticleImpl, qNameSetIntersect, map, new QNameSetBuilder());
                    HashMap map2 = new HashMap();
                    particlesMatchingAfter(schemaParticleImpl, qNameSetIntersect, map2, new QNameSetBuilder(), true);
                    zAfterMapSubsumedByStartMap = afterMapSubsumedByStartMap(map, map2);
                }
                if (z3) {
                    qNameSetBuilder2.addAll(qNameSetBuilder);
                }
                schemaParticleImpl.setTransitionRules(qNameSetBuilder.toQNameSet(), !z4 || minOccurs.signum() == 0);
                schemaParticleImpl.setTransitionNotes(qNameSetBuilder2.toQNameSet(), zAfterMapSubsumedByStartMap);
            }
            SchemaParticle[] schemaParticleArrEnsureStateMachine3 = ensureStateMachine(schemaParticleImpl.getParticleChildren());
            z = true;
            for (int i6 = 0; z && i6 < schemaParticleArrEnsureStateMachine3.length; i6++) {
                if (!schemaParticleArrEnsureStateMachine3[i6].isSkippable()) {
                    z = false;
                }
            }
            int length5 = schemaParticleArrEnsureStateMachine3.length;
            int i7 = 0;
            while (true) {
                if (i7 >= length5) {
                    zAfterMapSubsumedByStartMap = true;
                    break;
                } else {
                    if (!((SchemaParticleImpl) schemaParticleArrEnsureStateMachine3[i7]).isDeterministic()) {
                        zAfterMapSubsumedByStartMap = false;
                        break;
                    }
                    i7++;
                }
            }
            for (int i8 = 1; i8 < schemaParticleArrEnsureStateMachine3.length; i8++) {
                qNameSetBuilder2.addAll(((SchemaParticleImpl) schemaParticleArrEnsureStateMachine3[i8 - 1]).getExcludeNextSet());
                if (zAfterMapSubsumedByStartMap && !qNameSetBuilder2.isDisjoint(schemaParticleArrEnsureStateMachine3[i8].acceptedStartNames())) {
                    zAfterMapSubsumedByStartMap = false;
                }
                if (schemaParticleArrEnsureStateMachine3[i8].isSkippable()) {
                    qNameSetBuilder2.addAll(schemaParticleArrEnsureStateMachine3[i8].acceptedStartNames());
                } else {
                    qNameSetBuilder2.clear();
                }
            }
            for (SchemaParticle schemaParticle4 : schemaParticleArrEnsureStateMachine3) {
                qNameSetBuilder.addAll(schemaParticle4.acceptedStartNames());
                if (!schemaParticle4.isSkippable()) {
                    break;
                }
            }
        }
        z4 = z;
        BigInteger minOccurs2 = schemaParticleImpl.getMinOccurs();
        BigInteger maxOccurs2 = schemaParticleImpl.getMaxOccurs();
        if (maxOccurs2 != null) {
        }
        if (maxOccurs2 != null) {
        }
        if (z2) {
            QNameSet qNameSetIntersect2 = qNameSetBuilder2.intersect(qNameSetBuilder);
            HashMap map3 = new HashMap();
            particlesMatchingStart(schemaParticleImpl, qNameSetIntersect2, map3, new QNameSetBuilder());
            HashMap map22 = new HashMap();
            particlesMatchingAfter(schemaParticleImpl, qNameSetIntersect2, map22, new QNameSetBuilder(), true);
            zAfterMapSubsumedByStartMap = afterMapSubsumedByStartMap(map3, map22);
        }
        if (z3) {
        }
        schemaParticleImpl.setTransitionRules(qNameSetBuilder.toQNameSet(), !z4 || minOccurs2.signum() == 0);
        schemaParticleImpl.setTransitionNotes(qNameSetBuilder2.toQNameSet(), zAfterMapSubsumedByStartMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SchemaProperty buildUseProperty(SchemaField schemaField, SchemaType schemaType) {
        SchemaPropertyImpl schemaPropertyImpl = new SchemaPropertyImpl();
        schemaPropertyImpl.setName(schemaField.getName());
        schemaPropertyImpl.setContainerTypeRef(schemaType.getRef());
        schemaPropertyImpl.setTypeRef(schemaField.getType().getRef());
        schemaPropertyImpl.setAttribute(schemaField.isAttribute());
        schemaPropertyImpl.setDefault(schemaField.isDefault() ? 2 : 0);
        schemaPropertyImpl.setFixed(schemaField.isFixed() ? 2 : 0);
        schemaPropertyImpl.setNillable(schemaField.isNillable() ? 2 : 0);
        schemaPropertyImpl.setDefaultText(schemaField.getDefaultText());
        schemaPropertyImpl.setMinOccurs(schemaField.getMinOccurs());
        schemaPropertyImpl.setMaxOccurs(schemaField.getMaxOccurs());
        if (schemaField instanceof SchemaParticle) {
            schemaPropertyImpl.setDocumentation(((SchemaParticle) schemaField).getDocumentation());
        }
        if (schemaField instanceof SchemaLocalElementImpl) {
            schemaPropertyImpl.setAcceptedNames(((SchemaLocalElementImpl) schemaField).acceptedStartNames());
        }
        return schemaPropertyImpl;
    }

    static /* synthetic */ SchemaType.Ref[] c(int i2) {
        return new SchemaType.Ref[i2];
    }

    static SchemaParticle[] ensureStateMachine(SchemaParticle[] schemaParticleArr) {
        for (SchemaParticle schemaParticle : schemaParticleArr) {
            buildStateMachine(schemaParticle);
        }
        return schemaParticleArr;
    }

    static SchemaParticle extendContentModel(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, XmlObject xmlObject) {
        if (schemaParticle2 == null) {
            return schemaParticle;
        }
        if (schemaParticle == null) {
            return schemaParticle2;
        }
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(3);
        ArrayList arrayList = new ArrayList();
        addMinusPointlessParticles(arrayList, schemaParticle, 3);
        addMinusPointlessParticles(arrayList, schemaParticle2, 3);
        BigInteger bigInteger = BigInteger.ONE;
        schemaParticleImpl.setMinOccurs(bigInteger);
        schemaParticleImpl.setMaxOccurs(bigInteger);
        schemaParticleImpl.setParticleChildren((SchemaParticle[]) arrayList.toArray(new SchemaParticle[0]));
        return filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl, xmlObject);
    }

    static Map<QName, SchemaType> extractElementModel(SchemaType schemaType) {
        return schemaType == null ? new HashMap() : (Map) Stream.of((Object[]) schemaType.getProperties()).filter(new Predicate() { // from class: org.apache.xmlbeans.impl.schema.b1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return StscComplexTypeResolver.b((SchemaProperty) obj);
            }
        }).collect(Collectors.toMap(new Function() { // from class: org.apache.xmlbeans.impl.schema.r2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((SchemaProperty) obj).getName();
            }
        }, new Function() { // from class: org.apache.xmlbeans.impl.schema.b2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((SchemaProperty) obj).getType();
            }
        }));
    }

    static BigInteger extractMaxOccurs(AllNNI allNNI) {
        if (allNNI == null) {
            return BigInteger.ONE;
        }
        if (allNNI.instanceType().getPrimitiveType().getBuiltinTypeCode() == 11) {
            return ((XmlInteger) allNNI).getBigIntegerValue();
        }
        return null;
    }

    static BigInteger extractMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger) {
        if (xmlNonNegativeInteger == null) {
            return BigInteger.ONE;
        }
        BigInteger bigIntegerValue = xmlNonNegativeInteger.getBigIntegerValue();
        return bigIntegerValue == null ? BigInteger.ONE : bigIntegerValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static SchemaParticle filterPointlessParticlesAndVerifyAllParticles(SchemaParticle schemaParticle, XmlObject xmlObject) {
        if (schemaParticle.getMaxOccurs() != null && schemaParticle.getMaxOccurs().signum() == 0) {
            return null;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1) {
            if (schemaParticle.getParticleChildren().length != 0) {
                return null;
            }
            if (schemaParticle.isSingleton() && schemaParticle.countOfParticleChild() == 1) {
                return schemaParticle.getParticleChild(0);
            }
        } else if (particleType != 2) {
            if (particleType != 3) {
                if (particleType == 4 || particleType == 5) {
                    return schemaParticle;
                }
                throw new IllegalStateException();
            }
            if (schemaParticle.getParticleChildren().length != 0) {
            }
        } else {
            if (schemaParticle.getParticleChildren().length == 0 && schemaParticle.getMinOccurs().compareTo(BigInteger.ZERO) == 0) {
                return null;
            }
            if (schemaParticle.isSingleton() && schemaParticle.countOfParticleChild() == 1) {
                return schemaParticle.getParticleChild(0);
            }
        }
        boolean z = schemaParticle.getParticleType() == 1;
        if (z && (schemaParticle.getMaxOccurs() == null || schemaParticle.getMaxOccurs().compareTo(BigInteger.ONE) > 0)) {
            StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$IN_MIN_MAX_1_PARTICLE, (Object[]) null, xmlObject);
        }
        for (int i2 = 0; i2 < schemaParticle.countOfParticleChild(); i2++) {
            SchemaParticle particleChild = schemaParticle.getParticleChild(i2);
            if (particleChild.getParticleType() == 1) {
                StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$IN_COMPLEX_TYPE_DEF_PARTICLE, (Object[]) null, xmlObject);
            } else if (z && (particleChild.getParticleType() != 4 || particleChild.getMaxOccurs() == null || particleChild.getMaxOccurs().compareTo(BigInteger.ONE) > 0)) {
                StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$CHILD_PARTICLES_MAX_LTE_1, (Object[]) null, xmlObject);
            }
        }
        return schemaParticle;
    }

    public static Group getContentModel(final ComplexType complexType) {
        complexType.getClass();
        complexType.getClass();
        complexType.getClass();
        complexType.getClass();
        return getContentModel((Supplier<? extends Group>[]) new Supplier[]{new Supplier() { // from class: org.apache.xmlbeans.impl.schema.e
            @Override // java.util.function.Supplier
            public final Object get() {
                return complexType.getAll();
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.i2
            @Override // java.util.function.Supplier
            public final Object get() {
                return complexType.getSequence();
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.o2
            @Override // java.util.function.Supplier
            public final Object get() {
                return complexType.getChoice();
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.v1
            @Override // java.util.function.Supplier
            public final Object get() {
                return complexType.getGroup();
            }
        }});
    }

    static SchemaDocument.Schema getSchema(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        while (xmlCursorNewCursor.toParent()) {
            try {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object.schemaType().equals(SchemaDocument.Schema.type)) {
                    SchemaDocument.Schema schema = (SchemaDocument.Schema) object;
                    if (xmlCursorNewCursor != null) {
                        xmlCursorNewCursor.close();
                    }
                    return schema;
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
        if (xmlCursorNewCursor == null) {
            return null;
        }
        xmlCursorNewCursor.close();
        return null;
    }

    static /* synthetic */ Object h(Object obj, Object obj2) {
        throw new IllegalStateException("Duplicate key " + obj.toString());
    }

    private static SchemaType.Ref[] makeRefArray(Collection<SchemaType> collection) {
        return (SchemaType.Ref[]) collection.stream().map(m2.a).toArray(new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.v0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return StscComplexTypeResolver.c(i2);
            }
        });
    }

    static void mergeProperties(SchemaPropertyImpl schemaPropertyImpl, SchemaProperty schemaProperty, boolean z) {
        BigInteger bigIntegerMin;
        BigInteger bigIntegerMax;
        BigInteger minOccurs = schemaPropertyImpl.getMinOccurs();
        BigInteger maxOccurs = schemaPropertyImpl.getMaxOccurs();
        if (z) {
            bigIntegerMin = minOccurs.add(schemaProperty.getMinOccurs());
            if (maxOccurs != null) {
                if (schemaProperty.getMaxOccurs() != null) {
                    bigIntegerMax = maxOccurs.add(schemaProperty.getMaxOccurs());
                    maxOccurs = bigIntegerMax;
                }
                maxOccurs = null;
            }
        } else {
            bigIntegerMin = minOccurs.min(schemaProperty.getMinOccurs());
            if (maxOccurs != null) {
                if (schemaProperty.getMaxOccurs() != null) {
                    bigIntegerMax = maxOccurs.max(schemaProperty.getMaxOccurs());
                    maxOccurs = bigIntegerMax;
                }
                maxOccurs = null;
            }
        }
        schemaPropertyImpl.setMinOccurs(bigIntegerMin);
        schemaPropertyImpl.setMaxOccurs(maxOccurs);
        if (schemaProperty.hasNillable() != schemaPropertyImpl.hasNillable()) {
            schemaPropertyImpl.setNillable(1);
        }
        if (schemaProperty.hasDefault() != schemaPropertyImpl.hasDefault()) {
            schemaPropertyImpl.setDefault(1);
        }
        if (schemaProperty.hasFixed() != schemaPropertyImpl.hasFixed()) {
            schemaPropertyImpl.setFixed(1);
        }
        if (schemaPropertyImpl.getDefaultText() != null) {
            if (schemaProperty.getDefaultText() == null || !schemaPropertyImpl.getDefaultText().equals(schemaProperty.getDefaultText())) {
                schemaPropertyImpl.setDefaultText(null);
            }
        }
    }

    private static void particlesMatchingAfter(SchemaParticle schemaParticle, QNameSetSpecification qNameSetSpecification, Map<SchemaParticle, QNameSet> map, QNameSetBuilder qNameSetBuilder, boolean z) {
        int particleType = schemaParticle.getParticleType();
        boolean z2 = true;
        if (particleType == 1 || particleType == 2) {
            for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
                particlesMatchingAfter(schemaParticle2, qNameSetSpecification, map, qNameSetBuilder, false);
            }
        } else if (particleType == 3) {
            SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
            if (particleChildren.length != 0) {
                if (particleChildren[particleChildren.length - 1].isSkippable()) {
                    QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetSpecification);
                    QNameSetBuilder qNameSetBuilder3 = new QNameSetBuilder();
                    for (int length = particleChildren.length - 1; length >= 0; length--) {
                        particlesMatchingAfter(particleChildren[length], qNameSetBuilder2, map, qNameSetBuilder3, false);
                        qNameSetBuilder.addAll(qNameSetBuilder3);
                        if (!particleChildren[length].isSkippable()) {
                            break;
                        }
                        qNameSetBuilder2.removeAll(qNameSetBuilder3);
                        if (qNameSetBuilder2.isEmpty()) {
                            break;
                        }
                        qNameSetBuilder3.clear();
                    }
                } else {
                    particlesMatchingAfter(particleChildren[0], qNameSetSpecification, map, qNameSetBuilder, false);
                }
            }
        }
        if (z) {
            return;
        }
        BigInteger minOccurs = schemaParticle.getMinOccurs();
        BigInteger maxOccurs = schemaParticle.getMaxOccurs();
        if (maxOccurs != null && minOccurs.compareTo(maxOccurs) >= 0) {
            z2 = false;
        }
        if (z2) {
            particlesMatchingStart(schemaParticle, qNameSetSpecification, map, qNameSetBuilder);
        }
    }

    private static void particlesMatchingStart(SchemaParticle schemaParticle, QNameSetSpecification qNameSetSpecification, Map<SchemaParticle, QNameSet> map, QNameSetBuilder qNameSetBuilder) {
        int particleType = schemaParticle.getParticleType();
        int i2 = 0;
        if (particleType == 1 || particleType == 2) {
            SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
            int length = particleChildren.length;
            while (i2 < length) {
                particlesMatchingStart(particleChildren[i2], qNameSetSpecification, map, qNameSetBuilder);
                i2++;
            }
            return;
        }
        if (particleType != 3) {
            if (particleType == 4) {
                if (qNameSetSpecification.contains(schemaParticle.getName())) {
                    map.put(schemaParticle, null);
                    qNameSetBuilder.add(schemaParticle.getName());
                    return;
                }
                return;
            }
            if (particleType == 5 && !qNameSetSpecification.isDisjoint(schemaParticle.getWildcardSet())) {
                map.put(schemaParticle, schemaParticle.getWildcardSet().intersect(qNameSetSpecification));
                qNameSetBuilder.addAll(schemaParticle.getWildcardSet());
                return;
            }
            return;
        }
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        if (particleChildren2.length == 0) {
            return;
        }
        if (!particleChildren2[0].isSkippable()) {
            particlesMatchingStart(particleChildren2[0], qNameSetSpecification, map, qNameSetBuilder);
            return;
        }
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetSpecification);
        QNameSetBuilder qNameSetBuilder3 = new QNameSetBuilder();
        int length2 = particleChildren2.length;
        while (i2 < length2) {
            SchemaParticle schemaParticle2 = particleChildren2[i2];
            particlesMatchingStart(schemaParticle2, qNameSetBuilder2, map, qNameSetBuilder3);
            qNameSetBuilder.addAll(qNameSetBuilder3);
            if (!schemaParticle2.isSkippable()) {
                return;
            }
            qNameSetBuilder2.removeAll(qNameSetBuilder3);
            if (qNameSetBuilder2.isEmpty()) {
                return;
            }
            qNameSetBuilder3.clear();
            i2++;
        }
    }

    static void resolveBasicComplexType(SchemaTypeImpl schemaTypeImpl) {
        ArrayList arrayList = new ArrayList();
        ComplexType complexType = (ComplexType) schemaTypeImpl.getParseObject();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z = schemaTypeImpl.getChameleonNamespace() != null;
        Group contentModel = getContentModel(complexType);
        if (schemaTypeImpl.isRedefinition()) {
            StscState.get().error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{"<complexType>"}, complexType);
        }
        SchemaParticle schemaParticleTranslateContentModel = translateContentModel(schemaTypeImpl, contentModel, targetNamespace, z, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode(contentModel), arrayList, new LinkedHashMap(), false, null);
        boolean z2 = schemaParticleTranslateContentModel != null && schemaParticleTranslateContentModel.getParticleType() == 1;
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        translateAttributeModel(complexType, targetNamespace, z, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, null, true, null);
        WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticleTranslateContentModel);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        if (schemaParticleTranslateContentModel != null) {
            buildStateMachine(schemaParticleTranslateContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) schemaParticleTranslateContentModel).isDeterministic()) {
                StscState.get().error(XmlErrorCodes.UNIQUE_PARTICLE_ATTRIBUTION, (Object[]) null, contentModel);
            }
        }
        Map<QName, SchemaProperty> mapBuildContentPropertyModelByQName = buildContentPropertyModelByQName(schemaParticleTranslateContentModel, schemaTypeImpl);
        Map<QName, SchemaProperty> mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        int i2 = complexType.getMixed() ? 4 : schemaParticleTranslateContentModel == null ? 1 : 3;
        SchemaTypeImpl schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl2.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setComplexTypeVariety(i2);
        schemaTypeImpl.setContentModel(schemaParticleTranslateContentModel, schemaAttributeModelImpl, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z2);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0228  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void resolveCcExtension(SchemaTypeImpl schemaTypeImpl, ExtensionType extensionType, boolean z) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        SchemaType schemaType;
        boolean z2;
        SchemaParticle schemaParticle;
        int i2;
        int i3;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z3 = schemaTypeImpl.getChameleonNamespace() != null;
        if (extensionType.getBase() == null) {
            stscState.error("A complexContent must define a base type", 28, extensionType);
            schemaTypeImplFindGlobalType = null;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(extensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<complexType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, extensionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(extensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(extensionType.getBase(), 0, extensionType.xgetBase(), true);
            }
        }
        if (schemaTypeImplFindGlobalType != null && !StscResolver.resolveType(schemaTypeImplFindGlobalType)) {
            schemaTypeImplFindGlobalType = null;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.isSimpleType()) {
            stscState.recover(XmlErrorCodes.SCHEMA_COMPLEX_TYPE$COMPLEX_CONTENT, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, extensionType.xgetBase());
            schemaTypeImplFindGlobalType = null;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.finalExtension()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, extensionType.xgetBase());
        }
        SchemaParticle contentModel = schemaTypeImplFindGlobalType == null ? null : schemaTypeImplFindGlobalType.getContentModel();
        ArrayList arrayList = new ArrayList();
        Map<QName, SchemaType> mapExtractElementModel = extractElementModel(schemaTypeImplFindGlobalType);
        Group contentModel2 = getContentModel(extensionType);
        if (schemaTypeImplFindGlobalType == null || schemaTypeImplFindGlobalType.getContentType() != 2) {
            schemaType = schemaTypeImplFindGlobalType;
        } else if (contentModel2 == null) {
            resolveScExtensionPart2(schemaTypeImpl, schemaTypeImplFindGlobalType, extensionType, targetNamespace, z3);
            return;
        } else {
            stscState.recover(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$EXTENDING_SIMPLE_CONTENT, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, extensionType.xgetBase());
            schemaType = null;
        }
        SchemaParticle schemaParticle2 = contentModel;
        boolean z4 = z3;
        SchemaParticle schemaParticleTranslateContentModel = translateContentModel(schemaTypeImpl, contentModel2, targetNamespace, z3, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode(contentModel2), arrayList, mapExtractElementModel, false, null);
        if (schemaParticleTranslateContentModel != null || z) {
            z2 = z;
        } else {
            z2 = schemaType != null && schemaType.getContentType() == 4;
        }
        if (schemaType == null || schemaType.getContentType() == 1) {
            schemaParticle = null;
        } else {
            if ((schemaType.getContentType() == 4) != z2) {
                schemaParticle = null;
                stscState.error(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$BOTH_ELEMEMENT_OR_MIXED, (Object[]) null, extensionType.xgetBase());
            }
        }
        if (schemaType != null && schemaType.hasAllContent() && schemaParticleTranslateContentModel != null) {
            stscState.error("Cannot extend a type with 'all' content model", 42, extensionType.xgetBase());
            schemaParticleTranslateContentModel = schemaParticle;
        }
        SchemaParticle schemaParticleExtendContentModel = extendContentModel(schemaParticle2, schemaParticleTranslateContentModel, extensionType);
        boolean z5 = schemaParticleExtendContentModel != null && schemaParticleExtendContentModel.getParticleType() == 1;
        SchemaAttributeModelImpl schemaAttributeModelImpl = schemaType == null ? new SchemaAttributeModelImpl() : new SchemaAttributeModelImpl(schemaType.getAttributeModel());
        Object[] objArr = schemaParticle;
        boolean z6 = z2;
        translateAttributeModel(extensionType, targetNamespace, z4, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, schemaType, true, null);
        WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticleExtendContentModel);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        if (schemaParticleExtendContentModel != null) {
            buildStateMachine(schemaParticleExtendContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) schemaParticleExtendContentModel).isDeterministic()) {
                StscState.get().error(XmlErrorCodes.UNIQUE_PARTICLE_ATTRIBUTION, objArr, contentModel2);
            }
        }
        Map<QName, SchemaProperty> mapBuildContentPropertyModelByQName = buildContentPropertyModelByQName(schemaParticleExtendContentModel, schemaTypeImpl);
        Map<QName, SchemaProperty> mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        if (schemaParticleExtendContentModel == null && schemaType != null) {
            i2 = 2;
            if (schemaType.getContentType() == 2) {
                schemaTypeImpl.setContentBasedOnTypeRef(schemaType.getContentBasedOnType().getRef());
                i3 = 2;
            }
            if (schemaType == null) {
                schemaType = XmlObject.type;
            }
            schemaTypeImpl.setBaseTypeRef(schemaType.getRef());
            schemaTypeImpl.setBaseDepth(((SchemaTypeImpl) schemaType).getBaseDepth() + 1);
            schemaTypeImpl.setDerivationType(i2);
            schemaTypeImpl.setComplexTypeVariety(i3);
            schemaTypeImpl.setContentModel(schemaParticleExtendContentModel, schemaAttributeModelImpl, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z5);
            schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
            schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
        }
        i2 = 2;
        i3 = z6 ? 4 : schemaParticleExtendContentModel == null ? 1 : 3;
        if (schemaType == null) {
        }
        schemaTypeImpl.setBaseTypeRef(schemaType.getRef());
        schemaTypeImpl.setBaseDepth(((SchemaTypeImpl) schemaType).getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(i2);
        schemaTypeImpl.setComplexTypeVariety(i3);
        schemaTypeImpl.setContentModel(schemaParticleExtendContentModel, schemaAttributeModelImpl, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z5);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
    }

    static void resolveCcRestriction(SchemaTypeImpl schemaTypeImpl, ComplexRestrictionType complexRestrictionType, boolean z) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z2 = schemaTypeImpl.getChameleonNamespace() != null;
        if (complexRestrictionType.getBase() == null) {
            stscState.error("A complexContent must define a base type", 28, complexRestrictionType);
            schemaTypeImplFindGlobalType = null;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(complexRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<complexType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, complexRestrictionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(complexRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(complexRestrictionType.getBase(), 0, complexRestrictionType.xgetBase(), true);
            }
        }
        if (schemaTypeImplFindGlobalType == null) {
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.finalRestriction()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, complexRestrictionType.xgetBase());
        }
        SchemaTypeImpl schemaTypeImpl2 = (schemaTypeImplFindGlobalType == null || StscResolver.resolveType(schemaTypeImplFindGlobalType)) ? schemaTypeImplFindGlobalType : null;
        ArrayList arrayList = new ArrayList();
        Group contentModel = getContentModel(complexRestrictionType);
        SchemaParticle schemaParticleTranslateContentModel = translateContentModel(schemaTypeImpl, contentModel, targetNamespace, z2, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode(contentModel), arrayList, new LinkedHashMap(), false, null);
        boolean z3 = schemaParticleTranslateContentModel != null && schemaParticleTranslateContentModel.getParticleType() == 1;
        SchemaAttributeModelImpl schemaAttributeModelImpl = schemaTypeImpl2 == null ? new SchemaAttributeModelImpl() : new SchemaAttributeModelImpl(schemaTypeImpl2.getAttributeModel());
        translateAttributeModel(complexRestrictionType, targetNamespace, z2, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, schemaTypeImpl2, false, null);
        WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticleTranslateContentModel);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        if (schemaParticleTranslateContentModel != null) {
            buildStateMachine(schemaParticleTranslateContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) schemaParticleTranslateContentModel).isDeterministic()) {
                StscState.get().error(XmlErrorCodes.UNIQUE_PARTICLE_ATTRIBUTION, (Object[]) null, contentModel);
            }
        }
        Map<QName, SchemaProperty> mapBuildContentPropertyModelByQName = buildContentPropertyModelByQName(schemaParticleTranslateContentModel, schemaTypeImpl);
        Map<QName, SchemaProperty> mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        int i2 = z ? 4 : schemaParticleTranslateContentModel == null ? 1 : 3;
        if (schemaTypeImpl2 != null) {
            schemaTypeImpl.setBaseTypeRef(schemaTypeImpl2.getRef());
            schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        }
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(i2);
        schemaTypeImpl.setContentModel(schemaParticleTranslateContentModel, schemaAttributeModelImpl, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z3);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void resolveComplexType(SchemaTypeImpl schemaTypeImpl) {
        boolean zContains;
        boolean z;
        boolean zContains2;
        boolean z2;
        boolean zContains3;
        SimpleContentDocument.SimpleContent simpleContent;
        ComplexType complexType = (ComplexType) schemaTypeImpl.getParseObject();
        StscState stscState = StscState.get();
        SchemaDocument.Schema schema = getSchema(complexType);
        boolean z3 = complexType.isSetAbstract() && complexType.getAbstract();
        Object obj = complexType.isSetFinal() ? complexType.getFinal() : (schema == null || !schema.isSetFinalDefault()) ? null : schema.getFinalDefault();
        if (obj == null) {
            zContains = false;
            zContains2 = zContains;
            z = zContains2;
        } else if ((obj instanceof String) && obj.equals("#all")) {
            zContains = true;
            zContains2 = zContains;
            z = zContains2;
        } else {
            if (obj instanceof List) {
                List list = (List) obj;
                zContains = list.contains("extension");
                zContains2 = list.contains("restriction");
                z = false;
            }
            zContains = false;
            zContains2 = zContains;
            z = zContains2;
        }
        schemaTypeImpl.setAbstractFinal(z3, zContains, zContains2, z, z);
        Object block = complexType.isSetBlock() ? complexType.getBlock() : (schema == null || !schema.isSetBlockDefault()) ? null : schema.getBlockDefault();
        if (block == null) {
            z2 = false;
            zContains3 = z2;
        } else if ((block instanceof String) && block.equals("#all")) {
            z2 = true;
            zContains3 = z2;
        } else {
            if (block instanceof List) {
                List list2 = (List) block;
                zContains3 = list2.contains("extension");
                z2 = list2.contains("restriction");
            }
            z2 = false;
            zContains3 = z2;
        }
        schemaTypeImpl.setBlock(zContains3, z2);
        ComplexContentDocument.ComplexContent complexContent = complexType.getComplexContent();
        SimpleContentDocument.SimpleContent simpleContent2 = complexType.getSimpleContent();
        if ((complexContent != null ? 1 : 0) + (simpleContent2 != null ? 1 : 0) + (getContentModel(complexType) != null ? 1 : 0) > 1) {
            stscState.error("A complex type must define either a content model, or a simpleContent or complexContent derivation: more than one found.", 26, complexType);
            simpleContent = (complexContent == null || simpleContent2 == null) ? simpleContent2 : null;
        }
        if (complexContent != null) {
            if (complexContent.getExtension() != null && complexContent.getRestriction() != null) {
                stscState.error("Restriction conflicts with extension", 26, complexContent.getRestriction());
            }
            boolean mixed = complexContent.isSetMixed() ? complexContent.getMixed() : complexType.getMixed();
            if (complexContent.getExtension() != null) {
                resolveCcExtension(schemaTypeImpl, complexContent.getExtension(), mixed);
                return;
            } else if (complexContent.getRestriction() != null) {
                resolveCcRestriction(schemaTypeImpl, complexContent.getRestriction(), mixed);
                return;
            } else {
                stscState.error("Missing restriction or extension", 27, complexContent);
                resolveErrorType(schemaTypeImpl);
                return;
            }
        }
        if (simpleContent == null) {
            resolveBasicComplexType(schemaTypeImpl);
            return;
        }
        if (simpleContent.getExtension() != null && simpleContent.getRestriction() != null) {
            stscState.error("Restriction conflicts with extension", 26, simpleContent.getRestriction());
        }
        if (simpleContent.getExtension() != null) {
            resolveScExtension(schemaTypeImpl, simpleContent.getExtension());
        } else if (simpleContent.getRestriction() != null) {
            resolveScRestriction(schemaTypeImpl, simpleContent.getRestriction());
        } else {
            stscState.error("Missing restriction or extension", 27, simpleContent);
            resolveErrorType(schemaTypeImpl);
        }
    }

    static void resolveErrorType(SchemaTypeImpl schemaTypeImpl) {
        throw new RuntimeException("This type of error recovery not yet implemented.");
    }

    static void resolveScExtension(SchemaTypeImpl schemaTypeImpl, SimpleExtensionType simpleExtensionType) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z = schemaTypeImpl.getChameleonNamespace() != null;
        if (simpleExtensionType.getBase() == null) {
            stscState.error("A simpleContent extension must define a base type", 28, simpleExtensionType);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(simpleExtensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<simpleType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleExtensionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(simpleExtensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(simpleExtensionType.getBase(), 0, simpleExtensionType.xgetBase(), true);
                schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            }
        }
        StscResolver.resolveType(schemaTypeImplFindGlobalType);
        if (!schemaTypeImplFindGlobalType.isSimpleType() && schemaTypeImplFindGlobalType.getContentType() != 2) {
            stscState.error(XmlErrorCodes.SCHEMA_COMPLEX_TYPE$SIMPLE_CONTENT, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, simpleExtensionType);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.finalExtension()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleExtensionType.xgetBase());
        }
        resolveScExtensionPart2(schemaTypeImpl, schemaTypeImplFindGlobalType, simpleExtensionType, targetNamespace, z);
    }

    static void resolveScExtensionPart2(SchemaTypeImpl schemaTypeImpl, SchemaType schemaType, ExtensionType extensionType, String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaType.getAttributeModel());
        translateAttributeModel(extensionType, str, z, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, schemaType, true, null);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        Map<QName, SchemaProperty> mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        schemaTypeImpl.setBaseTypeRef(schemaType.getRef());
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaType;
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setContentBasedOnTypeRef(schemaType.getRef());
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
        schemaTypeImpl.setComplexTypeVariety(2);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, null, mapBuildAttributePropertyModelByQName, false);
        schemaTypeImpl.setSimpleTypeVariety(schemaType.getSimpleVariety());
        schemaTypeImpl.setPrimitiveTypeRef(schemaType.getPrimitiveType() == null ? null : schemaType.getPrimitiveType().getRef());
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaType.getUnionMemberTypes())));
        } else if (simpleVariety == 3) {
            schemaTypeImpl.setListItemTypeRef(schemaType.getListItemType().getRef());
        }
        StscSimpleTypeResolver.resolveFacets(schemaTypeImpl, null, schemaTypeImpl2);
        StscSimpleTypeResolver.resolveFundamentalFacets(schemaTypeImpl);
    }

    static void resolveScRestriction(SchemaTypeImpl schemaTypeImpl, SimpleRestrictionType simpleRestrictionType) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        SchemaTypeImpl schemaTypeImpl2;
        SchemaType listItemType;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z = schemaTypeImpl.getChameleonNamespace() != null;
        ArrayList arrayList = new ArrayList();
        SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType = simpleRestrictionType.getSimpleType() != null ? StscTranslator.translateAnonymousSimpleType(simpleRestrictionType.getSimpleType(), targetNamespace, z, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl) : null;
        if (simpleRestrictionType.getBase() == null) {
            stscState.error("A simpleContent restriction must define a base type", 28, simpleRestrictionType);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else if (schemaTypeImpl.isRedefinition()) {
            schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(simpleRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
            if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<simpleType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleRestrictionType);
            }
        } else {
            schemaTypeImplFindGlobalType = stscState.findGlobalType(simpleRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
        }
        if (schemaTypeImplFindGlobalType == null) {
            stscState.notFoundError(simpleRestrictionType.getBase(), 0, simpleRestrictionType.xgetBase(), true);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        StscResolver.resolveType(schemaTypeImplFindGlobalType);
        if (schemaTypeImplTranslateAnonymousSimpleType != null) {
            StscResolver.resolveType(schemaTypeImplTranslateAnonymousSimpleType);
            schemaTypeImpl2 = schemaTypeImplTranslateAnonymousSimpleType;
        } else {
            schemaTypeImpl2 = schemaTypeImplFindGlobalType;
        }
        if (schemaTypeImplFindGlobalType.isSimpleType()) {
            stscState.recover(XmlErrorCodes.COMPLEX_TYPE_PROPERTIES$SIMPLE_TYPE_EXTENSION, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, simpleRestrictionType);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        SchemaTypeImpl schemaTypeImpl3 = schemaTypeImplFindGlobalType;
        if (schemaTypeImpl3 != null && schemaTypeImpl3.finalRestriction()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImpl3.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleRestrictionType.xgetBase());
        }
        SchemaAttributeModelImpl schemaAttributeModelImpl = schemaTypeImpl3 == null ? new SchemaAttributeModelImpl() : new SchemaAttributeModelImpl(schemaTypeImpl3.getAttributeModel());
        boolean z2 = z;
        SchemaTypeImpl schemaTypeImpl4 = schemaTypeImpl2;
        translateAttributeModel(simpleRestrictionType, targetNamespace, z2, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, schemaTypeImpl3, false, null);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        Map<QName, SchemaProperty> mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        if (schemaTypeImpl3 != null) {
            schemaTypeImpl.setBaseTypeRef(schemaTypeImpl3.getRef());
            schemaTypeImpl.setBaseDepth(schemaTypeImpl3.getBaseDepth() + 1);
        }
        schemaTypeImpl.setContentBasedOnTypeRef(schemaTypeImpl4.getRef());
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
        schemaTypeImpl.setComplexTypeVariety(2);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, null, mapBuildAttributePropertyModelByQName, false);
        schemaTypeImpl.setSimpleTypeVariety(schemaTypeImpl4.getSimpleVariety());
        schemaTypeImpl.setPrimitiveTypeRef(schemaTypeImpl4.getPrimitiveType() != null ? schemaTypeImpl4.getPrimitiveType().getRef() : null);
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaTypeImpl4.getUnionMemberTypes())));
        } else if (simpleVariety == 3 && (listItemType = schemaTypeImpl4.getListItemType()) != null) {
            schemaTypeImpl.setListItemTypeRef(listItemType.getRef());
        }
        StscSimpleTypeResolver.resolveFacets(schemaTypeImpl, simpleRestrictionType, schemaTypeImpl4);
        StscSimpleTypeResolver.resolveFundamentalFacets(schemaTypeImpl);
    }

    static WildcardResult summarizeAttrWildcards(SchemaAttributeModel schemaAttributeModel) {
        return schemaAttributeModel.getWildcardProcess() == 0 ? new WildcardResult(QNameSet.EMPTY, false) : schemaAttributeModel.getWildcardProcess() == 3 ? new WildcardResult(QNameSet.EMPTY, true) : new WildcardResult(schemaAttributeModel.getWildcardSet(), true);
    }

    static WildcardResult summarizeEltWildcards(SchemaParticle schemaParticle) {
        if (schemaParticle == null) {
            return new WildcardResult(QNameSet.EMPTY, false);
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType != 1 && particleType != 2 && particleType != 3) {
            if (particleType != 5) {
                return new WildcardResult(QNameSet.EMPTY, false);
            }
            return new WildcardResult(schemaParticle.getWildcardProcess() == 3 ? QNameSet.EMPTY : schemaParticle.getWildcardSet(), true);
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        boolean z = false;
        for (int i2 = 0; i2 < schemaParticle.countOfParticleChild(); i2++) {
            WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticle.getParticleChild(i2));
            qNameSetBuilder.addAll(wildcardResultSummarizeEltWildcards.typedWildcards);
            z |= wildcardResultSummarizeEltWildcards.hasWildcards;
        }
        return new WildcardResult(qNameSetBuilder.toQNameSet(), z);
    }

    private static <T> BinaryOperator<T> throwingMerger() {
        return new BinaryOperator() { // from class: org.apache.xmlbeans.impl.schema.z0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                StscComplexTypeResolver.h(obj, obj2);
                throw null;
            }
        };
    }

    static int translateAttributeCode(QName qName) {
        return attributeCodeMap.getOrDefault(qName, 0).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0086 A[Catch: all -> 0x02b1, TryCatch #0 {all -> 0x02b1, blocks: (B:11:0x0025, B:13:0x0032, B:14:0x003b, B:117:0x0291, B:16:0x0040, B:18:0x0048, B:19:0x0051, B:23:0x005e, B:26:0x0066, B:28:0x006c, B:29:0x0072, B:31:0x007c, B:32:0x0086, B:34:0x0094, B:36:0x009d, B:37:0x00ac, B:22:0x005a, B:39:0x00bb, B:41:0x00c7, B:46:0x00d7, B:48:0x00dd, B:51:0x00ed, B:59:0x010e, B:60:0x0117, B:62:0x011d, B:64:0x0136, B:66:0x013c, B:72:0x014e, B:76:0x015c, B:56:0x0107, B:78:0x0183, B:81:0x01a2, B:83:0x01ad, B:84:0x01ce, B:86:0x01d9, B:89:0x01e5, B:91:0x01f3, B:93:0x0212, B:95:0x0218, B:96:0x0224, B:98:0x022b, B:100:0x0231, B:101:0x024d, B:103:0x0253, B:104:0x025a, B:106:0x0260, B:110:0x026d, B:112:0x0273, B:114:0x0279, B:116:0x027f, B:107:0x0264, B:109:0x026a), top: B:136:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010e A[Catch: all -> 0x02b1, TryCatch #0 {all -> 0x02b1, blocks: (B:11:0x0025, B:13:0x0032, B:14:0x003b, B:117:0x0291, B:16:0x0040, B:18:0x0048, B:19:0x0051, B:23:0x005e, B:26:0x0066, B:28:0x006c, B:29:0x0072, B:31:0x007c, B:32:0x0086, B:34:0x0094, B:36:0x009d, B:37:0x00ac, B:22:0x005a, B:39:0x00bb, B:41:0x00c7, B:46:0x00d7, B:48:0x00dd, B:51:0x00ed, B:59:0x010e, B:60:0x0117, B:62:0x011d, B:64:0x0136, B:66:0x013c, B:72:0x014e, B:76:0x015c, B:56:0x0107, B:78:0x0183, B:81:0x01a2, B:83:0x01ad, B:84:0x01ce, B:86:0x01d9, B:89:0x01e5, B:91:0x01f3, B:93:0x0212, B:95:0x0218, B:96:0x0224, B:98:0x022b, B:100:0x0231, B:101:0x024d, B:103:0x0253, B:104:0x025a, B:106:0x0260, B:110:0x026d, B:112:0x0273, B:114:0x0279, B:116:0x027f, B:107:0x0264, B:109:0x026a), top: B:136:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0117 A[Catch: all -> 0x02b1, TryCatch #0 {all -> 0x02b1, blocks: (B:11:0x0025, B:13:0x0032, B:14:0x003b, B:117:0x0291, B:16:0x0040, B:18:0x0048, B:19:0x0051, B:23:0x005e, B:26:0x0066, B:28:0x006c, B:29:0x0072, B:31:0x007c, B:32:0x0086, B:34:0x0094, B:36:0x009d, B:37:0x00ac, B:22:0x005a, B:39:0x00bb, B:41:0x00c7, B:46:0x00d7, B:48:0x00dd, B:51:0x00ed, B:59:0x010e, B:60:0x0117, B:62:0x011d, B:64:0x0136, B:66:0x013c, B:72:0x014e, B:76:0x015c, B:56:0x0107, B:78:0x0183, B:81:0x01a2, B:83:0x01ad, B:84:0x01ce, B:86:0x01d9, B:89:0x01e5, B:91:0x01f3, B:93:0x0212, B:95:0x0218, B:96:0x0224, B:98:0x022b, B:100:0x0231, B:101:0x024d, B:103:0x0253, B:104:0x025a, B:106:0x0260, B:110:0x026d, B:112:0x0273, B:114:0x0279, B:116:0x027f, B:107:0x0264, B:109:0x026a), top: B:136:0x0025 }] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r15v0, types: [org.apache.xmlbeans.impl.schema.StscState] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void translateAttributeModel(XmlObject xmlObject, String str, boolean z, String str2, List<SchemaType> list, SchemaType schemaType, Set<QName> set, SchemaAttributeModelImpl schemaAttributeModelImpl, SchemaType schemaType2, boolean z2, SchemaAttributeGroupImpl schemaAttributeGroupImpl) {
        SchemaAttributeModel schemaAttributeModel;
        Set<QName> set2;
        SchemaAttributeModel schemaAttributeModel2;
        SchemaAttributeGroupImpl schemaAttributeGroupImplFindAttributeGroup;
        SchemaAttributeGroupImpl schemaAttributeGroupImpl2;
        String str3;
        String str4 = str;
        SchemaAttributeGroupImpl schemaAttributeGroupImpl3 = schemaAttributeGroupImpl;
        ?? r15 = StscState.get();
        Set<QName> hashSet = set == null ? new HashSet() : set;
        ?? r10 = 0;
        SchemaAttributeModel attributeModel = schemaType2 != null ? schemaType2.getAttributeModel() : null;
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            boolean firstChild = xmlCursorNewCursor.toFirstChild();
            ?? r8 = 0;
            boolean z3 = z;
            boolean z4 = false;
            boolean z5 = false;
            while (firstChild) {
                switch (translateAttributeCode(xmlCursorNewCursor.getName())) {
                    case 100:
                        schemaAttributeModel = attributeModel;
                        set2 = hashSet;
                        Attribute attribute = (Attribute) xmlCursorNewCursor.getObject();
                        SchemaLocalAttributeImpl schemaLocalAttributeImplTranslateAttribute = StscTranslator.translateAttribute(attribute, str, str2, z3, list, schemaType, schemaAttributeModel, true);
                        if (schemaLocalAttributeImplTranslateAttribute != null) {
                            if (!set2.contains(schemaLocalAttributeImplTranslateAttribute.getName())) {
                                set2.add(schemaLocalAttributeImplTranslateAttribute.getName());
                                schemaAttributeModel2 = schemaAttributeModel;
                                if (schemaAttributeModel2 != null) {
                                    SchemaLocalAttribute attribute2 = schemaAttributeModel2.getAttribute(schemaLocalAttributeImplTranslateAttribute.getName());
                                    if (attribute2 == null) {
                                        if (!z2 && !schemaAttributeModel2.getWildcardSet().contains(schemaLocalAttributeImplTranslateAttribute.getName())) {
                                            r15.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ATTR_IN_BASE_WILDCARD_SET, new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName()), QNameHelper.pretty(schemaType.getName())}, attribute);
                                        }
                                    } else if (z2) {
                                        if (schemaLocalAttributeImplTranslateAttribute.getUse() == 1) {
                                            r15.error("An extension cannot prohibit an attribute from the base type; use restriction instead.", 37, attribute.xgetUse());
                                        }
                                    } else if (schemaLocalAttributeImplTranslateAttribute.getUse() != 3) {
                                        if (attribute2.getUse() == 3) {
                                            r15.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ATTR_REQUIRED, new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName()), QNameHelper.pretty(schemaType.getName())}, attribute);
                                        }
                                        if (schemaLocalAttributeImplTranslateAttribute.getUse() == 1) {
                                            schemaAttributeModelImpl.removeProhibitedAttribute(schemaLocalAttributeImplTranslateAttribute.getName());
                                        }
                                    }
                                }
                                if (schemaLocalAttributeImplTranslateAttribute.getUse() != 1) {
                                    schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImplTranslateAttribute);
                                } else {
                                    SchemaType type = schemaLocalAttributeImplTranslateAttribute.getType();
                                    if (list != null) {
                                        list.remove(type);
                                    }
                                }
                                if (schemaLocalAttributeImplTranslateAttribute.getDefaultText() != null && !schemaLocalAttributeImplTranslateAttribute.isFixed() && schemaLocalAttributeImplTranslateAttribute.getUse() != 2) {
                                    r15.error(XmlErrorCodes.SCHEMA_ATTR$DEFAULT_AND_USE_OPTIONAL, new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName())}, attribute);
                                    break;
                                }
                            } else {
                                r15.error(XmlErrorCodes.COMPLEX_TYPE_PROPERTIES$DUPLICATE_ATTRIBUTE, new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName()), QNameHelper.pretty(schemaType.getName())}, attribute.xgetName());
                            }
                        }
                        schemaAttributeModel2 = schemaAttributeModel;
                        break;
                    case 101:
                        AttributeGroupRef attributeGroupRef = (AttributeGroupRef) xmlCursorNewCursor.getObject();
                        QName ref = attributeGroupRef.getRef();
                        if (ref == null) {
                            r15.error("Attribute group reference must have a ref attribute", 39, attributeGroupRef);
                        } else {
                            if (schemaAttributeGroupImpl3 != null) {
                                schemaAttributeGroupImplFindAttributeGroup = r15.findRedefinedAttributeGroup(ref, z3 ? str4 : r10, schemaAttributeGroupImpl3);
                                if (schemaAttributeGroupImplFindAttributeGroup != null && schemaAttributeGroupImpl.getName().equals(schemaAttributeGroupImplFindAttributeGroup.getName())) {
                                    if (z5) {
                                        Object[] objArr = new Object[1];
                                        objArr[r8] = QNameHelper.pretty(schemaAttributeGroupImpl.getName());
                                        r15.error(XmlErrorCodes.SCHEMA_REDEFINE$ATTR_GROUP_SELF_REF, objArr, attributeGroupRef);
                                    }
                                    schemaAttributeGroupImpl2 = schemaAttributeGroupImplFindAttributeGroup;
                                    z5 = true;
                                }
                                if (schemaAttributeGroupImpl2 == null) {
                                    if (!r15.isProcessing(schemaAttributeGroupImpl2)) {
                                        if (schemaAttributeGroupImpl2.getTargetNamespace() != null) {
                                            String targetNamespace = schemaAttributeGroupImpl2.getTargetNamespace();
                                            z3 = schemaAttributeGroupImpl2.getChameleonNamespace() != null ? true : r8;
                                            str3 = targetNamespace;
                                        } else {
                                            str3 = str4;
                                        }
                                        r15.startProcessing(schemaAttributeGroupImpl2);
                                        schemaAttributeModel = attributeModel;
                                        set2 = hashSet;
                                        translateAttributeModel(schemaAttributeGroupImpl2.getParseObject(), str3, z3, schemaAttributeGroupImpl2.getFormDefault(), list, schemaType, hashSet, schemaAttributeModelImpl, schemaType2, z2, schemaAttributeGroupImpl2.isRedefinition() ? schemaAttributeGroupImpl2 : r10);
                                        r15.finishProcessing(schemaAttributeGroupImpl2);
                                        schemaAttributeModel2 = schemaAttributeModel;
                                        break;
                                    } else {
                                        Object[] objArr2 = new Object[1];
                                        objArr2[r8] = QNameHelper.pretty(schemaAttributeGroupImpl2.getName());
                                        r15.error(XmlErrorCodes.SCHEMA_ATTR_GROUP$SELF_REF, objArr2, schemaAttributeGroupImpl2.getParseObject());
                                    }
                                } else {
                                    r15.notFoundError(ref, 4, attributeGroupRef.xgetRef(), true);
                                }
                            } else {
                                schemaAttributeGroupImplFindAttributeGroup = r15.findAttributeGroup(ref, z3 ? str4 : r10, str4);
                            }
                            schemaAttributeGroupImpl2 = schemaAttributeGroupImplFindAttributeGroup;
                            if (schemaAttributeGroupImpl2 == null) {
                            }
                        }
                        schemaAttributeModel2 = attributeModel;
                        set2 = hashSet;
                        break;
                    case 102:
                        Wildcard wildcard = (Wildcard) xmlCursorNewCursor.getObject();
                        if (z4) {
                            r15.error("Only one attribute wildcard allowed", 38, wildcard);
                        } else {
                            NamespaceList namespaceListXgetNamespace = wildcard.xgetNamespace();
                            String stringValue = namespaceListXgetNamespace == null ? "##any" : namespaceListXgetNamespace.getStringValue();
                            QNameSet qNameSetForWildcardNamespaceString = QNameSet.forWildcardNamespaceString(stringValue, str4);
                            if (attributeModel == null || z2) {
                                int iTranslateWildcardProcess = translateWildcardProcess(wildcard.xgetProcessContents());
                                if (schemaAttributeModelImpl.getWildcardProcess() == 0) {
                                    schemaAttributeModelImpl.setWildcardSet(qNameSetForWildcardNamespaceString);
                                    schemaAttributeModelImpl.setWildcardProcess(iTranslateWildcardProcess);
                                } else if (z2) {
                                    schemaAttributeModelImpl.setWildcardSet(qNameSetForWildcardNamespaceString.union(schemaAttributeModelImpl.getWildcardSet()));
                                    schemaAttributeModelImpl.setWildcardProcess(iTranslateWildcardProcess);
                                } else {
                                    schemaAttributeModelImpl.setWildcardSet(qNameSetForWildcardNamespaceString.intersect(schemaAttributeModelImpl.getWildcardSet()));
                                }
                                z4 = true;
                            } else {
                                if (attributeModel.getWildcardSet() == null) {
                                    r15.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$BASE_HAS_ATTR_WILDCARD, r10, wildcard);
                                } else if (!attributeModel.getWildcardSet().containsAll(qNameSetForWildcardNamespaceString)) {
                                    Object[] objArr3 = new Object[1];
                                    objArr3[r8] = stringValue;
                                    r15.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ATTR_WILDCARD_SUBSET, objArr3, wildcard);
                                }
                                z4 = true;
                            }
                        }
                        schemaAttributeModel2 = attributeModel;
                        set2 = hashSet;
                        break;
                    default:
                        schemaAttributeModel2 = attributeModel;
                        set2 = hashSet;
                        break;
                }
                firstChild = xmlCursorNewCursor.toNextSibling();
                str4 = str;
                attributeModel = schemaAttributeModel2;
                hashSet = set2;
                r8 = 0;
                r10 = 0;
                schemaAttributeGroupImpl3 = schemaAttributeGroupImpl;
            }
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            if (z2 || z4) {
                return;
            }
            schemaAttributeModelImpl.setWildcardSet(null);
            schemaAttributeModelImpl.setWildcardProcess(0);
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x01ac, code lost:
    
        r0 = r2.getObject();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object[], org.apache.xmlbeans.SchemaParticle] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static SchemaParticle translateContentModel(SchemaType schemaType, XmlObject xmlObject, String str, boolean z, String str2, String str3, int i2, List<SchemaType> list, Map<QName, SchemaType> map, boolean z2, RedefinitionForGroup redefinitionForGroup) {
        boolean z3;
        String elemFormDefault;
        String attFormDefault;
        SchemaModelGroupImpl schemaModelGroupImplFindModelGroup;
        String str4;
        BigInteger bigIntegerExtractMinOccurs;
        String str5;
        String str6;
        boolean z4;
        SchemaParticleImpl schemaParticleImpl;
        SchemaModelGroupImpl schemaModelGroupImpl;
        BigInteger bigIntegerExtractMaxOccurs;
        XmlObject xmlObject2;
        boolean z5;
        XmlCursor xmlCursorNewCursor;
        ?? r4;
        RedefinitionForGroup redefinitionForGroup2;
        SchemaModelGroupImpl schemaModelGroupImpl2;
        SchemaParticleImpl schemaParticleImpl2;
        SchemaModelGroupImpl schemaModelGroupImpl3;
        ArrayList arrayList;
        SchemaParticleImpl schemaParticleImpl3;
        XmlObject object = xmlObject;
        String str7 = str;
        int iTranslateParticleCode = i2;
        if (object == null || iTranslateParticleCode == 0) {
            return null;
        }
        StscState stscState = StscState.get();
        if (iTranslateParticleCode == 4) {
            if (!z2) {
                stscState.error("Must be a sequence, choice or all here", 32, object);
            }
            LocalElement localElement = (LocalElement) object;
            SchemaLocalElementImpl schemaLocalElementImplTranslateElement = StscTranslator.translateElement(localElement, str, z, str2, str3, list, schemaType);
            if (schemaLocalElementImplTranslateElement == null) {
                return null;
            }
            bigIntegerExtractMinOccurs = extractMinOccurs(localElement.xgetMinOccurs());
            bigIntegerExtractMaxOccurs = extractMaxOccurs(localElement.xgetMaxOccurs());
            SchemaType schemaType2 = map.get(schemaLocalElementImplTranslateElement.getName());
            if (schemaType2 == null) {
                map.put(schemaLocalElementImplTranslateElement.getName(), schemaLocalElementImplTranslateElement.getType());
            } else if (!schemaLocalElementImplTranslateElement.getType().equals(schemaType2)) {
                stscState.error(XmlErrorCodes.ELEM_CONSISTANT, new Object[]{QNameHelper.pretty(schemaLocalElementImplTranslateElement.getName())}, object);
                return null;
            }
            z4 = z;
            str4 = str2;
            str5 = str3;
            xmlObject2 = object;
            str6 = str7;
            schemaModelGroupImpl = null;
            z5 = false;
            schemaParticleImpl = schemaLocalElementImplTranslateElement;
        } else if (iTranslateParticleCode == 5) {
            if (!z2) {
                stscState.error("Must be a sequence, choice or all here", 32, object);
            }
            AnyDocument.Any any = (AnyDocument.Any) object;
            SchemaParticleImpl schemaParticleImpl4 = new SchemaParticleImpl();
            schemaParticleImpl4.setParticleType(5);
            NamespaceList namespaceListXgetNamespace = any.xgetNamespace();
            schemaParticleImpl4.setWildcardSet(namespaceListXgetNamespace == null ? QNameSet.ALL : QNameSet.forWildcardNamespaceString(namespaceListXgetNamespace.getStringValue(), str7));
            schemaParticleImpl4.setWildcardProcess(translateWildcardProcess(any.xgetProcessContents()));
            bigIntegerExtractMinOccurs = extractMinOccurs(any.xgetMinOccurs());
            z4 = z;
            str4 = str2;
            str5 = str3;
            xmlObject2 = object;
            str6 = str7;
            schemaModelGroupImpl = null;
            z5 = false;
            schemaParticleImpl = schemaParticleImpl4;
            bigIntegerExtractMaxOccurs = extractMaxOccurs(any.xgetMaxOccurs());
        } else {
            Group group = (Group) object;
            SchemaParticleImpl schemaParticleImpl5 = new SchemaParticleImpl();
            BigInteger bigIntegerExtractMinOccurs2 = extractMinOccurs(group.xgetMinOccurs());
            BigInteger bigIntegerExtractMaxOccurs2 = extractMaxOccurs(group.xgetMaxOccurs());
            if (iTranslateParticleCode == 100) {
                QName ref = group.getRef();
                if (ref == null) {
                    stscState.error("Group reference must have a ref attribute", 33, object);
                    return null;
                }
                if (redefinitionForGroup != null) {
                    schemaModelGroupImplFindModelGroup = stscState.findRedefinedModelGroup(ref, z ? str7 : null, redefinitionForGroup.getGroup());
                    if (schemaModelGroupImplFindModelGroup != null && schemaModelGroupImplFindModelGroup.getName().equals(redefinitionForGroup.getGroup().getName())) {
                        if (redefinitionForGroup.isSeenRedefinition()) {
                            stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$GROUP_SELF_REF, new Object[]{QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName())}, object);
                        }
                        BigInteger bigInteger = BigInteger.ONE;
                        if (!bigInteger.equals(bigIntegerExtractMaxOccurs2) || !bigInteger.equals(bigIntegerExtractMinOccurs2)) {
                            stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$GROUP_SELF_REF_MIN_MAX_1, new Object[]{QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName())}, object);
                        }
                        redefinitionForGroup.setSeenRedefinition(true);
                    }
                } else {
                    schemaModelGroupImplFindModelGroup = stscState.findModelGroup(ref, z ? str7 : null, str7);
                }
                if (schemaModelGroupImplFindModelGroup == null) {
                    stscState.notFoundError(ref, 6, group.xgetRef(), true);
                    return null;
                }
                if (stscState.isProcessing(schemaModelGroupImplFindModelGroup)) {
                    stscState.error(XmlErrorCodes.MODEL_GROUP_PROPERTIES$CIRCULAR, new Object[]{QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName())}, schemaModelGroupImplFindModelGroup.getParseObject());
                    return null;
                }
                xmlCursorNewCursor = schemaModelGroupImplFindModelGroup.getParseObject().newCursor();
                try {
                    boolean firstChild = xmlCursorNewCursor.toFirstChild();
                    while (true) {
                        if (!firstChild) {
                            break;
                        }
                        iTranslateParticleCode = translateParticleCode(xmlCursorNewCursor.getName());
                        if (iTranslateParticleCode != 0) {
                            break;
                        }
                        firstChild = xmlCursorNewCursor.toNextSibling();
                    }
                    if (xmlCursorNewCursor != null) {
                        xmlCursorNewCursor.close();
                    }
                    if (iTranslateParticleCode == 0) {
                        stscState.error("Model group " + QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName()) + " is empty", 32, schemaModelGroupImplFindModelGroup.getParseObject());
                        return null;
                    }
                    if (iTranslateParticleCode != 1 && iTranslateParticleCode != 3 && iTranslateParticleCode != 2) {
                        stscState.error("Model group " + QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName()) + " is not a sequence, all, or choice", 32, schemaModelGroupImplFindModelGroup.getParseObject());
                    }
                    String targetNamespace = schemaModelGroupImplFindModelGroup.getTargetNamespace();
                    if (targetNamespace != null) {
                        str7 = targetNamespace;
                    }
                    elemFormDefault = schemaModelGroupImplFindModelGroup.getElemFormDefault();
                    attFormDefault = schemaModelGroupImplFindModelGroup.getAttFormDefault();
                    z3 = schemaModelGroupImplFindModelGroup.getChameleonNamespace() != null;
                } finally {
                }
            } else {
                z3 = z;
                elemFormDefault = str2;
                attFormDefault = str3;
                schemaModelGroupImplFindModelGroup = null;
            }
            if (iTranslateParticleCode != 1 && iTranslateParticleCode != 2 && iTranslateParticleCode != 3) {
                throw new IllegalStateException();
            }
            schemaParticleImpl5.setParticleType(iTranslateParticleCode);
            str4 = elemFormDefault;
            bigIntegerExtractMinOccurs = bigIntegerExtractMinOccurs2;
            str5 = attFormDefault;
            str6 = str7;
            z4 = z3;
            schemaParticleImpl = schemaParticleImpl5;
            schemaModelGroupImpl = schemaModelGroupImplFindModelGroup;
            bigIntegerExtractMaxOccurs = bigIntegerExtractMaxOccurs2;
            xmlObject2 = object;
            z5 = true;
        }
        if (bigIntegerExtractMaxOccurs == null || bigIntegerExtractMinOccurs.compareTo(bigIntegerExtractMaxOccurs) <= 0) {
            r4 = 0;
        } else {
            r4 = 0;
            stscState.error(XmlErrorCodes.PARTICLE_PROPERTIES$MIN_LTE_MAX, (Object[]) null, xmlObject2);
            bigIntegerExtractMaxOccurs = bigIntegerExtractMinOccurs;
        }
        if (bigIntegerExtractMaxOccurs != null && bigIntegerExtractMaxOccurs.compareTo(BigInteger.ONE) < 0) {
            stscState.warning(XmlErrorCodes.PARTICLE_PROPERTIES$MAX_GTE_1, (Object[]) r4, xmlObject2);
            list.remove(schemaParticleImpl.getType());
            return r4;
        }
        schemaParticleImpl.setMinOccurs(bigIntegerExtractMinOccurs);
        schemaParticleImpl.setMaxOccurs(bigIntegerExtractMaxOccurs);
        if (schemaModelGroupImpl != null) {
            stscState.startProcessing(schemaModelGroupImpl);
            redefinitionForGroup2 = schemaModelGroupImpl.isRedefinition() ? new RedefinitionForGroup(schemaModelGroupImpl) : null;
        } else {
            redefinitionForGroup2 = redefinitionForGroup;
        }
        if (z5) {
            ArrayList arrayList2 = new ArrayList();
            xmlCursorNewCursor = xmlObject2.newCursor();
            try {
                boolean firstChild2 = xmlCursorNewCursor.toFirstChild();
                while (firstChild2) {
                    int iTranslateParticleCode2 = translateParticleCode(xmlCursorNewCursor.getName());
                    if (iTranslateParticleCode2 == 0) {
                        schemaModelGroupImpl3 = schemaModelGroupImpl;
                        arrayList = arrayList2;
                        schemaParticleImpl3 = schemaParticleImpl;
                    } else {
                        schemaModelGroupImpl3 = schemaModelGroupImpl;
                        arrayList = arrayList2;
                        schemaParticleImpl3 = schemaParticleImpl;
                        addMinusPointlessParticles(arrayList, translateContentModel(schemaType, xmlCursorNewCursor.getObject(), str6, z4, str4, str5, iTranslateParticleCode2, list, map, true, redefinitionForGroup2), schemaParticleImpl3.getParticleType());
                    }
                    firstChild2 = xmlCursorNewCursor.toNextSibling();
                    schemaParticleImpl = schemaParticleImpl3;
                    arrayList2 = arrayList;
                    schemaModelGroupImpl = schemaModelGroupImpl3;
                }
                schemaModelGroupImpl2 = schemaModelGroupImpl;
                ArrayList arrayList3 = arrayList2;
                SchemaParticleImpl schemaParticleImpl6 = schemaParticleImpl;
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                }
                schemaParticleImpl2 = schemaParticleImpl6;
                schemaParticleImpl2.setParticleChildren((SchemaParticle[]) arrayList3.toArray(new SchemaParticle[0]));
            } finally {
            }
        } else {
            schemaModelGroupImpl2 = schemaModelGroupImpl;
            schemaParticleImpl2 = schemaParticleImpl;
        }
        SchemaParticle schemaParticleFilterPointlessParticlesAndVerifyAllParticles = filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl2, xmlObject2);
        SchemaModelGroupImpl schemaModelGroupImpl4 = schemaModelGroupImpl2;
        if (schemaModelGroupImpl4 != null) {
            stscState.finishProcessing(schemaModelGroupImpl4);
        }
        return schemaParticleFilterPointlessParticlesAndVerifyAllParticles;
    }

    private static int translateParticleCode(Group group) {
        if (group == null) {
            return 0;
        }
        XmlCursor xmlCursorNewCursor = group.newCursor();
        try {
            int iTranslateParticleCode = translateParticleCode(xmlCursorNewCursor.getName());
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return iTranslateParticleCode;
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

    static int translateWildcardProcess(Wildcard.ProcessContents processContents) {
        if (processContents == null) {
            return 1;
        }
        String stringValue = processContents.getStringValue();
        if ("lax".equals(stringValue)) {
            return 2;
        }
        return "skip".equals(stringValue) ? 3 : 1;
    }

    public static Group getContentModel(final ComplexRestrictionType complexRestrictionType) {
        complexRestrictionType.getClass();
        complexRestrictionType.getClass();
        complexRestrictionType.getClass();
        complexRestrictionType.getClass();
        return getContentModel((Supplier<? extends Group>[]) new Supplier[]{new Supplier() { // from class: org.apache.xmlbeans.impl.schema.h
            @Override // java.util.function.Supplier
            public final Object get() {
                return complexRestrictionType.getAll();
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.n2
            @Override // java.util.function.Supplier
            public final Object get() {
                return complexRestrictionType.getSequence();
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.w1
            @Override // java.util.function.Supplier
            public final Object get() {
                return complexRestrictionType.getChoice();
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.p
            @Override // java.util.function.Supplier
            public final Object get() {
                return complexRestrictionType.getGroup();
            }
        }});
    }

    public static Group getContentModel(final ExtensionType extensionType) {
        extensionType.getClass();
        extensionType.getClass();
        extensionType.getClass();
        extensionType.getClass();
        return getContentModel((Supplier<? extends Group>[]) new Supplier[]{new Supplier() { // from class: org.apache.xmlbeans.impl.schema.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return extensionType.getAll();
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.a2
            @Override // java.util.function.Supplier
            public final Object get() {
                return extensionType.getSequence();
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.m
            @Override // java.util.function.Supplier
            public final Object get() {
                return extensionType.getChoice();
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.j2
            @Override // java.util.function.Supplier
            public final Object get() {
                return extensionType.getGroup();
            }
        }});
    }

    @SafeVarargs
    private static Group getContentModel(Supplier<? extends Group>... supplierArr) {
        return (Group) Stream.of((Object[]) supplierArr).map(new Function() { // from class: org.apache.xmlbeans.impl.schema.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (Group) ((Supplier) obj).get();
            }
        }).filter(new Predicate() { // from class: org.apache.xmlbeans.impl.schema.z1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((Group) obj);
            }
        }).findFirst().orElse(null);
    }

    private static int translateParticleCode(QName qName) {
        return particleCodeMap.getOrDefault(qName, 0).intValue();
    }
}
