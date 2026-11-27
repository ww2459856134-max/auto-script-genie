package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes2.dex */
public interface STRectAlignment extends XmlToken {
    public static final Enum B;
    public static final Enum BL;
    public static final Enum BR;
    public static final Enum CTR;
    public static final SimpleTypeFactory<STRectAlignment> Factory;
    public static final int INT_B = 8;
    public static final int INT_BL = 7;
    public static final int INT_BR = 9;
    public static final int INT_CTR = 5;
    public static final int INT_L = 4;
    public static final int INT_R = 6;
    public static final int INT_T = 2;
    public static final int INT_TL = 1;
    public static final int INT_TR = 3;
    public static final Enum L;
    public static final Enum R;
    public static final Enum T;
    public static final Enum TL;
    public static final Enum TR;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_B = 8;
        static final int INT_BL = 7;
        static final int INT_BR = 9;
        static final int INT_CTR = 5;
        static final int INT_L = 4;
        static final int INT_R = 6;
        static final int INT_T = 2;
        static final int INT_TL = 1;
        static final int INT_TR = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("tl", 1), new Enum("t", 2), new Enum("tr", 3), new Enum("l", 4), new Enum("ctr", 5), new Enum("r", 6), new Enum("bl", 7), new Enum("b", 8), new Enum("br", 9)});

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
        SimpleTypeFactory<STRectAlignment> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "strectalignmentd400type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        TL = Enum.forString("tl");
        T = Enum.forString("t");
        TR = Enum.forString("tr");
        L = Enum.forString("l");
        CTR = Enum.forString("ctr");
        R = Enum.forString("r");
        BL = Enum.forString("bl");
        B = Enum.forString("b");
        BR = Enum.forString("br");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
