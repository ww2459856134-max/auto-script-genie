package com.jsj.autojs.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.act.WebAct;
import com.jsj.autojs.privacy.Ac14cd2721f;
import com.tencent.open.SocialConstants;
import com.yl.ui.s;

/* loaded from: classes.dex */
public class A91391ecb39 extends com.yl.ui.p implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l0(DialogInterface dialogInterface, int i2) throws Throwable {
        com.frame.v0.g().v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0(View view) {
        s.a aVar = new s.a(this);
        aVar.t("撤回隐私政策同意");
        aVar.j("撤回后APP将重启并重新进入隐私政策选择页面，停止基于本次同意进行后续个人信息处理。撤回不会自动注销账号、删除历史数据或关闭系统权限。");
        aVar.r("确认撤回", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.m3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) throws Throwable {
                this.c.l0(dialogInterface, i2);
            }
        });
        aVar.m("取消", null);
        aVar.e().show();
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492923;
    }

    @Override // com.yl.ui.p
    public void b0() {
        findViewById(2131297149).setOnClickListener(this);
        findViewById(2131297277).setOnClickListener(this);
        findViewById(2131297260).setOnClickListener(this);
        findViewById(2131297213).setVisibility(8);
        ((TextView) findViewById(2131297213)).setOnClickListener(this);
        ((TextView) findViewById(2131297295)).setText("Version " + com.frame.p0.h().j() + "  (" + com.frame.p0.h().k() + ")");
        String strF = com.jsj.autojs.l.c0.e().f();
        i.a.k kVar = new i.a.k();
        kVar.c("privacy", findViewById(2131297265), null, (TextView) findViewById(2131297265), this, strF);
        kVar.c("user_privacy", findViewById(2131297293), null, (TextView) findViewById(2131297293), this, "https://h5.skyingidea.com/useragree/autojs.html");
        findViewById(2131297313).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.k3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.n0(view);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131297149:
                Intent intent = new Intent(this, (Class<?>) WebAct.class);
                intent.putExtra(SocialConstants.PARAM_URL, "https://beian.miit.gov.cn");
                intent.putExtra("title", "备案");
                startActivity(intent);
                break;
            case 2131297213:
                s.a aVar = new s.a(com.frame.v0.g().d());
                aVar.r("确定", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.l3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        com.frame.v0.g().startActivity(new Intent(com.frame.v0.g(), (Class<?>) Aa60c95fc3c.class));
                    }
                });
                aVar.m("取消", null);
                aVar.s(2131558430);
                aVar.g(2131231019);
                aVar.j("您还不是我们的渠道合作商，可以加群，私聊技术小哥或发邮件申请渠道合作【chenai@skyingidea.com】");
                aVar.e().show();
                break;
            case 2131297260:
                startActivity(new Intent(this, (Class<?>) Ac14cd2721f.class));
                break;
            case 2131297277:
                Intent intent2 = new Intent(this, (Class<?>) WebAct.class);
                intent2.putExtra(SocialConstants.PARAM_URL, "https://h5.skyingidea.com/privacy/third-sdk-noali.html");
                intent2.putExtra("title", "第三方共享个人信息清单");
                startActivity(intent2);
                break;
        }
    }
}
