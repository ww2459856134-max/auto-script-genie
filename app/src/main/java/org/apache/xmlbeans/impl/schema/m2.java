package org.apache.xmlbeans.impl.schema;

import java.util.function.Function;
import org.apache.xmlbeans.SchemaType;

/* loaded from: classes.dex */
public final /* synthetic */ class m2 implements Function {
    public static final /* synthetic */ m2 a = new m2();

    private /* synthetic */ m2() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((SchemaType) obj).getRef();
    }
}
