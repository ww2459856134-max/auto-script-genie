package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes2.dex */
public interface STVisibility extends XmlString {
    public static final SimpleTypeFactory<STVisibility> Factory;
    public static final Enum HIDDEN;
    public static final int INT_HIDDEN = 2;
    public static final int INT_VERY_HIDDEN = 3;
    public static final int INT_VISIBLE = 1;
    public static final Enum VERY_HIDDEN;
    public static final Enum VISIBLE;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_HIDDEN = 2;
        static final int INT_VERY_HIDDEN = 3;
        static final int INT_VISIBLE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("visible", 1), new Enum("hidden", 2), new Enum("veryHidden", 3)});

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
        SimpleTypeFactory<STVisibility> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stvisibility762btype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        VISIBLE = Enum.forString("visible");
        HIDDEN = Enum.forString("hidden");
        VERY_HIDDEN = Enum.forString("veryHidden");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
