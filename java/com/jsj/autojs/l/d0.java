package com.jsj.autojs.l;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.frame.v0;
import com.jsj.autojs.activity.Aec5865a7cc;
import com.yl.ui.i0;

/* loaded from: classes.dex */
class d0 extends i.h.g<String> {
    final /* synthetic */ e0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    d0(e0 e0Var, Activity activity) {
        super(activity);
        this.b = e0Var;
    }

    @Override // i.h.g, i.h.f.b
    public void a(int i2, String str) {
        this.b.b.b(str);
    }

    @Override // i.h.f.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(String str) {
        Toast.makeText(this.b.a, "绑定成功", 0).show();
        i0.j();
        if (v0.g().d() instanceof Aec5865a7cc) {
            this.b.b.a();
        } else {
            this.b.a.startActivity(new Intent(this.b.a, (Class<?>) Aec5865a7cc.class));
        }
    }
}
