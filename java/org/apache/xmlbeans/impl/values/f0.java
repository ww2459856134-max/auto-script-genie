package org.apache.xmlbeans.impl.values;

import java.math.BigInteger;
import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class f0 implements BiConsumer {
    public static final /* synthetic */ f0 a = new f0();

    private /* synthetic */ f0() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((XmlObjectBase) obj).setBigIntegerValue((BigInteger) obj2);
    }
}
