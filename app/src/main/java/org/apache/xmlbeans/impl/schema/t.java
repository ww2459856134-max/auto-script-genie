package org.apache.xmlbeans.impl.schema;

import java.util.function.Function;
import org.apache.xmlbeans.SchemaGlobalElement;

/* loaded from: classes.dex */
public final /* synthetic */ class t implements Function {
    public static final /* synthetic */ t a = new t();

    private /* synthetic */ t() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((SchemaGlobalElement.Ref) obj).get();
    }
}
