package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class x8 implements Supplier {
    public final /* synthetic */ CTProtectedRangeImpl a;

    public /* synthetic */ x8(CTProtectedRangeImpl cTProtectedRangeImpl) {
        this.a = cTProtectedRangeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.a.sizeOfSecurityDescriptorArray());
    }
}
