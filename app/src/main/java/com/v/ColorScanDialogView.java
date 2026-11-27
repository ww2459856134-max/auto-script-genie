package com.v;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.v.ColorScanDialogView;
import com.v.item.ImageAreaChooseItem;
import com.v.item.InputItem;
import com.v.item.OffersetChooseItem;
import com.v.item.RunConditionItem;
import com.v.item.SelectAndDelayItem;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class ColorScanDialogView extends RelativeLayout implements View.OnClickListener {
    private Point A;
    private Task C;
    private Node D;
    private lt G;
    private ColorView H;
    private ColorView I;
    private ColorView J;
    private ColorView K;
    private ColorView M;
    private ColorView O;
    private DialogInterface.OnCancelListener P;
    private ImageAreaChooseItem c;
    private InputItem d;
    private InputItem e;
    private OffersetChooseItem f;
    private SelectAndDelayItem g;

    /* renamed from: h, reason: collision with root package name */
    private SelectAndDelayItem f925h;

    /* renamed from: i, reason: collision with root package name */
    private RunConditionItem f926i;

    /* renamed from: j, reason: collision with root package name */
    protected TextView f927j;

    /* renamed from: k, reason: collision with root package name */
    protected TextView f928k;
    private Rect t;

    class a implements Runnable {
        a() {
        }

        static /* synthetic */ void a(DialogInterface dialogInterface) {
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(ColorScanDialogView.class);
        }

        @Override // java.lang.Runnable
        public void run() {
            ColorChooseView colorChooseView = (ColorChooseView) com.frame.s0.g().x(ColorChooseView.class);
            colorChooseView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.v.f3
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    ColorScanDialogView.a.a(dialogInterface);
                }
            });
            colorChooseView.o(ColorScanDialogView.this.G);
        }
    }

    public ColorScanDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.p, (ViewGroup) this, true);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.f926i = runConditionItem;
        runConditionItem.setAttachView(this);
        this.f927j = (TextView) findViewById(j.b.e.P);
        this.f928k = (TextView) findViewById(j.b.e.g);
        this.d = (InputItem) findViewById(j.b.e.f4);
        this.e = (InputItem) findViewById(j.b.e.p4);
        this.d.setInputType(2);
        this.e.setInputType(2);
        this.c = (ImageAreaChooseItem) findViewById(j.b.e.Q3);
        this.f = (OffersetChooseItem) findViewById(j.b.e.e4);
        this.g = (SelectAndDelayItem) findViewById(j.b.e.h3);
        this.f925h = (SelectAndDelayItem) findViewById(j.b.e.j3);
        this.g.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.j3
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.c();
            }
        });
        this.g.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.n3
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.e();
            }
        });
        this.g.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.m3
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.g(str, str2);
            }
        });
        this.f925h.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.l3
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.i();
            }
        });
        this.f925h.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.o3
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.k();
            }
        });
        this.f925h.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.h3
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.m(str, str2);
            }
        });
        this.H = (ColorView) findViewById(j.b.e.s1);
        this.I = (ColorView) findViewById(j.b.e.t1);
        this.J = (ColorView) findViewById(j.b.e.u1);
        this.K = (ColorView) findViewById(j.b.e.v1);
        this.M = (ColorView) findViewById(j.b.e.w1);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.f927j.setOnClickListener(new View.OnClickListener() { // from class: com.v.g3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.o(view);
            }
        });
        this.f928k.setOnClickListener(new View.OnClickListener() { // from class: com.v.i3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.q(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String c() {
        return this.D.nextDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String e() {
        return this.D.nextMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(String str, String str2) {
        Node node = this.D;
        node.nextDelay = str;
        node.nextMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String i() {
        return this.D.errorDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String k() {
        return this.D.errorMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(String str, String str2) {
        Node node = this.D;
        node.errorDelay = str;
        node.errorMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(View view) {
        com.frame.s0.g().d(ColorScanDialogView.class);
        com.frame.s0.g().v();
        DialogInterface.OnCancelListener onCancelListener = this.P;
        if (onCancelListener != null) {
            onCancelListener.onCancel(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(View view) throws NumberFormatException {
        Node node;
        com.frame.s0.g().d(ColorScanDialogView.class);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(com.frame.q1.b(this.H.getColor()).replace("#", ""));
        Point point = (Point) this.H.getTag();
        if (this.I.getTag() != null) {
            Point point2 = (Point) this.I.getTag();
            stringBuffer.append(",");
            stringBuffer.append(point2.x - point.x);
            stringBuffer.append("|");
            stringBuffer.append(point2.y - point.y);
            stringBuffer.append("|");
            stringBuffer.append(com.frame.q1.b(this.I.getColor()).replace("#", ""));
        }
        if (this.J.getTag() != null) {
            Point point3 = (Point) this.J.getTag();
            stringBuffer.append(",");
            stringBuffer.append(point3.x - point.x);
            stringBuffer.append("|");
            stringBuffer.append(point3.y - point.y);
            stringBuffer.append("|");
            stringBuffer.append(com.frame.q1.b(this.J.getColor()).replace("#", ""));
        }
        if (this.K.getTag() != null) {
            Point point4 = (Point) this.K.getTag();
            stringBuffer.append(",");
            stringBuffer.append(point4.x - point.x);
            stringBuffer.append("|");
            stringBuffer.append(point4.y - point.y);
            stringBuffer.append("|");
            stringBuffer.append(com.frame.q1.b(this.K.getColor()).replace("#", ""));
        }
        if (this.M.getTag() != null) {
            Point point5 = (Point) this.M.getTag();
            stringBuffer.append(",");
            stringBuffer.append(point5.x - point.x);
            stringBuffer.append("|");
            stringBuffer.append(point5.y - point.y);
            stringBuffer.append("|");
            stringBuffer.append(com.frame.q1.b(this.M.getColor()).replace("#", ""));
        }
        this.D.setSrcRectNew(getColorRect());
        try {
            long j2 = Long.parseLong(this.e.getValue());
            try {
                Integer.parseInt(this.d.getValue());
                if (this.D == null) {
                    Node nodeQ = i.b.v8.m().Q();
                    this.D = nodeQ;
                    nodeQ.type = 13;
                }
                this.D.setPointNew(this.A);
                this.D.arg1 = stringBuffer.toString();
                this.D.pathPoints = new ArrayList<>();
                this.D.pathPoints.add(Integer.valueOf(point.x));
                this.D.pathPoints.add(Integer.valueOf(point.y));
                this.D.timeOut = j2;
                if (this.g.getVisibility() == 0 && this.f925h.getVisibility() == 0) {
                    if (!this.g.c() || !this.f925h.c()) {
                        return;
                    }
                    this.D.nextType = ((Integer) this.g.getValue()).intValue();
                    this.D.errorType = ((Integer) this.f925h.getValue()).intValue();
                    if (this.D.isJumOtherType()) {
                        this.D.nextTaskId = ((Long) this.g.getSubValue()).longValue();
                    } else {
                        Node node2 = this.D;
                        int i2 = node2.nextType;
                        if (i2 == 3 || i2 == 13) {
                            if (node2.nextId != ((Long) this.g.getSubValue()).longValue() && this.D.nextId != 0 && (node = this.C.getNodeMap().get(Long.valueOf(this.D.nextId))) != null) {
                                node.frontId = 0L;
                            }
                            this.D.nextId = ((Long) this.g.getSubValue()).longValue();
                        } else if (i2 == 9 || i2 == 11) {
                            node2.arg3 = this.g.getSelectSubLabel();
                            this.D.lineNextNodeAtIndex(this.C);
                        } else {
                            node2.lineNextNodeAtIndex(this.C);
                            this.D.arg3 = null;
                        }
                    }
                    if (this.f925h.getSubValue() != null) {
                        this.D.errorId = ((Long) this.f925h.getSubValue()).longValue();
                    }
                }
                this.D.setPointNew(this.f.getValue());
                this.c.p(this.D);
                com.frame.s0.g().o(this);
                lt ltVar = this.G;
                if (ltVar != null) {
                    ltVar.a(this.D);
                }
            } catch (Exception unused) {
                this.d.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("请输入正确的超时时间");
            }
        } catch (Exception unused2) {
            this.e.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请输入正确的超时时间");
        }
    }

    static /* synthetic */ void r(Runnable runnable) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i.b.i9.v().B()) {
                com.frame.l1.e(runnable);
            } else {
                SystemClock.sleep(500L);
            }
        }
    }

    public Rect getColorRect() {
        int i2;
        int i3;
        Point point = (Point) this.H.getTag();
        int i4 = point.x;
        int i5 = point.y;
        Rect rect = new Rect(i4, i5, i4, i5);
        ColorView[] colorViewArr = {this.I, this.J, this.K, this.M};
        for (int i6 = 0; i6 < 4; i6++) {
            Point point2 = (Point) colorViewArr[i6].getTag();
            if (point2 != null) {
                rect.left = Math.min(rect.left, point2.x);
                rect.right = Math.max(rect.right, point2.x);
                rect.top = Math.min(rect.top, point2.y);
                rect.bottom = Math.max(rect.bottom, point2.y);
            }
        }
        int i7 = rect.left;
        int i8 = rect.right;
        if (i7 == i8 && (i2 = rect.top) == (i3 = rect.bottom)) {
            rect.left = i7 - 10;
            rect.right = i8 + 10;
            rect.top = i2 - 10;
            rect.bottom = i3 + 10;
        }
        return rect;
    }

    public LinkedHashMap<String, Object> getNodeListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (Long l2 : this.C.getNodeMap().keySet()) {
            Node node = this.C.getNodeMap().get(l2);
            if (node != null) {
                linkedHashMap.put(node.getStepAndName(), l2);
            }
        }
        return linkedHashMap;
    }

    public LinkedHashMap<String, Object> getTaskListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (TaskSimple taskSimple : i.b.da.B().C()) {
            linkedHashMap.put(taskSimple.getName(), Long.valueOf(taskSimple.getId()));
        }
        return linkedHashMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.s1 || id == j.b.e.t1 || id == j.b.e.u1 || id == j.b.e.v1 || id == j.b.e.w1) {
            this.O = (ColorView) view;
            com.frame.s0.g().i(NodeListDialogView.class);
            com.frame.s0.g().i(FlowView.class);
            com.frame.s0.g().j(this);
            final a aVar = new a();
            if (i.b.i9.v().n()) {
                aVar.run();
            } else {
                com.frame.l1.g(new Runnable() { // from class: com.v.k3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ColorScanDialogView.r(aVar);
                    }
                });
            }
        }
    }

    public void setColor1(Point point, int i2) {
        this.H.setColor(i2);
        this.H.setTag(point);
    }

    public void setColor2(Point point, int i2) {
        this.I.setColor(i2);
        this.I.setTag(point);
    }

    public void setColor3(Point point, int i2) {
        this.J.setColor(i2);
        this.J.setTag(point);
    }

    public void setColor4(Point point, int i2) {
        this.K.setColor(i2);
        this.K.setTag(point);
    }

    public void setColor5(Point point, int i2) {
        this.M.setColor(i2);
        this.M.setTag(point);
    }

    public void setCurEditColor(Point point, int i2) {
        ColorView colorView = this.O;
        if (colorView != null) {
            colorView.setColor(i2);
            this.O.setTag(point);
        }
    }

    public void setMiniModel() {
        this.e.setVisibility(8);
        this.f925h.setVisibility(8);
        this.g.setVisibility(8);
        this.f.setVisibility(8);
        this.f926i.setVisibility(8);
    }

    public void setNodeCallback(lt ltVar) {
        this.G = ltVar;
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.P = onCancelListener;
    }

    public void setRect(Rect rect) {
        this.t = rect;
    }

    public void setTaskNode(Task task, Node node) {
        Integer num;
        Integer num2;
        this.C = task;
        this.D = node;
        this.f926i.setTaskNode(task, node);
        Integer num3 = 4;
        Integer num4 = 2;
        if (node.arg1.contains("|")) {
            String[] strArrSplit = node.arg1.split(",");
            Point point = new Point(node.pathPoints.get(0).intValue(), node.pathPoints.get(1).intValue());
            this.H.setColor(Color.parseColor("#" + strArrSplit[0]));
            this.H.setTag(point);
            ColorView[] colorViewArr = {this.H, this.I, this.J, this.K, this.M};
            int i2 = 1;
            while (i2 < strArrSplit.length) {
                String[] strArr = strArrSplit;
                String[] strArrSplit2 = strArrSplit[i2].split("\\|");
                colorViewArr[i2].setColor(Color.parseColor("#" + strArrSplit2[2]));
                colorViewArr[i2].setTag(new Point(Integer.parseInt(strArrSplit2[0]) + point.x, Integer.parseInt(strArrSplit2[1]) + point.y));
                i2++;
                strArrSplit = strArr;
                num4 = num4;
                num3 = num3;
                colorViewArr = colorViewArr;
            }
            num = num3;
            num2 = num4;
        } else {
            num = num3;
            num2 = num4;
            this.H.setColor(Color.parseColor("#" + node.arg1));
            this.H.setTag(new Point(node.pathPoints.get(0).intValue(), node.pathPoints.get(1).intValue()));
        }
        this.t = getColorRect();
        this.d.setValue(String.valueOf(this.D.what));
        this.e.setValue(String.valueOf(this.D.timeOut));
        this.A = this.D.getPoint();
        LinkedHashMap<String, LinkedHashMap> linkedHashMap = new LinkedHashMap<>();
        try {
            linkedHashMap.put("跳转任务", null);
            linkedHashMap.put("点击后跳任务", null);
            linkedHashMap.put("跳转节点", null);
            linkedHashMap.put("点击后跳节点", null);
            linkedHashMap.put("将坐标给变量", null);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("点击颜色", 0);
        linkedHashMap2.put("点击后跳任务", 12);
        linkedHashMap2.put("点击后跳节点", 13);
        linkedHashMap2.put("将坐标给变量", 11);
        linkedHashMap2.put("长按颜色", 5);
        linkedHashMap2.put("跳转节点", 3);
        Integer num5 = num;
        linkedHashMap2.put("跳转任务", num5);
        linkedHashMap2.put("结束任务", -3);
        linkedHashMap2.put("结束子任务/循环", -4);
        Integer num6 = num2;
        linkedHashMap2.put("跳转下一个节点", num6);
        this.g.setItems(linkedHashMap2, linkedHashMap);
        this.g.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem = this.g;
        selectAndDelayItem.setOnItemClick(new com.v.item.k2(this.C, this.D, selectAndDelayItem, this.f));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put("跳转节点", 3);
        linkedHashMap3.put("跳转任务", num5);
        linkedHashMap3.put("结束任务", -3);
        linkedHashMap3.put("结束子任务/循环", -4);
        linkedHashMap3.put("弹窗报错", -2);
        linkedHashMap3.put("跳转下一个节点", num6);
        linkedHashMap3.put("分支节点", 6);
        this.f925h.setItems(linkedHashMap3, linkedHashMap);
        this.f925h.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem2 = this.f925h;
        selectAndDelayItem2.setOnItemClick(new com.v.item.j2(this.C, this.D, selectAndDelayItem2));
        this.g.setSelectValue(Integer.valueOf(node.nextType));
        this.f925h.setSelectValue(Integer.valueOf(node.errorType));
        this.c.setValue(this.t, this.D.getArea(), this.D.areaParam);
        this.f.setValue(this.t, this.D.getPoint());
    }
}
