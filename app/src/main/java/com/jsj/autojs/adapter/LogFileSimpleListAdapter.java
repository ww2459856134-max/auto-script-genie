package com.jsj.autojs.adapter;

import android.text.format.Formatter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import com.tencent.cursor.R;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class LogFileSimpleListAdapter extends BaseQuickAdapter<File, BaseViewHolder> {
    private boolean a;
    private HashMap<Integer, File> b;

    public LogFileSimpleListAdapter(List<File> list) {
        super(2131493107, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, File file) {
        baseViewHolder.setText(R.id.tv_title, file.getName());
        baseViewHolder.setText(2131297278, Formatter.formatFileSize(v0.g(), file.length()));
        if (!this.a) {
            baseViewHolder.setGone(2131296546, false);
        } else {
            baseViewHolder.setVisible(2131296546, true);
            baseViewHolder.getView(2131296546).setSelected(this.b.containsKey(Integer.valueOf(baseViewHolder.getAdapterPosition())));
        }
    }

    public void d(boolean z) {
        this.a = z;
        if (z) {
            this.b = new HashMap<>();
        }
    }
}
