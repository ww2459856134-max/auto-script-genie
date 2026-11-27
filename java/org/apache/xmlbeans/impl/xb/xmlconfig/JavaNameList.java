package org.apache.xmlbeans.impl.xb.xmlconfig;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.apache.xmlbeans.metadata.system.sXMLCONFIG.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface JavaNameList extends XmlAnySimpleType {
    public static final SimpleTypeFactory<JavaNameList> Factory;
    public static final SchemaType type;

    public interface Member extends XmlToken {
        public static final ElementFactory<Member> Factory;
        public static final int INT_X = 1;
        public static final Enum X;
        public static final SchemaType type;

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_X = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("*", 1)});

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
            ElementFactory<Member> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "anon3e39type");
            Factory = elementFactory;
            type = elementFactory.getType();
            X = Enum.forString("*");
        }

        StringEnumAbstractBase getEnumValue();

        void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
    }

    public interface Member2 extends XmlAnySimpleType {
        public static final ElementFactory<Member2> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Member2> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "anon3a98type");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        List getListValue();

        void setListValue(List<?> list);

        List xgetListValue();
    }

    static {
        SimpleTypeFactory<JavaNameList> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "javanamelistbcfetype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }

    Object getObjectValue();

    SchemaType instanceType();

    void setObjectValue(Object obj);
}
