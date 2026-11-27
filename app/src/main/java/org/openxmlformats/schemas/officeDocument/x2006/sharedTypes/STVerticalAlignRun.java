package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes2.dex */
public interface STVerticalAlignRun extends XmlString {
    public static final Enum BASELINE;
    public static final SimpleTypeFactory<STVerticalAlignRun> Factory;
    public static final int INT_BASELINE = 1;
    public static final int INT_SUBSCRIPT = 3;
    public static final int INT_SUPERSCRIPT = 2;
    public static final Enum SUBSCRIPT;
    public static final Enum SUPERSCRIPT;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BASELINE = 1;
        static final int INT_SUBSCRIPT = 3;
        static final int INT_SUPERSCRIPT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("baseline", 1), new Enum("superscript", 2), new Enum("subscript", 3)});

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
        SimpleTypeFactory<STVerticalAlignRun> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stverticalalignrunc096type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        BASELINE = Enum.forString("baseline");
        SUPERSCRIPT = Enum.forString("superscript");
        SUBSCRIPT = Enum.forString("subscript");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
