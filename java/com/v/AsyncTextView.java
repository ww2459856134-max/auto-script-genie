package com.v;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* loaded from: classes.dex */
public class AsyncTextView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder c;

    public AsyncTextView(Context context) {
        super(context);
        new Paint();
        new Rect();
    }

    public void a() {
        SurfaceHolder holder = getHolder();
        this.c = holder;
        holder.addCallback(this);
        this.c.setFormat(-3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public AsyncTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new Paint();
        new Rect();
        a();
    }

    public AsyncTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new Paint();
        new Rect();
        a();
    }
}
