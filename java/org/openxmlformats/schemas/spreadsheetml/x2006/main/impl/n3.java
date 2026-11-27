package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class n3 implements Consumer {
    public final /* synthetic */ CTCfRuleImpl a;

    public /* synthetic */ n3(CTCfRuleImpl cTCfRuleImpl) {
        this.a = cTCfRuleImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.a.removeFormula(((Integer) obj).intValue());
    }
}
