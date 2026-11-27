package org.apache.xmlbeans.impl.xb.xsdschema;

import java.math.BigInteger;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.schema.AbstractDocumentFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface Group extends Annotated {
    public static final AbstractDocumentFactory<Group> Factory;
    public static final SchemaType type;

    static {
        AbstractDocumentFactory<Group> abstractDocumentFactory = new AbstractDocumentFactory<>(TypeSystemHolder.typeSystem, "group7ca6type");
        Factory = abstractDocumentFactory;
        type = abstractDocumentFactory.getType();
    }

    All addNewAll();

    AnyDocument.Any addNewAny();

    ExplicitGroup addNewChoice();

    LocalElement addNewElement();

    GroupRef addNewGroup();

    ExplicitGroup addNewSequence();

    All getAllArray(int i2);

    All[] getAllArray();

    List<All> getAllList();

    AnyDocument.Any getAnyArray(int i2);

    AnyDocument.Any[] getAnyArray();

    List<AnyDocument.Any> getAnyList();

    ExplicitGroup getChoiceArray(int i2);

    ExplicitGroup[] getChoiceArray();

    List<ExplicitGroup> getChoiceList();

    LocalElement getElementArray(int i2);

    LocalElement[] getElementArray();

    List<LocalElement> getElementList();

    GroupRef getGroupArray(int i2);

    GroupRef[] getGroupArray();

    List<GroupRef> getGroupList();

    Object getMaxOccurs();

    BigInteger getMinOccurs();

    String getName();

    QName getRef();

    ExplicitGroup getSequenceArray(int i2);

    ExplicitGroup[] getSequenceArray();

    List<ExplicitGroup> getSequenceList();

    All insertNewAll(int i2);

    AnyDocument.Any insertNewAny(int i2);

    ExplicitGroup insertNewChoice(int i2);

    LocalElement insertNewElement(int i2);

    GroupRef insertNewGroup(int i2);

    ExplicitGroup insertNewSequence(int i2);

    boolean isSetMaxOccurs();

    boolean isSetMinOccurs();

    boolean isSetName();

    boolean isSetRef();

    void removeAll(int i2);

    void removeAny(int i2);

    void removeChoice(int i2);

    void removeElement(int i2);

    void removeGroup(int i2);

    void removeSequence(int i2);

    void setAllArray(int i2, All all);

    void setAllArray(All[] allArr);

    void setAnyArray(int i2, AnyDocument.Any any);

    void setAnyArray(AnyDocument.Any[] anyArr);

    void setChoiceArray(int i2, ExplicitGroup explicitGroup);

    void setChoiceArray(ExplicitGroup[] explicitGroupArr);

    void setElementArray(int i2, LocalElement localElement);

    void setElementArray(LocalElement[] localElementArr);

    void setGroupArray(int i2, GroupRef groupRef);

    void setGroupArray(GroupRef[] groupRefArr);

    void setMaxOccurs(Object obj);

    void setMinOccurs(BigInteger bigInteger);

    void setName(String str);

    void setRef(QName qName);

    void setSequenceArray(int i2, ExplicitGroup explicitGroup);

    void setSequenceArray(ExplicitGroup[] explicitGroupArr);

    int sizeOfAllArray();

    int sizeOfAnyArray();

    int sizeOfChoiceArray();

    int sizeOfElementArray();

    int sizeOfGroupArray();

    int sizeOfSequenceArray();

    void unsetMaxOccurs();

    void unsetMinOccurs();

    void unsetName();

    void unsetRef();

    AllNNI xgetMaxOccurs();

    XmlNonNegativeInteger xgetMinOccurs();

    XmlNCName xgetName();

    XmlQName xgetRef();

    void xsetMaxOccurs(AllNNI allNNI);

    void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger);

    void xsetName(XmlNCName xmlNCName);

    void xsetRef(XmlQName xmlQName);
}
