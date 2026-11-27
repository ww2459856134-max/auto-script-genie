package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.v.item.ParamLabelItem;
import com.v.item.RunConditionItem;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class LengthScrollDialogView extends RelativeLayout implements View.OnClickListener {
    private final ArrayList<ParamLabelItem> c;
    private LinearLayout d;
    private RunConditionItem e;
    private Task f;
    private Node g;

    /* renamed from: h, reason: collision with root package name */
    private Node f980h;

    /* renamed from: i, reason: collision with root package name */
    private lt f981i;

    public LengthScrollDialogView() {
        super(com.frame.v0.g());
        this.c = new ArrayList<>();
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.I, (ViewGroup) this, true);
        this.d = (LinearLayout) findViewById(j.b.e.U3);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.e = runConditionItem;
        runConditionItem.setAttachView(this);
        View viewFindViewById = findViewById(j.b.e.f);
        ((TextView) viewFindViewById.findViewById(j.b.e.K5)).setText("添加坐标点");
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.v.tb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.g(view);
            }
        });
        findViewById(j.b.e.U).setOnClickListener(this);
        findViewById(j.b.e.g).setOnClickListener(this);
        findViewById(j.b.e.P).setOnClickListener(this);
    }

    private void a(String str) {
        final View viewInflate = LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.N0, (ViewGroup) this.d, false);
        final ParamLabelItem paramLabelItem = (ParamLabelItem) viewInflate.findViewById(j.b.e.i2);
        paramLabelItem.setParamKeys(this.f.params);
        if (!TextUtils.isEmpty(str)) {
            paramLabelItem.setValue(str);
        }
        viewInflate.findViewById(j.b.e.H).setOnClickListener(new View.OnClickListener() { // from class: com.v.vb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.e(paramLabelItem, viewInflate, view);
            }
        });
        this.c.add(paramLabelItem);
        this.d.addView(viewInflate);
        j();
    }

    private Node b(Node node) {
        Node node2 = this.g;
        node2.type = node.type;
        node2.duration = node.duration;
        node2.maxDuration = node.maxDuration;
        node2.text = node.text;
        node2.arg1 = node.arg1;
        node2.pathPoints = node.pathPoints == null ? null : new ArrayList<>(node.pathPoints);
        this.g.setCondition(node.getCondition() != null ? (Node) com.frame.q1.a(node.getCondition()) : null);
        return this.g;
    }

    private ArrayList<String> c(boolean z) {
        ArrayList<String> arrayList = new ArrayList<>(this.c.size());
        Iterator<ParamLabelItem> it = this.c.iterator();
        while (it.hasNext()) {
            ParamLabelItem next = it.next();
            String strTrim = next.getValue().trim();
            if (TextUtils.isEmpty(strTrim)) {
                if (!z) {
                    return null;
                }
                next.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return null;
            }
            arrayList.add(strTrim);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(ParamLabelItem paramLabelItem, View view, View view2) {
        if (this.c.size() <= 2) {
            FloatToast.i("至少保留两个滑动点");
            return;
        }
        this.c.remove(paramLabelItem);
        this.d.removeView(view);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(View view) {
        a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Node node) {
        this.f981i.a(node == null ? null : b(node));
    }

    private void j() {
        int i2 = 0;
        while (i2 < this.c.size()) {
            String strValueOf = i2 < 26 ? String.valueOf((char) (i2 + 65)) : String.valueOf(i2 + 1);
            this.c.get(i2).setLabel(strValueOf + "点坐标变量");
            i2++;
        }
    }

    public lt getCallback() {
        return this.f981i;
    }

    public LengthScrollDialogView k(lt ltVar) {
        this.f981i = ltVar;
        return this;
    }

    public LengthScrollDialogView l(Task task, Node node) {
        this.f = task;
        this.g = node;
        Node node2 = (Node) com.frame.q1.a(node);
        this.f980h = node2;
        this.e.setTaskNode(task, node2);
        this.c.clear();
        this.d.removeAllViews();
        Node node3 = this.f980h;
        ArrayList<String> arrayListC = kt.c(node3.arg1, node3.text);
        if (arrayListC.isEmpty()) {
            if (!TextUtils.isEmpty(this.f980h.arg1) && this.f980h.pathPoints == null) {
                FloatToast.i("变量坐标配置异常，请重新设置");
            }
            ArrayList<Integer> arrayListB = kt.b(this.f980h.pathPoints);
            for (int i2 = 0; i2 < arrayListB.size(); i2 += 2) {
                arrayListC.add(arrayListB.get(i2) + "," + arrayListB.get(i2 + 1));
            }
        }
        Iterator<String> it = arrayListC.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        while (this.c.size() < 2) {
            a(null);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.b.e.g) {
            ArrayList<String> arrayListC = c(true);
            if (arrayListC == null) {
                return;
            }
            String strE = kt.e(arrayListC);
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            com.frame.s0.g().o(this);
            Node node = this.f980h;
            node.type = 27;
            node.arg1 = strE;
            node.text = null;
            node.pathPoints = null;
            this.f981i.a(b(node));
            return;
        }
        if (view.getId() != j.b.e.U) {
            if (view.getId() == j.b.e.P) {
                com.frame.s0.g().o(this);
                this.f981i.a(null);
                return;
            }
            return;
        }
        ArrayList<String> arrayListC2 = c(false);
        if (arrayListC2 != null) {
            this.f980h.arg1 = kt.e(arrayListC2);
            this.f980h.text = null;
        }
        com.frame.s0.g().o(this);
        LengthScrollChooseView lengthScrollChooseView = (LengthScrollChooseView) com.frame.s0.g().x(LengthScrollChooseView.class);
        lengthScrollChooseView.setTaskNode(this.f, this.f980h);
        lengthScrollChooseView.setCallback(new lt() { // from class: com.v.ub
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.i(node2);
            }
        });
    }

    public void setCallback(lt ltVar) {
        this.f981i = ltVar;
    }
}
