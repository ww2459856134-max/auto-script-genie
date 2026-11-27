package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class u {
    private static int c = -100;
    private static final h.d.d<WeakReference<u>> d = new h.d.d<>();
    private static final Object e = new Object();

    u() {
    }

    static void c(u uVar) {
        synchronized (e) {
            y(uVar);
            d.add(new WeakReference<>(uVar));
        }
    }

    public static u g(Activity activity, t tVar) {
        return new t0(activity, tVar);
    }

    public static u h(Dialog dialog, t tVar) {
        return new t0(dialog, tVar);
    }

    public static int j() {
        return c;
    }

    static void x(u uVar) {
        synchronized (e) {
            y(uVar);
        }
    }

    private static void y(u uVar) {
        synchronized (e) {
            Iterator<WeakReference<u>> it = d.iterator();
            while (it.hasNext()) {
                u uVar2 = it.next().get();
                if (uVar2 == uVar || uVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract void A(int i2);

    public abstract void B(View view);

    public abstract void C(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void D(int i2);

    public abstract void E(CharSequence charSequence);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    @Deprecated
    public void e(Context context) {
    }

    public Context f(Context context) {
        e(context);
        return context;
    }

    public abstract <T extends View> T i(int i2);

    public abstract int k();

    public abstract MenuInflater l();

    public abstract a m();

    public abstract void n();

    public abstract void o();

    public abstract void p(Configuration configuration);

    public abstract void q(Bundle bundle);

    public abstract void r();

    public abstract void s(Bundle bundle);

    public abstract void t();

    public abstract void u(Bundle bundle);

    public abstract void v();

    public abstract void w();

    public abstract boolean z(int i2);
}
