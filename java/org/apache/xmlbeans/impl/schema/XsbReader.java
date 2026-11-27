package org.apache.xmlbeans.impl.schema;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoaderException;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.schema.SchemaAnnotationImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;
import org.apache.xmlbeans.impl.schema.StscComplexTypeResolver;
import org.apache.xmlbeans.impl.util.LongUTFDataInputStream;
import org.apache.xmlbeans.impl.util.LongUTFDataOutputStream;
import org.apache.xmlbeans.impl.values.XmlObjectBase;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument;
import org.apache.xmlbeans.soap.SOAPArrayType;
import org.apache.xmlbeans.soap.SchemaWSDLArrayType;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
class XsbReader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_UNSIGNED_SHORT = 65535;
    int _actualfiletype;
    private String _handle;
    private LongUTFDataInputStream _input;
    private int _majorver;
    private int _minorver;
    private LongUTFDataOutputStream _output;
    private int _releaseno;
    private SchemaTypeSystemImpl.StringPool _stringPool;
    private final SchemaTypeSystemImpl typeSystem;

    XsbReader(SchemaTypeSystemImpl schemaTypeSystemImpl, String str) {
        this.typeSystem = schemaTypeSystemImpl;
        this._handle = str;
        this._stringPool = new SchemaTypeSystemImpl.StringPool(str, schemaTypeSystemImpl.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(String str, SchemaComponent.Ref ref) {
        writeString(str);
        writeHandle(((SchemaType.Ref) ref).get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(String str, String str2) {
        writeString(str);
        writeString(str2);
    }

    protected boolean atLeast(int i2, int i3, int i4) {
        int i5 = this._majorver;
        if (i5 > i2) {
            return true;
        }
        if (i5 < i2) {
            return false;
        }
        int i6 = this._minorver;
        if (i6 > i3) {
            return true;
        }
        return i6 >= i3 && this._releaseno >= i4;
    }

    protected boolean atMost(int i2, int i3, int i4) {
        int i5 = this._majorver;
        if (i5 > i2) {
            return false;
        }
        if (i5 < i2) {
            return true;
        }
        int i6 = this._minorver;
        if (i6 > i3) {
            return false;
        }
        return i6 < i3 || this._releaseno <= i4;
    }

    void checkContainerNotNull(SchemaContainer schemaContainer, QName qName) {
        if (schemaContainer != null) {
            return;
        }
        throw new LinkageError("Loading of resource " + qName + NameUtil.PERIOD + this._handle + "failed, information from " + qName + ".index.xsb is  out of sync (or conflicting index files found)");
    }

    public SchemaGlobalAttribute finishLoadingAttribute() {
        try {
            try {
                QName qName = readQName();
                SchemaContainer container = this.typeSystem.getContainer(qName.getNamespaceURI());
                checkContainerNotNull(container, qName);
                SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = new SchemaGlobalAttributeImpl(container);
                loadAttribute(schemaGlobalAttributeImpl, qName, container);
                schemaGlobalAttributeImpl.setFilename(readString());
                return schemaGlobalAttributeImpl;
            } catch (SchemaTypeLoaderException e) {
                throw e;
            } catch (Exception e2) {
                throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e2);
            }
        } finally {
            readEnd();
        }
    }

    SchemaAttributeGroup finishLoadingAttributeGroup() {
        QName qName = readQName();
        SchemaContainer container = this.typeSystem.getContainer(qName.getNamespaceURI());
        checkContainerNotNull(container, qName);
        SchemaAttributeGroupImpl schemaAttributeGroupImpl = new SchemaAttributeGroupImpl(container);
        try {
            try {
                schemaAttributeGroupImpl.init(qName, readString(), readShort() == 1, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 15, 0) && readShort() == 1, AttributeGroupDocument.Factory.parse(readString()).getAttributeGroup(), readAnnotation(container), null);
                if (atLeast(2, 21, 0)) {
                    schemaAttributeGroupImpl.setFilename(readString());
                }
                return schemaAttributeGroupImpl;
            } catch (SchemaTypeLoaderException e) {
                throw e;
            } catch (Exception e2) {
                throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e2);
            }
        } finally {
            readEnd();
        }
    }

    public SchemaGlobalElement finishLoadingElement() {
        try {
            try {
                int i2 = readShort();
                if (i2 != 4) {
                    throw new SchemaTypeLoaderException("Wrong particle type ", this.typeSystem.getName(), this._handle, 11);
                }
                int i3 = readShort();
                BigInteger bigInteger = readBigInteger();
                BigInteger bigInteger2 = readBigInteger();
                QNameSet qNameSet = readQNameSet();
                QName qName = readQName();
                SchemaContainer container = this.typeSystem.getContainer(qName.getNamespaceURI());
                checkContainerNotNull(container, qName);
                SchemaGlobalElementImpl schemaGlobalElementImpl = new SchemaGlobalElementImpl(container);
                schemaGlobalElementImpl.setParticleType(i2);
                schemaGlobalElementImpl.setMinOccurs(bigInteger);
                schemaGlobalElementImpl.setMaxOccurs(bigInteger2);
                boolean z = true;
                schemaGlobalElementImpl.setTransitionRules(qNameSet, (i3 & 1) != 0);
                schemaGlobalElementImpl.setNameAndTypeRef(qName, readTypeRef());
                schemaGlobalElementImpl.setDefault(readString(), (i3 & 4) != 0, null);
                if (atLeast(2, 16, 0)) {
                    schemaGlobalElementImpl.setDefaultValue(readXmlValueObject());
                }
                schemaGlobalElementImpl.setNillable((i3 & 8) != 0);
                schemaGlobalElementImpl.setBlock((i3 & 16) != 0, (i3 & 32) != 0, (i3 & 64) != 0);
                schemaGlobalElementImpl.setWsdlArrayType(readSOAPArrayType());
                schemaGlobalElementImpl.setAbstract((i3 & 128) != 0);
                schemaGlobalElementImpl.setAnnotation(readAnnotation(container));
                boolean z2 = (i3 & 256) != 0;
                if ((i3 & 512) == 0) {
                    z = false;
                }
                schemaGlobalElementImpl.setFinal(z2, z);
                if (atLeast(2, 17, 0)) {
                    schemaGlobalElementImpl.setSubstitutionGroup((SchemaGlobalElement.Ref) readHandle());
                }
                int i4 = readShort();
                for (int i5 = 0; i5 < i4; i5++) {
                    schemaGlobalElementImpl.addSubstitutionGroupMember(readQName());
                }
                int i6 = readShort();
                SchemaIdentityConstraint.Ref[] refArr = new SchemaIdentityConstraint.Ref[i6];
                for (int i7 = 0; i7 < i6; i7++) {
                    refArr[i7] = (SchemaIdentityConstraint.Ref) readHandle();
                }
                schemaGlobalElementImpl.setIdentityConstraints(refArr);
                schemaGlobalElementImpl.setFilename(readString());
                return schemaGlobalElementImpl;
            } catch (SchemaTypeLoaderException e) {
                throw e;
            } catch (Exception e2) {
                throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), null, 14, e2);
            }
        } finally {
            readEnd();
        }
    }

    SchemaIdentityConstraint finishLoadingIdentityConstraint() {
        try {
            try {
                QName qName = readQName();
                SchemaContainer container = this.typeSystem.getContainer(qName.getNamespaceURI());
                checkContainerNotNull(container, qName);
                SchemaIdentityConstraintImpl schemaIdentityConstraintImpl = new SchemaIdentityConstraintImpl(container);
                schemaIdentityConstraintImpl.setName(qName);
                schemaIdentityConstraintImpl.setConstraintCategory(readShort());
                schemaIdentityConstraintImpl.setSelector(readString());
                schemaIdentityConstraintImpl.setAnnotation(readAnnotation(container));
                int i2 = readShort();
                String[] strArr = new String[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    strArr[i3] = readString();
                }
                schemaIdentityConstraintImpl.setFields(strArr);
                if (schemaIdentityConstraintImpl.getConstraintCategory() == 2) {
                    schemaIdentityConstraintImpl.setReferencedKey((SchemaIdentityConstraint.Ref) readHandle());
                }
                int i4 = readShort();
                HashMap map = new HashMap();
                for (int i5 = 0; i5 < i4; i5++) {
                    map.put(readString(), readString());
                }
                schemaIdentityConstraintImpl.setNSMap(map);
                if (atLeast(2, 21, 0)) {
                    schemaIdentityConstraintImpl.setFilename(readString());
                }
                return schemaIdentityConstraintImpl;
            } catch (SchemaTypeLoaderException e) {
                throw e;
            } catch (Exception e2) {
                throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e2);
            }
        } finally {
            readEnd();
        }
    }

    SchemaModelGroup finishLoadingModelGroup() {
        QName qName = readQName();
        SchemaContainer container = this.typeSystem.getContainer(qName.getNamespaceURI());
        checkContainerNotNull(container, qName);
        SchemaModelGroupImpl schemaModelGroupImpl = new SchemaModelGroupImpl(container);
        try {
            try {
                try {
                    schemaModelGroupImpl.init(qName, readString(), readShort() == 1, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 15, 0) && readShort() == 1, GroupDocument.Factory.parse(readString()).getGroup(), readAnnotation(container), null);
                    if (atLeast(2, 21, 0)) {
                        schemaModelGroupImpl.setFilename(readString());
                    }
                    return schemaModelGroupImpl;
                } catch (Exception e) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e);
                }
            } catch (SchemaTypeLoaderException e2) {
                throw e2;
            }
        } finally {
            readEnd();
        }
    }

    public SchemaType finishLoadingType() {
        int i2;
        QName attributeTypeAttributeName;
        int i3;
        SchemaParticle schemaParticle;
        LinkedHashMap linkedHashMap;
        SchemaParticle schemaParticle2;
        int i4;
        String str = "";
        try {
            try {
                int i5 = 1;
                SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(this.typeSystem.getContainerNonNull(""), true);
                schemaTypeImpl.setName(readQName());
                schemaTypeImpl.setOuterSchemaTypeRef(readTypeRef());
                schemaTypeImpl.setBaseDepth(readShort());
                schemaTypeImpl.setBaseTypeRef(readTypeRef());
                schemaTypeImpl.setDerivationType(readShort());
                schemaTypeImpl.setAnnotation(readAnnotation(null));
                int i6 = readShort();
                if (i6 == 1) {
                    schemaTypeImpl.setContainerFieldRef(readHandle());
                } else if (i6 == 2) {
                    schemaTypeImpl.setContainerFieldIndex((short) 1, readShort());
                } else if (i6 == 3) {
                    schemaTypeImpl.setContainerFieldIndex((short) 2, readShort());
                }
                String string = readString();
                if (string == null) {
                    string = "";
                }
                schemaTypeImpl.setFullJavaName(string);
                String string2 = readString();
                if (string2 != null) {
                    str = string2;
                }
                schemaTypeImpl.setFullJavaImplName(str);
                schemaTypeImpl.setAnonymousTypeRefs(readTypeRefArray());
                schemaTypeImpl.setAnonymousUnionMemberOrdinal(readShort());
                int i7 = readInt();
                boolean z = (i7 & 1) == 0;
                schemaTypeImpl.setCompiled((i7 & 2048) != 0);
                schemaTypeImpl.setDocumentType((i7 & 2) != 0);
                schemaTypeImpl.setAttributeType((524288 & i7) != 0);
                schemaTypeImpl.setSimpleType(!z);
                if (z) {
                    schemaTypeImpl.setAbstractFinal((262144 & i7) != 0, (i7 & 16384) != 0, (i7 & 32768) != 0, (i7 & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0, (i7 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0);
                    schemaTypeImpl.setBlock((i7 & XMLEvent.CHANGE_PREFIX_MAPPING) != 0, (i7 & XMLEvent.ENTITY_REFERENCE) != 0);
                    schemaTypeImpl.setOrderSensitive((i7 & 512) != 0);
                    int i8 = readShort();
                    schemaTypeImpl.setComplexTypeVariety(i8);
                    if (atLeast(2, 23, 0)) {
                        schemaTypeImpl.setContentBasedOnTypeRef(readTypeRef());
                    }
                    SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
                    int i9 = readShort();
                    for (int i10 = 0; i10 < i9; i10++) {
                        schemaAttributeModelImpl.addAttribute(readAttributeData());
                    }
                    schemaAttributeModelImpl.setWildcardSet(readQNameSet());
                    schemaAttributeModelImpl.setWildcardProcess(readShort());
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    int i11 = readShort();
                    for (int i12 = 0; i12 < i11; i12++) {
                        SchemaProperty propertyData = readPropertyData();
                        if (!propertyData.isAttribute()) {
                            throw new SchemaTypeLoaderException("Attribute property " + i12 + " is not an attribute", this.typeSystem.getName(), this._handle, 6);
                        }
                        linkedHashMap2.put(propertyData.getName(), propertyData);
                    }
                    if (i8 == 3 || i8 == 4) {
                        i3 = readShort();
                        SchemaParticle[] particleArray = readParticleArray();
                        if (particleArray.length == 1) {
                            schemaParticle = particleArray[0];
                        } else {
                            if (particleArray.length != 0) {
                                throw new SchemaTypeLoaderException("Content model not well-formed", this.typeSystem.getName(), this._handle, 7);
                            }
                            schemaParticle = null;
                        }
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                        int i13 = readShort();
                        int i14 = 0;
                        while (i14 < i13) {
                            SchemaProperty propertyData2 = readPropertyData();
                            if (propertyData2.isAttribute()) {
                                throw new SchemaTypeLoaderException("Element property " + i14 + " is not an element", this.typeSystem.getName(), this._handle, 6);
                            }
                            linkedHashMap3.put(propertyData2.getName(), propertyData2);
                            i14++;
                            i5 = 1;
                        }
                        linkedHashMap = linkedHashMap3;
                        int i15 = i5;
                        schemaParticle2 = schemaParticle;
                        i4 = i15;
                    } else {
                        i4 = 1;
                        i3 = 0;
                        schemaParticle2 = null;
                        linkedHashMap = null;
                    }
                    schemaTypeImpl.setContentModel(schemaParticle2, schemaAttributeModelImpl, linkedHashMap, linkedHashMap2, i3 == i4);
                    StscComplexTypeResolver.WildcardResult wildcardResultSummarizeEltWildcards = StscComplexTypeResolver.summarizeEltWildcards(schemaParticle2);
                    StscComplexTypeResolver.WildcardResult wildcardResultSummarizeAttrWildcards = StscComplexTypeResolver.summarizeAttrWildcards(schemaAttributeModelImpl);
                    schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
                    i2 = i8;
                } else {
                    i2 = 0;
                }
                if (!z || i2 == 2) {
                    int i16 = readShort();
                    schemaTypeImpl.setSimpleTypeVariety(i16);
                    boolean z2 = (i7 & 64) != 0;
                    schemaTypeImpl.setOrdered((i7 & 4) != 0 ? 0 : (i7 & 1024) != 0 ? 2 : 1);
                    schemaTypeImpl.setBounded((i7 & 8) != 0);
                    schemaTypeImpl.setFinite((i7 & 16) != 0);
                    schemaTypeImpl.setNumeric((i7 & 32) != 0);
                    schemaTypeImpl.setUnionOfLists((i7 & 128) != 0);
                    schemaTypeImpl.setSimpleFinal((i7 & 32768) != 0, (i7 & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0, (i7 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0);
                    XmlValueRef[] xmlValueRefArr = new XmlValueRef[12];
                    boolean[] zArr = new boolean[12];
                    int i17 = readShort();
                    for (int i18 = 0; i18 < i17; i18++) {
                        int i19 = readShort();
                        xmlValueRefArr[i19] = readXmlValueObject();
                        zArr[i19] = readShort() == 1;
                    }
                    schemaTypeImpl.setBasicFacets(xmlValueRefArr, zArr);
                    schemaTypeImpl.setWhiteSpaceRule(readShort());
                    schemaTypeImpl.setPatternFacet((i7 & 256) != 0);
                    int i20 = readShort();
                    RegularExpression[] regularExpressionArr = new RegularExpression[i20];
                    for (int i21 = 0; i21 < i20; i21++) {
                        regularExpressionArr[i21] = new RegularExpression(readString(), "X");
                    }
                    schemaTypeImpl.setPatterns(regularExpressionArr);
                    int i22 = readShort();
                    XmlValueRef[] xmlValueRefArr2 = new XmlValueRef[i22];
                    for (int i23 = 0; i23 < i22; i23++) {
                        xmlValueRefArr2[i23] = readXmlValueObject();
                    }
                    if (i22 == 0) {
                        xmlValueRefArr2 = null;
                    }
                    schemaTypeImpl.setEnumerationValues(xmlValueRefArr2);
                    schemaTypeImpl.setBaseEnumTypeRef(readTypeRef());
                    if (z2) {
                        int unsignedShortOrInt = readUnsignedShortOrInt();
                        SchemaStringEnumEntry[] schemaStringEnumEntryArr = new SchemaStringEnumEntry[unsignedShortOrInt];
                        for (int i24 = 0; i24 < unsignedShortOrInt; i24++) {
                            schemaStringEnumEntryArr[i24] = new SchemaStringEnumEntryImpl(readString(), readShort(), readString());
                        }
                        schemaTypeImpl.setStringEnumEntries(schemaStringEnumEntryArr);
                    }
                    if (i16 == 1) {
                        schemaTypeImpl.setPrimitiveTypeRef(readTypeRef());
                        schemaTypeImpl.setDecimalSize(readInt());
                    } else if (i16 == 2) {
                        schemaTypeImpl.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
                        schemaTypeImpl.setUnionMemberTypeRefs(readTypeRefArray());
                    } else {
                        if (i16 != 3) {
                            throw new SchemaTypeLoaderException("Simple type does not have a recognized variety", this.typeSystem.getName(), this._handle, 8);
                        }
                        schemaTypeImpl.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
                        schemaTypeImpl.setListItemTypeRef(readTypeRef());
                    }
                }
                schemaTypeImpl.setFilename(readString());
                if (schemaTypeImpl.getName() != null) {
                    SchemaContainer container = this.typeSystem.getContainer(schemaTypeImpl.getName().getNamespaceURI());
                    checkContainerNotNull(container, schemaTypeImpl.getName());
                    schemaTypeImpl.setContainer(container);
                } else if (schemaTypeImpl.isDocumentType()) {
                    QName documentElementName = schemaTypeImpl.getDocumentElementName();
                    if (documentElementName != null) {
                        SchemaContainer container2 = this.typeSystem.getContainer(documentElementName.getNamespaceURI());
                        checkContainerNotNull(container2, documentElementName);
                        schemaTypeImpl.setContainer(container2);
                    }
                } else if (schemaTypeImpl.isAttributeType() && (attributeTypeAttributeName = schemaTypeImpl.getAttributeTypeAttributeName()) != null) {
                    SchemaContainer container3 = this.typeSystem.getContainer(attributeTypeAttributeName.getNamespaceURI());
                    checkContainerNotNull(container3, attributeTypeAttributeName);
                    schemaTypeImpl.setContainer(container3);
                }
                readEnd();
                return schemaTypeImpl;
            } catch (SchemaTypeLoaderException e) {
                throw e;
            } catch (Exception e2) {
                throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e2);
            }
        } catch (Throwable th) {
            readEnd();
            throw th;
        }
    }

    int getActualFiletype() {
        return this._actualfiletype;
    }

    void loadAttribute(SchemaLocalAttributeImpl schemaLocalAttributeImpl, QName qName, SchemaContainer schemaContainer) {
        schemaLocalAttributeImpl.init(qName, readTypeRef(), readShort(), readString(), null, atLeast(2, 16, 0) ? readXmlValueObject() : null, readShort() == 1, readSOAPArrayType(), readAnnotation(schemaContainer), null);
    }

    void loadParticle(SchemaParticleImpl schemaParticleImpl, int i2) {
        int i3 = readShort();
        schemaParticleImpl.setParticleType(i2);
        schemaParticleImpl.setMinOccurs(readBigInteger());
        schemaParticleImpl.setMaxOccurs(readBigInteger());
        schemaParticleImpl.setTransitionRules(readQNameSet(), (i3 & 1) != 0);
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            schemaParticleImpl.setParticleChildren(readParticleArray());
            return;
        }
        if (i2 != 4) {
            if (i2 != 5) {
                throw new SchemaTypeLoaderException("Unrecognized particle type ", this.typeSystem.getName(), this._handle, 11);
            }
            schemaParticleImpl.setWildcardSet(readQNameSet());
            schemaParticleImpl.setWildcardProcess(readShort());
            return;
        }
        SchemaLocalElementImpl schemaLocalElementImpl = (SchemaLocalElementImpl) schemaParticleImpl;
        schemaLocalElementImpl.setNameAndTypeRef(readQName(), readTypeRef());
        schemaLocalElementImpl.setDefault(readString(), (i3 & 4) != 0, null);
        if (atLeast(2, 16, 0)) {
            schemaLocalElementImpl.setDefaultValue(readXmlValueObject());
        }
        schemaLocalElementImpl.setNillable((i3 & 8) != 0);
        schemaLocalElementImpl.setBlock((i3 & 16) != 0, (i3 & 32) != 0, (i3 & 64) != 0);
        schemaLocalElementImpl.setWsdlArrayType(readSOAPArrayType());
        schemaLocalElementImpl.setAbstract((i3 & 128) != 0);
        schemaLocalElementImpl.setAnnotation(readAnnotation(null));
        int i4 = readShort();
        SchemaIdentityConstraint.Ref[] refArr = new SchemaIdentityConstraint.Ref[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            refArr[i5] = (SchemaIdentityConstraint.Ref) readHandle();
        }
        schemaLocalElementImpl.setIdentityConstraints(refArr);
    }

    SchemaAnnotation readAnnotation(SchemaContainer schemaContainer) {
        int i2;
        if (!atLeast(2, 19, 0) || (i2 = readInt()) == -1) {
            return null;
        }
        SchemaAnnotation.Attribute[] attributeArr = new SchemaAnnotation.Attribute[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            attributeArr[i3] = new SchemaAnnotationImpl.AttributeImpl(readQName(), readString(), atLeast(2, 24, 0) ? readString() : null);
        }
        int i4 = readInt();
        String[] strArr = new String[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            strArr[i5] = readString();
        }
        int i6 = readInt();
        String[] strArr2 = new String[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            strArr2[i7] = readString();
        }
        return new SchemaAnnotationImpl(schemaContainer, strArr2, strArr, attributeArr);
    }

    List<SchemaAnnotation> readAnnotations() {
        int i2 = readInt();
        ArrayList arrayList = new ArrayList(i2);
        SchemaContainer containerNonNull = this.typeSystem.getContainerNonNull("");
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(readAnnotation(containerNonNull));
        }
        return arrayList;
    }

    SchemaLocalAttribute readAttributeData() {
        SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
        loadAttribute(schemaLocalAttributeImpl, readQName(), null);
        return schemaLocalAttributeImpl;
    }

    BigInteger readBigInteger() throws IOException {
        byte[] byteArray = readByteArray();
        if (byteArray.length == 0) {
            return null;
        }
        return (byteArray.length == 1 && byteArray[0] == 0) ? BigInteger.ZERO : (byteArray.length == 1 && byteArray[0] == 1) ? BigInteger.ONE : new BigInteger(byteArray);
    }

    byte[] readByteArray() throws IOException {
        try {
            byte[] bArr = new byte[this._input.readShort()];
            this._input.readFully(bArr);
            return bArr;
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    Map<String, SchemaComponent.Ref> readClassnameRefMap() {
        HashMap map = new HashMap();
        int i2 = readShort();
        for (int i3 = 0; i3 < i2; i3++) {
            map.put(readString(), readHandle());
        }
        return map;
    }

    double readDouble() {
        try {
            return this._input.readDouble();
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    void readEnd() {
        try {
            LongUTFDataInputStream longUTFDataInputStream = this._input;
            if (longUTFDataInputStream != null) {
                longUTFDataInputStream.close();
            }
        } catch (IOException unused) {
        }
        this._input = null;
        this._stringPool = null;
        this._handle = null;
    }

    SchemaComponent.Ref readHandle() {
        String string = readString();
        if (string == null) {
            return null;
        }
        if (string.charAt(0) != '_') {
            return this.typeSystem.getTypePool().refForHandle(string);
        }
        char cCharAt = string.charAt(2);
        if (cCharAt == 'A') {
            return this.typeSystem.getLinker().findAttributeRef(QNameHelper.forPretty(string, 4));
        }
        if (cCharAt == 'I') {
            SchemaType schemaType = (SchemaType) BuiltinSchemaTypeSystem.get().resolveHandle(string);
            return schemaType != null ? schemaType.getRef() : ((SchemaType) XQuerySchemaTypeSystem.get().resolveHandle(string)).getRef();
        }
        if (cCharAt == 'Y') {
            SchemaType schemaTypeTypeForSignature = this.typeSystem.getLinker().typeForSignature(string.substring(4));
            if (schemaTypeTypeForSignature != null) {
                return schemaTypeTypeForSignature.getRef();
            }
            throw new SchemaTypeLoaderException("Cannot resolve type for handle " + string, this.typeSystem.getName(), this._handle, 13);
        }
        if (cCharAt == 'D') {
            return this.typeSystem.getLinker().findIdentityConstraintRef(QNameHelper.forPretty(string, 4));
        }
        if (cCharAt == 'E') {
            return this.typeSystem.getLinker().findElementRef(QNameHelper.forPretty(string, 4));
        }
        switch (cCharAt) {
            case 'M':
                return this.typeSystem.getLinker().findModelGroupRef(QNameHelper.forPretty(string, 4));
            case 'N':
                return this.typeSystem.getLinker().findAttributeGroupRef(QNameHelper.forPretty(string, 4));
            case 'O':
                return this.typeSystem.getLinker().findDocumentTypeRef(QNameHelper.forPretty(string, 4));
            default:
                switch (cCharAt) {
                    case 'R':
                        SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = this.typeSystem.getLinker().findAttribute(QNameHelper.forPretty(string, 4));
                        if (schemaGlobalAttributeFindAttribute != null) {
                            return schemaGlobalAttributeFindAttribute.getType().getRef();
                        }
                        throw new SchemaTypeLoaderException("Cannot resolve attribute for handle " + string, this.typeSystem.getName(), this._handle, 13);
                    case 'S':
                        SchemaGlobalElement schemaGlobalElementFindElement = this.typeSystem.getLinker().findElement(QNameHelper.forPretty(string, 4));
                        if (schemaGlobalElementFindElement != null) {
                            return schemaGlobalElementFindElement.getType().getRef();
                        }
                        throw new SchemaTypeLoaderException("Cannot resolve element for handle " + string, this.typeSystem.getName(), this._handle, 13);
                    case 'T':
                        return this.typeSystem.getLinker().findTypeRef(QNameHelper.forPretty(string, 4));
                    default:
                        throw new SchemaTypeLoaderException("Cannot resolve handle " + string, this.typeSystem.getName(), this._handle, 13);
                }
        }
    }

    int readInt() {
        try {
            return this._input.readInt();
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    Set<String> readNamespaces() {
        HashSet hashSet = new HashSet();
        int i2 = readShort();
        for (int i3 = 0; i3 < i2; i3++) {
            hashSet.add(readString());
        }
        return hashSet;
    }

    SchemaParticle[] readParticleArray() {
        int i2 = readShort();
        SchemaParticle[] schemaParticleArr = new SchemaParticle[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            schemaParticleArr[i3] = readParticleData();
        }
        return schemaParticleArr;
    }

    SchemaParticle readParticleData() {
        int i2 = readShort();
        SchemaParticleImpl schemaParticleImpl = i2 != 4 ? new SchemaParticleImpl() : new SchemaLocalElementImpl();
        loadParticle(schemaParticleImpl, i2);
        return schemaParticleImpl;
    }

    SchemaProperty readPropertyData() {
        SchemaPropertyImpl schemaPropertyImpl = new SchemaPropertyImpl();
        schemaPropertyImpl.setName(readQName());
        schemaPropertyImpl.setTypeRef(readTypeRef());
        int i2 = readShort();
        schemaPropertyImpl.setAttribute((i2 & 1) != 0);
        schemaPropertyImpl.setContainerTypeRef(readTypeRef());
        schemaPropertyImpl.setMinOccurs(readBigInteger());
        schemaPropertyImpl.setMaxOccurs(readBigInteger());
        schemaPropertyImpl.setNillable(readShort());
        schemaPropertyImpl.setDefault(readShort());
        schemaPropertyImpl.setFixed(readShort());
        schemaPropertyImpl.setDefaultText(readString());
        schemaPropertyImpl.setJavaPropertyName(readString());
        schemaPropertyImpl.setJavaTypeCode(readShort());
        schemaPropertyImpl.setExtendsJava(readTypeRef(), (i2 & 2) != 0, (i2 & 4) != 0, (i2 & 8) != 0);
        if (atMost(2, 19, 0)) {
            schemaPropertyImpl.setJavaSetterDelimiter(readQNameSet());
        }
        if (atLeast(2, 16, 0)) {
            schemaPropertyImpl.setDefaultValue(readXmlValueObject());
        }
        if (!schemaPropertyImpl.isAttribute() && atLeast(2, 17, 0)) {
            int i3 = readShort();
            LinkedHashSet linkedHashSet = new LinkedHashSet(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                linkedHashSet.add(readQName());
            }
            schemaPropertyImpl.setAcceptedNames(linkedHashSet);
        }
        schemaPropertyImpl.setImmutable();
        return schemaPropertyImpl;
    }

    QName readQName() {
        String string = readString();
        String string2 = readString();
        if (string2 == null) {
            return null;
        }
        return new QName(string, string2);
    }

    Map<QName, SchemaComponent.Ref> readQNameRefMap() {
        HashMap map = new HashMap();
        int i2 = readShort();
        for (int i3 = 0; i3 < i2; i3++) {
            map.put(readQName(), readHandle());
        }
        return map;
    }

    List<SchemaComponent.Ref> readQNameRefMapAsList(List<QName> list) {
        int i2 = readShort();
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            QName qName = readQName();
            arrayList.add(readHandle());
            list.add(qName);
        }
        return arrayList;
    }

    QNameSet readQNameSet() {
        int i2 = readShort();
        HashSet hashSet = new HashSet();
        int i3 = readShort();
        for (int i4 = 0; i4 < i3; i4++) {
            hashSet.add(readString());
        }
        HashSet hashSet2 = new HashSet();
        int i5 = readShort();
        for (int i6 = 0; i6 < i5; i6++) {
            hashSet2.add(readQName());
        }
        HashSet hashSet3 = new HashSet();
        int i7 = readShort();
        for (int i8 = 0; i8 < i7; i8++) {
            hashSet3.add(readQName());
        }
        return i2 == 1 ? QNameSet.forSets(hashSet, null, hashSet2, hashSet3) : QNameSet.forSets(null, hashSet, hashSet3, hashSet2);
    }

    SOAPArrayType readSOAPArrayType() {
        QName qName = readQName();
        String string = readString();
        if (qName == null) {
            return null;
        }
        return new SOAPArrayType(qName, string);
    }

    int readShort() {
        try {
            return this._input.readUnsignedShort();
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    String readString() {
        return this._stringPool.stringForCode(readUnsignedShortOrInt());
    }

    SchemaType.Ref readTypeRef() {
        return (SchemaType.Ref) readHandle();
    }

    SchemaType.Ref[] readTypeRefArray() {
        int i2 = readShort();
        SchemaType.Ref[] refArr = new SchemaType.Ref[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            refArr[i3] = readTypeRef();
        }
        return refArr;
    }

    int readUnsignedShortOrInt() {
        try {
            return this._input.readUnsignedShortOrInt();
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    XmlValueRef readXmlValueObject() {
        SchemaType.Ref typeRef = readTypeRef();
        if (typeRef == null) {
            return null;
        }
        int i2 = readShort();
        if (i2 != 0) {
            if (i2 != MAX_UNSIGNED_SHORT) {
                switch (i2) {
                    case 2:
                    case 3:
                    case 6:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        return new XmlValueRef(typeRef, readString());
                    case 4:
                    case 5:
                        return new XmlValueRef(typeRef, readByteArray());
                    case 7:
                    case 8:
                        return new XmlValueRef(typeRef, readQName());
                    case 9:
                    case 10:
                        return new XmlValueRef(typeRef, Double.valueOf(readDouble()));
                }
            }
            int i3 = readShort();
            ArrayList arrayList = new ArrayList();
            writeShort(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList.add(readXmlValueObject());
            }
            return new XmlValueRef(typeRef, arrayList);
        }
        return new XmlValueRef(typeRef, null);
    }

    void writeAnnotation(SchemaAnnotation schemaAnnotation) throws IOException {
        if (schemaAnnotation == null) {
            writeInt(-1);
            return;
        }
        SchemaAnnotation.Attribute[] attributes = schemaAnnotation.getAttributes();
        writeInt(attributes.length);
        for (SchemaAnnotation.Attribute attribute : attributes) {
            QName name = attribute.getName();
            String value = attribute.getValue();
            String valueUri = attribute.getValueUri();
            writeQName(name);
            writeString(value);
            writeString(valueUri);
        }
        XmlObject[] userInformation = schemaAnnotation.getUserInformation();
        writeInt(userInformation.length);
        XmlOptions saveAggressiveNamespaces = new XmlOptions().setSaveOuter().setSaveAggressiveNamespaces();
        for (XmlObject xmlObject : userInformation) {
            writeString(xmlObject.xmlText(saveAggressiveNamespaces));
        }
        XmlObject[] applicationInformation = schemaAnnotation.getApplicationInformation();
        writeInt(applicationInformation.length);
        for (XmlObject xmlObject2 : applicationInformation) {
            writeString(xmlObject2.xmlText(saveAggressiveNamespaces));
        }
    }

    void writeAnnotations(SchemaAnnotation[] schemaAnnotationArr) throws IOException {
        writeInt(schemaAnnotationArr.length);
        for (SchemaAnnotation schemaAnnotation : schemaAnnotationArr) {
            writeAnnotation(schemaAnnotation);
        }
    }

    void writeAttributeData(SchemaLocalAttribute schemaLocalAttribute) {
        writeQName(schemaLocalAttribute.getName());
        writeType(schemaLocalAttribute.getType());
        writeShort(schemaLocalAttribute.getUse());
        writeString(schemaLocalAttribute.getDefaultText());
        writeXmlValueObject(schemaLocalAttribute.getDefaultValue());
        writeShort(schemaLocalAttribute.isFixed() ? 1 : 0);
        writeSOAPArrayType(((SchemaWSDLArrayType) schemaLocalAttribute).getWSDLArrayType());
        writeAnnotation(schemaLocalAttribute.getAnnotation());
    }

    void writeAttributeGroupData(SchemaAttributeGroup schemaAttributeGroup) {
        SchemaAttributeGroupImpl schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) schemaAttributeGroup;
        writeQName(schemaAttributeGroupImpl.getName());
        writeString(schemaAttributeGroupImpl.getTargetNamespace());
        writeShort(schemaAttributeGroupImpl.getChameleonNamespace() != null ? 1 : 0);
        writeString(schemaAttributeGroupImpl.getFormDefault());
        writeShort(schemaAttributeGroupImpl.isRedefinition() ? 1 : 0);
        writeString(schemaAttributeGroupImpl.getParseObject().xmlText(new XmlOptions().setSaveOuter()));
        writeAnnotation(schemaAttributeGroupImpl.getAnnotation());
        writeString(schemaAttributeGroupImpl.getSourceName());
    }

    void writeAttributeTypeMap(SchemaType[] schemaTypeArr) {
        writeShort(schemaTypeArr.length);
        for (SchemaType schemaType : schemaTypeArr) {
            writeQName(schemaType.getAttributeTypeAttributeName());
            writeHandle(schemaType);
        }
    }

    void writeBigInteger(BigInteger bigInteger) {
        if (bigInteger == null) {
            writeShort(0);
        } else if (bigInteger.signum() == 0) {
            writeByteArray(SchemaTypeSystemImpl.SINGLE_ZERO_BYTE);
        } else {
            writeByteArray(bigInteger.toByteArray());
        }
    }

    void writeByteArray(byte[] bArr) {
        try {
            writeShort(bArr.length);
            LongUTFDataOutputStream longUTFDataOutputStream = this._output;
            if (longUTFDataOutputStream != null) {
                longUTFDataOutputStream.write(bArr);
            }
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    void writeClassnameMap(Map<String, SchemaComponent.Ref> map) {
        writeShort(map.size());
        map.forEach(new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.s1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.a.b((String) obj, (SchemaComponent.Ref) obj2);
            }
        });
    }

    void writeDocumentTypeMap(SchemaType[] schemaTypeArr) {
        writeShort(schemaTypeArr.length);
        for (SchemaType schemaType : schemaTypeArr) {
            writeQName(schemaType.getDocumentElementName());
            writeHandle(schemaType);
        }
    }

    void writeDouble(double d) throws IOException {
        LongUTFDataOutputStream longUTFDataOutputStream = this._output;
        if (longUTFDataOutputStream != null) {
            try {
                longUTFDataOutputStream.writeDouble(d);
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
            }
        }
    }

    void writeEnd() {
        try {
            LongUTFDataOutputStream longUTFDataOutputStream = this._output;
            if (longUTFDataOutputStream != null) {
                longUTFDataOutputStream.flush();
                this._output.close();
            }
            this._output = null;
            this._stringPool = null;
            this._handle = null;
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    void writeHandle(SchemaComponent schemaComponent) {
        if (schemaComponent == null || schemaComponent.getTypeSystem() == this.typeSystem) {
            writeString(this.typeSystem.getTypePool().handleForComponent(schemaComponent));
            return;
        }
        int componentType = schemaComponent.getComponentType();
        if (componentType == 0) {
            SchemaType schemaType = (SchemaType) schemaComponent;
            if (schemaType.isBuiltinType()) {
                writeString("_BI_" + schemaType.getName().getLocalPart());
                return;
            }
            if (schemaType.getName() != null) {
                writeString("_XT_" + QNameHelper.pretty(schemaType.getName()));
                return;
            }
            if (schemaType.isDocumentType()) {
                writeString("_XO_" + QNameHelper.pretty(schemaType.getDocumentElementName()));
                return;
            }
            writeString("_XY_" + schemaType);
            return;
        }
        if (componentType == 1) {
            writeString("_XE_" + QNameHelper.pretty(schemaComponent.getName()));
            return;
        }
        if (componentType == 3) {
            writeString("_XA_" + QNameHelper.pretty(schemaComponent.getName()));
            return;
        }
        if (componentType == 4) {
            writeString("_XN_" + QNameHelper.pretty(schemaComponent.getName()));
            return;
        }
        if (componentType == 5) {
            writeString("_XD_" + QNameHelper.pretty(schemaComponent.getName()));
            return;
        }
        if (componentType != 6) {
            throw new SchemaTypeLoaderException("Cannot write handle for component " + schemaComponent, this.typeSystem.getName(), this._handle, 13);
        }
        writeString("_XM_" + QNameHelper.pretty(schemaComponent.getName()));
    }

    void writeIdConstraintData(SchemaIdentityConstraint schemaIdentityConstraint) {
        writeQName(schemaIdentityConstraint.getName());
        writeShort(schemaIdentityConstraint.getConstraintCategory());
        writeString(schemaIdentityConstraint.getSelector());
        writeAnnotation(schemaIdentityConstraint.getAnnotation());
        String[] fields = schemaIdentityConstraint.getFields();
        writeShort(fields.length);
        for (String str : fields) {
            writeString(str);
        }
        if (schemaIdentityConstraint.getConstraintCategory() == 2) {
            writeHandle(schemaIdentityConstraint.getReferencedKey());
        }
        Map<String, String> nSMap = schemaIdentityConstraint.getNSMap();
        writeShort(nSMap.size());
        nSMap.forEach(new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.r1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.a.d((String) obj, (String) obj2);
            }
        });
        writeString(schemaIdentityConstraint.getSourceName());
    }

    void writeIndexData() {
        this.typeSystem.getTypePool().writeHandlePool(this);
        writeQNameMap(this.typeSystem.globalElements());
        writeQNameMap(this.typeSystem.globalAttributes());
        writeQNameMap(this.typeSystem.modelGroups());
        writeQNameMap(this.typeSystem.attributeGroups());
        writeQNameMap(this.typeSystem.identityConstraints());
        writeQNameMap(this.typeSystem.globalTypes());
        writeDocumentTypeMap(this.typeSystem.documentTypes());
        writeAttributeTypeMap(this.typeSystem.attributeTypes());
        writeClassnameMap(this.typeSystem.getTypeRefsByClassname());
        writeNamespaces(this.typeSystem.getNamespaces());
        writeQNameMap(this.typeSystem.redefinedGlobalTypes());
        writeQNameMap(this.typeSystem.redefinedModelGroups());
        writeQNameMap(this.typeSystem.redefinedAttributeGroups());
        writeAnnotations(this.typeSystem.annotations());
    }

    void writeInt(int i2) throws IOException {
        LongUTFDataOutputStream longUTFDataOutputStream = this._output;
        if (longUTFDataOutputStream != null) {
            try {
                longUTFDataOutputStream.writeInt(i2);
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
            }
        }
    }

    void writeModelGroupData(SchemaModelGroup schemaModelGroup) {
        SchemaModelGroupImpl schemaModelGroupImpl = (SchemaModelGroupImpl) schemaModelGroup;
        writeQName(schemaModelGroupImpl.getName());
        writeString(schemaModelGroupImpl.getTargetNamespace());
        writeShort(schemaModelGroupImpl.getChameleonNamespace() != null ? 1 : 0);
        writeString(schemaModelGroupImpl.getElemFormDefault());
        writeString(schemaModelGroupImpl.getAttFormDefault());
        writeShort(schemaModelGroupImpl.isRedefinition() ? 1 : 0);
        writeString(schemaModelGroupImpl.getParseObject().xmlText(new XmlOptions().setSaveOuter()));
        writeAnnotation(schemaModelGroupImpl.getAnnotation());
        writeString(schemaModelGroupImpl.getSourceName());
    }

    void writeNamespaces(Set<String> set) {
        writeShort(set.size());
        set.forEach(new f(this));
    }

    void writeParticleArray(SchemaParticle[] schemaParticleArr) {
        writeShort(schemaParticleArr.length);
        for (SchemaParticle schemaParticle : schemaParticleArr) {
            writeParticleData(schemaParticle);
        }
    }

    void writeParticleData(SchemaParticle schemaParticle) {
        writeShort(schemaParticle.getParticleType());
        short s = schemaParticle.isSkippable() ? (short) 1 : (short) 0;
        if (schemaParticle.getParticleType() == 4) {
            SchemaLocalElement schemaLocalElement = (SchemaLocalElement) schemaParticle;
            if (schemaLocalElement.isFixed()) {
                s = (short) (s | 4);
            }
            if (schemaLocalElement.isNillable()) {
                s = (short) (s | 8);
            }
            if (schemaLocalElement.blockExtension()) {
                s = (short) (s | 16);
            }
            if (schemaLocalElement.blockRestriction()) {
                s = (short) (s | 32);
            }
            if (schemaLocalElement.blockSubstitution()) {
                s = (short) (s | 64);
            }
            if (schemaLocalElement.isAbstract()) {
                s = (short) (s | 128);
            }
            if (schemaLocalElement instanceof SchemaGlobalElement) {
                SchemaGlobalElement schemaGlobalElement = (SchemaGlobalElement) schemaLocalElement;
                if (schemaGlobalElement.finalExtension()) {
                    s = (short) (s | 256);
                }
                if (schemaGlobalElement.finalRestriction()) {
                    s = (short) (s | 512);
                }
            }
        }
        writeShort(s);
        writeBigInteger(schemaParticle.getMinOccurs());
        writeBigInteger(schemaParticle.getMaxOccurs());
        writeQNameSet(schemaParticle.acceptedStartNames());
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1 || particleType == 2 || particleType == 3) {
            writeParticleArray(schemaParticle.getParticleChildren());
            return;
        }
        if (particleType != 4) {
            if (particleType != 5) {
                throw new SchemaTypeLoaderException("Unrecognized particle type ", this.typeSystem.getName(), this._handle, 11);
            }
            writeQNameSet(schemaParticle.getWildcardSet());
            writeShort(schemaParticle.getWildcardProcess());
            return;
        }
        SchemaLocalElement schemaLocalElement2 = (SchemaLocalElement) schemaParticle;
        writeQName(schemaLocalElement2.getName());
        writeType(schemaLocalElement2.getType());
        writeString(schemaLocalElement2.getDefaultText());
        writeXmlValueObject(schemaLocalElement2.getDefaultValue());
        writeSOAPArrayType(((SchemaWSDLArrayType) schemaLocalElement2).getWSDLArrayType());
        writeAnnotation(schemaLocalElement2.getAnnotation());
        if (schemaLocalElement2 instanceof SchemaGlobalElement) {
            SchemaGlobalElement schemaGlobalElement2 = (SchemaGlobalElement) schemaLocalElement2;
            writeHandle(schemaGlobalElement2.substitutionGroup());
            QName[] qNameArrSubstitutionGroupMembers = schemaGlobalElement2.substitutionGroupMembers();
            writeShort(qNameArrSubstitutionGroupMembers.length);
            for (QName qName : qNameArrSubstitutionGroupMembers) {
                writeQName(qName);
            }
        }
        SchemaIdentityConstraint[] identityConstraints = schemaLocalElement2.getIdentityConstraints();
        writeShort(identityConstraints.length);
        for (SchemaIdentityConstraint schemaIdentityConstraint : identityConstraints) {
            writeHandle(schemaIdentityConstraint);
        }
    }

    void writePropertyData(SchemaProperty schemaProperty) throws IOException {
        writeQName(schemaProperty.getName());
        writeType(schemaProperty.getType());
        writeShort((schemaProperty.isAttribute() ? 1 : 0) | (schemaProperty.extendsJavaSingleton() ? 2 : 0) | (schemaProperty.extendsJavaOption() ? 4 : 0) | (schemaProperty.extendsJavaArray() ? 8 : 0));
        writeType(schemaProperty.getContainerType());
        writeBigInteger(schemaProperty.getMinOccurs());
        writeBigInteger(schemaProperty.getMaxOccurs());
        writeShort(schemaProperty.hasNillable());
        writeShort(schemaProperty.hasDefault());
        writeShort(schemaProperty.hasFixed());
        writeString(schemaProperty.getDefaultText());
        writeString(schemaProperty.getJavaPropertyName());
        writeShort(schemaProperty.getJavaTypeCode());
        writeType(schemaProperty.javaBasedOnType());
        writeXmlValueObject(schemaProperty.getDefaultValue());
        if (schemaProperty.isAttribute()) {
            return;
        }
        QName[] qNameArrAcceptedNames = schemaProperty.acceptedNames();
        writeShort(qNameArrAcceptedNames.length);
        for (QName qName : qNameArrAcceptedNames) {
            writeQName(qName);
        }
    }

    void writeQName(QName qName) {
        if (qName == null) {
            writeString(null);
            writeString(null);
        } else {
            writeString(qName.getNamespaceURI());
            writeString(qName.getLocalPart());
        }
    }

    void writeQNameMap(SchemaComponent[] schemaComponentArr) {
        writeShort(schemaComponentArr.length);
        for (SchemaComponent schemaComponent : schemaComponentArr) {
            writeQName(schemaComponent.getName());
            writeHandle(schemaComponent);
        }
    }

    void writeQNameSet(QNameSet qNameSet) {
        int i2 = qNameSet.excludedURIs() != null ? 1 : 0;
        writeShort(i2);
        Set<String> setExcludedURIs = i2 != 0 ? qNameSet.excludedURIs() : qNameSet.includedURIs();
        writeShort(setExcludedURIs.size());
        setExcludedURIs.forEach(new f(this));
        Set<QName> setExcludedQNamesInIncludedURIs = i2 != 0 ? qNameSet.excludedQNamesInIncludedURIs() : qNameSet.includedQNamesInExcludedURIs();
        writeShort(setExcludedQNamesInIncludedURIs.size());
        setExcludedQNamesInIncludedURIs.forEach(new Consumer() { // from class: org.apache.xmlbeans.impl.schema.f2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.writeQName((QName) obj);
            }
        });
        Set<QName> setIncludedQNamesInExcludedURIs = i2 != 0 ? qNameSet.includedQNamesInExcludedURIs() : qNameSet.excludedQNamesInIncludedURIs();
        writeShort(setIncludedQNamesInExcludedURIs.size());
        setIncludedQNamesInExcludedURIs.forEach(new Consumer() { // from class: org.apache.xmlbeans.impl.schema.f2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.writeQName((QName) obj);
            }
        });
    }

    void writeRealHeader(String str, int i2) {
        String str2;
        if (str.indexOf(47) >= 0) {
            str2 = str + ".xsb";
        } else {
            str2 = this.typeSystem.getBasePackage() + str + ".xsb";
        }
        OutputStream saverStream = this.typeSystem.getSaverStream(str2, this._handle);
        if (saverStream == null) {
            throw new SchemaTypeLoaderException("Could not write compiled schema resource " + str2, this.typeSystem.getName(), str, 12);
        }
        this._output = new LongUTFDataOutputStream(saverStream);
        this._handle = str;
        writeInt(-629491010);
        writeShort(2);
        writeShort(24);
        writeShort(0);
        writeShort(i2);
        this._stringPool.writeTo(this._output);
    }

    void writeSOAPArrayType(SOAPArrayType sOAPArrayType) {
        if (sOAPArrayType == null) {
            writeQName(null);
            writeString(null);
        } else {
            writeQName(sOAPArrayType.getQName());
            writeString(sOAPArrayType.soap11DimensionString());
        }
    }

    void writeShort(int i2) {
        if (i2 >= MAX_UNSIGNED_SHORT || i2 < -1) {
            throw new SchemaTypeLoaderException("Value " + i2 + " out of range: must fit in a 16-bit unsigned short.", this.typeSystem.getName(), this._handle, 10);
        }
        LongUTFDataOutputStream longUTFDataOutputStream = this._output;
        if (longUTFDataOutputStream != null) {
            try {
                longUTFDataOutputStream.writeShort(i2);
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
            }
        }
    }

    void writeShortOrInt(int i2) {
        LongUTFDataOutputStream longUTFDataOutputStream = this._output;
        if (longUTFDataOutputStream != null) {
            try {
                longUTFDataOutputStream.writeShortOrInt(i2);
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
            }
        }
    }

    void writeString(String str) {
        writeShortOrInt(this._stringPool.codeForString(str));
    }

    void writeType(SchemaType schemaType) {
        writeHandle(schemaType);
    }

    void writeTypeArray(SchemaType[] schemaTypeArr) {
        writeShort(schemaTypeArr.length);
        for (SchemaType schemaType : schemaTypeArr) {
            writeHandle(schemaType);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void writeTypeData(SchemaType schemaType) {
        writeQName(schemaType.getName());
        writeType(schemaType.getOuterType());
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) schemaType;
        writeShort(schemaTypeImpl.getBaseDepth());
        writeType(schemaType.getBaseType());
        writeShort(schemaType.getDerivationType());
        writeAnnotation(schemaType.getAnnotation());
        if (schemaType.getContainerField() == null) {
            writeShort(0);
        } else if (schemaType.getOuterType().isAttributeType() || schemaType.getOuterType().isDocumentType()) {
            writeShort(1);
            writeHandle((SchemaComponent) schemaType.getContainerField());
        } else if (schemaType.getContainerField().isAttribute()) {
            writeShort(2);
            writeShort(((SchemaTypeImpl) schemaType.getOuterType()).getIndexForLocalAttribute((SchemaLocalAttribute) schemaType.getContainerField()));
        } else {
            writeShort(3);
            writeShort(((SchemaTypeImpl) schemaType.getOuterType()).getIndexForLocalElement((SchemaLocalElement) schemaType.getContainerField()));
        }
        writeString(schemaType.getFullJavaName());
        writeString(schemaType.getFullJavaImplName());
        writeTypeArray(schemaType.getAnonymousTypes());
        writeShort(schemaType.getAnonymousUnionMemberOrdinal());
        boolean zIsSimpleType = schemaType.isSimpleType();
        int i2 = zIsSimpleType;
        if (schemaType.isDocumentType()) {
            i2 = (zIsSimpleType ? 1 : 0) | 2;
        }
        int i3 = i2;
        if (schemaType.isAttributeType()) {
            i3 = (i2 == true ? 1 : 0) | 524288;
        }
        int i4 = i3;
        if (schemaType.ordered() != 0) {
            i4 = (i3 == true ? 1 : 0) | 4;
        }
        int i5 = i4;
        if (schemaType.ordered() == 2) {
            i5 = (i4 == true ? 1 : 0) | 1024;
        }
        int i6 = i5;
        if (schemaType.isBounded()) {
            i6 = (i5 == true ? 1 : 0) | 8;
        }
        int i7 = i6;
        if (schemaType.isFinite()) {
            i7 = (i6 == true ? 1 : 0) | 16;
        }
        int i8 = i7;
        if (schemaType.isNumeric()) {
            i8 = (i7 == true ? 1 : 0) | 32;
        }
        int i9 = i8;
        if (schemaType.hasStringEnumValues()) {
            i9 = (i8 == true ? 1 : 0) | 64;
        }
        int i10 = i9;
        if (schemaTypeImpl.isUnionOfLists()) {
            i10 = (i9 == true ? 1 : 0) | 128;
        }
        int i11 = i10;
        if (schemaType.hasPatternFacet()) {
            i11 = (i10 == true ? 1 : 0) | 256;
        }
        int i12 = i11;
        if (schemaType.isOrderSensitive()) {
            i12 = (i11 == true ? 1 : 0) | 512;
        }
        int i13 = i12;
        if (schemaType.blockExtension()) {
            i13 = (i12 == true ? 1 : 0) | XMLEvent.CHANGE_PREFIX_MAPPING;
        }
        int i14 = i13;
        if (schemaType.blockRestriction()) {
            i14 = (i13 == true ? 1 : 0) | XMLEvent.ENTITY_REFERENCE;
        }
        int i15 = i14;
        if (schemaType.finalExtension()) {
            i15 = (i14 == true ? 1 : 0) | 16384;
        }
        int i16 = i15;
        if (schemaType.finalRestriction()) {
            i16 = (i15 == true ? 1 : 0) | 16384;
        }
        int i17 = i16;
        if (schemaType.finalList()) {
            i17 = (i16 == true ? 1 : 0) | WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        }
        int i18 = i17;
        if (schemaType.finalUnion()) {
            i18 = (i17 == true ? 1 : 0) | WXMediaMessage.THUMB_LENGTH_LIMIT;
        }
        int i19 = i18;
        if (schemaType.isAbstract()) {
            i19 = (i18 == true ? 1 : 0) | WXMediaMessage.NATIVE_GAME__THUMB_LIMIT;
        }
        writeInt(i19);
        if (!schemaType.isSimpleType()) {
            writeShort(schemaType.getContentType());
            writeType(schemaType.getContentBasedOnType());
            SchemaAttributeModel attributeModel = schemaType.getAttributeModel();
            SchemaLocalAttribute[] attributes = attributeModel.getAttributes();
            writeShort(attributes.length);
            for (SchemaLocalAttribute schemaLocalAttribute : attributes) {
                writeAttributeData(schemaLocalAttribute);
            }
            writeQNameSet(attributeModel.getWildcardSet());
            writeShort(attributeModel.getWildcardProcess());
            SchemaProperty[] attributeProperties = schemaType.getAttributeProperties();
            writeShort(attributeProperties.length);
            for (SchemaProperty schemaProperty : attributeProperties) {
                writePropertyData(schemaProperty);
            }
            if (schemaType.getContentType() == 3 || schemaType.getContentType() == 4) {
                writeShort(schemaType.hasAllContent() ? 1 : 0);
                writeParticleArray(schemaType.getContentModel() != null ? new SchemaParticle[]{schemaType.getContentModel()} : new SchemaParticle[0]);
                SchemaProperty[] elementProperties = schemaType.getElementProperties();
                writeShort(elementProperties.length);
                for (SchemaProperty schemaProperty2 : elementProperties) {
                    writePropertyData(schemaProperty2);
                }
            }
        }
        if (schemaType.isSimpleType() || schemaType.getContentType() == 2) {
            writeShort(schemaType.getSimpleVariety());
            int i20 = 0;
            for (int i21 = 0; i21 <= 11; i21++) {
                if (schemaType.getFacet(i21) != null) {
                    i20++;
                }
            }
            writeShort(i20);
            for (int i22 = 0; i22 <= 11; i22++) {
                XmlAnySimpleType facet = schemaType.getFacet(i22);
                if (facet != null) {
                    writeShort(i22);
                    writeXmlValueObject(facet);
                    writeShort(schemaType.isFacetFixed(i22) ? 1 : 0);
                }
            }
            writeShort(schemaType.getWhiteSpaceRule());
            RegularExpression[] patternExpressions = schemaTypeImpl.getPatternExpressions();
            writeShort(patternExpressions.length);
            for (RegularExpression regularExpression : patternExpressions) {
                writeString(regularExpression.getPattern());
            }
            XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
            if (enumerationValues == null) {
                writeShort(0);
            } else {
                writeShortOrInt(enumerationValues.length);
                for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
                    writeXmlValueObject(xmlAnySimpleType);
                }
            }
            writeType(schemaType.getBaseEnumType());
            if (schemaType.hasStringEnumValues()) {
                SchemaStringEnumEntry[] stringEnumEntries = schemaType.getStringEnumEntries();
                writeShort(stringEnumEntries.length);
                for (SchemaStringEnumEntry schemaStringEnumEntry : stringEnumEntries) {
                    writeString(schemaStringEnumEntry.getString());
                    writeShort(schemaStringEnumEntry.getIntValue());
                    writeString(schemaStringEnumEntry.getEnumName());
                }
            }
            int simpleVariety = schemaType.getSimpleVariety();
            if (simpleVariety == 1) {
                writeType(schemaType.getPrimitiveType());
                writeInt(schemaType.getDecimalSize());
            } else if (simpleVariety == 2) {
                writeTypeArray(schemaType.getUnionMemberTypes());
            } else if (simpleVariety == 3) {
                writeType(schemaType.getListItemType());
            }
        }
        writeString(schemaType.getSourceName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    void writeXmlValueObject(XmlAnySimpleType xmlAnySimpleType) throws IOException {
        SchemaType schemaType = xmlAnySimpleType == 0 ? null : xmlAnySimpleType.schemaType();
        writeType(schemaType);
        if (schemaType == null) {
        }
        SimpleValue simpleValue = (SimpleValue) xmlAnySimpleType;
        SchemaType schemaTypeInstanceType = simpleValue.instanceType();
        if (schemaTypeInstanceType == null) {
            writeShort(0);
            return;
        }
        if (schemaTypeInstanceType.getSimpleVariety() == 3) {
            writeShort(-1);
            List<? extends XmlAnySimpleType> listXgetListValue = ((XmlObjectBase) xmlAnySimpleType).xgetListValue();
            writeShort(listXgetListValue.size());
            listXgetListValue.forEach(new Consumer() { // from class: org.apache.xmlbeans.impl.schema.o
                @Override // java.util.function.Consumer
                public final void accept(Object obj) throws IOException {
                    this.a.writeXmlValueObject((XmlAnySimpleType) obj);
                }
            });
            return;
        }
        int builtinTypeCode = schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode();
        writeShort(builtinTypeCode);
        switch (builtinTypeCode) {
            case 2:
            case 3:
            case 6:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                writeString(xmlAnySimpleType.getStringValue());
                break;
            case 4:
            case 5:
                writeByteArray(simpleValue.getByteArrayValue());
                break;
            case 7:
            case 8:
                writeQName(simpleValue.getQNameValue());
                break;
            case 9:
                writeDouble(simpleValue.getFloatValue());
                break;
            case 10:
                writeDouble(simpleValue.getDoubleValue());
                break;
        }
    }

    public XsbReader(SchemaTypeSystemImpl schemaTypeSystemImpl, String str, int i2) {
        this.typeSystem = schemaTypeSystemImpl;
        String str2 = schemaTypeSystemImpl.getBasePackage() + str + ".xsb";
        InputStream loaderStream = schemaTypeSystemImpl.getLoaderStream(str2);
        if (loaderStream != null) {
            this._input = new LongUTFDataInputStream(loaderStream);
            this._handle = str;
            if (readInt() == -629491010) {
                this._majorver = readShort();
                int i3 = readShort();
                this._minorver = i3;
                if (this._majorver != 2) {
                    throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Wrong major version - expecting 2, got " + this._majorver, schemaTypeSystemImpl.getName(), str, 2);
                }
                if (i3 > 24) {
                    throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Incompatible minor version - expecting up to 24, got " + this._minorver, schemaTypeSystemImpl.getName(), str, 3);
                }
                if (i3 >= 14) {
                    if (atLeast(2, 18, 0)) {
                        this._releaseno = readShort();
                    }
                    int i4 = readShort();
                    if (i4 != i2 && i2 != MAX_UNSIGNED_SHORT) {
                        throw new SchemaTypeLoaderException("XML-BEANS compiled schema: File has the wrong type - expecting type " + i2 + ", got type " + i4, schemaTypeSystemImpl.getName(), str, 4);
                    }
                    SchemaTypeSystemImpl.StringPool stringPool = new SchemaTypeSystemImpl.StringPool(this._handle, schemaTypeSystemImpl.getName());
                    this._stringPool = stringPool;
                    stringPool.readFrom(this._input);
                    this._actualfiletype = i4;
                    return;
                }
                throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Incompatible minor version - expecting at least 14, got " + this._minorver, schemaTypeSystemImpl.getName(), str, 3);
            }
            throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Wrong magic cookie", schemaTypeSystemImpl.getName(), str, 1);
        }
        throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Could not locate compiled schema resource " + str2, schemaTypeSystemImpl.getName(), str, 0);
    }
}
