package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class g0 implements BiConsumer {
    public static final /* synthetic */ g0 a = new g0();

    private /* synthetic */ g0() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((XmlObjectBase) obj).setStringValue((String) obj2);
    }
}
