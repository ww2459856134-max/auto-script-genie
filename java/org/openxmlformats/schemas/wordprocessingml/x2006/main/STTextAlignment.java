package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes3.dex */
public interface STTextAlignment extends XmlString {
    public static final Enum AUTO;
    public static final Enum BASELINE;
    public static final Enum BOTTOM;
    public static final Enum CENTER;
    public static final SimpleTypeFactory<STTextAlignment> Factory;
    public static final int INT_AUTO = 5;
    public static final int INT_BASELINE = 3;
    public static final int INT_BOTTOM = 4;
    public static final int INT_CENTER = 2;
    public static final int INT_TOP = 1;
    public static final Enum TOP;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 5;
        static final int INT_BASELINE = 3;
        static final int INT_BOTTOM = 4;
        static final int INT_CENTER = 2;
        static final int INT_TOP = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("top", 1), new Enum("center", 2), new Enum("baseline", 3), new Enum("bottom", 4), new Enum("auto", 5)});

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
        SimpleTypeFactory<STTextAlignment> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "sttextalignment316ctype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        TOP = Enum.forString("top");
        CENTER = Enum.forString("center");
        BASELINE = Enum.forString("baseline");
        BOTTOM = Enum.forString("bottom");
        AUTO = Enum.forString("auto");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
