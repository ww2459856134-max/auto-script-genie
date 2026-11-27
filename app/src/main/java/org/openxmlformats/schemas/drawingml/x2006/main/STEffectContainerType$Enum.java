package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes2.dex */
public final class STEffectContainerType$Enum extends StringEnumAbstractBase {
    static final int INT_SIB = 1;
    static final int INT_TREE = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STEffectContainerType$Enum[]{new STEffectContainerType$Enum("sib", 1), new STEffectContainerType$Enum("tree", 2)});

    private STEffectContainerType$Enum(String str, int i2) {
        super(str, i2);
    }

    public static STEffectContainerType$Enum forInt(int i2) {
        return (STEffectContainerType$Enum) table.forInt(i2);
    }

    public static STEffectContainerType$Enum forString(String str) {
        return (STEffectContainerType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
