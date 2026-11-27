package com.v;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import com.yl.float_ui.DingMsgView;

/* loaded from: classes.dex */
public class FloatTopControllerView extends LinearLayout {
    Rect c;
    Rect d;
    private View e;
    private View f;
    private View g;

    public FloatTopControllerView() {
        super(com.frame.v0.g());
        this.c = new Rect();
        this.d = new Rect();
        View.inflate(com.frame.v0.g(), j.b.f.v0, this);
        this.e = findViewById(j.b.e.h0);
        this.f = findViewById(j.b.e.k0);
    }

    public static void c() {
        com.frame.s0.g().d(FloatTopControllerView.class);
    }

    static /* synthetic */ void d(View view) {
        com.frame.s0.g().d(FloatHandler.class);
        com.frame.s0.g().d(DingMsgView.class);
    }

    static /* synthetic */ void e(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        FloatHandler floatHandler = (FloatHandler) com.frame.s0.g().f(FloatHandler.class);
        if (floatHandler != null) {
            floatHandler.findViewById(j.b.e.r0).setVisibility(0);
            floatHandler.findViewById(j.b.e.x4).setVisibility(8);
            floatHandler.setMagnet(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        this.e.getLocationOnScreen(iArr);
        this.f.getLocationOnScreen(iArr2);
        this.e.getLocalVisibleRect(this.c);
        this.f.getLocalVisibleRect(this.d);
        this.c.offset(iArr[0], iArr[1]);
        this.d.offset(iArr2[0], iArr2[1]);
    }

    public static FloatTopControllerView h() {
        return com.frame.s0.g().f(FloatTopControllerView.class) == null ? (FloatTopControllerView) com.frame.s0.g().y(FloatTopControllerView.class, 0, 0, -1, -2) : (FloatTopControllerView) com.frame.s0.g().f(FloatTopControllerView.class);
    }

    public void a(int i2, int i3) {
        if (this.c.contains(i2, i3)) {
            this.e.setScaleX(0.5f);
            this.e.setScaleY(0.5f);
            this.g = this.e;
        } else if (this.d.contains(i2, i3)) {
            this.f.setScaleX(0.5f);
            this.f.setScaleY(0.5f);
            this.g = this.f;
        } else {
            this.f.setScaleX(1.0f);
            this.f.setScaleY(1.0f);
            this.e.setScaleX(1.0f);
            this.e.setScaleY(1.0f);
            this.g = null;
        }
    }

    public void b() {
        View view = this.g;
        if (view == this.e) {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.h("是要最小化还是关闭呢？关闭操作面板后，如果想要再次开启面板，需要进入应用开启服务。");
            dingMsgView.i("关闭", new View.OnClickListener() { // from class: com.v.x7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FloatTopControllerView.d(view2);
                }
            });
            dingMsgView.k("最小化", new View.OnClickListener() { // from class: com.v.y7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FloatTopControllerView.e(view2);
                }
            });
            dingMsgView.l("温馨提示");
        } else if (view == this.f) {
            FloatToast.i("编辑");
        }
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() { // from class: com.v.z7
            @Override // java.lang.Runnable
            public final void run() {
                this.c.g();
            }
        });
    }
}
