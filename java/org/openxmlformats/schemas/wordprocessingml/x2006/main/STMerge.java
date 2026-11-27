package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes3.dex */
public interface STMerge extends XmlString {
    public static final Enum CONTINUE;
    public static final SimpleTypeFactory<STMerge> Factory;
    public static final int INT_CONTINUE = 1;
    public static final int INT_RESTART = 2;
    public static final Enum RESTART;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONTINUE = 1;
        static final int INT_RESTART = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("continue", 1), new Enum("restart", 2)});

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
        SimpleTypeFactory<STMerge> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stmerge50aatype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        CONTINUE = Enum.forString("continue");
        RESTART = Enum.forString("restart");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
