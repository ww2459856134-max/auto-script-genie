package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes2.dex */
public interface STLineCap extends XmlToken {
    public static final Enum FLAT;
    public static final SimpleTypeFactory<STLineCap> Factory;
    public static final int INT_FLAT = 3;
    public static final int INT_RND = 1;
    public static final int INT_SQ = 2;
    public static final Enum RND;
    public static final Enum SQ;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FLAT = 3;
        static final int INT_RND = 1;
        static final int INT_SQ = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("rnd", 1), new Enum("sq", 2), new Enum("flat", 3)});

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
        SimpleTypeFactory<STLineCap> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stlinecapcddftype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        RND = Enum.forString("rnd");
        SQ = Enum.forString("sq");
        FLAT = Enum.forString("flat");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
