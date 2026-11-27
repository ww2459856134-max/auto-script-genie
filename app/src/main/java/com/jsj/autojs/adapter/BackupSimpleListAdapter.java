package com.jsj.autojs.adapter;

import android.text.format.Formatter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import com.jsj.autojs.model.ScriptModel;
import com.tencent.cursor.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class BackupSimpleListAdapter extends BaseQuickAdapter<ScriptModel.ContentBean, BaseViewHolder> {
    private boolean a;
    private HashMap<Integer, ScriptModel.ContentBean> b;

    public BackupSimpleListAdapter(List<ScriptModel.ContentBean> list) {
        super(2131492933, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, ScriptModel.ContentBean contentBean) {
        baseViewHolder.setText(R.id.tv_title, contentBean.getScriptName());
        if (contentBean.getFileSize() != null) {
            baseViewHolder.setText(2131297278, Formatter.formatFileSize(v0.g(), contentBean.getFileSize().longValue()));
        }
        if (!this.a) {
            baseViewHolder.setGone(2131296546, false);
        } else {
            baseViewHolder.setVisible(2131296546, true);
            baseViewHolder.getView(2131296546).setSelected(this.b.containsKey(Integer.valueOf(baseViewHolder.getAdapterPosition())));
        }
    }

    public Collection<ScriptModel.ContentBean> d() {
        return this.b.values();
    }

    public void e(boolean z) {
        if (!z) {
            this.b.clear();
            return;
        }
        for (int i2 = 0; i2 < getData().size(); i2++) {
            this.b.put(Integer.valueOf(i2), getData().get(i2));
        }
    }

    public void f(boolean z) {
        this.a = z;
        if (z) {
            this.b = new HashMap<>();
        }
    }

    public void g(int i2) {
        if (this.b.containsKey(Integer.valueOf(i2))) {
            this.b.remove(Integer.valueOf(i2));
        } else {
            this.b.put(Integer.valueOf(i2), getItem(i2));
        }
        notifyItemChanged(i2);
    }
}
