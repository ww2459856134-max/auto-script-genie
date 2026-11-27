package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes2.dex */
public interface STUnderlineValues extends XmlString {
    public static final Enum DOUBLE;
    public static final Enum DOUBLE_ACCOUNTING;
    public static final SimpleTypeFactory<STUnderlineValues> Factory;
    public static final int INT_DOUBLE = 2;
    public static final int INT_DOUBLE_ACCOUNTING = 4;
    public static final int INT_NONE = 5;
    public static final int INT_SINGLE = 1;
    public static final int INT_SINGLE_ACCOUNTING = 3;
    public static final Enum NONE;
    public static final Enum SINGLE;
    public static final Enum SINGLE_ACCOUNTING;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DOUBLE = 2;
        static final int INT_DOUBLE_ACCOUNTING = 4;
        static final int INT_NONE = 5;
        static final int INT_SINGLE = 1;
        static final int INT_SINGLE_ACCOUNTING = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("single", 1), new Enum(XmlErrorCodes.DOUBLE, 2), new Enum("singleAccounting", 3), new Enum("doubleAccounting", 4), new Enum("none", 5)});

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
        SimpleTypeFactory<STUnderlineValues> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stunderlinevaluesb6ddtype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        SINGLE = Enum.forString("single");
        DOUBLE = Enum.forString(XmlErrorCodes.DOUBLE);
        SINGLE_ACCOUNTING = Enum.forString("singleAccounting");
        DOUBLE_ACCOUNTING = Enum.forString("doubleAccounting");
        NONE = Enum.forString("none");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
