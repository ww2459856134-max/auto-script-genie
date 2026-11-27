package org.apache.xmlbeans.impl.xb.xmlschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLLANG.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface LangAttribute extends XmlObject {
    public static final DocumentFactory<LangAttribute> Factory;
    public static final SchemaType type;

    public interface Lang extends XmlAnySimpleType {
        public static final ElementFactory<Lang> Factory;
        public static final SchemaType type;

        public interface Member extends XmlString {
            public static final ElementFactory<Member> Factory;
            public static final int INT_X = 1;
            public static final Enum X;
            public static final SchemaType type;

            public static final class Enum extends StringEnumAbstractBase {
                static final int INT_X = 1;
                private static final long serialVersionUID = 1;
                public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("", 1)});

                private Enum(String str, int i2) {
                    super(str, i2);
                }

                public static Enum forInt(int i2) {
                    return (Enum) table.forInt(i2);
                }

                public static Enum forString(String str) {
                    return (Enum) table.forString(str);
                }

                private Object readResolve() {
                    return forInt(intValue());
                }
            }

            static {
                ElementFactory<Member> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "anon695ftype");
                Factory = elementFactory;
                type = elementFactory.getType();
                X = Enum.forString("");
            }

            StringEnumAbstractBase getEnumValue();

            void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
        }

        static {
            ElementFactory<Lang> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "lang1224attrtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        Object getObjectValue();

        SchemaType instanceType();

        void setObjectValue(Object obj);
    }

    static {
        DocumentFactory<LangAttribute> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "lange126attrtypetype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getLang();

    boolean isSetLang();

    void setLang(String str);

    void unsetLang();

    Lang xgetLang();

    void xsetLang(Lang lang);
}
