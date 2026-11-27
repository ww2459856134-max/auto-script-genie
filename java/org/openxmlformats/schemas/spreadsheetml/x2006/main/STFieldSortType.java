package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes2.dex */
public interface STFieldSortType extends XmlString {
    public static final Enum ASCENDING;
    public static final Enum DESCENDING;
    public static final SimpleTypeFactory<STFieldSortType> Factory;
    public static final int INT_ASCENDING = 2;
    public static final int INT_DESCENDING = 3;
    public static final int INT_MANUAL = 1;
    public static final Enum MANUAL;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ASCENDING = 2;
        static final int INT_DESCENDING = 3;
        static final int INT_MANUAL = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("manual", 1), new Enum("ascending", 2), new Enum("descending", 3)});

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
        SimpleTypeFactory<STFieldSortType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stfieldsorttypee6a1type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        MANUAL = Enum.forString("manual");
        ASCENDING = Enum.forString("ascending");
        DESCENDING = Enum.forString("descending");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
