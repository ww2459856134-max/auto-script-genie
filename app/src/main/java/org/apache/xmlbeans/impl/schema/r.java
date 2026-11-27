package org.apache.xmlbeans.impl.schema;

import java.util.function.Function;
import org.apache.xmlbeans.SchemaComponent;

/* loaded from: classes.dex */
public final /* synthetic */ class r implements Function {
    public static final /* synthetic */ r a = new r();

    private /* synthetic */ r() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((SchemaComponent) obj).getComponentRef();
    }
}
