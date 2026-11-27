package com.airbnb.lottie.u0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.f0;
import com.airbnb.lottie.y0.d;
import com.airbnb.lottie.y0.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b {
    private static final Object e = new Object();
    private final Context a;
    private String b;
    private com.airbnb.lottie.b c;
    private final Map<String, f0> d;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map<String, f0> map) {
        this.b = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.b.charAt(r4.length() - 1) != '/') {
                this.b += '/';
            }
        }
        if (callback instanceof View) {
            this.a = ((View) callback).getContext();
            this.d = map;
            d(bVar);
        } else {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.d = new HashMap();
            this.a = null;
        }
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (e) {
            this.d.get(str).f(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        f0 f0Var = this.d.get(str);
        if (f0Var == null) {
            return null;
        }
        Bitmap bitmapA = f0Var.a();
        if (bitmapA != null) {
            return bitmapA;
        }
        com.airbnb.lottie.b bVar = this.c;
        if (bVar != null) {
            Bitmap bitmapA2 = bVar.a(f0Var);
            if (bitmapA2 != null) {
                c(str, bitmapA2);
            }
            return bitmapA2;
        }
        String strB = f0Var.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strB.startsWith("data:") && strB.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strB.substring(strB.indexOf(44) + 1), 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                c(str, bitmapDecodeByteArray);
                return bitmapDecodeByteArray;
            } catch (IllegalArgumentException e2) {
                d.d("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            Bitmap bitmapL = h.l(BitmapFactory.decodeStream(this.a.getAssets().open(this.b + strB), null, options), f0Var.e(), f0Var.c());
            c(str, bitmapL);
            return bitmapL;
        } catch (IOException e3) {
            d.d("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.a == null) || this.a.equals(context);
    }

    public void d(com.airbnb.lottie.b bVar) {
        this.c = bVar;
    }
}
