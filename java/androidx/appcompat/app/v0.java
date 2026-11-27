package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class v0 extends Dialog implements t {
    private u c;
    private final h.e.j.o d;

    public v0(Context context, int i2) {
        super(context, b(context, i2));
        this.d = new u0(this);
        u uVarA = a();
        uVarA.D(b(context, i2));
        uVarA.q(null);
    }

    private static int b(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(h.a.a.z, typedValue, true);
        return typedValue.resourceId;
    }

    public u a() {
        if (this.c == null) {
            this.c = u.h(this, this);
        }
        return this.c;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().d(view, layoutParams);
    }

    @Override // androidx.appcompat.app.t
    public void c(h.a.o.c cVar) {
    }

    @Override // androidx.appcompat.app.t
    public h.a.o.c d(h.a.o.b bVar) {
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a().r();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return h.e.j.p.e(this.d, getWindow().getDecorView(), this, keyEvent);
    }

    boolean e(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean f(int i2) {
        return a().z(i2);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i2) {
        return (T) a().i(i2);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().o();
    }

    @Override // androidx.appcompat.app.t
    public void n(h.a.o.c cVar) {
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        a().n();
        super.onCreate(bundle);
        a().q(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().w();
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        a().A(i2);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().E(charSequence);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().B(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().C(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        a().E(getContext().getString(i2));
    }
}
