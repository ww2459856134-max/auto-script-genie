package com.v;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.v.PageScanFloatView;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.WidgetFeature;
import com.yl.widget.TabLinearLayout;

/* loaded from: classes.dex */
public class WidgetScanTypeDialogView extends RelativeLayout implements View.OnClickListener {
    private TextView A;
    private View C;
    private View D;
    private View G;
    private View H;
    private View I;
    private View J;
    private View K;
    private lt M;
    protected TextView O;
    protected TextView P;
    private Task Q;
    private TabLinearLayout c;
    private Node d;
    private CheckBox e;
    private TextView f;
    private TextView g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f1089h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f1090i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f1091j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f1092k;
    private TextView t;

    class a implements PageScanFloatView.b {
        final /* synthetic */ PageScanFloatView a;

        a(PageScanFloatView pageScanFloatView) {
            this.a = pageScanFloatView;
        }

        @Override // com.v.PageScanFloatView.b
        public void a(int i2, Rect rect, String str, AccessibilityNodeInfo accessibilityNodeInfo) {
            Node nodeC = this.a.c(accessibilityNodeInfo);
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(WidgetScanDialogView.class);
            com.frame.s0.g().u(WidgetScanTypeDialogView.class);
            WidgetScanTypeDialogView.this.d.arg1 = nodeC.arg1;
            WidgetScanTypeDialogView widgetScanTypeDialogView = WidgetScanTypeDialogView.this;
            widgetScanTypeDialogView.o(widgetScanTypeDialogView.Q, WidgetScanTypeDialogView.this.d);
        }

        @Override // com.v.PageScanFloatView.b
        public void cancel() {
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(WidgetScanDialogView.class);
            com.frame.s0.g().u(WidgetScanTypeDialogView.class);
        }
    }

    public WidgetScanTypeDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.j0, (ViewGroup) this, true);
        this.e = (CheckBox) findViewById(j.b.e.G6);
        this.f = (TextView) findViewById(j.b.e.H6);
        findViewById(j.b.e.L0).setOnClickListener(this);
        this.O = (TextView) findViewById(j.b.e.P);
        this.P = (TextView) findViewById(j.b.e.g);
        this.g = (TextView) findViewById(j.b.e.B6);
        this.f1089h = (TextView) findViewById(j.b.e.z6);
        this.f1090i = (TextView) findViewById(j.b.e.D6);
        this.f1091j = (TextView) findViewById(j.b.e.A6);
        this.f1092k = (TextView) findViewById(j.b.e.C6);
        this.A = (TextView) findViewById(j.b.e.i6);
        this.t = (TextView) findViewById(j.b.e.E6);
        this.C = findViewById(j.b.e.y3);
        this.D = findViewById(j.b.e.v3);
        this.G = findViewById(j.b.e.A3);
        this.H = findViewById(j.b.e.w3);
        this.I = findViewById(j.b.e.z3);
        this.J = findViewById(j.b.e.x3);
        this.K = findViewById(j.b.e.B3);
        this.g.setOnClickListener(this);
        this.f1091j.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        findViewById(j.b.e.I5).setOnClickListener(this);
        findViewById(j.b.e.J5).setOnClickListener(this);
        this.c = (TabLinearLayout) findViewById(j.b.e.p5);
        this.O.setOnClickListener(new View.OnClickListener() { // from class: com.v.ss
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetScanTypeDialogView.c(view);
            }
        });
        this.P.setOnClickListener(new View.OnClickListener() { // from class: com.v.ts
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.g(view);
            }
        });
    }

    static /* synthetic */ void c(View view) {
        com.frame.s0.g().d(WidgetScanTypeDialogView.class);
        MultiGestureRecordFloatView.c(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(boolean z) {
        SystemClock.sleep(100L);
        CharSequence text = this.g.getText();
        CharSequence text2 = this.f1089h.getText();
        CharSequence text3 = this.f1090i.getText();
        CharSequence text4 = this.f1091j.getText();
        CharSequence text5 = this.f1092k.getText();
        CharSequence text6 = this.A.getText();
        CharSequence text7 = this.t.getText();
        WidgetFeature widgetFeature = new WidgetFeature();
        widgetFeature.packageToggle = Boolean.valueOf(z);
        widgetFeature.idToggle = this.C.isSelected();
        widgetFeature.classToggle = this.D.isSelected();
        widgetFeature.textToggle = this.G.isSelected();
        widgetFeature.descToggle = this.H.isSelected();
        widgetFeature.pathToggle = this.I.isSelected();
        widgetFeature.heightToggle = this.J.isSelected();
        widgetFeature.widthToggle = this.K.isSelected();
        widgetFeature.id = String.valueOf(text);
        widgetFeature.className = String.valueOf(text2);
        widgetFeature.text = String.valueOf(text3);
        widgetFeature.path = String.valueOf(text5);
        widgetFeature.desc = String.valueOf(text4);
        widgetFeature.height = String.valueOf(text6);
        widgetFeature.width = String.valueOf(text7);
        if (this.G.isSelected()) {
            if (this.c.getSelectedTabViewId() == j.b.e.c5) {
                widgetFeature.textType = 1;
            } else if (this.c.getSelectedTabViewId() == j.b.e.d5) {
                widgetFeature.textType = 2;
            }
        }
        this.d.arg1 = new Gson().s(widgetFeature);
        this.d.what = this.c.getSelectedTabViewId() == j.b.e.d5 ? 0 : 1;
        com.frame.s0.g().o(this);
        lt ltVar = this.M;
        if (ltVar != null) {
            ltVar.a(this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(View view) {
        final boolean zIsChecked = this.e.isChecked();
        com.frame.l1.g(new Runnable() { // from class: com.v.us
            @Override // java.lang.Runnable
            public final void run() {
                this.c.e(zIsChecked);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Node node) {
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(WidgetScanDialogView.class);
        com.frame.s0.g().u(WidgetScanTypeDialogView.class);
        Node node2 = this.d;
        node2.arg1 = node.arg1;
        o(this.Q, node2);
    }

    static /* synthetic */ boolean j(TextView textView, String str) {
        textView.setText(str);
        return true;
    }

    static /* synthetic */ boolean k(TextView textView, String str) {
        textView.setText(str);
        return true;
    }

    static /* synthetic */ boolean l(TextView textView, String str) {
        textView.setText(str);
        return true;
    }

    public int getWhat() {
        return this.c.getSelectedTabViewId() == j.b.e.d5 ? 0 : 1;
    }

    public WidgetScanTypeDialogView n(lt ltVar) {
        this.M = ltVar;
        return this;
    }

    public WidgetScanTypeDialogView o(Task task, Node node) {
        this.Q = task;
        this.d = node;
        if (node.what == 0) {
            findViewById(j.b.e.d5).callOnClick();
        } else {
            findViewById(j.b.e.c5).callOnClick();
        }
        WidgetFeature widgetFeatureV = i.b.ka.s7.V(node.arg1);
        this.e.setChecked(widgetFeatureV.isPackageMatchEnabled());
        TextView textView = this.f;
        StringBuilder sb = new StringBuilder();
        sb.append("录制包名：");
        String str = node.url;
        sb.append((str == null || str.isEmpty()) ? "未记录" : node.url);
        sb.append("\n取消后仅在当前活动窗口按所选特征识别，不限制包名。");
        textView.setText(sb.toString());
        this.g.setText("null".equals(String.valueOf(widgetFeatureV.id)) ? null : String.valueOf(widgetFeatureV.id));
        this.f1089h.setText("null".equals(String.valueOf(widgetFeatureV.className)) ? null : String.valueOf(widgetFeatureV.className));
        this.f1090i.setText("null".equals(String.valueOf(widgetFeatureV.text)) ? null : String.valueOf(widgetFeatureV.text));
        this.f1091j.setText("null".equals(String.valueOf(widgetFeatureV.desc)) ? null : String.valueOf(widgetFeatureV.desc));
        this.f1092k.setText("null".equals(String.valueOf(widgetFeatureV.path)) ? null : String.valueOf(widgetFeatureV.path));
        this.t.setText("null".equals(String.valueOf(widgetFeatureV.width)) ? null : String.valueOf(widgetFeatureV.width));
        this.A.setText("null".equals(String.valueOf(widgetFeatureV.height)) ? null : String.valueOf(widgetFeatureV.height));
        this.C.setSelected(widgetFeatureV.idToggle);
        this.D.setSelected(widgetFeatureV.classToggle);
        this.G.setSelected(widgetFeatureV.textToggle);
        this.H.setSelected(widgetFeatureV.descToggle);
        this.I.setSelected(widgetFeatureV.pathToggle);
        this.K.setSelected(widgetFeatureV.widthToggle);
        this.J.setSelected(widgetFeatureV.heightToggle);
        this.g.setVisibility(widgetFeatureV.idToggle ? 0 : 8);
        this.f1089h.setVisibility(widgetFeatureV.classToggle ? 0 : 8);
        this.f1090i.setVisibility(widgetFeatureV.textToggle ? 0 : 8);
        this.f1091j.setVisibility(widgetFeatureV.descToggle ? 0 : 8);
        this.A.setVisibility(widgetFeatureV.heightToggle ? 0 : 8);
        this.t.setVisibility(widgetFeatureV.widthToggle ? 0 : 8);
        this.c.setVisibility(widgetFeatureV.textToggle ? 0 : 8);
        int i2 = widgetFeatureV.textType;
        if (i2 == 1) {
            this.c.b(j.b.e.d5);
            this.c.b(j.b.e.c5);
        } else if (i2 == 2) {
            this.c.b(j.b.e.c5);
            this.c.b(j.b.e.d5);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (j.b.e.y3 == id) {
            view.setSelected(!view.isSelected());
            this.g.setVisibility(view.isSelected() ? 0 : 8);
            return;
        }
        if (j.b.e.L0 == id) {
            com.frame.s0.g().i(FlowView.class);
            com.frame.s0.g().i(NodeListDialogView.class);
            com.frame.s0.g().j(this);
            com.frame.s0.g().i(WidgetScanDialogView.class);
            MultiGestureRecordFloatView.F(null);
            PageScanFloatView pageScanFloatView = (PageScanFloatView) com.frame.s0.g().x(PageScanFloatView.class);
            pageScanFloatView.d(new a(pageScanFloatView));
            pageScanFloatView.setNodeCallback(new lt() { // from class: com.v.ws
                @Override // com.v.lt
                public final void a(Node node) {
                    this.a.i(node);
                }
            });
            if (i.b.da.B().C().size() >= 4 || !com.frame.n0.a("guideAudio", true)) {
                return;
            }
            i.b.da.B().B1("record_text.mp4");
            return;
        }
        if (j.b.e.A3 == id) {
            view.setSelected(!view.isSelected());
            this.f1090i.setVisibility(view.isSelected() ? 0 : 8);
            this.c.setVisibility(view.isSelected() ? 0 : 8);
            if (view.isSelected()) {
                this.c.b(j.b.e.d5);
                this.c.b(j.b.e.c5);
                return;
            }
            return;
        }
        if (j.b.e.B3 == id) {
            view.setSelected(!view.isSelected());
            this.t.setVisibility(view.isSelected() ? 0 : 8);
            return;
        }
        if (j.b.e.x3 == id) {
            view.setSelected(!view.isSelected());
            this.A.setVisibility(view.isSelected() ? 0 : 8);
            return;
        }
        if (j.b.e.v3 == id) {
            view.setSelected(!view.isSelected());
            this.f1089h.setVisibility(view.isSelected() ? 0 : 8);
            return;
        }
        if (j.b.e.I5 == id || j.b.e.J5 == id) {
            p("有的时候控件容易识别错，特别没有id或id混乱的情况下且没有其他明显特征时容易识别错误，这时候可以试一试加入匹配控件的高度或宽度来识别控件，高度宽度可以用数字值，表示完全等于就匹配成，也可以使用一个数字范围，高宽只要在这个范围内就匹配成，如填入：<font color='#F45075'>200-300</font>，那么匹配是高宽在这个数值内就匹配成。");
            return;
        }
        if (j.b.e.w3 == id) {
            view.setSelected(!view.isSelected());
            this.f1091j.setVisibility(view.isSelected() ? 0 : 8);
            return;
        }
        if (j.b.e.A6 == id) {
            final TextView textView = (TextView) view;
            InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
            inputDialogView.v(1);
            inputDialogView.l("控件描述匹配");
            inputDialogView.w(textView.getText().toString());
            inputDialogView.s("请输入需要匹配的描述");
            inputDialogView.t(new InputDialogView.a() { // from class: com.v.zs
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return WidgetScanTypeDialogView.j(textView, str);
                }
            });
            return;
        }
        if (j.b.e.D6 == id) {
            final TextView textView2 = (TextView) view;
            InputDialogView inputDialogView2 = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
            inputDialogView2.v(1);
            inputDialogView2.l("文本内容匹配");
            inputDialogView2.w(textView2.getText().toString());
            inputDialogView2.s("请输入需要匹配的文本内容");
            inputDialogView2.t(new InputDialogView.a() { // from class: com.v.ys
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return WidgetScanTypeDialogView.k(textView2, str);
                }
            });
            return;
        }
        if (j.b.e.B6 != id) {
            if (j.b.e.z3 == id) {
                view.setSelected(!view.isSelected());
                return;
            }
            return;
        }
        final TextView textView3 = (TextView) view;
        InputDialogView inputDialogView3 = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView3.v(1);
        inputDialogView3.l("控件ID匹配");
        inputDialogView3.w(textView3.getText().toString());
        inputDialogView3.s("请输入需要匹配的控件id");
        inputDialogView3.t(new InputDialogView.a() { // from class: com.v.xs
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return WidgetScanTypeDialogView.l(textView3, str);
            }
        });
    }

    public void p(String str) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h(str);
        dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.vs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.l("温馨提示");
    }
}
