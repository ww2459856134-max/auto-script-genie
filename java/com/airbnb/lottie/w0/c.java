package com.airbnb.lottie.w0;

import android.content.Context;
import com.airbnb.lottie.e;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.m;
import com.tencent.connect.common.Constants;
import h.e.i.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class c {
    private final Context a;
    private final String b;
    private final b c;

    private c(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = str;
        if (str2 == null) {
            this.c = null;
        } else {
            this.c = new b(applicationContext);
        }
    }

    private e a() {
        d<a, InputStream> dVarA;
        b bVar = this.c;
        if (bVar == null || (dVarA = bVar.a(this.b)) == null) {
            return null;
        }
        a aVar = dVarA.a;
        InputStream inputStream = dVarA.b;
        k0<e> k0VarR = aVar == a.ZIP ? m.r(new ZipInputStream(inputStream), this.b) : m.h(inputStream, this.b);
        if (k0VarR.b() != null) {
            return k0VarR.b();
        }
        return null;
    }

    private k0<e> b() {
        try {
            return c();
        } catch (IOException e) {
            return new k0<>((Throwable) e);
        }
    }

    private k0<e> c() throws IOException {
        com.airbnb.lottie.y0.d.a("Fetching " + this.b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.b).openConnection();
        httpURLConnection.setRequestMethod(Constants.HTTP_GET);
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                k0<e> k0VarG = g(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(k0VarG.b() != null);
                com.airbnb.lottie.y0.d.a(sb.toString());
                return k0VarG;
            }
            return new k0<>((Throwable) new IllegalArgumentException("Unable to fetch " + this.b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + f(httpURLConnection)));
        } catch (Exception e) {
            return new k0<>((Throwable) e);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static k0<e> e(Context context, String str, String str2) {
        return new c(context, str, str2).d();
    }

    private String f(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    private k0<e> g(HttpURLConnection httpURLConnection) throws IOException {
        a aVar;
        k0<e> k0VarH;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        if (contentType.contains("application/zip")) {
            com.airbnb.lottie.y0.d.a("Handling zip response.");
            aVar = a.ZIP;
            b bVar = this.c;
            k0VarH = bVar == null ? m.r(new ZipInputStream(httpURLConnection.getInputStream()), null) : m.r(new ZipInputStream(new FileInputStream(bVar.f(this.b, httpURLConnection.getInputStream(), aVar))), this.b);
        } else {
            com.airbnb.lottie.y0.d.a("Received json response.");
            aVar = a.JSON;
            b bVar2 = this.c;
            k0VarH = bVar2 == null ? m.h(httpURLConnection.getInputStream(), null) : m.h(new FileInputStream(new File(bVar2.f(this.b, httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.b);
        }
        if (this.c != null && k0VarH.b() != null) {
            this.c.e(this.b, aVar);
        }
        return k0VarH;
    }

    public k0<e> d() {
        e eVarA = a();
        if (eVarA != null) {
            return new k0<>(eVarA);
        }
        com.airbnb.lottie.y0.d.a("Animation for " + this.b + " not found in cache. Fetching from network.");
        return b();
    }
}
