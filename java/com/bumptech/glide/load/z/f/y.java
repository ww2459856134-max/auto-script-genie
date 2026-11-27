package com.bumptech.glide.load.z.f;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes.dex */
public final class y {
    public static final com.bumptech.glide.load.q<com.bumptech.glide.load.b> f = com.bumptech.glide.load.q.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.bumptech.glide.load.b.e);
    public static final com.bumptech.glide.load.q<com.bumptech.glide.load.s> g = com.bumptech.glide.load.q.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", com.bumptech.glide.load.s.SRGB);

    /* renamed from: h, reason: collision with root package name */
    public static final com.bumptech.glide.load.q<Boolean> f649h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.bumptech.glide.load.q<Boolean> f650i;

    /* renamed from: j, reason: collision with root package name */
    private static final Set<String> f651j;

    /* renamed from: k, reason: collision with root package name */
    private static final x f652k;

    /* renamed from: l, reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f653l;

    /* renamed from: m, reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f654m;
    private final com.bumptech.glide.load.x.g1.g a;
    private final DisplayMetrics b;
    private final com.bumptech.glide.load.x.g1.b c;
    private final List<ImageHeaderParser> d;
    private final e0 e = e0.a();

    static {
        com.bumptech.glide.load.q<v> qVar = v.f;
        Boolean bool = Boolean.FALSE;
        f649h = com.bumptech.glide.load.q.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f650i = com.bumptech.glide.load.q.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f651j = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f652k = new w();
        f653l = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f654m = com.bumptech.glide.b0.p.e(0);
    }

    public y(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.bumptech.glide.load.x.g1.g gVar, com.bumptech.glide.load.x.g1.b bVar) {
        this.d = list;
        com.bumptech.glide.b0.n.d(displayMetrics);
        this.b = displayMetrics;
        com.bumptech.glide.b0.n.d(gVar);
        this.a = gVar;
        com.bumptech.glide.b0.n.d(bVar);
        this.c = bVar;
    }

    private static int a(double d) {
        return x((d / (r1 / r0)) * x(l(d) * d));
    }

    private void b(h0 h0Var, com.bumptech.glide.load.b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (this.e.e(i2, i3, options, z, z2)) {
            return;
        }
        if (bVar == com.bumptech.glide.load.b.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        boolean zHasAlpha = false;
        try {
            zHasAlpha = h0Var.d().hasAlpha();
        } catch (IOException e) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e);
            }
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, h0 h0Var, x xVar, com.bumptech.glide.load.x.g1.g gVar, v vVar, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int i9;
        int iFloor;
        double dFloor;
        int iRound;
        if (i3 <= 0 || i4 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
                return;
            }
            return;
        }
        if (r(i2)) {
            i8 = i3;
            i7 = i4;
        } else {
            i7 = i3;
            i8 = i4;
        }
        float fB = vVar.b(i7, i8, i5, i6);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + vVar + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        u uVarA = vVar.a(i7, i8, i5, i6);
        if (uVarA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f2 = i7;
        float f3 = i8;
        int iX = i7 / x(fB * f2);
        int iX2 = i8 / x(fB * f3);
        u uVar = u.MEMORY;
        int iMax = uVarA == uVar ? Math.max(iX, iX2) : Math.min(iX, iX2);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 23 || !f651j.contains(options.outMimeType)) {
            int iMax2 = Math.max(1, Integer.highestOneBit(iMax));
            if (uVarA == uVar && iMax2 < 1.0f / fB) {
                iMax2 <<= 1;
            }
            i9 = iMax2;
        } else {
            i9 = 1;
        }
        options.inSampleSize = i9;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(i9, 8);
            iFloor = (int) Math.ceil(f2 / fMin);
            iRound = (int) Math.ceil(f3 / fMin);
            int i11 = i9 / 8;
            if (i11 > 0) {
                iFloor /= i11;
                iRound /= i11;
            }
        } else {
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f4 = i9;
                iFloor = (int) Math.floor(f2 / f4);
                dFloor = Math.floor(f3 / f4);
            } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                if (i10 >= 24) {
                    float f5 = i9;
                    iFloor = Math.round(f2 / f5);
                    iRound = Math.round(f3 / f5);
                } else {
                    float f6 = i9;
                    iFloor = (int) Math.floor(f2 / f6);
                    dFloor = Math.floor(f3 / f6);
                }
            } else if (i7 % i9 == 0 && i8 % i9 == 0) {
                iFloor = i7 / i9;
                iRound = i8 / i9;
            } else {
                int[] iArrM = m(h0Var, options, xVar, gVar);
                iFloor = iArrM[0];
                iRound = iArrM[1];
            }
            iRound = (int) dFloor;
        }
        double dB = vVar.b(iFloor, iRound, i5, i6);
        if (i10 >= 19) {
            options.inTargetDensity = a(dB);
            options.inDensity = l(dB);
        }
        if (s(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + iFloor + "x" + iRound + "], exact scale factor: " + fB + ", power of 2 sample size: " + i9 + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private com.bumptech.glide.load.x.z0<Bitmap> e(h0 h0Var, int i2, int i3, com.bumptech.glide.load.r rVar, x xVar) throws IOException {
        byte[] bArr = (byte[]) this.c.c(WXMediaMessage.THUMB_LENGTH_LIMIT, byte[].class);
        BitmapFactory.Options optionsK = k();
        optionsK.inTempStorage = bArr;
        com.bumptech.glide.load.b bVar = (com.bumptech.glide.load.b) rVar.c(f);
        com.bumptech.glide.load.s sVar = (com.bumptech.glide.load.s) rVar.c(g);
        v vVar = (v) rVar.c(v.f);
        boolean zBooleanValue = ((Boolean) rVar.c(f649h)).booleanValue();
        com.bumptech.glide.load.q<Boolean> qVar = f650i;
        try {
            return e.e(h(h0Var, optionsK, vVar, bVar, sVar, rVar.c(qVar) != null && ((Boolean) rVar.c(qVar)).booleanValue(), i2, i3, zBooleanValue, xVar), this.a);
        } finally {
            v(optionsK);
            this.c.e(bArr);
        }
    }

    private Bitmap h(h0 h0Var, BitmapFactory.Options options, v vVar, com.bumptech.glide.load.b bVar, com.bumptech.glide.load.s sVar, boolean z, int i2, int i3, boolean z2, x xVar) throws IOException {
        int i4;
        int i5;
        y yVar;
        int iRound;
        int iRound2;
        int i6;
        ColorSpace colorSpace;
        long jB = com.bumptech.glide.b0.j.b();
        int[] iArrM = m(h0Var, options, xVar, this.a);
        boolean z3 = false;
        int i7 = iArrM[0];
        int i8 = iArrM[1];
        String str = options.outMimeType;
        boolean z4 = (i7 == -1 || i8 == -1) ? false : z;
        int iB = h0Var.b();
        int iG = r0.g(iB);
        boolean zJ = r0.j(iB);
        if (i2 == Integer.MIN_VALUE) {
            i4 = i3;
            i5 = r(iG) ? i8 : i7;
        } else {
            i4 = i3;
            i5 = i2;
        }
        int i9 = i4 == Integer.MIN_VALUE ? r(iG) ? i7 : i8 : i4;
        ImageHeaderParser.ImageType imageTypeD = h0Var.d();
        c(imageTypeD, h0Var, xVar, this.a, vVar, iG, i7, i8, i5, i9, options);
        b(h0Var, bVar, z4, zJ, options, i5, i9);
        int i10 = Build.VERSION.SDK_INT;
        boolean z5 = i10 >= 19;
        if (options.inSampleSize == 1 || z5) {
            yVar = this;
            if (yVar.z(imageTypeD)) {
                if (i7 < 0 || i8 < 0 || !z2 || !z5) {
                    float f2 = s(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i11 = options.inSampleSize;
                    float f3 = i11;
                    float f4 = f2;
                    int iCeil = (int) Math.ceil(i7 / f3);
                    int iCeil2 = (int) Math.ceil(i8 / f3);
                    iRound = Math.round(iCeil * f4);
                    iRound2 = Math.round(iCeil2 * f4);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + iRound + "x" + iRound2 + "] for source [" + i7 + "x" + i8 + "], sampleSize: " + i11 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f4);
                    }
                } else {
                    iRound = i5;
                    iRound2 = i9;
                }
                if (iRound > 0 && iRound2 > 0) {
                    y(options, yVar.a, iRound, iRound2);
                }
            }
        } else {
            yVar = this;
        }
        if (i10 >= 28) {
            if (sVar == com.bumptech.glide.load.s.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                z3 = true;
            }
            options.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i10 >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap bitmapI = i(h0Var, options, xVar, yVar.a);
        xVar.b(yVar.a, bitmapI);
        if (Log.isLoggable("Downsampler", 2)) {
            i6 = iB;
            t(i7, i8, str, options, bitmapI, i2, i3, jB);
        } else {
            i6 = iB;
        }
        Bitmap bitmapK = null;
        if (bitmapI != null) {
            bitmapI.setDensity(yVar.b.densityDpi);
            bitmapK = r0.k(yVar.a, bitmapI, i6);
            if (!bitmapI.equals(bitmapK)) {
                yVar.a.c(bitmapI);
            }
        }
        return bitmapK;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap i(h0 h0Var, BitmapFactory.Options options, x xVar, com.bumptech.glide.load.x.g1.g gVar) throws IOException {
        if (!options.inJustDecodeBounds) {
            xVar.a();
            h0Var.a();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        r0.f().lock();
        try {
            try {
                Bitmap bitmapC = h0Var.c(options);
                r0.f().unlock();
                return bitmapC;
            } catch (IllegalArgumentException e) {
                IOException iOExceptionU = u(e, i2, i3, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", iOExceptionU);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap == null) {
                    throw iOExceptionU;
                }
                try {
                    gVar.c(bitmap);
                    options.inBitmap = null;
                    Bitmap bitmapI = i(h0Var, options, xVar, gVar);
                    r0.f().unlock();
                    return bitmapI;
                } catch (IOException unused) {
                    throw iOExceptionU;
                }
            }
        } catch (Throwable th) {
            r0.f().unlock();
            throw th;
        }
    }

    @TargetApi(19)
    private static String j(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = f654m;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            w(optionsPoll);
        }
        return optionsPoll;
    }

    private static int l(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    private static int[] m(h0 h0Var, BitmapFactory.Options options, x xVar, com.bumptech.glide.load.x.g1.g gVar) throws IOException {
        options.inJustDecodeBounds = true;
        i(h0Var, options, xVar, gVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static boolean s(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    private static void t(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + n(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.b0.j.a(j2));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = f654m;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d) {
        return (int) (d + 0.5d);
    }

    @TargetApi(26)
    private static void y(BitmapFactory.Options options, com.bumptech.glide.load.x.g1.g gVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = gVar.e(i2, i3, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f653l.contains(imageType);
    }

    public com.bumptech.glide.load.x.z0<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, com.bumptech.glide.load.r rVar) throws IOException {
        return e(new g0(parcelFileDescriptor, this.d, this.c), i2, i3, rVar, f652k);
    }

    public com.bumptech.glide.load.x.z0<Bitmap> f(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.r rVar) throws IOException {
        return g(inputStream, i2, i3, rVar, f652k);
    }

    public com.bumptech.glide.load.x.z0<Bitmap> g(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.r rVar, x xVar) throws IOException {
        return e(new f0(inputStream, this.d, this.c), i2, i3, rVar, xVar);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return com.bumptech.glide.load.w.v.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }
}
