package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes3.dex */
public final class STChapterSep$Enum extends StringEnumAbstractBase {
    static final int INT_COLON = 3;
    static final int INT_EM_DASH = 4;
    static final int INT_EN_DASH = 5;
    static final int INT_HYPHEN = 1;
    static final int INT_PERIOD = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STChapterSep$Enum[]{new STChapterSep$Enum("hyphen", 1), new STChapterSep$Enum("period", 2), new STChapterSep$Enum("colon", 3), new STChapterSep$Enum("emDash", 4), new STChapterSep$Enum("enDash", 5)});

    private STChapterSep$Enum(String str, int i2) {
        super(str, i2);
    }

    public static STChapterSep$Enum forInt(int i2) {
        return (STChapterSep$Enum) table.forInt(i2);
    }

    public static STChapterSep$Enum forString(String str) {
        return (STChapterSep$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
