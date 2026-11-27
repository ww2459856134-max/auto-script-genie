package com.adapter;

import android.text.TextUtils;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v.ColorView;
import com.yl.model.FloatButtonConfig;
import com.yl.model.TaskSimple;
import i.b.da;
import i.b.g8;
import java.util.List;

/* loaded from: classes.dex */
public class FloatButtonAdapter extends BaseItemDraggableAdapter<FloatButtonConfig, BaseViewHolder> {
    public FloatButtonAdapter(List<FloatButtonConfig> list) {
        super(j.b.f.E0, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, FloatButtonConfig floatButtonConfig) {
        TaskSimple taskSimpleW = da.B().w(floatButtonConfig.taskId);
        baseViewHolder.setText(j.b.e.n6, taskSimpleW == null ? "未知" : taskSimpleW.getName());
        if (TextUtils.isEmpty(floatButtonConfig.appPn)) {
            baseViewHolder.setText(j.b.e.g6, "全局显示");
        } else {
            baseViewHolder.setText(j.b.e.g6, "仅" + g8.d().e(floatButtonConfig.appPn) + "显示");
        }
        ((ColorView) baseViewHolder.getView(j.b.e.Q1)).setColor(floatButtonConfig.color);
        int i2 = j.b.e.k1;
        baseViewHolder.getView(i2).setSelected(floatButtonConfig.isOpen);
        baseViewHolder.addOnClickListener(i2);
    }
}
