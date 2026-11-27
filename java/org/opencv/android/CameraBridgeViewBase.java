package org.opencv.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.List;
import org.opencv.core.Mat;

/* loaded from: classes2.dex */
public abstract class CameraBridgeViewBase extends SurfaceView implements SurfaceHolder.Callback {
    protected int A;
    protected int C;
    protected boolean D;
    protected t G;
    private int c;
    private Bitmap d;
    private c e;
    private boolean f;
    private final Object g;

    /* renamed from: h, reason: collision with root package name */
    protected int f2573h;

    /* renamed from: i, reason: collision with root package name */
    protected int f2574i;

    /* renamed from: j, reason: collision with root package name */
    protected int f2575j;

    /* renamed from: k, reason: collision with root package name */
    protected int f2576k;
    protected float t;

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            ((Activity) CameraBridgeViewBase.this.getContext()).finish();
        }
    }

    public interface b {
        Mat a();

        Mat b();
    }

    public interface c {
        void a(int i2, int i3);

        void b();

        Mat c(b bVar);
    }

    public interface d {
        void a(int i2, int i3);

        void b();

        Mat c(Mat mat);
    }

    protected class e implements c {
        private int a = 1;
        private d b;

        public e(CameraBridgeViewBase cameraBridgeViewBase, d dVar) {
            this.b = dVar;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.c
        public void a(int i2, int i3) {
            this.b.a(i2, i3);
        }

        @Override // org.opencv.android.CameraBridgeViewBase.c
        public void b() {
            this.b.b();
        }

        @Override // org.opencv.android.CameraBridgeViewBase.c
        public Mat c(b bVar) {
            int i2 = this.a;
            if (i2 == 1) {
                return this.b.c(bVar.b());
            }
            if (i2 == 2) {
                return this.b.c(bVar.a());
            }
            Log.e("CameraBridge", "Invalid frame format! Only RGBA and Gray Scale are supported!");
            return null;
        }

        public void d(int i2) {
            this.a = i2;
        }
    }

    public interface f {
        int a(Object obj);

        int b(Object obj);
    }

    public CameraBridgeViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.g = new Object();
        this.t = 0.0f;
        this.A = 1;
        this.C = -1;
        this.G = null;
        Log.d("CameraBridge", "Attr count: " + Integer.valueOf(attributeSet.getAttributeCount()));
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, n.c.a.a);
        if (typedArrayObtainStyledAttributes.getBoolean(n.c.a.c, false)) {
            g();
        }
        this.C = typedArrayObtainStyledAttributes.getInt(n.c.a.b, -1);
        getHolder().addCallback(this);
        this.f2576k = -1;
        this.f2575j = -1;
        typedArrayObtainStyledAttributes.recycle();
    }

    private void c() {
        Log.d("CameraBridge", "call checkCurrentState");
        int i2 = (this.D && this.f && getVisibility() == 0) ? 1 : 0;
        int i3 = this.c;
        if (i2 != i3) {
            m(i3);
            this.c = i2;
            l(i2);
        }
    }

    private void h() {
        Log.d("CameraBridge", "call onEnterStartedState");
        if (d(getWidth(), getHeight())) {
            return;
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setMessage("It seems that you device does not support camera (or it is locked). Application will be closed.");
        alertDialogCreate.setButton(-3, "OK", new a());
        alertDialogCreate.show();
    }

    private void i() {
    }

    private void j() {
        f();
        Bitmap bitmap = this.d;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    private void k() {
    }

    private void l(int i2) {
        Log.d("CameraBridge", "call processEnterState: " + i2);
        if (i2 == 0) {
            i();
            c cVar = this.e;
            if (cVar != null) {
                cVar.b();
                return;
            }
            return;
        }
        if (i2 != 1) {
            return;
        }
        h();
        c cVar2 = this.e;
        if (cVar2 != null) {
            cVar2.a(this.f2573h, this.f2574i);
        }
    }

    private void m(int i2) {
        Log.d("CameraBridge", "call processExitState: " + i2);
        if (i2 == 0) {
            k();
        } else {
            if (i2 != 1) {
                return;
            }
            j();
        }
    }

    protected void a() {
        this.d = Bitmap.createBitmap(this.f2573h, this.f2574i, Bitmap.Config.ARGB_8888);
    }

    protected org.opencv.core.d b(List<?> list, f fVar, int i2, int i3) {
        int i4 = this.f2576k;
        if (i4 != -1 && i4 < i2) {
            i2 = i4;
        }
        int i5 = this.f2575j;
        if (i5 != -1 && i5 < i3) {
            i3 = i5;
        }
        int i6 = 0;
        int i7 = 0;
        for (Object obj : list) {
            int iB = fVar.b(obj);
            int iA = fVar.a(obj);
            if (iB <= i2 && iA <= i3 && iB >= i6 && iA >= i7) {
                i7 = iA;
                i6 = iB;
            }
        }
        return new org.opencv.core.d(i6, i7);
    }

    protected abstract boolean d(int i2, int i3);

    protected void e(b bVar) {
        Canvas canvasLockCanvas;
        c cVar = this.e;
        Mat matC = cVar != null ? cVar.c(bVar) : bVar.b();
        boolean z = true;
        if (matC != null) {
            try {
                Utils.c(matC, this.d);
            } catch (Exception e2) {
                Log.e("CameraBridge", "Mat type: " + matC);
                Log.e("CameraBridge", "Bitmap type: " + this.d.getWidth() + "*" + this.d.getHeight());
                StringBuilder sb = new StringBuilder();
                sb.append("Utils.matToBitmap() throws an exception: ");
                sb.append(e2.getMessage());
                Log.e("CameraBridge", sb.toString());
                z = false;
            }
        }
        if (!z || this.d == null || (canvasLockCanvas = getHolder().lockCanvas()) == null) {
            return;
        }
        canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        if (this.t != 0.0f) {
            canvasLockCanvas.drawBitmap(this.d, new Rect(0, 0, this.d.getWidth(), this.d.getHeight()), new Rect((int) ((canvasLockCanvas.getWidth() - (this.t * this.d.getWidth())) / 2.0f), (int) ((canvasLockCanvas.getHeight() - (this.t * this.d.getHeight())) / 2.0f), (int) (((canvasLockCanvas.getWidth() - (this.t * this.d.getWidth())) / 2.0f) + (this.t * this.d.getWidth())), (int) (((canvasLockCanvas.getHeight() - (this.t * this.d.getHeight())) / 2.0f) + (this.t * this.d.getHeight()))), (Paint) null);
        } else {
            canvasLockCanvas.drawBitmap(this.d, new Rect(0, 0, this.d.getWidth(), this.d.getHeight()), new Rect((canvasLockCanvas.getWidth() - this.d.getWidth()) / 2, (canvasLockCanvas.getHeight() - this.d.getHeight()) / 2, ((canvasLockCanvas.getWidth() - this.d.getWidth()) / 2) + this.d.getWidth(), ((canvasLockCanvas.getHeight() - this.d.getHeight()) / 2) + this.d.getHeight()), (Paint) null);
        }
        t tVar = this.G;
        if (tVar != null) {
            tVar.c();
            this.G.a(canvasLockCanvas, 20.0f, 30.0f);
        }
        getHolder().unlockCanvasAndPost(canvasLockCanvas);
    }

    protected abstract void f();

    public void g() {
        if (this.G == null) {
            t tVar = new t();
            this.G = tVar;
            tVar.d(this.f2573h, this.f2574i);
        }
    }

    public void setCameraIndex(int i2) {
        this.C = i2;
    }

    public void setCvCameraViewListener(c cVar) {
        this.e = cVar;
    }

    public void setMaxFrameSize(int i2, int i3) {
        this.f2576k = i2;
        this.f2575j = i3;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Log.d("CameraBridge", "call surfaceChanged event");
        synchronized (this.g) {
            if (this.f) {
                this.f = false;
                c();
                this.f = true;
                c();
            } else {
                this.f = true;
                c();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this.g) {
            this.f = false;
            c();
        }
    }

    public void setCvCameraViewListener(d dVar) {
        e eVar = new e(this, dVar);
        eVar.d(this.A);
        this.e = eVar;
    }
}
