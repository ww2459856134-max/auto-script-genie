package com.jsj.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.frame.k0;
import com.frame.n0;
import com.frame.v0;
import com.jsj.autojs.activity.A047634d3a4;
import com.jsj.autojs.activity.Ad1cbbb5a22;
import com.jsj.autojs.l.c0;
import com.jsj.autojs.l.w;
import com.user.AccountTool;
import com.user.model.WechatModel;
import com.yl.ui.s;

/* loaded from: classes.dex */
public class UserTop extends RelativeLayout implements View.OnClickListener {
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f801h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f802i;

    public UserTop(Context context) {
        super(context);
    }

    public void a() {
        findViewById(2131296522).setVisibility(8);
        findViewById(2131296482).setVisibility(8);
    }

    public void b() {
        View viewInflate = View.inflate(v0.g(), 2131493103, this);
        TextView textView = (TextView) viewInflate.findViewById(2131296506);
        this.f = textView;
        textView.setOnClickListener(this);
        this.c = (TextView) viewInflate.findViewById(2131297255);
        this.d = (TextView) viewInflate.findViewById(2131297294);
        this.g = (TextView) viewInflate.findViewById(2131297281);
        this.e = (TextView) viewInflate.findViewById(2131297271);
        this.f801h = (ImageView) viewInflate.findViewById(2131296850);
        ImageView imageView = (ImageView) viewInflate.findViewById(2131296823);
        this.f802i = imageView;
        imageView.setOnClickListener(this);
        this.c.setOnClickListener(this);
        findViewById(2131296522).setOnClickListener(this);
        findViewById(2131296482).setOnClickListener(this);
    }

    public void d() {
        String str;
        WechatModel wechatModelC = AccountTool.d().c();
        this.g.setVisibility(AccountTool.d().j() && wechatModelC != null && wechatModelC.getPid() != null && !wechatModelC.getPid().equals(wechatModelC.getId()) ? 0 : 8);
        try {
            WechatModel wechatModelC2 = AccountTool.d().c();
            if (!AccountTool.d().j()) {
                this.d.setText("登录后可管理账号、会员和云端脚本");
                this.f801h.setVisibility(8);
            } else if (wechatModelC2 == null) {
                this.d.setText("正在同步账号信息");
                this.f801h.setVisibility(8);
            } else if (AccountTool.d().l()) {
                this.d.setText("终身会员");
                this.f801h.setVisibility(0);
                w.b(this.f801h, "vip_super.webp");
            } else if (AccountTool.d().m()) {
                String vipEndTime = wechatModelC2.getVipEndTime();
                this.d.setText("会员有效期至 " + vipEndTime.split(" ")[0]);
                this.f801h.setVisibility(0);
                w.b(this.f801h, "vip_normal.png");
            } else if (!AccountTool.d().m() && !TextUtils.isEmpty(wechatModelC2.getVipEndTime())) {
                this.d.setText("会员已过期");
                this.f801h.setVisibility(8);
            } else if (AccountTool.d().m()) {
                this.d.setText("登录后可管理账号、会员和云端脚本");
                this.c.setText("登录账号");
                this.f801h.setVisibility(0);
                w.b(this.f801h, "vip_normal.png");
            } else {
                this.d.setText("暂未开通会员");
                this.c.setText(wechatModelC2.getName());
                this.f801h.setVisibility(8);
            }
        } catch (Exception e) {
            e.printStackTrace();
            k0.r(e);
        }
        try {
            WechatModel wechatModelC3 = AccountTool.d().c();
            if (!AccountTool.d().j() || wechatModelC3 == null) {
                this.c.setText(AccountTool.d().j() ? "正在同步账号" : "登录账号");
                com.bumptech.glide.c.t(v0.g()).v(2131230906).q0(this.f802i);
            } else {
                if (!TextUtils.isEmpty(wechatModelC3.getHeadimgurl())) {
                    com.bumptech.glide.c.t(v0.g()).w(wechatModelC3.getHeadimgurl()).q0(this.f802i);
                }
                this.c.setText(wechatModelC3.getName());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            k0.r(e2);
        }
        if (!AccountTool.d().j()) {
            this.e.setVisibility(8);
            return;
        }
        int iB = n0.b("unReadCount");
        if (iB <= 0) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        TextView textView = this.e;
        if (iB > 99) {
            str = "99";
        } else {
            str = iB + "";
        }
        textView.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131296506) {
            if (id == 2131296823 || id == 2131297255) {
                if (AccountTool.d().j()) {
                    v0.g().startActivity(new Intent(v0.g(), (Class<?>) Ad1cbbb5a22.class));
                    return;
                } else {
                    v0.g().startActivity(new Intent(v0.g(), (Class<?>) A047634d3a4.class));
                    return;
                }
            }
            return;
        }
        try {
            s.a aVar = new s.a(v0.g().d());
            aVar.r("联系客服", new DialogInterface.OnClickListener() { // from class: com.jsj.widget.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    c0.e().g();
                }
            });
            aVar.m("关闭", null);
            aVar.f();
            aVar.j("会员未生效时，请先确认当前账号与购买时一致，然后重新登录。仍未恢复，可准备付款凭证和用户ID联系客服查询。");
            aVar.t("会员与支付帮助");
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    public void setRightButton(String str, View.OnClickListener onClickListener) {
        this.f.setText(str);
        this.f.setOnClickListener(onClickListener);
    }

    public UserTop(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UserTop(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
