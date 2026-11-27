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
public class PageCaptureTextFloatView extends RelativeLayout implements View.OnClickListener {
    private b c;
    private LinearLayout d;
    private lt e;
    private Paint f;
    private GestureDetector g;

    /* renamed from: h, reason: collision with root package name */
    private LinkedHashMap<Rect, AccessibilityNodeInfo> f1020h;

    /* renamed from: i, reason: collision with root package name */
    private List<Rect> f1021i;

    /* renamed from: j, reason: collision with root package name */
    private AccessibilityNodeInfo f1022j;

    /* renamed from: k, reason: collision with root package name */
    private Runnable f1023k;
    private HashMap<AccessibilityNodeInfo, String> t;

    class a implements c {
        a(PageCaptureTextFloatView pageCaptureTextFloatView) {
        }

        @Override // com.v.PageCaptureTextFloatView.c
        public boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return !TextUtils.isEmpty(accessibilityNodeInfo.getText());
        }

        @Override // com.v.PageCaptureTextFloatView.c
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
                for (Rect rect2 : PageCaptureTextFloatView.this.f1020h.keySet()) {
                    if (rect2.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && (rect == null || rect.contains(rect2))) {
                        rect = rect2;
                    }
                }
                if (rect != null) {
                    PageCaptureTextFloatView.this.b(rect);
                    return true;
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    public PageCaptureTextFloatView() {
        super(com.frame.v0.g());
        this.f1020h = new LinkedHashMap<>();
        this.f1021i = new ArrayList();
        this.t = new HashMap<>();
        this.d = (LinearLayout) View.inflate(com.frame.v0.g(), j.b.f.u0, null);
        Paint paint = new Paint();
        this.f = paint;
        paint.setAlpha(0);
        this.f.setDither(true);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setStrokeJoin(Paint.Join.ROUND);
        this.g = new GestureDetector(com.frame.v0.g(), new d());
        CanDragCloseButton canDragCloseButton = new CanDragCloseButton(com.frame.v0.g());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        canDragCloseButton.setCompoundDrawablesWithIntrinsicBounds(j.b.d.A0, 0, 0, 0);
        canDragCloseButton.setText("关闭识别");
        layoutParams.addRule(11);
        layoutParams.topMargin = com.frame.p1.c(2.0f);
        layoutParams.rightMargin = com.frame.p1.c(8.0f);
        addView(canDragCloseButton, layoutParams);
        canDragCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.v.gi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.k(view);
            }
        });
    }

    static /* synthetic */ void f(b bVar, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        if (bVar != null) {
            bVar.cancel();
        }
    }

    static /* synthetic */ void g(final b bVar) {
        com.frame.s0.g().d(PageCaptureTextFloatView.class);
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("未找到可识别的元素。当前页面可能是游戏引擎绘制的页面，无法使用控件识别，请用<strong><font color='#F45075'>『图片识别』</font></strong>代替使用。");
        dingMsgView.i("取消", null);
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.ki
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PageCaptureTextFloatView.f(bVar, view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(c cVar, final b bVar) {
        ArrayList arrayList = new ArrayList();
        AccessibilityNodeInfo accessibilityNodeInfo = null;
        int i2 = 0;
        while (true) {
            if (i2 < 5) {
                AccessibilityNodeInfo accessibilityNodeInfoC = com.frame.w0.b().c();
                if (accessibilityNodeInfoC != null && accessibilityNodeInfoC.getPackageName() != null) {
                    this.f1022j = accessibilityNodeInfoC;
                    e("", 0, accessibilityNodeInfoC, arrayList, cVar);
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
        Runnable runnable = this.f1023k;
        if (runnable == null) {
            runnable = new Runnable() { // from class: com.v.ji
                @Override // java.lang.Runnable
                public final void run() {
                    PageCaptureTextFloatView.g(bVar);
                }
            };
        }
        com.frame.l1.e(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(View view) {
        com.frame.s0.g().d(PageCaptureTextFloatView.class);
        b bVar = this.c;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(AccessibilityNodeInfo accessibilityNodeInfo, View view) {
        try {
            String strSubstring = this.t.get(accessibilityNodeInfo).substring(1);
            System.out.println("++++++" + strSubstring);
            Node nodeQ = i.b.v8.m().Q();
            nodeQ.timeOut = 5000L;
            nodeQ.nextType = 7;
            nodeQ.errorType = 2;
            nodeQ.type = 44;
            nodeQ.url = this.f1022j.getPackageName().toString();
            nodeQ.text = strSubstring;
            nodeQ.arg1 = "标题=" + strSubstring;
            nodeQ.whatIndex = 1;
            com.frame.s0.g().d(PageCaptureTextFloatView.class);
            this.e.a(nodeQ);
        } catch (Exception e) {
            com.frame.k0.r(e);
            Toast.makeText(com.frame.v0.g(), "识别元素出错...", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(Rect rect) {
        this.d.setX(((rect.width() - this.d.getWidth()) / 2) + rect.left);
        if (rect.width() >= com.frame.k0.c().e() || rect.height() >= com.frame.k0.c().d()) {
            this.d.setY(rect.centerY());
        } else {
            LinearLayout linearLayout = this.d;
            linearLayout.setY(rect.bottom + linearLayout.getHeight() > getHeight() ? rect.top - this.d.getHeight() : rect.bottom);
        }
    }

    public void b(Rect rect) {
        if (this.c == null) {
            setHighLight(rect);
            return;
        }
        com.frame.s0.g().o(this);
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1020h.get(rect);
        int iIndexOf = new ArrayList(this.f1020h.values()).indexOf(accessibilityNodeInfo);
        String strSubstring = this.t.get(accessibilityNodeInfo);
        if (strSubstring.startsWith(",")) {
            strSubstring = strSubstring.substring(1);
        }
        this.c.a(iIndexOf, rect, strSubstring, accessibilityNodeInfo);
    }

    public void c(final c cVar, final b bVar) {
        this.c = bVar;
        if (com.frame.w0.d()) {
            com.frame.l1.g(new Runnable() { // from class: com.v.ii
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.i(cVar, bVar);
                }
            });
        } else {
            Toast.makeText(com.frame.v0.g(), "请先开启【无障碍服务】权限", 0).show();
            com.frame.s0.g().d(PageCaptureTextFloatView.class);
        }
    }

    public void d(b bVar) {
        c(new a(this), bVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f.setColor(Color.parseColor("#FF3C3C"));
        canvas.drawColor(Color.parseColor("#55000000"));
        try {
            Iterator<Rect> it = this.f1020h.keySet().iterator();
            while (it.hasNext()) {
                canvas.drawRect(it.next(), this.f);
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        canvas.drawColor(Color.parseColor("#aa000000"));
        for (int i2 = 0; i2 < this.f1021i.size(); i2++) {
            Rect rect = this.f1021i.get(i2);
            if (rect != null) {
                Paint paint = new Paint();
                paint.setAlpha(0);
                paint.setDither(true);
                paint.setStyle(Paint.Style.FILL);
                paint.setStrokeJoin(Paint.Join.ROUND);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                canvas.drawRect(rect, paint);
                paint.setAlpha(1);
                paint.setXfermode(null);
                paint.setColor(Color.parseColor("#88FF3C3C"));
                canvas.drawRect(rect, paint);
            }
        }
        super.dispatchDraw(canvas);
    }

    public List<AccessibilityNodeInfo> e(String str, int i2, AccessibilityNodeInfo accessibilityNodeInfo, List<AccessibilityNodeInfo> list, c cVar) {
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
                                this.t.put(child, str2);
                                this.f1020h.put(rect, child);
                                list.add(child);
                            }
                        } else {
                            if (cVar != null && cVar.b(child)) {
                                this.t.put(child, str2);
                                Rect rect2 = new Rect();
                                child.getBoundsInScreen(rect2);
                                this.f1020h.put(rect2, child);
                                list.add(child);
                            }
                            e(str2, i3, child, list, cVar);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    public lt getNodeCallback() {
        return this.e;
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
        GestureDetector gestureDetector = this.g;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public PageCaptureTextFloatView p(String str, View.OnClickListener onClickListener) {
        TextView textView = (TextView) this.d.findViewById(j.b.e.A0);
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

    public PageCaptureTextFloatView q(String str, View.OnClickListener onClickListener) {
        TextView textView = (TextView) this.d.findViewById(j.b.e.I0);
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

    public void setHighLight(Rect rect) {
        this.f1021i.clear();
        this.f1021i.add(rect);
        setSubViewPosition(rect);
        final AccessibilityNodeInfo accessibilityNodeInfo = this.f1020h.get(rect);
        i.b.fa faVar = new i.b.fa();
        ArrayList arrayList = new ArrayList();
        AccessibilityNodeInfo accessibilityNodeInfoC = faVar.c(accessibilityNodeInfo);
        if (accessibilityNodeInfoC == null) {
            return;
        }
        List<Integer> listA = faVar.a(accessibilityNodeInfo, accessibilityNodeInfoC);
        listA.remove(0);
        for (int i2 = 0; i2 < accessibilityNodeInfoC.getChildCount(); i2++) {
            AccessibilityNodeInfo child = accessibilityNodeInfoC.getChild(i2);
            Iterator<Integer> it = listA.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (child == null || child.getChildCount() <= iIntValue) {
                    break;
                } else {
                    child = child.getChild(iIntValue);
                }
            }
            if (child != null) {
                Rect rect2 = new Rect();
                child.getBoundsInScreen(rect2);
                arrayList.add(rect2);
            }
        }
        this.f1021i.addAll(arrayList);
        p(null, null);
        q("识别元素", new View.OnClickListener() { // from class: com.v.hi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.m(accessibilityNodeInfo, view);
            }
        });
    }

    public void setMiniModel(boolean z) {
    }

    public void setNeedScanTextIfHash(boolean z) {
    }

    public void setNodeCallback(lt ltVar) {
        this.e = ltVar;
    }

    public void setOnNoFindCallback(Runnable runnable) {
        this.f1023k = runnable;
    }

    public void setSubViewPosition(final Rect rect) {
        int iC;
        int iC2;
        int iWidth = ((rect.width() - com.frame.p1.c(250.0f)) / 2) + rect.left;
        removeView(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (rect.width() > com.frame.p1.c(120.0f)) {
            this.d.setOrientation(0);
            iC = com.frame.p1.c(40.0f);
        } else {
            iWidth = rect.left + ((rect.width() - com.frame.p1.c(70.0f)) / 2);
            this.d.setOrientation(1);
            iC = com.frame.p1.c(80.0f);
        }
        if (rect.bottom + iC > getHeight()) {
            iC2 = rect.top - iC;
        } else {
            iC2 = com.frame.p1.c(10.0f) + rect.bottom;
        }
        this.d.setX(iWidth);
        this.d.setY(iC2);
        addView(this.d, layoutParams);
        this.d.post(new Runnable() { // from class: com.v.li
            @Override // java.lang.Runnable
            public final void run() {
                this.c.o(rect);
            }
        });
    }
}
