package com.v;

import com.v.PageScrollDialogView;
import com.yl.float_ui.InputDialogView;

/* loaded from: classes.dex */
class mt implements InputDialogView.a {
    final /* synthetic */ PageScrollDialogView.b a;

    mt(PageScrollDialogView.b bVar) {
        this.a = bVar;
    }

    @Override // com.yl.float_ui.InputDialogView.a
    public boolean a(String str) {
        PageScrollDialogView.this.f1028h.setSelectSubLabel(str);
        return true;
    }
}
