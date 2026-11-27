package com.v;

import android.graphics.Point;
import android.view.View;
import android.widget.Toast;
import com.permission.ClickView;
import com.s.BoxService;
import com.yl.float_ui.CanDragFloatView;
import com.yl.model.Node;
import com.yl.model.Task;

/* loaded from: classes.dex */
public class FloatHandlerContinue extends CanDragFloatView implements View.OnClickListener {
    private Task c;
    private Node d;
    private boolean e;

    public FloatHandlerContinue() {
        super(com.frame.v0.g());
        View.inflate(com.frame.v0.g(), j.b.f.q0, this);
        View viewFindViewById = findViewById(j.b.e.y4);
        viewFindViewById.setOnClickListener(this);
        viewFindViewById.setOnTouchListener(this.mSubTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k() {
        this.e = false;
    }

    public static FloatHandlerContinue m() {
        return (FloatHandlerContinue) com.frame.s0.g().y(FloatHandlerContinue.class, com.frame.n0.c("fhr_x", 0), com.frame.n0.c("fhr_y", 100), -2, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (com.frame.w0.d() && BoxService.m() != null) {
            BoxService.m().x();
        }
        ClickView.p();
        com.frame.s0.g().i(FlowView.class);
        i.b.v8.m().k0(this.c);
        i.b.v8.m().j0(this.d);
        com.frame.s0.g().o(this);
        com.frame.l1.f(y3.c, 100L);
    }

    public FloatHandlerContinue l(Task task, Node node) {
        this.c = task;
        this.d = node;
        return this;
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public Point loadXY() {
        return new Point(com.frame.n0.c("fhr_x", 0), com.frame.n0.c("fhr_y", 100));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.b.e.y4) {
            if (this.c == null) {
                Toast.makeText(com.frame.v0.g(), "未找到录制任务，请重新打开脚本", 0).show();
                return;
            }
            if (i.b.da.B().O()) {
                if (this.e) {
                    return;
                }
                this.e = true;
                i.b.y7.d("继续录制脚本", new Runnable() { // from class: com.v.s6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.n();
                    }
                }, new Runnable() { // from class: com.v.t6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.k();
                    }
                });
                return;
            }
            if (com.frame.w0.d() && BoxService.m() != null) {
                n();
                return;
            }
            if (!com.permission.u0.g().h()) {
                com.permission.u0.g().d("accessibility");
            }
            com.permission.x0.m().a();
        }
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public void saveXY(Point point) {
        com.frame.n0.i("fhr_x", point.x);
        com.frame.n0.i("fhr_y", point.y);
    }
}
