package com.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yl.model.TaskSimple;

/* loaded from: classes.dex */
public class TaskSearchAdapter extends BaseItemDraggableAdapter<TaskSimple, BaseViewHolder> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, TaskSimple taskSimple) {
        ((TextView) baseViewHolder.getView(j.b.e.m6)).setText(taskSimple.getName());
        baseViewHolder.setGone(j.b.e.k6, false);
    }
}
