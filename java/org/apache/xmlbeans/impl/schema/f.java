package org.apache.xmlbeans.impl.schema;

import java.util.function.Consumer;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Consumer {
    public final /* synthetic */ XsbReader a;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.a.writeString((String) obj);
    }
}
