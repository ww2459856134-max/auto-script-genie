package androidx.preference;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class c {
    final r a;
    private final Context b;
    private boolean c = false;

    c(PreferenceGroup preferenceGroup, r rVar) {
        this.a = rVar;
        this.b = preferenceGroup.i();
    }

    private b a(PreferenceGroup preferenceGroup, List<Preference> list) {
        b bVar = new b(this.b, list, preferenceGroup.m());
        bVar.o0(new a(this, preferenceGroup));
        return bVar;
    }

    private List<Preference> b(PreferenceGroup preferenceGroup) {
        this.c = false;
        boolean z = preferenceGroup.B0() != Integer.MAX_VALUE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iE0 = preferenceGroup.E0();
        int i2 = 0;
        for (int i3 = 0; i3 < iE0; i3++) {
            Preference preferenceD0 = preferenceGroup.D0(i3);
            if (preferenceD0.G()) {
                if (!z || i2 < preferenceGroup.B0()) {
                    arrayList.add(preferenceD0);
                } else {
                    arrayList2.add(preferenceD0);
                }
                if (preferenceD0 instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceD0;
                    if (preferenceGroup2.F0()) {
                        List<Preference> listB = b(preferenceGroup2);
                        if (z && this.c) {
                            throw new IllegalArgumentException("Nested expand buttons are not supported!");
                        }
                        for (Preference preference : listB) {
                            if (!z || i2 < preferenceGroup.B0()) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i2++;
                        }
                    } else {
                        continue;
                    }
                } else {
                    i2++;
                }
            }
        }
        if (z && i2 > preferenceGroup.B0()) {
            arrayList.add(a(preferenceGroup, arrayList2));
        }
        this.c |= z;
        return arrayList;
    }

    public List<Preference> c(PreferenceGroup preferenceGroup) {
        return b(preferenceGroup);
    }
}
