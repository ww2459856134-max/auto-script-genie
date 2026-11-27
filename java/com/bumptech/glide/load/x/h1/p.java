package com.bumptech.glide.load.x.h1;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: i, reason: collision with root package name */
    static final int f613i;
    final Context a;
    ActivityManager b;
    r c;
    float e;
    float d = 2.0f;
    float f = 0.4f;
    float g = 0.33f;

    /* renamed from: h, reason: collision with root package name */
    int f614h = 4194304;

    static {
        f613i = Build.VERSION.SDK_INT < 26 ? 4 : 1;
    }

    public p(Context context) {
        this.e = f613i;
        this.a = context;
        this.b = (ActivityManager) context.getSystemService("activity");
        this.c = new q(context.getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT < 26 || !s.e(this.b)) {
            return;
        }
        this.e = 0.0f;
    }

    public s a() {
        return new s(this);
    }
}
