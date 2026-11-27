package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class g {
    private static Map<String, g> a = Collections.synchronizedMap(new HashMap());
    private static String b = null;
    private Context c;
    private String d;
    private JSONObject e = null;
    private long f = 0;
    private int g = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f895h = true;

    private g(Context context, String str) {
        this.c = null;
        this.d = null;
        this.c = context.getApplicationContext();
        this.d = str;
        a();
        b();
    }

    private void b() {
        if (this.g != 0) {
            d("update thread is running, return");
            return;
        }
        this.g = 1;
        final Bundle bundle = new Bundle();
        bundle.putString("appid", this.d);
        bundle.putString("appid_for_getting_config", this.d);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        new Thread() { // from class: com.tencent.open.utils.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    g.this.a(l.d(HttpUtils.openUrl2(g.this.c, "https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", Constants.HTTP_GET, bundle).a));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                g.this.g = 0;
            }
        }.start();
    }

    private String c(String str) throws IOException {
        InputStream inputStreamOpen;
        String str2;
        String string = "";
        try {
            try {
                if (this.d != null) {
                    str2 = str + "." + this.d;
                } else {
                    str2 = str;
                }
                inputStreamOpen = this.c.openFileInput(str2);
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        } catch (FileNotFoundException unused) {
            inputStreamOpen = this.c.getAssets().open(str);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charset.forName("UTF-8")));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        stringBuffer.append(line);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    inputStreamOpen.close();
                    bufferedReader.close();
                }
            } catch (Throwable th) {
                try {
                    inputStreamOpen.close();
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        string = stringBuffer.toString();
        inputStreamOpen.close();
        bufferedReader.close();
        return string;
    }

    private void d(String str) {
        if (this.f895h) {
            SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.d);
        }
    }

    public static g a(Context context, String str) {
        g gVar;
        synchronized (a) {
            SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                b = str;
            }
            if (str == null && (str = b) == null) {
                str = "0";
            }
            gVar = a.get(str);
            if (gVar == null) {
                gVar = new g(context, str);
                a.put(str, gVar);
            }
            SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return gVar;
    }

    private void a() {
        try {
            this.e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.e = new JSONObject();
        }
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object objOpt = this.e.opt(str);
        if (objOpt == null) {
            return false;
        }
        if (objOpt instanceof Integer) {
            return !objOpt.equals(0);
        }
        if (objOpt instanceof Boolean) {
            return ((Boolean) objOpt).booleanValue();
        }
        return false;
    }

    private void a(String str, String str2) throws IOException {
        try {
            if (this.d != null) {
                str = str + "." + this.d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void c() {
        int iOptInt = this.e.optInt("Common_frequency");
        if (iOptInt == 0) {
            iOptInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f >= iOptInt * 3600000) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) throws IOException {
        d("cgi back, do update");
        this.e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.e.optInt(str);
    }
}
