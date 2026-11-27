package com.adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.k0;
import com.frame.v0;
import com.v.ColorView;
import com.yl.model.ImageBox;
import com.yl.model.Node;
import i.b.b8;
import i.b.da;
import i.b.v8;
import java.util.List;

/* loaded from: classes.dex */
public class LogicJumpNodeAdapter extends BaseItemDraggableAdapter<Node, BaseViewHolder> {
    public LogicJumpNodeAdapter(List<Node> list) {
        super(j.b.f.O0, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Node node) {
        if (node == null) {
            return;
        }
        baseViewHolder.addOnClickListener(j.b.e.v6);
        baseViewHolder.setGone(j.b.e.J3, false);
        baseViewHolder.setGone(j.b.e.K3, false);
        baseViewHolder.setGone(j.b.e.L3, false);
        baseViewHolder.setGone(j.b.e.R1, true);
        int i2 = j.b.e.g6;
        baseViewHolder.setGone(i2, true);
        TextView textView = (TextView) baseViewHolder.getView(i2);
        textView.setHintTextColor(v0.g().getColor(j.b.c.f));
        textView.setHint("设置跳转");
        try {
            int i3 = node.nextType;
            if (i3 == 2) {
                textView.setText("跳下个节点");
                textView.setHintTextColor(v0.g().getColor(j.b.c.c));
            } else if (i3 == 3) {
                textView.setText("跳节点：" + v8.m().p().getNodeMap().get(Long.valueOf(node.nextId)).getStepAndName());
                textView.setHintTextColor(v0.g().getColor(j.b.c.c));
            } else if (i3 == -3) {
                textView.setText("结束任务");
            } else if (i3 == -4) {
                textView.setText("结束子任务/循环");
            } else if (i3 == 12) {
                textView.setText("点击后跳任务：" + da.B().w(node.nextTaskId).getName());
                textView.setHintTextColor(v0.g().getColor(j.b.c.c));
            } else if (i3 == 0) {
                textView.setText("点击后跳下个节点");
                textView.setHintTextColor(v0.g().getColor(j.b.c.c));
            } else if (i3 == 13) {
                textView.setText("点击后跳节点：" + v8.m().p().getNodeMap().get(Long.valueOf(node.nextId)).getStepAndName());
                textView.setHintTextColor(v0.g().getColor(j.b.c.c));
            } else if (i3 == 4) {
                textView.setText("跳任务：" + da.B().w(node.nextTaskId).getName());
                textView.setHintTextColor(v0.g().getColor(j.b.c.c));
            }
        } catch (Exception e) {
            k0.r(e);
        }
        int i4 = node.type;
        if ((i4 == 3 || i4 == 22) && !TextUtils.isEmpty(node.url)) {
            int i5 = j.b.e.R1;
            com.bumptech.glide.c.t(v0.g()).w(node.url).q0((ImageView) baseViewHolder.getView(i5));
            baseViewHolder.setText(j.b.e.v6, TextUtils.isEmpty(node.name) ? "有该图片" : node.name);
            baseViewHolder.setGone(j.b.e.S3, false);
            if (node.url.startsWith("1")) {
                int i6 = j.b.e.J3;
                baseViewHolder.setGone(i6, true);
                int i7 = j.b.e.K3;
                baseViewHolder.setGone(i7, true);
                int i8 = j.b.e.L3;
                baseViewHolder.setGone(i8, true);
                baseViewHolder.setVisible(i5, false);
                int[] iArr = {i6, i7, i8};
                ImageBox imageBoxA = b8.c().a(Long.valueOf(node.url).longValue());
                if (imageBoxA.urls != null) {
                    for (int i9 = 0; i9 < 3; i9++) {
                        if (i9 < imageBoxA.urls.size()) {
                            com.bumptech.glide.c.t(v0.g()).w(imageBoxA.urls.get(i9)).q0((ImageView) baseViewHolder.getView(iArr[i9]));
                        }
                    }
                }
            }
        } else {
            int i10 = node.type;
            if (i10 == 24) {
                baseViewHolder.setImageResource(j.b.e.R1, j.b.d.c0);
                baseViewHolder.setGone(j.b.e.S3, false);
                baseViewHolder.setText(j.b.e.v6, TextUtils.isEmpty(node.name) ? "变量判断" : node.name);
            } else if (i10 == 13) {
                baseViewHolder.setGone(j.b.e.R1, false);
                baseViewHolder.setGone(j.b.e.S3, true);
                ColorView colorView = (ColorView) baseViewHolder.getView(j.b.e.s1);
                ColorView colorView2 = (ColorView) baseViewHolder.getView(j.b.e.t1);
                ColorView colorView3 = (ColorView) baseViewHolder.getView(j.b.e.u1);
                ColorView colorView4 = (ColorView) baseViewHolder.getView(j.b.e.v1);
                ColorView colorView5 = (ColorView) baseViewHolder.getView(j.b.e.w1);
                if (node.arg1.contains("|")) {
                    String[] strArrSplit = node.arg1.split(",");
                    colorView.setColor(Color.parseColor("#" + strArrSplit[0]));
                    ColorView[] colorViewArr = {colorView, colorView2, colorView3, colorView4, colorView5};
                    for (int i11 = 1; i11 < strArrSplit.length; i11++) {
                        String[] strArrSplit2 = strArrSplit[i11].split("\\|");
                        colorViewArr[i11].setColor(Color.parseColor("#" + strArrSplit2[2]));
                    }
                } else {
                    colorView.setColor(Color.parseColor("#" + node.arg1));
                }
                baseViewHolder.setText(j.b.e.v6, TextUtils.isEmpty(node.name) ? "有该颜色" : node.name);
            } else {
                baseViewHolder.setImageResource(j.b.e.R1, j.b.d.a0);
                baseViewHolder.setGone(j.b.e.S3, false);
                baseViewHolder.setText(j.b.e.v6, node.getName());
            }
        }
        baseViewHolder.addOnClickListener(j.b.e.O0);
        baseViewHolder.addOnClickListener(j.b.e.g6);
    }
}
