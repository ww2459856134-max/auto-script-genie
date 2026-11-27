package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class a {

    @Deprecated
    public static abstract class b {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public abstract void m(Configuration configuration);

    void n() {
    }

    public abstract boolean o(int i2, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z);

    public abstract void s(boolean z);

    public abstract void t(CharSequence charSequence);

    public abstract h.a.o.c u(h.a.o.b bVar);

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0000a extends ViewGroup.MarginLayoutParams {
        public int a;

        public C0000a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.a.j.t);
            this.a = typedArrayObtainStyledAttributes.getInt(h.a.j.u, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0000a(int i2, int i3) {
            super(i2, i3);
            this.a = 0;
            this.a = 8388627;
        }

        public C0000a(C0000a c0000a) {
            super((ViewGroup.MarginLayoutParams) c0000a);
            this.a = 0;
            this.a = c0000a.a;
        }

        public C0000a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }
    }
}
