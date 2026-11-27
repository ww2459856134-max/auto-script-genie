package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface RestrictionDocument extends XmlObject {
    public static final DocumentFactory<RestrictionDocument> Factory;
    public static final SchemaType type;

    public interface Restriction extends Annotated {
        public static final ElementFactory<Restriction> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Restriction> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "restrictionad11elemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        NoFixedFacet addNewEnumeration();

        NumFacet addNewFractionDigits();

        NumFacet addNewLength();

        Facet addNewMaxExclusive();

        Facet addNewMaxInclusive();

        NumFacet addNewMaxLength();

        Facet addNewMinExclusive();

        Facet addNewMinInclusive();

        NumFacet addNewMinLength();

        PatternDocument.Pattern addNewPattern();

        LocalSimpleType addNewSimpleType();

        TotalDigitsDocument.TotalDigits addNewTotalDigits();

        WhiteSpaceDocument.WhiteSpace addNewWhiteSpace();

        QName getBase();

        NoFixedFacet getEnumerationArray(int i2);

        NoFixedFacet[] getEnumerationArray();

        List<NoFixedFacet> getEnumerationList();

        NumFacet getFractionDigitsArray(int i2);

        NumFacet[] getFractionDigitsArray();

        List<NumFacet> getFractionDigitsList();

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

        LocalSimpleType getSimpleType();

        TotalDigitsDocument.TotalDigits getTotalDigitsArray(int i2);

        TotalDigitsDocument.TotalDigits[] getTotalDigitsArray();

        List<TotalDigitsDocument.TotalDigits> getTotalDigitsList();

        WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int i2);

        WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray();

        List<WhiteSpaceDocument.WhiteSpace> getWhiteSpaceList();

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

        boolean isSetBase();

        boolean isSetSimpleType();

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

        void setBase(QName qName);

        void setEnumerationArray(int i2, NoFixedFacet noFixedFacet);

        void setEnumerationArray(NoFixedFacet[] noFixedFacetArr);

        void setFractionDigitsArray(int i2, NumFacet numFacet);

        void setFractionDigitsArray(NumFacet[] numFacetArr);

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

        void setSimpleType(LocalSimpleType localSimpleType);

        void setTotalDigitsArray(int i2, TotalDigitsDocument.TotalDigits totalDigits);

        void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] totalDigitsArr);

        void setWhiteSpaceArray(int i2, WhiteSpaceDocument.WhiteSpace whiteSpace);

        void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] whiteSpaceArr);

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

        void unsetBase();

        void unsetSimpleType();

        XmlQName xgetBase();

        void xsetBase(XmlQName xmlQName);
    }

    static {
        DocumentFactory<RestrictionDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "restriction0049doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Restriction addNewRestriction();

    Restriction getRestriction();

    void setRestriction(Restriction restriction);
}
