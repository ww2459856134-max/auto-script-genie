package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* loaded from: classes2.dex */
public interface STLblAlgn extends XmlString {
    public static final Enum CTR;
    public static final SimpleTypeFactory<STLblAlgn> Factory;
    public static final int INT_CTR = 1;
    public static final int INT_L = 2;
    public static final int INT_R = 3;
    public static final Enum L;
    public static final Enum R;
    public static final SchemaType type;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CTR = 1;
        static final int INT_L = 2;
        static final int INT_R = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("ctr", 1), new Enum("l", 2), new Enum("r", 3)});

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
        SimpleTypeFactory<STLblAlgn> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stlblalgn934etype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        CTR = Enum.forString("ctr");
        L = Enum.forString("l");
        R = Enum.forString("r");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
