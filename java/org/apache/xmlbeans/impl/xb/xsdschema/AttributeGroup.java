package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.schema.AbstractDocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface AttributeGroup extends Annotated {
    public static final AbstractDocumentFactory<AttributeGroup> Factory;
    public static final SchemaType type;

    static {
        AbstractDocumentFactory<AttributeGroup> abstractDocumentFactory = new AbstractDocumentFactory<>(TypeSystemHolder.typeSystem, "attributegroupe530type");
        Factory = abstractDocumentFactory;
        type = abstractDocumentFactory.getType();
    }

    Wildcard addNewAnyAttribute();

    Attribute addNewAttribute();

    AttributeGroupRef addNewAttributeGroup();

    Wildcard getAnyAttribute();

    Attribute getAttributeArray(int i2);

    Attribute[] getAttributeArray();

    AttributeGroupRef getAttributeGroupArray(int i2);

    AttributeGroupRef[] getAttributeGroupArray();

    List<AttributeGroupRef> getAttributeGroupList();

    List<Attribute> getAttributeList();

    String getName();

    QName getRef();

    Attribute insertNewAttribute(int i2);

    AttributeGroupRef insertNewAttributeGroup(int i2);

    boolean isSetAnyAttribute();

    boolean isSetName();

    boolean isSetRef();

    void removeAttribute(int i2);

    void removeAttributeGroup(int i2);

    void setAnyAttribute(Wildcard wildcard);

    void setAttributeArray(int i2, Attribute attribute);

    void setAttributeArray(Attribute[] attributeArr);

    void setAttributeGroupArray(int i2, AttributeGroupRef attributeGroupRef);

    void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr);

    void setName(String str);

    void setRef(QName qName);

    int sizeOfAttributeArray();

    int sizeOfAttributeGroupArray();

    void unsetAnyAttribute();

    void unsetName();

    void unsetRef();

    XmlNCName xgetName();

    XmlQName xgetRef();

    void xsetName(XmlNCName xmlNCName);

    void xsetRef(XmlQName xmlQName);
}
