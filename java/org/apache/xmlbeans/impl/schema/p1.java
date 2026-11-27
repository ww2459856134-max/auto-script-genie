package org.apache.xmlbeans.impl.schema;

import java.util.function.Function;
import org.apache.xmlbeans.SchemaGlobalAttribute;

/* loaded from: classes.dex */
public final /* synthetic */ class p1 implements Function {
    public static final /* synthetic */ p1 a = new p1();

    private /* synthetic */ p1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((SchemaGlobalAttribute.Ref) obj).get();
    }
}
