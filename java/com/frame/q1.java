package com.frame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.gson.Gson;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class q1 {
    public static <T> T a(T t) {
        Gson gson = new Gson();
        return (T) gson.j(gson.s(t), t.getClass());
    }

    public static String b(int i2) {
        return String.format("#%06x", Integer.valueOf(i2 & 16777215));
    }

    public static int c() {
        try {
            Resources resources = v0.g().getApplicationContext().getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int d() {
        return v0.g().getResources().getDisplayMetrics().heightPixels;
    }

    public static int e() {
        return v0.g().getResources().getDisplayMetrics().widthPixels;
    }

    public static final int f() throws IllegalAccessException, InstantiationException, ClassNotFoundException, NumberFormatException {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return v0.g().getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception unused) {
            return g(v0.g());
        }
    }

    public static int g(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static float h(Activity activity) {
        if (activity.getResources().getIdentifier("status_bar_height", "dimen", "android") > 0) {
            return activity.getResources().getDimensionPixelSize(r0) / activity.getResources().getDisplayMetrics().density;
        }
        return 0.0f;
    }

    public static int i() {
        return j().heightPixels;
    }

    private static DisplayMetrics j() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            WindowManager windowManager = (WindowManager) v0.g().getSystemService("window");
            if (windowManager != null) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 30) {
                    Rect bounds = windowManager.getMaximumWindowMetrics().getBounds();
                    displayMetrics.widthPixels = bounds.width();
                    displayMetrics.heightPixels = bounds.height();
                } else {
                    Display defaultDisplay = windowManager.getDefaultDisplay();
                    if (i2 >= 17) {
                        defaultDisplay.getRealMetrics(displayMetrics);
                    } else {
                        defaultDisplay.getMetrics(displayMetrics);
                    }
                }
            }
        } catch (Exception unused) {
        }
        DisplayMetrics displayMetrics2 = v0.g().getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels <= 0) {
            displayMetrics.widthPixels = Math.max(1, displayMetrics2.widthPixels);
        }
        if (displayMetrics.heightPixels <= 0) {
            displayMetrics.heightPixels = Math.max(1, displayMetrics2.heightPixels);
        }
        return displayMetrics;
    }

    public static int k() {
        return j().widthPixels;
    }

    public static boolean l(String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            return v0.g().getPackageManager().queryIntentActivities(intent, WXMediaMessage.THUMB_LENGTH_LIMIT).size() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int m(int i2, int i3) {
        return new Random().nextInt(i3 - i2) + i2;
    }

    public static final void n(Activity activity, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", str);
            intent.putExtra("android.intent.extra.TEXT", str2);
            activity.startActivity(Intent.createChooser(intent, str));
            k0.i("share");
        } catch (Exception e) {
            k0.r(e);
        }
    }
}
