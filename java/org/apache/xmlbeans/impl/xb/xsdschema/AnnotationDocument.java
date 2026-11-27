package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface AnnotationDocument extends XmlObject {
    public static final DocumentFactory<AnnotationDocument> Factory;
    public static final SchemaType type;

    public interface Annotation extends OpenAttrs {
        public static final ElementFactory<Annotation> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Annotation> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "annotation5abfelemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        AppinfoDocument.Appinfo addNewAppinfo();

        DocumentationDocument.Documentation addNewDocumentation();

        AppinfoDocument.Appinfo getAppinfoArray(int i2);

        AppinfoDocument.Appinfo[] getAppinfoArray();

        List<AppinfoDocument.Appinfo> getAppinfoList();

        DocumentationDocument.Documentation getDocumentationArray(int i2);

        DocumentationDocument.Documentation[] getDocumentationArray();

        List<DocumentationDocument.Documentation> getDocumentationList();

        String getId();

        AppinfoDocument.Appinfo insertNewAppinfo(int i2);

        DocumentationDocument.Documentation insertNewDocumentation(int i2);

        boolean isSetId();

        void removeAppinfo(int i2);

        void removeDocumentation(int i2);

        void setAppinfoArray(int i2, AppinfoDocument.Appinfo appinfo);

        void setAppinfoArray(AppinfoDocument.Appinfo[] appinfoArr);

        void setDocumentationArray(int i2, DocumentationDocument.Documentation documentation);

        void setDocumentationArray(DocumentationDocument.Documentation[] documentationArr);

        void setId(String str);

        int sizeOfAppinfoArray();

        int sizeOfDocumentationArray();

        void unsetId();

        XmlID xgetId();

        void xsetId(XmlID xmlID);
    }

    static {
        DocumentFactory<AnnotationDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "annotationb034doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Annotation addNewAnnotation();

    Annotation getAnnotation();

    void setAnnotation(Annotation annotation);
}
