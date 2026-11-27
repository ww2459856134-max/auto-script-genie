package org.apache.xmlbeans.impl.schema;

import java.util.function.Function;
import org.apache.xmlbeans.SchemaType;

/* loaded from: classes.dex */
public final /* synthetic */ class d2 implements Function {
    public static final /* synthetic */ d2 a = new d2();

    private /* synthetic */ d2() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((SchemaType.Ref) obj).get();
    }
}
