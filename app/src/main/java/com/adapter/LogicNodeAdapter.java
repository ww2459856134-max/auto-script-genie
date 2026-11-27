package com.adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import com.v.ColorView;
import com.yl.model.ImageBox;
import com.yl.model.Node;
import i.b.b8;
import java.util.List;

/* loaded from: classes.dex */
public class LogicNodeAdapter extends BaseItemDraggableAdapter<Node, BaseViewHolder> {
    public LogicNodeAdapter(List<Node> list) {
        super(j.b.f.O0, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Node node) {
        int i2;
        char c;
        if (node == null) {
            return;
        }
        int i3 = j.b.e.v6;
        baseViewHolder.addOnClickListener(i3);
        int i4 = j.b.e.J3;
        baseViewHolder.setGone(i4, false);
        int i5 = j.b.e.K3;
        baseViewHolder.setGone(i5, false);
        int i6 = j.b.e.L3;
        baseViewHolder.setGone(i6, false);
        int i7 = j.b.e.R1;
        baseViewHolder.setGone(i7, true);
        int i8 = node.type;
        if (i8 == 39) {
            baseViewHolder.setImageResource(i7, j.b.d.a0);
            baseViewHolder.setGone(j.b.e.S3, false);
            baseViewHolder.setText(i3, TextUtils.isEmpty(node.name) ? "未匹配到控件" : "未匹配到控件「" + node.name + "」");
            i2 = 1;
            c = 0;
        } else {
            if ((i8 == 37 || i8 == 40) && !TextUtils.isEmpty(node.url)) {
                com.bumptech.glide.c.t(v0.g()).w(node.url).q0((ImageView) baseViewHolder.getView(i7));
                baseViewHolder.setText(i3, TextUtils.isEmpty(node.name) ? "未匹配到图片" : node.name);
                baseViewHolder.setGone(j.b.e.S3, false);
                int i9 = j.b.e.g6;
                baseViewHolder.setGone(i9, true);
                if (node.areaParam != null) {
                    baseViewHolder.setText(i9, "变量区域识别");
                } else if (node.getArea() == null) {
                    baseViewHolder.setText(i9, "全屏识别(慢)");
                } else if (node.getArea().equals(node.getSrcRect())) {
                    baseViewHolder.setText(i9, "固定坐标识别");
                } else {
                    baseViewHolder.setText(i9, "区域识别");
                }
                if (node.url.startsWith("1")) {
                    baseViewHolder.setGone(i4, true);
                    baseViewHolder.setGone(i5, true);
                    baseViewHolder.setGone(i6, true);
                    baseViewHolder.setVisible(i7, false);
                    int[] iArr = {i4, i5, i6};
                    ImageBox imageBoxA = b8.c().a(Long.valueOf(node.url).longValue());
                    if (imageBoxA.urls != null) {
                        for (int i10 = 0; i10 < 3; i10++) {
                            if (i10 < imageBoxA.urls.size()) {
                                com.bumptech.glide.c.t(v0.g()).w(imageBoxA.urls.get(i10)).q0((ImageView) baseViewHolder.getView(iArr[i10]));
                            }
                        }
                    }
                }
            } else {
                int i11 = node.type;
                if ((i11 == 3 || i11 == 22) && !TextUtils.isEmpty(node.url)) {
                    com.bumptech.glide.c.t(v0.g()).w(node.url).q0((ImageView) baseViewHolder.getView(i7));
                    baseViewHolder.setText(i3, TextUtils.isEmpty(node.name) ? "是否含有该图片" : node.name);
                    baseViewHolder.setGone(j.b.e.S3, false);
                    int i12 = j.b.e.g6;
                    baseViewHolder.setGone(i12, true);
                    if (node.areaParam != null) {
                        baseViewHolder.setText(i12, "变量区域识别");
                    } else if (node.getArea() == null) {
                        baseViewHolder.setText(i12, "全屏识别(慢)");
                    } else if (node.getArea().equals(node.getSrcRect())) {
                        baseViewHolder.setText(i12, "固定坐标识别");
                    } else {
                        baseViewHolder.setText(i12, "区域识别");
                    }
                    if (node.url.startsWith("1")) {
                        baseViewHolder.setGone(i4, true);
                        baseViewHolder.setGone(i5, true);
                        baseViewHolder.setGone(i6, true);
                        baseViewHolder.setVisible(i7, false);
                        int[] iArr2 = {i4, i5, i6};
                        ImageBox imageBoxA2 = b8.c().a(Long.valueOf(node.url).longValue());
                        if (imageBoxA2 != null && imageBoxA2.urls != null) {
                            for (int i13 = 0; i13 < 3; i13++) {
                                if (i13 < imageBoxA2.urls.size()) {
                                    com.bumptech.glide.c.t(v0.g()).w(imageBoxA2.urls.get(i13)).q0((ImageView) baseViewHolder.getView(iArr2[i13]));
                                }
                            }
                        }
                    }
                } else {
                    int i14 = node.type;
                    if (i14 == 38) {
                        baseViewHolder.setGone(i7, false);
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
                            for (int i15 = 1; i15 < strArrSplit.length; i15++) {
                                colorViewArr[i15].setColor(Color.parseColor("#" + strArrSplit[i15].split("\\|")[2]));
                            }
                        } else {
                            colorView.setColor(Color.parseColor("#" + node.arg1));
                        }
                        baseViewHolder.setText(j.b.e.v6, TextUtils.isEmpty(node.name) ? "未匹配到颜色" : node.name);
                        int i16 = j.b.e.g6;
                        baseViewHolder.setGone(i16, true);
                        if (node.areaParam != null) {
                            baseViewHolder.setText(i16, "变量区域识别");
                        } else if (node.getArea() == null) {
                            baseViewHolder.setText(i16, "全屏找色");
                        } else {
                            baseViewHolder.setText(i16, "区域找色");
                        }
                    } else if (i14 == 24) {
                        baseViewHolder.setImageResource(i7, j.b.d.c0);
                        baseViewHolder.setGone(j.b.e.S3, false);
                        baseViewHolder.setText(i3, TextUtils.isEmpty(node.name) ? "变量判断" : node.name);
                        int i17 = j.b.e.g6;
                        baseViewHolder.setGone(i17, true);
                        baseViewHolder.setText(i17, "「" + node.text + "」" + node.arg1 + node.arg2);
                    } else if (i14 == 13) {
                        baseViewHolder.setGone(i7, false);
                        baseViewHolder.setGone(j.b.e.S3, true);
                        ColorView colorView6 = (ColorView) baseViewHolder.getView(j.b.e.s1);
                        ColorView colorView7 = (ColorView) baseViewHolder.getView(j.b.e.t1);
                        ColorView colorView8 = (ColorView) baseViewHolder.getView(j.b.e.u1);
                        ColorView colorView9 = (ColorView) baseViewHolder.getView(j.b.e.v1);
                        ColorView colorView10 = (ColorView) baseViewHolder.getView(j.b.e.w1);
                        if (node.arg1.contains("|")) {
                            String[] strArrSplit2 = node.arg1.split(",");
                            colorView6.setColor(Color.parseColor("#" + strArrSplit2[0]));
                            ColorView[] colorViewArr2 = {colorView6, colorView7, colorView8, colorView9, colorView10};
                            for (int i18 = 1; i18 < strArrSplit2.length; i18++) {
                                colorViewArr2[i18].setColor(Color.parseColor("#" + strArrSplit2[i18].split("\\|")[2]));
                            }
                        } else {
                            colorView6.setColor(Color.parseColor("#" + node.arg1));
                        }
                        baseViewHolder.setText(j.b.e.v6, TextUtils.isEmpty(node.name) ? "是否含有颜色" : node.name);
                        int i19 = j.b.e.g6;
                        baseViewHolder.setGone(i19, true);
                        if (node.areaParam != null) {
                            baseViewHolder.setText(i19, "变量区域识别");
                        } else if (node.getArea() == null) {
                            baseViewHolder.setText(i19, "全屏找色");
                        } else {
                            baseViewHolder.setText(i19, "区域找色");
                        }
                    } else {
                        baseViewHolder.setImageResource(i7, j.b.d.a0);
                        c = 0;
                        baseViewHolder.setGone(j.b.e.S3, false);
                        baseViewHolder.setText(i3, node.getName());
                        i2 = 1;
                    }
                }
            }
            i2 = 1;
            c = 0;
        }
        int[] iArr3 = new int[i2];
        iArr3[c] = j.b.e.O0;
        baseViewHolder.addOnClickListener(iArr3);
    }
}
