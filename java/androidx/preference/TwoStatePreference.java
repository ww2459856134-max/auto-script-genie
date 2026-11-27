package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    private CharSequence m0;
    private CharSequence n0;
    protected boolean o0;
    private boolean p0;
    private boolean q0;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void A0(boolean z) {
        this.q0 = z;
    }

    public void B0(CharSequence charSequence) {
        this.n0 = charSequence;
        if (y0()) {
            return;
        }
        H();
    }

    public void C0(CharSequence charSequence) {
        this.m0 = charSequence;
        if (y0()) {
            H();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void D0(View view) {
        int i2;
        if (!(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        boolean z = true;
        if (!this.o0 || TextUtils.isEmpty(this.m0)) {
            if (!this.o0 && !TextUtils.isEmpty(this.n0)) {
                textView.setText(this.n0);
            }
            if (z) {
                CharSequence charSequenceZ = z();
                if (!TextUtils.isEmpty(charSequenceZ)) {
                    textView.setText(charSequenceZ);
                    z = false;
                }
            }
            i2 = z ? 8 : 0;
            if (i2 == textView.getVisibility()) {
                textView.setVisibility(i2);
                return;
            }
            return;
        }
        textView.setText(this.m0);
        z = false;
        if (z) {
        }
        if (z) {
        }
        if (i2 == textView.getVisibility()) {
        }
    }

    protected void E0(x xVar) {
        D0(xVar.b(R.id.summary));
    }

    @Override // androidx.preference.Preference
    protected void O() {
        super.O();
        boolean z = !y0();
        if (b(Boolean.valueOf(z))) {
            z0(z);
        }
    }

    @Override // androidx.preference.Preference
    protected Object R(TypedArray typedArray, int i2) {
        return Boolean.valueOf(typedArray.getBoolean(i2, false));
    }

    @Override // androidx.preference.Preference
    protected void U(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.U(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.U(aVar.getSuperState());
        z0(aVar.c);
    }

    @Override // androidx.preference.Preference
    protected Parcelable V() {
        Parcelable parcelableV = super.V();
        if (E()) {
            return parcelableV;
        }
        a aVar = new a(parcelableV);
        aVar.c = y0();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void W(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        z0(s(((Boolean) obj).booleanValue()));
    }

    @Override // androidx.preference.Preference
    public boolean t0() {
        return (this.q0 ? this.o0 : !this.o0) || super.t0();
    }

    public boolean y0() {
        return this.o0;
    }

    public void z0(boolean z) {
        boolean z2 = this.o0 != z;
        if (z2 || !this.p0) {
            this.o0 = z;
            this.p0 = true;
            a0(z);
            if (z2) {
                I(t0());
                H();
            }
        }
    }

    static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new g0();
        boolean c;

        public a(Parcel parcel) {
            super(parcel);
            this.c = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.c ? 1 : 0);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
