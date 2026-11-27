package com.jsj.autojs.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.m1;
import com.tencent.cursor.R;
import com.yl.model.TaskSimple;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class RecycleBinAdapter extends BaseQuickAdapter<TaskSimple, BaseViewHolder> {
    private final HashMap<Integer, TaskSimple> a;

    public RecycleBinAdapter(List<TaskSimple> list) {
        super(2131493093, list);
        this.a = new HashMap<>();
    }

    public void c() {
        this.a.clear();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, TaskSimple taskSimple) {
        baseViewHolder.setText(2131297255, taskSimple.getName());
        baseViewHolder.setGone(2131297218, taskSimple.getDeletedAt() > 0);
        if (taskSimple.getDeletedAt() > 0) {
            baseViewHolder.setText(2131297218, "删除于 " + m1.b(taskSimple.getDeletedAt(), "MM-dd HH:mm"));
        }
        baseViewHolder.setVisible(2131296546, true);
        baseViewHolder.setGone(2131296503, false);
        baseViewHolder.setGone(2131296507, false);
        baseViewHolder.setGone(2131296456, false);
        baseViewHolder.setGone(2131296430, false);
        baseViewHolder.setGone(2131296453, false);
        baseViewHolder.setGone(2131296426, false);
        baseViewHolder.setImageResource(R.id.iv_icon, 2131231011);
        baseViewHolder.getView(2131296546).setSelected(this.a.containsKey(Integer.valueOf(baseViewHolder.getAdapterPosition())));
    }

    public List<TaskSimple> e() {
        return new ArrayList(this.a.values());
    }

    public void f(int i2) {
        if (this.a.containsKey(Integer.valueOf(i2))) {
            this.a.remove(Integer.valueOf(i2));
        } else {
            this.a.put(Integer.valueOf(i2), getItem(i2));
        }
        notifyItemChanged(i2);
    }
}
