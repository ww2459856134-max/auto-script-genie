package org.apache.xmlbeans.impl.values;

import java.util.Calendar;
import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class b implements BiConsumer {
    public static final /* synthetic */ b a = new b();

    private /* synthetic */ b() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((XmlObjectBase) obj).setCalendarValue((Calendar) obj2);
    }
}
