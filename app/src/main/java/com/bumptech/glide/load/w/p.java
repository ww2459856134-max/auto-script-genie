package com.bumptech.glide.load.w;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.y.c0;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public class p implements e<InputStream> {

    /* renamed from: i, reason: collision with root package name */
    static final o f594i = new n();
    private final c0 c;
    private final int d;
    private final o e;
    private HttpURLConnection f;
    private InputStream g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f595h;

    public p(c0 c0Var, int i2) {
        this(c0Var, i2, f594i);
    }

    private InputStream e(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.g = com.bumptech.glide.b0.e.c(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.g = httpURLConnection.getInputStream();
        }
        return this.g;
    }

    private static boolean f(int i2) {
        return i2 / 100 == 2;
    }

    private static boolean g(int i2) {
        return i2 / 100 == 3;
    }

    private InputStream h(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 >= 5) {
            throw new com.bumptech.glide.load.e("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new com.bumptech.glide.load.e("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.f = this.e.a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.f.setConnectTimeout(this.d);
        this.f.setReadTimeout(this.d);
        this.f.setUseCaches(false);
        this.f.setDoInput(true);
        this.f.setInstanceFollowRedirects(false);
        this.f.connect();
        this.g = this.f.getInputStream();
        if (this.f595h) {
            return null;
        }
        int responseCode = this.f.getResponseCode();
        if (f(responseCode)) {
            return e(this.f);
        }
        if (!g(responseCode)) {
            if (responseCode == -1) {
                throw new com.bumptech.glide.load.e(responseCode);
            }
            throw new com.bumptech.glide.load.e(this.f.getResponseMessage(), responseCode);
        }
        String headerField = this.f.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            throw new com.bumptech.glide.load.e("Received empty or null redirect url");
        }
        URL url3 = new URL(url, headerField);
        b();
        return h(url3, i2 + 1, url, map);
    }

    @Override // com.bumptech.glide.load.w.e
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.w.e
    public void b() throws IOException {
        InputStream inputStream = this.g;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f = null;
    }

    @Override // com.bumptech.glide.load.w.e
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.REMOTE;
    }

    @Override // com.bumptech.glide.load.w.e
    public void cancel() {
        this.f595h = true;
    }

    @Override // com.bumptech.glide.load.w.e
    public void d(com.bumptech.glide.h hVar, d<? super InputStream> dVar) {
        StringBuilder sb;
        long jB = com.bumptech.glide.b0.j.b();
        try {
            try {
                dVar.e(h(this.c.h(), 0, null, this.c.e()));
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                dVar.f(e);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                } else {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(com.bumptech.glide.b0.j.a(jB));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + com.bumptech.glide.b0.j.a(jB));
            }
            throw th;
        }
    }

    p(c0 c0Var, int i2, o oVar) {
        this.c = c0Var;
        this.d = i2;
        this.e = oVar;
    }
}
