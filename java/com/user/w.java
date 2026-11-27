package com.user;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.frame.k0;
import com.frame.l0;
import com.frame.l1;
import com.frame.v0;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.user.model.PayModel;

/* loaded from: classes.dex */
public class w {
    public static w e;
    private IWXAPI a;
    private BroadcastReceiver b;
    private a c;
    private a d;

    public static abstract class a {
        public abstract void a(String str);

        public void b(String str) {
        }

        public abstract void c(String str);

        public void d() {
        }
    }

    private w() {
        if (TextUtils.isEmpty(k0.e)) {
            Log.e("微信初始化失败", "微信初始化失败--未设置APP_ID");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static String I(PayModel payModel, String str) {
        if (j(str)) {
            return "微信支付未配置";
        }
        if (payModel == null || j(payModel.getPartnerid()) || j(payModel.getPrepayid()) || j(payModel.getNoncestr()) || j(payModel.getTimestamp()) || j(payModel.getSign())) {
            return "微信支付参数不完整，请重试";
        }
        if (!j(payModel.getAppid()) && !str.equals(payModel.getAppid())) {
            return "微信支付应用配置不匹配";
        }
        if (!j(payModel.getPackageX()) && !"Sign=WXPay".equals(payModel.getPackageX())) {
            return "微信支付参数无效，请重试";
        }
        try {
            if (Long.parseLong(payModel.getTimestamp()) <= 0) {
                return "微信支付时间参数无效，请重试";
            }
            return null;
        } catch (NumberFormatException unused) {
            return "微信支付时间参数无效，请重试";
        }
    }

    private a f() {
        u uVar = new u(this);
        this.c = uVar;
        return uVar;
    }

    private void g(String str) {
        a aVar = this.d;
        this.d = null;
        if (aVar != null) {
            aVar.c(str);
        }
    }

    public static w h() {
        if (e == null) {
            e = new w();
        }
        return e;
    }

    private static boolean j(String str) {
        return str == null || str.trim().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(final a aVar) {
        try {
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "chan_ding_login_test";
            if (this.a.sendReq(req)) {
                return;
            }
            l1.e(new Runnable() { // from class: com.user.m
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.c("微信授权启动失败");
                }
            });
        } catch (Exception e2) {
            k0.r(e2);
            l1.e(new Runnable() { // from class: com.user.h
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.c("微信授权启动失败");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(PayModel payModel, a aVar) {
        String strI = I(payModel, k0.e);
        if (strI != null) {
            if (aVar != null) {
                aVar.c(strI);
                return;
            }
            return;
        }
        this.d = aVar;
        try {
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(v0.g(), k0.e, true);
            this.a = iwxapiCreateWXAPI;
            if (!iwxapiCreateWXAPI.isWXAppInstalled()) {
                g("未安装微信，请先安装微信");
                return;
            }
            if (!iwxapiCreateWXAPI.registerApp(k0.e)) {
                g("微信支付注册失败，请重试");
                return;
            }
            PayReq payReq = new PayReq();
            payReq.appId = k0.e;
            payReq.partnerId = payModel.getPartnerid();
            payReq.prepayId = payModel.getPrepayid();
            payReq.packageValue = "Sign=WXPay";
            payReq.nonceStr = payModel.getNoncestr();
            payReq.timeStamp = payModel.getTimestamp();
            payReq.sign = payModel.getSign();
            if (!iwxapiCreateWXAPI.sendReq(payReq)) {
                g("无法启动微信支付，请检查微信后重试");
            } else if (aVar != null) {
                aVar.d();
            }
        } catch (Exception e2) {
            Log.w("WechatPay", "SDK launch failed: " + e2.getClass().getSimpleName());
            g("微信支付启动失败，请重试");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(String str, String str2, String str3) {
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = str2;
        wXMediaMessage.description = str3;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.message = wXMediaMessage;
        req.scene = 0;
        this.a.sendReq(req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String str, String str2, String str3, int i2) {
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = str2;
        wXMediaMessage.description = str3;
        if (i2 != 0) {
            wXMediaMessage.thumbData = l0.a(BitmapFactory.decodeResource(v0.g().getResources(), i2), 32768.0d, true);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.message = wXMediaMessage;
        req.scene = 1;
        this.a.sendReq(req);
    }

    private void z(Context context, Runnable runnable) {
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, k0.e, true);
        this.a = iwxapiCreateWXAPI;
        if (!iwxapiCreateWXAPI.isWXAppInstalled()) {
            Toast.makeText(v0.g(), "未安装微信，请先安装微信~", 0).show();
            return;
        }
        if (this.a.registerApp(k0.e)) {
            if (runnable != null) {
                l1.g(runnable);
            }
        } else if (this.b == null) {
            this.b = new t(this, runnable);
            try {
                v0.g().registerReceiver(this.b, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP), "com.tencent.mm.plugin.permission.SEND", null);
            } catch (Exception e2) {
                k0.r(e2);
            }
        }
    }

    public void A(final a aVar) {
        z(v0.g(), new Runnable() { // from class: com.user.k
            @Override // java.lang.Runnable
            public final void run() {
                this.c.s(aVar);
            }
        });
    }

    public void B(PayModel payModel, a aVar) {
        y(payModel, aVar);
    }

    public void D(String str, String str2, String str3) {
        E(str, str2, str3, f());
    }

    public void E(final String str, final String str2, final String str3, a aVar) {
        this.c = aVar;
        z(v0.g(), new Runnable() { // from class: com.user.n
            @Override // java.lang.Runnable
            public final void run() {
                this.c.u(str3, str, str2);
            }
        });
    }

    public void F(int i2, String str, String str2, String str3) {
        G(i2, str, str2, str3, f());
    }

    public void G(final int i2, final String str, final String str2, final String str3, a aVar) {
        this.c = aVar;
        z(v0.g(), new Runnable() { // from class: com.user.l
            @Override // java.lang.Runnable
            public final void run() {
                this.c.w(str3, str, str2, i2);
            }
        });
    }

    public void H() {
        try {
            IWXAPI iwxapi = this.a;
            if (iwxapi != null) {
                iwxapi.unregisterApp();
                this.a = null;
            }
        } catch (Exception e2) {
            k0.r(e2);
        }
        try {
            if (this.b != null) {
                v0.g().unregisterReceiver(this.b);
                this.b = null;
            }
        } catch (Exception e3) {
            k0.r(e3);
        }
    }

    public void i(Intent intent) {
        try {
            if (this.a == null) {
                this.a = WXAPIFactory.createWXAPI(v0.g(), k0.e, true);
            }
            this.a.handleIntent(intent, new v(this));
        } catch (Exception e2) {
            k0.r(e2);
        }
    }

    public boolean k(Context context) {
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, k0.e, true);
        this.a = iwxapiCreateWXAPI;
        return iwxapiCreateWXAPI.isWXAppInstalled();
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void s(final a aVar) {
        this.c = aVar;
        l1.g(new Runnable() { // from class: com.user.j
            @Override // java.lang.Runnable
            public final void run() {
                this.c.o(aVar);
            }
        });
    }

    public void y(final PayModel payModel, final a aVar) {
        C(new Runnable() { // from class: com.user.i
            @Override // java.lang.Runnable
            public final void run() {
                this.c.q(payModel, aVar);
            }
        });
    }
}
