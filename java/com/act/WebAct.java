package com.act;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.s;
import com.frame.i0;
import com.frame.k0;
import com.frame.v0;
import com.tencent.open.SocialConstants;
import i.a.k;

/* loaded from: classes.dex */
public class WebAct extends s implements View.OnClickListener {
    private static String U;
    private static String V;
    private WebView J;
    private ProgressBar K;
    private k M;
    private String O;
    private boolean P;
    private volatile boolean Q;

    class a extends WebViewClient {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(View view) {
            if (WebAct.this.Q || WebAct.this.isFinishing()) {
                return;
            }
            WebAct.this.recreate();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webView == WebAct.this.J && WebAct.this.a0()) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (TextUtils.isEmpty(WebAct.this.O)) {
                    return;
                }
                WebAct webAct = WebAct.this;
                webAct.d0(webAct.O);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w("WebAct", "Renderer terminated; crashed=" + renderProcessGoneDetail.didCrash());
            if (webView == WebAct.this.J) {
                WebAct.this.J = null;
                WebAct.this.K.setVisibility(8);
                if (!WebAct.this.Q && !WebAct.this.isFinishing() && (webView.getParent() instanceof ViewGroup)) {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    int iIndexOfChild = viewGroup.indexOfChild(webView);
                    ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
                    viewGroup.removeView(webView);
                    TextView textView = new TextView(WebAct.this);
                    textView.setText("网页已停止，点此重新加载");
                    textView.setGravity(17);
                    textView.setTextSize(16.0f);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.act.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.c.b(view);
                        }
                    });
                    viewGroup.addView(textView, iIndexOfChild, layoutParams);
                }
            }
            WebAct.this.e0(webView);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith("file:///android_asset/")) {
                WebAct.this.d0(str);
                return true;
            }
            if ((str.startsWith("http") || str.startsWith("https")) && !str.endsWith(".apk")) {
                WebAct.this.d0(str);
            } else {
                try {
                    WebAct.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e) {
                    k0.r(e);
                }
            }
            return true;
        }
    }

    class b extends WebChromeClient {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            if (webView == WebAct.this.J && WebAct.this.a0()) {
                if (i2 != 100) {
                    WebAct.this.K.setVisibility(0);
                    WebAct.this.K.setProgress(i2);
                    return;
                }
                WebAct.this.K.setVisibility(8);
                WebAct.this.J.getSettings().setBlockNetworkImage(false);
                if (webView.getUrl() == null || !webView.getUrl().equals(this.a) || TextUtils.isEmpty(this.b)) {
                    return;
                }
                WebAct.this.M.l(this.b);
            }
        }
    }

    class c implements DownloadListener {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            try {
                WebAct.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                TextUtils.isEmpty(this.a);
            } catch (Exception e) {
                k0.r(e);
            }
        }
    }

    private boolean Z(String str) {
        Uri uri = Uri.parse(str);
        return "https".equals(uri.getScheme()) && ("h5.skyingidea.com".equals(uri.getHost()) || "mgr.skyingidea.com".equals(uri.getHost()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a0() {
        return (this.Q || this.J == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c0(String str) {
        if (a0()) {
            this.J.loadUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(WebView webView) {
        try {
            if (webView.getParent() instanceof ViewGroup) {
                ((ViewGroup) webView.getParent()).removeView(webView);
            }
        } finally {
            webView.destroy();
        }
    }

    public void d0(final String str) {
        if (!a0() || TextUtils.isEmpty(str)) {
            return;
        }
        this.J.post(new Runnable() { // from class: com.act.c
            @Override // java.lang.Runnable
            public final void run() {
                this.c.c0(str);
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.P) {
            finish();
            return;
        }
        try {
            WebView webView = this.J;
            if (webView == null || !webView.canGoBack()) {
                super.onBackPressed();
            } else {
                this.J.goBack();
            }
        } catch (Exception e) {
            k0.r(e);
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != j.a.a.c && view.getId() == j.a.a.b) {
            onBackPressed();
        }
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            try {
                i0.k(this, true);
                super.onCreate(bundle);
                setContentView(j.a.b.a);
                this.K = (ProgressBar) findViewById(j.a.a.e);
                this.M = new k();
                findViewById(j.a.a.c).setOnClickListener(this);
                findViewById(j.a.a.b).setOnClickListener(this);
                String stringExtra = getIntent().getStringExtra("jsName");
                String stringExtra2 = getIntent().getStringExtra("jsClass");
                this.P = getIntent().getBooleanExtra("isBackClose", false);
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                    return;
                }
                V = stringExtra2;
                U = stringExtra;
            } catch (Exception e) {
                e.printStackTrace();
                finish();
            }
        } catch (Exception unused) {
            String stringExtra3 = getIntent().getStringExtra(SocialConstants.PARAM_URL);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringExtra3));
            intent.setFlags(268435456);
            v0.g().startActivity(intent);
            finish();
        }
    }

    @Override // androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        this.Q = true;
        WebView webView = this.J;
        this.J = null;
        super.onDestroy();
        if (webView != null) {
            try {
                webView.stopLoading();
            } catch (Exception unused) {
            }
            try {
                webView.loadUrl("about:blank");
            } catch (Exception unused2) {
            }
            try {
                webView.clearHistory();
                webView.clearCache(true);
            } catch (Exception unused3) {
            }
            try {
                webView.setWebViewClient(null);
                webView.setWebChromeClient(null);
                webView.setDownloadListener(null);
            } catch (Exception unused4) {
            }
            try {
                e0(webView);
            } catch (Exception e) {
                k0.r(e);
            }
        }
    }

    @Override // androidx.fragment.app.h0, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            if (!"android.intent.action.VIEW".equals(intent.getAction()) || intent.getData() == null) {
                return;
            }
            d0(intent.getData().toString());
        } catch (Exception e) {
            k0.r(e);
        }
    }

    @Override // androidx.fragment.app.h0, android.app.Activity
    public void onPause() {
        super.onPause();
        if (v0.g().l()) {
            k0.j(this);
        }
    }

    @Override // androidx.appcompat.app.s, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    protected void onPostCreate(Bundle bundle) {
        String string;
        String str;
        super.onPostCreate(bundle);
        Intent intent = getIntent();
        if (!"android.intent.action.VIEW".equals(intent.getAction()) || intent.getData() == null) {
            this.O = intent.getStringExtra("errorPage");
            String stringExtra = intent.getStringExtra(SocialConstants.PARAM_URL);
            String stringExtra2 = intent.getStringExtra("key");
            String stringExtra3 = intent.getStringExtra("title");
            if (!TextUtils.isEmpty(stringExtra3)) {
                ((TextView) findViewById(j.a.a.d)).setText(stringExtra3);
            }
            string = stringExtra;
            str = stringExtra2;
        } else {
            string = intent.getData().toString();
            str = null;
        }
        WebView webView = (WebView) findViewById(j.a.a.f1740k);
        this.J = webView;
        if (webView == null || TextUtils.isEmpty(string)) {
            finish();
            return;
        }
        boolean zStartsWith = string.startsWith("file:///android_asset/");
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                this.J.removeJavascriptInterface("searchBoxJavaBridge_");
                this.J.removeJavascriptInterface("accessibility");
                this.J.removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Exception e) {
            k0.r(e);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 18) {
            this.J.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        }
        CookieManager cookieManager = CookieManager.getInstance();
        if (i2 >= 21) {
            cookieManager.setAcceptThirdPartyCookies(this.J, true);
        }
        this.J.getSettings().setJavaScriptEnabled(true);
        try {
            if (V != null && U != null && i2 >= 17 && Z(string)) {
                this.J.addJavascriptInterface(Class.forName(V).newInstance(), U);
            }
        } catch (Exception e2) {
            k0.r(e2);
        }
        this.J.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.J.getSettings().setAllowFileAccess(zStartsWith);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 16) {
            this.J.getSettings().setAllowFileAccessFromFileURLs(false);
            this.J.getSettings().setAllowUniversalAccessFromFileURLs(false);
        }
        this.J.getSettings().setDomStorageEnabled(true);
        this.J.getSettings().setDatabaseEnabled(true);
        this.J.setWebViewClient(new a());
        if (i3 >= 26) {
            this.J.setRendererPriorityPolicy(2, true);
        }
        this.J.getSettings().setBlockNetworkImage(true);
        this.J.setWebChromeClient(new b(string, str));
        this.J.setDownloadListener(new c(str));
        if (this.Q) {
            return;
        }
        d0(string);
    }

    @Override // androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        v0.g().o(this);
        if (v0.g().l()) {
            k0.k(this);
        }
    }
}
