package com.user;

import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.user.w;

/* loaded from: classes.dex */
class v implements IWXAPIEventHandler {
    final /* synthetic */ w a;

    v(w wVar) {
        this.a = wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(BaseResp baseResp) {
        String str;
        w.a aVar = this.a.d;
        this.a.d = null;
        if (aVar == null) {
            return;
        }
        if (baseResp.errCode == 0 && baseResp.getType() == 5) {
            aVar.a(baseResp.openId);
            return;
        }
        if (baseResp.errCode == -2) {
            aVar.c("已取消微信支付");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("微信支付失败（");
        sb.append(baseResp.errCode);
        sb.append("）");
        if (TextUtils.isEmpty(baseResp.errStr)) {
            str = "";
        } else {
            str = "：" + baseResp.errStr;
        }
        sb.append(str);
        aVar.c(sb.toString());
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(final BaseResp baseResp) {
        if (baseResp instanceof PayResp) {
            w.C(new Runnable() { // from class: com.user.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.b(baseResp);
                }
            });
            return;
        }
        if (this.a.c == null) {
            return;
        }
        if (baseResp instanceof SendAuth.Resp) {
            if (baseResp.errCode == 0) {
                this.a.c.a(((SendAuth.Resp) baseResp).code);
                return;
            } else {
                this.a.c.c(baseResp.openId);
                return;
            }
        }
        if (baseResp instanceof SendMessageToWX.Resp) {
            int i2 = baseResp.errCode;
            if (i2 == -2) {
                this.a.c.b(baseResp.openId);
            } else if (i2 != 0) {
                this.a.c.c(baseResp.openId);
            } else {
                this.a.c.a(baseResp.openId);
            }
        }
    }
}
