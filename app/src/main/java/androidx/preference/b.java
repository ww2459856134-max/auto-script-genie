package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class b extends Preference {
    private long m0;

    b(Context context, List<Preference> list, long j2) {
        super(context);
        y0();
        z0(list);
        this.m0 = j2 + 1000000;
    }

    private void y0() {
        m0(b0.a);
        j0(z.a);
        r0(c0.a);
        p0(999);
    }

    private void z0(List<Preference> list) {
        ArrayList arrayList = new ArrayList();
        CharSequence string = null;
        for (Preference preference : list) {
            CharSequence charSequenceA = preference.A();
            boolean z = preference instanceof PreferenceGroup;
            if (z && !TextUtils.isEmpty(charSequenceA)) {
                arrayList.add((PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.r())) {
                if (z) {
                    arrayList.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(charSequenceA)) {
                string = string == null ? charSequenceA : i().getString(c0.b, string, charSequenceA);
            }
        }
        q0(string);
    }

    @Override // androidx.preference.Preference
    public void N(x xVar) {
        super.N(xVar);
        xVar.e(false);
    }

    @Override // androidx.preference.Preference
    public long m() {
        return this.m0;
    }
}
