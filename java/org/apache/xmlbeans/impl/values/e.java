package org.apache.xmlbeans.impl.values;

import java.util.List;
import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class e implements BiConsumer {
    public static final /* synthetic */ e a = new e();

    private /* synthetic */ e() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((XmlObjectBase) obj).setListValue((List) obj2);
    }
}
