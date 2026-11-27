package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class d2 implements Consumer {
    public final /* synthetic */ CTAuthorsImpl a;

    public /* synthetic */ d2(CTAuthorsImpl cTAuthorsImpl) {
        this.a = cTAuthorsImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.a.removeAuthor(((Integer) obj).intValue());
    }
}
