package com.bumptech.glide.y;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class c {
    private final List<ImageHeaderParser> a = new ArrayList();

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.a.add(imageHeaderParser);
    }

    public synchronized List<ImageHeaderParser> b() {
        return this.a;
    }
}
