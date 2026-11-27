package androidx.preference;

import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;

/* loaded from: classes.dex */
class a implements Preference.e {
    final /* synthetic */ PreferenceGroup a;
    final /* synthetic */ c b;

    a(c cVar, PreferenceGroup preferenceGroup) {
        this.b = cVar;
        this.a = preferenceGroup;
    }

    @Override // androidx.preference.Preference.e
    public boolean a(Preference preference) {
        this.a.H0(Integer.MAX_VALUE);
        this.b.a.b(preference);
        PreferenceGroup.a aVarC0 = this.a.C0();
        if (aVarC0 == null) {
            return true;
        }
        aVarC0.a();
        return true;
    }
}
