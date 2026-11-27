package com.jsj.autojs.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jsj.autojs.adapter.AppSkipAdLisAdapter;
import com.jsj.autojs.model.AppConfig;
import com.tencent.cursor.R;
import com.yl.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
public class A73ee1fe7ab extends com.yl.ui.p implements TextWatcher, BaseQuickAdapter.OnItemClickListener, SwipeRefreshLayout.j {
    private AppSkipAdLisAdapter P;
    private String Q;
    private RecyclerView U;
    private String V;
    private List<String> W;
    private SwipeRefreshLayout Z;
    private HashMap<String, AppConfig> a0;
    boolean b0 = false;

    class a implements TextView.OnEditorActionListener {
        a(A73ee1fe7ab a73ee1fe7ab) {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            return true;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                List<ResolveInfo> listB = i.b.g8.d().b();
                if (TextUtils.isEmpty(A73ee1fe7ab.this.Q)) {
                    A73ee1fe7ab.this.P.setNewData(listB);
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < listB.size(); i2++) {
                        try {
                            String string = listB.get(i2).activityInfo.applicationInfo.loadLabel(A73ee1fe7ab.this.getPackageManager()).toString();
                            if (!TextUtils.isEmpty(string) && string.contains(A73ee1fe7ab.this.Q)) {
                                arrayList.add(listB.get(i2));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (arrayList.size() <= 0) {
                        A73ee1fe7ab.this.Y("未找到应用");
                    }
                    A73ee1fe7ab.this.P.setNewData(arrayList);
                }
                A73ee1fe7ab.this.P.notifyDataSetChanged();
                A73ee1fe7ab.this.b0 = false;
            } catch (Exception e2) {
                com.frame.k0.r(e2);
            }
        }
    }

    static /* synthetic */ void B0(DialogInterface dialogInterface) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D0(List list) {
        this.P.setNewData(list);
        i.b.g8.d().f(list);
        this.P.notifyDataSetChanged();
        this.Z.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F0() {
        final List<ResolveInfo> listC = i.b.g8.d().c(com.frame.v0.g());
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.b3
            @Override // java.lang.Runnable
            public final void run() {
                this.c.D0(listC);
            }
        });
    }

    private void m0() {
        if (this.a0.isEmpty()) {
            g0(null, null);
        } else {
            g0("清空设置", new View.OnClickListener() { // from class: com.jsj.autojs.activity.d3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.r0(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0(DialogInterface dialogInterface, int i2) {
        Iterator<String> it = this.a0.keySet().iterator();
        while (it.hasNext()) {
            com.jsj.autojs.l.x.e().c(this.a0.get(it.next()));
        }
        this.a0.clear();
        this.P.notifyDataSetChanged();
        com.jsj.autojs.l.x.e().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(View view) {
        s.a aVar = new s.a(com.frame.v0.g().d());
        aVar.g(2131231019);
        aVar.m("取消", null);
        aVar.r("确定", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.f3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.p0(dialogInterface, i2);
            }
        });
        aVar.j("是否清空所有应用护眼色");
        aVar.t("温馨提示");
        aVar.e().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(List list) {
        m0();
        this.P = new AppSkipAdLisAdapter(list, this.a0);
        this.U.setLayoutManager(new LinearLayoutManager(this));
        this.P.setOnItemClickListener(this);
        this.P.d(this.W);
        this.U.setAdapter(this.P);
        if (TextUtils.isEmpty(this.V) || this.U.getLayoutManager() == null) {
            return;
        }
        try {
            this.U.getLayoutManager().v1(n0(list, this.V));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w0() {
        this.a0 = com.jsj.autojs.l.x.e().g();
        final List<ResolveInfo> listB = i.b.g8.d().b();
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.g3
            @Override // java.lang.Runnable
            public final void run() {
                this.c.u0(listB);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0(AppConfig appConfig, EditText editText, EditText editText2, boolean z, BaseQuickAdapter baseQuickAdapter, int i2, DialogInterface dialogInterface, int i3) {
        try {
            appConfig.setDuration((int) (Float.parseFloat(editText.getText().toString()) * 1000.0f));
        } catch (Exception unused) {
            Y("检测时长请输入数字");
        }
        appConfig.setSkipAdText(editText2.getText().toString());
        if (z) {
            this.a0.put(appConfig.getPackageName(), appConfig);
            com.jsj.autojs.l.x.e().a(appConfig);
        }
        com.jsj.autojs.l.x.e().h();
        baseQuickAdapter.notifyItemChanged(i2);
        com.yl.ui.i0.k(this, null);
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A0(AppConfig appConfig, DialogInterface dialogInterface, int i2) {
        com.jsj.autojs.l.x.e().c(appConfig);
        this.a0.remove(appConfig.getPackageName());
        m0();
        this.P.notifyDataSetChanged();
        com.jsj.autojs.l.x.e().h();
    }

    void G0() {
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.a3
            @Override // java.lang.Runnable
            public final void run() {
                this.c.w0();
            }
        });
    }

    public void H0() {
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.i3
            @Override // java.lang.Runnable
            public final void run() {
                this.c.F0();
            }
        });
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492894;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.Q = editable.toString();
        if (this.b0) {
            return;
        }
        this.b0 = true;
        com.frame.l1.f(new b(), 500L);
    }

    @Override // com.yl.ui.p
    public void b0() throws Resources.NotFoundException {
        j0("全局去广告");
        getIntent().getBooleanExtra("isCheck", true);
        EditText editText = (EditText) findViewById(2131296597);
        Drawable drawable = getResources().getDrawable(2131231154);
        drawable.setBounds(0, 0, 40, 40);
        editText.setCompoundDrawables(drawable, null, null, null);
        editText.addTextChangedListener(this);
        editText.setOnEditorActionListener(new a(this));
        Intent intent = getIntent();
        intent.getIntExtra("maxCount", 10);
        intent.getStringExtra("title");
        this.V = intent.getStringExtra("packageName");
        this.W = intent.getStringArrayListExtra("selectedPackageNames");
        this.U = (RecyclerView) findViewById(2131296878);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(2131297080);
        this.Z = swipeRefreshLayout;
        swipeRefreshLayout.setEnabled(true);
        this.Z.setOnRefreshListener(this);
        G0();
        if (!com.frame.w0.d()) {
            com.permission.x0.m().a();
        }
        if (com.frame.n0.a("first_skip_ad", true)) {
            s.a aVar = new s.a(this);
            aVar.r("知道了", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.j3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    com.frame.n0.g("first_skip_ad", false);
                }
            });
            aVar.j("我们研发【去广告】功能，是为了给大家提供一个干净的用机体验，开启后能自动跳过各APP开屏广告。");
            aVar.t("温馨提示");
            aVar.e().show();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void h() {
        H0();
    }

    public int n0(List<ResolveInfo> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (str.equals(list.get(i2).activityInfo.packageName)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(final BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
        final boolean z;
        final AppConfig appConfig;
        PackageManager packageManager = com.frame.v0.g().getPackageManager();
        ApplicationInfo applicationInfo = ((ResolveInfo) baseQuickAdapter.getItem(i2)).activityInfo.applicationInfo;
        Drawable drawableLoadIcon = applicationInfo.loadIcon(packageManager);
        String string = applicationInfo.loadLabel(packageManager).toString();
        AppConfig appConfigD = com.jsj.autojs.l.x.e().d(applicationInfo.packageName);
        if (appConfigD == null) {
            AppConfig appConfig2 = new AppConfig();
            appConfig2.setPackageName(applicationInfo.packageName);
            appConfig2.setSkipAdText("跳过");
            appConfig2.setDuration(5000);
            appConfig2.setSkipAd(true);
            appConfig = appConfig2;
            z = true;
        } else {
            z = false;
            appConfig = appConfigD;
        }
        View viewInflate = View.inflate(com.frame.v0.g(), 2131492941, null);
        final EditText editText = (EditText) viewInflate.findViewById(2131296590);
        final EditText editText2 = (EditText) viewInflate.findViewById(2131296592);
        editText.setText(appConfig.getSkipAdText());
        editText2.setText((appConfig.getDuration() / XmlValidationError.INCORRECT_ATTRIBUTE) + "");
        try {
            s.a aVar = new s.a(this);
            final AppConfig appConfig3 = appConfig;
            aVar.r("确定", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.e3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.c.y0(appConfig3, editText2, editText, z, baseQuickAdapter, i2, dialogInterface, i3);
                }
            });
            aVar.m("清除设置", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.h3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.c.A0(appConfig, dialogInterface, i3);
                }
            });
            aVar.o(new DialogInterface.OnCancelListener() { // from class: com.jsj.autojs.activity.c3
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    A73ee1fe7ab.B0(dialogInterface);
                }
            });
            aVar.u(viewInflate);
            aVar.h(drawableLoadIcon);
            aVar.t(string);
            aVar.g(R.drawable.great_icon);
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
