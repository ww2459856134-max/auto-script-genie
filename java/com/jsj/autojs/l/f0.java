package com.jsj.autojs.l;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.jsj.autojs.activity.Ae029968deb;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public class f0 {
    private int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 <= 0 || i5 <= 0) {
            return 1;
        }
        while (true) {
            if (i4 / i6 <= i3 && i5 / i6 <= i2) {
                return i6;
            }
            i6 *= 2;
        }
    }

    private void b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (Exception unused) {
        }
    }

    public static Map<i.f.a.e, Object> d() {
        EnumMap enumMap = new EnumMap(i.f.a.e.class);
        enumMap.put((EnumMap) i.f.a.e.POSSIBLE_FORMATS, (i.f.a.e) Collections.singletonList(i.f.a.a.QR_CODE));
        enumMap.put((EnumMap) i.f.a.e.CHARACTER_SET, (i.f.a.e) "UTF-8");
        enumMap.put((EnumMap) i.f.a.e.TRY_HARDER, (i.f.a.e) Boolean.TRUE);
        return enumMap;
    }

    private Bitmap e(Activity activity, Uri uri) throws Throwable {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpenInputStream = activity.getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                b(inputStreamOpenInputStream);
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inPreferredConfig = Bitmap.Config.RGB_565;
                options2.inSampleSize = a(options, 1600, 1600);
                try {
                    InputStream inputStreamOpenInputStream2 = activity.getContentResolver().openInputStream(uri);
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options2);
                        b(inputStreamOpenInputStream2);
                        return bitmapDecodeStream;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStreamOpenInputStream2;
                        b(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStreamOpenInputStream;
                b(inputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private i.f.a.p f(Bitmap bitmap) throws i.f.a.k {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return h(new i.f.a.m(width, height, iArr));
    }

    private i.f.a.p h(i.f.a.i iVar) throws i.f.a.k {
        i.f.a.j jVar = new i.f.a.j();
        jVar.e(d());
        try {
            return jVar.d(new i.f.a.c(new i.f.a.v.j(iVar)));
        } catch (i.f.a.k unused) {
            return jVar.d(new i.f.a.c(new i.f.a.v.j(iVar.e())));
        } finally {
            jVar.b();
        }
    }

    public Bitmap c(String str) throws i.f.a.t {
        EnumMap enumMap = new EnumMap(i.f.a.f.class);
        enumMap.put((EnumMap) i.f.a.f.CHARACTER_SET, (i.f.a.f) "UTF-8");
        i.f.a.v.b bVarA = new i.f.a.a0.b().a(str, i.f.a.a.QR_CODE, 480, 480, enumMap);
        int iJ = bVarA.j();
        int iG = bVarA.g();
        int[] iArr = new int[iJ * iG];
        for (int i2 = 0; i2 < iG; i2++) {
            int i3 = i2 * iJ;
            for (int i4 = 0; i4 < iJ; i4++) {
                iArr[i3 + i4] = bVarA.d(i4, i2) ? -16777216 : -1;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iJ, iG, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, iJ, 0, 0, iJ, iG);
        return bitmapCreateBitmap;
    }

    public String g(Activity activity, Uri uri) throws Throwable {
        Bitmap bitmapE;
        Bitmap bitmap = null;
        if (activity != null && uri != null) {
            try {
                bitmapE = e(activity, uri);
                if (bitmapE == null) {
                    if (bitmapE != null && !bitmapE.isRecycled()) {
                        bitmapE.recycle();
                    }
                    return null;
                }
                try {
                    i.f.a.p pVarF = f(bitmapE);
                    String strF = pVarF != null ? pVarF.f() : null;
                    if (bitmapE != null && !bitmapE.isRecycled()) {
                        bitmapE.recycle();
                    }
                    return strF;
                } catch (Exception unused) {
                    if (bitmapE != null && !bitmapE.isRecycled()) {
                        bitmapE.recycle();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    bitmap = bitmapE;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                bitmapE = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public void i(Activity activity, int i2) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        activity.startActivityForResult(intent, i2);
    }

    public void j(Activity activity, int i2) {
        activity.startActivityForResult(new Intent(activity, (Class<?>) Ae029968deb.class), i2);
    }
}
