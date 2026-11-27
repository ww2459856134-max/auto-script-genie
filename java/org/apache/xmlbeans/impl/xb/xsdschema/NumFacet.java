package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface NumFacet extends Facet {
    public static final DocumentFactory<NumFacet> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<NumFacet> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "numfacet93a2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }
}
