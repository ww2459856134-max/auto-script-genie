package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    private final AdapterView.OnItemSelectedListener A0;
    private final Context x0;
    private final ArrayAdapter y0;
    private Spinner z0;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (i2 >= 0) {
                String string = DropDownPreference.this.H0()[i2].toString();
                if (string.equals(DropDownPreference.this.I0()) || !DropDownPreference.this.b(string)) {
                    return;
                }
                DropDownPreference.this.K0(string);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, y.c);
    }

    private void N0() {
        this.y0.clear();
        if (F0() != null) {
            for (CharSequence charSequence : F0()) {
                this.y0.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    protected void H() {
        super.H();
        this.y0.notifyDataSetChanged();
    }

    protected ArrayAdapter L0() {
        return new ArrayAdapter(this.x0, R.layout.simple_spinner_dropdown_item);
    }

    public int M0(String str) {
        CharSequence[] charSequenceArrH0 = H0();
        if (str == null || charSequenceArrH0 == null) {
            return -1;
        }
        for (int length = charSequenceArrH0.length - 1; length >= 0; length--) {
            if (charSequenceArrH0[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    @Override // androidx.preference.Preference
    public void N(x xVar) {
        Spinner spinner = (Spinner) xVar.itemView.findViewById(a0.e);
        this.z0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.y0);
        this.z0.setOnItemSelectedListener(this.A0);
        this.z0.setSelection(M0(I0()));
        super.N(xVar);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void O() {
        this.z0.performClick();
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.A0 = new a();
        this.x0 = context;
        this.y0 = L0();
        N0();
    }
}
