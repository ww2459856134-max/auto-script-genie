package com.jsj.autojs.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.cursor.R;
import com.user.AccountTool;
import com.yl.ui.s;
import i.h.f;

/* loaded from: classes.dex */
public class InputInviteAct934934 extends com.yl.ui.p implements View.OnClickListener {
    private TextView P;
    private EditText Q;

    class a extends i.h.g<String> {
        a(Activity activity) {
            super(activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e(DialogInterface dialogInterface, int i2) {
            InputInviteAct934934.this.finish();
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            InputInviteAct934934.this.S();
            InputInviteAct934934.this.P.setClickable(true);
            InputInviteAct934934.this.Y(str);
        }

        @Override // i.h.f.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            InputInviteAct934934.this.S();
            InputInviteAct934934.this.P.setEnabled(true);
            AccountTool.d().y(null, null);
            try {
                s.a aVar = new s.a(InputInviteAct934934.this);
                aVar.t("温馨提示");
                aVar.j("已绑定邀请码，免费获得vip体验，请重新登录账号查看。");
                aVar.r("知道了", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.d8
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.c.e(dialogInterface, i2);
                    }
                });
                aVar.e().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m0(View view) {
        finish();
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492902;
    }

    @Override // com.yl.ui.p
    public void b0() {
        ((TextView) findViewById(2131297159)).setText(Html.fromHtml("填写邀请码获得<strong><font color='#F45075'>VIP</font></strong>体验名额"));
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.e8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.m0(view);
            }
        });
        com.frame.i0.k(this, false);
        this.Q = (EditText) findViewById(2131296594);
        TextView textView = (TextView) findViewById(2131297249);
        this.P = textView;
        textView.setOnClickListener(this);
        i.a.k kVar = new i.a.k();
        kVar.c("privacy", findViewById(2131297315), null, null, this, com.jsj.autojs.l.c0.e().f());
        kVar.c("user_privacy", findViewById(2131297314), null, null, this, "https://h5.skyingidea.com/useragree/autojs.html");
        TextView textView2 = (TextView) findViewById(2131297144);
        TextView textView3 = (TextView) findViewById(2131297145);
        textView2.setText(Html.fromHtml("输入普通用户发给您的邀请码可获得<strong><font color='#F45075'>7天</font></strong>会员体验"));
        textView3.setText(Html.fromHtml("输入终身会员发给您的邀请码可获得<strong><font color='#F45075'>15天</font></strong>会员体验"));
        findViewById(2131297244).setOnClickListener(this);
    }

    public void n0() {
        String string = this.Q.getText().toString();
        if (TextUtils.isEmpty(string)) {
            Y("请输入邀请码");
            this.Q.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), 2130772016));
            return;
        }
        try {
            com.frame.n1.b(string);
            try {
                f.a aVar = new f.a();
                aVar.f("/bindChannel");
                aVar.e("id", string);
                aVar.g(true);
                aVar.a().l(String.class, new a(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception unused) {
            Y("请输入正确的邀请码");
            this.Q.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), 2130772016));
        }
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297244) {
            finish();
        } else {
            if (id != 2131297249) {
                return;
            }
            n0();
        }
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        com.user.w.h().H();
        super.onDestroy();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        S();
        this.P.setClickable(true);
    }
}
