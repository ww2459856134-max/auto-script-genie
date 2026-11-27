package h.e.j;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import h.e.j.e1;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
abstract class d1 {
    private static Field a;
    private static Field b;
    private static Field c;
    private static boolean d;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            c = declaredField3;
            declaredField3.setAccessible(true);
            d = true;
        } catch (ReflectiveOperationException e) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }
    }

    public static e1 a(View view) throws IllegalAccessException, IllegalArgumentException {
        if (d && view.isAttachedToWindow()) {
            try {
                Object obj = a.get(view.getRootView());
                if (obj != null) {
                    Rect rect = (Rect) b.get(obj);
                    Rect rect2 = (Rect) c.get(obj);
                    if (rect != null && rect2 != null) {
                        e1.a aVar = new e1.a();
                        aVar.b(h.e.d.b.c(rect));
                        aVar.c(h.e.d.b.c(rect2));
                        e1 e1VarA = aVar.a();
                        e1VarA.o(e1VarA);
                        e1VarA.d(view.getRootView());
                        return e1VarA;
                    }
                }
            } catch (IllegalAccessException e) {
                Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            }
        }
        return null;
    }
}
