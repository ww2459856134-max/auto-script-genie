package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes3.dex */
public interface STLineSpacingRule extends XmlString {
    public static final Enum AT_LEAST;
    public static final Enum AUTO;
    public static final Enum EXACT;
    public static final SimpleTypeFactory<STLineSpacingRule> Factory;
    public static final int INT_AT_LEAST = 3;
    public static final int INT_AUTO = 1;
    public static final int INT_EXACT = 2;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AT_LEAST = 3;
        static final int INT_AUTO = 1;
        static final int INT_EXACT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("auto", 1), new Enum("exact", 2), new Enum("atLeast", 3)});

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
        SimpleTypeFactory<STLineSpacingRule> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stlinespacingrule6237type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        AUTO = Enum.forString("auto");
        EXACT = Enum.forString("exact");
        AT_LEAST = Enum.forString("atLeast");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
