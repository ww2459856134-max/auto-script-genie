package com.yl.ui;

import android.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.fragment.app.p1;
import com.frame.k0;
import com.tencent.open.SocialConstants;

/* loaded from: classes.dex */
public class q extends androidx.fragment.app.s {
    private View P0;
    private Window Q0;
    int R0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m2(View view) {
        X1();
    }

    @Override // androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void S0() {
        super.S0();
        try {
            ImageView imageView = (ImageView) this.P0.findViewById(a0.f1137o);
            com.bumptech.glide.c.u(imageView).w(v().getString(SocialConstants.PARAM_URL)).q0(imageView);
        } catch (Exception e) {
            k0.r(e);
        }
        this.P0.findViewById(a0.A).setOnClickListener(new View.OnClickListener() { // from class: com.yl.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.m2(view);
            }
        });
        Window window = a2().getWindow();
        this.Q0 = window;
        window.setBackgroundDrawableResource(R.color.transparent);
        this.Q0.setWindowAnimations(d0.c);
        WindowManager.LayoutParams attributes = this.Q0.getAttributes();
        attributes.gravity = 80;
        attributes.width = R().getDisplayMetrics().widthPixels;
        this.Q0.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.s
    public void j2(p1 p1Var, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(SocialConstants.PARAM_URL, str);
        G1(bundle);
        try {
            super.j2(p1Var, str);
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public void n2(int i2) {
        this.R0 = i2;
    }

    @Override // androidx.fragment.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a2().requestWindowFeature(1);
        View viewInflate = layoutInflater.inflate(b0.b, (ViewGroup) null);
        this.P0 = viewInflate;
        int i2 = this.R0;
        if (i2 != 0) {
            viewInflate.setBackgroundResource(i2);
        }
        return this.P0;
    }
}
