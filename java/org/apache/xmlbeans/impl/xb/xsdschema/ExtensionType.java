package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface ExtensionType extends Annotated {
    public static final DocumentFactory<ExtensionType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<ExtensionType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "extensiontypeed4ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    All addNewAll();

    Wildcard addNewAnyAttribute();

    Attribute addNewAttribute();

    AttributeGroupRef addNewAttributeGroup();

    ExplicitGroup addNewChoice();

    GroupRef addNewGroup();

    ExplicitGroup addNewSequence();

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

    GroupRef getGroup();

    ExplicitGroup getSequence();

    Attribute insertNewAttribute(int i2);

    AttributeGroupRef insertNewAttributeGroup(int i2);

    boolean isSetAll();

    boolean isSetAnyAttribute();

    boolean isSetChoice();

    boolean isSetGroup();

    boolean isSetSequence();

    void removeAttribute(int i2);

    void removeAttributeGroup(int i2);

    void setAll(All all);

    void setAnyAttribute(Wildcard wildcard);

    void setAttributeArray(int i2, Attribute attribute);

    void setAttributeArray(Attribute[] attributeArr);

    void setAttributeGroupArray(int i2, AttributeGroupRef attributeGroupRef);

    void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr);

    void setBase(QName qName);

    void setChoice(ExplicitGroup explicitGroup);

    void setGroup(GroupRef groupRef);

    void setSequence(ExplicitGroup explicitGroup);

    int sizeOfAttributeArray();

    int sizeOfAttributeGroupArray();

    void unsetAll();

    void unsetAnyAttribute();

    void unsetChoice();

    void unsetGroup();

    void unsetSequence();

    XmlQName xgetBase();

    void xsetBase(XmlQName xmlQName);
}
