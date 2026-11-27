package com.jsj.autojs.l;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import android.util.TypedValue;
import android.widget.ImageView;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class w {
    private static final LruCache<String, Drawable> a = new v(4194304);

    public static Drawable a(Resources resources, String str) throws IOException {
        String str2 = "app_images/xxhdpi/" + str;
        String str3 = resources.getDisplayMetrics().densityDpi + ParameterizedMessage.ERROR_MSG_SEPARATOR + str2;
        LruCache<String, Drawable> lruCache = a;
        Drawable drawable = lruCache.get(str3);
        if (drawable != null) {
            return drawable.getConstantState().newDrawable(resources).mutate();
        }
        TypedValue typedValue = new TypedValue();
        typedValue.density = 480;
        try {
            InputStream inputStreamOpen = resources.getAssets().open(str2);
            try {
                Drawable drawableCreateFromResourceStream = Drawable.createFromResourceStream(resources, typedValue, inputStreamOpen, str2);
                if (drawableCreateFromResourceStream == null) {
                    throw new IOException("Cannot decode " + str2);
                }
                if (!(drawableCreateFromResourceStream instanceof BitmapDrawable) || drawableCreateFromResourceStream.getConstantState() == null) {
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    return drawableCreateFromResourceStream;
                }
                lruCache.put(str3, drawableCreateFromResourceStream);
                Drawable drawableMutate = drawableCreateFromResourceStream.getConstantState().newDrawable(resources).mutate();
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return drawableMutate;
            } finally {
            }
        } catch (IOException e) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(str2);
            notFoundException.initCause(e);
            throw notFoundException;
        }
    }

    public static void b(ImageView imageView, String str) {
        imageView.setImageDrawable(a(imageView.getResources(), str));
    }
}
