package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class ih implements Supplier {
    public final /* synthetic */ CTCfRuleImpl a;

    public /* synthetic */ ih(CTCfRuleImpl cTCfRuleImpl) {
        this.a = cTCfRuleImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.a.sizeOfFormulaArray());
    }
}
