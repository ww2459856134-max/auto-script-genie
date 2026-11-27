package com.tencent.open.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class a extends RelativeLayout {
    private static final String a = a.class.getName();
    private Rect b;
    private boolean c;
    private InterfaceC0010a d;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0010a {
        void a();

        void a(int i2);
    }

    public a(Context context) {
        super(context);
        this.b = null;
        this.c = false;
        this.d = null;
        this.b = new Rect();
    }

    public void a(InterfaceC0010a interfaceC0010a) {
        this.d = interfaceC0010a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.b.top) - size;
        InterfaceC0010a interfaceC0010a = this.d;
        if (interfaceC0010a != null && size != 0) {
            if (height > 100) {
                interfaceC0010a.a((Math.abs(this.b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0010a.a();
            }
        }
        super.onMeasure(i2, i3);
    }
}
