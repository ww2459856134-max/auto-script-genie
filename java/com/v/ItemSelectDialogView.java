package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.ItemAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;

/* loaded from: classes.dex */
public class ItemSelectDialogView extends RelativeLayout implements View.OnClickListener {
    private c c;
    private ItemAdapter d;

    class a implements BaseQuickAdapter.OnItemChildClickListener {
        a() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            if (view.getId() == j.b.e.O0) {
                i.b.i7.p().k().remove(ItemSelectDialogView.this.d.getItem(i2));
                ItemSelectDialogView.this.d.remove(i2);
                ItemSelectDialogView.this.d.notifyDataSetChanged();
                i.b.i7.p().d();
            }
        }
    }

    class b implements BaseQuickAdapter.OnItemClickListener {
        b() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            ItemSelectDialogView.this.d.c(i2);
        }
    }

    public interface c {
        void a(int i2, List<String> list);
    }

    public ItemSelectDialogView() {
        this(com.frame.v0.g());
    }

    private void b() {
        View.inflate(com.frame.v0.g(), j.b.f.f, this);
        setGravity(17);
        this.d = new ItemAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.d);
        findViewById(j.b.e.P).setVisibility(8);
        int i2 = j.b.e.g;
        findViewById(i2).setOnClickListener(this);
        ((TextView) findViewById(i2)).setText("确定");
        this.d.setOnItemChildClickListener(new a());
        TextView textView = new TextView(com.frame.v0.g());
        textView.setText("还未添文案~");
        textView.setGravity(17);
        textView.setTextColor(com.frame.v0.g().getResources().getColor(j.b.c.d));
        this.d.setOnItemClickListener(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().d(ItemSelectDialogView.class);
            return;
        }
        if (id == j.b.e.g) {
            com.frame.s0.g().d(ItemSelectDialogView.class);
            c cVar = this.c;
            if (cVar != null) {
                cVar.a(this.d.e(), this.d.getData());
            }
        }
    }

    public void setDefaultData(int i2, List<String> list) {
        this.d.setNewData(list);
        this.d.c(i2);
    }

    public void setOnTextChoose(c cVar) {
        this.c = cVar;
    }

    public ItemSelectDialogView(Context context) {
        this(context, null);
    }

    public ItemSelectDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public void setDefaultData(int i2) {
        this.d.c(i2);
    }
}
