package org.apache.xmlbeans.impl.xb.substwsdl;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface DefinitionsDocument extends XmlObject {
    public static final DocumentFactory<DefinitionsDocument> Factory;
    public static final SchemaType type;

    public interface Definitions extends XmlObject {
        public static final ElementFactory<Definitions> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Definitions> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "definitions05ddelemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        XmlObject addNewBinding();

        TImport addNewImport();

        XmlObject addNewMessage();

        XmlObject addNewPortType();

        XmlObject addNewService();

        XmlObject addNewTypes();

        XmlObject getBindingArray(int i2);

        XmlObject[] getBindingArray();

        List<XmlObject> getBindingList();

        TImport getImportArray(int i2);

        TImport[] getImportArray();

        List<TImport> getImportList();

        XmlObject getMessageArray(int i2);

        XmlObject[] getMessageArray();

        List<XmlObject> getMessageList();

        XmlObject getPortTypeArray(int i2);

        XmlObject[] getPortTypeArray();

        List<XmlObject> getPortTypeList();

        XmlObject getServiceArray(int i2);

        XmlObject[] getServiceArray();

        List<XmlObject> getServiceList();

        XmlObject getTypesArray(int i2);

        XmlObject[] getTypesArray();

        List<XmlObject> getTypesList();

        XmlObject insertNewBinding(int i2);

        TImport insertNewImport(int i2);

        XmlObject insertNewMessage(int i2);

        XmlObject insertNewPortType(int i2);

        XmlObject insertNewService(int i2);

        XmlObject insertNewTypes(int i2);

        void removeBinding(int i2);

        void removeImport(int i2);

        void removeMessage(int i2);

        void removePortType(int i2);

        void removeService(int i2);

        void removeTypes(int i2);

        void setBindingArray(int i2, XmlObject xmlObject);

        void setBindingArray(XmlObject[] xmlObjectArr);

        void setImportArray(int i2, TImport tImport);

        void setImportArray(TImport[] tImportArr);

        void setMessageArray(int i2, XmlObject xmlObject);

        void setMessageArray(XmlObject[] xmlObjectArr);

        void setPortTypeArray(int i2, XmlObject xmlObject);

        void setPortTypeArray(XmlObject[] xmlObjectArr);

        void setServiceArray(int i2, XmlObject xmlObject);

        void setServiceArray(XmlObject[] xmlObjectArr);

        void setTypesArray(int i2, XmlObject xmlObject);

        void setTypesArray(XmlObject[] xmlObjectArr);

        int sizeOfBindingArray();

        int sizeOfImportArray();

        int sizeOfMessageArray();

        int sizeOfPortTypeArray();

        int sizeOfServiceArray();

        int sizeOfTypesArray();
    }

    static {
        DocumentFactory<DefinitionsDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "definitionsc7f1doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Definitions addNewDefinitions();

    Definitions getDefinitions();

    void setDefinitions(Definitions definitions);
}
