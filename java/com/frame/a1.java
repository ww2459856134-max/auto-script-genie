package com.frame;

import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a1 {
    private static a1 d;
    private String a;
    private JSONObject b;
    private Handler c;

    public static a1 b() {
        a1 a1Var = d;
        if (a1Var != null) {
            return a1Var;
        }
        a1 a1Var2 = new a1();
        d = a1Var2;
        return a1Var2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00dc A[Catch: Exception -> 0x0290, TRY_ENTER, TryCatch #0 {Exception -> 0x0290, blocks: (B:7:0x003a, B:48:0x00d4, B:51:0x00dc, B:53:0x00f7, B:56:0x0103, B:60:0x011a, B:65:0x013d, B:70:0x014f, B:72:0x01a6, B:75:0x01b0, B:77:0x01c6, B:79:0x01ce, B:82:0x01d4, B:83:0x01d8, B:87:0x0203, B:88:0x026d, B:90:0x027b, B:64:0x0139, B:27:0x008a, B:28:0x008e, B:46:0x00ce), top: B:100:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0139 A[Catch: Exception -> 0x0290, TRY_ENTER, TryCatch #0 {Exception -> 0x0290, blocks: (B:7:0x003a, B:48:0x00d4, B:51:0x00dc, B:53:0x00f7, B:56:0x0103, B:60:0x011a, B:65:0x013d, B:70:0x014f, B:72:0x01a6, B:75:0x01b0, B:77:0x01c6, B:79:0x01ce, B:82:0x01d4, B:83:0x01d8, B:87:0x0203, B:88:0x026d, B:90:0x027b, B:64:0x0139, B:27:0x008a, B:28:0x008e, B:46:0x00ce), top: B:100:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a6 A[Catch: Exception -> 0x0290, TryCatch #0 {Exception -> 0x0290, blocks: (B:7:0x003a, B:48:0x00d4, B:51:0x00dc, B:53:0x00f7, B:56:0x0103, B:60:0x011a, B:65:0x013d, B:70:0x014f, B:72:0x01a6, B:75:0x01b0, B:77:0x01c6, B:79:0x01ce, B:82:0x01d4, B:83:0x01d8, B:87:0x0203, B:88:0x026d, B:90:0x027b, B:64:0x0139, B:27:0x008a, B:28:0x008e, B:46:0x00ce), top: B:100:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c6 A[Catch: Exception -> 0x0290, TryCatch #0 {Exception -> 0x0290, blocks: (B:7:0x003a, B:48:0x00d4, B:51:0x00dc, B:53:0x00f7, B:56:0x0103, B:60:0x011a, B:65:0x013d, B:70:0x014f, B:72:0x01a6, B:75:0x01b0, B:77:0x01c6, B:79:0x01ce, B:82:0x01d4, B:83:0x01d8, B:87:0x0203, B:88:0x026d, B:90:0x027b, B:64:0x0139, B:27:0x008a, B:28:0x008e, B:46:0x00ce), top: B:100:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x026d A[Catch: Exception -> 0x0290, TryCatch #0 {Exception -> 0x0290, blocks: (B:7:0x003a, B:48:0x00d4, B:51:0x00dc, B:53:0x00f7, B:56:0x0103, B:60:0x011a, B:65:0x013d, B:70:0x014f, B:72:0x01a6, B:75:0x01b0, B:77:0x01c6, B:79:0x01ce, B:82:0x01d4, B:83:0x01d8, B:87:0x0203, B:88:0x026d, B:90:0x027b, B:64:0x0139, B:27:0x008a, B:28:0x008e, B:46:0x00ce), top: B:100:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x028f A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void j() {
        Exception exc;
        boolean z;
        String strOptString;
        String str;
        String str2;
        String strQ;
        JSONObject jSONObject;
        Handler handler;
        Exception exc2;
        try {
            this.a = String.valueOf(v0.g().getPackageManager().getPackageInfo(v0.g().getPackageName(), 0).versionCode);
        } catch (Exception e) {
            k0.r(e);
        }
        try {
            String string = v0.i().getString("params", null);
            if (TextUtils.isEmpty(string)) {
                String strU = r0.u("i");
                if (TextUtils.isEmpty(strU)) {
                    z = false;
                    strOptString = null;
                } else {
                    try {
                        String strReplaceAll = n1.b(strU).replaceAll("http://", "https://");
                        JSONObject jSONObjectOptJSONObject = new JSONObject(strReplaceAll).optJSONObject("json");
                        this.b = jSONObjectOptJSONObject;
                        if (jSONObjectOptJSONObject == null) {
                            Log.e("params", strReplaceAll);
                            strOptString = null;
                        } else {
                            strOptString = jSONObjectOptJSONObject.optString("time");
                        }
                        try {
                            Handler handler2 = this.c;
                            if (handler2 != null) {
                                try {
                                    handler2.sendEmptyMessage(0);
                                    z = true;
                                } catch (Exception e2) {
                                    exc2 = e2;
                                    z = true;
                                    k0.r(exc2);
                                    if (this.b != null) {
                                    }
                                    int i2 = Calendar.getInstance().get(6);
                                    if (v0.i().getInt("params_update_day", 0) == i2) {
                                    }
                                    v0.i().edit().putInt("params_update_day", i2).apply();
                                    ArrayList<BasicNameValuePair> arrayListB = p0.h().b();
                                    arrayListB.add(new BasicNameValuePair("time", strOptString == null ? null : n1.h(strOptString, "4jso$dkm#kkd*lsdk@")));
                                    arrayListB.add(new BasicNameValuePair("stal", z ? "1" : "0"));
                                    arrayListB.add(new BasicNameValuePair("ylcx", "1"));
                                    arrayListB.add(new BasicNameValuePair("startCount", v0.g().h() + ""));
                                    strQ = p0.h().q(k0.f + "/getParamsByPn", arrayListB, null);
                                    if (!TextUtils.isEmpty(strQ)) {
                                    }
                                }
                            }
                            z = false;
                        } catch (Exception e3) {
                            exc2 = e3;
                            z = false;
                        }
                    } catch (Exception e4) {
                        exc2 = e4;
                        z = false;
                        strOptString = null;
                    }
                }
            } else {
                try {
                    String strB = n1.b(string);
                    JSONObject jSONObjectOptJSONObject2 = new JSONObject(strB).optJSONObject("json");
                    this.b = jSONObjectOptJSONObject2;
                    if (jSONObjectOptJSONObject2 == null) {
                        Log.e("params", strB);
                        strOptString = null;
                    } else {
                        strOptString = jSONObjectOptJSONObject2.optString("time");
                    }
                    try {
                        Handler handler3 = this.c;
                        if (handler3 != null) {
                            try {
                                handler3.sendEmptyMessage(0);
                                z = true;
                            } catch (Exception e5) {
                                exc = e5;
                                z = true;
                                k0.r(exc);
                                if (this.b != null) {
                                }
                                int i22 = Calendar.getInstance().get(6);
                                if (v0.i().getInt("params_update_day", 0) == i22) {
                                }
                                v0.i().edit().putInt("params_update_day", i22).apply();
                                ArrayList<BasicNameValuePair> arrayListB2 = p0.h().b();
                                arrayListB2.add(new BasicNameValuePair("time", strOptString == null ? null : n1.h(strOptString, "4jso$dkm#kkd*lsdk@")));
                                arrayListB2.add(new BasicNameValuePair("stal", z ? "1" : "0"));
                                arrayListB2.add(new BasicNameValuePair("ylcx", "1"));
                                arrayListB2.add(new BasicNameValuePair("startCount", v0.g().h() + ""));
                                strQ = p0.h().q(k0.f + "/getParamsByPn", arrayListB2, null);
                                if (!TextUtils.isEmpty(strQ)) {
                                    return;
                                }
                                jSONObject = new JSONObject(n1.c(strQ, "4jso$dkm#kkd*lsdk@").replaceAll("http://", "https://"));
                                if (jSONObject.optInt("code") == 1) {
                                }
                            }
                        }
                        z = false;
                    } catch (Exception e6) {
                        exc = e6;
                        z = false;
                    }
                } catch (Exception e7) {
                    exc = e7;
                    z = false;
                    strOptString = null;
                }
            }
            if (this.b != null) {
                str = "waitAd";
                str2 = "tencentPosIds";
                if (v0.i().getLong("params_update_time", 0L) + 43200000 > System.currentTimeMillis()) {
                    Log.e("ParamsUtils", "init: 过快加载，跳过");
                    return;
                }
            } else {
                str = "waitAd";
                str2 = "tencentPosIds";
            }
            int i222 = Calendar.getInstance().get(6);
            boolean z2 = v0.i().getInt("params_update_day", 0) == i222;
            v0.i().edit().putInt("params_update_day", i222).apply();
            ArrayList<BasicNameValuePair> arrayListB22 = p0.h().b();
            arrayListB22.add(new BasicNameValuePair("time", strOptString == null ? null : n1.h(strOptString, "4jso$dkm#kkd*lsdk@")));
            arrayListB22.add(new BasicNameValuePair("stal", z2 ? "1" : "0"));
            arrayListB22.add(new BasicNameValuePair("ylcx", "1"));
            arrayListB22.add(new BasicNameValuePair("startCount", v0.g().h() + ""));
            strQ = p0.h().q(k0.f + "/getParamsByPn", arrayListB22, null);
            if (!TextUtils.isEmpty(strQ) && !"bad base-64".equals(strQ)) {
                jSONObject = new JSONObject(n1.c(strQ, "4jso$dkm#kkd*lsdk@").replaceAll("http://", "https://"));
                if (jSONObject.optInt("code") == 1) {
                    if ("无更新".equals(jSONObject.optString(SocialConstants.PARAM_SEND_MSG))) {
                        v0.i().edit().putLong("params_update_time", System.currentTimeMillis()).apply();
                        return;
                    }
                    return;
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("json");
                this.b = jSONObjectOptJSONObject3;
                if (!z && (handler = this.c) != null && jSONObjectOptJSONObject3 != null) {
                    handler.sendEmptyMessage(0);
                }
                v0.i().edit().putString("params", strQ).putLong("params_update_time", System.currentTimeMillis()).apply();
                String str3 = str2;
                SharedPreferences.Editor editorPutString = v0.f().edit().putBoolean("splash_toggle", this.b.optInt("splash_toggle", 1) == 1).putString("splash_pos_id", this.b.optString("splash_pos_id")).putString("splash_app_id", this.b.optString("splash_app_id")).putString(str3, this.b.optString(str3));
                String str4 = str;
                editorPutString.putInt(str4, this.b.optInt(str4, 0)).putInt("accDelay", this.b.optInt("accDelay", 100)).putInt("splash_type", this.b.optInt("splash_type", 1)).putInt("keepLive", this.b.optInt("keepLive", 1)).putString("splash_height", this.b.optString("splash_height", "1")).apply();
            }
        } catch (Exception e8) {
            k0.r(e8);
            Handler handler4 = this.c;
            if (handler4 == null || this.b == null) {
                return;
            }
            handler4.sendEmptyMessage(0);
        }
    }

    public void a() {
        if (TextUtils.isEmpty(this.a)) {
            h();
        }
    }

    public JSONObject c() {
        return this.b;
    }

    public String d(String str) {
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.optString(str);
        } catch (Exception e) {
            k0.r(e);
            return null;
        }
    }

    public String e(String str, String str2) {
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject != null && !jSONObject.isNull(str)) {
                return this.b.optString(str);
            }
            return str2;
        } catch (Exception e) {
            k0.r(e);
            return str2;
        }
    }

    public JSONObject f(String str) {
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject != null && !jSONObject.isNull(str)) {
                return new JSONObject(this.b.optString(str));
            }
            return null;
        } catch (Exception e) {
            k0.r(e);
            return null;
        }
    }

    public String g() {
        return this.a;
    }

    public void h() {
        if (v0.g().l()) {
            new Thread(new Runnable() { // from class: com.frame.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.j();
                }
            }).start();
        }
    }

    public void k(Handler handler) {
        this.c = handler;
    }
}
