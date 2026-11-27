package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* loaded from: classes2.dex */
public interface FormChoice extends XmlNMTOKEN {
    public static final SimpleTypeFactory<FormChoice> Factory;
    public static final int INT_QUALIFIED = 1;
    public static final int INT_UNQUALIFIED = 2;
    public static final Enum QUALIFIED;
    public static final Enum UNQUALIFIED;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_QUALIFIED = 1;
        static final int INT_UNQUALIFIED = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("qualified", 1), new Enum("unqualified", 2)});

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
        SimpleTypeFactory<FormChoice> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "formchoicef2aetype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        QUALIFIED = Enum.forString("qualified");
        UNQUALIFIED = Enum.forString("unqualified");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
