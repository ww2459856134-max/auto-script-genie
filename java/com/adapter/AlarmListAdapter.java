package com.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yl.model.AlarmTask;
import java.util.List;

/* loaded from: classes.dex */
public class AlarmListAdapter extends BaseItemDraggableAdapter<AlarmTask, BaseViewHolder> {
    public AlarmListAdapter(List<AlarmTask> list) {
        super(j.b.f.z0, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, AlarmTask alarmTask) {
        baseViewHolder.addOnClickListener(j.b.e.O0);
        baseViewHolder.setText(j.b.e.v6, alarmTask.time);
    }
}
