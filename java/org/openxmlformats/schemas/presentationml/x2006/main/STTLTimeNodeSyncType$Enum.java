package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes2.dex */
public final class STTLTimeNodeSyncType$Enum extends StringEnumAbstractBase {
    static final int INT_CAN_SLIP = 1;
    static final int INT_LOCKED = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTLTimeNodeSyncType$Enum[]{new STTLTimeNodeSyncType$Enum("canSlip", 1), new STTLTimeNodeSyncType$Enum("locked", 2)});

    private STTLTimeNodeSyncType$Enum(String str, int i2) {
        super(str, i2);
    }

    public static STTLTimeNodeSyncType$Enum forInt(int i2) {
        return (STTLTimeNodeSyncType$Enum) table.forInt(i2);
    }

    public static STTLTimeNodeSyncType$Enum forString(String str) {
        return (STTLTimeNodeSyncType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
