package com.user;

import com.frame.l1;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.user.p;
import org.json.JSONObject;

/* loaded from: classes.dex */
class o implements IUiListener {
    final /* synthetic */ p a;

    o(p pVar) {
        this.a = pVar;
    }

    @Override // com.tencent.tauth.IUiListener
    public void onCancel() {
        final p.a aVar = this.a.c;
        if (aVar != null) {
            l1.e(new Runnable() { // from class: com.user.c
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.b("已取消QQ登录");
                }
            });
        }
    }

    @Override // com.tencent.tauth.IUiListener
    public void onComplete(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        final String strOptString = jSONObject.optString("openid");
        final String strOptString2 = jSONObject.optString(Constants.PARAM_ACCESS_TOKEN);
        final p.a aVar = this.a.c;
        if (aVar != null) {
            l1.e(new Runnable() { // from class: com.user.d
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a(strOptString2, strOptString);
                }
            });
        }
    }

    @Override // com.tencent.tauth.IUiListener
    public void onError(UiError uiError) {
        final p.a aVar = this.a.c;
        if (aVar != null) {
            l1.e(new Runnable() { // from class: com.user.e
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.b("QQ授权失败，请重试");
                }
            });
        }
    }

    @Override // com.tencent.tauth.IUiListener
    public void onWarning(int i2) {
    }
}
