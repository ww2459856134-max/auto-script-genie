package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface SimpleExtensionType extends ExtensionType {
    public static final DocumentFactory<SimpleExtensionType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<SimpleExtensionType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "simpleextensiontypee0detype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }
}
