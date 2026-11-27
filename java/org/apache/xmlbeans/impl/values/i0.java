package org.apache.xmlbeans.impl.values;

import java.util.function.Function;
import org.apache.xmlbeans.SimpleValue;

/* loaded from: classes2.dex */
public final /* synthetic */ class i0 implements Function {
    public final /* synthetic */ Class a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return (SimpleValue) this.a.cast((XmlObjectBase) obj);
    }
}
