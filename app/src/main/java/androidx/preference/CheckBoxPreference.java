package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;

/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    private final a r0;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (CheckBoxPreference.this.b(Boolean.valueOf(z))) {
                CheckBoxPreference.this.z0(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F0(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.o0);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.r0);
        }
    }

    private void G0(View view) {
        if (((AccessibilityManager) i().getSystemService("accessibility")).isEnabled()) {
            F0(view.findViewById(R.id.checkbox));
            D0(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void N(x xVar) {
        super.N(xVar);
        F0(xVar.b(R.id.checkbox));
        E0(xVar);
    }

    @Override // androidx.preference.Preference
    protected void Z(View view) {
        super.Z(view);
        G0(view);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.r0 = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.c, i2, i3);
        C0(androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.f295i, e0.d));
        B0(androidx.core.content.c.r.o(typedArrayObtainStyledAttributes, e0.f294h, e0.e));
        A0(androidx.core.content.c.r.b(typedArrayObtainStyledAttributes, e0.g, e0.f, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.c.r.a(context, y.a, R.attr.checkBoxPreferenceStyle));
    }
}
