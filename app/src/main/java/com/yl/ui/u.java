package com.yl.ui;

import android.view.View;
import android.widget.EditText;
import com.yl.ui.v;

/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ v c;
    final /* synthetic */ EditText d;
    final /* synthetic */ v.a e;

    u(v.a aVar, v vVar, EditText editText) {
        this.e = aVar;
        this.c = vVar;
        this.d = editText;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == v.c) {
            if (this.e.g != null) {
                this.e.g.a(this.c, this.d.getText().toString());
            }
        } else if (id != v.d && id == a0.f1131i) {
            this.c.cancel();
        }
        if (this.e.f1159m) {
            this.c.cancel();
        }
    }
}
