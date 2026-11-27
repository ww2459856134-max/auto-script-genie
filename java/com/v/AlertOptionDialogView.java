package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.ArgumentKeyValueAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.v.ArgumentKeyValueDialog;
import com.v.item.CheckItem;
import com.v.item.InputItem;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.XmlValidationError;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AlertOptionDialogView extends RelativeLayout implements View.OnClickListener {
    private Node c;
    private ArgumentKeyValueAdapter d;
    private InputItem e;
    private InputItem f;
    private CheckItem g;

    /* renamed from: h, reason: collision with root package name */
    private CheckItem f900h;

    /* renamed from: i, reason: collision with root package name */
    private lt f901i;

    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AlertOptionDialogView.this.f.setVisibility(z ? 0 : 8);
        }
    }

    public AlertOptionDialogView(Context context) {
        super(context);
    }

    private View b() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.z0, null);
        viewInflate.findViewById(j.b.e.O0).setVisibility(8);
        TextView textView = (TextView) viewInflate.findViewById(j.b.e.v6);
        textView.setText("添加参数");
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.g(view);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(JSONObject jSONObject) {
        this.d.addData((ArgumentKeyValueAdapter) jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(View view) {
        com.frame.s0.g().i(NodeListDialogView.class);
        ArgumentKeyValueDialog argumentKeyValueDialog = (ArgumentKeyValueDialog) com.frame.s0.g().B(ArgumentKeyValueDialog.class);
        argumentKeyValueDialog.l("参数设置");
        argumentKeyValueDialog.F(new ArgumentKeyValueDialog.a() { // from class: com.v.r0
            @Override // com.v.ArgumentKeyValueDialog.a
            public final void a(JSONObject jSONObject) {
                this.a.e(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i2, JSONObject jSONObject) {
        this.d.setData(i2, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
        JSONObject item = this.d.getItem(i2);
        ArgumentKeyValueDialog argumentKeyValueDialog = (ArgumentKeyValueDialog) com.frame.s0.g().B(ArgumentKeyValueDialog.class);
        argumentKeyValueDialog.l("参数设置");
        argumentKeyValueDialog.setDefault(item);
        argumentKeyValueDialog.F(new ArgumentKeyValueDialog.a() { // from class: com.v.o0
            @Override // com.v.ArgumentKeyValueDialog.a
            public final void a(JSONObject jSONObject) {
                this.a.i(i2, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() == j.b.e.O0) {
            this.d.remove(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o() {
        this.f901i.a(this.c);
    }

    public void c() {
        View.inflate(com.frame.v0.g(), j.b.f.g, this);
        this.g = (CheckItem) findViewById(j.b.e.p1);
        this.f900h = (CheckItem) findViewById(j.b.e.n1);
        this.f = (InputItem) findViewById(j.b.e.j3);
        this.e = (InputItem) findViewById(j.b.e.g2);
        findViewById(j.b.e.A).setOnClickListener(this);
        findViewById(j.b.e.B).setOnClickListener(this);
        int i2 = j.b.e.O4;
        this.d = new ArgumentKeyValueAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(i2);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.d);
        this.d.addFooterView(b());
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.m0
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.c.k(baseQuickAdapter, view, i3);
            }
        });
        androidx.recyclerview.widget.k0 k0Var = new androidx.recyclerview.widget.k0(new ItemDragAndSwipeCallback(this.d));
        k0Var.j(recyclerView);
        this.d.enableDragItem(k0Var, j.b.e.h1, false);
        this.d.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.v.q0
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.c.m(baseQuickAdapter, view, i3);
            }
        });
        this.g.setOnCheckedChangeListener(new a());
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
                this.c.text = this.e.getValue();
                this.c.arg1 = jSONArray.toString();
                this.c.arg2 = this.f900h.getValue().booleanValue() ? "1" : "0";
                if (this.g.getValue().booleanValue()) {
                    this.c.timeOut = Integer.valueOf(this.f.getValue()).intValue() * XmlValidationError.INCORRECT_ATTRIBUTE;
                } else {
                    this.c.timeOut = -1L;
                }
                com.frame.s0.g().d(OcrDialogView.class);
                post(new Runnable() { // from class: com.v.p0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.o();
                    }
                });
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
            com.frame.s0.g().o(this);
        }
    }

    public AlertOptionDialogView p(lt ltVar) {
        this.f901i = ltVar;
        return this;
    }

    public void setTaskNode(Task task, Node node) {
        this.c = node;
        this.e.setValue(node.text);
        this.f900h.setValue("1".equals(node.arg2));
        this.g.setValue(this.c.timeOut > 0);
        this.f.setVisibility(this.g.getValue().booleanValue() ? 0 : 8);
        this.f.setValue(String.valueOf(node.timeOut / 1000));
        try {
            JSONArray jSONArray = new JSONArray(node.arg1);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(jSONArray.optJSONObject(i2));
            }
            this.d.setNewData(arrayList);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public AlertOptionDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlertOptionDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public AlertOptionDialogView() {
        super(com.frame.v0.g());
        c();
    }
}
