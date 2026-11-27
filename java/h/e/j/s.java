package h.e.j;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;

/* loaded from: classes.dex */
public abstract class s {
    public static MenuItem a(MenuItem menuItem, e eVar) {
        if (menuItem instanceof h.e.e.a.b) {
            return ((h.e.e.a.b) menuItem).b(eVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void b(MenuItem menuItem, char c, int i2) {
        if (menuItem instanceof h.e.e.a.b) {
            ((h.e.e.a.b) menuItem).setAlphabeticShortcut(c, i2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c, i2);
        }
    }

    public static void c(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof h.e.e.a.b) {
            ((h.e.e.a.b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void d(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof h.e.e.a.b) {
            ((h.e.e.a.b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void e(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof h.e.e.a.b) {
            ((h.e.e.a.b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }

    public static void f(MenuItem menuItem, char c, int i2) {
        if (menuItem instanceof h.e.e.a.b) {
            ((h.e.e.a.b) menuItem).setNumericShortcut(c, i2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c, i2);
        }
    }

    public static void g(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof h.e.e.a.b) {
            ((h.e.e.a.b) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }
}
