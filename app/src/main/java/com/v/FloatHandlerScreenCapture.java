package com.v;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.yl.float_ui.CanDragFloatView;

/* loaded from: classes.dex */
public class FloatHandlerScreenCapture extends CanDragFloatView implements View.OnClickListener {
    private lt c;
    private Rect d;

    public FloatHandlerScreenCapture() {
        super(com.frame.v0.g());
        setMagnet(false);
        View.inflate(com.frame.v0.g(), j.b.f.t0, this);
        View viewFindViewById = findViewById(j.b.e.e0);
        viewFindViewById.setOnClickListener(this);
        viewFindViewById.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById2 = findViewById(j.b.e.g0);
        viewFindViewById2.setOnClickListener(this);
        viewFindViewById2.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById3 = findViewById(j.b.e.c1);
        viewFindViewById3.setOnClickListener(this);
        viewFindViewById3.setOnTouchListener(this.mSubTouchListener);
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public Point loadXY() {
        return new Point(com.frame.n0.c("fhi_x", (com.frame.q1.e() / 2) - com.frame.p1.c(100.0f)), com.frame.n0.c("fhi_y", (com.frame.q1.d() * 2) / 3));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.c1) {
            com.frame.s0.g().d(RectChooseView.class);
            com.frame.s0.g().d(FloatHandlerScreenCapture.class);
            com.frame.s0.g().u(FloatHandlerRecord.class);
            if (this.c != null) {
                this.c.a(i.b.v8.m().b0(2, this.d, null));
                return;
            }
            return;
        }
        if (id == j.b.e.e0) {
            com.frame.s0.g().d(RectChooseView.class);
            com.frame.s0.g().d(FloatHandlerScreenCapture.class);
            com.frame.s0.g().u(FloatHandlerRecord.class);
            lt ltVar = this.c;
            if (ltVar != null) {
                ltVar.a(null);
            }
        }
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public void saveXY(Point point) {
        com.frame.n0.i("fhi_x", point.x);
        com.frame.n0.i("fhi_y", point.y);
    }

    public void setImageRect(Rect rect) {
        this.d = rect;
    }
}
