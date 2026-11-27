package com.jsj.autojs.i;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* loaded from: classes.dex */
public final class y extends androidx.fragment.app.s {
    private boolean P0;

    public interface a {
        void g(int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m2(View view) {
        t2(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o2(View view) {
        t2(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q2(View view) {
        t2(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s2(View view) {
        X1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t2(int i2) {
        if (this.P0) {
            return;
        }
        this.P0 = true;
        Fragment fragmentK = K();
        X1();
        if ((fragmentK instanceof a) && fragmentK.d0()) {
            ((a) fragmentK).g(i2);
        }
    }

    @Override // androidx.fragment.app.s, androidx.fragment.app.Fragment
    public void S0() {
        super.S0();
        Window window = g2().getWindow();
        if (window == null) {
            return;
        }
        float f = R().getDisplayMetrics().density;
        int iMax = Math.max(1, Math.min((int) (400.0f * f), R().getDisplayMetrics().widthPixels - ((int) (32.0f * f))));
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.addFlags(2);
        window.setDimAmount(0.4f);
        window.setLayout(iMax, -2);
        View viewFindViewById = window.findViewById(2131296992);
        viewFindViewById.measure(View.MeasureSpec.makeMeasureSpec(iMax, WXVideoFileObject.FILE_SIZE_LIMIT), View.MeasureSpec.makeMeasureSpec(0, 0));
        int iMax2 = Math.max(1, R().getDisplayMetrics().heightPixels - ((int) (f * 96.0f)));
        if (viewFindViewById.getMeasuredHeight() > iMax2) {
            window.setLayout(iMax, iMax2);
        }
    }

    @Override // androidx.fragment.app.s
    public Dialog c2(Bundle bundle) {
        Dialog dialog = new Dialog(y1());
        dialog.requestWindowFeature(1);
        View viewInflate = View.inflate(y1(), 2131493001, null);
        viewInflate.findViewById(2131296989).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.i.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.m2(view);
            }
        });
        viewInflate.findViewById(2131296988).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.i.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.o2(view);
            }
        });
        viewInflate.findViewById(2131296991).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.i.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.q2(view);
            }
        });
        viewInflate.findViewById(2131296990).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.i.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.s2(view);
            }
        });
        dialog.setContentView(viewInflate);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }
}
