package com.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import com.yl.model.ImageBox;
import java.util.List;

/* loaded from: classes.dex */
public class ImageBoxAdapter extends BaseItemDraggableAdapter<ImageBox, BaseViewHolder> {
    private int a;

    public ImageBoxAdapter(List<ImageBox> list) {
        super(j.b.f.G0, list);
    }

    public void c(int i2) {
        this.a = i2;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, ImageBox imageBox) {
        baseViewHolder.setText(j.b.e.n6, imageBox.name);
        int[] iArr = {j.b.e.J3, j.b.e.K3, j.b.e.L3};
        if (imageBox.urls != null) {
            for (int i2 = 0; i2 < 3; i2++) {
                if (i2 < imageBox.urls.size()) {
                    com.bumptech.glide.c.t(v0.g()).w(imageBox.urls.get(i2)).q0((ImageView) baseViewHolder.getView(iArr[i2]));
                }
            }
        }
        baseViewHolder.setBackgroundColor(j.b.e.t3, v0.g().getResources().getColor(this.a == baseViewHolder.getLayoutPosition() ? j.b.c.e : j.b.c.a));
    }

    public int e() {
        return this.a;
    }
}
