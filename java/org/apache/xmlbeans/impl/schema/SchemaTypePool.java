package org.apache.xmlbeans.impl.schema;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiConsumer;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoaderException;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
class SchemaTypePool {
    private boolean _started;
    private final SchemaTypeSystemImpl typeSystem;
    private final Map<String, SchemaComponent.Ref> _handlesToRefs = new LinkedHashMap();
    private final Map<SchemaComponent, String> _componentsToHandles = new LinkedHashMap();

    SchemaTypePool(SchemaTypeSystemImpl schemaTypeSystemImpl) {
        this.typeSystem = schemaTypeSystemImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(XsbReader xsbReader, SchemaComponent schemaComponent, String str) {
        xsbReader.writeString(str);
        xsbReader.writeShort(fileTypeFromComponentType(schemaComponent.getComponentType()));
    }

    private String addUniqueHandle(SchemaComponent schemaComponent, String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        int i2 = 2;
        String str2 = lowerCase;
        while (this._handlesToRefs.containsKey(str2)) {
            str2 = lowerCase + i2;
            i2++;
        }
        this._handlesToRefs.put(str2, schemaComponent.getComponentRef());
        this._componentsToHandles.put(schemaComponent, str2);
        return str2;
    }

    int fileTypeFromComponentType(int i2) {
        if (i2 == 0) {
            return 2;
        }
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 3) {
            return 4;
        }
        if (i2 == 4) {
            return 7;
        }
        if (i2 == 5) {
            return 8;
        }
        if (i2 == 6) {
            return 6;
        }
        throw new IllegalStateException("Unexpected component type");
    }

    String handleForAttribute(SchemaGlobalAttribute schemaGlobalAttribute) {
        if (schemaGlobalAttribute == null) {
            return null;
        }
        if (schemaGlobalAttribute.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        String str = this._componentsToHandles.get(schemaGlobalAttribute);
        if (str != null) {
            return str;
        }
        return addUniqueHandle(schemaGlobalAttribute, NameUtil.upperCamelCase(schemaGlobalAttribute.getName().getLocalPart()) + "Attribute");
    }

    String handleForAttributeGroup(SchemaAttributeGroup schemaAttributeGroup) {
        if (schemaAttributeGroup == null) {
            return null;
        }
        if (schemaAttributeGroup.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        String str = this._componentsToHandles.get(schemaAttributeGroup);
        if (str != null) {
            return str;
        }
        return addUniqueHandle(schemaAttributeGroup, NameUtil.upperCamelCase(schemaAttributeGroup.getName().getLocalPart()) + "AttributeGroup");
    }

    String handleForComponent(SchemaComponent schemaComponent) {
        if (schemaComponent == null) {
            return null;
        }
        if (schemaComponent.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        if (schemaComponent instanceof SchemaType) {
            return handleForType((SchemaType) schemaComponent);
        }
        if (schemaComponent instanceof SchemaGlobalElement) {
            return handleForElement((SchemaGlobalElement) schemaComponent);
        }
        if (schemaComponent instanceof SchemaGlobalAttribute) {
            return handleForAttribute((SchemaGlobalAttribute) schemaComponent);
        }
        if (schemaComponent instanceof SchemaModelGroup) {
            return handleForModelGroup((SchemaModelGroup) schemaComponent);
        }
        if (schemaComponent instanceof SchemaAttributeGroup) {
            return handleForAttributeGroup((SchemaAttributeGroup) schemaComponent);
        }
        if (schemaComponent instanceof SchemaIdentityConstraint) {
            return handleForIdentityConstraint((SchemaIdentityConstraint) schemaComponent);
        }
        throw new IllegalStateException("Component type cannot have a handle");
    }

    String handleForElement(SchemaGlobalElement schemaGlobalElement) {
        if (schemaGlobalElement == null) {
            return null;
        }
        if (schemaGlobalElement.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        String str = this._componentsToHandles.get(schemaGlobalElement);
        if (str != null) {
            return str;
        }
        return addUniqueHandle(schemaGlobalElement, NameUtil.upperCamelCase(schemaGlobalElement.getName().getLocalPart()) + "Element");
    }

    String handleForIdentityConstraint(SchemaIdentityConstraint schemaIdentityConstraint) {
        if (schemaIdentityConstraint == null) {
            return null;
        }
        if (schemaIdentityConstraint.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        String str = this._componentsToHandles.get(schemaIdentityConstraint);
        if (str != null) {
            return str;
        }
        return addUniqueHandle(schemaIdentityConstraint, NameUtil.upperCamelCase(schemaIdentityConstraint.getName().getLocalPart()) + "IdentityConstraint");
    }

    String handleForModelGroup(SchemaModelGroup schemaModelGroup) {
        if (schemaModelGroup == null) {
            return null;
        }
        if (schemaModelGroup.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        String str = this._componentsToHandles.get(schemaModelGroup);
        if (str != null) {
            return str;
        }
        return addUniqueHandle(schemaModelGroup, NameUtil.upperCamelCase(schemaModelGroup.getName().getLocalPart()) + "ModelGroup");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String handleForType(SchemaType schemaType) {
        String str;
        String str2;
        if (schemaType == null) {
            return null;
        }
        if (schemaType.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        String str3 = this._componentsToHandles.get(schemaType);
        if (str3 != null) {
            return str3;
        }
        QName name = schemaType.getName();
        if (name != null) {
            str = "";
        } else if (schemaType.isDocumentType()) {
            name = schemaType.getDocumentElementName();
            str = "Doc";
        } else if (schemaType.isAttributeType()) {
            name = schemaType.getAttributeTypeAttributeName();
            str = "AttrType";
        } else if (schemaType.getContainerField() != null) {
            name = schemaType.getContainerField().getName();
            str = schemaType.getContainerField().isAttribute() ? "Attr" : "Elem";
        }
        String upperCase = Integer.toHexString(schemaType.toString().hashCode() | Integer.MIN_VALUE).substring(4).toUpperCase(Locale.ROOT);
        if (name == null) {
            str2 = "Anon" + upperCase + "Type";
        } else {
            str2 = NameUtil.upperCamelCase(name.getLocalPart()) + upperCase + str + "Type";
        }
        return addUniqueHandle(schemaType, str2);
    }

    void readHandlePool(XsbReader xsbReader) {
        SchemaComponent.Ref ref;
        if (!this._handlesToRefs.isEmpty() || this._started) {
            throw new IllegalStateException("Nonempty handle set before read");
        }
        int i2 = xsbReader.readShort();
        for (int i3 = 0; i3 < i2; i3++) {
            String string = xsbReader.readString();
            int i4 = xsbReader.readShort();
            if (i4 == 2) {
                ref = new SchemaType.Ref(this.typeSystem, string);
            } else if (i4 == 3) {
                ref = new SchemaGlobalElement.Ref(this.typeSystem, string);
            } else if (i4 == 4) {
                ref = new SchemaGlobalAttribute.Ref(this.typeSystem, string);
            } else if (i4 == 6) {
                ref = new SchemaModelGroup.Ref(this.typeSystem, string);
            } else if (i4 == 7) {
                ref = new SchemaAttributeGroup.Ref(this.typeSystem, string);
            } else {
                if (i4 != 8) {
                    throw new SchemaTypeLoaderException("Schema index has an unrecognized entry of type " + i4, this.typeSystem.getName(), string, 5);
                }
                ref = new SchemaIdentityConstraint.Ref(this.typeSystem, string);
            }
            this._handlesToRefs.put(string, ref);
        }
    }

    SchemaComponent.Ref refForHandle(String str) {
        if (str == null) {
            return null;
        }
        return this._handlesToRefs.get(str);
    }

    void startWriteMode() {
        this._started = true;
        this._componentsToHandles.clear();
        for (String str : this._handlesToRefs.keySet()) {
            this._componentsToHandles.put(this._handlesToRefs.get(str).getComponent(), str);
        }
    }

    void writeHandlePool(final XsbReader xsbReader) {
        xsbReader.writeShort(this._componentsToHandles.size());
        this._componentsToHandles.forEach(new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.d0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.a.b(xsbReader, (SchemaComponent) obj, (String) obj2);
            }
        });
    }
}
