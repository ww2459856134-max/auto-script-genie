package com.jsj.autojs.model;

import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.permission.v0;
import com.tencent.cursor.R;
import java.util.List;

/* loaded from: classes.dex */
public class PermissionAdapter extends BaseQuickAdapter<v0, BaseViewHolder> {
    public PermissionAdapter(List<v0> list) {
        super(2131493082, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, v0 v0Var) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.title);
        TextView textView2 = (TextView) baseViewHolder.getView(2131296577);
        textView.setText(v0Var.a);
        textView2.setText(v0Var.b);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_icon);
        int i2 = v0Var.a;
        if (i2 == 2131558493) {
            imageView.setImageResource(2131231110);
        } else if (i2 == 2131558520) {
            imageView.setImageResource(2131231132);
        } else if (i2 == 2131558497 || i2 == 2131558498 || i2 == 2131558434) {
            imageView.setImageResource(2131231114);
        } else if (i2 == 2131558509) {
            imageView.setImageResource(2131231120);
        } else if (i2 == 2131558500) {
            imageView.setImageResource(2131231125);
        } else if (i2 == 2131558518) {
            imageView.setImageResource(2131231116);
        } else if (i2 == 2131558515) {
            imageView.setImageResource(2131231123);
        } else if (i2 == 2131558505) {
            imageView.setImageResource(2131231119);
        } else if (i2 == 2131558514) {
            imageView.setImageResource(2131231110);
        } else if (i2 == 2131558544) {
            imageView.setImageResource(2131231125);
        } else if (i2 == 2131558502) {
            imageView.setImageResource(2131231116);
        } else if (i2 == 2131558504 || i2 == 2131558537) {
            imageView.setImageResource(2131231113);
        }
        if (v0Var.d == null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131231170, 0);
            textView.setSelected(v0Var.d.booleanValue());
        }
    }
}
