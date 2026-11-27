package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.IntFunction;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;

/* loaded from: classes.dex */
public class StscResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static /* synthetic */ SchemaType.Ref[] a(int i2) {
        return new SchemaType.Ref[i2];
    }

    private static SchemaType.Ref[] makeRefArray(Collection<SchemaType> collection) {
        return (SchemaType.Ref[]) collection.stream().map(m2.a).toArray(new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.c1
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return StscResolver.a(i2);
            }
        });
    }

    public static void resolveAll() {
        StscState stscState = StscState.get();
        for (SchemaType schemaType : stscState.documentTypes()) {
            resolveSubstitutionGroup((SchemaTypeImpl) schemaType);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(stscState.documentTypes()));
        arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
        arrayList.addAll(Arrays.asList(stscState.redefinedGlobalTypes()));
        arrayList.addAll(Arrays.asList(stscState.globalTypes()));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            SchemaType schemaType2 = (SchemaType) arrayList.get(i2);
            resolveType((SchemaTypeImpl) schemaType2);
            arrayList.addAll(Arrays.asList(schemaType2.getAnonymousTypes()));
        }
        resolveIdentityConstraints();
    }

    public static void resolveAttributeType(SchemaTypeImpl schemaTypeImpl) {
        ArrayList arrayList = new ArrayList();
        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl) StscTranslator.translateAttribute((Attribute) schemaTypeImpl.getParseObject(), schemaTypeImpl.getTargetNamespace(), null, schemaTypeImpl.isChameleon(), arrayList, schemaTypeImpl, null, false);
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        if (schemaGlobalAttributeImpl != null) {
            StscState.get().addGlobalAttribute(schemaGlobalAttributeImpl);
            SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
            StscTranslator.copyGlobalAttributeToLocalAttribute(schemaGlobalAttributeImpl, schemaLocalAttributeImpl);
            schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
        }
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(1);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, Collections.EMPTY_MAP, StscComplexTypeResolver.buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl), false);
        QNameSet qNameSet = QNameSet.EMPTY;
        schemaTypeImpl.setWildcardSummary(qNameSet, false, qNameSet, false);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
    }

    public static void resolveDocumentType(SchemaTypeImpl schemaTypeImpl) {
        SchemaLocalElementImpl schemaLocalElementImpl;
        SchemaTypeImpl schemaTypeImplFindDocumentType;
        ArrayList arrayList = new ArrayList();
        SchemaGlobalElementImpl schemaGlobalElementImpl = (SchemaGlobalElementImpl) StscTranslator.translateElement((Element) schemaTypeImpl.getParseObject(), schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.isChameleon(), null, null, arrayList, schemaTypeImpl);
        if (schemaGlobalElementImpl != null) {
            StscState.get().addGlobalElement(schemaGlobalElementImpl);
            SchemaLocalElementImpl schemaLocalElementImpl2 = new SchemaLocalElementImpl();
            schemaLocalElementImpl2.setParticleType(4);
            StscTranslator.copyGlobalElementToLocalElement(schemaGlobalElementImpl, schemaLocalElementImpl2);
            BigInteger bigInteger = BigInteger.ONE;
            schemaLocalElementImpl2.setMinOccurs(bigInteger);
            schemaLocalElementImpl2.setMaxOccurs(bigInteger);
            schemaLocalElementImpl2.setTransitionNotes(QNameSet.EMPTY, true);
            schemaLocalElementImpl = schemaLocalElementImpl2;
        } else {
            schemaLocalElementImpl = null;
        }
        Map<QName, SchemaProperty> mapBuildContentPropertyModelByQName = StscComplexTypeResolver.buildContentPropertyModelByQName(schemaLocalElementImpl, schemaTypeImpl);
        if (schemaTypeImpl.getSubstitutionGroup() == null) {
            schemaTypeImplFindDocumentType = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        } else {
            schemaTypeImplFindDocumentType = StscState.get().findDocumentType(schemaTypeImpl.getSubstitutionGroup(), schemaTypeImpl.isChameleon() ? schemaTypeImpl.getTargetNamespace() : null, null);
        }
        schemaTypeImpl.setBaseTypeRef(schemaTypeImplFindDocumentType.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImplFindDocumentType.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(3);
        schemaTypeImpl.setContentModel(schemaLocalElementImpl, new SchemaAttributeModelImpl(), mapBuildContentPropertyModelByQName, Collections.EMPTY_MAP, false);
        QNameSet qNameSet = QNameSet.EMPTY;
        schemaTypeImpl.setWildcardSummary(qNameSet, false, qNameSet, false);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
    }

    public static void resolveIdentityConstraints() {
        StscState stscState = StscState.get();
        for (SchemaIdentityConstraintImpl schemaIdentityConstraintImpl : stscState.idConstraints()) {
            if (!schemaIdentityConstraintImpl.isResolved()) {
                KeyrefDocument.Keyref keyref = (KeyrefDocument.Keyref) schemaIdentityConstraintImpl.getParseObject();
                QName refer = keyref.getRefer();
                SchemaIdentityConstraintImpl schemaIdentityConstraintImplFindIdConstraint = stscState.findIdConstraint(refer, schemaIdentityConstraintImpl.getChameleonNamespace(), schemaIdentityConstraintImpl.getTargetNamespace());
                if (schemaIdentityConstraintImplFindIdConstraint == null) {
                    stscState.notFoundError(refer, 5, keyref, true);
                } else {
                    if (schemaIdentityConstraintImplFindIdConstraint.getConstraintCategory() == 2) {
                        stscState.error(XmlErrorCodes.IDENTITY_CONSTRAINT_PROPERTIES$KEYREF_REFERS_TO_KEYREF, (Object[]) null, schemaIdentityConstraintImpl.getParseObject());
                    }
                    if (schemaIdentityConstraintImplFindIdConstraint.getFields().length != schemaIdentityConstraintImpl.getFields().length) {
                        stscState.error(XmlErrorCodes.IDENTITY_CONSTRAINT_PROPERTIES$KEY_KEYREF_FIELD_COUNT_EQ, (Object[]) null, schemaIdentityConstraintImpl.getParseObject());
                    }
                    schemaIdentityConstraintImpl.setReferencedKey(schemaIdentityConstraintImplFindIdConstraint.getRef());
                }
            }
        }
    }

    /* JADX WARN: Path cross not found for [B:18:0x0071, B:11:0x003c], limit reached: 30 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0071 -> B:19:0x0072). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean resolveSubstitutionGroup(SchemaTypeImpl schemaTypeImpl) {
        SchemaTypeImpl schemaTypeImplFindDocumentType;
        if (schemaTypeImpl.isSGResolved()) {
            return true;
        }
        if (schemaTypeImpl.isSGResolving()) {
            StscState.get().error("Cyclic dependency error", 13, schemaTypeImpl.getParseObject());
            return false;
        }
        schemaTypeImpl.startResolvingSGs();
        TopLevelElement topLevelElement = (TopLevelElement) schemaTypeImpl.getParseObject();
        QName qName = new QName(schemaTypeImpl.getTargetNamespace(), topLevelElement.getName());
        if (topLevelElement.isSetSubstitutionGroup()) {
            schemaTypeImplFindDocumentType = StscState.get().findDocumentType(topLevelElement.getSubstitutionGroup(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
            if (schemaTypeImplFindDocumentType == null) {
                StscState.get().notFoundError(topLevelElement.getSubstitutionGroup(), 1, topLevelElement.xgetSubstitutionGroup(), true);
            } else if (resolveSubstitutionGroup(schemaTypeImplFindDocumentType)) {
                schemaTypeImpl.setSubstitutionGroup(topLevelElement.getSubstitutionGroup());
            }
            while (schemaTypeImplFindDocumentType != null) {
                schemaTypeImplFindDocumentType.addSubstitutionGroupMember(qName);
                if (schemaTypeImplFindDocumentType.getSubstitutionGroup() == null) {
                    break;
                }
                schemaTypeImplFindDocumentType = StscState.get().findDocumentType(schemaTypeImplFindDocumentType.getSubstitutionGroup(), schemaTypeImplFindDocumentType.getChameleonNamespace(), null);
                if (!resolveSubstitutionGroup(schemaTypeImplFindDocumentType)) {
                }
            }
            schemaTypeImpl.finishResolvingSGs();
            return true;
        }
        schemaTypeImplFindDocumentType = null;
        while (schemaTypeImplFindDocumentType != null) {
        }
        schemaTypeImpl.finishResolvingSGs();
        return true;
    }

    public static boolean resolveType(SchemaTypeImpl schemaTypeImpl) {
        if (schemaTypeImpl.isResolved()) {
            return true;
        }
        if (schemaTypeImpl.isResolving()) {
            StscState.get().error("Cyclic dependency error", 13, schemaTypeImpl.getParseObject());
            return false;
        }
        schemaTypeImpl.startResolving();
        if (schemaTypeImpl.isDocumentType()) {
            resolveDocumentType(schemaTypeImpl);
        } else if (schemaTypeImpl.isAttributeType()) {
            resolveAttributeType(schemaTypeImpl);
        } else if (schemaTypeImpl.isSimpleType()) {
            StscSimpleTypeResolver.resolveSimpleType(schemaTypeImpl);
        } else {
            StscComplexTypeResolver.resolveComplexType(schemaTypeImpl);
        }
        schemaTypeImpl.finishResolving();
        return true;
    }
}
