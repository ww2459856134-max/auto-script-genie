package org.opencv.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;

/* loaded from: classes2.dex */
public class CameraGLSurfaceView extends GLSurfaceView {
    private a c;
    private r d;

    public interface a {
        void a(int i2, int i3);

        void b();

        boolean c(int i2, int i3, int i4, int i5);
    }

    public CameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, n.c.a.a);
        int i2 = typedArrayObtainStyledAttributes.getInt(n.c.a.b, -1);
        typedArrayObtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            this.d = new q(this);
        } else {
            this.d = new s(this);
        }
        setCameraIndex(i2);
        setEGLContextClientVersion(2);
        setRenderer(this.d);
        setRenderMode(0);
    }

    public a getCameraTextureListener() {
        return this.c;
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        Log.i("CameraGLSurfaceView", "onPause");
        this.d.o();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Log.i("CameraGLSurfaceView", "onResume");
        super.onResume();
        this.d.p();
    }

    public void setCameraIndex(int i2) {
        this.d.r(i2);
    }

    public void setCameraTextureListener(a aVar) {
        this.c = aVar;
    }

    public void setMaxCameraPreviewSize(int i2, int i3) {
        this.d.t(i2, i3);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        super.surfaceChanged(surfaceHolder, i2, i3, i4);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.d.y = false;
        super.surfaceDestroyed(surfaceHolder);
    }
}
