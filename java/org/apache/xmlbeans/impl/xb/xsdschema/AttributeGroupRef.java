package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface AttributeGroupRef extends AttributeGroup {
    public static final DocumentFactory<AttributeGroupRef> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<AttributeGroupRef> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "attributegroupref8375type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    QName getRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    boolean isSetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void setRef(QName qName);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void unsetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    XmlQName xgetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void xsetRef(XmlQName xmlQName);
}
