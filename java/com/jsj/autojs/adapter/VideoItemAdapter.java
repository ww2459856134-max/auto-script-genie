package com.jsj.autojs.adapter;

import android.text.TextUtils;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jsj.autojs.model.Video;
import com.tencent.cursor.R;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VideoItemAdapter extends BaseSectionQuickAdapter<Video, BaseViewHolder> {
    public VideoItemAdapter(List<Video> list) {
        super(2131493095, 2131493096, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Video video) {
        JSONObject jSONObject = (JSONObject) video.t;
        String strTrim = jSONObject.optString("label").trim();
        String strTrim2 = jSONObject.optString("descr").trim();
        if (TextUtils.isEmpty(strTrim)) {
            strTrim = "未命名教程";
        }
        baseViewHolder.setText(R.id.tv_title, strTrim);
        baseViewHolder.setText(R.id.tv_content, strTrim2);
        baseViewHolder.setGone(R.id.tv_content, !TextUtils.isEmpty(strTrim2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseSectionQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convertHead(BaseViewHolder baseViewHolder, Video video) {
        baseViewHolder.setText(2131297175, video.header);
    }
}
