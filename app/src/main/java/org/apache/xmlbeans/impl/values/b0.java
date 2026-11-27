package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.GDate;

/* loaded from: classes2.dex */
public final /* synthetic */ class b0 implements BiConsumer {
    public static final /* synthetic */ b0 a = new b0();

    private /* synthetic */ b0() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((XmlObjectBase) obj).setGDateValue((GDate) obj2);
    }
}
