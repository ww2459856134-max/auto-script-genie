package org.apache.xmlbeans.impl.values;

import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Function {
    public static final /* synthetic */ c a = new c();

    private /* synthetic */ c() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((XmlObjectBase) obj).getEnumValue();
    }
}
