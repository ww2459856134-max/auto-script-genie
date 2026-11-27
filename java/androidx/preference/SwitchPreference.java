package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    private final a r0;
    private CharSequence s0;
    private CharSequence t0;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SwitchPreference.this.b(Boolean.valueOf(z))) {
                SwitchPreference.this.z0(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.r0 = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.H0, i2, i3);
        C0(androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.P0, e0.I0));
        B0(androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.O0, e0.J0));
        G0(androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.R0, e0.L0));
        F0(androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.Q0, e0.M0));
        A0(androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, e0.N0, e0.K0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void H0(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.o0);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.s0);
            r4.setTextOff(this.t0);
            r4.setOnCheckedChangeListener(this.r0);
        }
    }

    private void I0(View view) {
        if (((AccessibilityManager) i().getSystemService("accessibility")).isEnabled()) {
            H0(view.findViewById(R.id.switch_widget));
            D0(view.findViewById(R.id.summary));
        }
    }

    public void F0(CharSequence charSequence) {
        this.t0 = charSequence;
        H();
    }

    public void G0(CharSequence charSequence) {
        this.s0 = charSequence;
        H();
    }

    @Override // androidx.preference.Preference
    public void N(x xVar) {
        super.N(xVar);
        H0(xVar.b(R.id.switch_widget));
        E0(xVar);
    }

    @Override // androidx.preference.Preference
    protected void Z(View view) {
        super.Z(view);
        I0(view);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.c.r.a(context, y.f315l, R.attr.switchPreferenceStyle));
    }
}
