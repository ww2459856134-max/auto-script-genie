package org.apache.xmlbeans.impl.xb.xmlconfig;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLCONFIG.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface ConfigDocument extends XmlObject {
    public static final DocumentFactory<ConfigDocument> Factory;
    public static final SchemaType type;

    public interface Config extends XmlObject {
        public static final ElementFactory<Config> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Config> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "configf467elemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        Extensionconfig addNewExtension();

        Nsconfig addNewNamespace();

        Qnameconfig addNewQname();

        Usertypeconfig addNewUsertype();

        Extensionconfig getExtensionArray(int i2);

        Extensionconfig[] getExtensionArray();

        List<Extensionconfig> getExtensionList();

        Nsconfig getNamespaceArray(int i2);

        Nsconfig[] getNamespaceArray();

        List<Nsconfig> getNamespaceList();

        Qnameconfig getQnameArray(int i2);

        Qnameconfig[] getQnameArray();

        List<Qnameconfig> getQnameList();

        Usertypeconfig getUsertypeArray(int i2);

        Usertypeconfig[] getUsertypeArray();

        List<Usertypeconfig> getUsertypeList();

        Extensionconfig insertNewExtension(int i2);

        Nsconfig insertNewNamespace(int i2);

        Qnameconfig insertNewQname(int i2);

        Usertypeconfig insertNewUsertype(int i2);

        void removeExtension(int i2);

        void removeNamespace(int i2);

        void removeQname(int i2);

        void removeUsertype(int i2);

        void setExtensionArray(int i2, Extensionconfig extensionconfig);

        void setExtensionArray(Extensionconfig[] extensionconfigArr);

        void setNamespaceArray(int i2, Nsconfig nsconfig);

        void setNamespaceArray(Nsconfig[] nsconfigArr);

        void setQnameArray(int i2, Qnameconfig qnameconfig);

        void setQnameArray(Qnameconfig[] qnameconfigArr);

        void setUsertypeArray(int i2, Usertypeconfig usertypeconfig);

        void setUsertypeArray(Usertypeconfig[] usertypeconfigArr);

        int sizeOfExtensionArray();

        int sizeOfNamespaceArray();

        int sizeOfQnameArray();

        int sizeOfUsertypeArray();
    }

    static {
        DocumentFactory<ConfigDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "config4185doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Config addNewConfig();

    Config getConfig();

    void setConfig(Config config);
}
