package com.jsj.autojs.adapter;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.k0;
import com.frame.v0;
import com.jsj.autojs.model.Coupon;
import com.jsj.autojs.model.VipItemModel;
import com.tencent.cursor.R;
import java.util.List;

/* loaded from: classes.dex */
public class VipAdapter extends BaseQuickAdapter<VipItemModel.ContentBean, BaseViewHolder> {
    private int a;
    private Coupon b;
    AssetManager c;
    Typeface d;

    public VipAdapter(List<VipItemModel.ContentBean> list) {
        super(2131493182, list);
        AssetManager assets = v0.g().getAssets();
        this.c = assets;
        this.d = Typeface.createFromAsset(assets, "fonts/SwitzerlandBold2.otf");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, VipItemModel.ContentBean contentBean) {
        baseViewHolder.getView(2131297003).setSelected(this.a == baseViewHolder.getAdapterPosition());
        int[] iArr = {Color.parseColor("#6CB5C7"), Color.parseColor("#E47841"), Color.parseColor("#7BB461")};
        int[] iArr2 = {Color.parseColor("#9CE9EA"), Color.parseColor("#FCC971"), Color.parseColor("#A0E6C4")};
        int adapterPosition = (baseViewHolder.getAdapterPosition() - 1) % 3;
        ((TextView) baseViewHolder.getView(2131297263)).setTypeface(this.d);
        baseViewHolder.setBackgroundRes(2131297003, new int[]{2131231215, 2131231219, 2131231217}[adapterPosition]);
        baseViewHolder.setText(R.id.tv_title, contentBean.getTitle());
        baseViewHolder.setText(2131297218, contentBean.getContent());
        baseViewHolder.setText(2131297263, d(contentBean.getMoney()));
        baseViewHolder.setText(2131297264, "￥" + d(contentBean.getScrMoney()));
        baseViewHolder.setTextColor(2131297264, iArr[adapterPosition]);
        baseViewHolder.setTextColor(2131297263, iArr[adapterPosition]);
        baseViewHolder.setTextColor(2131297196, iArr[adapterPosition]);
        baseViewHolder.setTextColor(2131297218, iArr[adapterPosition]);
        baseViewHolder.setBackgroundRes(2131296340, new int[]{2131231216, 2131231220, 2131231218}[adapterPosition]);
        baseViewHolder.setBackgroundColor(2131297264, iArr2[adapterPosition]);
        baseViewHolder.setGone(2131297264, contentBean.getScrMoney() != 0);
        baseViewHolder.setVisible(2131297282, !TextUtils.isEmpty(contentBean.getTag()));
        ((TextView) baseViewHolder.getView(2131297264)).getPaint().setFlags(16);
        baseViewHolder.setText(2131297282, contentBean.getTag());
        Coupon coupon = this.b;
        if (coupon != null) {
            if (coupon.getVipConfigId() != null) {
                if (!this.b.getVipConfigId().equals(contentBean.getId() + "")) {
                    return;
                }
            }
            try {
                baseViewHolder.getView(2131297282).startAnimation(AnimationUtils.loadAnimation(v0.g(), 2130772016));
                baseViewHolder.setText(2131297282, "优惠券");
                baseViewHolder.setText(2131297263, d(contentBean.getMoney() - this.b.getMoney().longValue()));
            } catch (Exception e) {
                k0.r(e);
            }
        }
    }

    public String d(long j2) {
        return (j2 / 100) + "";
    }

    public void e(Coupon coupon) {
        this.b = coupon;
    }

    public void f(int i2) {
        this.a = i2 + 1;
    }
}
