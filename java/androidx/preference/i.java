package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.p;
import androidx.preference.internal.AbstractMultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class i extends l {
    Set<String> X0 = new HashSet();
    boolean Y0;
    CharSequence[] Z0;
    CharSequence[] a1;

    class a implements DialogInterface.OnMultiChoiceClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
            if (z) {
                i iVar = i.this;
                iVar.Y0 = iVar.X0.add(iVar.a1[i2].toString()) | iVar.Y0;
            } else {
                i iVar2 = i.this;
                iVar2.Y0 = iVar2.X0.remove(iVar2.a1[i2].toString()) | iVar2.Y0;
            }
        }
    }

    private AbstractMultiSelectListPreference s2() {
        return (AbstractMultiSelectListPreference) l2();
    }

    public static i t2(String str) {
        i iVar = new i();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        iVar.G1(bundle);
        return iVar;
    }

    @Override // androidx.preference.l, androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void R0(Bundle bundle) {
        super.R0(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.X0));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.Y0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.Z0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.a1);
    }

    @Override // androidx.preference.l
    public void p2(boolean z) {
        AbstractMultiSelectListPreference abstractMultiSelectListPreferenceS2 = s2();
        if (z && this.Y0) {
            Set<String> set = this.X0;
            if (abstractMultiSelectListPreferenceS2.b(set)) {
                abstractMultiSelectListPreferenceS2.H0(set);
            }
        }
        this.Y0 = false;
    }

    @Override // androidx.preference.l
    protected void q2(p.a aVar) {
        super.q2(aVar);
        int length = this.a1.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = this.X0.contains(this.a1[i2].toString());
        }
        aVar.g(this.Z0, zArr, new a());
    }

    @Override // androidx.preference.l, androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
        if (bundle != null) {
            this.X0.clear();
            this.X0.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.Y0 = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.Z0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.a1 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        AbstractMultiSelectListPreference abstractMultiSelectListPreferenceS2 = s2();
        if (abstractMultiSelectListPreferenceS2.E0() == null || abstractMultiSelectListPreferenceS2.F0() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.X0.clear();
        this.X0.addAll(abstractMultiSelectListPreferenceS2.G0());
        this.Y0 = false;
        this.Z0 = abstractMultiSelectListPreferenceS2.E0();
        this.a1 = abstractMultiSelectListPreferenceS2.F0();
    }
}
