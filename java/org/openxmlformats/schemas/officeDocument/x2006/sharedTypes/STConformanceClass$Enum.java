package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes2.dex */
public final class STConformanceClass$Enum extends StringEnumAbstractBase {
    static final int INT_STRICT = 1;
    static final int INT_TRANSITIONAL = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STConformanceClass$Enum[]{new STConformanceClass$Enum("strict", 1), new STConformanceClass$Enum("transitional", 2)});

    private STConformanceClass$Enum(String str, int i2) {
        super(str, i2);
    }

    public static STConformanceClass$Enum forInt(int i2) {
        return (STConformanceClass$Enum) table.forInt(i2);
    }

    public static STConformanceClass$Enum forString(String str) {
        return (STConformanceClass$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
