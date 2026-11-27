package com.adapter;

import android.text.TextUtils;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.k0;
import com.yl.model.AlarmTask;
import i.b.i7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class AlarmAdapter extends BaseItemDraggableAdapter<AlarmTask, BaseViewHolder> {
    private String[] a;

    public AlarmAdapter(List<AlarmTask> list) {
        super(j.b.f.z0, list);
        this.a = new String[]{"日", "一", "二", "三", "四", "五", "六"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, AlarmTask alarmTask) {
        baseViewHolder.addOnClickListener(j.b.e.O0).addOnClickListener(j.b.e.i1);
        if (alarmTask.isInterval) {
            try {
                baseViewHolder.setText(j.b.e.v6, alarmTask.getStartTimeStr() + "至" + alarmTask.getEndTimeStr() + " 每" + i7.g(alarmTask.intervalMs));
            } catch (Exception e) {
                k0.r(e);
            }
        } else if (alarmTask.isArea) {
            try {
                baseViewHolder.setText(j.b.e.v6, alarmTask.getStartTimeStr() + "至" + alarmTask.getEndTimeStr());
            } catch (Exception e2) {
                k0.r(e2);
            }
        } else {
            baseViewHolder.setText(j.b.e.v6, alarmTask.time);
        }
        int i2 = j.b.e.i1;
        baseViewHolder.setVisible(i2, true);
        baseViewHolder.getView(i2).setSelected(alarmTask.isOpen);
        baseViewHolder.setGone(j.b.e.y6, true);
        ArrayList arrayList = new ArrayList();
        List<Integer> list = alarmTask.repeat;
        if (list != null) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(this.a[it.next().intValue() - 1]);
            }
        }
        baseViewHolder.setText(j.b.e.y6, TextUtils.join(" ", arrayList));
    }
}
