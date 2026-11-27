package com.v;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public class PageScanFloatView extends RelativeLayout implements View.OnClickListener {
    private AccessibilityNodeInfo A;
    private Runnable C;
    private HashMap<AccessibilityNodeInfo, String> D;
    private b c;
    private Runnable d;
    private LinearLayout e;
    private lt f;
    private Paint g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1024h;

    /* renamed from: i, reason: collision with root package name */
    private GestureDetector f1025i;

    /* renamed from: j, reason: collision with root package name */
    private LinkedHashMap<Rect, AccessibilityNodeInfo> f1026j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1027k;
    private Rect t;

    class a implements c {
        a(PageScanFloatView pageScanFloatView) {
        }

        @Override // com.v.PageScanFloatView.c
        public boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return com.frame.g0.v().z(accessibilityNodeInfo.getClassName().toString());
        }

        @Override // com.v.PageScanFloatView.c
        public boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return false;
        }
    }

    public interface b {
        void a(int i2, Rect rect, String str, AccessibilityNodeInfo accessibilityNodeInfo);

        void cancel();
    }

    interface c {
        boolean a(AccessibilityNodeInfo accessibilityNodeInfo);

        boolean b(AccessibilityNodeInfo accessibilityNodeInfo);
    }

    class d extends GestureDetector.SimpleOnGestureListener {
        d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Rect rect = null;
            try {
                for (Rect rect2 : PageScanFloatView.this.f1026j.keySet()) {
                    if (rect2.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && (rect == null || rect.contains(rect2))) {
                        rect = rect2;
                    }
                }
                if (rect != null) {
                    PageScanFloatView.this.b(rect);
                    return true;
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    public PageScanFloatView() {
        super(com.frame.v0.g());
        this.f1026j = new LinkedHashMap<>();
        this.D = new HashMap<>();
        this.e = (LinearLayout) View.inflate(com.frame.v0.g(), j.b.f.u0, null);
        Paint paint = new Paint();
        this.g = paint;
        paint.setAlpha(0);
        this.g.setDither(true);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeJoin(Paint.Join.ROUND);
        this.f1025i = new GestureDetector(com.frame.v0.g(), new d());
        CanDragCloseButton canDragCloseButton = new CanDragCloseButton(com.frame.v0.g());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        canDragCloseButton.setCompoundDrawablesWithIntrinsicBounds(j.b.d.A0, 0, 0, 0);
        canDragCloseButton.setText("关闭识别");
        layoutParams.addRule(11);
        layoutParams.topMargin = com.frame.p1.c(2.0f);
        layoutParams.rightMargin = com.frame.p1.c(8.0f);
        addView(canDragCloseButton, layoutParams);
        canDragCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.v.ri
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.p(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(Rect rect, View view) {
        h(rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(Node node) {
        lt ltVar = this.f;
        if (ltVar != null) {
            ltVar.a(node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(Rect rect) {
        this.e.setX(((rect.width() - this.e.getWidth()) / 2) + rect.left);
        if (rect.width() >= com.frame.k0.c().e() || rect.height() >= com.frame.k0.c().d()) {
            this.e.setY(rect.centerY());
        } else {
            LinearLayout linearLayout = this.e;
            linearLayout.setY(rect.bottom + linearLayout.getHeight() > getHeight() ? rect.top - this.e.getHeight() : rect.bottom);
        }
    }

    private void G() {
        Runnable runnable = this.d;
        if (runnable != null) {
            runnable.run();
            return;
        }
        b bVar = this.c;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l() {
        com.frame.s0.g().d(PageScanFloatView.class);
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("未找到可识别的元素。当前页面可能是游戏引擎绘制的页面，无法使用控件识别，请用<strong><font color='#F45075'>『图片识别』</font></strong>代替使用。");
        dingMsgView.i("取消", null);
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.xi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.j(view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(c cVar) {
        ArrayList arrayList = new ArrayList();
        AccessibilityNodeInfo accessibilityNodeInfo = null;
        int i2 = 0;
        while (true) {
            if (i2 < 5) {
                AccessibilityNodeInfo accessibilityNodeInfoC = com.frame.w0.b().c();
                if (accessibilityNodeInfoC != null && accessibilityNodeInfoC.getPackageName() != null) {
                    this.A = accessibilityNodeInfoC;
                    g("", 0, accessibilityNodeInfoC, arrayList, cVar);
                    accessibilityNodeInfo = accessibilityNodeInfoC;
                    break;
                } else {
                    SystemClock.sleep(100L);
                    i2++;
                    accessibilityNodeInfo = accessibilityNodeInfoC;
                }
            } else {
                break;
            }
        }
        if (accessibilityNodeInfo != null && !arrayList.isEmpty()) {
            postInvalidate();
            return;
        }
        Runnable runnable = this.C;
        if (runnable == null) {
            runnable = new Runnable() { // from class: com.v.vi
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.l();
                }
            };
        }
        com.frame.l1.e(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(View view) {
        com.frame.s0.g().d(PageScanFloatView.class);
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(AccessibilityNodeInfo accessibilityNodeInfo, Node node) {
        if (accessibilityNodeInfo != null) {
            try {
                if (!TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
                    node.name = accessibilityNodeInfo.getText().toString();
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
        lt ltVar = this.f;
        if (ltVar != null) {
            ltVar.a(node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(final AccessibilityNodeInfo accessibilityNodeInfo, View view) {
        try {
            final Node nodeC = c(accessibilityNodeInfo);
            if (nodeC.what == -1) {
                com.frame.s0.g().d(PageScanFloatView.class);
                WidgetScanDialogView widgetScanDialogView = (WidgetScanDialogView) com.frame.s0.g().B(WidgetScanDialogView.class);
                widgetScanDialogView.B(this.f1024h);
                widgetScanDialogView.D(i.b.v8.m().p(), nodeC);
                widgetScanDialogView.C(new lt() { // from class: com.v.wi
                    @Override // com.v.lt
                    public final void a(Node node) {
                        this.a.D(node);
                    }
                });
            } else {
                com.frame.s0.g().d(PageScanFloatView.class);
                post(new Runnable() { // from class: com.v.qi
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.r(accessibilityNodeInfo, nodeC);
                    }
                });
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            Toast.makeText(com.frame.v0.g(), "识别元素出错...", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Node node) {
        lt ltVar = this.f;
        if (ltVar != null) {
            ltVar.a(node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(final Node node) {
        com.frame.l1.e(new Runnable() { // from class: com.v.ti
            @Override // java.lang.Runnable
            public final void run() {
                this.c.v(node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(AccessibilityNodeInfo accessibilityNodeInfo, View view) {
        com.frame.s0.g().d(PageScanFloatView.class);
        Node nodeC = c(accessibilityNodeInfo);
        WidgetScanDialogView widgetScanDialogView = (WidgetScanDialogView) com.frame.s0.g().B(WidgetScanDialogView.class);
        widgetScanDialogView.B(this.f1024h);
        widgetScanDialogView.D(i.b.v8.m().p(), nodeC);
        widgetScanDialogView.C(new lt() { // from class: com.v.ui
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.x(node);
            }
        });
    }

    public PageScanFloatView H(String str, View.OnClickListener onClickListener) {
        TextView textView = (TextView) this.e.findViewById(j.b.e.W);
        if (str == null) {
            textView.setVisibility(8);
            textView.setOnClickListener(null);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
            textView.setOnClickListener(onClickListener);
        }
        return this;
    }

    public PageScanFloatView I(String str, View.OnClickListener onClickListener) {
        TextView textView = (TextView) this.e.findViewById(j.b.e.A0);
        if (str == null) {
            textView.setVisibility(8);
            textView.setOnClickListener(null);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
            textView.setOnClickListener(onClickListener);
        }
        return this;
    }

    public PageScanFloatView J(String str, View.OnClickListener onClickListener) {
        TextView textView = (TextView) this.e.findViewById(j.b.e.I0);
        if (str == null) {
            textView.setVisibility(8);
            textView.setOnClickListener(null);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
            textView.setOnClickListener(onClickListener);
        }
        return this;
    }

    public void b(Rect rect) {
        if (this.c == null) {
            setHighLight(rect);
            return;
        }
        com.frame.s0.g().o(this);
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1026j.get(rect);
        int iIndexOf = new ArrayList(this.f1026j.values()).indexOf(accessibilityNodeInfo);
        String strSubstring = this.D.get(accessibilityNodeInfo);
        if (strSubstring.startsWith(",")) {
            strSubstring = strSubstring.substring(1);
        }
        this.c.a(iIndexOf, rect, strSubstring, accessibilityNodeInfo);
    }

    public Node c(AccessibilityNodeInfo accessibilityNodeInfo) {
        Node nodeJ = i.b.v8.m().j(this.f1027k, this.D.get(accessibilityNodeInfo).substring(1), accessibilityNodeInfo, this.A, this.f1026j.values());
        nodeJ.whatIndex = 1;
        return nodeJ;
    }

    public void d(b bVar) {
        e(null, bVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.g.setColor(Color.parseColor("#FF3C3C"));
        canvas.drawColor(Color.parseColor("#55000000"));
        try {
            Iterator<Rect> it = this.f1026j.keySet().iterator();
            while (it.hasNext()) {
                canvas.drawRect(it.next(), this.g);
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        if (this.t != null) {
            canvas.drawColor(Color.parseColor("#aa000000"));
            Paint paint = new Paint();
            paint.setAlpha(0);
            paint.setDither(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawRect(this.t, paint);
            paint.setAlpha(1);
            paint.setXfermode(null);
            paint.setColor(Color.parseColor("#88FF3C3C"));
            canvas.drawRect(this.t, paint);
        }
        super.dispatchDraw(canvas);
    }

    public void e(final c cVar, b bVar) {
        this.c = bVar;
        if (com.frame.w0.d()) {
            com.frame.l1.g(new Runnable() { // from class: com.v.pi
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.n(cVar);
                }
            });
        } else {
            Toast.makeText(com.frame.v0.g(), "请先开启【无障碍服务】权限", 0).show();
            com.frame.s0.g().d(PageScanFloatView.class);
        }
    }

    public void f(b bVar) {
        e(new a(this), bVar);
    }

    public List<AccessibilityNodeInfo> g(String str, int i2, AccessibilityNodeInfo accessibilityNodeInfo, List<AccessibilityNodeInfo> list, c cVar) {
        for (int i3 = 0; i3 < accessibilityNodeInfo.getChildCount(); i3++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
            if (child != null) {
                try {
                    if (child.getClassName() != null) {
                        String str2 = str + "," + ((Object) child.getClassName()) + "#" + i3;
                        if (child.getChildCount() == 0 && (cVar == null || cVar.a(child))) {
                            Rect rect = new Rect();
                            child.getBoundsInScreen(rect);
                            if (rect.width() < com.frame.k0.c().e() && rect.height() < com.frame.k0.c().d()) {
                                this.D.put(child, str2);
                                this.f1026j.put(rect, child);
                                list.add(child);
                            }
                        } else {
                            if (cVar != null && cVar.b(child)) {
                                this.D.put(child, str2);
                                Rect rect2 = new Rect();
                                child.getBoundsInScreen(rect2);
                                this.f1026j.put(rect2, child);
                                list.add(child);
                            }
                            g(str2, i3, child, list, cVar);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    public lt getNodeCallback() {
        return this.f;
    }

    public void h(Rect rect) {
        this.f1026j.remove(rect);
        removeView(this.e);
        this.t = null;
        if (this.f1026j.isEmpty()) {
            com.frame.s0.g().d(PageScanFloatView.class);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.frame.s0.g().i(FloatHandlerRecord.class);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.frame.s0.g().u(FloatHandlerRecord.class);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f1025i;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setHighLight(final Rect rect) {
        this.t = rect;
        setSubViewPosition(rect);
        final AccessibilityNodeInfo accessibilityNodeInfo = this.f1026j.get(rect);
        J("识别元素", new View.OnClickListener() { // from class: com.v.mi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.t(accessibilityNodeInfo, view);
            }
        });
        I("逻辑编辑", new View.OnClickListener() { // from class: com.v.ni
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.z(accessibilityNodeInfo, view);
            }
        });
        H("忽略元素", new View.OnClickListener() { // from class: com.v.oi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.B(rect, view);
            }
        });
    }

    public void setMiniModel(boolean z) {
        this.f1024h = z;
    }

    public void setNeedScanTextIfHash(boolean z) {
        this.f1027k = z;
    }

    public void setNodeCallback(lt ltVar) {
        this.f = ltVar;
    }

    public void setOnCancelListener(Runnable runnable) {
        this.d = runnable;
    }

    public void setOnNoFindCallback(Runnable runnable) {
        this.C = runnable;
    }

    public void setSubViewPosition(final Rect rect) {
        int iC;
        int iC2;
        int iWidth = ((rect.width() - com.frame.p1.c(250.0f)) / 2) + rect.left;
        removeView(this.e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (rect.width() > com.frame.p1.c(120.0f)) {
            this.e.setOrientation(0);
            iC = com.frame.p1.c(40.0f);
        } else {
            iWidth = rect.left + ((rect.width() - com.frame.p1.c(70.0f)) / 2);
            this.e.setOrientation(1);
            iC = com.frame.p1.c(80.0f);
        }
        if (rect.bottom + iC > getHeight()) {
            iC2 = rect.top - iC;
        } else {
            iC2 = com.frame.p1.c(10.0f) + rect.bottom;
        }
        this.e.setX(iWidth);
        this.e.setY(iC2);
        addView(this.e, layoutParams);
        this.e.post(new Runnable() { // from class: com.v.si
            @Override // java.lang.Runnable
            public final void run() {
                this.c.F(rect);
            }
        });
    }
}
