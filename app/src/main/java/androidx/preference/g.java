package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.p;

/* loaded from: classes.dex */
public class g extends l {
    int X0;
    private CharSequence[] Y0;
    private CharSequence[] Z0;

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            g gVar = g.this;
            gVar.X0 = i2;
            gVar.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    private ListPreference s2() {
        return (ListPreference) l2();
    }

    public static g t2(String str) {
        g gVar = new g();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        gVar.G1(bundle);
        return gVar;
    }

    @Override // androidx.preference.l, androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void R0(Bundle bundle) {
        super.R0(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.X0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.Y0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.Z0);
    }

    @Override // androidx.preference.l
    public void p2(boolean z) {
        int i2;
        ListPreference listPreferenceS2 = s2();
        if (!z || (i2 = this.X0) < 0) {
            return;
        }
        String string = this.Z0[i2].toString();
        if (listPreferenceS2.b(string)) {
            listPreferenceS2.K0(string);
        }
    }

    @Override // androidx.preference.l
    protected void q2(p.a aVar) {
        super.q2(aVar);
        aVar.l(this.Y0, this.X0, new a());
        aVar.j(null, null);
    }

    @Override // androidx.preference.l, androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
        if (bundle != null) {
            this.X0 = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.Y0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.Z0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreferenceS2 = s2();
        if (listPreferenceS2.F0() == null || listPreferenceS2.H0() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.X0 = listPreferenceS2.E0(listPreferenceS2.I0());
        this.Y0 = listPreferenceS2.F0();
        this.Z0 = listPreferenceS2.H0();
    }
}
