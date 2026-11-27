package androidx.preference;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.p;
import androidx.fragment.app.h0;
import androidx.preference.DialogPreference;

/* loaded from: classes.dex */
public abstract class l extends androidx.fragment.app.s implements DialogInterface.OnClickListener {
    private DialogPreference P0;
    private CharSequence Q0;
    private CharSequence R0;
    private CharSequence S0;
    private CharSequence T0;
    private int U0;
    private BitmapDrawable V0;
    private int W0;

    private void r2(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    @Override // androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void R0(Bundle bundle) {
        super.R0(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.Q0);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.R0);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.S0);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.T0);
        bundle.putInt("PreferenceDialogFragment.layout", this.U0);
        BitmapDrawable bitmapDrawable = this.V0;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    @Override // androidx.fragment.app.s
    public Dialog c2(Bundle bundle) {
        h0 h0VarQ = q();
        this.W0 = -2;
        p.a aVar = new p.a(h0VarQ);
        aVar.m(this.Q0);
        aVar.e(this.V0);
        aVar.j(this.R0, this);
        aVar.h(this.S0, this);
        View viewO2 = o2(h0VarQ);
        if (viewO2 != null) {
            n2(viewO2);
            aVar.n(viewO2);
        } else {
            aVar.f(this.T0);
        }
        q2(aVar);
        androidx.appcompat.app.p pVarA = aVar.a();
        if (m2()) {
            r2(pVarA);
        }
        return pVarA;
    }

    public DialogPreference l2() {
        if (this.P0 == null) {
            this.P0 = (DialogPreference) ((DialogPreference.a) X()).a(v().getString("key"));
        }
        return this.P0;
    }

    protected boolean m2() {
        return false;
    }

    protected void n2(View view) {
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.T0;
            int i2 = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i2 = 0;
            }
            if (viewFindViewById.getVisibility() != i2) {
                viewFindViewById.setVisibility(i2);
            }
        }
    }

    protected View o2(Context context) {
        int i2 = this.U0;
        if (i2 == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(i2, (ViewGroup) null);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.W0 = i2;
    }

    @Override // androidx.fragment.app.s, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        p2(this.W0 == -1);
    }

    public abstract void p2(boolean z);

    protected void q2(p.a aVar) {
    }

    @Override // androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
        androidx.lifecycle.w wVarX = X();
        if (!(wVarX instanceof DialogPreference.a)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.a aVar = (DialogPreference.a) wVarX;
        String string = v().getString("key");
        if (bundle != null) {
            this.Q0 = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.R0 = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.S0 = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.T0 = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.U0 = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.V0 = new BitmapDrawable(R(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) aVar.a(string);
        this.P0 = dialogPreference;
        this.Q0 = dialogPreference.B0();
        this.R0 = this.P0.D0();
        this.S0 = this.P0.C0();
        this.T0 = this.P0.A0();
        this.U0 = this.P0.z0();
        Drawable drawableY0 = this.P0.y0();
        if (drawableY0 == null || (drawableY0 instanceof BitmapDrawable)) {
            this.V0 = (BitmapDrawable) drawableY0;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableY0.getIntrinsicWidth(), drawableY0.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableY0.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableY0.draw(canvas);
        this.V0 = new BitmapDrawable(R(), bitmapCreateBitmap);
    }
}
