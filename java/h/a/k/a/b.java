package h.a.k.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.j1;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public abstract class b {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    private static final WeakHashMap<Context, SparseArray<a>> b = new WeakHashMap<>(0);
    private static final Object c = new Object();

    private static void a(Context context, int i2, ColorStateList colorStateList) {
        synchronized (c) {
            WeakHashMap<Context, SparseArray<a>> weakHashMap = b;
            SparseArray<a> sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i2, new a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static ColorStateList b(Context context, int i2) {
        a aVar;
        synchronized (c) {
            SparseArray<a> sparseArray = b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = sparseArray.get(i2)) != null) {
                if (aVar.b.equals(context.getResources().getConfiguration())) {
                    return aVar.a;
                }
                sparseArray.remove(i2);
            }
            return null;
        }
    }

    public static ColorStateList c(Context context, int i2) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList colorStateListB = b(context, i2);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListF = f(context, i2);
        if (colorStateListF == null) {
            return androidx.core.content.a.d(context, i2);
        }
        a(context, i2, colorStateListF);
        return colorStateListF;
    }

    public static Drawable d(Context context, int i2) {
        return j1.h().j(context, i2);
    }

    private static TypedValue e() {
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList f(Context context, int i2) throws Resources.NotFoundException {
        if (g(context, i2)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return androidx.core.content.c.a.a(resources, resources.getXml(i2), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static boolean g(Context context, int i2) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        TypedValue typedValueE = e();
        resources.getValue(i2, typedValueE, true);
        int i3 = typedValueE.type;
        return i3 >= 28 && i3 <= 31;
    }
}
