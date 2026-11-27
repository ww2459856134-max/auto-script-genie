package org.apache.xmlbeans.impl.values;

import java.util.function.ToDoubleFunction;
import org.apache.xmlbeans.SimpleValue;

/* loaded from: classes2.dex */
public final /* synthetic */ class a0 implements ToDoubleFunction {
    public static final /* synthetic */ a0 a = new a0();

    private /* synthetic */ a0() {
    }

    @Override // java.util.function.ToDoubleFunction
    public final double applyAsDouble(Object obj) {
        return ((SimpleValue) obj).getDoubleValue();
    }
}
