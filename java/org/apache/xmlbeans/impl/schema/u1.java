package org.apache.xmlbeans.impl.schema;

import java.util.function.Function;
import org.apache.xmlbeans.SchemaIdentityConstraint;

/* loaded from: classes.dex */
public final /* synthetic */ class u1 implements Function {
    public static final /* synthetic */ u1 a = new u1();

    private /* synthetic */ u1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((SchemaIdentityConstraint.Ref) obj).get();
    }
}
