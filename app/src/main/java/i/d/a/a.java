package i.d.a;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.s;

/* loaded from: classes.dex */
public class a extends s {
    @Override // androidx.fragment.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a2().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        a2().requestWindowFeature(1);
        a2().setCancelable(false);
        h2(false);
        return layoutInflater.inflate(2131493169, viewGroup);
    }
}
