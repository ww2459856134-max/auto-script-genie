package com.bumptech.glide.load.x.g1;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class r implements g {

    /* renamed from: j, reason: collision with root package name */
    private static final Bitmap.Config f605j = Bitmap.Config.ARGB_8888;
    private final s a;
    private final Set<Bitmap.Config> b;
    private final p c;
    private long d;
    private long e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f606h;

    /* renamed from: i, reason: collision with root package name */
    private int f607i;

    r(long j2, s sVar, Set<Bitmap.Config> set) {
        this.d = j2;
        this.a = sVar;
        this.b = set;
        this.c = new q();
    }

    @TargetApi(26)
    private static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private static Bitmap g(int i2, int i3, Bitmap.Config config) {
        if (config == null) {
            config = f605j;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f + ", misses=" + this.g + ", puts=" + this.f606h + ", evictions=" + this.f607i + ", currentSize=" + this.e + ", maxSize=" + this.d + "\nStrategy=" + this.a);
    }

    private void j() {
        q(this.d);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            hashSet.add(null);
        }
        if (i2 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static s l() {
        return Build.VERSION.SDK_INT >= 19 ? new x() : new e();
    }

    private synchronized Bitmap m(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapD;
        f(config);
        bitmapD = this.a.d(i2, i3, config != null ? config : f605j);
        if (bitmapD == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.a.a(i2, i3, config));
            }
            this.g++;
        } else {
            this.f++;
            this.e -= this.a.b(bitmapD);
            this.c.b(bitmapD);
            p(bitmapD);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.a.a(i2, i3, config));
        }
        h();
        return bitmapD;
    }

    @TargetApi(19)
    private static void o(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j2) {
        while (this.e > j2) {
            Bitmap bitmapF = this.a.f();
            if (bitmapF == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    i();
                }
                this.e = 0L;
                return;
            }
            this.c.b(bitmapF);
            this.e -= this.a.b(bitmapF);
            this.f607i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.a.e(bitmapF));
            }
            h();
            bitmapF.recycle();
        }
    }

    @Override // com.bumptech.glide.load.x.g1.g
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i2);
        }
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            b();
        } else if (i2 >= 20 || i2 == 15) {
            q(n() / 2);
        }
    }

    @Override // com.bumptech.glide.load.x.g1.g
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // com.bumptech.glide.load.x.g1.g
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.a.b(bitmap) <= this.d && this.b.contains(bitmap.getConfig())) {
                int iB = this.a.b(bitmap);
                this.a.c(bitmap);
                this.c.a(bitmap);
                this.f606h++;
                this.e += iB;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.a.e(bitmap));
                }
                h();
                j();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.a.e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.b.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.x.g1.g
    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapM = m(i2, i3, config);
        if (bitmapM == null) {
            return g(i2, i3, config);
        }
        bitmapM.eraseColor(0);
        return bitmapM;
    }

    @Override // com.bumptech.glide.load.x.g1.g
    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapM = m(i2, i3, config);
        return bitmapM == null ? g(i2, i3, config) : bitmapM;
    }

    public long n() {
        return this.d;
    }

    public r(long j2) {
        this(j2, l(), k());
    }
}
