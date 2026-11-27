package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface NoFixedFacet extends Facet {
    public static final DocumentFactory<NoFixedFacet> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<NoFixedFacet> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "nofixedfacet250ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }
}
