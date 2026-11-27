package com.yl.ui;

import android.view.View;
import com.frame.k0;
import com.yl.ui.s;

/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ s c;
    final /* synthetic */ s.a d;

    r(s.a aVar, s sVar) {
        this.d = aVar;
        this.c = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == s.e) {
            try {
                if (this.d.f1151m != null) {
                    this.d.f1151m.onClick(this.c, id);
                }
                this.c.cancel();
                return;
            } catch (Exception e) {
                k0.r(e);
                return;
            }
        }
        if (id == s.f || id == a0.E) {
            if (this.d.f1152n != null) {
                this.d.f1152n.onClick(this.c, id);
            }
            this.c.cancel();
        } else {
            if (s.g == id) {
                this.c.cancel();
                if (this.d.p != null) {
                    this.d.p.onClick(this.c, id);
                    return;
                }
                return;
            }
            if (a0.B != id || this.d.f1153o == null) {
                return;
            }
            this.d.f1153o.onClick(this.c, id);
        }
    }
}
