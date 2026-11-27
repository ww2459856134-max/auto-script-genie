package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class f implements BiConsumer {
    public static final /* synthetic */ f a = new f();

    private /* synthetic */ f() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((XmlObjectBase) obj).setObjectValue(obj2);
    }
}
