package com.adapter;

import android.content.res.ColorStateList;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.l1;
import com.frame.v0;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import i.b.da;
import i.b.ka.x5;
import i.b.o8;
import i.b.x7;
import java.util.List;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class NodeListAdapter extends BaseItemDraggableAdapter<Node, BaseViewHolder> {
    private int a;
    private boolean b;
    private boolean c;
    private TreeMap<Integer, Node> d;
    private Task e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f415h;

    /* renamed from: i, reason: collision with root package name */
    private int f416i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f417j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f418k;

    /* renamed from: l, reason: collision with root package name */
    private RecyclerView f419l;

    public NodeListAdapter(List<Node> list, Task task) {
        super(j.b.f.P0, list);
        this.a = -1;
        v0 v0VarG = v0.g();
        int i2 = j.b.c.f;
        this.f = v0VarG.getColor(i2);
        v0 v0VarG2 = v0.g();
        int i3 = j.b.c.b;
        this.g = v0VarG2.getColor(i3);
        this.f415h = v0.g().getColor(j.b.c.e);
        this.f416i = v0.g().getColor(j.b.c.a);
        this.f417j = v0.g().getColorStateList(i2);
        this.f418k = v0.g().getColorStateList(i3);
        this.e = task;
    }

    private RecyclerView e() {
        return this.f419l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i2) {
        if (e() == null || e().w0()) {
            return;
        }
        int i3 = this.a;
        int size = getData().size();
        if (i3 < 0 || i3 >= size) {
            i3 = -1;
        }
        if (i2 < 0 || i2 >= size) {
            return;
        }
        this.a = i2;
        if (i3 >= 0 && i3 < size) {
            try {
                notifyItemChanged(i3);
            } catch (Exception unused) {
                notifyDataSetChanged();
            }
        }
        try {
            notifyItemChanged(i2);
        } catch (Exception unused2) {
            notifyDataSetChanged();
        }
    }

    private void k() {
        l(new Runnable() { // from class: com.adapter.c
            @Override // java.lang.Runnable
            public final void run() {
                this.c.notifyDataSetChanged();
            }
        });
    }

    private void l(Runnable runnable) {
        RecyclerView recyclerView;
        if (runnable == null || (recyclerView = this.f419l) == null) {
            return;
        }
        if (recyclerView.w0()) {
            this.f419l.post(runnable);
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            l1.e(runnable);
            return;
        }
        try {
            try {
                runnable.run();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            this.f419l.post(runnable);
        }
    }

    public void c(int i2) {
        Node item;
        if (i2 < 0 || this.d == null || (item = getItem(i2)) == null) {
            return;
        }
        this.d.put(Integer.valueOf(i2), item);
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Node node) {
        int layoutPosition;
        int i2;
        int i3;
        int i4;
        String str;
        if (node != null && (layoutPosition = baseViewHolder.getLayoutPosition()) >= 0) {
            int i5 = j.b.e.f6;
            BaseViewHolder baseViewHolderAddOnClickListener = baseViewHolder.addOnClickListener(i5);
            int i6 = j.b.e.h6;
            BaseViewHolder baseViewHolderAddOnClickListener2 = baseViewHolderAddOnClickListener.addOnClickListener(i6);
            int i7 = j.b.e.m6;
            BaseViewHolder baseViewHolderAddOnClickListener3 = baseViewHolderAddOnClickListener2.addOnClickListener(i7);
            int i8 = j.b.e.y0;
            BaseViewHolder baseViewHolderAddOnClickListener4 = baseViewHolderAddOnClickListener3.addOnClickListener(i8);
            int i9 = j.b.e.j1;
            BaseViewHolder baseViewHolderAddOnClickListener5 = baseViewHolderAddOnClickListener4.addOnClickListener(i9);
            int i10 = j.b.e.O0;
            BaseViewHolder baseViewHolderAddOnClickListener6 = baseViewHolderAddOnClickListener5.addOnClickListener(i10);
            int i11 = j.b.e.q6;
            baseViewHolderAddOnClickListener6.addOnClickListener(i11);
            baseViewHolder.addOnLongClickListener(i7).addOnLongClickListener(i9);
            int i12 = j.b.e.k6;
            baseViewHolder.setText(i12, (layoutPosition + 1) + ".");
            baseViewHolder.setBackgroundColor(j.b.e.P3, this.a == layoutPosition ? this.f415h : this.f416i);
            int i13 = node.type;
            if (i13 == 27 || i13 == 1 || i13 == 2 || i13 == 11 || i13 == 17) {
                if (node.maxDuration != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("持续：");
                    i2 = i12;
                    sb.append(node.duration);
                    sb.append(ProcessIdUtil.DEFAULT_PROCESSID);
                    sb.append(node.maxDuration);
                    sb.append("ms");
                    baseViewHolder.setText(i6, sb.toString());
                    i3 = i8;
                    i4 = i9;
                } else {
                    i2 = i12;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("持续：");
                    i3 = i8;
                    i4 = i9;
                    sb2.append(node.duration);
                    sb2.append("ms");
                    baseViewHolder.setText(i6, sb2.toString());
                }
                baseViewHolder.setGone(i6, true);
            } else {
                baseViewHolder.setGone(i6, false);
                i2 = i12;
                i3 = i8;
                i4 = i9;
            }
            if (node.repeatCount == -1) {
                baseViewHolder.setText(i11, "无限循环");
            } else {
                baseViewHolder.setText(i11, "循环：" + node.repeatCount + "次");
            }
            baseViewHolder.setGone(i11, node.repeatCount != 0);
            String strC = o8.c(node.delay, node.maxDelay);
            if (o8.j(node.delay)) {
                baseViewHolder.setText(i5, Html.fromHtml("等待：<font color='#FF886A'>" + strC + "<font/>"));
            } else {
                baseViewHolder.setText(i5, "等待：" + strC);
            }
            TextView textView = (TextView) baseViewHolder.getView(i7);
            x5 x5VarE = x7.d().e(node.type);
            if (x5VarE != null) {
                int iR = x5VarE.r();
                textView.setText(x5VarE.t());
                textView.setCompoundDrawablesWithIntrinsicBounds(iR, 0, 0, 0);
            }
            if (!TextUtils.isEmpty(node.name)) {
                textView.setText(node.name);
            }
            int i14 = j.b.e.k1;
            baseViewHolder.setGone(i14, this.c).setGone(i10, this.b).setGone(j.b.e.h1, this.b).setGone(i3, !this.b).setGone(i4, !this.b);
            baseViewHolder.addOnClickListener(i14);
            if (this.d != null) {
                baseViewHolder.getView(i14).setSelected(this.d.containsKey(Integer.valueOf(layoutPosition)));
            }
            TextView textView2 = (TextView) baseViewHolder.getView(j.b.e.l6);
            int i15 = node.nextType;
            if (i15 == 3 || i15 == 13) {
                str = "跳转任务:";
                textView2.setVisibility(0);
                Node node2 = this.e.nodeMap.get(Long.valueOf(node.getJumpNodeId()));
                if (node2 != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(node.nextType == 3 ? "跳转节点:" : "点击后跳转节点:");
                    sb3.append(node2.getStepAndName());
                    textView2.setText(sb3.toString());
                } else {
                    textView2.setText(Html.fromHtml("跳转节点:<font color='#E73030'>未找到节点</font>"));
                }
            } else if (i15 == 4 || i15 == 12) {
                str = "跳转任务:";
                textView2.setVisibility(0);
                TaskSimple taskSimpleW = da.B().w(node.getJumpNodeId());
                if (taskSimpleW != null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(node.nextType == 4 ? str : "点击后跳转任务:");
                    sb4.append(taskSimpleW.getName());
                    textView2.setText(sb4.toString());
                } else {
                    textView2.setText(Html.fromHtml("跳转任务:<font color='#E73030'>未找到任务</font>"));
                }
            } else if (i15 == -4) {
                textView2.setVisibility(0);
                textView2.setText("结束子任务/循环");
                str = "跳转任务:";
            } else if (i15 == 6) {
                textView2.setVisibility(0);
                str = "跳转任务:";
                Node node3 = this.e.nodeMap.get(Long.valueOf(node.nextId));
                if (node3 != null) {
                    textView2.setText("跳转分支:" + node3.getStepAndName());
                } else {
                    textView2.setText(Html.fromHtml("跳转分支:<font color='#E73030'>未找到分支节点</font>"));
                }
            } else {
                str = "跳转任务:";
                textView2.setVisibility(8);
            }
            if (textView2.getVisibility() == 8) {
                int i16 = node.errorType;
                if (i16 == -4) {
                    textView2.setVisibility(0);
                    textView2.setText("超时结束子任务/循环");
                } else if (i16 != 3 || node.type == 15) {
                    int i17 = node.nextType;
                    if (i17 == 4) {
                        textView2.setVisibility(0);
                        TaskSimple taskSimpleW2 = da.B().w(node.errorId);
                        if (taskSimpleW2 != null) {
                            textView2.setText(str + taskSimpleW2.getName());
                        } else {
                            textView2.setText(Html.fromHtml("跳转任务:<font color='#E73030'>未找到任务</font>"));
                        }
                    } else if (i17 == 6) {
                        textView2.setVisibility(0);
                        Node node4 = this.e.nodeMap.get(Long.valueOf(node.errorId));
                        if (node4 != null) {
                            textView2.setText("超时跳转分支:" + node4.getStepAndName());
                        } else {
                            textView2.setText(Html.fromHtml("超时跳转分支:<font color='#E73030'>未找到分支节点</font>"));
                        }
                    } else {
                        textView2.setVisibility(8);
                    }
                } else {
                    textView2.setVisibility(0);
                    Node node5 = this.e.nodeMap.get(Long.valueOf(node.errorId));
                    if (node5 != null) {
                        textView2.setText("超时跳转节点:" + node5.getStepAndName());
                    } else {
                        textView2.setText(Html.fromHtml("超时跳转节点:<font color='#E73030'>未找到节点</font>"));
                    }
                }
            }
            if ((node.frontId != 0 || layoutPosition == 0) && !node.invalid) {
                baseViewHolder.getConvertView().setAlpha(1.0f);
                textView.setTextColor(this.g);
                baseViewHolder.setTextColor(i2, this.g);
                textView.setCompoundDrawableTintList(this.f418k);
                return;
            }
            textView.setTextColor(this.f);
            baseViewHolder.setTextColor(i2, this.f);
            textView.setCompoundDrawableTintList(this.f417j);
            baseViewHolder.getConvertView().setAlpha(0.4f);
        }
    }

    public TreeMap<Integer, Node> f() {
        return this.d;
    }

    public boolean g(int i2) {
        TreeMap<Integer, Node> treeMap = this.d;
        return treeMap != null && treeMap.containsKey(Integer.valueOf(i2));
    }

    public void j(int i2) {
        if (i2 < 0 || this.d == null) {
            return;
        }
        Node item = getItem(i2);
        if (item == null) {
            this.d.remove(Integer.valueOf(i2));
        } else {
            this.d.remove(Integer.valueOf(i2), item);
        }
        k();
    }

    public void m(final int i2) {
        int i3 = this.a;
        if (i2 < 0 || i2 >= getData().size() || i3 == i2) {
            return;
        }
        l(new Runnable() { // from class: com.adapter.j
            @Override // java.lang.Runnable
            public final void run() {
                this.c.i(i2);
            }
        });
    }

    public void n(boolean z) {
        this.b = z;
        k();
    }

    public void o(boolean z) {
        this.c = z;
        this.d = new TreeMap<>();
        k();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f419l = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        if (this.f419l == recyclerView) {
            this.f419l = null;
        }
        super.onDetachedFromRecyclerView(recyclerView);
    }
}
