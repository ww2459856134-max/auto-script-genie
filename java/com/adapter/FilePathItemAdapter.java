package com.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class FilePathItemAdapter extends BaseQuickAdapter<File, BaseViewHolder> {
    public FilePathItemAdapter(List<File> list) {
        super(j.b.f.l0, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, File file) {
        TextView textView = (TextView) baseViewHolder.getView(j.b.e.n6);
        textView.setText(file.getName());
        boolean z = getData().size() - 1 == baseViewHolder.getAdapterPosition();
        textView.setSelected(z);
        baseViewHolder.setGone(j.b.e.y1, !z);
    }
}
