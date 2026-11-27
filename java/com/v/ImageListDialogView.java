package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.ImageListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.v.ItemChooseDialogView;
import com.yl.float_ui.DingMsgView;
import com.yl.model.ImageBox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/* loaded from: classes.dex */
public class ImageListDialogView extends RelativeLayout implements View.OnClickListener {
    private ImageListAdapter c;

    class a implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ androidx.recyclerview.widget.k0 a;

        a(androidx.recyclerview.widget.k0 k0Var) {
            this.a = k0Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ImageListDialogView.this.c.enableDragItem(z ? this.a : null);
        }
    }

    class b implements BaseQuickAdapter.OnItemLongClickListener {
        final /* synthetic */ CheckBox c;

        b(CheckBox checkBox) {
            this.c = checkBox;
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
        public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            if (this.c.isChecked()) {
                return false;
            }
            ImageListDialogView.this.n(i2);
            return true;
        }
    }

    public interface c {
    }

    public ImageListDialogView() {
        this(com.frame.v0.g());
    }

    private void c(final int i2) {
        final List<ImageBox> listB = i.b.b8.c().b();
        List<String> list = (List) listB.stream().map(new Function() { // from class: com.v.ga
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImageBox) obj).name;
            }
        }).collect(Collectors.toList());
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("操作菜单");
        itemChooseDialogView.setDefaultData(-1, list);
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.ca
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i3, List list2) {
                this.a.g(listB, i2, i3, list2);
            }
        });
    }

    private void d() {
        View.inflate(com.frame.v0.g(), j.b.f.C, this);
        setGravity(17);
        ((TextView) findViewById(j.b.e.w6)).setText("图片列表");
        CheckBox checkBox = (CheckBox) findViewById(j.b.e.o1);
        this.c = new ImageListAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setLayoutManager(new GridLayoutManager(com.frame.v0.g(), 3));
        recyclerView.setAdapter(this.c);
        androidx.recyclerview.widget.k0 k0Var = new androidx.recyclerview.widget.k0(new ItemDragAndSwipeCallback(this.c));
        k0Var.j(recyclerView);
        checkBox.setOnCheckedChangeListener(new a(k0Var));
        TextView textView = (TextView) findViewById(j.b.e.g);
        textView.setOnClickListener(this);
        textView.setText("确定");
        textView.setVisibility(8);
        TextView textView2 = (TextView) findViewById(j.b.e.P);
        textView2.setOnClickListener(this);
        textView2.setText("取消");
        TextView textView3 = new TextView(com.frame.v0.g());
        textView3.setText("无内容~");
        textView3.setGravity(17);
        textView3.setTextColor(com.frame.v0.g().getResources().getColor(j.b.c.d));
        this.c.setEmptyView(textView3);
        this.c.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.ea
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.i(baseQuickAdapter, view, i2);
            }
        });
        this.c.setOnItemLongClickListener(new b(checkBox));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(List list, int i2, int i3, List list2) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        ((ImageBox) list.get(i3)).urls.add(this.c.getItem(i2));
        com.yl.ui.i0.l(null);
        i.b.b8.c().d(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        this.c.c(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(int i2, int i3, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (i3 == 0) {
            c(i2);
        } else {
            if (i3 != 1) {
                return;
            }
            o(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(int i2, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        this.c.remove(i2);
        i.b.b8.c().d(i.b.b8.c().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final int i2) {
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("操作菜单");
        itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("复制到其他图集中,删除图片".split(","))));
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.da
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i3, List list) {
                this.a.k(i2, i3, list);
            }
        });
    }

    public void o(final int i2) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("是否确认删除？");
        dingMsgView.i("取消", null);
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.fa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.m(i2, view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().d(ImageListDialogView.class);
        } else if (id == j.b.e.g) {
            com.frame.s0.g().d(ImageListDialogView.class);
        }
    }

    public void setDefaultData(int i2, List<String> list) {
        this.c.setNewData(list);
        this.c.c(i2);
    }

    public void setOnNodeChoose(c cVar) {
    }

    public ImageListDialogView(Context context) {
        this(context, null);
    }

    public ImageListDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public void setDefaultData(int i2) {
        this.c.c(i2);
    }
}
