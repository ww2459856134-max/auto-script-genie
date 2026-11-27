package com.jsj.autojs.l;

import android.content.Intent;
import android.widget.Toast;
import com.act.WebAct;
import com.frame.v0;
import com.tencent.open.SocialConstants;
import i.h.f;

/* loaded from: classes.dex */
class b0 implements f.b<String> {
    b0(c0 c0Var) {
    }

    @Override // i.h.f.b
    public void a(int i2, String str) {
        Toast.makeText(v0.g(), str, 0).show();
    }

    @Override // i.h.f.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(String str) {
        Intent intent = new Intent(v0.g().d(), (Class<?>) WebAct.class);
        intent.addFlags(268435456);
        intent.putExtra(SocialConstants.PARAM_URL, str);
        intent.putExtra("title", "客服");
        v0.g().startActivity(intent);
        Toast.makeText(v0.g(), "可发邮件至chenai@skyingidea.com", 0).show();
    }
}
