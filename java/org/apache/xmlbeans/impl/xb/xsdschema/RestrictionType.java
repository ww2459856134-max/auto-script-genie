package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface RestrictionType extends Annotated {
    public static final DocumentFactory<RestrictionType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<RestrictionType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "restrictiontype939ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    All addNewAll();

    Wildcard addNewAnyAttribute();

    Attribute addNewAttribute();

    AttributeGroupRef addNewAttributeGroup();

    ExplicitGroup addNewChoice();

    NoFixedFacet addNewEnumeration();

    NumFacet addNewFractionDigits();

    GroupRef addNewGroup();

    NumFacet addNewLength();

    Facet addNewMaxExclusive();

    Facet addNewMaxInclusive();

    NumFacet addNewMaxLength();

    Facet addNewMinExclusive();

    Facet addNewMinInclusive();

    NumFacet addNewMinLength();

    PatternDocument.Pattern addNewPattern();

    ExplicitGroup addNewSequence();

    LocalSimpleType addNewSimpleType();

    TotalDigitsDocument.TotalDigits addNewTotalDigits();

    WhiteSpaceDocument.WhiteSpace addNewWhiteSpace();

    All getAll();

    Wildcard getAnyAttribute();

    Attribute getAttributeArray(int i2);

    Attribute[] getAttributeArray();

    AttributeGroupRef getAttributeGroupArray(int i2);

    AttributeGroupRef[] getAttributeGroupArray();

    List<AttributeGroupRef> getAttributeGroupList();

    List<Attribute> getAttributeList();

    QName getBase();

    ExplicitGroup getChoice();

    NoFixedFacet getEnumerationArray(int i2);

    NoFixedFacet[] getEnumerationArray();

    List<NoFixedFacet> getEnumerationList();

    NumFacet getFractionDigitsArray(int i2);

    NumFacet[] getFractionDigitsArray();

    List<NumFacet> getFractionDigitsList();

    GroupRef getGroup();

    NumFacet getLengthArray(int i2);

    NumFacet[] getLengthArray();

    List<NumFacet> getLengthList();

    Facet getMaxExclusiveArray(int i2);

    Facet[] getMaxExclusiveArray();

    List<Facet> getMaxExclusiveList();

    Facet getMaxInclusiveArray(int i2);

    Facet[] getMaxInclusiveArray();

    List<Facet> getMaxInclusiveList();

    NumFacet getMaxLengthArray(int i2);

    NumFacet[] getMaxLengthArray();

    List<NumFacet> getMaxLengthList();

    Facet getMinExclusiveArray(int i2);

    Facet[] getMinExclusiveArray();

    List<Facet> getMinExclusiveList();

    Facet getMinInclusiveArray(int i2);

    Facet[] getMinInclusiveArray();

    List<Facet> getMinInclusiveList();

    NumFacet getMinLengthArray(int i2);

    NumFacet[] getMinLengthArray();

    List<NumFacet> getMinLengthList();

    PatternDocument.Pattern getPatternArray(int i2);

    PatternDocument.Pattern[] getPatternArray();

    List<PatternDocument.Pattern> getPatternList();

    ExplicitGroup getSequence();

    LocalSimpleType getSimpleType();

    TotalDigitsDocument.TotalDigits getTotalDigitsArray(int i2);

    TotalDigitsDocument.TotalDigits[] getTotalDigitsArray();

    List<TotalDigitsDocument.TotalDigits> getTotalDigitsList();

    WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int i2);

    WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray();

    List<WhiteSpaceDocument.WhiteSpace> getWhiteSpaceList();

    Attribute insertNewAttribute(int i2);

    AttributeGroupRef insertNewAttributeGroup(int i2);

    NoFixedFacet insertNewEnumeration(int i2);

    NumFacet insertNewFractionDigits(int i2);

    NumFacet insertNewLength(int i2);

    Facet insertNewMaxExclusive(int i2);

    Facet insertNewMaxInclusive(int i2);

    NumFacet insertNewMaxLength(int i2);

    Facet insertNewMinExclusive(int i2);

    Facet insertNewMinInclusive(int i2);

    NumFacet insertNewMinLength(int i2);

    PatternDocument.Pattern insertNewPattern(int i2);

    TotalDigitsDocument.TotalDigits insertNewTotalDigits(int i2);

    WhiteSpaceDocument.WhiteSpace insertNewWhiteSpace(int i2);

    boolean isSetAll();

    boolean isSetAnyAttribute();

    boolean isSetChoice();

    boolean isSetGroup();

    boolean isSetSequence();

    boolean isSetSimpleType();

    void removeAttribute(int i2);

    void removeAttributeGroup(int i2);

    void removeEnumeration(int i2);

    void removeFractionDigits(int i2);

    void removeLength(int i2);

    void removeMaxExclusive(int i2);

    void removeMaxInclusive(int i2);

    void removeMaxLength(int i2);

    void removeMinExclusive(int i2);

    void removeMinInclusive(int i2);

    void removeMinLength(int i2);

    void removePattern(int i2);

    void removeTotalDigits(int i2);

    void removeWhiteSpace(int i2);

    void setAll(All all);

    void setAnyAttribute(Wildcard wildcard);

    void setAttributeArray(int i2, Attribute attribute);

    void setAttributeArray(Attribute[] attributeArr);

    void setAttributeGroupArray(int i2, AttributeGroupRef attributeGroupRef);

    void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr);

    void setBase(QName qName);

    void setChoice(ExplicitGroup explicitGroup);

    void setEnumerationArray(int i2, NoFixedFacet noFixedFacet);

    void setEnumerationArray(NoFixedFacet[] noFixedFacetArr);

    void setFractionDigitsArray(int i2, NumFacet numFacet);

    void setFractionDigitsArray(NumFacet[] numFacetArr);

    void setGroup(GroupRef groupRef);

    void setLengthArray(int i2, NumFacet numFacet);

    void setLengthArray(NumFacet[] numFacetArr);

    void setMaxExclusiveArray(int i2, Facet facet);

    void setMaxExclusiveArray(Facet[] facetArr);

    void setMaxInclusiveArray(int i2, Facet facet);

    void setMaxInclusiveArray(Facet[] facetArr);

    void setMaxLengthArray(int i2, NumFacet numFacet);

    void setMaxLengthArray(NumFacet[] numFacetArr);

    void setMinExclusiveArray(int i2, Facet facet);

    void setMinExclusiveArray(Facet[] facetArr);

    void setMinInclusiveArray(int i2, Facet facet);

    void setMinInclusiveArray(Facet[] facetArr);

    void setMinLengthArray(int i2, NumFacet numFacet);

    void setMinLengthArray(NumFacet[] numFacetArr);

    void setPatternArray(int i2, PatternDocument.Pattern pattern);

    void setPatternArray(PatternDocument.Pattern[] patternArr);

    void setSequence(ExplicitGroup explicitGroup);

    void setSimpleType(LocalSimpleType localSimpleType);

    void setTotalDigitsArray(int i2, TotalDigitsDocument.TotalDigits totalDigits);

    void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] totalDigitsArr);

    void setWhiteSpaceArray(int i2, WhiteSpaceDocument.WhiteSpace whiteSpace);

    void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] whiteSpaceArr);

    int sizeOfAttributeArray();

    int sizeOfAttributeGroupArray();

    int sizeOfEnumerationArray();

    int sizeOfFractionDigitsArray();

    int sizeOfLengthArray();

    int sizeOfMaxExclusiveArray();

    int sizeOfMaxInclusiveArray();

    int sizeOfMaxLengthArray();

    int sizeOfMinExclusiveArray();

    int sizeOfMinInclusiveArray();

    int sizeOfMinLengthArray();

    int sizeOfPatternArray();

    int sizeOfTotalDigitsArray();

    int sizeOfWhiteSpaceArray();

    void unsetAll();

    void unsetAnyAttribute();

    void unsetChoice();

    void unsetGroup();

    void unsetSequence();

    void unsetSimpleType();

    XmlQName xgetBase();

    void xsetBase(XmlQName xmlQName);
}
