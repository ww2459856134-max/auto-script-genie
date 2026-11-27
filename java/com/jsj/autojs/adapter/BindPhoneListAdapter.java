package com.jsj.autojs.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.m1;
import com.jsj.autojs.model.UserModel;
import com.tencent.cursor.R;
import java.util.List;

/* loaded from: classes.dex */
public class BindPhoneListAdapter extends BaseQuickAdapter<UserModel.ContentBean, BaseViewHolder> {
    public BindPhoneListAdapter(List<UserModel.ContentBean> list) {
        super(2131492932, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, UserModel.ContentBean contentBean) {
        baseViewHolder.setText(R.id.tv_title, contentBean.getName());
        try {
            if (contentBean.getVipEndTime() == null) {
                baseViewHolder.setText(2131297218, "未开通会员");
            } else if (m1.e(contentBean.getVipEndTime(), "yyyy-MM-dd HH:mm") > System.currentTimeMillis() + 1827387392) {
                baseViewHolder.setText(2131297218, "超级会员");
            } else {
                baseViewHolder.setText(2131297218, "vip有效时间：" + contentBean.getVipEndTime());
            }
            baseViewHolder.setText(2131297278, "");
            baseViewHolder.setText(2131297193, "最近登录：" + contentBean.getLastLoginTime());
            baseViewHolder.setText(2131297189, contentBean.isActive() ? "已激活" : "未激活");
            baseViewHolder.setText(2131297169, "用户id:" + contentBean.getId());
            baseViewHolder.setGone(2131297169, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
