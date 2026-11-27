package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes2.dex */
public interface STCellType extends XmlString {
    public static final Enum B;
    public static final Enum E;
    public static final SimpleTypeFactory<STCellType> Factory;
    public static final Enum INLINE_STR;
    public static final int INT_B = 1;
    public static final int INT_E = 3;
    public static final int INT_INLINE_STR = 6;
    public static final int INT_N = 2;
    public static final int INT_S = 4;
    public static final int INT_STR = 5;
    public static final Enum N;
    public static final Enum S;
    public static final Enum STR;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_B = 1;
        static final int INT_E = 3;
        static final int INT_INLINE_STR = 6;
        static final int INT_N = 2;
        static final int INT_S = 4;
        static final int INT_STR = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("b", 1), new Enum("n", 2), new Enum("e", 3), new Enum("s", 4), new Enum("str", 5), new Enum("inlineStr", 6)});

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
        SimpleTypeFactory<STCellType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stcelltypebf95type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        B = Enum.forString("b");
        N = Enum.forString("n");
        E = Enum.forString("e");
        S = Enum.forString("s");
        STR = Enum.forString("str");
        INLINE_STR = Enum.forString("inlineStr");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
