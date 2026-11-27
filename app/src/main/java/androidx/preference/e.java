package androidx.preference;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/* loaded from: classes.dex */
public class e extends l {
    private EditText X0;
    private CharSequence Y0;

    private EditTextPreference s2() {
        return (EditTextPreference) l2();
    }

    public static e t2(String str) {
        e eVar = new e();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        eVar.G1(bundle);
        return eVar;
    }

    @Override // androidx.preference.l, androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void R0(Bundle bundle) {
        super.R0(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.Y0);
    }

    @Override // androidx.preference.l
    protected boolean m2() {
        return true;
    }

    @Override // androidx.preference.l
    protected void n2(View view) {
        super.n2(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.X0 = editText;
        editText.requestFocus();
        EditText editText2 = this.X0;
        if (editText2 == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText2.setText(this.Y0);
        EditText editText3 = this.X0;
        editText3.setSelection(editText3.getText().length());
    }

    @Override // androidx.preference.l
    public void p2(boolean z) {
        if (z) {
            String string = this.X0.getText().toString();
            if (s2().b(string)) {
                s2().F0(string);
            }
        }
    }

    @Override // androidx.preference.l, androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
        if (bundle == null) {
            this.Y0 = s2().E0();
        } else {
            this.Y0 = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }
}
