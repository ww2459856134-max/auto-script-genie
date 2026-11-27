package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    int m0;
    int n0;
    private int o0;
    private int p0;
    boolean q0;
    SeekBar r0;
    private TextView s0;
    boolean t0;
    private boolean u0;
    private SeekBar.OnSeekBarChangeListener v0;
    private View.OnKeyListener w0;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.q0) {
                    return;
                }
                seekBarPreference.C0(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.q0 = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.q0 = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.n0 != seekBarPreference.m0) {
                seekBarPreference.C0(seekBar);
            }
        }
    }

    class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.t0 && (i2 == 21 || i2 == 22)) || i2 == 23 || i2 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.r0;
            if (seekBar != null) {
                return seekBar.onKeyDown(i2, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.v0 = new a();
        this.w0 = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.B0, i2, i3);
        this.n0 = typedArrayObtainStyledAttributes.getInt(e0.E0, 0);
        y0(typedArrayObtainStyledAttributes.getInt(e0.C0, 100));
        z0(typedArrayObtainStyledAttributes.getInt(e0.F0, 0));
        this.t0 = typedArrayObtainStyledAttributes.getBoolean(e0.D0, true);
        this.u0 = typedArrayObtainStyledAttributes.getBoolean(e0.G0, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void B0(int i2, boolean z) {
        int i3 = this.n0;
        if (i2 < i3) {
            i2 = i3;
        }
        int i4 = this.o0;
        if (i2 > i4) {
            i2 = i4;
        }
        if (i2 != this.m0) {
            this.m0 = i2;
            TextView textView = this.s0;
            if (textView != null) {
                textView.setText(String.valueOf(i2));
            }
            b0(i2);
            if (z) {
                H();
            }
        }
    }

    public void A0(int i2) {
        B0(i2, true);
    }

    void C0(SeekBar seekBar) {
        int progress = this.n0 + seekBar.getProgress();
        if (progress != this.m0) {
            if (b(Integer.valueOf(progress))) {
                B0(progress, false);
            } else {
                seekBar.setProgress(this.m0 - this.n0);
            }
        }
    }

    @Override // androidx.preference.Preference
    public void N(x xVar) {
        super.N(xVar);
        xVar.itemView.setOnKeyListener(this.w0);
        this.r0 = (SeekBar) xVar.b(a0.c);
        TextView textView = (TextView) xVar.b(a0.d);
        this.s0 = textView;
        if (this.u0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.s0 = null;
        }
        SeekBar seekBar = this.r0;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.v0);
        this.r0.setMax(this.o0 - this.n0);
        int i2 = this.p0;
        if (i2 != 0) {
            this.r0.setKeyProgressIncrement(i2);
        } else {
            this.p0 = this.r0.getKeyProgressIncrement();
        }
        this.r0.setProgress(this.m0 - this.n0);
        TextView textView2 = this.s0;
        if (textView2 != null) {
            textView2.setText(String.valueOf(this.m0));
        }
        this.r0.setEnabled(D());
    }

    @Override // androidx.preference.Preference
    protected Object R(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInt(i2, 0));
    }

    @Override // androidx.preference.Preference
    protected void U(Parcelable parcelable) {
        if (!parcelable.getClass().equals(c.class)) {
            super.U(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.U(cVar.getSuperState());
        this.m0 = cVar.c;
        this.n0 = cVar.d;
        this.o0 = cVar.e;
        H();
    }

    @Override // androidx.preference.Preference
    protected Parcelable V() {
        Parcelable parcelableV = super.V();
        if (E()) {
            return parcelableV;
        }
        c cVar = new c(parcelableV);
        cVar.c = this.m0;
        cVar.d = this.n0;
        cVar.e = this.o0;
        return cVar;
    }

    @Override // androidx.preference.Preference
    protected void W(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        A0(t(((Integer) obj).intValue()));
    }

    public final void y0(int i2) {
        int i3 = this.n0;
        if (i2 < i3) {
            i2 = i3;
        }
        if (i2 != this.o0) {
            this.o0 = i2;
            H();
        }
    }

    public final void z0(int i2) {
        if (i2 != this.p0) {
            this.p0 = Math.min(this.o0 - this.n0, Math.abs(i2));
            H();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c extends Preference.b {
        public static final Parcelable.Creator<c> CREATOR = new f0();
        int c;
        int d;
        int e;

        public c(Parcel parcel) {
            super(parcel);
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, y.f313j);
    }
}
