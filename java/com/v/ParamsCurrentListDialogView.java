package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.ParamsListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yl.float_ui.DingMsgView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ParamsCurrentListDialogView extends RelativeLayout implements View.OnClickListener {
    private ParamsListAdapter c;

    class a implements BaseQuickAdapter.OnItemLongClickListener {
        a() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
        public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            ParamsCurrentListDialogView.this.e(i2);
            return true;
        }
    }

    public ParamsCurrentListDialogView() {
        this(com.frame.v0.g());
    }

    private void a() {
        View.inflate(com.frame.v0.g(), j.b.f.f, this);
        setGravity(17);
        ((TextView) findViewById(j.b.e.w6)).setText("当前变量");
        this.c = new ParamsListAdapter(new ArrayList(i.b.da.B().E()));
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.c);
        TextView textView = (TextView) findViewById(j.b.e.g);
        textView.setOnClickListener(this);
        textView.setText("重置");
        textView.setVisibility(0);
        TextView textView2 = (TextView) findViewById(j.b.e.P);
        textView2.setOnClickListener(this);
        textView2.setText("取消");
        TextView textView3 = new TextView(com.frame.v0.g());
        textView3.setText("无内容~");
        textView3.setGravity(17);
        textView3.setTextColor(com.frame.v0.g().getResources().getColor(j.b.c.d));
        this.c.setEmptyView(textView3);
        this.c.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.bj
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                ParamsCurrentListDialogView.b(baseQuickAdapter, view, i2);
            }
        });
        this.c.setOnItemLongClickListener(new a());
    }

    static /* synthetic */ void b(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(int i2, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        String item = this.c.getItem(i2);
        this.c.remove(i2);
        i.b.da.B().E1(item, "");
    }

    public void e(final int i2) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h(String.format("是否重置『%s』变量？", this.c.getItem(i2)));
        dingMsgView.i("取消", null);
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.d(i2, view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().d(ParamsCurrentListDialogView.class);
        } else if (id == j.b.e.g) {
            com.frame.s0.g().d(ParamsCurrentListDialogView.class);
            i.b.da.B().J1();
            com.yl.ui.i0.l(null);
        }
    }

    public ParamsCurrentListDialogView(Context context) {
        this(context, null);
    }

    public ParamsCurrentListDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
