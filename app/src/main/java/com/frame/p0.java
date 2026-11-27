package com.frame;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.android.internal.http.multipart.FilePart;
import com.android.internal.http.multipart.MultipartEntity;
import com.android.internal.http.multipart.Part;
import com.android.internal.http.multipart.StringPart;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.apache.xmlbeans.XmlValidationError;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class p0 {
    private static p0 d;
    private static volatile o0 e;
    private HashMap<String, BasicNameValuePair> a;
    private String b;
    private String c = v0.g().getPackageName();

    public p0(boolean z) throws JSONException {
        if (z && v0.g().l()) {
            l();
        }
    }

    public static p0 h() {
        p0 p0Var = d;
        if (p0Var != null) {
            return p0Var;
        }
        p0 p0Var2 = new p0(true);
        d = p0Var2;
        return p0Var2;
    }

    private void l() throws JSONException {
        if (v0.f) {
            try {
                this.a = new HashMap<>();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("packageName", this.c);
                jSONObject.put("systemVersion", String.valueOf(Build.VERSION.SDK_INT));
                jSONObject.put("channel", k0.a());
                jSONObject.put("firstStartTime", String.valueOf(k0.b()));
                jSONObject.put("version", j());
                jSONObject.put("token", v0.f().getString("token", null));
                String strH = n1.h(jSONObject.toString(), "4jso$dkm#kkd*lsdk@");
                this.b = strH;
                if (TextUtils.isEmpty(strH)) {
                    return;
                }
                this.a.put("u", new BasicNameValuePair("u", strH));
            } catch (Exception e2) {
                k0.r(e2);
            }
        }
    }

    private boolean m(ArrayList<BasicNameValuePair> arrayList) {
        if (arrayList == null) {
            return false;
        }
        Iterator<BasicNameValuePair> it = arrayList.iterator();
        while (it.hasNext()) {
            BasicNameValuePair next = it.next();
            if (next != null && "ylcx".equals(next.getName()) && "1".equals(next.getValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean n(String str) {
        try {
            String strReplaceAll = str.replaceAll("\\s", "");
            if (strReplaceAll.matches("[A-Za-z0-9+/]+={0,2}") && strReplaceAll.length() % 4 == 0) {
                byte[] bArrDecode = Base64.decode(strReplaceAll, 0);
                if (bArrDecode.length <= 0 || bArrDecode.length % 8 != 0) {
                    return false;
                }
                return n1.c(strReplaceAll, "4jso$dkm#kkd*lsdk@") != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public String A(String str, String str2) throws ParseException, IOException {
        if (!v0.f) {
            return null;
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        defaultHttpClient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        HttpPost httpPost = new HttpPost("https://api1.skyingidea.com/api_v1/upload");
        httpPost.setEntity(new MultipartEntity(new Part[]{new FilePart("file", new File(str)), new StringPart("token", str2, "UTF-8")}));
        System.out.println("executing request " + httpPost.getRequestLine());
        HttpResponse httpResponseExecute = defaultHttpClient.execute(httpPost);
        HttpEntity entity = httpResponseExecute.getEntity();
        System.out.println(httpResponseExecute.getStatusLine());
        if (entity == null) {
            if (entity != null) {
                entity.consumeContent();
            }
            defaultHttpClient.getConnectionManager().shutdown();
            return null;
        }
        String string = EntityUtils.toString(entity);
        Log.d("lololo", "uploadImage() returned: " + string);
        return string;
    }

    public String a(ArrayList<BasicNameValuePair> arrayList) throws UnsupportedEncodingException {
        if (arrayList == null || arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            BasicNameValuePair basicNameValuePair = arrayList.get(i2);
            try {
                String strEncode = URLEncoder.encode(basicNameValuePair.getName(), "UTF-8");
                String strEncode2 = URLEncoder.encode(basicNameValuePair.getValue(), "UTF-8");
                sb.append(strEncode);
                sb.append("=");
                sb.append(strEncode2);
                if (i2 != arrayList.size() - 1) {
                    sb.append("&");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return sb.toString();
    }

    public ArrayList<BasicNameValuePair> b() {
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        if (!v0.g().l()) {
            return arrayList;
        }
        if (this.a == null) {
            l();
        }
        HashMap<String, BasicNameValuePair> map = this.a;
        if (map != null) {
            arrayList.addAll(map.values());
        }
        return arrayList;
    }

    public String c(String str, String str2, ArrayList<BasicNameValuePair> arrayList) throws Exception {
        FileOutputStream fileOutputStream;
        BufferedReader bufferedReader = null;
        if (!v0.f) {
            return null;
        }
        HttpPost httpPost = new HttpPost(str);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            fileOutputStream = new FileOutputStream(str2);
            try {
                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                HttpResponse httpResponseExecute = defaultHttpClient.execute(httpPost);
                HttpEntity entity = httpResponseExecute.getEntity();
                Log.e("response.getStatusLine", httpResponseExecute.getStatusLine().toString());
                InputStream content = entity.getContent();
                if (httpResponseExecute.getStatusLine().getStatusCode() == 433) {
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(content));
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                String string = stringBuffer.toString();
                                x0.b(bufferedReader2);
                                x0.e(fileOutputStream);
                                return string;
                            }
                            stringBuffer.append(line);
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            x0.b(bufferedReader);
                            x0.e(fileOutputStream);
                            throw th;
                        }
                    }
                } else {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i2 = content.read(bArr);
                        if (i2 == -1) {
                            fileOutputStream.flush();
                            x0.b(null);
                            x0.e(fileOutputStream);
                            return null;
                        }
                        fileOutputStream.write(bArr, 0, i2);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                x0.b(bufferedReader);
                x0.e(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public String d(String str) throws Throwable {
        BufferedReader bufferedReader = null;
        if (!v0.f) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new DefaultHttpClient().execute(new HttpGet(str)).getEntity().getContent()));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        stringBuffer.append(line);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        k0.r(e);
                        x0.b(bufferedReader);
                        return stringBuffer.toString();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        x0.b(bufferedReader);
                        throw th;
                    }
                }
                x0.b(bufferedReader2);
            } catch (Exception e3) {
                e = e3;
            }
            return stringBuffer.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String e(String str, ArrayList<BasicNameValuePair> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return z0.d(str);
        }
        return z0.d(str + a(arrayList));
    }

    public HttpResponse f(String str, ArrayList<BasicNameValuePair> arrayList, HashMap<String, String> map, boolean z) throws IOException {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        HttpPost httpPost = new HttpPost(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                httpPost.addHeader(str2, map.get(str2));
            }
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        if (str != null && str.split("\\?", 2)[0].matches(".*/mgr/(getUserOverview|getApps|getAppDetailDataByMgr)")) {
            HttpConnectionParams.setConnectionTimeout(defaultHttpClient.getParams(), XmlValidationError.UNDEFINED);
            HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), 15000);
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return defaultHttpClient.execute(httpPost);
    }

    public String g(HttpResponse httpResponse) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        String string = sb.toString();
                        x0.b(bufferedReader2);
                        return string;
                    }
                    sb.append(line);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    x0.b(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String i() {
        return this.b;
    }

    public String j() {
        try {
            return v0.g().getPackageManager().getPackageInfo(v0.g().getPackageName(), 0).versionName;
        } catch (Exception e2) {
            k0.r(e2);
            return "";
        }
    }

    public Integer k() {
        try {
            return Integer.valueOf(v0.g().getPackageManager().getPackageInfo(v0.g().getPackageName(), 0).versionCode);
        } catch (Exception e2) {
            k0.r(e2);
            return 0;
        }
    }

    public String p(String str, ArrayList<BasicNameValuePair> arrayList) throws Exception {
        return v(str, arrayList, null, 0L);
    }

    public String q(String str, ArrayList<BasicNameValuePair> arrayList, HashMap<String, String> map) throws Exception {
        return r(str, arrayList, map, true);
    }

    public String r(String str, ArrayList<BasicNameValuePair> arrayList, HashMap<String, String> map, boolean z) throws Exception {
        String[] strArr;
        if (str.contains("https://api.skyingidea.com/")) {
            String strReplace = str.replace("https://api.skyingidea.com/", "");
            strArr = new String[]{"https://api.skyingidea.com/" + strReplace, "https://api1.skyingidea.com/" + strReplace};
        } else if (str.contains("https://api1.skyingidea.com/")) {
            String strReplace2 = str.replace("https://api1.skyingidea.com/", "");
            strArr = new String[]{"https://api1.skyingidea.com/" + strReplace2, "https://api.skyingidea.com/" + strReplace2};
        } else {
            strArr = new String[]{str};
        }
        return s(strArr, arrayList, map, z);
    }

    public String s(String[] strArr, ArrayList<BasicNameValuePair> arrayList, HashMap<String, String> map, boolean z) throws Exception {
        if (!v0.f) {
            return null;
        }
        boolean zM = m(arrayList);
        for (String str : strArr) {
            try {
                HttpResponse httpResponseF = f(str, arrayList, map, z);
                int statusCode = httpResponseF.getStatusLine().getStatusCode();
                String strG = g(httpResponseF);
                if (statusCode >= 200 && statusCode < 300 && !TextUtils.isEmpty(strG) && (!zM || n(strG))) {
                    return strG;
                }
            } catch (SSLException unused) {
            } catch (Exception e2) {
                k0.r(e2);
            }
        }
        return "";
    }

    public String t(String str, ArrayList<BasicNameValuePair> arrayList, HashMap<String, String> map, long j2, boolean z) throws Exception {
        return u(str, arrayList, map, j2, z, false);
    }

    public String u(String str, ArrayList<BasicNameValuePair> arrayList, HashMap<String, String> map, long j2, boolean z, boolean z2) throws Exception {
        final String strE;
        String strA;
        o0 o0Var = e;
        if (o0Var != null && (strA = o0Var.a(str, arrayList)) != null) {
            return strA;
        }
        final String strC = null;
        if (!v0.f || v0.g().m()) {
            return null;
        }
        if (j2 != 0) {
            strE = e(str, arrayList);
            if (!z2) {
                if (v0.e().getLong(strE + ":cache_time", 0L) + j2 > System.currentTimeMillis()) {
                    strC = v0.e().getString(strE, null);
                }
            }
        } else {
            strE = null;
        }
        boolean z3 = false;
        if (TextUtils.isEmpty(strC)) {
            ArrayList<BasicNameValuePair> arrayList2 = new ArrayList<>();
            if (z) {
                if (arrayList != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        BasicNameValuePair basicNameValuePair = arrayList.get(i2);
                        if (basicNameValuePair != null && basicNameValuePair.getValue() != null) {
                            if ("u".equals(basicNameValuePair.getName())) {
                                arrayList2.add(new BasicNameValuePair(basicNameValuePair.getName(), basicNameValuePair.getValue()));
                            } else {
                                arrayList2.add(new BasicNameValuePair(basicNameValuePair.getName(), n1.h(basicNameValuePair.getValue(), "4jso$dkm#kkd*lsdk@")));
                            }
                        }
                    }
                }
                arrayList2.add(new BasicNameValuePair("ylcx", "1"));
            } else {
                if (arrayList == null) {
                }
                strC = q(str, arrayList, map);
            }
            arrayList = arrayList2;
            strC = q(str, arrayList, map);
        } else {
            z3 = true;
        }
        if (!z3 && j2 != 0 && !TextUtils.isEmpty(strC)) {
            l1.g(new Runnable() { // from class: com.frame.l
                @Override // java.lang.Runnable
                public final void run() {
                    String str2 = strE;
                    v0.e().edit().putLong(str2 + ":cache_time", System.currentTimeMillis()).putString(str2, strC).apply();
                }
            });
        }
        if (z && !TextUtils.isEmpty(strC)) {
            strC = n1.c(strC, "4jso$dkm#kkd*lsdk@");
        }
        return strC.replaceAll("http://", "https://");
    }

    public String v(String str, ArrayList<BasicNameValuePair> arrayList, HashMap<String, String> map, long j2) throws Exception {
        return t(str, arrayList, map, j2, true);
    }

    public String w(String str, ArrayList<BasicNameValuePair> arrayList, HashMap<String, String> map, long j2, boolean z) throws Exception {
        return u(str, arrayList, map, j2, true, z);
    }

    public String x(String str, String str2, HashMap<String, String> map) throws Exception {
        BufferedReader bufferedReader = null;
        if (!v0.f) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        HttpPost httpPost = new HttpPost(str);
        if (map != null) {
            for (String str3 : map.keySet()) {
                httpPost.addHeader(str3, map.get(str3));
            }
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            httpPost.setEntity(new StringEntity(str2, "utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(defaultHttpClient.execute(httpPost).getEntity().getContent()));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (Exception e3) {
                        e = e3;
                        bufferedReader = bufferedReader2;
                        k0.r(e);
                        x0.b(bufferedReader);
                        return sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        x0.b(bufferedReader);
                        throw th;
                    }
                }
                x0.b(bufferedReader2);
            } catch (Exception e4) {
                e = e4;
            }
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void y() {
        d = null;
    }

    public String z(String str, String str2, HashMap<String, String> map) throws ParseException, IOException {
        if (!v0.f) {
            return null;
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        defaultHttpClient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        HttpPost httpPost = new HttpPost(str);
        FilePart filePart = new FilePart("file", new File(str2), (String) null, "UTF-8");
        int i2 = 1;
        Part[] partArr = new Part[map.size() + 1];
        partArr[0] = filePart;
        for (String str3 : map.keySet()) {
            partArr[i2] = new StringPart(str3, map.get(str3), "UTF-8");
            i2++;
        }
        httpPost.setEntity(new MultipartEntity(partArr));
        System.out.println("executing request " + httpPost.getRequestLine());
        HttpResponse httpResponseExecute = defaultHttpClient.execute(httpPost);
        HttpEntity entity = httpResponseExecute.getEntity();
        System.out.println(httpResponseExecute.getStatusLine());
        if (entity == null) {
            if (entity != null) {
                entity.consumeContent();
            }
            defaultHttpClient.getConnectionManager().shutdown();
            return null;
        }
        String string = EntityUtils.toString(entity);
        Log.d("lololo", "uploadImage() returned: " + string);
        return string;
    }
}
