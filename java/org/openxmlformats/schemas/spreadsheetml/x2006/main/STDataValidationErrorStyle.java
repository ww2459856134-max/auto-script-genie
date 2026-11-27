package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes2.dex */
public interface STDataValidationErrorStyle extends XmlString {
    public static final SimpleTypeFactory<STDataValidationErrorStyle> Factory;
    public static final Enum INFORMATION;
    public static final int INT_INFORMATION = 3;
    public static final int INT_STOP = 1;
    public static final int INT_WARNING = 2;
    public static final Enum STOP;
    public static final Enum WARNING;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_INFORMATION = 3;
        static final int INT_STOP = 1;
        static final int INT_WARNING = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("stop", 1), new Enum("warning", 2), new Enum("information", 3)});

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
        SimpleTypeFactory<STDataValidationErrorStyle> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stdatavalidationerrorstyleca85type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        STOP = Enum.forString("stop");
        WARNING = Enum.forString("warning");
        INFORMATION = Enum.forString("information");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
