package com.jsj.autojs.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.yl.ui.s;
import com.yl.ui.v;
import i.h.f;

/* loaded from: classes.dex */
public class A4e5efa332d extends com.yl.ui.p implements View.OnClickListener {

    class a implements f.b<String> {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(String str, DialogInterface dialogInterface, int i2) {
            A4e5efa332d.this.m0(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(DialogInterface dialogInterface, int i2) {
            A4e5efa332d.this.finish();
        }

        @Override // i.h.f.b
        public void a(int i2, String str) {
            A4e5efa332d.this.S();
            try {
                s.a aVar = new s.a(A4e5efa332d.this);
                aVar.j("提交失败！是不是网络问题，检查一下？");
                final String str2 = this.a;
                aVar.r("重试", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.c1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.c.d(str2, dialogInterface, i3);
                    }
                });
                aVar.m("跳过", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.b1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.c.f(dialogInterface, i3);
                    }
                });
                aVar.e().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // i.h.f.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            A4e5efa332d.this.S();
            A4e5efa332d.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean l0(Dialog dialog, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        m0(str);
        return true;
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492916;
    }

    @Override // com.yl.ui.p
    public void b0() {
        findViewById(2131297027).setOnClickListener(this);
        findViewById(2131297030).setOnClickListener(this);
        findViewById(2131297029).setOnClickListener(this);
        findViewById(2131297028).setOnClickListener(this);
        findViewById(2131297026).setOnClickListener(this);
        findViewById(2131297031).setOnClickListener(this);
        findViewById(2131297032).setOnClickListener(this);
        findViewById(2131297025).setOnClickListener(this);
    }

    public void m0(String str) {
        U();
        f.a aVar = new f.a();
        aVar.f("/submitSeeWhere");
        aVar.e("seeWhere", str);
        aVar.a().l(String.class, new a(str));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131297025:
                m0("B站");
                break;
            case 2131297026:
                m0("抖音");
                break;
            case 2131297027:
                m0("好友种草");
                break;
            case 2131297028:
                m0("快手");
                break;
            case 2131297029:
                m0("应用商城");
                break;
            case 2131297030:
                try {
                    v.a aVar = new v.a(this);
                    aVar.n("哪里得知「禅定空间」的？");
                    aVar.g(new v.b() { // from class: com.jsj.autojs.activity.d1
                        @Override // com.yl.ui.v.b
                        public final boolean a(Dialog dialog, String str) {
                            return this.a.l0(dialog, str);
                        }
                    });
                    aVar.d().show();
                    break;
                } catch (Exception unused) {
                    finish();
                    return;
                }
            case 2131297031:
                m0("小红书");
                break;
            case 2131297032:
                m0("知乎");
                break;
        }
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
