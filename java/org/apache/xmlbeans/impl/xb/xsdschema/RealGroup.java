package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface RealGroup extends Group {
    public static final DocumentFactory<RealGroup> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<RealGroup> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "realgroup1f64type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    All addNewAll();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup addNewChoice();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup addNewSequence();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    All getAllArray(int i2);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    All[] getAllArray();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    List<All> getAllList();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup getChoiceArray(int i2);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup[] getChoiceArray();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    List<ExplicitGroup> getChoiceList();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup getSequenceArray(int i2);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup[] getSequenceArray();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    List<ExplicitGroup> getSequenceList();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    All insertNewAll(int i2);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup insertNewChoice(int i2);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    ExplicitGroup insertNewSequence(int i2);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void removeAll(int i2);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void removeChoice(int i2);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void removeSequence(int i2);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setAllArray(int i2, All all);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setAllArray(All[] allArr);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setChoiceArray(int i2, ExplicitGroup explicitGroup);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setChoiceArray(ExplicitGroup[] explicitGroupArr);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setSequenceArray(int i2, ExplicitGroup explicitGroup);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setSequenceArray(ExplicitGroup[] explicitGroupArr);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    int sizeOfAllArray();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    int sizeOfChoiceArray();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    int sizeOfSequenceArray();
}
