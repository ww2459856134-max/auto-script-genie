package com.jsj.autojs.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.jsj.autojs.activity.Aec5865a7cc;
import com.jsj.autojs.adapter.BindPhoneListAdapter;
import com.jsj.autojs.l.e0;
import com.jsj.autojs.model.UserModel;
import com.tencent.cursor.R;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.user.model.PayModel;
import com.user.model.WechatModel;
import com.user.w;
import com.yl.float_ui.InputDialogView;
import com.yl.ui.s;
import com.yl.ui.v;
import i.b.da;
import i.b.u8;
import i.h.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Aec5865a7cc extends com.yl.ui.p implements View.OnClickListener, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.j {
    private SwipeRefreshLayout P;
    private RecyclerView Q;
    private BindPhoneListAdapter U;
    private String W;
    private String Z;
    private EditText a0;
    private View b0;
    private com.jsj.autojs.l.e0 e0;
    public boolean f0;
    public HashSet<String> g0;
    private int V = 20;
    private boolean c0 = true;
    private int d0 = 0;

    class a extends i.h.g<String> {
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Activity activity, int i2) {
            super(activity);
            this.b = i2;
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            Aec5865a7cc.this.Y(str);
            Aec5865a7cc.this.S();
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            Aec5865a7cc.this.U.remove(this.b);
            Aec5865a7cc.this.U.notifyDataSetChanged();
            Aec5865a7cc.this.S();
        }
    }

    class b extends i.h.g<UserModel> {
        b(Activity activity) {
            super(activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e(UserModel userModel) {
            for (UserModel.ContentBean contentBean : userModel.getContent()) {
                Aec5865a7cc.this.g0.add(contentBean.getId() + "");
            }
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            Aec5865a7cc.this.U.loadMoreComplete();
            Aec5865a7cc.this.P.setRefreshing(false);
            Aec5865a7cc.this.Y(str);
            Aec5865a7cc.this.S();
        }

        @Override // i.h.f.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(final UserModel userModel) {
            Aec5865a7cc.this.U.loadMoreComplete();
            Aec5865a7cc.this.P.setRefreshing(false);
            boolean z = (userModel == null || userModel.getContent() == null || userModel.getContent().isEmpty()) ? false : true;
            if (z) {
                Aec5865a7cc.this.U.addData((Collection) userModel.getContent());
                Aec5865a7cc.this.U.notifyDataSetChanged();
                Aec5865a7cc.this.U.setEnableLoadMore(userModel.getNumber() + 1 < userModel.getTotalPages());
                com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.l6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.e(userModel);
                    }
                });
            }
            if (Aec5865a7cc.this.d0 == 0 && Aec5865a7cc.this.b0 != null) {
                if (Aec5865a7cc.this.c0) {
                    Aec5865a7cc.this.c0 = false;
                    Aec5865a7cc.this.b0.setVisibility(z ? 0 : 8);
                } else if (z && Aec5865a7cc.this.b0.getVisibility() != 0) {
                    Aec5865a7cc.this.b0.setVisibility(0);
                }
            }
            Aec5865a7cc.this.S();
        }
    }

    class c implements f.b<String> {
        final /* synthetic */ Long a;

        c(Long l2) {
            this.a = l2;
        }

        @Override // i.h.f.b
        public void a(int i2, String str) {
            Aec5865a7cc.this.S();
            Aec5865a7cc.this.Y(str);
        }

        @Override // i.h.f.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            Aec5865a7cc.this.S();
            if (TextUtils.isEmpty(str)) {
                Aec5865a7cc.this.W1(this.a, null);
                return;
            }
            try {
                Aec5865a7cc.this.W1(this.a, new JSONObject(str).optString("permissions"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class d implements f.b<String> {
        d() {
        }

        @Override // i.h.f.b
        public void a(int i2, String str) {
            Aec5865a7cc.this.S();
            Aec5865a7cc.this.Y(str);
        }

        @Override // i.h.f.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            Aec5865a7cc.this.S();
            com.yl.ui.i0.j();
        }
    }

    class e implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ CheckBox a;

        e(CheckBox checkBox) {
            this.a = checkBox;
        }

        static /* synthetic */ void a(CheckBox checkBox, DatePicker datePicker, int i2, int i3, int i4) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(1, i2);
            calendar.set(2, i3);
            calendar.set(5, i4);
            checkBox.setText("限制使用主账号脚本有效期\n" + com.frame.m1.b(calendar.getTimeInMillis(), "yyyy年MM月dd日"));
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!z) {
                this.a.setText("限制使用主账号脚本有效期");
                return;
            }
            try {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Aec5865a7cc.this);
                final CheckBox checkBox = this.a;
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() { // from class: com.jsj.autojs.activity.q6
                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                        Aec5865a7cc.e.a(checkBox, datePicker, i2, i3, i4);
                    }
                });
                datePickerDialog.create();
                datePickerDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class f extends i.h.g<String> {
        f(Activity activity) {
            super(activity);
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            try {
                Aec5865a7cc.this.Y(str);
                ((com.yl.ui.p) c()).S();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ("已开通成功，请重新登录".equals(str)) {
                s.a aVar = new s.a(Aec5865a7cc.this);
                aVar.j("子账号已开通会员，请重新登录主账号刷新缓存");
                aVar.m("取消", null);
                aVar.g(2131231260);
                aVar.r("知道了", null);
                aVar.t("温馨提示");
                aVar.e().show();
            }
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
        }
    }

    class g extends i.h.g<String> {
        final /* synthetic */ UserModel.ContentBean b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Activity activity, UserModel.ContentBean contentBean, String str) {
            super(activity);
            this.b = contentBean;
            this.c = str;
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            Aec5865a7cc.this.S();
            Aec5865a7cc.this.Y(str);
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            this.b.setName(this.c);
            Aec5865a7cc.this.U.notifyDataSetChanged();
            Aec5865a7cc.this.S();
        }
    }

    class h implements e0.a {
        h() {
        }

        @Override // com.jsj.autojs.l.e0.a
        public void a() {
            Aec5865a7cc.this.S();
            Aec5865a7cc.this.h();
        }

        @Override // com.jsj.autojs.l.e0.a
        public void b(String str) {
            Aec5865a7cc.this.Y(str);
            Aec5865a7cc.this.S();
        }
    }

    class i extends w.a {
        i() {
        }

        @Override // com.user.w.a
        public void a(String str) {
            Aec5865a7cc.this.S1();
            com.yl.ui.i0.j();
            Aec5865a7cc.this.S();
            Aec5865a7cc.this.Z1();
        }

        @Override // com.user.w.a
        public void c(String str) {
        }
    }

    class j extends i.h.g<String> {
        final /* synthetic */ ImageView b;
        final /* synthetic */ TextView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Activity activity, ImageView imageView, TextView textView) {
            super(activity);
            this.b = imageView;
            this.c = textView;
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            Aec5865a7cc.this.S();
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("name");
                String strOptString2 = jSONObject.optString("headimgurl");
                if (!TextUtils.isEmpty(strOptString2)) {
                    com.bumptech.glide.c.t(com.frame.v0.g()).w(strOptString2).q0(this.b);
                }
                this.c.setText(strOptString);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Aec5865a7cc.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B0(int i2, com.yl.ui.s sVar, View view) {
        Intent intent = new Intent(com.frame.v0.g(), (Class<?>) Abc651937bc.class);
        intent.putExtra("userId", this.U.getItem(i2).getId());
        startActivity(intent);
        sVar.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B1(com.yl.ui.s sVar, View view) {
        sVar.cancel();
        u0(10, "super");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D0(int i2, com.yl.ui.s sVar, View view) {
        T1(i2);
        sVar.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D1(com.yl.ui.s sVar, View view) {
        sVar.cancel();
        u0(100, "super");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F0(com.yl.ui.s sVar, View view) {
        X1();
        sVar.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F1(com.yl.ui.s sVar, View view) {
        sVar.cancel();
        u0(500, "super");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H0(int i2, com.yl.ui.s sVar, View view) {
        V1(i2);
        sVar.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H1(int i2, DialogInterface dialogInterface, int i3) {
        U();
        f.a aVar = new f.a();
        aVar.f(com.frame.k0.g + "/unbindSubUser");
        aVar.d("subId", this.U.getItem(i2).getId());
        aVar.g(true);
        aVar.a().l(String.class, new a(this, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J0() {
        this.e0.z(null);
        try {
            s.a aVar = new s.a(this);
            aVar.t("温馨提示");
            aVar.j("扫描成功，子账号登录成功。");
            aVar.r("知道了", null);
            aVar.e().show();
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean J1(UserModel.ContentBean contentBean, String str) {
        if (str.length() > 20) {
            Y("长度不能超过20");
            return false;
        }
        f.a aVar = new f.a();
        aVar.f("/rename");
        aVar.d("id", contentBean.getId());
        aVar.e("name", str);
        aVar.a().l(String.class, new g(this, contentBean, str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L0(String str, UserModel.ContentBean contentBean) {
        new u8().b(str, contentBean.getId(), new Runnable() { // from class: com.jsj.autojs.activity.a7
            @Override // java.lang.Runnable
            public final void run() {
                this.c.J0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, Long l2, DialogInterface dialogInterface, int i2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (checkBox.isChecked()) {
                jSONObject.put("noCloud", 1);
            }
            if (checkBox2.isChecked()) {
                jSONObject.put("noShare", 1);
            }
            if (checkBox3.isChecked()) {
                jSONObject.put("runTime", checkBox3.getText().toString().split("\n")[1]);
            }
            if (checkBox4.isChecked()) {
                jSONObject.put("canBackup", 1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        f.a aVar = new f.a();
        aVar.f("/submitSubPermission");
        aVar.d("id", l2);
        aVar.g(true);
        aVar.e("pid", AccountTool.d().f());
        aVar.g(true);
        aVar.e("permissions", jSONObject.toString());
        aVar.a().l(String.class, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean N0(int i2, Dialog dialog, final String str) {
        if (TextUtils.isEmpty(str)) {
            Y("请输入登录码");
            return false;
        }
        final UserModel.ContentBean item = this.U.getItem(i2);
        this.e0.z(item.getId());
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.v6
            @Override // java.lang.Runnable
            public final void run() {
                this.c.L0(str, item);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean N1(Dialog dialog, String str) {
        t0(str, "subVip");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P0(final int i2, View view) {
        v.a aVar = new v.a(this);
        aVar.n("输入登录码");
        aVar.f("请输入登录码");
        aVar.l(3);
        aVar.g(new v.b() { // from class: com.jsj.autojs.activity.f7
            @Override // com.yl.ui.v.b
            public final boolean a(Dialog dialog, String str) {
                return this.a.N0(i2, dialog, str);
            }
        });
        aVar.d().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P1(DialogInterface dialogInterface, int i2) {
        Abd192a7cca.D0(this, "bindAccount");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R0(int i2, View view) {
        if (q0()) {
            this.e0.z(this.U.getItem(i2).getId());
            new com.jsj.autojs.l.f0().j(this, 1025);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R1(DialogInterface dialogInterface, int i2) {
        Abd192a7cca.D0(this, "bindAccount");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T0(View view) {
        Intent intent = new Intent(com.frame.v0.g(), (Class<?>) A68c0a83b53.class);
        intent.putExtra("isMainLoad", true);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V0(View view) {
        v0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean X0(TextView textView, int i2, KeyEvent keyEvent) {
        v0();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z0() {
        if (da.B().V()) {
            finish();
            TextView textView = null;
            textView.setText((CharSequence) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b1(PayModel payModel) {
        com.user.w.h().B(payModel, new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d1(int i2, String str) {
        try {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("u", com.frame.p0.h().i()));
            arrayList.add(new BasicNameValuePair("count", i2 + ""));
            arrayList.add(new BasicNameValuePair("payType", "wx"));
            arrayList.add(new BasicNameValuePair("vipType", str));
            arrayList.add(new BasicNameValuePair("token", AccountTool.d().e()));
            JSONObject jSONObject = new JSONObject(com.frame.p0.h().p(com.frame.k0.g + "/createAndPaySubUser", arrayList));
            S();
            if (jSONObject.optInt("code") != 1) {
                Y(jSONObject.optString(SocialConstants.PARAM_SEND_MSG));
                return;
            }
            this.f0 = true;
            String strOptString = jSONObject.optString("json");
            jSONObject.optString(SocialConstants.PARAM_SEND_MSG);
            final PayModel payModel = (PayModel) new Gson().j(com.frame.n1.b(strOptString), PayModel.class);
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.o6
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.b1(payModel);
                }
            });
            S();
        } catch (Exception e2) {
            S();
            com.frame.k0.r(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f1(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        r0(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean h1(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        return r0(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j1(com.yl.ui.w wVar, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (i2 == 0) {
            this.W = "id desc";
            h();
            wVar.X1();
        } else if (i2 == 1) {
            this.W = "name desc";
            h();
            wVar.X1();
        } else if (i2 == 2) {
            this.W = "name asc";
            h();
            wVar.X1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l1(View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("默认排序");
        arrayList.add("按昵称降序");
        arrayList.add("按昵称升序");
        final com.yl.ui.w wVar = new com.yl.ui.w();
        wVar.m2("设置排序");
        wVar.l2(arrayList, new BaseQuickAdapter.OnItemClickListener() { // from class: com.jsj.autojs.activity.w6
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i2) {
                this.c.j1(wVar, baseQuickAdapter, view2, i2);
            }
        });
        wVar.j2(x(), "item");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n1(com.yl.ui.s sVar, View view) {
        sVar.cancel();
        u0(100, "mouth");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p1(com.yl.ui.s sVar, View view) {
        sVar.cancel();
        u0(100, "year");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r1(com.yl.ui.s sVar, View view) {
        sVar.cancel();
        u0(100, "7day");
    }

    private boolean r0(final int i2) {
        if (!AccountTool.d().m()) {
            Y1();
            return true;
        }
        View viewInflate = View.inflate(com.frame.v0.g(), 2131493113, null);
        s.a aVar = new s.a(this);
        aVar.u(viewInflate);
        aVar.f();
        aVar.r("确定", null);
        aVar.m("取消", null);
        aVar.n();
        aVar.t("请选择操作");
        final com.yl.ui.s sVarE = aVar.e();
        sVarE.show();
        viewInflate.findViewById(2131296399).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.d7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.z0(i2, sVarE, view);
            }
        });
        viewInflate.findViewById(2131296354).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.o7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.B0(i2, sVarE, view);
            }
        });
        viewInflate.findViewById(2131296397).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.k7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.D0(i2, sVarE, view);
            }
        });
        viewInflate.findViewById(2131296417).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.y6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.F0(sVarE, view);
            }
        });
        viewInflate.findViewById(2131296393).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.t6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.H0(i2, sVarE, view);
            }
        });
        viewInflate.findViewById(2131296365).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.r7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.P0(i2, view);
            }
        });
        viewInflate.findViewById(2131296410).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.b7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.R0(i2, view);
            }
        });
        return true;
    }

    private View s0() {
        View viewInflate = View.inflate(com.frame.v0.g(), 2131493115, null);
        TextView textView = (TextView) viewInflate.findViewById(2131296443);
        textView.setOnClickListener(this);
        textView.setText("购买账号");
        ((TextView) viewInflate.findViewById(2131297161)).setText("是否需要在多个设备上执行同一脚本，在模拟器上扫一扫快速登录子账号，一个设备同时只能登录一个账号，二级子账号更优惠。");
        ((TextView) viewInflate.findViewById(2131297162)).setText("绑定子账号");
        com.jsj.autojs.l.w.b((ImageView) viewInflate.findViewById(R.id.iv_icon), "img_bindphone.webp");
        View viewFindViewById = viewInflate.findViewById(2131296895);
        if (AccountTool.d().j()) {
            viewFindViewById.setBackgroundResource(R.drawable.bg_item);
            TextView textView2 = (TextView) viewFindViewById.findViewById(2131296506);
            viewFindViewById.findViewById(2131296850).setVisibility(8);
            textView2.setText("主账号");
            WechatModel wechatModelC = AccountTool.d().c();
            ImageView imageView = (ImageView) viewFindViewById.findViewById(2131296823);
            TextView textView3 = (TextView) viewFindViewById.findViewById(2131297255);
            if (wechatModelC.getPid() != null) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.n7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.T0(view);
                    }
                });
                f.a aVar = new f.a();
                aVar.f("/getUserInfoById");
                aVar.d("id", wechatModelC.getPid());
                aVar.a().l(String.class, new j(this, imageView, textView3));
            } else {
                viewFindViewById.setVisibility(8);
            }
        } else {
            viewFindViewById.setVisibility(8);
        }
        this.a0 = (EditText) viewInflate.findViewById(2131296618);
        this.b0 = viewInflate.findViewById(2131296904);
        viewInflate.findViewById(2131296520).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.w7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.V0(view);
            }
        });
        this.a0.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.jsj.autojs.activity.n6
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView4, int i2, KeyEvent keyEvent) {
                return this.a.X0(textView4, i2, keyEvent);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t1(DialogInterface dialogInterface, int i2) {
        Abd192a7cca.D0(this, "createAccount");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v1(DialogInterface dialogInterface, int i2) {
        Abd192a7cca.D0(this, "createAccount");
    }

    private void v0() {
        this.Z = this.a0.getText().toString().trim();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x0(DialogInterface dialogInterface, int i2) {
        androidx.core.app.f.l(this, new String[]{"android.permission.CAMERA"}, 1026);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x1(com.yl.ui.s sVar, View view) {
        sVar.cancel();
        u0(0, "super");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z0(int i2, com.yl.ui.s sVar, View view) {
        U1(i2);
        sVar.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z1(com.yl.ui.s sVar, View view) {
        sVar.cancel();
        u0(1, "super");
    }

    public void S1() {
        f.a aVar = new f.a();
        aVar.f(com.frame.k0.g + "/getSubUsers");
        aVar.c("page", Integer.valueOf(this.d0));
        aVar.c("size", Integer.valueOf(this.V));
        aVar.e("sorter", this.W);
        if (!TextUtils.isEmpty(this.Z)) {
            aVar.e("name", this.Z);
        }
        aVar.g(true);
        aVar.a().l(UserModel.class, new b(this));
    }

    public void T1(final int i2) {
        try {
            s.a aVar = new s.a(this);
            aVar.g(2131231019);
            aVar.r("确认", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.u7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.c.H1(i2, dialogInterface, i3);
                }
            });
            aVar.m("取消", null);
            aVar.j("是否确认解绑该子账号？");
            aVar.t("温馨提示");
            aVar.e().show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void U1(int i2) {
        final UserModel.ContentBean item = this.U.getItem(i2);
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("重命昵称");
        inputDialogView.s("请输入子账号昵称");
        inputDialogView.w(item.getName());
        inputDialogView.t(new InputDialogView.a() { // from class: com.jsj.autojs.activity.p7
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.J1(item, str);
            }
        });
    }

    public void V1(int i2) {
        Long id = this.U.getItem(i2).getId();
        f.a aVar = new f.a();
        aVar.f("/getSubUserPermission");
        aVar.d("userId", id);
        aVar.g(true);
        aVar.a().l(String.class, new c(id));
    }

    public void W1(final Long l2, String str) {
        View viewInflate = View.inflate(getApplicationContext(), 2131493140, null);
        final CheckBox checkBox = (CheckBox) viewInflate.findViewById(2131296386);
        final CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(2131296364);
        final CheckBox checkBox3 = (CheckBox) viewInflate.findViewById(2131296387);
        final CheckBox checkBox4 = (CheckBox) viewInflate.findViewById(2131296358);
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                checkBox.setChecked(jSONObject.has("noCloud"));
                checkBox3.setChecked(jSONObject.has("noShare"));
                checkBox2.setChecked(jSONObject.has("runTime"));
                checkBox4.setChecked(jSONObject.has("canBackup"));
                if (checkBox2.isChecked()) {
                    checkBox2.setText("限制执行主账号脚本有效期\n" + jSONObject.optString("runTime"));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        s.a aVar = new s.a(this);
        aVar.u(viewInflate);
        aVar.f();
        aVar.r("确定", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.u6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) throws JSONException {
                this.c.L1(checkBox, checkBox3, checkBox2, checkBox4, l2, dialogInterface, i2);
            }
        });
        aVar.m("取消", null);
        aVar.n();
        aVar.t("请选择操作");
        aVar.e().show();
        checkBox2.setOnCheckedChangeListener(new e(checkBox2));
    }

    public void X1() {
        try {
            v.a aVar = new v.a(this);
            aVar.f("你可以购买/获取会员抵用券，输入后即可开通子账号会员，可以批量6折购买子账号VIP（10个起售），输入抵用券即可为子账号开通VIP。");
            aVar.n("请输入输入会员抵用券码");
            aVar.g(new v.b() { // from class: com.jsj.autojs.activity.j7
                @Override // com.yl.ui.v.b
                public final boolean a(Dialog dialog, String str) {
                    return this.a.N1(dialog, str);
                }
            });
            aVar.d().show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void Y1() {
        s.a aVar = new s.a(this);
        aVar.j("绑定子账号是会员权益功能功能，解锁更多任务及会员权益，请开通VIP可继续使用？");
        aVar.m("查看权益", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.r6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.P1(dialogInterface, i2);
            }
        });
        aVar.g(2131231260);
        aVar.r("去开通", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.t7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.R1(dialogInterface, i2);
            }
        });
        aVar.t("温馨提示");
        aVar.e().show();
    }

    public void Z1() {
        try {
            S();
            s.a aVar = new s.a(com.frame.v0.g().d());
            aVar.g(R.drawable.great_icon);
            aVar.m("知道了", null);
            aVar.j("如果您已成功支付，可下拉刷新列表，服务器有时候会延迟，也可稍等会儿下来刷新。");
            aVar.t("温馨提示");
            aVar.e().show();
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492895;
    }

    @Override // com.yl.ui.p
    public void b0() {
        j0("绑定多设备");
        String strF = com.frame.n0.f("subUserIds", null);
        if (strF != null) {
            this.g0 = new HashSet<>(Arrays.asList(strF.split(",")));
        } else {
            this.g0 = new HashSet<>();
        }
        this.e0 = new com.jsj.autojs.l.e0(this, new h());
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(2131297080);
        this.P = swipeRefreshLayout;
        swipeRefreshLayout.setEnabled(true);
        this.P.setOnRefreshListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.Q = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BindPhoneListAdapter bindPhoneListAdapter = new BindPhoneListAdapter(null);
        this.U = bindPhoneListAdapter;
        bindPhoneListAdapter.setEnableLoadMore(false);
        this.U.setUpFetchEnable(true);
        this.U.setOnLoadMoreListener(this);
        this.U.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.jsj.autojs.activity.s7
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.f1(baseQuickAdapter, view, i2);
            }
        });
        this.U.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() { // from class: com.jsj.autojs.activity.i7
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                return this.c.h1(baseQuickAdapter, view, i2);
            }
        });
        this.Q.setAdapter(this.U);
        this.U.addHeaderView(s0());
        S1();
        Z();
        i0(" 排序 ", new View.OnClickListener() { // from class: com.jsj.autojs.activity.k6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.l1(view);
            }
        });
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void h() {
        this.d0 = 0;
        this.U.setNewData(null);
        S1();
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.e0.y(i2, i3, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296443) {
            return;
        }
        if (!AccountTool.d().l()) {
            s.a aVar = new s.a(this);
            aVar.j("只有终身会员才可购买子账号（终身会员并没有赠送子账号，需要额外购买），解锁更多会员权益，请开通VIP可继续使用？");
            aVar.m("查看权益", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.e7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.t1(dialogInterface, i2);
                }
            });
            aVar.g(2131231260);
            aVar.r("去开通", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.m7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.v1(dialogInterface, i2);
                }
            });
            aVar.t("温馨提示");
            aVar.e().show();
            return;
        }
        View viewInflate = View.inflate(com.frame.v0.g(), 2131493114, null);
        s.a aVar2 = new s.a(this);
        aVar2.j("购买的子账号，使用扫一扫登录，方便模拟器、云手机上登录使用，可以同步脚本到子账号，精准控制子账号使用权限。买的越多折扣越多，子账号登录后即激活（激活后才算会员时间不会提前计算的）。");
        aVar2.u(viewInflate);
        aVar2.f();
        aVar2.r("确定", null);
        aVar2.m("取消", null);
        aVar2.n();
        aVar2.t("创建子账号");
        final com.yl.ui.s sVarE = aVar2.e();
        sVarE.show();
        viewInflate.findViewById(2131296341).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.p6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.x1(sVarE, view2);
            }
        });
        viewInflate.findViewById(2131296342).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.m6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.z1(sVarE, view2);
            }
        });
        viewInflate.findViewById(2131296343).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.v7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.B1(sVarE, view2);
            }
        });
        viewInflate.findViewById(2131296344).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.l7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.D1(sVarE, view2);
            }
        });
        viewInflate.findViewById(2131296345).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.z6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.F1(sVarE, view2);
            }
        });
        viewInflate.findViewById(2131296382).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.x6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.n1(sVarE, view2);
            }
        });
        viewInflate.findViewById(2131296418).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.s6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.p1(sVarE, view2);
            }
        });
        viewInflate.findViewById(2131296346).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.c7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.r1(sVarE, view2);
            }
        });
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
        this.d0++;
        S1();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f0) {
            Z1();
        }
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onStop() {
        super.onStop();
        HashSet<String> hashSet = this.g0;
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        com.frame.n0.k("subUserIds", defpackage.g.a(",", this.g0));
    }

    public boolean q0() {
        if (androidx.core.content.a.a(this, "android.permission.CAMERA") == 0) {
            return true;
        }
        s.a aVar = new s.a(this);
        aVar.j("绑定子账号，需要用到开启相机权限扫描二维码，是否开启呢？");
        aVar.m("取消", null);
        aVar.r("开启", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.g7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.x0(dialogInterface, i2);
            }
        });
        aVar.t("温馨提示");
        aVar.e().show();
        return false;
    }

    public void t0(String str, String str2) {
        f.a aVar = new f.a();
        aVar.f("/createOrder");
        aVar.b();
        aVar.b();
        aVar.e("couponCode", str);
        aVar.e("fromEvent", str2);
        aVar.a().l(String.class, new f(this));
    }

    public void u0(final int i2, final String str) {
        new Thread(new Runnable() { // from class: com.jsj.autojs.activity.q7
            @Override // java.lang.Runnable
            public final void run() {
                this.c.Z0();
            }
        }).start();
        X(false);
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.h7
            @Override // java.lang.Runnable
            public final void run() {
                this.c.d1(i2, str);
            }
        });
    }
}
