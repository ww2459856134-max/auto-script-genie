package org.apache.xmlbeans.impl.schema;

import java.util.function.Function;
import org.apache.xmlbeans.SchemaAttributeGroup;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements Function {
    public static final /* synthetic */ n a = new n();

    private /* synthetic */ n() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((SchemaAttributeGroup.Ref) obj).get();
    }
}
