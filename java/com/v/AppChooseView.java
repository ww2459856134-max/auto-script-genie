package com.v;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.adapter.AppLisAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.v.item.RunConditionItem;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AppChooseView extends LinearLayout implements TextWatcher, BaseQuickAdapter.OnItemClickListener, SwipeRefreshLayout.j, View.OnClickListener {
    private Node A;
    boolean C;
    private int D;
    private a G;
    private AppLisAdapter c;
    private String d;
    private RecyclerView e;
    private String f;
    private List<String> g;

    /* renamed from: h, reason: collision with root package name */
    private int f907h;

    /* renamed from: i, reason: collision with root package name */
    private SwipeRefreshLayout f908i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f909j;

    /* renamed from: k, reason: collision with root package name */
    private RunConditionItem f910k;
    private Node t;

    public interface a {
        void a(String str);
    }

    public AppChooseView() throws Resources.NotFoundException {
        super(com.frame.v0.g());
        this.f907h = 1;
        this.f909j = true;
        this.C = false;
        this.D = -1;
        View.inflate(com.frame.v0.g(), j.b.f.n0, this);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(List list) {
        list.size();
        this.c.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(List list) {
        this.c.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i() {
        try {
            final List<ResolveInfo> listB = i.b.g8.d().b();
            if (TextUtils.isEmpty(this.d)) {
                com.frame.l1.e(new Runnable() { // from class: com.v.f1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.f(listB);
                    }
                });
            } else {
                final ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < listB.size(); i2++) {
                    try {
                        String string = listB.get(i2).activityInfo.applicationInfo.loadLabel(com.frame.v0.g().getPackageManager()).toString();
                        if (!TextUtils.isEmpty(string) && string.contains(this.d)) {
                            arrayList.add(listB.get(i2));
                        }
                    } catch (Exception e) {
                        com.frame.k0.r(e);
                    }
                }
                com.frame.l1.e(new Runnable() { // from class: com.v.g1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.d(arrayList);
                    }
                });
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
        this.C = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(List list) {
        this.c = new AppLisAdapter(list, true);
        this.e.setLayoutManager(new GridLayoutManager(com.frame.v0.g(), 5));
        this.c.setOnItemClickListener(this);
        this.c.k(this.g);
        this.e.setAdapter(this.c);
        if (TextUtils.isEmpty(this.f) || this.e.getLayoutManager() == null) {
            return;
        }
        try {
            this.e.getLayoutManager().v1(a(list, this.f));
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m() {
        final List<ResolveInfo> listB = i.b.g8.d().b();
        com.frame.l1.e(new Runnable() { // from class: com.v.i1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.k(listB);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(List list) {
        this.c.setNewData(list);
        i.b.g8.d().f(list);
        this.f908i.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q() {
        final List<ResolveInfo> listC = i.b.g8.d().c(com.frame.v0.g());
        com.frame.l1.e(new Runnable() { // from class: com.v.e1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.o(listC);
            }
        });
    }

    public int a(List<ResolveInfo> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (str.equals(list.get(i2).activityInfo.packageName)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.d = editable.toString();
        if (this.C) {
            return;
        }
        this.C = true;
        com.frame.l1.g(new Runnable() { // from class: com.v.k1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.i();
            }
        });
    }

    public void b() throws Resources.NotFoundException {
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.I2);
        this.f910k = runConditionItem;
        runConditionItem.setAttachView(this);
        EditText editText = (EditText) findViewById(j.b.e.B1);
        Drawable drawable = getResources().getDrawable(j.b.d.G0);
        drawable.setBounds(0, 0, 40, 40);
        editText.setCompoundDrawables(drawable, null, null, null);
        editText.addTextChangedListener(this);
        findViewById(j.b.e.P).setOnClickListener(this);
        findViewById(j.b.e.g).setOnClickListener(this);
        this.e = (RecyclerView) findViewById(j.b.e.O4);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(j.b.e.Z4);
        this.f908i = swipeRefreshLayout;
        swipeRefreshLayout.setEnabled(true);
        this.f908i.setOnRefreshListener(this);
        r();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public a getCallback() {
        return this.G;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void h() {
        s();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != j.b.e.g) {
            if (id == j.b.e.P) {
                com.frame.s0.g().d(getClass());
                return;
            }
            return;
        }
        try {
            if (this.c.d() != null && !this.c.d().isEmpty()) {
                if (this.G != null) {
                    Node node = this.t;
                    if (node != null) {
                        node.setCondition(this.A.getCondition());
                    }
                    this.G.a(TextUtils.join(",", this.c.d()));
                }
                com.frame.s0.g().d(getClass());
                return;
            }
            if (this.f909j) {
                FloatToast.i("请先选择APP~");
                return;
            }
            a aVar = this.G;
            if (aVar != null) {
                aVar.a(null);
            }
            com.frame.s0.g().d(getClass());
        } catch (Exception e) {
            com.frame.k0.r(e);
            FloatToast.i("请先选择APP~");
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (this.c.e(i2)) {
            this.c.l(i2);
            this.D = -1;
        } else {
            int size = this.c.d().size();
            int i3 = this.f907h;
            if (size >= i3) {
                if (i3 == 1) {
                    this.c.d().clear();
                }
                int i4 = this.D;
                if (i4 > -1) {
                    this.c.l(i4);
                    this.c.notifyItemChanged(this.D);
                }
                this.D = i2;
                this.c.j(i2);
            } else {
                this.D = i2;
                this.c.j(i2);
            }
        }
        this.c.notifyItemChanged(i2);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    void r() {
        com.frame.l1.g(new Runnable() { // from class: com.v.j1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.m();
            }
        });
    }

    public void s() {
        com.frame.l1.g(new Runnable() { // from class: com.v.h1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.q();
            }
        });
    }

    public void setCallback(a aVar) {
        this.G = aVar;
    }

    public AppChooseView t(Task task, Node node) {
        this.t = node;
        Gson gson = new Gson();
        Node node2 = (Node) gson.j(gson.s(node), Node.class);
        this.A = node2;
        this.f910k.setTaskNode(task, node2);
        this.f910k.setVisibility(0);
        return this;
    }

    public AppChooseView u(String str) {
        this.f = str;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.add(str);
        AppLisAdapter appLisAdapter = this.c;
        if (appLisAdapter != null) {
            appLisAdapter.k(this.g);
            this.c.notifyDataSetChanged();
        }
        return this;
    }

    public AppChooseView v(boolean z) {
        this.f909j = z;
        return this;
    }

    public AppChooseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f907h = 1;
        this.f909j = true;
        this.C = false;
        this.D = -1;
    }

    public AppChooseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f907h = 1;
        this.f909j = true;
        this.C = false;
        this.D = -1;
    }
}
