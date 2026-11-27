package com.v.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.KeyValueAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v.KeyValueDialog;
import com.v.NodeListDialogView;
import java.util.List;

/* loaded from: classes.dex */
public class KeyValueItem extends BaseItemView {
    private KeyValueAdapter c;
    private TextView d;
    private String e;

    class a implements BaseQuickAdapter.OnItemClickListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(int i2, String str, String str2) {
            KeyValueItem.this.c.setData(i2, str + "=" + str2);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
            String[] strArrSplit = KeyValueItem.this.c.getItem(i2).split("=");
            if (strArrSplit.length < 2) {
                return;
            }
            KeyValueDialog keyValueDialog = (KeyValueDialog) com.frame.s0.g().B(KeyValueDialog.class);
            keyValueDialog.l("参数设置");
            keyValueDialog.setKeyValue(strArrSplit[0], strArrSplit[1]);
            keyValueDialog.r(new KeyValueDialog.a() { // from class: com.v.item.x0
                @Override // com.v.KeyValueDialog.a
                public final void a(String str, String str2) {
                    this.a.b(i2, str, str2);
                }
            });
        }
    }

    class b implements BaseQuickAdapter.OnItemChildClickListener {
        b() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            if (view.getId() == j.b.e.O0) {
                KeyValueItem.this.c.remove(i2);
            }
        }
    }

    public KeyValueItem(Context context) {
        super(context);
        this.e = "添加参数";
    }

    private View d() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.y0, null);
        viewInflate.setId(j.b.e.T1);
        TextView textView = (TextView) viewInflate.findViewById(j.b.e.K5);
        this.d = textView;
        textView.setText(this.e);
        this.d.setGravity(17);
        this.d.setPadding(0, 0, 0, 0);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.item.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.i(view);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(String str, String str2) {
        this.c.addData((KeyValueAdapter) (str + "=" + str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(View view) {
        com.frame.s0.g().i(NodeListDialogView.class);
        KeyValueDialog keyValueDialog = (KeyValueDialog) com.frame.s0.g().B(KeyValueDialog.class);
        keyValueDialog.l(this.e);
        keyValueDialog.r(new KeyValueDialog.a() { // from class: com.v.item.y0
            @Override // com.v.KeyValueDialog.a
            public final void a(String str, String str2) {
                this.a.g(str, str2);
            }
        });
    }

    public void e() {
        View.inflate(getContext(), j.b.f.L0, this);
        int i2 = j.b.e.O4;
        this.c = new KeyValueAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(i2);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.c);
        this.c.addFooterView(d());
        this.c.setOnItemClickListener(new a());
        this.c.setOnItemChildClickListener(new b());
    }

    public void j(String str) {
        this.c.addData((KeyValueAdapter) str);
    }

    public void setBtnAddName(String str) {
        this.e = str;
        this.d.setText(str);
    }

    public void setValue(List<String> list) {
        this.c.setNewData(list);
    }

    @Override // com.v.item.BaseItemView
    public List<String> getValue() {
        return this.c.getData();
    }

    public KeyValueItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = "添加参数";
        e();
    }

    public KeyValueItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.e = "添加参数";
    }
}
