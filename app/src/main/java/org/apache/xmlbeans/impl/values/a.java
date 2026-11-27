package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements BiConsumer {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((XmlObjectBase) obj).setBigDecimalValue((BigDecimal) obj2);
    }
}
