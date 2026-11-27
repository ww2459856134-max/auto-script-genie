package org.apache.xmlbeans.impl.values;

import java.util.function.BiConsumer;
import org.apache.poi.javax.xml.namespace.QName;

/* loaded from: classes2.dex */
public final /* synthetic */ class j0 implements BiConsumer {
    public static final /* synthetic */ j0 a = new j0();

    private /* synthetic */ j0() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((XmlObjectBase) obj).setQNameValue((QName) obj2);
    }
}
