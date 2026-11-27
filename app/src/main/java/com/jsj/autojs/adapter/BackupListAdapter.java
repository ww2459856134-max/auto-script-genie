package com.jsj.autojs.adapter;

import android.text.TextUtils;
import android.text.format.Formatter;
import android.widget.TextView;
import com.auto.exceldeps.log4j.message.StructuredDataId;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import com.jsj.autojs.model.ScriptModel;
import com.tencent.cursor.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class BackupListAdapter extends BaseQuickAdapter<ScriptModel.ContentBean, BaseViewHolder> {
    private boolean a;
    private HashMap<Integer, ScriptModel.ContentBean> b;

    public BackupListAdapter(List<ScriptModel.ContentBean> list) {
        super(2131492932, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, ScriptModel.ContentBean contentBean) {
        baseViewHolder.setText(R.id.tv_title, contentBean.getScriptName());
        if (TextUtils.isEmpty(contentBean.getUpdateTime())) {
            baseViewHolder.setText(2131297218, contentBean.getInsertTime() + "（" + contentBean.getShareUserName() + "）");
        } else {
            baseViewHolder.setText(2131297218, contentBean.getUpdateTime() + "（" + contentBean.getUpdateUserName() + "）");
        }
        if (contentBean.getFileSize() != null) {
            baseViewHolder.setText(2131297278, Formatter.formatFileSize(v0.g(), contentBean.getFileSize().longValue()));
        }
        if (contentBean.getDownloadCount() != null) {
            TextView textView = (TextView) baseViewHolder.getView(2131297278);
            textView.append("\n");
            textView.append("下载次数：" + contentBean.getDownloadCount());
        }
        if (this.a) {
            baseViewHolder.setVisible(2131296546, true);
            baseViewHolder.getView(2131296546).setSelected(this.b.containsKey(Integer.valueOf(baseViewHolder.getAdapterPosition())));
        } else {
            baseViewHolder.setGone(2131296546, false);
        }
        if (!StructuredDataId.RESERVED.equals(contentBean.getPath())) {
            baseViewHolder.setGone(2131297189, false);
        } else {
            baseViewHolder.setText(2131297189, "系统检测违规已冻结");
            baseViewHolder.setGone(2131297189, true);
        }
    }

    public Collection<ScriptModel.ContentBean> d() {
        return this.b.values();
    }

    public void e(boolean z) {
        this.a = z;
        if (z) {
            this.b = new HashMap<>();
        }
    }

    public void f(int i2) {
        if (this.b.containsKey(Integer.valueOf(i2))) {
            this.b.remove(Integer.valueOf(i2));
        } else {
            this.b.put(Integer.valueOf(i2), getItem(i2));
        }
        notifyItemChanged(i2);
    }
}
