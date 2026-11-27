package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class d7 implements Supplier {
    public final /* synthetic */ CTAuthorsImpl a;

    public /* synthetic */ d7(CTAuthorsImpl cTAuthorsImpl) {
        this.a = cTAuthorsImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.a.sizeOfAuthorArray());
    }
}
