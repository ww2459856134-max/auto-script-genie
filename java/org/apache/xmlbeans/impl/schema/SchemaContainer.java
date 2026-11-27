package org.apache.xmlbeans.impl.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;

/* loaded from: classes.dex */
class SchemaContainer {
    boolean _immutable;
    private final String _namespace;
    private SchemaTypeSystem _typeSystem;
    private final List<SchemaGlobalElement.Ref> _globalElements = new ArrayList();
    private final List<SchemaGlobalAttribute.Ref> _globalAttributes = new ArrayList();
    private final List<SchemaModelGroup.Ref> _modelGroups = new ArrayList();
    private final List<SchemaModelGroup.Ref> _redefinedModelGroups = new ArrayList();
    private final List<SchemaAttributeGroup.Ref> _attributeGroups = new ArrayList();
    private final List<SchemaAttributeGroup.Ref> _redefinedAttributeGroups = new ArrayList();
    private final List<SchemaType.Ref> _globalTypes = new ArrayList();
    private final List<SchemaType.Ref> _redefinedGlobalTypes = new ArrayList();
    private final List<SchemaType.Ref> _documentTypes = new ArrayList();
    private final List<SchemaType.Ref> _attributeTypes = new ArrayList();
    private final List<SchemaIdentityConstraint.Ref> _identityConstraints = new ArrayList();
    private final List<SchemaAnnotation> _annotations = new ArrayList();

    SchemaContainer(String str) {
        this._namespace = str;
    }

    private void check_immutable() {
        if (this._immutable) {
            throw new IllegalStateException("Cannot add components to immutable SchemaContainer");
        }
    }

    void addAnnotation(SchemaAnnotation schemaAnnotation) {
        check_immutable();
        this._annotations.add(schemaAnnotation);
    }

    void addAttributeGroup(SchemaAttributeGroup.Ref ref) {
        check_immutable();
        this._attributeGroups.add(ref);
    }

    void addAttributeType(SchemaType.Ref ref) {
        check_immutable();
        this._attributeTypes.add(ref);
    }

    void addDocumentType(SchemaType.Ref ref) {
        check_immutable();
        this._documentTypes.add(ref);
    }

    void addGlobalAttribute(SchemaGlobalAttribute.Ref ref) {
        check_immutable();
        this._globalAttributes.add(ref);
    }

    void addGlobalElement(SchemaGlobalElement.Ref ref) {
        check_immutable();
        this._globalElements.add(ref);
    }

    void addGlobalType(SchemaType.Ref ref) {
        check_immutable();
        this._globalTypes.add(ref);
    }

    void addIdentityConstraint(SchemaIdentityConstraint.Ref ref) {
        check_immutable();
        this._identityConstraints.add(ref);
    }

    void addModelGroup(SchemaModelGroup.Ref ref) {
        check_immutable();
        this._modelGroups.add(ref);
    }

    void addRedefinedAttributeGroup(SchemaAttributeGroup.Ref ref) {
        check_immutable();
        this._redefinedAttributeGroups.add(ref);
    }

    void addRedefinedModelGroup(SchemaModelGroup.Ref ref) {
        check_immutable();
        this._redefinedModelGroups.add(ref);
    }

    void addRedefinedType(SchemaType.Ref ref) {
        check_immutable();
        this._redefinedGlobalTypes.add(ref);
    }

    List<SchemaAnnotation> annotations() {
        return Collections.unmodifiableList(this._annotations);
    }

    List<SchemaAttributeGroup> attributeGroups() {
        return (List) this._attributeGroups.stream().map(n.a).collect(Collectors.toList());
    }

    List<SchemaType> attributeTypes() {
        return (List) this._attributeTypes.stream().map(d2.a).collect(Collectors.toList());
    }

    List<SchemaType> documentTypes() {
        return (List) this._documentTypes.stream().map(d2.a).collect(Collectors.toList());
    }

    String getNamespace() {
        return this._namespace;
    }

    synchronized SchemaTypeSystem getTypeSystem() {
        return this._typeSystem;
    }

    List<SchemaGlobalAttribute> globalAttributes() {
        return (List) this._globalAttributes.stream().map(p1.a).collect(Collectors.toList());
    }

    List<SchemaGlobalElement> globalElements() {
        return (List) this._globalElements.stream().map(t.a).collect(Collectors.toList());
    }

    List<SchemaType> globalTypes() {
        return (List) this._globalTypes.stream().map(d2.a).collect(Collectors.toList());
    }

    List<SchemaIdentityConstraint> identityConstraints() {
        return (List) this._identityConstraints.stream().map(u1.a).collect(Collectors.toList());
    }

    List<SchemaModelGroup> modelGroups() {
        return (List) this._modelGroups.stream().map(t1.a).collect(Collectors.toList());
    }

    List<SchemaAttributeGroup> redefinedAttributeGroups() {
        return (List) this._redefinedAttributeGroups.stream().map(n.a).collect(Collectors.toList());
    }

    List<SchemaType> redefinedGlobalTypes() {
        return (List) this._redefinedGlobalTypes.stream().map(d2.a).collect(Collectors.toList());
    }

    List<SchemaModelGroup> redefinedModelGroups() {
        return (List) this._redefinedModelGroups.stream().map(t1.a).collect(Collectors.toList());
    }

    synchronized void setImmutable() {
        this._immutable = true;
    }

    synchronized void setTypeSystem(SchemaTypeSystem schemaTypeSystem) {
        this._typeSystem = schemaTypeSystem;
    }

    synchronized void unsetImmutable() {
        this._immutable = false;
    }
}
