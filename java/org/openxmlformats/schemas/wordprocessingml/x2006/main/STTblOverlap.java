package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes3.dex */
public interface STTblOverlap extends XmlString {
    public static final SimpleTypeFactory<STTblOverlap> Factory;
    public static final int INT_NEVER = 1;
    public static final int INT_OVERLAP = 2;
    public static final Enum NEVER;
    public static final Enum OVERLAP;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_NEVER = 1;
        static final int INT_OVERLAP = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("never", 1), new Enum("overlap", 2)});

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
        SimpleTypeFactory<STTblOverlap> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "sttbloverlapb50ftype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        NEVER = Enum.forString("never");
        OVERLAP = Enum.forString("overlap");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
