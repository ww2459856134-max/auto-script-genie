package com.yl.float_ui;

import android.graphics.Color;
import android.graphics.Point;
import android.text.Html;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.frame.c1;
import com.frame.l1;
import com.frame.n0;
import com.frame.p1;
import com.frame.q1;
import com.frame.r0;
import com.frame.s0;
import com.frame.v0;
import com.frame.y0;
import com.yl.float_ui.LogSetDialogView;
import java.io.File;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public class SimpleLogView extends RelativeLayout {
    public boolean A;
    protected int C;
    protected int D;
    private int G;
    private int H;
    private Runnable I;
    private boolean J;
    private GestureDetector c;
    private TextView d;
    private ScrollView e;
    private final Object f;
    private final ArrayDeque<String> g;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f1118h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f1119i;

    /* renamed from: j, reason: collision with root package name */
    private int f1120j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1121k;
    private boolean t;

    class a implements LogSetDialogView.a {
        a() {
        }

        @Override // com.yl.float_ui.LogSetDialogView.a
        public void a(String str) {
            SimpleLogView.this.d.setTextSize(n0.c("lgoTs", 7));
        }
    }

    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getLocationInWindow(new int[2]);
            motionEvent.offsetLocation(r1[0], r1[1]);
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                SimpleLogView.this.A = true;
            } else if (action == 1) {
                SimpleLogView simpleLogView = SimpleLogView.this;
                simpleLogView.A = false;
                simpleLogView.N(rawX, rawY);
                l1.c(30939485, SimpleLogView.this.I, 200L);
            } else if (action == 2) {
                SimpleLogView simpleLogView2 = SimpleLogView.this;
                simpleLogView2.A = true;
                simpleLogView2.N(rawX, rawY);
            }
            return true;
        }
    }

    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getLocationInWindow(new int[2]);
            motionEvent.offsetLocation(r1[0], r1[1]);
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                SimpleLogView simpleLogView = SimpleLogView.this;
                simpleLogView.A = true;
                simpleLogView.G = (int) motionEvent.getX();
                SimpleLogView.this.H = (int) motionEvent.getY();
            } else if (action == 1) {
                SimpleLogView.this.A = false;
                if (rawX - view.getWidth() < 0 || rawX + view.getWidth() > q1.e() || rawY + view.getHeight() > q1.d()) {
                    SimpleLogView.this.Q();
                }
                SimpleLogView.this.j();
            } else if (action == 2) {
                SimpleLogView simpleLogView2 = SimpleLogView.this;
                simpleLogView2.A = true;
                simpleLogView2.C = rawY - simpleLogView2.H;
                SimpleLogView simpleLogView3 = SimpleLogView.this;
                simpleLogView3.D = rawX - simpleLogView3.G;
                SimpleLogView.this.L(r7.D, r7.C);
            }
            return true;
        }
    }

    class d extends GestureDetector.SimpleOnGestureListener {
        d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            SimpleLogView.this.postInvalidate();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    public SimpleLogView() {
        super(v0.g());
        this.f = new Object();
        this.g = new ArrayDeque<>();
        this.f1118h = new Runnable() { // from class: com.yl.float_ui.w
            @Override // java.lang.Runnable
            public final void run() {
                this.c.l();
            }
        };
        this.f1119i = new Runnable() { // from class: com.yl.float_ui.x
            @Override // java.lang.Runnable
            public final void run() {
                this.c.z();
            }
        };
        this.I = new Runnable() { // from class: com.yl.float_ui.a
            @Override // java.lang.Runnable
            public final void run() {
                this.c.k();
            }
        };
        m();
    }

    static /* synthetic */ void B(TextView textView, View view) {
        y0.b().t(true);
        s0.g().d(SimpleLogView.class);
        s0.g().d(DingMsgView.class);
        if (textView.isSelected()) {
            y0.b().r(false);
        }
    }

    static /* synthetic */ void D(View view) {
        s0.g().d(DingMsgView.class);
        r0.z(y0.b().a().getAbsolutePath(), "", false);
        Toast.makeText(v0.g(), "已清理~", 0).show();
    }

    static /* synthetic */ void E(View view) {
        s0.g().d(DingMsgView.class);
        s0.g().d(SimpleLogView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G() {
        this.e.fullScroll(130);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(String str) {
        try {
            this.d.setText(Html.fromHtml(str));
            this.d.post(new Runnable() { // from class: com.yl.float_ui.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.G();
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K(File file) {
        try {
            if (file.exists()) {
                final String strW = r0.w(file.getAbsolutePath());
                l1.e(new Runnable() { // from class: com.yl.float_ui.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.I(strW);
                    }
                });
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public static SimpleLogView P() {
        int i2;
        int i3;
        if (s0.g().m(SimpleLogView.class)) {
            return (SimpleLogView) s0.g().f(SimpleLogView.class);
        }
        int iC = n0.c("log_x", 0);
        int iC2 = n0.c("log_y", 100);
        int iC3 = p1.c(180.0f);
        int iC4 = p1.c(250.0f);
        int iC5 = n0.c("log_w", iC3);
        int iC6 = n0.c("log_h", iC4);
        if ((iC5 >= iC3 / 2 || iC6 >= iC4 / 2) && iC5 < iC3 && iC6 < iC4) {
            i2 = iC5;
            i3 = iC6;
        } else {
            i2 = iC3;
            i3 = iC4;
        }
        return (SimpleLogView) s0.g().y(SimpleLogView.class, iC, iC2, i2, i3);
    }

    private void h() {
        synchronized (this.f) {
            l1.h(this.f1118h);
            this.g.clear();
            this.f1120j = 0;
            this.f1121k = false;
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.removeCallbacks(this.f1119i);
        }
    }

    private View i(final File file) {
        TextView textView = new TextView(v0.g());
        textView.setTextColor(Color.parseColor("#999999"));
        textView.setText("点击导出日志");
        textView.setPadding(p1.c(25.0f), p1.c(10.0f), 0, p1.c(10.0f));
        textView.setTextSize(12.0f);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.yl.float_ui.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleLogView.p(file, view);
            }
        });
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        synchronized (this.f) {
            boolean z = false;
            if (this.t && !this.g.isEmpty()) {
                StringBuilder sb = new StringBuilder(this.f1120j);
                while (!this.g.isEmpty()) {
                    sb.append(this.g.removeFirst());
                }
                this.f1120j = 0;
                try {
                    if (this.d.getText().length() + sb.length() > 104288) {
                        this.d.setText((CharSequence) null);
                    }
                    this.d.append(Html.fromHtml(sb.toString()));
                    this.d.removeCallbacks(this.f1119i);
                    this.d.post(this.f1119i);
                } catch (Exception unused) {
                }
                synchronized (this.f) {
                    this.f1121k = false;
                    if (this.t && !this.g.isEmpty()) {
                        this.f1121k = true;
                        z = true;
                    }
                }
                if (z) {
                    l1.e(this.f1118h);
                    return;
                }
                return;
            }
            this.f1121k = false;
        }
    }

    static /* synthetic */ void p(File file, View view) {
        c1.a(file);
        s0.g().d(DingMsgView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(View view) {
        ((LogSetDialogView) s0.g().B(LogSetDialogView.class)).t(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(View view) {
        r0.z(y0.b().a().getAbsolutePath(), "", false);
        h();
        this.d.setText((CharSequence) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(View view) {
        Q();
    }

    static /* synthetic */ void w(DingMsgView dingMsgView, View view) {
        s0.g().o(dingMsgView);
        c1.a(y0.b().a());
    }

    static /* synthetic */ void x(View view) {
        try {
            final DingMsgView dingMsgView = (DingMsgView) s0.g().x(DingMsgView.class);
            dingMsgView.l("温馨提示");
            dingMsgView.h("是否需要导出日志文件（可保存到下载目录或通过微信/QQ发送）？");
            dingMsgView.k("导出", new View.OnClickListener() { // from class: com.yl.float_ui.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SimpleLogView.w(dingMsgView, view2);
                }
            });
            dingMsgView.i("取消", null);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z() {
        this.e.fullScroll(130);
    }

    protected void L(float f, float f2) {
        s0.g().G(this, (int) f, (int) f2);
    }

    public boolean M() {
        return false;
    }

    public void N(int i2, int i3) {
        try {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
            int i4 = i2 - layoutParams.x;
            int i5 = i3 - layoutParams.y;
            int iC = p1.c(50.0f);
            int iC2 = p1.c(50.0f);
            s0.g().H(this, layoutParams.x, layoutParams.y, i4 < iC ? iC : i4, i5 < iC2 ? iC2 : i5);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void O(Point point) {
        n0.i("log_x", point.x);
        n0.i("log_y", point.y);
    }

    public void Q() {
        try {
            final TextView textView = new TextView(v0.g());
            textView.setTextColor(Color.parseColor("#999999"));
            textView.setText("完全关闭，不在后台记录日志");
            textView.setPadding(p1.c(25.0f), p1.c(8.0f), 0, p1.c(10.0f));
            textView.setTextSize(12.0f);
            textView.setCompoundDrawablePadding(p1.c(5.0f));
            textView.setCompoundDrawablesWithIntrinsicBounds(i0.a, 0, 0, 0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.yl.float_ui.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    textView.setSelected(!r0.isSelected());
                }
            });
            DingMsgView dingMsgView = (DingMsgView) s0.g().x(DingMsgView.class);
            dingMsgView.l("温馨提示");
            dingMsgView.h("拖动到屏幕边缘，是否关闭日志显示，关闭显示后还会在后台记录日志，方便下次查看，也可勾选下面的<strong><font color='#F45075'>[完全关闭]</font></strong>来关闭后台记录功能。");
            dingMsgView.m(textView);
            dingMsgView.k("确定", new View.OnClickListener() { // from class: com.yl.float_ui.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SimpleLogView.B(textView, view);
                }
            });
            dingMsgView.i("取消", new View.OnClickListener() { // from class: com.yl.float_ui.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s0.g().d(DingMsgView.class);
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public SimpleLogView R(final File file) {
        y0.b().t(false);
        if (file.length() <= 1048576) {
            this.d.setText("加载中...");
            l1.g(new Runnable() { // from class: com.yl.float_ui.b0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.K(file);
                }
            });
            return this;
        }
        DingMsgView dingMsgView = (DingMsgView) s0.g().x(DingMsgView.class);
        dingMsgView.h(String.format("日志文件过大（已大于%dM）是否先清理！", Long.valueOf(file.length() / 1048576)));
        dingMsgView.k("清理", new View.OnClickListener() { // from class: com.yl.float_ui.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleLogView.D(view);
            }
        });
        dingMsgView.m(i(file));
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.yl.float_ui.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleLogView.E(view);
            }
        });
        dingMsgView.l("温馨提示");
        return this;
    }

    public void g(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        boolean z = false;
        synchronized (this.f) {
            if (this.t) {
                if (str.length() > 104288) {
                    str = "<br/><font color='#EB5E00'>单条实时日志过长，已省略，完整内容请查看日志文件</font>";
                }
                this.g.addLast(str);
                this.f1120j += str.length();
                while (this.f1120j > 104288 && this.g.size() > 1) {
                    this.f1120j -= this.g.removeFirst().length();
                }
                if (!this.f1121k) {
                    this.f1121k = true;
                    z = true;
                }
                if (z) {
                    l1.e(this.f1118h);
                }
                if (this.J) {
                    l1.c(342546, new Runnable() { // from class: com.yl.float_ui.a0
                        @Override // java.lang.Runnable
                        public final void run() {
                            s0.g().s(SimpleLogView.class);
                        }
                    }, 300L);
                }
            }
        }
    }

    protected void j() {
        boolean z;
        try {
            boolean z2 = true;
            if (this.D < 0) {
                this.D = 0;
                z = true;
            } else {
                z = false;
            }
            if (this.C < 0) {
                this.C = 0;
                z = true;
            }
            if (this.D + getWidth() > q1.e()) {
                this.D = q1.e() - getWidth();
                z = true;
            }
            if (this.C + getHeight() > q1.d()) {
                this.C = q1.d() - getHeight();
            } else {
                z2 = z;
            }
            if (z2) {
                L(this.D, this.C);
                M();
            } else if (this.C != 0) {
                O(new Point(this.D, this.C));
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void k() {
        int width = getWidth();
        int height = getHeight();
        n0.i("log_w", width);
        n0.i("log_h", height);
    }

    public void m() {
        try {
            this.c = new GestureDetector(v0.g(), new d());
            View.inflate(v0.g(), k0.f, this);
            this.d = (TextView) findViewById(j0.r);
            this.e = (ScrollView) findViewById(j0.q);
            View viewFindViewById = findViewById(j0.g);
            View viewFindViewById2 = findViewById(j0.f);
            this.d.setTextSize(n0.c("lgoTs", 7));
            findViewById(j0.f1123i).setOnClickListener(new View.OnClickListener() { // from class: com.yl.float_ui.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.r(view);
                }
            });
            findViewById(j0.d).setOnClickListener(new View.OnClickListener() { // from class: com.yl.float_ui.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.t(view);
                }
            });
            findViewById(j0.e).setOnClickListener(new View.OnClickListener() { // from class: com.yl.float_ui.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.v(view);
                }
            });
            findViewById(j0.f1122h).setOnClickListener(new View.OnClickListener() { // from class: com.yl.float_ui.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SimpleLogView.x(view);
                }
            });
            viewFindViewById.setOnTouchListener(new b());
            viewFindViewById2.setOnTouchListener(new c());
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.D = n0.c("log_x", 0);
        this.C = n0.c("log_y", 100);
        post(new Runnable() { // from class: com.yl.float_ui.m
            @Override // java.lang.Runnable
            public final void run() {
                this.c.j();
            }
        });
        synchronized (this.f) {
            this.t = true;
        }
        y0.b().s(new y0.a() { // from class: com.yl.float_ui.b
            @Override // com.frame.y0.a
            public final void a(String str) {
                this.a.g(str);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y0.b().s(null);
        synchronized (this.f) {
            this.t = false;
        }
        h();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.c.onTouchEvent(motionEvent);
        return true;
    }

    public void setTop(boolean z) {
        this.J = z;
    }
}
