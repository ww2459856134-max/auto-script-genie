package com.yl.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.yl.ui.v;

/* loaded from: classes.dex */
class t implements TextWatcher {
    final /* synthetic */ v.a c;

    t(v.a aVar) {
        this.c = aVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.c.f1156j = editable.toString();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
