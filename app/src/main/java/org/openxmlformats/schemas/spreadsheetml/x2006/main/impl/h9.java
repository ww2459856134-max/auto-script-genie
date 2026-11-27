package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class h9 implements Consumer {
    public final /* synthetic */ CTProtectedRangeImpl a;

    public /* synthetic */ h9(CTProtectedRangeImpl cTProtectedRangeImpl) {
        this.a = cTProtectedRangeImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.a.removeSecurityDescriptor(((Integer) obj).intValue());
    }
}
