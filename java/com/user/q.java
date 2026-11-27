package com.user;

import com.frame.k0;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

/* loaded from: classes.dex */
class q implements IUiListener {
    private q(p pVar) {
    }

    @Override // com.tencent.tauth.IUiListener
    public void onCancel() {
        k0.i("share_cancel");
    }

    @Override // com.tencent.tauth.IUiListener
    public void onComplete(Object obj) {
        k0.i("share_success");
    }

    @Override // com.tencent.tauth.IUiListener
    public void onError(UiError uiError) {
        k0.i("share_error");
    }

    @Override // com.tencent.tauth.IUiListener
    public void onWarning(int i2) {
    }

    /* synthetic */ q(p pVar, o oVar) {
        this(pVar);
    }
}
