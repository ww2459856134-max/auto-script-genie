package org.apache.xmlbeans.impl.values;

import java.util.Date;
import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class d implements BiConsumer {
    public static final /* synthetic */ d a = new d();

    private /* synthetic */ d() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((XmlObjectBase) obj).setDateValue((Date) obj2);
    }
}
