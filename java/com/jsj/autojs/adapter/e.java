package com.jsj.autojs.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.frame.k0;
import com.frame.v0;
import com.jsj.autojs.activity.A1393b5d52c;
import com.jsj.autojs.l.c0;

/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ f c;

    e(f fVar) {
        this.c = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.c.e) {
            c0.e().z(v0.g().d());
            return;
        }
        try {
            A1393b5d52c a1393b5d52c = (A1393b5d52c) v0.g().d();
            a1393b5d52c.l();
            ViewGroup viewGroup = (ViewGroup) a1393b5d52c.findViewById(2131296946);
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            k0.i("guid_click_start");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
