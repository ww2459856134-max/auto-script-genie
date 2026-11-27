package org.apache.xmlbeans.impl.schema;

import java.util.function.Function;
import org.apache.xmlbeans.SchemaModelGroup;

/* loaded from: classes.dex */
public final /* synthetic */ class t1 implements Function {
    public static final /* synthetic */ t1 a = new t1();

    private /* synthetic */ t1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((SchemaModelGroup.Ref) obj).get();
    }
}
