package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.t;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    private boolean t0;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, androidx.core.content.c.r.a(context, y.g, R.attr.preferenceScreenStyle));
        this.t0 = true;
    }

    @Override // androidx.preference.PreferenceGroup
    protected boolean F0() {
        return false;
    }

    public boolean K0() {
        return this.t0;
    }

    @Override // androidx.preference.Preference
    protected void O() {
        t.b bVarG;
        if (n() != null || l() != null || E0() == 0 || (bVarG = x().g()) == null) {
            return;
        }
        bVarG.e(this);
    }
}
