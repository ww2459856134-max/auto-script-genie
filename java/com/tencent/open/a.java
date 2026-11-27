package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class a {
    protected HashMap<String, b> a = new HashMap<>();

    /* compiled from: ProGuard */
    public static class b {
        public void call(String str, List<String> list, C0009a c0009a) throws SecurityException {
            Method method;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i2];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                } else {
                    i2++;
                }
            }
            if (method == null) {
                if (c0009a != null) {
                    c0009a.a();
                    return;
                }
                return;
            }
            try {
                int size = list.size();
                Object objInvoke = size != 0 ? size != 1 ? size != 2 ? size != 3 ? size != 4 ? size != 5 ? method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)) : method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)) : method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3)) : method.invoke(this, list.get(0), list.get(1), list.get(2)) : method.invoke(this, list.get(0), list.get(1)) : method.invoke(this, list.get(0)) : method.invoke(this, new Object[0]);
                Class<?> returnType = method.getReturnType();
                SLog.d("openSDK_LOG.JsBridge", "-->call, result: " + objInvoke + " | ReturnType: " + returnType.getName());
                if (!"void".equals(returnType.getName()) && returnType != Void.class) {
                    if (c0009a == null || !customCallback()) {
                        return;
                    }
                    c0009a.a(objInvoke != null ? objInvoke.toString() : null);
                    return;
                }
                if (c0009a != null) {
                    c0009a.a((Object) null);
                }
            } catch (Exception e) {
                SLog.e("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e);
                if (c0009a != null) {
                    c0009a.a();
                }
            }
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(b bVar, String str) {
        this.a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C0009a c0009a) throws SecurityException {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                list.set(i2, URLDecoder.decode(list.get(i2), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        b bVar = this.a.get(str);
        if (bVar != null) {
            SLog.d("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c0009a);
        } else {
            SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (c0009a != null) {
                c0009a.a();
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.a$a, reason: collision with other inner class name */
    public static class C0009a {
        protected WeakReference<WebView> a;
        protected long b;
        protected String c;

        public C0009a(WebView webView, long j2, String str) {
            this.a = new WeakReference<>(webView);
            this.b = j2;
            this.c = str;
        }

        public void a(Object obj) {
            String string;
            WebView webView = this.a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                string = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else {
                string = ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Boolean)) ? obj.toString() : "'undefined'";
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + string + "});");
        }

        public void a() {
            WebView webView = this.a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})");
        }

        public void a(String str) {
            WebView webView = this.a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    public boolean a(WebView webView, String str) throws SecurityException {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List<String> listSubList = arrayList.subList(4, arrayList.size() - 1);
        C0009a c0009a = new C0009a(webView, 4L, str);
        webView.getUrl();
        a(str2, str3, listSubList, c0009a);
        return true;
    }
}
