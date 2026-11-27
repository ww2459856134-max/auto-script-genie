package com.bumptech.glide.load.w;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
class n implements o {
    n() {
    }

    @Override // com.bumptech.glide.load.w.o
    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
}
