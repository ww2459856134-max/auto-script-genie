package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl;

import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class z5 implements Consumer {
    public final /* synthetic */ CTVectorImpl a;

    public /* synthetic */ z5(CTVectorImpl cTVectorImpl) {
        this.a = cTVectorImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.a.removeI1(((Integer) obj).intValue());
    }
}
