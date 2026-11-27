package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    private CharSequence m0;
    private CharSequence n0;
    private Drawable o0;
    private CharSequence p0;
    private CharSequence q0;
    private int r0;

    public interface a {
        Preference a(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.f296j, i2, i3);
        String strO = androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.t, e0.f297k);
        this.m0 = strO;
        if (strO == null) {
            this.m0 = A();
        }
        this.n0 = androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.s, e0.f298l);
        this.o0 = androidx.core.content.c.r.c(typedArrayObtainStyledAttributes, e0.q, e0.f299m);
        this.p0 = androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.v, e0.f300n);
        this.q0 = androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.u, e0.f301o);
        this.r0 = androidx.core.content.c.r.n(typedArrayObtainStyledAttributes, e0.r, e0.p, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public CharSequence A0() {
        return this.n0;
    }

    public CharSequence B0() {
        return this.m0;
    }

    public CharSequence C0() {
        return this.q0;
    }

    public CharSequence D0() {
        return this.p0;
    }

    @Override // androidx.preference.Preference
    protected void O() {
        x().u(this);
    }

    public Drawable y0() {
        return this.o0;
    }

    public int z0() {
        return this.r0;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.c.r.a(context, y.b, R.attr.dialogPreferenceStyle));
    }
}
