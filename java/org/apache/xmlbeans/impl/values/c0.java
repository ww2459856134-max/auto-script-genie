package org.apache.xmlbeans.impl.values;

import java.util.function.ToLongFunction;
import org.apache.xmlbeans.SimpleValue;

/* loaded from: classes2.dex */
public final /* synthetic */ class c0 implements ToLongFunction {
    public static final /* synthetic */ c0 a = new c0();

    private /* synthetic */ c0() {
    }

    @Override // java.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        return ((SimpleValue) obj).getLongValue();
    }
}
