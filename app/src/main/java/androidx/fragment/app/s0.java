package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public abstract class s0<E> extends p0 {
    private final Activity c;
    private final Context d;
    private final Handler e;
    final p1 f;

    s0(h0 h0Var) {
        this(h0Var, h0Var, new Handler(), 0);
    }

    Activity h() {
        return this.c;
    }

    Context i() {
        return this.d;
    }

    Handler j() {
        return this.e;
    }

    public abstract E l();

    public abstract LayoutInflater m();

    public abstract boolean n(Fragment fragment);

    public void p(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (i2 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        androidx.core.content.a.i(this.d, intent, bundle);
    }

    public abstract void q();

    s0(Activity activity, Context context, Handler handler, int i2) {
        this.f = new q1();
        this.c = activity;
        h.e.i.h.e(context, "context == null");
        this.d = context;
        h.e.i.h.e(handler, "handler == null");
        this.e = handler;
    }
}
