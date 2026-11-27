package com.airbnb.lottie.u0;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.v0.j;
import com.airbnb.lottie.y0.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {
    private final AssetManager d;
    private com.airbnb.lottie.a e;
    private final j<String> a = new j<>();
    private final Map<j<String>, Typeface> b = new HashMap();
    private final Map<String, Typeface> c = new HashMap();
    private String f = ".ttf";

    public a(Drawable.Callback callback, com.airbnb.lottie.a aVar) {
        if (callback instanceof View) {
            this.d = ((View) callback).getContext().getAssets();
        } else {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
        }
    }

    private Typeface a(String str) {
        String strB;
        Typeface typeface = this.c.get(str);
        if (typeface != null) {
            return typeface;
        }
        com.airbnb.lottie.a aVar = this.e;
        Typeface typefaceA = aVar != null ? aVar.a(str) : null;
        com.airbnb.lottie.a aVar2 = this.e;
        if (aVar2 != null && typefaceA == null && (strB = aVar2.b(str)) != null) {
            typefaceA = Typeface.createFromAsset(this.d, strB);
        }
        if (typefaceA == null) {
            typefaceA = Typeface.createFromAsset(this.d, "fonts/" + str + this.f);
        }
        this.c.put(str, typefaceA);
        return typefaceA;
    }

    private Typeface d(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i2 = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
    }

    public Typeface b(String str, String str2) {
        this.a.b(str, str2);
        Typeface typeface = this.b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceD = d(a(str), str2);
        this.b.put(this.a, typefaceD);
        return typefaceD;
    }

    public void c(com.airbnb.lottie.a aVar) {
    }
}
