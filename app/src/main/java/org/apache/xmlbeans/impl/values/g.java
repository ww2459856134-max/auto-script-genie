package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class g implements BiConsumer {
    public static final /* synthetic */ g a = new g();

    private /* synthetic */ g() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((XmlObjectBase) obj).setByteArrayValue((byte[]) obj2);
    }
}
