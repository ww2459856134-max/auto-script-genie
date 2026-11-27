package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a;
import com.tencent.open.a.g;
import com.tencent.open.b.a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.h;
import com.tencent.open.utils.l;
import com.tencent.tauth.AuthActivity;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class c extends com.tencent.open.b implements a.InterfaceC0010a {
    static Toast c;
    private String d;
    private IUiListener e;
    private C0011c f;
    private Handler g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.open.b.a f874h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.open.b.b f875i;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<Context> f876j;

    /* renamed from: k, reason: collision with root package name */
    private int f877k;

    /* compiled from: ProGuard */
    private class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            c.this.f875i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            c.this.f.onError(new UiError(i2, str, str2));
            if (c.this.f876j != null && c.this.f876j.get() != null) {
                Toast.makeText((Context) c.this.f876j.get(), "网络连接异常或系统错误", 0).show();
            }
            c.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(h.a().a((Context) c.this.f876j.get(), "auth://tauth.qq.com/"))) {
                c.this.f.onComplete(l.c(str));
                c.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                c.this.f.onCancel();
                c.this.dismiss();
                return true;
            }
            if (!str.startsWith(Constants.CLOSE_URI)) {
                return false;
            }
            c.this.dismiss();
            return true;
        }
    }

    /* compiled from: ProGuard */
    private class b extends a.b {
        private b() {
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.c$c, reason: collision with other inner class name */
    private static class C0011c extends DefaultUiListener {
        String a;
        String b;
        private WeakReference<Context> c;
        private String d;
        private IUiListener e;

        public C0011c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.c = new WeakReference<>(context);
            this.d = str;
            this.a = str2;
            this.b = str3;
            this.e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.a, false);
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.a;
            } else {
                str = this.a;
            }
            g gVarA = g.a();
            gVarA.a(this.d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(l.d(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* compiled from: ProGuard */
    private class d extends Handler {
        private C0011c b;

        public d(C0011c c0011c, Looper looper) {
            super(looper);
            this.b = c0011c;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.b.a((String) message.obj);
                return;
            }
            if (i2 == 2) {
                this.b.onCancel();
                return;
            }
            if (i2 == 3) {
                if (c.this.f876j == null || c.this.f876j.get() == null) {
                    return;
                }
                c.c((Context) c.this.f876j.get(), (String) message.obj);
                return;
            }
            if (i2 != 5 || c.this.f876j == null || c.this.f876j.get() == null) {
                return;
            }
            c.d((Context) c.this.f876j.get(), (String) message.obj);
        }
    }

    public c(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f876j = new WeakReference<>(context);
        this.d = str2;
        this.f = new C0011c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.g = new d(this.f, context.getMainLooper());
        this.e = iUiListener;
        this.f877k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f877k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) throws JSONException {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject jSONObjectD = l.d(str);
            jSONObjectD.getInt(AuthActivity.ACTION_KEY);
            jSONObjectD.getString(SocialConstants.PARAM_SEND_MSG);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    protected void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.f875i.setVerticalScrollBarEnabled(false);
        this.f875i.setHorizontalScrollBarEnabled(false);
        this.f875i.setWebViewClient(new a());
        this.f875i.setWebChromeClient(this.b);
        this.f875i.clearFormData();
        WebSettings settings = this.f875i.getSettings();
        if (settings == null) {
            return;
        }
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        WeakReference<Context> weakReference = this.f876j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f876j.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.a.a(new b(), "sdk_js_if");
        this.f875i.clearView();
        this.f875i.loadUrl(this.d);
        this.f875i.getSettings().setSavePassword(false);
    }

    private void b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        com.tencent.open.b.a aVar = new com.tencent.open.b.a(this.f876j.get());
        this.f874h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.f874h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.b.b bVar = new com.tencent.open.b.b(this.f876j.get());
        this.f875i = bVar;
        bVar.setBackgroundColor(0);
        this.f875i.setBackgroundDrawable(null);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f875i, 1, new Paint());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f877k);
        layoutParams.addRule(13, -1);
        this.f875i.setLayoutParams(layoutParams);
        this.f874h.addView(this.f875i);
        this.f874h.a(this);
        setContentView(this.f874h);
    }

    @Override // com.tencent.open.b.a.InterfaceC0010a
    public void a(int i2) {
        WeakReference<Context> weakReference = this.f876j;
        if (weakReference != null && weakReference.get() != null) {
            if (i2 < this.f877k && 2 == this.f876j.get().getResources().getConfiguration().orientation) {
                this.f875i.getLayoutParams().height = i2;
            } else {
                this.f875i.getLayoutParams().height = this.f877k;
            }
        }
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.b.a.InterfaceC0010a
    public void a() {
        this.f875i.getLayoutParams().height = this.f877k;
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.b
    protected void a(String str) {
        SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.a.a(this.f875i, str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) throws JSONException {
        try {
            JSONObject jSONObjectD = l.d(str);
            int i2 = jSONObjectD.getInt(SocialConstants.PARAM_TYPE);
            String string = jSONObjectD.getString(SocialConstants.PARAM_SEND_MSG);
            if (i2 == 0) {
                Toast toast = c;
                if (toast == null) {
                    c = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    c.setText(string);
                    c.setDuration(0);
                }
                c.show();
                return;
            }
            if (i2 == 1) {
                Toast toast2 = c;
                if (toast2 == null) {
                    c = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    c.setText(string);
                    c.setDuration(1);
                }
                c.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
