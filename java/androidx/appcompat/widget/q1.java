package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class q1 extends ContextWrapper {
    private static final Object c = new Object();
    private static ArrayList<WeakReference<q1>> d;
    private final Resources a;
    private final Resources.Theme b;

    private q1(Context context) {
        super(context);
        if (!d2.b()) {
            this.a = new s1(this, context.getResources());
            this.b = null;
            return;
        }
        d2 d2Var = new d2(this, context.getResources());
        this.a = d2Var;
        Resources.Theme themeNewTheme = d2Var.newTheme();
        this.b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        if ((context instanceof q1) || (context.getResources() instanceof s1) || (context.getResources() instanceof d2)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || d2.b();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (c) {
            ArrayList<WeakReference<q1>> arrayList = d;
            if (arrayList == null) {
                d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<q1> weakReference = d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        d.remove(size);
                    }
                }
                for (int size2 = d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<q1> weakReference2 = d.get(size2);
                    q1 q1Var = weakReference2 != null ? weakReference2.get() : null;
                    if (q1Var != null && q1Var.getBaseContext() == context) {
                        return q1Var;
                    }
                }
            }
            q1 q1Var2 = new q1(context);
            d.add(new WeakReference<>(q1Var2));
            return q1Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Resources.Theme theme = this.b;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
