package org.apache.xmlbeans.impl.schema;

import java.util.List;
import java.util.function.Function;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Function {
    public static final /* synthetic */ c a = new c();

    private /* synthetic */ c() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((List) obj).stream();
    }
}
