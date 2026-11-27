package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;

/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    private final a r0;
    private CharSequence s0;
    private CharSequence t0;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SwitchPreferenceCompat.this.b(Boolean.valueOf(z))) {
                SwitchPreferenceCompat.this.z0(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.r0 = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.S0, i2, i3);
        C0(androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.a1, e0.T0));
        B0(androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.Z0, e0.U0));
        G0(androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.c1, e0.W0));
        F0(androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.b1, e0.X0));
        A0(androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, e0.Y0, e0.V0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void H0(View view) throws Resources.NotFoundException {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.o0);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.s0);
            switchCompat.setTextOff(this.t0);
            switchCompat.setOnCheckedChangeListener(this.r0);
        }
    }

    private void I0(View view) throws Resources.NotFoundException {
        if (((AccessibilityManager) i().getSystemService("accessibility")).isEnabled()) {
            H0(view.findViewById(a0.f));
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
    public void N(x xVar) throws Resources.NotFoundException {
        super.N(xVar);
        H0(xVar.b(a0.f));
        E0(xVar);
    }

    @Override // androidx.preference.Preference
    protected void Z(View view) throws Resources.NotFoundException {
        super.Z(view);
        I0(view);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, y.f314k);
    }
}
