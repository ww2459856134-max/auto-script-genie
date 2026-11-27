package androidx.preference;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import h.e.j.q1.e;

/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // androidx.preference.Preference
    public boolean D() {
        return false;
    }

    @Override // androidx.preference.Preference
    public void N(x xVar) {
        super.N(xVar);
        if (Build.VERSION.SDK_INT >= 28) {
            xVar.itemView.setAccessibilityHeading(true);
        }
    }

    @Override // androidx.preference.Preference
    public void S(h.e.j.q1.e eVar) {
        e.a aVarO;
        super.S(eVar);
        if (Build.VERSION.SDK_INT >= 28 || (aVarO = eVar.o()) == null) {
            return;
        }
        eVar.X(e.a.f(aVarO.c(), aVarO.d(), aVarO.a(), aVarO.b(), true, aVarO.e()));
    }

    @Override // androidx.preference.Preference
    public boolean t0() {
        return !super.D();
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.c.r.a(context, y.e, R.attr.preferenceCategoryStyle));
    }
}
