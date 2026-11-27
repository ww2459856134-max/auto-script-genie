package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes2.dex */
public final /* synthetic */ class h0 implements BiConsumer {
    public static final /* synthetic */ h0 a = new h0();

    private /* synthetic */ h0() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((XmlObjectBase) obj).setEnumValue((StringEnumAbstractBase) obj2);
    }
}
