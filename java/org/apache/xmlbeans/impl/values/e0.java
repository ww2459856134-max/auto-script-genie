package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.GDuration;

/* loaded from: classes2.dex */
public final /* synthetic */ class e0 implements BiConsumer {
    public static final /* synthetic */ e0 a = new e0();

    private /* synthetic */ e0() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((XmlObjectBase) obj).setGDurationValue((GDuration) obj2);
    }
}
