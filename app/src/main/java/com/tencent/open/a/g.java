package com.tencent.open.a;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.j;
import com.tencent.open.utils.l;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.xmlbeans.XmlValidationError;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class g {
    protected static g a;
    protected HandlerThread e;
    protected Handler f;
    protected Random b = new Random();
    protected List<Serializable> d = Collections.synchronizedList(new ArrayList());
    protected List<Serializable> c = Collections.synchronizedList(new ArrayList());
    protected Executor g = j.b();

    /* renamed from: h, reason: collision with root package name */
    protected Executor f872h = j.b();

    private g() {
        this.e = null;
        if (this.e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.e = handlerThread;
            handlerThread.start();
        }
        if (!this.e.isAlive() || this.e.getLooper() == null) {
            return;
        }
        this.f = new Handler(this.e.getLooper()) { // from class: com.tencent.open.a.g.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1000) {
                    g.this.b();
                } else if (i2 == 1001) {
                    g.this.e();
                }
                super.handleMessage(message);
            }
        };
    }

    public static synchronized g a() {
        if (a == null) {
            a = new g();
        }
        return a;
    }

    protected void b() {
        this.f872h.execute(new Runnable() { // from class: com.tencent.open.a.g.4
            /* JADX WARN: Removed duplicated region for block: B:24:0x00a5 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:3:0x0008, B:6:0x0011, B:9:0x0023, B:24:0x00a5, B:25:0x00b0, B:17:0x0094, B:19:0x0099, B:21:0x009e, B:12:0x003b, B:14:0x008a), top: B:30:0x0008, inners: #1, #2, #3 }] */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00a3 A[EDGE_INSN: B:35:0x00a3->B:23:0x00a3 BREAK  A[LOOP:0: B:11:0x0039->B:40:?], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:40:? A[LOOP:0: B:11:0x0039->B:40:?, LOOP_END, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                try {
                    Bundle bundleC = g.this.c();
                    if (bundleC == null) {
                        return;
                    }
                    int iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_HttpRetryCount");
                    if (iA == 0) {
                        iA = 3;
                    }
                    SLog.d("openSDK_LOG.ReportManager", "-->doReportCgi, retryCount: " + iA);
                    boolean z = false;
                    int i2 = 0;
                    while (true) {
                        i2++;
                        try {
                            try {
                                try {
                                    HttpClient httpClient = HttpUtils.getHttpClient(com.tencent.open.utils.f.a(), null, "https://wspeed.qq.com/w.cgi");
                                    HttpPost httpPost = new HttpPost("https://wspeed.qq.com/w.cgi");
                                    httpPost.addHeader("Accept-Encoding", "gzip");
                                    httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                                    httpPost.setEntity(new ByteArrayEntity(l.i(HttpUtils.encodeUrl(bundleC))));
                                    int statusCode = httpClient.execute(httpPost).getStatusLine().getStatusCode();
                                    SLog.d("openSDK_LOG.ReportManager", "-->doReportCgi, statusCode: " + statusCode);
                                    if (statusCode != 200) {
                                        break;
                                    }
                                    f.a().b("report_cgi");
                                    z = true;
                                    break;
                                } catch (Exception e) {
                                    SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e);
                                }
                            } catch (SocketTimeoutException e2) {
                                SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e2);
                                if (i2 < iA) {
                                    if (!z) {
                                    }
                                    g.this.c.clear();
                                }
                            }
                        } catch (ConnectTimeoutException e3) {
                            SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e3);
                            if (i2 < iA) {
                            }
                        }
                    }
                    if (!z) {
                        f.a().a("report_cgi", g.this.c);
                    }
                    g.this.c.clear();
                } catch (Exception e4) {
                    SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", e4);
                }
            }
        });
    }

    protected Bundle c() {
        if (this.c.size() == 0) {
            return null;
        }
        b bVar = (b) this.c.get(0);
        if (bVar == null) {
            SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = bVar.a.get("appid");
        List<Serializable> listA = f.a().a("report_cgi");
        if (listA != null) {
            this.c.addAll(listA);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.c.size());
        if (this.c.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", Constants.SDK_VERSION_REPORT);
            bundle.putString("device", Build.DEVICE);
            bundle.putString("qua", Constants.SDK_QUA);
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                b bVar2 = (b) this.c.get(i2);
                bundle.putString(i2 + "_1", bVar2.a.get("apn"));
                bundle.putString(i2 + "_2", bVar2.a.get("frequency"));
                bundle.putString(i2 + "_3", bVar2.a.get("commandid"));
                bundle.putString(i2 + "_4", bVar2.a.get("resultCode"));
                bundle.putString(i2 + "_5", bVar2.a.get("timeCost"));
                bundle.putString(i2 + "_6", bVar2.a.get("reqSize"));
                bundle.putString(i2 + "_7", bVar2.a.get("rspSize"));
                bundle.putString(i2 + "_8", bVar2.a.get("detail"));
                bundle.putString(i2 + "_9", bVar2.a.get("uin"));
                bundle.putString(i2 + "_10", c.e(com.tencent.open.utils.f.a()) + "&" + bVar2.a.get("deviceInfo"));
            }
            SLog.v("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (Exception e) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
            return null;
        }
    }

    protected Bundle d() throws JSONException {
        List<Serializable> listA = f.a().a("report_via");
        if (listA != null) {
            this.d.addAll(listA);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
        if (this.d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.d) {
            JSONObject jSONObject = new JSONObject();
            b bVar = (b) serializable;
            for (String str : bVar.a.keySet()) {
                try {
                    String str2 = bVar.a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e) {
                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (JSONException e2) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    protected void e() {
        this.g.execute(new Runnable() { // from class: com.tencent.open.a.g.5
            @Override // java.lang.Runnable
            public void run() throws JSONException, NumberFormatException {
                long jElapsedRealtime;
                int i2;
                int i3;
                try {
                    Bundle bundleD = g.this.d();
                    if (bundleD == null) {
                        return;
                    }
                    SLog.v("openSDK_LOG.ReportManager", "-->doReportVia, params: " + bundleD.toString());
                    int iA = e.a();
                    int i4 = 0;
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    long j2 = 0;
                    long j3 = 0;
                    boolean z = false;
                    int errorCodeFromException = 0;
                    do {
                        int i5 = i4 + 1;
                        try {
                            try {
                                try {
                                    try {
                                        l.a aVarOpenUrl2 = HttpUtils.openUrl2(com.tencent.open.utils.f.a(), "https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", Constants.HTTP_POST, bundleD);
                                        try {
                                            i3 = l.d(aVarOpenUrl2.a).getInt("ret");
                                        } catch (JSONException unused) {
                                            i3 = -4;
                                        }
                                        if (i3 == 0 || !TextUtils.isEmpty(aVarOpenUrl2.a)) {
                                            i5 = iA;
                                            z = true;
                                        }
                                        j2 = aVarOpenUrl2.b;
                                        j3 = aVarOpenUrl2.c;
                                    } catch (JSONException unused2) {
                                        i4 = i5;
                                        errorCodeFromException = -4;
                                        j2 = 0;
                                        j3 = 0;
                                    }
                                } catch (SocketTimeoutException unused3) {
                                    jElapsedRealtime = SystemClock.elapsedRealtime();
                                    i2 = -8;
                                    jElapsedRealtime2 = jElapsedRealtime;
                                    j2 = 0;
                                    j3 = 0;
                                    errorCodeFromException = i2;
                                    i4 = i5;
                                }
                            } catch (HttpUtils.NetworkUnavailableException unused4) {
                                g.this.d.clear();
                                SLog.d("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
                                return;
                            } catch (IOException e) {
                                errorCodeFromException = HttpUtils.getErrorCodeFromException(e);
                                i4 = i5;
                                j2 = 0;
                                j3 = 0;
                            }
                        } catch (HttpUtils.HttpStatusException e2) {
                            try {
                                errorCodeFromException = Integer.parseInt(e2.getMessage().replace(HttpUtils.HttpStatusException.ERROR_INFO, ""));
                            } catch (Exception unused5) {
                            }
                        } catch (ConnectTimeoutException unused6) {
                            jElapsedRealtime = SystemClock.elapsedRealtime();
                            i2 = -7;
                            jElapsedRealtime2 = jElapsedRealtime;
                            j2 = 0;
                            j3 = 0;
                            errorCodeFromException = i2;
                            i4 = i5;
                        } catch (Exception unused7) {
                            errorCodeFromException = -6;
                            i4 = iA;
                            j2 = 0;
                            j3 = 0;
                        }
                        i4 = i5;
                    } while (i4 < iA);
                    g.this.a("mapp_apptrace_sdk", jElapsedRealtime2, j2, j3, errorCodeFromException, null, false);
                    if (z) {
                        f.a().b("report_via");
                    } else {
                        f.a().a("report_via", g.this.d);
                    }
                    g.this.d.clear();
                    SLog.d("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z);
                } catch (Exception e3) {
                    SLog.e("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e3);
                }
            }
        });
    }

    public void a(final Bundle bundle, String str, final boolean z) {
        if (bundle == null) {
            return;
        }
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z) {
            this.g.execute(new Runnable() { // from class: com.tencent.open.a.g.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String strK = l.k(c.b(com.tencent.open.utils.f.a()));
                        String strK2 = l.k(c.c(com.tencent.open.utils.f.a()));
                        String strK3 = l.k(c.a());
                        String strK4 = l.k(c.d(com.tencent.open.utils.f.a()));
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", Constants.DEFAULT_UIN);
                        bundle2.putString("imei", strK);
                        bundle2.putString("imsi", strK2);
                        bundle2.putString("android_id", strK4);
                        bundle2.putString("mac", strK3);
                        bundle2.putString(Constants.PARAM_PLATFORM, "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString("position", "");
                        bundle2.putString("network", a.a(com.tencent.open.utils.f.a()));
                        bundle2.putString("language", c.b());
                        bundle2.putString("resolution", c.a(com.tencent.open.utils.f.a()));
                        bundle2.putString("apn", a.b(com.tencent.open.utils.f.a()));
                        bundle2.putString("model_name", Build.MODEL);
                        bundle2.putString("timezone", TimeZone.getDefault().getID());
                        bundle2.putString("sdk_ver", Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", l.d(com.tencent.open.utils.f.a(), Constants.PACKAGE_QZONE));
                        bundle2.putString("qq_ver", l.c(com.tencent.open.utils.f.a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", l.e(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.f.b());
                        bundle2.putString("app_ver", l.d(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                        Bundle bundle3 = bundle;
                        if (bundle3 != null) {
                            bundle2.putAll(bundle3);
                        }
                        g.this.d.add(new b(bundle2));
                        int size = g.this.d.size();
                        int iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (iA == 0) {
                            iA = XmlValidationError.UNDEFINED;
                        }
                        if (!g.this.a("report_via", size) && !z) {
                            if (g.this.f.hasMessages(XmlValidationError.ATTRIBUTE_TYPE_INVALID)) {
                                return;
                            }
                            Message messageObtain = Message.obtain();
                            messageObtain.what = XmlValidationError.ATTRIBUTE_TYPE_INVALID;
                            g.this.f.sendMessageDelayed(messageObtain, iA);
                            return;
                        }
                        g.this.e();
                        g.this.f.removeMessages(XmlValidationError.ATTRIBUTE_TYPE_INVALID);
                    } catch (Exception e) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    public void a(String str, long j2, long j3, long j4, int i2) {
        a(str, j2, j3, j4, i2, "", false);
    }

    public void a(final String str, final long j2, final long j3, final long j4, final int i2, final String str2, final boolean z) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j2 + " | reqSize:" + j3 + " | rspSize: " + j4 + " | responseCode: " + i2 + " | detail: " + str2);
        if (a("report_cgi", "" + i2) || z) {
            this.f872h.execute(new Runnable() { // from class: com.tencent.open.a.g.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - j2;
                        Bundle bundle = new Bundle();
                        String strA = a.a(com.tencent.open.utils.f.a());
                        bundle.putString("apn", strA);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str);
                        bundle.putString("detail", str2);
                        StringBuilder sb = new StringBuilder();
                        sb.append("network=");
                        sb.append(strA);
                        sb.append('&');
                        sb.append("sdcard=");
                        int i3 = 1;
                        sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                        sb.append('&');
                        sb.append("wifi=");
                        sb.append(a.e(com.tencent.open.utils.f.a()));
                        bundle.putString("deviceInfo", sb.toString());
                        int iA = 100 / g.this.a(i2);
                        if (iA > 0) {
                            i3 = iA > 100 ? 100 : iA;
                        }
                        bundle.putString("frequency", i3 + "");
                        bundle.putString("reqSize", j3 + "");
                        bundle.putString("resultCode", i2 + "");
                        bundle.putString("rspSize", j4 + "");
                        bundle.putString("timeCost", jElapsedRealtime + "");
                        bundle.putString("uin", Constants.DEFAULT_UIN);
                        g.this.c.add(new b(bundle));
                        int size = g.this.c.size();
                        int iA2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (iA2 == 0) {
                            iA2 = XmlValidationError.UNDEFINED;
                        }
                        if (g.this.a("report_cgi", size) || z) {
                            g.this.b();
                            g.this.f.removeMessages(XmlValidationError.INCORRECT_ATTRIBUTE);
                        } else if (!g.this.f.hasMessages(XmlValidationError.INCORRECT_ATTRIBUTE)) {
                            Message messageObtain = Message.obtain();
                            messageObtain.what = XmlValidationError.INCORRECT_ATTRIBUTE;
                            g.this.f.sendMessageDelayed(messageObtain, iA2);
                        }
                    } catch (Exception e) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    protected boolean a(String str, String str2) {
        int iA;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 100;
        if (str.equals("report_cgi")) {
            try {
                iA = a(Integer.parseInt(str2));
                if (this.b.nextInt(100) < iA) {
                    z = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                iA = e.a(str2);
                if (this.b.nextInt(100) < iA) {
                    i2 = iA;
                    z = true;
                }
            }
            SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i2);
            return z;
        }
        i2 = iA;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i2);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c A[PHI: r0
      0x001c: PHI (r0v9 int) = (r0v6 int), (r0v12 int) binds: [B:11:0x0034, B:5:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean a(String str, int i2) {
        int iA;
        int i3 = 5;
        if (str.equals("report_cgi")) {
            iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_CGIReportMaxcount");
            if (iA != 0) {
                i3 = iA;
            }
        } else if (str.equals("report_via")) {
            iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Agent_ReportBatchCount");
            if (iA != 0) {
            }
        } else {
            i3 = 0;
        }
        SLog.d("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i2 + " | maxcount: " + i3);
        return i2 >= i3;
    }

    protected int a(int i2) {
        if (i2 == 0) {
            int iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (iA == 0) {
                return 10;
            }
            return iA;
        }
        int iA2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (iA2 == 0) {
            return 100;
        }
        return iA2;
    }

    public void a(final String str, final String str2, final Bundle bundle, final boolean z) {
        j.a(new Runnable() { // from class: com.tencent.open.a.g.6
            /* JADX WARN: Removed duplicated region for block: B:103:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:85:0x0136 A[Catch: Exception -> 0x0159, TRY_ENTER, TryCatch #12 {Exception -> 0x0159, blocks: (B:3:0x0004, B:5:0x0008, B:7:0x000e, B:10:0x0015, B:12:0x003e, B:13:0x0042, B:15:0x0050, B:19:0x0086, B:85:0x0136, B:86:0x013c, B:35:0x00d6, B:71:0x0119, B:95:0x0152, B:94:0x014f, B:16:0x0064, B:18:0x0072, B:96:0x0153, B:89:0x0144, B:91:0x014a), top: B:113:0x0004, inners: #2 }] */
            /* JADX WARN: Removed duplicated region for block: B:86:0x013c A[Catch: Exception -> 0x0159, TRY_LEAVE, TryCatch #12 {Exception -> 0x0159, blocks: (B:3:0x0004, B:5:0x0008, B:7:0x000e, B:10:0x0015, B:12:0x003e, B:13:0x0042, B:15:0x0050, B:19:0x0086, B:85:0x0136, B:86:0x013c, B:35:0x00d6, B:71:0x0119, B:95:0x0152, B:94:0x014f, B:16:0x0064, B:18:0x0072, B:96:0x0153, B:89:0x0144, B:91:0x014a), top: B:113:0x0004, inners: #2 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() throws Throwable {
                HttpUriRequest httpGet;
                HttpResponse httpResponseExecute;
                String str3 = "-->ReportCenter httpRequest consumeContent Exception:";
                try {
                    if (bundle == null) {
                        SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, params is null!");
                        return;
                    }
                    int iA = e.a();
                    if (iA == 0) {
                        iA = 3;
                    }
                    SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + iA);
                    HttpResponse httpResponse = null;
                    HttpClient httpClient = HttpUtils.getHttpClient(com.tencent.open.utils.f.a(), null, str);
                    String strEncodeUrl = HttpUtils.encodeUrl(bundle);
                    if (z) {
                        strEncodeUrl = URLEncoder.encode(strEncodeUrl);
                    }
                    if (str2.toUpperCase().equals(Constants.HTTP_GET)) {
                        StringBuffer stringBuffer = new StringBuffer(str);
                        stringBuffer.append(strEncodeUrl);
                        httpGet = new HttpGet(stringBuffer.toString());
                    } else if (!str2.toUpperCase().equals(Constants.HTTP_POST)) {
                        SLog.e("openSDK_LOG.ReportManager", "-->httpRequest unkonw request method return.");
                        return;
                    } else {
                        HttpPost httpPost = new HttpPost(str);
                        httpPost.setEntity(new ByteArrayEntity(l.i(strEncodeUrl)));
                        httpGet = httpPost;
                    }
                    httpGet.addHeader("Accept-Encoding", "gzip");
                    httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    int i2 = 0;
                    boolean z2 = false;
                    do {
                        i2++;
                        try {
                            try {
                                httpResponseExecute = httpClient.execute(httpGet);
                                try {
                                    int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
                                    SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + statusCode);
                                    if (statusCode != 200) {
                                        SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest : HttpStatuscode != 200");
                                    } else {
                                        try {
                                            SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread success");
                                            z2 = true;
                                        } catch (SocketTimeoutException e) {
                                            e = e;
                                            z2 = true;
                                            try {
                                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e);
                                                if (httpResponseExecute != null) {
                                                    try {
                                                        HttpEntity entity = httpResponseExecute.getEntity();
                                                        if (entity != null) {
                                                            entity.consumeContent();
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e);
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                httpResponse = httpResponseExecute;
                                                if (httpResponse != null) {
                                                    try {
                                                        HttpEntity entity2 = httpResponse.getEntity();
                                                        if (entity2 != null) {
                                                            entity2.consumeContent();
                                                        }
                                                    } catch (Exception e3) {
                                                        SLog.e("openSDK_LOG.ReportManager", str3, e3);
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (ConnectTimeoutException e4) {
                                            e = e4;
                                            z2 = true;
                                            SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest ConnectTimeoutException:", e);
                                            if (httpResponseExecute != null) {
                                                try {
                                                    HttpEntity entity3 = httpResponseExecute.getEntity();
                                                    if (entity3 != null) {
                                                        entity3.consumeContent();
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e);
                                                }
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            z2 = true;
                                            httpResponse = httpResponseExecute;
                                            SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e);
                                            if (httpResponse != null) {
                                                try {
                                                    HttpEntity entity4 = httpResponse.getEntity();
                                                    if (entity4 != null) {
                                                        entity4.consumeContent();
                                                    }
                                                } catch (Exception e7) {
                                                    e = e7;
                                                    SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e);
                                                    if (z2) {
                                                    }
                                                }
                                            }
                                            if (z2) {
                                            }
                                        }
                                    }
                                    if (httpResponseExecute != null) {
                                        try {
                                            HttpEntity entity5 = httpResponseExecute.getEntity();
                                            if (entity5 != null) {
                                                entity5.consumeContent();
                                            }
                                        } catch (Exception e8) {
                                            e = e8;
                                            SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest consumeContent Exception:", e);
                                            if (z2) {
                                            }
                                        }
                                    }
                                } catch (SocketTimeoutException e9) {
                                    e = e9;
                                } catch (ConnectTimeoutException e10) {
                                    e = e10;
                                } catch (Exception e11) {
                                    e = e11;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (httpResponse != null) {
                                }
                                throw th;
                            }
                        } catch (SocketTimeoutException e12) {
                            e = e12;
                            httpResponseExecute = null;
                        } catch (ConnectTimeoutException e13) {
                            e = e13;
                            httpResponseExecute = null;
                        } catch (Exception e14) {
                            e = e14;
                        }
                        if (z2) {
                            str3 = "-->ReportCenter httpRequest Thread request success";
                            SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request success");
                        } else {
                            str3 = "-->ReportCenter httpRequest Thread request failed";
                            SLog.d("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request failed");
                        }
                    } while (i2 < iA);
                    if (z2) {
                    }
                } catch (Exception e15) {
                    SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e15);
                }
            }
        });
    }
}
