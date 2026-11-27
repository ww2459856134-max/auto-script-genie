package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface All extends ExplicitGroup {
    public static final DocumentFactory<All> Factory;
    public static final SchemaType type;

    public interface MaxOccurs extends AllNNI {
        public static final ElementFactory<MaxOccurs> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<MaxOccurs> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "maxoccurse8b1attrtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        Object getObjectValue();

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        SchemaType instanceType();

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllNNI
        void setObjectValue(Object obj);
    }

    public interface MinOccurs extends XmlNonNegativeInteger {
        public static final ElementFactory<MinOccurs> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<MinOccurs> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "minoccurs9283attrtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }
    }

    static {
        DocumentFactory<All> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "all3c04type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }
}
