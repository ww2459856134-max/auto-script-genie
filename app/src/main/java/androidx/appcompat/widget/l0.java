package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.z;

/* loaded from: classes.dex */
public interface l0 {
    boolean a();

    boolean b();

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    void g(int i2);

    CharSequence getTitle();

    int h();

    void i();

    void j(boolean z);

    void k();

    void l(int i2);

    int m();

    void n();

    h.e.j.z0 o(int i2, long j2);

    ViewGroup p();

    void q(boolean z);

    Context r();

    void s(ScrollingTabContainerView scrollingTabContainerView);

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setMenu(Menu menu, z.a aVar);

    void setMenuPrepared();

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(int i2);
}
