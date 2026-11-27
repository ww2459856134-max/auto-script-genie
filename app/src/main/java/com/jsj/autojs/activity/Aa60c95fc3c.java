package com.jsj.autojs.activity;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.jsj.autojs.adapter.CouponListAdapter;
import com.tencent.cursor.R;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.user.model.PayModel;
import com.user.w;
import com.yl.ui.v;
import i.h.f;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Aa60c95fc3c extends q8 implements BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.j {
    private CouponListAdapter P;
    private SwipeRefreshLayout V;
    private int Q = 20;
    private int U = 0;
    ArrayList<JSONObject> W = new ArrayList<>();

    class a extends w.a {
        a() {
        }

        @Override // com.user.w.a
        public void a(String str) {
            Aa60c95fc3c.this.h();
        }

        @Override // com.user.w.a
        public void c(String str) {
        }
    }

    class b extends i.h.g<String> {
        b(Activity activity) {
            super(activity);
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            Aa60c95fc3c.this.Y(str);
            Aa60c95fc3c.this.V.setRefreshing(false);
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(String str) throws JSONException {
            Aa60c95fc3c.this.P.loadMoreComplete();
            Aa60c95fc3c.this.V.setRefreshing(false);
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("content");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    Aa60c95fc3c.this.W.add(jSONArray.getJSONObject(i2));
                }
                Aa60c95fc3c.this.P.setNewData(Aa60c95fc3c.this.W);
                Aa60c95fc3c.this.P.setEnableLoadMore(jSONObject.optInt("number") + 1 < jSONObject.optInt("totalPages"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Aa60c95fc3c.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o0(PayModel payModel) {
        com.user.w.h().B(payModel, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q0(int i2) {
        try {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("count", i2 + ""));
            arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_TYPE, "wx"));
            arrayList.add(new BasicNameValuePair("vipConfigId", "7530136"));
            arrayList.add(new BasicNameValuePair("token", AccountTool.d().e()));
            JSONObject jSONObject = new JSONObject(com.frame.p0.h().p(com.frame.k0.g + "/buyCoupon", arrayList));
            S();
            if (jSONObject.optInt("code") != 1) {
                Y(jSONObject.optString(SocialConstants.PARAM_SEND_MSG));
                return;
            }
            String strOptString = jSONObject.optString("json");
            jSONObject.optString(SocialConstants.PARAM_SEND_MSG);
            final PayModel payModel = (PayModel) new Gson().j(com.frame.n1.b(strOptString), PayModel.class);
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.c4
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.o0(payModel);
                }
            });
            S();
        } catch (Exception e) {
            S();
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean s0(Dialog dialog, String str) {
        try {
            m0(Integer.parseInt(str));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Y("请输入整数");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(View view) {
        v.a aVar = new v.a(this);
        aVar.n("批量采购");
        aVar.f("请输入采购数量");
        aVar.h(2);
        aVar.k("50");
        aVar.o("VIP抵用券");
        aVar.g(new v.b() { // from class: com.jsj.autojs.activity.d4
            @Override // com.yl.ui.v.b
            public final boolean a(Dialog dialog, String str) {
                return this.a.s0(dialog, str);
            }
        });
        aVar.d().show();
    }

    private void v0() {
        f.a aVar = new f.a();
        aVar.f("/getChannelCoupons");
        aVar.c("page", Integer.valueOf(this.U));
        aVar.c("size", Integer.valueOf(this.Q));
        aVar.a().l(String.class, new b(this));
    }

    @Override // com.yl.ui.p
    public void b0() {
        super.b0();
        j0("我的抵用券");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(2131297080);
        this.V = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CouponListAdapter couponListAdapter = new CouponListAdapter(null);
        this.P = couponListAdapter;
        recyclerView.setAdapter(couponListAdapter);
        this.P.setOnItemClickListener(this);
        this.P.setOnLoadMoreListener(this);
        U();
        v0();
        g0("批量采购", new View.OnClickListener() { // from class: com.jsj.autojs.activity.b4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.u0(view);
            }
        });
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void h() {
        this.W.clear();
        this.U = 0;
        v0();
    }

    public void m0(final int i2) {
        X(false);
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.e4
            @Override // java.lang.Runnable
            public final void run() {
                this.c.q0(i2);
            }
        });
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        try {
            com.frame.m0.a(this.P.getItem(i2).optString("code"));
            Y("已经优惠券码复制至剪切板");
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
        this.U++;
        v0();
    }
}
