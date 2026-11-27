package org.apache.xmlbeans.impl.values;

import java.util.function.ToIntFunction;
import org.apache.xmlbeans.SimpleValue;

/* loaded from: classes2.dex */
public final /* synthetic */ class d0 implements ToIntFunction {
    public static final /* synthetic */ d0 a = new d0();

    private /* synthetic */ d0() {
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        return ((SimpleValue) obj).getIntValue();
    }
}
