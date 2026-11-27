package com.v;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.ArgumentKeyValueAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.v.ArgumentKeyValueDialog;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ArgumentDialogView extends RelativeLayout implements View.OnClickListener {
    private Task c;
    private ArgumentKeyValueAdapter d;

    public ArgumentDialogView(Context context) {
        super(context);
    }

    private View a() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.z0, null);
        viewInflate.findViewById(j.b.e.O0).setVisibility(8);
        TextView textView = (TextView) viewInflate.findViewById(j.b.e.v6);
        textView.setText("添加参数");
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.f(view);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(JSONObject jSONObject) {
        this.d.addData((ArgumentKeyValueAdapter) jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        com.frame.s0.g().i(NodeListDialogView.class);
        ArgumentKeyValueDialog argumentKeyValueDialog = (ArgumentKeyValueDialog) com.frame.s0.g().B(ArgumentKeyValueDialog.class);
        argumentKeyValueDialog.l("参数设置");
        argumentKeyValueDialog.F(new ArgumentKeyValueDialog.a() { // from class: com.v.o1
            @Override // com.v.ArgumentKeyValueDialog.a
            public final void a(JSONObject jSONObject) {
                this.a.d(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(int i2, JSONObject jSONObject) {
        this.d.setData(i2, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
        JSONObject item = this.d.getItem(i2);
        ArgumentKeyValueDialog argumentKeyValueDialog = (ArgumentKeyValueDialog) com.frame.s0.g().B(ArgumentKeyValueDialog.class);
        argumentKeyValueDialog.l("参数设置");
        argumentKeyValueDialog.setDefault(item);
        argumentKeyValueDialog.F(new ArgumentKeyValueDialog.a() { // from class: com.v.m1
            @Override // com.v.ArgumentKeyValueDialog.a
            public final void a(JSONObject jSONObject) {
                this.a.h(i2, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() == j.b.e.O0) {
            this.d.remove(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(List list) {
        this.d.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(Task task) {
        if (TextUtils.isEmpty(task.getArgumentJson())) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(task.getArgumentJson());
            final ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(jSONArray.optJSONObject(i2));
            }
            com.frame.l1.e(new Runnable() { // from class: com.v.n1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.n(arrayList);
                }
            });
        } catch (JSONException e) {
            com.frame.k0.r(e);
        }
    }

    public void b() {
        View.inflate(com.frame.v0.g(), j.b.f.f1759j, this);
        findViewById(j.b.e.A).setOnClickListener(this);
        findViewById(j.b.e.B).setOnClickListener(this);
        int i2 = j.b.e.O4;
        this.d = new ArgumentKeyValueAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(i2);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.d);
        this.d.addFooterView(a());
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.r1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.c.j(baseQuickAdapter, view, i3);
            }
        });
        androidx.recyclerview.widget.k0 k0Var = new androidx.recyclerview.widget.k0(new ItemDragAndSwipeCallback(this.d));
        k0Var.j(recyclerView);
        this.d.enableDragItem(k0Var, j.b.e.h1, false);
        this.d.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.v.p1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.c.l(baseQuickAdapter, view, i3);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.b.e.A) {
            com.frame.s0.g().o(this);
            return;
        }
        if (view.getId() == j.b.e.B) {
            try {
                JSONArray jSONArray = new JSONArray();
                List<JSONObject> data = this.d.getData();
                for (int i2 = 0; i2 < data.size(); i2++) {
                    jSONArray.put(data.get(i2));
                }
                this.c.setArgumentJson(jSONArray.toString());
                i.b.da.B().z1(this.c);
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
            com.frame.s0.g().o(this);
        }
    }

    public void setTask(final Task task) {
        this.c = task;
        com.frame.l1.g(new Runnable() { // from class: com.v.l1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.p(task);
            }
        });
    }

    public ArgumentDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ArgumentDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public ArgumentDialogView() {
        super(com.frame.v0.g());
        b();
    }
}
