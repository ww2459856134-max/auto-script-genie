package com.jsj.autojs.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k0;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.act.WebAct;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jsj.autojs.adapter.VideoItemAdapter;
import com.jsj.autojs.model.Video;
import com.tencent.cursor.R;
import com.tencent.open.SocialConstants;
import com.yl.widget.TitleBar;
import i.h.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class o1 extends com.yl.widget.e implements BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.j {
    private VideoItemAdapter I0;
    private SwipeRefreshLayout J0;
    private GridLayoutManager K0;
    private EditText L0;
    private ImageView M0;
    private View N0;
    private TextView O0;
    private TextView P0;
    private TextView Q0;
    private int R0;
    private boolean S0;
    private boolean T0;
    private final ArrayList<JSONObject> H0 = new ArrayList<>();
    private String U0 = "";

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            o1.this.U0 = charSequence == null ? "" : charSequence.toString().trim();
            o1.this.M0.setVisibility(TextUtils.isEmpty(o1.this.U0) ? 8 : 0);
            o1.this.N2();
        }
    }

    class b extends i.h.g<String> {
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, int i2) {
            super(activity);
            this.b = i2;
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            o1.this.x2(this.b, str);
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(String str) throws JSONException {
            boolean z = false;
            if (!o1.this.d0() || o1.this.I0 == null) {
                o1.this.S0 = false;
                o1.this.v2();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("content");
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(jSONArray.getJSONObject(i2));
                }
                if (this.b == 0) {
                    o1.this.H0.clear();
                }
                o1.this.H0.addAll(arrayList);
                o1.this.R0 = this.b;
                o1.this.T0 = jSONObject.optInt("number") + 1 < jSONObject.optInt("totalPages");
                o1.this.S0 = false;
                o1.this.v2();
                o1.this.N2();
                if (o1.this.T0) {
                    o1.this.I0.loadMoreComplete();
                } else {
                    o1.this.I0.loadMoreEnd();
                }
                VideoItemAdapter videoItemAdapter = o1.this.I0;
                if (o1.this.T0 && TextUtils.isEmpty(o1.this.U0)) {
                    z = true;
                }
                videoItemAdapter.setEnableLoadMore(z);
            } catch (JSONException e) {
                com.frame.k0.r(e);
                o1.this.x2(this.b, "教程数据加载失败");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D2() {
        this.L0.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F2() {
        L2(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H2(View view) {
        this.L0.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean J2(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 != 3) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) y1().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.L0.getWindowToken(), 0);
        }
        this.L0.clearFocus();
        return true;
    }

    private void L2(int i2) {
        SwipeRefreshLayout swipeRefreshLayout;
        if (!d0() || this.S0) {
            return;
        }
        this.S0 = true;
        y2();
        if (i2 == 0 && this.H0.isEmpty() && (swipeRefreshLayout = this.J0) != null) {
            swipeRefreshLayout.setRefreshing(true);
        }
        f.a aVar = new f.a();
        aVar.f("/getIndexPage");
        aVar.b();
        aVar.c("page", Integer.valueOf(i2));
        aVar.c("size", Integer.valueOf(k0.a.DEFAULT_DRAG_ANIMATION_DURATION));
        aVar.c("jumpType", 12);
        aVar.a().l(String.class, new b(q(), i2));
    }

    private boolean M2(JSONObject jSONObject, String str, String str2) {
        return TextUtils.isEmpty(str2) || u2(jSONObject.optString("label"), str2) || u2(jSONObject.optString("descr"), str2) || u2(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, org.json.JSONObject] */
    public void N2() {
        if (this.I0 == null) {
            return;
        }
        String lowerCase = this.U0.toLowerCase(Locale.ROOT);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        Iterator<JSONObject> it = this.H0.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JSONObject next = it.next();
            String strTrim = next.optString("subTitle").trim();
            if (TextUtils.isEmpty(strTrim)) {
                strTrim = "更多教程";
            }
            if (M2(next, strTrim, lowerCase)) {
                if (hashSet.add(strTrim)) {
                    arrayList.add(new Video(true, strTrim));
                }
                Video video = new Video(false, strTrim);
                video.t = next;
                arrayList.add(video);
            }
        }
        this.I0.setNewData(arrayList);
        this.I0.setEnableLoadMore(this.T0 && TextUtils.isEmpty(this.U0));
        if (!arrayList.isEmpty()) {
            y2();
            return;
        }
        if (this.S0) {
            y2();
        } else if (TextUtils.isEmpty(this.U0)) {
            P2("暂无教程", "下拉刷新或稍后再试", "重新加载", new Runnable() { // from class: com.jsj.autojs.j.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.F2();
                }
            });
        } else {
            P2("未找到相关教程", "换个关键词试试", "清除搜索", new Runnable() { // from class: com.jsj.autojs.j.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.D2();
                }
            });
        }
    }

    private void O2() {
        this.L0 = (EditText) V1(2131296597);
        ImageView imageView = (ImageView) V1(2131296436);
        this.M0 = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.j.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.H2(view);
            }
        });
        this.L0.addTextChangedListener(new a());
        this.L0.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.jsj.autojs.j.e
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return this.a.J2(textView, i2, keyEvent);
            }
        });
    }

    private void P2(String str, String str2, String str3, final Runnable runnable) {
        this.O0.setText(str);
        this.P0.setText(str2);
        this.Q0.setText(str3);
        this.Q0.setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.j.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                runnable.run();
            }
        });
        this.Q0.setVisibility(TextUtils.isEmpty(str3) ? 8 : 0);
        this.N0.setVisibility(0);
    }

    private boolean u2(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.toLowerCase(Locale.ROOT).contains(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v2() {
        SwipeRefreshLayout swipeRefreshLayout = this.J0;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    private int w2() {
        return com.frame.p1.f() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x2(int i2, String str) {
        this.S0 = false;
        v2();
        VideoItemAdapter videoItemAdapter = this.I0;
        if (videoItemAdapter == null) {
            return;
        }
        if (i2 > 0) {
            videoItemAdapter.loadMoreFail();
            return;
        }
        if (this.H0.isEmpty()) {
            P2("教程加载失败", "请检查网络后重新加载", "重新加载", new Runnable() { // from class: com.jsj.autojs.j.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.A2();
                }
            });
            return;
        }
        N2();
        if (TextUtils.isEmpty(str)) {
            str = "刷新失败，请稍后重试";
        }
        h2(str);
    }

    private void y2() {
        View view = this.N0;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A2() {
        L2(0);
    }

    @Override // com.yl.widget.e
    public int X1() {
        return 2131493041;
    }

    @Override // com.yl.widget.e
    public void e2(Bundle bundle) {
        super.e2(bundle);
        TitleBar titleBar = (TitleBar) V1(R.id.title_bar);
        titleBar.b();
        titleBar.setBackgroundColor(R().getColor(R.color.main_color));
        titleBar.setTitle("使用教程");
        com.jsj.autojs.j.a aVar = new View.OnClickListener() { // from class: com.jsj.autojs.j.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.jsj.autojs.l.c0.e().g();
            }
        };
        V1(2131296933).setOnClickListener(aVar);
        V1(2131296392).setOnClickListener(aVar);
        this.N0 = V1(2131297139);
        this.O0 = (TextView) V1(2131297142);
        this.P0 = (TextView) V1(2131297141);
        this.Q0 = (TextView) V1(2131297140);
        O2();
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) V1(2131297080);
        this.J0 = swipeRefreshLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.main_color);
        this.J0.setOnRefreshListener(this);
        this.J0.setRefreshing(true);
        RecyclerView recyclerView = (RecyclerView) V1(R.id.recyclerView);
        recyclerView.setItemAnimator(null);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(com.frame.v0.g(), w2());
        this.K0 = gridLayoutManager;
        recyclerView.setLayoutManager(gridLayoutManager);
        VideoItemAdapter videoItemAdapter = new VideoItemAdapter(new ArrayList());
        this.I0 = videoItemAdapter;
        recyclerView.setAdapter(videoItemAdapter);
        this.I0.setOnItemClickListener(this);
        this.I0.setOnLoadMoreListener(this);
        this.I0.setEnableLoadMore(false);
        L2(0);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void h() {
        if (this.S0) {
            return;
        }
        L2(0);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    @SuppressLint({"NotifyDataSetChanged"})
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GridLayoutManager gridLayoutManager = this.K0;
        if (gridLayoutManager != null) {
            gridLayoutManager.e3(w2());
            VideoItemAdapter videoItemAdapter = this.I0;
            if (videoItemAdapter != null) {
                videoItemAdapter.notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        T t;
        try {
            Video video = (Video) this.I0.getItem(i2);
            if (video != null && (t = video.t) != 0) {
                JSONObject jSONObject = (JSONObject) t;
                String strTrim = jSONObject.optString(SocialConstants.PARAM_URL).trim();
                if (TextUtils.isEmpty(strTrim)) {
                    h2("教程链接暂不可用");
                    return;
                }
                Intent intent = new Intent(q(), (Class<?>) WebAct.class);
                intent.putExtra(SocialConstants.PARAM_URL, strTrim);
                intent.putExtra("title", jSONObject.optString("label"));
                P1(intent);
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            h2("教程打开失败，请稍后重试");
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
        if (!this.S0 && this.T0 && TextUtils.isEmpty(this.U0)) {
            L2(this.R0 + 1);
        }
    }
}
