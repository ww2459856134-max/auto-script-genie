package com.v;

import android.graphics.Point;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.v.item.AreaChooseItem;
import com.v.item.CoordItem;
import com.v.item.InputItem;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.widget.TabLinearLayout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MultiClickDialogView extends RelativeLayout implements View.OnClickListener {
    private View A;
    private View C;
    private TabLinearLayout D;
    private TabLinearLayout G;
    private Node H;
    private lt c;
    protected TextView d;
    protected TextView e;
    protected TextView f;
    private CoordItem g;

    /* renamed from: h, reason: collision with root package name */
    private AreaChooseItem f986h;

    /* renamed from: i, reason: collision with root package name */
    private InputItem f987i;

    /* renamed from: j, reason: collision with root package name */
    private InputItem f988j;

    /* renamed from: k, reason: collision with root package name */
    private InputItem f989k;
    private InputItem t;

    public MultiClickDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.K, (ViewGroup) this, true);
        this.d = (TextView) findViewById(j.b.e.w6);
        this.e = (TextView) findViewById(j.b.e.P);
        this.f = (TextView) findViewById(j.b.e.g);
        this.g = (CoordItem) findViewById(j.b.e.i2);
        InputItem inputItem = (InputItem) findViewById(j.b.e.L1);
        this.t = inputItem;
        inputItem.setValue("150");
        InputItem inputItem2 = (InputItem) findViewById(j.b.e.z4);
        this.f987i = inputItem2;
        inputItem2.setInputType(2);
        this.C = findViewById(j.b.e.q3);
        this.A = findViewById(j.b.e.r3);
        this.f986h = (AreaChooseItem) findViewById(j.b.e.t4);
        this.f988j = (InputItem) findViewById(j.b.e.B4);
        this.f989k = (InputItem) findViewById(j.b.e.C4);
        this.f988j.setInputType(2);
        this.f989k.setInputType(2);
        this.G = (TabLinearLayout) this.C.findViewById(j.b.e.f5);
        TabLinearLayout tabLinearLayout = (TabLinearLayout) this.A.findViewById(j.b.e.g5);
        this.D = tabLinearLayout;
        tabLinearLayout.setTabClickListener(this);
        this.G.setTabClickListener(this);
        this.D.b(j.b.e.c5);
        this.G.b(j.b.e.n5);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.v.cc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(MultiClickDialogView.class);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.v.bc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.c(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(View view) throws NumberFormatException {
        int iIntValue;
        if (this.c != null) {
            int selectedTabViewId = this.D.getSelectedTabViewId();
            int i2 = j.b.e.c5;
            if (selectedTabViewId == i2) {
                if (this.g.getValue() == null && TextUtils.isEmpty(this.g.getParamName())) {
                    FloatToast.i("请先选择连点坐标");
                    this.g.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                    return;
                }
            } else if (selectedTabViewId == j.b.e.d5) {
                if (!this.f986h.e()) {
                    FloatToast.i("请先选择连点区域");
                    this.f986h.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                    return;
                }
                if (this.G.getSelectedTabViewId() == j.b.e.o5) {
                    if (TextUtils.isEmpty(this.f988j.getValue())) {
                        FloatToast.i("请先选择输入点击密度");
                        this.f988j.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                        return;
                    }
                    try {
                        if (Integer.parseInt(this.f988j.getValue().toString()) <= 0 || Integer.parseInt(this.f989k.getValue().toString()) <= 0) {
                            FloatToast.i("密度必须是大于0的整数");
                            return;
                        } else if (TextUtils.isEmpty(this.f989k.getValue())) {
                            FloatToast.i("请先选择输入点击密度");
                            this.f989k.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                            return;
                        }
                    } catch (Exception unused) {
                        FloatToast.i("密度必须是大于0的整数");
                        return;
                    }
                }
            }
            if (this.f987i.getVisibility() == 0 && TextUtils.isEmpty(this.f987i.getValue())) {
                this.f987i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return;
            }
            if (TextUtils.isEmpty(this.t.getValue())) {
                this.t.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return;
            }
            try {
                long j2 = Integer.parseInt(this.t.getValue());
                if (this.f987i.getVisibility() == 0) {
                    iIntValue = Integer.parseInt(this.f987i.getValue());
                    if (iIntValue < 1) {
                        FloatToast.i("点击次数必须大于0");
                        this.f987i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                        return;
                    }
                } else {
                    iIntValue = Integer.valueOf(this.f988j.getValue().toString()).intValue() * Integer.valueOf(this.f989k.getValue().toString()).intValue();
                }
                Node node = this.H;
                node.pathPoints = new ArrayList<>();
                node.type = 11;
                node.duration = iIntValue * j2;
                node.arg1 = String.valueOf(iIntValue);
                node.text = this.f988j.getValue().toString();
                node.url = this.f989k.getValue().toString();
                int i3 = this.D.getSelectedTabViewId() == i2 ? 0 : 1;
                node.what = i3;
                if (i3 == 1) {
                    this.f986h.u(this.H);
                    String strValueOf = String.valueOf(this.G.getSelectedTabViewId() == j.b.e.n5 ? 0 : 1);
                    node.arg2 = strValueOf;
                    if ("1".equals(strValueOf)) {
                        node.text = this.f988j.getValue().toString();
                        node.url = this.f989k.getValue().toString();
                        node.type = 18;
                    } else {
                        node.type = 17;
                    }
                } else if (this.g.getValue() != null) {
                    node.pathPoints.add(Integer.valueOf(this.g.getValue().x));
                    node.pathPoints.add(Integer.valueOf(this.g.getValue().y));
                    node.arg3 = null;
                } else if (!TextUtils.isEmpty(this.g.getParamName())) {
                    node.arg3 = this.g.getParamName();
                    node.pathPoints = null;
                }
                lt ltVar = this.c;
                if (ltVar != null) {
                    ltVar.a(node);
                }
                com.frame.s0.g().d(MultiClickDialogView.class);
            } catch (Exception e) {
                com.frame.k0.r(e);
                FloatToast.i("请输入整数");
            }
        }
    }

    private MultiClickDialogView g(Point point) {
        this.g.setValue(point);
        return this;
    }

    public MultiClickDialogView d() {
        this.D.b(j.b.e.d5);
        this.G.b(j.b.e.n5);
        this.A.setVisibility(8);
        this.C.setVisibility(8);
        this.d.setText("区域随机点击");
        return this;
    }

    public MultiClickDialogView e() {
        this.D.b(j.b.e.d5);
        this.G.b(j.b.e.o5);
        this.A.setVisibility(8);
        this.C.setVisibility(8);
        this.d.setText("网格点击");
        return this;
    }

    public MultiClickDialogView f(lt ltVar) {
        this.c = ltVar;
        return this;
    }

    public MultiClickDialogView h(Task task, Node node) {
        this.H = node;
        this.f987i.setValue(node.arg1);
        if (node.arg1 != null) {
            this.t.setValue(String.valueOf(node.duration / Integer.parseInt(r6)));
        } else {
            this.t.setValue("150");
        }
        this.f988j.setValue(node.text);
        this.f989k.setValue(node.url);
        if (node.what == 1) {
            this.D.b(j.b.e.d5);
            if ("0".equals(node.arg2)) {
                this.G.b(j.b.e.n5);
            } else if ("1".equals(node.arg2)) {
                this.G.b(j.b.e.o5);
            }
            this.f986h.setValue(node.getArea(), node.areaParam);
        } else {
            this.D.b(j.b.e.c5);
            if (TextUtils.isEmpty(node.arg3)) {
                g(new Point(node.pathPoints.get(0).intValue(), node.pathPoints.get(1).intValue()));
            } else {
                this.g.l(node.arg3);
            }
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.c5) {
            this.g.setVisibility(0);
            this.C.setVisibility(8);
            this.f986h.setVisibility(8);
            this.f988j.setVisibility(8);
            this.f989k.setVisibility(8);
            this.f987i.setVisibility(0);
            return;
        }
        if (id != j.b.e.d5) {
            if (id == j.b.e.n5) {
                this.f988j.setVisibility(8);
                this.f989k.setVisibility(8);
                this.f987i.setVisibility(0);
                return;
            } else {
                if (id == j.b.e.o5) {
                    this.f988j.setVisibility(0);
                    this.f989k.setVisibility(0);
                    this.f987i.setVisibility(8);
                    return;
                }
                return;
            }
        }
        this.g.setVisibility(8);
        this.C.setVisibility(0);
        this.f986h.setVisibility(0);
        if (this.G.getSelectedTabViewId() == j.b.e.o5) {
            this.f988j.setVisibility(0);
            this.f989k.setVisibility(0);
            this.f987i.setVisibility(8);
        } else {
            this.f988j.setVisibility(8);
            this.f989k.setVisibility(8);
            this.f987i.setVisibility(0);
        }
    }
}
