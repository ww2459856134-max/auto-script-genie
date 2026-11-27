package com.jsj.autojs.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.act.WebAct;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.jsj.autojs.adapter.VipAdapter;
import com.jsj.autojs.model.Coupon;
import com.jsj.autojs.model.VipItemModel;
import com.jsj.widget.UserTop;
import com.tencent.cursor.R;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.user.model.PayModel;
import com.yl.ui.f0;
import com.yl.ui.s;
import com.yl.ui.v;
import i.h.f;

/* loaded from: classes.dex */
public class Abd192a7cca extends com.yl.ui.p implements View.OnClickListener, BaseQuickAdapter.OnItemClickListener {
    private boolean Q;
    private boolean U;
    private String V;
    private Coupon a0;
    private RecyclerView b0;
    private VipAdapter c0;
    UserTop d0;
    private boolean P = false;
    private int W = 0;
    private Long Z = 0L;

    class a extends i.h.g<Coupon> {
        a(Activity activity) {
            super(activity);
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            Toast.makeText(com.frame.v0.g(), str, 0).show();
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(Coupon coupon) {
            Abd192a7cca.this.a0 = coupon;
            if (Abd192a7cca.this.c0 != null) {
                Abd192a7cca.this.c0.e(coupon);
                Abd192a7cca.this.c0.notifyDataSetChanged();
            }
        }
    }

    class b extends i.h.g<Coupon> {
        b(Activity activity) {
            super(activity);
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            Toast.makeText(Abd192a7cca.this.getApplicationContext(), str, 0).show();
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(Coupon coupon) {
            Abd192a7cca.this.a0 = coupon;
            if (Abd192a7cca.this.c0 != null) {
                Abd192a7cca.this.c0.e(Abd192a7cca.this.a0);
                Abd192a7cca.this.c0.notifyDataSetChanged();
            }
        }
    }

    class c implements v.b {
        c() {
        }

        @Override // com.yl.ui.v.b
        public boolean a(Dialog dialog, String str) {
            Abd192a7cca.this.w0(str);
            return true;
        }
    }

    class d extends i.h.g<VipItemModel> {
        d(Activity activity) {
            super(activity);
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(VipItemModel vipItemModel) {
            if (vipItemModel == null || vipItemModel.getContent() == null || vipItemModel.getContent().size() <= 0) {
                return;
            }
            Abd192a7cca.this.Z = vipItemModel.getContent().get(0).getId();
            Abd192a7cca.this.c0.setNewData(vipItemModel.getContent());
            Abd192a7cca.this.c0.f(0);
            Abd192a7cca.this.c0.notifyDataSetChanged();
        }
    }

    class e extends i.h.g<String> {
        e(Activity activity) {
            super(activity);
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            try {
                Abd192a7cca.this.Y(str);
                ((com.yl.ui.p) c()).S();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ("已开通成功，请重新登录".equals(str)) {
                Abd192a7cca.this.r0();
            }
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            try {
                com.frame.v0.f().edit().putLong("getCurrentUserInfo", 0L).apply();
                com.user.w.h().B((PayModel) new Gson().j(com.frame.n1.b(str), PayModel.class), new o8(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class f implements f0.b {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        f(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // com.yl.ui.f0.b
        public void a(Dialog dialog) {
            com.user.p.g().c(Abd192a7cca.this, this.a, this.b, this.c);
        }

        @Override // com.yl.ui.f0.b
        public void b(Dialog dialog) {
            com.user.p.g().a(Abd192a7cca.this, this.a, this.b, this.c);
        }

        @Override // com.yl.ui.f0.b
        public void c(Dialog dialog) {
            com.user.w.h().D(this.a, this.b, this.c);
        }

        @Override // com.yl.ui.f0.b
        public void d(Dialog dialog) {
            com.user.w.h().F(2131231011, this.a, this.b, this.c);
        }
    }

    class g implements f.b<String> {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d() {
            Abd192a7cca.this.r0();
        }

        @Override // i.h.f.b
        public void a(int i2, String str) {
            AccountTool.d().v();
            Abd192a7cca.this.r0();
        }

        @Override // i.h.f.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            AccountTool.d().x(str);
            if (AccountTool.d().m()) {
                Abd192a7cca.this.C0();
            } else if (Abd192a7cca.this.W == 3) {
                Abd192a7cca.this.r0();
            } else {
                com.frame.l1.f(new Runnable() { // from class: com.jsj.autojs.activity.g5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.d();
                    }
                }, 4000L);
            }
        }
    }

    public static void D0(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) Abd192a7cca.class);
        intent.putExtra("fromEvent", str);
        com.frame.v0.g().startActivity(intent);
    }

    private View t0() {
        View viewInflate = View.inflate(com.frame.v0.g(), 2131493105, null);
        i.a.k kVar = new i.a.k();
        kVar.c("vipAgree", viewInflate.findViewById(2131297315), null, null, this, "https://h5.skyingidea.com/autojs/vip.html");
        kVar.c("privacy", viewInflate.findViewById(2131297314), null, null, this, com.jsj.autojs.l.c0.e().f());
        viewInflate.findViewById(2131297206).setOnClickListener(this);
        viewInflate.findViewById(2131296536).setOnClickListener(this);
        viewInflate.findViewById(2131296442).setOnClickListener(this);
        viewInflate.findViewById(2131296493).setOnClickListener(this);
        ImageView imageView = (ImageView) viewInflate.findViewById(2131296838);
        new i.a.k().c("img_vip_info", imageView, imageView, null, this, null);
        return viewInflate;
    }

    private View v0() {
        UserTop userTop = new UserTop(com.frame.v0.g());
        this.d0 = userTop;
        userTop.b();
        this.d0.a();
        return this.d0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(String str) {
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(com.frame.v0.g(), "劵码不能为空", 0).show();
            return;
        }
        f.a aVar = new f.a();
        aVar.f("/getCoupons");
        aVar.e("couponCode", str);
        aVar.g(true);
        aVar.a().l(Coupon.class, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0(DialogInterface dialogInterface, int i2) {
        B0();
    }

    private void z0(String str, String str2) {
        f.a aVar = new f.a();
        aVar.f("/getCoupons");
        aVar.e("id", str);
        aVar.e("couponCode", str2);
        aVar.g(true);
        aVar.a().l(Coupon.class, new a(this));
    }

    public void A0() {
        f.a aVar = new f.a();
        aVar.f("/getVipConfig");
        aVar.g(true);
        aVar.a().l(VipItemModel.class, new d(this));
    }

    public void B0() {
        com.frame.k0.i("finish_to_share");
        String string = getString(R.string.app_name);
        f0.a aVar = new f0.a(this);
        aVar.c(new f(string, "我在[自动脚本精灵]APP等你解放双手，自动定时任务。", "https://sj.qq.com/appdetail/com.jsj.autojs"));
        aVar.a().show();
    }

    public void C0() {
        String str;
        try {
            S();
            if (AccountTool.d().l()) {
                str = "恭喜您！已成功购买<big><strong><font color='#F45075'>永久VIP会员</font></strong></big>套餐, 分享好友可获得更多功能。";
            } else if (!this.Q) {
                str = "您已成功购买<big><strong><font color='#F45075'>VIP会员</font></strong></big>,有效期将至" + AccountTool.d().c().getVipEndTime() + "，分享好友可获得更多功能。";
            } else {
                if (this.V.equals(AccountTool.d().c().getVipEndTime())) {
                    return;
                }
                str = "您已成功购买<big><strong><font color='#F45075'>VIP会员</font></strong></big>套餐,有效期将延长至" + AccountTool.d().c().getVipEndTime() + "，分享好友可获得更多功能。";
            }
            com.frame.k0.i("user_pay_" + this.Z);
            s.a aVar = new s.a(com.frame.v0.g().d());
            aVar.g(R.drawable.great_icon);
            aVar.m("知道了", null);
            aVar.r("分享", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.h5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.y0(dialogInterface, i2);
                }
            });
            aVar.j(str);
            aVar.t("购买通知");
            aVar.e().show();
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public void E0() {
        X(false);
        this.P = true;
        u0();
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492920;
    }

    @Override // com.yl.ui.p
    public void b0() {
        super.b0();
        this.b0 = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        this.b0.setLayoutManager(linearLayoutManager);
        linearLayoutManager.B2(1);
        VipAdapter vipAdapter = new VipAdapter(null);
        this.c0 = vipAdapter;
        vipAdapter.setEnableLoadMore(false);
        this.c0.setUpFetchEnable(true);
        this.c0.setOnItemClickListener(this);
        this.b0.setAdapter(this.c0);
        this.c0.setFooterView(t0());
        this.c0.setHeaderView(v0());
        try {
            String stringExtra = getIntent().getStringExtra("couponId");
            String stringExtra2 = getIntent().getStringExtra("couponCode");
            if (!TextUtils.isEmpty(stringExtra) || !TextUtils.isEmpty(stringExtra2)) {
                z0(stringExtra, stringExtra2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (getIntent().getStringExtra(SocialConstants.PARAM_TYPE).equals("login")) {
                startActivity(new Intent(com.frame.v0.g(), (Class<?>) A047634d3a4.class));
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296442:
                v.a aVar = new v.a(this);
                aVar.n("请输入劵码");
                aVar.g(new c());
                aVar.d().show();
                break;
            case 2131296493:
                Intent intent = new Intent(getApplicationContext(), (Class<?>) WebAct.class);
                intent.putExtra(SocialConstants.PARAM_URL, "https://h5.skyingidea.com/orderHistory/payrecord.html");
                intent.putExtra("title", "购买记录");
                startActivity(intent);
                break;
            case 2131296536:
                Intent intent2 = new Intent(getApplicationContext(), (Class<?>) WebAct.class);
                intent2.putExtra(SocialConstants.PARAM_URL, "https://h5.skyingidea.com/orderHistory/ieyes/pages/tips.html");
                intent2.putExtra("title", "购买须知");
                startActivity(intent2);
                break;
            case 2131296823:
            case 2131297255:
                if (!AccountTool.d().j()) {
                    startActivity(new Intent(com.frame.v0.g(), (Class<?>) A047634d3a4.class));
                    break;
                }
                break;
            case 2131297206:
                s0();
                break;
        }
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.P) {
            com.user.w.h().H();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        try {
            this.Z = this.c0.getItem(i2).getId();
            this.c0.f(i2);
            this.c0.notifyDataSetChanged();
            s0();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onPause() {
        super.onPause();
        S();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        UserTop userTop = this.d0;
        if (userTop != null) {
            userTop.d();
        }
        com.frame.n0.j("getCurrentUserInfo", 0L);
        if (this.U) {
            this.W = 0;
            this.U = false;
            X(false);
            r0();
        }
        this.U = false;
        VipAdapter vipAdapter = this.c0;
        if (vipAdapter == null || vipAdapter.getData().isEmpty()) {
            A0();
        }
    }

    public void r0() {
        if (this.W >= 3) {
            this.W = 0;
            return;
        }
        if (AccountTool.d().m() && !this.Q) {
            C0();
            return;
        }
        this.W++;
        f.a aVar = new f.a();
        aVar.f("/getCurrentUserInfo");
        aVar.b();
        aVar.a().l(String.class, new g());
    }

    void s0() {
        if (AccountTool.d().c() == null) {
            startActivity(new Intent(this, (Class<?>) A047634d3a4.class));
            return;
        }
        boolean zM = AccountTool.d().m();
        this.Q = zM;
        if (zM) {
            this.V = AccountTool.d().c().getVipEndTime();
        }
        E0();
    }

    public void u0() {
        String stringExtra;
        if (this.Z.longValue() == 0) {
            return;
        }
        String code = null;
        try {
            stringExtra = getIntent().getStringExtra("fromEvent");
        } catch (Exception e2) {
            e2.printStackTrace();
            stringExtra = null;
        }
        f.a aVar = new f.a();
        aVar.f("/createOrder");
        aVar.b();
        aVar.e("id", this.Z + "");
        Coupon coupon = this.a0;
        aVar.d("couponId", (coupon == null || !(coupon.getVipConfigId() == null || this.a0.getVipConfigId().contains(String.valueOf(this.Z)))) ? null : this.a0.getId());
        Coupon coupon2 = this.a0;
        if (coupon2 != null && (coupon2.getVipConfigId() == null || this.a0.getVipConfigId().contains(String.valueOf(this.Z)))) {
            code = this.a0.getCode();
        }
        aVar.e("couponCode", code);
        aVar.e("fromEvent", stringExtra);
        aVar.a().l(String.class, new e(this));
    }
}
