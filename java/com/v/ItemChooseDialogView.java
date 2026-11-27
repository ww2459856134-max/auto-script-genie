package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.ItemAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ItemChooseDialogView extends FrameLayout implements View.OnClickListener {
    private b c;
    private ItemAdapter d;

    class a implements BaseQuickAdapter.OnItemClickListener {
        a() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            if (ItemChooseDialogView.this.d.g()) {
                ItemChooseDialogView.this.d.i(i2);
                return;
            }
            ItemChooseDialogView.this.d.c(i2);
            if (ItemChooseDialogView.this.c != null) {
                ItemChooseDialogView.this.c.a(ItemChooseDialogView.this.d.e(), ItemChooseDialogView.this.d.getData());
            }
        }
    }

    public interface b {
        void a(int i2, List<String> list);
    }

    public ItemChooseDialogView() {
        this(com.frame.v0.g());
    }

    private void d() {
        View.inflate(com.frame.v0.g(), j.b.f.f, this);
        findViewById(j.b.e.u4).setVisibility(8);
        this.d = new ItemAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.d);
        findViewById(j.b.e.P).setOnClickListener(this);
        int i2 = j.b.e.g;
        findViewById(i2).setOnClickListener(this);
        TextView textView = (TextView) findViewById(i2);
        textView.setVisibility(8);
        textView.setText("确定");
        this.d.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.v.ib
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.c.f(baseQuickAdapter, view, i3);
            }
        });
        TextView textView2 = new TextView(com.frame.v0.g());
        textView2.setText("还未添文案~");
        textView2.setGravity(17);
        textView2.setTextColor(com.frame.v0.g().getResources().getColor(j.b.c.d));
        this.d.setOnItemClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() == j.b.e.O0) {
            i.b.i7.p().k().remove(this.d.getItem(i2));
            this.d.remove(i2);
            i.b.i7.p().d();
        }
    }

    public void c(View view) {
        ((RelativeLayout) findViewById(j.b.e.w4)).addView(view);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().d(ItemChooseDialogView.class);
            return;
        }
        if (id == j.b.e.g) {
            com.frame.s0.g().d(ItemChooseDialogView.class);
            if (this.c != null) {
                if (this.d.g()) {
                    this.c.a(0, new ArrayList(this.d.f().values()));
                } else {
                    this.c.a(this.d.e(), this.d.getData());
                }
            }
        }
    }

    public void setCheckable() {
        this.d.h(true);
        ((TextView) findViewById(j.b.e.g)).setVisibility(0);
    }

    public void setDefaultData(int i2, List<String> list) {
        this.d.setNewData(list);
        this.d.c(i2);
    }

    public void setMultiDefaultData(List<String> list, List<String> list2) {
        this.d.setNewData(list);
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            int iIndexOf = list.indexOf(it.next());
            if (iIndexOf != -1) {
                this.d.i(iIndexOf);
            }
        }
    }

    public void setOnItemLongClickListener(BaseQuickAdapter.OnItemLongClickListener onItemLongClickListener) {
        this.d.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void setOnTextChoose(b bVar) {
        this.c = bVar;
    }

    public void setTitle(String str) {
        TextView textView = (TextView) findViewById(j.b.e.w6);
        textView.setText(str);
        textView.setVisibility(0);
        findViewById(j.b.e.u4).setVisibility(0);
    }

    public ItemChooseDialogView(Context context) {
        this(context, null);
    }

    public ItemChooseDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public void setDefaultData(int i2) {
        this.d.c(i2);
    }
}
