package com.v;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.v.PageScanFloatView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.widget.TabLinearLayout;

/* loaded from: classes.dex */
public class WidgetFeatureDialogView extends RelativeLayout implements View.OnClickListener {
    private View A;
    private lt C;
    protected TextView D;
    protected TextView G;
    private Task H;
    private Node I;
    private TabLinearLayout c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f1081h;

    /* renamed from: i, reason: collision with root package name */
    private View f1082i;

    /* renamed from: j, reason: collision with root package name */
    private View f1083j;

    /* renamed from: k, reason: collision with root package name */
    private View f1084k;
    private View t;

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
            com.frame.s0.g().u(WidgetFeatureDialogView.class);
            WidgetFeatureDialogView.this.I.arg1 = nodeC.arg1;
            WidgetFeatureDialogView widgetFeatureDialogView = WidgetFeatureDialogView.this;
            widgetFeatureDialogView.m(widgetFeatureDialogView.H, WidgetFeatureDialogView.this.I);
        }

        @Override // com.v.PageScanFloatView.b
        public void cancel() {
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(WidgetScanDialogView.class);
            com.frame.s0.g().u(WidgetFeatureDialogView.class);
        }
    }

    public WidgetFeatureDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.h0, (ViewGroup) this, true);
        findViewById(j.b.e.L0).setOnClickListener(this);
        this.D = (TextView) findViewById(j.b.e.P);
        this.G = (TextView) findViewById(j.b.e.g);
        this.d = (TextView) findViewById(j.b.e.B6);
        this.e = (TextView) findViewById(j.b.e.z6);
        this.f = (TextView) findViewById(j.b.e.D6);
        this.g = (TextView) findViewById(j.b.e.A6);
        this.f1081h = (TextView) findViewById(j.b.e.C6);
        this.f1082i = findViewById(j.b.e.y3);
        this.f1083j = findViewById(j.b.e.v3);
        this.f1084k = findViewById(j.b.e.A3);
        this.t = findViewById(j.b.e.w3);
        this.A = findViewById(j.b.e.z3);
        this.d.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.f1082i.setOnClickListener(this);
        this.f1083j.setOnClickListener(this);
        this.f1084k.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.c = (TabLinearLayout) findViewById(j.b.e.p5);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.v.vr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetFeatureDialogView.c(view);
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.v.xr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.g(view);
            }
        });
    }

    static /* synthetic */ void c(View view) {
        com.frame.s0.g().d(WidgetFeatureDialogView.class);
        MultiGestureRecordFloatView.c(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e() {
        SystemClock.sleep(100L);
        CharSequence text = this.d.getText();
        CharSequence text2 = this.e.getText();
        CharSequence text3 = this.f.getText();
        CharSequence text4 = this.g.getText();
        CharSequence text5 = this.f1081h.getText();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(text);
        stringBuffer.append("##");
        stringBuffer.append(this.f1082i.isSelected() ? "1" : "0");
        stringBuffer.append("|");
        stringBuffer.append(text2);
        stringBuffer.append("##");
        stringBuffer.append(this.f1083j.isSelected() ? "1" : "0");
        stringBuffer.append("|");
        if (!this.f1084k.isSelected()) {
            stringBuffer.append(text3);
            stringBuffer.append("##");
            stringBuffer.append("0");
            stringBuffer.append("|");
        } else if (this.c.getSelectedTabViewId() == j.b.e.c5) {
            stringBuffer.append(text3);
            stringBuffer.append("##");
            stringBuffer.append("1");
            stringBuffer.append("|");
        } else if (this.c.getSelectedTabViewId() == j.b.e.d5) {
            stringBuffer.append(text3);
            stringBuffer.append("##");
            stringBuffer.append("2");
            stringBuffer.append("|");
        } else {
            stringBuffer.append(text3);
            stringBuffer.append("##");
            stringBuffer.append("0");
            stringBuffer.append("|");
        }
        stringBuffer.append(text4);
        stringBuffer.append("##");
        stringBuffer.append(this.t.isSelected() ? "1" : "0");
        stringBuffer.append("|");
        stringBuffer.append(text5);
        stringBuffer.append("##");
        stringBuffer.append(this.A.isSelected() ? "1" : "0");
        stringBuffer.append("|");
        this.I.arg1 = stringBuffer.toString();
        this.I.what = this.c.getSelectedTabViewId() == j.b.e.d5 ? 0 : 1;
        com.frame.s0.g().o(this);
        lt ltVar = this.C;
        if (ltVar != null) {
            ltVar.a(this.I);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(View view) {
        com.frame.l1.g(new Runnable() { // from class: com.v.zr
            @Override // java.lang.Runnable
            public final void run() {
                this.c.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Node node) {
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(WidgetScanDialogView.class);
        com.frame.s0.g().u(WidgetFeatureDialogView.class);
        Node node2 = this.I;
        node2.arg1 = node.arg1;
        m(this.H, node2);
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

    public WidgetFeatureDialogView m(Task task, Node node) {
        this.H = task;
        this.I = node;
        if (node.what == 0) {
            findViewById(j.b.e.d5).callOnClick();
        } else {
            findViewById(j.b.e.c5).callOnClick();
        }
        String strReplace = node.arg1.replace("||", "|");
        node.arg1 = strReplace;
        String[] strArrSplit = strReplace.split("\\|");
        String[] strArrSplit2 = strArrSplit[0].split("##");
        String str = strArrSplit2[0];
        boolean z = !"0".equals(strArrSplit2[1]);
        String[] strArrSplit3 = strArrSplit[1].split("##");
        String str2 = strArrSplit3[0];
        boolean zEquals = "1".equals(strArrSplit3[1]);
        String[] strArrSplit4 = strArrSplit[2].split("##");
        String str3 = strArrSplit4[0];
        boolean z2 = !"0".equals(strArrSplit4[1]);
        String str4 = strArrSplit4[1];
        String[] strArrSplit5 = strArrSplit[3].split("##");
        String str5 = strArrSplit5[0];
        boolean zEquals2 = "1".equals(strArrSplit5[1]);
        String[] strArrSplit6 = strArrSplit[4].split("##");
        String str6 = strArrSplit6[0];
        boolean zEquals3 = "1".equals(strArrSplit6[1]);
        TextView textView = this.d;
        if ("null".equals(str)) {
            str = null;
        }
        textView.setText(str);
        TextView textView2 = this.e;
        if ("null".equals(str2)) {
            str2 = null;
        }
        textView2.setText(str2);
        TextView textView3 = this.f;
        if ("null".equals(str3)) {
            str3 = null;
        }
        textView3.setText(str3);
        TextView textView4 = this.g;
        if ("null".equals(str5)) {
            str5 = null;
        }
        textView4.setText(str5);
        TextView textView5 = this.f1081h;
        if ("null".equals(str6)) {
            str6 = null;
        }
        textView5.setText(str6);
        this.f1082i.setSelected(z);
        this.f1083j.setSelected(zEquals);
        this.f1084k.setSelected(z2);
        this.t.setSelected(zEquals2);
        this.A.setSelected(zEquals3);
        this.d.setVisibility(z ? 0 : 8);
        this.e.setVisibility(zEquals ? 0 : 8);
        this.f.setVisibility(z2 ? 0 : 8);
        this.g.setVisibility(zEquals2 ? 0 : 8);
        this.f1081h.setVisibility(zEquals3 ? 0 : 8);
        this.c.setVisibility(z2 ? 0 : 8);
        if ("1".equals(str4)) {
            this.c.b(j.b.e.d5);
            this.c.b(j.b.e.c5);
        } else if ("2".equals(str4)) {
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
            this.d.setVisibility(view.isSelected() ? 0 : 8);
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
            pageScanFloatView.setNodeCallback(new lt() { // from class: com.v.bs
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
            this.f.setVisibility(view.isSelected() ? 0 : 8);
            this.c.setVisibility(view.isSelected() ? 0 : 8);
            if (view.isSelected()) {
                this.c.b(j.b.e.d5);
                this.c.b(j.b.e.c5);
                return;
            }
            return;
        }
        if (j.b.e.v3 == id) {
            view.setSelected(!view.isSelected());
            this.e.setVisibility(view.isSelected() ? 0 : 8);
            return;
        }
        if (j.b.e.w3 == id) {
            view.setSelected(!view.isSelected());
            this.g.setVisibility(view.isSelected() ? 0 : 8);
            return;
        }
        if (j.b.e.A6 == id) {
            final TextView textView = (TextView) view;
            InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
            inputDialogView.v(1);
            inputDialogView.l("控件描述匹配");
            inputDialogView.w(textView.getText().toString());
            inputDialogView.s("请输入需要匹配的描述");
            inputDialogView.t(new InputDialogView.a() { // from class: com.v.as
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return WidgetFeatureDialogView.j(textView, str);
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
            inputDialogView2.t(new InputDialogView.a() { // from class: com.v.yr
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return WidgetFeatureDialogView.k(textView2, str);
                }
            });
            return;
        }
        if (j.b.e.B6 != id) {
            if (j.b.e.z3 == id) {
                view.setSelected(!view.isSelected());
                this.f1081h.setVisibility(view.isSelected() ? 0 : 8);
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
        inputDialogView3.t(new InputDialogView.a() { // from class: com.v.wr
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return WidgetFeatureDialogView.l(textView3, str);
            }
        });
    }
}
