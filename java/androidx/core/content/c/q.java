package androidx.core.content.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class q {
    public static Drawable a(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i2, theme) : resources.getDrawable(i2);
    }

    public static Typeface b(Context context, int i2, TypedValue typedValue, int i3, m mVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return c(context, i2, typedValue, i3, mVar, null, true, false);
    }

    private static Typeface c(Context context, int i2, TypedValue typedValue, int i3, m mVar, Handler handler, boolean z, boolean z2) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        Typeface typefaceD = d(context, resources, typedValue, i2, i3, mVar, handler, z, z2);
        if (typefaceD != null || mVar != null || z2) {
            return typefaceD;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Typeface d(Context context, Resources resources, TypedValue typedValue, int i2, int i3, m mVar, Handler handler, boolean z, boolean z2) {
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i2) + "\" (" + Integer.toHexString(i2) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        if (!string.startsWith("res/")) {
            if (mVar != null) {
                mVar.a(-3, handler);
            }
            return null;
        }
        Typeface typefaceF = h.e.d.g.f(resources, i2, i3);
        if (typefaceF != null) {
            if (mVar != null) {
                mVar.b(typefaceF, handler);
            }
            return typefaceF;
        }
        if (z2) {
            return null;
        }
        try {
            if (!string.toLowerCase().endsWith(".xml")) {
                Typeface typefaceD = h.e.d.g.d(context, resources, i2, string, i3);
                if (mVar != null) {
                    if (typefaceD != null) {
                        mVar.b(typefaceD, handler);
                    } else {
                        mVar.a(-3, handler);
                    }
                }
                return typefaceD;
            }
            c cVarB = g.b(resources.getXml(i2), resources);
            if (cVarB != null) {
                return h.e.d.g.c(context, cVarB, resources, i2, i3, mVar, handler, z);
            }
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (mVar != null) {
                mVar.a(-3, handler);
            }
            return null;
        } catch (IOException e) {
            Log.e("ResourcesCompat", "Failed to read xml resource " + string, e);
            if (mVar != null) {
                mVar.a(-3, handler);
            }
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("ResourcesCompat", "Failed to parse xml resource " + string, e2);
            if (mVar != null) {
            }
            return null;
        }
    }
}
