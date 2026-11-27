package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a;
import com.tencent.open.a.g;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.h;
import com.tencent.open.utils.l;
import com.tencent.tauth.AuthActivity;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class TDialog extends b {
    static final FrameLayout.LayoutParams c = new FrameLayout.LayoutParams(-1, -1);
    static Toast d = null;
    private static WeakReference<ProgressDialog> f;
    private WeakReference<Context> e;
    private String g;

    /* renamed from: h, reason: collision with root package name */
    private OnTimeListener f865h;

    /* renamed from: i, reason: collision with root package name */
    private IUiListener f866i;

    /* renamed from: j, reason: collision with root package name */
    private FrameLayout f867j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.open.b.b f868k;

    /* renamed from: l, reason: collision with root package name */
    private Handler f869l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f870m;

    /* renamed from: n, reason: collision with root package name */
    private QQToken f871n;

    /* compiled from: ProGuard */
    private class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.f868k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            TDialog.this.f865h.onError(new UiError(i2, str, str2));
            if (TDialog.this.e != null && TDialog.this.e.get() != null) {
                Toast.makeText((Context) TDialog.this.e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(h.a().a((Context) TDialog.this.e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f865h.onComplete(l.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f865h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(".apk")) {
                return str.startsWith("auth://progress");
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                intent.addFlags(268435456);
                if (TDialog.this.e != null && TDialog.this.e.get() != null) {
                    ((Context) TDialog.this.e.get()).startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    /* compiled from: ProGuard */
    private class JsListener extends a.b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            SLog.d("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.f869l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel("cancel");
        }

        public void onCancelInvite() {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.f869l.obtainMessage(1, str).sendToTarget();
            SLog.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.f869l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.f869l.obtainMessage(3, str).sendToTarget();
        }
    }

    /* compiled from: ProGuard */
    private static class OnTimeListener extends DefaultUiListener {
        String a;
        String b;
        private WeakReference<Context> c;
        private String d;
        private IUiListener e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
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
    private class THandler extends Handler {
        private OnTimeListener b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            SLog.d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
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
                if (TDialog.this.e == null || TDialog.this.e.get() == null) {
                    return;
                }
                TDialog.c((Context) TDialog.this.e.get(), (String) message.obj);
                return;
            }
            if (i2 != 5 || TDialog.this.e == null || TDialog.this.e.get() == null) {
                return;
            }
            TDialog.d((Context) TDialog.this.e.get(), (String) message.obj);
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f870m = false;
        this.f871n = null;
        this.e = new WeakReference<>(context);
        this.g = str2;
        this.f865h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f869l = new THandler(this.f865h, context.getMainLooper());
        this.f866i = iUiListener;
        this.f871n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f865h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.TDialog.1
            @Override // java.lang.Runnable
            public void run() {
                View decorView;
                View childAt;
                Window window = TDialog.this.getWindow();
                if (window == null || (decorView = window.getDecorView()) == null || (childAt = ((ViewGroup) decorView).getChildAt(0)) == null) {
                    return;
                }
                childAt.setPadding(0, 0, 0, 0);
            }
        });
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str) throws JSONException {
        try {
            JSONObject jSONObjectD = l.d(str);
            int i2 = jSONObjectD.getInt(SocialConstants.PARAM_TYPE);
            String string = jSONObjectD.getString(SocialConstants.PARAM_SEND_MSG);
            if (i2 == 0) {
                Toast toast = d;
                if (toast == null) {
                    d = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    d.setText(string);
                    d.setDuration(0);
                }
                d.show();
                return;
            }
            if (i2 == 1) {
                Toast toast2 = d;
                if (toast2 == null) {
                    d = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    d.setText(string);
                    d.setDuration(1);
                }
                d.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) throws JSONException {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject jSONObjectD = l.d(str);
            int i2 = jSONObjectD.getInt(AuthActivity.ACTION_KEY);
            String string = jSONObjectD.getString(SocialConstants.PARAM_SEND_MSG);
            if (i2 == 1) {
                WeakReference<ProgressDialog> weakReference = f;
                if (weakReference == null || weakReference.get() == null) {
                    ProgressDialog progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage(string);
                    f = new WeakReference<>(progressDialog);
                    progressDialog.show();
                } else {
                    f.get().setMessage(string);
                    if (!f.get().isShowing()) {
                        f.get().show();
                    }
                }
            } else if (i2 == 0) {
                WeakReference<ProgressDialog> weakReference2 = f;
                if (weakReference2 == null) {
                    return;
                }
                if (weakReference2.get() != null && f.get().isShowing()) {
                    f.get().dismiss();
                    f = null;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void a() {
        new TextView(this.e.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.b.b bVar = new com.tencent.open.b.b(this.e.get());
        this.f868k = bVar;
        bVar.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.e.get());
        this.f867j = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f867j.addView(this.f868k);
        setContentView(this.f867j);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.f868k.setVerticalScrollBarEnabled(false);
        this.f868k.setHorizontalScrollBarEnabled(false);
        this.f868k.setWebViewClient(new FbWebViewClient());
        this.f868k.setWebChromeClient(this.b);
        this.f868k.clearFormData();
        WebSettings settings = this.f868k.getSettings();
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
        WeakReference<Context> weakReference = this.e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.a.a(new JsListener(), "sdk_js_if");
        this.f868k.loadUrl(this.g);
        this.f868k.setLayoutParams(c);
        this.f868k.setVisibility(4);
        this.f868k.getSettings().setSavePassword(false);
    }

    @Override // com.tencent.open.b
    protected void a(String str) {
        SLog.d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.a.a(this.f868k, str);
        } catch (Exception unused) {
        }
    }
}
