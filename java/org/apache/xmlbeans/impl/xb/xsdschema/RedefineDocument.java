package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface RedefineDocument extends XmlObject {
    public static final DocumentFactory<RedefineDocument> Factory;
    public static final SchemaType type;

    public interface Redefine extends OpenAttrs {
        public static final ElementFactory<Redefine> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Redefine> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "redefine9e9felemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        AnnotationDocument.Annotation addNewAnnotation();

        NamedAttributeGroup addNewAttributeGroup();

        TopLevelComplexType addNewComplexType();

        NamedGroup addNewGroup();

        TopLevelSimpleType addNewSimpleType();

        AnnotationDocument.Annotation getAnnotationArray(int i2);

        AnnotationDocument.Annotation[] getAnnotationArray();

        List<AnnotationDocument.Annotation> getAnnotationList();

        NamedAttributeGroup getAttributeGroupArray(int i2);

        NamedAttributeGroup[] getAttributeGroupArray();

        List<NamedAttributeGroup> getAttributeGroupList();

        TopLevelComplexType getComplexTypeArray(int i2);

        TopLevelComplexType[] getComplexTypeArray();

        List<TopLevelComplexType> getComplexTypeList();

        NamedGroup getGroupArray(int i2);

        NamedGroup[] getGroupArray();

        List<NamedGroup> getGroupList();

        String getId();

        String getSchemaLocation();

        TopLevelSimpleType getSimpleTypeArray(int i2);

        TopLevelSimpleType[] getSimpleTypeArray();

        List<TopLevelSimpleType> getSimpleTypeList();

        AnnotationDocument.Annotation insertNewAnnotation(int i2);

        NamedAttributeGroup insertNewAttributeGroup(int i2);

        TopLevelComplexType insertNewComplexType(int i2);

        NamedGroup insertNewGroup(int i2);

        TopLevelSimpleType insertNewSimpleType(int i2);

        boolean isSetId();

        void removeAnnotation(int i2);

        void removeAttributeGroup(int i2);

        void removeComplexType(int i2);

        void removeGroup(int i2);

        void removeSimpleType(int i2);

        void setAnnotationArray(int i2, AnnotationDocument.Annotation annotation);

        void setAnnotationArray(AnnotationDocument.Annotation[] annotationArr);

        void setAttributeGroupArray(int i2, NamedAttributeGroup namedAttributeGroup);

        void setAttributeGroupArray(NamedAttributeGroup[] namedAttributeGroupArr);

        void setComplexTypeArray(int i2, TopLevelComplexType topLevelComplexType);

        void setComplexTypeArray(TopLevelComplexType[] topLevelComplexTypeArr);

        void setGroupArray(int i2, NamedGroup namedGroup);

        void setGroupArray(NamedGroup[] namedGroupArr);

        void setId(String str);

        void setSchemaLocation(String str);

        void setSimpleTypeArray(int i2, TopLevelSimpleType topLevelSimpleType);

        void setSimpleTypeArray(TopLevelSimpleType[] topLevelSimpleTypeArr);

        int sizeOfAnnotationArray();

        int sizeOfAttributeGroupArray();

        int sizeOfComplexTypeArray();

        int sizeOfGroupArray();

        int sizeOfSimpleTypeArray();

        void unsetId();

        XmlID xgetId();

        XmlAnyURI xgetSchemaLocation();

        void xsetId(XmlID xmlID);

        void xsetSchemaLocation(XmlAnyURI xmlAnyURI);
    }

    static {
        DocumentFactory<RedefineDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "redefine3f55doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Redefine addNewRedefine();

    Redefine getRedefine();

    void setRedefine(Redefine redefine);
}
