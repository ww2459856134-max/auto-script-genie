package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes3.dex */
public final class STPageBorderZOrder$Enum extends StringEnumAbstractBase {
    static final int INT_BACK = 2;
    static final int INT_FRONT = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STPageBorderZOrder$Enum[]{new STPageBorderZOrder$Enum("front", 1), new STPageBorderZOrder$Enum("back", 2)});

    private STPageBorderZOrder$Enum(String str, int i2) {
        super(str, i2);
    }

    public static STPageBorderZOrder$Enum forInt(int i2) {
        return (STPageBorderZOrder$Enum) table.forInt(i2);
    }

    public static STPageBorderZOrder$Enum forString(String str) {
        return (STPageBorderZOrder$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
